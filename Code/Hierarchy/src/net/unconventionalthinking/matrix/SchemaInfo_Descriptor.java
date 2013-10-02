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
import net.unconventionalthinking.matrix.symbols.*;

import java.util.*;

/**
 *
 * @author peterjoh
 */
public interface SchemaInfo_Descriptor extends SchemaInfo {



    /**
     * This version of add_ChildDescriptor is just an overloaded version of the one where you pass in a Descriptor object.
     * BUT, one thing it must also do is check that the schemaInfo_Descriptor object is an instance of Descriptor!!!
     * 
     * @param executeInfo
     * @param childDescriptor
     * @throws net.unconventionalthinking.matrix.Exception_Descriptor
     */
    public void addChild_SchemaInfoDescriptor(ExecutionInfo executeInfo, SchemaInfo_Descriptor child_SchemaInfoDescriptor)
            throws Exception_Descriptor, Exception_SchemaInfo;
    public void addChild_SchemaInfo_FieldDescriptor(ExecutionInfo executeInfo, Descriptor child_FieldDescriptor)
            throws Exception_Descriptor;


    public void create_SchemaInfoFieldSet(ExecutionInfo executeInfo);
    public SchemaInfo_FieldSet get_SchemaInfoFieldSet(ExecutionInfo executeInfo);

    public boolean getSchemaInfo_canHave_FieldSet();
    public void setSchemaInfo_canHave_FieldSet(boolean value);



    public SchemaInfo_Descriptor getChild_SchemaInfoDescriptor(ExecutionInfo executeInfo, DescriptorTag find_SchemaInfo_DescTag);
    public SchemaInfo_Descriptor getChild_SchemaInfoDescriptor(ExecutionInfo executeInfo, DescriptorTag find_SchemaInfo_DescTag,
                                        SearchType searchType);
    public SchemaInfo_Descriptor getChild_SchemaInfoDescriptor(ExecutionInfo executeInfo, DescriptorTagName find_SchemaInfo_DescTagName);
    public SchemaInfo_Descriptor getChild_SchemaInfoDescriptor(ExecutionInfo executeInfo, DescriptorTagName find_SchemaInfo_DescTagName,
                                        SearchType searchType);
    public List<SchemaInfo_Descriptor> getChild_SchemaInfoDescriptors(ExecutionInfo executeInfo);
    

    public SchemaInfo findChild_SchemaInfo(ExecutionInfo executeInfo, SchemaInfoProperty_Type find_schemaInfo_Type, SearchType searchType,
            DescriptorTagName find_DescriptorTagName, SchemaInfoProperty filter_SchemaInfo_Property);



    public List<SchemaInfo_Descriptor> getSchemaInfo_ChildSchemaInfoDesc_List();
    public Map<DescriptorTagName, SchemaInfo_Descriptor> getSchemaInfo_ChildSchemaInfoDescIndex_by_DescTagName();


    public void setSchemaInfo_FieldNames_Desc(Descriptor fieldNames);
    public void setSchemaInfo_FieldTypes_Desc(Descriptor fieldTypes);
    public void setSchemaInfo_FieldDescription_Desc(Descriptor fieldDescription);
    public void setSchemaInfo_FieldDefaults_Desc(Descriptor fieldDefaults);

    public Descriptor getSchemaInfo_FieldNames_Desc();
    public Descriptor getSchemaInfo_FieldTypes_Desc();
    public Descriptor getSchemaInfo_FieldDescription_Desc();
    public Descriptor getSchemaInfo_FieldDefaults_Desc();

    public FieldSet_Tuple getSchemaInfo_FieldNames_FieldSet(ExecutionInfo executeInfo) throws Exception_Descriptor;
    public FieldSet_Tuple getSchemaInfo_FieldTypes_FieldSet(ExecutionInfo executeInfo) throws Exception_Descriptor;
    public FieldSet_Tuple getSchemaInfo_FieldDescription_FieldSet(ExecutionInfo executeInfo) throws Exception_Descriptor;
    public FieldSet_Tuple getSchemaInfo_FieldDefaults_FieldSet(ExecutionInfo executeInfo) throws Exception_Descriptor;

    public Descriptor getSchemaInfo_FieldDescriptor(ExecutionInfo executeInfo, DescriptorTagName field_DescTagName) throws Exception_Descriptor;


    public DescriptorTag getSchemaInfo_DescriptorTag();



}
