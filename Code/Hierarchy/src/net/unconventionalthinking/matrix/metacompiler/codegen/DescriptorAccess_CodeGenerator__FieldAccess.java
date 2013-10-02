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
import net.unconventionalthinking.lang.ExecutionInfo.ErrorType;
import net.unconventionalthinking.lang.Pair;
import net.unconventionalthinking.matrix.Descriptor;
import net.unconventionalthinking.matrix.Exception_Descriptor;
import net.unconventionalthinking.matrix.FieldSet;
import net.unconventionalthinking.matrix.MatrixControl;
import net.unconventionalthinking.matrix.SchemaControl;
import net.unconventionalthinking.matrix.SchemaInfo_Field;
import net.unconventionalthinking.matrix.SchemaInfo_FieldSet;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.matrix.utilities.TypeUtilities;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import java.util.List;
import net.unconventionalthinking.lang.String_Mutable;

/**
 *
 * @author peterjoh
 */
public class DescriptorAccess_CodeGenerator__FieldAccess extends DescriptorAccess_CodeGenerator__Base {

    CodeBuilder codeBuilder_FieldAssignment;
    FieldSet fieldSet;
    boolean have_FieldSet;
    SchemaInfo_FieldSet schemaInfo_FieldSet;
    SchemaInfo_Field schemaInfo_Field;
    boolean have_SchemaInfoField;
    String continuationIndex_ParamName;
    public Symbol output_FieldType_Symbol;
    public String output_FieldType;
    public String output_DefaultValue;

    public DescriptorAccess_CodeGenerator__FieldAccess(SymbolControl symbolControl, SchemaControl schemaControl, MatrixControl matrixControl,
            int baseIndentLevel, HierarchySettings hierarchySettings, CodeGen_OutputResults outputResults) {
        super(symbolControl, schemaControl, matrixControl, baseIndentLevel, hierarchySettings, outputResults);
    }

    public void set_ContinuationIndex_ParamName(String continuationIndex_ParamName) {
        this.continuationIndex_ParamName = continuationIndex_ParamName;
    }

    public CodeBuilder generate_FieldAccess(int childAccess_Index, DescriptorAccess_ChildAccessInfo childAccessInfo,
            DescriptorAccess_ChildAccessGeneratorInfo childAccessGenInfo, List<Pair<String, String>> intraMethod_ChildAccessExpr_Pairs__List,
            boolean is_MatrixAccess)
            throws Exception_MetaCompilerError, Exception_MetaCompiler_IncorrectMatrixAccess {


        codeBuilder_FieldAssignment = new CodeBuilder();


        setup_Curr_FieldAccess(childAccessInfo);

        codeBuilder_FieldAssignment.append("\n" + baseIndent + "\t" + childAccessGenInfo.outComment_AccessDescription).append(baseIndent + "\tif (DescriptorUtilities.validDescriptors(executeInfo, " + currAccessSettings.parent_OutExpression + ")) {\n");
        codeBuilder_FieldAssignment.append(baseIndent + "\t\ttry{\n").append(baseIndent + "\t\t\tif (" + currAccessSettings.parent_OutExpression + ".has_FieldSet()) {\n");

        codeBuilder_FieldAssignment.append(baseIndent + "\t\t\t\treturn ");


        String getFieldSet_MethodCall = ".get_FieldSet()";
        if (childAccessInfo.accessExpr2_Is_ContinuationIndex) {
            getFieldSet_MethodCall = ".get_FieldSet_Tuple(executeInfo)";
        }


        //  If it is static access && the fieldset has a specialized version
        if (have_SchemaInfoField && fieldSet.is_SpecializedFieldSet()) {

            codeBuilder_FieldAssignment.append("((" + hierarchySettings.appClasses_PackageName + "." + schemaInfo_FieldSet.get_FieldSetTypeString() + ")"
                    + currAccessSettings.parent_OutExpression + getFieldSet_MethodCall
                        + ").get_" + schemaInfo_Field.fieldName.get_Name_no_backtiks() + "(executeInfo");

            if (childAccessInfo.accessExpr2_Is_ContinuationIndex) {
                codeBuilder_FieldAssignment.append(", " + continuationIndex_ParamName);
            } 
            codeBuilder_FieldAssignment.append(");\n");


            //  If it is static access, it does not have a specialized fieldset, and it's a primitive type.
        } else if (have_SchemaInfoField && TypeUtilities.is_PrimitiveType(schemaInfo_Field.getFieldType_Symbol_No_ContinuationType())) {

            codeBuilder_FieldAssignment.append(currAccessSettings.parent_OutExpression + getFieldSet_MethodCall + ".getField_"
                    + schemaInfo_Field.getFieldType_Symbol_No_ContinuationType().name + "(executeInfo, ");

            if (childAccessInfo.accessExpr2_Is_ContinuationIndex) {
                // for a continuation index, you don't need to pass in the desc Tag name
                codeBuilder_FieldAssignment.append(continuationIndex_ParamName);
            } else {
                codeBuilder_FieldAssignment.append(childAccessGenInfo.getChildDescriptor_ParamValue1);
            }
            codeBuilder_FieldAssignment.append(");\n");



        } else {
            String fieldAccess_Expr = currAccessSettings.parent_OutExpression + getFieldSet_MethodCall + ".getField(executeInfo, ";
            if (childAccessInfo.accessExpr2_Is_ContinuationIndex) {
                // for a continuation index, you don't need to pass in the desc Tag name
                fieldAccess_Expr += continuationIndex_ParamName;
            } else {
                fieldAccess_Expr += " (DescriptorTagName)" + childAccessGenInfo.getChildDescriptor_ParamValue1;
            }
            fieldAccess_Expr += ")";

            if (have_SchemaInfoField) {
                //  The generate_CastObjectToCorrectType() method turns Primitive objects (like Integers) into primitives (like int)
                //  This is to avoid unboxing overhead.
                codeBuilder_FieldAssignment.append(CodeGeneratorUtilities.generate_CastObjectToCorrectType(fieldAccess_Expr,
                        schemaInfo_Field.getFieldType_Symbol_No_ContinuationType())).append(";\n");

            } else {
                codeBuilder_FieldAssignment.append(fieldAccess_Expr).append(";\n");
            }
        }


        //  Error Handling code:
        codeBuilder_FieldAssignment.append(baseIndent + "\t\t\t} else {\n").append(baseIndent + "\t\t\t\texecuteInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedFieldButNoFieldSetExists);\n").append(baseIndent + "\t\t\t}\n\n").append(baseIndent + "\t\t} catch (Exception e) {\n").append(baseIndent + "\t\t\texecuteInfo.setErrorException(e);\n").append(baseIndent + "\t\t}\n\n").append(baseIndent + "\t} else { // end of if (validDescriptors())\n").append(baseIndent + "\t\texecuteInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);\n").append(baseIndent + "\t}\n\n");

        generate_AccessChildCode_AccessErrorCode(codeBuilder_FieldAssignment, true, true, is_MatrixAccess, output_FieldType_Symbol,
                childAccess_Index, childAccessInfo, intraMethod_ChildAccessExpr_Pairs__List, baseIndent);


        return codeBuilder_FieldAssignment;
    }



    /**
     *
     * @param childAccess_Index
     * @param childAccessInfo
     * @param is_MatrixAccess
     * @return   the codebuilder for the setField(...) method call
     * @throws Exception_MetaCompilerError
     */
    public CodeBuilder generate_FieldAssignment(int childAccess_Index, DescriptorAccess_ChildAccessInfo childAccessInfo,
            boolean is_MatrixAccess, String_Mutable OUT__specializedFieldSet_FullTypeName) throws Exception_MetaCompilerError {

        setup_Curr_FieldAccess(childAccessInfo);


        codeBuilder_FieldAssignment = new CodeBuilder();

        //  If it is static access && the fieldset has a specialized version
        if (have_SchemaInfoField && fieldSet.is_SpecializedFieldSet()) {

            codeBuilder_FieldAssignment.append(".set_" + schemaInfo_Field.fieldName.get_Name_no_backtiks() + "(executeInfo, ");
            // leave the method call open!!! the value expression needs to be append next!!!

            OUT__specializedFieldSet_FullTypeName.value =
                hierarchySettings.appClasses_PackageName + "." + schemaInfo_FieldSet.get_FieldSetTypeString();
        //  If it is static access, it does not have a specialized fieldset
        } else {
            codeBuilder_FieldAssignment.append(".setField(executeInfo, ");
            // leave the method call open!!! the value expression needs to be append next!!!
        }

        return codeBuilder_FieldAssignment;
    }







    void setup_Curr_FieldAccess(DescriptorAccess_ChildAccessInfo childAccessInfo) throws Exception_MetaCompiler_IncorrectMatrixAccess {

        have_SchemaInfoField = false;
        fieldSet = null;
        have_FieldSet = false;

        // these will be changed to the actual field type & default value if the schemaInfo Field object is found.
        output_FieldType_Symbol = null;
        output_FieldType = "Object";
        output_DefaultValue = "null";

        if (childAccessInfo.is_StaticAccess && currAccessSettings.has_ParentMatrixUsageDescriptor()) {


            try {
                fieldSet = currAccessSettings.getCorrect_MatrixUsageDescriptor().get_FieldSet_Tuple(executeInfo);
                if (fieldSet == null) // see if there's a parammap
                    fieldSet = currAccessSettings.getCorrect_MatrixUsageDescriptor().get_FieldSet_ParameterMap(executeInfo);
            } catch (Exception_Descriptor e) {
                throw new Exception_MetaCompiler_IncorrectMatrixAccess("Tried to get a field set from a descriptor from the Matrix usage structure, but had a error", e);
            }

            if (fieldSet != null) {
                schemaInfo_FieldSet = (SchemaInfo_FieldSet) fieldSet.getSchemaInfo();
                if (childAccessInfo.accessExpr1_Is_Static_DescTagName) {
                    if (childAccessInfo.accessExpr1_DescTagOrLabel_Actual == null) {
                        throw new Exception_MetaCompiler_IncorrectMatrixAccess("You tried to access a field statically, but the fieldName string you gave does not have a descriptor tag object associated with it.");
                    }
                    if (!(childAccessInfo.accessExpr1_DescTagOrLabel_Actual instanceof DescriptorTagName)) {
                        throw new Exception_MetaCompiler_IncorrectMatrixAccess("You tried to access a field statically, but the fieldName object was not a descriptor tag (which means it was probably a label).");
                    }

                    schemaInfo_Field = schemaInfo_FieldSet.get_SchemaInfoField(executeInfo, (DescriptorTagName) childAccessInfo.accessExpr1_DescTagOrLabel_Actual);
                    have_SchemaInfoField = true;

                    output_FieldType_Symbol = schemaInfo_Field.fieldType_Symbol_No_ContinuationType;
                    output_FieldType = schemaInfo_Field.fieldType_Symbol_No_ContinuationType.name;

                    output_DefaultValue =
                            CodeGeneratorUtilities.generate_UnusedDefaultType_Object(schemaInfo_Field.fieldType_Symbol_No_ContinuationType, true).toString();
                }


                have_FieldSet = true;

            } else {
                throw new Exception_MetaCompiler_IncorrectMatrixAccess("You are accessing a field statically on a matrix, but the descriptor did not have a fieldset.");
            }


        } else { //  Is dynamic access
            // Don't need to do anything
        }
    }




}
