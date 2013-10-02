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
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.SchemaInfo_Field;
import net.unconventionalthinking.matrix.SchemaInfo_FieldSet;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolConstants;
import net.unconventionalthinking.matrix.utilities.TypeUtilities;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import java.util.List;

/**
 *
 * @author peterjoh
 */
public class FieldSetTupleSpecialized_GetAndSet_byFieldName {

    public HierarchySettings hierarchySettings;
    public CodeBuilder codeBuilder;

    public SchemaInfo_FieldSet schemaInfo_FieldSet;
    public List<SchemaInfo_Field> fields;



    FieldSetTupleSpecialized_GetAndSet_byFieldName(HierarchySettings hierarchySettings, CodeBuilder codeBuilder, SchemaInfo_FieldSet schemaInfo_FieldSet) {

        this.hierarchySettings = hierarchySettings;

        this.codeBuilder = codeBuilder;
        this.schemaInfo_FieldSet = schemaInfo_FieldSet;

        fields =  schemaInfo_FieldSet.get_SchemaInfoFields();

    }




    
 
    /**
     * <Field Type> get_<Field Name>()
     * <Field Type> get_<Field Name>(continuationIndex)
     */
    void create_get_FieldName_Methods() {

        for (SchemaInfo_Field field : fields) {

            if (!field.is_ContinuationField()) {

                String get_Field_MethodSignature = "get_" + field.fieldName + "(ExecutionInfo executeInfo) throws Exception_InvalidArgumentPassed ";
                String fieldValueSpecial_Name = field.fieldName + CodeConstants.FieldSet_SetMethodNameSuffix_Special;

                //  get_<Field>() - very similar to FieldSet_Tuple.getField(fieldName)
                codeBuilder.append("\tpublic ").append(field.fieldType_Symbol.name_no_backtiks).append(" ").append(get_Field_MethodSignature).append(" {\n\n");


                codeBuilder.append("\t\tif (").append(fieldValueSpecial_Name).append(" == FieldConstants.HAS_STANDARD_VALUE) {\n");
                codeBuilder.append("\t\t\texecuteInfo.clearResultsInfo();\n");
                codeBuilder.append("\t\t\treturn ").append(field.fieldName + ";\n\n");

                FieldSetTypleSpecialized_Utilities.generate_get_UnusedAndDefault_Code(codeBuilder, field.fieldName + CodeConstants.FieldSet_SetMethodNameSuffix_Special,
                        field, true, 2);


                codeBuilder.append("\t}\n\n");


            } else {
                // get_<Field>(continuationIndex) - gets the value of a continuation index field
                codeBuilder.append("\tpublic ").append(field.fieldType_Symbol_No_ContinuationType.name_no_backtiks)
                        .append(" get_").append(field.fieldName).append("(ExecutionInfo executeInfo, int continuationIndex) \n")
                        .append("\t\t\tthrows Exception_InvalidArgumentPassed {\n\n");


                codeBuilder.append(
                    FieldSetTypleSpecialized_Utilities.create_GetContinuationValue_HandlerCode(
                        field.fieldType_Symbol_No_ContinuationType, true, "schemaInfo_Positioned.getNum_NonContinuationFields()", 2)
                    );

                codeBuilder.append("\t}\n\n");

            }
        }
    }



    /**
     * set_<Field Name>(<Type> value)
     * set_<Field Name >__Special(specialValue)
     * set_<Field Name>(continuationIndex, <Type> value)
     * set_<Field Name>__Special(continuationIndex, specialValue)
     */
    void create_set_FieldName_Methods() {

        for (SchemaInfo_Field field : fields) {

            if (!field.is_ContinuationField()) {

                CodeBuilder set_Field_MethodSignature = new CodeBuilder();
                set_Field_MethodSignature.append("set_").append(field.fieldName.getTagName()).append("(ExecutionInfo executeInfo, ")
                        .append(field.fieldType_Symbol.name_no_backtiks).append(" value) throws Exception_InvalidArgumentPassed ");
                String fieldValueSpecial_Name = field.fieldName + CodeConstants.FieldSet_SetMethodNameSuffix_Special;

                //  set_<Field>() - very similar to FieldSet_Tuple.setField(fieldName)
                codeBuilder.append("\tpublic void ").append(set_Field_MethodSignature).append(" {\n");
                codeBuilder.append("\t\t//  if the previous fieldValue special has not been set, then you are adding a new value. increase count\n");
                codeBuilder.append("\t\tif (this.").append(fieldValueSpecial_Name).append(" == null) {\n");
                codeBuilder.append("\t\t\t++fieldValue_TotalCount;\n");
                codeBuilder.append("\t\t\t++fieldValue_NonContinuationCount;\n");
                codeBuilder.append("\t\t}\n");
                codeBuilder.append("\t\tthis.").append(field.fieldName).append(" = value;\n");
                codeBuilder.append("\t\tthis.").append(fieldValueSpecial_Name).append(" = FieldConstants.HAS_STANDARD_VALUE;\n");
                codeBuilder.append("\t}\n");

                //  set_<Field>__Special()
                CodeBuilder set_FieldSpecial_MethodSignature = new CodeBuilder();
                set_FieldSpecial_MethodSignature.append("set_").append(fieldValueSpecial_Name).append("(ExecutionInfo executeInfo, ")
                        .append("FieldConstants specialValue)\n")
                        .append("\t\t\tthrows Exception_InvalidArgumentPassed ");

                codeBuilder.append("\tpublic void ").append(set_FieldSpecial_MethodSignature).append(" {\n");
                codeBuilder.append("\t\t//  if the previous fieldValue special has not been set, then you are adding a new value. increase count\n");
                codeBuilder.append("\t\tif (this.").append(fieldValueSpecial_Name).append(" == null) {\n");
                codeBuilder.append("\t\t\t++fieldValue_TotalCount;\n");
                codeBuilder.append("\t\t\t++fieldValue_NonContinuationCount;\n");
                codeBuilder.append("\t\t}\n");
                codeBuilder.append("\t\tthis.").append(fieldValueSpecial_Name).append(" = specialValue;\n");
                codeBuilder.append("\t\tthis.").append(field.fieldName).append(" = ")
                        .append(CodeGeneratorUtilities.generate_UnusedDefaultValueForType(field.fieldType_Symbol)).append(";\n");
                codeBuilder.append("\t}\n\n");


            } else {
                // set_<Field>(continuationIndex, <Type> value) - gets the value of a continuation index field
                CodeBuilder set_Field_MethodSignature = new CodeBuilder();
                set_Field_MethodSignature.append("set_").append(field.fieldName).append("(ExecutionInfo executeInfo, int continuationIndex, ")
                        .append(field.fieldType_Symbol_No_ContinuationType.toString()).append(" value) \n\t\t\tthrows Exception_InvalidArgumentPassed ");
                String fieldValueSpecial_Name = field.fieldName + CodeConstants.FieldSet_SetMethodNameSuffix_Special;

                //  set_<Field>() - very similar to FieldSet_Tuple.setField(fieldName)
                codeBuilder.append("\tpublic void ").append(set_Field_MethodSignature).append(" {\n\n");

                codeBuilder.append(
                    FieldSetTypleSpecialized_Utilities.create_SetContinuationValue_HandlerCode(field.fieldType_Symbol_No_ContinuationType, true, 2));

                codeBuilder.append("\t}\n\n");




                // set_<Field>__Special(continuationIndex, specialValue)
                CodeBuilder set_FieldSpecial_MethodSignature = new CodeBuilder();
                set_FieldSpecial_MethodSignature.append("set_").append(fieldValueSpecial_Name).append("(ExecutionInfo executeInfo, int continuationIndex, ")
                        .append(" FieldConstants specialValue)\n\t\t\tthrows Exception_InvalidArgumentPassed ");

                codeBuilder.append("\tpublic void ").append(set_FieldSpecial_MethodSignature).append(" {\n\n");

                codeBuilder.append(
                    FieldSetTypleSpecialized_Utilities.create_SetContinuationSpecialValue_HandlerCode(field.fieldType_Symbol_No_ContinuationType, 2));

                codeBuilder.append("\t}\n\n");


            }
        }


    }





    /**
     * Object getField(fieldName)
     * <Type> getField_<Type>(fieldName)
     *
     * @param executeInfo
     * @param createTypedMethod
     * @param fieldType
     * @throws Exception_MetaCompilerError
     */
    void create_getField_byFieldName_Methods(ExecutionInfo executeInfo, boolean createTypedMethod, Symbol fieldType) throws Exception_MetaCompilerError {

        FieldSetTupleSpecialized_FieldMethod_Settings fieldMethodSettings =
                FieldSetTupleSpecialized_FieldMethod_Settings.setup_GetAndSet_MethodInfo(executeInfo, createTypedMethod, fieldType, schemaInfo_FieldSet,
                true, false);

        CodeBuilder get_Field_MethodSignature = new CodeBuilder();

        get_Field_MethodSignature.append(fieldMethodSettings.getMethodName).append("(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed ");

        //  getField(fieldname) OR getField_<Type>(fieldname)
        if (fieldMethodSettings.is_OverrideMethod)
            codeBuilder.append("\t@Override\n");
        codeBuilder.append("\tpublic ").append(fieldMethodSettings.typeOrObjectString + " ").append(get_Field_MethodSignature).append(" {\n\n");


        codeBuilder.append("\t\tswitch ( ((Symbol)fieldName).ID ) {\n");

        for (SchemaInfo_Field field : fieldMethodSettings.fields_TypeFiltered) {

            if (!field.is_ContinuationField()) {

                String fieldValueSpecial_Name = field.fieldName + CodeConstants.FieldSet_SetMethodNameSuffix_Special;

                //  Append the package name to the AppSymbol_DescTagName class name, because if you have an external jar with a same descriptor
                //  tag name, the java compiler can get confused.
                codeBuilder.append("\t\t\tcase ").append(hierarchySettings.appClasses_PackageName).append(".")
                        .append(hierarchySettings.appSymbolClassName_DescTagName).append(".")
                        .append(field.getFieldName().getTagName_Symbol().name_IdentFormat)
                        .append(SymbolConstants.SymbolFile_SymbolName__SymbolID_Suffix).append(":\n");
                codeBuilder.append("\t\t\t\tif (").append(fieldValueSpecial_Name).append(" == FieldConstants.HAS_STANDARD_VALUE) {\n");
                codeBuilder.append("\t\t\t\t\texecuteInfo.clearResultsInfo();\n");

                if (createTypedMethod) {
                    codeBuilder.append("\t\t\t\t\treturn ").append(field.fieldName).append(";\n\n");


                } else {
                    codeBuilder.append("\t\t\t\t\treturn ");
                    if (TypeUtilities.is_PrimitiveType(field.fieldType_Symbol))
                        codeBuilder.append(CodeGeneratorUtilities.generate_WrapPrimitiveInPrimitiveObject(field.fieldName.toString(),
                                            field.fieldType_Symbol));
                    else
                        codeBuilder.append(field.fieldName);
                    codeBuilder.append(";\n\n");

                }
                FieldSetTypleSpecialized_Utilities.generate_get_UnusedAndDefault_Code(codeBuilder, fieldValueSpecial_Name,
                        field, createTypedMethod, 4);
                codeBuilder.append("\n ");

            }
        }
        codeBuilder.append("\t\t\tdefault: // Error, invalid index;\n ");
        codeBuilder.append("\t\t\t\tthrow new Exception_InvalidArgumentPassed(\"Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was ")
            .append(get_Field_MethodSignature.toString()).append(".")
            .append(" The fieldName that was passed was, \" + ( (fieldName != null) ? fieldName.toString() : null ) +  \".\");\n");

        codeBuilder.append("\t\t} // end of switch\n\n");



        codeBuilder.append("\t}\n\n");


    }






    /**
     * setField(fieldName, Object value)
     * setField__Special(fieldName, specialValue)
     * setField_<Type>(fieldName, <Type> value)
     *
     * (note: no continuation setField for these methods, and no setField_<Type>__Special (unnecessary))
     *
     * @param executeInfo
     * @param createTypedMethod
     * @param fieldType
     * @throws Exception_MetaCompilerError
     */
    void create_setField_byFieldName_Methods(ExecutionInfo executeInfo, boolean createTypedMethod, Symbol fieldType)
            throws Exception_MetaCompilerError {
        create_setField_byFieldName_Methods(executeInfo, createTypedMethod, fieldType, false);
    }



    void create_setField_byFieldName_Methods(ExecutionInfo executeInfo, boolean createTypedMethod, Symbol fieldType, boolean createSpecialValueMethod)
            throws Exception_MetaCompilerError {

        if (createTypedMethod && createSpecialValueMethod)
            throw new Exception_MetaCompilerError("Can not create a setField(fieldName) method that is both typed and a special value method.");

        

        FieldSetTupleSpecialized_FieldMethod_Settings fieldMethodSettings =
                FieldSetTupleSpecialized_FieldMethod_Settings.setup_GetAndSet_MethodInfo(executeInfo, createTypedMethod, fieldType, schemaInfo_FieldSet,
                true, createSpecialValueMethod);

        CodeBuilder set_Field_MethodSignature = new CodeBuilder();
        if (!createSpecialValueMethod) {
            set_Field_MethodSignature.append(fieldMethodSettings.setMethodName).append("(ExecutionInfo executeInfo, DescriptorTagName fieldName, ")
                .append(fieldMethodSettings.typeOrObjectString.toString()).append(" value) throws Exception_InvalidArgumentPassed ");
        } else {
            set_Field_MethodSignature.append(fieldMethodSettings.setMethodName).append(CodeConstants.FieldSet_SetMethodNameSuffix_Special)
                .append("(ExecutionInfo executeInfo, DescriptorTagName fieldName, FieldConstants specialValue) throws Exception_InvalidArgumentPassed ");
        }



        //  setField(fieldname, value) OR setField_<Type>(fieldname, value)
        if (fieldMethodSettings.is_OverrideMethod)
            codeBuilder.append("\t@Override\n");
        codeBuilder.append("\tpublic void ").append(set_Field_MethodSignature).append(" {\n\n");


        codeBuilder.append("\t\tswitch ( ((Symbol)fieldName).ID ) {\n");

        for (SchemaInfo_Field field : fieldMethodSettings.fields_TypeFiltered) {

            if (!field.is_ContinuationField()) {

                String fieldValueSpecial_Name = field.fieldName + CodeConstants.FieldSet_SetMethodNameSuffix_Special;
                
                //  Append the package name to the AppSymbol_DescTagName class name, because if you have an external jar with a same descriptor
                //  tag name, the java compiler can get confused.
                codeBuilder.append("\t\t\tcase ").append(hierarchySettings.appClasses_PackageName).append(".")
                        .append(hierarchySettings.appSymbolClassName_DescTagName).append(".")
                        .append(field.getFieldName().getTagName_Symbol().name_IdentFormat)
                        .append(SymbolConstants.SymbolFile_SymbolName__SymbolID_Suffix).append(":\n");

                if (!createSpecialValueMethod) {
                    codeBuilder.append("\t\t\t\t//  if the previous fieldValue special has not been set, then you are adding a new value. increase count\n");
                    codeBuilder.append("\t\t\t\tif (this.").append(fieldValueSpecial_Name).append(" == null) {\n");
                    codeBuilder.append("\t\t\t\t\t++fieldValue_TotalCount;\n");
                    codeBuilder.append("\t\t\t\t\t++fieldValue_NonContinuationCount;\n");
                    codeBuilder.append("\t\t\t\t}\n");
                    if (!createTypedMethod) {
                        codeBuilder.append("\t\t\t\tthis.").append(field.fieldName).append(" = ").append(
                                CodeGeneratorUtilities.generate_CastObjectToCorrectType("value", field.fieldType_Symbol)
                            ).append(";\n");
                    } else {
                        codeBuilder.append("\t\t\t\tthis.").append(field.fieldName).append(" = value;\n");
                    }
                    codeBuilder.append("\t\t\t\tthis.").append(fieldValueSpecial_Name).append(" = FieldConstants.HAS_STANDARD_VALUE;\n");
                    
                } else {
                    codeBuilder.append("\t\t\t\t//  if the previous fieldValue special has not been set, then you are adding a new value. increase count\n");
                    codeBuilder.append("\t\t\t\tif (this.").append(fieldValueSpecial_Name).append(" == null) {\n");
                    codeBuilder.append("\t\t\t\t\t++fieldValue_TotalCount;\n");
                    codeBuilder.append("\t\t\t\t\t++fieldValue_NonContinuationCount;\n");
                    codeBuilder.append("\t\t\t\t}\n");
                    codeBuilder.append("\t\t\t\tthis.").append(fieldValueSpecial_Name).append(" = specialValue;\n");
                    codeBuilder.append("\t\t\t\tthis.").append(field.fieldName).append(" = ")
                            .append(CodeGeneratorUtilities.generate_UnusedDefaultValueForType(field.fieldType_Symbol)).append(";\n");
                }
                codeBuilder.append("\t\t\t\treturn;\n");
            }

            
        }

        codeBuilder.append("\t\t\tdefault: // Error, invalid index;\n ");
        codeBuilder.append("\t\t\t\tthrow new Exception_InvalidArgumentPassed(\"Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was ")
            .append(set_Field_MethodSignature.toString()).append(".")
            .append(" The fieldName that was passed was, \" + ( (fieldName != null) ? fieldName.toString() : null ) +  \".\");\n");

        codeBuilder.append("\t\t} // end of switch\n\n");



        codeBuilder.append("\t}\n\n");


    }

}
