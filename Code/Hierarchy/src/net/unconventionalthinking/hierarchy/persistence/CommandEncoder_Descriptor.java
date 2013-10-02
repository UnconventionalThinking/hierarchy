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

package net.unconventionalthinking.hierarchy.persistence;

import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.lang.Integer_Mutable;
import net.unconventionalthinking.matrix.Descriptor;
import net.unconventionalthinking.matrix.Exception_Descriptor;
import net.unconventionalthinking.matrix.MatrixControl;
import net.unconventionalthinking.matrix.MatrixSet;
import net.unconventionalthinking.matrix.SchemaInfo_Descriptor;
import net.unconventionalthinking.matrix.SchemaInfo_Schema;
import net.unconventionalthinking.matrix.symbols.DescriptorTag;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.hierarchy.SchemaSet_ScopeStack;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author peterjoh
 */
public class CommandEncoder_Descriptor {

    public final CommandEncoder persist_CommandEncoder;

    private MatrixControl matrixControl;

    public CommandEncoder_Descriptor(CommandEncoder persist_CommandEncoder, MatrixControl matrixControl) throws IOException {
        this.persist_CommandEncoder = persist_CommandEncoder;
        this.matrixControl = matrixControl;
    }

    public Descriptor createNew_Descriptor(ExecutionInfo executeInfo, Integer_Mutable createdDesc_logVarID_OUT,
            SchemaInfo_Descriptor schemaInfo_Positioned, Label label, MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor)
            throws IOException {

        return matrixControl.matrixFactory.createNew_Descriptor_Persistent(executeInfo, persist_CommandEncoder, createdDesc_logVarID_OUT,
                schemaInfo_Positioned, label, uses_SchemaSet, parentDescriptor);
    }

    public Descriptor createNew_Descriptor(ExecutionInfo executeInfo, Integer_Mutable createdDesc_logVarID_OUT,
            DescriptorTag descTag, Label label, MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor,
            SchemaSet_ScopeStack schemaSet_ScopeStack)
            throws Exception_Descriptor {

        return matrixControl.matrixFactory.createNew_Descriptor_Persistent(executeInfo, persist_CommandEncoder, createdDesc_logVarID_OUT,
                descTag, label, uses_SchemaSet, parentDescriptor, schemaSet_ScopeStack);
    }


    public void addDescriptor(ExecutionInfo executeInfo, Descriptor parentDesc, Descriptor childDesc) throws IOException, Exception_Descriptor {

        int cmdID = persist_CommandEncoder.DescriptorAddChildDesc(parentDesc.descriptorID, childDesc.descriptorID);

        parentDesc.add_ChildDescriptor(executeInfo, childDesc);

        persist_CommandEncoder.closeCommand(cmdID);

    }


}
