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
import net.unconventionalthinking.matrix.MatrixControl;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.hierarchy.persistence.PersistentMatricesManager.PersistenceEventType;
import java.io.File;
import java.io.IOException;
///*
//*/
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author peterjoh
 */
public class PersistTest_03b_Client__CheckNewPersistedMatrix {


    static PersistenceTestWorker persistenceTest_Worker;
    static PersistentMatricesManager_Client persistManager_Client;
    static File logFile;
 
    static AppControl_Base appControl;
    static ExecutionInfo executeInfo;
    static MatrixControl matrixControl;
    static SymbolControl symbolControl;

    static Matrix testMatrix;
    static Matrix testMatrix2;


    static final Object testThread_LockObject = new Object();
    static int chunkCount = 0;


    public PersistTest_03b_Client__CheckNewPersistedMatrix() {    }


    @BeforeClass
    public static void setUpClass() throws Exception {
///*
        AppControl_Base appControl = maintests.samples.persistenceclient.AppControl.initializeApp();
//*/
        executeInfo = appControl.executionInfo;
        matrixControl = appControl.matrixControl;
        symbolControl = appControl.symbolControl;

        testMatrix = maintests.samples.persistenceclient.Test$__$Matrix.matrix;
        testMatrix2 = matrixControl.find("maintests.samples.persistenceclient.otherpackage::Test.Matrix2");

        persistenceTest_Worker = new PersistenceTestWorker();
        if (PersistTest_03a_Client__UpdatePersistentMatrix.runClient_ExecutorOrConfigurator) {
            PersistentMatricesManager_Configurator_Client clientConfigurator = new PersistentMatricesManager_Configurator_Client(
                    PersistTest_02a_Client__UpdatePersistentMatrix.ClientPropertiesFile_Path, appControl.matrixControl);

            persistManager_Client = clientConfigurator.configure();

        } else {
            persistenceTest_Worker.setupClient(appControl.matrixControl);
            persistManager_Client = persistenceTest_Worker.persistenceClient;
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {}
    @After
    public void tearDown() {}



    /**
     * Test of createNew_Descriptor method, of class CommandEncoder_Descriptor.
     */
    @Test
    public void checkNewPersistedMatrix() throws Exception {
        System.out.println("checkNewPersistedMatrix");


        persistManager_Client.registerPersistenceEventListener(PersistenceEventType.ClientChunkMonitor_Event_SentChunkFileToServer,
            new PersistentMatricesManager_EventListener() {

                public void eventOccurred(PersistentMatricesManager persistenceMatrixManager, PersistenceEventType eventType, Object... eventParams)
                        throws Exception_PersistenceEventHandler {
                    try {
                        test_NewChunkFile((File)eventParams[0]);
                    } catch(Exception e) {
                        throw new Exception_PersistenceEventHandler("Had ERROR!", e);
                    }
                }

            }
        );

        persistManager_Client.initialize1_REQUIRED();
        //persistManager_Client.start_PersistenceLogging();


        PersistTest_03_Utilities.testUpdatedMatrix(testMatrix, symbolControl, executeInfo);
        PersistTest_03_Utilities.testUpdatedMatrix(testMatrix2, symbolControl, executeInfo);


        persistManager_Client.persistentServerManagement_StopServer(null, null);
    }



    
    /**
     * called by the PersistentEvent handler
     */
     void test_NewChunkFile(File newChunkFile) throws IOException {
        //  test that the logfile chunk exists and has been moved
        String path = newChunkFile.getPath();
        assertTrue(newChunkFile.exists());
        assertEquals(new File(PersistenceTestWorker_Constants.PersistTestServer_ChunkInbox_DirPath, newChunkFile.getName()).getPath(), newChunkFile.getPath());

        //  test that the new logfile exists
        File logFile = new File(PersistenceTestWorker_Constants.PersistTestClient_UpdateLog_DirPath, PersistenceTestWorker_Constants.UpdateLog_FileName);
        assertTrue(logFile.exists());

        chunkCount++;

        //  let the test thread wake up so test can continue
        synchronized(testThread_LockObject) {
            testThread_LockObject.notify();
        }
    }

}