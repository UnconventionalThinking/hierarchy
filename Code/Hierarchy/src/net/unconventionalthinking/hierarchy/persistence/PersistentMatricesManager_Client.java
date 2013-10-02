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

import net.unconventionalthinking.matrix.MatrixControl;
import net.unconventionalthinking.utilities.FileUtilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import net.unconventionalthinking.hierarchy.Exception_HierarchyCompiler;
import net.unconventionalthinking.hierarchy.langsymboltable.Exception_FindTypeName;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.utilities.Exception_FileUtilities_ProcessingError;



/**
 *
 * @author peterjoh
 */
public class PersistentMatricesManager_Client extends PersistentMatricesManager {


    
    public final UpdateLog_Writer updateLog_Writer;
    public final CommandEncoder commandEncoder;
    public final CommandEncoder_Descriptor commandEncoder_Desc;

    private MatrixControl matrixControl;


    private String logFile_DirPath;
    private String logFileName;

    private int chunkSizeBoundary_LineCount;


    private PersistentMatricesManager_Client_RemoteClient   remoteClient;
    private PersistentMatricesManager_Server_RemoteMethods  persistServerRemoteMethods_Proxy;
    private String rmiRegistery_HostName;
    private int rmiRegistery_Port;




    public PersistentMatricesManager_Client(String logFile_DirPath, String logFileName, boolean replaceExistingFile, MatrixControl matrixControl) throws IOException {
        super(PersistentMatricesManagerConstants.CLIENT__CHUNKMONITOR_CHECKFORCHUNKS_DEFAULT_INITIAL_INTERVAL__MS,
              PersistentMatricesManagerConstants.CLIENT__CHUNKMONITOR_CHECKFORCHUNKS_DEFAULT_INTERVAL__MS, 60);

        this.logFile_DirPath = logFile_DirPath;
        this.logFileName = logFileName;
        this.updateLog_Writer = new UpdateLog_Writer(logFile_DirPath, logFileName, replaceExistingFile);

        this.matrixControl = matrixControl;

        commandEncoder = new CommandEncoder(updateLog_Writer);
        commandEncoder_Desc = new CommandEncoder_Descriptor(commandEncoder, matrixControl);

        chunkSizeBoundary_LineCount = PersistentMatricesManagerConstants.CLIENT__CHUNK_DEFAULT_SIZEBOUNDARY__LINECOUNT;

        
        ChunkMonitor_ChunkProcessor client_ChunkMonitorProcessor =  new ChunkMonitor_ChunkProcessor() {
            public void process() throws IOException, Exception_PersistenceEventHandler {
                createNewChunkIfNeeded();
            }
        };
        
        chunkMonitor_ChunkProcessorTaskWrapper = new PersistentMatrix_ChunkMonitor_TaskWrapper(client_ChunkMonitorProcessor, this);

        rmiRegistery_HostName = null;
        rmiRegistery_Port = -1;

        persistServerRemoteMethods_Proxy = null;
    }

    /**
     *  only used for testing
     */
    PersistentMatricesManager_Client(UpdateLog_Writer updateLog_Writer, CommandEncoder commandEncoder, CommandEncoder_Descriptor commandEncoderDescriptor) {
        super(PersistentMatricesManagerConstants.CLIENT__CHUNKMONITOR_CHECKFORCHUNKS_DEFAULT_INITIAL_INTERVAL__MS,
              PersistentMatricesManagerConstants.CLIENT__CHUNKMONITOR_CHECKFORCHUNKS_DEFAULT_INTERVAL__MS, 60);

        this.updateLog_Writer = updateLog_Writer;
        this.commandEncoder = commandEncoder;
        this.commandEncoder_Desc = commandEncoderDescriptor;
        

        chunkSizeBoundary_LineCount = PersistentMatricesManagerConstants.CLIENT__CHUNK_DEFAULT_SIZEBOUNDARY__LINECOUNT;

        chunkMonitor_ChunkProcessorTaskWrapper = null;
    }




    
    //  ______________________________________________________________________________________________________________________
    //
    //  Get and Set Methods
    //  ______________________________________________________________________________________________________________________


    public int getChunkSizeBoundary_LineCount() { return chunkSizeBoundary_LineCount;}
    public void setChunkSizeBoundary_LineCount(int chunkSizeBoundary_LineCount) { this.chunkSizeBoundary_LineCount = chunkSizeBoundary_LineCount; }

    public boolean chunkExists() {
        File chunkFile = new File(logFile_DirPath + File.separator + logFileName);
        return chunkFile.exists();
    }
    public boolean chunkIsEmpty() throws IOException {
        File chunkFile = new File(logFile_DirPath + File.separator + logFileName);
        ObjectInputStream chunkFile_In = new ObjectInputStream(new FileInputStream(chunkFile));
        return chunkFile_In.available() == 0;
    }


    public String getLogFile_DirPath() { return logFile_DirPath;}
    public void setLogFile_DirPath(String logFile_DirPath) { this.logFile_DirPath = logFile_DirPath;}
    public String getLogFileName() { return logFileName; }
    public void setLogFileName(String logFileName) { this.logFileName = logFileName; }



    @Override
    public void setRmiRegistery_HostName(String rmiRegistery_HostName) { this.rmiRegistery_HostName = rmiRegistery_HostName; }
    @Override
    public void setRmiRegistery_Port(int rmiRegistery_Port) { this.rmiRegistery_Port = rmiRegistery_Port; }



    @Override
    public void printSettings() {
        System.out.println("PersistentMatrices Client-Manager Settings:");
        System.out.println("  o log-file dir-path [" + logFile_DirPath + "]");
        System.out.println("  o log-file name [" + logFileName + "]");

        super.printSettings();
    }


    //  ______________________________________________________________________________________________________________________
    //
    //  Public Methods
    //  ______________________________________________________________________________________________________________________

    /**
     * This initializes must be called in BOTH JVM's! In the client initialization jvm , and in the client monitoring jvm.
     */
    public void initialize1_REQUIRED() {
        System.out.println("PersistenceMatrixManager Client: RMI Registry connection Settings:");
        System.out.println("\thost: " + rmiRegistery_HostName + ", port: " + rmiRegistery_Port);

        remoteClient = new PersistentMatricesManager_Client_RemoteClient(rmiRegistery_HostName, rmiRegistery_Port);
        try {
            persistServerRemoteMethods_Proxy = remoteClient.getRemoteMethodsService_ProxyObj();
        } catch (Exception e) {
            throw new ExceptRuntime_PersistenceManagerError("Tried to get the persistence server, remote methods proxy, but had an error.", e);
        }
    }

    /**
     * **This method needs to run it's own JVM before the actual client starts.**
     * Why? because it needs to update the client persistent matrix and recompile it.
     */
    public void initialize2_UpdatePersistentMatrices() throws RemoteException, IOException, Exception_PersistenceError, 
            Exception_PersistenceEventHandler, Exception_MetaCompilerError, Exception_HierarchyCompiler, Exception_FileUtilities_ProcessingError,
            Exception_FindTypeName {
        
        System.out.println("\nInitialize2_UpdatePersistentMatrices...");
        //  Update PersistedMatrixCode _____________________

        //  1. Copy existing chunks to server
        if (chunkExists() && !chunkIsEmpty()) {
            String newChunkFileName_withTimeStampAndPath = renameLogChunk_AppendTimestamp();
            sendLogChunkToPersistenceServer(newChunkFileName_withTimeStampAndPath);
        }
        
        //  2. Tell the server to process any of the unprocessed chunks, getting its version of Persistent Matrix up to date.
        //  3. Then:
        //      - regenerate the updated persisted matrix (on the server)
        //      - metacompile it (again, on the server)
        //      - copy all the meta src and the java classes to the client, so that when the runtime , client jvm starts, it will have updated classes to use.
        boolean processedChunks = persistServerRemoteMethods_Proxy.checkForAndProcessChunks(true);


        //  4. Not sure this is needed, because you've copied over all the final, class files from the meta-compilation process, but let's
        //     metacompile the code that was sent over.
        //   metaCompile_PersistedMatrixCode(false);

        System.out.println("... done!\n");
    }

    
    @Override
    public void resetPersistentMatricesManager() {
        //  the call to the parent reset() method also obtains the lifecycle lock, so we don't really need this because this method only has
        //  this super.reset() call, but keeing the sync block here in case we need to add more code.
        synchronized(lifeCycle_Lock) {
            super.resetPersistentMatricesManager();
        }
    }


    public void start_PersistenceLogging() {

        synchronized(lifeCycle_Lock) {
            if (lifeCycle_RunState.compareAndSet(RunState.Shutdown.ordinal(), RunState.Starting.ordinal())) {
                System.out.println("Starting Persistence Logging...");
                
                inboxMonitor_ExecService.scheduleAtFixedRate(chunkMonitor_ChunkProcessorTaskWrapper, chunkCheck_Interval__Initial_ms, chunkCheck_Interval__ms,
                    TimeUnit.MILLISECONDS);
                lifeCycle_RunState.set(RunState.Running.ordinal());

                System.out.println("   ... started!");

            } else {
                System.out.println("Trying to start the Client Persistent-Matrices Manager, but it is not shutdown! The Client is in the '"
                        + lifeCycle_RunState.toString() + "' run state.");
            }
        }
    }


    /** 
     * Stop persistence logging. But if it's currently processing something, let it finish.
     * You need to call awaitTermination() to see if the shutdown of the monitor thread was successful.
     */
    @Override
    public void shutdown() throws IOException, Exception_PersistenceEventHandler, InterruptedException {

        synchronized(lifeCycle_Lock) {
            if (lifeCycle_RunState.compareAndSet(RunState.Running.ordinal(), RunState.ShuttingDown.ordinal())) {

                inboxMonitor_ExecService.shutdown();
                // create a last chunk if needed.
                createNewChunkIfNeeded();

            } else {
                System.out.println("Trying to shutdown the Client Persistent-Matrices Manager, but client is not running! The Client is in the '"
                        + lifeCycle_RunState.toString() + "' run state.");
            }
        }
    }


    public void destroy() throws IOException, Exception_PersistenceEventHandler, InterruptedException {
        shutdown();
        updateLog_Writer.closeLogFile_OutStream();
    }



    public File createNewChunkIfNeeded() throws IOException, Exception_PersistenceEventHandler {

        File newChunkFile = null;
        try {
            updateLog_Writer.updateLogFileLock__Lock();
            if (hierarchySettings.DEBUG_PERSISTENCE_CLIENT_VERBOSE)
                System.out.println("Checking for chunks...");


            if (is_NewChunk_Needed()) {
                if (hierarchySettings.DEBUG_PERSISTENCE_CLIENT_VERBOSE)
                    System.out.println("   ... Chunk found. Send to Persistence Server...");

                updateLog_Writer.closeLogFile_OutStream();
                String newChunkFileName_withTimeStampAndPath = renameLogChunk_AppendTimestamp();
                newChunkFile = sendLogChunkToPersistenceServer(newChunkFileName_withTimeStampAndPath);
                updateLog_Writer.createNewLogFile(true);

                if (hierarchySettings.DEBUG_PERSISTENCE_CLIENT_VERBOSE) 
                    System.out.println("   ... Done. Sent chunk to : " + newChunkFileName_withTimeStampAndPath + ".");
                sendPersistenceEvent(PersistenceEventType.ClientChunkMonitor_Event_SentChunkFileToServer, newChunkFile);
            }

        } finally {
            updateLog_Writer.updateLogFileLock__Unlock();
        }

        return newChunkFile;
    }


    //  ______________________________________________________________________________________________________________________
    //
    //  Server Management methods
    //  ______________________________________________________________________________________________________________________

    public void persistentServerManagement_StopServer(String userName, String password) throws RemoteException {
        persistServerRemoteMethods_Proxy.shutdownServer(userName, password);
    }
    /** returns true if successfully terminated. returns false if the wait timeout lapsed instead. */
    public boolean persistentServerManagement_AwaitServerTermination() throws RemoteException {
        return persistServerRemoteMethods_Proxy.awaitTerminationOfServer();
    }




    //  ______________________________________________________________________________________________________________________
    //
    //  Private Helper Methods
    //  ______________________________________________________________________________________________________________________

    private boolean is_NewChunk_Needed() {
        return (
                updateLog_Writer.getLineCount() > chunkSizeBoundary_LineCount ||
                (updateLog_Writer.getLineCount() > 0 && is_ChunkPastItsLifetime() )
        );
    }

    private boolean is_ChunkPastItsLifetime() {
        return ( System.currentTimeMillis() > (updateLog_Writer.getLogFile_UsageStartTime() + (chunkCheck_Interval__ms) ) );
    }

    /**
     * returns the file name with path of the renamed file chunk.
     */
    private String renameLogChunk_AppendTimestamp() {
        File logFileChunk = updateLog_Writer.getLogFile();
        String logChunk_NewFileName_FullPath = logFileChunk.getParent() + File.separator +
                getLogFileChunk_BaseName() + PersistentMatricesManager_Utilities.get_LogFileName_ShortenedTimestamp();

        boolean renameSucceeded = logFileChunk.renameTo(new File(logChunk_NewFileName_FullPath));

        if (!renameSucceeded)
            throw new ExceptRuntime_PersistenceManagerError("Couldn't rename the logfile chunk to: " + logChunk_NewFileName_FullPath +
                    ". Please check the permissions of the logfile directory and log file chunks themselves.");

        return logChunk_NewFileName_FullPath;
    }

    /**
     *
     * @return  returns the new file object for the moved chunk
     */
    private File sendLogChunkToPersistenceServer(String chunkFileName_withTimeStampAndPath) throws IOException {
        File chunkFile = new File(chunkFileName_withTimeStampAndPath);

        if (!chunkFile.exists())
            throw new ExceptRuntime_PersistenceManagerError("The log file chunk named, " + chunkFileName_withTimeStampAndPath + ", should have existed, because it doesn't.");

        return FileUtilities.moveFile(chunkFile, persistenceServer_LogFileChunk_InboxDir);
    }





    
    
}


