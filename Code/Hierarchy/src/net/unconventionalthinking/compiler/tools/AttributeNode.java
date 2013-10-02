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

import net.unconventionalthinking.hierarchy.HierarchyControl;
import net.unconventionalthinking.hierarchy.grammar.node.Node;

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



    protected CodeBuilder codeBuilder;

    protected MethodAttributeSet methodAttributeSet;

    protected static AttributeNode_ToStringProcessor default_ToStringProcessor;
    protected AttributeNode_ToStringProcessor        toStringProcessor;




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

    /**
     * The problem with the toString() method is that it doesn't call the toString_Processor on THIS node, only on the children. If you
     * want to make sure that the processor starts with this node, use this method (for instance, if there is code builder on this node
     * that should be used when creating the string).
     * @return
     */
    public String toString_ProcessCurrent() {

        if (toStringProcessor != null)
            return toStringProcessor.process_ToString(this);
        else if (default_ToStringProcessor != null)
            return default_ToStringProcessor.process_ToString(this);
        else
            return this.toString();

    }

    public String toString_Processor(Object node) {

        if (toStringProcessor != null)
            return toStringProcessor.process_ToString(node);
        else if (default_ToStringProcessor != null)
            return default_ToStringProcessor.process_ToString(node);
        else
            return node.toString();

    }

    public MethodAttributeSet createMethodAttributes(String methodName, Node node, HierarchyControl hierarchyControl) {
        return createMethodAttributes(methodName, node, hierarchyControl, false);
    }
    
    
    /**
     * @param methodName
     * @param node
     * @param hierarchyControl
     * @param getExistingOrCreateNew_ReturnValuesMap    if you set this to true, instead of creating a new returnValues map for
     *                                                  the method, you'll get an existing one if it exists, and only create one if it doesn't.
     *                                                  Usually, you want to use set to true for things like recursive calls, where you don't want
     *                                                  destroy the existing retValues Map with each new call
     * @return
     */
    public MethodAttributeSet createMethodAttributes(String methodName, Node node, HierarchyControl hierarchyControl,
            boolean getExistingOrCreateNew_ReturnValuesMap) {

        MethodAttributeSet parent_MethodAttributes = node.parent().getMethodAttributes();

        // get method parameter values if there are any
        if (node.parent() != null && node.parent().getMethodAttributes() != null &&
                node.parent().getMethodAttributes().methodCall_HasValues(methodName)) {
            
            methodAttributeSet = new MethodAttributeSet(methodName, parent_MethodAttributes, hierarchyControl,
                    getExistingOrCreateNew_ReturnValuesMap, node.parent().getMethodAttributes().methodCall_GetValueSet(methodName));
        } else
            methodAttributeSet = new MethodAttributeSet(methodName, parent_MethodAttributes, hierarchyControl, getExistingOrCreateNew_ReturnValuesMap);

        return methodAttributeSet;
    }

    public MethodAttributeSet getMethodAttributes() { return methodAttributeSet; }

    public void setMethodAttributes(MethodAttributeSet methodAttributeSet) { this.methodAttributeSet = methodAttributeSet; }




    public static void set_Default_ToStringProcessor(AttributeNode_ToStringProcessor toStringProcessor) {
        default_ToStringProcessor = toStringProcessor;
    }
    public void set_ToStringProcessor(AttributeNode_ToStringProcessor toStringProcessor) {
        this.toStringProcessor = toStringProcessor;
    }

    
}
