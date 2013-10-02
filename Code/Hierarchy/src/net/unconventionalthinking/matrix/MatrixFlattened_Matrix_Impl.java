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
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.MatrixName;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.hierarchy.SchemaSet_ScopeStack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;





/**
 * This Matrix is used by the Matrix_Usage structure. The way it works is:
 * When a child flattened-descriptor is added, if an existing child with the same descriptor-tag exists, they are considered the same flattened-descriptor
 * and combined.
 * <p>
 * The way they are comibined is:<br>
 * 1. Union of their schema sets.<br>
 * 2. if a label exists on the new child, add the label to the existing child's label_to_DescriptorActual_Index<br>
 *
 * @author peterjoh
 */
public class MatrixFlattened_Matrix_Impl extends Matrix implements MatrixFlattened_Descriptor {

    Map<Label, Descriptor> label_to_DescriptorActual_Index;



    MatrixFlattened_Matrix_Impl(ExecutionInfo executeInfo, Label matrixName_Label, DescriptorTagName packageName, boolean matrixName_IsStaticSymbol,
        MatrixSet<SchemaInfo_Schema> uses_SchemaSet,
        Descriptor parentDescriptor, SchemaControl schemaControl, DescriptorControl descriptorControl)
        throws Exception_SchemaInfo, Exception_Descriptor {

        super(executeInfo, matrixName_Label, packageName, matrixName_IsStaticSymbol, uses_SchemaSet, parentDescriptor, schemaControl, descriptorControl,
                -1); // no descriptor id!!

        label_to_DescriptorActual_Index = new HashMap<Label, Descriptor>();
    }

    MatrixFlattened_Matrix_Impl(ExecutionInfo executeInfo, Label matrixName_Label, MatrixName matrixName, MatrixSet<SchemaInfo_Schema> uses_SchemaSet,
            Descriptor parentDescriptor, SchemaControl schemaControl, DescriptorControl descriptorControl)
            throws Exception_SchemaInfo, Exception_Descriptor {

        super(executeInfo, matrixName_Label, matrixName, uses_SchemaSet, parentDescriptor, schemaControl, descriptorControl, -1); // no descriptor id!!
        
        label_to_DescriptorActual_Index = new HashMap<Label, Descriptor>();
    }




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
    public MatrixFlattened_Descriptor addFlattened_ChildDescriptor(ExecutionInfo executeInfo,
            MatrixFlattened_Descriptor childDescriptor_Flattened_Temp, Descriptor childDescriptor_Actual)
            throws Exception_Descriptor {

        return MatrixFlattened_Worker.addFlattened_ChildDescriptor(executeInfo, this, childDescriptor_Flattened_Temp, childDescriptor_Actual);
    }
    public void childIndexes_AddFlattenedChildDesc(MatrixFlattened_Descriptor childDescriptor_Flattened, boolean performing_CombineFlattenedDescriptors) throws Exception_Descriptor {
        MatrixFlattened_Worker.childIndexes_AddFlattenedChildDesc(this, childDescriptor_Flattened, performing_CombineFlattenedDescriptors);
    }


    public void combine_FlattenedDescriptors(MatrixFlattened_Descriptor descriptorToAdd_Flattened, Descriptor descriptorToAdd_Actual) {
        MatrixFlattened_Worker.combine_FlattenedDescriptors(this, descriptorToAdd_Flattened, descriptorToAdd_Actual);
    }


    public Map<Label, Descriptor> get_Label_to_DescriptorActual_Index() { return label_to_DescriptorActual_Index; }

    public Descriptor cast_as_Descriptor() { return this; }


    public MatrixFlattened_Descriptor get_ChildDescriptor_Flattened(ExecutionInfo executeInfo, Label label) {
        return MatrixFlattened_Worker.get_ChildDescriptor_Flattened(executeInfo, this, label);
    }

    public MatrixFlattened_Descriptor get_ChildDescriptor_Flattened(ExecutionInfo executeInfo, DescriptorTag descriptorTag, Label label) {
        return MatrixFlattened_Worker.get_ChildDescriptor_Flattened(executeInfo, this, descriptorTag, label);
    }


}
