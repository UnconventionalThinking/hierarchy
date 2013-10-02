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
public class Schema extends Matrix {




    /**
     * NOTE: when you create a schema, you don't start by creating a Schema object, you start by creating a SchemaInfo_Schema!! Why?
     * because a Schema is made up of SchemaInfo objects, which ARE schema and descriptor objects!!! That is why the Schema constructor has
     * package level access, so users can't create them.
     *
     */
    Schema(ExecutionInfo executeInfo, SchemaInfo_Schema schemaInfoSchema_Positioned, 
            Label schemaName, DescriptorTagName packageName, boolean schemaName_IsStaticSymbol,
            MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor, DescriptorControl schema_DescControl)
            throws Exception_Descriptor {

        super(executeInfo, schemaInfoSchema_Positioned, schemaName,
                MatrixName_Utilities.create_SchemaName(schemaName, packageName, schemaName_IsStaticSymbol, schema_DescControl.symbolControl),
                uses_SchemaSet, parentDescriptor, schema_DescControl);
    }
    /**
     * pass in the desc id
     */
    Schema(ExecutionInfo executeInfo, SchemaInfo_Schema schemaInfoSchema_Positioned,
            Label schemaName, DescriptorTagName packageName, boolean schemaName_IsStaticSymbol,
            MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor, DescriptorControl schema_DescControl, int descriptorID)
            throws Exception_Descriptor {

        super(executeInfo, schemaInfoSchema_Positioned, schemaName,
                MatrixName_Utilities.create_SchemaName(schemaName, packageName, schemaName_IsStaticSymbol, schema_DescControl.symbolControl),
                uses_SchemaSet, parentDescriptor, schema_DescControl, descriptorID);
    }



    /**
     * Use this constructor if you can't figure out the schema_element at compile time. For instance, if you are building
     * a dynamic matrix.
     *
     * @param schemaSet_ScopeStack      The stack of schemaSets that you have seen so far in the parent descriptors
     */
     Schema(ExecutionInfo executeInfo, DescriptorTag descTag, Label schemaName, DescriptorTagName packageName, boolean schemaName_IsStaticSymbol,
            MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor,
            SchemaSet_ScopeStack schemaSet_ScopeStack, DescriptorControl schema_DescControl) throws Exception_Descriptor {

            super(executeInfo, descTag, schemaName,
                    MatrixName_Utilities.create_SchemaName(schemaName, packageName, schemaName_IsStaticSymbol, schema_DescControl.symbolControl),
                    uses_SchemaSet, parentDescriptor, schemaSet_ScopeStack, schema_DescControl);
    }




}
