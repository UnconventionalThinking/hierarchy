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

package net.unconventionalthinking.reflection;

import net.unconventionalthinking.lang.Boolean_Mutable;
import net.unconventionalthinking.hierarchy.Exception_HierarchyCompiler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author peterjoh
 */
public class MethodInvoker {



    /**
     * A convenience method for dynamically calling methods.
     * This version is a call on a method with no parameters.
     *
     * @param targetObject          For static method calls, pass null as target object.
     * @param targetClass
     * @param methodName
     * @param methodThrewException
     * @return
     * @throws Exception
     */
    public static Object invokeMethod_Helper(Object targetObject, Class targetClass, String methodName, Boolean_Mutable methodThrewException)
            throws Exception {
        return invokeMethod_Helper(targetObject, targetClass, methodName, methodThrewException, new Class[] {}, new Object[] {});
    }

    /**
     * A convenience method for dynamically calling methods.
     *
     * @param targetObject          For static method calls, pass null as target object.
     * @param targetClass
     * @param methodName
     * @param methodThrewException
     * @param parameterTypes
     * @param parameterValues
     * @return
     * @throws Exception
     */
    public static Object invokeMethod_Helper(Object targetObject, Class targetClass, String methodName, Boolean_Mutable methodThrewException,
            Class[] parameterTypes, Object[] parameterValues) throws Exception {

        MethodInvoker methodInvoker = new MethodInvoker();

        methodInvoker.setParameterTypes(parameterTypes);
        methodInvoker.setParameterValuesArray(parameterValues);

        return methodInvoker.invokeMethod(targetObject, targetClass, methodName, methodThrewException);

    }


    
    private Class[] parameterTypes;
    private Object[] parameterValues;

    private boolean alreadyHave_ParameterTypes = false;



    public MethodInvoker setParameterTypes(Class... parameterTypes) {
        this.parameterTypes = parameterTypes;
        alreadyHave_ParameterTypes = true;

        return this;
    }
    public MethodInvoker setParameterValues(Object... parameterValues) {
        this.parameterValues = parameterValues;

        return this;
    }
    public MethodInvoker setParameterValuesArray(Object[] parameterValues) {
        this.parameterValues = parameterValues;

        return this;
    }

    /**
     * For static method invocation, pass null as target object.
     * 
     * @param targetObject          For static method calls, pass null as target object.
     * @param targetObjectClass
     * @param fieldMethodString
     * @param methodThrewException
     * @return
     * @throws Exception_HierarchyCompiler
     * @throws InvocationTargetException
     * @throws Exception
     */
    public Object invokeMethod(Object targetObject, Class targetObjectClass, String fieldMethodString, Boolean_Mutable methodThrewException)
            throws Exception_HierarchyCompiler, InvocationTargetException, Exception {


        if (!alreadyHave_ParameterTypes) {
            parameterTypes = new Class[parameterValues.length];

            int i = 0;
            for (Object param : parameterValues) {
                parameterTypes[i] = param.getClass();
                ++i;
            }

        }
        Method fieldMethod = targetObjectClass.getMethod(fieldMethodString, parameterTypes);
        Object retValObj = null;
        try {
            retValObj = fieldMethod.invoke(targetObject, parameterValues);
        } catch(InvocationTargetException e) {
            System.out.println("Invoked Method threw an exception");
            if (methodThrewException != null)
                methodThrewException.value = true;

            if (e.getTargetException() != null) {
                retValObj = e.getTargetException();
                // This exception is not being thrown. why?
                throw new Exception_HierarchyCompiler("Exception thrown in an invoked method", e.getTargetException());
            } else {
                retValObj = e.getTargetException();
                throw e;
            }
        }

        return retValObj;

    }
}
