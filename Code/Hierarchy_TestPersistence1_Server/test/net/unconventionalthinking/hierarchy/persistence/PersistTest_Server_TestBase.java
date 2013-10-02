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
import net.unconventionalthinking.matrix.Descriptor;
import net.unconventionalthinking.matrix.Matrix;
import net.unconventionalthinking.matrix.MatrixControl;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.utilities.FileUtilities;
import net.unconventionalthinking.hierarchy.persistence.PersistentMatricesManager.PersistenceEventType;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import net.unconventionalthinking.utilities.FileUtilities_Delete;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * This test is used together with the number '02' persistence client tests. The purpose of the 02 tests is to do basic end-to-end testing of
 * persistence. More specifically, these tests start up server, and then start up the client, which metacompiles and loads a test matrix.
 * Then, the client does some basic updates to the matrix, which should be sent to back to this server. This unit test is waiting for update
 * events. On each update, it tests that the updates have reached the server.
 *
 * The main client unit test that does most of the updates is the PersistTest_02b_Client__BasicEndToEndTest!!
 *
 * Look at the serverEvent_ProcessedChunk() method to see what updates are done to the persisted matrix. To summarize,
 *   In the first chunk:
 *     - A descriptor is added to the matrix: FORM.SELECTOR `My`.`FormSelector`
 *     - The FORM.REQUIRED descriptor's RequiredImagePath field is updated
 *
 *   In the second chunk:
 *     - The FORM.REQUIRED descriptor's image width and height are updated.
 *
 * To build and run the tests, see the document, "Building and Testing Persistence.txt"
 */
public class PersistTest_Server_TestBase {

    public static final String ServerPropertiesFile_Path =
        PersistenceTestConstants.ProjDir__PersistenceTestServer + "/test/net/unconventionalthinking/hierarchy/persistence/PersistTest_Server.properties";


    static PersistenceTestWorker persistenceTest_Worker;
    static PersistentMatricesManager_Server persistManager_Server;
    static File logFile;
 


    static final Object testThread_LockObject = new Object();
    static int processedChunkCount = 0;



    public PersistTest_Server_TestBase() {    }


    @AfterClass
    public static void tearDownClass() throws Exception {}
    @Before
    public void setUp() {}
    @After
    public void tearDown() {}




    public static void setupServer_InitialRun(boolean runServer_UsingServerExecutor) throws Exception {

        System.out.println("setting up server for initial run.");
        //  Before we start, make sure the client has a fresh copy of the matrix, copy the Original matrix file to the _CLIENT_ source directory
        FileUtilities_Delete.deleteFile(PersistenceTestWorker_Constants.PersistTestClient_SrcMetaCode_maintestsSamples_DirPath + "/Test$__$Matrix.matrix", true);
        //  Setup the CLIENT to start with a fresh copy of the matrices, copy the Original matrix files to the client source directory
        FileUtilities.copyFilesInDir_Recursive(PersistenceTestWorker_Constants.PersistTestClient_CleanTestMatrices_BaseDirPath,
                PersistenceTestWorker_Constants.PersistTestClient_SrcMetaCode_DirPath, true, true);

        if (runServer_UsingServerExecutor) {
            boolean deletePersistentMatrices_onStartup = true;
            PersistentMatricesExecutor_Server persistMatricesServer_Main = new PersistentMatricesExecutor_Server(ServerPropertiesFile_Path,
                    deletePersistentMatrices_onStartup);
            persistManager_Server = persistMatricesServer_Main.startServer();
            
        } else {
            setupAndStartServer(true);
        }

    }

    public static void setupServer_ForExistingMatrixRun(boolean runServer_UsingServerMainClass) throws Exception {

        System.out.println("setting up server for a run with an existing matrix.");
        if (runServer_UsingServerMainClass) {
            boolean deletePersistentMatrices_onStartup = false;
            PersistentMatricesExecutor_Server persistMatricesServer_Main = new PersistentMatricesExecutor_Server(ServerPropertiesFile_Path,
                    deletePersistentMatrices_onStartup);
            persistManager_Server = persistMatricesServer_Main.startServer();

        } else {
            setupAndStartServer(false);
        }
    }

    private static void setupAndStartServer(boolean deletePersistentMatrices) throws Exception {
        persistenceTest_Worker = new PersistenceTestWorker();
        persistenceTest_Worker.setupServer();

        persistManager_Server = persistenceTest_Worker.persistenceServer;
        if (deletePersistentMatrices)
            persistManager_Server.deletePersistentMatrices();

        persistManager_Server.startServer();
    }

    
    
    //  With all the re-loading of the matrices and the appcontrol done by the server, you should use
    //  these methods to make sure you've got the current version (one that hasn't be replaced by a more
    //  current version.
    public static Matrix getCurr_TestMatrix(boolean isSecond_TestMatrix) throws Exception {

        if (isSecond_TestMatrix)
            return persistManager_Server.findPersistentMatrix("maintests.samples.persistenceclient.otherpackage", "Test.Matrix2");
        else
            return persistManager_Server.findPersistentMatrix("maintests.samples.persistenceclient", "Test.Matrix");
    }
    public static ExecutionInfo getCurr_ExecutionInfo() {
        return persistManager_Server.executeInfo;
    }
    public static SymbolControl getCurr_SymbolControl() {
        return persistManager_Server.appControl.symbolControl;
    }
    public static MatrixControl getCurr_MatrixControl() {
        return persistManager_Server.appControl.matrixControl;
    }

    /**
     * If an assert fails, we need to shutdown the main test thread. We can do this by simply shutting down the server.
     */
    public static void multiThreaded_AssertEquals(Object expected, Object actual) throws Exception {

        if (expected == null && actual != null ||
            expected != null && !expected.equals(actual)) {

           persistManager_Server.shutdown();
            synchronized(testThread_LockObject) {
                testThread_LockObject.notify();
            }
        }
        assertEquals(expected, actual);
    }


    protected void stopPersistenceServer() throws Exception_PersistenceEventHandler, ExceptRuntime_PersistenceManagerError, InterruptedException {
        persistManager_Server.shutdown();
        synchronized(testThread_LockObject) {
            testThread_LockObject.notify();
        }
    }

    /**
     * called by the PersistentEvent handler
     */
    protected void serverEvent_ProcessedChunk(int numOfLinesInChunk, File processedChunkFile, long chunk_TimeStamp) throws Exception {

        processedChunkCount++;
        assertTrue(processedChunkFile.exists());

    }

    protected void serverEvent_ShutdownRequestCompleted() {
        //  let the test thread wake up so test can continue
        synchronized(testThread_LockObject) {
            testThread_LockObject.notify();
        }
    }

    protected void register_PersistenceMatrixGeneration_ServerEvents() {

        persistManager_Server.registerPersistenceEventListener(PersistenceEventType.Server_Event_PersistenceMatrixGeneration_Started,
            new PersistentMatricesManager_EventListener() {

                public void eventOccurred(PersistentMatricesManager persistenceMatrixManager, PersistenceEventType eventType, Object... eventParams)
                        throws Exception_PersistenceEventHandler {
                    try {
                        serverEvent_PersistenceMatrixGen_Started((String)eventParams[0], (String)eventParams[1], (String)eventParams[2],
                                (Long)eventParams[3]);
                    } catch(Exception e) {
                        throw new Exception_PersistenceEventHandler("Had ERROR!", e);
                    }
                }

            }
        );

        persistManager_Server.registerPersistenceEventListener(PersistenceEventType.Server_Event_PersistenceMatrixGeneration_Finished,
            new PersistentMatricesManager_EventListener() {

                public void eventOccurred(PersistentMatricesManager persistenceMatrixManager, PersistenceEventType eventType, Object... eventParams)
                        throws Exception_PersistenceEventHandler {
                    try {
                        serverEvent_PersistenceMatrixGen_Finished((String)eventParams[0], (String)eventParams[1], (String)eventParams[2],
                                (Long)eventParams[3]);
                    } catch(Exception e) {
                        throw new Exception_PersistenceEventHandler("Had ERROR!", e);
                    }
                }
            }
        );
    }


    void serverEvent_PersistenceMatrixGen_Started(String matrix_PackageName, String matrix_SimpleName, String matrixSrcFile_FullFilePath,
            Long generationStartTime) {
    }
    void serverEvent_PersistenceMatrixGen_Finished(String matrix_PackageName, String matrix_SimpleName, String matrixSrcFile_FullFilePath,
            Long generationStartTime) {
    }

}