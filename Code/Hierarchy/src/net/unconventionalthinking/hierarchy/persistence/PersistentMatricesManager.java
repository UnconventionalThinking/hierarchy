/* Copyright 2012, 2013 Unconventional Thinking
 *
 * This file is part of Hierarchy.
 *
 * Hierarchy is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License 
 * as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * Hierarchy is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied 
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Hierarchy.  
 * If not, see <http://www.gnu.org/licenses/>.
 */

package net.unconventionalthinking.hierarchy.persistence;

import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.AppControl_Base;
import net.unconventionalthinking.matrix.Matrix;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.utilities.FileUtilities;
import net.unconventionalthinking.hierarchy.Exception_HierarchyCompiler;
import net.unconventionalthinking.hierarchy.HierarchyMetaCompiler;
import net.unconventionalthinking.hierarchy.HierarchyMetaCompilerUtilities_Compiler;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import net.unconventionalthinking.hierarchy.langsymboltable.Exception_FindTypeName;
import net.unconventionalthinking.utilities.Exception_FileUtilities_ProcessingError;
import net.unconventionalthinking.utilities.FilenameFilter_StartsWith;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;
import net.unconventionalthinking.matrix.Descriptor;
import net.unconventionalthinking.matrix.SchemaInfo_FieldSet;
import net.unconventionalthinking.matrix.symbols.Exception_MultiPartSymbolAccess;
import net.unconventionalthinking.matrix.symbols.Exception_MultiPartSymbolCreation;
import net.unconventionalthinking.matrix.symbols.Exception_MultiPartSymbolCreationOrAccess;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.MPSymbols_DescTagName;
import net.unconventionalthinking.matrix.symbols.MatrixName;
import net.unconventionalthinking.matrix.symbols.MatrixName_Utilities;
import net.unconventionalthinking.utilities.FileUtilities_Delete;





/**
 * Multi-Threading Notes - to see general notes on the multi-threading strategy for the MatricesManagers, see the doc,
 * "Persistent-Matrices Manager, Threading-Strategy.txt"
 *
 * @author peterjoh
 */
public abstract class PersistentMatricesManager {


    public enum PersistenceEventType {
        Client_Event,
        Client_Event_ShutDownCompleted,
        Client_Error,

        ClientChunkMonitor_Event,
        ClientChunkMonitor_Event_SentChunkFileToServer,
        ClientChunkMonitor_Error,


        Server_Event,
        Server_Event_ProcessedChunk,
        Server_Event_StartingShutDown,
        Server_Event_ShutDownRequestCompleted,
        Server_Event_ShutDownCompleted,
        Server_Event_PersistenceMatrixGeneration_Started,
        Server_Event_PersistenceMatrixGeneration_Finished,
        Server_Error,

        ServerChunkMonitor_Event,
        ServerChunkMonitor_Error,

        ChunkMonitor_Shutdown
    }

    /** The run state of the the Persistent-Matrices Manager */
    public enum RunState {
        Starting, Running, ShuttingDown,
        /** Note that shutdown is not really the shutdown state, it's the "Shutdown-Request Completed" state, meaning that the shutdown request
         *  has successfully been made. The inbox monitor thread may still be running and may be in the process of being terminated. */
        Shutdown
    }


    
    //  Hierarchy Meta-Compiler vars __________________________________________________________

    HierarchySettings       hierarchySettings;
    HierarchyMetaCompiler   hierarchyMetaCompiler;

    AppControl_Base         appControl;
    ExecutionInfo           executeInfo;

    
    //  Path & FileName vars __________________________________________________________
    String                              persistenceServer_LogFileChunk_InboxDir;
    //  Why are the logFileChunk_BaseName and filter private? because inherited classes should not set these directly
    //  which is because the chunkFileNameFilter is created when the logFileChunkBaseName is set
    private String                      logFileChunk_BaseName;
    private FilenameFilter_StartsWith   chunkFileNameFilter;

    ConcurrentMap<MatrixName, Matrix>   persistentMatrix_Map;

    //  Chunk Monitor vars __________________________________________________________
    //  Both the Client and the Server have a chunkMonitors
    final ScheduledThreadPoolExecutor               inboxMonitor_ExecService;
    PersistentMatrix_ChunkMonitor_TaskWrapper       chunkMonitor_ChunkProcessorTaskWrapper;
    volatile int                                    chunkCheck_Interval__Initial_ms;
    volatile int                                    chunkCheck_Interval__ms;
    final int                                       shutdownWaitTime_sec;

    //  Event vars __________________________________________________________________
    final Map<PersistenceEventType, List<PersistentMatricesManager_EventListener>> persistenceEventListenersIndex_byEventType;

    //  Misc vars __________________________________________________________________
    private boolean printClassPath = false;

    final Object            lifeCycle_Lock;
    /** runstate may only be set if you first obtain the lifecycle lock!! */
    final AtomicInteger     lifeCycle_RunState;

    final Object            chunkFiles_Lock;
    final Object            controlSets_Lock;
    final Object            metaCode_Lock;


    //  ______________________________________________________________________________________________________________________
    //
    //  Constructors & Setup related Methods
    //  ______________________________________________________________________________________________________________________

    public PersistentMatricesManager(int default__chunkCheck_Interval__Initial_ms, int default__chunkCheck_Interval_ms, int shutdownWaitTime_sec) {
        this.chunkCheck_Interval__Initial_ms = default__chunkCheck_Interval__Initial_ms;
        this.chunkCheck_Interval__ms = default__chunkCheck_Interval_ms;
        this.shutdownWaitTime_sec = shutdownWaitTime_sec;
        
        setLogFileChunk_BaseName(PersistentMatricesManagerConstants.CHUNK_DEFAULT_LOGFILECHUNK_BASENAME);


        persistenceEventListenersIndex_byEventType = new EnumMap(PersistenceEventType.class);
        //  Fill the map with the list objects
        for (PersistenceEventType eventType : PersistenceEventType.values()) {
            //  Use a CopyOnWriteArrayList to make this list threadsafe.
            List<PersistentMatricesManager_EventListener> persistenceEventListeners_List
                    = new CopyOnWriteArrayList<PersistentMatricesManager_EventListener>();
            persistenceEventListenersIndex_byEventType.put(eventType, persistenceEventListeners_List);
        }

        hierarchyMetaCompiler = new HierarchyMetaCompiler();
        hierarchySettings = hierarchyMetaCompiler.get_HierarchySettings();

        persistentMatrix_Map = new ConcurrentHashMap<MatrixName, Matrix>();

        lifeCycle_RunState = new AtomicInteger(RunState.Shutdown.ordinal());
    	lifeCycle_Lock = new Object();
    	chunkFiles_Lock = new Object();
    	controlSets_Lock = new Object();
    	metaCode_Lock = new Object();

        inboxMonitor_ExecService = new ScheduledThreadPoolExecutor(1);
        inboxMonitor_ExecService.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
        inboxMonitor_ExecService.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);

    }



    
    //  ______________________________________________________________________________________________________________________
    //
    //  Set Settings Methods
    //  ______________________________________________________________________________________________________________________


    //  Hierarchy Meta-Compiler set methods ___________________________________________________________________________________

    /** The directory where the hierarchy jar file is located. */
    public void setMetaCompiler__HierarchyJar_Dir(String hierarchyJar_Dir) throws MalformedURLException { hierarchyMetaCompiler.set_HierarchyJar_Dir(hierarchyJar_Dir); }
    /** The directory where the javac compiler executable is located. */
    public void setMetaCompiler__javac_Dir(String javac_Dir) { hierarchyMetaCompiler.set_javac_Dir(javac_Dir); }


    /** The base directory where the source files to metacompile are located. */
    public void setMetaCompiler__SrcMetaCode_BaseDir(String srcBaseDir) throws IOException { hierarchyMetaCompiler.set_SrcMetaCode_BaseDir(srcBaseDir); }
    /**  The name of the package for all the Matrix application classes (such as AppControl, AppSymbols, AppSymbols_DescTag...). */
    public void setMetaCompiler__AppClasses_PackageName(String packageName) throws IOException { hierarchyMetaCompiler.set_AppClasses_PackageName(packageName); }
    
    /**  The base directory where the metacompiled java files are placed. */
    public void setMetaCompiler__BuildMeta_BaseDir(String baseBuildMetaDir) throws IOException { hierarchyMetaCompiler.set_BuildMeta_BaseDir(baseBuildMetaDir); }
    /**  The base directory where the final (and intermediate) classes files are placed. */
    public void setMetaCompiler__BuildFinal_BaseDir(String baseFinalBuildDir) throws IOException { hierarchyMetaCompiler.set_BuildFinal_BaseDir(baseFinalBuildDir); }



    /**
     * The path to the persistenceServer's LogFileChunk Inbox Directory must be set to a value.
     */
    public void setPersistenceServer_LogFileChunk_InboxDir(String persistenceServer_LogFileChunk_InboxDir) {
        this.persistenceServer_LogFileChunk_InboxDir = persistenceServer_LogFileChunk_InboxDir;
    }
    public void setLogFileChunk_BaseName(String logFileChunk_BaseName) {
        this.logFileChunk_BaseName = logFileChunk_BaseName;
        chunkFileNameFilter = new FilenameFilter_StartsWith(logFileChunk_BaseName);
    }

    /**  This is to set the first, chunk-check interval. This is especially useful for unit tests, where the timing of everything is important. */
    public void setChunkCheck_Interval__Initial_ms(int chunkCheck_Interval__Initial_ms) {
        this.chunkCheck_Interval__Initial_ms = chunkCheck_Interval__Initial_ms;
    }
    public void setChunkCheck_Interval_ms(int chunkCheck_Interval_ms) { this.chunkCheck_Interval__ms = chunkCheck_Interval_ms; }




    public abstract void setRmiRegistery_HostName(String rmiRegistery_HostName);
    public abstract void setRmiRegistery_Port(int rmiRegistery_Port);

    /** For debugging: print the class path of the MatrixManager */
    public void setPrintClassPath(boolean printClassPath) { this.printClassPath = printClassPath; }



    //  ______________________________________________________________________________________________________________________
    //
    //  Get Methods (Settings-Related)
    //  ______________________________________________________________________________________________________________________


    public String getPersistenceServer_LogFileChunk_InboxDir() { return persistenceServer_LogFileChunk_InboxDir; }
    public String getLogFileChunk_BaseName() { return logFileChunk_BaseName;}
    public FilenameFilter_StartsWith getChunkFileNameFilter() { return chunkFileNameFilter; }

    public int getChunkCheck_Interval__Initial_ms() { return chunkCheck_Interval__Initial_ms; }
    public int getChunkCheck_Interval_ms() { return chunkCheck_Interval__ms; }

    
    /**  The directory where the hierarchy jar file is located. */
    public String getMetaCompiler__HierarchyJar_Dir() { return hierarchyMetaCompiler.get_HierarchyJar_Dir(); }
    /**  The directory where the javac compiler executable is located. */
    public String getMetaCompiler__javac_Dir() { return hierarchyMetaCompiler.get_javac_Dir(); }

    public String getMetaCompiler__SrcMetaCode_BaseDir() { return hierarchyMetaCompiler.get_SrcMetaCode_BaseDirPath();}
    /**  The base directory where the metacompiled java files are placed. */
    public String getMetaCompiler__BuildMeta_BaseDir() { return hierarchyMetaCompiler.get_BuildMeta_BaseDir(); }
    /**  The name of the package for all the Matrix application classes (such as AppControl, AppSymbols, AppSymbols_DescTag...). */
    public String getMetaCompiler__AppClasses_PackageName() { return hierarchyMetaCompiler.get_AppClasses_PackageName(); }
    /**  The base directory where the final (and intermediate) classes files are placed. */
    public String getMetaCompiler__BuildFinal_BaseDir() { return hierarchyMetaCompiler.get_BuildFinal_BaseDir(); }


    /**
     * child class methods should override this method, and then also call this method in their implementations through super.
     */
    public void printSettings() {
        
        System.out.println("  o persistenceServer_LogFileChunk_InboxDir [" + persistenceServer_LogFileChunk_InboxDir + "]");
        System.out.println("  o logFileChunk_BaseName [" + logFileChunk_BaseName + "]");
        System.out.println("  o chunkFileNameFilter [" + chunkFileNameFilter + "]");
        System.out.println("  o chunkCheck_Interval__Initial_ms [" + chunkCheck_Interval__Initial_ms + "]");
        System.out.println("  o chunkCheck_Interval__ms [" + chunkCheck_Interval__ms + "]");
        System.out.println("  o metaCompiler__HierarchyJar_Dir [" + getMetaCompiler__HierarchyJar_Dir() + "]");
        System.out.println("  o metaCompiler__SrcMetaCode_BaseDir [" + getMetaCompiler__SrcMetaCode_BaseDir() + "]");
        System.out.println("  o metaCompiler__BuildMeta_BaseDir [" + getMetaCompiler__BuildMeta_BaseDir() + "]");
        System.out.println("  o metaCompiler__AppClasses_PackageName [" + getMetaCompiler__AppClasses_PackageName() + "]");
        System.out.println("  o metaCompiler__BuildFinal_BaseDir [" + getMetaCompiler__BuildFinal_BaseDir() + "]");

    }


    //  ______________________________________________________________________________________________________________________
    //
    //  Get Methods (runtime related)
    //  ______________________________________________________________________________________________________________________

    /**
     * NOTE: the performance of this method is not as good (not bad, but not high performance). Because needs to build the matrix name from
     * strings.
     */
    public Matrix findPersistentMatrix(String packageName, String matrixName) 
        throws Exception_InvalidArgumentPassed, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreation, 
        Exception_MultiPartSymbolCreationOrAccess{

        MatrixName matrixNameSymbol = MatrixName_Utilities.create_MatrixOrSchemaName_FromStrings(packageName, matrixName, true, false, appControl.symbolControl);
        return persistentMatrix_Map.get(matrixNameSymbol);
    }
    public Matrix findPersistentMatrix(MatrixName matrixName) { return persistentMatrix_Map.get(matrixName); }
    public Collection<Matrix> getPersistentMatrices() { return persistentMatrix_Map.values(); }

    public AppControl_Base getAppControl() { return appControl; }
    public HierarchySettings getHierarchySettings() { return hierarchySettings; }

    public int getRunState() {
        return lifeCycle_RunState.get();
    }




    //  ______________________________________________________________________________________________________________________
    //
    //  Server Methods - PersistentMatrix Management methods
    //  ______________________________________________________________________________________________________________________

    public void resetPersistentMatricesManager() {
        synchronized(lifeCycle_Lock) {

            persistentMatrix_Map = new ConcurrentHashMap<MatrixName, Matrix>();
            appControl = null;
            executeInfo = null;
        }
    }


    public void metaCompile_PersistedMatrixCode(boolean isServerNotClient) throws IOException, Exception_PersistenceError, Exception_HierarchyCompiler, Exception_MetaCompilerError,
        Exception_FileUtilities_ProcessingError, Exception_FindTypeName {

        synchronized (metaCode_Lock) {
            System.out.println("\n_________________________________________________________________________________________________________________");
            System.out.println("Metacompiling the " + (isServerNotClient ? "Server's" : "Client's") + " code.");
            System.out.println("  Meta-Src base-dir path [" + hierarchyMetaCompiler.get_SrcMetaCode_BaseDirPath() + "]");
            System.out.println("  Meta-Build dest-dir path [" + hierarchyMetaCompiler.get_BuildMeta_BaseDir() + "]");
            System.out.println("  Final-Build dest-dir path [" + hierarchyMetaCompiler.get_BuildFinal_BaseDir() + "]");
            System.out.println("_________________________________________________________________________________________________________________");


            hierarchyMetaCompiler.clean();
            hierarchyMetaCompiler.phase0_InitiallyCompileJavaCode();
            hierarchyMetaCompiler.phase1_MetacompileSchemaCode();
            hierarchyMetaCompiler.phase2_GenerateFieldSets();
            hierarchyMetaCompiler.phase3_MetacompileMatrices();
            hierarchyMetaCompiler.phase4_CollectTypeInfo();
            hierarchyMetaCompiler.phase5_MetaCompileEmbeddedJavaFiles();

            System.out.println("\n... End of Metacompilation");
            System.out.println("_________________________________________________________________________________________________________________\n\n");
        }
    }




    public void load_PersistentMatrices() {
        System.out.println("Loading Persistent Matices:");
        resetPersistentMatricesManager();

        //  First, load the appControl
        try {
            HierarchyMetaCompilerUtilities_Compiler hierarchy_CompilerUtilities = new HierarchyMetaCompilerUtilities_Compiler(hierarchySettings);

            synchronized (metaCode_Lock) { // don't want to try to load the appclasses in the middle of metacompilation.
                
                appControl = hierarchy_CompilerUtilities.dynReload_AppClasses(hierarchyMetaCompiler.get_BuildFinal_BaseDir(),
                        hierarchyMetaCompiler.get_AppClasses_PackageName(), hierarchyMetaCompiler.get_Classpath_EmbeddedFiles_URLS(), false);
            }
            executeInfo = appControl.getExecutionInfo();

        } catch (Exception e) {
            throw new ExceptRuntime_PersistenceManagerError("Had an unexpected error. While trying to the persistent Matrices, tried to load the " +
                    "appControl class for the persistence app, but could not load it.", e);
        }

        if (printClassPath) {
            //Get the System Classloader
            ClassLoader sysClassLoader = ClassLoader.getSystemClassLoader();
            //Get the URLs
            URL[] urls = ((URLClassLoader)sysClassLoader).getURLs();
            for(int i=0; i< urls.length; i++)
                System.out.println(urls[i].getFile());
        }


        int totalPersistentMatrices = 0;
        //  loop through all matrices, and find the persistent ones.
        for(Matrix matrix : appControl.matrixControl.getMatrices()) {
            Descriptor desc = matrix.get_ChildDescriptor(executeInfo, MPSymbols_DescTagName.MATRIXPROG$__$PERSISTENCE$__$SETTINGS);

            try {
                if (desc != null &&
                    ((SchemaInfo_FieldSet)desc.get_FieldSet().getSchemaInfo()).has_Field(executeInfo, MPSymbols_DescTagName.IsPersistentMatrix) &&
                    desc.get_FieldSet().getField(executeInfo, MPSymbols_DescTagName.IsPersistentMatrix) == MPSymbols.IsPersistent
                   ) {
                    persistentMatrix_Map.put(matrix.matrixName, matrix);
                    System.out.println("   Added matrix [" + matrix.matrixName.get_Name_no_backtiks() +"] to persistentMatrix index");
                    totalPersistentMatrices++;
                }

            } catch (Exception_InvalidArgumentPassed e) {
                throw new ExceptRuntime_PersistenceManagerError("While trying to identify the persistent matrices, had an error trying to access the IsPersistentMatrix field. This should not happen!", e);
            }
        }
        System.out.println("   ... done! There were " + totalPersistentMatrices + " persistent matrices out of " + appControl.matrixControl.getMatrices().size() + " total matrices.");
    }

    
    /**
     * Tells the Manager to stop processing, but if it's currently processing something, let it finish.
     * You need to call awaitTermination() to see if the shutdown of the monitor thread was successful.
     */
    abstract public void shutdown() throws IOException, Exception_PersistenceEventHandler, ExceptRuntime_PersistenceManagerError, InterruptedException;
    /** returns true if successfully terminated. returns false if the wait timeout lapsed instead. */
    public boolean awaitTermination() throws InterruptedException {
        return awaitTermination(shutdownWaitTime_sec, TimeUnit.SECONDS);
    }
    public boolean awaitTermination_Indefinitely() throws InterruptedException {
        return awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
    }
    /** returns true if successfully terminated. returns false if the wait timeout lapsed instead. */
    public boolean awaitTermination(long shutdownWaitTime_sec, TimeUnit timeUnit) throws InterruptedException {
        boolean terminationSuccessful = inboxMonitor_ExecService.awaitTermination(shutdownWaitTime_sec, timeUnit);
        try {
            if (this instanceof PersistentMatricesManager_Client)
                sendPersistenceEvent(PersistenceEventType.Client_Event_ShutDownCompleted);
            else
                sendPersistenceEvent(PersistenceEventType.Server_Event_ShutDownCompleted);
        } catch (Exception_PersistenceEventHandler e) {
            throw new ExceptRuntime_PersistenceManagerError("Sending the shutdown client/server Persitence Event and had an error sending it.", e);
        }
        return terminationSuccessful;
    }

    
    //  ______________________________________________________________________________________________________________________
    //
    //  Persistence Event Related Methods
    //  ______________________________________________________________________________________________________________________

    /**
     * This is Threadsafe.
     */
    public void registerPersistenceEventListener(PersistenceEventType eventType, PersistentMatricesManager_EventListener eventListener) {
        List<PersistentMatricesManager_EventListener> persistenceEventListeners_List = persistenceEventListenersIndex_byEventType.get(eventType);
        persistenceEventListeners_List.add(eventListener);
    }


    /**
     * This is Threadsafe.
     */
    void sendPersistenceEvent(PersistenceEventType eventType, Object... eventParameters) throws Exception_PersistenceEventHandler {

        List<PersistentMatricesManager_EventListener> persistenceEventListeners_List = persistenceEventListenersIndex_byEventType.get(eventType);

        if (persistenceEventListeners_List != null) {
            for (PersistentMatricesManager_EventListener eventListener : persistenceEventListeners_List) {
                eventListener.eventOccurred(this, eventType, eventParameters);
            }
        }
    }



}
