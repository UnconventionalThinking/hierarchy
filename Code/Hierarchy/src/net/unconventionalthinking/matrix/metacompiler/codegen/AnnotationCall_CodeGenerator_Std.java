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
import net.unconventionalthinking.matrix.metacompiler.codefilegen.AnnotationsInterface_FileGenerator;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.AnnotationParameters;
import net.unconventionalthinking.matrix.AnnotationReference_Utilities;
import net.unconventionalthinking.matrix.Exception_MatrixRuntime_Checked;
import net.unconventionalthinking.matrix.symbols.Symbol_Single;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author peterjoh
 */
public class AnnotationCall_CodeGenerator_Std extends AnnotationCall_CodeGenerator {


    public Symbol          lastSeen_AnnotationReference;
    public Symbol_Single   lastSeen_AnnotationRefBase;
    public int             annotationRef_AccessCounter;






    public AnnotationCall_CodeGenerator_Std(HierarchySettings hierarchySettings, AnnotationsInterface_FileGenerator annotationInterface_FileGen,
            AnnotationsCodeGenerator_Control annotationsCodeGenerator_Control) {
        super(hierarchySettings, annotationInterface_FileGen, annotationsCodeGenerator_Control);
        


        lastSeen_AnnotationReference = null;
        lastSeen_AnnotationRefBase = null;
        annotationRef_AccessCounter = 0;

    }






    /**
     * For each new matrix access, call this method so we can init some annotation vars
     */
    @Override
    public void starting_NewAccess() {
        lastSeen_AnnotationReference = null;
        lastSeen_AnnotationRefBase = null;
        annotationRef_AccessCounter = 0;
    }

    /**
     * For each child access, call this method to determine what the annotation ref is.
     */
    @Override
    public void determine_AnotationRef(DescriptorAccess_ChildAccessInfo childAccessInfo, int childAccess_Index) throws Exception_MetaCompilerError {

        Symbol annotationRef_ForCurrentAccess = null;

        if (childAccessInfo.annotationReference_Exists) {
            lastSeen_AnnotationReference = annotationRef_ForCurrentAccess = childAccessInfo.annotationReference;
            lastSeen_AnnotationRefBase = (Symbol_Single)childAccessInfo.annotationReference.getSymbol_AtPartNum(1);

            try {
                annotationRef_AccessCounter = AnnotationReference_Utilities.get_ReferenceCounter(lastSeen_AnnotationReference);
            } catch (Exception_MatrixRuntime_Checked e) {
                throw new Exception_MetaCompilerError("Error: See inner exception.", e);
            }

        } else {
            if (childAccess_Index == 0) // first access
                annotationRef_AccessCounter = 0;
            else
                ++annotationRef_AccessCounter;
        }
    }






    /**
     * For each matrix access, must create a new annotation handler method name for it.
     * @param methodName
     */
    @Override
    public CodeBuilder generateCall(CodeBuilder codeBuilder, int childIndex, 
            String matrix_OutExpression, String parentDescriptor_OutVar, String currDesc_OutVarName, DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed typeOfMatrixAccess,
            Symbol accessValue_Type, boolean is_Continuation_Field_Access, boolean is_MultiAccess, boolean prevAccess_isMultiAccess,
            boolean is_MatrixAccess_In_StaticMethod, String embeddedFile_ClassName,
            List<Pair<String, String>> childAccessPairs_List) {

        return generateCall(codeBuilder, childIndex, 
                matrix_OutExpression, parentDescriptor_OutVar, currDesc_OutVarName, typeOfMatrixAccess, accessValue_Type,
                is_Continuation_Field_Access, is_MultiAccess, prevAccess_isMultiAccess, is_MatrixAccess_In_StaticMethod, embeddedFile_ClassName,
                childAccessPairs_List, false, null);
    }

    @Override
    public CodeBuilder generateCall(CodeBuilder codeBuilder, int childIndex, 
            String matrix_OutExpression, String parentDescriptor_OutVar, String currDesc_OutVarName, DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed typeOfMatrixAccess,
            Symbol accessValue_Type, boolean is_Continuation_Field_Access, boolean is_MultiAccess, boolean prevAccess_isMultiAccess,
            boolean is_MatrixAccess_In_StaticMethod, String embeddedFile_ClassName,
            List<Pair<String, String>> childAccessPairs_List, boolean passInException, String exceptionObj_OutVarName) {

        CodeBuilder codeBuilder_AnnoteCall = new CodeBuilder();

        boolean annotationReference_Exists = (lastSeen_AnnotationRefBase != null);
        Symbol_Single annotationRef_Base = lastSeen_AnnotationRefBase;

        //  Determine the caller object for annotation method call. If its for a matrix access in a static method, you call the annotation
        //  on the embedded file's class name. If a regular, non-static annotation method call, use the callerObj.
        String callerObject_Code = (is_MatrixAccess_In_StaticMethod ? embeddedFile_ClassName : "callerObj");


        codeBuilder_AnnoteCall.append(callerObject_Code + "." + CodeConstants.OutMethodName_AnnotationMethod_Suffix +
                annotationsCodeGenerator_Control.get_MethodIndex()).append("(executeInfo, ");
        if (annotationReference_Exists)
            codeBuilder_AnnoteCall.append("true, " + hierarchySettings.appSymbols_ClassName + "." + annotationRef_Base.name_IdentFormat + ", " +
                    annotationRef_AccessCounter);
        else
            codeBuilder_AnnoteCall.append("false, null, " + annotationRef_AccessCounter);

        String typeOfMatrixAccess_String = (typeOfMatrixAccess != null) ?
            "AnnotationParameters.AccessType." + typeOfMatrixAccess.toString() : "null";
        codeBuilder_AnnoteCall.append(", " + childIndex + ", " + typeOfMatrixAccess_String + ", " + hierarchySettings.accessReturnTypeOutParam_ParamName + ", ");
        codeBuilder_AnnoteCall.append(matrix_OutExpression + ", ");


        // if the prev access is multi access
        if (childIndex != 0 && prevAccess_isMultiAccess)
            codeBuilder_AnnoteCall.append("null, " + parentDescriptor_OutVar + ", ");
        else // single access
            codeBuilder_AnnoteCall.append(parentDescriptor_OutVar + ", null, ");
            
        codeBuilder_AnnoteCall.append(passInException + ", " + exceptionObj_OutVarName);



        for (int i = 0; i <= childIndex; ++i) {
            Pair<String, String> accessExpr1_and_accessExpr2 = childAccessPairs_List.get(i);

            codeBuilder_AnnoteCall.append(", new Pair<Object, Object>(");
            //  if this is the last element accessed and this access is to a continuation field, then the parameter passed in as a cont index.
            if (i == childIndex && is_Continuation_Field_Access) {
                codeBuilder_AnnoteCall.append(accessExpr1_and_accessExpr2.first + ", " +
                    "new Integer(" + accessExpr1_and_accessExpr2.second + "))");

            } else {
                codeBuilder_AnnoteCall.append(accessExpr1_and_accessExpr2.first + ", " +
                    accessExpr1_and_accessExpr2.second + ")");
            }

        }

        codeBuilder_AnnoteCall.append(")");


        
        if (codeBuilder != null) {
            codeBuilder.append(codeBuilder_AnnoteCall);
            return codeBuilder;
        } else {
            return codeBuilder_AnnoteCall;
        }
    }




}
