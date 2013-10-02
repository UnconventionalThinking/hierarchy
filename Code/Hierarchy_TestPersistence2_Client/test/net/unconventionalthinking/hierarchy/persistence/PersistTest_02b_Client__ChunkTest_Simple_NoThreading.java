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
import net.unconventionalthinking.lang.Integer_Mutable;
import net.unconventionalthinking.matrix.AppControl_Base;
import net.unconventionalthinking.matrix.Descriptor;
import net.unconventionalthinking.matrix.Matrix;
import net.unconventionalthinking.matrix.MatrixControl;
import net.unconventionalthinking.matrix.MatrixSet;
import net.unconventionalthinking.matrix.SchemaInfo_Descriptor;
import net.unconventionalthinking.matrix.SchemaInfo_Schema;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.utilities.FileUtilities;
import java.io.File;
import java.util.Arrays;
import java.util.List;
///*
import maintests.samples.persistenceclient.AppControl;
import maintests.samples.persistenceclient.AppSymbols_DescTag;
//*/
import maintests.samples.persistenceclient.AppSymbols_Label;
import net.unconventionalthinking.hierarchy.persistence.PersistenceTestWorker_Constants;
import net.unconventionalthinking.hierarchy.persistence.PersistenceWrapper_FieldSet;
import net.unconventionalthinking.hierarchy.persistence.PersistentMatricesManager_Client;
import net.unconventionalthinking.utilities.FileUtilities_Delete;
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
public class PersistTest_02b_Client__ChunkTest_Simple_NoThreading {


    static File logFile;
    static PersistentMatricesManager_Client persistManager_Client;
 
    static AppControl_Base appControl;
    static ExecutionInfo executeInfo;
    static MatrixControl matrixControl;
    static SymbolControl symbolControl;

    static Matrix testMatrix_Original;




    public PersistTest_02b_Client__ChunkTest_Simple_NoThreading() {    }


    @BeforeClass
    public static void setUpClass() throws Exception {
///*
        appControl = maintests.samples.persistenceclient.AppControl.initializeApp();
        testMatrix_Original = maintests.samples.persistenceclient.Test$__$Matrix.matrix;
//*/
        executeInfo = appControl.executionInfo;
        matrixControl = appControl.matrixControl;
        symbolControl = appControl.symbolControl;

        persistManager_Client = new PersistentMatricesManager_Client(PersistenceTestWorker_Constants.PersistTestClient_UpdateLog_DirPath, PersistenceTestWorker_Constants.UpdateLog_FileName,
                true, matrixControl);
        persistManager_Client.setPersistenceServer_LogFileChunk_InboxDir(PersistenceTestWorker_Constants.PersistTestServer_ChunkInbox_DirPath);
        persistManager_Client.setChunkCheck_Interval_ms(2);
        persistManager_Client.setChunkSizeBoundary_LineCount(4);


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
    public void createUpdates_Test() throws Exception {
        System.out.println("createUpdates_Test");


        SchemaInfo_Descriptor formSelector_SchemaInfo = maintests.samples.persistenceclient.WEB$__$FORM.schema.getChild_SchemaInfoDescriptor(executeInfo,
            AppSymbols_DescTag.maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM$_CC_$FORM$__$SELECTOR);
        SchemaInfo_Descriptor option_SchemaInfo = formSelector_SchemaInfo.getChild_SchemaInfoDescriptor(executeInfo,
            AppSymbols_DescTag.maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM$_CC_$OPTION);




        Integer_Mutable createdDesc_logVarName_OUT = new Integer_Mutable();

        List<String> labelParts = Arrays.asList("my", "formSelector");
        Label label = symbolControl.multiPartSymbol_Factory.createNew_Label(labelParts, 1, false);
        MatrixSet<SchemaInfo_Schema> uses_SchemaSet = null;
        Descriptor parentDescriptor = testMatrix_Original;


        Descriptor newDesc = null;

        // for testing purposes: if you want to write out just the add, use this line of code
        //newDesc = matrixControl.matrixFactory.createNew_Descriptor(executeInfo, formSelector_SchemaInfo, label, null, parentDescriptor, 111);

        newDesc = persistManager_Client.commandEncoder_Desc.createNew_Descriptor(executeInfo, createdDesc_logVarName_OUT, formSelector_SchemaInfo,
                label, uses_SchemaSet, parentDescriptor);


        assertNotNull(newDesc);


        persistManager_Client.commandEncoder_Desc.addDescriptor(executeInfo, testMatrix_Original, newDesc);




        System.out.println("setField values");

        String newFieldValue = "*** TEST PATH from _01_createUpdateLog_Test ***";

        Descriptor formReq_Desc = testMatrix_Original.get_ChildDescriptor(executeInfo, AppSymbols_Label.First$32$Name)
                .get_ChildDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED);
        PersistenceWrapper_FieldSet fieldSet_PersistWrapper = new PersistenceWrapper_FieldSet(executeInfo, formReq_Desc.get_FieldSet(), persistManager_Client);
        fieldSet_PersistWrapper.setField(executeInfo, 1, newFieldValue);

        assertEquals(formReq_Desc.get_FieldSet().getField(executeInfo, 1), newFieldValue);



        
        File newChunkFile = persistManager_Client.createNewChunkIfNeeded();

        //  test that the logfile chunk exists and has been moved
        String path = newChunkFile.getPath();
        assertTrue(newChunkFile.exists());
        assertEquals(new File(PersistenceTestWorker_Constants.PersistTestServer_ChunkInbox_DirPath, newChunkFile.getName()).getPath(), newChunkFile.getPath());

        //  test that the new logfile exists
        File logFile = new File(PersistenceTestWorker_Constants.PersistTestClient_UpdateLog_DirPath, PersistenceTestWorker_Constants.UpdateLog_FileName);
        assertTrue(logFile.exists());


        // cleanup
        FileUtilities_Delete.deleteFile(logFile);
        FileUtilities_Delete.deleteFile(newChunkFile);

    }



}