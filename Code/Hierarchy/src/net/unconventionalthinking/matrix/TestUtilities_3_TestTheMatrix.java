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

package net.unconventionalthinking.matrix;

import net.unconventionalthinking.lang.ExecutionInfo;
import java.util.*;

import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.matrix.Descriptor.DescriptorIndex_Type;
import net.unconventionalthinking.matrix.FieldSet.Type;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.MPSymbols_DescTag;
import net.unconventionalthinking.matrix.symbols.MPSymbols_DescTagName;
import net.unconventionalthinking.matrix.symbols.MatrixName;
import static org.junit.Assert.*;



/**
 * The purpose of this class is to let us test matrix functionality in two places, the Hierarchy project, when we are doing 
 * the testing of the matrix / descriptor objects and the _general_ fieldset objects,
 * and in the TestGenerationProject, when we test the _specialized_ fieldset tuples that are generated.
 *
 * *** Very Annoying - this class actually contains junit asserts, and since the class is currently in the Hierarchy main project,
 * the project must include the Junit.jar in the class path. remove this if you can.
 *
 * @author peterjoh
 */
public class TestUtilities_3_TestTheMatrix {

    // we don't need the real thing right now. just a tester object to do testing with.
    private AppControl_Base appControl_MockObj;
    
    private ExecutionInfo executeInfo;
    private SchemaControl schemaControl;
    private MatrixControl matrixControl;
    private SymbolControl symbolControl;
    private TestUtilities_2_Matrix matrix_Utilities;

    private SchemaInfo_Schema webForm_Schema;

    public Matrix registrationForm_Matrix;





    public TestUtilities_3_TestTheMatrix() throws Exception {
        appControl_MockObj = new AppControl_Simple();
        executeInfo = new ExecutionInfo();
        symbolControl = new SymbolControl();
        symbolControl.intialize_All_MPSymbols();
        
        appControl_MockObj.executionInfo = executeInfo;
        appControl_MockObj.symbolControl = symbolControl;
        
        schemaControl = new SchemaControl(executeInfo, appControl_MockObj);
        matrixControl = new MatrixControl(appControl_MockObj);


        matrix_Utilities = new TestUtilities_2_Matrix(executeInfo, schemaControl, matrixControl, symbolControl);
    }

    public TestUtilities_3_TestTheMatrix(ExecutionInfo executeInfo, SymbolControl symbolControl, SchemaControl schemaControl,
            MatrixControl matrixControl) throws Exception {
        appControl_MockObj = new AppControl_Simple();
        this.executeInfo = executeInfo;
        this.symbolControl = symbolControl;
        this.schemaControl = schemaControl;
        this.matrixControl = matrixControl;


        appControl_MockObj.executionInfo = executeInfo;
        appControl_MockObj.symbolControl = symbolControl;
        appControl_MockObj.schemaControl = schemaControl;
        appControl_MockObj.matrixControl = matrixControl;
        
        matrix_Utilities = new TestUtilities_2_Matrix(executeInfo, schemaControl, matrixControl, symbolControl);
    }



    public Matrix createTestMatrix() throws Exception {
        registrationForm_Matrix = matrix_Utilities.buildTestMatrix(MPSymbols_DescTagName.net$__$unconventionalthinking$__$matrix$__$schema.get_Name_no_backtiks());
        return registrationForm_Matrix;
    }

    public void createAndTestMatrix(boolean uses_SpecializedFieldSets) throws Exception {
        System.out.println("createAndTestMatrix");


        registrationForm_Matrix = matrix_Utilities.buildTestMatrix(MPSymbols_DescTagName.net$__$unconventionalthinking$__$matrix$__$schema.get_Name_no_backtiks());

        String expResult = "";

        String regForm_PrintOut = registrationForm_Matrix.printMatrix(true).toString();


        MatrixName webForm_SchemaName = matrix_Utilities.testWebFormSchema.getSchemaInfo_SchemaNameFull();

/*
MATRIX `RegistrationForm`
	`First Name`
		FORM.REQUIRED: {  IsRequired, "Test Path", 11  }
	`State`
		FORM.REQUIRED: {  NotRequired  }
		FORM.SELECT: {  stateSelector, mouseOverMethod();  }
			OPTION: {  default, - Select -, Selected  }
			OPTION: {  AL, AL  }
			OPTION: {  AZ, AZ  }
*/



        assertEquals("MATRIX", registrationForm_Matrix.descTagName.getTagName());
        assertEquals("`RegistrationForm`", registrationForm_Matrix.label.getLabel_Simple());
        assertEquals(MPSymbols_DescTagName.net$__$unconventionalthinking$__$matrix$__$schema.get_Name_no_backtiks() + "::RegistrationForm",
                registrationForm_Matrix.getMatrixName().get_Name_no_backtiks());
        assertEquals(null, registrationForm_Matrix.parentDescriptor);


        MatrixName matrixName = registrationForm_Matrix.getMatrixName();

        
        //  Test get_ChildDescriptor(Label label);
        String tagName = "ITEM";
        Label name_Label = symbolControl.singleSymbol_Factory.createNew_Label("First Name", false);
        Descriptor itemFirstName = registrationForm_Matrix.get_ChildDescriptor(executeInfo, name_Label);
        assertEquals(tagName, itemFirstName.descTagName.getTagName());
        assertEquals(name_Label.getSymbol().name, itemFirstName.label.getSymbol().name);
        assertEquals(registrationForm_Matrix, itemFirstName.parentDescriptor);

        //  Test the item's schemaInfo. (which is found at: MATRIX `RegistrationForm`'s SchemaInfo_Descriptor -> ITEM schemaInfo_Descriptor
        SchemaInfo_Descriptor schemaInfoDesc_for_Item = (SchemaInfo_Descriptor)itemFirstName.schemaInfo_Positioned;
        assertEquals(false, schemaInfoDesc_for_Item.getSchemaInfo_canHave_FieldSet()); // later, this will be true when the item fieldset parameter map is defined
        assertEquals("ITEM", schemaInfoDesc_for_Item.getSchemaInfo_DescriptorTag().getDescTagName().getTagName());
        assertEquals(MPSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM,
                schemaInfoDesc_for_Item.getSchemaInfo_DescriptorTag());



        //  `FORM`.`REQUIRED`___________________________________________________________________________________________

        //  Test get_ChildDescriptor(DescTagName descTagName);
        List<String> symbolStrings = new ArrayList<String>();
        symbolStrings.add("FORM");
        symbolStrings.add("REQUIRED");

        DescriptorTagName formRequired_DescTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, 1, false);
        Descriptor formRequired_desc = itemFirstName.get_ChildDescriptor(executeInfo, formRequired_DescTagName);
        assertEquals(formRequired_DescTagName, formRequired_desc.descTagName);
        assertEquals(webForm_SchemaName, formRequired_desc.descTag.getSchemaName_Full());
        assertEquals(itemFirstName, formRequired_desc.parentDescriptor);

        //  Test the item's schemaInfo. (which is found at: SCHEMA `WEB`.`FORM`->DESCRIPTOR `FORM`.`REQUIRED`)
        SchemaInfo_Descriptor schemaInfoDesc_for_FormRequired = (SchemaInfo_Descriptor)formRequired_desc.schemaInfo_Positioned;
        assertEquals(true, schemaInfoDesc_for_FormRequired.getSchemaInfo_canHave_FieldSet());
        assertEquals("FORM.REQUIRED", schemaInfoDesc_for_FormRequired.getSchemaInfo_DescriptorTag().getDescTagName().getTagName());


        FieldSet_Tuple formRequired_FieldSet = formRequired_desc.get_FieldSet_Tuple(executeInfo);
        //  Test the fieldSet
        assertEquals(uses_SpecializedFieldSets, formRequired_FieldSet.is_SpecializedFieldSet());

        assertEquals(3, formRequired_FieldSet.size_NonContinuationFields());
        assertEquals(3, formRequired_FieldSet.size());
        assertEquals(symbolControl.appSymbolsIndex.getSingleSymbol_ByName("IsRequired"), formRequired_FieldSet.getField_Symbol(executeInfo, 0));
        assertEquals("Test Path", formRequired_FieldSet.getField_String(executeInfo, 1));
        assertEquals(11, formRequired_FieldSet.getField_int(executeInfo, 2));
        assertEquals(7, formRequired_FieldSet.getField_int(executeInfo, 3));  // default value by index
        //  Test the schemaInfo FieldSet
        SchemaInfo_FieldSet schemaInfoFieldSet_for_FormRequired = schemaInfoDesc_for_FormRequired.get_SchemaInfoFieldSet(executeInfo);
        assertEquals(4, schemaInfoFieldSet_for_FormRequired.num_NonContinuationFields);
        assertEquals(4, schemaInfoFieldSet_for_FormRequired.num_AllFields);
        assertEquals(false, schemaInfoFieldSet_for_FormRequired.hasContinuationField());



        //  ITEM `State` ______________________________________________________________________________________________

        //  Test get_ChildDescriptor(Label label);
        tagName = "ITEM";
        Label state_Label = symbolControl.singleSymbol_Factory.createNew_Label("State", false);
        Descriptor itemState = registrationForm_Matrix.get_ChildDescriptor(executeInfo,
                state_Label);
        assertEquals(tagName, itemState.descTagName.getTagName());
        assertEquals(state_Label.getSymbol().name, itemState.label.getSymbol().name);
        assertEquals(registrationForm_Matrix, itemState.parentDescriptor);



        //  FORM.REQUIRED ______________________________________________________________________________________________

        //  Test get_ChildDescriptor(DescTagName descTagName);
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("FORM");
        symbolStrings.add("REQUIRED");

        formRequired_DescTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, 1, false);
        formRequired_desc = itemState.get_ChildDescriptor(executeInfo, formRequired_DescTagName);
        assertEquals(formRequired_DescTagName, formRequired_desc.descTagName);
        assertEquals(itemState, formRequired_desc.parentDescriptor);


        formRequired_FieldSet = formRequired_desc.get_FieldSet_Tuple(executeInfo);
        //  Test the fieldSet
        assertEquals(uses_SpecializedFieldSets, formRequired_FieldSet.is_SpecializedFieldSet());

        assertEquals(symbolControl.appSymbolsIndex.getSingleSymbol_ByName("NotRequired"), 
                formRequired_FieldSet.getField_Symbol(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.getSingleSymbol_ByName("IsRequired")));
        assertEquals("/images/required.gif", formRequired_FieldSet.getField_String(executeInfo, 
                (DescriptorTagName)symbolControl.descTagNames_Index.getSingleSymbol_ByName("RequiredImagePath")));
        assertEquals(6, formRequired_FieldSet.getField_int(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.getSingleSymbol_ByName("ImageHeight"))); // default Value by fieldname
        assertEquals(7, formRequired_FieldSet.getField_int(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.getSingleSymbol_ByName("ImageWidth")));  // default value by fieldname



        //  FORM.SELECT ________________________________________________________________________________________________
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("FORM");
        symbolStrings.add("SELECT");

        DescriptorTagName formSelect_DescTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, 1, false);
        Descriptor formSelect_Desc = itemState.get_ChildDescriptor(executeInfo, formSelect_DescTagName);
        assertEquals(formSelect_DescTagName, formSelect_Desc.descTagName);
        assertEquals(webForm_SchemaName, formRequired_desc.descTag.getSchemaName_Full());
        assertEquals(itemState, formSelect_Desc.parentDescriptor);

        //  Test the item's schemaInfo. (which is found at: SCHEMA `WEB`.`FORM`->DESCRIPTOR `FORM`.`SELECT`)
        SchemaInfo_Descriptor schemaInfoDesc_for_FormSelect = (SchemaInfo_Descriptor)formSelect_Desc.schemaInfo_Positioned;
        assertEquals(true, schemaInfoDesc_for_FormSelect.getSchemaInfo_canHave_FieldSet());
        assertEquals("FORM.SELECT", schemaInfoDesc_for_FormSelect.getSchemaInfo_DescriptorTag().getDescTagName().getTagName());

        FieldSet_Tuple formSelect_FieldSet = formSelect_Desc.get_FieldSet_Tuple(executeInfo);
        //  Test the fieldSet
        assertEquals("stateSelector", formSelect_FieldSet.getField_String(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.getSingleSymbol_ByName("Name")));
        assertEquals("mouseOverMethod();", formSelect_FieldSet.getField_String(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.getSingleSymbol_ByName("onChange")));
        //  Test the schemaInfo FieldSet
        SchemaInfo_FieldSet schemaInfoFieldSet_for_FormSelect = schemaInfoDesc_for_FormSelect.get_SchemaInfoFieldSet(executeInfo);
        assertEquals(2, schemaInfoFieldSet_for_FormSelect.num_NonContinuationFields);
        assertEquals(2, schemaInfoFieldSet_for_FormSelect.num_AllFields);
        assertEquals(false, schemaInfoFieldSet_for_FormSelect.hasContinuationField());




        //  Test the MatrixSet<Descriptors> get_ChildDescriptors(DescriptorTagName) - returns a set of descriptors
        String option_tagName = "OPTION";
        DescriptorTagName option_DescTagName = symbolControl.singleSymbol_Factory.createNew_DescTagName(option_tagName, false);
        MatrixSet<Descriptor> optionDescriptors = formSelect_Desc.get_ChildDescriptors(executeInfo, option_DescTagName);



        assertTrue(optionDescriptors.size() > 0);

        for (int i = 0; i <  optionDescriptors.size(); ++i) {

            Descriptor optionDesc = optionDescriptors.get(i);

            assertEquals(option_tagName, optionDesc.descTagName.getTagName());
            assertEquals(webForm_SchemaName, formRequired_desc.descTag.getSchemaName_Full());
            assertEquals(formSelect_Desc, optionDesc.parentDescriptor);

            //  Test the item's schemaInfo. (which is found at: SCHEMA `WEB`.`FORM`->DESCRIPTOR `FORM`.`REQUIRED`)
            SchemaInfo_Descriptor schemaInfoDesc_for_Option = (SchemaInfo_Descriptor)optionDesc.schemaInfo_Positioned;
            assertEquals(true, schemaInfoDesc_for_Option.getSchemaInfo_canHave_FieldSet());
            assertEquals("OPTION", schemaInfoDesc_for_Option.getSchemaInfo_DescriptorTag().getDescTagName().getTagName());


            //  Get full path tests
            List<DescriptorTagName> fullPath_DescTagName = new ArrayList<DescriptorTagName>();
            List<Label> fullPath_Label = new ArrayList<Label>();
            optionDesc.getFullPath(executeInfo, fullPath_DescTagName, fullPath_Label);


            assertEquals("MATRIX", fullPath_DescTagName.get(0).getTagName());
            assertEquals("ITEM", fullPath_DescTagName.get(1).getTagName());
            assertEquals(state_Label, fullPath_Label.get(1));
            assertEquals(formSelect_Desc.descTagName, fullPath_DescTagName.get(2));
            assertEquals(option_DescTagName, fullPath_DescTagName.get(3));


            List<Descriptor> fullPath_Desc = new ArrayList<Descriptor>();
            optionDesc.getFullPath_Desc(executeInfo, fullPath_Desc);

            assertEquals(registrationForm_Matrix, fullPath_Desc.get(0));
            assertEquals(itemState, fullPath_Desc.get(1));
            assertEquals(formSelect_Desc, fullPath_Desc.get(2));
            assertEquals(optionDesc, fullPath_Desc.get(3));



            FieldSet_Tuple option_FieldSet = optionDesc.get_FieldSet_Tuple(executeInfo);

            //  Test the schemaInfo FieldSet
            SchemaInfo_FieldSet schemaInfoFieldSet_for_Option = schemaInfoDesc_for_Option.get_SchemaInfoFieldSet(executeInfo);
            assertEquals(3, schemaInfoFieldSet_for_Option.num_NonContinuationFields);
            assertEquals(3, schemaInfoFieldSet_for_Option.num_AllFields);
            assertEquals(false, schemaInfoFieldSet_for_Option.hasContinuationField());


            if (i == 0) {
                //  Test the fieldSet
                assertEquals("default", option_FieldSet.getField_String(executeInfo, 0));
                assertEquals("- Select -", option_FieldSet.getField_String(executeInfo, 1));
                assertEquals("Selected", option_FieldSet.getField_Symbol(executeInfo, 2).name);

            } else if (i == 1) {
                //  Test the fieldSet
                assertEquals("AL", option_FieldSet.getField_String(executeInfo, 0));
                assertEquals("AL", option_FieldSet.getField_String(executeInfo, 1));
                //  default value by index
                assertEquals(symbolControl.appSymbolsIndex.getSingleSymbol_ByName("NotSelected"), option_FieldSet.getField_Symbol(executeInfo, 2));

            } else if (i == 2) {
                //  Test the fieldSet
                assertEquals("AZ", option_FieldSet.getField_String(executeInfo, 0));
                assertEquals("AZ", option_FieldSet.getField_String(executeInfo, 1));
                //  default value by fieldname
                assertEquals(symbolControl.appSymbolsIndex.getSingleSymbol_ByName("NotSelected"), 
                    option_FieldSet.getField_Symbol(executeInfo, (DescriptorTagName)symbolControl.descTagNames_Index.getSingleSymbol_ByName("Selected")) );
            }


        }

    }

}
