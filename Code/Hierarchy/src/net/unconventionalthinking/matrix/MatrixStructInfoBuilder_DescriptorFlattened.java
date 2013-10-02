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
import net.unconventionalthinking.matrix.Descriptor;
import net.unconventionalthinking.matrix.MatrixFlattened_Descriptor;
import net.unconventionalthinking.matrix.MatrixControl;
import net.unconventionalthinking.matrix.SchemaControl;
import net.unconventionalthinking.matrix.SchemaInfo_Descriptor;
import net.unconventionalthinking.matrix.SchemaInfo_Schema;
import net.unconventionalthinking.matrix.MatrixSet;
import net.unconventionalthinking.matrix.metacompiler.codegen.DescriptorCodeGenerator_Utilities;
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
public class MatrixStructInfoBuilder_DescriptorFlattened extends MatrixStructInfoBuilder_DescriptorActual {


    public MatrixStructInfoBuilder_DescriptorFlattened(ExecutionInfo executeInfo, SymbolControl symbolControl, SchemaControl schemaControl,
            MatrixControl matrixControl, boolean creating_StaticMatrixOrSchema) {
        super(executeInfo, symbolControl, schemaControl, matrixControl, creating_StaticMatrixOrSchema);
    }
    

    @Override
    public Descriptor create_Descriptor_BasedOnType(
            DescriptorTagName descTagName, Label label, SchemaInfo_Descriptor descriptor_SchemaInfo, Descriptor parentDesc,
            MatrixSet<SchemaInfo_Schema> usesSchema_Set,Symbol buildingMatrixElemOrSchemaElem, boolean create_InitialMatrixDescriptor)
            throws Exception_MetaCompilerError
        {  throw new UnsupportedOperationException("Do not use this method for this class, use create_MatrixInfoDescriptor_BasedOnType() "); }



    public Descriptor create_MatrixStructInfoDescriptor_BasedOnType(
            DescriptorTagName descTagName, Label label, Descriptor desc_Actual, SchemaInfo_Descriptor descriptor_SchemaInfo, Descriptor parentDesc,
            MatrixSet<SchemaInfo_Schema> usesSchema_Set,
            Symbol buildingMatrixElemOrSchemaElem, boolean create_InitialMatrixDescriptor)
            throws Exception_MetaCompilerError {

        MatrixFlattened_Descriptor descriptor_Flattened = null;

        switch (DescriptorCodeGenerator_Utilities.determine_DescriptorType(buildingMatrixElemOrSchemaElem, create_InitialMatrixDescriptor)) {
            case Matrix:
                try {
                    descriptor_Flattened = matrixControl.matrixFactory.createNew_MatrixFlattened(executeInfo, label, packageName,
                            create_InitialMatrixDescriptor, usesSchema_Set, parentDesc, true);
                } catch (Exception e) {
                    throw new Exception_MetaCompilerError("Tried to create the MatrixStructureInfo Matrix object (for the MetaCompiler version of a matrix) with name, '" +
                            label + "', but had an error.", e);
                }
                break;
                
            case Descriptor:
                try {
                    //  need to pass the descriptor_Actul into the MatrixUsage_Descriptor constructor, so it can setup the label->desc_actual map
                    //  correctly in the flattened desc.
                    descriptor_Flattened = matrixControl.matrixFactory.createNew_MatrixFlattened_Descriptor(executeInfo, descriptor_SchemaInfo, label,
                            desc_Actual, usesSchema_Set, parentDesc);
                } catch (Exception e) {
                    throw new Exception_MetaCompilerError("Tried to create the MatrixStructureInfo Descriptor object (for the MetaCompiler version of a matrix), '" +
                            descTagName + "', but had an error.", e);
                }
                break;


            default:
                throw new Exception_MetaCompilerError("Tried to create some type of descriptor_Flattened object (for the MatrixStructureInfo or in-memory version of the schema)" +
                        " with desc tag name, '" + descTagName + "', but tried to create a descriptor of a type not supported: " +
                        DescriptorCodeGenerator_Utilities.determine_DescriptorType(buildingMatrixElemOrSchemaElem, create_InitialMatrixDescriptor).toString());
        }

        return (Descriptor)descriptor_Flattened;
    }



    /**

     * Call this method to add a child flattenedMatrix-desc to its parent flattenedMatrix-desc.
     *
     * Note, you need to pass in the child actual-desc as well
     * as the child flattenedMatrix-desc. Why? because if the child has a label and is combined with an existing child desc (with the same descTag),
     * then the label->actual-descriptor pair will be added to the existing child's label-to-descActual Map.
     */
    public void add_FlattenedChildDesc_To_Parent(MatrixFlattened_Descriptor parentDesc_Flattened,
            MatrixStructInfo_DescriptorContainer child_DescContainer, Symbol buildingMatrixElemOrSchemaElem, DescriptorTagName descriptorTagName)
        throws Exception_MetaCompilerError {


        //  this childDesc_Flattened may not be the final childDesc_Flattened. It is just a temporary one that holds the current
        //  child desc's info. It may just be added to an existing one.
        //  If it is just added to an existing one, we need to add this existing one to the child_DescContainer, replacing the temp one.
        MatrixFlattened_Descriptor childDesc_Flattened_Temp = child_DescContainer.descriptor_Flattened;
        try {
            if (buildingMatrixElemOrSchemaElem == MPSymbols.BuildingMatrixElement ||
                    buildingMatrixElemOrSchemaElem == MPSymbols.BuildingMatrixElementForSchema) {

                child_DescContainer.descriptor_Flattened = parentDesc_Flattened.addFlattened_ChildDescriptor(
                                                            executeInfo, childDesc_Flattened_Temp, child_DescContainer.descriptor_Actual);
                
            } else { // schema element
                addChildDescToParent((Descriptor)parentDesc_Flattened, child_DescContainer.descriptor_Actual, buildingMatrixElemOrSchemaElem,
                        descriptorTagName);
            }
        } catch (Exception e) {
            Descriptor parentDesc = (parentDesc_Flattened instanceof Descriptor ? (Descriptor) parentDesc_Flattened : null);
            Descriptor childDesc = (childDesc_Flattened_Temp instanceof Descriptor ? (Descriptor) childDesc_Flattened_Temp : null);
            String parentDescTagName = (parentDesc != null) ? parentDesc.getSchemaInfo().getSchemaInfo_DescriptorTagName().getTagName() : "<null>" ;
            String descTagName = (childDesc != null) ? childDesc.getSchemaInfo().getSchemaInfo_DescriptorTagName().getTagName() : "<null>" ;

            throw new Exception_MetaCompilerError("For the flattened, MetaCompiler version of the matrix, tried to add a flattened descriptor" +
                " with descriptor tag name, '" + descTagName + "', to a parent flattened descriptor with descriptor tag name, '" + parentDescTagName +
                "',  but had an error.", e);
        }

    }




}
