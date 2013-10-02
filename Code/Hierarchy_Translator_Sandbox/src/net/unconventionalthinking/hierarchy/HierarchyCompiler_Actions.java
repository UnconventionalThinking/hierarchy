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

package net.unconventionalthinking.hierarchy;

/**
 *
 * @author peterjoh
 */

import net.unconventionalthinking.hierarchy.Node_Utilities;
import net.unconventionalthinking.hierarchy.grammar.analysis.*;
import net.unconventionalthinking.hierarchy.grammar.node.*;
import java.util.LinkedList;

import net.unconventionalthinking.compiler.tools.*;



public class HierarchyCompiler_Actions extends DepthFirstAdapter {

    private CompilerSettings compilerSettings;



    public HierarchyCompiler_Actions() {
        compilerSettings = new CompilerSettings();
    }
    public HierarchyCompiler_Actions(CompilerSettings compilerSettings) {
        this.compilerSettings = compilerSettings;
    }




    @Override
    public void caseAMpSectionMpDeclarationSection(AMpSectionMpDeclarationSection node)
    {
        if (compilerSettings.matrixCode_Passthrough_Code) {
            Node_Utilities.setCurrentAndParent_Code(node,
                node.code().append(
                    node.getMpDeclarationsKeyword().code(), " ", node.getMpDeclarationSectionBody(), "\n")

            );
        }

        System.out.println("Out:\n" + node.code());

    }
/*
    @Override
    public void caseAMpBodyMpDeclarationSectionBody(AMpBodyMpDeclarationSectionBody node)
    {
        CodeBuilder matrixStatement_CodeBlock =  Node_Utilities.createCode_fromManyChildNodes(node.getMatrixStatement(), "\n");

        if (compilerSettings.matrixCode_Passthrough_Code) {
            Node_Utilities.setCurrentAndParent_Code(node,
                node.code().append(
                    node.getLBrc().code(),"\n", matrixStatement_CodeBlock, node.getRBrc().code(), "\n"
                )
            );
        }


    }

    @Override
    public void outALocalVariableDeclarationStatement(ALocalVariableDeclarationStatement node)
    {
        if (compilerSettings.matrixCode_Passthrough_Code) {
            Node_Utilities.setCurrentAndParent_Code(node,
                node.code().append(
                    node.getType(), " ", node.getIdentifier(), " ", node.getVarAssignment(), node.getSemi()
                )

            );
        }

    }

*/

    /*

    @Override
    public void outANormalClassClassDeclaration(ANormalClassClassDeclaration node)
    {
        Node_Utilities.setCurrentAndParent_Code(node,
            node.getClassBody().code().addToStart(
                node.getClassToken().getText(), " ", node.getIdentifier().getText()
            )
        );

        System.out.println("Out NormalClassDecl:\n" + node.code());
    }    */


}
