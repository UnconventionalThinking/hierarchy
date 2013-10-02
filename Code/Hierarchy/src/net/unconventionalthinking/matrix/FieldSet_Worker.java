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

package net.unconventionalthinking.matrix;

import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Symbol;
import java.util.List;
import java.util.Map;

/**
 *
 * @author peterjoh
 */
public class FieldSet_Worker {

    /*
     * The following methods are used in high performance situations. they should be static, so they can be inlined, and kept as small as possible
     *
     * This is also why the two setField methods have a lot of redundant code. We could just have the second setField method call the first, but
     * to insure inlining, I don't want to even have a return type (and, maybe having a inlined method with a return type creates a small amount
     * of additional overhead vs. ones that don't).
     */


    public static Object getField_ProcessFieldValueBucket(ExecutionInfo executeInfo, FieldSet_FieldValueBucket fieldValueBucket,
            SchemaInfo_FieldSet schemaInfo_Positioned, int fieldIndex) throws Exception_InvalidArgumentPassed {

        if (fieldValueBucket != null) {

            FieldConstants fieldValue_Special = fieldValueBucket.specialValue;
            if (fieldValue_Special == FieldConstants.HAS_STANDARD_VALUE) {
                executeInfo.clearResultsInfo();
                return (fieldValueBucket != null) ? fieldValueBucket.value : null;

            } else if (fieldValue_Special == FieldConstants.UNUSED) {
                executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
                return null;

            } else if (fieldValue_Special == FieldConstants.NULL) {
                executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
                return null;
            }
        }

        // either no value in fieldset OR, the fieldValue Special was set to default. Either way, return default value if there is one
        Object fieldDefaultValue_Raw;
        fieldDefaultValue_Raw = schemaInfo_Positioned.get_SchemaInfoField(executeInfo, fieldIndex).fieldDefault;

        if (fieldDefaultValue_Raw != null) {
            executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_DEFAULT);
            return fieldDefaultValue_Raw;
        } else {
            executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.Result_Empty);
            return null;
        }
    }




    public static Object getField_ProcessFieldValueBucket(ExecutionInfo executeInfo, FieldSet_FieldValueBucket fieldValueBucket,
            SchemaInfo_FieldSet schemaInfo_Positioned, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed {

        if (fieldValueBucket != null) {

            FieldConstants fieldValue_Special = fieldValueBucket.specialValue;
            if (fieldValue_Special == FieldConstants.HAS_STANDARD_VALUE) {
                executeInfo.clearResultsInfo();
                return (fieldValueBucket != null) ? fieldValueBucket.value : null;

            } else if (fieldValue_Special == FieldConstants.UNUSED) {
                executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
                return null;

            } else if (fieldValue_Special == FieldConstants.NULL) {
                executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
                return null;
            }
        }

        // either no value in fieldset OR, the fieldValue Special was set to default. Either way, return default value if there is one
        Object fieldDefaultValue_Raw = schemaInfo_Positioned.get_SchemaInfoField(executeInfo, fieldName).fieldDefault;

        if (fieldDefaultValue_Raw != null) {
            executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_DEFAULT);
            return fieldDefaultValue_Raw;
        } else {
            executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.Result_Empty);
            return null;
        }
    }


    public static Object getField_DefaultValue(ExecutionInfo executeInfo, int index, SchemaInfo_FieldSet schemaInfo_FieldSet)
        throws Exception_InvalidArgumentPassed {

        // either no value in fieldset OR, the fieldValue Special was set to default. Either way, return default value if there is one
        Object fieldDefaultValue_Raw = schemaInfo_FieldSet.get_SchemaInfoField(executeInfo, index).fieldDefault;

        if (fieldDefaultValue_Raw != null) {
            executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_DEFAULT);
            return fieldDefaultValue_Raw;
        } else {
            executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.Result_Empty);
            return null;
        }
    }
    public static Object getField_DefaultValue(ExecutionInfo executeInfo, DescriptorTagName fieldName, SchemaInfo_FieldSet schemaInfo_FieldSet) {

        // either no value in fieldset OR, the fieldValue Special was set to default. Either way, return default value if there is one
        Object fieldDefaultValue_Raw = schemaInfo_FieldSet.get_SchemaInfoField(executeInfo, fieldName).fieldDefault;

        if (fieldDefaultValue_Raw != null) {
            executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_DEFAULT);
            return fieldDefaultValue_Raw;
        } else {
            executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.Result_Empty);
            return null;
        }
    }








    public static void setField_AddNewValue_to_EndOfList(Object value, List<FieldSet_FieldValueBucket> fieldList, FieldSet fieldSet) {

        FieldSet_FieldValueBucket fieldValueBucket = new FieldSet_FieldValueBucket();
        fieldValueBucket.value = value;
        fieldValueBucket.specialValue = FieldConstants.HAS_STANDARD_VALUE;
        fieldList.add(fieldValueBucket);

        ++fieldSet.fieldValue_TotalCount;
    }
    public static void setField_AddNewValue_to_EndOfList(Object value, List<FieldSet_FieldValueBucket> fieldList, FieldSet fieldSet,
            Map<DescriptorTagName, FieldSet_FieldValueBucket> fieldIndex, DescriptorTagName fieldName) {

        FieldSet_FieldValueBucket fieldValueBucket = new FieldSet_FieldValueBucket();
        fieldValueBucket.value = value;
        fieldValueBucket.specialValue = FieldConstants.HAS_STANDARD_VALUE;
        fieldList.add(fieldValueBucket);

        ++fieldSet.fieldValue_TotalCount;


        fieldIndex.put(fieldName, fieldValueBucket);
    }


    public static void setFieldSpecial_AddNewValue_to_EndOfList(FieldConstants specialValue, List<FieldSet_FieldValueBucket> fieldList, FieldSet fieldSet) {

        FieldSet_FieldValueBucket fieldValueBucket = new FieldSet_FieldValueBucket();
        fieldValueBucket.value = null;
        fieldValueBucket.specialValue = specialValue;
        fieldList.add(fieldValueBucket);

        ++fieldSet.fieldValue_TotalCount;
    }
    public static void setFieldSpecial_AddNewValue_to_EndOfList(FieldConstants specialValue, List<FieldSet_FieldValueBucket> fieldList, FieldSet fieldSet,
            Map<DescriptorTagName, FieldSet_FieldValueBucket> fieldIndex, DescriptorTagName fieldName) {

        FieldSet_FieldValueBucket fieldValueBucket = new FieldSet_FieldValueBucket();
        fieldValueBucket.value = null;
        fieldValueBucket.specialValue = specialValue;
        fieldList.add(fieldValueBucket);

        ++fieldSet.fieldValue_TotalCount;


        fieldIndex.put(fieldName, fieldValueBucket);
    }






    public static void setField_ReplaceExistingValue_in_List(Object value, int index, List<FieldSet_FieldValueBucket> fieldList, FieldSet fieldSet) {

        FieldSet_FieldValueBucket fieldValueBucket = fieldList.get(index);
        if (fieldValueBucket == null) {
            fieldValueBucket = new FieldSet_FieldValueBucket();

            fieldList.set(index, fieldValueBucket);

            ++fieldSet.fieldValue_TotalCount;
        }

        fieldValueBucket.value = value;
        if (value != null)
            fieldValueBucket.specialValue = FieldConstants.HAS_STANDARD_VALUE;
        else {
            // setting null - but, so you can tell that the field actually has a value,
            // put the FieldConstant.NULL object instead!
            fieldValueBucket.specialValue = FieldConstants.NULL;
        }
    }

    public static void setField_ReplaceExistingValue_in_List(Object value, int index, List<FieldSet_FieldValueBucket> fieldList, FieldSet fieldSet,
            Map<DescriptorTagName, FieldSet_FieldValueBucket> fieldIndex, DescriptorTagName fieldName) {

        FieldSet_FieldValueBucket fieldValueBucket = fieldList.get(index);
        if (fieldValueBucket == null) {
            fieldValueBucket = new FieldSet_FieldValueBucket();

            fieldList.set(index, fieldValueBucket);
            fieldIndex.put(fieldName, fieldValueBucket);

            ++fieldSet.fieldValue_TotalCount;
        }

        fieldValueBucket.value = value;
        if (value != null)
            fieldValueBucket.specialValue = FieldConstants.HAS_STANDARD_VALUE;
        else {
            // setting null - but, so you can tell that the field actually has a value,
            // put the FieldConstant.NULL object instead!
            fieldValueBucket.specialValue = FieldConstants.NULL;
        }
    }



    public static void setFieldSpecial_ReplaceExistingValue_in_List(FieldConstants specialValue, int index, List<FieldSet_FieldValueBucket> fieldList,
            FieldSet fieldSet) {

        FieldSet_FieldValueBucket fieldValueBucket = fieldList.get(index);
        if (fieldValueBucket == null) {
            fieldValueBucket = new FieldSet_FieldValueBucket();

            fieldList.set(index, fieldValueBucket);

            ++fieldSet.fieldValue_TotalCount;
        }

        fieldValueBucket.value = null;
        fieldValueBucket.specialValue = specialValue;
    }
    public static void setFieldSpecial_ReplaceExistingValue_in_List(FieldConstants specialValue, int index, List<FieldSet_FieldValueBucket> fieldList, FieldSet fieldSet,
            Map<DescriptorTagName, FieldSet_FieldValueBucket> fieldIndex, DescriptorTagName fieldName) {

        FieldSet_FieldValueBucket fieldValueBucket = fieldList.get(index);
        if (fieldValueBucket == null) {
            fieldValueBucket = new FieldSet_FieldValueBucket();

            fieldList.set(index, fieldValueBucket);
            fieldIndex.put(fieldName, fieldValueBucket);

            ++fieldSet.fieldValue_TotalCount;
        }

        fieldValueBucket.value = null;
        fieldValueBucket.specialValue = specialValue;
    }
}
