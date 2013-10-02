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
import net.unconventionalthinking.matrix.MatrixControl;
import net.unconventionalthinking.matrix.SchemaControl;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.hierarchy.HierarchySettings;




/**
 * NOTE: This is used RECURSIVELY!!
 * 
 * Each annotaton body bock has one! And, the code generated from child AnnoationHandler_CodeBenerator_AnooationBodyBock objects is added to the
 * parent's child code.
 *
 *
 * @author peterjoh
 */
public class AnnotationHandler_CodeGenerator_AnnotationBlockStmt__Filters extends AnnotationHandler_CodeGenerator_AnnotationBlockStmt {



    public AnnotationHandler_CodeGenerator_AnnotationBlockStmt__Filters(SymbolControl symbolControl, SchemaControl schemaControl, MatrixControl matrixControl,
            HierarchySettings hierarchySettings, int baseIndentLevel) {

        super(symbolControl, schemaControl, matrixControl, hierarchySettings, baseIndentLevel);
    }







    /**
     * This is a recusive method
     *
     * @return
     * @throws Exception_MetaCompilerError
     */
    @Override
    public CodeBuilder generate_AnnoteBlockStmt() throws Exception_MetaCompilerError {


        String indentOption = (isFirst_AnnotationBlockStmtCodeGen_Sibling) ? baseIndent : "";
        String elseOption = (!isFirst_AnnotationBlockStmtCodeGen_Sibling) ? " else " : "";



        codeBuilder_AnnoteBlockStmt.append(indentOption);
            codeBuilder_AnnoteBlockStmt.append(elseOption).append(
              "if (annotationRef == " + hierarchySettings.appSymbols_ClassName + "." + annotationHandlerReference.get_Name_IdentFormat() + ") {\n");




        generate_AnnoteBlockStmt__ProcessChildren(false);


        codeBuilder_AnnoteBlockStmt.append(baseIndent).append("}");

        codeBuilder_AnnoteBlockStmt.append("\n");


        return codeBuilder_AnnoteBlockStmt;
    }


}
