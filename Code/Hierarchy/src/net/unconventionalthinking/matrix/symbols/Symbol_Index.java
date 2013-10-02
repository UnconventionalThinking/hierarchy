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

/**
 *
 *
 *
 * @author peterjoh
 */
// ** Do this when you have time **
// TODO  for MultiPart index by MultiPart Name, need to define and good hashCode() algorithm for it, and equals(), so
//       hashing by MultiPart name is very fast!!
public class Symbol_Index extends Symbol_Index_Base {

    //  Child Indexes:
    public final Symbol_Index_MultiPart multiPart = new Symbol_Index_MultiPart();

    Map<Integer, Symbol_Single> single_Index_ByID = new HashMap<Integer, Symbol_Single>();
    Map<String, Symbol_Single>  single_Index_ByName = new HashMap<String, Symbol_Single>();
    Map<String, Symbol_Single>  single_Index_ByName_IdentFormat = new HashMap<String, Symbol_Single>();
    List<Symbol_Single>         single_List = new ArrayList<Symbol_Single>();

    Map<Integer, Symbol>        singleAndMultiPart_SymbolIndex_ByID = new HashMap<Integer, Symbol>();

    
    @Override
    public void add(Symbol symbol) {

        super.add(symbol);

        Symbol_Single singleSymbol = (Symbol_Single) symbol;

        single_Index_ByID.put(new Integer(symbol.ID), singleSymbol);
        single_Index_ByName.put(singleSymbol.name, singleSymbol);
        single_Index_ByName_IdentFormat.put(singleSymbol.name_IdentFormat, singleSymbol);
        single_List.add(singleSymbol);

        singleAndMultiPart_SymbolIndex_ByID.put(new Integer(symbol.ID), singleSymbol);

    }

    public Symbol_Single getSingleSymbol_ByName(String symbolName) {
        return single_Index_ByName.get(symbolName);
    }

    public Symbol_Single getSingleSymbol_ById(int symbol_ID) {
        return (Symbol_Single) single_Index_ByID.get(new Integer(symbol_ID));
    }

    public List<Symbol_Single> getSingleSymbol_List() {
        return single_List;
    }

    public Symbol getSingleOrMultiPartSymbol_ById(int symbol_ID) {
        return singleAndMultiPart_SymbolIndex_ByID.get(new Integer(symbol_ID));
    }

    

    public class Symbol_Index_MultiPart extends Symbol_Index_Base {

        Map<Integer, Symbol_MultiPart> multiPart_Index_ByID = new HashMap<Integer, Symbol_MultiPart>();
        Map<SymbolName, Symbol_MultiPart> multiPart_Index_ByMultiPartName = new HashMap<SymbolName, Symbol_MultiPart>();
        Map<String, Symbol_MultiPart> multiPart_Index_ByName = new HashMap<String, Symbol_MultiPart>();
        Map<String, Symbol_MultiPart> multiPart_Index_ByName_IdentFormat = new HashMap<String, Symbol_MultiPart>();
        List<Symbol_MultiPart> multiPart_List = new ArrayList<Symbol_MultiPart>();
        /**
         * The Multi Tree-Level, MultiPart Symbol_Single Index.
         * Used only during multi-part symbol creation, to quickly find if the Multi-Part Symbol_Single _segments_ have been
         * created as multipart symbols (meaning, you can't do a m.p. sym. creation like,
         *    :sym1.sym2.+:sym3, if :sym.+sym2 hasn't already been created.
         *  BUT, you could just do :sym1.+sym2.:sym3. This will create :sym1.sym2 and :sym1.sym2.sym3
         */
        Map<Integer, HashOrMultiPartSymbol_Bucket> multiTreeLevel_MultiPart_Index_By_Id =
                new HashMap<Integer, HashOrMultiPartSymbol_Bucket>();

        /**
         * Note: this method does not add the the multipart symbol to the multilevel_MultiPart_Index_By_Id (why?
         * because this is a complex operation). This is done by the method:
         * Symbol_MultiPart_Worker.addOrAccess_MultiPartSymbol_To_Indexes().
         *
         * @param symbol
         */
        @Override
        public void add(Symbol symbol) {

            super.add(symbol);

            Symbol_MultiPart multiPartSymbol = (Symbol_MultiPart) symbol;

            multiPart_Index_ByID.put(new Integer(multiPartSymbol.ID), multiPartSymbol);

            multiPart_Index_ByMultiPartName.put(multiPartSymbol.name_MultiPart, multiPartSymbol);
            multiPart_Index_ByName.put(multiPartSymbol.name, multiPartSymbol);
            multiPart_Index_ByName_IdentFormat.put(multiPartSymbol.name_IdentFormat, multiPartSymbol);

            multiPart_List.add(multiPartSymbol);

            singleAndMultiPart_SymbolIndex_ByID.put(new Integer(symbol.ID), symbol);


        }

        public Symbol_MultiPart get_MultiPartSymbol_ById(int symbol_ID) {
            return multiPart_Index_ByID.get(new Integer(symbol_ID));
        }

        public Symbol_MultiPart get_MultiPartSymbol_ByName(String multiPartName_w_Backtiks) {
            return multiPart_Index_ByName.get(multiPartName_w_Backtiks);
        }

        public Symbol_MultiPart get_MultiPartSymbol_ByName_IdentFormat(String multiPartName_IdentFormat) {
            return multiPart_Index_ByName_IdentFormat.get(multiPartName_IdentFormat);
        }

        public Symbol_MultiPart get_MultiPartSymbol_ByMultiPartName(SymbolName multiPartName) {
            return multiPart_Index_ByMultiPartName.get(multiPartName);
        }

        public Map<Integer, HashOrMultiPartSymbol_Bucket> get_MultiLevel_Index() {
            return multiTreeLevel_MultiPart_Index_By_Id;
        }

        public List<Symbol_MultiPart> get_MultiPartSymbol_List() {
            return multiPart_List;
        }
    }






}
