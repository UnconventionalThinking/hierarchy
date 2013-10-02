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
import java.util.*;

import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Symbol;

/**
 *
 * @author peterjoh
 */
public class FieldSet_Tuple extends FieldSet {

    List<FieldSet_FieldValueBucket> dynAccessed_FieldSet_List;
    Map<DescriptorTagName, FieldSet_FieldValueBucket> dynAccessed_FieldSet_Index;



    public FieldSet_Tuple(ExecutionInfo executeInfo, Descriptor parentDescriptor) {
        this(executeInfo, parentDescriptor, false);
    }

    /**
     *
     * @param executeInfo
     * @param parentDescriptor
     * @param create_DynAccessed_FieldSets  The reason for this parameter is that Specialized FieldSet_Tuples don't need the dynAccessed_FieldSets
     *                                      to be created, and they pass in true so they are not created. but, for alomst all other situations,
     *                                      you do want these created.
     */
    public FieldSet_Tuple(ExecutionInfo executeInfo, Descriptor parentDescriptor, boolean dont_create_DynAccessed_FieldSets) {

        super(executeInfo, parentDescriptor);

        fieldValue_TotalCount = 0;
        fieldValue_NonContinuationCount = 0;

        if (!dont_create_DynAccessed_FieldSets) {
            dynAccessed_FieldSet_List = new ArrayList<FieldSet_FieldValueBucket>();
            dynAccessed_FieldSet_Index = new HashMap<DescriptorTagName, FieldSet_FieldValueBucket>();
        }

    }



    @Override
    public Object getField(ExecutionInfo executeInfo, DescriptorTagName fieldname) throws Exception_InvalidArgumentPassed {
        executeInfo.reset();
        FieldSet_FieldValueBucket fieldValueBucket = dynAccessed_FieldSet_Index.get(fieldname);

        return FieldSet_Worker.getField_ProcessFieldValueBucket(executeInfo, fieldValueBucket, schemaInfo_Positioned, fieldname);
    }


    @Override
    public Object getField(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed  {
        executeInfo.reset();

        if (index < dynAccessed_FieldSet_List.size()) {

            FieldSet_FieldValueBucket fieldValueBucket = dynAccessed_FieldSet_List.get(index);

            return FieldSet_Worker.getField_ProcessFieldValueBucket(executeInfo, fieldValueBucket, schemaInfo_Positioned, index);

        } else {
            //  no field Value for it, but if there is still a field default, then use it
            if (index < schemaInfo_Positioned.num_NonContinuationFields) {
                return FieldSet_Worker.getField_DefaultValue(executeInfo, index, schemaInfo_Positioned);

            } else if (schemaInfo_Positioned.has_ContinuationField) { // accessing a continuation field with no value. return cont field default
                return FieldSet_Worker.getField_DefaultValue(executeInfo, schemaInfo_Positioned.num_NonContinuationFields, schemaInfo_Positioned);

            } else { // error
                executeInfo.setErrorMessage("Tried to access a FieldSet tuple by field index, but it was out of bounds: " + index);
                throw new Exception_InvalidArgumentPassed(executeInfo.getErrorMessage());
            }
        }

    }




    @Override
    public void setField(ExecutionInfo executeInfo, DescriptorTagName fieldname, Object value, Symbol typeSymbol) throws Exception_InvalidArgumentPassed {
        executeInfo.reset();

        SchemaInfo_Field schemaInfo_Field = schemaInfo_Positioned.get_SchemaInfoField(executeInfo, fieldname);
        if (executeInfo.containsError(ExecutionInfo.ErrorType.FieldName_NotValid))
            return;

        FieldSet.test_FieldValueType(executeInfo, typeSymbol, value, schemaInfo_Field);


        FieldSet_FieldValueBucket fieldValueBucket = dynAccessed_FieldSet_Index.get(fieldname);

        if (fieldValueBucket != null) {
            fieldValueBucket.value = value;
            if (value != null)
                fieldValueBucket.specialValue = FieldConstants.HAS_STANDARD_VALUE;
            else {
                // setting null - but, so you can tell that the field actually has a value,
                // put the FieldConstant.NULL object instead!
                fieldValueBucket.specialValue = FieldConstants.NULL;

            }
            return;

        } else {


            if (!schemaInfo_Field.is_Continuation_Field) {
                if (schemaInfo_Field.fieldIndex == dynAccessed_FieldSet_List.size()) {  // add to end
                    FieldSet_Worker.setField_AddNewValue_to_EndOfList(value, this.dynAccessed_FieldSet_List, this,
                            dynAccessed_FieldSet_Index, schemaInfo_Field.fieldName);
                    ++fieldValue_NonContinuationCount;

                } else {  // replace an existing value

                    FieldSet_Worker.setField_ReplaceExistingValue_in_List(value, schemaInfo_Field.fieldIndex, this.dynAccessed_FieldSet_List, this,
                            dynAccessed_FieldSet_Index, schemaInfo_Field.fieldName);
                }


            } else {
                throw new Exception_InvalidArgumentPassed("Tried setting a field value on a fieldSet tuple's continuation field by fieldname: " +
                        fieldname.getTagName() + ". This is not allowed. Must set continuation fields by index.");
            }
        }
    }


    /**
     * To "add" new field values to a tuple, you must call the SetField() method in sequential order by index!
     * But, you can also replace existing field values with this method (meaning, they must have already been added).
     *
     * @param executeInfo
     * @param index
     * @param value
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed
     */
    @Override
    public void setField(ExecutionInfo executeInfo, int index, Object value, Symbol typeSymbol) throws Exception_InvalidArgumentPassed {
        executeInfo.reset();

        //  The get_SchemaInfoField should throw any errors dealing with an out of bound index.

        SchemaInfo_Field schemaInfo_Field = schemaInfo_Positioned.get_SchemaInfoField(executeInfo, index);

        test_FieldValueType(executeInfo, typeSymbol, value, schemaInfo_Field);


        if (!schemaInfo_Field.is_Continuation_Field) {

            if (index == dynAccessed_FieldSet_List.size()) {  // add to end

                FieldSet_Worker.setField_AddNewValue_to_EndOfList(value, this.dynAccessed_FieldSet_List, this,
                        dynAccessed_FieldSet_Index, schemaInfo_Field.fieldName);
                ++fieldValue_NonContinuationCount;

            } else {  // replace an existing value
                FieldSet_Worker.setField_ReplaceExistingValue_in_List(value, index, this.dynAccessed_FieldSet_List, this,
                        dynAccessed_FieldSet_Index, schemaInfo_Field.fieldName);
            }



        } else { // set the value at the correct continuation field
            if (index == dynAccessed_FieldSet_List.size()) {    // add to end
                FieldSet_Worker.setField_AddNewValue_to_EndOfList(value, this.dynAccessed_FieldSet_List, this,
                        dynAccessed_FieldSet_Index, schemaInfo_Field.fieldName);

            } else // set an existing value
                FieldSet_Worker.setField_ReplaceExistingValue_in_List(value, index, this.dynAccessed_FieldSet_List, this,
                        dynAccessed_FieldSet_Index, schemaInfo_Field.fieldName);

        }

    }


    /**
     * To "add" new special field values to a tuple, you must call the SetField() method in sequential order by index!
     * But, you can also replace existing field values with this method (meaning, they must have already been added).
     *
     * @param executeInfo
     * @param index
     * @param value
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed
     */
    @Override
    public void setField__Special(ExecutionInfo executeInfo, int index, FieldConstants specialValue) throws Exception_InvalidArgumentPassed {
        executeInfo.reset();

        //  The get_SchemaInfoField should throw any errors dealing with an out of bound index.

        SchemaInfo_Field schemaInfo_Field = schemaInfo_Positioned.get_SchemaInfoField(executeInfo, index);


        if (!schemaInfo_Field.is_Continuation_Field) {

            if (index == dynAccessed_FieldSet_List.size()) {  // add to end

                FieldSet_Worker.setFieldSpecial_AddNewValue_to_EndOfList(specialValue, this.dynAccessed_FieldSet_List, this,
                        dynAccessed_FieldSet_Index, schemaInfo_Field.fieldName);
                ++fieldValue_NonContinuationCount;

            } else {  // replace an existing value
                FieldSet_Worker.setFieldSpecial_ReplaceExistingValue_in_List(specialValue, index, this.dynAccessed_FieldSet_List, this,
                        dynAccessed_FieldSet_Index, schemaInfo_Field.fieldName);
            }



        } else { // set the value at the correct continuation field
            if (index == dynAccessed_FieldSet_List.size()) {    // add to end
                FieldSet_Worker.setFieldSpecial_AddNewValue_to_EndOfList(specialValue, this.dynAccessed_FieldSet_List, this,
                        dynAccessed_FieldSet_Index, schemaInfo_Field.fieldName);

            } else // set an existing value
                FieldSet_Worker.setFieldSpecial_ReplaceExistingValue_in_List(specialValue, index, this.dynAccessed_FieldSet_List, this,
                        dynAccessed_FieldSet_Index, schemaInfo_Field.fieldName);

        }
    }

    /**
     * Add or replace new special field values to a tuple.
     * But, you can also replace existing field values with this method (meaning, they must have already been added).
     *
     * @param executeInfo
     * @param index
     * @param value
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed
     */
    @Override
    public void setField__Special(ExecutionInfo executeInfo, DescriptorTagName fieldName, FieldConstants specialValue)
            throws Exception_InvalidArgumentPassed {

        executeInfo.reset();

        FieldSet_FieldValueBucket fieldValueBucket = dynAccessed_FieldSet_Index.get(fieldName);

        if (fieldValueBucket != null) {
            fieldValueBucket.value = null;
            fieldValueBucket.specialValue = specialValue;
            return;

        } else {
            //  The get_SchemaInfoField should throw any errors dealing with an out of bound index.
            SchemaInfo_Field schemaInfo_Field = schemaInfo_Positioned.get_SchemaInfoField(executeInfo, fieldName);


            if (!schemaInfo_Field.is_Continuation_Field) {

                if (schemaInfo_Field.fieldIndex == dynAccessed_FieldSet_List.size()) {  // add to end

                    FieldSet_Worker.setFieldSpecial_AddNewValue_to_EndOfList(specialValue, this.dynAccessed_FieldSet_List, this,
                            dynAccessed_FieldSet_Index, schemaInfo_Field.fieldName);
                    ++fieldValue_NonContinuationCount;

                } else {  // replace an existing value
                    FieldSet_Worker.setFieldSpecial_ReplaceExistingValue_in_List(specialValue, schemaInfo_Field.fieldIndex, this.dynAccessed_FieldSet_List, this,
                            dynAccessed_FieldSet_Index, schemaInfo_Field.fieldName);
                }



            } else { // set the value at the correct continuation field
                throw new Exception_InvalidArgumentPassed("Tried setting a special field value on a fieldSet tuple's continuation field by fieldname: " +
                        fieldName.getTagName() + ". This is not allowed. Must set continuation fields by index.");
            }
        }
    }







}
