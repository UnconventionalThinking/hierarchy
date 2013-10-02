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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.unconventionalthinking.matrix;

import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.lang.Integer_Mutable;
import net.unconventionalthinking.matrix.symbols.DescriptorTag;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.hierarchy.SchemaSet_ScopeStack;
import net.unconventionalthinking.hierarchy.persistence.CommandEncoder;
import java.io.IOException;

/**
 *
 * @author peterjoh
 */
public class MatrixFactory {

    SymbolControl   symbolControl;
    SchemaControl   schemaControl;  
    MatrixControl   matrixControl;


    public MatrixFactory(SymbolControl symbolControl, MatrixControl matrixControl, SchemaControl schemaControl) {

        this.symbolControl = symbolControl;
        this.matrixControl = matrixControl;
        this.schemaControl = schemaControl;

    }




    /**
     * this creation method passes a default value for "is_Static_Matrix" as true.
     */
    public final Matrix createNew_Matrix(ExecutionInfo executeInfo, Label matrixName, DescriptorTagName packageName, boolean matrixName_IsStaticSymbol,
                MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor)
            throws Exception_SchemaInfo, Exception_Descriptor {

        return createNew_Matrix(executeInfo, matrixName, packageName, matrixName_IsStaticSymbol, uses_SchemaSet, parentDescriptor, true);
    }
    /**
     * This is the main constructor for matrices. It will create the matrix SchemaInfo object. Use this one most of the time.
     */
    public final Matrix createNew_Matrix(ExecutionInfo executeInfo, Label matrixName, DescriptorTagName packageName, boolean matrixName_IsStaticSymbol,
                MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor, boolean is_StaticMatrix)
            throws Exception_SchemaInfo, Exception_Descriptor {
        uses_SchemaSet = initialize_SchemaSetScopeStack(executeInfo, uses_SchemaSet);
        Matrix matrix = new Matrix(executeInfo, matrixName, packageName, matrixName_IsStaticSymbol, uses_SchemaSet,
                parentDescriptor, schemaControl, matrixControl.descriptorControl);
        matrixControl.addMatrix(matrix, is_StaticMatrix);
        return matrix;
    }
    /**
     * Same as above creation method, except you also pass in the descriptor id.
     */
    public final Matrix createNew_Matrix(ExecutionInfo executeInfo, Label matrixName, DescriptorTagName packageName, boolean matrixName_IsStaticSymbol,
                MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor, boolean is_StaticMatrix, int descriptorID)
            throws Exception_SchemaInfo, Exception_Descriptor {

        uses_SchemaSet = initialize_SchemaSetScopeStack(executeInfo, uses_SchemaSet);
        Matrix matrix = new Matrix(executeInfo, matrixName, packageName, matrixName_IsStaticSymbol, uses_SchemaSet,
                parentDescriptor, schemaControl, matrixControl.descriptorControl, descriptorID);
        matrixControl.addMatrix(matrix, is_StaticMatrix);
        return matrix;
    }






    /**
     * this creation method passes a default value for "is_Static_Matrix" as true.
     */
    public final Matrix createNew_Matrix(ExecutionInfo executeInfo, SchemaInfo_Matrix schemaInfo_Matrix_Positioned, 
            Label label, DescriptorTagName packageName, boolean matrixName_IsStaticSymbol,
            MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor)
            throws Exception_SchemaInfo, Exception_Descriptor {
        return createNew_Matrix(executeInfo, schemaInfo_Matrix_Positioned, label, packageName, matrixName_IsStaticSymbol,
                uses_SchemaSet, parentDescriptor, true);
    }
    /**
     * pass in the schemaInfo_Matrix_Positioned in this version
     */
    public final Matrix createNew_Matrix(ExecutionInfo executeInfo, SchemaInfo_Matrix schemaInfo_Matrix_Positioned, 
            Label label, DescriptorTagName packageName, boolean matrixName_IsStaticSymbol,
            MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor, boolean is_StaticMatrix)
            throws Exception_SchemaInfo, Exception_Descriptor {

        uses_SchemaSet = initialize_SchemaSetScopeStack(executeInfo, uses_SchemaSet);
        Matrix matrix = new Matrix(executeInfo, schemaInfo_Matrix_Positioned, label, packageName, matrixName_IsStaticSymbol,
                uses_SchemaSet, parentDescriptor, matrixControl.descriptorControl);
        matrixControl.addMatrix(matrix, is_StaticMatrix);
        return matrix;
    }
    /**
     * Same as above creation method, except you also pass in the descriptor id.
     */
    public final Matrix createNew_Matrix(ExecutionInfo executeInfo, SchemaInfo_Matrix schemaInfo_Matrix_Positioned,
            Label label, DescriptorTagName packageName, boolean matrixName_IsStaticSymbol,
            MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor, boolean is_StaticMatrix, int descriptorID)
            throws Exception_SchemaInfo, Exception_Descriptor {

        uses_SchemaSet = initialize_SchemaSetScopeStack(executeInfo, uses_SchemaSet);
        Matrix matrix = new Matrix(executeInfo, schemaInfo_Matrix_Positioned, label, packageName, matrixName_IsStaticSymbol,
                uses_SchemaSet, parentDescriptor, matrixControl.descriptorControl, descriptorID);
        matrixControl.addMatrix(matrix, is_StaticMatrix);
        return matrix;
    }




    public final Matrix createNew_Matrix(ExecutionInfo executeInfo, DescriptorTag descTag, 
            Label matrixName_Label, DescriptorTagName packageName, boolean matrixName_IsStaticSymbol,
            MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor, SchemaSet_ScopeStack schemaSet_ScopeStack)
        throws Exception_SchemaInfo, Exception_Descriptor {

        return createNew_Matrix(executeInfo, descTag, matrixName_Label, packageName, matrixName_IsStaticSymbol, uses_SchemaSet, parentDescriptor,
                schemaSet_ScopeStack, false);
    }

    public final Matrix createNew_Matrix(ExecutionInfo executeInfo, DescriptorTag descTag, 
            Label matrixName_Label, DescriptorTagName packageName, boolean matrixName_IsStaticSymbol,
            MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor, SchemaSet_ScopeStack schemaSet_ScopeStack,
            boolean is_StaticMatrix)
        throws Exception_SchemaInfo, Exception_Descriptor {

        uses_SchemaSet = initialize_SchemaSetScopeStack(executeInfo, uses_SchemaSet);
        Matrix matrix = new Matrix(executeInfo, descTag, matrixName_Label, packageName, matrixName_IsStaticSymbol, uses_SchemaSet,
                parentDescriptor, schemaSet_ScopeStack, matrixControl.descriptorControl);
        matrixControl.addMatrix(matrix, is_StaticMatrix);
        return matrix;
    }






    /**
     * CreateNew Matrix Flattened
     */
    public final MatrixFlattened_Descriptor createNew_MatrixFlattened(ExecutionInfo executeInfo, Label matrixName, DescriptorTagName packageName,
            boolean matrixName_IsStaticSymbol, MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor)
            throws Exception_SchemaInfo, Exception_Descriptor {

        return createNew_MatrixFlattened(executeInfo, matrixName, packageName, matrixName_IsStaticSymbol, uses_SchemaSet, parentDescriptor, true);
    }
    public final MatrixFlattened_Descriptor createNew_MatrixFlattened(ExecutionInfo executeInfo, Label matrixName, DescriptorTagName packageName,
            boolean matrixName_IsStaticSymbol, MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor, boolean is_StaticMatrix)
            throws Exception_SchemaInfo, Exception_Descriptor {

     
        MatrixFlattened_Matrix_Impl matrix_Flattened = new MatrixFlattened_Matrix_Impl(executeInfo, matrixName, packageName, matrixName_IsStaticSymbol,
                uses_SchemaSet, parentDescriptor, schemaControl, matrixControl.descriptorControl);
        
        return matrix_Flattened;
    }




    
    /**
     * Add the Matrix Standard schema to each matrix
     * @param uses_SchemaSet
     * @return
     */
    private final MatrixSet<SchemaInfo_Schema> initialize_SchemaSetScopeStack(ExecutionInfo executeInfo, MatrixSet<SchemaInfo_Schema> uses_SchemaSet)
        throws Exception_SchemaInfo, Exception_Descriptor {

        if (uses_SchemaSet == null)
            uses_SchemaSet = new MatrixSet<SchemaInfo_Schema>();
        return uses_SchemaSet.add(schemaControl.schemaFactory.get_StdSchema(executeInfo));
    }







    public final Descriptor createNew_Descriptor_Persistent(ExecutionInfo executeInfo, CommandEncoder persist_CommandEncoder,
            Integer_Mutable createdDesc_logVarID_OUT, SchemaInfo_Descriptor schemaInfo_Positioned, Label label,
            MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor) throws IOException {

        int descID = matrixControl.descriptorControl.getNextID__MustRegisterLATER();

        int cmdID = persist_CommandEncoder.DescriptorCreate_useSchemaInfo(createdDesc_logVarID_OUT, schemaInfo_Positioned, label, uses_SchemaSet,
                parentDescriptor, descID);
        Descriptor newDesc = createNew_Descriptor(executeInfo, schemaInfo_Positioned, label, uses_SchemaSet, parentDescriptor, descID);

        persist_CommandEncoder.closeCommand(cmdID);
        return newDesc;
    }
    /**
     * This method is not really necessary right now, because the factory doesn't do any processing on the newly created descriptor like it does
     * with the matrix creation methods. But, just for the future (and for consistency of design), the descriptor creation should be done though
     * the matrix factory just like when creating a matrix descriptor.
     */
    public final Descriptor createNew_Descriptor(ExecutionInfo executeInfo, SchemaInfo_Descriptor schemaInfo_Positioned, Label label,
            MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor) {

        return new Descriptor(executeInfo, schemaInfo_Positioned, label, uses_SchemaSet, parentDescriptor, matrixControl.descriptorControl);
    }
    /**
     * Same as above creation method, except you also pass in the descriptor id.
     */
    public final Descriptor createNew_Descriptor(ExecutionInfo executeInfo, SchemaInfo_Descriptor schemaInfo_Positioned, Label label, MatrixSet<SchemaInfo_Schema> uses_SchemaSet,
            Descriptor parentDescriptor, int descriptorID) {

        return new Descriptor(executeInfo, schemaInfo_Positioned, label, uses_SchemaSet, parentDescriptor, matrixControl.descriptorControl, descriptorID);
    }




    public final Descriptor createNew_Descriptor_Persistent(ExecutionInfo executeInfo, CommandEncoder persist_CommandGen,
            Integer_Mutable createdDesc_logVarID_OUT,  DescriptorTag descTag, Label label, MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor,
            SchemaSet_ScopeStack schemaSet_ScopeStack)
            throws Exception_Descriptor {

        throw new UnsupportedOperationException("createNew_Descriptor_Persistent() not supported yet!");

    }
    /**
     * This method is not really necessary right now, because the factory doesn't do any processing on the newly created descriptor like it does
     * with the matrix creation methods. But, just for the future (and for consistency of design), the descriptor creation should be done though
     * the matrix factory just like when creating a matrix descriptor.
     */
    public final Descriptor createNew_Descriptor(ExecutionInfo executeInfo, DescriptorTag descTag, Label label, MatrixSet<SchemaInfo_Schema> uses_SchemaSet,
            Descriptor parentDescriptor, SchemaSet_ScopeStack schemaSet_ScopeStack)
            throws Exception_Descriptor {

        return new Descriptor(executeInfo, descTag, label, uses_SchemaSet, parentDescriptor, schemaSet_ScopeStack, matrixControl.descriptorControl);
    }
    /**
     * Same as above creation method, except you also pass in the descriptor id.
     */
    public final Descriptor createNew_Descriptor(ExecutionInfo executeInfo, DescriptorTag descTag, Label label, MatrixSet<SchemaInfo_Schema> uses_SchemaSet,
            Descriptor parentDescriptor, SchemaSet_ScopeStack schemaSet_ScopeStack, int descriptorID)
            throws Exception_Descriptor {

        return new Descriptor(executeInfo, descTag, label, uses_SchemaSet, parentDescriptor, schemaSet_ScopeStack, matrixControl.descriptorControl, descriptorID);
    }

    
    








    /**
     * Need to pass the descriptor_Actual into the MatrixUsage_Descriptor constructor, so it can setup the label->desc_actual map
     * correctly in the flattened desc.
     */
    public final MatrixFlattened_Descriptor createNew_MatrixFlattened_Descriptor(ExecutionInfo executeInfo, SchemaInfo_Descriptor schemaInfo_Positioned,
            Label label, Descriptor desc_Actual, MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor) {

        return new MatrixFlattened_Descriptor_Impl(executeInfo, schemaInfo_Positioned, label, desc_Actual, uses_SchemaSet, parentDescriptor,
                matrixControl.descriptorControl);
    }
    /**
     * Need to pass the descriptor_Actual into the MatrixUsage_Descriptor constructor, so it can setup the label->desc_actual map
     * correctly in the flattened desc.
     */
    public final MatrixFlattened_Descriptor createNew_MatrixUsage_Descriptor(ExecutionInfo executeInfo, DescriptorTag descTag, Label label,
            Descriptor desc_Actual, MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor, SchemaSet_ScopeStack schemaSet_ScopeStack)
            throws Exception_Descriptor {

        return new MatrixFlattened_Descriptor_Impl(executeInfo, descTag, label, desc_Actual, uses_SchemaSet, parentDescriptor, schemaSet_ScopeStack,
                matrixControl.descriptorControl);
    }




    public void add_MatrixUsageStructure_to_Indexes(MatrixStructInfo_DescriptorContainer descContainer) {
        matrixControl.add_MatrixUsageStructure(descContainer);
    }

}
