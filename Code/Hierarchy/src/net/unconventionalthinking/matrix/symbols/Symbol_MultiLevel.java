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

import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null;
import net.unconventionalthinking.lang.Boolean_Mutable;
import java.util.List;



/**
 * Multi Level Symbol:
 * a Multi level symbol can be thought of as the 3rd (or higher) level of symbol. the first level are single symbols:
 *   sym1
 * The second level is multi-part symbols:
 *   sym1.child
 * The third level is the Multi-Level Symbol::
 *   sym1.child::sym2.child
 *
 * notice, you specify a different separator for each level.
 * Also notice, you don't have to use all the levels, you can use just two out of three
 *    sym1::sym2
 *
 * NOTE: this symbol uses the parent class's equals() and hashcode() methods!
 *
 * @author peterjoh
 */
public class Symbol_MultiLevel extends Symbol implements Symbol_MultiLevel_Base {



    public final Symbol[] symbols;
    public final String[] symbolNames;


    
    /**
     * Seems like this constructor should be rarely called. Why would you want to create a symbol with a -1 symbol id?
     */
    Symbol_MultiLevel() throws Exception_InvalidArgumentPassed_Null {

        super(new String[0], -1, false);

        this.symbols = new Symbol[0];
        this.symbolNames = new String[0];
    }


    Symbol_MultiLevel(Symbol[] symbols, boolean has_StaticVersion) throws Exception_InvalidArgumentPassed_Null {
        super(true, symbols, idCreator.getAndInc_ID(), has_StaticVersion);

        this.symbols = new Symbol[symbols.length];
        this.symbolNames = new String[symbols.length];

        for (int i = 0; i < symbols.length; ++i) {
            this.symbols[i] = symbols[i];
            this.symbolNames[i] = symbols[i].name;
        }
    }

    Symbol_MultiLevel(Symbol[] symbols, int multipart_SymbolID, boolean has_StaticVersion) throws Exception_InvalidArgumentPassed_Null {
        super(true, symbols, multipart_SymbolID, has_StaticVersion);

        this.symbols = new Symbol[symbols.length];
        this.symbolNames = new String[symbols.length];

        for (int i = 0; i < symbols.length; ++i) {
            this.symbols[i] = symbols[i];
            this.symbolNames[i] = symbols[i].name;
        }

        idCreator.incAndSet_IfGreater(multipart_SymbolID);
    }




    Symbol_MultiLevel(List<Symbol> symbols, boolean has_StaticVersion) throws Exception_InvalidArgumentPassed_Null  {
        super(true, symbols, idCreator.getAndInc_ID(), has_StaticVersion);

        this.symbols = new Symbol[symbols.size()];
        this.symbolNames = new String[symbols.size()];

        for (int i = 0; i < this.symbols.length; ++i) {
            this.symbols[i] = symbols.get(i);
            this.symbolNames[i] = symbols.get(i).name;
        }
    }
    Symbol_MultiLevel(List<Symbol> symbols, int multipart_SymbolID, boolean has_StaticVersion) throws Exception_InvalidArgumentPassed_Null  {
        super(true, symbols, multipart_SymbolID, has_StaticVersion);

        this.symbols = new Symbol[symbols.size()];
        this.symbolNames = new String[symbols.size()];

        for (int i = 0; i < this.symbols.length; ++i) {
            this.symbols[i] = symbols.get(i);
            this.symbolNames[i] = symbols.get(i).name;
        }

        idCreator.incAndSet_IfGreater(multipart_SymbolID);
    }




    @Override
    public int getNumOfParts() {
        return symbols.length;
    }

    @Override
    public String[] getSymbolNames() {
        return symbolNames;
    }

    @Override
    public Symbol getSymbol_AtPartNum(int partNum) {
        if (partNum <= symbols.length)
            return symbols[partNum - 1];  //  Note:  partNum == partNum + 1 !!
        else
            return null;
    }

    @Override
    public int getSymbolId_AtPartNum(int partNum, Boolean_Mutable found_SymbolAtPartNum) {
        if (partNum <= symbols.length) {
            found_SymbolAtPartNum.value = true;
            return symbols[partNum - 1].ID;  //  Note:  partNum == partNum + 1 !!
        } else {
            found_SymbolAtPartNum.value = false;
            return -1;
        }
    }

    @Override
    public String getSymbolName_AtPartNum(int partNum) {
        if (partNum <= symbols.length)
            return symbols[partNum - 1].name;  //  Note:  partNum == partNum + 1 !!
        else
            return null;
    }


    //  NOTE: this symbol uses the parent class's equals() and hashcode() methods!
}
