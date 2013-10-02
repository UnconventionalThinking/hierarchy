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
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolControl;



/**
 * This MatrixStructInfoBuilder creates a flattened matrix from an actual matrix (actually, it builds the full matrix usage structure with
 * DescriptorContainers).<P>
 *
 * This builder is used for External Matrices/schemas. If you use an external matrix/schema, it does not have a matirx usage structure. you need to
 * create this for each external matrix, and add it to the matrixControl's matrixStructInfo index.
 * @author peterjoh
 */
public class MatrixStructInfoBuilder__buildDescFlattenedFromMatrix extends MatrixStructInfoBuilder {

    Matrix matrix_Actual;

    MatrixStructInfoBuilder__buildDescFlattenedFromMatrix(ExecutionInfo executeInfo, SymbolControl symbolControl, SchemaControl schemaControl,
            MatrixControl matrixControl, boolean creating_StaticMatrixOrSchema) {

        super(executeInfo, symbolControl, schemaControl, matrixControl, creating_StaticMatrixOrSchema);
    }


    public void setMatrix_Actual(Matrix matrix_Actual) { this.matrix_Actual = matrix_Actual; }




    public MatrixStructInfo_DescriptorContainer create_MatrixUsageStructure_FromMatrix(Symbol buildingMatrixElemOrSchemaElem)
        throws Exception_MetaCompilerError {
        
        MatrixStructInfo_DescriptorContainer matrixUsageStructure = create_MatrixUsageStructure_ForDesc(matrix_Actual, null,
                buildingMatrixElemOrSchemaElem);

        return matrixUsageStructure;
    }



    private MatrixStructInfo_DescriptorContainer create_MatrixUsageStructure_ForDesc(Descriptor curr_Desc,
            MatrixStructInfo_DescriptorContainer parent_DescContainer, Symbol buildingMatrixElemOrSchemaElem) 
            throws Exception_MetaCompilerError {

        MatrixStructInfo_DescriptorContainer curr_DescContainer = super.forEachDescriptor__CreateMatrixUsageDescriptor_BasedOnType(curr_Desc,
                parent_DescContainer, buildingMatrixElemOrSchemaElem, (parent_DescContainer == null));
        if (curr_Desc.has_FieldSet())
            super.forEachDescriptor__CreateFieldSetTuple(curr_DescContainer, (curr_Desc.get_FieldSet_Type() == FieldSet.Type.Tuple));

        if (parent_DescContainer != null)
            super.forEachDescriptor__AddChildDescToParent(parent_DescContainer, curr_DescContainer, buildingMatrixElemOrSchemaElem, 
                    curr_Desc.descTagName);

        if (curr_Desc.childDescriptors != null)
            for (Descriptor childDesc : curr_Desc.childDescriptors)
                create_MatrixUsageStructure_ForDesc(childDesc, curr_DescContainer, buildingMatrixElemOrSchemaElem);

        

        return curr_DescContainer;

    }
}
