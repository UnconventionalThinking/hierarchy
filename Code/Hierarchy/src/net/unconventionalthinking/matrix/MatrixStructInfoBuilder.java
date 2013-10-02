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
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolControl;

/**
 *
 * @author peterjoh
 */
public class MatrixStructInfoBuilder {

    DescriptorTagName   packageName;
    boolean             creating_StaticMatrixOrSchema;

    MatrixControl       matrixControl;

    MatrixStructInfoBuilder_DescriptorFlattened builder_DescFlattened;



    MatrixStructInfoBuilder(ExecutionInfo executeInfo, SymbolControl symbolControl, SchemaControl schemaControl,
            MatrixControl matrixControl, boolean creating_StaticMatrixOrSchema) {

        this.creating_StaticMatrixOrSchema = creating_StaticMatrixOrSchema;
        this.matrixControl = matrixControl;

        builder_DescFlattened = new MatrixStructInfoBuilder_DescriptorFlattened(executeInfo, symbolControl, schemaControl,
                matrixControl, creating_StaticMatrixOrSchema);

    }


    public void setPackageName(DescriptorTagName packageName) {
        this.packageName = packageName;

        builder_DescFlattened.setPackageName(packageName);
    }



    /**
     * This is used by the child classes to create the MatrixUsageDescriptor. It is not a public method, and should only be called by the child
     * classes. It's a worker method. The versions that should be called by client objects are the ones in the child classes.
     *
     * @param parent_DescriptorContainer        for matrix/schema descriptor, you pass in null for the parent Descriptor-Container
     */
    MatrixStructInfo_DescriptorContainer forEachDescriptor__CreateMatrixUsageDescriptor_BasedOnType(
            Descriptor descriptor_Actual,
            MatrixStructInfo_DescriptorContainer parent_DescriptorContainer,
            Symbol buildingMatrixElemOrSchemaElem, boolean create_InitialMatrixDescriptor)
            throws Exception_MetaCompilerError {


        MatrixStructInfo_DescriptorContainer descContainer = new MatrixStructInfo_DescriptorContainer();

        descContainer.descriptor_Actual = descriptor_Actual;

        if (buildingMatrixElemOrSchemaElem == MPSymbols.BuildingMatrixElement) {
            descContainer.descriptor_Flattened = (MatrixFlattened_Descriptor)builder_DescFlattened.create_MatrixStructInfoDescriptor_BasedOnType(
                    descriptor_Actual.descTagName, descriptor_Actual.label, descContainer.descriptor_Actual, descriptor_Actual.schemaInfo_Positioned,
                    (parent_DescriptorContainer != null ? (Descriptor)parent_DescriptorContainer.descriptor_Flattened : null),
                    descriptor_Actual.uses_Schema_Set, buildingMatrixElemOrSchemaElem, create_InitialMatrixDescriptor);


            //  if this is the initial matrix descriptor, add the container to the matrixUsageStructure index
            if (create_InitialMatrixDescriptor)
                matrixControl.matrixFactory.add_MatrixUsageStructure_to_Indexes(descContainer);

        }

        return descContainer;
    }







    public void forEachDescriptor__AddChildDescToParent(MatrixStructInfo_DescriptorContainer parent_DescContainer,
            MatrixStructInfo_DescriptorContainer child_DescContainer,
            Symbol buildingMatrixElemOrSchemaElem, DescriptorTagName descriptorTagName)
        throws Exception_MetaCompilerError {

        if (buildingMatrixElemOrSchemaElem == MPSymbols.BuildingMatrixElement) {
            builder_DescFlattened.add_FlattenedChildDesc_To_Parent(
                    (parent_DescContainer != null ? parent_DescContainer.descriptor_Flattened : null),
                    child_DescContainer, buildingMatrixElemOrSchemaElem, descriptorTagName);
        }

    }



    public void forEachDescriptor__CreateFieldSetTuple(MatrixStructInfo_DescriptorContainer descContainer, boolean fieldSet_Is_Tuple)
        throws Exception_MetaCompilerError {

        if (descContainer.descriptor_Flattened != null)
            builder_DescFlattened.create_FieldSetTuple((Descriptor)descContainer.descriptor_Flattened, fieldSet_Is_Tuple);
    }






}
