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

package net.unconventionalthinking.hierarchy;

import net.unconventionalthinking.compiler.tools.*;


/**
 *
 * @author peterjoh
 */
public class Node_ToStringProcessor implements AttributeNode_ToStringProcessor {

    public boolean DEBUG = false;

    private int indentLevel = 0;


    public Node_ToStringProcessor(boolean debug) {
        DEBUG = debug;
    }


    public String process_ToString(Object node) {

        String nodeClassName = node.getClass().getSimpleName();
        String nodeClassNamePrefix = nodeClassName.substring(0, 3);

        if (nodeClassNamePrefix.equals("AMp")) { // a matrix production alternative
            if (node instanceof AttributeNode) {
                AttributeNode attribNode = (AttributeNode)node;

                if (attribNode.has_CodeBuilder())  // notice, finding a code builder stops the walking of the tree up
                                                   // into the subtree (but still continues walking).
                    return(attribNode.code().toString());

                else { // there's no code Builder, call the toString method. If in debug, print out !: to let dev know that
                       // an AMp node had a toString called on it, and not the codeBuilder.
                    if (!DEBUG)
                        return (attribNode.toString());
                    else
                        return (" !:" + attribNode.toString() + ":! ");
                }

            }
            else
                return null;

        } else if (nodeClassNamePrefix.equals("TMp")) { // a matrix token - actually, this one will probably never be called.
            if (node instanceof AttributeNode)
                return node.toString();
            else
                return null;
        } else if (nodeClassName.equals("TSemi")) { // The semi token.
            //  Let's add a line feed if you see a semi
            return
                ( (node instanceof AttributeNode && ((AttributeNode)node).has_CodeBuilder()) ? ((AttributeNode)node).code().toString() : ";") +
                "\n" + indentLevel_GetTabs();

        } else if (nodeClassName.equals("TLBrc")) { // The '{' token.
            //  Let's add a line feed if you see a '{'
            inc_IndentLevel();
            return
                ( (node instanceof AttributeNode && ((AttributeNode)node).has_CodeBuilder()) ? ((AttributeNode)node).code().toString() : "{") +
                    "\n" + indentLevel_GetTabs();

        } else if (nodeClassName.equals("TRBrc")) { // The '}' token.
            //  Let's add a line feed if you see a '}'
            dec_IndentLevel();
            return "\n" + indentLevel_GetTabs() +
                ( (node instanceof AttributeNode && ((AttributeNode)node).has_CodeBuilder()) ? ((AttributeNode)node).code().toString() : "}") +
                    "\n" + indentLevel_GetTabs() ;

        } else { // should be just a regular node object
            if (node instanceof AttributeNode) {
                AttributeNode attribNode = (AttributeNode)node;

                if (attribNode.has_CodeBuilder())  // notice, finding a code builder stops the walking of the tree up
                                                   // into the subtree (but still continues walking).
                    return(attribNode.code().toString());

                else { // there's no code Builder, call the toString method. If in debug, print out !: to let dev know that
                       // an AMp node had a toString called on it, and not the codeBuilder.
                    if (!DEBUG)
                        return (attribNode.toString());
                    else
                        return (" !:" + attribNode.toString() + ":! ");
                }

            } else {
                return node.toString();
            }
        }


    }

    public void set_IndentLevel(int indentLevel) { this.indentLevel = indentLevel; }
    public void inc_IndentLevel() { ++indentLevel; }
    public void dec_IndentLevel() { indentLevel--; }
    public int  get_IndentLevel() { return indentLevel; }

    public String indentLevel_GetTabs() {
        StringBuilder tabs = new StringBuilder();

        for (int i = 0; i < indentLevel; ++i)
            tabs.append("\t");

        return tabs.toString();
    }
}
