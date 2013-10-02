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
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.utilities.TextUtilities;

/**
 *
 * @author peterjoh
 */
public class SymbolName {


    /**
     * Array of names, (unmodified)
     */
    public final String[] names;

    /**
     * A combined string name for the multi-part symbol. if a single symbol name has special characters, it will
     * be put in backtiks. So: :"sym 1!".sym2  becomes  `sym 1!`.sym2
     */
    public final String name;
    /**
     * NOTE: this multipart name is NOT a unique name!!
     */
    public final String name_no_backtiks;
    /**
     * A combined string name where all the single symbol names are in identifier format, and separated by the
     * special string: "$__$"
     */
    public final String name_IdentFormat;


    /**
     * Why is there a separate item for ListOfSingleSymbols but no arrayOrSingleSymbols? Because an Symbol[] variable can be
     * set to a child type (so can be set to Symbol_Single[]). But, an List<Symbol> cannot be set to a List<Symbol_Single>, this
     * is a syntax error, so we need a separate item for it.
     */
    public enum NameListType { arrayOfStrings, arrayOfSymbols, listOfSingleSymbols, listOfSymbols }





    
    public SymbolName(String[] names, SymbolNameConstructor constructor) throws Exception_InvalidArgumentPassed_Null {

        StringBuilder nameBuilder = new StringBuilder();
        StringBuilder nameBuilder_no_backtiks = new StringBuilder();
        StringBuilder nameBuilder_IdentFormat = new StringBuilder();
        
        this.names =  constructor.construct(names, NameListType.arrayOfStrings, names.length,
                                    nameBuilder, nameBuilder_no_backtiks, nameBuilder_IdentFormat);

        this.name = nameBuilder.toString();
        this.name_no_backtiks = nameBuilder_no_backtiks.toString();
        this.name_IdentFormat = nameBuilder_IdentFormat.toString();

    }

    public SymbolName(Symbol[] names, SymbolNameConstructor constructor) throws Exception_InvalidArgumentPassed_Null {

        StringBuilder nameBuilder = new StringBuilder();
        StringBuilder nameBuilder_no_backtiks = new StringBuilder();
        StringBuilder nameBuilder_IdentFormat = new StringBuilder();

        this.names =  constructor.construct(names, NameListType.arrayOfSymbols, names.length,
                                    nameBuilder, nameBuilder_no_backtiks, nameBuilder_IdentFormat);

        this.name = nameBuilder.toString();
        this.name_no_backtiks = nameBuilder_no_backtiks.toString();
        this.name_IdentFormat = nameBuilder_IdentFormat.toString();

    }

    public SymbolName(List<Symbol_Single> names, SymbolNameConstructor constructor) throws Exception_InvalidArgumentPassed_Null {

        StringBuilder nameBuilder = new StringBuilder();
        StringBuilder nameBuilder_no_backtiks = new StringBuilder();
        StringBuilder nameBuilder_IdentFormat = new StringBuilder();

        this.names =  constructor.construct(names, NameListType.listOfSingleSymbols, names.size(),
                                    nameBuilder, nameBuilder_no_backtiks, nameBuilder_IdentFormat);

        this.name = nameBuilder.toString();
        this.name_no_backtiks = nameBuilder_no_backtiks.toString();
        this.name_IdentFormat = nameBuilder_IdentFormat.toString();

    }

    /**
     *
     * @param names
     * @param constructor
     * @param dummyParam        pass in a dummy parameter to differentiate this constructor from SymbolName(List<Symbol_Single> names,...)
     * @throws Exception_InvalidArgumentPassed_Null
     */
    public SymbolName(List<Symbol> names, SymbolNameConstructor constructor, Symbol dummyParam) throws Exception_InvalidArgumentPassed_Null {

        StringBuilder nameBuilder = new StringBuilder();
        StringBuilder nameBuilder_no_backtiks = new StringBuilder();
        StringBuilder nameBuilder_IdentFormat = new StringBuilder();

        this.names =  constructor.construct(names, NameListType.listOfSymbols, names.size(),
                                    nameBuilder, nameBuilder_no_backtiks, nameBuilder_IdentFormat);

        this.name = nameBuilder.toString();
        this.name_no_backtiks = nameBuilder_no_backtiks.toString();
        this.name_IdentFormat = nameBuilder_IdentFormat.toString();

    }








    @Override
    public String toString() { return name; }


    @Override
    public boolean equals(Object value) {

        if (this == value) return true; // same object
        if (value == null) return false;
        if (getClass() != value.getClass()) return false; // not the same class

        SymbolName other_SymbolName_MultiPart = (SymbolName)value;

        return this.name_IdentFormat.equals(other_SymbolName_MultiPart.name_IdentFormat);

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }
}
