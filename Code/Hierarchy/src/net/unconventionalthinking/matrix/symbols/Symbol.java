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

import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null;
import net.unconventionalthinking.utilities.IdCreator;
import net.unconventionalthinking.matrix.utilities.*;
import net.unconventionalthinking.lang.*;



/**
 *
 * @author peterjoh
 */
public abstract class Symbol implements Symbol_Base {


    //  Symbol_Single Values
    public final String name;
    public final String name_IdentFormat;
    public final String name_no_backtiks;
    public final int    ID;

    public final boolean is_SingleSymbol;
    public final boolean is_MultiPartSymbol;
    public final boolean is_3LevelSymbol;

    //  Why is SymbolName in the base class instead of the Symbol_MultiPart class?
    //
    //  Normally, this would be apart of the child class, but, since I want these to be final members, I needed
    //  to put this is the base_class. Why? because the easiest and most efficient way to compute the name, and the 
    //  name_IdentFormat (and the name_MultiPart) is to do it all once, in one method call. BUT, because name and
    //  name_Ident_Format are both final variables, in the Symbol_MultiPart() constructor, you need to set them by passing 
    //  their values from the child to the base class object (Symbol) using "super()" as the FIRST method call!
    //  To do this with_out_ having name_MultiPart as apart of SymbolBase, you would need to call a method call for 
    //  each one, In the MultiPart constructor:
    //  
    //      super(create_MultiPart_NameString(symbols), create_MultiPart_Name_IdentFormat(symbols)...);
    //      this.name_MultiPart = create_MultiPart_Name(symbols);
    //
    //  Not very efficient in its performance.
    public final SymbolName name_MultiPart;



    // this one is changeable by other classes, just in case the static-ness is modified
    public boolean has_StaticReference;



    //  Shared by both single and multipart symbols
    static IdCreator idCreator = new IdCreator();

    

    /**
     * Single Symbol_Single constructor
     *
     * @param name
     * @param id
     * @param has_StaticReference
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null
     */
    public Symbol(String name, int id, boolean has_StaticVersion)
            throws Exception_InvalidArgumentPassed_Null {

        if (name == null)
            throw new Exception_InvalidArgumentPassed_Null("Expected a Symbol Name, but was passed null.");

        this.name = name;
        this.name_no_backtiks = name;
        Boolean_Mutable have_ModifiedString = new Boolean_Mutable(false);

        this.name_IdentFormat = TextUtilities.convertTextToIdentifier(name.toString());
        this.ID = id;

        this.has_StaticReference = has_StaticVersion;

        //  This is a single Symbol_Single, set MultiPart Name to null:
        name_MultiPart = null;

        is_SingleSymbol = true;
        is_MultiPartSymbol = false;
        is_3LevelSymbol = false;
    }



    
    //  ________________________________________________________________________________________________________________
    //
    //  MultiPart Symbol Constructors
    //  NOTE: these constructors are in the parent class because they need to set final variables that belong to the
    //  parent (and thus, can only be set in the parent)
    //  ________________________________________________________________________________________________________________

    /**
     * MultiPart Symbol_Single Constructor
     *
     * @param symbolStrings
     * @param id
     * @param has_StaticReference
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null
     */
    public Symbol(String[] symbolStrings, int id, boolean has_StaticVersion)
            throws Exception_InvalidArgumentPassed_Null {

        this(SymbolName.NameListType.arrayOfStrings, symbolStrings, id, has_StaticVersion);
    }


    /**
     * MultiPart Symbol_Single Constructor
     *
     * @param symbols
     * @param id
     * @param has_StaticReference
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null
     */
    public Symbol(Symbol_Single[] symbols, int id, boolean has_StaticVersion)
            throws Exception_InvalidArgumentPassed_Null {

        this(SymbolName.NameListType.arrayOfSymbols, symbols, id, has_StaticVersion);
    }

    /**
     * MultiPart Symbol_Single Constructor
     *
     * @param symbols
     * @param id
     * @param has_StaticReference
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null
     */
    public Symbol(List<Symbol_Single> symbols, int id, boolean has_StaticVersion)
            throws Exception_InvalidArgumentPassed_Null {

        this(SymbolName.NameListType.listOfSymbols, symbols, id, has_StaticVersion);
    }

    private Symbol(SymbolName.NameListType nameListType, Object listOfSymbols, int id, boolean has_StaticVersion)
        throws Exception_InvalidArgumentPassed_Null {

        if (listOfSymbols == null) throw new Exception_InvalidArgumentPassed_Null("Expected symbols, but was passed null.");



        //  Why not use reflection here? because, I don't want the performance overhead. This code may be called
        //  a lot!
        SymbolName created_MultiPartName;
        if (nameListType == SymbolName.NameListType.arrayOfStrings)
            created_MultiPartName = new SymbolName((String[])listOfSymbols, SymbolNameConstructor_MultiPart.constructor);
        if (nameListType == SymbolName.NameListType.arrayOfSymbols)
            created_MultiPartName = new SymbolName((Symbol_Single[])listOfSymbols, SymbolNameConstructor_MultiPart.constructor);
        else
            created_MultiPartName = new SymbolName((List<Symbol_Single>)listOfSymbols, SymbolNameConstructor_MultiPart.constructor);

        name_MultiPart = created_MultiPartName;

        this.is_SingleSymbol = false;
        this.is_MultiPartSymbol = true;
        this.is_3LevelSymbol = false;

        this.name = name_MultiPart.name;
        this.name_no_backtiks = name_MultiPart.name_no_backtiks;
        this.name_IdentFormat = name_MultiPart.name_IdentFormat;
        this.ID = id;

        this.has_StaticReference = has_StaticVersion;

    }






    //  ________________________________________________________________________________________________________________
    //
    //  3-Level Symbol Constructors
    //  NOTE: these constructors are in the parent class because they need to set final variables that belong to the
    //  parent (and thus, can only be set in the parent)
    //  ________________________________________________________________________________________________________________

    
    /**
     * 3-Level Symbol Constructor
     *
     * @param is_3LevelSymbol     used to differentiate 3-level constructor from other Symbol constructors. this should always be true
     * @param symbols
     * @param id
     * @param has_StaticReference
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null
     */
    public Symbol(boolean is_3LevelSymbol, Symbol[] symbols, int id, boolean has_StaticVersion)
            throws Exception_InvalidArgumentPassed_Null {

        this(true, SymbolName.NameListType.arrayOfSymbols, symbols, id, has_StaticVersion);
    }

    /**
     * 3-Level Symbol Constructor
     *
     * @param is_3LevelSymbol     used to differentiate 3-level constructor from other Symbol constructors. this should always be true
     * @param symbols
     * @param id
     * @param has_StaticReference
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null
     */
    public Symbol(boolean is_3LevelSymbol, List<Symbol> symbols, int id, boolean has_StaticVersion)
            throws Exception_InvalidArgumentPassed_Null {

        this(true, SymbolName.NameListType.listOfSymbols, symbols, id, has_StaticVersion);
    }

    /**
     * Constructor for 3 Level symbols
     * 
     * @param is_3LevelSymbol     used to differentiate 3-level constructor from other Symbol constructors. this should always be true
     * @param id
     * @param has_StaticReference
     */
    Symbol(boolean is_3LevelSymbol, SymbolName.NameListType nameListType, Object listOfSymbols, int id, boolean has_StaticVersion)
        throws Exception_InvalidArgumentPassed_Null {


        //  Why not use reflection here? because, I don't want the performance overhead. This code may be called
        //  a lot!
        SymbolName created_MultiPartName;
        if (nameListType == SymbolName.NameListType.arrayOfSymbols)
            created_MultiPartName = new SymbolName((Symbol[])listOfSymbols, SymbolNameConstructor_MultiLevel.constructor);
        else
            created_MultiPartName = new SymbolName((List<Symbol>)listOfSymbols, SymbolNameConstructor_MultiLevel.constructor, MPSymbols.Symbol);

        name_MultiPart = created_MultiPartName;


        this.is_SingleSymbol = false;
        this.is_MultiPartSymbol = false;
        this.is_3LevelSymbol = true;

        this.name = name_MultiPart.name;
        this.name_no_backtiks = name_MultiPart.name_no_backtiks;
        this.name_IdentFormat = name_MultiPart.name_IdentFormat;
        this.ID = id;

        this.has_StaticReference = has_StaticVersion;

    }






    

    @Override
    public String toString() {
        return name;
    }

    // two symbols can only be equal if they are the same symbol object!
    @Override
    public boolean equals(Object other) {

        if (this == other)
            return true; // same object
        else
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * (hash + ID);
        return hash;
    }

    

    public boolean is_Single() { return is_SingleSymbol; }
    public boolean is_MultiPart() { return is_MultiPartSymbol; }
    public boolean is_3LevelSymbol() { return is_3LevelSymbol; }


    public SymbolType getSymbolType() { return SymbolType.Symbol; }

    public boolean has_StaticReference() { return has_StaticReference; }

    

    //  These methods are for multi-part symbols, but can be called on single symbols
    public int getNumOfParts() {
        return 1;
    }
    public String[] getSymbolNames() {
        return new String[] { name };
    }
    public Symbol getSymbol_AtPartNum(int i) {
        if (i == 1)
            return this;
        else
            return null;
    }

    public int getSymbolId_AtPartNum(int i, Boolean_Mutable found_SymbolAtPartNum) {
        if (i == 1) {
            found_SymbolAtPartNum.value = false;
            return ID;  
        } else {
            found_SymbolAtPartNum.value = true;
            return -1;
        }
    }

    public String getSymbolName_AtPartNum(int i) {
        if (i == 1)
            return name;  
        else
            return null;
    }

    public int getID() { return ID; }
    public final String getName() { return name; }
    public final String get_Name_IdentFormat() { return name_IdentFormat; }
    public final String get_Name_no_backtiks() { return name_no_backtiks; }



    

}
