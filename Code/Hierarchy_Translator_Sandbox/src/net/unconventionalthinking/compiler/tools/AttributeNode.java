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

package net.unconventionalthinking.compiler.tools;

/**
 *
 * @author peterjoh
 *
 * The purpose of this class is to extended by the SableCC nodes so they can have node attributes
 *
 *
 * Put these lines of code in your in Node.java

import net.unconventionalthinking.compiler.tools.*;
@SuppressWarnings("nls")
public abstract class Node extends AttributeNode implements Switchable, Cloneable


 * Put this method in your Token.java
    @Override
    public CodeBuilder code() {
        if (codeBuilder == null){
            if (text != null && text.trim().length() != 0)
                codeBuilder = new CodeBuilder(text);
            else
                codeBuilder = new CodeBuilder();
        }
        return codeBuilder;
    }



* Also, throw the Node_Utilities.java in your project, and use these methods as needed.

 */

public abstract class AttributeNode {

    private static boolean DEBUG = false;
    public static void setDEBUG(boolean value) { DEBUG = value; }

    protected CodeBuilder codeBuilder;

    protected MethodAttributeSet methodAttributeSet;

    public boolean has_CodeBuilder() { return (codeBuilder != null); }

    public CodeBuilder code() {

        if (codeBuilder == null){
            codeBuilder = new CodeBuilder();
        }
        return codeBuilder;
    }

    public CodeBuilder code(String str) {
        codeBuilder = new CodeBuilder(str);
        return codeBuilder;
    }
    public CodeBuilder code(StringBuilder strBuilder) {
        codeBuilder = new CodeBuilder(strBuilder);
        return codeBuilder;
    }
    public CodeBuilder code(CodeBuilder newCodeBuilder) {
        codeBuilder = newCodeBuilder;

        return codeBuilder;
    }


    public String toString_Processor(Object node) {

        String nodeClassName = node.getClass().getSimpleName();
        String nodeClassNamePrefix = nodeClassName.substring(0, 3);

        if (nodeClassNamePrefix.equals("AMp")) { // a matrix production alternative
            if (node instanceof AttributeNode) {
                AttributeNode attribNode = (AttributeNode)node;

                if (attribNode.has_CodeBuilder())
                    return(attribNode.code().toString());

                else { // there's no code Builder, if in debug, call the toString method
                    if (DEBUG)
                        return (" !:" + attribNode.toString() + ":! ");
                    else
                        return null;
                }

            }
            else
                return null;
            
        } else if (nodeClassNamePrefix.equals("TMp")) { // a matrix token - actually, this one will probably never be called.
            if (node instanceof AttributeNode)
                return node.toString();
            else
                return null;
        } else { // should be just a regular node object
            return node.toString();
        }
    }

    public MethodAttributeSet createMethodAttributes(String setName) {

        methodAttributeSet = new MethodAttributeSet(setName);
        return methodAttributeSet;
    }

    public MethodAttributeSet getMethodAttributes() {

        return methodAttributeSet;
        
    }

    public void setMethodAttributes(MethodAttributeSet methodAttributeSet) {
        this.methodAttributeSet = methodAttributeSet;
    }
    
}
