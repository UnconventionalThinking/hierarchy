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

import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.utilities.IdCreator;
import net.unconventionalthinking.utilities.ListUtilities;
import java.util.ArrayList;
import java.util.List;



/**
 * there should be one descriptor control per app. This also means desc id's are only unique to an app. We could have made it so a descriptor
 * is unique to a matrix, but then a descriptor can not be reused across matrices
 *
 * @author peterjoh
 */
public class DescriptorControl {

    public SymbolControl symbolControl;
    /**
     * the List index corresponds to the descriptor ID
     */
    private List<Descriptor> descriptorIndex_byDescID;
    private IdCreator idCreator = new IdCreator();


    public DescriptorControl(SymbolControl symbolControl) {
        this.symbolControl = symbolControl;
        this.descriptorIndex_byDescID = new ArrayList<Descriptor>();
    }


    public Descriptor getDescriptor(int descID) {
        return descriptorIndex_byDescID.get(descID);
    }



    /**
     * These methods are used by the desc constructors to register themselves, getting their desc id's and registering these id's with the
     */
    int registerNewDesc_GetNextID(Descriptor desc) {
        int descID = idCreator.getAndInc_ID();

        ListUtilities.arrayList_Set__IncreaseSizeIfNeeded((ArrayList)descriptorIndex_byDescID, descID, desc);

        return descID;
    }

    int registerNewDesc_IncAndSetDescID_IfGreater(int descID, Descriptor desc) {
        idCreator.incAndSet_IfGreater(descID);

        ListUtilities.arrayList_Set__IncreaseSizeIfNeeded((ArrayList)descriptorIndex_byDescID, descID, desc);

        return descID;
    }

    /**
     * Sometimes you need the id before you can get access to the desc reference. Use this method to get just the id, BUT,
     * you should call registerNewDesc_IncAndSetDescID_IfGreater() later to register the desc/id.
     */
    int getNextID__MustRegisterLATER() {
        return idCreator.getAndInc_ID();
    }

}
