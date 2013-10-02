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
import net.unconventionalthinking.hierarchy.persistence.Command;
import net.unconventionalthinking.hierarchy.persistence.ExceptRuntime_Persistence_RebuilderError;



/**
 *
 * @author peterjoh
 */
public class CmdAction_DescriptorSetField_ByIndex extends CmdAction {

    @Override
    public void performAction(ExecutionInfo executeInfo, Command cmd) throws Exception {

        Descriptor desc = matrixControl.descriptorControl.getDescriptor(((Integer)cmd.logVarID).intValue());

        int fieldIndex = ((Integer)cmd.params[0]).intValue();
        Object value = objectIndex.get(((Integer)cmd.params[1]).intValue());

        if (desc != null) {
            desc.get_FieldSet_Tuple(executeInfo).setField(executeInfo, fieldIndex, value);
        } else {
            throw new ExceptRuntime_Persistence_RebuilderError("Was performing the DescriptorSetField_ByIndex command, but could not find " +
                    "the Descriptor.");
        }
    }


    
}
