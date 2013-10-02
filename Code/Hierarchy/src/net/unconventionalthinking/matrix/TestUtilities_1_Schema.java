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


import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.matrix.*;
import net.unconventionalthinking.lang.ExecutionInfo;
import java.util.*;
import net.unconventionalthinking.exceptions.*;
import net.unconventionalthinking.matrix.metacompiler.codegen.CodeGen_OutputResults;
import net.unconventionalthinking.matrix.metacompiler.codegen.DescriptorCreation_CodeGenerator;
import net.unconventionalthinking.matrix.symbols.*;

/**
 *
 * @author peterjoh
 */
public class TestUtilities_1_Schema {

    ExecutionInfo       executeInfo;
    SchemaControl       schemaControl;
    SymbolControl       symbolControl;

    public SchemaForSchema_Container   schemaForSchema_Container;
    public SchemaInfo_Schema   schemaForSchema;


    public SchemaInfo_Schema[] testWebFormSchema;

    DescriptorTagName   formSelect_DescTagName;


    DescriptorTagName schemaPackage;


    public TestUtilities_1_Schema(ExecutionInfo executeInfo, SchemaControl schemaControl, SymbolControl symbolControl)
            throws Exception_SchemaInfo, Exception_Descriptor {

        this.executeInfo = executeInfo;
        this.schemaControl = schemaControl;
        this.symbolControl = symbolControl;

        schemaForSchema = schemaControl.schemaForSchema;
        schemaForSchema_Container = schemaControl.schemaForSchema_Container;


        testWebFormSchema = new SchemaInfo_Schema[100];

        this.schemaPackage = MPSymbols_DescTagName.net$__$unconventionalthinking$__$matrix;
    }

    public void set_SchemaPackage(DescriptorTagName schemaPackage) {
        this.schemaPackage = schemaPackage;
    }




    public SchemaInfo_Schema buildTestSchema(int testWebFormSchema_Index)
            throws Exception_Descriptor, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreation,
            Exception_MultiPartSymbolCreationOrAccess, Exception_SchemaInfo, Exception_InvalidArgumentPassed_Null,
            Exception_InvalidArgumentPassed {
        return buildTestSchema("", testWebFormSchema_Index);
    }
    public SchemaInfo_Schema buildTestSchema(String descTagAndSchemaName_suffix, int testWebFormSchema_Index)
            throws Exception_Descriptor, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreation,
            Exception_MultiPartSymbolCreationOrAccess, Exception_SchemaInfo, Exception_InvalidArgumentPassed_Null,
            Exception_InvalidArgumentPassed {
        return buildTestSchema(descTagAndSchemaName_suffix, descTagAndSchemaName_suffix, testWebFormSchema_Index);
    }

    public SchemaInfo_Schema buildTestSchema(String schemaName_suffix, String descTag_suffix, int testWebFormSchema_Index)
            throws Exception_Descriptor, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreation,
            Exception_MultiPartSymbolCreationOrAccess, Exception_SchemaInfo, Exception_InvalidArgumentPassed_Null,
            Exception_InvalidArgumentPassed {



        //  Build Schema
        List<String> symbolStrings = new ArrayList<String>();

        symbolStrings = new ArrayList<String>();
        symbolStrings.add("WEB");
        symbolStrings.add("FORM" + schemaName_suffix);
        Label webForm_Label = symbolControl.multiPartSymbol_Factory.createNew_Label(symbolStrings, 1, true);
        testWebFormSchema[testWebFormSchema_Index] = schemaControl.schemaFactory.createNew_Schema(executeInfo, webForm_Label,
                schemaPackage, true, null, null);


        //  FORM.REQUIRED_______________________________________________________________________________________________
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("FORM");
        symbolStrings.add("REQUIRED" + descTag_suffix);
        Label formRequired_Label = symbolControl.multiPartSymbol_Factory.createNew_Label(symbolStrings, 1, true);
        SchemaInfo_Descriptor formRequired_SchemaInfo_Desc = new SchemaInfo_Descriptor_Impl(executeInfo,
                schemaForSchema_Container.schema4Schema__SchemaInfoDesc_Descriptor,
                formRequired_Label, null, (Descriptor)testWebFormSchema[testWebFormSchema_Index], schemaControl.schema_DescControl);


        Descriptor formRequired__fieldNames_SchemaInfoDesc = new Descriptor(executeInfo,
                schemaForSchema_Container.schema4Schema__DescDescriptor__SchemaInfoDesc_FieldNames,
                null, null, (Descriptor)formRequired_SchemaInfo_Desc, schemaControl.schema_DescControl);
        // Create FieldSet
        FieldSet_Tuple fieldNames_FieldSet = formRequired__fieldNames_SchemaInfoDesc.get_FieldSet_Tuple(executeInfo);
        fieldNames_FieldSet.setField_DescTagName(executeInfo, 0, symbolControl.singleSymbol_Factory.createNew_DescTagName("IsRequired", true));
        fieldNames_FieldSet.setField_DescTagName(executeInfo, 1, symbolControl.singleSymbol_Factory.createNew_DescTagName("RequiredImagePath", true));
        fieldNames_FieldSet.setField_DescTagName(executeInfo, 2, symbolControl.singleSymbol_Factory.createNew_DescTagName("ImageHeight", true));
        fieldNames_FieldSet.setField_DescTagName(executeInfo, 3, symbolControl.singleSymbol_Factory.createNew_DescTagName("ImageWidth", true));

        Descriptor formRequired__fieldTypes_SchemaInfoDesc = new Descriptor(executeInfo,
                schemaForSchema_Container.schema4Schema__DescDescriptor__SchemaInfoDesc_FieldTypes,
                null, null, (Descriptor)formRequired_SchemaInfo_Desc, schemaControl.schema_DescControl);
        // Create FieldSet
        FieldSet_Tuple fieldType_FieldSet = formRequired__fieldTypes_SchemaInfoDesc.get_FieldSet_Tuple(executeInfo);
        fieldType_FieldSet.setField_Symbol(executeInfo, 0, MPSymbols.Symbol);
        //  create the possible symbol values for the IsRequired field so they will be added the the symbol file
        symbolControl.singleSymbol_Factory.createNew("NotRequired", true);
        symbolControl.singleSymbol_Factory.createNew("IsRequired", true);
        fieldType_FieldSet.setField_Symbol(executeInfo, 1, MPSymbols.String);
        fieldType_FieldSet.setField_Symbol(executeInfo, 2, MPSymbols.int$_sym_$);
        fieldType_FieldSet.setField_Symbol(executeInfo, 3, MPSymbols.int$_sym_$);

        Descriptor formRequired__fieldDesc_SchemaInfoDesc = new Descriptor(executeInfo,
                schemaForSchema_Container.schema4Schema__DescDescriptor__SchemaInfoDesc_FieldDescription,
                null, null, (Descriptor)formRequired_SchemaInfo_Desc, schemaControl.schema_DescControl);
        FieldSet_Tuple fieldDesc_FieldSet = formRequired__fieldDesc_SchemaInfoDesc.get_FieldSet_Tuple(executeInfo);
        fieldDesc_FieldSet.setField_String(executeInfo, 0, "Is this a required field?");
        fieldDesc_FieldSet.setField_String(executeInfo, 1, "The path image file that marks required fields.");
        fieldDesc_FieldSet.setField_String(executeInfo, 2, "The height of the image.");
        fieldDesc_FieldSet.setField_String(executeInfo, 3, "The width of the image.");


        Descriptor formRequired__fieldDefaults_SchemaInfoDesc = new Descriptor(executeInfo,
                schemaForSchema_Container.schema4Schema__DescDescriptor__SchemaInfoDesc_FieldDefaults,
                null, null, (Descriptor)formRequired_SchemaInfo_Desc, schemaControl.schema_DescControl);
        FieldSet_Tuple fieldDefaults_FieldSet = formRequired__fieldDefaults_SchemaInfoDesc.get_FieldSet_Tuple(executeInfo);
        fieldDefaults_FieldSet.setField(executeInfo, 0, symbolControl.singleSymbol_Factory.createNew("NotRequired", true));
        fieldDefaults_FieldSet.setField(executeInfo, 1, "/images/required.gif");
        fieldDefaults_FieldSet.setField(executeInfo, 2, new Integer(6));
        fieldDefaults_FieldSet.setField(executeInfo, 3, new Integer(7));




        //  FORM.SELECT ________________________________________________________________________________________________
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("FORM");
        symbolStrings.add("SELECT" + descTag_suffix);
        Label formSelect_Label = symbolControl.multiPartSymbol_Factory.createNew_Label(symbolStrings, 1, true);
        SchemaInfo_Descriptor formSelect_SchemaInfo_Desc = new SchemaInfo_Descriptor_Impl(executeInfo,
                schemaForSchema_Container.schema4Schema__SchemaInfoDesc_Descriptor,
                formSelect_Label, null, (Descriptor)testWebFormSchema[testWebFormSchema_Index], schemaControl.schema_DescControl);


        Descriptor formSelect__fieldNames_SchemaInfoDesc = new Descriptor(executeInfo,
                schemaForSchema_Container.schema4Schema__DescDescriptor__SchemaInfoDesc_FieldNames,
                null, null, (Descriptor)formSelect_SchemaInfo_Desc, schemaControl.schema_DescControl);
        // Create FieldSet
        fieldNames_FieldSet = formSelect__fieldNames_SchemaInfoDesc.get_FieldSet_Tuple(executeInfo);
        fieldNames_FieldSet.setField_DescTagName(executeInfo, 0, symbolControl.singleSymbol_Factory.createNew_DescTagName("Name", true));
        fieldNames_FieldSet.setField_DescTagName(executeInfo, 1, symbolControl.singleSymbol_Factory.createNew_DescTagName("onChange", true));


        Descriptor formSelect__fieldTypes_SchemaInfoDesc = new Descriptor(executeInfo,
                schemaForSchema_Container.schema4Schema__DescDescriptor__SchemaInfoDesc_FieldTypes,
                null, null, (Descriptor)formSelect_SchemaInfo_Desc, schemaControl.schema_DescControl);
        // Create FieldSet
        fieldType_FieldSet = formSelect__fieldTypes_SchemaInfoDesc.get_FieldSet_Tuple(executeInfo);
        fieldType_FieldSet.setField_Symbol(executeInfo, 0, MPSymbols.String);
        fieldType_FieldSet.setField_Symbol(executeInfo, 1, MPSymbols.String);

        Descriptor formSelect__fieldDesc_SchemaInfoDesc = new Descriptor(executeInfo,
                schemaForSchema_Container.schema4Schema__DescDescriptor__SchemaInfoDesc_FieldDescription,
                null, null, (Descriptor)formSelect_SchemaInfo_Desc, schemaControl.schema_DescControl);
        fieldDesc_FieldSet = formSelect__fieldDesc_SchemaInfoDesc.get_FieldSet_Tuple(executeInfo);
        fieldDesc_FieldSet.setField_String(executeInfo, 0, "Name of Select");
        fieldDesc_FieldSet.setField_String(executeInfo, 1, "The javascript code for what happens during the onchange event for the select.");

        Descriptor formSelect__fieldDefaults_SchemaInfoDesc = new Descriptor(executeInfo,
                schemaForSchema_Container.schema4Schema__DescDescriptor__SchemaInfoDesc_FieldDefaults,
                null, null, (Descriptor)formSelect_SchemaInfo_Desc, schemaControl.schema_DescControl);
        fieldDefaults_FieldSet = formSelect__fieldDefaults_SchemaInfoDesc.get_FieldSet_Tuple(executeInfo);
        fieldDefaults_FieldSet.setField(executeInfo, 0, "");
        fieldDefaults_FieldSet.setField(executeInfo, 1, null);



        Label option_Label = symbolControl.singleSymbol_Factory.createNew_Label("OPTION" + descTag_suffix, true);
        SchemaInfo_Descriptor option_SchemaInfo_Desc = new SchemaInfo_Descriptor_Impl(executeInfo,
                schemaForSchema_Container.schema4Schema__SchemaInfoDesc_Descriptor,
                option_Label, null, (Descriptor)formSelect_SchemaInfo_Desc, schemaControl.schema_DescControl);

        Descriptor option__fieldNames_SchemaInfoDesc = new Descriptor(executeInfo,
                schemaForSchema_Container.schema4Schema__DescDescriptor__SchemaInfoDesc_FieldNames,
                null, null, (Descriptor)option_SchemaInfo_Desc, schemaControl.schema_DescControl);
        // Create FieldSet
        fieldNames_FieldSet = option__fieldNames_SchemaInfoDesc.get_FieldSet_Tuple(executeInfo);
        fieldNames_FieldSet.setField_DescTagName(executeInfo, 0, symbolControl.singleSymbol_Factory.createNew_DescTagName("Value", true));
        fieldNames_FieldSet.setField_DescTagName(executeInfo, 1, symbolControl.singleSymbol_Factory.createNew_DescTagName("Label", true));
        fieldNames_FieldSet.setField_DescTagName(executeInfo, 2, symbolControl.singleSymbol_Factory.createNew_DescTagName("Selected", true));

        Descriptor option__fieldTypes_SchemaInfoDesc = new Descriptor(executeInfo,
                schemaForSchema_Container.schema4Schema__DescDescriptor__SchemaInfoDesc_FieldTypes,
                null, null, (Descriptor)option_SchemaInfo_Desc, schemaControl.schema_DescControl);
        // Create FieldSet
        fieldType_FieldSet = option__fieldTypes_SchemaInfoDesc.get_FieldSet_Tuple(executeInfo);
        fieldType_FieldSet.setField_Symbol(executeInfo, 0, MPSymbols.String);
        fieldType_FieldSet.setField_Symbol(executeInfo, 1, MPSymbols.String);
        fieldType_FieldSet.setField_Symbol(executeInfo, 2, MPSymbols.Symbol);

        Descriptor option__fieldDesc_SchemaInfoDesc = new Descriptor(executeInfo,
                schemaForSchema_Container.schema4Schema__DescDescriptor__SchemaInfoDesc_FieldDescription,
                null, null, (Descriptor)option_SchemaInfo_Desc, schemaControl.schema_DescControl);
        fieldDesc_FieldSet = option__fieldDesc_SchemaInfoDesc.get_FieldSet_Tuple(executeInfo);
        fieldDesc_FieldSet.setField_String(executeInfo, 0, "Value of option");
        fieldDesc_FieldSet.setField_String(executeInfo, 1, "Name of option.");
        fieldDesc_FieldSet.setField_String(executeInfo, 2, "Whether the option is the default selected or not.");

        Descriptor option__fieldDefaults_SchemaInfoDesc = new Descriptor(executeInfo,
                schemaForSchema_Container.schema4Schema__DescDescriptor__SchemaInfoDesc_FieldDefaults,
                null, null, (Descriptor)option_SchemaInfo_Desc, schemaControl.schema_DescControl);
        fieldDefaults_FieldSet = option__fieldDefaults_SchemaInfoDesc.get_FieldSet_Tuple(executeInfo);
        fieldDefaults_FieldSet.setField(executeInfo, 0, null);
        fieldDefaults_FieldSet.setField(executeInfo, 1, null);
        fieldDefaults_FieldSet.setField(executeInfo, 2, symbolControl.singleSymbol_Factory.createNew("NotSelected", true));



        /*FIX*/
        //  TODO build fieldset for schema test later on!


        //  Build the actual schema matrix
        testWebFormSchema[testWebFormSchema_Index].addChild_SchemaInfoDescriptor(executeInfo, formRequired_SchemaInfo_Desc);
            formRequired_SchemaInfo_Desc.addChild_SchemaInfo_FieldDescriptor(executeInfo, formRequired__fieldNames_SchemaInfoDesc);
            formRequired_SchemaInfo_Desc.addChild_SchemaInfo_FieldDescriptor(executeInfo, formRequired__fieldTypes_SchemaInfoDesc);
            formRequired_SchemaInfo_Desc.addChild_SchemaInfo_FieldDescriptor(executeInfo, formRequired__fieldDesc_SchemaInfoDesc);
            formRequired_SchemaInfo_Desc.addChild_SchemaInfo_FieldDescriptor(executeInfo, formRequired__fieldDefaults_SchemaInfoDesc);

        testWebFormSchema[testWebFormSchema_Index].addChild_SchemaInfoDescriptor(executeInfo, formSelect_SchemaInfo_Desc);
            formSelect_SchemaInfo_Desc.addChild_SchemaInfo_FieldDescriptor(executeInfo, formSelect__fieldNames_SchemaInfoDesc);
            formSelect_SchemaInfo_Desc.addChild_SchemaInfo_FieldDescriptor(executeInfo, formSelect__fieldTypes_SchemaInfoDesc);
            formSelect_SchemaInfo_Desc.addChild_SchemaInfo_FieldDescriptor(executeInfo, formSelect__fieldDesc_SchemaInfoDesc);
            formSelect_SchemaInfo_Desc.addChild_SchemaInfo_FieldDescriptor(executeInfo, formSelect__fieldDefaults_SchemaInfoDesc);

            formSelect_SchemaInfo_Desc.addChild_SchemaInfoDescriptor(executeInfo, option_SchemaInfo_Desc);
                option_SchemaInfo_Desc.addChild_SchemaInfo_FieldDescriptor(executeInfo, option__fieldNames_SchemaInfoDesc);
                option_SchemaInfo_Desc.addChild_SchemaInfo_FieldDescriptor(executeInfo, option__fieldTypes_SchemaInfoDesc);
                option_SchemaInfo_Desc.addChild_SchemaInfo_FieldDescriptor(executeInfo, option__fieldDesc_SchemaInfoDesc);
                option_SchemaInfo_Desc.addChild_SchemaInfo_FieldDescriptor(executeInfo, option__fieldDefaults_SchemaInfoDesc);


        //  initialize all the schemaInfo objects
        testWebFormSchema[testWebFormSchema_Index].initialize_SchemaInfo(executeInfo, symbolControl, schemaControl.schemaControl_Info);

        return testWebFormSchema[testWebFormSchema_Index];
    }



}
