/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abstractsystems.compiler.tools;

/**
 *
 * @author peterjoh
 *
 * The purpose of this class is to extended by the SableCC nodes so they can have node attributes
 *
 *
 * Put these lines of code in your in Node.java

import com.abstractsystems.compiler.tools.*;
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

    
}
