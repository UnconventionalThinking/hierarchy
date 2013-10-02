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

package net.unconventionalthinking.matrix.metacompiler.codefilegen;

import net.unconventionalthinking.matrix.metacompiler.codegen.*;
import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.matrix.SchemaInfo_Field;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.utilities.TypeUtilities;

/**
 *
 * @author peterjoh
 */
public class FieldSetTypleSpecialized_Utilities {



    static void generate_get_UnusedAndDefault_Code(CodeBuilder codeBuilder, String fieldVarForConditions, SchemaInfo_Field field,
            boolean creatingTypedMethod, int tabLevel) {

        String lineTabs = "";
        for (int i = 0; i < tabLevel; ++i)
            lineTabs += "\t";

        codeBuilder.append(lineTabs).append("} else if (").append(fieldVarForConditions).append(" == FieldConstants.UNUSED) {\n");
        codeBuilder.append(lineTabs).append("\texecuteInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);\n");
        codeBuilder.append(lineTabs).append("\treturn ");

        if (creatingTypedMethod) {
            codeBuilder.append("(").append(field.getFieldType_Symbol_No_ContinuationType().name_no_backtiks).append(")").append(
                CodeGeneratorUtilities.generate_UnusedDefaultValueForType(field.getFieldType_Symbol_No_ContinuationType())
            );
        } else
            codeBuilder.append("null");
        codeBuilder.append(";\n\n");

        codeBuilder.append(lineTabs).append("} else if (").append(fieldVarForConditions).append(" == FieldConstants.NULL) {\n");
        codeBuilder.append(lineTabs).append("\texecuteInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);\n");
        codeBuilder.append(lineTabs).append("\treturn ");
        if (creatingTypedMethod) {
            codeBuilder.append("(").append(field.getFieldType_Symbol_No_ContinuationType().name_no_backtiks).append(")").append(
                CodeGeneratorUtilities.generate_UnusedDefaultValueForType(field.getFieldType_Symbol_No_ContinuationType())
            );
        } else
            codeBuilder.append("null");
        codeBuilder.append(";\n\n");

        codeBuilder.append(lineTabs).append("} else {\n");
        codeBuilder.append(lineTabs).append("\t// no value was set, return default value\n");

        codeBuilder.append(lineTabs).append("\tObject fieldDefaultValue_Raw = \n");
        codeBuilder.append(lineTabs).append("\t\tFieldSet_Worker.getField_DefaultValue(executeInfo, ")
                .append(field.getFieldIndex()).append(", schemaInfo_Positioned);\n");

        codeBuilder.append(lineTabs).append("\treturn (fieldDefaultValue_Raw != null) ? ").append(
                CodeGeneratorUtilities.generate_CastObjectToCorrectType("fieldDefaultValue_Raw",
                    field.getFieldType_Symbol_No_ContinuationType())
            ).append(" : ");

        if (creatingTypedMethod) {
            codeBuilder.append("(").append(field.getFieldType_Symbol_No_ContinuationType().name_no_backtiks).append(")").append(
                CodeGeneratorUtilities.generate_UnusedDefaultValueForType(field.getFieldType_Symbol_No_ContinuationType())
            );
        } else
            codeBuilder.append("null");
        codeBuilder.append(";\n");

        codeBuilder.append(lineTabs).append("}\n");

    }






    static CodeBuilder create_GetContinuationValue_HandlerCode(Symbol fieldType, boolean createTypedMethod, String schemaInfo_FieldIndex_CodeString,
            int tabLevel) {

        CodeBuilder codeBuilder = new CodeBuilder();

        String lineTabs = "";
        for (int i = 0; i < tabLevel; ++i)
            lineTabs += "\t";


        codeBuilder.append("\t\tif (continuationIndex < continuationValues.size()) {\n");
        codeBuilder.append("\t\t\tFieldSet_FieldValueBucket fieldValueBucket = continuationValues.get(continuationIndex);\n");

        if (createTypedMethod) {
            codeBuilder.append("\t\t\tObject value = FieldSet_Worker.getField_ProcessFieldValueBucket(executeInfo, fieldValueBucket, schemaInfo_Positioned, ")
                    .append(schemaInfo_FieldIndex_CodeString).append(");\n");
            codeBuilder.append("\t\t\treturn (value != null) ? ")
                .append(CodeGeneratorUtilities.generate_CastObjectToCorrectType("value", fieldType))
                .append(" : ");
            codeBuilder.append("(").append(fieldType.name_no_backtiks).append(")").append(
                CodeGeneratorUtilities.generate_UnusedDefaultValueForType(fieldType)
            );
            codeBuilder.append(";\n\n");

        } else {
            codeBuilder.append("\t\t\treturn FieldSet_Worker.getField_ProcessFieldValueBucket(executeInfo, fieldValueBucket, schemaInfo_Positioned, ")
                    .append(schemaInfo_FieldIndex_CodeString).append(");\n");

        }
        codeBuilder.append("\n\t\t} else { \n");

        if (createTypedMethod) {
            codeBuilder.append("\t\t\tObject defaultValue = FieldSet_Worker.getField_DefaultValue(executeInfo, ")
                    .append(schemaInfo_FieldIndex_CodeString).append(", schemaInfo_Positioned);\n");
            codeBuilder.append("\t\t\treturn (defaultValue != null) ? ")
                .append(CodeGeneratorUtilities.generate_CastObjectToCorrectType("defaultValue", fieldType))
                .append(" : ");
            codeBuilder.append("(").append(fieldType.name_no_backtiks).append(")").append(
                CodeGeneratorUtilities.generate_UnusedDefaultValueForType(fieldType)
            );
            codeBuilder.append(";\n\n");

        } else {
            codeBuilder.append("\t\t\treturn FieldSet_Worker.getField_DefaultValue(executeInfo, ")
                    .append(schemaInfo_FieldIndex_CodeString).append(", schemaInfo_Positioned);\n\n");
        }

        codeBuilder.append("\t\t}\n\n");

        return codeBuilder;

    }


    static CodeBuilder create_SetContinuationValue_HandlerCode(Symbol valueTypeSymbol, boolean createTypedMethod, int tabLevel) {

        CodeBuilder codeBuilder = new CodeBuilder();

        String lineTabs = "";
        for (int i = 0; i < tabLevel; ++i)
            lineTabs += "\t";


        codeBuilder.append(lineTabs).append("if (continuationIndex == continuationValues.size()) {  // add to end\n");
        codeBuilder.append(lineTabs).append("\tFieldSet_Worker.setField_AddNewValue_to_EndOfList(");
        if (createTypedMethod && TypeUtilities.is_PrimitiveType(valueTypeSymbol)) {
            codeBuilder.append(
                CodeGeneratorUtilities.generate_WrapPrimitiveInPrimitiveObject("value", valueTypeSymbol)
            );
        } else
            codeBuilder.append("value");
        codeBuilder.append(", continuationValues, this);\n\n");


        codeBuilder.append(lineTabs).append("} else if (continuationIndex < continuationValues.size()) {\n");
        codeBuilder.append(lineTabs).append("\tFieldSet_Worker.setField_ReplaceExistingValue_in_List(");
        if (createTypedMethod && TypeUtilities.is_PrimitiveType(valueTypeSymbol)) {
            codeBuilder.append(
                CodeGeneratorUtilities.generate_WrapPrimitiveInPrimitiveObject("value", valueTypeSymbol)
            );
        } else
            codeBuilder.append("value");
        codeBuilder.append(", continuationIndex, continuationValues, this);\n\n");
        codeBuilder.append(lineTabs).append("} else {\n");
        codeBuilder.append(lineTabs).append("\t//  Error\n");
        codeBuilder.append(lineTabs).append("\tthrow new Exception_InvalidArgumentPassed(")
                .append("\"Tried to access the continuation field with an index greater than the number of field values. The continuation index that ")
                .append("was passed was, \" + continuationIndex +  \", and the number of continuation values is, \" + continuationValues.size() +  \".\");");
        codeBuilder.append(lineTabs).append("}\n");


        return codeBuilder;
    }



    static CodeBuilder create_SetContinuationSpecialValue_HandlerCode(Symbol valueTypeSymbol, int tabLevel) {

        CodeBuilder codeBuilder = new CodeBuilder();

        String lineTabs = "";
        for (int i = 0; i < tabLevel; ++i)
            lineTabs += "\t";

        codeBuilder.append(lineTabs).append("if (continuationIndex == continuationValues.size()) {  // add to end\n");
        codeBuilder.append(lineTabs).append("\tFieldSet_Worker.setFieldSpecial_AddNewValue_to_EndOfList(specialValue, continuationValues, this);\n\n");


        codeBuilder.append(lineTabs).append("} else if (continuationIndex < continuationValues.size()) {\n");
        codeBuilder.append(lineTabs).append("\tFieldSet_Worker.setFieldSpecial_ReplaceExistingValue_in_List(specialValue, continuationIndex, continuationValues, this);\n\n");
        codeBuilder.append(lineTabs).append("} else {\n");
        codeBuilder.append(lineTabs).append("\t//  Error\n");
        codeBuilder.append(lineTabs).append("\tthrow new Exception_InvalidArgumentPassed(")
                .append("\"Tried to access the continuation field with an index greater than the number of field values. The continuation index that ")
                .append("was passed was, \" + continuationIndex +  \", and the number of continuation values is, \" + continuationValues.size() +  \".\");");
        codeBuilder.append(lineTabs).append("}\n");

        return codeBuilder;
    }


}
