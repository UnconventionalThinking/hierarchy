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
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.AnnotationReference_Utilities;
import net.unconventionalthinking.matrix.Exception_MatrixRuntime_Checked;
import net.unconventionalthinking.matrix.MatrixControl;
import net.unconventionalthinking.matrix.SchemaControl;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.matrix.symbols.Symbol_Single;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import java.util.ArrayList;
import java.util.List;




/**
 * NOTE: This is used RECURSIVELY!!
 * 
 * Each annotaton body bock has one! And, the code generated from child AnnoationHandler_CodeBenerator_AnooationBodyBock objects is added to the
 * parent's child code.
 *
 *
 * @author peterjoh
 */
public class AnnotationHandler_CodeGenerator_AnnotationBlockStmt {

    SymbolControl symbolControl;
    SchemaControl schemaControl;
    MatrixControl matrixControl;
    ExecutionInfo executeInfo;

    HierarchySettings hierarchySettings;

    int     baseIndentLevel;
    String  baseIndent;


    CodeBuilder codeBuilder_AnnoteBlockStmt;
    List<Object> childBlockStmt_List; // holds CodeBuilders and child AnnotationHandler_CodeGenerator_AnnotationBlockStmt

    Symbol annotationHandlerReference;
    Symbol_Single annotationHandlerRef_Base;
    int annotationHandlerRef_AccessCounter;

    
    AnnotationHandler_CodeGenerator_AnnotationBlockStmt nextSibling__AnnoteBlockStmt_CodeGen;
    boolean isFirst_AnnotationBlockStmtCodeGen_Sibling;
    boolean isLast_AnnotationBlockStmtCodeGen_Sibling;




    public AnnotationHandler_CodeGenerator_AnnotationBlockStmt(SymbolControl symbolControl, SchemaControl schemaControl, MatrixControl matrixControl,
            HierarchySettings hierarchySettings, int baseIndentLevel) {

        this.symbolControl = symbolControl;
        this.schemaControl = schemaControl;
        this.matrixControl = matrixControl;

        this.hierarchySettings = hierarchySettings;

        executeInfo = new ExecutionInfo();

        set_BaseIndentLevel(baseIndentLevel);

        codeBuilder_AnnoteBlockStmt = new CodeBuilder();
        childBlockStmt_List = new ArrayList<Object>();
    }


    public CodeBuilder get_CodeBuilder_AnnoteBlockStmt() {
        return codeBuilder_AnnoteBlockStmt;
    }

    public void set_AnnotateHandlerReference(Symbol annotationHandlerReference) throws Exception_MetaCompilerError {
        this.annotationHandlerReference = annotationHandlerReference;

        annotationHandlerRef_Base = (Symbol_Single)annotationHandlerReference.getSymbol_AtPartNum(1);

        try {
            annotationHandlerRef_AccessCounter = AnnotationReference_Utilities.get_ReferenceCounter(annotationHandlerReference);
        } catch (Exception_MatrixRuntime_Checked e) {
            throw new Exception_MetaCompilerError("Error: See inner exception.", e);
        }

    }


    public void add_Child_AnnotationBlockStmt(AnnotationHandler_CodeGenerator_AnnotationBlockStmt codeGenerator_ChildBlockStmt) {
        childBlockStmt_List.add(codeGenerator_ChildBlockStmt);
    }
    public void add_Child_AnnotationBlockStmt(CodeBuilder childBlockStmt) {
        childBlockStmt_List.add(childBlockStmt);
    }
    public void add_Child_AnnotationBlockStmt(String childBlockStmt) {
        childBlockStmt_List.add(childBlockStmt);
    }

    /**
     * We need to know what the next sibling child_annotationBlockStmt is. Why? because we need to know what the range of the annotation ref counter
     * should be. For example, from *1.1 to *1.3 (so, the first range should be  >= 1  and < 3.
     */
    public void set_NextSiblingInfo(AnnotationHandler_CodeGenerator_AnnotationBlockStmt nextSibling__AnnoteBlockStmt_CodeGen) {
        this.nextSibling__AnnoteBlockStmt_CodeGen = nextSibling__AnnoteBlockStmt_CodeGen;

    }
    public void set_IsFirst_AnnotationBlockStmtCodeGen_Sibling(boolean isFirst_AnnotationBlockStmtCodeGen_Sibling) {
        this.isFirst_AnnotationBlockStmtCodeGen_Sibling = isFirst_AnnotationBlockStmtCodeGen_Sibling;
    }
    public void set_IsLast_AnnotationBlockStmtCodeGen_Sibling(boolean isLast_AnnotationBlockStmtCodeGen_Sibling) {
        this.isLast_AnnotationBlockStmtCodeGen_Sibling = isLast_AnnotationBlockStmtCodeGen_Sibling;
    }



    public void set_BaseIndentLevel(int indentLevel) {
        this.baseIndentLevel = indentLevel;
        baseIndent = "";
        for (int i = 0; i < indentLevel; ++i)
            baseIndent += "\t";
    }



    /**
     * This is an important method. It needs to be called before you call generate_AnnoteBlockStmt on each annotation CodeGen.
     * It's used to setup the next sibling info for a tree of Annotation CodeGens (actually, a "Forest" of Annotation Code Gens.
     *
     * @param childBlockStmt_List   A list of annotation Block stmts, that are a mix of Annote CodeGen's, CodeBuilders, and Strings
     */
    public static void setupChildren_Helper(List<Object> childBlockStmt_List) {


        //  Set the codeGenerator next sibling info:

        AnnotationHandler_CodeGenerator_AnnotationBlockStmt prev_AnnoteBlockStmt_CodeGen = null;
        AnnotationHandler_CodeGenerator_AnnotationBlockStmt curr_AnnoteBlockStmt_CodeGen = null;


        int annotationBlockStmt_CodeGen__Count = 0;
        for (Object childBlockStmt : childBlockStmt_List) {

            if (childBlockStmt instanceof AnnotationHandler_CodeGenerator_AnnotationBlockStmt) {
                curr_AnnoteBlockStmt_CodeGen = (AnnotationHandler_CodeGenerator_AnnotationBlockStmt)childBlockStmt;
                ++annotationBlockStmt_CodeGen__Count;

                curr_AnnoteBlockStmt_CodeGen.setupChildren(); // recursive call, so a child annote CodeGen will setup it's sibling info first.

                if (prev_AnnoteBlockStmt_CodeGen != null)
                    prev_AnnoteBlockStmt_CodeGen.set_NextSiblingInfo(curr_AnnoteBlockStmt_CodeGen);

                if (annotationBlockStmt_CodeGen__Count == 1)
                    curr_AnnoteBlockStmt_CodeGen.set_IsFirst_AnnotationBlockStmtCodeGen_Sibling(true);

                prev_AnnoteBlockStmt_CodeGen = curr_AnnoteBlockStmt_CodeGen;
            }

        }

        if (curr_AnnoteBlockStmt_CodeGen != null)
            curr_AnnoteBlockStmt_CodeGen.set_IsLast_AnnotationBlockStmtCodeGen_Sibling(true);

    }


    /**
     * this method is used by setupChildren_Helper, so it can operate recursively.
     */
    void setupChildren() {
        setupChildren_Helper(childBlockStmt_List);
    }



    /**
     * This is a recursive method
     *
     * @return
     * @throws Exception_MetaCompilerError
     */
    public CodeBuilder generate_AnnoteBlockStmt() throws Exception_MetaCompilerError {

        boolean is_TwoLevel_Reference = (annotationHandlerReference.getNumOfParts() == 2);
        boolean is_Default_Reference = (annotationHandlerReference == MPSymbols.DEFAULT);

        String indentOption = (isFirst_AnnotationBlockStmtCodeGen_Sibling) ? baseIndent : "";
        String elseOption = (!isFirst_AnnotationBlockStmtCodeGen_Sibling) ? " else " : "";



        codeBuilder_AnnoteBlockStmt.append(indentOption);
        if (is_Default_Reference) {
            // no if then added
            codeBuilder_AnnoteBlockStmt.append('\n').append(baseIndent).append("//  Default:\n");
            codeBuilder_AnnoteBlockStmt.append(indentOption);

        } else if (!is_TwoLevel_Reference) { // one level annoteRef
            codeBuilder_AnnoteBlockStmt.append(elseOption).append(
              "if (annotationRef_Base == " + hierarchySettings.appSymbols_ClassName + "." + annotationHandlerReference.get_Name_IdentFormat() + ") {\n");

        } else { // two level annoteRef

            int conditionCount = 0;
            String gt_eq_condition = "";
            String lt_condition = "";
            if (isFirst_AnnotationBlockStmtCodeGen_Sibling) {
                gt_eq_condition = "annotationRef_AccessCounter >= " + annotationHandlerRef_AccessCounter;

                ++conditionCount;
            }
            if (!isLast_AnnotationBlockStmtCodeGen_Sibling) {
                lt_condition  = "annotationRef_AccessCounter < " + nextSibling__AnnoteBlockStmt_CodeGen.annotationHandlerRef_AccessCounter;
                ++conditionCount;
            }



            if (conditionCount > 0) {
                String andOption = (conditionCount == 2) ? " && " : "";

                codeBuilder_AnnoteBlockStmt.append(
                  elseOption + "if (" + gt_eq_condition + andOption + lt_condition +") {\n");

            } else { // this must be the last 2nd level annotation reference. It should just have an else
                codeBuilder_AnnoteBlockStmt.append(
                  " else { \n");

            }
        }


        
        generate_AnnoteBlockStmt__ProcessChildren(is_Default_Reference);


        //  no closing '}' if it's the default reference, cause their is no 'if (...)'
        if (!is_Default_Reference)
            codeBuilder_AnnoteBlockStmt.append(baseIndent).append("}");

 

        return codeBuilder_AnnoteBlockStmt;
    }


    void generate_AnnoteBlockStmt__ProcessChildren(boolean is_Default_Reference) throws Exception_MetaCompilerError {

        //  set the base indent level for the nested child stmts.
        String child_baseIndent = baseIndent + '\t';
        int child_baseIndentLevel = baseIndentLevel + 1;
        if (is_Default_Reference) {
            child_baseIndent = baseIndent;
            child_baseIndentLevel = baseIndentLevel;
        }
        

        for (Object childBlockStmt : childBlockStmt_List) {

            if (childBlockStmt instanceof String) {
                codeBuilder_AnnoteBlockStmt.append(child_baseIndent).append((String)childBlockStmt).append("\n");

            } else {
                CodeBuilder codeBuilder_ChildBlockStmt = null;

                if (childBlockStmt instanceof CodeBuilder) {
                    codeBuilder_ChildBlockStmt = (CodeBuilder)childBlockStmt;
                    codeBuilder_ChildBlockStmt.addToStart(child_baseIndent);

                } else if (childBlockStmt instanceof AnnotationHandler_CodeGenerator_AnnotationBlockStmt) {
                    AnnotationHandler_CodeGenerator_AnnotationBlockStmt annoteBlockStmt_CodeGen = (AnnotationHandler_CodeGenerator_AnnotationBlockStmt)
                            childBlockStmt;
                    annoteBlockStmt_CodeGen.set_BaseIndentLevel(child_baseIndentLevel);
                    codeBuilder_ChildBlockStmt = annoteBlockStmt_CodeGen.generate_AnnoteBlockStmt();

                } else {
                    throw new Exception_MetaCompilerError("Generating an annotation method, and adding in Child Block Stmts. But, for some reason, a child block stmt was not a string, codeBuilder or a AnnotationBlockStmt Code Generator object.");
                }

                codeBuilder_AnnoteBlockStmt.append(codeBuilder_ChildBlockStmt);
            }
        }

    }

}
