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
import java.util.*;

import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.hierarchy.SchemaSet_ScopeStack;



/**
 *
 * @author peterjoh
 */
public class Matrix extends Descriptor {


    public final MatrixName matrixName;

    /**
     * This is the main constructor for matrices. It will create the matrix SchemaInfo object. Use this one most of the time.
     *
     * @param executeInfo
     * @param schemaInfo_Positioned
     * @param label
     * @param uses_SchemaSet
     * @param parentDescriptor
     * @param symbolControl
     */
    Matrix(ExecutionInfo executeInfo, Label matrixName_Label, DescriptorTagName packageName, boolean matrixName_IsStaticSymbol,
            MatrixSet<SchemaInfo_Schema> uses_SchemaSet,
            Descriptor parentDescriptor, SchemaControl schemaControl, DescriptorControl descriptorControl)
            throws Exception_SchemaInfo, Exception_Descriptor {

        super(executeInfo, schemaControl.schemaFactory.get_BaseSchema_MatrixSchemaInfo(executeInfo),
                matrixName_Label, uses_SchemaSet, parentDescriptor, descriptorControl);

        this.matrixName = MatrixName_Utilities.create_MatrixName(matrixName_Label, packageName, matrixName_IsStaticSymbol, 
                descriptorControl.symbolControl);
    }
    /**
     * pass in the desc id
     */
    Matrix(ExecutionInfo executeInfo, Label matrixName_Label, DescriptorTagName packageName, boolean matrixName_IsStaticSymbol,
            MatrixSet<SchemaInfo_Schema> uses_SchemaSet,
            Descriptor parentDescriptor, SchemaControl schemaControl, DescriptorControl descriptorControl, int descriptorID)
            throws Exception_SchemaInfo, Exception_Descriptor {

        super(executeInfo, schemaControl.schemaFactory.get_BaseSchema_MatrixSchemaInfo(executeInfo),
                matrixName_Label, uses_SchemaSet, parentDescriptor, descriptorControl, descriptorID);

        this.matrixName = MatrixName_Utilities.create_MatrixName(matrixName_Label, packageName, matrixName_IsStaticSymbol,
                descriptorControl.symbolControl);
    }
    
    /**
     * This is a version of the above constructor used by the child class, Schema. It passes in the matrixName (or schemaName).
     */
    Matrix(ExecutionInfo executeInfo, Label matrixName_Label, MatrixName matrixName, MatrixSet<SchemaInfo_Schema> uses_SchemaSet,
            Descriptor parentDescriptor, SchemaControl schemaControl, DescriptorControl descriptorControl)
            throws Exception_SchemaInfo, Exception_Descriptor {

        super(executeInfo, schemaControl.schemaFactory.get_BaseSchema_MatrixSchemaInfo(executeInfo),
                matrixName_Label, uses_SchemaSet, parentDescriptor, descriptorControl);
        this.matrixName = matrixName;
    }
    /**
     * pass in the desc id
     */
    Matrix(ExecutionInfo executeInfo, Label matrixName_Label, MatrixName matrixName, MatrixSet<SchemaInfo_Schema> uses_SchemaSet,
            Descriptor parentDescriptor, SchemaControl schemaControl, DescriptorControl descriptorControl, int descriptorID)
            throws Exception_SchemaInfo, Exception_Descriptor {

        super(executeInfo, schemaControl.schemaFactory.get_BaseSchema_MatrixSchemaInfo(executeInfo),
                matrixName_Label, uses_SchemaSet, parentDescriptor, descriptorControl, descriptorID);
        this.matrixName = matrixName;
    }






    Matrix(ExecutionInfo executeInfo, SchemaInfo_Descriptor schemaInfo_Matrix_Positioned, 
            Label matrixName_Label, DescriptorTagName packageName, boolean matrixName_IsStaticSymbol, MatrixSet<SchemaInfo_Schema> uses_SchemaSet,
            Descriptor parentDescriptor, DescriptorControl descriptorControl)
            throws Exception_Descriptor {

        super(executeInfo, schemaInfo_Matrix_Positioned, matrixName_Label, uses_SchemaSet, parentDescriptor, descriptorControl);

        this.matrixName = MatrixName_Utilities.create_MatrixName(matrixName_Label, packageName, matrixName_IsStaticSymbol, 
                descriptorControl.symbolControl);
    }
    /**
     * pass in the desc id
     */
    Matrix(ExecutionInfo executeInfo, SchemaInfo_Descriptor schemaInfo_Matrix_Positioned,
            Label matrixName_Label, DescriptorTagName packageName, boolean matrixName_IsStaticSymbol, MatrixSet<SchemaInfo_Schema> uses_SchemaSet,
            Descriptor parentDescriptor, DescriptorControl descriptorControl, int descriptorID)
            throws Exception_Descriptor {

        super(executeInfo, schemaInfo_Matrix_Positioned, matrixName_Label, uses_SchemaSet, parentDescriptor, descriptorControl, descriptorID);

        this.matrixName = MatrixName_Utilities.create_MatrixName(matrixName_Label, packageName, matrixName_IsStaticSymbol,
                descriptorControl.symbolControl);
    }

    /**
     * This is a version of the above constructor used by the child class, Schema. It passes in the matrixName (or schemaName).
     */
    Matrix(ExecutionInfo executeInfo, SchemaInfo_Descriptor schemaInfo_Matrix_Positioned,
             Label matrixName_Label, MatrixName matrixName, MatrixSet<SchemaInfo_Schema> uses_SchemaSet,
            Descriptor parentDescriptor, DescriptorControl descriptorControl)
            throws Exception_Descriptor {

        super(executeInfo, schemaInfo_Matrix_Positioned, matrixName_Label, uses_SchemaSet, parentDescriptor, descriptorControl);

        this.matrixName = matrixName;
    }
    /**
     * pass in the desc id
     */
    Matrix(ExecutionInfo executeInfo, SchemaInfo_Descriptor schemaInfo_Matrix_Positioned,
             Label matrixName_Label, MatrixName matrixName, MatrixSet<SchemaInfo_Schema> uses_SchemaSet,
            Descriptor parentDescriptor, DescriptorControl descriptorControl, int descriptorID)
            throws Exception_Descriptor {

        super(executeInfo, schemaInfo_Matrix_Positioned, matrixName_Label, uses_SchemaSet, parentDescriptor, descriptorControl, descriptorID);

        this.matrixName = matrixName;
    }





    /**
     * Use this constructor if you can't figure out the schema_element at compile time. For instance, if you are building
     * a dynamic matrix... Actually, not sure why you'd use this constructor on a matrix, you usually use them on descriptors.
     *
     * @param descTag
     * @param label
     * @param uses_SchemaSet
     * @param parentDescriptor
     * @param schemaSet_ScopeStack      The stack of schemaSets that you have seen so far in the parent descriptors
     * @param symbolControl
     */
    Matrix(ExecutionInfo executeInfo, DescriptorTag descTag, Label matrixName_Label, DescriptorTagName packageName, boolean matrixName_IsStaticSymbol,
            MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor, SchemaSet_ScopeStack schemaSet_ScopeStack, DescriptorControl descriptorControl)
        throws Exception_Descriptor {

        super(executeInfo, descTag, matrixName_Label, uses_SchemaSet, parentDescriptor, schemaSet_ScopeStack, descriptorControl);

        this.matrixName = MatrixName_Utilities.create_MatrixName(matrixName_Label, packageName, matrixName_IsStaticSymbol, descriptorControl.symbolControl);
    }
    /**
     * This is a version of the above constructor used by the child class, Schema. It passes in the matrixName (or schemaName).
     */
    Matrix(ExecutionInfo executeInfo, DescriptorTag descTag, Label matrixName_Label, MatrixName matrixName,
            MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor, SchemaSet_ScopeStack schemaSet_ScopeStack, DescriptorControl descriptorControl)
        throws Exception_Descriptor {

        super(executeInfo, descTag, matrixName_Label, uses_SchemaSet, parentDescriptor, schemaSet_ScopeStack, descriptorControl);

        this.matrixName = matrixName;
    }





    public MatrixName getMatrixName() { return matrixName; }


    /** This method has not been implemented yet!!! for now, return true */
    public boolean is_StaticMatrix() {
        return true;
    }




    /** NOTE: you can call this print on a Flattened matrix, which is useful for debugging */
    public StringBuilder printMatrix(boolean identify_SchemaInfoObjs) {
        StringBuilder strBuilder = new StringBuilder();

        super.print(strBuilder, 0, identify_SchemaInfoObjs);
        return strBuilder;
    }








}
