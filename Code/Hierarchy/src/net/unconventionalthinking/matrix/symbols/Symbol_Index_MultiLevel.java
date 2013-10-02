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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 *
 * @author peterjoh
 */
public class Symbol_Index_MultiLevel extends Symbol_Index_Base {

    Map<Integer, Symbol_MultiLevel> multiLevel_Index_ByID = new HashMap<Integer, Symbol_MultiLevel>();
    Map<String, Symbol_MultiLevel> multiLevel_Index_ByName = new HashMap<String, Symbol_MultiLevel>();
    Map<String, Symbol_MultiLevel> multiLevel_Index_ByName_IdentFormat = new HashMap<String, Symbol_MultiLevel>();
    List<Symbol_MultiLevel> multiLevel_List = new ArrayList<Symbol_MultiLevel>();





    @Override
    public void add(Symbol symbol) {

        super.add(symbol);

        Symbol_MultiLevel multiLevelSymbol = (Symbol_MultiLevel) symbol;

        multiLevel_Index_ByID.put(new Integer(multiLevelSymbol.ID), multiLevelSymbol);

        multiLevel_Index_ByName.put(multiLevelSymbol.name, multiLevelSymbol);
        multiLevel_Index_ByName_IdentFormat.put(multiLevelSymbol.name_IdentFormat, multiLevelSymbol);

        multiLevel_List.add(multiLevelSymbol);

    }

    public Symbol_MultiLevel get_MultiLevelSymbol_ById(int symbol_ID) {
        return multiLevel_Index_ByID.get(new Integer(symbol_ID));
    }

    public Symbol_MultiLevel get_MultiLevelSymbol_ByName(String multiLevelName_w_Backtiks) {
        return multiLevel_Index_ByName.get(multiLevelName_w_Backtiks);
    }

    public Symbol_MultiLevel get_MultiLevelSymbol_ByName_IdentFormat(String multiLevelName_IdentFormat) {
        return multiLevel_Index_ByName_IdentFormat.get(multiLevelName_IdentFormat);
    }



    public List<Symbol_MultiLevel> get_MultiLevelSymbol_List() {
        return multiLevel_List;
    }




}
