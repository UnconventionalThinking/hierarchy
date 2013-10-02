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
import java.util.Map;


public interface MatrixFlattened_Descriptor {

    

    /**
     * this childDesc_Flattened may not be the final childDesc_Flattened. It is just a temporary one that holds the current
     * child desc's info. It may just be added to an existing one.
     * If it is just added to an existing one, we need to add this existing one to the child_DescContainer, replacing the temp one.
     *
     * @param executeInfo
     * @param childDescriptor_Flattened_Temp    you pass in the temporary child desc flattened, which may or may not be the final
     * @param childDescriptor_Actual
     * @return                                  returns the final child desc flattened
     */
    public MatrixFlattened_Descriptor addFlattened_ChildDescriptor(ExecutionInfo executeInfo, MatrixFlattened_Descriptor childDescriptor_Flattened_Temp,
            Descriptor childDescriptor_Actual)
            throws Exception_Descriptor;

    /*
     *  *** NORMALLY, when you add a child descriptor to a parent descriptor, you'd call: parentDesc.childIndexes_Add(childDesc), in order to
     *  add the child descriptor to all the parent descriptor's indexes. But, since this is a descriptor flattened,
     *  it doesn't have anything in the 'labels' field. Instead, it uses a 'label_to_DescriptorActual_Index'. So, we have to
     *  go through all the child descriptors in this index and add them manually to all the parent desc label indexes.
     */
    public void childIndexes_AddFlattenedChildDesc(MatrixFlattened_Descriptor childDescriptor_Flattened, 
            boolean performing_CombineFlattenedDescriptors) throws Exception_Descriptor;

    public void combine_FlattenedDescriptors(MatrixFlattened_Descriptor descriptorToAdd_Flattened, Descriptor descriptorToAdd_Actual);

    public MatrixFlattened_Descriptor get_ChildDescriptor_Flattened(ExecutionInfo executeInfo, Label label);

    public MatrixFlattened_Descriptor get_ChildDescriptor_Flattened(ExecutionInfo executeInfo, DescriptorTag descriptorTag, Label label);

    public Map<Label, Descriptor> get_Label_to_DescriptorActual_Index();

    public Descriptor cast_as_Descriptor();


    //  NOTE: if you want to print a flattened matrix, you can call the Descriptor's print(). It supports flattened matrices

}
