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
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolControl;

/**
 *
 * @author peterjoh
 */
public class MatrixStructInfoBuilder__builds_DescActualAndDescFlattened extends MatrixStructInfoBuilder {

    

    MatrixStructInfoBuilder_DescriptorActual builder_DescActual;



    public MatrixStructInfoBuilder__builds_DescActualAndDescFlattened(ExecutionInfo executeInfo, SymbolControl symbolControl, SchemaControl schemaControl,
            MatrixControl matrixControl, boolean creating_StaticMatrixOrSchema) {

        super(executeInfo, symbolControl, schemaControl, matrixControl, creating_StaticMatrixOrSchema);

        builder_DescActual = new MatrixStructInfoBuilder_DescriptorActual(executeInfo, symbolControl, schemaControl,
                matrixControl, creating_StaticMatrixOrSchema);


    }



    @Override
    public void setPackageName(DescriptorTagName packageName) {
        super.setPackageName(packageName);

        builder_DescActual.setPackageName(packageName);
    }




    /**
     * This version of CreateMatrixUsageDescriptor() is used during the matrix/schema building phases of metacompilation. It takes all the elements
     * of a descriptor (like the descTagName, label...) and builds the entire Descriptor Container.
     *
     * @param parent_DescriptorContainer        for matrix/schema descriptor, you pass in null for the parent Descriptor-Container
     */
    public MatrixStructInfo_DescriptorContainer forEachDescriptor__CreateMatrixUsageDescriptor_BasedOnType(
            DescriptorTagName descTagName, Label label, SchemaInfo_Descriptor descriptor_SchemaInfo, 
            MatrixStructInfo_DescriptorContainer parent_DescriptorContainer,
            MatrixSet<SchemaInfo_Schema> usesSchema_Set,
            Symbol buildingMatrixElemOrSchemaElem, boolean create_InitialMatrixDescriptor)
            throws Exception_MetaCompilerError {

        
        MatrixStructInfo_DescriptorContainer descContainer = new MatrixStructInfo_DescriptorContainer();

        descContainer.descriptor_Actual = builder_DescActual.create_Descriptor_BasedOnType(descTagName, label, descriptor_SchemaInfo,
                (parent_DescriptorContainer != null ? parent_DescriptorContainer.descriptor_Actual : null),
                usesSchema_Set, buildingMatrixElemOrSchemaElem, create_InitialMatrixDescriptor);


        if (buildingMatrixElemOrSchemaElem == MPSymbols.BuildingMatrixElement) {
            descContainer.descriptor_Flattened = (MatrixFlattened_Descriptor)builder_DescFlattened.create_MatrixStructInfoDescriptor_BasedOnType(
                    descTagName, label, descContainer.descriptor_Actual, descriptor_SchemaInfo,
                    (parent_DescriptorContainer != null ? (Descriptor)parent_DescriptorContainer.descriptor_Flattened : null),
                    usesSchema_Set, buildingMatrixElemOrSchemaElem, create_InitialMatrixDescriptor);


            //  if this is the initial matrix descriptor, add the container to the matrixUsageStructure index
            if (create_InitialMatrixDescriptor)
                matrixControl.matrixFactory.add_MatrixUsageStructure_to_Indexes(descContainer);

        }
        return descContainer;
    }





    @Override
    public void forEachDescriptor__AddChildDescToParent(MatrixStructInfo_DescriptorContainer parent_DescContainer,
            MatrixStructInfo_DescriptorContainer child_DescContainer,
            Symbol buildingMatrixElemOrSchemaElem, DescriptorTagName descriptorTagName)
        throws Exception_MetaCompilerError {

        builder_DescActual.addChildDescToParent(
                (parent_DescContainer != null ? parent_DescContainer.descriptor_Actual : null),
                child_DescContainer.descriptor_Actual, buildingMatrixElemOrSchemaElem, descriptorTagName);


        super.forEachDescriptor__AddChildDescToParent(parent_DescContainer, child_DescContainer, buildingMatrixElemOrSchemaElem, descriptorTagName);
    }




    @Override
    public void forEachDescriptor__CreateFieldSetTuple(MatrixStructInfo_DescriptorContainer descContainer, boolean fieldSet_Is_Tuple)
        throws Exception_MetaCompilerError {

        builder_DescActual.create_FieldSetTuple(descContainer.descriptor_Actual, fieldSet_Is_Tuple);

        super.forEachDescriptor__CreateFieldSetTuple(descContainer, fieldSet_Is_Tuple);
    }


}
