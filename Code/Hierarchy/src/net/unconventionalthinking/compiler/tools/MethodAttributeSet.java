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
import java.util.*;


/**
 *
 * @author peterjoh
 */
public class MethodAttributeSet {

    public MethodAttributeSet(String methodName, MethodAttributeSet parent_AttributeSet, HierarchyControl hierarchyControl) {
        this(methodName, parent_AttributeSet, hierarchyControl, false, null);
    }

    /**
     * @param methodName
     * @param hierarchyControl
     * @param getExistingOrCreateNew_ReturnValuesMap    if you set this to true, instead of creating a new returnValues map for
     *                                                  the method, you'll get an existing one if it exists, and only create one if it doesn't.
     */
    public MethodAttributeSet(String methodName, MethodAttributeSet parent_AttributeSet, HierarchyControl hierarchyControl,
            boolean getExistingOrCreateNew_ReturnValuesMap) {
        this(methodName, parent_AttributeSet, hierarchyControl, getExistingOrCreateNew_ReturnValuesMap, null);
    }
    /**
     * @param methodName
     * @param hierarchyControl
     * @param getExistingOrCreateNew_ReturnValuesMap    if you set this to true, instead of creating a new returnValues map for
     *                                                  the method, you'll get an existing one if it exists, and only create one if it doesn't.
     * @param parameterValues
     */
    public MethodAttributeSet(String methodName, MethodAttributeSet parent_AttributeSet, HierarchyControl hierarchyControl,
            boolean getExistingOrCreateNew_ReturnValuesMap, Map<String, Object> parameterValues) {

        this.methodName = methodName;
        this.parent = parent_AttributeSet;
        
        if (parameterValues != null)
            this.params = parameterValues;
        else
            this.params = new HashMap<String, Object>();

        this.vars = new HashMap<String, Object>();

        this.codeBuilder = new CodeBuilder();
        this.codeBuilders_Map = new HashMap<String, CodeBuilder>();


        if (getExistingOrCreateNew_ReturnValuesMap)
            this.returnValues = hierarchyControl.returnValues_getExistingOrCreateNewMap_for(methodName);
        else
            this.returnValues = hierarchyControl.returnValues_CreateNewMap_for(methodName);

        this.methodCallValues = new HashMap<String, Map<String, Object>>();
    }


    public void new_CodeBuilder(String codeBuilderName) {
        codeBuilders_Map.put(codeBuilderName, new CodeBuilder());
    }

    

    public boolean methodCall_HasValues(String methodName) {
        Map<String, Object> methodParams = methodCallValues.get(methodName);

        return (methodParams != null && !methodParams.isEmpty());
    }
    public void methodCall_AddValue(String methodName, String paramName, Object value) {
        Map<String, Object> methodCallValues_Found = methodCallValues.get(methodName);
        if (methodCallValues_Found == null) {
            methodCallValues_Found = new HashMap<String, Object>();
            methodCallValues.put(methodName, methodCallValues_Found);
        }
        methodCallValues_Found.put(paramName, value);
    }


    public Map<String, Object> methodCall_GetValueSet(String methodName) {
        return methodCallValues.get(methodName);

    }
    public Object methodCall_GetValue(String methodName, String paramName) {
        return methodCallValues.get(methodName).get(paramName);
    }

    public void methodCall_ClearValues(String methodName) {
        methodCallValues.put(methodName, null);
    }
    public void methodCall_ClearAllValues() {
        methodCallValues.clear();
    }


    
    public final String                         methodName;
    public final MethodAttributeSet             parent;


    public final Map<String, Object>            params;
    public final Map<String, Object>            vars;

    public CodeBuilder                          codeBuilder;
    /**
     * Use the CodeBuilder Map if you want to have multiple code builders for the attribute set. otherwise, just use the main codebuilder.
     */
    public final Map<String, CodeBuilder>       codeBuilders_Map;

    public Map<String, Object>                  returnValues;


    /**
     * use Method Call values to pass the parameter values for a method call by this current method. The called method will automatically
     * pickup the method call values, and set it to its 'params'
     */
    private Map<String, Map<String, Object>>    methodCallValues;
}
