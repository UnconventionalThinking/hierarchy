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
import net.unconventionalthinking.matrix.Exception_Descriptor;
import net.unconventionalthinking.matrix.Exception_SchemaInfo;
import net.unconventionalthinking.matrix.FieldSet;
import net.unconventionalthinking.matrix.FieldSet_Tuple;
import net.unconventionalthinking.matrix.MatrixControl;
import net.unconventionalthinking.matrix.SchemaControl;
import net.unconventionalthinking.matrix.SchemaInfo_Descriptor;
import net.unconventionalthinking.matrix.SchemaInfo_FieldSet;
import net.unconventionalthinking.matrix.SchemaInfo_Schema;
import net.unconventionalthinking.matrix.MatrixSet;
import net.unconventionalthinking.matrix.metacompiler.codegen.DescriptorCodeGenerator_Utilities;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.MPSymbols_DescTagName;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import java.util.List;



/**
 * The purpose of this class is for the metacompiler to use to build the actual matrix or schema so the metacompiler
 * can reference it.
 *
 * @author peterjoh
 */
public class MatrixStructInfoBuilder_DescriptorActual {


    ExecutionInfo executeInfo;
    SymbolControl symbolControl;
    SchemaControl schemaControl;
    MatrixControl matrixControl;

    DescriptorTagName packageName;
    boolean           creating_StaticMatrixOrSchema;


    public MatrixStructInfoBuilder_DescriptorActual(ExecutionInfo executeInfo, SymbolControl symbolControl, SchemaControl schemaControl,
            MatrixControl matrixControl, boolean creating_StaticMatrixOrSchema) {
        this.executeInfo = executeInfo;
        this.symbolControl = symbolControl;
        this.schemaControl = schemaControl;
        this.matrixControl = matrixControl;

        this.creating_StaticMatrixOrSchema = creating_StaticMatrixOrSchema;

    }


    public void setPackageName(DescriptorTagName packageName) {
        this.packageName = packageName;
    }



    /**
     *
     * @param parentDesc   pass null for matrix/schema descriptors.
     */
    public Descriptor create_Descriptor_BasedOnType(
            DescriptorTagName descTagName, Label label, SchemaInfo_Descriptor descriptor_SchemaInfo, Descriptor parentDesc, 
            MatrixSet<SchemaInfo_Schema> usesSchema_Set,
            Symbol buildingMatrixElemOrSchemaElem, boolean create_InitialMatrixDescriptor)
            throws Exception_MetaCompilerError {

        
        Descriptor descriptor = null;

        switch (DescriptorCodeGenerator_Utilities.determine_DescriptorType(buildingMatrixElemOrSchemaElem, create_InitialMatrixDescriptor)) {
            case Schema:
                try {
                    descriptor = (Descriptor)schemaControl.schemaFactory.createNew_Schema(executeInfo, label, packageName, create_InitialMatrixDescriptor,
                            usesSchema_Set, parentDesc, true);
                } catch (Exception e) {
                    throw new Exception_MetaCompilerError("Tried to create the schema descriptor object (for the MetaCompiler version of a Schema) with name, '" +
                            label + "', but had an error.", e);
                }
                break;

            case SchemaInfo_Descriptor:
                try {
                    descriptor = (Descriptor)schemaControl.schemaFactory.createNew_SchemaInfoDescriptor(executeInfo, descriptor_SchemaInfo,
                            label, usesSchema_Set, parentDesc);
                } catch (Exception_SchemaInfo e) {
                    throw new Exception_MetaCompilerError("Tried to create a SchemaInfo Descriptor object (for the MetaCompiler version of a Schema), with descriptor TagName, '" +
                            descTagName + "', and label name, " + label + ", but had an error.", e);
                }
                break;

            case Matrix:
                try {
                    descriptor = (Descriptor)matrixControl.matrixFactory.createNew_Matrix(executeInfo, label, packageName, create_InitialMatrixDescriptor,
                            usesSchema_Set, parentDesc, true);
                } catch (Exception e) {
                    throw new Exception_MetaCompilerError("Tried to create the Matrix descriptor object (for the MetaCompiler version of a matrix) with name, '" + 
                            label + "', but had an error.", e);
                }
                break;

            case Descriptor:
                try {
                    descriptor = matrixControl.matrixFactory.createNew_Descriptor(executeInfo, descriptor_SchemaInfo, label,
                            usesSchema_Set, parentDesc);
                } catch (Exception e) {
                    throw new Exception_MetaCompilerError("Tried to create the descriptor object (for the MetaCompiler version of a matrix), '" +
                            descTagName + "', but had an error.", e);
                }
                break;


            default:
                throw new Exception_MetaCompilerError("Tried to create some type of descriptor object (for the matrix-usage structure or in-memory version of the schema)" +
                        " with desc tag name, '" + descTagName + "', but tried to create a descriptor of a type not supported: " +
                        DescriptorCodeGenerator_Utilities.determine_DescriptorType(buildingMatrixElemOrSchemaElem, create_InitialMatrixDescriptor).toString());

        }
        return descriptor;
    }




    /**
     * For Metacompiler matrix, don't need to actually add values to the descriptor_actual's fieldset, just create the fieldset itself.
     * 
     * @param descriptor
     * @param fieldSet_Is_Tuple
     * @throws Exception_MetaCompilerError
     */
    public void create_FieldSetTuple(Descriptor descriptor, boolean fieldSet_Is_Tuple)
        throws Exception_MetaCompilerError {

        try {
            //  Call get fieldSet simply to create a fieldset
            FieldSet fieldSet;
            if (fieldSet_Is_Tuple)
                fieldSet = descriptor.get_FieldSet_Tuple(executeInfo);
            else
                fieldSet = descriptor.get_FieldSet_ParameterMap(executeInfo);

        } catch (Exception_Descriptor e) {
            String descTagName = (descriptor != null) ? descriptor.getSchemaInfo().getSchemaInfo_DescriptorTagName().getTagName() : "<null>" ;
            throw new Exception_MetaCompilerError("Tried to create a field set tuple for a descriptor object (for the MetaCompiler version of a matrix)" +
                " with desc tag name, '" + descTagName + "', but had an error", e);
        }
    }


    /**
     * Determine the correct addChildDesc() method to use based on whether it's a schemaInfo_Desc your adding, or just a standard descriptor, or
     * if it's a FIELD.* object being added to a schema
     */
    public void addChildDescToParent(Descriptor parentDesc, Descriptor descriptor, Symbol buildingMatrixElemOrSchemaElem,
            DescriptorTagName descriptorTagName)
        throws Exception_MetaCompilerError {
        try {
            if (buildingMatrixElemOrSchemaElem == MPSymbols.BuildingMatrixElement ||
                    buildingMatrixElemOrSchemaElem == MPSymbols.BuildingMatrixElementForSchema) {
                parentDesc.add_ChildDescriptor(executeInfo, descriptor);

            } else { // adding schema descriptors
                if (descriptorTagName == MPSymbols_DescTagName.DESCRIPTOR)
                    ((SchemaInfo_Descriptor)parentDesc).addChild_SchemaInfoDescriptor(executeInfo, (SchemaInfo_Descriptor)descriptor);
                else if (descriptorTagName.getDescTagName_AtPartNum(1) == MPSymbols_DescTagName.FIELD)  //  This is a FIELD.* descriptor, like FIELD.NAMES
                    ((SchemaInfo_Descriptor)parentDesc).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor);
                else
                parentDesc.add_ChildDescriptor(executeInfo, descriptor);
            }

        } catch (Exception e) {
            String parentDescTagName = (parentDesc != null) ? parentDesc.getSchemaInfo().getSchemaInfo_DescriptorTagName().getTagName() : "<null>" ;
            String descTagName = (descriptor != null) ? descriptor.getSchemaInfo().getSchemaInfo_DescriptorTagName().getTagName() : "<null>" ;
            
            throw new Exception_MetaCompilerError("For the MetaCompiler version of a matrix, tried to add a descriptor" +
                " with descriptor tag name, '" + descTagName + "', to a parent with descriptor tag name, '" + parentDescTagName +
                "',  but had an error.", e);
        }

    }

}
