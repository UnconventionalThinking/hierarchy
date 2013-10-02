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

import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.symbols.*;
import java.util.*;


/**
 *
 * @author peterjoh
 */
public class Schema_for_SchemaForSchema__SchemaInfoDesc_FieldTypes implements SchemaInfo_Descriptor {

    SchemaInfo_Descriptor                           parent_SchemaInfoDescriptor;

    Map<DescriptorTagName, SchemaInfo_Descriptor>   child_SchemaInfoDescriptor_Index_by_DescTagName;
    List<SchemaInfo_Descriptor>                     child_SchemaInfoDescriptor_List;

    SchemaInfo_FieldSet                             schemaInfoFieldSet;


    public Schema_for_SchemaForSchema__SchemaInfoDesc_FieldTypes(ExecutionInfo executeInfo, SchemaInfo_Descriptor parent_SchemaInfoDescriptor,
            DescriptorControl schema_DescControl)
            throws Exception_SchemaInfo {

        this.parent_SchemaInfoDescriptor = parent_SchemaInfoDescriptor;

        child_SchemaInfoDescriptor_Index_by_DescTagName = new HashMap<DescriptorTagName, SchemaInfo_Descriptor>();
        child_SchemaInfoDescriptor_List = new ArrayList<SchemaInfo_Descriptor>();

        schemaInfoFieldSet = new SchemaInfo_FieldSet_FieldTypes(executeInfo, schema_DescControl.symbolControl);
    }


    public void initialize_SchemaInfo(ExecutionInfo executeInfo, SymbolControl symbolControl, SchemaControl_Info schemaControl_Info) throws Exception_SchemaInfo
        {}


    
    public DescriptorTagName getSchemaInfo_DescriptorTagName() { return MPSymbols_DescTagName.FIELD$__$TYPES;    }
    public DescriptorTag getSchemaInfo_DescriptorTag() {
        return MPSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$TYPES;
    }
    public MatrixName getSchemaInfo_SchemaNameFull() {
        return MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA;
    }

    

    public void addChild_SchemaInfoDescriptor(ExecutionInfo executeInfo, SchemaInfo_Descriptor child_SchemaInfoDescriptor) throws Exception_Descriptor, Exception_SchemaInfo {
        throw new UnsupportedOperationException("This operation is not supported for the SchemaForSchema_SchemaInfoDescriptor_FieldTypes obj.");
    }
    public void addChild_SchemaInfo_FieldDescriptor(ExecutionInfo executeInfo, Descriptor child_FieldDescriptor)
            throws Exception_Descriptor {
        throw new UnsupportedOperationException("This operation is not supported for the SchemaForSchema_SchemaInfoDescriptor_FieldTypes obj.");
    }


    public void create_SchemaInfoFieldSet(ExecutionInfo executeInfo) {
        throw new UnsupportedOperationException("This operation is not supported for the SchemaForSchema_SchemaInfoDescriptor_FieldTypes obj.");
    }
    public SchemaInfo_FieldSet get_SchemaInfoFieldSet(ExecutionInfo executeInfo) {
        return schemaInfoFieldSet;
    }

    public FieldSet_Tuple create_FieldSet_Tuple(ExecutionInfo executeInfo, Descriptor parentDescriptor) {
        return new FieldSet_Tuple(executeInfo, parentDescriptor);
    }
    public FieldSet_ParameterMap create_FieldSet_ParameterMap(ExecutionInfo executeInfo, Descriptor parentDescriptor) {
        throw new UnsupportedOperationException("This operation is not supported for the SchemaForSchema_SchemaInfoDescriptor_FieldTypes obj.");
    }
    public boolean getSchemaInfo_canHave_FieldSet() { return true; }
    public void setSchemaInfo_canHave_FieldSet(boolean value) {
        throw new UnsupportedOperationException("This operation is not supported for the SchemaForSchema_SchemaInfoDescriptor_FieldTypes obj.");
    }






    public SchemaInfo_Descriptor getChild_SchemaInfoDescriptor(ExecutionInfo executeInfo, DescriptorTag find_SchemaInfo_DescTag)
        { return null; }
    public SchemaInfo_Descriptor getChild_SchemaInfoDescriptor(ExecutionInfo executeInfo, DescriptorTag find_SchemaInfo_DescTag, SearchType searchType)
        { return null; }
    public SchemaInfo_Descriptor getChild_SchemaInfoDescriptor(ExecutionInfo executeInfo, DescriptorTagName find_SchemaInfo_DescTagName)
        { return null; }
    public SchemaInfo_Descriptor getChild_SchemaInfoDescriptor(ExecutionInfo executeInfo, DescriptorTagName find_SchemaInfo_DescTagName, SearchType searchType)
        { return null; }

    public List<SchemaInfo_Descriptor> getChild_SchemaInfoDescriptors(ExecutionInfo executeInfo) {
        return child_SchemaInfoDescriptor_List;
    }
    public SchemaInfo findChild_SchemaInfo(ExecutionInfo executeInfo, SchemaInfoProperty_Type find_schemaInfo_Type, SearchType searchType, DescriptorTagName find_SchemaInfo_DescTagName, SchemaInfoProperty filter_SchemaInfo_Property) {
        return null;
    }


    public SchemaInfo getSchemaInfo_ParentSchemaInfo(ExecutionInfo executeInfo) {
        return parent_SchemaInfoDescriptor;
    }

    public void getSchemaInfo_DescTagName_FullPath(ExecutionInfo executeInfo, List<Symbol_Base> nameSymbols) {

        parent_SchemaInfoDescriptor.getSchemaInfo_DescTagName_FullPath(executeInfo, nameSymbols);
        nameSymbols.add(MPSymbols_DescTagName.FIELD$__$TYPES);
    }
    public String getSchemaInfo_DescTagName_FullPath_String(ExecutionInfo executeInfo) {
        return (parent_SchemaInfoDescriptor.getSchemaInfo_DescTagName_FullPath_String(executeInfo) + SymbolConstants.SymbolPath_SymbolSeparator +
            ((Symbol)MPSymbols_DescTagName.FIELD$__$TYPES).name_MultiPart.name_no_backtiks);
    }
    public String getSchemaInfo_DescTagName_FullPath_IdentFormat(ExecutionInfo executeInfo) {
        return (parent_SchemaInfoDescriptor.getSchemaInfo_DescTagName_FullPath_IdentFormat(executeInfo) + SymbolConstants.SymbolPath_SymbolSeparator_IdentFormat +
            ((Symbol)MPSymbols_DescTagName.FIELD$__$TYPES).name_IdentFormat);
    }


    public SchemaInfo.Type getSchemaInfo_SchemaInfoType() {
        return SchemaInfo.Type.SchemaInfoDescriptor;
    }
    public SchemaInfo_Schema getSchemaInfo__Ancestor_SchemaInfoSchema() {
        return (SchemaInfo_Schema)parent_SchemaInfoDescriptor.getSchemaInfo_ParentSchemaInfo(new ExecutionInfo());
    }


    public List<SchemaInfo_Descriptor> getSchemaInfo_ChildSchemaInfoDesc_List() { return child_SchemaInfoDescriptor_List; }
    public Map<DescriptorTagName, SchemaInfo_Descriptor> getSchemaInfo_ChildSchemaInfoDescIndex_by_DescTagName() {
        return child_SchemaInfoDescriptor_Index_by_DescTagName;
    }


    public void setSchemaInfo_FieldNames_Desc(Descriptor fieldNames) { throw new UnsupportedOperationException("Not supported operation."); }
    public void setSchemaInfo_FieldTypes_Desc(Descriptor fieldTypes) { throw new UnsupportedOperationException("Not supported operation."); }
    public void setSchemaInfo_FieldDescription_Desc(Descriptor fieldDescription) { throw new UnsupportedOperationException("Not supported operation."); }
    public void setSchemaInfo_FieldDefaults_Desc(Descriptor fieldDefaults) { throw new UnsupportedOperationException("Not supported operation."); }

    public Descriptor getSchemaInfo_FieldNames_Desc() { return null; }
    public Descriptor getSchemaInfo_FieldTypes_Desc() { return null; }
    public Descriptor getSchemaInfo_FieldDescription_Desc() { return null; }
    public Descriptor getSchemaInfo_FieldDefaults_Desc() { return null; }

    public FieldSet_Tuple getSchemaInfo_FieldNames_FieldSet(ExecutionInfo executeInfo) throws Exception_Descriptor { return null; }
    public FieldSet_Tuple getSchemaInfo_FieldTypes_FieldSet(ExecutionInfo executeInfo) throws Exception_Descriptor { return null; }
    public FieldSet_Tuple getSchemaInfo_FieldDescription_FieldSet(ExecutionInfo executeInfo) throws Exception_Descriptor { return null; }
    public FieldSet_Tuple getSchemaInfo_FieldDefaults_FieldSet(ExecutionInfo executeInfo) throws Exception_Descriptor { return null; }

    public Descriptor getSchemaInfo_FieldDescriptor(ExecutionInfo executeInfo, DescriptorTagName field_DescTagName) throws Exception_Descriptor { return null; }




    public class SchemaInfo_FieldSet_FieldTypes extends SchemaInfo_FieldSet {

        public SchemaInfo_Field schemaInfoField_FieldTypes;

        public SchemaInfo_FieldSet_FieldTypes(ExecutionInfo executeInfo, SymbolControl symbolControl) throws Exception_SchemaInfo {
            super(executeInfo, Schema_for_SchemaForSchema__SchemaInfoDesc_FieldTypes.this); // want to pass the outer object reference.

            //  this is not setup in the super obj's constructor (SchemaInfo_FieldSet). It is setup and used in its initialize() method.
            //  So set it here.
            super.symbolControl = symbolControl;

            //  Set up the schemaInfoField for fieldnames. there will be just one continuation field returning Strings

            schemaInfoField_FieldTypes = new SchemaInfo_Field(executeInfo, 0, this, SchemaConstants.Schema_4_Schema4Schema__FieldName_for_FieldTypes,
                    MPSymbols.ContinuationType$__$Symbol, symbolControl, null, null);


            schemaInfoFields_List.add(schemaInfoField_FieldTypes);
            schemaInfoFields_Index.put(SchemaConstants.Schema_4_Schema4Schema__FieldName_for_FieldTypes, schemaInfoField_FieldTypes);

            num_NonContinuationFields = 0;
            num_AllFields = 1;
            has_ContinuationField = true;
            max_FieldSet_Size = 1;
        }


    }
}
