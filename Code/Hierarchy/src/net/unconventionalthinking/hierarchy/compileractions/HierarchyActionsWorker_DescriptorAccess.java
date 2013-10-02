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

package net.unconventionalthinking.hierarchy.compileractions;

import net.unconventionalthinking.compiler.tools.AttributeNode;
import net.unconventionalthinking.compiler.tools.MethodAttributeSet;
import net.unconventionalthinking.matrix.metacompiler.codegen.CodeUtilities;
import net.unconventionalthinking.matrix.metacompiler.codegen.DescriptorAccess_ChildAccessInfo;
import net.unconventionalthinking.matrix.metacompiler.codegen.DescriptorAccess_CodeGenerator;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolType;
import net.unconventionalthinking.hierarchy.Exception_HierarchyCompiler;
import net.unconventionalthinking.hierarchy.HierarchyControl;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author peterjoh
 */
public class HierarchyActionsWorker_DescriptorAccess extends HierarchyActionsWorker {


    public HierarchyActionsWorker_DescriptorAccess(HierarchyActions hierarchyActions, HierarchyControl hierarchyControl, int baseIndentLevel) {
        super(hierarchyActions, hierarchyControl, baseIndentLevel);
    }




    public void generate_MatrixAccess(DescriptorAccess_CodeGenerator descAccess_CodeGen,
            List<DescriptorAccess_ChildAccessInfo> childAccessInfo_List,
            Boolean collecting_MatrixAccessState, Boolean is_MatrixFieldAssignment, AttributeNode node) {

        try {
            descAccess_CodeGen.set_3_ChildAccessInfo(childAccessInfo_List);
            if (collecting_MatrixAccessState != null && collecting_MatrixAccessState.booleanValue() == true)
                descAccess_CodeGen.set_2_CollectMatrixAccessState();
            else if (is_MatrixFieldAssignment != null && is_MatrixFieldAssignment.booleanValue() == true)
                descAccess_CodeGen.set_2_IsMatrixFieldAssignment();


            descAccess_CodeGen.generate_MartrixAccess_Method(hierarchyActions.outputResults);

        } catch (Exception_MetaCompilerError e) {
            hierarchySettings.logger.reportError_And_Exit("Tried to generate matrix access code, but had an error.", e);

        }


        //  If we're doing matrix access with a embedded java file, it uses the node.code() code builder. so, must set it to the access code
        node.code(descAccess_CodeGen.getCodeBuilder_EmbeddedCode().toString());


    }


    public void initialize_ChildAccessInfo(AttributeNode node, DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed typeOfAccess,
            boolean has_AnnotationUseage, Symbol annotationReference) {

        MethodAttributeSet generateAccess_Attribs = node.getMethodAttributes();

        DescriptorAccess_ChildAccessInfo curr_ChildAccessInfo = (DescriptorAccess_ChildAccessInfo) generateAccess_Attribs.vars.get(
                HierarchyMethodConstants.var_Curr_ChildAccessInfo);

        //  These can all change to mult access if the later multiple access productions are matched on.
        curr_ChildAccessInfo.typeOfElementAccessed = typeOfAccess;
        curr_ChildAccessInfo.is_SingleAccess = true;


        curr_ChildAccessInfo.annotationReference_Exists = has_AnnotationUseage;
        if (has_AnnotationUseage) {
            curr_ChildAccessInfo.annotationReference = annotationReference;
        }

    }




    public void setSymbolExpr(String symExpr, int exprNum, DescriptorAccess_ChildAccessInfo curr_ChildAccessInfo, String symbolMethod_Constant,
            String symbolMethod_RetVal_Constant) {

        Symbol symbol = (hierarchyControl.returnValues_getMap_for(symbolMethod_Constant) != null)
                ? (Symbol) hierarchyControl.returnValues_getMap_for(symbolMethod_Constant).get(symbolMethod_RetVal_Constant)
                : null;



        curr_ChildAccessInfo.numberOfExpresions = (short) exprNum;

        try {
            if ((curr_ChildAccessInfo.typeOfElementAccessed == DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.Field
                    || curr_ChildAccessInfo.typeOfElementAccessed == DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.FieldValueSet)
                    && exprNum == 2) {
                throw new Exception_HierarchyCompiler("Matrix Access Syntax error. Can not have a second access expression and access a field. You can only"
                        + "have one. The second access expression was: '" + symExpr + "'");
            }



            //  ***See if the expression is a symbol, schemaName or desctag. Note, you can't just check to see if a symbol is returned. Because, maybe
            //  the symbol created is nested in the symbolExpr. Something like: "callAMethod(MPSymbols_DescTagName.sym1)".  You also need to
            //  check the actual expression to see if it starts with "MPSymbols..."
            SymbolType symbolType = CodeUtilities.getSymbolType_FromCodeString(symExpr, hierarchySettings.appSymbols_ClassName);
            if (symbol != null && symbolType != null) {

                if (symbolType == SymbolType.DescriptorTagName) {
                    if (exprNum == 1) {

                        curr_ChildAccessInfo.accessExpr1 = hierarchySettings.appSymbols_ClassName + hierarchySettings.symbolClassSuffix_DescTagName + "."
                                + symbol.get_Name_IdentFormat();
                        curr_ChildAccessInfo.accessExpr1_Is_Static_DescTagName = true;
                        curr_ChildAccessInfo.accessExpr1_DescTagOrLabel_Actual = symbol;
                        curr_ChildAccessInfo.accessExpr1_SymbolParts = Arrays.asList(symbol.getSymbolNames());

                        curr_ChildAccessInfo.accessExpr1_Is_Static_DescTag = false;
                        curr_ChildAccessInfo.accessExpr1_Is_Static_Label = false;

                    } else {
                        throw new Exception_HierarchyCompiler("Matrix Access Syntax error. Can not have a second expression that is a desc tag name. It should"
                                + "either be a Label or a Continuation Index. The second expr was: '" + symExpr + "'");
                    }
                } else if (symbolType == SymbolType.DescriptorTag) {
                    if (exprNum == 1) {

                        curr_ChildAccessInfo.accessExpr1 = hierarchySettings.appSymbols_ClassName + hierarchySettings.symbolClassSuffix_DescTag + "."
                                + symbol.get_Name_IdentFormat();
                        curr_ChildAccessInfo.accessExpr1_Is_Static_DescTag = true;
                        curr_ChildAccessInfo.accessExpr1_DescTagOrLabel_Actual = symbol;
                        curr_ChildAccessInfo.accessExpr1_SymbolParts = Arrays.asList(symbol.getSymbolNames());

                        curr_ChildAccessInfo.accessExpr1_Is_Static_DescTagName = false;
                        curr_ChildAccessInfo.accessExpr1_Is_Static_Label = false;

                    } else {
                        throw new Exception_HierarchyCompiler("Matrix Access Syntax error. Can not have a second expression that is a desc tag. It should"
                                + "either be a Label or a Continuation Index. The second expr was: '" + symExpr + "'");
                    }


                } else if (symbolType == SymbolType.Label) {
                    if (exprNum == 1) {
                        curr_ChildAccessInfo.accessExpr1 = symExpr;
                        curr_ChildAccessInfo.accessExpr1_Is_Static_Label = true;
                        curr_ChildAccessInfo.accessExpr1_DescTagOrLabel_Actual = symbol;
                        curr_ChildAccessInfo.accessExpr1_SymbolParts = Arrays.asList(symbol.getSymbolNames());

                        curr_ChildAccessInfo.accessExpr1_Is_Static_DescTag = false;

                    } else { // is a 2nd expr
                        curr_ChildAccessInfo.accessExpr2 = symExpr;
                        curr_ChildAccessInfo.accessExpr2_Exists = true;
                        curr_ChildAccessInfo.accessExpr2_Is_Static_Label = true;
                        curr_ChildAccessInfo.accessExpr2_Label_Actual = (Label) symbol;
                        curr_ChildAccessInfo.accessExpr2_LabelParts = Arrays.asList(symbol.getSymbolNames());

                    }

                } else {  // means that: (symbolType == SymbolType.Symbol)
                    throw new Exception_HierarchyCompiler("Matrix Access Syntax error. Can not have an access expression that is a static symbol. It should"
                            + "either be a Label or a Continuation Index. The expr was: '" + symExpr + "'");
                }


            } else {
                if (exprNum == 1) {
                    curr_ChildAccessInfo.accessExpr1 = symExpr;
                    curr_ChildAccessInfo.accessExpr1_Is_Static_DescTagName = false;
                    curr_ChildAccessInfo.accessExpr1_Is_Static_DescTag = false;
                    curr_ChildAccessInfo.accessExpr1_Is_Static_Label = false;

                } else { // is a 2nd expr
                    curr_ChildAccessInfo.accessExpr2 = symExpr;
                    curr_ChildAccessInfo.accessExpr2_Exists = true;
                    curr_ChildAccessInfo.accessExpr2_Is_Static_Label = false;
                }

            }


        } catch (Exception_HierarchyCompiler e) {
            hierarchySettings.logger.reportError_And_Exit("Tried to generate matrix access code, but had an error.", e);

        }
    }






    public void setupMultiAccess(MethodAttributeSet generateAccess_Attribs, boolean has_FiltersAnnotationReference, Symbol annoteRef) {

        DescriptorAccess_ChildAccessInfo curr_ChildAccessInfo = (DescriptorAccess_ChildAccessInfo) generateAccess_Attribs.vars.get(
                HierarchyMethodConstants.var_Curr_ChildAccessInfo);

        curr_ChildAccessInfo.is_SingleAccess = false;

        if (curr_ChildAccessInfo.typeOfElementAccessed == DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.Descriptor)
            curr_ChildAccessInfo.typeOfElementAccessed = DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.DescriptorSet;
        else if (curr_ChildAccessInfo.typeOfElementAccessed == DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.Field)
            curr_ChildAccessInfo.typeOfElementAccessed = DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.FieldValueSet;

        curr_ChildAccessInfo.multiAccess_FiltersAnnotationReference_Exists = has_FiltersAnnotationReference;
        curr_ChildAccessInfo.multiAccess_FiltersAnnotationRef = annoteRef;

    }


}
