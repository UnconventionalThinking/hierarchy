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

package net.unconventionalthinking.hierarchy.persistence;


import net.unconventionalthinking.hierarchy.grammar.analysis.*;
import net.unconventionalthinking.hierarchy.grammar.node.*;

import net.unconventionalthinking.compiler.tools.*;
import net.unconventionalthinking.matrix.Matrix;


import net.unconventionalthinking.hierarchy.Node_ToStringProcessor;
import net.unconventionalthinking.hierarchy.compileractions.HierarchyMethodConstants;
import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of these actions is to replace just the MATRIX definition with an updated portion (leaving the rest untouched) from an updated
 * matrix. The way we do this is using a custom action class that does this replacement. All it is doing is in the MatrixNewDeclaration rule,
 * it IGNORES the MATRIX code from the, old file, and replaces it meta code generated from actual the updated persistent matrix.
 * @author peterjoh
 */
public class PersistentMatrixCodeGenerator_MatrixReplacer_MetaCompilerActions extends DepthFirstAdapter {


    private int baseIndentLevel = 2;

    private Matrix matrix;
    private List<String> usesSchema_List = new ArrayList<String>();

    private String replacedCode;



    public PersistentMatrixCodeGenerator_MatrixReplacer_MetaCompilerActions() {
    }

    public void setMatrix(Matrix matrix) { this.matrix = matrix;}

    public String getReplacedCode() { return replacedCode; }



    
    /**
     * The defaultIn is the default "In" method called when a node is visited. By overriding the method like we did here,
     * we can customize the default behavior for the In method.
     *
     * What we've done here is to have a parent automatically pass its child its method-attribute set (actually,
     * the child is grabbing the attrib set from its parent).
     *
     * @param node
     */
    @Override
    public void defaultIn(Node node) {
        if (node != null && node.parent() != null) {
            node.setMethodAttributes(node.parent().getMethodAttributes());
        }
    }

    //  Do initial Setup here:
    @Override
    public void inStart(Start node) {
        defaultIn(node);



        //  MatrixSet the default toString Processor for the nodes:
        AttributeNode.set_Default_ToStringProcessor(new Node_ToStringProcessor(false));
    }


    

    @Override
    public void outACompilationUnit(ACompilationUnit node) {
        replacedCode = node.toString();
    }





    @Override
    public void inAMpMatrixNewDeclaration(AMpMatrixNewDeclaration node) {
        defaultIn(node);
    }

    //  In between the inAMpMatrixNewDeclaration and the outAMpMatrixNewDeclaration, the uses schema list will be matched on. Collect the names.
    @Override
    public void outAMpSchemaName(AMpSchemaName node) {
        defaultOut(node);

        usesSchema_List.add(node.toString());
    }

    @Override
    public void outAMpMatrixNewDeclaration(AMpMatrixNewDeclaration node) {
        defaultOut(node);


        //  Apply the replacement actions
        StringBuilder newMatrixCode = new StringBuilder();
        matrix.print_MetaCode(newMatrixCode, 0, usesSchema_List);

        node.code(newMatrixCode);
    }




    
    @Override
    public void caseAMpSchemaNewDeclaration(AMpSchemaNewDeclaration node) {
    }
}
