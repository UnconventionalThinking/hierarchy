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

import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.lang.Pair;
import net.unconventionalthinking.matrix.FieldConstants;
import net.unconventionalthinking.matrix.FieldSet;
import net.unconventionalthinking.matrix.FieldSet_ParameterMap;
import net.unconventionalthinking.matrix.FieldValueInfo;
import net.unconventionalthinking.matrix.SchemaInfo_Descriptor;
import net.unconventionalthinking.matrix.SchemaInfo_Field;
import net.unconventionalthinking.matrix.SchemaInfo_FieldSet;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolConstants;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.matrix.utilities.TypeUtilities;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import java.util.List;

/**
 *
 * @author peterjoh
 */
public class DescriptorCreation_CodeGenerator_FieldSetWorker {



    static void generate_FieldSetTuple(ExecutionInfo executeInfo, CodeBuilder codeBuilder, String baseIndent, SchemaInfo_FieldSet schemaInfo_FieldSet,
            String descriptor_OutVarName, boolean fieldSet_is_Tuple, List<String> fieldValueExpr_List, List<FieldValueInfo> fieldValueInfo_List,
            String appClasses_PackageName)
        throws Exception_MetaCompilerError {

        String descFieldSet_OutVarName = descriptor_OutVarName +
                SymbolConstants.SymbolPath_IdentifierGroupSeparator + CodeConstants.OutVarName_FieldSet_Suffix;


        String fieldSet_Type = null;
        String fieldSet_Cast = "";

        if (schemaInfo_FieldSet != null) {
            if (schemaInfo_FieldSet.has_SpecializedFieldSet()) {
                fieldSet_Type = appClasses_PackageName + "." + schemaInfo_FieldSet.get_FieldSetTypeString();
                fieldSet_Cast = "(" + fieldSet_Type + ")";
            } else {
                fieldSet_Type = FieldSet.class.getSimpleName();
            }

            codeBuilder.append(baseIndent + fieldSet_Type + " " + descFieldSet_OutVarName + " = " + fieldSet_Cast +
                    descriptor_OutVarName + ".get_FieldSet_Tuple(executeInfo);\n");


            for (int i = 0; i < fieldValueExpr_List.size(); ++i) {
                generate_SetFieldToValue_byFieldIndex(executeInfo, codeBuilder, baseIndent, descFieldSet_OutVarName, i, fieldValueExpr_List.get(i),
                        fieldValueInfo_List.get(i), schemaInfo_FieldSet);
            }

        }
    }





    static void generate_FieldSetParameterMap(ExecutionInfo executeInfo, CodeBuilder codeBuilder, SymbolControl symbolControl, 
            HierarchySettings hierarchySettings, String baseIndent, SchemaInfo_FieldSet schemaInfo_FieldSet, String descriptor_OutVarName,
            boolean fieldSet_is_Tuple, List<Pair<DescriptorTagName,String>> fieldToValue_List, List<FieldValueInfo> fieldValueInfo_List)
        throws Exception_MetaCompilerError {

        String descFieldSet_OutVarName = descriptor_OutVarName +
                    SymbolConstants.SymbolPath_IdentifierGroupSeparator + CodeConstants.OutVarName_FieldSet_Suffix;

        codeBuilder.append(baseIndent + FieldSet_ParameterMap.class.getSimpleName() +  " " + descFieldSet_OutVarName + " = " +
                descriptor_OutVarName + ".get_FieldSet_ParameterMap(executeInfo);\n");


        for (int i = 0; i < fieldToValue_List.size(); ++i) {
            Pair<DescriptorTagName, String> fieldName_and_Value = fieldToValue_List.get(i);
            generate_SetFieldToValue_ByFieldName(executeInfo, codeBuilder, hierarchySettings, baseIndent, descFieldSet_OutVarName,
                    fieldName_and_Value.first, fieldName_and_Value.second, fieldValueInfo_List.get(i), schemaInfo_FieldSet);
        }
    }






    static void generate_SetFieldToValue_byFieldIndex(ExecutionInfo executeInfo, CodeBuilder codeBuilder, String baseIndent, 
            String descFieldSet_OutVarName, int fieldIndex, String fieldValueExpression_Raw, FieldValueInfo fieldValueInfo,
            SchemaInfo_FieldSet schemaInfo_FieldSet)
            throws Exception_MetaCompilerError {


        SchemaInfo_Field schemaInfo_Field = null;
        try {
            schemaInfo_Field = schemaInfo_FieldSet.get_SchemaInfoField(executeInfo, fieldIndex);

        } catch (Exception_InvalidArgumentPassed e) {
            String descName = "<null>";
            if (schemaInfo_FieldSet != null && schemaInfo_FieldSet.getSchemaInfo_ParentSchemaInfo(executeInfo) != null)
                descName = ((SchemaInfo_Descriptor)schemaInfo_FieldSet.getSchemaInfo_ParentSchemaInfo(executeInfo))
                        .getSchemaInfo_DescriptorTagName().getTagName();

            throw new Exception_MetaCompilerError("tried to find the schemaInfo for the Field in the descriptor with tagName " + descName + ", and with a field at the index, '" + fieldIndex + "', but could not find it.", e);
        }




        String setField_Suffix = "";
        if (fieldValueInfo.is_SpecialValue())
            setField_Suffix = CodeConstants.FieldSet_SetMethodNameSuffix_Special;

        String fieldValueExpression = determine_FieldValueExpression(fieldValueInfo, fieldValueExpression_Raw);


        if (!schemaInfo_FieldSet.has_SpecializedFieldSet()) {
            Symbol fieldTypeSymbol = schemaInfo_Field.getFieldType_Symbol_No_ContinuationType();

            if (TypeUtilities.is_PrimitiveType(fieldTypeSymbol)) {
                String type_or_SpecialValueSuffix = (setField_Suffix.length() > 0) ? setField_Suffix : "_" + fieldTypeSymbol.name_IdentFormat;

                codeBuilder.append(baseIndent + descFieldSet_OutVarName + ".setField" + type_or_SpecialValueSuffix +
                    "(executeInfo, " + fieldIndex + ", " + fieldValueExpression + ")");
            } else {
                // some type of Object, so just use the general setField.
                codeBuilder.append(baseIndent + descFieldSet_OutVarName + ".setField" + setField_Suffix + "(executeInfo, " + fieldIndex +
                    ", " + fieldValueExpression + ")");
            }

        } else { // Specialized field set, so use fieldName set methods

            if (schemaInfo_Field.is_ContinuationField()) {
                codeBuilder.append(baseIndent + descFieldSet_OutVarName + ".set_" + schemaInfo_Field.getFieldName().getTagName() + setField_Suffix +
                        "(executeInfo, "  + (fieldIndex - schemaInfo_FieldSet.getNumFields(false)) + ", " + fieldValueExpression + ")");

            } else {
                codeBuilder.append(baseIndent + descFieldSet_OutVarName + ".set_" + schemaInfo_Field.getFieldName().getTagName() + setField_Suffix +
                        "(executeInfo, " + fieldValueExpression + ")");
            }
        }
        codeBuilder.append(";\n");
    }





    static void generate_SetFieldToValue_ByFieldName(ExecutionInfo executeInfo, CodeBuilder codeBuilder, HierarchySettings hierarchySettings,
            String baseIndent, String descFieldSet_OutVarName, DescriptorTagName fieldName, String fieldValueExpression_Raw, FieldValueInfo fieldValueInfo,
            SchemaInfo_FieldSet schemaInfo_FieldSet)
            throws Exception_MetaCompilerError {


        SchemaInfo_Field schemaInfo_Field = null;
        schemaInfo_Field = schemaInfo_FieldSet.get_SchemaInfoField(executeInfo, fieldName);

        if (schemaInfo_Field == null) {
            String descName = "<null>";
            if (fieldName != null)
                descName = fieldName.getTagName();

            throw new Exception_MetaCompilerError("tried to find the schemaInfo for the Field in the descriptor with tagName '" + descName + "', but could not find it.");
        }



        String setField_Suffix = "";
        if (fieldValueInfo.is_SpecialValue())
            setField_Suffix = CodeConstants.FieldSet_SetMethodNameSuffix_Special;

        String fieldValueExpression = determine_FieldValueExpression(fieldValueInfo, fieldValueExpression_Raw);

        Symbol fieldTypeSymbol = schemaInfo_Field.getFieldType_Symbol_No_ContinuationType();

        String descTagName_OutputAccessCode = hierarchySettings.appSymbolClassName_DescTagName + "." + fieldName.getSymbol().name_IdentFormat;


        if (TypeUtilities.is_PrimitiveType(fieldTypeSymbol)) {
            String type_or_SpecialValueSuffix = (setField_Suffix.length() > 0) ? setField_Suffix : "_" + fieldTypeSymbol.name_IdentFormat;

            codeBuilder.append(baseIndent + descFieldSet_OutVarName + ".setField" + type_or_SpecialValueSuffix +
                "(executeInfo, " + descTagName_OutputAccessCode + ", " +
                fieldValueExpression + ")");
            
        } else {
            // some type of Object, so just use the general setField.
            codeBuilder.append(baseIndent + descFieldSet_OutVarName + ".setField" + setField_Suffix + "(executeInfo, " + descTagName_OutputAccessCode +
                ", " + fieldValueExpression + ")");
        }

        codeBuilder.append(";\n");
    }



    private static String determine_FieldValueExpression(FieldValueInfo fieldValueInfo, String fieldValueExpression_Raw) {
        
        String fieldValueExpression = null;

        if (fieldValueInfo == null || fieldValueInfo.type == FieldValueInfo.Type.Standard || fieldValueInfo.type == FieldValueInfo.Type.None)
            fieldValueExpression = fieldValueExpression_Raw;
        else if (fieldValueInfo.type == FieldValueInfo.Type.Unused)
            fieldValueExpression = FieldConstants.class.getSimpleName() + "." + FieldConstants.UNUSED.value;
        else if (fieldValueInfo.type == FieldValueInfo.Type.Null)
            fieldValueExpression = FieldConstants.class.getSimpleName() + "." + FieldConstants.NULL.value;
        else if (fieldValueInfo.type == FieldValueInfo.Type.Default)
            fieldValueExpression = FieldConstants.class.getSimpleName() + "." + FieldConstants.DEFAULT.value;
        else if (fieldValueInfo.type == FieldValueInfo.Type.Ditto)
            throw new UnsupportedOperationException("Ditto is not yet implemented!");
        else if (fieldValueInfo.type == FieldValueInfo.Type.Ditto_PrevLevel)
            throw new UnsupportedOperationException("Ditto_PrevLevel is not yet implemented!");

        return fieldValueExpression;
    }




}
