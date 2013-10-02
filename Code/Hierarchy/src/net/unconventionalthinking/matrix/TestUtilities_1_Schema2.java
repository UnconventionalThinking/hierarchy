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

/**
 *
 * @author peterjoh
 */
public class TestUtilities_1_Schema2 {

    ExecutionInfo       executeInfo;
    SchemaControl       schemaControl;
    SymbolControl       symbolControl;

    SchemaForSchema_Container   schemaForSchema_Container;
    SchemaInfo_Schema   schemaForSchema;


    SchemaInfo_Schema[] testSchemaList;

    DescriptorTagName   formSelect_DescTagName;


    DescriptorTagName   schemaPackage;

    

    public TestUtilities_1_Schema2(ExecutionInfo executeInfo, SchemaControl schemaControl, SymbolControl symbolControl)
            throws Exception_SchemaInfo, Exception_Descriptor {

        this.executeInfo = executeInfo;
        this.schemaControl = schemaControl;
        this.symbolControl = symbolControl;

        schemaForSchema = schemaControl.schemaForSchema;
        schemaForSchema_Container = schemaControl.schemaForSchema_Container;


        testSchemaList = new SchemaInfo_Schema[100];

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

    public SchemaInfo_Schema buildTestSchema(String descTag_suffix, int testSchema_Index)
            throws Exception_Descriptor, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreation,
            Exception_MultiPartSymbolCreationOrAccess, Exception_SchemaInfo, Exception_InvalidArgumentPassed_Null,
            Exception_InvalidArgumentPassed {



        //  Build Schema
        List<String> symbolStrings = new ArrayList<String>();
        symbolStrings.add("TEST");
        symbolStrings.add("SCHEMA" + descTag_suffix);
        Label testSchema_Label = symbolControl.multiPartSymbol_Factory.createNew_Label(symbolStrings, 1, true);
        testSchemaList[testSchema_Index] = schemaControl.schemaFactory.createNew_Schema(executeInfo, testSchema_Label,
                schemaPackage, true, null, null);


        //  Continuation FieldSet:  MY_DESC.NUM1: { string, short, int...}_______________________________________________________________________________________________
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("MY_DESC");
        symbolStrings.add("NUM1" + descTag_suffix);
        Label myDescNum1_Label = symbolControl.multiPartSymbol_Factory.createNew_Label(symbolStrings, 1, true);
        SchemaInfo_Descriptor myDescNum1_SchemaInfo_Desc = new SchemaInfo_Descriptor_Impl(executeInfo,
                schemaForSchema_Container.schema4Schema__SchemaInfoDesc_Descriptor,
                myDescNum1_Label, null, (Descriptor)testSchemaList[testSchema_Index], schemaControl.schema_DescControl);


        Descriptor myDescNum1__fieldNames_SchemaInfoDesc = new Descriptor(executeInfo,
                schemaForSchema_Container.schema4Schema__DescDescriptor__SchemaInfoDesc_FieldNames,
                null, null, (Descriptor)myDescNum1_SchemaInfo_Desc, schemaControl.schema_DescControl);
        // Create FieldSet
        FieldSet_Tuple fieldNames_FieldSet = myDescNum1__fieldNames_SchemaInfoDesc.get_FieldSet_Tuple(executeInfo);
        fieldNames_FieldSet.setField_DescTagName(executeInfo, 0, symbolControl.singleSymbol_Factory.createNew_DescTagName("field1Str", true));
        fieldNames_FieldSet.setField_DescTagName(executeInfo, 1, symbolControl.singleSymbol_Factory.createNew_DescTagName("field2Short", true));
        fieldNames_FieldSet.setField_DescTagName(executeInfo, 2, symbolControl.singleSymbol_Factory.createNew_DescTagName("field3ContInt", true));

        Descriptor myDescNum1__fieldTypes_SchemaInfoDesc = new Descriptor(executeInfo,
                schemaForSchema_Container.schema4Schema__DescDescriptor__SchemaInfoDesc_FieldTypes,
                null, null, (Descriptor)myDescNum1_SchemaInfo_Desc, schemaControl.schema_DescControl);
        // Create FieldSet
        FieldSet_Tuple fieldType_FieldSet = myDescNum1__fieldTypes_SchemaInfoDesc.get_FieldSet_Tuple(executeInfo);

        List<String> intCont_SymbolStrings = new ArrayList<String>();
        intCont_SymbolStrings.add(MPSymbols.ContinuationType.toString());
        intCont_SymbolStrings.add(MPSymbols.int$_sym_$.toString());
        Symbol intContinuationType = symbolControl.multiPartSymbol_Factory.createNew(intCont_SymbolStrings, 1, true);

        fieldType_FieldSet.setField_Symbol(executeInfo, 0, MPSymbols.String);
        fieldType_FieldSet.setField_Symbol(executeInfo, 1, MPSymbols.short$_sym_$);
        fieldType_FieldSet.setField_Symbol(executeInfo, 2, intContinuationType);

        Descriptor myDescNum1__fieldDesc_SchemaInfoDesc = new Descriptor(executeInfo,
                schemaForSchema_Container.schema4Schema__DescDescriptor__SchemaInfoDesc_FieldDescription,
                null, null, (Descriptor)myDescNum1_SchemaInfo_Desc, schemaControl.schema_DescControl);
        FieldSet_Tuple fieldDesc_FieldSet = myDescNum1__fieldDesc_SchemaInfoDesc.get_FieldSet_Tuple(executeInfo);
        fieldDesc_FieldSet.setField_String(executeInfo, 0, "Field 1 of type String");
        fieldDesc_FieldSet.setField_String(executeInfo, 1, "Field 2 of type short");
        fieldDesc_FieldSet.setField_String(executeInfo, 2, "Field 3 is a continuation type of int.");


        Descriptor myDescNum1__fieldDefaults_SchemaInfoDesc = new Descriptor(executeInfo,
                schemaForSchema_Container.schema4Schema__DescDescriptor__SchemaInfoDesc_FieldDefaults,
                null, null, (Descriptor)myDescNum1_SchemaInfo_Desc, schemaControl.schema_DescControl);
        FieldSet_Tuple fieldDefaults_FieldSet = myDescNum1__fieldDefaults_SchemaInfoDesc.get_FieldSet_Tuple(executeInfo);
        fieldDefaults_FieldSet.setField(executeInfo, 0, "default string");
        fieldDefaults_FieldSet.setField(executeInfo, 1, -99);
        fieldDefaults_FieldSet.setField(executeInfo, 2, -100);







        //  Continuation FieldSet:  MY_DESC.NUM2: { MyTestType, net.unconventionalthinking.matrix.MyTestType2 }_______________________________________________________________________________________________
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("MY_DESC");
        symbolStrings.add("NUM2" + descTag_suffix);
        Label myDescNum2_Label = symbolControl.multiPartSymbol_Factory.createNew_Label(symbolStrings, 1, true);
        SchemaInfo_Descriptor myDescNum2_SchemaInfo_Desc = new SchemaInfo_Descriptor_Impl(executeInfo,
                schemaForSchema_Container.schema4Schema__SchemaInfoDesc_Descriptor,
                myDescNum2_Label, null, (Descriptor)testSchemaList[testSchema_Index], schemaControl.schema_DescControl);


        Descriptor myDescNum2__fieldNames_SchemaInfoDesc = new Descriptor(executeInfo,
                schemaForSchema_Container.schema4Schema__DescDescriptor__SchemaInfoDesc_FieldNames,
                null, null, (Descriptor)myDescNum2_SchemaInfo_Desc, schemaControl.schema_DescControl);
        // Create FieldSet
        fieldNames_FieldSet = myDescNum2__fieldNames_SchemaInfoDesc.get_FieldSet_Tuple(executeInfo);
        fieldNames_FieldSet.setField_DescTagName(executeInfo, 0, symbolControl.singleSymbol_Factory.createNew_DescTagName("field1TestType", true));
        fieldNames_FieldSet.setField_DescTagName(executeInfo, 1, symbolControl.singleSymbol_Factory.createNew_DescTagName("field2TestType2", true));

        Descriptor myDescNum2__fieldTypes_SchemaInfoDesc = new Descriptor(executeInfo,
                schemaForSchema_Container.schema4Schema__DescDescriptor__SchemaInfoDesc_FieldTypes,
                null, null, (Descriptor)myDescNum2_SchemaInfo_Desc, schemaControl.schema_DescControl);
        // Create FieldSet
        fieldType_FieldSet = myDescNum2__fieldTypes_SchemaInfoDesc.get_FieldSet_Tuple(executeInfo);


        Symbol myTestType = symbolControl.singleSymbol_Factory.createNew("MyTestType", true);

        List<String> myPackageMyTestType2_SymbolStrings = new ArrayList<String>();
        myPackageMyTestType2_SymbolStrings.add("net");
        myPackageMyTestType2_SymbolStrings.add("unconventionalthinking");
        myPackageMyTestType2_SymbolStrings.add("MyTestType2");
        Symbol myPackageMyTestType2 = symbolControl.multiPartSymbol_Factory.createNew(myPackageMyTestType2_SymbolStrings, 1, true);

        fieldType_FieldSet.setField_Symbol(executeInfo, 0, myTestType);
        fieldType_FieldSet.setField_Symbol(executeInfo, 1, myPackageMyTestType2);

        Descriptor myDescNum2__fieldDesc_SchemaInfoDesc = new Descriptor(executeInfo,
                schemaForSchema_Container.schema4Schema__DescDescriptor__SchemaInfoDesc_FieldDescription,
                null, null, (Descriptor)myDescNum2_SchemaInfo_Desc, schemaControl.schema_DescControl);
        fieldDesc_FieldSet = myDescNum2__fieldDesc_SchemaInfoDesc.get_FieldSet_Tuple(executeInfo);
        fieldDesc_FieldSet.setField_String(executeInfo, 0, "Field 1 of type MyTestType");
        fieldDesc_FieldSet.setField_String(executeInfo, 1, "Field 2 of type net.unconventionalthinking.MyTestType2");


        Descriptor myDescNum2__fieldDefaults_SchemaInfoDesc = new Descriptor(executeInfo,
                schemaForSchema_Container.schema4Schema__DescDescriptor__SchemaInfoDesc_FieldDefaults,
                null, null, (Descriptor)myDescNum2_SchemaInfo_Desc, schemaControl.schema_DescControl);
        fieldDefaults_FieldSet = myDescNum2__fieldDefaults_SchemaInfoDesc.get_FieldSet_Tuple(executeInfo);
        fieldDefaults_FieldSet.setField(executeInfo, 0, null);
        fieldDefaults_FieldSet.setField(executeInfo, 1, null);





        //  Build the actual schema matrix
        testSchemaList[testSchema_Index].addChild_SchemaInfoDescriptor(executeInfo, myDescNum1_SchemaInfo_Desc);
            myDescNum1_SchemaInfo_Desc.addChild_SchemaInfo_FieldDescriptor(executeInfo, myDescNum1__fieldNames_SchemaInfoDesc);
            myDescNum1_SchemaInfo_Desc.addChild_SchemaInfo_FieldDescriptor(executeInfo, myDescNum1__fieldTypes_SchemaInfoDesc);
            myDescNum1_SchemaInfo_Desc.addChild_SchemaInfo_FieldDescriptor(executeInfo, myDescNum1__fieldDesc_SchemaInfoDesc);
            myDescNum1_SchemaInfo_Desc.addChild_SchemaInfo_FieldDescriptor(executeInfo, myDescNum1__fieldDefaults_SchemaInfoDesc);


        testSchemaList[testSchema_Index].addChild_SchemaInfoDescriptor(executeInfo, myDescNum2_SchemaInfo_Desc);
            myDescNum2_SchemaInfo_Desc.addChild_SchemaInfo_FieldDescriptor(executeInfo, myDescNum2__fieldNames_SchemaInfoDesc);
            myDescNum2_SchemaInfo_Desc.addChild_SchemaInfo_FieldDescriptor(executeInfo, myDescNum2__fieldTypes_SchemaInfoDesc);
            myDescNum2_SchemaInfo_Desc.addChild_SchemaInfo_FieldDescriptor(executeInfo, myDescNum2__fieldDesc_SchemaInfoDesc);
            myDescNum2_SchemaInfo_Desc.addChild_SchemaInfo_FieldDescriptor(executeInfo, myDescNum2__fieldDefaults_SchemaInfoDesc);




        //  initialize all the schemaInfo objects
        testSchemaList[testSchema_Index].initialize_SchemaInfo(executeInfo, symbolControl, schemaControl.schemaControl_Info);

        return testSchemaList[testSchema_Index];
    }






}
