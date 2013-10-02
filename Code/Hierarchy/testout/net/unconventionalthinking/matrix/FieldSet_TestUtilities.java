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

package net.unconventionalthinking.matrix;

import net.unconventionalthinking.matrix.*;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.lang.Boolean_Mutable;

import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.reflection.MethodInvoker;
import java.lang.reflect.Method;
import static org.junit.Assert.*;



/**
 *
 * @author peterjoh
 */
public class FieldSet_TestUtilities {

    public enum GetAndSetMethod_Parameters { IncludeIndex, IncludeFieldName, None };



    //  ________________________________________________________________________________________________________________
    //
    //    Set And Get Method, test methods
    //  ________________________________________________________________________________________________________________


    /**
     * For these get and set methods:
     *
     *   <Field type> get_<Field Name>()
     *   set_<Field Name>(<Field Type> value)
     *   set_<Field Name>__Special(special value)
     */
    public static void test_SetAndGetFieldName(ExecutionInfo executeInfo, FieldSet fieldSet, Class fieldSet_Type,
            String setMethodString, Class setMethod_ValueType, String setSpecialMethodString, String getMethodString,
            Object expectedValue, Object nullSpecial_ExpectedValue, Object unusedSpecial_ExpectedValue, Object defaultSpecial_ExpectedValue)
            throws Exception {

        Object resultObj;
        Boolean_Mutable methodThrewException = new Boolean_Mutable(false);
 
		methodThrewException.value = false;
        resultObj = create_SetMethod(setMethod_ValueType, executeInfo, expectedValue)
                .invokeMethod(fieldSet, fieldSet_Type, setMethodString, methodThrewException);
		process_MethodThrewException(resultObj, methodThrewException);
        resultObj = create_GetMethod(executeInfo).invokeMethod(fieldSet, fieldSet_Type, getMethodString, methodThrewException);
		process_MethodThrewException(resultObj, methodThrewException);
        assertEquals(expectedValue, resultObj);
        assertTrue(executeInfo.nothingToReport());

        //  Test special set methods
		resultObj = create_SetMethod(FieldConstants.class, executeInfo, FieldConstants.NULL)
                .invokeMethod(fieldSet, fieldSet_Type, setSpecialMethodString, methodThrewException);
		process_MethodThrewException(resultObj, methodThrewException);
        resultObj = create_GetMethod(executeInfo).invokeMethod(fieldSet, fieldSet_Type, getMethodString, methodThrewException);
		process_MethodThrewException(resultObj, methodThrewException);
        assertEquals(nullSpecial_ExpectedValue, resultObj);
        assertTrue(executeInfo.containsResult(ExecutionInfo.ResultType.FieldValue_NULL));

        resultObj = create_SetMethod(FieldConstants.class, executeInfo, FieldConstants.UNUSED)
                .invokeMethod(fieldSet, fieldSet_Type, setSpecialMethodString, methodThrewException);
		process_MethodThrewException(resultObj, methodThrewException);
        resultObj = create_GetMethod(executeInfo).invokeMethod(fieldSet, fieldSet_Type, getMethodString, methodThrewException);
		process_MethodThrewException(resultObj, methodThrewException);
        assertEquals(unusedSpecial_ExpectedValue, resultObj);
        assertTrue(executeInfo.containsResult(ExecutionInfo.ResultType.FieldValue_UNUSED));

        resultObj = create_SetMethod(FieldConstants.class, executeInfo, FieldConstants.DEFAULT)
                .invokeMethod(fieldSet, fieldSet_Type, setSpecialMethodString, methodThrewException);
		process_MethodThrewException(resultObj, methodThrewException);
        resultObj = create_GetMethod(executeInfo).invokeMethod(fieldSet, fieldSet_Type, getMethodString, methodThrewException);
		process_MethodThrewException(resultObj, methodThrewException);
        assertEquals(defaultSpecial_ExpectedValue, resultObj);
        assertTrue(executeInfo.containsResult(ExecutionInfo.ResultType.FieldValue_DEFAULT));

    }


    /**
     * Can be of the form:
     *   get<*>(int index)
     *   set<*>(int index, <some type> value)
     *
     * So, this method used to call these get and set methods:
     *
     *   Object getField(int index)
     *   setField(int index, Object value)
     *   setField_Special(int index, specialValue)
     *
     *   <Field Type> getField_<Field Type>(int index)
     *   setField_<Field Type>(int index, <Field Type> value)
     */
    public static void test_SetAndGet_useIndex(ExecutionInfo executeInfo, FieldSet fieldSet, Class fieldSet_Type,
            String setMethodString, Class setMethod_ValueType, String setSpecialMethodString, String getMethodString, int index,
            Object expectedValue, Object nullSpecial_ExpectedValue, Object unusedSpecial_ExpectedValue, Object defaultSpecial_ExpectedValue)
            throws Exception {

        Object resultObj;
        Boolean_Mutable methodThrewException = new Boolean_Mutable(false);


        resultObj = create_SetMethod(setMethod_ValueType, executeInfo, expectedValue, GetAndSetMethod_Parameters.IncludeIndex, index, null)
                .invokeMethod(fieldSet, fieldSet_Type, setMethodString, methodThrewException);
		process_MethodThrewException(resultObj, methodThrewException);
        resultObj = create_GetMethod(executeInfo, GetAndSetMethod_Parameters.IncludeIndex, index, null)
                .invokeMethod(fieldSet, fieldSet_Type, getMethodString, methodThrewException);
		process_MethodThrewException(resultObj, methodThrewException);
        assertEquals(expectedValue, resultObj);
        assertTrue(executeInfo.nothingToReport());

        //  Test special set methods
        resultObj = create_SetMethod(FieldConstants.class, executeInfo, FieldConstants.NULL, GetAndSetMethod_Parameters.IncludeIndex, index, null)
                .invokeMethod(fieldSet, fieldSet_Type, setSpecialMethodString, methodThrewException);
		process_MethodThrewException(resultObj, methodThrewException);
        resultObj = create_GetMethod(executeInfo, GetAndSetMethod_Parameters.IncludeIndex, index, null)
                .invokeMethod(fieldSet, fieldSet_Type, getMethodString, methodThrewException);
		process_MethodThrewException(resultObj, methodThrewException);
        assertEquals(nullSpecial_ExpectedValue, resultObj);
        assertTrue(executeInfo.containsResult(ExecutionInfo.ResultType.FieldValue_NULL));

        resultObj = create_SetMethod(FieldConstants.class, executeInfo, FieldConstants.UNUSED, GetAndSetMethod_Parameters.IncludeIndex, index, null)
                .invokeMethod(fieldSet, fieldSet_Type, setSpecialMethodString, methodThrewException);
		process_MethodThrewException(resultObj, methodThrewException);
        resultObj = create_GetMethod(executeInfo, GetAndSetMethod_Parameters.IncludeIndex, index, null)
                .invokeMethod(fieldSet, fieldSet_Type, getMethodString, methodThrewException);
		process_MethodThrewException(resultObj, methodThrewException);
        assertEquals(unusedSpecial_ExpectedValue, resultObj);
        assertTrue(executeInfo.containsResult(ExecutionInfo.ResultType.FieldValue_UNUSED));


        resultObj = create_SetMethod(FieldConstants.class, executeInfo, FieldConstants.DEFAULT, GetAndSetMethod_Parameters.IncludeIndex, index, null)
                .invokeMethod(fieldSet, fieldSet_Type, setSpecialMethodString, methodThrewException);
		process_MethodThrewException(resultObj, methodThrewException);
        resultObj = create_GetMethod(executeInfo, GetAndSetMethod_Parameters.IncludeIndex, index, null)
                .invokeMethod(fieldSet, fieldSet_Type, getMethodString, methodThrewException);
		process_MethodThrewException(resultObj, methodThrewException);
        assertEquals(defaultSpecial_ExpectedValue, resultObj);
        assertTrue(executeInfo.containsResult(ExecutionInfo.ResultType.FieldValue_DEFAULT));

    }


    public static Exception test_SetAndGet_useFieldName(ExecutionInfo executeInfo, FieldSet fieldSet, Class fieldSet_Type,
            String setMethodString, Class setMethod_ValueType, String setSpecialMethodString, String getMethodString, String fieldNameString, SymbolControl symbolControl,
            Object expectedValue, Object nullSpecial_ExpectedValue, Object unusedSpecial_ExpectedValue, Object defaultSpecial_ExpectedValue)
            throws Exception {

		return test_SetAndGet_useFieldName(executeInfo, fieldSet, fieldSet_Type, setMethodString, setMethod_ValueType,
			setSpecialMethodString, getMethodString, fieldNameString, symbolControl, expectedValue,
			nullSpecial_ExpectedValue, unusedSpecial_ExpectedValue, defaultSpecial_ExpectedValue, false);
	}
    /**
     * Can be of the form:
     *   get<*>(int index)
     *   set<*>(int index, <some type> value)
     *
     * So, this method used to call these get and set methods:
     *
     *   getField(FieldName)
     *   <Type> getField_<Type>(FieldName)
     *
     *   setField(FieldName, Object value)
     *   setField_<Type>(FieldName, <Type> value)
     *   setField_Special(FieldName, specialValue)
     */
    public static Exception test_SetAndGet_useFieldName(ExecutionInfo executeInfo, FieldSet fieldSet, Class fieldSet_Type,
            String setMethodString, Class setMethod_ValueType, String setSpecialMethodString, String getMethodString, String fieldNameString, SymbolControl symbolControl,
            Object expectedValue, Object nullSpecial_ExpectedValue, Object unusedSpecial_ExpectedValue, Object defaultSpecial_ExpectedValue, boolean returnExceptions)
            throws Exception {

        Object resultObj;
        Boolean_Mutable methodThrewException = new Boolean_Mutable(false);

        DescriptorTagName fieldName = symbolControl.singleSymbol_Factory.createNew_DescTagName(fieldNameString, true);

		try {
			resultObj = create_SetMethod(setMethod_ValueType, executeInfo, expectedValue, GetAndSetMethod_Parameters.IncludeFieldName, -1, fieldName)
					.invokeMethod(fieldSet, fieldSet_Type, setMethodString, methodThrewException);
			process_MethodThrewException(resultObj, methodThrewException);
			resultObj = create_GetMethod(executeInfo, GetAndSetMethod_Parameters.IncludeFieldName, -1, fieldName)
					.invokeMethod(fieldSet, fieldSet_Type, getMethodString, methodThrewException);
			process_MethodThrewException(resultObj, methodThrewException);
			assertEquals(expectedValue, resultObj);
			assertTrue(executeInfo.nothingToReport());

			//  Test special set methods
			resultObj = create_SetMethod(FieldConstants.class, executeInfo, FieldConstants.NULL, GetAndSetMethod_Parameters.IncludeFieldName, -1, fieldName)
					.invokeMethod(fieldSet, fieldSet_Type, setSpecialMethodString, methodThrewException);
			process_MethodThrewException(resultObj, methodThrewException);
			resultObj = create_GetMethod(executeInfo, GetAndSetMethod_Parameters.IncludeFieldName, -1, fieldName)
					.invokeMethod(fieldSet, fieldSet_Type, getMethodString, methodThrewException);
			process_MethodThrewException(resultObj, methodThrewException);
			assertEquals(nullSpecial_ExpectedValue, resultObj);
			assertTrue(executeInfo.containsResult(ExecutionInfo.ResultType.FieldValue_NULL));
	
			resultObj = create_SetMethod(FieldConstants.class, executeInfo, FieldConstants.UNUSED, GetAndSetMethod_Parameters.IncludeFieldName, -1, fieldName)
					.invokeMethod(fieldSet, fieldSet_Type, setSpecialMethodString, methodThrewException);
			process_MethodThrewException(resultObj, methodThrewException);
			resultObj = create_GetMethod(executeInfo, GetAndSetMethod_Parameters.IncludeFieldName, -1, fieldName)
					.invokeMethod(fieldSet, fieldSet_Type, getMethodString, methodThrewException);
			process_MethodThrewException(resultObj, methodThrewException);
			assertEquals(unusedSpecial_ExpectedValue, resultObj);
			assertTrue(executeInfo.containsResult(ExecutionInfo.ResultType.FieldValue_UNUSED));
	
	
			resultObj = create_SetMethod(FieldConstants.class, executeInfo, FieldConstants.DEFAULT, GetAndSetMethod_Parameters.IncludeFieldName, -1, fieldName)
					.invokeMethod(fieldSet, fieldSet_Type, setSpecialMethodString, methodThrewException);
			process_MethodThrewException(resultObj, methodThrewException);
			resultObj = create_GetMethod(executeInfo, GetAndSetMethod_Parameters.IncludeFieldName, -1, fieldName)
					.invokeMethod(fieldSet, fieldSet_Type, getMethodString, methodThrewException);
			process_MethodThrewException(resultObj, methodThrewException);
			assertEquals(defaultSpecial_ExpectedValue, resultObj);
			assertTrue(executeInfo.containsResult(ExecutionInfo.ResultType.FieldValue_DEFAULT));
		
		} catch (Exception e) {
			if (returnExceptions) {
				System.out.printf("returning an exception from  test_SetAndGet_useFieldName() returned an error of this type: %s, with this msg: %s\n", e.getClass().toString(), e.getMessage());
				return e;
			} else {
				System.out.printf("EXCEPTION: test_SetAndGet_useFieldName() returned an error of this type: %s, with this msg: %s\n", e.getClass().toString(), e.getMessage());
				throw e;
			}
		}
		
		return null;

    }





    //  ________________________________________________________________________________________________________________
    //
    //    Set And Get Method, Dynamic Method invokers
    //  ________________________________________________________________________________________________________________

    /**
     * Creates a call to a setFieldName with a passed in type. Used for these set methods
     *
     * set_<Field Name>(<Type> value)
     * setField(Object value);
     */
    public static MethodInvoker create_SetMethod(Class setMethod_ValueType, ExecutionInfo executeInfo, Object value) {
        return create_SetMethod(setMethod_ValueType, executeInfo, value, GetAndSetMethod_Parameters.None, -1, null);
    }
    /**
     * Creates a call to a setFieldName with a passed in type. Used with these methods
     *
     * GetAndSetMethod_Parameters.None:
     *   set_<Field Name>(<Type> value)
     *
     * GetAndSetMethod_Parameters.IncludeIndex:
     *   setField(int index, Object value)
     *   set_<Field Name>(int continuationIndex, <Type> value)
     *   setField_Special(int index, specialValue)
     *
     * GetAndSetMethod_Parameters.IncludeFieldName:
     *   setField(FieldName, Object value)
     *   setField_<Type>(FieldName, <Type> value)
     *   setField_Special(FieldName, specialValue)
     */
    public static MethodInvoker create_SetMethod(Class setMethod_ValueType, ExecutionInfo executeInfo, Object value, 
            GetAndSetMethod_Parameters setMethod_Parameters, int index, DescriptorTagName fieldName) {


        //  test set and get
        MethodInvoker setMethod = new MethodInvoker();

        Class[] paramTypes;
        Class[] paramTypesNoIndex = {ExecutionInfo.class, setMethod_ValueType };
        Class[] paramTypesWithIndex = {ExecutionInfo.class, Integer.TYPE, setMethod_ValueType };
        Class[] paramTypesWithFieldName = {ExecutionInfo.class, DescriptorTagName.class, setMethod_ValueType };

        
        if (setMethod_Parameters == GetAndSetMethod_Parameters.IncludeIndex) {
            paramTypes = paramTypesWithIndex;
            setMethod.setParameterTypes(paramTypes);
            setMethod.setParameterValues(executeInfo, index, value);

        } else if (setMethod_Parameters == GetAndSetMethod_Parameters.IncludeFieldName) {
            paramTypes = paramTypesWithFieldName;
            setMethod.setParameterTypes(paramTypes);
            setMethod.setParameterValues(executeInfo, fieldName, value);

        } else {
            paramTypes = paramTypesNoIndex;
            setMethod.setParameterTypes(paramTypes);
            setMethod.setParameterValues(executeInfo, value);

        }

        return setMethod;
    }



    /**
     * Creates a call to a get Method with no parameters (excpetion execution info). Used for these methods:
     *
     * General method signature: get<*>()
     *
     * Specific methods
     *   getField()
     *   get_<Field Name>()
     */
    public static MethodInvoker create_GetMethod(ExecutionInfo executeInfo) {
        return create_GetMethod(executeInfo, GetAndSetMethod_Parameters.None, -1, null);
    }
    /**
     * Creates a call to a get method with an index:
     *
     * GetAndSetMethod_Parameters.None: get<*>():
     *   getField()
     *   get_<Field Name>()
     *   <Type> getField_<Type>();
     *
     * GetAndSetMethod_Parameters.IncludeIndex:  get<*>(int Index):
     *   getField(int index)
     *   get_<Continunation Field>(int continuationIndex)
     *
     * GetAndSetMethod_Parameters.IncludeFieldName: get<*>(FieldName):
     *   getField(FieldName)
     *   <Type> getField_<Type>(FieldName)
     */
    public static MethodInvoker create_GetMethod(ExecutionInfo executeInfo, GetAndSetMethod_Parameters getMethodParameters,
            int index, DescriptorTagName fieldName) {

        //  test set and get
        MethodInvoker getMethod = new MethodInvoker();

        Class[] paramTypes;
        if (getMethodParameters == GetAndSetMethod_Parameters.IncludeIndex) {
            paramTypes = getMethod_ParamTypesWithIndex;
            getMethod.setParameterTypes(paramTypes);
            getMethod.setParameterValues(executeInfo, index);

        } else if (getMethodParameters == GetAndSetMethod_Parameters.IncludeFieldName) {
            paramTypes = getMethod_ParamTypesWithFieldName;
            getMethod.setParameterTypes(paramTypes);
            getMethod.setParameterValues(executeInfo, fieldName);

        } else {
            paramTypes = getMethod_ParamTypesNoIndex;
            getMethod.setParameterTypes(paramTypes);
            getMethod.setParameterValues(executeInfo);
        }

        return getMethod;
    }



	private static void process_MethodThrewException(Object resultObj, Boolean_Mutable methodThrewException) 
			throws Exception{
	
		if (methodThrewException.value == true)
			throw (Exception)resultObj; // resultObj from methodInvoker will be the exception if methodThrewException is true;
		else
			methodThrewException.value = false;
	
	}



    private static Class[] getMethod_ParamTypesNoIndex = {ExecutionInfo.class, };
    private static Class[] getMethod_ParamTypesWithIndex = {ExecutionInfo.class, Integer.TYPE };
    private static Class[] getMethod_ParamTypesWithFieldName = {ExecutionInfo.class, DescriptorTagName.class };


}
