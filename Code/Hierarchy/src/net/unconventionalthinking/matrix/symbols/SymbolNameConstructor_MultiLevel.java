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
public class SymbolNameConstructor_MultiLevel implements SymbolNameConstructor {

    
    public static SymbolNameConstructor_MultiLevel constructor = new SymbolNameConstructor_MultiLevel();
    
    

    public String[] construct(Object listOfNames, SymbolName.NameListType nameListType, int numOfNames, StringBuilder nameBuilder,
            StringBuilder nameBuilder_no_backtiks, StringBuilder nameBuilder_IdentFormat)
            throws Exception_InvalidArgumentPassed_Null {

        String[] names = new String[numOfNames];

        for (int i = 0; i < names.length;  ++i) {

            Symbol symbolPart;
            if (nameListType == nameListType.arrayOfSymbols) {
                symbolPart = ((Symbol[])listOfNames)[i];
            } else {// is a list of Symbols
                symbolPart = ((List<Symbol>)listOfNames).get(i);
            }


            nameBuilder.append(symbolPart.name);
            nameBuilder_no_backtiks.append(symbolPart.name_no_backtiks);
            nameBuilder_IdentFormat.append(symbolPart.name_IdentFormat);

            names[i] = symbolPart.name_no_backtiks;

            
            // separator:
            if (i < (names.length - 1)) { // not the last
                nameBuilder.append("::"); // just the standard dot
                nameBuilder_no_backtiks.append("::"); // just the standard dot
                nameBuilder_IdentFormat.append(SymbolConstants.ThreeLevelSymbol_Separator_IdentFormat);
            }

        }

        return names;

    }



}
