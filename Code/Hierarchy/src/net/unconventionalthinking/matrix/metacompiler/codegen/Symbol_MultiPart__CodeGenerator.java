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

import net.unconventionalthinking.utilities.ListUtilities;
import java.util.*;

import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.compiler.tools.CodeBuilder;

import net.unconventionalthinking.exceptions.*;
import net.unconventionalthinking.matrix.utilities.*;
import net.unconventionalthinking.hierarchy.HierarchySettings;

/**
 *
 * @author peterjoh
 */
public class Symbol_MultiPart__CodeGenerator {

    public SymbolControl symbolControl;
    public Symbol_MultiPart_Factory multiPartSymbolFactory;

    public Symbol_MultiPart__CodeGenerator(SymbolControl symbolControl) {
        this.symbolControl = symbolControl;
        multiPartSymbolFactory = symbolControl.multiPartSymbol_Factory;
    }

    public Symbol generate_MultiPartSymbol_CreationCode(CodeBuilder codeBuilder, CodeGen_OutputResults outputResults,
            SymbolType symbolType, List<String> symbolStrings, int creation_StartLevel, boolean creation_Has_StaticVersion, String symbolFileName)
            throws Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreationOrAccess,
                    Exception_InvalidArgumentPassed_Null {


        //  Also, list any newly created _single_ symbols
        List<Symbol_Single> newlyCreatedSymbols = new ArrayList<Symbol_Single>();

        //  because, could have just done access of existing symbol!
        Boolean_Mutable have_Created_New_MultiPartSymbol = new Boolean_Mutable(false);


        Symbol multiPartSymbol = null;
        try {
            multiPartSymbol = multiPartSymbolFactory.createNew(symbolType, symbolStrings, creation_StartLevel, creation_Has_StaticVersion,
                    have_Created_New_MultiPartSymbol, newlyCreatedSymbols);

        } catch(Exception_MultiPartSymbolCreation e) { throw e;
        } catch(Exception_MultiPartSymbolAccess e) { throw e; }


        if (multiPartSymbol == null)
            throw new Exception_MultiPartSymbolCreation("Could not create the multipart symbol: " + ListUtilities.printWithDot(symbolStrings) + ".");
        else if (!(multiPartSymbol instanceof Symbol_MultiPart))
            throw new Exception_MultiPartSymbolCreation("Tried to generate code for a multipart symbol, but created a single symbol instead: " + ListUtilities.printWithDot(symbolStrings) + ".");


        //  The symbol should be a multipart symbol at this point
        create_MultiPartSymbol_AccessCode(codeBuilder, outputResults, symbolType, (Symbol_MultiPart)multiPartSymbol, symbolFileName);

        return multiPartSymbol;
    }





    public Symbol generate_MultiPartSymbol_AccessCode(CodeBuilder codeBuilder, CodeGen_OutputResults outputResults, SymbolType symbolType, 
            List<String> symbolStrings, String symbolFileName)
            throws Exception_MultiPartSymbolAccess, Exception_InvalidArgumentPassed_Null {


        Symbol multiPartSymbol = null;
        try {
            multiPartSymbol = multiPartSymbolFactory.find(symbolType, symbolStrings);

        } catch(Exception_MultiPartSymbolAccess e) { throw e; }


        if (multiPartSymbol == null)
            throw new Exception_MultiPartSymbolAccess("Could not find the multipart " + symbolType.toString() + ": " + ListUtilities.printWithDot(symbolStrings) + ".");
        else if (!(multiPartSymbol instanceof Symbol_MultiPart))
            throw new Exception_MultiPartSymbolAccess("Tried to create code for access of a multipart " + symbolType.toString() + ", but created a single " + symbolType.toString() + " instead: " + ListUtilities.printWithDot(symbolStrings) + ".");


        create_MultiPartSymbol_AccessCode(codeBuilder, outputResults, symbolType, (Symbol_MultiPart)multiPartSymbol, symbolFileName);

        return multiPartSymbol;
    }



    public CodeBuilder create_MultiPartSymbol_AccessCode(CodeBuilder codeBuilder, CodeGen_OutputResults outputResults, 
            SymbolType symbolType, Symbol_MultiPart multiPartSymbol, String symbolFile_BaseName)
            throws Exception_InvalidArgumentPassed_Null {

        if (multiPartSymbol.has_StaticReference) {
            if (symbolFile_BaseName != null) {
                
                String symbolFileName = null;
                if (symbolType == SymbolType.DescriptorTagName)
                    symbolFileName = symbolFile_BaseName + HierarchySettings.symbolClassSuffix_DescTagName;
                else if (symbolType == SymbolType.Label)
                    symbolFileName = symbolFile_BaseName + HierarchySettings.symbolClassSuffix_Label;
                else
                    symbolFileName = symbolFile_BaseName;

                codeBuilder.append(symbolFileName + "." + multiPartSymbol.name_IdentFormat);
            } else
                throw new Exception_InvalidArgumentPassed_Null( "Tried to create the static access code for the multiPart " + symbolType.toString() + ": "
                        + multiPartSymbol.name + ", with id " + multiPartSymbol.ID + ", but you passed in a null SymbolFile Name.");

        } else {// do dynamic access
            if (symbolType == SymbolType.DescriptorTagName)
                codeBuilder.append(CodeConstants.SymbolIndex__getMultiPartDescTagName_ById + "(" + multiPartSymbol.ID +")");
            else if (symbolType == SymbolType.Label)
                codeBuilder.append(CodeConstants.SymbolIndex__getMultiPartLabel_ById + "(" + multiPartSymbol.ID +")");
            else
                codeBuilder.append(CodeConstants.SymbolIndex__getMultiPartSymbol_ById + "(" + multiPartSymbol.ID +")");
        }

        //  Add import for symbols
        outputResults.addImport(CodeConstants.MatrixImports_Symbols);

        return codeBuilder;

    }



}
