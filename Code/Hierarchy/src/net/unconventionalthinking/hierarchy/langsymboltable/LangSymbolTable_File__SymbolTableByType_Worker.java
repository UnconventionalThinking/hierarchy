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

package net.unconventionalthinking.hierarchy.langsymboltable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol.SymbolType;

/**
 *
 * @author Peter Joh
 */
public class LangSymbolTable_File__SymbolTableByType_Worker {

    private Map<LangSymbol.SymbolType, TreeMap<Integer, List<LangSymbol>>>  symbolTable_bySymbolType;

    public LangSymbolTable_File__SymbolTableByType_Worker(Map<SymbolType, TreeMap<Integer, List<LangSymbol>>> symbolTable_bySymbolType) {
        this.symbolTable_bySymbolType = symbolTable_bySymbolType;
    }





    /**
     * Add symbol to the symbolTable_bySymbolType is organized first by symbolType, then by scope id. It's useful for things like matrixAccess,
     * where at a certain scope level, you want to know if there are any matrix accesses at a certain scope.
     */
    void addSymbolto_SymbolTypesMap(LangSymbol.SymbolType symbolType, LangSymbol langSymbol) {

        TreeMap<Integer, List<LangSymbol>> treeMap_forSymbolType = symbolTable_bySymbolType.get(symbolType);
        if (treeMap_forSymbolType == null) {
            treeMap_forSymbolType = new TreeMap<Integer, List<LangSymbol>>();
            symbolTable_bySymbolType.put(symbolType, treeMap_forSymbolType);
        }

        // now, see there is a list of symbols there already (the list contains all the symbols with the same name at the same scope level)
        Integer scopeID = new Integer(langSymbol.scopeID);
        List<LangSymbol> symbolsList__forScopeLevel = treeMap_forSymbolType.get(scopeID);
        if (symbolsList__forScopeLevel == null) {
            symbolsList__forScopeLevel = new ArrayList<LangSymbol>();
            treeMap_forSymbolType.put(scopeID, symbolsList__forScopeLevel);
        }

        // add the sym to the symbol list
        symbolsList__forScopeLevel.add(langSymbol);
    }


  

}
