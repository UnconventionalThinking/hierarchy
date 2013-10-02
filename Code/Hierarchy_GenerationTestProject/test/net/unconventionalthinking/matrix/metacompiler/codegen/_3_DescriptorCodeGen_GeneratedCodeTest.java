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

package net.unconventionalthinking.matrix.metacompiler.codegen;


import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.lang.Pair;
import net.unconventionalthinking.matrix.AnnotationParameters;
import net.unconventionalthinking.matrix.AnnotationParameters_AccessReturnType_OutParam;
import net.unconventionalthinking.matrix.TestCode__Annotations;
import net.unconventionalthinking.matrix.WEB$__$FORM;
import net.unconventionalthinking.matrix.AppControl;
import net.unconventionalthinking.matrix.AppControl_Base;
import net.unconventionalthinking.matrix.AppSymbols;
import net.unconventionalthinking.matrix.AppSymbols_DescTag;
import net.unconventionalthinking.matrix.AppSymbols_DescTagName;
import net.unconventionalthinking.matrix.Descriptor;

import net.unconventionalthinking.matrix.TestCode__MatrixWorker;
import net.unconventionalthinking.matrix.FieldSet;
import net.unconventionalthinking.matrix.FieldSet_Tuple;
import net.unconventionalthinking.matrix.Matrix;

///*
import net.unconventionalthinking.matrix.MyMatrix1;
import net.unconventionalthinking.matrix.MyMatrix2;
//*/
import net.unconventionalthinking.matrix.SchemaInfo_Descriptor;
import net.unconventionalthinking.matrix.SchemaInfo_FieldSet;
import net.unconventionalthinking.matrix.MatrixSet;
import net.unconventionalthinking.matrix.TestUtilities_1_SchemaTester;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.matrix.symbols.Symbol_Base;
import java.util.ArrayList;
import java.util.List;
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
public class _3_DescriptorCodeGen_GeneratedCodeTest implements TestCode__Annotations {


    ExecutionInfo executeInfo = new ExecutionInfo();

    

    public _3_DescriptorCodeGen_GeneratedCodeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void testConstuctedMatrices() throws Exception {

        // Build Matrices by initializing the appcontrol by accessing it.
        AppControl_Base appControl = AppControl.initializeApp();


        //  Test the schema
        TestUtilities_1_SchemaTester schemaTester = new TestUtilities_1_SchemaTester();
        schemaTester.testSchema_FirstPart(WEB$__$FORM.schema, executeInfo, appControl.symbolControl);

               

        /*
            //  MyMatrix1
            MATRIX USES (WEB.FORM, TEST.SCHEMA) {

                FORM.REQUIRED: { IsRequired, "/images/required.jpg", 6, DEFAULT}
                    TEST.CHILD: { 111, "Test String" }
            }
        */
///*
        testMatrix("MyMatrix1", MyMatrix1.matrix, true, false, 4, executeInfo, appControl.symbolControl);
        testMatrix1Access_Static();
        testMatrix1Access_Dyn();
        testMatrix("MyMatrix2", MyMatrix2.matrix, false, true, 4, executeInfo, appControl.symbolControl);
        testMatrix2Access_Static();
        testMatrix2Access_Dyn();

//*/
    }


    private void testMatrix(String matrixName, Matrix matrix, boolean uses_SpecializedFieldSets, boolean uses_ParameterMap, int numFormRequiredValues, 
            ExecutionInfo executeInfo, SymbolControl symbolControl) throws Exception {

        assertEquals("MATRIX", matrix.get_DescTagName().getTagName());
        assertEquals("`" + matrixName + "`", matrix.get_Label().getLabel_Simple());
        assertEquals(null, matrix.get_ParentDescriptor());

        //  Test FORM.REQUIRED _________________________________________________________________________________________
        List<String> symbolStrings = new ArrayList<String>();
        symbolStrings.add("FORM");
        symbolStrings.add("REQUIRED");

        DescriptorTagName  formRequired_DescTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, 1, false);

        Descriptor formRequired_desc = matrix.get_ChildDescriptor(executeInfo, formRequired_DescTagName);
        assertEquals(formRequired_DescTagName, formRequired_desc.get_DescTagName());
        assertEquals(matrix, formRequired_desc.get_ParentDescriptor());

        //  Test the item's schemaInfo. (which is found at: SCHEMA `WEB`.`FORM`->DESCRIPTOR `FORM`.`REQUIRED`)
        SchemaInfo_Descriptor schemaInfoDesc_for_FormRequired = (SchemaInfo_Descriptor)formRequired_desc.getSchemaInfo();
        assertEquals(true, schemaInfoDesc_for_FormRequired.getSchemaInfo_canHave_FieldSet());
        assertEquals("FORM.REQUIRED", schemaInfoDesc_for_FormRequired.getSchemaInfo_DescriptorTagName().getTagName());


        FieldSet formRequired_FieldSet = null;
        if (!uses_ParameterMap)
            formRequired_FieldSet = formRequired_desc.get_FieldSet_Tuple(executeInfo);
        else
            formRequired_FieldSet = formRequired_desc.get_FieldSet_ParameterMap(executeInfo);
        
        //  Test the fieldSet
        assertEquals(uses_SpecializedFieldSets, formRequired_FieldSet.is_SpecializedFieldSet());
        if (uses_ParameterMap)
            assertTrue(formRequired_FieldSet.is_ParameterMap());
        else
            assertTrue(formRequired_FieldSet.is_Tuple());


        assertEquals(numFormRequiredValues, formRequired_FieldSet.size_NonContinuationFields());
        assertEquals(numFormRequiredValues, formRequired_FieldSet.size());
        assertEquals(symbolControl.appSymbolsIndex.getSingleSymbol_ByName("IsRequired"), formRequired_FieldSet.getField_Symbol(executeInfo, 0));
        assertEquals("/images/required.jpg", formRequired_FieldSet.getField_String(executeInfo, 1));  // default value by index
        assertEquals(6, formRequired_FieldSet.getField_int(executeInfo, 2));  // default value by index

        if(!uses_ParameterMap)
            assertEquals(-1, formRequired_FieldSet.getField_int(executeInfo, 3));  // default value by index
        else
            assertEquals(null, formRequired_FieldSet.getField(executeInfo, 3));  // default value by index

        //  Test the schemaInfo FieldSet
        SchemaInfo_FieldSet schemaInfoFieldSet_for_FormRequired = schemaInfoDesc_for_FormRequired.get_SchemaInfoFieldSet(executeInfo);
        assertEquals(4, schemaInfoFieldSet_for_FormRequired.getNum_NonContinuationFields());
        assertEquals(4, schemaInfoFieldSet_for_FormRequired.getNum_AllFields());
        assertEquals(false, schemaInfoFieldSet_for_FormRequired.hasContinuationField());






        //  Test TEST.CHILD _________________________________________________________________________________________
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("TEST");
        symbolStrings.add("CHILD");

        DescriptorTagName testChild_DescTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, 1, false);

        Descriptor testChild_desc = formRequired_desc.get_ChildDescriptor(executeInfo, testChild_DescTagName);
        assertEquals(testChild_DescTagName, testChild_desc.get_DescTagName());
        assertEquals(formRequired_desc, testChild_desc.get_ParentDescriptor());

        //  Test the item's schemaInfo. (which is found at: SCHEMA `WEB`.`FORM`->DESCRIPTOR `FORM`.`REQUIRED`->DESCRIPTOR `TEST`.`CHILD`)
        SchemaInfo_Descriptor schemaInfoDesc_for_TestChild = (SchemaInfo_Descriptor)testChild_desc.getSchemaInfo();
        assertEquals(true, schemaInfoDesc_for_TestChild.getSchemaInfo_canHave_FieldSet());
        assertEquals("TEST.CHILD", schemaInfoDesc_for_TestChild.getSchemaInfo_DescriptorTagName().getTagName());


        FieldSet testChild_FieldSet = null;
        if (!uses_ParameterMap)
            testChild_FieldSet = testChild_desc.get_FieldSet_Tuple(executeInfo);
        else
            testChild_FieldSet = testChild_desc.get_FieldSet_ParameterMap(executeInfo);

        //  Test the fieldSet
        assertEquals(false, testChild_FieldSet.is_SpecializedFieldSet());
        if (uses_ParameterMap)
            assertTrue(testChild_FieldSet.is_ParameterMap());
        else
            assertTrue(testChild_FieldSet.is_Tuple());


        assertEquals(2, testChild_FieldSet.size_NonContinuationFields());
        assertEquals(2, testChild_FieldSet.size());
        
        assertEquals(111, testChild_FieldSet.getField_int(executeInfo, 0));
        assertEquals("Test String", testChild_FieldSet.getField_String(executeInfo, 1));  // default value by index


        //  Test the schemaInfo FieldSet
        SchemaInfo_FieldSet schemaInfoFieldSet_for_TestChild = schemaInfoDesc_for_TestChild.get_SchemaInfoFieldSet(executeInfo);
        assertEquals(2, schemaInfoFieldSet_for_TestChild.getNum_NonContinuationFields());
        assertEquals(2, schemaInfoFieldSet_for_TestChild.getNum_AllFields());
        assertEquals(false, schemaInfoFieldSet_for_TestChild.hasContinuationField());


    }

///*


    private void testMatrix1Access_Static() throws Exception {
        //  desc access test
        //  *** access code generated from output of DescriptorAccess_CodeGenerator!! (copy & pasted in)
        Descriptor testChildDesc = TestCode__MatrixWorker.accessMatrix_MyMatrix1__0(executeInfo, this);
        assertEquals(AppSymbols_DescTagName.TEST$__$CHILD, testChildDesc.get_DescTagName());

        //  field access test
        //  *** access code generated from output of DescriptorAccess_CodeGenerator!! (copy & pasted in)
        int testValue = TestCode__MatrixWorker.accessMatrix_MyMatrix1__1(executeInfo, this);
        assertEquals(111, testValue);

        
        //  field continuation access test
        //  *** access code generated from output of DescriptorAccess_CodeGenerator!! (copy & pasted in)
        int testContValue = TestCode__MatrixWorker.accessMatrix_MyMatrix1__2(executeInfo, this, 2);
        assertEquals(2, testContValue);


        //  Continued access, field access test
        //  *** access code generated from output of DescriptorAccess_CodeGenerator!! (copy & pasted in)
        Symbol isRequired = TestCode__MatrixWorker.accessMatrix___3(executeInfo, testChildDesc, this);
        assertTrue(AppSymbols.NotRequired == isRequired);


    }


    private void testMatrix1Access_Dyn() throws Exception {

        // *** access code generated from output of DescriptorAccess_CodeGenerator!! (copy & pasted in)
        Descriptor testChildDesc = TestCode__MatrixWorker.accessMatrix_MyMatrix1__4(executeInfo, net.unconventionalthinking.matrix.MyMatrix1.matrix, this,
                AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED,
                AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$TEST$__$CHILD);

        assertEquals(AppSymbols_DescTagName.TEST$__$CHILD, testChildDesc.get_DescTagName());

        //  field access test - field 1
        //  *** access code generated from output of DescriptorAccess_CodeGenerator!! (copy & pasted in)
        Integer testValue = (Integer)TestCode__MatrixWorker.accessMatrix_MyMatrix1__5(executeInfo, net.unconventionalthinking.matrix.MyMatrix1.matrix, this,
                AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED,
                AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$TEST$__$CHILD, AppSymbols_DescTagName.Field1int);

        assertEquals(111, testValue.intValue());


        //  field access test - field 2 - continuation
        //  *** access code generated from output of DescriptorAccess_CodeGenerator!! (copy & pasted in)
        Integer testContValue = (Integer)TestCode__MatrixWorker.accessMatrix_MyMatrix1__6(executeInfo, net.unconventionalthinking.matrix.MyMatrix1.matrix, this,
                AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$TEST$__$CONT, AppSymbols_DescTagName.field2ContInt, 2);
        assertEquals(2, testContValue.intValue());


        //  Continued access, field access test
        //  *** access code generated from output of DescriptorAccess_CodeGenerator!! (copy & pasted in)
        Symbol isRequired = (Symbol)TestCode__MatrixWorker.accessMatrix___7(executeInfo, testChildDesc, this,
                AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED, AppSymbols_DescTagName.IsRequired);
        assertTrue(AppSymbols.NotRequired == isRequired);




        //  multi access test - descriptor set
        MatrixSet<Descriptor> resultDescriptorSet = TestCode__MatrixWorker.accessMatrix_MyMatrix1__8(executeInfo,
                net.unconventionalthinking.matrix.MyMatrix1.matrix, this,
                AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED,
                AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$TEST$__$CHILD);

        assertEquals(1, resultDescriptorSet.size());
        assertEquals(AppSymbols_DescTagName.TEST$__$CHILD, ((Descriptor)resultDescriptorSet.get(0)).get_DescTagName()  );

        //  multi access test - field set
        MatrixSet<Object> resultFieldValueSet = TestCode__MatrixWorker.accessMatrix_MyMatrix1__9(executeInfo,
                net.unconventionalthinking.matrix.MyMatrix1.matrix, this,
                AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED,
                AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$TEST$__$CHILD, AppSymbols_DescTagName.Field1int);
        assertEquals(1, resultFieldValueSet.size());
        assertEquals(111, resultFieldValueSet.get(0));


    }



    private void testMatrix2Access_Static() throws Exception {

        // *** access code generated from output of DescriptorAccess_CodeGenerator!! (copy & pasted in)
        Descriptor testChild = TestCode__MatrixWorker.accessMatrix_MyMatrix2__10(executeInfo, this);

        assertEquals(AppSymbols_DescTagName.TEST$__$CHILD, testChild.get_DescTagName());

        //  field access test
        //  *** access code generated from output of DescriptorAccess_CodeGenerator!! (copy & pasted in)
        int testValue = TestCode__MatrixWorker.accessMatrix_MyMatrix2__11(executeInfo, this);
        assertEquals(111, testValue);

    }


    private void testMatrix2Access_Dyn() throws Exception {

        // *** access code generated from output of DescriptorAccess_CodeGenerator!! (copy & pasted in)
        Descriptor testChild = TestCode__MatrixWorker.accessMatrix_MyMatrix2__12(executeInfo, net.unconventionalthinking.matrix.MyMatrix2.matrix, this,
                AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED,
                AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$TEST$__$CHILD);

        assertEquals(AppSymbols_DescTagName.TEST$__$CHILD, testChild.get_DescTagName());
        

        //  field access test - field 2 - continuation
        //  *** access code generated from output of DescriptorAccess_CodeGenerator!! (copy & pasted in)
        Integer testValue = (Integer)TestCode__MatrixWorker.accessMatrix_MyMatrix2__13(executeInfo, net.unconventionalthinking.matrix.MyMatrix2.matrix, this,
                AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED,
                AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$TEST$__$CHILD, AppSymbols_DescTagName.Field1int);

        assertEquals(111, testValue.intValue());



        //  multi access test - descriptor set
        MatrixSet<Descriptor> resultDescriptorSet = TestCode__MatrixWorker.accessMatrix_MyMatrix2__14(executeInfo, net.unconventionalthinking.matrix.MyMatrix2.matrix, this,
                AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED,
                AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$TEST$__$CHILD);
        assertEquals(1, resultDescriptorSet.size());
        assertEquals(AppSymbols_DescTagName.TEST$__$CHILD, ((Descriptor)resultDescriptorSet.get(0)).get_DescTagName()  );

        //  multi access test - field set
        MatrixSet<Object> resultFieldValueSet = TestCode__MatrixWorker.accessMatrix_MyMatrix2__15(executeInfo, net.unconventionalthinking.matrix.MyMatrix2.matrix, this,
                AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED,
                AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$TEST$__$CHILD, AppSymbols_DescTagName.Field1int);
        assertEquals(1, resultFieldValueSet.size());
        assertEquals(111, resultFieldValueSet.get(0));


    }


//*/
public Object annotationHandler_0(ExecutionInfo executeInfo, boolean annotationReference_Exists, Symbol annotationRef_Base, int annotationRef_AccessCounter,
		int childAccessIndex, AnnotationParameters.AccessType accessType, AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam,
		Descriptor rootAccessDescriptor, Descriptor currAccessors_ParentDescriptor, net.unconventionalthinking.matrix.MatrixSet<Descriptor> currAccessors_ParentDescriptorSet,
		boolean passingInException, Exception e, Pair<Object, Object>... childAccessor_Pairs) {

            // do nothing
            return null;

    }

}