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

import net.unconventionalthinking.matrix.Descriptor;
import net.unconventionalthinking.matrix.MatrixFlattened_Descriptor;
import net.unconventionalthinking.matrix.MatrixStructInfoBuilder__builds_DescActualAndDescFlattened;
import net.unconventionalthinking.matrix.MatrixStructInfoType;



/**
 *
 * @author peterjoh
 */
public class DescriptorAccess_ChildAccessSettings {

    public Descriptor                   parent_DescriptorActual;
    public MatrixFlattened_Descriptor   parent_DescriptorFlattened;

    public String                       parent_OutExpression;
    public boolean                      parent_OutExpression_Is_OutVar;


    //  Private Var

    //  only access though get & set methods:
    private boolean                     have_ParentMatrixUsageDescriptor;
    private MatrixStructInfoType        accessUsing_MatrixUsageDesc_Type;




    public void copyValues(DescriptorAccess_ChildAccessSettings src_ChildAccessSettings) {
        
        this.parent_DescriptorActual = src_ChildAccessSettings.parent_DescriptorActual;
        this.parent_DescriptorFlattened = src_ChildAccessSettings.parent_DescriptorFlattened;
        this.have_ParentMatrixUsageDescriptor = src_ChildAccessSettings.have_ParentMatrixUsageDescriptor;
        this.accessUsing_MatrixUsageDesc_Type = src_ChildAccessSettings.accessUsing_MatrixUsageDesc_Type;

        this.parent_OutExpression = src_ChildAccessSettings.parent_OutExpression;
        this.parent_OutExpression_Is_OutVar = src_ChildAccessSettings.parent_OutExpression_Is_OutVar;
    }



    public void set_HaveParentMatrixUsageDescriptor(boolean have_MatrixUsageDescriptor) {
        this.have_ParentMatrixUsageDescriptor = have_MatrixUsageDescriptor;
    }
    public void determine_HaveParentMatrixUsageDescriptor() {
        this.have_ParentMatrixUsageDescriptor = (parent_DescriptorActual != null || parent_DescriptorFlattened != null);
    }
    public void clearAll_ParentMatrixUsageDescriptor_Settings() {
        have_ParentMatrixUsageDescriptor = false;
        parent_DescriptorActual = null;
        parent_DescriptorFlattened = null;
    }
    public boolean has_ParentMatrixUsageDescriptor() { return have_ParentMatrixUsageDescriptor; }





    public void determine_MatrixUsageDescriptor_Type_for_ContinuedAccess() {
        // for right now, it's always descriptor Flattened
        accessUsing_MatrixUsageDesc_Type = MatrixStructInfoType.DescriptorFlattened;
    }

    public void determine_MatrixUsageDescriptor_Type_for_RootAccess(DescriptorAccess_ChildAccessInfo curr_ChildAccessInfo) {
        determine_MatrixUsageDescriptor_Type(null, null, curr_ChildAccessInfo, false, false);
    }
    /**
     * The basic rules for which type of MatrixUsageDescriptor to pick is done using the following rules:
     * 1. If you creating a matrix access for a matrix access state, then always use the flattened matrix (except for if it's the root access)
     * 
     * 2. Access the descriptor_Actual until you hit a 'static access with dyn label" access. Here, use the descriptor_Flattened instead
     * 3. But, if you're currently doing descriptor_Flattened, and you hit a static label access, move back to using the descriptor_Actual
     * 4. If none of the above rules apply, just continue on with the previous access.
     */
    public void determine_MatrixUsageDescriptor_Type(DescriptorAccess_ChildAccessInfo prev_ChildAccessInfo,
            DescriptorAccess_ChildAccessSettings prev_ChildAccessSettings, DescriptorAccess_ChildAccessInfo curr_ChildAccessInfo,
            boolean is_MatrixAccessStateCreation, boolean is_ContinuedAccess) {


        if (is_MatrixAccessStateCreation || is_ContinuedAccess) {
            accessUsing_MatrixUsageDesc_Type = MatrixStructInfoType.DescriptorFlattened;
        
        } else if (prev_ChildAccessInfo == null) { // root access

            if (curr_ChildAccessInfo.is_StaticDescTag_DynLabel_Access()) {
                //  If you hit static descTag w dyn label access, move to using the descriptor flattened
                accessUsing_MatrixUsageDesc_Type = MatrixStructInfoType.DescriptorFlattened;
            } else
                accessUsing_MatrixUsageDesc_Type = MatrixStructInfoType.DescriptorActual;

        } else {

            if (curr_ChildAccessInfo.is_StaticDescTag_DynLabel_Access()) {
                //  If you hit static descTag w dyn label access, move to using the descriptor flattened (if you haven't already done so)
                accessUsing_MatrixUsageDesc_Type = MatrixStructInfoType.DescriptorFlattened;

            } else if (prev_ChildAccessInfo.is_StaticDescTag_DynLabel_Access() &&
                    (curr_ChildAccessInfo.accessExpr1_Is_Static_Label || curr_ChildAccessInfo.accessExpr2_Is_Static_Label) ) {

                //  Was using the flattened matrix, but hit a static label. Move back to using the descriptor actual
                accessUsing_MatrixUsageDesc_Type = MatrixStructInfoType.Get_DescriptorActual_from_DescriptorFlattened;

            } else {
                //  continue on with the same type of access
                accessUsing_MatrixUsageDesc_Type = prev_ChildAccessSettings.accessUsing_MatrixUsageDesc_Type;

            }

        }

    }


    public MatrixStructInfoType get_AccessUsing_MatrixUsageDesc_Type() { return accessUsing_MatrixUsageDesc_Type; }

    public Descriptor getCorrect_MatrixUsageDescriptor() {
        if (have_ParentMatrixUsageDescriptor) {
            switch (accessUsing_MatrixUsageDesc_Type) {
                case DescriptorActual:
                    return parent_DescriptorActual;
                case DescriptorFlattened:
                    return parent_DescriptorFlattened.cast_as_Descriptor();
                default:
                    return null;
            }
        } else {
            return null;
        }

    }




    
}
