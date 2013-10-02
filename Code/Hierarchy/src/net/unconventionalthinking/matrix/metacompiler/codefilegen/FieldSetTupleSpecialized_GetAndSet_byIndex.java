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

package net.unconventionalthinking.matrix.metacompiler.codefilegen;

import net.unconventionalthinking.matrix.metacompiler.codegen.*;
import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.Exception_SchemaInfo;
import net.unconventionalthinking.matrix.FieldConstants;
import net.unconventionalthinking.matrix.FieldSet_FieldValueBucket;
import net.unconventionalthinking.matrix.SchemaInfo_Field;
import net.unconventionalthinking.matrix.SchemaInfo_FieldSet;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.utilities.TypeUtilities;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author peterjoh
 */
public class FieldSetTupleSpecialized_GetAndSet_byIndex {

    public CodeBuilder codeBuilder;

    public SchemaInfo_FieldSet schemaInfo_FieldSet;
    public List<SchemaInfo_Field> fields;


    FieldSetTupleSpecialized_GetAndSet_byIndex(CodeBuilder codeBuilder, SchemaInfo_FieldSet schemaInfo_FieldSet) {
        this.codeBuilder = codeBuilder;
        this.schemaInfo_FieldSet = schemaInfo_FieldSet;

    }





    /**
     *
     * Object getField(int index)
     * <Field Type> getField_<Type>(int index);
     */
    void create_getField_byIndex_Methods(ExecutionInfo executeInfo, boolean createTypedMethod, Symbol fieldType) throws Exception_MetaCompilerError {

        FieldSetTupleSpecialized_FieldMethod_Settings fieldMethodSettings =
                FieldSetTupleSpecialized_FieldMethod_Settings.setup_GetAndSet_MethodInfo(executeInfo, createTypedMethod, fieldType, schemaInfo_FieldSet,
                true, false);

        CodeBuilder get_Field_MethodSignature = new CodeBuilder();

        get_Field_MethodSignature.append(fieldMethodSettings.getMethodName).append("(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed");



        //  getField(index) OR getField_<Type>(index)
        if (fieldMethodSettings.is_OverrideMethod)
            codeBuilder.append("\t@Override\n");
        codeBuilder.append("\tpublic ").append(fieldMethodSettings.typeOrObjectString + " ").append(get_Field_MethodSignature).append(" {\n\n");

        //  generate switch for non continuation fields:
        codeBuilder.append("\t\tif (index < schemaInfo_Positioned.getNum_NonContinuationFields()) {\n");
        codeBuilder.append("\t\t\tswitch (index) {\n");

        for (SchemaInfo_Field field : fieldMethodSettings.fields_TypeFiltered) {

            if (!field.is_ContinuationField()) {
                String fieldValueSpecial_Name = field.fieldName + CodeConstants.FieldSet_SetMethodNameSuffix_Special;

                codeBuilder.append("\t\t\t\tcase ").append(field.getFieldIndex()).append(":\n");
                codeBuilder.append("\t\t\t\t\tif (").append(fieldValueSpecial_Name).append(" == FieldConstants.HAS_STANDARD_VALUE) {\n");
                codeBuilder.append("\t\t\t\t\t\texecuteInfo.clearResultsInfo();\n");

                if (createTypedMethod) {
                    codeBuilder.append("\t\t\t\t\t\treturn ").append(field.fieldName).append(";\n\n");


                } else {
                    codeBuilder.append("\t\t\t\t\t\treturn ");
                    if (TypeUtilities.is_PrimitiveType(field.fieldType_Symbol))
                        codeBuilder.append(CodeGeneratorUtilities.generate_WrapPrimitiveInPrimitiveObject(field.fieldName.toString(),
                                            field.fieldType_Symbol));
                    else
                        codeBuilder.append(field.fieldName);
                    codeBuilder.append(";\n\n");

                }
                FieldSetTypleSpecialized_Utilities.generate_get_UnusedAndDefault_Code(codeBuilder, fieldValueSpecial_Name,
                        field, createTypedMethod, 5);
                codeBuilder.append("\n ");

            }

        }
        codeBuilder.append("\t\t\t\tdefault: // Error, invalid index;\n ");
        codeBuilder.append("\t\t\t\t\tthrow new Exception_InvalidArgumentPassed(\"Tried to access the field with an invalid index for the method, ")
            .append(fieldMethodSettings.getMethodName).append("(ExecutionInfo executeInfo, int index).")
            .append(" The index that was passed was, \" + index +  \", and there is no field of the correct type.\");\n");

        codeBuilder.append("\t\t\t} // end of switch\n\n");



        if (schemaInfo_FieldSet.hasContinuationField() &&
                (!createTypedMethod ||
                /*  here, if this is a typed method with a continuation field, and the continuation field type matches the type of the method that's
                 *  being created, then create the continuation field code */
                fieldType == schemaInfo_FieldSet.get_Continuation_SchemaInfoField(executeInfo).fieldType_Symbol_No_ContinuationType)) {

            SchemaInfo_Field continuationField =  schemaInfo_FieldSet.get_Continuation_SchemaInfoField(executeInfo);

            codeBuilder.append("\t\t}\n\n");


            codeBuilder.append("\t\tint continuationIndex = index - schemaInfo_Positioned.getNum_NonContinuationFields();\n");

            codeBuilder.append(
                FieldSetTypleSpecialized_Utilities.create_GetContinuationValue_HandlerCode(
                    continuationField.fieldType_Symbol_No_ContinuationType, createTypedMethod, "schemaInfo_Positioned.getNum_NonContinuationFields()", 2)
            );


            codeBuilder.append("\t}\n\n");



        } else {
            codeBuilder.append("\n\t\t} else { \n");
            codeBuilder.append("\t\t\tthrow new Exception_InvalidArgumentPassed(\"Tried to access the field with an index larger than the actual number of field values. The index that was passed in was, ")
                .append(" The index that was passed was, \" + index +  \". And the number of elements in this fields set is: \" + fieldValue_TotalCount);\n");
            codeBuilder.append("\t\t}\n\n");

            codeBuilder.append("\t}\n\n");


        }



    }







    /**
     * setField_<Type>(int index, <Field Type> value);
     */
    void create_setField_byIndex_Methods(ExecutionInfo executeInfo, boolean createTypedMethod, Symbol fieldType) throws Exception_MetaCompilerError {
        create_setField_byIndex_Methods_Helper(executeInfo, createTypedMethod, fieldType, false);
    }
    /**
     * setField(int index, Object value)
     */
    void create_setFieldSpecial_byIndex_Method(ExecutionInfo executeInfo) throws Exception_MetaCompilerError {
        create_setField_byIndex_Methods_Helper(executeInfo, false, null, true);

    }



    /**
     * NOTE: if you are creating a create_SpecialValue_SetMethod, you can not be creating a typed method. Why? it's pointless
     * to create a typed, specialValue method.
     */
    void create_setField_byIndex_Methods_Helper(ExecutionInfo executeInfo, boolean createTypedMethod, Symbol fieldType,
            boolean create_SpecialValue_SetMethod)
            throws Exception_MetaCompilerError {


        if (create_SpecialValue_SetMethod && createTypedMethod)
            throw new Exception_MetaCompilerError("Trying to create a setField Method that is a SpecialValue method, and a typed method. This is pointless and not allowed.");



        FieldSetTupleSpecialized_FieldMethod_Settings fieldMethodSettings =
                FieldSetTupleSpecialized_FieldMethod_Settings.setup_GetAndSet_MethodInfo(executeInfo, createTypedMethod, fieldType,
                schemaInfo_FieldSet, true, create_SpecialValue_SetMethod);

        CodeBuilder set_Field_MethodSignature = new CodeBuilder();

        if (!create_SpecialValue_SetMethod)
            set_Field_MethodSignature.append(fieldMethodSettings.setMethodName).append("(ExecutionInfo executeInfo, int index, ")
                .append(fieldMethodSettings.typeOrObjectString).append(" value) throws Exception_InvalidArgumentPassed");
        else
            set_Field_MethodSignature.append("setField" + CodeConstants.FieldSet_SetMethodNameSuffix_Special)
                .append("(ExecutionInfo executeInfo, int index, ")
                .append("FieldConstants specialValue) throws Exception_InvalidArgumentPassed");



        //  setField(index) OR setField_<Type>(index)
        if (fieldMethodSettings.is_OverrideMethod)
            codeBuilder.append("\t@Override\n");
        codeBuilder.append("\tpublic void ").append(set_Field_MethodSignature).append(" {\n\n");

        //  generate switch for non continuation fields:
        codeBuilder.append("\t\tif (index < schemaInfo_Positioned.getNum_NonContinuationFields()) {\n");


        codeBuilder.append("\t\t\tswitch (index) {\n");

        for (SchemaInfo_Field field : fieldMethodSettings.fields_TypeFiltered) {

            if (!field.is_ContinuationField()) {
                String fieldValueSpecial_Name = field.fieldName + CodeConstants.FieldSet_SetMethodNameSuffix_Special;

                codeBuilder.append("\t\t\t\tcase ").append(field.getFieldIndex()).append(":\n");

                codeBuilder.append("\t\t\t\t\t//  if the previous fieldValue special has not been set, then you are adding a new value. increase count\n");
                codeBuilder.append("\t\t\t\t\tif (").append(fieldValueSpecial_Name).append(" == null) {\n");
                codeBuilder.append("\t\t\t\t\t\t++fieldValue_TotalCount;\n");
                codeBuilder.append("\t\t\t\t\t\t++fieldValue_NonContinuationCount;\n");
                codeBuilder.append("\t\t\t\t\t}\n");
                
                if (createTypedMethod) {
                    codeBuilder.append("\t\t\t\t\t").append(field.fieldName).append(" = value;\n");
                    codeBuilder.append("\t\t\t\t\t").append(fieldValueSpecial_Name).append(" = FieldConstants.HAS_STANDARD_VALUE;\n");
                    codeBuilder.append("\t\t\t\t\treturn;\n\n");

                } else if (!create_SpecialValue_SetMethod) {
                    codeBuilder.append("\t\t\t\t\t").append(field.fieldName).append(" = ")
                        .append(CodeGeneratorUtilities.generate_CastObjectToCorrectType("value",
                                            field.fieldType_Symbol))
                        .append(";\n");

                    codeBuilder.append("\t\t\t\t\t").append(fieldValueSpecial_Name).append(" = FieldConstants.HAS_STANDARD_VALUE;\n");
                    codeBuilder.append("\t\t\t\t\treturn;\n\n");


                //  Creating special value set-method
                } else  {
                    codeBuilder.append("\t\t\t\t\t").append(fieldValueSpecial_Name).append(" = specialValue;\n");
                    codeBuilder.append("\t\t\t\t\t").append(field.fieldName).append(" = ")
                            .append(CodeGeneratorUtilities.generate_UnusedDefaultValueForType(field.fieldType_Symbol))
                            .append(";\n");
                    codeBuilder.append("\t\t\t\t\treturn;\n\n");

                }
                codeBuilder.append("\n ");

            }

        }
        codeBuilder.append("\t\t\t\tdefault: // Error, invalid index;\n ");
        codeBuilder.append("\t\t\t\t\tthrow new Exception_InvalidArgumentPassed(\"Tried to access the field with an invalid index for the method, ")
            .append(fieldMethodSettings.getMethodName).append("(ExecutionInfo executeInfo, int index).")
            .append(" The index that was passed was, \" + index +  \", and there is no field of the correct type.\");\n");

        codeBuilder.append("\t\t\t} // end of switch\n\n");



        if (schemaInfo_FieldSet.hasContinuationField() &&
                (!createTypedMethod ||
                /*  here, if this is a typed method with a continuation field, and the continuation field type matches the type of the method that's
                 *  being created, then create the continuation field code */
                fieldType == schemaInfo_FieldSet.get_Continuation_SchemaInfoField(executeInfo).fieldType_Symbol_No_ContinuationType)) {

            SchemaInfo_Field continuationField = schemaInfo_FieldSet.get_Continuation_SchemaInfoField(executeInfo);


            codeBuilder.append("\t\t}\n\n");

            codeBuilder.append("\t\tint continuationIndex = index - schemaInfo_Positioned.getNum_NonContinuationFields();\n");

            if (!create_SpecialValue_SetMethod) {
                codeBuilder.append(
                    FieldSetTypleSpecialized_Utilities.create_SetContinuationValue_HandlerCode(
                        continuationField.fieldType_Symbol_No_ContinuationType,  createTypedMethod, 2)
                );

            //  Creating special value set-method
            } else {
                codeBuilder.append(
                    FieldSetTypleSpecialized_Utilities.create_SetContinuationSpecialValue_HandlerCode(
                        continuationField.fieldType_Symbol_No_ContinuationType, 2)
                );
            }


        } else {

            codeBuilder.append("\n\t\t} else { \n");
            codeBuilder.append("\t\t\t//  error\n");
            codeBuilder.append("\t\t\tthrow new Exception_InvalidArgumentPassed(\"Tried to access the field with an index larger than the actual number of field values. The index that was passed in was, ")
                .append(" The index that was passed was, \" + index +  \". And the number of elements in this fields set is: \" + fieldValue_TotalCount);\n");

            codeBuilder.append("\t\t}\n\n");

        }


        codeBuilder.append("\t}\n\n");

    }


}
