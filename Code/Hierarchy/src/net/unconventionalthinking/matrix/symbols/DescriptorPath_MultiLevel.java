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

package net.unconventionalthinking.matrix.symbols;

import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author peterjoh
 */
public class DescriptorPath_MultiLevel extends Symbol_MultiLevel implements DescriptorPath {



    DescriptorPath_MultiLevel(DescriptorTagName[] symbols, boolean has_StaticVersion)
            throws Exception_InvalidArgumentPassed {
        super((Symbol[])symbols, has_StaticVersion);

    }

    DescriptorPath_MultiLevel(DescriptorTagName[] symbols, int multiLevel_SymbolID, boolean has_StaticVersion)
            throws Exception_InvalidArgumentPassed {
        super((Symbol[])symbols, multiLevel_SymbolID, has_StaticVersion);

    }

    DescriptorPath_MultiLevel(List<Symbol> symbols, boolean has_StaticVersion)
            throws Exception_InvalidArgumentPassed {
        super(symbols, has_StaticVersion);

    }

    DescriptorPath_MultiLevel(List<Symbol> symbols, int multiLevel_SymbolID, boolean has_StaticVersion)
            throws Exception_InvalidArgumentPassed {
        super(symbols, multiLevel_SymbolID, has_StaticVersion);

    }




    
    @Override
    public SymbolType getSymbolType() { return SymbolType.DescriptorPath; }



    public List<Integer> get_ID_List() {

        List<Integer> id_List = new ArrayList<Integer>();

        for (Symbol descTagName : super.symbols) {
            id_List.add(new Integer(descTagName.getID()));
        }

        return id_List;
    }
}
