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

import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import static org.junit.Assert.*;
/**
 *
 * @author peterjoh
 */
public class TestUtilities_1_SchemaTester {

    SchemaInfo_Descriptor schemaInfoDesc_for_formRequired_SchemaInfoDesc;
    SchemaInfo_Descriptor formRequired_SchemaInfoDesc;

    String fieldNames;
    Descriptor fieldNames_Desc;
    String expResults_fieldNames;
    SchemaInfo_Descriptor schemaInfoDesc_for_fieldNamesDesc;
    FieldSet_Tuple fieldNames_FieldSet;

    String fieldTypes;
    Descriptor fieldTypes_Desc;
    String expResults_fieldTypes;
    SchemaInfo_Descriptor schemaInfoDesc_for_fieldTypesDesc;
    FieldSet_Tuple fieldTypes_FieldSet;



    public void testSchema_FirstPart(SchemaInfo_Schema webForm_Schema, ExecutionInfo executeInfo, SymbolControl symbolControl)
        throws Exception {


        assertEquals("SCHEMA", ((Descriptor)webForm_Schema).descTagName.getTagName());

        //  ____________________________________________________________________________________________________________
        //
        //  FORM.REQUIRED
        //  ____________________________________________________________________________________________________________
        String formRequired = "`FORM`.`REQUIRED`";
        String expResults_formRequired = "FORM.REQUIRED";
        formRequired_SchemaInfoDesc = webForm_Schema.getChild_SchemaInfoDescriptor(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.multiPart.get_MultiPartSymbol_ByName(formRequired));
        assertEquals(expResults_formRequired, formRequired_SchemaInfoDesc.getSchemaInfo_DescriptorTag().getDescTagName().getTagName());

        //  Test the schemaInfo's schemaInfo!! (meaning, get this schemaInfo_Descriptor's schemaInfo, which is: SchemaForSchema->DESCRIPTOR `DESCRIPTOR`)
        schemaInfoDesc_for_formRequired_SchemaInfoDesc =
                (SchemaInfo_Descriptor) ((Descriptor)formRequired_SchemaInfoDesc).schemaInfo_Positioned;
        assertEquals(false, schemaInfoDesc_for_formRequired_SchemaInfoDesc.getSchemaInfo_canHave_FieldSet());
        assertEquals("DESCRIPTOR", schemaInfoDesc_for_formRequired_SchemaInfoDesc.getSchemaInfo_DescriptorTag().getDescTagName().getTagName());
        assertEquals(4, schemaInfoDesc_for_formRequired_SchemaInfoDesc.getSchemaInfo_ChildSchemaInfoDesc_List().size()); // FIELD.* schemaInfoDesc's




        //  DESCRIPTOR `FORM`.`REQUIRED`-> FIELD.NAMES_____________________________________________________________
        fieldNames = "`FIELD`.`NAMES`";
        expResults_fieldNames = "FIELD.NAMES";
        fieldNames_Desc = formRequired_SchemaInfoDesc.getSchemaInfo_FieldDescriptor(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.multiPart.get_MultiPartSymbol_ByName(fieldNames));
        assertEquals(expResults_fieldNames, fieldNames_Desc.descTagName.getTagName());

        //  Test the desc's schemaInfo. (which is: SchemaForSchema->DESCRIPTOR `DESCRIPTOR`->DESCRIPTOR `FIELD`.`NAMES`)
        schemaInfoDesc_for_fieldNamesDesc = (SchemaInfo_Descriptor)fieldNames_Desc.schemaInfo_Positioned;
        assertEquals(true, schemaInfoDesc_for_fieldNamesDesc.getSchemaInfo_canHave_FieldSet());
        assertEquals("FIELD.NAMES", schemaInfoDesc_for_fieldNamesDesc.getSchemaInfo_DescriptorTag().getDescTagName().getTagName());

        fieldNames_FieldSet = fieldNames_Desc.get_FieldSet_Tuple(executeInfo);
        //  Test the fieldSet
        assertEquals("IsRequired", fieldNames_FieldSet.getField_DescTagName(executeInfo, 0).getTagName());
        assertEquals("RequiredImagePath", fieldNames_FieldSet.getField_DescTagName(executeInfo, 1).getTagName());
        assertEquals("ImageHeight", fieldNames_FieldSet.getField_DescTagName(executeInfo, 2).getTagName());
        assertEquals("ImageWidth", fieldNames_FieldSet.getField_DescTagName(executeInfo, 3).getTagName());


        //  DESCRIPTOR `FORM`.`REQUIRED`-> FIELD.TYPES_____________________________________________________________
        fieldTypes = "`FIELD`.`TYPES`";
        expResults_fieldTypes = "FIELD.TYPES";
        fieldTypes_Desc = formRequired_SchemaInfoDesc.getSchemaInfo_FieldDescriptor(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.multiPart.get_MultiPartSymbol_ByName(fieldTypes));
        assertEquals(expResults_fieldTypes, fieldTypes_Desc.descTagName.getTagName());

        //  Test the desc's schemaInfo. (which is: SchemaForSchema->DESCRIPTOR `DESCRIPTOR`->DESCRIPTOR `FIELD`.`TYPES`)
        schemaInfoDesc_for_fieldTypesDesc = (SchemaInfo_Descriptor)fieldTypes_Desc.schemaInfo_Positioned;
        assertEquals(true, schemaInfoDesc_for_fieldTypesDesc.getSchemaInfo_canHave_FieldSet());
        assertEquals("FIELD.TYPES", schemaInfoDesc_for_fieldTypesDesc.getSchemaInfo_DescriptorTag().getDescTagName().getTagName());


        fieldTypes_FieldSet = fieldTypes_Desc.get_FieldSet_Tuple(executeInfo);
        //  Test the fieldSet
        assertEquals(MPSymbols.Symbol, fieldTypes_FieldSet.getField_Symbol(executeInfo, 0));
        assertEquals(MPSymbols.String, fieldTypes_FieldSet.getField_Symbol(executeInfo, 1));
        assertEquals(MPSymbols.int$_sym_$, fieldTypes_FieldSet.getField_Symbol(executeInfo, 2));
        assertEquals(MPSymbols.int$_sym_$, fieldTypes_FieldSet.getField_Symbol(executeInfo, 3));

    }





    public void testSchema_SecondPart(SchemaInfo_Schema webForm_Schema, ExecutionInfo executeInfo, SymbolControl symbolControl)
        throws Exception {


        String regForm_PrintOut = ((Schema)webForm_Schema).printMatrix(true).toString();

/*
SCHEMA `WEB`.`FORM` (SchemaInfo)
	DESCRIPTOR `FORM`.`REQUIRED` (SchemaInfo) (schemaInfo FieldSet: IsRequired, RequiredImagePath, ImageHeight, ImageWidth)
		FIELD.NAMES: {  (Cont Fields) `IsRequired`, `RequiredImagePath`, `ImageHeight`, `ImageWidth`  }
		FIELD.TYPES: {  (Cont Fields) `Symbol`, `String`, `int`, `int`  }
		FIELD.DESC: {  (Cont Fields) "Is this a required field?", "The path image file that marks required fields.", "The height of the image.", "The width of the image."  }
		FIELD.DEFAULTS: {  (Cont Fields) `NotRequired`, "/images/required.gif", 6, 7  }
	DESCRIPTOR `FORM`.`SELECT` (SchemaInfo) (schemaInfo FieldSet: Name, onChange)
		FIELD.NAMES: {  (Cont Fields) `Name`, `onChange`  }
		FIELD.TYPES: {  (Cont Fields) `String`, `String`  }
		FIELD.DESC: {  (Cont Fields) "Name of Select", "The javascript code for what happens during the onchange event for the select."  }
		FIELD.DEFAULTS: {  (Cont Fields) "", null  }
		DESCRIPTOR `OPTION` (SchemaInfo) (schemaInfo FieldSet: Value, Label, Selected)
			FIELD.NAMES: {  (Cont Fields) `Value`, `Label`, `Selected`  }
			FIELD.TYPES: {  (Cont Fields) `String`, `String`, `Symbol`  }
			FIELD.DESC: {  (Cont Fields) "Value of option", "Name of option.", "Whether the option is the default selected or not."  }
			FIELD.DEFAULTS: {  (Cont Fields) null, null, `NotSelected`  }

 */




        //  DESCRIPTOR `FORM`.`REQUIRED`-> FIELD.DESC _________________________________________________________________
        String fieldDescription = "`FIELD`.`DESC`";
        String expResults_fieldDescription = "FIELD.DESC";
        Descriptor fieldDescription_Desc = formRequired_SchemaInfoDesc.getSchemaInfo_FieldDescriptor(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.multiPart.get_MultiPartSymbol_ByName(fieldDescription));
        assertEquals(expResults_fieldDescription, fieldDescription_Desc.descTagName.getTagName());

        //  Test the desc's schemaInfo. (which is: SchemaForSchema->DESCRIPTOR `DESCRIPTOR`->DESCRIPTOR `FIELD`.`DESC`)
        SchemaInfo_Descriptor schemaInfoDesc_for_fieldDescriptionDesc = (SchemaInfo_Descriptor)fieldDescription_Desc.schemaInfo_Positioned;
        assertEquals(true, schemaInfoDesc_for_fieldDescriptionDesc.getSchemaInfo_canHave_FieldSet());
        assertEquals("FIELD.DESC", schemaInfoDesc_for_fieldDescriptionDesc.getSchemaInfo_DescriptorTag().getDescTagName().getTagName());


        FieldSet_Tuple fieldDescription_FieldSet = fieldDescription_Desc.get_FieldSet_Tuple(executeInfo);
        //  Test the fieldSet
        assertEquals("Is this a required field?", fieldDescription_FieldSet.getField_String(executeInfo, 0));
        assertEquals("The path image file that marks required fields.", fieldDescription_FieldSet.getField_String(executeInfo, 1));
        assertEquals("The height of the image.", fieldDescription_FieldSet.getField_String(executeInfo, 2));
        assertEquals("The width of the image.", fieldDescription_FieldSet.getField_String(executeInfo, 3));


        //  DESCRIPTOR `FORM`.`REQUIRED`-> FIELD.DEFAULTS_____________________________________________________________
        String fieldDefaults = "`FIELD`.`DEFAULTS`";
        String expResults_fieldDefaults = "FIELD.DEFAULTS";
        Descriptor fieldDefaults_Desc = formRequired_SchemaInfoDesc.getSchemaInfo_FieldDescriptor(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.multiPart.get_MultiPartSymbol_ByName(fieldDefaults));
        assertEquals(expResults_fieldDefaults, fieldDefaults_Desc.descTagName.getTagName());

        //  Test the desc's schemaInfo. (which is: SchemaForSchema->DESCRIPTOR `DESCRIPTOR`->DESCRIPTOR `FIELD`.`DEFAULTS`)
        SchemaInfo_Descriptor schemaInfoDesc_for_fieldDefaultsDesc = (SchemaInfo_Descriptor)fieldDefaults_Desc.schemaInfo_Positioned;
        assertEquals(true, schemaInfoDesc_for_fieldDefaultsDesc.getSchemaInfo_canHave_FieldSet());
        assertEquals("FIELD.DEFAULTS", schemaInfoDesc_for_fieldDefaultsDesc.getSchemaInfo_DescriptorTag().getDescTagName().getTagName());

        FieldSet_Tuple fieldDefaults_FieldSet = fieldDefaults_Desc.get_FieldSet_Tuple(executeInfo);
        //  Test the fieldSet
        assertEquals("NotRequired", fieldDefaults_FieldSet.getField_Symbol(executeInfo, 0).name);
        assertEquals("/images/required.gif", fieldDefaults_FieldSet.getField_String(executeInfo, 1));
        assertEquals(6, fieldDefaults_FieldSet.getField_int(executeInfo, 2));
        assertEquals(7, fieldDefaults_FieldSet.getField_int(executeInfo, 3));





        //  ____________________________________________________________________________________________________________
        //
        //  DESCRIPTOR `FORM`.`SELECT`
        //  ____________________________________________________________________________________________________________
        String formSelect = "`FORM`.`SELECT`";
        String expResult_formSelect = "FORM.SELECT";
        SchemaInfo_Descriptor formSelect_SchemaInfoDesc = webForm_Schema.getChild_SchemaInfoDescriptor(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.multiPart.get_MultiPartSymbol_ByName(formSelect));
        assertEquals(expResult_formSelect, formSelect_SchemaInfoDesc.getSchemaInfo_DescriptorTag().getDescTagName().getTagName());

        //  Test the schemaInfo's schemaInfo!! (meaning, get this schemaInfo_Descriptor's schemaInfo, which is: SchemaForSchema->DESCRIPTOR `DESCRIPTOR`)
        SchemaInfo_Descriptor schemaInfoDesc_for_formSelect_SchemaInfoDesc =
                (SchemaInfo_Descriptor) ((Descriptor)formRequired_SchemaInfoDesc).schemaInfo_Positioned;
        assertEquals(false, schemaInfoDesc_for_formSelect_SchemaInfoDesc.getSchemaInfo_canHave_FieldSet());
        assertEquals("DESCRIPTOR", schemaInfoDesc_for_formSelect_SchemaInfoDesc.getSchemaInfo_DescriptorTag().getDescTagName().getTagName());
        assertEquals(4, schemaInfoDesc_for_formRequired_SchemaInfoDesc.getSchemaInfo_ChildSchemaInfoDesc_List().size()); // FIELD.* schemaInfoDesc's



        //  DESCRIPTOR `FORM`.`SELECT`-> FIELD.NAMES_____________________________________________________________
        fieldNames_Desc = formSelect_SchemaInfoDesc.getSchemaInfo_FieldDescriptor(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.multiPart.get_MultiPartSymbol_ByName(fieldNames));
        assertEquals(expResults_fieldNames, fieldNames_Desc.descTagName.getTagName());

        //  Check the full path of the field, see that it's right
        StringBuilder fieldNames_FullPath_buffer = new StringBuilder();
        fieldNames_Desc.getFullPath_String(executeInfo, fieldNames_FullPath_buffer);
        String fieldNames_FullPath = fieldNames_FullPath_buffer.toString();
        String expResult_FieldNames_FullPath = "SCHEMA `WEB`.`FORM`->DESCRIPTOR `FORM`.`SELECT`->FIELD.NAMES";
        assertEquals(expResult_FieldNames_FullPath, fieldNames_FullPath);

        //  Test the desc's schemaInfo. (which is: SchemaForSchema->DESCRIPTOR `DESCRIPTOR`->DESCRIPTOR `FIELD`.`NAMES`)
        schemaInfoDesc_for_fieldNamesDesc = (SchemaInfo_Descriptor)fieldNames_Desc.schemaInfo_Positioned;
        assertEquals(true, schemaInfoDesc_for_fieldNamesDesc.getSchemaInfo_canHave_FieldSet());
        assertEquals("FIELD.NAMES", schemaInfoDesc_for_fieldNamesDesc.getSchemaInfo_DescriptorTag().getDescTagName().getTagName());

        fieldNames_FieldSet = fieldNames_Desc.get_FieldSet_Tuple(executeInfo);
        //  Test the fieldSet
        assertEquals("Name", fieldNames_FieldSet.getField_DescTagName(executeInfo, 0).getTagName());
        assertEquals("onChange", fieldNames_FieldSet.getField_DescTagName(executeInfo, 1).getTagName());



        //  DESCRIPTOR `FORM`.`SELECT`-> FIELD.TYPES_____________________________________________________________
        fieldTypes_Desc = formSelect_SchemaInfoDesc.getSchemaInfo_FieldDescriptor(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.multiPart.get_MultiPartSymbol_ByName(fieldTypes));
        assertEquals(expResults_fieldTypes, fieldTypes_Desc.descTagName.getTagName());

        fieldTypes_FieldSet = fieldTypes_Desc.get_FieldSet_Tuple(executeInfo);
        //  Test the fieldSet
        assertEquals(MPSymbols.String, fieldTypes_FieldSet.getField_Symbol(executeInfo, 0));
        assertEquals(MPSymbols.String, fieldTypes_FieldSet.getField_Symbol(executeInfo, 1));

        //  Test the desc's schemaInfo. (which is: SchemaForSchema->DESCRIPTOR `DESCRIPTOR`->DESCRIPTOR `FIELD`.`TYPES`)
        schemaInfoDesc_for_fieldTypesDesc = (SchemaInfo_Descriptor)fieldTypes_Desc.schemaInfo_Positioned;
        assertEquals(true, schemaInfoDesc_for_fieldTypesDesc.getSchemaInfo_canHave_FieldSet());
        assertEquals("FIELD.TYPES", schemaInfoDesc_for_fieldTypesDesc.getSchemaInfo_DescriptorTag().getDescTagName().getTagName());



        //  DESCRIPTOR `FORM`.`REQUIRED`-> FIELD.DESC _________________________________________________________________

        fieldDescription_Desc = formSelect_SchemaInfoDesc.getSchemaInfo_FieldDescriptor(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.multiPart.get_MultiPartSymbol_ByName(fieldDescription));
        assertEquals(expResults_fieldDescription, fieldDescription_Desc.descTagName.getTagName());

        fieldDescription_FieldSet = fieldDescription_Desc.get_FieldSet_Tuple(executeInfo);
        //  Test the fieldSet
        assertEquals("Name of Select", fieldDescription_FieldSet.getField_String(executeInfo, 0));
        assertEquals("The javascript code for what happens during the onchange event for the select.", fieldDescription_FieldSet.getField_String(executeInfo, 1));


        //  DESCRIPTOR `FORM`.`REQUIRED`-> FIELD.DEFAULTS_____________________________________________________________
        fieldDefaults_Desc = formSelect_SchemaInfoDesc.getSchemaInfo_FieldDescriptor(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.multiPart.get_MultiPartSymbol_ByName(fieldDefaults));
        assertEquals(expResults_fieldDefaults, fieldDefaults_Desc.descTagName.getTagName());

        fieldDefaults_FieldSet = fieldDefaults_Desc.get_FieldSet_Tuple(executeInfo);
        //  Test the fieldSet
        assertEquals("", fieldDefaults_FieldSet.getField_String(executeInfo, 0));
        assertEquals(null, fieldDefaults_FieldSet.getField_String(executeInfo, 1));




        //  ____________________________________________________________________________________________________________
        //
        //  DESCRIPTOR `FORM`.`SELECT`-> DESCRIPTOR `OPTION`
        //  ____________________________________________________________________________________________________________

        String option = "OPTION";
        SchemaInfo_Descriptor option_SchemaInfoDesc = formSelect_SchemaInfoDesc.getChild_SchemaInfoDescriptor(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.getSingleSymbol_ByName(option));
        assertEquals(option, option_SchemaInfoDesc.getSchemaInfo_DescriptorTag().getDescTagName().getTagName());

        //  Test the schemaInfo's schemaInfo!! (meaning, get this schemaInfo_Descriptor's schemaInfo, which is: SchemaForSchema->DESCRIPTOR `DESCRIPTOR`)
        SchemaInfo_Descriptor schemaInfoDesc_for_option_SchemaInfoDesc =
                (SchemaInfo_Descriptor) ((Descriptor)option_SchemaInfoDesc).schemaInfo_Positioned;
        assertEquals(false, schemaInfoDesc_for_option_SchemaInfoDesc.getSchemaInfo_canHave_FieldSet());
        assertEquals("DESCRIPTOR", schemaInfoDesc_for_option_SchemaInfoDesc.getSchemaInfo_DescriptorTag().getDescTagName().getTagName());
        assertEquals(4, schemaInfoDesc_for_option_SchemaInfoDesc.getSchemaInfo_ChildSchemaInfoDesc_List().size()); // FIELD.* schemaInfoDesc's




        fieldNames_Desc = option_SchemaInfoDesc.getSchemaInfo_FieldDescriptor(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.multiPart.get_MultiPartSymbol_ByName(fieldNames));
        fieldNames_FieldSet = fieldNames_Desc.get_FieldSet_Tuple(executeInfo);

        //  Test the desc's schemaInfo. (which is: SchemaForSchema->DESCRIPTOR `DESCRIPTOR`->DESCRIPTOR `FIELD`.`NAMES`)
        schemaInfoDesc_for_fieldNamesDesc = (SchemaInfo_Descriptor)fieldNames_Desc.schemaInfo_Positioned;
        assertEquals(true, schemaInfoDesc_for_fieldNamesDesc.getSchemaInfo_canHave_FieldSet());
        assertEquals("FIELD.NAMES", schemaInfoDesc_for_fieldNamesDesc.getSchemaInfo_DescriptorTag().getDescTagName().getTagName());

        //  Test the fieldSet
        assertEquals("Value", fieldNames_FieldSet.getField_DescTagName(executeInfo, 0).getTagName());
        assertEquals("Label", fieldNames_FieldSet.getField_DescTagName(executeInfo, 1).getTagName());
        assertEquals("Selected", fieldNames_FieldSet.getField_DescTagName(executeInfo, 2).getTagName());


        assertEquals(expResults_fieldNames, fieldNames_Desc.descTagName.getTagName());
        fieldTypes_Desc = option_SchemaInfoDesc.getSchemaInfo_FieldDescriptor(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.multiPart.get_MultiPartSymbol_ByName(fieldTypes));
        assertEquals(expResults_fieldTypes, fieldTypes_Desc.descTagName.getTagName());

        fieldTypes_FieldSet = fieldTypes_Desc.get_FieldSet_Tuple(executeInfo);
        //  Test the fieldSet
        assertEquals(MPSymbols.String, fieldTypes_FieldSet.getField_Symbol(executeInfo, 0));
        assertEquals(MPSymbols.String, fieldTypes_FieldSet.getField_Symbol(executeInfo, 1));
        assertEquals(MPSymbols.Symbol, fieldTypes_FieldSet.getField_Symbol(executeInfo, 2));


        fieldDescription_Desc = option_SchemaInfoDesc.getSchemaInfo_FieldDescriptor(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.multiPart.get_MultiPartSymbol_ByName(fieldDescription));
        assertEquals(expResults_fieldDescription, fieldDescription_Desc.descTagName.getTagName());

        fieldDescription_FieldSet = fieldDescription_Desc.get_FieldSet_Tuple(executeInfo);
        //  Test the fieldSet
        assertEquals("Value of option", fieldDescription_FieldSet.getField_String(executeInfo, 0));
        assertEquals("Name of option.", fieldDescription_FieldSet.getField_String(executeInfo, 1));
        assertEquals("Whether the option is the default selected or not.", fieldDescription_FieldSet.getField_String(executeInfo, 2));



        fieldDefaults_Desc = option_SchemaInfoDesc.getSchemaInfo_FieldDescriptor(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.multiPart.get_MultiPartSymbol_ByName(fieldDefaults));
        assertEquals(expResults_fieldDefaults, fieldDefaults_Desc.descTagName.getTagName());

        //  Check the full path of the field, see that it's right
        fieldNames_FullPath_buffer = new StringBuilder();
        fieldNames_Desc.getFullPath_String(executeInfo, fieldNames_FullPath_buffer);
        fieldNames_FullPath = fieldNames_FullPath_buffer.toString();
        expResult_FieldNames_FullPath = "SCHEMA `WEB`.`FORM`->DESCRIPTOR `FORM`.`SELECT`->DESCRIPTOR `OPTION`->FIELD.NAMES";
        assertEquals(expResult_FieldNames_FullPath, fieldNames_FullPath);

        fieldDefaults_FieldSet = fieldDefaults_Desc.get_FieldSet_Tuple(executeInfo);
        //  Test the fieldSet
        assertEquals(null, fieldDefaults_FieldSet.getField_String(executeInfo, 0));
        assertEquals(null, fieldDefaults_FieldSet.getField_String(executeInfo, 1));
        assertEquals("NotSelected", fieldDefaults_FieldSet.getField_Symbol(executeInfo, 2).name);





        //  Error test - try to set a field with a value of the wrong type

        FieldSet_Tuple formSelect_FieldDescription_FieldSet = fieldDescription_Desc.get_FieldSet_Tuple(executeInfo);
        //  First, set it to a value of the CORRECT type
        formSelect_FieldDescription_FieldSet.setField_String(executeInfo, 0, "Should be okay");

        // Now, try the wrong type
        boolean had_error = false;
        try {
            formSelect_FieldDescription_FieldSet.setField_int(executeInfo, 0, -999); // wrong type, should be string and should throw exception
        } catch (Exception_InvalidArgumentPassed e) {
            had_error = true;
        }
        assertTrue(had_error);


    }
}
