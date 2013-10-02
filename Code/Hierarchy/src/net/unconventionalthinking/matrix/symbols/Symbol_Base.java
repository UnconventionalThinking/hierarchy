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

import net.unconventionalthinking.lang.Boolean_Mutable;

/**
 * The only point of this interface is so that you can reference a
 *
 * @author peterjoh
 */
public interface Symbol_Base {

    public boolean is_Single();
    public boolean is_MultiPart();
    public boolean is_3LevelSymbol();



    //  These methods are for multi-part symbols, but can be called on single symbols
    public int getNumOfParts();

    public String[] getSymbolNames();
    /**
     * part numbers starts at 1!
     */
    public Symbol getSymbol_AtPartNum(int i);

    /**
     * part numbers starts at 1!
     */
    public int getSymbolId_AtPartNum(int i, Boolean_Mutable found_SymbolAtLevel);

    /**
     * part numbers starts at 1!
     */
    public String getSymbolName_AtPartNum(int i);
    public SymbolType getSymbolType();


    public int getID();
    public String getName();
    public String get_Name_IdentFormat();
    public String get_Name_no_backtiks();

    public boolean has_StaticReference();


}

