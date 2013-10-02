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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.unconventionalthinking.matrix.symbols;

import java.util.*;
import net.unconventionalthinking.exceptions.*;
import net.unconventionalthinking.lang.*;


/**
 *
 * @author peterjoh
 */
public class Symbol_MultiPart extends Symbol {

    public final Symbol_Single[] symbols;
    public final String[] symbolNames;

    //  A multi part symbol has: a name string, a name_IdentifierFormatted name string, and
    //  a SymbolName_MultiPart!! (see Symbol class!)



    //  Constructors used in Symbol_MultiPart_Worker.addOrAccess_MultiPartSymbol_To_Indexes()

    Symbol_MultiPart() throws Exception_InvalidArgumentPassed_Null {

        super(new String[0], -1, false);

        this.symbols = new Symbol_Single[0];
        this.symbolNames = new String[0];
    }


    Symbol_MultiPart(Symbol_Single[] symbols, boolean has_StaticVersion) throws Exception_InvalidArgumentPassed_Null {
        super(symbols, idCreator.getAndInc_ID(),has_StaticVersion);

        this.symbols = new Symbol_Single[symbols.length];
        this.symbolNames = new String[symbols.length];

        for (int i = 0; i < symbols.length; ++i) {
            this.symbols[i] = symbols[i];
            this.symbolNames[i] = symbols[i].name;
        }
    }

    Symbol_MultiPart(Symbol_Single[] symbols, int multipart_SymbolID, boolean has_StaticVersion) throws Exception_InvalidArgumentPassed_Null {
        super(symbols, multipart_SymbolID, has_StaticVersion);

        this.symbols = new Symbol_Single[symbols.length];
        this.symbolNames = new String[symbols.length];

        for (int i = 0; i < symbols.length; ++i) {
            this.symbols[i] = symbols[i];
            this.symbolNames[i] = symbols[i].name;
        }

        idCreator.incAndSet_IfGreater(multipart_SymbolID);
    }

    


    Symbol_MultiPart(List<Symbol_Single> symbols, boolean has_StaticVersion) throws Exception_InvalidArgumentPassed_Null  {
        super(symbols, idCreator.getAndInc_ID(), has_StaticVersion);

        this.symbols = new Symbol_Single[symbols.size()];
        this.symbolNames = new String[symbols.size()];

        for (int i = 0; i < this.symbols.length; ++i) {
            this.symbols[i] = symbols.get(i);
            this.symbolNames[i] = symbols.get(i).name;
        }
    }
    Symbol_MultiPart(List<Symbol_Single> symbols, int multipart_SymbolID, boolean has_StaticVersion) throws Exception_InvalidArgumentPassed_Null  {
        super(symbols, multipart_SymbolID, has_StaticVersion);

        this.symbols = new Symbol_Single[symbols.size()];
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

    /**
     * part numbers starts at 1!
     */
    @Override
    public Symbol_Single getSymbol_AtPartNum(int partNum) {
        if (partNum <= symbols.length)
            return symbols[partNum - 1];  //  Note:  partNum == partNum + 1 !!
        else
            return null;
    }

    /**
     * part numbers starts at 1!
     */
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

    /**
     * part numbers starts at 1!
     */
    @Override
    public String getSymbolName_AtPartNum(int partNum) {
        if (partNum <= symbols.length)
            return symbols[partNum - 1].name;  //  Note:  partNum == partNum + 1 !!
        else
            return null;
    }


    
    /**
     *
     * If you are creating a symbol starting at the last part, then this method just returns the single symbol at that part.
     * If you are creating a sub multi-part symbol (with multiple parts), then a new multipart symbol is created.
     * @return
     */
    public Symbol createSymbol_StartingAtLevel(Symbol_MultiPart_Factory multiPart_SymbolFactory, int partNum, boolean hasStaticVersion)
            throws Exception_SymbolCreation {

        if (partNum > symbols.length)
            return null;
        else if (partNum == 1)
            return this;
        else if (partNum == symbols.length)
            return symbols[partNum - 1];
        else {

            List<String> newSymbol_SymbolList = new ArrayList<String>();
            for (int i = 1; i < symbols.length; ++i)
                newSymbol_SymbolList.add(symbols[i].name);
            
            Symbol newSymbol = null;
            try {
                newSymbol = multiPart_SymbolFactory.createNew(newSymbol_SymbolList, 1, has_StaticReference);
            } catch (Exception_MultiPartSymbolCreation e) {
                throw new Exception_SymbolCreation("Tried to create a new multipart symbol from continuation type multipart symbol, but had a problem", e);
            } catch (Exception_MultiPartSymbolAccess e) {
                throw new Exception_SymbolCreation("Tried to create a new multipart symbol from continuation type multipart symbol, but had a problem", e);
            } catch (Exception_MultiPartSymbolCreationOrAccess e) {
                throw new Exception_SymbolCreation("Tried to create a new multipart symbol from continuation type multipart symbol, but had a problem", e);
            }
            return newSymbol;


        }

    }

    @Override
    public int hashCode() {
        return name_MultiPart.hashCode();
    }

    // two symbols can only be equal if they are the same symbol object!
    @Override
    public boolean equals(Object other) {

        if (this == other)
            return true; // same object
        else
            return false;
    }



}
