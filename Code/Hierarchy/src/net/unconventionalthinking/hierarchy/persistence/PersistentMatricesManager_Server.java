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

import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null;
import net.unconventionalthinking.lang.Integer_Mutable;
import net.unconventionalthinking.lang.OutputParameter;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.utilities.FileUtilities;
import net.unconventionalthinking.matrix.utilities.TextUtilities;
import net.unconventionalthinking.hierarchy.Exception_HierarchyCompiler;
import net.unconventionalthinking.hierarchy.langsymboltable.Exception_FindTypeName;
import net.unconventionalthinking.hierarchy.persistence.actions.CmdAction;
import net.unconventionalthinking.utilities.Exception_FileUtilities_ProcessingError;
import net.unconventionalthinking.utilities.FilenameFilter_StartsWith;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.unconventionalthinking.matrix.Matrix;
import net.unconventionalthinking.utilities.FileUtilities_Delete;


/**
 * This class is Thread-Safe.
 *
 * Also, the most of the methods support the standard thread cancellation pattern of using the Interrupt flag.
 * 
 * @author peterjoh
 */
public class PersistentMatricesManager_Server extends PersistentMatricesManager {



    private String persistenceControl_RootDir;
    private String persistenceControl_DirBaseName;
    private String persistenceControl_FileBaseName;

    private String client__SrcMetaCode_BaseDir;
    private String client__BuildMeta_BaseDir;
    private String client__BuildFinal_BaseDir;



    private ConcurrentMap<Integer, Object> objectIndex;
    private Command_OrphanedCommands_Manager orphanedCommands_Manager;

    private PersistentMatricesManager_Server_RemoteService  persistServer_RemoteService;



    public PersistentMatricesManager_Server() {
        super(PersistentMatricesManagerConstants.SERVER__CHUNKMONITOR_CHECKFORCHUNKS_DEFAULT_INITIAL_INTERVAL__MS,
              PersistentMatricesManagerConstants.SERVER__CHUNKMONITOR_CHECKFORCHUNKS_DEFAULT_INTERVAL__MS, 60);
        

        objectIndex = new ConcurrentHashMap<Integer, Object>();

        persistenceControl_DirBaseName = PersistentMatricesManagerConstants.SERVER__PERSISTENCECONTROL_DEFAULT_DIRBASENAME;
        persistenceControl_FileBaseName = PersistentMatricesManagerConstants.SERVER__PERSISTENCECONTROL_DEFAULT_FILEBASENAME;
        persistenceControl_RootDir = null;


        ChunkMonitor_ChunkProcessor server_ChunkMonitorProcessor =  new ChunkMonitor_ChunkProcessor() {
            public void process() throws IOException, Exception_PersistenceEventHandler, Exception_PersistenceError {
                checkForAndProcessChunks();
            }
        };

        chunkMonitor_ChunkProcessorTaskWrapper = new PersistentMatrix_ChunkMonitor_TaskWrapper(server_ChunkMonitorProcessor, this);

        persistServer_RemoteService = new PersistentMatricesManager_Server_RemoteService(this);
    }





    //  ______________________________________________________________________________________________________________________
    //
    //  Set Settings Methods
    //  ______________________________________________________________________________________________________________________


    
    /** The baseName of the control directories (has default) */
    public void setPersistenceControl_DirBaseName(String persistenceControl_DirBaseName) { this.persistenceControl_DirBaseName = persistenceControl_DirBaseName; }
    /**  The persistenceControl file base name (has default) */
    public void setPersistenceControl_FileBaseName(String persistenceControl_FileBaseName) { this.persistenceControl_FileBaseName = persistenceControl_FileBaseName; }
    /** The root directory of the control directories (must set) */
    public void setPersistenceControl_RootDir(String persistenceControl_RootDir) { this.persistenceControl_RootDir = persistenceControl_RootDir;}


    /**  The base directory where the persistent matrix source files for the client are located. */
    public void setClient__SrcMetaCode_BaseDir(String srcDir) throws IOException { this.client__SrcMetaCode_BaseDir = srcDir; }
    /**  The base directory where the client's MetaCompiled java files should be placed. This is often actually in the client proj's src dir.  */
    public void setClient__BuildMeta_BaseDir(String client__BuildMeta_BaseDir) { this.client__BuildMeta_BaseDir = client__BuildMeta_BaseDir;}
    /**  The base directory where the client's final class files should be placed. This is often it's build dir. NOTE: this build dir is what the client will also run off of,
     * loading its persistent matrix from!!! */
    public void setClient__BuildFinal_BaseDir(String client__BuildFinal_BaseDir) { this.client__BuildFinal_BaseDir = client__BuildFinal_BaseDir; }


    @Override
    public void setRmiRegistery_HostName(String rmiRegistery_HostName) { persistServer_RemoteService.setRmiRegistery_HostName(rmiRegistery_HostName); }
    @Override
    public void setRmiRegistery_Port(int rmiRegistery_Port) { persistServer_RemoteService.setRmiRegistery_Port(rmiRegistery_Port); }




    //  ______________________________________________________________________________________________________________________
    //
    //  Get Methods
    //  ______________________________________________________________________________________________________________________

    public Map<Integer, Object> getObjectIndex() { return objectIndex; }
    public String getPersistenceControl_DirBaseName() { return persistenceControl_DirBaseName; }
    public String getPersistenceControl_FileBaseName() { return persistenceControl_FileBaseName; }
    public String getPersistenceControl_RootDir() { return persistenceControl_RootDir;}

    public String getClient__BuildMeta_BaseDir() { return client__BuildMeta_BaseDir; }
    public String getClient__BuildFinal_BaseDir() { return client__BuildFinal_BaseDir;}

    public int getShutdownWaitTime_sec() { return shutdownWaitTime_sec; }

    @Override
    public void printSettings() {
        System.out.println("PersistentMatrices Server-Manager Settings:");
        System.out.println("  o persistenceControl_DirBaseName [" + persistenceControl_DirBaseName + "]");
        System.out.println("  o persistenceControl_FileBaseName [" + persistenceControl_FileBaseName + "]");
        System.out.println("  o persistenceControl_RootDir [" + persistenceControl_RootDir + "]");
        System.out.println("  o client__BuildMeta_BaseDir [" + client__BuildMeta_BaseDir + "]");
        System.out.println("  o client__BuildFinal_BaseDir [" + client__BuildFinal_BaseDir + "]");
        System.out.println("  o shutdownWaitTime_sec [" + shutdownWaitTime_sec + "]");

        super.printSettings();
    }
    
    //  ______________________________________________________________________________________________________________________
    //
    //  Server Methods - Inbox Monitoring & Management methods
    //  ______________________________________________________________________________________________________________________

    @Override
    public void resetPersistentMatricesManager() {
        synchronized(lifeCycle_Lock) {
            super.resetPersistentMatricesManager();

            objectIndex.clear();
        }
    }

    
    public void startServer() throws IOException, Exception_PersistenceError, Exception_MetaCompilerError, Exception_HierarchyCompiler,
            Exception_FileUtilities_ProcessingError, Exception_FindTypeName {

        synchronized(lifeCycle_Lock) {
            if (lifeCycle_RunState.compareAndSet(RunState.Shutdown.ordinal(), RunState.Starting.ordinal())) {
                System.out.println("\nStarting Server...");

                Integer_Mutable numControlSets_includesInvalid = new Integer_Mutable(-1);
                PersistentMatricesManager_Server_ControlFile latestValidControlFile = getLatest_PersistenceControlFile(numControlSets_includesInvalid);

                if (latestValidControlFile == null) {
                    if (numControlSets_includesInvalid.value == 0) {
                        //  This is the first time time the server has started. Get the Persistent Matrix from the client directory
                        copy_ClientPersistedMatrixSrcDir_to_Server();

                    } else {  //  we have some invalid control sets, throw an error
                        throw new Exception_PersistenceError("There are only invalid Control sets in the control directory. Sort that out, then restart the server.");
                    }

                } else {
                    //  There is a valid controlFile. This means this is a restart of an existing persistent matrix. You should just be able to
                    //  reload the existing persistent matrix.
                }

                metaCompile_PersistedMatrixCode(true);
                load_PersistentMatrices();
                //  loadOrphanedCommands();

                System.out.println("\nStarting RMI Service - Registry connection Settings:");
                System.out.println("   host: " + persistServer_RemoteService.getRmiRegistery_HostName() + ", port: " + persistServer_RemoteService.getRmiRegistery_Port());

                try {
                    persistServer_RemoteService.startService();
                } catch (Exception e) {
                    throw new ExceptRuntime_PersistenceManagerError("Tried to start the rmi server, but had an error.", e);
                }

                //  Start monitor thread
                inboxMonitor_ExecService.scheduleAtFixedRate(chunkMonitor_ChunkProcessorTaskWrapper, chunkCheck_Interval__Initial_ms, chunkCheck_Interval__ms,
                        TimeUnit.MILLISECONDS);

                lifeCycle_RunState.set(RunState.Running.ordinal());
                System.out.println("\n\n...Finished Starting Server.\n");

            } else {
                System.out.println("Trying to start the server, but it is not shutdown! The Server is in the '"
                        + lifeCycle_RunState.toString() + "' run state.");
            }
        }
    }

    
    /**
     * Tells the server to stop processing, but if it's currently processing something, let it finish.
     * You need to call awaitTermination to see if the shutdown of the monitor thread was successful.
     */
    public void shutdown() throws Exception_PersistenceEventHandler, ExceptRuntime_PersistenceManagerError, InterruptedException {

        synchronized(lifeCycle_Lock) {
            if (lifeCycle_RunState.compareAndSet(RunState.Running.ordinal(), RunState.ShuttingDown.ordinal())) {
                System.out.println("ShutDown requested:");
                sendPersistenceEvent(PersistenceEventType.Server_Event_StartingShutDown);

                //  Shutting down RMI service so we can't receive requests anymore
                System.out.println("   Trying to stop the Server's RMI service...");
                try {
                    persistServer_RemoteService.stopService();
                    System.out.println("   ...Done!");
                } catch (Exception e) {
                    throw new ExceptRuntime_PersistenceManagerError("Had Error during shutdown! - Error while trying to stop the "
                            + "Rmi Server-Methods Service", e);

                } finally {
                    // now, shutdown the inbox monitor thread
                    System.out.print("   Shutting Down the inbox monitor thread...");
                    inboxMonitor_ExecService.shutdown();
                    System.out.println(" request made (async call).");

                    lifeCycle_RunState.set(RunState.Shutdown.ordinal());
                    sendPersistenceEvent(PersistenceEventType.Server_Event_ShutDownRequestCompleted);
                }
                
            } else {
                System.out.println("Trying to shutdown, but server is not running! The Server is in the '"
                        + lifeCycle_RunState.toString() + "' run state.");
            }
        }
    }


    public void deletePersistentMatrices() throws IOException {
        synchronized(chunkFiles_Lock) {
            synchronized(controlSets_Lock) {
                FileUtilities_Delete.deleteFilesInDir(getPersistenceServer_LogFileChunk_InboxDir());
                FileUtilities_Delete.deltree(persistenceControl_RootDir, true);

            }
        }
    }

    //  ______________________________________________________________________________________________________________________
    //
    //  Server Methods - Chunk Processing methods
    //  ______________________________________________________________________________________________________________________


    public boolean checkForAndProcessChunks() throws IOException, Exception_PersistenceEventHandler, Exception_PersistenceError 
        { return checkForAndProcessChunks(false); }

    /**
     * Multi-Threading Notes:
     * o We want to hold the chunkFiles_Lock for the entire method because we don't want any other thread to remove any chunks while
     * we're processing the chunks ourselves. And, at a higher level, we don't want multiple checkForProcessChunks() calls over
     * lapping.
     *
     * o We hold the controlSets_Lock for the first two-thirds of this method, when we load the latest control file, process the chunks,
     * and then update the controlSets. We want to make sure no one else updates the controlSets in between when we grab the latest one
     * and when we write out a new one.
     */
    public synchronized boolean checkForAndProcessChunks(boolean sendClient_UpdatedPersistedMatrix_MetaSrcAndBuild)
            throws IOException, Exception_PersistenceEventHandler, Exception_PersistenceError  {

        synchronized(chunkFiles_Lock) {
            if (lifeCycle_RunState.get() == RunState.Shutdown.ordinal())
                throw new Exception_PersistenceError("Error: Tried to check for chunks while the server was shutdown.");


            boolean processedChunks = false;

            synchronized(controlSets_Lock) {
                //  check for new chunks to process
                File[] currInboxChunks_FileList = getFromInbox_ChunkFiles();
                TreeMap<Long, File> unprocessedChunks_OrderedMap = null;

                if (currInboxChunks_FileList != null && currInboxChunks_FileList.length > 0) {
                    PersistentMatricesManager_Server_ControlFile controlFile = getLatest_PersistenceControlFile();

                    if (controlFile != null) {
                        unprocessedChunks_OrderedMap = controlFile.determine_UnprocessedChunks(currInboxChunks_FileList);

                    } else {  // there is no control file. These chunks are the first ones. order the list of file names by timestamp

                        unprocessedChunks_OrderedMap = new TreeMap<Long, File>();
                        for (File chunkFile : currInboxChunks_FileList) {
                                long timeStamp = PersistentMatricesManager_Utilities.getTimeStamp_from_FileName(chunkFile.getName(), getLogFileChunk_BaseName());
                                unprocessedChunks_OrderedMap.put(timeStamp, chunkFile);
                        }
                    }

                    if (unprocessedChunks_OrderedMap.size() > 0) {
                        long timeStamp_Shortened = processChunks(unprocessedChunks_OrderedMap);

                        generate_PersistedMatrixCode();
                        /*
                        orphanedCommands_Manager.writeToOrphanedCommandsLog(timeStamp_Shortened);
                            */
                        PersistentMatricesManager_Server_ControlFile newPersistControlFile =
                                switchTo_New_PersistentControlSet(unprocessedChunks_OrderedMap, timeStamp_Shortened);
                        PersistentMatricesManager_Utilities.delete_OldChunksAndControl(newPersistControlFile.chunkTimeStamp_First,
                                newPersistControlFile.control_TimeStamp, this);

                        processedChunks = true;
                    }
                }
                
            } // end of synchronized(controlSets_Lock) block



            if (sendClient_UpdatedPersistedMatrix_MetaSrcAndBuild) {
                try {
                    metaCompile_PersistedMatrixCode(true);
                } catch (Exception e) {
                    throw new Exception_PersistenceError("Tried to metacompile the Persisted Matrix Code, but had an error (see inner exception).", e);
                }
                //  remember, after you re-metacompile, you have to reload the matrix application class files..
                load_PersistentMatrices();

                copy_ServerPersistedMatrix_MetaSrcAndBuild_to_Client();
            }

            return processedChunks;

        } // end of synchronized(chunkFiles_Lock) block
            
    }

    


    public long processChunks(Map<Long, File> unprocessedChunks_OrderedMap) throws IOException, Exception_PersistenceError, Exception_PersistenceEventHandler {
        synchronized (chunkFiles_Lock) {
            System.out.println("\nChunks Exist - processing chunks:");

            for (File unprocessedChunkFile : unprocessedChunks_OrderedMap.values()) {
                System.out.print("   Processing chunk file [" + unprocessedChunkFile.getAbsolutePath() + "]");
                System.out.flush();

                int numOfLinesInChunk = loadAndRead_LogFile_Chunk(unprocessedChunkFile, orphanedCommands_Manager);
                long chunk_TimeStamp = PersistentMatricesManager_Utilities.getTimeStamp_from_FileName(unprocessedChunkFile.getName(), getLogFileChunk_BaseName());

                System.out.println(" with " + numOfLinesInChunk + " lines.");
                sendPersistenceEvent(PersistenceEventType.Server_Event_ProcessedChunk, numOfLinesInChunk, unprocessedChunkFile, chunk_TimeStamp);
            }

            System.out.println("   ... Done!");
            long timeStamp_Shortened = PersistentMatricesManager_Utilities.get_LogFileName_ShortenedTimestamp();
            return timeStamp_Shortened;
            
        }
    }


    public PersistentMatricesManager_Server_ControlFile switchTo_New_PersistentControlSet(TreeMap<Long, File> processedChunks_OrderedMap, long timeStamp_Shortened) throws IOException {

        synchronized (controlSets_Lock) {
            //  create the new control dir
            File newControlDir = FileUtilities.makeDir(persistenceControl_RootDir + File.separator + persistenceControl_DirBaseName + timeStamp_Shortened);
            //  generate new control file
            File newControlFileObj = new File(newControlDir, persistenceControl_FileBaseName + timeStamp_Shortened);
            newControlFileObj.createNewFile();

            return PersistentMatricesManager_Server_ControlFile.writeNewControlFile_and_CreateNewControlFileObj(this,
                    newControlFileObj, timeStamp_Shortened, processedChunks_OrderedMap, getLogFileChunk_BaseName());

        }
    }


    //  TODO - I think for this method, you don't want to lock all chunkFiles, but just the one you're reading. Add this in later.
    public int loadAndRead_LogFile_Chunk(File chunkFile, Command_OrphanedCommands_Manager orphanedCommands_Manager)
            throws Exception_PersistenceError, IOException {
        UpdateLog_Reader updateLog_Reader = new UpdateLog_Reader(chunkFile);


        int lineCount = 0;
        while (updateLog_Reader.hasCharactersToRead()) {
            try {
                Command command = updateLog_Reader.readCommand();
                if (command != null) {
                    // perform action
                    CmdAction cmdAction = command.cmdAction;

                    cmdAction.set_AppControl(appControl);
                    cmdAction.set_ObjectIndex(objectIndex);

                    cmdAction.performAction(executeInfo, command);


                } else {
                }
                lineCount++;
                
            } catch(Exception e) {
                throw new Exception_PersistenceError("Had an error trying to read line #" + (lineCount + 1) + ".", e);
            }
        }

        return lineCount;
    }


    
    public void copy_ClientPersistedMatrixSrcDir_to_Server() throws IOException {
        synchronized (metaCode_Lock) {
            System.out.println("\nUpdating the server's src. Copying the client's meta-src files to the server:");
            System.out.println("   Copying client Meta-Src from [" + client__SrcMetaCode_BaseDir + "] to server dir [ " + getMetaCompiler__SrcMetaCode_BaseDir() + "]");

            //  clean out the server's source files from the previous server execution.
            FileUtilities_Delete.deltree(getMetaCompiler__SrcMetaCode_BaseDir(), true);

            //  copy current client source to server
            FileUtilities.copyFilesInDir_Recursive(client__SrcMetaCode_BaseDir, getMetaCompiler__SrcMetaCode_BaseDir(), true, true);
            System.out.println("   ...Done!");
        }
    }
    public void copy_ServerPersistedMatrix_MetaSrcAndBuild_to_Client() throws IOException {
        synchronized (metaCode_Lock) {
            System.out.println("\nUpdating the client src. Copying the Server files to the client:");

            System.out.println("   Copying server Meta-Src from [" + getMetaCompiler__SrcMetaCode_BaseDir() + "] to client dir [ " + client__SrcMetaCode_BaseDir + "]");
            //  copy the Matrix Meta Src (.matrix and .mjava files, along with any secondary .java files) to the client
            FileUtilities.copyFilesInDir_Recursive(getMetaCompiler__SrcMetaCode_BaseDir(), client__SrcMetaCode_BaseDir, true, true);

            System.out.println("   Copying server Meta-Build files from [" + getMetaCompiler__BuildMeta_BaseDir() + "] to client dir [ " + client__BuildMeta_BaseDir + "]");
            //  copy the BuildMeta files (meta compiled .java files) to the client
            FileUtilities.copyFilesInDir_Recursive(getMetaCompiler__BuildMeta_BaseDir(), client__BuildMeta_BaseDir, true, true);

            System.out.println("   Copying server Final-Build files from [" + getMetaCompiler__BuildFinal_BaseDir() + "] to client dir [ " + client__BuildFinal_BaseDir + "]");
            //  copy the BuildFinal files (.class files) to the client
            FileUtilities.copyFilesInDir_Recursive(getMetaCompiler__BuildFinal_BaseDir(), client__BuildFinal_BaseDir, true,  true);

            System.out.println("   ...Done!");
        }
    }

    
    public void generate_PersistedMatrixCode() throws IOException, Exception_PersistenceError, Exception_PersistenceEventHandler {
        synchronized (metaCode_Lock) {

            for (Matrix persistMatrix : getPersistentMatrices()) {

                String matrixSrcPackage_FullDirPath = getMetaCompiler__SrcMetaCode_BaseDir() + File.separator +
                        FileUtilities.convert_DotName_to_Path(persistMatrix.getMatrixName().getPackageName().toString());
                String matrixSrcFile_FullFilePath = matrixSrcPackage_FullDirPath + File.separator +
                        persistMatrix.matrixName.getMatrixName().get_Name_no_backtiks();

                System.out.println("Generating Persisted Matrix Code for matrix: ");
                System.out.println("   name:" + persistMatrix.getMatrixName().get_Name_no_backtiks());
                System.out.println("   dest file path:" + matrixSrcFile_FullFilePath);
                sendPersistenceEvent(PersistenceEventType.Server_Event_PersistenceMatrixGeneration_Started,
                        persistMatrix.getMatrixName().getPackageName().toString(),
                        (persistMatrix.matrixName.getMatrixName().get_Name_no_backtiks()), matrixSrcFile_FullFilePath, System.currentTimeMillis());


                PersistentMatrixCodeGenerator matrixCodeGen = new PersistentMatrixCodeGenerator(
                        matrixSrcPackage_FullDirPath,
                        persistMatrix.matrixName.getMatrixName().get_Name_IdentFormat() + ".matrix");
                String replacedMatrixCode = matrixCodeGen.generateCodeFromMatrix(persistMatrix);
                matrixCodeGen.writeToFile(matrixSrcPackage_FullDirPath, true);


                System.out.println("   ... Done!");
                sendPersistenceEvent(PersistenceEventType.Server_Event_PersistenceMatrixGeneration_Finished,
                        persistMatrix.getMatrixName().getPackageName().toString(),
                        (persistMatrix.matrixName.getMatrixName().get_Name_no_backtiks()), matrixSrcFile_FullFilePath, System.currentTimeMillis());

            }
        }
        
    }



    


    //  ______________________________________________________________________________________________________________________
    //
    //  Get Property Methods
    //  ______________________________________________________________________________________________________________________

    

    public File[] getFromInbox_ChunkFiles() throws IOException {
        synchronized(chunkFiles_Lock) {
            return FileUtilities.getFilesInDir(persistenceServer_LogFileChunk_InboxDir, getChunkFileNameFilter());
        }
    }
 
    public File[] getAll_ControlDirectories() throws IOException {
        synchronized(controlSets_Lock) {
            return FileUtilities.getDirectoriesInDir(persistenceControl_RootDir, new FilenameFilter_StartsWith(persistenceControl_DirBaseName));
        }
    }

    
    public PersistentMatricesManager_Server_ControlFile getLatest_PersistenceControlFile() throws IOException {
            return getLatest_PersistenceControlFile(null);
    }
    public PersistentMatricesManager_Server_ControlFile getLatest_PersistenceControlFile(Integer_Mutable numControlSets_IncludesInvalid__OUT) throws IOException {
        synchronized(controlSets_Lock) {

            Comparator<Long> reverseLongOrdering_Comparator = new Comparator<Long>() {
                public int compare(Long o1, Long o2) {
                    if (o1.longValue() > o2.longValue())
                        return -1;
                    else if (o1.longValue() == o2.longValue())
                        return 0;
                    else
                        return 1;
                }
            };

            TreeMap<Long, File> timeStamps_to_ControlDir_ReverseOrderedMap = new TreeMap<Long, File>(reverseLongOrdering_Comparator);
            FilenameFilter controlDir_DirNameFilter = new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.startsWith(persistenceControl_DirBaseName);
                }
            };

            File[] controlDir_FileObj_List = FileUtilities.getDirectoriesInDir(persistenceControl_RootDir, controlDir_DirNameFilter);

            //  order the timestamps
            for (File controlDir_FileObj : controlDir_FileObj_List) {
                String controlDir_TimeStamp_String = controlDir_FileObj.getName().substring(persistenceControl_DirBaseName.length());

                Exception except = null;
                try {
                    Long controlDir_TimeStamp = Long.parseLong(controlDir_TimeStamp_String);

                    timeStamps_to_ControlDir_ReverseOrderedMap.put(controlDir_TimeStamp, controlDir_FileObj);

                } catch (NumberFormatException e) {
                    except = e;
                }

                if (except != null) {
                    try {
                        sendPersistenceEvent(PersistenceEventType.Server_Error,
                            new Exception_PersistenceError("Tried to grab the timestamp from the control directory name, but had an error. The name of the directory was, " +
                            controlDir_FileObj.getName() + ", and the timestamp string was  '" + controlDir_TimeStamp_String + "'. See inner exception for more detail.", except));
                    } catch (Exception_PersistenceEventHandler e) {
                        throw new ExceptRuntime_PersistenceManagerError("Tried to send a persistence server error event, but had an error sending to the event handlers (see inner exception).", e);
                    }
                }
            }




            PersistentMatricesManager_Server_ControlFile validPersistControlFile = null;

            // get the newest, valid control file (the latest one might have been interrupted during creation, so invalid and should not be used.
            if (timeStamps_to_ControlDir_ReverseOrderedMap.size() > 0) {

                Iterator<Map.Entry<Long, File>> timeStamp_w_ControlDir_ReverseOrdered_Iter = timeStamps_to_ControlDir_ReverseOrderedMap.entrySet().iterator();
                boolean foundValid_ControlFile_and_Chunks = false;

                while (!foundValid_ControlFile_and_Chunks && timeStamp_w_ControlDir_ReverseOrdered_Iter.hasNext()) {

                    Map.Entry<Long, File> timeStamp_w_ControlDir = timeStamp_w_ControlDir_ReverseOrdered_Iter.next();
                    Long control_TimeStamp = timeStamp_w_ControlDir.getKey();
                    File controlDir = timeStamp_w_ControlDir.getValue();


                    File controlFile = new File(controlDir, persistenceControl_FileBaseName + control_TimeStamp);


                    if (controlFile.exists()) {

                        List<String> chunkFileNames_OUT = new ArrayList<String>();
                        OutputParameter controlFile_ValidationError_OUT = new OutputParameter();

                        PersistentMatricesManager_Server_ControlFile persistControlFile = PersistentMatricesManager_Server_ControlFile.validateFile_and_Load(
                                controlFile, getPersistenceControl_FileBaseName(), getLogFileChunk_BaseName(), this, chunkFileNames_OUT,
                                controlFile_ValidationError_OUT);

                        if (controlFile_ValidationError_OUT.value == null) {
                            persistControlFile.setChunkFiles(chunkFileNames_OUT, persistenceServer_LogFileChunk_InboxDir, getLogFileChunk_BaseName());

                            if (persistControlFile.checkIfChunkFilesExist()) {
                                foundValid_ControlFile_and_Chunks = true;
                                validPersistControlFile = persistControlFile;
                            } else {
                                //  TODO - LOG THIS ERROR!!!
                            }
                        } else {
                            //  TODO - LOG THIS ERROR!!!
                        }
                    }

                }  //  end of while(not found a valid control)



                if (foundValid_ControlFile_and_Chunks) {
                    if (numControlSets_IncludesInvalid__OUT != null)
                        numControlSets_IncludesInvalid__OUT.value = controlDir_FileObj_List.length;
                    return validPersistControlFile;
                }
            }

            if (numControlSets_IncludesInvalid__OUT != null)
                numControlSets_IncludesInvalid__OUT.value = controlDir_FileObj_List.length;
            return null;


        } // end of synchronized(controlSets_Lock)
    }





    //  ______________________________________________________________________________________________________________________
    //
    //  Private Helper Methods
    //  ______________________________________________________________________________________________________________________



}
