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

import java.util.*;
import net.unconventionalthinking.exceptions.*;

/**
 *
 * @author peterjoh
 */
public class DescriptorTagName_MultiPart extends Symbol_MultiPart implements DescriptorTagName {


    //  Constructors used in Symbol_MultiPart_Worker.addOrAccess_MultiPartSymbol_To_Indexes()

    DescriptorTagName_MultiPart() throws Exception_InvalidArgumentPassed_Null {

        super(new Symbol_Single[0], false);

    }


    DescriptorTagName_MultiPart(Symbol_Single[] symbols, boolean has_StaticVersion) throws Exception_InvalidArgumentPassed_Null {
        super(symbols, has_StaticVersion);
    }
    DescriptorTagName_MultiPart(Symbol_Single[] symbols, int multipart_SymbolID, boolean has_StaticVersion) throws Exception_InvalidArgumentPassed_Null {
        super(symbols, multipart_SymbolID, has_StaticVersion);
    }

    DescriptorTagName_MultiPart(List<Symbol_Single> symbols, boolean has_StaticVersion) throws Exception_InvalidArgumentPassed_Null  {
        super(symbols, has_StaticVersion);
    }
    DescriptorTagName_MultiPart(List<Symbol_Single> symbols, int multipart_SymbolID, boolean has_StaticVersion) throws Exception_InvalidArgumentPassed_Null  {
        super(symbols, multipart_SymbolID, has_StaticVersion);
    }


    public String getTagName() { return this.name_MultiPart.name_no_backtiks; }
    public Symbol getTagName_Symbol() { return this; }

    public boolean is_MultiPart_DescTagName() { return true; }

    public DescriptorTagName_Single getDescTagName_AtPartNum(int i) {
        return (DescriptorTagName_Single) super.getSymbol_AtPartNum(i);
    }


    public Symbol getSymbol() { return (Symbol)this; }
    @Override
    public SymbolType getSymbolType() { return SymbolType.DescriptorTagName; }


    @Override
    public String toString() {
        return getTagName();
    }
}
