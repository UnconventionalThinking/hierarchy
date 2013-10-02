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

import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.utilities.*;
import net.unconventionalthinking.exceptions.*;


/**
 *
 * @author peterjoh
 */
public class Symbol_Single_Factory {


    SymbolControl symbolControl;

    public Symbol_Single_Factory(SymbolControl symbolControl) {
        this.symbolControl = symbolControl;
    }



    /**
     * Creates a new symbol with the name you passed in. if a symbol already exist, then return that sym object.
     *
     * @param name
     * @param has_StaticReference  pass in whether this symbol has a static version (meaning is apart of the selected_SymbolIndex file).
     * @return
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null
     */
    public Symbol_Single createNew(String name, boolean has_StaticVersion) 
            throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed {
        return createNew(SymbolType.Symbol, name, has_StaticVersion, null);
    }


    /**
     * Creates a new symbol with the name you passed in. if a symbol already exist, then return that sym object.
     *
     * @param name
     * @param has_StaticReference  pass in whether this symbol has a static version (meaning is apart of the selected_SymbolIndex file).
     * @param createdNew_Symbol  (output parameter) let's you know if a new symbol was created, or is false if returning
     *                              an existing symbol.
     * @return
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null
     */
    public Symbol_Single createNew(String name, boolean has_StaticVersion, Boolean_Mutable createdNew_Symbol)
        throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed {
        return createNew(SymbolType.Symbol, name, has_StaticVersion, createdNew_Symbol);
    }


    /**
     * Creates a new descTagname with the name you passed in. if a symbol already exist, then return that sym object.
     *
     * @param name
     * @param has_StaticReference  pass in whether this descTagName symbol has a static version (meaning is apart of the selected_SymbolIndex file).
     * @return
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null
     */
    public DescriptorTagName_Single createNew_DescTagName(String name, boolean has_StaticVersion) 
            throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed {
        return (DescriptorTagName_Single)createNew(SymbolType.DescriptorTagName, name, has_StaticVersion, null);
    }

    /**
     * Creates a new descTagname with the name you passed in. if a symbol already exist, then return that sym object.
     *
     * @param name
     * @param has_StaticReference  pass in whether this symbol has a static version (meaning is apart of the selected_SymbolIndex file).
     * @param createdNew_Symbol  (output parameter) let's you know if a new symbol was created, or is false if returning
     *                              an existing symbol.
     * @return
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null
     */
    public DescriptorTagName_Single createNew_DescTagName(String name, boolean has_StaticVersion, Boolean_Mutable createdNew_Symbol)
        throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed {
        return (DescriptorTagName_Single)createNew(SymbolType.DescriptorTagName, name, has_StaticVersion, createdNew_Symbol);
    }


    /**
     * Creates a new labelName with the name you passed in. if a labelName already exist, then return that labelName object.
     *
     * @param name
     * @param has_StaticReference  pass in whether this descTagName symbol has a static version (meaning is apart of the selected_SymbolIndex file).
     * @return
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null
     */
    public Label_Single createNew_Label(String name, boolean has_StaticVersion) 
            throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed  {
        return (Label_Single)createNew(SymbolType.Label, name, has_StaticVersion, null);
    }

    /**
     * Creates a new labelName with the name you passed in. if a labelName already exist, then return that labelName object.
     *
     * @param name
     * @param has_StaticReference  pass in whether this symbol has a static version (meaning is apart of the selected_SymbolIndex file).
     * @param createdNew_Symbol  (output parameter) let's you know if a new symbol was created, or is false if returning
     *                              an existing symbol.
     * @return
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null
     */
    public Label_Single createNew_Label(String name, boolean has_StaticVersion, Boolean_Mutable createdNew_Symbol)
        throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed {
        return (Label_Single)createNew(SymbolType.Label, name, has_StaticVersion, createdNew_Symbol);
    }






    
    /**
     * Creates a new symbol with the name you passed in. if a symbol already exist, then return that sym object.
     *
     * @param symbolType         The type of symbol you'll create: a standard symbol, a descriptor tagname, or a label
     * @param name
     * @param has_StaticReference  pass in whether this symbol has a static version (meaning is apart of the selected_SymbolIndex file).
     * @return
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null
     */
    public Symbol_Single createNew(SymbolType symbolType, String name, boolean has_StaticVersion)
        throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed {

        return createNew(name, has_StaticVersion, null);
    }

    /**
     * Creates a new symbol with the name you passed in. if a symbol already exist, then return that sym object.
     *
     * @param symbolType         The type of symbol you'll create: a standard symbol, a descriptor tagname, or a label
     * @param name
     * @param has_StaticReference  pass in whether this symbol has a static version (meaning is apart of the selected_SymbolIndex file).
     * @param createdNew_Symbol  (output parameter) let's you know if a new symbol was created, or is false if returning
     *                              an existing symbol.
     * @return
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null
     */
    public Symbol_Single createNew(SymbolType symbolType, String name, boolean has_StaticVersion, Boolean_Mutable createdNew_Symbol)
        throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed {

        if (name == null)
            throw new Exception_InvalidArgumentPassed_Null( "Tried to create a new symbol by name, but you passed in a null name.");

        Symbol_Index selected_SymbolIndex = symbolControl.selectIndex_NonMultiLevel(symbolType);
        Symbol_Single symbol = selected_SymbolIndex.getSingleSymbol_ByName(name);


        if (symbol == null) {
            // The symbol doesn't already exist, create new one a pub in indexes
            switch(symbolType) {
                case Symbol:
                    symbol = new Symbol_Single(name, has_StaticVersion); break;
                case DescriptorTagName:
                    try {
                        symbol = new DescriptorTagName_Single(name, has_StaticVersion);
                    } catch (Exception_DescTagName_IsNotValidName e) {
                        throw new Exception_InvalidArgumentPassed("Bad descTagName (see inner exception).", e);
                    }
                    break;
                case Label:
                    symbol = new Label_Single(name, has_StaticVersion); break;
            }

            selected_SymbolIndex.add(symbol);

            if (createdNew_Symbol != null)
                createdNew_Symbol.value = true;
            return symbol;
        }

        //  if you ever try to create a symbol, even one that exists already and try to set the static version
        //  to true, it will stay true (meaning, has_StaticReference is sticky)
        symbol.has_StaticReference = symbol.has_StaticReference || has_StaticVersion;


        if (createdNew_Symbol != null)
            createdNew_Symbol.value = false;
        return symbol;
    }




    /**
     * Creates a new symbol with the id and name you passed in. if a symbol already exist with that name and id,
     * and the name and id match what you passed in, then return that sym object. If a symbol exists with the same
     * id, but different name (or vice-versa), then throw an exception.
     *
     * @param name
     * @param id
     * @param has_StaticReference  pass in whether this symbol has a static version (meaning is apart of the selected_SymbolIndex file).
     * @param createdNew_Symbol  (output parameter) let's you know if a new symbol was created, or is false if returning
     *                              an existing symbol.
     * @return
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null
     * @throws net.unconventionalthinking.matrix.symbols.Exception_SymbolCreation
     */
    public Symbol_Single createNew(String name, int id, boolean has_StaticVersion, Boolean_Mutable createdNew_Symbol)
        throws Exception_InvalidArgumentPassed, Exception_SymbolCreation {
        return createNew(SymbolType.Symbol, name, id, has_StaticVersion, createdNew_Symbol);
    }

    /**
     * Creates a new descTagName with the id and name you passed in. if a symbol already exist with that name and id,
     * and the name and id match what you passed in, then return that sym object. If a symbol exists with the same
     * id, but different name (or vice-versa), then throw an exception.
     *
     * @param name
     * @param id
     * @param has_StaticReference  pass in whether this symbol has a static version (meaning is apart of the selected_SymbolIndex file).
     * @param createdNew_Symbol  (output parameter) let's you know if a new symbol was created, or is false if returning
     *                              an existing symbol.
     * @return
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null
     * @throws net.unconventionalthinking.matrix.symbols.Exception_SymbolCreation
     */
    public DescriptorTagName_Single createNew_DescTagName(String name, int id, boolean has_StaticVersion, Boolean_Mutable createdNew_Symbol)
        throws Exception_InvalidArgumentPassed, Exception_SymbolCreation {
        return (DescriptorTagName_Single)createNew(SymbolType.DescriptorTagName, name, id, has_StaticVersion, createdNew_Symbol);
    }

    /**
     * Creates a new Label with the id and name you passed in. if a symbol already exist with that name and id,
     * and the name and id match what you passed in, then return that sym object. If a symbol exists with the same
     * id, but different name (or vice-versa), then throw an exception.
     *
     * @param name
     * @param id
     * @param has_StaticReference  pass in whether this symbol has a static version (meaning is apart of the selected_SymbolIndex file).
     * @param createdNew_Symbol  (output parameter) let's you know if a new symbol was created, or is false if returning
     *                              an existing symbol.
     * @return
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null
     * @throws net.unconventionalthinking.matrix.symbols.Exception_SymbolCreation
     */
    public Label_Single createNew_Label(String name, int id, boolean has_StaticVersion, Boolean_Mutable createdNew_Symbol)
        throws Exception_InvalidArgumentPassed, Exception_SymbolCreation {
        return (Label_Single)createNew(SymbolType.Label, name, id, has_StaticVersion, createdNew_Symbol);
    }



    /**
     * Creates a new symbol with the id and name you passed in. if a symbol already exist with that name and id,
     * and the name and id match what you passed in, then return that sym object. If a symbol exists with the same
     * id, but different name (or vice-versa), then throw an exception.
     *
     * @param symbolType         The type of symbol you'll create: a standard symbol, a descriptor tagname, or a label
     * @param name
     * @param id
     * @param has_StaticReference  pass in whether this symbol has a static version (meaning is apart of the selected_SymbolIndex file).
     * @param createdNew_Symbol  (output parameter) let's you know if a new symbol was created, or is false if returning
     *                              an existing symbol.
     * @return
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null
     * @throws net.unconventionalthinking.matrix.symbols.Exception_SymbolCreation
     */
    public Symbol_Single createNew(SymbolType symbolType, String name, int id, boolean has_StaticVersion, Boolean_Mutable createdNew_Symbol)
        throws Exception_InvalidArgumentPassed, Exception_SymbolCreation {

        if (name == null) throw new Exception_InvalidArgumentPassed_Null( "Tried to create a new symbol by name and id, but you passed in a null name.");
        if (id < 0) throw new Exception_InvalidArgumentPassed( "Tried to create a new symbol by name and id, but you passed in an invalid id: " + id + ", with name: " + name);


        Symbol_Index selected_SymbolIndex = symbolControl.selectIndex_NonMultiLevel(symbolType);

        Symbol_Single symbolById = selected_SymbolIndex.getSingleSymbol_ById(id);
        Symbol_Single symbolByName = selected_SymbolIndex.getSingleSymbol_ByName(name);

        if (symbolById == null && symbolByName == null) {
            // The symbol doesn't already exist, create new one a pub in indexes
            Symbol_Single symbol = null;

            switch(symbolType) {
                case Symbol:
                    symbol = new Symbol_Single(name, id, has_StaticVersion); break;
                case DescriptorTagName:
                    try {
                        symbol = new DescriptorTagName_Single(name, id, has_StaticVersion); break;
                    } catch (Exception_DescTagName_IsNotValidName e) {
                        throw new Exception_InvalidArgumentPassed("Bad descTagName (see inner exception).", e);
                    }
                case Label:
                    symbol = new Label_Single(name, id, has_StaticVersion); break;
            }

            selected_SymbolIndex.add(symbol);


            if (createdNew_Symbol != null)
                createdNew_Symbol.value = true;
            return symbol;

        } if (symbolById == symbolByName) {

            //  a symbol obj already exists, and it's the same in both the symbolByID and symbolByName indexes, as it
            //  should be. Return the existing object

            //  even though it already exists, change the has_StaticReference setting
            symbolById.has_StaticReference = has_StaticVersion;

            if (createdNew_Symbol != null)
                createdNew_Symbol.value = false;
            return symbolById;

        } else  {
            throw new Exception_SymbolCreation("Tried to create a symbol with the id and name you passed in, but the name " +
                    "or id you used already exists. If you were trying to maybe accessing an existing one, you need to pass " +
                    "in both the right name and id. The id you passed in was, " + id + " , and the name was, '" + name + "'.");

        }

    }



}
