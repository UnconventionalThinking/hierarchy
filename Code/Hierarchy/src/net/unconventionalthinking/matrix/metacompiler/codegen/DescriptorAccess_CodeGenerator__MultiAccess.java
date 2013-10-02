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
import net.unconventionalthinking.lang.Pair;
import net.unconventionalthinking.matrix.Descriptor;
import net.unconventionalthinking.matrix.ExceptRuntime_DescriptorAccess;
import net.unconventionalthinking.matrix.ExceptRuntime_Matrix_UnexpectedError;
import net.unconventionalthinking.matrix.MatrixControl;
import net.unconventionalthinking.matrix.SchemaControl;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import java.util.List;





/**
 *
 * @author peterjoh
 */
public class DescriptorAccess_CodeGenerator__MultiAccess extends DescriptorAccess_CodeGenerator__Base {

    CodeBuilder                             codeBuilder_MultiAccess;

    public Symbol       outVar_TypeSymbol;
    public String       outVar_TypeString;
    public String       output_DefaultValue;


    private String      outVarName;






    public DescriptorAccess_CodeGenerator__MultiAccess(SymbolControl symbolControl, SchemaControl schemaControl, MatrixControl matrixControl,
            int baseIndentLevel, HierarchySettings hierarchySettings, CodeGen_OutputResults outputResults) {
        super(symbolControl, schemaControl, matrixControl, baseIndentLevel, hierarchySettings, outputResults);
    }




    public void set_OutVarName(String outVarName) {
        this.outVarName = outVarName;
    }




    
    public CodeBuilder generate_MultiAccess(int childAccess_Index, 
            DescriptorAccess_ChildAccessGeneratorInfo childAccessGenInfo, List<Pair<String, String>> intraMethod_ChildAccessExpr_Pairs__List,
            boolean is_MatrixAccess) 
            throws Exception_MetaCompilerError {
        
        codeBuilder_MultiAccess = new CodeBuilder();
        boolean prevAccessIsMultiAccess = prevChildAccessInfo != null && !prevChildAccessInfo.is_SingleAccess;


        if (currChildAccessInfo.typeOfElementAccessed == DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.DescriptorSet) {

            if (childAccess_Index == 0) { // initial access

                //  Since this is the initial access, currAccessSettings.parent_OutExpression will just be the matrix parameter name from the access
                //  method signature (so, it's just "matrix")
                codeBuilder_MultiAccess
                    .append("\n" + baseIndent + "\t" + childAccessGenInfo.outComment_AccessDescription)
                    .append(baseIndent + "\tMatrixSet<Descriptor> " + outVarName + " = null;\n")
                    .append(baseIndent + "\tif (DescriptorUtilities.validDescriptors(executeInfo, " + currAccessSettings.parent_OutExpression + ")) {\n");

                codeBuilder_MultiAccess
                    .append(baseIndent + "\t\ttry{\n")
                    .append(baseIndent + "\t\t\t" + outVarName + " = " + currAccessSettings.parent_OutExpression + ".get_ChildDescriptors(executeInfo," +
                            childAccessGenInfo.getChildDescriptor_ParamValue1 + ");\n");

            } else {

                codeBuilder_MultiAccess
                    .append("\n" + baseIndent + "\t" + childAccessGenInfo.outComment_AccessDescription)
                    .append(baseIndent + "\tMatrixSet<Descriptor> " + outVarName + " = new MatrixSet<Descriptor>();\n")
                    .append(baseIndent + "\tif (DescriptorUtilities.validDescriptors(executeInfo, " + currAccessSettings.parent_OutExpression + ")) {\n");

                if (prevChildAccessInfo == null) {
                    throw new ExceptRuntime_Matrix_UnexpectedError("Generating matrix multi-access code, and should be doing a non-intial access, but there is no prevChildAccessInfo. This should not happen. The currChildAccessInfo is: " +
                            (currChildAccessInfo != null ?
                                currChildAccessInfo.accessExpr1  + (currChildAccessInfo.accessExpr2 != null ? " " + currChildAccessInfo.accessExpr2 : "") :
                                "null") +
                         ".");
                }
                if (prevChildAccessInfo.is_SingleAccess) {
                    codeBuilder_MultiAccess
                    .append(baseIndent + "\t\ttry{\n")
                    .append(baseIndent + "\t\t\t" + currAccessSettings.parent_OutExpression + ".get_ChildDescriptors(executeInfo," +
                            childAccessGenInfo.getChildDescriptor_ParamValue1 + ", " + outVarName + ");\n");

                } else { // last access was multi-access
                    codeBuilder_MultiAccess
                    .append(baseIndent + "\t\ttry{\n")
                    .append(baseIndent + "\t\t\tfor(Descriptor childDesc : " + currAccessSettings.parent_OutExpression + ") {\n")
                    .append(baseIndent + "\t\t\t\tchildDesc.get_ChildDescriptors(executeInfo," +
                            childAccessGenInfo.getChildDescriptor_ParamValue1 + ", " + outVarName + ");\n")
                    .append(baseIndent + "\t\t\t}\n");
                }

            }


            //  if there's a filter add the filter call
            if (currChildAccessInfo.multiAccess_FiltersAnnotationReference_Exists) {

                codeBuilder_MultiAccess.append(baseIndent + "\t\t\t" + outVarName + " = (" + MPSymbols.MatrixSet$60$Descriptor$62$.name_no_backtiks + ")");

                annotationCall_CodeGen_Filters.determine_AnotationRef(currChildAccessInfo, childAccess_Index);
                annotationCall_CodeGen_Filters.generateCall(codeBuilder_MultiAccess, childAccess_Index,
                    rootAccessSettings.parent_OutExpression, currAccessSettings.parent_OutExpression, outVarName, currChildAccessInfo.typeOfElementAccessed,
                    MPSymbols.MatrixSet$60$Descriptor$62$, false, true, prevAccessIsMultiAccess,
                    is_MatrixAccess_In_StaticMethod, embeddedFile_ClassName,
                    intraMethod_ChildAccessExpr_Pairs__List);

                codeBuilder_MultiAccess.append(";\n");
            }


            //  Error Handling code:
            codeBuilder_MultiAccess
                    .append(baseIndent + "\t\t} catch (Exception e) {\n")
                    .append(baseIndent + "\t\t\texecuteInfo.setErrorException(e);\n")
                    .append(baseIndent + "\t\t}\n\n")

                    .append(baseIndent + "\t} else { // end of if (validDescriptors())\n")
                    .append(baseIndent + "\t\texecuteInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);\n")
                    .append(baseIndent + "\t}\n\n");


            generate_AccessChildCode_AccessErrorCode(codeBuilder_MultiAccess, false, false, is_MatrixAccess, MPSymbols.MatrixSet$60$Descriptor$62$,
                    childAccess_Index, currChildAccessInfo, intraMethod_ChildAccessExpr_Pairs__List,
                    outVarName);

            outVar_TypeString = "MatrixSet<Descriptor>";
            outVar_TypeSymbol = MPSymbols.MatrixSet$60$Descriptor$62$;





        } else if (currChildAccessInfo.typeOfElementAccessed == DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.FieldValueSet) {

            codeBuilder_MultiAccess
                .append("\n" + baseIndent + "\t" + childAccessGenInfo.outComment_AccessDescription)
                .append(baseIndent + "\tMatrixSet<Object> " + outVarName + " = new MatrixSet<Object>();\n")
                .append(baseIndent + "\tif (DescriptorUtilities.validDescriptors(executeInfo, " + currAccessSettings.parent_OutExpression + ")) {\n")
                .append(baseIndent + "\t\ttry{\n");

            if (childAccess_Index == 0) { // initial access
                codeBuilder_MultiAccess
                    .append(baseIndent + "\t\t\tif (" + currAccessSettings.parent_OutExpression + ".get_FieldSet() != null) {\n")
                    .append(baseIndent + "\t\t\t\t" + outVarName + ".add(" + currAccessSettings.parent_OutExpression + ".get_FieldSet().getField(executeInfo, " +
                            childAccessGenInfo.getChildDescriptor_ParamValue1 + "));\n")
                    .append(baseIndent + "\t\t\t}\n");

            } else {
                codeBuilder_MultiAccess
                    .append(baseIndent + "\t\t\tfor(Descriptor childDesc : " + currAccessSettings.parent_OutExpression + ") {\n")
                    .append(baseIndent + "\t\t\t\tif (childDesc.get_FieldSet() != null) {\n")
                    .append(baseIndent + "\t\t\t\t\t" + outVarName + ".add(childDesc.get_FieldSet().getField(executeInfo, " +
                            childAccessGenInfo.getChildDescriptor_ParamValue1 + "));\n")
                    .append(baseIndent + "\t\t\t\t}\n")
                    .append(baseIndent + "\t\t\t}\n");
            }


            //  if there's a filter add the filter call
            if (currChildAccessInfo.multiAccess_FiltersAnnotationReference_Exists) {

                codeBuilder_MultiAccess.append(baseIndent + "\t\t\t" + outVarName + " = (" + MPSymbols.MatrixSet$60$Object$62$.name_no_backtiks + ")");

                annotationCall_CodeGen_Filters.determine_AnotationRef(currChildAccessInfo, childAccess_Index);
                annotationCall_CodeGen_Filters.generateCall(codeBuilder_MultiAccess, childAccess_Index,
                    rootAccessSettings.parent_OutExpression, currAccessSettings.parent_OutExpression, outVarName, currChildAccessInfo.typeOfElementAccessed,
                    MPSymbols.MatrixSet$60$Object$62$, false, true, prevAccessIsMultiAccess,
                    is_MatrixAccess_In_StaticMethod, embeddedFile_ClassName,
                    intraMethod_ChildAccessExpr_Pairs__List);

                codeBuilder_MultiAccess.append(";\n");
            }

            
            //  Error Handling code:
            codeBuilder_MultiAccess
                    .append(baseIndent + "\t\t} catch (Exception e) {\n")
                    .append(baseIndent + "\t\t\texecuteInfo.setErrorException(e);\n")
                    .append(baseIndent + "\t\t}\n\n")

                    .append(baseIndent + "\t} else { // end of if (validDescriptors())\n")
                    .append(baseIndent + "\t\texecuteInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);\n")
                    .append(baseIndent + "\t}\n\n");


            generate_AccessChildCode_AccessErrorCode(codeBuilder_MultiAccess, true, false, is_MatrixAccess, MPSymbols.MatrixSet$60$Object$62$,
                    childAccess_Index, currChildAccessInfo, intraMethod_ChildAccessExpr_Pairs__List,
                    outVarName);

            outVar_TypeString = "MatrixSet<Object>";
            outVar_TypeSymbol = MPSymbols.MatrixSet$60$Object$62$;

        }


        output_DefaultValue = "null";


        return codeBuilder_MultiAccess;
    }




}
