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
import net.unconventionalthinking.utilities.*;

import java.util.regex.*;


/**
 *
 * @author peterjoh
 */
public class DescriptorTagName_Single extends Symbol_Single implements DescriptorTagName {



    //  can only be called by classes in the same package. for normal dev, to create symbols, use the above methods.
    DescriptorTagName_Single() throws Exception_InvalidArgumentPassed_Null, Exception_DescTagName_IsNotValidName { super("", -1, false);  }

    DescriptorTagName_Single(String name, boolean has_StaticVersion)
            throws Exception_InvalidArgumentPassed_Null, Exception_DescTagName_IsNotValidName {

        super (name, idCreator.getAndInc_ID(), has_StaticVersion);

        if (!StringUtilities.is_Identifier(name))
            throw new Exception_DescTagName_IsNotValidName("Tried to create a descriptorTagName, but it was not a valid Identifier: '" + name + "'");
    }


    DescriptorTagName_Single(String name, int id, boolean has_StaticVersion) 
            throws Exception_InvalidArgumentPassed_Null, Exception_DescTagName_IsNotValidName
    {
        super(name, id, has_StaticVersion);


        if (!StringUtilities.is_Identifier(name))
            throw new Exception_DescTagName_IsNotValidName("Tried to create a descriptorTagName, but it was not a valid Identifier: '" + name + "'");
        //  if the id passed in is greater than the current idCreator's id, the idCreator id will be set to the passed in id.
        idCreator.incAndSet_IfGreater(id);

    }


    public String getTagName() { return this.name; }
    public Symbol getTagName_Symbol() { return this; }

    public boolean is_MultiPart_DescTagName() { return false; }

    public DescriptorTagName_Single getDescTagName_AtPartNum(int i) {
        if (i == 1)
            return (DescriptorTagName_Single)this;
        else
            return null;
    }


    public Symbol getSymbol() { return (Symbol)this; }
    @Override
    public SymbolType getSymbolType() { return SymbolType.DescriptorTagName; }


}
