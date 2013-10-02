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
import net.unconventionalthinking.matrix.symbols.DescriptorTag;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.MPSymbols_DescTag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.unconventionalthinking.matrix.symbols.DescriptorTag_MultiLevel;
import net.unconventionalthinking.matrix.symbols.MPSymbols_DescTagName;

/**
 *
 * @author peterjoh
 */
public class MatrixFlattened_Worker {


    
    public static Map<Label, Descriptor> setup_LabelToDesc_Index(Label label, Descriptor desc_Actual) {

        Map<Label, Descriptor> label_to_DescriptorActual_Index = new HashMap<Label, Descriptor>();

        if (label != null)
            label_to_DescriptorActual_Index.put(label, desc_Actual);

        return label_to_DescriptorActual_Index;
    }


    /**
     * this childDesc_Flattened may not be the final childDesc_Flattened. It is just a temporary one that holds the current
     * child desc's info. It may just be added to an existing one.
     * If it is just added to an existing one, we need to add this existing one to the child_DescContainer, replacing the temp one.
     *
     * @param executeInfo
     * @param parentDescriptor_Flattened
     * @param childDescriptor_Flattened_Temp    you pass in the temporary child desc flattened, which may or may not be the final
     * @param childDescriptor_Actual
     * @return                                  returns the final child desc flattened
     */
    public static MatrixFlattened_Descriptor addFlattened_ChildDescriptor(ExecutionInfo executeInfo,
            MatrixFlattened_Descriptor parentDescriptor_Flattened, MatrixFlattened_Descriptor childDescriptor_Flattened_Temp,
            Descriptor childDescriptor_Actual)
            throws Exception_Descriptor {

        executeInfo.reset();

        if (childDescriptor_Flattened_Temp == null) {
            executeInfo.set_HadError();
            executeInfo.addErrorInfo(ExecutionInfo.ErrorType.NullArgument);
            executeInfo.setErrorMessage("in add_ChildDescriptor, was passed a null child to add.");
            throw new Exception_Descriptor(executeInfo.getErrorMessage());
        }

        Descriptor childDesc = (Descriptor)childDescriptor_Flattened_Temp;
        Descriptor parentDesc = (Descriptor)parentDescriptor_Flattened;

        if (DescriptorUtilities.check_ChildDescriptorIsAddable(parentDesc, childDesc)) {

            if (parentDesc.childDescriptors == null) {
                parentDesc.childDescriptors = new ArrayList<Descriptor>();
                parentDesc.childIndexes_Create();
            }

            //  Check to make sure this child descriptor has been created with this decriptor as its parent!
            if (childDesc.parentDescriptor != parentDesc)
                throw new Exception_Descriptor("Tried to add a child descriptor of name: " + childDesc.descTag + " to the parent descriptor: " +
                        parentDesc.descTag + ", but the child descriptor's parent was not set to this parent! it was: " +
                        ((childDesc.parentDescriptor != null) ? childDesc.parentDescriptor.descTag : null)    );

            //

            //  check for existing descriptor with same descTag
            Descriptor existing_childDesc_Flattened = parentDesc.get_ChildDescriptor(executeInfo, childDesc.descTag);
            if (executeInfo.get_HadError()) {
                throw new Exception_Descriptor("While trying to build the Flattened Matrix, tried to get child descriptor flattened. There should"
                        + "only be one child found, but probably there were mutliple found. This should not happen!! TELL THE DEVELOPER. The child descriptor of name was: " + childDesc.descTag + " with the parent descriptor: " +
                        parentDesc.descTag + ".");
            }

            if (existing_childDesc_Flattened == null) {
                parentDesc.childDescriptors.add(childDesc);
                //  *** NORMALLY, you'd call: parentDesc.childIndexes_Add(childDesc); But since this is a descriptor flattened,
                //  it doesn't have anything in the 'labels' field. Instead, it uses a 'label_to_DescriptorActual_Index'. So, we have to
                //  go through all the child descriptors in this index and add them manually, which is done in this method.
                parentDescriptor_Flattened.childIndexes_AddFlattenedChildDesc(childDescriptor_Flattened_Temp, false);

                return childDescriptor_Flattened_Temp;
                
            } else {
                ((MatrixFlattened_Descriptor)existing_childDesc_Flattened).combine_FlattenedDescriptors(childDescriptor_Flattened_Temp,
                        childDescriptor_Actual);
                //  *** SEE PREV COMMENT - except here, if, in an index, an there's an existing label pointing to a flattened desc, this is
                //  no problem because it should just be the same one. Can re-add it.
                parentDescriptor_Flattened.childIndexes_AddFlattenedChildDesc((MatrixFlattened_Descriptor)existing_childDesc_Flattened, true);

                return (MatrixFlattened_Descriptor)existing_childDesc_Flattened;
            }
        } else
            return childDescriptor_Flattened_Temp;

    }



    /*
     *  *** NORMALLY, when you add a child descriptor to a parent descriptor, you'd call: parentDesc.childIndexes_Add(childDesc), in order to
     *  add the child descriptor to all the parent descriptor's indexes. But, since this is a descriptor flattened,
     *  it doesn't have anything in the 'labels' field. Instead, it uses a 'label_to_DescriptorActual_Index'. So, we have to
     *  go through all the child descriptors in this index and add them manually to all the parent desc label indexes.
     */
    public static void childIndexes_AddFlattenedChildDesc(MatrixFlattened_Descriptor parentDescriptor_Flattened,
            MatrixFlattened_Descriptor childDescriptor_Flattened, boolean performing_CombineFlattenedDescriptors) throws Exception_Descriptor {

        Descriptor parentDescriptor = (Descriptor)parentDescriptor_Flattened;
        Descriptor childDescriptor = (Descriptor)childDescriptor_Flattened;

        //  If this is the first time you're adding in child descriptors to the parent (meaning you're not calling this from a
        //  combineFlattened matrix op), then add the child descriptor to the main one. You really don't want to mess this up
        //  by accidentally adding in the same flattened child descriptor twice! that would be bad!
        if (!performing_CombineFlattenedDescriptors) {
            parentDescriptor.childDescIndex_DescTag_NonUnique.put(childDescriptor.descTag, childDescriptor);
            parentDescriptor.childDescIndex_DescriptorTagName_NonUnique.put(((DescriptorTag_MultiLevel)childDescriptor.descTag).descTagName,
                    childDescriptor);
        }

        //  Usually, at this point in metacompilation, when you're building the flattened matrix,
        //  there is only one label in each childDescriptor_Flattened label-to-desc set. But, maybe in the future they'll be more.
        for (Label childDesc_Label : childDescriptor_Flattened.get_Label_to_DescriptorActual_Index().keySet()) {

            Descriptor foundDescriptor = parentDescriptor.childDescIndex_LabelName_Unique.get(childDesc_Label);

            if (foundDescriptor == null) {
                parentDescriptor.childDescIndex_LabelName_Unique.put(childDesc_Label, childDescriptor);
                
                if (parentDescriptor.use_TwoPartLabel) {
                    parentDescriptor.childDescIndex_LabelPrimaryName_NonUnique.put(childDesc_Label.getPrimaryLabel(false), childDescriptor);

                    if (childDesc_Label.has_TwoPartLabel())
                        parentDescriptor.childDescIndex_LabelSecondaryName_NonUnique.put(childDesc_Label.getSecondaryLabel(), childDescriptor);
                }

            } else if (foundDescriptor != childDescriptor) {  // if one already exists, they should be the same!!
                // Error!
                throw new Exception_Descriptor("Tried to add the flattened child descriptor: " + childDescriptor.descTag.getDescTagName().getTagName() +
                    ", to the flattened parent descriptor: " + parentDescriptor.descTag.getDescTagName().getTagName() + " but had an error. " +
                    "Tried to add it to the labelname-childIndex using the label: " + childDesc_Label +
                    ", but there was another, different flattened child descriptor there already. This should never happen!!!! Tell the developer!!");
            }

        }
    }



    public static void combine_FlattenedDescriptors(MatrixFlattened_Descriptor destDescriptor_Flattened, MatrixFlattened_Descriptor descriptorToAdd_Flattened,
            Descriptor descriptorToAdd_Actual) {

        Descriptor destDesc = (Descriptor)destDescriptor_Flattened;
        Descriptor descToAdd = (Descriptor)descriptorToAdd_Flattened;

        //  Union the schema sets
        if (descToAdd != null && descToAdd.uses_Schema_Set != null && descToAdd.uses_Schema_Set.size() > 0) {
            if (destDesc.uses_Schema_Set == null)
                destDesc.create_UsesSchemaSet();

            destDesc.uses_Schema_Set.union(descToAdd.uses_Schema_Set, true);
        }
        //  if a label exists, add the label to this descriptor's labelToDescriptorActual_index
        if (((Descriptor)descriptorToAdd_Flattened).label != null) {
            destDescriptor_Flattened.get_Label_to_DescriptorActual_Index().put(((Descriptor)descriptorToAdd_Flattened).label, descriptorToAdd_Actual);
        }
    }


    /**
     * This method is interesting in it's how it behaves. Since we're searching for a child descriptor of this descriptor only by _label_,
     * You can't do a simple ((Descriptor)desc_Flattened).get_ChildDescriptor(executeInfo, label);
     * Why? because the current descriptor is a flattened, so it has an empty childDescIndex_LabelName_Unique! we could fill it, but it's a little
     * odd, because we'd have to do it manually when we build the flattened matrix.
     * has an empty
     * @param executeInfo
     * @param desc_Flattened
     * @param label
     * @return
     */
    public static MatrixFlattened_Descriptor get_ChildDescriptor_Flattened(ExecutionInfo executeInfo, MatrixFlattened_Descriptor desc_Flattened,
            Label label) {
        executeInfo.reset();

        MatrixFlattened_Descriptor flattened_Desc = (MatrixFlattened_Descriptor)((Descriptor)desc_Flattened).get_ChildDescriptor(executeInfo,
                label);

        if (flattened_Desc != null && flattened_Desc.get_Label_to_DescriptorActual_Index().containsKey(label))
            return flattened_Desc;
        else
            return null;
    }

    public static MatrixFlattened_Descriptor get_ChildDescriptor_Flattened(ExecutionInfo executeInfo, MatrixFlattened_Descriptor desc_Flattened,
            DescriptorTag descriptorTag, Label label) {
        executeInfo.reset();

        MatrixFlattened_Descriptor flattened_Desc = (MatrixFlattened_Descriptor)((Descriptor)desc_Flattened).get_ChildDescriptor(executeInfo,
                descriptorTag);

        if (flattened_Desc != null && flattened_Desc.get_Label_to_DescriptorActual_Index().containsKey(label))
            return flattened_Desc;
        else
            return null;

    }



}
