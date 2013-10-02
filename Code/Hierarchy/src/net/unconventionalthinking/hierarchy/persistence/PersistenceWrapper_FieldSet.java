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

import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.FieldConstants;
import net.unconventionalthinking.matrix.FieldSet;
import net.unconventionalthinking.matrix.SchemaInfo_FieldSet;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Symbol;
import java.io.IOException;

/**
 *
 * @author peterjoh
 */
public class PersistenceWrapper_FieldSet extends FieldSet {


    public final PersistentMatricesManager_Client persistManager_Client;
    public final FieldSet fieldSet;

    public PersistenceWrapper_FieldSet(ExecutionInfo executeInfo, FieldSet fieldSet, PersistentMatricesManager_Client persistManager_Client) {
        super(executeInfo, fieldSet.getParentDescriptor());

        this.fieldSet = fieldSet;
        this.persistManager_Client = persistManager_Client;
    }



    
    @Override
    public Object getField(ExecutionInfo executeInfo, DescriptorTagName fieldname) throws Exception_InvalidArgumentPassed {
        return fieldSet.getField(executeInfo, fieldname);
    }
    @Override
    public Object getField(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed {
        return fieldSet.getField(executeInfo, index);
    }






    @Override
    public void setField(ExecutionInfo executeInfo, DescriptorTagName fieldname, Object value, Symbol typeSymbol) throws Exception_InvalidArgumentPassed {
        SchemaInfo_FieldSet schemaInfo_FieldSet = (SchemaInfo_FieldSet)fieldSet.getSchemaInfo();

        int fieldIndex = schemaInfo_FieldSet.get_FieldIndex_For(executeInfo, fieldname);

        setField(executeInfo, fieldIndex, value, typeSymbol);
    }

    @Override
    public void setField(ExecutionInfo executeInfo, int index, Object value, Symbol typeSymbol)
            throws Exception_InvalidArgumentPassed {

        try {
            int cmdID = persistManager_Client.commandEncoder.DescriptorSetField_byIndex(getParentDescriptor(), index, value, typeSymbol);

            fieldSet.setField(executeInfo, index, value, typeSymbol);

            persistManager_Client.commandEncoder.closeCommand(cmdID);

        } catch (IOException e) {
            String fullFieldPath = this.schemaInfo_Positioned.getSchemaInfo_DescTagName_FullPath_String(executeInfo);
            throw new ExceptRuntime_PersistenceManagerError("Tried to persist the value of using set to the field, " + fullFieldPath);
        }

    }



    
    @Override
    public void setField__Special(ExecutionInfo executeInfo, int index, FieldConstants specialValue) throws Exception_InvalidArgumentPassed {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setField__Special(ExecutionInfo executeInfo, DescriptorTagName fieldName, FieldConstants specialValue) throws Exception_InvalidArgumentPassed {
        throw new UnsupportedOperationException("Not supported yet.");
    }




    
}
