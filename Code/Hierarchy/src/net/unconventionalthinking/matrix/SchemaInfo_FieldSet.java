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

import net.unconventionalthinking.exceptions.*;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 *
 * @author peterjoh
 */
public class SchemaInfo_FieldSet extends MatrixElement implements SchemaInfo  {




    public enum OrderBy_Property { FieldIndex, FieldName, FieldType, FieldDefaultValue }

    SchemaInfo_Descriptor                       parent_SchemaInfoDescriptor;

    List<SchemaInfo_Field>                      schemaInfoFields_List;
    Map<DescriptorTagName, SchemaInfo_Field>    schemaInfoFields_Index;



    FieldSet            fieldNames_FieldSet;
    FieldSet            fieldTypes_FieldSet;
    FieldSet            fieldDescription_FieldSet;
    FieldSet            fieldDefaults_FieldSet;

    int                 num_NonContinuationFields;
    int                 num_AllFields;
    boolean             has_ContinuationField;
    SchemaInfo_Field    continuation_SchemaInfoField;
    int                 max_FieldSet_Size;
    boolean             has_SpecializedFieldSet;

    /**
     * This field is used to access the "fieldSetTuple_To_CreateNew_Index". it returns the createNew method call back
     * object.
     */
    Symbol              fieldSet_TypeSymbol;
    String              fieldSet_TypeString;


    SymbolControl               symbolControl;
    SchemaControl_Info          schemaControl_Info;
    Map<Symbol, Constructor>    fieldSetTupleSpecialized_Constructor_Index_byTypeSymbol;



    SchemaInfo_FieldSet(ExecutionInfo executeInfo, SchemaInfo_Descriptor parent_SchemaInfoDescriptor) {
        this.parent_SchemaInfoDescriptor = parent_SchemaInfoDescriptor;

        schemaInfoFields_List = new ArrayList<SchemaInfo_Field>();
        schemaInfoFields_Index = new HashMap<DescriptorTagName, SchemaInfo_Field>();

        num_NonContinuationFields = 0;
        num_AllFields = 0;
        has_ContinuationField = false;
        max_FieldSet_Size = 0;

        has_SpecializedFieldSet = false;
    }




    public void initialize_SchemaInfo(ExecutionInfo executeInfo, SymbolControl symbolControl, SchemaControl_Info schemaControl_Info) 
            throws Exception_SchemaInfo {

        executeInfo.reset();

        this.symbolControl = symbolControl;
        this.schemaControl_Info = schemaControl_Info;
        this.fieldSetTupleSpecialized_Constructor_Index_byTypeSymbol = schemaControl_Info.fieldSetTupleSpecialized_Constructor_Index_byTypeSymbol;
        
        
        

        //  create fieldList & field Hash
        try {
            fieldNames_FieldSet = parent_SchemaInfoDescriptor.getSchemaInfo_FieldNames_FieldSet(executeInfo);
            fieldTypes_FieldSet = parent_SchemaInfoDescriptor.getSchemaInfo_FieldTypes_FieldSet(executeInfo);
            fieldDescription_FieldSet = parent_SchemaInfoDescriptor.getSchemaInfo_FieldDescription_FieldSet(executeInfo);
            fieldDefaults_FieldSet = parent_SchemaInfoDescriptor.getSchemaInfo_FieldDefaults_FieldSet(executeInfo);


            fieldSet_TypeString = SchemaConstants.FieldSetTuple__SpecializedName_Prefix + getSchemaInfo_DescTagName_FullPath_IdentFormat(executeInfo);
            fieldSet_TypeSymbol = symbolControl.singleSymbol_Factory.createNew(fieldSet_TypeString, false);

        } catch (Exception e) {
            throw new Exception_SchemaInfo("Tried to initialized a schemaInfo_FieldSet, but had problems get the Field<*> fieldSet from the schema.", e);
        }

        //  get the max size of all 4 field<*> fieldsets
        max_FieldSet_Size =
            Math.max(  (fieldNames_FieldSet != null) ? fieldNames_FieldSet.size() : 0,
                Math.max(  (fieldTypes_FieldSet != null) ? fieldTypes_FieldSet.size() : 0,
                    Math.max(  (fieldDescription_FieldSet != null) ? fieldDescription_FieldSet.size() : 0,
                        (fieldDefaults_FieldSet != null) ? fieldDefaults_FieldSet.size() : 0  )));


        for(int i = 0; i < max_FieldSet_Size; ++i) {

            DescriptorTagName fieldName_descTagName;
            Symbol fieldType_Symbol;
            String fieldDescription;
            Object fieldDefault;

            try {
                //  Create the SchemaInfo_Fields:
                //  First, get the field info from the field sets:
                fieldName_descTagName = (fieldNames_FieldSet != null) ? fieldNames_FieldSet.getField_DescTagName(executeInfo, i) : null;
                fieldType_Symbol = (fieldTypes_FieldSet != null) ? fieldTypes_FieldSet.getField_Symbol(executeInfo, i) : null;
                fieldDescription = (fieldDescription_FieldSet != null) ? fieldDescription_FieldSet.getField_String(executeInfo, i) : null;
                fieldDefault = (fieldDefaults_FieldSet != null) ? fieldDefaults_FieldSet.getField(executeInfo, i) : null;
            } catch (Exception e) {
                throw new Exception_SchemaInfo("Tried to initialize a schemaInfo_FieldSet, for the schemaInfo_Descriptor, " +
                        ((parent_SchemaInfoDescriptor != null) ? parent_SchemaInfoDescriptor.getSchemaInfo_DescriptorTag() : "<null>") +
                        ", but had problems with the getField_<*>() methods.", e);
            }


            SchemaInfo_Field schemaInfo_Field = null;
            //  The SchemaInfo_Field constructor will handle Continuation fields. Note: the symbol for a continuation
            //  field is  :ContinuationType.int
            schemaInfo_Field = new SchemaInfo_Field(executeInfo, i, this, fieldName_descTagName, fieldType_Symbol, symbolControl,
                                                     fieldDescription, fieldDefault);

            if (schemaInfo_Field.is_Continuation_Field) {
                has_ContinuationField = true;
                continuation_SchemaInfoField = schemaInfo_Field;
            } else
                ++num_NonContinuationFields;

            ++num_AllFields;


            schemaInfoFields_List.add(schemaInfo_Field);
            schemaInfoFields_Index.put(fieldName_descTagName, schemaInfo_Field);

        }



        // determine if the fieldSets for this schemaInfo_FieldSet have specialized fieldsets
        Constructor<FieldSet_Tuple> fieldSetTuple_Constructor = null;
        if (fieldSetTupleSpecialized_Constructor_Index_byTypeSymbol != null)
            fieldSetTuple_Constructor = fieldSetTupleSpecialized_Constructor_Index_byTypeSymbol.get(fieldSet_TypeSymbol);
        has_SpecializedFieldSet = (fieldSetTuple_Constructor != null);


    }








    public FieldSet_Tuple create_FieldSet_Tuple(ExecutionInfo executeInfo, Descriptor parentDescriptor,
            Boolean_Mutable created_SpecializedFieldSet) throws Exception_SchemaInfo {


        //  Note: casting a specialized fieldSet into a base class fieldSet
        //  first, get the specialized fieldset's createNew callback
        Constructor<FieldSet_Tuple> fieldSetTuple_Constructor = null;
        if (fieldSetTupleSpecialized_Constructor_Index_byTypeSymbol != null)
            fieldSetTuple_Constructor = fieldSetTupleSpecialized_Constructor_Index_byTypeSymbol.get(fieldSet_TypeSymbol);


        if (fieldSetTuple_Constructor != null) {
            if (created_SpecializedFieldSet != null)
                created_SpecializedFieldSet.value = true;

            FieldSet_Tuple newFieldSet_Tuple = null;

            try {
                 newFieldSet_Tuple = fieldSetTuple_Constructor.newInstance(executeInfo, parentDescriptor);

            } catch (IllegalAccessException e) {
                throw new Exception_SchemaInfo("Tried to create a new specialized field set of type: " + fieldSet_TypeString + ", but had an error (see inner exception).", e);
            } catch (IllegalArgumentException e) {
                throw new Exception_SchemaInfo("Tried to create a new specialized field set of type: " + fieldSet_TypeString + ", but had an error (see inner exception).", e);
            } catch (InstantiationException e) {
                throw new Exception_SchemaInfo("Tried to create a new specialized field set of type: " + fieldSet_TypeString + ", but had an error (see inner exception).", e);
            } catch (InvocationTargetException e) {
                throw new Exception_SchemaInfo("Tried to create a new specialized field set of type: " + fieldSet_TypeString + ", but had an error (see inner exception).", e);
            }

            return newFieldSet_Tuple;

        } else {
            //  return a generic fieldSetTuple
            return new FieldSet_Tuple(executeInfo, parentDescriptor);
        }

    }


    public FieldSet_ParameterMap create_FieldSet_ParameterMap(ExecutionInfo executeInfo, Descriptor parentDescriptor) {
        return new FieldSet_ParameterMap(executeInfo, parentDescriptor);
    }



    
    /**
     * SchemaInfo_FieldSet's don't have schemaInfo's return null;
     * @return
     */
    public SchemaInfo getSchemaInfo() { return null; }


    public Object has_Field(ExecutionInfo executeInfo, String fieldnameString, SymbolControl symbolControl) throws Exception_InvalidArgumentPassed {
        return has_Field(executeInfo, symbolControl.singleSymbol_Factory.createNew_DescTagName(fieldnameString, false));
    }
    public boolean has_Field(ExecutionInfo executeInfo, DescriptorTagName fieldName) {
        return schemaInfoFields_Index.containsKey(fieldName);
    }

    public List<SchemaInfo_Field> get_FieldList(ExecutionInfo executeInfo, Symbol primitiveType_Filter,
            OrderBy_Property orderBy_Property) throws Exception_SchemaInfo{

        executeInfo.reset();

        List<SchemaInfo_Field> result_SchemaInfoFields = new ArrayList<SchemaInfo_Field>();

        for (SchemaInfo_Field field_SchemaInfo : schemaInfoFields_List) {

            // add the field if there is no type filtering, or if there is type filtering, the schemaInfo field's type symbol
            // matches the filter's type symbol.
            if (primitiveType_Filter == null ||
                (primitiveType_Filter != null && field_SchemaInfo.fieldType_Symbol == primitiveType_Filter) ) {

                    result_SchemaInfoFields.add(field_SchemaInfo);
            }

        }

        //  sort on the orderByProperty
        if (orderBy_Property != null && orderBy_Property != OrderBy_Property.FieldIndex)
            SchemaInfo_FieldSet_Utilities.sort_SchemaInfoFields(result_SchemaInfoFields, orderBy_Property);

        return result_SchemaInfoFields;
    }




    public List<Pair<Object, SchemaInfo_Field>>  get_FieldList_ReturnPairs(ExecutionInfo executeInfo, Symbol primitiveType_Filter,
            OrderBy_Property orderBy_Property) throws Exception_SchemaInfo {
        executeInfo.reset();

        List<Pair<Object, SchemaInfo_Field>>  resultFields = new ArrayList<Pair<Object, SchemaInfo_Field>>();

        for (SchemaInfo_Field field_SchemaInfo : schemaInfoFields_List) {

            // add the field if there is no type filtering, or if there is type filtering, the schemaInfo field's type symbol
            // matches the filter's type symbol.
            if (primitiveType_Filter == null ||
                (primitiveType_Filter != null && field_SchemaInfo.fieldType_Symbol == primitiveType_Filter) ) {

                    //  pull the correct field var to use as the order by property. This value will be used to sort the resulting fieldList
                    // (for instance, use the fieldIndex to sort)
                    Object orderBy_PropertyForField = SchemaInfo_FieldSet_Utilities.get_OrderBy_PropertyValue_FromField(field_SchemaInfo, orderBy_Property);

                    resultFields.add(new Pair<Object, SchemaInfo_Field>(orderBy_PropertyForField, field_SchemaInfo));
            }

        }

        //  sort on the orderByProperty
        if (orderBy_Property != null && orderBy_Property != OrderBy_Property.FieldIndex)
            SchemaInfo_FieldSet_Utilities.sort_SchemaInfoFieldPairs(resultFields, orderBy_Property);

        return resultFields;
    }



    /**
     * returns continuation as a field
     * @return
     */
    public List<SchemaInfo_Field> get_SchemaInfoFields() { return schemaInfoFields_List; }

    public Map<DescriptorTagName, SchemaInfo_Field> get_ScheamInfoFieldsIndex() { return schemaInfoFields_Index; }


    /**
     *
     * @param countContinuationAsField  pass true if you want to count continuation as a single field.
     * @return
     */
    public int getNumFields(boolean count_ContinuationAsField) {
        if (count_ContinuationAsField)
            return num_AllFields;
        else
            return num_NonContinuationFields;
    }
    public final int getNum_NonContinuationFields() { return num_NonContinuationFields; }
    /**
     * a continuation field is counted as one field.
     * @return
     */
    public final int getNum_AllFields() { return num_AllFields; }

    public boolean isEmpty() {
        return (fieldNames_FieldSet == null) && (fieldTypes_FieldSet == null) && (fieldDescription_FieldSet == null)
                  && (fieldDefaults_FieldSet == null);
    }



    /**
     * This method will return continuation field if the index is equal to or above the continuation start index.
     * @param index
     * @return
     */
    public SchemaInfo_Field get_SchemaInfoField(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed {
        executeInfo.reset();

        if (index < 0) throw new Exception_InvalidArgumentPassed("Tried to access a schemaInfo_Field using an FieldSet index less than zero");

        if (index < num_NonContinuationFields)
            return schemaInfoFields_List.get(index);
        else if (has_ContinuationField) {
            return schemaInfoFields_List.get(num_NonContinuationFields); // the last schemaInfo_Field must be the continuation Field
        } else {
            throw new Exception_InvalidArgumentPassed("Tried to access a schemaInfo_Field using an FieldSet index greater than the number of existing fields." +
                " this fieldset has " + num_NonContinuationFields + " and was accessed using an index of " + index + ". The schemaInfo_Field you tried to access was '" + getSchemaInfo_DescTagName_FullPath_String(executeInfo) + "'" );
        }
    }

    public SchemaInfo_Field get_SchemaInfoField(ExecutionInfo executeInfo, DescriptorTagName fieldName) {
        executeInfo.reset();
        SchemaInfo_Field schemaInfoField = schemaInfoFields_Index.get(fieldName);

        if (schemaInfoField != null)
            return schemaInfoField;
        else {
            executeInfo.set_HadError();
            executeInfo.addErrorInfo(ExecutionInfo.ErrorType.FieldName_NotValid);
            return null;
        }

    }

    public SchemaInfo_Field get_Continuation_SchemaInfoField(ExecutionInfo executeInfo) {
        executeInfo.reset();

        if (continuation_SchemaInfoField != null)
            return continuation_SchemaInfoField;
        else {
            executeInfo.addResultsInfo_EmptyResultSet();
            return null;
        }
    }





    public DescriptorTagName get_FieldName_At(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed {

        SchemaInfo_Field schemaInfo_Field = get_SchemaInfoField(executeInfo, index);

        if (schemaInfo_Field != null)
            return schemaInfo_Field.fieldName;
        else {
            executeInfo.addResultsInfo_EmptyResultSet();
            return null;
        }
    }

    public int get_FieldIndex_For(ExecutionInfo executeInfo, DescriptorTagName fieldName) {
        executeInfo.reset();
        SchemaInfo_Field schemaInfo_Field = schemaInfoFields_Index.get(fieldName);

        return schemaInfo_Field.getFieldIndex();
    }


    public boolean           hasContinuationField() { return has_ContinuationField; }



    
    public boolean has_SpecializedFieldSet() { return has_SpecializedFieldSet; }
    /**
     * used to create new fieldSet objects
     * @return
     */
    public String get_FieldSetTypeString() { return fieldSet_TypeString; }
    /**
     * used to create new fieldSet objects
     * @return
     */
    public Symbol get_FieldSetTypeSymbol() { return fieldSet_TypeSymbol; }





    //  SchemaInfo interface methods

    public SchemaInfo getSchemaInfo_ParentSchemaInfo(ExecutionInfo executeInfo) {
        return parent_SchemaInfoDescriptor;
    }

    /**
     * For this method, a fieldSet returns its parent descriptor's tag name.
     * @return
     */
    public DescriptorTagName getSchemaInfo_DescriptorTagName()  {
        return parent_SchemaInfoDescriptor.getSchemaInfo_DescriptorTagName();
    }
    public void getSchemaInfo_DescTagName_FullPath(ExecutionInfo executeInfo, List<Symbol_Base> nameSymbols) {
        parent_SchemaInfoDescriptor.getSchemaInfo_DescTagName_FullPath(executeInfo, nameSymbols);
    }
    public String getSchemaInfo_DescTagName_FullPath_String(ExecutionInfo executeInfo) {
        return parent_SchemaInfoDescriptor.getSchemaInfo_DescTagName_FullPath_String(executeInfo);
    }
    public String getSchemaInfo_DescTagName_FullPath_IdentFormat(ExecutionInfo executeInfo) {
        return parent_SchemaInfoDescriptor.getSchemaInfo_DescTagName_FullPath_IdentFormat(executeInfo);
    }


    public Type getSchemaInfo_SchemaInfoType() {
        return Type.SchemaInfoFieldSet;
    }


    public SchemaInfo_Schema getSchemaInfo__Ancestor_SchemaInfoSchema() {
        return parent_SchemaInfoDescriptor.getSchemaInfo__Ancestor_SchemaInfoSchema();
    }
    public MatrixName getSchemaInfo_SchemaNameFull() {
        return parent_SchemaInfoDescriptor.getSchemaInfo_SchemaNameFull();
    }



    public void print(StringBuilder strBuilder, int indentationLevel) {

        strBuilder.append(" (schemaInfo FieldSet: ");

        boolean isFirst = true;
        for (SchemaInfo_Field schemaInfo_Field : schemaInfoFields_List) {
            if (!isFirst)
                strBuilder.append(", ");
            else
                isFirst = false;
            strBuilder.append(schemaInfo_Field.fieldName);
        }

        strBuilder.append(")");

    }

}
