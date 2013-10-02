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
public class Schema_for_SchemaForSchema__SchemaInfoSchema implements SchemaInfo_Schema  {



    Schema_for_SchemaForSchema__SchemaInfoDescriptor        child_SchemaInfoDescriptor_Schema;
    Schema_for_SchemaForSchema__SchemaInfoDescriptor        child_SchemaInfoDescriptor_Matrix;
    Schema_for_SchemaForSchema__SchemaInfoDescriptor        child_SchemaInfoDescriptor_Item;
    Schema_for_SchemaForSchema__SchemaInfoDescriptor        child_SchemaInfoDescriptor_Descriptor;

    //  This only contains one schemaInfoDescriptor, but is need for one of the methods.
    Map<DescriptorTagName, SchemaInfo_Descriptor>           child_SchemaInfoDescriptor_Index_by_DescTagName;
    List<SchemaInfo_Descriptor>                             child_SchemaInfoDescriptor_List;




    public Schema_for_SchemaForSchema__SchemaInfoSchema(ExecutionInfo executeInfo, DescriptorControl schema_DescControl) throws Exception_SchemaInfo {

        child_SchemaInfoDescriptor_Schema = new Schema_for_SchemaForSchema__SchemaInfoDescriptor(executeInfo, MPSymbols_DescTagName.SCHEMA, this, schema_DescControl);
        child_SchemaInfoDescriptor_Matrix = new Schema_for_SchemaForSchema__SchemaInfoDescriptor(executeInfo, MPSymbols_DescTagName.MATRIX, this, schema_DescControl);
        child_SchemaInfoDescriptor_Item = new Schema_for_SchemaForSchema__SchemaInfoDescriptor(executeInfo, MPSymbols_DescTagName.ITEM, this, schema_DescControl);
        child_SchemaInfoDescriptor_Descriptor = new Schema_for_SchemaForSchema__SchemaInfoDescriptor(executeInfo, MPSymbols_DescTagName.DESCRIPTOR, this, schema_DescControl);

        child_SchemaInfoDescriptor_Index_by_DescTagName = new HashMap<DescriptorTagName, SchemaInfo_Descriptor>();
        child_SchemaInfoDescriptor_Index_by_DescTagName.put(child_SchemaInfoDescriptor_Schema.getSchemaInfo_DescriptorTagName(),
                child_SchemaInfoDescriptor_Schema);
        child_SchemaInfoDescriptor_Index_by_DescTagName.put(child_SchemaInfoDescriptor_Matrix.getSchemaInfo_DescriptorTagName(),
                child_SchemaInfoDescriptor_Matrix);
        child_SchemaInfoDescriptor_Index_by_DescTagName.put(child_SchemaInfoDescriptor_Item.getSchemaInfo_DescriptorTagName(),
                child_SchemaInfoDescriptor_Item);
        child_SchemaInfoDescriptor_Index_by_DescTagName.put(child_SchemaInfoDescriptor_Descriptor.getSchemaInfo_DescriptorTagName(),
                child_SchemaInfoDescriptor_Descriptor);

        child_SchemaInfoDescriptor_List = new ArrayList<SchemaInfo_Descriptor>();
        child_SchemaInfoDescriptor_List.add(child_SchemaInfoDescriptor_Schema);
        child_SchemaInfoDescriptor_List.add(child_SchemaInfoDescriptor_Matrix);
        child_SchemaInfoDescriptor_List.add(child_SchemaInfoDescriptor_Item);
        child_SchemaInfoDescriptor_List.add(child_SchemaInfoDescriptor_Descriptor);

    }



    public void initialize_SchemaInfo(ExecutionInfo executeInfo, SymbolControl symbolControl, SchemaControl_Info schemaControl_Info) throws Exception_SchemaInfo
        {}


    public DescriptorTagName getSchemaInfo_DescriptorTagName() { return MPSymbols_DescTagName.SCHEMA; }
    public DescriptorTag getSchemaInfo_DescriptorTag() {
        return MPSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$SCHEMA;
    }
    public MatrixName getSchemaInfo_SchemaNameFull() {
        return MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA;
    }




    public void addChild_SchemaInfoDescriptor(ExecutionInfo executeInfo, SchemaInfo_Descriptor child_SchemaInfoDescriptor) throws Exception_Descriptor, Exception_SchemaInfo {
        throw new UnsupportedOperationException("You cannot call this operation on the Schema_for_SchemaForSchema__SchemaInfoSchema obj.");
    }

    public void addChild_SchemaInfo_FieldDescriptor(ExecutionInfo executeInfo, Descriptor child_FieldDescriptor) throws Exception_Descriptor {
        throw new UnsupportedOperationException("You cannot call this operation on the Schema_for_SchemaForSchema__SchemaInfoSchema obj.");
    }



    public void create_SchemaInfoFieldSet(ExecutionInfo executeInfo) {
        throw new UnsupportedOperationException("You cannot call this operation on the Schema_for_SchemaForSchema__SchemaInfoSchema obj.");
    }
    public SchemaInfo_FieldSet get_SchemaInfoFieldSet(ExecutionInfo executeInfo) {
        throw new UnsupportedOperationException("You cannot call this operation on the Schema_for_SchemaForSchema__SchemaInfoSchema obj.");
    }

    public FieldSet_Tuple create_FieldSet_Tuple(ExecutionInfo executeInfo, Descriptor parentDescriptor) {
        throw new UnsupportedOperationException("You cannot call this operation on the Schema_for_SchemaForSchema__SchemaInfoSchema obj.");
    }

    public FieldSet_ParameterMap create_FieldSet_ParameterMap(ExecutionInfo executeInfo, Descriptor parentDescriptor) {
        throw new UnsupportedOperationException("You cannot call this operation on the Schema_for_SchemaForSchema__SchemaInfoSchema obj.");
    }
    public boolean getSchemaInfo_canHave_FieldSet() { return false; }
    public void setSchemaInfo_canHave_FieldSet(boolean value) {
        throw new UnsupportedOperationException("You cannot call this operation on the Schema_for_SchemaForSchema__SchemaInfoSchema obj.");
    }


    



    public SchemaInfo_Descriptor getChild_SchemaInfoDescriptor(ExecutionInfo executeInfo, DescriptorTag find_SchemaInfo_DescTag) {
        return (SchemaInfo_Descriptor)findChild_SchemaInfo(executeInfo, SchemaInfoProperty_Type.Descriptor, SearchType.SearchOnlyOneLevel,
                ((DescriptorTag_MultiLevel)find_SchemaInfo_DescTag).descTagName, SchemaInfoProperty.None);
    }
    public SchemaInfo_Descriptor getChild_SchemaInfoDescriptor(ExecutionInfo executeInfo, DescriptorTag find_SchemaInfo_DescTag, SearchType searchType) {
        return (SchemaInfo_Descriptor)findChild_SchemaInfo(executeInfo, SchemaInfoProperty_Type.Descriptor, searchType,
                ((DescriptorTag_MultiLevel)find_SchemaInfo_DescTag).descTagName, SchemaInfoProperty.None);
    }
    /**
     * Can only have one child SchemaInfo_Descriptors, schemaInfoDescriptor_Descriptor!
     *
     * @param executeInfo
     * @param find_SchemaInfo_DescTagName
     * @return
     */
    public SchemaInfo_Descriptor getChild_SchemaInfoDescriptor(ExecutionInfo executeInfo, DescriptorTagName find_SchemaInfo_DescTagName) {
        return (SchemaInfo_Descriptor)findChild_SchemaInfo(executeInfo, SchemaInfoProperty_Type.Descriptor, SearchType.SearchOnlyOneLevel,
                find_SchemaInfo_DescTagName, SchemaInfoProperty.None);
    }

    public SchemaInfo_Descriptor getChild_SchemaInfoDescriptor(ExecutionInfo executeInfo, DescriptorTagName find_SchemaInfo_DescTagName,
                                                                SearchType searchType) {
        return (SchemaInfo_Descriptor)findChild_SchemaInfo(executeInfo, SchemaInfoProperty_Type.Descriptor, searchType,
                find_SchemaInfo_DescTagName, SchemaInfoProperty.None);
    }
    public List<SchemaInfo_Descriptor> getChild_SchemaInfoDescriptors(ExecutionInfo executeInfo) {
        return child_SchemaInfoDescriptor_List;
    }

    public SchemaInfo findChild_SchemaInfo(ExecutionInfo executeInfo, SchemaInfoProperty_Type find_schemaInfo_Type, SearchType searchType,
            DescriptorTagName find_SchemaInfo_DescTagName, SchemaInfoProperty filter_SchemaInfo_Property) {
        executeInfo.reset();

        if (find_schemaInfo_Type == SchemaInfoProperty_Type.Descriptor) {

            if (find_SchemaInfo_DescTagName == MPSymbols_DescTagName.SCHEMA)
                return child_SchemaInfoDescriptor_Schema;
            else if (find_SchemaInfo_DescTagName == MPSymbols_DescTagName.MATRIX)
                return child_SchemaInfoDescriptor_Matrix;
            else if (find_SchemaInfo_DescTagName == MPSymbols_DescTagName.ITEM)
                return child_SchemaInfoDescriptor_Item;
            else if (find_SchemaInfo_DescTagName == MPSymbols_DescTagName.DESCRIPTOR)
                return child_SchemaInfoDescriptor_Descriptor;
            else if (searchType == SearchType.SearchAllNestedLevels &&
                    find_SchemaInfo_DescTagName == MPSymbols_DescTagName.FIELD$__$TYPES)
                return child_SchemaInfoDescriptor_Descriptor.child_SchemaInfoDescriptor_FieldTypes;
            else
                return null;

        } else
            return null;
    }

    public SchemaInfo getSchemaInfo_ParentSchemaInfo(ExecutionInfo executeInfo) {
        return null;
    }

    public void getSchemaInfo_DescTagName_FullPath(ExecutionInfo executeInfo, List<Symbol_Base> nameSymbols) {

        nameSymbols.add(MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA);
    }
    public String getSchemaInfo_DescTagName_FullPath_String(ExecutionInfo executeInfo) {
        return (MPSymbols_DescTagName.SCHEMA.getTagName());
    }
    public String getSchemaInfo_DescTagName_FullPath_IdentFormat(ExecutionInfo executeInfo) {
        return (MPSymbols_DescTagName.SCHEMA.getTagName_Symbol().name_IdentFormat);
    }





    public SchemaInfo.Type getSchemaInfo_SchemaInfoType() {
        return SchemaInfo.Type.SchemaInfoSchema;
    }
    public SchemaInfo_Schema getSchemaInfo__Ancestor_SchemaInfoSchema() {
        return this;
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




}
