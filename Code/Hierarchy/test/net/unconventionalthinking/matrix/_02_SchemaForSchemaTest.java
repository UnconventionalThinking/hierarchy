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
import net.unconventionalthinking.matrix.symbols.*;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

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
public class _02_SchemaForSchemaTest {

    private static ExecutionInfo executeInfo = new ExecutionInfo();
    private static SymbolControl symbolControl;
    private static DescriptorControl schema_DescControl;
    private static SchemaControl_Info schemaControl_Info;
    private static Map<Symbol, Constructor> fieldSetTupleSpecialized_Constructor_Index_byTypeSymbol;


    public _02_SchemaForSchemaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        symbolControl = new SymbolControl();
        symbolControl.intialize_All_MPSymbols();

        schema_DescControl = new DescriptorControl(symbolControl);

        fieldSetTupleSpecialized_Constructor_Index_byTypeSymbol = new HashMap<Symbol, Constructor>();
        schemaControl_Info = new SchemaControl_Info(fieldSetTupleSpecialized_Constructor_Index_byTypeSymbol);

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
     * Test of build_SchemaForSchema method, of class SchemaForSchema_Container.
     */
    @Test
    public void testBuild_SchemaForSchema() throws Exception {
        System.out.println("build_SchemaForSchema");
        SchemaForSchema_Container schemaForSchema_Container = new SchemaForSchema_Container(executeInfo, schema_DescControl, schemaControl_Info);
        SchemaInfo_Schema schemaForSchema = schemaForSchema_Container.schema4Schema;

        String printoutOfSchemaForSchema = ((Schema)schemaForSchema).printMatrix(true).toString();
/*
 * Here's what the printout looks like:

SCHEMA `SCHEMA_FOR_SCHEMA` (SchemaInfo)
	DESCRIPTOR `DESCRIPTOR` (SchemaInfo)

		DESCRIPTOR `FIELD`.`NAMES` (SchemaInfo) (schemaInfo FieldSet: NAMES)
			FIELD.NAMES: {  (Cont Fields) NAMES  }
			FIELD.TYPES: {  (Cont Fields) `ContinuationType`.`DescriptorTagName`  }

		DESCRIPTOR `FIELD`.`TYPES` (SchemaInfo) (schemaInfo FieldSet: TYPES)
			FIELD.NAMES: {  (Cont Fields) TYPES  }
			FIELD.TYPES: {  (Cont Fields) `ContinuationType`.`Symbol`  }

		DESCRIPTOR `FIELD`.`DESC` (SchemaInfo) (schemaInfo FieldSet: DESC)
			FIELD.NAMES: {  (Cont Fields) DESC  }
			FIELD.TYPES: {  (Cont Fields) `ContinuationType`.`String`  }

		DESCRIPTOR `FIELD`.`DEFAULTS` (SchemaInfo) (schemaInfo FieldSet: DEFAULTS)
			FIELD.NAMES: {  (Cont Fields) DEFAULTS  }
			FIELD.TYPES: {  (Cont Fields) `ContinuationType`.`Object`  }

	DESCRIPTOR `SCHEMA` (SchemaInfo)
	DESCRIPTOR `MATRIX` (SchemaInfo)
	DESCRIPTOR `ITEM` (SchemaInfo)
*/



        String expResult_DescTagname = "SCHEMA";
        String expResults_Label = "`SCHEMA_FOR_SCHEMA`";
        //  **NOTE: eventhough the label for the SchemaForSchema is "SCHEMA_FOR_SCHEMA", getSchemaInfo_DescTagname() for schemaForSchema still returns
        //    just "SCHEMA" like it's supposed to. TEST THIS:
        MatrixName schemaName = MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA;
        DescriptorTag expDescTag = MPSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$SCHEMA;
        assertEquals(expDescTag, schemaForSchema.getSchemaInfo_DescriptorTag());
        assertEquals(schemaName, schemaForSchema.getSchemaInfo_DescriptorTag().getSchemaName_Full());
        assertEquals(expResult_DescTagname, schemaForSchema.getSchemaInfo_DescriptorTagName().getTagName());
        assertEquals(expResults_Label, ((Schema)schemaForSchema).label.getLabel_Simple().toString());




        expResult_DescTagname = "DESCRIPTOR";
        expResults_Label = "`DESCRIPTOR`";
        String expResults_Label_no_Backtiks = "DESCRIPTOR";
        expDescTag = MPSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR;

        SchemaInfo_Descriptor descriptorDescriptor_SchemaInfoDesc = schemaForSchema.getChild_SchemaInfoDescriptor(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.getSingleSymbol_ByName(expResults_Label_no_Backtiks) );

        assertEquals(expDescTag, descriptorDescriptor_SchemaInfoDesc.getSchemaInfo_DescriptorTag());
        assertEquals(schemaName, descriptorDescriptor_SchemaInfoDesc.getSchemaInfo_DescriptorTag().getSchemaName_Full());
        assertEquals(expResult_DescTagname, ((Descriptor)descriptorDescriptor_SchemaInfoDesc).descTagName.getTagName());
        assertEquals(expResults_Label, ((Descriptor)descriptorDescriptor_SchemaInfoDesc).label.getLabel_Simple().toString());


        check_Descriptor_Field_star(descriptorDescriptor_SchemaInfoDesc, "`FIELD`.`NAMES`", MPSymbols_DescTagName.NAMES,
                                    MPSymbols.ContinuationType$__$DescriptorTagName);
        check_Descriptor_Field_star(descriptorDescriptor_SchemaInfoDesc, "`FIELD`.`TYPES`", MPSymbols_DescTagName.TYPES,
                                    MPSymbols.ContinuationType$__$Symbol);
        check_Descriptor_Field_star(descriptorDescriptor_SchemaInfoDesc, "`FIELD`.`DESC`", MPSymbols_DescTagName.DESC,
                                    MPSymbols.ContinuationType$__$String);
        check_Descriptor_Field_star(descriptorDescriptor_SchemaInfoDesc, "`FIELD`.`DEFAULTS`", MPSymbols_DescTagName.DEFAULTS,
                                    MPSymbols.ContinuationType$__$Object);


        expResult_DescTagname = "DESCRIPTOR";
        expResults_Label = "`SCHEMA`";
        expResults_Label_no_Backtiks = "SCHEMA";
        expDescTag = MPSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$SCHEMA;

        SchemaInfo_Descriptor schemaInfoDesc = schemaForSchema.getChild_SchemaInfoDescriptor(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.getSingleSymbol_ByName(expResults_Label_no_Backtiks) );

        assertEquals(expDescTag, schemaInfoDesc.getSchemaInfo_DescriptorTag());
        assertEquals(schemaName, schemaInfoDesc.getSchemaInfo_DescriptorTag().getSchemaName_Full());
        assertEquals(expResult_DescTagname, ((Descriptor)schemaInfoDesc).descTagName.getTagName());
        assertEquals(expResults_Label, ((Descriptor)schemaInfoDesc).label.getLabel_Simple().toString());


        expResult_DescTagname = "DESCRIPTOR";
        expResults_Label = "`MATRIX`";
        expResults_Label_no_Backtiks = "MATRIX";
        schemaInfoDesc = schemaForSchema.getChild_SchemaInfoDescriptor(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.getSingleSymbol_ByName(expResults_Label_no_Backtiks) );

        assertEquals(expResult_DescTagname, ((Descriptor)schemaInfoDesc).descTagName.getTagName());
        assertEquals(expResults_Label, ((Descriptor)schemaInfoDesc).label.getLabel_Simple().toString());


        expResult_DescTagname = "DESCRIPTOR";
        expResults_Label = "`ITEM`";
        expResults_Label_no_Backtiks = "ITEM";
        expDescTag = MPSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$ITEM;

        schemaInfoDesc = schemaForSchema.getChild_SchemaInfoDescriptor(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.getSingleSymbol_ByName(expResults_Label_no_Backtiks) );

        assertEquals(expDescTag, schemaInfoDesc.getSchemaInfo_DescriptorTag());
        assertEquals(schemaName, schemaInfoDesc.getSchemaInfo_DescriptorTag().getSchemaName_Full());
        assertEquals(expResult_DescTagname, ((Descriptor)schemaInfoDesc).descTagName.getTagName());
        assertEquals(expResults_Label, ((Descriptor)schemaInfoDesc).label.getLabel_Simple().toString());

    }




    private void check_Descriptor_Field_star(SchemaInfo_Descriptor parentDescriptor, String fieldStar_Label,
                                            DescriptorTagName fieldName_FieldSetValue, Symbol fieldTypeSymbol_FieldSetValue) throws Exception {


        String expResult_DescTagname = "DESCRIPTOR";
        String expResults_Label = fieldStar_Label;
        Descriptor descriptorFieldStar_Descriptor = ((Descriptor)parentDescriptor).get_ChildDescriptor(executeInfo,
                (Label)symbolControl.labels_Index.multiPart.get_MultiPartSymbol_ByName(expResults_Label));

        assertEquals(expResult_DescTagname, descriptorFieldStar_Descriptor.descTagName.getTagName());
        assertEquals(expResults_Label, descriptorFieldStar_Descriptor.label.getLabel_Simple().toString());
        assertTrue(descriptorFieldStar_Descriptor instanceof SchemaInfo_Descriptor);


        expResult_DescTagname = "FIELD.NAMES";
        String backtik_descTagname = "`FIELD`.`NAMES`";
        DescriptorTag expDescTag = MPSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$NAMES;


        Descriptor child_Desc = descriptorFieldStar_Descriptor.get_ChildDescriptor(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.multiPart.get_MultiPartSymbol_ByName(backtik_descTagname));

        //  ** NOTE: testing actual descriptorTag, not SchemaInfo_DescTag()
        assertEquals(expResult_DescTagname, child_Desc.descTagName.getTagName());
        assertEquals(expDescTag, child_Desc.descTag);
        assertFalse(child_Desc instanceof SchemaInfo_Descriptor);

        // test the fieldset
        assertTrue(child_Desc.has_FieldSet());
        FieldSet_Tuple fieldNames_FieldSet = child_Desc.get_FieldSet_Tuple(executeInfo);
        DescriptorTagName fieldNames_FieldValue = fieldNames_FieldSet.getField_DescTagName(executeInfo, 0);
        assertEquals(0, fieldNames_FieldSet.size_NonContinuationFields());
        assertEquals(1, fieldNames_FieldSet.size_ContinuationFields());
        assertEquals(fieldName_FieldSetValue, fieldNames_FieldValue);

        // test the SchemaInfo FieldSet
        SchemaInfo_FieldSet fieldNames_SchemaInfoFieldSet = (SchemaInfo_FieldSet)fieldNames_FieldSet.schemaInfo_Positioned;
        SchemaInfo_Field fieldNames_SchemaInfoField = fieldNames_SchemaInfoFieldSet.get_SchemaInfoField(executeInfo, 0);
        assertEquals(0, fieldNames_SchemaInfoFieldSet.num_NonContinuationFields);
        assertEquals(1, fieldNames_SchemaInfoFieldSet.num_AllFields);
        assertEquals(MPSymbols_DescTagName.NAMES, fieldNames_SchemaInfoField.fieldName);



        
        expResult_DescTagname = "FIELD.TYPES";
        backtik_descTagname = "`FIELD`.`TYPES`";
        child_Desc = descriptorFieldStar_Descriptor.get_ChildDescriptor(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.multiPart.get_MultiPartSymbol_ByName(backtik_descTagname));

        assertEquals(expResult_DescTagname, child_Desc.descTagName.getTagName());
        assertFalse(child_Desc instanceof SchemaInfo_Descriptor);

        // test the fieldset
        assertTrue(child_Desc.has_FieldSet());
        FieldSet_Tuple fieldTypes_FieldSet = child_Desc.get_FieldSet_Tuple(executeInfo);
        Symbol fieldTypes_FieldValue = fieldTypes_FieldSet.getField_Symbol(executeInfo, 0);
        assertEquals(0, fieldTypes_FieldSet.size_NonContinuationFields());
        assertEquals(1, fieldTypes_FieldSet.size_ContinuationFields());
        assertEquals(fieldTypeSymbol_FieldSetValue, fieldTypes_FieldValue);

        // test the SchemaInfo FieldSet
        SchemaInfo_FieldSet fieldTypes_SchemaInfoFieldSet = (SchemaInfo_FieldSet)fieldTypes_FieldSet.schemaInfo_Positioned;
        SchemaInfo_Field fieldTypes_SchemaInfoField = fieldTypes_SchemaInfoFieldSet.get_SchemaInfoField(executeInfo, MPSymbols_DescTagName.TYPES);
        assertEquals(0, fieldTypes_SchemaInfoFieldSet.num_NonContinuationFields);
        assertEquals(1, fieldTypes_SchemaInfoFieldSet.num_AllFields);
        assertEquals(MPSymbols_DescTagName.TYPES, fieldTypes_SchemaInfoField.fieldName);

    }


}