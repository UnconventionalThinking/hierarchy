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


import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;
import net.unconventionalthinking.lang.ExecutionInfo;
import java.util.*;

import net.unconventionalthinking.matrix.symbols.*;

/**
 *  DESIGN EXPLANATION:  The reason why we use a Schema Factory here to create a schema object instead of letting the user
 *  create them directly is because there are a lot of classes and interfaces dealing with schema:
 *    class Schema, interface SchemaInfo, interface SchemaInfo_Schema, and class SchemaInfo_Schema_Impl.
 *
 *  So, let the factory deal with what schema related class needs to be newed, and what the return type should be.
 *
 * @author peterjoh
 */
public class SchemaFactory {

    SchemaInfo_Schema schemaForSchema;
    SchemaForSchema_Container schemaForSchema_Container;
    SymbolControl     symbolControl;
    SchemaControl     schemaControl;

    SchemaInfo_Schema matrixBaseSchema;
    SchemaInfo_Schema matrixStdSchema;

    
    public SchemaFactory(SchemaForSchema_Container schemaForSchema_Container, SymbolControl symbolControl, SchemaControl schemaControl) {

        this.schemaForSchema_Container = schemaForSchema_Container;
        this.schemaForSchema = schemaForSchema_Container.schema4Schema;
        this.symbolControl = symbolControl;

        this.schemaControl = schemaControl;

        this.matrixBaseSchema = null;
        this.matrixStdSchema = null;

    }




    /** This version uses the 'Schema for Schema' as it's schemaInfo_Positioned. Also, this version defaults to NOT building a static schema. */
    public final SchemaInfo_Schema createNew_Schema(ExecutionInfo executeInfo, 
            Label schemaName, DescriptorTagName packageName, boolean schemaName_IsStaticSymbol,
            MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor)
            throws Exception_SchemaInfo, Exception_Descriptor {
        return createNew_Schema(executeInfo, schemaForSchema, schemaName, packageName, schemaName_IsStaticSymbol, uses_SchemaSet, parentDescriptor, false);
    }
    /** This version uses the 'Schema for Schema' as it's schemaInfo_Positioned. */
    public final SchemaInfo_Schema createNew_Schema(ExecutionInfo executeInfo, 
            Label schemaName, DescriptorTagName packageName, boolean schemaName_IsStaticSymbol,
            MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor, boolean is_StaticSchema)
            throws Exception_SchemaInfo, Exception_Descriptor {
        return createNew_Schema(executeInfo, schemaForSchema, schemaName, packageName, schemaName_IsStaticSymbol, uses_SchemaSet, parentDescriptor, is_StaticSchema);
    }
    
    public final SchemaInfo_Schema createNew_Schema(ExecutionInfo executeInfo, SchemaInfo_Schema schemaInfoSchema_Positioned, 
            Label schemaName, DescriptorTagName packageName, boolean schemaName_IsStaticSymbol,
            MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor, boolean is_StaticSchema)
            throws Exception_SchemaInfo, Exception_Descriptor {

        SchemaInfo_Schema schema = new SchemaInfo_Schema_Impl(executeInfo, schemaInfoSchema_Positioned, schemaName, packageName, schemaName_IsStaticSymbol, 
                uses_SchemaSet, parentDescriptor, schemaControl.schema_DescControl);

        schemaControl.schemaIndex_Add(schema, is_StaticSchema);
        
        return schema;

    }




    /**
     * This is the base schema that should used to create matrices, meaning it should be added to the schema set scope stack before a new
     * matrices is created.
     *
     * @param executeInfo
     * @return
     * @throws Exception_SchemaInfo
     * @throws Exception_Descriptor
     */
    public SchemaInfo_Schema get_BaseSchema(ExecutionInfo executeInfo) throws Exception_SchemaInfo, Exception_Descriptor {

        if (matrixBaseSchema == null) {
            matrixBaseSchema = createNew_Schema(executeInfo, MPSymbols_Label.MATRIX$__$BASE, MPSymbols_DescTagName.net$__$unconventionalthinking$__$matrix,
                    true, null, null, false);

            matrixBaseSchema.addChild_SchemaInfoDescriptor(executeInfo, createNew_MatrixSchemaInfo(executeInfo, matrixBaseSchema));

        }
        return matrixBaseSchema;
    }
    public SchemaInfo_Descriptor get_BaseSchema_MatrixSchemaInfo(ExecutionInfo executeInfo) throws Exception_SchemaInfo, Exception_Descriptor {
        return get_BaseSchema(executeInfo).getChild_SchemaInfoDescriptor(executeInfo, MPSymbols_DescTagName.MATRIX);
    }


    /**
     * This is the standard schema that should be added to all matrices (by default). There should be only one instance that is shared by all
     * matrices.
     *
     * @param executeInfo
     * @return
     * @throws Exception_SchemaInfo
     * @throws Exception_Descriptor
     */
    public SchemaInfo_Schema get_StdSchema(ExecutionInfo executeInfo) throws Exception_SchemaInfo, Exception_Descriptor {
        
        if (matrixStdSchema == null) {
            matrixStdSchema = createNew_Schema(executeInfo, MPSymbols_Label.MATRIX$__$STANDARD, MPSymbols_DescTagName.net$__$unconventionalthinking$__$matrix,
                    true, null, null, false);
            
            matrixStdSchema.addChild_SchemaInfoDescriptor(executeInfo, createNew_ItemSchemaInfo(executeInfo, matrixStdSchema));
        }
        return matrixStdSchema;
    }


    /**
     * All Matrix Descriptor-Object have their own standalone schemaInfo_Matrix that they share. Why? because a matrix has many schemaInfo_Schemas
     * that its descriptors can use, but doesn't have a SchemaInfo object for itself. So, use this method to create one.
     *
     * NOTE: there should only be one instance of the matrix SchemaInfo for all matrices
     *
     * @param executeInfo
     * @return
     * @throws Exception_SchemaInfo
     * @throws Exception_Descriptor
     */
    public final SchemaInfo_Matrix createNew_MatrixSchemaInfo(ExecutionInfo executeInfo, SchemaInfo_Descriptor parent_SchemaInfoDesc)
            throws Exception_SchemaInfo, Exception_Descriptor {

        SchemaInfo_Matrix_Impl schemaInfo_Matrix = new SchemaInfo_Matrix_Impl(executeInfo,
                schemaForSchema_Container.schema4Schema__SchemaInfoDesc_Descriptor, null, (Descriptor)parent_SchemaInfoDesc, schemaControl.schema_DescControl);

        //  Matrix Descriptor, FieldNames
        Descriptor matrix_FieldNames_Descriptor = new Descriptor(executeInfo,
                schemaForSchema_Container.schema4Schema__DescDescriptor__SchemaInfoDesc_FieldNames,
                null, null, (Descriptor)schemaInfo_Matrix, schemaControl.schema_DescControl);
        FieldSet_Tuple fieldNames_FieldSet = matrix_FieldNames_Descriptor.get_FieldSet_Tuple(executeInfo);

        Descriptor matrix_FieldTypes_Descriptor = new Descriptor(executeInfo,
                schemaForSchema_Container.schema4Schema__DescDescriptor__SchemaInfoDesc_FieldTypes,
                null, null, (Descriptor)schemaInfo_Matrix, schemaControl.schema_DescControl);
        FieldSet_Tuple fieldTypes_FieldSet = matrix_FieldTypes_Descriptor.get_FieldSet_Tuple(executeInfo);


        try {
            fieldNames_FieldSet.setField_DescTagName(executeInfo, 0, MPSymbols_DescTagName.IsPersistentMatrix);
            fieldTypes_FieldSet.setField_Symbol(executeInfo, 0, MPSymbols.Symbol);
        } catch(Exception_InvalidArgumentPassed e) {
            throw new Exception_SchemaInfo("Tried to build the Matrix Schema Info object for the base schema, but had an error. could not set it's FIELD.NAMES or FIELD.TYPES descriptors.", e);
        }

        schemaInfo_Matrix.addChild_SchemaInfo_FieldDescriptor(executeInfo, matrix_FieldNames_Descriptor);
        schemaInfo_Matrix.addChild_SchemaInfo_FieldDescriptor(executeInfo, matrix_FieldTypes_Descriptor);
        
        return schemaInfo_Matrix;


    }
    
    /**
     *
     * @param executeInfo
     * @return
     * @throws Exception_SchemaInfo
     * @throws Exception_Descriptor
     */
    public final SchemaInfo_Descriptor createNew_ItemSchemaInfo(ExecutionInfo executeInfo, SchemaInfo_Descriptor parentDesc)
            throws Exception_SchemaInfo, Exception_Descriptor {

        return new SchemaInfo_Descriptor_Impl(executeInfo, schemaForSchema_Container.schema4Schema__SchemaInfoDesc_Descriptor,
                MPSymbols_Label.ITEM, null, (Descriptor)parentDesc, schemaControl.schema_DescControl);

    }




    public final SchemaInfo_Descriptor createNew_SchemaInfoDescriptor(ExecutionInfo executeInfo, SchemaInfo_Descriptor schemaInfo_Positioned, Label descriptorTagName_Label,
            MatrixSet<SchemaInfo_Schema> uses_SchemaSet,
            Descriptor parentDescriptor)
            throws Exception_SchemaInfo {
        return new SchemaInfo_Descriptor_Impl(executeInfo, schemaInfo_Positioned, descriptorTagName_Label, uses_SchemaSet, parentDescriptor, schemaControl.schema_DescControl);
    }

}
