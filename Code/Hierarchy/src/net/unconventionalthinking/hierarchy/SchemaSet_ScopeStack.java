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

package net.unconventionalthinking.hierarchy;

import net.unconventionalthinking.lang.Boolean_Mutable;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.lang.String_Mutable;
import net.unconventionalthinking.matrix.MatrixSet;
import net.unconventionalthinking.matrix.SchemaControl;
import net.unconventionalthinking.matrix.SchemaInfo_Schema;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.symbols.MatrixName;
import net.unconventionalthinking.hierarchy.compileractions.HierarchyActions;
import java.net.MalformedURLException;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author peterjoh
 */
public class SchemaSet_ScopeStack {


    public final LinkedList<MatrixSet<SchemaInfo_Schema>> stack;

    private SchemaControl schemaControl;
    private ExecutionInfo executeInfo;



    public SchemaSet_ScopeStack(ExecutionInfo executeInfo, SchemaControl schemaControl) {
        this.stack = new LinkedList<MatrixSet<SchemaInfo_Schema>>();

        this.executeInfo = executeInfo;
        this.schemaControl = schemaControl;
    }


    /**
     * The BaseSchema contains the Matrix SchemaInfoDesc, so if you are creating a Matrix Descriptor, call this method to add it.
     */
    public void add_BaseSchema_toStack() throws Exception_MetaCompilerError {

        try {
            stack.add(
                new MatrixSet<SchemaInfo_Schema>().add(
                    schemaControl.schemaFactory.get_BaseSchema(executeInfo),
                    schemaControl.schemaForSchema )
                );
        } catch (Exception e) {
            throw new Exception_MetaCompilerError("Tried to add the Base Schema to the scope stack, but had an error creating it (see inner exception).", e);
        }
    }



    public static MatrixSet<SchemaInfo_Schema> create_SchemaSet(List<MatrixName> usesSchema_List, HierarchyActions hierarchyActions)
            throws Exception_MetaCompilerError, MalformedURLException {

        MatrixSet<SchemaInfo_Schema> usesSchema_Set = new MatrixSet<SchemaInfo_Schema>();

        if (usesSchema_List != null) {
            for (MatrixName schemaName : usesSchema_List) {
                SchemaInfo_Schema schema = ClassPath_SearchUtilities.classPath__FindSchema(schemaName.get_Name_no_backtiks(), hierarchyActions);

                if (schema == null)
                    throw new Exception_MetaCompilerError("In the schema list of a Descriptor's USES statement, tried to find a schema, " + schemaName +
                            ", but it doesn't exist. Please check the name of this schema.");
                else
                    usesSchema_Set.add(schema);
            }
        }
        return usesSchema_Set;

    }




}
