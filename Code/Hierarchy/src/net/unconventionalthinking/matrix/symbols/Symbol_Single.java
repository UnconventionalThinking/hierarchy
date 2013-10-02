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

import net.unconventionalthinking.exceptions.*;

/**
 *
 * Note: there should NOT be a equals() method for symbols! in a running application if two symbols are equal,
 * they should be the same symbol object! (because if you try to create another symbol object with the same info, it
 * should just spit you back the existing symbol object!
 *
 * @author peterjoh
 */
public class Symbol_Single extends Symbol {




    //  can only be called by classes in the same package. for normal dev, to create symbols, use the above methods.
    Symbol_Single() throws Exception_InvalidArgumentPassed_Null { super("", -1, false);  }

    Symbol_Single(String name, boolean has_StaticVersion) throws Exception_InvalidArgumentPassed_Null {

        super (name, idCreator.getAndInc_ID(), has_StaticVersion);
    }


    Symbol_Single(String name, int id, boolean has_StaticVersion) throws Exception_InvalidArgumentPassed_Null {

        super(name, id, has_StaticVersion);

        //  if the id passed in is greater than the current idCreator's id, the idCreator id will be set to the passed in id.
        idCreator.incAndSet_IfGreater(id);
    }


    @Override
    public SymbolType getSymbolType() { return SymbolType.Symbol; }






}
