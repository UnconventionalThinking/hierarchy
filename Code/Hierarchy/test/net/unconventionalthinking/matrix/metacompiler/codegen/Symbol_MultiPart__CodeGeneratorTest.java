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
import net.unconventionalthinking.matrix.symbols.*;
import java.util.*;

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
public class Symbol_MultiPart__CodeGeneratorTest {

    public Symbol_MultiPart__CodeGeneratorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
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

    private static final SymbolType symbolType = SymbolType.Symbol;

    /**
     * Test of generate_MultiPartSymbol_CreationCode method, of class Symbol_MultiPart__CodeGenerator.
     */
    @Test
    public void testGenerate_MultiPartSymbol_CreationCode() throws Exception {

        System.out.println("generate_MultiPartSymbol_CreationCode");

        CodeBuilder codeBuilder = new CodeBuilder();

        /*
         * These test cover a lot of stuff, so be thorough
         */

        List<String> symbolStrings = new ArrayList<String>();
        symbolStrings.add("sym 1");
        symbolStrings.add("child 1");
        symbolStrings.add("child 2");
        symbolStrings.add("child 3");
        int creation_StartLevel = 0;
        boolean creation_Has_StaticVersion = true;
        CodeGen_OutputResults outputResults = new CodeGen_OutputResults();

        SymbolName multiPartName = SymbolNameConstructor_MultiPart.createNew_UsingStringList(symbolStrings);
        String expResult = symbolFileName + "." + multiPartName.name_IdentFormat;


        Symbol createdSymbol = codeGenerators.multiPartSymbol_CodeGenerator.generate_MultiPartSymbol_CreationCode(codeBuilder, outputResults, symbolType, symbolStrings,
                creation_StartLevel, creation_Has_StaticVersion, symbolFileName);
        assertEquals(expResult, codeBuilder.toString());
        assertTrue(outputResults.getImportSet().contains(CodeConstants.MatrixImports_Symbols));




        //  Test starting creation at level 2!
        codeBuilder = new CodeBuilder();
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("sym 1");
        symbolStrings.add("child 1 @%@ !...");
        symbolStrings.add("child2");
        symbolStrings.add("child 3 @#$@#$");
        creation_StartLevel = 2;
        creation_Has_StaticVersion = true;
        outputResults = new CodeGen_OutputResults();

        multiPartName = SymbolNameConstructor_MultiPart.createNew_UsingStringList(symbolStrings);
        expResult = symbolFileName + "." + multiPartName.name_IdentFormat;


        createdSymbol = codeGenerators.multiPartSymbol_CodeGenerator.generate_MultiPartSymbol_CreationCode(codeBuilder, outputResults, symbolType, symbolStrings,
                creation_StartLevel, creation_Has_StaticVersion, symbolFileName);
        assertEquals(expResult, codeBuilder.toString());
        assertTrue(outputResults.getImportSet().contains(CodeConstants.MatrixImports_Symbols));





        //  Test having new symbols at level 2, but with a low creation level like 1. Also, test dynamic creation
        codeBuilder = new CodeBuilder();
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("sym 1");         // existing
        symbolStrings.add("child 11 new!!"); // new
        symbolStrings.add("child 3"); // existing
        creation_StartLevel = 1;
        creation_Has_StaticVersion = false;
        outputResults = new CodeGen_OutputResults();

        multiPartName = SymbolNameConstructor_MultiPart.createNew_UsingStringList(symbolStrings);

        int id = 16;
        expResult = CodeConstants.SymbolIndex__getMultiPartSymbol_ById + "(" + id +")";

        createdSymbol = codeGenerators.multiPartSymbol_CodeGenerator.generate_MultiPartSymbol_CreationCode(codeBuilder, outputResults, symbolType, symbolStrings,
                creation_StartLevel, creation_Has_StaticVersion, symbolFileName);
        assertEquals(expResult, codeBuilder.toString());
        assertTrue(outputResults.getImportSet().contains(CodeConstants.MatrixImports_Symbols));



    }



//    /**
//     * Test of generate_MultiPartSymbol_AccessCode method, of class Symbol_MultiPart__CodeGenerator.
//     */
//    @Test
//    public void testGenerate_MultiPartSymbol_AccessCode() throws Exception {
//        System.out.println("generate_MultiPartSymbol_AccessCode");
//        CodeBuilder codeBuilder = null;
//        List<String> symbolStrings = null;
//        String symbolFileName = "";
//        CodeBuilder expResult = null;
//        CodeBuilder result = Symbol_MultiPart__CodeGenerator.generate_MultiPartSymbol_AccessCode(codeBuilder, symbolType, symbolStrings, symbolFileName);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of create_MultiPartSymbol_AccessCode method, of class Symbol_MultiPart__CodeGenerator.
//     */
//    @Test
//    public void testCreate_MultiPartSymbol_AccessCode() throws Exception {
//        System.out.println("create_MultiPartSymbol_AccessCode");
//        CodeBuilder codeBuilder = null;
//        Symbol_MultiPart multiPartSymbol = null;
//        String symbolFileName = "";
//        CodeBuilder expResult = null;
//        CodeBuilder result = Symbol_MultiPart__CodeGenerator.create_MultiPartSymbol_AccessCode(codeBuilder, multiPartSymbol, symbolFileName);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}