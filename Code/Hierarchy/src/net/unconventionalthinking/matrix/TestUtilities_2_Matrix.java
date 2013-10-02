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

import net.unconventionalthinking.matrix.*;
import net.unconventionalthinking.lang.ExecutionInfo;
import java.util.*;
import net.unconventionalthinking.exceptions.*;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.hierarchy.SchemaSet_ScopeStack;


/**
 *
 * @author peterjoh
 */
public class TestUtilities_2_Matrix {




    ExecutionInfo       executeInfo;
    SchemaControl       schemaControl;
    SymbolControl       symbolControl;
    MatrixControl       matrixControl;

    SchemaForSchema_Container   schemaForSchema_Container;
    SchemaInfo_Schema   schemaForSchema;


    SchemaInfo_Schema   testWebFormSchema;
    Matrix              testRegistrationMatrix;

    DescriptorTagName   formSelect_DescTagName;




    public TestUtilities_2_Matrix(ExecutionInfo executeInfo, SchemaControl schemaControl, MatrixControl matrixControl, SymbolControl symbolControl)
            throws Exception_SchemaInfo, Exception_Descriptor, Exception_InvalidArgumentPassed, Exception_MultiPartSymbolAccess,
            Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolCreationOrAccess {

        this.executeInfo = executeInfo;
        this.schemaControl = schemaControl;
        this.matrixControl = matrixControl;
        this.symbolControl = symbolControl;

        schemaForSchema = schemaControl.schemaForSchema;
        schemaForSchema_Container = schemaControl.schemaForSchema_Container;


        TestUtilities_1_Schema testUtilities_Schema = new TestUtilities_1_Schema(executeInfo, schemaControl, symbolControl);
        testUtilities_Schema.set_SchemaPackage(MPSymbols_DescTagName.net$__$unconventionalthinking$__$matrix$__$schema);
        testWebFormSchema = testUtilities_Schema.buildTestSchema(0);

    }

    public Matrix buildTestMatrix(String matrixPackageName)
            throws Exception_Descriptor, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreation,
            Exception_MultiPartSymbolCreationOrAccess, Exception_SchemaInfo, Exception_InvalidArgumentPassed_Null,
            Exception_InvalidArgumentPassed {


        DescriptorTagName matrixPackageName_DescTag = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(matrixPackageName, 1, true, null, null);


        MatrixName matrixName = null;

        //  Build SchemaSet
        MatrixSet<SchemaInfo_Schema> matrix_Uses_SchemaSet = new MatrixSet<SchemaInfo_Schema>();
        matrix_Uses_SchemaSet.add(testWebFormSchema);

        //  Create scope stack
        SchemaSet_ScopeStack schemaSet_ScopeStack = new SchemaSet_ScopeStack(executeInfo, schemaControl);
        schemaSet_ScopeStack.stack.add(new MatrixSet<SchemaInfo_Schema>().add(schemaControl.schemaFactory.get_BaseSchema(executeInfo)));
        schemaSet_ScopeStack.stack.add(matrix_Uses_SchemaSet);

        List<String> symbolStrings = new ArrayList<String>();



        //  Create registration form matrix
        Label registrationForm_Label = symbolControl.singleSymbol_Factory.createNew_Label("RegistrationForm", false);
        testRegistrationMatrix =  matrixControl.matrixFactory.createNew_Matrix(executeInfo, registrationForm_Label, matrixPackageName_DescTag,
                true, matrix_Uses_SchemaSet, testRegistrationMatrix);

        matrixName = testRegistrationMatrix.matrixName;





        Label firstName_Label = symbolControl.singleSymbol_Factory.createNew_Label("First Name", false);
        SchemaInfo_Descriptor item_SchemaInfoDesc = SchemaInfoUtilities.find_SchemaInfoDescriptor_in_Stack(executeInfo,
                MPSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM,
                testRegistrationMatrix.schemaInfo_Positioned, schemaSet_ScopeStack);
        Descriptor itemFirstName_Desc = new Descriptor(executeInfo, item_SchemaInfoDesc, firstName_Label, null, testRegistrationMatrix, matrixControl.descriptorControl);


        symbolStrings = new ArrayList<String>();
        symbolStrings.add("FORM");
        symbolStrings.add("REQUIRED");
        DescriptorTagName formRequired_DescTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, 1, false);
        SchemaInfo_Descriptor firstName_formRequired_SchemaInfoDesc = SchemaInfoUtilities.find_SchemaInfoDescriptor_in_Stack(executeInfo,
                formRequired_DescTagName, MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$__$schema$_CC_$WEB$__$FORM, symbolControl,
                itemFirstName_Desc.schemaInfo_Positioned, schemaSet_ScopeStack);
        Descriptor firstName_formRequired_Desc = new Descriptor(executeInfo, firstName_formRequired_SchemaInfoDesc, null, null, itemFirstName_Desc, matrixControl.descriptorControl);
        // Create FieldSet
        FieldSet_Tuple formRequired_FieldSet = firstName_formRequired_Desc.get_FieldSet_Tuple(executeInfo);
        formRequired_FieldSet.setField_Symbol(executeInfo, 0, symbolControl.singleSymbol_Factory.createNew("IsRequired", true));
        formRequired_FieldSet.setField_String(executeInfo, 1, "Test Path");
        formRequired_FieldSet.setField_int(executeInfo, 2, 11);





        Label state_Label = symbolControl.singleSymbol_Factory.createNew_Label("State", false);
        item_SchemaInfoDesc = SchemaInfoUtilities.find_SchemaInfoDescriptor_in_Stack(executeInfo,
                MPSymbols_DescTagName.ITEM, MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD, symbolControl, testRegistrationMatrix.schemaInfo_Positioned, schemaSet_ScopeStack);
        Descriptor itemState_Desc = new Descriptor(executeInfo, item_SchemaInfoDesc, state_Label, null, testRegistrationMatrix, matrixControl.descriptorControl);


        symbolStrings = new ArrayList<String>();
        symbolStrings.add("FORM");
        symbolStrings.add("REQUIRED");
        formRequired_DescTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, 1, false);
        SchemaInfo_Descriptor formRequired_SchemaInfoDesc = SchemaInfoUtilities.find_SchemaInfoDescriptor_in_Stack(executeInfo,
                formRequired_DescTagName, testWebFormSchema.getSchemaInfo_SchemaNameFull(), symbolControl, itemState_Desc.schemaInfo_Positioned, schemaSet_ScopeStack);
        Descriptor state_formRequired_Desc = new Descriptor(executeInfo, formRequired_SchemaInfoDesc, null, null, itemState_Desc, matrixControl.descriptorControl);
        // Create FieldSet
        formRequired_FieldSet = state_formRequired_Desc.get_FieldSet_Tuple(executeInfo);
        formRequired_FieldSet.setField_Symbol(executeInfo, 0, symbolControl.singleSymbol_Factory.createNew("NotRequired", true));


        symbolStrings = new ArrayList<String>();
        symbolStrings.add("FORM");
        symbolStrings.add("SELECT");
        formSelect_DescTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, 1, false);
        SchemaInfo_Descriptor formSelect_SchemaInfoDesc = SchemaInfoUtilities.find_SchemaInfoDescriptor_in_Stack(executeInfo,
                formSelect_DescTagName, testWebFormSchema.getSchemaInfo_SchemaNameFull(), symbolControl, itemState_Desc.schemaInfo_Positioned, schemaSet_ScopeStack);
        Descriptor formSelect_Desc = new Descriptor(executeInfo, formSelect_SchemaInfoDesc, null, null, itemState_Desc, matrixControl.descriptorControl);
        // Create FieldSet
        FieldSet_Tuple formSelect_FieldSet = formSelect_Desc.get_FieldSet_Tuple(executeInfo);
        formSelect_FieldSet.setField_String(executeInfo, (DescriptorTagName)symbolControl.descTagNames_Index.getSingleSymbol_ByName("Name"),
                                            "stateSelector");
        formSelect_FieldSet.setField_String(executeInfo, (DescriptorTagName)symbolControl.descTagNames_Index.getSingleSymbol_ByName("onChange"),
                                            "mouseOverMethod();");


        DescriptorTagName option_DescTagName = symbolControl.singleSymbol_Factory.createNew_DescTagName("OPTION", false);
        SchemaInfo_Descriptor option_SchemaInfoDesc = SchemaInfoUtilities.find_SchemaInfoDescriptor_in_Stack(executeInfo,
                option_DescTagName, testWebFormSchema.getSchemaInfo_SchemaNameFull(), symbolControl, formSelect_SchemaInfoDesc, schemaSet_ScopeStack);
        Descriptor option_Desc1 = new Descriptor(executeInfo, option_SchemaInfoDesc, null, null, formSelect_Desc, matrixControl.descriptorControl);
        // Create FieldSet
        FieldSet_Tuple option_FieldSet = option_Desc1.get_FieldSet_Tuple(executeInfo);
        option_FieldSet.setField_String(executeInfo, (DescriptorTagName)symbolControl.descTagNames_Index.getSingleSymbol_ByName("Value"),
                                            "default");
        option_FieldSet.setField_String(executeInfo, (DescriptorTagName)symbolControl.descTagNames_Index.getSingleSymbol_ByName("Label"),
                                            "- Select -");
        option_FieldSet.setField_Symbol(executeInfo, (DescriptorTagName)symbolControl.descTagNames_Index.getSingleSymbol_ByName("Selected"),
                                            symbolControl.singleSymbol_Factory.createNew("Selected", true));


        Descriptor option_Desc2 = new Descriptor(executeInfo, option_SchemaInfoDesc, null, null, formSelect_Desc, matrixControl.descriptorControl);
        // Create FieldSet
        option_FieldSet = option_Desc2.get_FieldSet_Tuple(executeInfo);
        option_FieldSet.setField_String(executeInfo, (DescriptorTagName)symbolControl.descTagNames_Index.getSingleSymbol_ByName("Value"),
                                            "AL");
        option_FieldSet.setField_String(executeInfo, (DescriptorTagName)symbolControl.descTagNames_Index.getSingleSymbol_ByName("Label"),
                                            "AL");

        Descriptor option_Desc3 = new Descriptor(executeInfo, option_SchemaInfoDesc, null, null, formSelect_Desc, matrixControl.descriptorControl);
        // Create FieldSet
        option_FieldSet = option_Desc3.get_FieldSet_Tuple(executeInfo);
        option_FieldSet.setField_String(executeInfo, (DescriptorTagName)symbolControl.descTagNames_Index.getSingleSymbol_ByName("Value"),
                                            "AZ");
        option_FieldSet.setField_String(executeInfo, (DescriptorTagName)symbolControl.descTagNames_Index.getSingleSymbol_ByName("Label"),
                                            "AZ");




        testRegistrationMatrix.add_ChildDescriptor(executeInfo, itemFirstName_Desc);
            itemFirstName_Desc.add_ChildDescriptor(executeInfo, firstName_formRequired_Desc);
        testRegistrationMatrix.add_ChildDescriptor(executeInfo, itemState_Desc);
            itemState_Desc.add_ChildDescriptor(executeInfo, state_formRequired_Desc);
            itemState_Desc.add_ChildDescriptor(executeInfo, formSelect_Desc);
                formSelect_Desc.add_ChildDescriptor(executeInfo, option_Desc1);
                formSelect_Desc.add_ChildDescriptor(executeInfo, option_Desc2);
                formSelect_Desc.add_ChildDescriptor(executeInfo, option_Desc3);


        return testRegistrationMatrix;
    }

}
