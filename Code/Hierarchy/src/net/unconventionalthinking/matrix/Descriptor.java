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

import net.unconventionalthinking.lang.Boolean_Mutable;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.hierarchy.SchemaSet_ScopeStack;

import java.util.*;
import org.apache.commons.collections.map.MultiValueMap;

/**
 *
 * @author peterjoh
 */
public class Descriptor extends MatrixElement  {



    public enum DescriptorIndex_Type { descTag, descTagName, label, primary_LabelName, secondary_LabelName }


    public final DescriptorTag              descTag;
    public final DescriptorTagName          descTagName;
    public final Label                      label;

    public final int                        descriptorID;
    public final DescriptorControl          descriptorControl;

    MatrixSet<SchemaInfo_Schema>            uses_Schema_Set;

    FieldSet                    fieldSet;
    FieldSet.Type               fieldSet_Type;

    List<Descriptor>            childDescriptors;

    Descriptor                  parentDescriptor;
    SchemaInfo_Descriptor       schemaInfo_Positioned;



    //  Child Descriptor Indexes
    MultiValueMap               childDescIndex_DescTag_NonUnique;
    MultiValueMap               childDescIndex_DescriptorTagName_NonUnique;

    boolean                     use_TwoPartLabel = false;  // TODO - this needs to be an option that you can set. For now, turn off two part labels
    Map<Label, Descriptor>      childDescIndex_LabelName_Unique;
    MultiValueMap               childDescIndex_LabelPrimaryName_NonUnique;
    MultiValueMap               childDescIndex_LabelSecondaryName_NonUnique;







    /**
     * Should use the MatrixFactory to create descriptors and not call this constructor directly.
     *
     * Auto Generates the descriptorID.
     */
    Descriptor(ExecutionInfo executeInfo, SchemaInfo_Descriptor schemaInfo_Positioned, Label label, MatrixSet<SchemaInfo_Schema> uses_SchemaSet,
            Descriptor parentDescriptor, DescriptorControl descriptorControl) {

        // NOTE: this method could just call the next constructor using "this(..., descriptorControl.descriptorID_GetNextID()", but de-normalized for perf reasons
        executeInfo.reset();

        this.parentDescriptor = parentDescriptor;
        this.schemaInfo_Positioned = schemaInfo_Positioned;
        this.descTag = schemaInfo_Positioned.getSchemaInfo_DescriptorTag();
        this.descTagName = ((DescriptorTag_MultiLevel)descTag).descTagName;
        this.label = label;

        this.uses_Schema_Set = uses_SchemaSet;

        this.descriptorControl = descriptorControl;
        this.descriptorID = descriptorControl.registerNewDesc_GetNextID(this);

    }
    /**
     * Should use the MatrixFactory to create descriptors and not call this constructor directly.
     *
     * For this version of the above method, pass in the descriptorID.
     *
     * @param descriptorID   set descriptor id to -1 if id's are not used for this descriptor
     */
    Descriptor(ExecutionInfo executeInfo, SchemaInfo_Descriptor schemaInfo_Positioned, Label label, MatrixSet<SchemaInfo_Schema> uses_SchemaSet,
            Descriptor parentDescriptor, DescriptorControl descriptorControl, int descriptorID) {

        executeInfo.reset();

        this.parentDescriptor = parentDescriptor;
        this.schemaInfo_Positioned = schemaInfo_Positioned;
        this.descTag = schemaInfo_Positioned.getSchemaInfo_DescriptorTag();
        this.descTagName = ((DescriptorTag_MultiLevel)descTag).descTagName;
        this.label = label;

        this.uses_Schema_Set = uses_SchemaSet;

        this.descriptorControl = descriptorControl;

        this.descriptorID = descriptorID;

        //  usually an id less than 0 is for descriptors that aren't for real matrices. For instance, for Flattened Matrics
        //  don't register these
        if (descriptorID >= 0)
            descriptorControl.registerNewDesc_IncAndSetDescID_IfGreater(descriptorID, this);
    }




    /**
     * Should use the MatrixFactory to create descriptors and not call this constructor directly.
     *
     * Use this constructor if you can't figure out the schema_element at compile time. For instance, if you are building
     * a dynamic matrix.
     *
     * Auto Generates the descriptorID.
     *
     */
    Descriptor(ExecutionInfo executeInfo, DescriptorTag descTag, Label label, MatrixSet<SchemaInfo_Schema> uses_SchemaSet,
            Descriptor parentDescriptor, SchemaSet_ScopeStack schemaSet_ScopeStack, DescriptorControl descriptorControl)
            throws Exception_Descriptor {

        this(executeInfo, descTag, label, uses_SchemaSet, parentDescriptor, schemaSet_ScopeStack, descriptorControl,
                descriptorControl.getNextID__MustRegisterLATER());
    }

    /**
     * Should use the MatrixFactory to create descriptors and not call this constructor directly.
     *
     * Use this constructor if you can't figure out the schema_element at compile time. For instance, if you are building
     * a dynamic matrix.
     *
     * For this version of the above method, pass in the descriptorID.
     *
     * @param descTagName
     * @param label
     * @param uses_SchemaSet
     * @param parentDescriptor
     * @param schemaSet_ScopeStack      The stack of schemaSets that you have seen so far in the parent descriptors
     * @param descriptorControl
     * @param descriptorID
     */
    Descriptor(ExecutionInfo executeInfo, DescriptorTag descTag, Label label, MatrixSet<SchemaInfo_Schema> uses_SchemaSet,
            Descriptor parentDescriptor, SchemaSet_ScopeStack schemaSet_ScopeStack, DescriptorControl descriptorControl, int descriptorID)
            throws Exception_Descriptor {

        executeInfo.reset();

        if (true) throw new Exception_Descriptor("ERROR: this method has not been implemented yet!");

        this.parentDescriptor = parentDescriptor;
        this.label = label;

        //  and the uses_SchemaSet to the schemaSet_ScopeStack:
        schemaSet_ScopeStack.stack.addFirst(uses_SchemaSet);
        this.schemaInfo_Positioned =  SchemaInfoUtilities.find_SchemaInfoDescriptor_in_Stack(executeInfo, this.descTag,
                parentDescriptor.schemaInfo_Positioned, schemaSet_ScopeStack);

        this.descTag = schemaInfo_Positioned.getSchemaInfo_DescriptorTag();
        this.descTagName = ((DescriptorTag_MultiLevel)descTag).descTagName;

        this.descriptorControl = descriptorControl;

        this.descriptorID = descriptorID;
        descriptorControl.registerNewDesc_IncAndSetDescID_IfGreater(descriptorID, this);

    }




    /**
     * returns -1 if id's are not used for this descriptor.
     */
    public int get_DescriptorID() { return descriptorID; }

    public void create_UsesSchemaSet() {
        if (uses_Schema_Set == null)
            uses_Schema_Set = new MatrixSet<SchemaInfo_Schema>();
    }

    public SchemaInfo getSchemaInfo() { return schemaInfo_Positioned; }



    //  ________________________________________________________________________________________________________________
    //
    //    Child & Parent Descriptor Methods
    //  ________________________________________________________________________________________________________________

    public void add_ChildDescriptor(ExecutionInfo executeInfo, Descriptor childDescriptor) throws Exception_Descriptor {

        executeInfo.reset();

        if (childDescriptor == null) {
            executeInfo.set_HadError();
            executeInfo.addErrorInfo(ExecutionInfo.ErrorType.NullArgument);
            executeInfo.setErrorMessage("in add_ChildDescriptor, was passed a null child to add.");
            throw new Exception_Descriptor(executeInfo.getErrorMessage());
        }

        if (DescriptorUtilities.check_ChildDescriptorIsAddable(this, childDescriptor)) {

            if (childDescriptors == null) {
                childDescriptors = new ArrayList<Descriptor>();
                childIndexes_Create();
            }

            //  Check to make sure this child descriptor has been created with this decriptor as its parent!
            if (childDescriptor.parentDescriptor != this)
                throw new Exception_Descriptor("Tried to add a child descriptor of name: " + childDescriptor.descTag + " to the parent descriptor: " +
                        this.descTag + ", but the child descriptor's parent was not set to this parent! it was: " +
                        ((childDescriptor.parentDescriptor != null) ? childDescriptor.parentDescriptor.descTag : null)    );


            childDescriptors.add(childDescriptor);
            childIndexes_Add(childDescriptor);
        }

    }


    public void remove_ChildDescriptor(ExecutionInfo executeInfo, DescriptorTag descriptorTag) {
        remove_ChildDescriptor(get_ChildDescriptor(executeInfo, descriptorTag));
    }
    public void remove_ChildDescriptor(ExecutionInfo executeInfo, DescriptorTagName descriptor_TagName) {
        remove_ChildDescriptor(get_ChildDescriptor(executeInfo, descriptor_TagName));
    }
    public void remove_ChildDescriptor(ExecutionInfo executeInfo, Label label) {
        remove_ChildDescriptor(get_ChildDescriptor(executeInfo, label));
    }
    /**
     * This remove_ChildDescriptor() uses both a label and a desctagName to find the descriptor to remove. Actually, since the label is unique,
     * this is what is used to find the child. But, this method double checks to see if the descriptor tagname matches.
     * tagname matches.
     */
    public void remove_ChildDescriptor(ExecutionInfo executeInfo, DescriptorTagName descTagName, Label label) {
        remove_ChildDescriptor(get_ChildDescriptor(executeInfo, descTagName, label));
    }
    /**
     * This remove_ChildDescriptor() uses both a label and a desctag to find the descriptor to remove. Actually, since the label is unique,
     * this is what is used to find the child. But, this method double checks to see if the descriptor tagname matches.
     */
    public void remove_ChildDescriptor(ExecutionInfo executeInfo, DescriptorTag descriptorTag, Label label) {
        remove_ChildDescriptor(get_ChildDescriptor(executeInfo, descriptorTag, label));
    }

    public Descriptor remove_ChildDescriptor(Descriptor childDescriptor) {
        return remove_ChildDescriptor(childDescriptor.descriptorID);
    }
    public Descriptor remove_ChildDescriptor(int childDescriptorID) {
        //  NOTE!!!: this method is currently very inefficient. We'll move to a doubly-linked, linked list (custom built) later on, which will support
        //  O(c) removal times.

        int foundDesc_Index = -1;
        boolean foundDesc = false;
        Descriptor childDesc = null;
        for (int i = 0; i < childDescriptors.size() && !foundDesc; i++) {
            childDesc = childDescriptors.get(i);
            if (childDesc.descriptorID == childDescriptorID) {
                foundDesc_Index = i;
                foundDesc = true;
            }
        }
        if (foundDesc) {
            childDescriptors.remove(foundDesc_Index);
            childIndexes_Remove(childDesc);

            return childDesc;
        } else {
            return null;
        }

    }



    public boolean insert_ChildDescriptor_InsertAfter(Descriptor insertAfter_ChildDescriptor, Descriptor childDescriptor_to_Insert)
        throws Exception_Descriptor {
        return insert_ChildDescriptor_InsertAfter(insertAfter_ChildDescriptor.descriptorID, childDescriptor_to_Insert);
    }
    public boolean insert_ChildDescriptor_InsertAfter(int insertAfter_ChildDescriptorID, Descriptor childDescriptor_to_Insert)
        throws Exception_Descriptor {
        //  NOTE!!!: this method is currently very inefficient. We'll move to a doubly-linked, linked list (custom built) later on, which will support
        //  O(c) insert times.

        int foundDesc_Index = -1;
        boolean foundDesc = false;
        Descriptor childDesc = null;
        for (int i = 0; i < childDescriptors.size() && !foundDesc; i++) {
            childDesc = childDescriptors.get(i);
            if (childDesc.descriptorID == insertAfter_ChildDescriptorID) {
                foundDesc_Index = i;
                foundDesc = true;
            }
        }


        if (foundDesc) {
            childDescriptors.add(foundDesc_Index + 1, childDescriptor_to_Insert);
            childIndexes_Add(childDescriptor_to_Insert);
            return true;
        } else {
            return false;
        }

    }







    public Descriptor get_ChildDescriptor(ExecutionInfo executeInfo, Symbol_Base descriptorTagName_or_Label) {
        executeInfo.reset();

        if (descriptorTagName_or_Label.getSymbolType() == SymbolType.Label)
            return get_ChildDescriptor(executeInfo, (Label)descriptorTagName_or_Label);
        else if (descriptorTagName_or_Label.getSymbolType() == SymbolType.DescriptorTag)
            return get_ChildDescriptor(executeInfo, (DescriptorTag)descriptorTagName_or_Label);
        else if (descriptorTagName_or_Label.getSymbolType() == SymbolType.DescriptorTagName)
            return get_ChildDescriptor(executeInfo, (DescriptorTagName)descriptorTagName_or_Label);
        else {
            executeInfo.addErrorInfo(ExecutionInfo.ErrorType.Argument_WrongType);
            executeInfo.setErrorMessage("Expected a SymbolType of Label or DescriptorTag, but was passed a type of `" +
                    (descriptorTagName_or_Label != null ? descriptorTagName_or_Label.getSymbolType() : "<null>") + "`.");
            return null;
        }

    }


    public Descriptor get_ChildDescriptor(ExecutionInfo executeInfo, DescriptorTag descriptorTag) {
        executeInfo.reset();

        MatrixSet<Descriptor> foundChildDescriptors = get_ChildDescriptors(executeInfo, DescriptorIndex_Type.descTag, descriptorTag);

        return process_FoundChildDescriptors_forSingleDescriptor(executeInfo, foundChildDescriptors);
    }


    public Descriptor get_ChildDescriptor(ExecutionInfo executeInfo, DescriptorTagName descriptor_TagName) {
        executeInfo.reset();

        MatrixSet<Descriptor> foundChildDescriptors = get_ChildDescriptors(executeInfo, DescriptorIndex_Type.descTagName, descriptor_TagName);

        return process_FoundChildDescriptors_forSingleDescriptor(executeInfo, foundChildDescriptors);
    }




    public Descriptor get_ChildDescriptor(ExecutionInfo executeInfo, Label label) {
        executeInfo.reset();
        return childDescIndex_LabelName_Unique.get(label);
    }


    /**
     * This get_ChildDescriptor() excepts both a label and a desctagname.
     * Actually, since the label is unique, this is what is used to find the child. But, this method double checks to see if the descriptor
     * tagname matches.
     */
    public Descriptor get_ChildDescriptor(ExecutionInfo executeInfo, DescriptorTagName descTagName, Label label) {
        executeInfo.reset();
        Descriptor childDesc = childDescIndex_LabelName_Unique.get(label);
        if (childDesc.descTagName == descTagName)
            return childDesc;
        else {
            executeInfo.addErrorInfo(ExecutionInfo.ErrorType.Desc_DescTagAndLabel_NotMatch);
            return null;
        }
    }

    /**
     * This get_ChildDescriptor() excepts both a label and a desctag. Actually, since the label is unique, this is what is used to
     * find the child. But, this method double checks to see if the descriptor tagname matches.
     */
    public Descriptor get_ChildDescriptor(ExecutionInfo executeInfo, DescriptorTag descriptorTag, Label label) {
        executeInfo.reset();
        Descriptor childDesc = childDescIndex_LabelName_Unique.get(label);
        if (childDesc.descTag == descriptorTag)
            return childDesc;
        else {
            executeInfo.addErrorInfo(ExecutionInfo.ErrorType.Desc_DescTagAndLabel_NotMatch);
            return null;
        }
    }



    public List<Descriptor> get_ChildDescriptors_List(ExecutionInfo executeInfo) {
        return childDescriptors;
    }
    public int get_ChildDescriptors_Size(ExecutionInfo executeInfo) {
        return (childDescriptors != null ? childDescriptors.size() : 0);
    }
    public MatrixSet<Descriptor> get_ChildDescriptors(ExecutionInfo executeInfo, DescriptorTag descriptorTag) {
        return get_ChildDescriptors(executeInfo, DescriptorIndex_Type.descTag, descriptorTag, null);
    }
    public MatrixSet<Descriptor> get_ChildDescriptors(ExecutionInfo executeInfo, DescriptorTag descriptorTag, MatrixSet<Descriptor> addTo_Set) {
        return get_ChildDescriptors(executeInfo, DescriptorIndex_Type.descTag, descriptorTag, addTo_Set);
    }


    public MatrixSet<Descriptor> get_ChildDescriptors(ExecutionInfo executeInfo, DescriptorTagName descriptor_TagName) {
        return get_ChildDescriptors(executeInfo, DescriptorIndex_Type.descTagName, descriptor_TagName, null);
    }
    public MatrixSet<Descriptor> get_ChildDescriptors(ExecutionInfo executeInfo, DescriptorTagName descriptor_TagName, MatrixSet<Descriptor> addTo_Set) {
        return get_ChildDescriptors(executeInfo, DescriptorIndex_Type.descTagName, descriptor_TagName, addTo_Set);
    }

    public MatrixSet<Descriptor> get_ChildDescriptors(ExecutionInfo executeInfo, String primary_LabelName) {
        if (use_TwoPartLabel)
            return get_ChildDescriptors(executeInfo, DescriptorIndex_Type.primary_LabelName, primary_LabelName, null);
        else
            throw_TwoPartLabel_AccessError(executeInfo);
        return null;
    }
    public MatrixSet<Descriptor> get_ChildDescriptors(ExecutionInfo executeInfo, String primary_LabelName, MatrixSet<Descriptor> addTo_Set) {
        if (use_TwoPartLabel)
            return get_ChildDescriptors(executeInfo, DescriptorIndex_Type.primary_LabelName, primary_LabelName, addTo_Set);
        else
            throw_TwoPartLabel_AccessError(executeInfo);
        return null;
    }

    public MatrixSet<Descriptor> get_ChildDescriptors_by_SecondaryLabelName(ExecutionInfo executeInfo, String secondary_LabelName) {
        if (use_TwoPartLabel)
            return get_ChildDescriptors(executeInfo, DescriptorIndex_Type.secondary_LabelName, secondary_LabelName, null);
        else
            throw_TwoPartLabel_AccessError(executeInfo);
        return null;
    }
    public MatrixSet<Descriptor> get_ChildDescriptors_by_SecondaryLabelName(ExecutionInfo executeInfo, String secondary_LabelName, MatrixSet<Descriptor> addTo_Set) {
        if (use_TwoPartLabel)
            return get_ChildDescriptors(executeInfo, DescriptorIndex_Type.secondary_LabelName, secondary_LabelName, addTo_Set);
        else
            throw_TwoPartLabel_AccessError(executeInfo);
        return null;
    }


    public MatrixSet<Descriptor> get_ChildDescriptors(ExecutionInfo executeInfo, DescriptorIndex_Type indexType, Object key) {
        return get_ChildDescriptors(executeInfo, indexType, key, null);
    }
    public MatrixSet<Descriptor> get_ChildDescriptors(ExecutionInfo executeInfo, DescriptorIndex_Type indexType, Object key,
            MatrixSet<Descriptor> addTo_Set) {

        executeInfo.reset();

        Collection foundDescriptors = null;

        if (indexType == DescriptorIndex_Type.descTag)
            foundDescriptors = childDescIndex_DescTag_NonUnique.getCollection(key);
        else if (indexType == DescriptorIndex_Type.descTagName)
            foundDescriptors = childDescIndex_DescriptorTagName_NonUnique.getCollection(key);
        else if (indexType == DescriptorIndex_Type.primary_LabelName)
            foundDescriptors = childDescIndex_LabelPrimaryName_NonUnique.getCollection(key);
        else if (indexType == DescriptorIndex_Type.secondary_LabelName)
            foundDescriptors = childDescIndex_LabelSecondaryName_NonUnique.getCollection(key);


        //  the MultiValueMap returns a java.util.ArrayList. create a set around this!
        if (foundDescriptors != null) {
            if (addTo_Set != null)
                return addTo_Set.add(foundDescriptors);
            else
                return new MatrixSet<Descriptor>((ArrayList)foundDescriptors);

        } else {
            executeInfo.addResultsInfo_EmptyResultSet();
            return null;
        }
    }



    public FieldSet get_ChildDescriptor_FieldSet(ExecutionInfo executeInfo, DescriptorTag descriptorTag) {
        executeInfo.reset();

        Descriptor foundChildDescriptor = get_ChildDescriptor(executeInfo, descriptorTag);

        if (foundChildDescriptor != null) {
            return foundChildDescriptor.fieldSet;
        } else {
            //  NOTE: appropriate error should have been set in the get_ChildDescriptor method.
            return null;
        }
    }


    public FieldSet get_ChildDescriptor_FieldSet(ExecutionInfo executeInfo, DescriptorTagName descriptor_TagName) {
        executeInfo.reset();

        Descriptor foundChildDescriptor = get_ChildDescriptor(executeInfo, descriptor_TagName);

        if (foundChildDescriptor != null) {
            return foundChildDescriptor.fieldSet;
        } else {
            //  NOTE: appropriate error should have been set in the get_ChildDescriptor method.
            return null;
        }
    }


    public FieldSet get_ChildDescriptor_FieldSet(ExecutionInfo executeInfo, Label label) {
        executeInfo.reset();

        Descriptor foundChildDescriptor = get_ChildDescriptor(executeInfo, label);

        if (foundChildDescriptor != null) {
            return foundChildDescriptor.fieldSet;
        } else {
            //  NOTE: appropriate error should have been set in the get_ChildDescriptor method.
            return null;
        }
    }


    public Descriptor get_ParentDescriptor() { return parentDescriptor; }




    //  ________________________________________________________________________________________________________________
    //
    //    FieldSet Methods
    //  ________________________________________________________________________________________________________________


    public boolean  has_FieldSet() { return fieldSet != null; }
    public FieldSet get_FieldSet() { return fieldSet; }
    public FieldSet.Type get_FieldSet_Type() { return fieldSet_Type; }


    public FieldSet_Tuple get_FieldSet_Tuple(ExecutionInfo executeInfo) throws Exception_Descriptor {
        executeInfo.reset();


        if (schemaInfo_Positioned.getSchemaInfo_canHave_FieldSet()) {
            if (fieldSet == null) {
                //  have the schemaInfo object create you a fieldset

                Boolean_Mutable created_SpecializedFieldSetObject = new Boolean_Mutable(false);
                try {
                fieldSet = schemaInfo_Positioned.get_SchemaInfoFieldSet(executeInfo).create_FieldSet_Tuple(executeInfo, this, created_SpecializedFieldSetObject);
                } catch (Exception_SchemaInfo e) {
                    throw new Exception_Descriptor("Error creating FieldSet (see inner exceptions)", e);
                }
                fieldSet_Type = FieldSet.Type.Tuple;

                if (created_SpecializedFieldSetObject.value == true)
                    executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldSet_CreatedSpecializedFieldSetTuple);
                else
                    executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldSet_CreatedGenericFieldSetTuple);

                return (FieldSet_Tuple)fieldSet;

            } else {
                if (fieldSet_Type == FieldSet.Type.Tuple)
                    return (FieldSet_Tuple)fieldSet;
                else {

                    executeInfo.set_HadError();
                    executeInfo.addResultsInfo_EmptyResultSet();
                    executeInfo.setErrorMessage("Tried to get the fieldset tuple for the descriptor: " + descTag + ", but it has a parameter map!");

                    return null;
                }
            }
        } else {
            executeInfo.addResultsInfo_EmptyResultSet();
            return null;
        }
    }


    public FieldSet_ParameterMap get_FieldSet_ParameterMap(ExecutionInfo executeInfo) throws Exception_Descriptor {
        executeInfo.reset();

        if (schemaInfo_Positioned.getSchemaInfo_canHave_FieldSet()) {
            if (fieldSet == null) {

                //  have the schemaInfo object create you a fieldset
                fieldSet = schemaInfo_Positioned.get_SchemaInfoFieldSet(executeInfo).create_FieldSet_ParameterMap(executeInfo, this);
                fieldSet_Type = FieldSet.Type.ParameterMap;

                return (FieldSet_ParameterMap)fieldSet;

            } else {
                if (fieldSet_Type == FieldSet.Type.ParameterMap)
                    return (FieldSet_ParameterMap)fieldSet;
                else {

                    executeInfo.set_HadError();
                    executeInfo.addResultsInfo_EmptyResultSet();
                    executeInfo.setErrorMessage("Tried to get the fieldset parametermap for the descriptor: " + descTag + ", but it has a fieldset tuple!");

                    return null;
                }
            }

        } else {
            executeInfo.addResultsInfo_EmptyResultSet();
            return null;
        }
    }






    public DescriptorTagName get_DescTagName() { return descTagName; }
    public Label get_Label() { return label; }
    public boolean has_Label() { return label != null; }





    /**
     * Returns the full path of descriptors with their tagnames and labels. The desc tagnames and labels are stored
     * in two side by side arraylists.
     *
     * @param executeInfo
     * @param descTagNames
     * @param labelNames
     */
    public void getFullPath(ExecutionInfo executeInfo, List<DescriptorTagName> descTagNames, List<Label> labelNames) {
        executeInfo.reset();

        if (parentDescriptor != null)
            parentDescriptor.getFullPath(executeInfo, descTagNames, labelNames);

        descTagNames.add(((DescriptorTag_MultiLevel)descTag).descTagName);
        if (has_Label())
            labelNames.add(label);
        else
            labelNames.add(null);
    }



    public void getFullPath_Desc(ExecutionInfo executeInfo, List<Descriptor> fullPath_Descriptors) {
        executeInfo.reset();

        if (parentDescriptor != null)
            parentDescriptor.getFullPath_Desc(executeInfo, fullPath_Descriptors);

        fullPath_Descriptors.add(this);
    }

    public void getFullPath_String(ExecutionInfo executeInfo, StringBuilder strBuilder) {
        executeInfo.reset();

        if (parentDescriptor != null) {
            parentDescriptor.getFullPath_String(executeInfo, strBuilder);
            strBuilder.append(SymbolConstants.SymbolPath_SymbolSeparator);
        }
        strBuilder.append(((DescriptorTag_MultiLevel)descTag).descTagName.getTagName());
        if (has_Label())
            strBuilder.append(" ").append(label.getLabel_Simple());
    }



    /**
     * NOTE: you can call this print on a Flattened matrix, which is useful for debugging
     */
    public void print(StringBuilder strBuilder, int indentationLevel, boolean identify_SchemaInfoObjs) {

        for (int i = 0; i < indentationLevel; ++i)
            strBuilder.append("\t");

        boolean is_ItemDescriptor = (((DescriptorTag_MultiLevel)descTag).descTagName == MPSymbols_DescTagName.ITEM);
        if (!is_ItemDescriptor)
            strBuilder.append(((DescriptorTag_MultiLevel)descTag).descTagName.getTagName());

        if (has_Label()) {
            if (!is_ItemDescriptor)
                strBuilder.append(" ");
            String labelText = getLabelText(indentationLevel);
            strBuilder.append(labelText);
        }
        if (identify_SchemaInfoObjs) {
            if (this instanceof SchemaInfo) {
                strBuilder.append(" (SchemaInfo)");

                SchemaInfo_Descriptor schemaInfoDesc_View = (SchemaInfo_Descriptor)this;
                if (schemaInfoDesc_View.getSchemaInfo_canHave_FieldSet())
                    schemaInfoDesc_View.get_SchemaInfoFieldSet(new ExecutionInfo()).print(strBuilder, indentationLevel + 1);
            }
        }

        if (has_FieldSet())
            fieldSet.print(strBuilder, indentationLevel);

        strBuilder.append("\n");

        if (childDescriptors != null)
            for (Descriptor descriptor : childDescriptors)
                descriptor.print(strBuilder, indentationLevel + 1, identify_SchemaInfoObjs);

    }




    public void print_MetaCode(StringBuilder strBuilder, int indentationLevel) { print_MetaCode(strBuilder, indentationLevel, null); }

    /**
     * Use this method print out the matrix/descriptor's matrix metacode. This is useful if you want to write the current matrix to a file.
     *
     * @param strBuilder
     * @param indentationLevel
     * @param matrix_UsesSchemaList     for the matrix descriptor, pass in the matrix uses schema list so they can be included in the matrix's USES clause
     */
    public void print_MetaCode(StringBuilder strBuilder, int indentationLevel, List<String> matrix_UsesSchemaList) {

        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < indentationLevel; ++i)
            indent.append("\t");

        strBuilder.append(indent);

        boolean is_ItemDescriptor = (((DescriptorTag_MultiLevel)descTag).descTagName == MPSymbols_DescTagName.ITEM);
        boolean is_MatrixDescriptor = (((DescriptorTag_MultiLevel)descTag).descTagName == MPSymbols_DescTagName.MATRIX);

        if (!is_ItemDescriptor) {
            if (is_MatrixDescriptor)
                strBuilder.append("MATRIX");
            else
                strBuilder.append(((DescriptorTag_MultiLevel)descTag).get_Name_no_backtiks());
        }

        if (has_Label()) {
            if (!is_ItemDescriptor)
                strBuilder.append(" ");
            if (is_MatrixDescriptor)
                strBuilder.append(label.get_Name_no_backtiks());
            else
                strBuilder.append('+').append(label.getLabel_Simple());
        }


        if (matrix_UsesSchemaList != null && matrix_UsesSchemaList.size() > 0) {
            strBuilder.append(" USES (");
            for (int i = 0; i < matrix_UsesSchemaList.size(); i++) {
                if (i > 0)
                    strBuilder.append(", ");
                strBuilder.append(matrix_UsesSchemaList.get(i));
            }
            strBuilder.append(")");
        }

        if (has_FieldSet())
            fieldSet.print_MetaCode(strBuilder, indentationLevel);


        if (childDescriptors != null) {
            strBuilder.append(" {\n");
            for (Descriptor descriptor : childDescriptors)
                descriptor.print_MetaCode(strBuilder, indentationLevel + 1);
        strBuilder.append(indent).append("}\n");

        } else {
            strBuilder.append(";\n");
        }

    }




    //  ________________________________________________________________________________________________________________
    //
    //    Helper Methods
    //  ________________________________________________________________________________________________________________

    void childIndexes_Create() {

        childDescIndex_DescTag_NonUnique = new MultiValueMap();
        childDescIndex_DescriptorTagName_NonUnique = new MultiValueMap();

        childDescIndex_LabelName_Unique = new HashMap<Label, Descriptor>();

        if (use_TwoPartLabel) {
            childDescIndex_LabelPrimaryName_NonUnique = new MultiValueMap();
            childDescIndex_LabelSecondaryName_NonUnique = new MultiValueMap();
        }
    }



    void childIndexes_Add(Descriptor childDescriptor) throws Exception_Descriptor {

        childDescIndex_DescTag_NonUnique.put(childDescriptor.descTag, childDescriptor);
        childDescIndex_DescriptorTagName_NonUnique.put(((DescriptorTag_MultiLevel)childDescriptor.descTag).descTagName, childDescriptor);


        if (childDescriptor.has_Label()) {
            Descriptor foundDescriptor = childDescIndex_LabelName_Unique.get(childDescriptor.label);

            if (foundDescriptor == null) {
                childDescIndex_LabelName_Unique.put(childDescriptor.label, childDescriptor);
                if (use_TwoPartLabel) {
                    childDescIndex_LabelPrimaryName_NonUnique.put(childDescriptor.label.getPrimaryLabel(false), childDescriptor);

                    if (childDescriptor.label.has_TwoPartLabel())
                        childDescIndex_LabelSecondaryName_NonUnique.put(childDescriptor.label.getSecondaryLabel(), childDescriptor);
                }
            } else {
                // Error!
                String errorMsg = "Tried to add the child descriptor: " +
                        (childDescriptor != null ? childDescriptor.descTag.getDescTagName().getTagName() : " (child descriptor is null!)");
                errorMsg += ", to the parent: " + descTag.getDescTagName().getTagName()
                        + " but had an error. Tried to add it to the labelname-childIndex using the label: " +
                        (childDescriptor != null ? childDescriptor.label : " (child descriptor is null) ") +
                        ", which should be unique, but a descriptor already exists with that label. ";

                throw new Exception_Descriptor(errorMsg);
            }

        }

    }

    void childIndexes_Remove(Descriptor childDescriptor) {
        childDescIndex_DescTag_NonUnique.remove(childDescriptor.descTag, childDescriptor);
        childDescIndex_DescriptorTagName_NonUnique.remove(childDescriptor.descTagName, childDescriptor);

        if (childDescriptor.has_Label()) {
            childDescIndex_LabelName_Unique.remove(childDescriptor.label);
            if (use_TwoPartLabel) {
                childDescIndex_LabelPrimaryName_NonUnique.remove(childDescriptor.label.getPrimaryLabel(false), childDescriptor);
                childDescIndex_LabelSecondaryName_NonUnique.remove(childDescriptor.label.getSecondaryLabel(), childDescriptor);
            }
        }

    }

    private void throw_TwoPartLabel_AccessError(ExecutionInfo executeInfo) {

        StringBuilder fullPath = new StringBuilder();
        getFullPath_String(executeInfo, fullPath);
        throw new ExceptRuntime_DescriptorAccess("Tried to access a descriptor by secondarylabel label, but this descriptor does not have its use_TwoPartLabel setting turned on." +
                "Descriptor Tag's full path is: " + fullPath.toString());
    }


    static Descriptor process_FoundChildDescriptors_forSingleDescriptor(ExecutionInfo executeInfo, MatrixSet<Descriptor> foundChildDescriptors) {
        if (foundChildDescriptors != null) {
            if (foundChildDescriptors.size() < 1) {
                executeInfo.addResultsInfo_EmptyResultSet();
                return null;

            } else if (foundChildDescriptors.size() == 1) {
                return foundChildDescriptors.get(0);
            } else {
                executeInfo.set_HadError();
                executeInfo.addErrorInfo(ExecutionInfo.ErrorType.MoreThanOne_Item_Found);
                return null;
            }

       } else {
            executeInfo.addResultsInfo_EmptyResultSet();
            return null;
       }

    }

    /** The purpose of this method is so that if you print a flattened matrix, it's version of getLabelText() will print out
     *  the entire set of labels. */
    String getLabelText(int indentationLevel) {
        return label.getLabel_Simple();
    }


}
