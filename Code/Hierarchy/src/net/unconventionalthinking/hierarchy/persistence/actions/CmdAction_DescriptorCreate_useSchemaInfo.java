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

package net.unconventionalthinking.hierarchy.persistence.actions;

import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.Descriptor;
import net.unconventionalthinking.matrix.SchemaInfo_Descriptor;
import net.unconventionalthinking.matrix.symbols.DescriptorTag;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.SchemaPath;
import net.unconventionalthinking.hierarchy.persistence.Command;
import net.unconventionalthinking.hierarchy.persistence.ExceptRuntime_PersistenceManagerError;
import net.unconventionalthinking.hierarchy.persistence.ExceptRuntime_Persistence_RebuilderError;



/**
 *
 * @author peterjoh
 */
public class CmdAction_DescriptorCreate_useSchemaInfo extends CmdAction {

    @Override
    public void performAction(ExecutionInfo executeInfo, Command cmd) throws Exception {

        SchemaPath schemaPath = (SchemaPath)objectIndex.get(((Integer)cmd.params[0]).intValue());
        Label label = (Label)objectIndex.get(((Integer)cmd.params[1]).intValue());
        //MatrixSet usesSchemaSet = (MatrixSet)objectIndex.get(((Integer)cmd.params[2]).intValue());
        Descriptor parentDesc = matrixControl.descriptorControl.getDescriptor(((Integer)cmd.params[3]).intValue());

        SchemaInfo_Descriptor desc_SchemaInfo = schemaControl.getSchemaInfoDescriptor(executeInfo, schemaPath);
        if (desc_SchemaInfo != null) {
            Descriptor newDesc = matrixControl.matrixFactory.createNew_Descriptor(executeInfo, desc_SchemaInfo, label, null, parentDesc, cmd.logVarID);
        } else {
            throw new ExceptRuntime_Persistence_RebuilderError("Was performing the DescriptorCreate using SchemaInfo command, but could not find " +
                    "the schemaInfo for the schemaPath: " + (schemaPath != null ? schemaPath.toString() : null));
        }

    }

    
}
