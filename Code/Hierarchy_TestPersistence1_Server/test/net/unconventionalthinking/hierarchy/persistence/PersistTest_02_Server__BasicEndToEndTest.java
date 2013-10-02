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
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.hierarchy.persistence.PersistentMatricesManager.PersistenceEventType;
import java.io.File;
import java.util.Arrays;
import java.util.List;
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
public class PersistTest_02_Server__BasicEndToEndTest extends PersistTest_Server_TestBase {

    //  Setup the server.
    //  You can do this two ways. One, with the Server Main class, which use the configurator (meaning, using the properties file).
    //  Two, you can manually set the settings in code.
    public static boolean runServer_UsingServerMainClass = true;


    public PersistTest_02_Server__BasicEndToEndTest() {    }



    @BeforeClass
    public static void setUpClass() throws Exception {
        PersistTest_Server_TestBase.setupServer_InitialRun(runServer_UsingServerMainClass);
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
    public void processUpdates_Test() throws Exception {
        try {
            System.out.println("processUpdates_Test");


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


            // Wait until all the chunks have been processed
            synchronized(testThread_LockObject) {
                testThread_LockObject.wait();
            }
            System.out.println("Waiting for server to terminate inbox monitor thread...");
            persistManager_Server.awaitTermination();
            //  sleep for a couple of secs, in case multiThreaded_AssertEquals() has had an assert failure,
            //  is stopping the server, and doing any last operations.
            Thread.sleep(3000);

            System.out.println("...Test stopped.");


        } catch (Exception e) {
            stopPersistenceServer();
            throw e;
        }

    }




    /**
     * called by the PersistentEvent handler
     */
    @Override
    protected void serverEvent_ProcessedChunk(int numOfLinesInChunk, File processedChunkFile, long chunk_TimeStamp) throws Exception {
        System.out.println("***PERSIST_TEST_SERVER Event Handler**  Processed Chunk File with name: " + processedChunkFile + ", with " + numOfLinesInChunk + " lines." );
        System.out.flush();
        
        processedChunkCount++;
        assertTrue(processedChunkFile.exists());
        boolean amProcessing_Second_TestMatrix = processedChunkCount == 3 || processedChunkCount == 4;
        Matrix curr_PersistedTestMatrix = getCurr_TestMatrix(amProcessing_Second_TestMatrix);
        
        SymbolControl symbolControl = getCurr_SymbolControl();
        ExecutionInfo executeInfo = getCurr_ExecutionInfo();
        
        //  Get the FORM.REQUIRED descriptor. In both the first and second chunk, values are set on it.
        List<String> firstName_LabelParts = Arrays.asList("First Name");
        Label firstName_Label = symbolControl.multiPartSymbol_Factory.createNew_Label(firstName_LabelParts, 1, false);
        Descriptor firstName_Item = curr_PersistedTestMatrix.get_ChildDescriptor(executeInfo, firstName_Label);

        DescriptorTagName formReq_DescTag = symbolControl.multiPartSymbol_Factory.createNew_DescTagName("FORM.REQUIRED", 1, false, null, null);
        Descriptor formReq_Desc = firstName_Item.get_ChildDescriptor(executeInfo, formReq_DescTag);

        if (processedChunkCount == 1 || processedChunkCount == 3) {
            //  Test that a descriptor was added: FORM.SELECTOR `my`.`formSelector`
            List<String> formSelector_LabelParts = Arrays.asList("my", "formSelector");
            Label formSelector_Label = symbolControl.multiPartSymbol_Factory.createNew_Label(formSelector_LabelParts, 1, false);
            Descriptor formSelector_Desc = curr_PersistedTestMatrix.get_ChildDescriptor(executeInfo, formSelector_Label);

            multiThreaded_AssertEquals(formSelector_Desc.label, formSelector_Label);
            multiThreaded_AssertEquals("*** TEST PATH 1t ***", formReq_Desc.get_FieldSet().getField(executeInfo, 1));

            System.out.println("   * The chunk #" + processedChunkCount + " passed the 'Add New Descriptor ( w/a Set field)' tests.");

        } else if (processedChunkCount == 2 || processedChunkCount == 4) {
            //  Test for new values set on the FORM.REQUIRED descriptor:
            multiThreaded_AssertEquals(PersistTestResultsConstants_forClientServerTests.FORMREQUIRED_NEW_FIELDVALUE__IMAGE_HEIGHT, formReq_Desc.get_FieldSet().getField(executeInfo, 2));
            multiThreaded_AssertEquals(PersistTestResultsConstants_forClientServerTests.FORMREQUIRED_NEW_FIELDVALUE__IMAGE_WIDTH, formReq_Desc.get_FieldSet().getField(executeInfo, 3));

            System.out.println("   * The chunk #" + processedChunkCount + " passed the 'Set field' tests.");
        } else {
            throw new Exception("There should only be 4 chunks processed, but there was a 5th one!!!");
        }

        if (processedChunkCount == 4) {
            //  Stop the server
            persistManager_Server.shutdown();
        }
        
    }



}