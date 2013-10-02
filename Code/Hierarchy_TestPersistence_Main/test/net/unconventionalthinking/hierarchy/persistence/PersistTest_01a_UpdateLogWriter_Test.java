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
import java.io.File;
import java.util.Arrays;
import java.util.List;
///*
import maintests.samples.AppControl;
import maintests.samples.AppSymbols_DescTag;
//*/
import maintests.samples.AppSymbols_Label;
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
public class PersistTest_01a_UpdateLogWriter_Test {


    static File logFile;
    static CommandEncoder commandEncoder;
    static UpdateLog_Writer updateLog_Writer;
    static CommandEncoder_Descriptor commandEncoder_Desc;

    static AppControl_Base appControl;
    static ExecutionInfo executeInfo;
    static MatrixControl matrixControl;
    static SymbolControl symbolControl;

    static Matrix testMatrix_Original;




    public PersistTest_01a_UpdateLogWriter_Test() {    }


    @BeforeClass
    public static void setUpClass() throws Exception {
///*
        appControl = maintests.samples.AppControl.initializeApp();
        testMatrix_Original = maintests.samples.Test$__$Matrix.matrix;
//*/
        executeInfo = appControl.executionInfo;
        matrixControl = appControl.matrixControl;
        symbolControl = appControl.symbolControl;

        updateLog_Writer = new UpdateLog_Writer(PersistenceTestWorker_Constants.TestData_DirPath, PersistenceTestWorker_Constants.UpdateLog_FileName, true);

        commandEncoder = new CommandEncoder(updateLog_Writer);
        commandEncoder_Desc = new CommandEncoder_Descriptor(commandEncoder, matrixControl);

        System.out.println("Writing updates to log: [" + updateLog_Writer.getLogFileFullPath() + "]");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        updateLog_Writer.closeLogFile_OutStream();
    }

    @Before
    public void setUp() {}
    @After
    public void tearDown() {}



    /**
     * Test of createNew_Descriptor method, of class CommandEncoder_Descriptor.
     */
    @Test
    public void _01_createUpdateLog_Test() throws Exception {
        System.out.println("createNew_Descriptor");


        SchemaInfo_Descriptor formSelector_SchemaInfo = maintests.samples.WEB$__$FORM.schema.getChild_SchemaInfoDescriptor(executeInfo,
            AppSymbols_DescTag.maintests$__$samples$_CC_$WEB$__$FORM$_CC_$FORM$__$SELECTOR);
        SchemaInfo_Descriptor option_SchemaInfo = formSelector_SchemaInfo.getChild_SchemaInfoDescriptor(executeInfo,
            AppSymbols_DescTag.maintests$__$samples$_CC_$WEB$__$FORM$_CC_$OPTION);




        Integer_Mutable createdDesc_logVarName_OUT = new Integer_Mutable();

        List<String> labelParts = Arrays.asList("my", "formSelector");
        Label label = symbolControl.multiPartSymbol_Factory.createNew_Label(labelParts, 1, false);
        MatrixSet<SchemaInfo_Schema> uses_SchemaSet = null;
        Descriptor parentDescriptor = testMatrix_Original;


        Descriptor newDesc = null;

        // for testing purposes: if you want to write out just the add, use this line of code
        //newDesc = matrixControl.matrixFactory.createNew_Descriptor(executeInfo, formSelector_SchemaInfo, label, null, parentDescriptor, 111);

        newDesc = commandEncoder_Desc.createNew_Descriptor(executeInfo, createdDesc_logVarName_OUT, formSelector_SchemaInfo,
                label, uses_SchemaSet, parentDescriptor);
 
 
        assertNotNull(newDesc);


        commandEncoder_Desc.addDescriptor(executeInfo, testMatrix_Original, newDesc);




        System.out.println("setField values");

        String newFieldValue = "*** TEST PATH from _01_createUpdateLog_Test ***";

        Descriptor formReq_Desc = testMatrix_Original.get_ChildDescriptor(executeInfo, AppSymbols_Label.First$32$Name)
                .get_ChildDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED);

        //  create a TEST version of the persistManagerClient, passing in the update log and cmd encoders. You never does this in real code, you
        //  let the persistManagerClient create them
        PersistentMatricesManager_Client persistManagerClient = new PersistentMatricesManager_Client(updateLog_Writer, commandEncoder, commandEncoder_Desc);
        PersistenceWrapper_FieldSet fieldSet_PersistWrapper = new PersistenceWrapper_FieldSet(executeInfo, formReq_Desc.get_FieldSet(), persistManagerClient);

        fieldSet_PersistWrapper.setField(executeInfo, 1, newFieldValue);

        assertEquals(formReq_Desc.get_FieldSet().getField(executeInfo, 1), newFieldValue);

    }



}