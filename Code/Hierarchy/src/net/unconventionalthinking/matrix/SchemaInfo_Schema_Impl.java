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
import java.util.*;

import net.unconventionalthinking.matrix.symbols.*;


/**
 *
 * @author peterjoh
 */
public class SchemaInfo_Schema_Impl extends Schema implements SchemaInfo_Schema {


    SchemaInfo_Descriptor_Worker                        schemaInfoDescriptor_Worker;


    public MatrixName                                   schemaInfo_SchemaNameFull;
    public DescriptorTag                                schemaInfo_DescriptorTag;

    List<SchemaInfo_Descriptor>                         childSchemaInfoDesc_List;
    Map<DescriptorTagName, SchemaInfo_Descriptor>       childSchemaInfoDesc_Index_by_DescTagName;

    Descriptor                                          fieldNames_Desc;
    Descriptor                                          fieldTypes_Desc;
    Descriptor                                          fieldDescription_Desc;
    Descriptor                                          fieldDefaults_Desc;


    SchemaInfo_Schema                                   ancestor_SchemaInfoSchema;


    boolean                                             canHave_FieldSet;
    SchemaInfo_FieldSet                                 schemaInfo_FieldSet;




    /**
     *
     * @param schemaInfo_Positioned
     * @param schemaName_Label   ** for the schemaInfo_Descriptor, you pass in a label for the <b>schemaInfo</b> descriptorTagName!
     *                                  This label is converted into a Descriptor TagName.
     * @param uses_SchemaSet
     * @param parentDescriptor
     */
    public SchemaInfo_Schema_Impl(ExecutionInfo executeInfo, SchemaInfo_Schema schemaInfoSchema_Positioned, 
            Label schemaName_Label, DescriptorTagName packageName, boolean schemaName_IsStaticSymbol,
            MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor, DescriptorControl schema_DescControl)
            throws Exception_SchemaInfo, Exception_Descriptor {

        super(executeInfo, schemaInfoSchema_Positioned, schemaName_Label, packageName, schemaName_IsStaticSymbol, uses_SchemaSet,
                parentDescriptor, schema_DescControl);

        schemaInfoDescriptor_Worker = new SchemaInfo_Descriptor_Worker(executeInfo, this);

        schemaInfo_DescriptorTag = MPSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$SCHEMA;
        try {
            //  Normally, the schemaInfo_DescriptorTagName is set to the label of the Descriptor part of this object. So, you'd get
            //    (descriptorTag) (Label)
            //    SCHEMA 'WebFormSchema'
            //  And, when something asks this schemaInfo_Schema obj what the descTagName is for this, it'd return WebFormSchema (actually, this
            //  isn't too important in Matrices that have schemas, because there are no matrix descriptor's that have a SchemaInfo_Schema as
            //  its schemaInfo)
            //
            //  But, for schemaForSchema, what this looks like as a matrix is:
            //    SCHEMA 'SchemaForSchema'
            //  And, the descriptor that would have this as its schemaInfo object is a Schema:
            //    'Schema' descriptor has a 'SchemaForSchema' SchemaInfo_Schema
            //  But, when the Schema descriptor asks its schemaInfo_Schema for its descTagName (using the schemaInfo_DescTagName() methods), normally
            //  it'll get back 'SchemaForSchema'. This is not what we'd like. So if the SchemaInfo_Schema being created is the SchemaForSchema,
            //  return SCHEMA instead
            if (schemaName_Label == MPSymbols_Label.SCHEMA$95$FOR$95$SCHEMA)
                schemaInfo_SchemaNameFull = MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA;
            else {
                DescriptorTagName schemaName_DescTag = SymbolUtilities.convert_Label_to_DescTagName(schemaName_Label, schema_DescControl.symbolControl);
                schemaInfo_SchemaNameFull = schema_DescControl.symbolControl.multiLevelSymbol_Factory.createNew_SchemaName(packageName, schemaName_DescTag, true);
            }
            
        } catch (Exception e) {
            executeInfo.set_HadError();
            executeInfo.setErrorException(new Exception_SchemaInfo("Tried creating a SchemaInfo_descriptor, converting the descriptor_labelname to a descritorTagName, but had an error.", e));
            throw (Exception_SchemaInfo) executeInfo.getErrorException();
        }

        childSchemaInfoDesc_List = new ArrayList<SchemaInfo_Descriptor>();
        childSchemaInfoDesc_Index_by_DescTagName = new HashMap<DescriptorTagName, SchemaInfo_Descriptor>();

        ancestor_SchemaInfoSchema = SchemaInfoUtilities.find_SchemaInfoSchema_for_SchemaInfoDescriptor(executeInfo, this);


    }



    public void initialize_SchemaInfo(ExecutionInfo executeInfo, SymbolControl symbolControl, SchemaControl_Info schemaControl_Info) throws Exception_SchemaInfo
        { schemaInfoDescriptor_Worker.initialize_SchemaInfo(executeInfo, symbolControl, schemaControl_Info); }


    public void addChild_SchemaInfoDescriptor(ExecutionInfo executeInfo, SchemaInfo_Descriptor childSchemaInfo_Descriptor)
            throws Exception_Descriptor, Exception_SchemaInfo {

        if (!(childSchemaInfo_Descriptor instanceof Descriptor))
            throw new Exception_SchemaInfo("Adding a childSchemaInfo object to his schemaInfo_Descriptor, but the child is not a descriptor!");

        super.add_ChildDescriptor(executeInfo, (Descriptor)childSchemaInfo_Descriptor);
        schemaInfoDescriptor_Worker.addSchema_ChildSchemaInfoDescriptor(executeInfo, childSchemaInfo_Descriptor);

    }
    public void addChild_SchemaInfo_FieldDescriptor(ExecutionInfo executeInfo, Descriptor child_FieldDescriptor)
            throws Exception_Descriptor {

        super.add_ChildDescriptor(executeInfo, child_FieldDescriptor);
        schemaInfoDescriptor_Worker.addSchema_ChildFieldDescriptor(executeInfo, child_FieldDescriptor);
    }




    public void create_SchemaInfoFieldSet(ExecutionInfo executeInfo) {
        schemaInfo_FieldSet = new SchemaInfo_FieldSet(executeInfo, this);
    }
    public SchemaInfo_FieldSet get_SchemaInfoFieldSet(ExecutionInfo executeInfo) {
        return schemaInfo_FieldSet;
    }

    public boolean getSchemaInfo_canHave_FieldSet() {
        return canHave_FieldSet;
    }
    public void setSchemaInfo_canHave_FieldSet(boolean value) {
        canHave_FieldSet = value;
    }






    public SchemaInfo_Descriptor getChild_SchemaInfoDescriptor(ExecutionInfo executeInfo, DescriptorTag find_SchemaInfo_DescTag)
        { return schemaInfoDescriptor_Worker.getChild_SchemaInfoDescriptor(executeInfo, find_SchemaInfo_DescTag); }

    public SchemaInfo_Descriptor getChild_SchemaInfoDescriptor(ExecutionInfo executeInfo, DescriptorTag find_SchemaInfo_DescTag, SearchType searchType) {
        return schemaInfoDescriptor_Worker.getChild_SchemaInfoDescriptor(executeInfo, find_SchemaInfo_DescTag, searchType);
    }
    public SchemaInfo_Descriptor getChild_SchemaInfoDescriptor(ExecutionInfo executeInfo, DescriptorTagName find_SchemaInfo_DescTagName) { return schemaInfoDescriptor_Worker.getChild_SchemaInfoDescriptor(executeInfo, find_SchemaInfo_DescTagName); }
    public SchemaInfo_Descriptor getChild_SchemaInfoDescriptor(ExecutionInfo executeInfo, DescriptorTagName find_SchemaInfo_DescTagName,
            SearchType searchType) {
        return schemaInfoDescriptor_Worker.getChild_SchemaInfoDescriptor(executeInfo, find_SchemaInfo_DescTagName, searchType);
    }
    public List<SchemaInfo_Descriptor> getChild_SchemaInfoDescriptors(ExecutionInfo executeInfo) {
        return childSchemaInfoDesc_List;
    }
    public SchemaInfo findChild_SchemaInfo(ExecutionInfo executeInfo, SchemaInfoProperty_Type find_schemaInfo_Type, SearchType searchType,
            DescriptorTagName find_SchemaInfo_DescTagName, SchemaInfoProperty filter_SchemaInfo_Property) {
        return schemaInfoDescriptor_Worker.findChild_SchemaInfo(executeInfo, find_schemaInfo_Type, searchType,
                                                            find_SchemaInfo_DescTagName, filter_SchemaInfo_Property);
    }


    public SchemaInfo getSchemaInfo_ParentSchemaInfo(ExecutionInfo executeInfo) { return schemaInfoDescriptor_Worker.getParent_SchemaInfo(executeInfo); }

    
    
    /**
     *  Normally, the schemaInfo_DescriptorTagName is set to the label of the Descriptor part of this object. So, you'd get
     *    (descriptorTag) (Label)
     *    SCHEMA 'WebFormSchema'
     *  And, when something asks this schemaInfo_Schema obj what the descTagName is for this, it'd return WebFormSchema (actually, this
     *  isn't too important in Matrices that have schemas, because there are no matrix descriptor's that have a SchemaInfo_Schema as
     *  its schemaInfo)
     *
     *  But, for schemaForSchema, what this looks like as a matrix is:
     *    SCHEMA 'SchemaForSchema'
     *  And, the descriptor that would have this as its schemaInfo object is a Schema:
     *    'Schema' descriptor has a 'SchemaForSchema' SchemaInfo_Schema
     *  But, when the Schema descriptor asks its schemaInfo_Schema for its descTagName (using the schemaInfo_DescTagName() methods), normally
     *  it'll get back 'SchemaForSchema'. This is not what we'd like. So if the SchemaInfo_Schema being created is the SchemaForSchema,
     *  return SCHEMA instead

     * @param executeInfo
     * @param nameSymbols
     */
    public void getSchemaInfo_DescTagName_FullPath(ExecutionInfo executeInfo, List<Symbol_Base> nameSymbols) {
        executeInfo.reset();

        SchemaInfo parent_SchemaInfo = getSchemaInfo_ParentSchemaInfo(executeInfo);
        if (parent_SchemaInfo != null) {
            parent_SchemaInfo.getSchemaInfo_DescTagName_FullPath(executeInfo, nameSymbols);

        }
        nameSymbols.add(getSchemaInfo_SchemaNameFull());


    }
    /**
     * See the javadoc for getSchemaInfo_DescTagName_FullPath()
     * @param executeInfo
     * @return
     */
    public String getSchemaInfo_DescTagName_FullPath_String(ExecutionInfo executeInfo) {
        executeInfo.reset();

        SchemaInfo parent_SchemaInfo = this.getSchemaInfo_ParentSchemaInfo(executeInfo);
        if (parent_SchemaInfo != null) {
            return parent_SchemaInfo.getSchemaInfo_DescTagName_FullPath_String(executeInfo) + SymbolConstants.SymbolPath_SymbolSeparator +
                    getSchemaInfo_SchemaNameFull();
        } else {
            return getSchemaInfo_SchemaNameFull().toString();
        }
    }

    /**
     * See the javadoc for getSchemaInfo_DescTagName_FullPath()
     * @param executeInfo
     * @return
     */
    public String getSchemaInfo_DescTagName_FullPath_IdentFormat(ExecutionInfo executeInfo) {
        executeInfo.reset();

        SchemaInfo parent_SchemaInfo = this.getSchemaInfo_ParentSchemaInfo(executeInfo);
        if (parent_SchemaInfo != null) {
            return parent_SchemaInfo.getSchemaInfo_DescTagName_FullPath_IdentFormat(executeInfo) +
                    SymbolConstants.SymbolPath_SymbolSeparator_IdentFormat +
                    getSchemaInfo_DescriptorTagName().getTagName_Symbol().name_IdentFormat;
        } else {
            return getSchemaInfo_SchemaNameFull().get_Name_IdentFormat();
        }

    }


    public SchemaInfo.Type      getSchemaInfo_SchemaInfoType() { return SchemaInfo.Type.SchemaInfoSchema; }
    public SchemaInfo_Schema    getSchemaInfo__Ancestor_SchemaInfoSchema() { return ancestor_SchemaInfoSchema; }

    public MatrixName           getSchemaInfo_SchemaNameFull() { return schemaInfo_SchemaNameFull; }


    public DescriptorTagName    getSchemaInfo_DescriptorTagName() { return ((DescriptorTag_MultiLevel)schemaInfo_DescriptorTag).descTagName;  }
    public DescriptorTag        getSchemaInfo_DescriptorTag() { return schemaInfo_DescriptorTag;  }

    
    public List<SchemaInfo_Descriptor> getSchemaInfo_ChildSchemaInfoDesc_List() { return childSchemaInfoDesc_List; }
    public Map<DescriptorTagName, SchemaInfo_Descriptor> getSchemaInfo_ChildSchemaInfoDescIndex_by_DescTagName() { return childSchemaInfoDesc_Index_by_DescTagName;  }



    public void setSchemaInfo_FieldNames_Desc(Descriptor fieldNames) { this.fieldNames_Desc = fieldNames;  }
    public void setSchemaInfo_FieldTypes_Desc(Descriptor fieldTypes) { this.fieldTypes_Desc = fieldTypes;  }
    public void setSchemaInfo_FieldDescription_Desc(Descriptor fieldDescription) { this.fieldDescription_Desc = fieldDescription;  }
    public void setSchemaInfo_FieldDefaults_Desc(Descriptor fieldDefaults) { this.fieldDefaults_Desc = fieldDefaults;  }


    public Descriptor getSchemaInfo_FieldNames_Desc(){ return fieldNames_Desc; }
    public Descriptor getSchemaInfo_FieldTypes_Desc(){ return fieldTypes_Desc; }
    public Descriptor getSchemaInfo_FieldDescription_Desc(){ return fieldDescription_Desc; }
    public Descriptor getSchemaInfo_FieldDefaults_Desc(){ return fieldDefaults_Desc; }

    public FieldSet_Tuple getSchemaInfo_FieldNames_FieldSet(ExecutionInfo executeInfo) throws Exception_Descriptor
        { return (fieldNames_Desc != null) ? fieldNames_Desc.get_FieldSet_Tuple(executeInfo) : null;  }
    public FieldSet_Tuple getSchemaInfo_FieldTypes_FieldSet(ExecutionInfo executeInfo) throws Exception_Descriptor
        { return (fieldTypes_Desc != null) ? fieldTypes_Desc.get_FieldSet_Tuple(executeInfo) : null;  }
    public FieldSet_Tuple getSchemaInfo_FieldDescription_FieldSet(ExecutionInfo executeInfo) throws Exception_Descriptor
        { return (fieldDescription_Desc != null) ? fieldDescription_Desc.get_FieldSet_Tuple(executeInfo) : null;  }
    public FieldSet_Tuple getSchemaInfo_FieldDefaults_FieldSet(ExecutionInfo executeInfo) throws Exception_Descriptor
        { return (fieldDefaults_Desc != null) ? fieldDefaults_Desc.get_FieldSet_Tuple(executeInfo) : null;  }

    public Descriptor getSchemaInfo_FieldDescriptor(ExecutionInfo executeInfo, DescriptorTagName field_DescTagName) throws Exception_Descriptor{
        return schemaInfoDescriptor_Worker.getChild_FieldDescriptor(executeInfo, field_DescTagName);
    }



}
