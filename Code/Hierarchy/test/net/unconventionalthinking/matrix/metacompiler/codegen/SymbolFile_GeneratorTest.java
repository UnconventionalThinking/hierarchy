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


import net.unconventionalthinking.matrix.metacompiler.codefilegen.SymbolFile_Generator;
import java.util.*;


import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null;
import net.unconventionalthinking.lang.*;

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
public class SymbolFile_GeneratorTest {

    public SymbolFile_GeneratorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        symbolControl.intialize_All_MPSymbols();
    }

    @After
    public void tearDown() {
    }


    public static SymbolControl symbolControl = new SymbolControl();
    private static CodeGenerators codeGenerators = new CodeGenerators(symbolControl);
    private static Symbol_Index symbol_Index = symbolControl.appSymbolsIndex;


    private static String singleSymbol_ClassName = "AppSymbols";

    /**
     * Test of generate_SymbolVariables method, of class SymbolFile_Generator.
     */
    @Test
    public void testGenerate_SingleSymbolVariables() throws Exception {
        System.out.println("generate_SingleSymbolVariables");



        //  create some test symbols
        //  NOTE: if a symbol name has speicial characters like '\n' or '\t', then, in the output code, the result
        //  should be '\n' or '\t'!!!
        int creation_StartLevel = 0;
        List<String> symbolStrings = new ArrayList<String>();
        symbolStrings.add("sym 1 \n");  // '\n' **
        symbolStrings.add("child 1 \t"); // '\t' **
        symbolStrings.add("child 2 \\");
        symbolStrings.add("child 3");

        boolean has_SymbolCreation = true;

        List<Symbol_Single> newlyCreatedSymbols = new ArrayList<Symbol_Single>();
        Boolean_Mutable have_Created_New_MultiPartSymbol = new Boolean_Mutable(false);
        Symbol multiPartSymbol = null;
        try {
            multiPartSymbol = symbolControl.multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, true,
                    have_Created_New_MultiPartSymbol, newlyCreatedSymbols);
        } catch (Exception e) {
            throw e;
        }


        CodeBuilder variablesCode = new CodeBuilder();
        CodeBuilder staticInitCode = new CodeBuilder();


        SymbolFile_Generator.generate_SingleSymbolVariables(SymbolType.Symbol, variablesCode, staticInitCode, symbol_Index);
        String varString = variablesCode.toString();
        String staticInitString = staticInitCode.toString();

        String dummy = null;

    }
    /**
     * Test of generate_SymbolFile method, of class SymbolFile_Generator.
     */
    @Test
    public void testGenerate_SymbolFile() {
        System.out.println("generate_SymbolFile");
        String symbolFile_Package = "";
        String symbolClassName = "AppSymbols";

        CodeBuilder expResult = null;
        CodeBuilder result = SymbolFile_Generator.generate_SymbolFile(null, SymbolType.Symbol, symbol_Index,  symbolFile_Package, symbolClassName);
        String outFile = result.toString();
  //      assertEquals(expResult, result);
    }

    /**
     * compiled the file generated in testGenerate_SymbolFile(). Test the compiled file
     */
    @Test
    public void test_SymbolFile() {
//        assertEquals(symbol_Index.getSingleSymbol_ByName("sym 1 \n"), AppSymbols.sym$32$1$32$$10$);
//        assertEquals(symbol_Index.getSingleSymbol_ByName("child 1 \t"), AppSymbols.child$32$1$32$$9$);
    }

    /**
     * Test of generate_MultiPartSymbolVariables method, of class SymbolFile_Generator.
     */
    @Test
    public void testGenerate_MultiPartSymbolVariables() {
        System.out.println("generate_MultiPartSymbolVariables");


        CodeBuilder variablesCode = new CodeBuilder();
        CodeBuilder staticInitCode = new CodeBuilder();

  

        SymbolFile_Generator.generate_MultiPartSymbolVariables(SymbolType.Symbol, variablesCode, staticInitCode, symbol_Index);

        String varString = variablesCode.toString();
        String staticInitString = staticInitCode.toString();

//        assertEquals(varString, expResultVar );



        //  TODO: testing of SymbolFile Generator - MultiPartSymbols: static init - compare the staticInitString to the file
        //        SymbolFile_GeneratorTest__MultiPart_StaticInit.txt


    }


    /**
     * Test of generate_SymbolFile method, of class SymbolFile_Generator.
     */
/*
    @Test
    public void testGenerate_MultiPart_SymbolFile() {
        System.out.println("generate_SymbolFile");
        String symbolFile_Package = "com.mypackage";

        CodeBuilder result = SymbolFile_Generator.generate_MultiPart_SymbolFile(null, SymbolType.Symbol, symbol_Index,  symbolFile_Package,
                singleSymbol_ClassName, multiPartSymbol_ClassName);
        String outFile = result.toString();
    }
   */


    /**
     * compiled the file generated in testGenerate_SymbolFile(). Test the compiled file
     */
    @Test
    public void test_MultiPart_SymbolFile() {
        SymbolName mpName  = null;
        try {
            mpName = new SymbolName(new String[] {"sym 1 \n"}, SymbolNameConstructor_MultiPart.constructor);
        } catch (Exception_InvalidArgumentPassed_Null e) { }
        Symbol_MultiPart mpSymbol =  symbol_Index.multiPart.get_MultiPartSymbol_ByMultiPartName(mpName);
        assertNotNull(mpSymbol);
//        assertTrue(mpSymbol == AppSymbols_MultiPart.sym$32$1$32$$10$ );
    }

}