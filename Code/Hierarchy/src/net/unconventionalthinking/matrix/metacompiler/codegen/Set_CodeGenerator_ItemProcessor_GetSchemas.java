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

import net.unconventionalthinking.matrix.SchemaControl;
import net.unconventionalthinking.matrix.SchemaInfo;
import net.unconventionalthinking.matrix.SchemaInfo_Schema;
import net.unconventionalthinking.matrix.symbols.MatrixName;
import net.unconventionalthinking.hierarchy.HierarchySettings;

/**
 *
 * @author peterjoh
 */
public class Set_CodeGenerator_ItemProcessor_GetSchemas implements Set_CodeGenerator_ItemProcessor_CallBack {

    private String schemaNameSymbols_ClassName;

    public Set_CodeGenerator_ItemProcessor_GetSchemas(String schemaNameSymbols_ClassName) {
        this.schemaNameSymbols_ClassName = schemaNameSymbols_ClassName;
    }

    

    /**
     * This Set_CodeGenerator_ItemProcessor_GetSchemas prints out the schema access code for a schema object.
     *
     * @param schemaName
     * @param args          args[0] is a SchemaControl object. args[1] is a String with the appControlObjectName
     * @return
     */
    public String processItemExpression(Object schema_Raw, Object[] args) {
        
        SchemaInfo_Schema schema = (SchemaInfo_Schema)schema_Raw;
        SchemaControl schemaControl = (SchemaControl)args[0];
        String appControlObjectName = (String)args[1];


        if (schema != null) {
            return appControlObjectName + ".schemaControl.schemaIndex_Find(" +
                    schemaNameSymbols_ClassName + "." +
                    schema.getSchemaInfo_SchemaNameFull().get_Name_IdentFormat()  + ")";

        } else {
            return "null";
        }


    }


}
