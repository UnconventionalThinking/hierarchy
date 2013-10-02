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

/**
 *
 * @author peterjoh
 */
public class Symbol_MultiPart_Factory {

    SymbolControl symbolControl;

    Symbol_MultiPart_Worker symbol_MultiPart_Worker;


    public Symbol_MultiPart_Factory(SymbolControl symbolControl) {
        this.symbolControl = symbolControl;

        symbol_MultiPart_Worker = new Symbol_MultiPart_Worker(symbolControl);
    }





    public Symbol createNew(List<String> symbolStrings, int creation_StartLevel,
                    boolean creation_Has_StaticVersion)
                throws Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreationOrAccess {

        return createNew(SymbolType.Symbol, symbolStrings, false, -1, creation_StartLevel, creation_Has_StaticVersion, null, null);
    }

    public Symbol createNew(List<String> symbolStrings, int creation_StartLevel,
                    boolean creation_Has_StaticVersion, Boolean_Mutable have_Created_New_MultiPartSymbol,
                    List<Symbol_Single> newlyCreatedSymbols)
                throws Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreationOrAccess {

        return createNew(SymbolType.Symbol, symbolStrings, false, -1, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);
    }


    public Symbol createNew(List<String> symbolStrings, int multipart_SymbolID, int creation_StartLevel,
                    boolean creation_Has_StaticVersion, Boolean_Mutable have_Created_New_MultiPartSymbol,
                    List<Symbol_Single> newlyCreatedSymbols)
                throws Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreationOrAccess {

        return createNew(SymbolType.Symbol, symbolStrings, true, multipart_SymbolID, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);
    }



    /**
     * createNew_DescTagName() - this method can take the full descTagnName string, split it into its different parts, and then construct a list
     * for it for each part to use to create the possibly multipart symbol. Only DescTagName can do this, because a desc tagname can not have dots
     * or spaces in any of the parts!
     *
     * @param fullDescTagNameString   for example: "MY.DESC.NAME"
     * @param creation_StartLevel
     * @param creation_Has_StaticVersion
     * @param have_Created_New_MultiPartSymbol
     * @param newlyCreatedSymbols
     * @return
     * @throws Exception_MultiPartSymbolCreation
     * @throws Exception_MultiPartSymbolAccess
     * @throws Exception_MultiPartSymbolCreationOrAccess
     */
    public DescriptorTagName createNew_DescTagName(String fullDescTagNameString, int creation_StartLevel,
                    boolean creation_Has_StaticVersion, Boolean_Mutable have_Created_New_MultiPartSymbol,
                    List<Symbol_Single> newlyCreatedSymbols)
                throws Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreationOrAccess {

        return (DescriptorTagName)createNew(SymbolType.DescriptorTagName,
                DescriptorTagName_Utilities.split_DescTagNameString_into_PartsList(fullDescTagNameString),
                false, -1, creation_StartLevel,
                creation_Has_StaticVersion, null, null);
    }

    public DescriptorTagName createNew_DescTagName(List<String> symbolStrings, int creation_StartLevel,
                    boolean creation_Has_StaticVersion)
                throws Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreationOrAccess {

        return (DescriptorTagName)createNew(SymbolType.DescriptorTagName, symbolStrings, false, -1, creation_StartLevel, creation_Has_StaticVersion, null, null);
    }
    public DescriptorTagName createNew_DescTagName(List<String> symbolStrings, int creation_StartLevel,
                    boolean creation_Has_StaticVersion, Boolean_Mutable have_Created_New_MultiPartSymbol,
                    List<Symbol_Single> newlyCreatedSymbols)
                throws Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreationOrAccess {

        return (DescriptorTagName)createNew(SymbolType.DescriptorTagName, symbolStrings, false, -1, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);
    }
    public DescriptorTagName createNew_DescTagName(List<String> symbolStrings, int multipart_SymbolID, int creation_StartLevel,
                    boolean creation_Has_StaticVersion, Boolean_Mutable have_Created_New_MultiPartSymbol,
                    List<Symbol_Single> newlyCreatedSymbols)
                throws Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreationOrAccess {

        return (DescriptorTagName)createNew(SymbolType.DescriptorTagName, symbolStrings, true, multipart_SymbolID, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);
    }





    public Label createNew_Label(List<String> symbolStrings, int creation_StartLevel,
                    boolean creation_Has_StaticVersion)
                throws Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreationOrAccess {

        return (Label)createNew(SymbolType.Label, symbolStrings, false, -1, creation_StartLevel, creation_Has_StaticVersion, null, null);
    }
    public Label createNew_Label(List<String> symbolStrings, int creation_StartLevel,
                    boolean creation_Has_StaticVersion, Boolean_Mutable have_Created_New_MultiPartSymbol,
                    List<Symbol_Single> newlyCreatedSymbols)
                throws Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreationOrAccess {

        return (Label)createNew(SymbolType.Label, symbolStrings, false, -1, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);
    }
    public Label createNew_Label(List<String> symbolStrings, int multipart_SymbolID, int creation_StartLevel,
                    boolean creation_Has_StaticVersion, Boolean_Mutable have_Created_New_MultiPartSymbol,
                    List<Symbol_Single> newlyCreatedSymbols)
                throws Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreationOrAccess {

        return (Label)createNew(SymbolType.Label, symbolStrings, true, multipart_SymbolID, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);
    }









    public Symbol createNew(SymbolType symbolType, List<String> symbolStrings, int creation_StartLevel,
                    boolean creation_Has_StaticVersion, Boolean_Mutable have_Created_New_MultiPartSymbol,
                    List<Symbol_Single> newlyCreatedSymbols)
                throws Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreationOrAccess {

        return createNew(symbolType, symbolStrings, false, -1, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);
    }

    public Symbol createNew(SymbolType symbolType, List<String> symbolStrings, boolean passingIn_SymbolID, int multipart_SymbolID,
                    int creation_StartLevel, boolean creation_Has_StaticVersion, Boolean_Mutable have_Created_New_MultiPartSymbol,
                    List<Symbol_Single> newlyCreatedSymbols)
                throws Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreationOrAccess {

        Symbol_Single[] symbols = null;
        try {
            symbols = symbol_MultiPart_Worker.getOrCreateEachSingleSymbol(symbolType, symbolStrings, true, creation_StartLevel,
                                                                             newlyCreatedSymbols);
        } catch (Exception_MultiPartSymbolCreation e) {
            throw e;
        }

        //  if the symbol is just a symbol with only a single part, then return the single symbol. Else, try to create a multipart symbol
        if (symbols.length == 1) {
            return symbols[0];
        } else {
            return symbol_MultiPart_Worker.addOrAccess_MultiPartSymbol_To_Indexes(symbolType, symbols,
                                              passingIn_SymbolID, multipart_SymbolID,
                                              creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol);
        }
    }








    public Symbol find(SymbolType symbolType, List<String> symbolStrings)
            throws Exception_MultiPartSymbolAccess {
        return symbol_MultiPart_Worker.find(symbolType, symbolStrings);
    }


    /**
     * This method can take the full descTagnName string, split it into its different parts, and then construct a list
     * for it for each part to use to create the possibly multipart symbol. Of all the symbol types, only DescTagName can do this,
     * because a desc tagname can not have dots or spaces in any of the parts.
     */
    public DescriptorTagName find_DescTagName(String fullDescTagNameString)
            throws Exception_MultiPartSymbolAccess {
        
        return (DescriptorTagName)symbol_MultiPart_Worker.find(SymbolType.DescriptorTagName,
                DescriptorTagName_Utilities.split_DescTagNameString_into_PartsList(fullDescTagNameString));
    }

    public Symbol_MultiPart_Worker get_MultiPartSymbol_Worker() { return symbol_MultiPart_Worker; }


}
