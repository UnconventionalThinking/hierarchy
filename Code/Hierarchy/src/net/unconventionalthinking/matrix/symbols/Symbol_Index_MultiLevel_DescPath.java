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

import net.unconventionalthinking.lang.MultiID_Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 *
 * @author peterjoh
 */
public class Symbol_Index_MultiLevel_DescPath extends Symbol_Index_MultiLevel {

    Map<MultiID_Key, DescriptorPath> descTagIndex_BySchemaNameAndDescTag = new HashMap<MultiID_Key, DescriptorPath>();





    //  Descriptor Tag Methods _____________________________________________________________________________________

    @Override
    public void add(Symbol descPath_Symbol) {

        super.add((Symbol) descPath_Symbol);

        DescriptorPath_MultiLevel descPath = (DescriptorPath_MultiLevel)descPath_Symbol;

        descTagIndex_BySchemaNameAndDescTag.put(new MultiID_Key(descPath.get_ID_List()), descPath);


    }



    public DescriptorPath get_byDescTagName_PathList(List<Symbol> descTagName_PathList, SymbolControl symbolControl) {

        List<Integer> id_List = new ArrayList<Integer>();


        for (Symbol descTagName : descTagName_PathList) {
            id_List.add(((Symbol)descTagName).ID);
        }

        return descTagIndex_BySchemaNameAndDescTag.get(new MultiID_Key(id_List));
    }


    public DescriptorPath get_byDescTagNameString_PathList(List<String> descTagName_PathList, SymbolControl symbolControl) throws Exception_MultiPartSymbolAccess {

        return descTagIndex_BySchemaNameAndDescTag.get(new MultiID_Key(get_ID_List(descTagName_PathList, symbolControl)));
    }


    
    public static List<Integer> get_ID_List(List<String> descTagName_PathList, SymbolControl symbolControl) throws Exception_MultiPartSymbolAccess {

        List<Integer> id_List = new ArrayList<Integer>();


        for (String descTagName_String : descTagName_PathList) {
            DescriptorTagName descTagName = symbolControl.multiPartSymbol_Factory.find_DescTagName(descTagName_String);
            id_List.add(new Integer(descTagName.getID()));
        }

        return id_List;
    }


    public static List<DescriptorTagName> get_DescTagName_List(List<String> descTagName_PathList, SymbolControl symbolControl) throws Exception_MultiPartSymbolAccess {

        List<DescriptorTagName> descTagName_List = new ArrayList<DescriptorTagName>();


        for (String descTagName_String : descTagName_PathList) {
            DescriptorTagName descTagName = symbolControl.multiPartSymbol_Factory.find_DescTagName(descTagName_String);
            descTagName_List.add(descTagName);
        }

        return descTagName_List;
    }

    public static List<Symbol> get_DescTagName_SymbolList(List<String> descTagName_PathList, SymbolControl symbolControl) throws Exception_MultiPartSymbolAccess {

        List<Symbol> descTagName_List = new ArrayList<Symbol>();


        for (String descTagName_String : descTagName_PathList) {
            DescriptorTagName descTagName = symbolControl.multiPartSymbol_Factory.find_DescTagName(descTagName_String);
            descTagName_List.add((Symbol)descTagName);
        }

        return descTagName_List;
    }


}
