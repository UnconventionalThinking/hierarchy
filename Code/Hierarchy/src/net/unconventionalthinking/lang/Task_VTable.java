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

package net.unconventionalthinking.lang;

import net.unconventionalthinking.matrix.SchemaInfo;
import net.unconventionalthinking.matrix.SchemaInfo_Descriptor;
import net.unconventionalthinking.matrix.SchemaInfo_Descriptor_Impl;
import net.unconventionalthinking.matrix.SchemaInfo_Field;
import net.unconventionalthinking.matrix.SchemaInfo_FieldSet;
import net.unconventionalthinking.matrix.SchemaInfo_Schema;
import net.unconventionalthinking.matrix.SchemaInfo_Schema_Impl;
import net.unconventionalthinking.matrix.metacompiler.codegen.CodeGeneratorTask_CreateSchemaInfo_AccessCode;
import net.unconventionalthinking.matrix.symbols.Symbol;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author peterjoh
 */
public class Task_VTable {

    public static Map<Class, Map<Class, Method>> vTable_Index_byTaskClass = new HashMap<Class, Map<Class, Method>>();

    
    /**
     * This is just a temporary way of setuping the vTableIndex.
     */
    static {


        // VTable setup for the for the CodeGeneratorTask_CreateSchemaInfo_AccessCode Task
        //
        Map<Class, Method> vTable = new HashMap<Class, Method>();
        vTable_Index_byTaskClass.put(CodeGeneratorTask_CreateSchemaInfo_AccessCode.class, vTable);

        Class[] methodParameters = new Class[] { SchemaInfo.class,  ExecutionInfo.class, String.class, String.class};

        addMethodToVTable(vTable, CodeGeneratorTask_CreateSchemaInfo_AccessCode.class,
                new Class[] { SchemaInfo_Field.class }, "SchemaInfo_Field__GenerateAccessCode", methodParameters);
        addMethodToVTable(vTable, CodeGeneratorTask_CreateSchemaInfo_AccessCode.class, 
                new Class[] { SchemaInfo_FieldSet.class }, "SchemaInfo_FieldSet__GenerateAccessCode", methodParameters);
        addMethodToVTable(vTable, CodeGeneratorTask_CreateSchemaInfo_AccessCode.class,
                new Class[] { SchemaInfo_Descriptor.class, SchemaInfo_Descriptor_Impl.class }, "SchemaInfo_Descriptor__GenerateAccessCode", methodParameters);
        addMethodToVTable(vTable, CodeGeneratorTask_CreateSchemaInfo_AccessCode.class,
                new Class[] { SchemaInfo_Schema.class, SchemaInfo_Schema_Impl.class }, "SchemaInfo_Schema__GenerateAccessCode", methodParameters);
    }
    
    private static void addMethodToVTable(Map<Class, Method> vTable, Class taskClassObj,
            Class[] baseTypesForMethodHierarchy_List, String methodName, Class[] methodParameters) {


        Method taskMethod = null;
        try {
            taskMethod = taskClassObj.getMethod(methodName, methodParameters);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Tried to initialize the VTable for the " + taskClassObj.getSimpleName() +
                    " Task, and add the " + methodName + ", but had a error. Could not find the method.", e);
        }

        for (Class baseTypeForMethodHierarchy: baseTypesForMethodHierarchy_List) {
            vTable.put(baseTypeForMethodHierarchy, taskMethod);

        }
    }

    public static Object selectAndInvokeMethod(Object taskObj, Object... thisObjAndParameters) {

        Class taskClass = taskObj.getClass();
        Object thisObj = thisObjAndParameters[0];
        Map<Class, Method> vTable = vTable_Index_byTaskClass.get(taskClass);

        if (vTable != null) {
            Method method = vTable.get(thisObj.getClass());
            if (method != null) {
                try {
                    return method.invoke(taskObj, thisObjAndParameters);
                } catch (Exception e) {
                    throw new Exception_CouldNotInvokeMethod("Tried to invoke a method for a task, but had an error (see inner exception)", e);
                }
            } else {
                throw new Exception_VTableMethodNotFound("While trying to invoke a method, could not find a method for an object of type, '" + thisObj.getClass().getSimpleName()
                        + "', in the vTable for the class, "+ taskClass.getSimpleName());
            }
        } else {
            throw new Exception_VTableNotFound("While trying to invoke a method, could not find a VTable for the task, " + taskClass.getSimpleName());

        }

    }

}
