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
import net.unconventionalthinking.matrix.Matrix;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.hierarchy.persistence.PersistentMatricesManager.PersistenceEventType;
import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;



public class PersistTest_03_Server__CheckNewPersistedMatrix extends PersistTest_Server_TestBase {

    //  Setup the server.
    //  You can do this two ways. One, with the Server Executor class, which use the configurator (meaning, using the properties file).
    //  Two, you can manually set the settings in code.
    public static boolean runServer_UsingServerExecutor = true;

    public PersistTest_03_Server__CheckNewPersistedMatrix() {    }


    @BeforeClass
    public static void setUpClass() throws Exception {
        PersistTest_Server_TestBase.setupServer_ForExistingMatrixRun(runServer_UsingServerExecutor);
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
        PersistTest_Server_TestBase.tearDownClass();
    }

    @Before
    @Override
    public void setUp() {}
    @After
    @Override
    public void tearDown() {}



    /**
     * Test of createNew_Descriptor method, of class CommandEncoder_Descriptor.
     */
    @Test
    public void checkNewPersistedMatrix_Test() throws Exception {
        try {
            System.out.println("checkNewPersistedMatrix_Test");



            persistManager_Server.registerPersistenceEventListener(PersistenceEventType.Server_Event_ProcessedChunk,
                new PersistentMatricesManager_EventListener() {

                    public void eventOccurred(PersistentMatricesManager persistenceMatrixManager, PersistenceEventType eventType, Object... eventParams)
                            throws Exception_PersistenceEventHandler {
                        try {
                            serverEvent_ProcessedChunk((Integer)eventParams[0], (File)eventParams[1], (Long)eventParams[2]);
                        } catch(Exception e) {
                            throw new Exception_PersistenceEventHandler("Had ERROR!", e);
                        }
                    }
                }
            );

            persistManager_Server.registerPersistenceEventListener(PersistenceEventType.Server_Event_ShutDownRequestCompleted,
                new PersistentMatricesManager_EventListener() {

                    public void eventOccurred(PersistentMatricesManager persistenceMatrixManager, PersistenceEventType eventType, Object... eventParams)
                            throws Exception_PersistenceEventHandler {
                        try {
                            serverEvent_ShutdownRequestCompleted();
                        } catch(Exception e) {
                            throw new Exception_PersistenceEventHandler("Had ERROR!", e);
                        }
                    }
                }
            );

            super.register_PersistenceMatrixGeneration_ServerEvents();

            Matrix persisted_testMatrix = getCurr_TestMatrix(false);
            assertEquals("Test.Matrix" , persisted_testMatrix.label.getSymbol().name_no_backtiks);

            SymbolControl symbolControl = getCurr_SymbolControl();
            ExecutionInfo executeInfo = getCurr_ExecutionInfo();

            PersistTest_03_Utilities.testUpdatedMatrix(persisted_testMatrix, symbolControl, executeInfo);

            persisted_testMatrix = getCurr_TestMatrix(true);
            assertEquals("Test.Matrix2" , persisted_testMatrix.label.getSymbol().name_no_backtiks);
            PersistTest_03_Utilities.testUpdatedMatrix(persisted_testMatrix, symbolControl, executeInfo);

            
            // Wait until client asks server to shutdown
            synchronized(testThread_LockObject) {
                testThread_LockObject.wait();
            }
            //  sleep for a couple of secs, in case multiThreaded_AssertEquals() has had an assert failure,
            //  is stopping the server, and doing any last operaations.
            Thread.sleep(3000);

            System.out.println("...Test stopped.");
            
        } catch (Exception e) {
            stopPersistenceServer();
            throw e;
        }
    }


}