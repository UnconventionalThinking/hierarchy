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
public class CmdAction_DescriptorAddChildDesc extends CmdAction {

    @Override
    public void performAction(ExecutionInfo executeInfo, Command cmd) throws Exception {

        Descriptor parentDesc = matrixControl.descriptorControl.getDescriptor(((Integer)cmd.logVarID).intValue());
        Descriptor childDesc = matrixControl.descriptorControl.getDescriptor(((Integer)cmd.params[0]).intValue());

        if (parentDesc != null && childDesc != null) {
             parentDesc.add_ChildDescriptor(executeInfo, childDesc);
        } else {
            throw new ExceptRuntime_Persistence_RebuilderError("Was performing the Descriptor Add Child Desc command, but could not find either the parent " +
                    "or the child descriptors (or both). " +
                    "The id of the parent was " + cmd.logVarID + " and it was " + (parentDesc != null ? "found" : "not found") +
                    ". The id of the child was " + cmd.params[0] + " and it was " + (childDesc != null ? "found" : "not found") + ".");
        }

    }
    
}
