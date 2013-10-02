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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.unconventionalthinking.matrix.metacompiler.codegen;

import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.matrix.metacompiler.codegen.Symbol_CodeGenerator.AccessType;
import net.unconventionalthinking.matrix.metacompiler.codegen.Symbol_CodeGenerator.SymbolCreationType;
import net.unconventionalthinking.matrix.utilities.TextUtilities;
import net.unconventionalthinking.matrix.symbols.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author peterjoh
 */
public class Symbol_CodeGeneratorTest {

    public Symbol_CodeGeneratorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        symbolControl.intialize_All_MPSymbols();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }





    public static String symbolFileName = "AppSymbols";

    public static SymbolControl symbolControl = new SymbolControl();
    private static CodeGenerators codeGenerators = new CodeGenerators(symbolControl);
    private static Symbol_Index symbol_Index = symbolControl.appSymbolsIndex;


        private static final SymbolType symbolType = SymbolType.Symbol;

    private static int sym1_SymbolID;




    /**
     * Test of generate_SymbolCreationCode by name method, of class Symbol_CodeGenerator.
     */
    @Test
    public void testGenerate_SymbolCreationCodeByName() throws Exception {
        System.out.println("generate_SymbolCreationCode by name");


        int initialCreatedSymbolID;


        CodeBuilder codeBuilder = new CodeBuilder();

        String symbolName = "Sym1!";
        String expResult = symbolFileName + ".Sym1" + TextUtilities.convertCharToIdentifier_NonFirstChar('!');
        CodeGen_OutputResults outputResults = new CodeGen_OutputResults();

        Symbol createdSymbol = codeGenerators.symbol_CodeGenerator.generate_SymbolCreationCode(codeBuilder, outputResults, symbolType, symbolName, symbolFileName);
        assertEquals(expResult, codeBuilder.toString());

        Symbol_Single symbol = symbol_Index.getSingleSymbol_ByName(symbolName);
        assertEquals(symbol, createdSymbol);
        assertEquals(symbol.name, symbolName);
        String name_IdentFormat = TextUtilities.convertTextToIdentifier(symbolName);
        assertEquals(symbol.name_IdentFormat, name_IdentFormat);
        assertEquals(symbol.has_StaticReference, true);
        assertTrue(outputResults.getImportSet().contains(CodeConstants.MatrixImports_Symbols));

        initialCreatedSymbolID = symbol.ID;
        sym1_SymbolID = symbol.ID;


        codeBuilder = new CodeBuilder();
        symbolName = "!@#$ Sym2  .2342";
        int expSymbolID = initialCreatedSymbolID + 1;
        name_IdentFormat = TextUtilities.convertTextToIdentifier(symbolName);
        expResult = symbolFileName + "." + name_IdentFormat;
        createdSymbol = codeGenerators.symbol_CodeGenerator.generate_SymbolCreationCode(codeBuilder, outputResults, symbolType, symbolName, symbolFileName);
        assertEquals(expResult, codeBuilder.toString());

        symbol = symbol_Index.getSingleSymbol_ById(expSymbolID);
        assertEquals(symbol, createdSymbol);
        assertEquals(symbol.ID, expSymbolID);
        assertEquals(symbol.name, symbolName);
        assertEquals(symbol.name_IdentFormat, name_IdentFormat);
        assertEquals(symbol.has_StaticReference, true);
        assertTrue(outputResults.getImportSet().contains(CodeConstants.MatrixImports_Symbols));


        // now, try an existing one!!
        codeBuilder = new CodeBuilder();
        symbolName = "Sym1!";
        expResult = symbolFileName + ".Sym1" + TextUtilities.convertCharToIdentifier_NonFirstChar('!');
        createdSymbol = codeGenerators.symbol_CodeGenerator.generate_SymbolCreationCode(codeBuilder, outputResults, symbolType, symbolName, symbolFileName);
        assertEquals(expResult, codeBuilder.toString());

        symbol = symbol_Index.getSingleSymbol_ByName(symbolName);
		assertEquals(symbol, createdSymbol);
        assertEquals(symbol.ID, initialCreatedSymbolID);
        assertEquals(symbol.name, symbolName);
        name_IdentFormat = TextUtilities.convertTextToIdentifier(symbolName);
        assertEquals(symbol.name_IdentFormat, name_IdentFormat);
        assertEquals(symbol.has_StaticReference, true);



        //  Test dynamic access code when creating a symbol
        codeBuilder = new CodeBuilder();
        symbolName = "sym 3!";
        boolean has_StaticVersion = false; //  dynamic access
        name_IdentFormat = TextUtilities.convertTextToIdentifier(symbolName);
        expSymbolID = initialCreatedSymbolID + 2;
        expResult = CodeConstants.SymbolIndex__getSingleSymbol_ById  + "(" + expSymbolID + ")";   // dynamic access output code
        createdSymbol = codeGenerators.symbol_CodeGenerator.generate_SymbolCreationCode(codeBuilder, outputResults, SymbolCreationType.createByName, symbolType, symbolName,
                    -1, symbolFileName, has_StaticVersion);
        assertEquals(expResult, codeBuilder.toString());

        symbol = symbol_Index.getSingleSymbol_ByName(symbolName);
		assertEquals(symbol, createdSymbol);
        assertEquals(symbol.ID, expSymbolID);
        assertEquals(symbol.name, symbolName);
        assertEquals(symbol.name_IdentFormat, name_IdentFormat);
        assertEquals(symbol.has_StaticReference, false);

    }




    /**
     * Test of generate_SymbolCreationCode method, of class Symbol_CodeGenerator.
     */
    @Test
    public void testGenerate_SymbolCreationCodeByNameAndId() throws Exception {
        System.out.println("generate_SymbolCreationCode by name and id");


        CodeBuilder codeBuilder = new CodeBuilder();
        CodeGen_OutputResults outputResults = new CodeGen_OutputResults();

        String symbolName = "Sym10!";
        int id = 100;
        String expResult = symbolFileName + ".Sym10" + TextUtilities.convertCharToIdentifier_NonFirstChar('!');
        Symbol createdSymbol = codeGenerators.symbol_CodeGenerator.generate_SymbolCreationCode(codeBuilder, outputResults, symbolType, symbolName, id, symbolFileName);
        assertEquals(expResult, codeBuilder.toString());

        Symbol_Single symbol = symbol_Index.getSingleSymbol_ByName(symbolName);
		assertEquals(symbol, createdSymbol);
        assertEquals(symbol.ID, 100);
        assertEquals(symbol.name, symbolName);
        String name_IdentFormat = TextUtilities.convertTextToIdentifier(symbolName);
        assertEquals(symbol.name_IdentFormat, name_IdentFormat);
        assertEquals(symbol.has_StaticReference, true);
        assertTrue(outputResults.getImportSet().contains(CodeConstants.MatrixImports_Symbols));


        codeBuilder = new CodeBuilder();
        symbolName = "sym 11 !@#$!@";
        id = 200;
        name_IdentFormat = TextUtilities.convertTextToIdentifier(symbolName);
        expResult = symbolFileName + "." + name_IdentFormat;
        createdSymbol = codeGenerators.symbol_CodeGenerator.generate_SymbolCreationCode(codeBuilder, outputResults, symbolType, symbolName, id, symbolFileName);
        assertEquals(expResult, codeBuilder.toString());

        symbol = symbol_Index.getSingleSymbol_ById(id);
        assertEquals(symbol.ID, 200);
        assertEquals(symbol.name, symbolName);
        assertEquals(symbol.name_IdentFormat, name_IdentFormat);
        assertEquals(symbol.has_StaticReference, true);
        assertTrue(outputResults.getImportSet().contains(CodeConstants.MatrixImports_Symbols));


        // now, try an existing one, using the symCreate method that _doesn't_ use id
        codeBuilder = new CodeBuilder();
        symbolName = "Sym10!";
        expResult = symbolFileName + ".Sym10" + TextUtilities.convertCharToIdentifier_NonFirstChar('!');
        createdSymbol = codeGenerators.symbol_CodeGenerator.generate_SymbolCreationCode(codeBuilder, outputResults, symbolType, symbolName, symbolFileName);
        assertEquals(expResult, codeBuilder.toString());

        symbol = symbol_Index.getSingleSymbol_ByName(symbolName);
		assertEquals(symbol, createdSymbol);
        assertEquals(symbol.ID, 100);
        assertEquals(symbol.name, symbolName);
        name_IdentFormat = TextUtilities.convertTextToIdentifier(symbolName);
        assertEquals(symbol.name_IdentFormat, name_IdentFormat);
        assertEquals(symbol.has_StaticReference, true);


        // now, try creating an existing one using the symCreate method that does use id
        codeBuilder = new CodeBuilder();
        symbolName = "sym 11 !@#$!@";
        id = 200;
        name_IdentFormat = TextUtilities.convertTextToIdentifier(symbolName);
        expResult = symbolFileName + "." + name_IdentFormat;
        createdSymbol = codeGenerators.symbol_CodeGenerator.generate_SymbolCreationCode(codeBuilder, outputResults, symbolType, symbolName, id, symbolFileName);
        assertEquals(expResult, codeBuilder.toString());

        symbol = symbol_Index.getSingleSymbol_ById(id);
        assertEquals(symbol.ID, 200);
        assertEquals(symbol.name, symbolName);
        assertEquals(symbol.name_IdentFormat, name_IdentFormat);
        assertEquals(symbol.has_StaticReference, true);



        // now, try to resume regular sym creation (no id)
        codeBuilder = new CodeBuilder();
        symbolName = "Sym12 $$$";
        name_IdentFormat = TextUtilities.convertTextToIdentifier(symbolName);
        expResult = symbolFileName + "." + name_IdentFormat;
        createdSymbol = codeGenerators.symbol_CodeGenerator.generate_SymbolCreationCode(codeBuilder, outputResults, symbolType, symbolName, symbolFileName);
        assertEquals(expResult, codeBuilder.toString());

        symbol = symbol_Index.getSingleSymbol_ByName(symbolName);
		assertEquals(symbol, createdSymbol);
        assertEquals(symbol.ID, 201);
        assertEquals(symbol.name, symbolName);
        assertEquals(symbol.name_IdentFormat, name_IdentFormat);
        assertEquals(symbol.has_StaticReference, true);


        // now, try creating an existing one. using the right name, but wrong id! error!
        codeBuilder = new CodeBuilder();
        symbolName = "sym 11 !@#$!@";
        id = 11111; // wrong id!
        name_IdentFormat = TextUtilities.convertTextToIdentifier(symbolName);
        expResult = symbolFileName + "." + name_IdentFormat;

        boolean had_error = false;
        try {
            createdSymbol = codeGenerators.symbol_CodeGenerator.generate_SymbolCreationCode(codeBuilder, outputResults, symbolType, symbolName, id, symbolFileName);
        } catch (Exception_SymbolCreation e) {
            had_error = true;
            System.out.println("Error was: " + e.getMessage() );
        }
        assertEquals(true, had_error);


        // now, try creating an existing one. using the right name, but wrong nameid! error!
        codeBuilder = new CodeBuilder();
        symbolName = "Sym10!";
        id = 200; // wrong id!
        name_IdentFormat = TextUtilities.convertTextToIdentifier(symbolName);
        expResult = symbolFileName + "." + name_IdentFormat;

        had_error = false;
        try {
            createdSymbol = codeGenerators.symbol_CodeGenerator.generate_SymbolCreationCode(codeBuilder, outputResults, symbolType, symbolName, id, symbolFileName);
        } catch (Exception_SymbolCreation e) {
            had_error = true;
            System.out.println("Error was: " + e.getMessage() );
        }
        assertEquals(true, had_error);



        // now, resume regular creation
        codeBuilder = new CodeBuilder();
        symbolName = "Sym13";
        name_IdentFormat = TextUtilities.convertTextToIdentifier(symbolName);
        expResult = symbolFileName + "." + name_IdentFormat;

        createdSymbol = codeGenerators.symbol_CodeGenerator.generate_SymbolCreationCode(codeBuilder, outputResults, symbolType, symbolName, symbolFileName);
        assertEquals(expResult, codeBuilder.toString());

        symbol = symbol_Index.getSingleSymbol_ByName(symbolName);
		assertEquals(symbol, createdSymbol);
        assertEquals(symbol.ID, 202); // because last created one had 201!!
        assertEquals(symbol.name, symbolName);
        assertEquals(symbol.name_IdentFormat, name_IdentFormat);
        assertEquals(symbol.has_StaticReference, true);


    }






    /**
     * Test of generate_SymbolAccessCode method, of class Symbol_CodeGenerator.
     */
    @Test
    public void testGenerate_SymbolAccessCode() throws Exception {
        System.out.println("generate_SymbolAccessCode");


        CodeGen_OutputResults outputResults = new CodeGen_OutputResults();

        //  access by name
        CodeBuilder codeBuilder = new CodeBuilder();
        String symbolName = "sym 11 !@#$!@";

        int symbol_ID = -1; // dummy value
        String name_IdentFormat = TextUtilities.convertTextToIdentifier(symbolName);
        String expResult = symbolFileName + "." + name_IdentFormat;
        Symbol createdSymbol = codeGenerators.symbol_CodeGenerator.generate_SymbolAccessCode(codeBuilder, outputResults, symbolType, symbolName, symbolFileName);
        assertEquals(expResult, codeBuilder.toString());

        Symbol_Single symbol = symbol_Index.getSingleSymbol_ByName(symbolName);
		assertEquals(symbol, createdSymbol);
        assertEquals(symbol.ID, 200);
        assertEquals(symbol.name, symbolName);
        assertEquals(symbol.name_IdentFormat, name_IdentFormat);
        assertEquals(symbol.has_StaticReference, true);
        assertTrue(outputResults.getImportSet().contains(CodeConstants.MatrixImports_Symbols));


        //  access by id
        symbol_ID = sym1_SymbolID;

        codeBuilder = new CodeBuilder();
        symbolName = "Sym1!";
        name_IdentFormat = TextUtilities.convertTextToIdentifier(symbolName);
        expResult = symbolFileName + "." + name_IdentFormat;
        createdSymbol = codeGenerators.symbol_CodeGenerator.generate_SymbolAccessCode(codeBuilder, outputResults, symbolType, symbol_ID, symbolFileName);
        assertEquals(expResult, codeBuilder.toString());

        symbol = symbol_Index.getSingleSymbol_ById(symbol_ID);
        assertEquals(symbol.ID, symbol_ID);
        assertEquals(symbol.name, symbolName);
        name_IdentFormat = TextUtilities.convertTextToIdentifier(symbolName);
        assertEquals(symbol.name_IdentFormat, name_IdentFormat);
        assertEquals(symbol.has_StaticReference, true);
        assertTrue(outputResults.getImportSet().contains(CodeConstants.MatrixImports_Symbols));


        //  Test dynamic access code
        codeBuilder = new CodeBuilder();
        symbolName = "sym 3!";
        name_IdentFormat = TextUtilities.convertTextToIdentifier(symbolName);
        expResult = CodeConstants.SymbolIndex__getSingleSymbol_ById  + "(" + (sym1_SymbolID + 2) + ")";   // dynamic access output code
        createdSymbol = codeGenerators.symbol_CodeGenerator.generate_SymbolAccessCode(codeBuilder, outputResults, symbolType, symbolName, symbolFileName);
        assertEquals(expResult, codeBuilder.toString());

        symbol = symbol_Index.getSingleSymbol_ByName(symbolName);
		assertEquals(symbol, createdSymbol);
        assertEquals(symbol.ID, sym1_SymbolID + 2);
        assertEquals(symbol.name, symbolName);
        assertEquals(symbol.name_IdentFormat, name_IdentFormat);
        assertEquals(symbol.has_StaticReference, false);
        assertTrue(outputResults.getImportSet().contains(CodeConstants.MatrixImports_Symbols));


    }


}