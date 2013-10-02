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
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.utilities.ListUtilities;
import net.unconventionalthinking.exceptions.*;
import net.unconventionalthinking.matrix.utilities.TextUtilities;


/**
 *
 * @author peterjoh
 */
public class Symbol_MultiPart_Worker {


    SymbolControl symbolControl;
    Symbol_Single_Factory singleSymbol_Factory;

    public Symbol_MultiPart_Worker(SymbolControl symbolControl) {
        this.symbolControl = symbolControl;
        this.singleSymbol_Factory = symbolControl.singleSymbol_Factory;
    }



    public Symbol find(SymbolType symbolType, List<String> symbolStrings)
            throws Exception_MultiPartSymbolAccess {

        Symbol_Index selected_SymbolIndex = symbolControl.selectIndex_NonMultiLevel(symbolType);


        Symbol_Single[] symbols = null;
        List<Symbol_Single> newlyCreatedSymbols = new ArrayList<Symbol_Single>();

        try {
            symbols = getOrCreateEachSingleSymbol(symbolType, symbolStrings, false, Integer.MAX_VALUE, newlyCreatedSymbols);
        } catch (Exception e) {
            throw new Exception_MultiPartSymbolAccess("During MultiPart Symbol find, trying to get the single symbols and had an error (see inner exception).", e);
        }


        
        //  If the symbol is just a single symbol, return the single symbol
        if (symbols.length == 1)
            return symbols[0];

        //  Look through the multi-level hash for the multi-part sym
        Map<Integer, HashOrMultiPartSymbol_Bucket> curr_ChildHash = selected_SymbolIndex.multiPart.multiTreeLevel_MultiPart_Index_By_Id;
        HashOrMultiPartSymbol_Bucket bucket = null;
        for (int i = 0; i < symbols.length; ++i) {

            if (curr_ChildHash != null)
                bucket = curr_ChildHash.get(new Integer(symbols[i].ID));
            else
                throw new Exception_MultiPartSymbolAccess("During MultiPart Symbol find of single symbols, could not find multipart symbol, " + ListUtilities.printWithDot(symbolStrings) + ", in multi-level index.");

            if (bucket != null)
                curr_ChildHash = bucket.hash;
            else
                throw new Exception_MultiPartSymbolAccess("During MultiPart Symbol find of single symbols, could not find multipart symbol, " + ListUtilities.printWithDot(symbolStrings) + ", in multi-level index.");
        }

        if (bucket != null)
            return bucket.multiPartSymbol;
        else
            throw new Exception_MultiPartSymbolAccess("During MultiPart Symbol find of single symbols, could not find multipart symbol, " + ListUtilities.printWithDot(symbolStrings) + ", in multi-level index.");
    }




    public Symbol_Single[] getOrCreateEachSingleSymbol(SymbolType symbolType, List<String> symbolStrings, boolean has_SymbolCreation,
            int creation_StartLevel, List<Symbol_Single> newlyCreatedSymbols)
            throws Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreation {


        Symbol_Index selected_SymbolIndex = symbolControl.selectIndex_NonMultiLevel(symbolType);


        Symbol_Single[] symbols = new Symbol_Single[symbolStrings.size()];

        for (int i = 0; i < symbolStrings.size(); ++i) {

            Symbol_Single symbol;

            // if either is symbol access, or have not started creating single symbols yet
            if (!has_SymbolCreation ||
                ( has_SymbolCreation &&
                  (i + 1) < creation_StartLevel)) {  // Note, creation level starts at 1!

                //  no symbol creation, just access the symbol:
                symbol = selected_SymbolIndex.single_Index_ByName.get(symbolStrings.get(i));

                if ( symbol != null) {
                    symbols[i] = symbol;

                } else {
                    throw new Exception_MultiPartSymbolAccess("Tried to access a single symbol of the multipart symbol: " +
                            ListUtilities.printWithDot(symbolStrings) + ", but could not access the single symbol: " + symbolStrings.get(i) +
                            ", at level " + (i + 1) + " of the multipart symbol. Symbol not found in symbol index.");
                }


            } else {  //  Single Symbol_Single creation

                Boolean_Mutable created_NewSymbol = new Boolean_Mutable(false);

                try {
                    symbol = singleSymbol_Factory.createNew(symbolType, symbolStrings.get(i), has_SymbolCreation, created_NewSymbol);

                } catch (Exception e) {
                    throw new Exception_MultiPartSymbolCreation("Tried to create a single symbol of the multipart symbol: " +
                            ListUtilities.printWithDot(symbolStrings) + ", but could not create the single symbol: " + symbolStrings.get(i) +
                            ", at level " + (i + 1) + " of the multipart symbol. Had a bad argument (see inner exception).", e);

                }



                if (symbol != null) {
                    if (newlyCreatedSymbols != null && created_NewSymbol.value)
                        newlyCreatedSymbols.add(symbol);

                    symbols[i] = symbol;

                } else {
                    throw new Exception_MultiPartSymbolAccess("Tried to create a single symbol of the multipart symbol: " +
                            ListUtilities.printWithDot(symbolStrings) + ", but could not create the single symbol: " + symbolStrings.get(i) +
                            ", at level " + (i + 1) + " of the multipart symbol. Null symbol returned from single symbol creation method.");
                }

            }
        }



        return symbols;

    }





    public Symbol_MultiPart access_MultiPartSymbol(SymbolType symbolType, Symbol_Single[] symbols)
            throws Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreationOrAccess {

        return (addOrAccess_MultiPartSymbol_To_Indexes(symbolType, symbols, false, -1, Integer.MAX_VALUE, false, null));
    }


    public Symbol_MultiPart addOrAccess_MultiPartSymbol_To_Indexes(SymbolType symbolType, Symbol_Single[] symbols,
            int creation_StartLevel, boolean has_StaticVersion)
            throws Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreationOrAccess {

        return addOrAccess_MultiPartSymbol_To_Indexes(symbolType, symbols, false, -1, creation_StartLevel, has_StaticVersion, null);
    }

    public Symbol_MultiPart addOrAccess_MultiPartSymbol_To_Indexes(SymbolType symbolType, Symbol_Single[] symbols,
            boolean passingIn_SymbolID, int multipart_SymbolID, int creation_StartLevel, boolean has_StaticVersion, Boolean_Mutable have_Created_New_MultiPartSymbol)
            throws Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreationOrAccess {

        Symbol_Index selected_SymbolIndex = symbolControl.selectIndex_NonMultiLevel(symbolType);
        if (have_Created_New_MultiPartSymbol != null) have_Created_New_MultiPartSymbol.value = false;


        HashOrMultiPartSymbol_Bucket curr_ChildBucket = null;
        Map<Integer, HashOrMultiPartSymbol_Bucket> curr_ChildHash = selected_SymbolIndex.multiPart.multiTreeLevel_MultiPart_Index_By_Id;
        List<Symbol_Single> symbols_SeenSoFar = new ArrayList<Symbol_Single>();


        for (int i = 0; i < symbols.length; ++i) {

            Integer curr_Child_SingleSymbol_ID = new Integer(symbols[i].ID);
            symbols_SeenSoFar.add(symbols[i]);

            //  Get the curr child bucket for this symbol
            curr_ChildBucket = curr_ChildHash.get(curr_Child_SingleSymbol_ID);



            if (curr_ChildBucket == null) {

                if (i + 1 >= creation_StartLevel || (i + 1) == 1) {
                    // ** Creation level is one greater than the index in the sym array
                    //  since we are above the start creation level, we can add a new multipart symbol (and new bucket)
                    //  to the the multi-level hash
                    // ** OR, it's the first level, and even though there is no symbol creation for the first element, it
                    //  has already been created. for example:
                    //    +:sym1; :sym1.+:sym2
                    //  we can create sym1 at level 1

                    curr_ChildBucket = new HashOrMultiPartSymbol_Bucket();

                    Symbol_MultiPart new_MultiPart_Symbol = null;
                    try {
                        switch(symbolType) {
                            case Symbol:
                                if (passingIn_SymbolID)
                                    new_MultiPart_Symbol = new Symbol_MultiPart(symbols_SeenSoFar, multipart_SymbolID, has_StaticVersion);
                                else
                                    new_MultiPart_Symbol = new Symbol_MultiPart(symbols_SeenSoFar, has_StaticVersion);
                                break;
                            case DescriptorTagName:
                                if (passingIn_SymbolID)
                                    new_MultiPart_Symbol = new DescriptorTagName_MultiPart(symbols_SeenSoFar, multipart_SymbolID, has_StaticVersion);
                                else
                                    new_MultiPart_Symbol = new DescriptorTagName_MultiPart(symbols_SeenSoFar, has_StaticVersion);
                                break;
                            case Label:
                                if (passingIn_SymbolID)
                                    new_MultiPart_Symbol = new Label_MultiPart(symbols_SeenSoFar, multipart_SymbolID, has_StaticVersion);
                                else
                                    new_MultiPart_Symbol = new Label_MultiPart(symbols_SeenSoFar, has_StaticVersion);
                                break;
                        }
                    } catch (Exception e) {
                        throw new Exception_MultiPartSymbolCreation("Tried to create the multipart symbol: " + ListUtilities.printWithDot(symbols) +
                            ", but the symbol segment: " + ListUtilities.printWithDot(symbols_SeenSoFar) + " of the multipart symbol could not be created.");
                    }


                    if (new_MultiPart_Symbol == null) throw new Exception_MultiPartSymbolCreation("Tried to create the multipart symbol: " + ListUtilities.printWithDot(symbols) +
                            ", but the symbol segment: " + ListUtilities.printWithDot(symbols_SeenSoFar) + " of the multipart symbol could not be created.");




                    curr_ChildBucket.multiPartSymbol = new_MultiPart_Symbol;

                    // add the new multiPart Symbol_Single to the indexes (except the "multi-level" multi-part index)
                    selected_SymbolIndex.multiPart.add(new_MultiPart_Symbol);

                    //  now, add it into the multi-level index by adding it to the correct childHash:
                    curr_ChildHash.put(curr_Child_SingleSymbol_ID, curr_ChildBucket);

                    if (have_Created_New_MultiPartSymbol != null)
                        have_Created_New_MultiPartSymbol.value = true;


                } else { // trying to access a child symbol that is not part of multi-part symbol
                    throw new Exception_MultiPartSymbolAccess("(1) Tried to access the multipart symbol: " + ListUtilities.printWithDot(symbols) +
                        ", but the symbol segment: " + ListUtilities.printWithDot(symbols_SeenSoFar) + " of the multipart symbol does not exist");
                }

            } else { // doing multipart access
                // don't need to do anything special except. but left this here just in case you need to add code for
                // this situation, and to do a little error checking
                if (curr_ChildBucket.multiPartSymbol == null)
                    throw new Exception_MultiPartSymbolAccess("(2) Tried to access the multipart symbol: " + ListUtilities.printWithDot(symbols) +
                            ", but the symbol segment: " + ListUtilities.printWithDot(symbols_SeenSoFar) + " of the multipart symbol does not exist");
            }



            //  Advance the curr child hash to the hash of the bucket that has just been created or found
            curr_ChildHash = curr_ChildBucket.hash;
        }

        if (curr_ChildBucket != null && curr_ChildBucket.multiPartSymbol != null)
            return curr_ChildBucket.multiPartSymbol;
        else
            throw new Exception_MultiPartSymbolCreationOrAccess("(3) Tried to access the multipart symbol: " +
                    ListUtilities.printWithDot(symbols) + ", but had an error.");
    }



}
