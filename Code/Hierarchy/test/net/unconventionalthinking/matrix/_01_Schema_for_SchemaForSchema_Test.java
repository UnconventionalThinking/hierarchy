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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.unconventionalthinking.matrix;

import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.symbols.DescriptorTag;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.MPSymbols_DescTag;
import net.unconventionalthinking.matrix.symbols.MPSymbols_DescTagName;
import net.unconventionalthinking.matrix.symbols.MPSymbols_SchemaName;
import net.unconventionalthinking.matrix.symbols.MatrixName;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolConstants;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.matrix.symbols.Symbol_Base;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *  Basically, testing the Schema for the SchemaForSchema_Container
 *
 * @author peterjoh
 */
public class _01_Schema_for_SchemaForSchema_Test {


    private static SchemaForSchema_Container schemaForSchemaBuilder;
    private static SchemaInfo_Schema schemaForSchema_SchemaMatrix;
    private static SchemaInfo_Schema schema_for_SchemaForSchema;


    // we don't need the real thing right now. just a tester object to do testing with.
    private static AppControl_Base appControl_MockObj;
    private static ExecutionInfo executeInfo = new ExecutionInfo();
    private static SymbolControl symbolControl;

    private static SchemaControl schemaControl;
    private static SchemaControl_Info schemaControl_Info;
    private static Map<Symbol, Constructor> fieldSetTupleSpecialized_Constructor_Index_byTypeSymbol;


    public _01_Schema_for_SchemaForSchema_Test() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        appControl_MockObj = new AppControl_Simple();

        symbolControl = new SymbolControl();
        symbolControl.intialize_All_MPSymbols();
        appControl_MockObj.executionInfo = executeInfo;
        appControl_MockObj.symbolControl = symbolControl;

//        fieldSetTupleSpecialized_Constructor_Index_byTypeSymbol = new HashMap<Symbol, Constructor>();
//        schemaControl_Info = new SchemaControl_Info(fieldSetTupleSpecialized_Constructor_Index_byTypeSymbol);
//        schemaForSchemaBuilder = new SchemaForSchema_Container(executeInfo, symbolControl, schemaControl_Info);

        schemaControl = new SchemaControl(executeInfo, appControl_MockObj);
        
        fieldSetTupleSpecialized_Constructor_Index_byTypeSymbol = schemaControl.fieldSetTupleSpecialized_Constructor_Index_byTypeSymbol;
        schemaControl_Info = schemaControl.schemaControl_Info;
        schemaForSchemaBuilder = schemaControl.schemaForSchema_Container;

        schemaForSchema_SchemaMatrix = schemaForSchemaBuilder.schema4Schema;
        schema_for_SchemaForSchema = schemaForSchemaBuilder.schema_4_schema4Schema__SchemaInfoSchema;
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



    /**
     * Test of getSchemaInfo_DescriptorTag method, of class SchemaForSchema_SchemaInfoSchema.
     */
    @Test
    public void testGetSchemaInfo_DescriptorTagName() throws Exception {

        System.out.println("getSchemaInfo_DescriptorTagName");
        String expResult = "SCHEMA";
        MatrixName schemaName = MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA;
        DescriptorTag expDescTag = MPSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$SCHEMA;

        DescriptorTag result = schema_for_SchemaForSchema.getSchemaInfo_DescriptorTag();

        assertEquals(expResult, result.getDescTagName().toString());
        assertEquals(schemaName, result.getSchemaName_Full());
        assertEquals(expDescTag, result);


        expResult = "DESCRIPTOR";
        schemaName = MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA;
        expDescTag = MPSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR;

        SchemaInfo_Descriptor descriptor_SchemaInfoDescriptor = schema_for_SchemaForSchema.getChild_SchemaInfoDescriptor(executeInfo,
                MPSymbols_DescTagName.DESCRIPTOR);

        result = descriptor_SchemaInfoDescriptor.getSchemaInfo_DescriptorTag();
        assertEquals(expResult, result.getDescTagName().toString());
        assertEquals(schemaName, result.getSchemaName_Full());
        assertEquals(expDescTag, result);




        //  SchemaInfoDesc FieldNames
        SchemaInfo_Descriptor fieldNames_SchemaInfoDescriptor = schemaForSchemaBuilder.schema_4_Schema4Schema__SchemaInfoDesc_Descriptor.getChild_SchemaInfoDescriptor(executeInfo, MPSymbols_DescTagName.FIELD$__$NAMES);
        schemaName = MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA;
        result = fieldNames_SchemaInfoDescriptor.getSchemaInfo_DescriptorTag();
        assertEquals(MPSymbols_DescTagName.FIELD$__$NAMES.getTagName(), result.getDescTagName().toString());
        assertEquals(schemaName, result.getSchemaName_Full());

        //  Check the fieldNames's SchemaInfo_Field. this should be a continuation field of symbols
        SchemaInfo_FieldSet fieldNames_SchemaInfoFieldSet = fieldNames_SchemaInfoDescriptor.get_SchemaInfoFieldSet(executeInfo);
        
        assertEquals(1, fieldNames_SchemaInfoFieldSet.num_AllFields);
        assertEquals(0, fieldNames_SchemaInfoFieldSet.num_NonContinuationFields);
        assertEquals(true, fieldNames_SchemaInfoFieldSet.hasContinuationField());


        SchemaInfo_Field fieldNames_ContField = fieldNames_SchemaInfoFieldSet.get_SchemaInfoField(executeInfo, 0);
        assertEquals(0, fieldNames_ContField.fieldIndex);
        assertEquals(true, fieldNames_ContField.is_Continuation_Field);
        assertEquals(MPSymbols.ContinuationType$__$DescriptorTagName, fieldNames_ContField.fieldType_Symbol);
        assertEquals(MPSymbols_DescTagName.NAMES, fieldNames_ContField.fieldName);



        //  SchemaInfoDesc FieldTypes
        SchemaInfo_Descriptor fieldTypes_SchemaInfoDescriptor = schemaForSchemaBuilder.schema_4_Schema4Schema__SchemaInfoDesc_Descriptor.getChild_SchemaInfoDescriptor(executeInfo, MPSymbols_DescTagName.FIELD$__$TYPES);
        result = fieldTypes_SchemaInfoDescriptor.getSchemaInfo_DescriptorTag();
        assertEquals(MPSymbols_DescTagName.FIELD$__$TYPES.getTagName(), result.getDescTagName().toString());

        //  Check the fieldTypes's SchemaInfo_Field. this should be a continuation field of symbols
        SchemaInfo_FieldSet fieldTypes_SchemaInfoFieldSet = fieldTypes_SchemaInfoDescriptor.get_SchemaInfoFieldSet(executeInfo);
        assertEquals(1, fieldTypes_SchemaInfoFieldSet.num_AllFields);
        assertEquals(0, fieldTypes_SchemaInfoFieldSet.num_NonContinuationFields);
        assertEquals(true, fieldTypes_SchemaInfoFieldSet.hasContinuationField());


        SchemaInfo_Field fieldTypes_ContField = fieldTypes_SchemaInfoFieldSet.get_SchemaInfoField(executeInfo, 0);
        assertEquals(0, fieldTypes_ContField.fieldIndex);
        assertEquals(true, fieldTypes_ContField.is_Continuation_Field);
        assertEquals(MPSymbols.ContinuationType$__$Symbol, fieldTypes_ContField.fieldType_Symbol);
        assertEquals(MPSymbols_DescTagName.TYPES, fieldTypes_ContField.fieldName);




        //  Test Schema4Schema can access schema_4_schema4schema
        //  ______________________________________________________________________________________________________________________

        //  DESCRIPTOR 'DESCRIPTOR'
        expResult = "DESCRIPTOR";
        schemaName = MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA;
        descriptor_SchemaInfoDescriptor = schemaForSchema_SchemaMatrix.getChild_SchemaInfoDescriptor(executeInfo,
                MPSymbols_DescTagName.DESCRIPTOR);
        expDescTag = MPSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR;

        DescriptorTag result_DescTag = ((Descriptor)descriptor_SchemaInfoDescriptor).descTag;
        assertEquals(expResult, result_DescTag.getDescTagName().toString());
        assertEquals(schemaName, result_DescTag.getSchemaName_Full());
        assertEquals(expDescTag, result_DescTag);


        //  DESCRIPTOR 'MATRIX' - expected results should be the same as DESCRIPTOR 'DESCRIPTOR'
        descriptor_SchemaInfoDescriptor = schemaForSchema_SchemaMatrix.getChild_SchemaInfoDescriptor(executeInfo,
                MPSymbols_DescTagName.MATRIX);

        result_DescTag = ((Descriptor)descriptor_SchemaInfoDescriptor).descTag;
        assertEquals(expResult, result_DescTag.getDescTagName().toString());
        assertEquals(schemaName, result_DescTag.getSchemaName_Full());
        assertEquals(expDescTag, result_DescTag);



        //  DESCRIPTOR 'SCHEMA' - expected results should be the same as DESCRIPTOR 'DESCRIPTOR'
        descriptor_SchemaInfoDescriptor = schemaForSchema_SchemaMatrix.getChild_SchemaInfoDescriptor(executeInfo,
                MPSymbols_DescTagName.SCHEMA);


        result_DescTag = ((Descriptor)descriptor_SchemaInfoDescriptor).descTag;
        assertEquals(expResult, result_DescTag.getDescTagName().toString());
        assertEquals(schemaName, result_DescTag.getSchemaName_Full());
        assertEquals(expDescTag, result_DescTag);







    }



    /**
     * Test of getSchemaInfo_ParentSchemaInfo method, of schema_for_SchemaForSchema.
     */
    @Test
    public void testGetParent_SchemaInfo() {
        System.out.println("getParent_SchemaInfo");
        SchemaInfo result = schema_for_SchemaForSchema.getSchemaInfo_ParentSchemaInfo(executeInfo);
        assertEquals(null, result);


        result = schemaForSchemaBuilder.schema_4_Schema4Schema__SchemaInfoDesc_Descriptor.getSchemaInfo_ParentSchemaInfo(executeInfo);
        assertEquals(schemaForSchemaBuilder.schema_4_schema4Schema__SchemaInfoSchema, result);


        result = schemaForSchemaBuilder.schema_4_Schema4Schema__SchemaInfoDesc_FieldTypes.getSchemaInfo_ParentSchemaInfo(executeInfo);
        assertEquals(schemaForSchemaBuilder.schema_4_Schema4Schema__SchemaInfoDesc_Descriptor, result);
    }

    /**
     * Test of getSchemaInfo_DescTagName_FullPath method, of class SchemaForSchema_SchemaInfoSchema.
     */
    @Test
    public void testGetFullName_as_DescTagNames() {
        System.out.println("getFullName_as_DescTagNames");
        List<Symbol_Base> nameSymbols = new ArrayList<Symbol_Base>();

        schemaForSchemaBuilder.schema_4_Schema4Schema__SchemaInfoDesc_FieldTypes.getSchemaInfo_DescTagName_FullPath(executeInfo, nameSymbols);

        assertEquals(schemaForSchemaBuilder.schema_4_schema4Schema__SchemaInfoSchema.getSchemaInfo_SchemaNameFull(), nameSymbols.get(0));
        assertEquals(schemaForSchemaBuilder.schema_4_Schema4Schema__SchemaInfoDesc_Descriptor.getSchemaInfo_DescriptorTagName(), nameSymbols.get(1));
        assertEquals(schemaForSchemaBuilder.schema_4_Schema4Schema__SchemaInfoDesc_FieldTypes.getSchemaInfo_DescriptorTagName(), nameSymbols.get(2));

    }

    /**
     * Test of getSchemaInfo_DescTagName_FullPath_IdentFormat method, of class SchemaForSchema_SchemaInfoSchema.
     */
    @Test
    public void testGetFullName() {
        System.out.println("getFullName");
        String expResult = "SCHEMA->DESCRIPTOR->FIELD.TYPES";
        String result = schemaForSchemaBuilder.schema_4_Schema4Schema__SchemaInfoDesc_FieldTypes.getSchemaInfo_DescTagName_FullPath_String(executeInfo);
        assertEquals(expResult, result);


        expResult = "SCHEMA" + SymbolConstants.SymbolPath_SymbolSeparator_IdentFormat + "DESCRIPTOR" +
                SymbolConstants.SymbolPath_SymbolSeparator_IdentFormat + "FIELD" + SymbolConstants.MultiPart_Separator_IdentFormat + "TYPES";
        result = schemaForSchemaBuilder.schema_4_Schema4Schema__SchemaInfoDesc_FieldTypes.getSchemaInfo_DescTagName_FullPath_IdentFormat(executeInfo);
        assertEquals(expResult, result);
    }


    /**
     * Test of getSchemaInfo__Ancestor_SchemaInfoSchema method, of class SchemaForSchema_SchemaInfoSchema.
     */
    @Test
    public void testGetAncestor_SchemaInfoSchema() {
        System.out.println("getAncestor_SchemaInfoSchema");

        SchemaInfo_Schema expResult = schemaForSchemaBuilder.schema_4_schema4Schema__SchemaInfoSchema;
        SchemaInfo_Schema result = schema_for_SchemaForSchema.getSchemaInfo__Ancestor_SchemaInfoSchema();
        assertEquals(expResult, result);

        result = schemaForSchemaBuilder.schema_4_Schema4Schema__SchemaInfoDesc_Descriptor.getSchemaInfo__Ancestor_SchemaInfoSchema();
        assertEquals(expResult, result);

        result = schemaForSchemaBuilder.schema_4_Schema4Schema__SchemaInfoDesc_FieldTypes.getSchemaInfo__Ancestor_SchemaInfoSchema();
        assertEquals(expResult, result);



    }

}