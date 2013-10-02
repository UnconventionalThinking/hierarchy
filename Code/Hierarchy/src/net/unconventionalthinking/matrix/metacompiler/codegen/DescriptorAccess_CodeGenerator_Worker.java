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

package net.unconventionalthinking.matrix.metacompiler.codegen;

import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.Descriptor;
import net.unconventionalthinking.matrix.MatrixFlattened_Descriptor;
import net.unconventionalthinking.matrix.MatrixStructInfoType;
import net.unconventionalthinking.matrix.symbols.DescriptorTag;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Label;

/**
 *
 * @author peterjoh
 */
public class DescriptorAccess_CodeGenerator_Worker {

    /** Takes a Descriptor Tag  */
    public static void matrixUsageStruct_GetDescriptor(ExecutionInfo executeInfo, DescriptorTag descTag, 
        DescriptorAccess_ChildAccessSettings currAccessSettings, Descriptor prev_ParentDescriptorActual, Descriptor prev_ParentDescriptorFlattened) {

        currAccessSettings.parent_DescriptorActual =
            (currAccessSettings.get_AccessUsing_MatrixUsageDesc_Type() == MatrixStructInfoType.DescriptorActual ?
                prev_ParentDescriptorActual.get_ChildDescriptor(executeInfo, descTag) : null);
        if (executeInfo.get_HadError())
            return;

        currAccessSettings.parent_DescriptorFlattened = (MatrixFlattened_Descriptor)prev_ParentDescriptorFlattened.get_ChildDescriptor(executeInfo,
                descTag);

    }

    /** Takes a Descriptor TagName */
    public static void matrixUsageStruct_GetDescriptor(ExecutionInfo executeInfo, DescriptorTagName descTagName, 
        DescriptorAccess_ChildAccessSettings currAccessSettings, Descriptor prev_ParentDescriptorActual, Descriptor prev_ParentDescriptorFlattened) {

        currAccessSettings.parent_DescriptorActual =
            (currAccessSettings.get_AccessUsing_MatrixUsageDesc_Type() == MatrixStructInfoType.DescriptorActual ?
                prev_ParentDescriptorActual.get_ChildDescriptor(executeInfo, descTagName) : null);
        if (executeInfo.get_HadError())
            return;

        currAccessSettings.parent_DescriptorFlattened = (MatrixFlattened_Descriptor)prev_ParentDescriptorFlattened.get_ChildDescriptor(executeInfo,
                descTagName);

    }

    /** Takes a Label */
    public static void matrixUsageStruct_GetDescriptor(ExecutionInfo executeInfo, Label label,
        DescriptorAccess_ChildAccessSettings currAccessSettings, Descriptor prev_ParentDescriptorActual, 
        MatrixFlattened_Descriptor prev_ParentDescriptorFlattened) {

        //  To get flattened desc by Label, you need to use a special get_ChildDescriptor_Flattened() method.
        currAccessSettings.parent_DescriptorFlattened = prev_ParentDescriptorFlattened.get_ChildDescriptor_Flattened(executeInfo,
                label);

        if (currAccessSettings.get_AccessUsing_MatrixUsageDesc_Type() == MatrixStructInfoType.Get_DescriptorActual_from_DescriptorFlattened) {
            currAccessSettings.parent_DescriptorActual = currAccessSettings.parent_DescriptorFlattened.get_Label_to_DescriptorActual_Index().get(label);

        } else {
            currAccessSettings.parent_DescriptorActual =
                (currAccessSettings.get_AccessUsing_MatrixUsageDesc_Type() == MatrixStructInfoType.DescriptorActual ?
                    prev_ParentDescriptorActual.get_ChildDescriptor(executeInfo, label) : null);
            if (executeInfo.get_HadError())
                return;
        }
    }


    /** Takes a Descriptor Tag and Label */
    public static void matrixUsageStruct_GetDescriptor(ExecutionInfo executeInfo, DescriptorTag descTag, Label label,
        DescriptorAccess_ChildAccessSettings currAccessSettings, Descriptor prev_ParentDescriptorActual,
        MatrixFlattened_Descriptor prev_ParentDescriptorFlattened) {

        //  To get flattened desc by Label, you need to use a special get_ChildDescriptor_Flattened() method.
        currAccessSettings.parent_DescriptorFlattened = prev_ParentDescriptorFlattened.get_ChildDescriptor_Flattened(executeInfo,
                descTag, label);

        if (currAccessSettings.get_AccessUsing_MatrixUsageDesc_Type() == MatrixStructInfoType.Get_DescriptorActual_from_DescriptorFlattened) {
            currAccessSettings.parent_DescriptorActual = currAccessSettings.parent_DescriptorFlattened.get_Label_to_DescriptorActual_Index().get(label);

        } else {
            currAccessSettings.parent_DescriptorActual =
                (currAccessSettings.get_AccessUsing_MatrixUsageDesc_Type() == MatrixStructInfoType.DescriptorActual ?
                    prev_ParentDescriptorActual.get_ChildDescriptor(executeInfo, descTag, label) : null);
            if (executeInfo.get_HadError())
                return;
        }

    }


    //  _________________________________________________________________________________________________________________________________________
    //
    //   The "GetDescriptorFlattened()" methods
    //   Used for Static access with a dynamic label
    //  _________________________________________________________________________________________________________________________________________

    /** takes a Descriptor Tag */
    public static void matrixUsageStruct_GetDescriptorFlattened(ExecutionInfo executeInfo, DescriptorTag descTag,
        DescriptorAccess_ChildAccessSettings currAccessSettings, Descriptor prev_ParentDescriptorActual, Descriptor prev_ParentDescriptorFlattened) {

        currAccessSettings.parent_DescriptorActual = null;

        currAccessSettings.parent_DescriptorFlattened = (MatrixFlattened_Descriptor)prev_ParentDescriptorFlattened.get_ChildDescriptor(executeInfo,
                descTag);

    }

    /** takes a Descriptor TagName */
    public static void matrixUsageStruct_GetDescriptorFlattened(ExecutionInfo executeInfo, DescriptorTagName descTagName,
        DescriptorAccess_ChildAccessSettings currAccessSettings, Descriptor prev_ParentDescriptorActual, Descriptor prev_ParentDescriptorFlattened) {

        currAccessSettings.parent_DescriptorActual = null;

        currAccessSettings.parent_DescriptorFlattened = (MatrixFlattened_Descriptor)prev_ParentDescriptorFlattened.get_ChildDescriptor(executeInfo,
                descTagName);

    }

    
}
