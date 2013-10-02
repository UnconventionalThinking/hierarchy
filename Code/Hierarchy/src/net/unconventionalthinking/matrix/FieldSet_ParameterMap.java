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

import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;
import java.util.*;

import net.unconventionalthinking.matrix.symbols.*;

/**
 * Note, a dynamically built fieldset_tuple, and a parameter map are very similar behind the scenes. the major difference
 * is that the parameter map only has a hash, while a dynamically built fieldset_tuple has both a hash and an arraylist.
 *
 * @author peterjoh
 */
public class FieldSet_ParameterMap extends FieldSet {


    //  Note, the key is a DescriptorTagName, which uses the symbol ID as the hashcode! so hashing a symbol is a very quick operation!
    protected Map<DescriptorTagName, FieldSet_FieldValueBucket> parameterMap_FieldSet;
    protected List<FieldSet_FieldValueBucket> continuationFields;



    public FieldSet_ParameterMap(ExecutionInfo executeInfo, Descriptor parentDescriptor) {

        super(executeInfo, parentDescriptor);

        fieldValue_TotalCount = 0;
        fieldValue_NonContinuationCount = 0;

        parameterMap_FieldSet = new HashMap<DescriptorTagName, FieldSet_FieldValueBucket>();

        if (schemaInfo_Positioned.has_ContinuationField)
            continuationFields = new ArrayList<FieldSet_FieldValueBucket>();


    }



    @Override
    public Object getField(ExecutionInfo executeInfo, DescriptorTagName fieldname) throws Exception_InvalidArgumentPassed {
        executeInfo.reset();
        FieldSet_FieldValueBucket fieldValueBucket = parameterMap_FieldSet.get(fieldname);

        return FieldSet_Worker.getField_ProcessFieldValueBucket(executeInfo, fieldValueBucket, schemaInfo_Positioned, fieldname);
    }

    @Override
    public Object getField(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed {
        executeInfo.reset();

        DescriptorTagName fieldName;
        try {
            fieldName = schemaInfo_Positioned.get_FieldName_At(executeInfo, index);
        } catch(Exception_InvalidArgumentPassed e) {
            throw e;
        }


        if (fieldName != null) {

            FieldSet_FieldValueBucket fieldValueBucket = parameterMap_FieldSet.get(fieldName);

            return FieldSet_Worker.getField_ProcessFieldValueBucket(executeInfo, fieldValueBucket, schemaInfo_Positioned, index);


        } else {
            executeInfo.set_HadError();
            executeInfo.addErrorInfo(ExecutionInfo.ErrorType.FieldName_NotValid);

            throw new Exception_InvalidArgumentPassed("Tried to access a fieldset parametermap by index, but the field index is not valid: " + index);
        }

    }




    @Override
    public void setField(ExecutionInfo executeInfo, DescriptorTagName fieldName, Object value, Symbol typeSymbol) throws Exception_InvalidArgumentPassed {
        executeInfo.reset();

        SchemaInfo_Field schemaInfo_Field = schemaInfo_Positioned.get_SchemaInfoField(executeInfo, fieldName);
        if (executeInfo.containsError(ExecutionInfo.ErrorType.FieldName_NotValid))
            return;

        FieldSet.test_FieldValueType(executeInfo, typeSymbol, value, schemaInfo_Field);


        FieldSet_FieldValueBucket fieldValueBucket = parameterMap_FieldSet.get(fieldName);

        if (fieldValueBucket == null) {
            if (!schemaInfo_Field.is_Continuation_Field) {
                fieldValueBucket = new FieldSet_FieldValueBucket();

                parameterMap_FieldSet.put(fieldName, fieldValueBucket);

                ++fieldValue_TotalCount;
                ++fieldValue_NonContinuationCount;

            } else {
                throw new Exception_InvalidArgumentPassed("Tried setting a field value on a fieldSet parametermap's continuation field by fieldname: " +
                        fieldName.getTagName() + ". This is not allowed. Must set continuation fields by index.");
            }
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



    @Override
    public void setField(ExecutionInfo executeInfo, int index, Object value, Symbol typeSymbol) throws Exception_InvalidArgumentPassed {
        executeInfo.reset();

        SchemaInfo_Field schemaInfo_Field = schemaInfo_Positioned.get_SchemaInfoField(executeInfo, index);
        if (schemaInfo_Field == null)
            throw new Exception_InvalidArgumentPassed("Tried setting a field value on a fieldSet parametermap's with an invalid index of :" + index);

        if (!schemaInfo_Field.is_Continuation_Field) {
            FieldSet_FieldValueBucket fieldValueBucket = parameterMap_FieldSet.get(schemaInfo_Field.fieldName);

            if (fieldValueBucket == null) {
                fieldValueBucket = new FieldSet_FieldValueBucket();

                parameterMap_FieldSet.put(schemaInfo_Field.fieldName, fieldValueBucket);

                ++fieldValue_TotalCount;
                ++fieldValue_NonContinuationCount;

            }


            fieldValueBucket.value = value;
            if (value != null)
                fieldValueBucket.specialValue = FieldConstants.HAS_STANDARD_VALUE;
            else {
                // setting null - but, so you can tell that the field actually has a value,
                // put the FieldConstant.NULL object instead!
                fieldValueBucket.specialValue = FieldConstants.NULL;

            }



        } else {
            int continuationIndex = schemaInfo_Positioned.num_NonContinuationFields - index;
            if (continuationIndex  == continuationFields.size()) {    // add to end
                FieldSet_Worker.setField_AddNewValue_to_EndOfList(value, continuationFields, this);

            } else // set an existing value
                FieldSet_Worker.setField_ReplaceExistingValue_in_List(value, continuationIndex, continuationFields, this);

        }



    }



    @Override
    public void setField__Special(ExecutionInfo executeInfo, DescriptorTagName fieldName, FieldConstants specialValue)
        throws Exception_InvalidArgumentPassed {


        SchemaInfo_Field schemaInfo_Field = schemaInfo_Positioned.get_SchemaInfoField(executeInfo, fieldName);
        if (executeInfo.containsError(ExecutionInfo.ErrorType.FieldName_NotValid))
            return;

        FieldSet_FieldValueBucket fieldValueBucket = parameterMap_FieldSet.get(fieldName);

        if (fieldValueBucket == null) {
            if (!schemaInfo_Field.is_Continuation_Field) {
                fieldValueBucket = new FieldSet_FieldValueBucket();

                parameterMap_FieldSet.put(fieldName, fieldValueBucket);

                ++fieldValue_TotalCount;
                ++fieldValue_NonContinuationCount;

            } else {
                throw new Exception_InvalidArgumentPassed("Tried setting a field value on a fieldSet parametermap's continuation field by fieldname: " +
                        fieldName.getTagName() + ". This is not allowed. Must set continuation fields by index.");
            }
        }

        fieldValueBucket.value = null;
        fieldValueBucket.specialValue = specialValue;



    }





    @Override
    public void setField__Special(ExecutionInfo executeInfo, int index, FieldConstants specialValue) throws Exception_InvalidArgumentPassed {

        SchemaInfo_Field schemaInfo_Field = schemaInfo_Positioned.get_SchemaInfoField(executeInfo, index);
        if (schemaInfo_Field == null)
            throw new Exception_InvalidArgumentPassed("Tried setting a field value on a fieldSet parametermap's with an invalid index of :" + index);

        if (!schemaInfo_Field.is_Continuation_Field) {
            FieldSet_FieldValueBucket fieldValueBucket = parameterMap_FieldSet.get(schemaInfo_Field.fieldName);

            if (fieldValueBucket == null) {
                fieldValueBucket = new FieldSet_FieldValueBucket();

                parameterMap_FieldSet.put(schemaInfo_Field.fieldName, fieldValueBucket);

                ++fieldValue_TotalCount;
                ++fieldValue_NonContinuationCount;

            }


            fieldValueBucket.value = null;
            fieldValueBucket.specialValue = specialValue;



        } else {
            int continuationIndex = schemaInfo_Positioned.num_NonContinuationFields - index;
            if (continuationIndex  == continuationFields.size()) {    // add to end
                FieldSet_Worker.setFieldSpecial_AddNewValue_to_EndOfList(specialValue, continuationFields, this);

            } else // set an existing value
                FieldSet_Worker.setFieldSpecial_ReplaceExistingValue_in_List(specialValue, continuationIndex, continuationFields, this);

        }



    }



    @Override
    public boolean is_ParameterMap() {
        return true;
    }
    @Override
    public boolean is_Tuple() {
        return false;
    }

}
