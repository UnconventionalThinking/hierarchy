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
public class SchemaInfo_Descriptor_Worker {
    //  We want two ways to access the schemaInfoDescriptor object, through the SchemaInfo_Descriptor interface, and through the
    //  objects base class, Descriptor
    Descriptor              descriptorView;
    SchemaInfo_Descriptor   schemaInfoView;

    /**
     *
     * @param schemaInfo_Positioned
     * @param descriptorTagName_Label   ** for the schemaInfo_Descriptor, you pass in a label for the <b>schemaInfo</b> descTagName!
     *                                  This label is converted into a Descriptor TagName.
     * @param uses_SchemaSet
     * @param parentDescriptor
     */
    public SchemaInfo_Descriptor_Worker(ExecutionInfo executeInfo, SchemaInfo_Descriptor schemaInfoDescriptor) {

        descriptorView = (Descriptor) schemaInfoDescriptor;
        schemaInfoView = schemaInfoDescriptor;


    }

    /**
     * initialize the info in this schemaInfo object, and all its children.
     *
     * Note, this method doesn't do any real initialization at this point. but, leave it here for the future.
     * @param executeInfo
     */
    public void initialize_SchemaInfo(ExecutionInfo executeInfo, SymbolControl symbolControl, SchemaControl_Info schemaControl_Info) throws Exception_SchemaInfo {
        executeInfo.reset();


        if (determine_CanHave_FieldSet(executeInfo)) {
            schemaInfoView.setSchemaInfo_canHave_FieldSet(true);
            schemaInfoView.create_SchemaInfoFieldSet(executeInfo);
            //  init the SchemaInfo_FieldSet
            (schemaInfoView.get_SchemaInfoFieldSet(executeInfo)).initialize_SchemaInfo(executeInfo, symbolControl, schemaControl_Info);

        } else
            schemaInfoView.setSchemaInfo_canHave_FieldSet(false);


        //  call initialize on the child SchemaInfoDesc too
        for (SchemaInfo_Descriptor child_SchemaInfoDescriptor : schemaInfoView.getSchemaInfo_ChildSchemaInfoDesc_List()) {

            child_SchemaInfoDescriptor.initialize_SchemaInfo(executeInfo, symbolControl, schemaControl_Info);
        }

    }

    private boolean determine_CanHave_FieldSet(ExecutionInfo executeInfo) throws Exception_SchemaInfo {

        // check to see if you have FIELD.NAMES and FIELD.TYPES field sets. Also, they must be non-empty and the same size
        FieldSet_Tuple fieldNames_FieldSet;
        FieldSet_Tuple fieldTypes_FieldSet;
        try {
            fieldNames_FieldSet = schemaInfoView.getSchemaInfo_FieldNames_FieldSet(executeInfo);
            fieldTypes_FieldSet = schemaInfoView.getSchemaInfo_FieldTypes_FieldSet(executeInfo);
        } catch (Exception_Descriptor e) {
            throw new Exception_SchemaInfo("Error trying to get the FIELD.NAMES or FIELD.TYPES descriptors (see inner exception):", e);
        }


        if (fieldNames_FieldSet != null && fieldTypes_FieldSet != null) {
            if (fieldTypes_FieldSet.size() > 0 && fieldNames_FieldSet.size() > 0) {
                return true;

            } else {
                executeInfo.setErrorMessage("Checking over the FIELD.NAMES / FIELD.TYPES descriptor to determine if can have a fieldset, and had an error." +
                        "one of the two descriptors did not have any values!");
                throw new Exception_SchemaInfo(executeInfo.getErrorMessage());
            }

        } else { // no fieldSet
            executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.Result_Empty);
        }

        return false;


    }

    /**
     * This method is both inherited from the Descriptor class, and is apart of the SchemaInfo_Descriptor interface
     *
     * @param executeInfo
     * @param childDescriptor
     * @throws net.unconventionalthinking.matrix.Exception_Descriptor
     */
    public void addSchema_ChildSchemaInfoDescriptor(ExecutionInfo executeInfo, SchemaInfo_Descriptor child_SchemaInfoDescriptor)
            throws Exception_Descriptor {
        executeInfo.reset();

        Descriptor child_DescriptorView = null;

        //  This SchemaInfo_Descriptor should also be a Descriptor obj!
        if (child_SchemaInfoDescriptor instanceof Descriptor) {
            child_DescriptorView = (Descriptor) child_SchemaInfoDescriptor;
        } else {
            Exception_Descriptor e = new Exception_Descriptor("tried to add the child schemaInfoDescriptor but it is not also a Descriptor!");
            executeInfo.setErrorException(e);

            throw e;
        }


        //  Check to see that it has not already been added:
        DescriptorTagName child_SchemaInfoDescTagName = child_SchemaInfoDescriptor.getSchemaInfo_DescriptorTagName();
        if (child_SchemaInfoDescTagName != null) {

            SchemaInfo_Descriptor existingSchemaInfoDescriptor = schemaInfoView.getSchemaInfo_ChildSchemaInfoDescIndex_by_DescTagName().get(child_SchemaInfoDescTagName);

            if (existingSchemaInfoDescriptor == null) {
                //  Now, check to see if it's a "Descriptor" descriptor. if it is, add to child_SchemaInfo_Descriptor Index and List
                if (child_DescriptorView.descTagName.equals(MPSymbols_DescTagName.DESCRIPTOR)) {

                    schemaInfoView.getSchemaInfo_ChildSchemaInfoDesc_List().add(child_SchemaInfoDescriptor);
                    schemaInfoView.getSchemaInfo_ChildSchemaInfoDescIndex_by_DescTagName().
                            put(child_SchemaInfoDescriptor.getSchemaInfo_DescriptorTagName(), child_SchemaInfoDescriptor);
                } else {
                    Exception_Descriptor e = new Exception_Descriptor("tried to add the child schemaInfoDescriptor but its schemaInfo descTag name is not `Descriptor`!");
                    executeInfo.setErrorException(e);

                    throw e;
                }
            } else {
                // if it's already been added, do nothing
            }
        } else {
            Exception_Descriptor e = new Exception_Descriptor("tried to add the child schemaInfoDescriptor but its schemaInfo descTag name is null.");
            executeInfo.setErrorException(e);
        }
    }

    /**
     * This method is both inherited from the Descriptor class, and is apart of the SchemaInfo_Descriptor interface
     *
     * @param executeInfo
     * @param childDescriptor
     * @throws net.unconventionalthinking.matrix.Exception_Descriptor
     */
    public void addSchema_ChildFieldDescriptor(ExecutionInfo executeInfo, Descriptor child_FieldDescriptor)
            throws Exception_Descriptor {
        executeInfo.reset();

        //  See if child descriptor is a field descriptor, like:  FIELD.NAMES
        //  if it is, get its field set and set it to field<fieldtype>_FieldSet

        if (child_FieldDescriptor.descTagName.is_MultiPart_DescTagName()) {
            int childDesc_DescTagID = child_FieldDescriptor.descTagName.getSymbol().ID;

            if (childDesc_DescTagID == ((Symbol)MPSymbols_DescTagName.FIELD$__$NAMES).ID) {
                schemaInfoView.setSchemaInfo_FieldNames_Desc(child_FieldDescriptor);
            } else if (childDesc_DescTagID == ((Symbol)MPSymbols_DescTagName.FIELD$__$TYPES).ID) {
                schemaInfoView.setSchemaInfo_FieldTypes_Desc(child_FieldDescriptor);
            } else if (childDesc_DescTagID == ((Symbol)MPSymbols_DescTagName.FIELD$__$DESC).ID) {
                schemaInfoView.setSchemaInfo_FieldDescription_Desc(child_FieldDescriptor);
            } else if (childDesc_DescTagID == ((Symbol)MPSymbols_DescTagName.FIELD$__$DEFAULTS).ID) {
                schemaInfoView.setSchemaInfo_FieldDefaults_Desc(child_FieldDescriptor);
            } else {
                String fieldDescTagNameString = (child_FieldDescriptor != null && child_FieldDescriptor.descTagName != null) ?
                    child_FieldDescriptor.descTagName.getTagName() : "<null>";
                throw new Exception_Descriptor("Tried to add child schemaInfo, Field descriptor, but it was the wrong descriptor tagName. " +
                        "Expected something like FIELD.NAMES or FIELD.TYPES, but got: " + fieldDescTagNameString);
            }

        }

    }




    public SchemaInfo_Descriptor getChild_SchemaInfoDescriptor(ExecutionInfo executeInfo, DescriptorTag find_SchemaInfo_DescTag) {

        if (find_SchemaInfo_DescTag.getSchemaName_Full() != schemaInfoView.getSchemaInfo_SchemaNameFull()) {
            executeInfo.addResultsInfo_EmptyResultSet();
            return null;

        } else
            return (SchemaInfo_Descriptor) findChild_SchemaInfo(executeInfo, SchemaInfoProperty_Type.Descriptor, SearchType.SearchOnlyOneLevel,
                    ((DescriptorTag_MultiLevel)find_SchemaInfo_DescTag).descTagName, SchemaInfoProperty.None);
    }
    public SchemaInfo_Descriptor getChild_SchemaInfoDescriptor(ExecutionInfo executeInfo, DescriptorTag find_SchemaInfo_DescTag,
            SearchType searchType) {

        if (find_SchemaInfo_DescTag.getSchemaName_Full() != schemaInfoView.getSchemaInfo_SchemaNameFull()) {
            executeInfo.addResultsInfo_EmptyResultSet();
            return null;

        } else
            return (SchemaInfo_Descriptor) findChild_SchemaInfo(executeInfo, SchemaInfoProperty_Type.Descriptor, searchType,
                    ((DescriptorTag_MultiLevel)find_SchemaInfo_DescTag).descTagName, SchemaInfoProperty.None);
    }


    public SchemaInfo_Descriptor getChild_SchemaInfoDescriptor(ExecutionInfo executeInfo, DescriptorTagName find_SchemaInfo_DescTagName) {
        return (SchemaInfo_Descriptor) findChild_SchemaInfo(executeInfo, SchemaInfoProperty_Type.Descriptor, SearchType.SearchOnlyOneLevel,
                find_SchemaInfo_DescTagName, SchemaInfoProperty.None);
    }

    public SchemaInfo_Descriptor getChild_SchemaInfoDescriptor(ExecutionInfo executeInfo, DescriptorTagName find_SchemaInfo_DescTagName,
            SearchType searchType) {
        return (SchemaInfo_Descriptor) findChild_SchemaInfo(executeInfo, SchemaInfoProperty_Type.Descriptor, searchType,
                find_SchemaInfo_DescTagName, SchemaInfoProperty.None);
    }

    public SchemaInfo findChild_SchemaInfo(ExecutionInfo executeInfo, SchemaInfoProperty_Type find_schemaInfo_Type, SearchType searchType,
            DescriptorTagName find_SchemaInfo_DescTagName, SchemaInfoProperty filter_SchemaInfo_Property) {
        executeInfo.reset();

        if (find_schemaInfo_Type == SchemaInfoProperty_Type.Descriptor) {

            boolean haveFound_ChildDescriptor = false;

            //  First, search child schemaInfo_descriptors
            SchemaInfo_Descriptor found_SchemaInfoDescriptor =
                    schemaInfoView.getSchemaInfo_ChildSchemaInfoDescIndex_by_DescTagName().get(find_SchemaInfo_DescTagName);

            if (found_SchemaInfoDescriptor != null) {
                if (filter_SchemaInfo_Property == SchemaInfoProperty.Addable) {
                    /*FIX*/
                    // nothing done here yet!
                }

                haveFound_ChildDescriptor = true;

            } else {

                //  now, search nested levels by calling findChild() on each children
                if (searchType == SearchType.SearchAllNestedLevels) {


                    Iterator<Descriptor> childSchemaInfoDescriptors_iter = descriptorView.childDescriptors.iterator();

                    while (childSchemaInfoDescriptors_iter.hasNext() && !haveFound_ChildDescriptor) {
                        SchemaInfo_Descriptor childSchemaInfoDesc = (SchemaInfo_Descriptor) childSchemaInfoDescriptors_iter.next();

                        found_SchemaInfoDescriptor = (SchemaInfo_Descriptor) childSchemaInfoDesc.findChild_SchemaInfo(executeInfo,
                                find_schemaInfo_Type, searchType, find_SchemaInfo_DescTagName, filter_SchemaInfo_Property);

                        if (found_SchemaInfoDescriptor != null && executeInfo.hadEmptyResultSet() != true) {
                            haveFound_ChildDescriptor = true;
                        }
                    }
                }


            }

            if (haveFound_ChildDescriptor) {
                return found_SchemaInfoDescriptor;
            } else {
                executeInfo.addResultsInfo_EmptyResultSet();
                return null;
            }
        }

        executeInfo.addResultsInfo_EmptyResultSet();
        executeInfo.set_HadError();
        executeInfo.setErrorMessage("You tried to use features on this method that were not supported yet.");
        return null;
    }








    public Descriptor getChild_FieldDescriptor(ExecutionInfo executeInfo, DescriptorTagName field_DescTagName)
            throws Exception_Descriptor {


        if (field_DescTagName.is_MultiPart_DescTagName()) {
            int childDesc_DescTagID = field_DescTagName.getSymbol().ID;

            if (childDesc_DescTagID == ((Symbol)MPSymbols_DescTagName.FIELD$__$NAMES).ID) {
                return (schemaInfoView.getSchemaInfo_FieldNames_Desc());
            } else if (childDesc_DescTagID == ((Symbol)MPSymbols_DescTagName.FIELD$__$TYPES).ID) {
                return (schemaInfoView.getSchemaInfo_FieldTypes_Desc());
            } else if (childDesc_DescTagID == ((Symbol)MPSymbols_DescTagName.FIELD$__$DESC).ID) {
                return (schemaInfoView.getSchemaInfo_FieldDescription_Desc());
                } else if (childDesc_DescTagID == ((Symbol)MPSymbols_DescTagName.FIELD$__$DEFAULTS).ID) {
                return (schemaInfoView.getSchemaInfo_FieldDefaults_Desc());
            } else {
                throw new Exception_Descriptor("Tried to add child field descriptor, but it didn't have a `FIELD`.<?> d");
            }

        } else {
            return null;
        }
    }

    public SchemaInfo getParent_SchemaInfo(ExecutionInfo executeInfo) {
        executeInfo.reset();

        if (descriptorView.parentDescriptor != null && descriptorView.parentDescriptor.schemaInfo_Positioned != null) {
            return ((SchemaInfo)descriptorView.parentDescriptor);
        } else {
            return null;
        }
    }

    public void getSchemaInfo_DescTagName_FullPath(ExecutionInfo executeInfo, List<Symbol_Base> nameSymbols) {
        executeInfo.reset();

        SchemaInfo parent_SchemaInfo = getParent_SchemaInfo(executeInfo);
        if (parent_SchemaInfo != null) {
            parent_SchemaInfo.getSchemaInfo_DescTagName_FullPath(executeInfo, nameSymbols);
        }


        nameSymbols.add(schemaInfoView.getSchemaInfo_DescriptorTagName());

    }

    public String getSchemaInfo_DescTagName_FullPath_String(ExecutionInfo executeInfo) {
        executeInfo.reset();

        SchemaInfo parent_SchemaInfo = getParent_SchemaInfo(executeInfo);
        if (parent_SchemaInfo != null) {
            return parent_SchemaInfo.getSchemaInfo_DescTagName_FullPath_String(executeInfo) + SymbolConstants.SymbolPath_SymbolSeparator + 
                    schemaInfoView.getSchemaInfo_DescriptorTagName().toString();
        } else {
            return schemaInfoView.getSchemaInfo_DescriptorTagName().toString();
        }
    }

    public String getSchemaInfo_DescTagName_FullPath_IdentFormat(ExecutionInfo executeInfo) {
        executeInfo.reset();

        SchemaInfo parent_SchemaInfo = getParent_SchemaInfo(executeInfo);
        if (parent_SchemaInfo != null) {
            return parent_SchemaInfo.getSchemaInfo_DescTagName_FullPath_IdentFormat(executeInfo) +
                    SymbolConstants.SymbolPath_SymbolSeparator_IdentFormat +
                    schemaInfoView.getSchemaInfo_DescriptorTagName().getTagName_Symbol().name_IdentFormat;
        } else {
            return schemaInfoView.getSchemaInfo_DescriptorTagName().getTagName_Symbol().name_IdentFormat;
        }

    }




}
