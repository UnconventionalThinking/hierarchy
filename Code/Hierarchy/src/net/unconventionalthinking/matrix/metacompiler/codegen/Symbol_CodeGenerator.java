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


package net.unconventionalthinking.matrix.metacompiler.codegen;


import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.compiler.tools.CodeBuilder;

import net.unconventionalthinking.exceptions.*;
import net.unconventionalthinking.matrix.utilities.TypeUtilities;
import net.unconventionalthinking.hierarchy.HierarchySettings;


/**
 *
 * @author peterjoh
 */
public class Symbol_CodeGenerator {

    public enum AccessType { accessByName, accessByID }
    public enum SymbolCreationType { createByName, createByNameAndID }


    public SymbolControl symbolControl;
    public Symbol_CodeGenerator(SymbolControl symbolControl) {
        this.symbolControl = symbolControl;
    }


    //  ________________________________________________________________________________________________________________
    //
    //    Symbol_Single-Creation Code-Generation
    //  ________________________________________________________________________________________________________________

    /**
     * Generate the code for creating a symbol. You create a symbol by passing in a symbol name. If an existing symbol exists
     * (meaning if you pass in a name, and a symbol with that name already exists), then don't create, return the
     * existing symbol.
     *
     * @param codeBuilder
     * @param symbolName
     * @param symbolFileName
     * @return
     * @throws net.unconventionalthinking.matrix.symbols.Exception_SymbolCreation
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed
     */
    public Symbol_Single generate_SymbolCreationCode(CodeBuilder codeBuilder, CodeGen_OutputResults outputResults,
                                    SymbolType symbolType, String symbolName, String symbolFileName)
                                    throws Exception_SymbolCreation, Exception_InvalidArgumentPassed {

        return generate_SymbolCreationCode(codeBuilder, outputResults, SymbolCreationType.createByName, symbolType, symbolName, -1, symbolFileName, true);
    }
    /**
     * Generate the code for creating a symbol. You can create a symbol by in a name and id.
     * If an existing symbol exists (meaning you are passing in a name and id, a symbol with the same name and id exists),
     * then don't create, return the existing symbol.
     *
     * @param codeBuilder
     * @param symbolName
     * @param symbol_ID
     * @param symbolFileName
     * @return
     * @throws net.unconventionalthinking.matrix.symbols.Exception_SymbolCreation
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed
     */
    public Symbol_Single generate_SymbolCreationCode(CodeBuilder codeBuilder, CodeGen_OutputResults outputResults,
            SymbolType symbolType, String symbolName, int symbol_ID, String symbolFileName)
                                    throws Exception_SymbolCreation, Exception_InvalidArgumentPassed {

        return generate_SymbolCreationCode(codeBuilder, outputResults, SymbolCreationType.createByNameAndID, symbolType, symbolName, symbol_ID, symbolFileName, true);
    }



    /**
     * Generate the code for creating a symbol. You can create a symbol by just passing in a symbol name, or you
     * can also pass in a name and id.
     * If an existing symbol exists (meaning if you pass in just a name, then a symbol with that name already exists, or
     * if you are passing in a name and id, a symbol with the same name and id exists), then don't create, return the
     * existing symbol.
     *
     * @param codeBuilder
     * @param creationType   Are you creating by just name, or name and id?
     * @param symbolName
     * @param symbol_ID
     * @param symbolFileName
     * @param has_StaticReference
     * @return
     * @throws net.unconventionalthinking.matrix.symbols.Exception_SymbolCreation
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed
     */
    public Symbol_Single generate_SymbolCreationCode(CodeBuilder codeBuilder, CodeGen_OutputResults outputResults,
            SymbolCreationType creationType, SymbolType symbolType, String symbolName, int symbol_ID,
            String symbolFileName, boolean has_StaticVersion)
                                    throws Exception_SymbolCreation, Exception_InvalidArgumentPassed {


        Symbol_Single_Factory singleSymbol_Factory = symbolControl.singleSymbol_Factory;

        Symbol_Single symbol = null;

        //  This symbol creation method gets the symbol if it already exists, otherwise, it creates a new one and
        //  adds it to the MetaCompiler SymbolIndex hash.
        Boolean_Mutable have_CreatedNewSymbol = new Boolean_Mutable(false);

        if (creationType == SymbolCreationType.createByName) {

            try {
                symbol = singleSymbol_Factory.createNew(symbolType, symbolName, has_StaticVersion, have_CreatedNewSymbol);

            } catch (Exception_InvalidArgumentPassed_Null e) {
                throw new Exception_SymbolCreation("Tried to create a symbol by name, but a null symbol name was passed in.", e);
            }

            if (symbol == null) throw new Exception_SymbolCreation("Could not create a new symbol for symbol name '" + symbolName + "'");


        } else {  //  creationType is createByNameAndID
            try {
                symbol = singleSymbol_Factory.createNew(symbolType, symbolName, symbol_ID, has_StaticVersion, have_CreatedNewSymbol);

            } catch (Exception_InvalidArgumentPassed e) {
                throw new Exception_SymbolCreation("Tried to create a symbol by name and id, but a null symbol name or invalid id was passed in.", e);
            }

            if (symbol == null) throw new Exception_SymbolCreation("Could not create a new symbol for symbol name '" + symbolName + "'");

        }
        create_SymbolAccessCode(symbolType, symbol, symbolFileName, codeBuilder, outputResults);

        return symbol;
    }



    //  ________________________________________________________________________________________________________________
    //
    //    Symbol_Single-Access Code-Generation
    //  ________________________________________________________________________________________________________________

    /**
     * Generate the code for accessing a symbol. You identify which symbol to create access code by symbol name.
     *
     * @param codeBuilder
     * @param symbolName
     * @param symbolFileName
     * @return
     * @throws net.unconventionalthinking.matrix.symbols.Exception_SymbolAccess
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null
     */
    public Symbol_Single generate_SymbolAccessCode(CodeBuilder codeBuilder, CodeGen_OutputResults outputResults,
                                    SymbolType symbolType, String symbolName, String symbolFileName)
                                    throws Exception_SymbolAccess, Exception_InvalidArgumentPassed_Null {
        return generate_SymbolAccessCode(codeBuilder, outputResults, AccessType.accessByName, symbolType, symbolName, -1, symbolFileName);
    }
    /**
     * Generate the code for accessing a symbol. You identify which symbol to create access code by id.
     *
     * @param codeBuilder
     * @param symbol_ID
     * @param symbolFileName
     * @return
     * @throws net.unconventionalthinking.matrix.symbols.Exception_SymbolAccess
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null
     */
    public Symbol_Single generate_SymbolAccessCode(CodeBuilder codeBuilder, CodeGen_OutputResults outputResults,
                                    SymbolType symbolType, int symbol_ID, String symbolFileName)
                                    throws Exception_SymbolAccess, Exception_InvalidArgumentPassed_Null {
        return generate_SymbolAccessCode(codeBuilder, outputResults, AccessType.accessByID, symbolType, null, symbol_ID, symbolFileName);
    }



    /**
     * Generate the code for accessing a symbol. You can identify which symbol to create access code for by either name or by id.
     *
     * @param codeBuilder
     * @param accessByNameOrID  Are you accessing by name, or by id?
     * @param symbolName
     * @param symbol_ID
     * @param symbolFileName
     * @return
     * @throws net.unconventionalthinking.matrix.symbols.Exception_SymbolAccess
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null
     */
    public Symbol_Single generate_SymbolAccessCode(CodeBuilder codeBuilder, CodeGen_OutputResults outputResults, AccessType accessByNameOrID,
                                    SymbolType symbolType, String symbolName, int symbol_ID, String symbolFileName)
                                    throws Exception_SymbolAccess, Exception_InvalidArgumentPassed_Null {


        Symbol_Single symbol = null;

        if (accessByNameOrID == AccessType.accessByName) {
            if (symbolName == null) throw new Exception_SymbolAccess("Tried to access a symbol by Name, but the name string you passed in is null.");

            if (symbolType == SymbolType.DescriptorTagName)
                symbol = symbolControl.descTagNames_Index.getSingleSymbol_ByName(symbolName);
            else if (symbolType == SymbolType.Label)
                symbol = symbolControl.labels_Index.getSingleSymbol_ByName(symbolName);
            else
                symbol = symbolControl.appSymbolsIndex.getSingleSymbol_ByName(symbolName);


            if (symbol == null) throw new Exception_SymbolAccess("Tried to access a " + symbolType.toString() + " with name, '" + symbolName
                    + "', but could not find it. \n"
                    + "  In this situation, you're either trying to access an existing symbol that was previously created, "
                    + "or your trying to create a new symbol. \n"
                    + "    - If you're trying to access an existing symbol that was previously created, then double check the symbol's spelling!\n"
                    + "    - If you're trying to create a new symbol, then add a '+' before the symbol to do symbol creation.\n"
                    + "      For instance: +:MyNewSymbol. ");

        } else { //  access by id
            if (symbol_ID < 0) throw new Exception_SymbolAccess("Tried to access a " + symbolType.toString() + " by ID, but you didn't pass in an id (or passed in an id less than zero, which is invalid).");

            symbol = symbolControl.appSymbolsIndex.getSingleSymbol_ById(symbol_ID);


            if (symbol == null) throw new Exception_SymbolAccess("Tried to access a " + symbolType.toString() + " with ID, " + symbol_ID+ ", but could not find it.");
        }

        create_SymbolAccessCode(symbolType, symbol, symbolFileName, codeBuilder, outputResults);
        return symbol;

    }






    /**
     * Helper Method to generate the access code
     *
     * @param symbol
     * @param symbolFileName
     * @param codeBuilder
     * @return
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null
     */
    public CodeBuilder create_SymbolAccessCode(SymbolType symbolType, Symbol_Single symbol, String symbolFile_BaseName, CodeBuilder codeBuilder,
                CodeGen_OutputResults outputResults)
            throws Exception_InvalidArgumentPassed_Null {


        if (symbol.has_StaticReference) {
            if (symbolFile_BaseName != null) {
                String symbolFileName = null;

                if (symbolType == SymbolType.DescriptorTagName)
                    symbolFileName = symbolFile_BaseName + HierarchySettings.symbolClassSuffix_DescTagName;
                else if (symbolType == SymbolType.Label)
                    symbolFileName = symbolFile_BaseName + HierarchySettings.symbolClassSuffix_Label;
                else
                    symbolFileName = symbolFile_BaseName;

                String symbolName = TypeUtilities.is_JavaReservedWord(symbol) ?
                    symbol.name_IdentFormat + SymbolConstants.SymbolFile_SymbolName__ReservedWord_Suffix : symbol.name_IdentFormat;
                codeBuilder.append(symbolFileName + "." + symbolName);
                
            } else
                throw new Exception_InvalidArgumentPassed_Null( "Tried to create the static access code for the " + symbolType.toString() + ": " + symbol.name + ", with id " + symbol.ID + ", but you passed in a null SymbolFile Name.");

        } else { // do dynamic access

            if (symbolType == SymbolType.DescriptorTagName)
                codeBuilder.append(CodeConstants.SymbolIndex__getSingleDescTagName_ById + "(" + symbol.ID +")");
            else if (symbolType == SymbolType.Label)
                codeBuilder.append(CodeConstants.SymbolIndex__getSingleLabel_ById + "(" + symbol.ID +")");
            else
                codeBuilder.append(CodeConstants.SymbolIndex__getSingleSymbol_ById + "(" + symbol.ID +")");

        }


        //  Add import for symbols
        outputResults.addImport(CodeConstants.MatrixImports_Symbols);

        return codeBuilder;
    }
}
