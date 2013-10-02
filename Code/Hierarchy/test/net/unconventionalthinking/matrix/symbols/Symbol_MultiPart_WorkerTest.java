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

package net.unconventionalthinking.matrix.symbols;

import net.unconventionalthinking.lang.Boolean_Mutable;
import net.unconventionalthinking.matrix.utilities.*;


import java.util.ArrayList;
import java.util.List;
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
public class Symbol_MultiPart_WorkerTest {

    public Symbol_MultiPart_WorkerTest() {
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


    public static SymbolControl symbolControl = new SymbolControl();
    public static Symbol_MultiPart_Worker multiPartSymbol_Worker = new Symbol_MultiPart_Worker(symbolControl);

    /**
     * Test of getOrCreateEachSingleSymbol method, of class Symbol.
     */
    @Test
    public void testGetOrCreateEachSingleSymbol() throws Exception {
        System.out.println("getOrCreateEachSingleSymbol");


        // start creating new single symbols from the first single symbol (level 0!)
        int creation_StartLevel = 0;
        List<String> symbolStrings = new ArrayList<String>();
        symbolStrings.add("sym 1");
        symbolStrings.add("child 1");
        symbolStrings.add("child 2");
        symbolStrings.add("child 3");

        boolean has_SymbolCreation = true;
        List<Symbol_Single> newlyCreatedSymbols = new ArrayList<Symbol_Single>();
        Symbol_Single[] result = multiPartSymbol_Worker.getOrCreateEachSingleSymbol(SymbolType.Symbol, symbolStrings, has_SymbolCreation, creation_StartLevel, newlyCreatedSymbols);

        assertEquals(result.length , 4);
        assertEquals(result[0].name , symbolStrings.get(0));
        assertEquals(result[1].name , symbolStrings.get(1));
        assertEquals(result[2].name , symbolStrings.get(2));
        assertEquals(result[3].name , symbolStrings.get(3));

        assertEquals(newlyCreatedSymbols.size(), 4);
        assertTrue(newlyCreatedSymbols.get(0) == result[0]);
        assertTrue(newlyCreatedSymbols.get(1) == result[1]);
        assertTrue(newlyCreatedSymbols.get(2) == result[2]);
        assertTrue(newlyCreatedSymbols.get(3) == result[3]);


        // start creating new single symbols from the thrid single symbol (level 2)
        creation_StartLevel = 2;
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("sym 1");
        symbolStrings.add("child 1");
        symbolStrings.add("new child 2"); // new sym
        symbolStrings.add("new child 3"); // new sym

        has_SymbolCreation = true;
        newlyCreatedSymbols = new ArrayList<Symbol_Single>();
        result = multiPartSymbol_Worker.getOrCreateEachSingleSymbol(SymbolType.Symbol, symbolStrings, has_SymbolCreation, creation_StartLevel, newlyCreatedSymbols);

        assertEquals(result.length , 4);
        assertEquals(result[0].name , symbolStrings.get(0));
        assertEquals(result[1].name , symbolStrings.get(1));
        assertEquals(result[2].name , symbolStrings.get(2));
        assertEquals(result[3].name , symbolStrings.get(3));

        assertEquals(newlyCreatedSymbols.size(), 2);
        assertTrue(newlyCreatedSymbols.get(0) == result[2]);
        assertTrue(newlyCreatedSymbols.get(1) == result[3]);




       // start creating new single symbols from the third single symbol, but start creation at level 0!
        creation_StartLevel = 0;
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("sym 1");
        symbolStrings.add("child 1");
        symbolStrings.add("new child 22"); // new sym
        symbolStrings.add("new child 33"); // new sym
        symbolStrings.add("new child 44"); // new sym

        has_SymbolCreation = true;
        newlyCreatedSymbols = new ArrayList<Symbol_Single>();
        result = multiPartSymbol_Worker.getOrCreateEachSingleSymbol(SymbolType.Symbol, symbolStrings, has_SymbolCreation, creation_StartLevel, newlyCreatedSymbols);

        assertEquals(result.length , 5);
        assertEquals(result[0].name , symbolStrings.get(0));
        assertEquals(result[1].name , symbolStrings.get(1));
        assertEquals(result[2].name , symbolStrings.get(2));
        assertEquals(result[3].name , symbolStrings.get(3));
        assertEquals(result[4].name , symbolStrings.get(4));

        assertEquals(newlyCreatedSymbols.size(), 3);
        assertTrue(newlyCreatedSymbols.get(0) == result[2]);
        assertTrue(newlyCreatedSymbols.get(1) == result[3]);
        assertTrue(newlyCreatedSymbols.get(2) == result[4]);




       // start creating new single symbols from the third single symbol, and, have  some existing symbols mixed in!
        creation_StartLevel = 2;
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("sym 1");
        symbolStrings.add("child 1");
        symbolStrings.add("new child 111"); // new sym
        symbolStrings.add("child 2");       // existing !
        symbolStrings.add("new child 222"); // new sym
        symbolStrings.add("child 3");       // existing !

        // used to test that a new child 2 sym wasn't created
        Symbol_Single child2_sym = symbolControl.appSymbolsIndex.getSingleSymbol_ByName("child 2");

        has_SymbolCreation = true;
        newlyCreatedSymbols = new ArrayList<Symbol_Single>();
        result = multiPartSymbol_Worker.getOrCreateEachSingleSymbol(SymbolType.Symbol, symbolStrings, has_SymbolCreation, creation_StartLevel, newlyCreatedSymbols);

        assertEquals(result.length , 6);
        assertEquals(result[0].name , symbolStrings.get(0));
        assertEquals(result[1].name , symbolStrings.get(1));
        assertEquals(result[2].name , symbolStrings.get(2));
        assertEquals(result[3].name , symbolStrings.get(3));
        assertEquals(result[4].name , symbolStrings.get(4));
        assertEquals(result[5].name , symbolStrings.get(5));

        assertEquals(newlyCreatedSymbols.size(), 2);
        assertTrue(newlyCreatedSymbols.get(0) == result[2]);
        assertTrue(newlyCreatedSymbols.get(1) == result[4]);

        // make sure a new child 2 sym wasn't created:
        assertTrue(child2_sym == result[3]);


       // start creating at wrong creation level!
        creation_StartLevel = 2;  // wrong creation level, should be 1!
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("sym 2!"); // new sym
        symbolStrings.add("new a");
        symbolStrings.add("new b");

        has_SymbolCreation = true;
        newlyCreatedSymbols = new ArrayList<Symbol_Single>();
        boolean had_Error = false;
        try {
            result = multiPartSymbol_Worker.getOrCreateEachSingleSymbol(SymbolType.Symbol, symbolStrings, has_SymbolCreation, creation_StartLevel, newlyCreatedSymbols);
        } catch (Exception_MultiPartSymbolAccess e) {
           had_Error = true;
        }
        assertEquals(had_Error, true);


        // start creating at wrong creation level, test 2
        creation_StartLevel = 3;  // wrong creation level, should be 2!
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("sym 1");
        symbolStrings.add("new child 1!!"); // new sym
        symbolStrings.add("child 2");
        symbolStrings.add("child 3");

        has_SymbolCreation = true;
        newlyCreatedSymbols = new ArrayList<Symbol_Single>();
        had_Error = false;
        try {
            result = multiPartSymbol_Worker.getOrCreateEachSingleSymbol(SymbolType.Symbol, symbolStrings, has_SymbolCreation, creation_StartLevel, newlyCreatedSymbols);
        } catch (Exception_MultiPartSymbolAccess e) {
           had_Error = true;
        }
        assertEquals(had_Error, true);



        //  ____________________________________________________________________________________________________________
        //
        //    Test Accessing (getting), existing single symbols
        //  ____________________________________________________________________________________________________________

        // accessing existing symbols
        creation_StartLevel = 999999;
        has_SymbolCreation = false; //  false! no sym creation


        symbolStrings = new ArrayList<String>();
        symbolStrings.add("sym 1");         //  all of these are existing symbols
        symbolStrings.add("child 1");
        symbolStrings.add("child 2");
        symbolStrings.add("child 3");

        newlyCreatedSymbols = new ArrayList<Symbol_Single>();
        result = multiPartSymbol_Worker.getOrCreateEachSingleSymbol(SymbolType.Symbol, symbolStrings, has_SymbolCreation, creation_StartLevel, newlyCreatedSymbols);

        assertEquals(result.length , 4);
        assertEquals(result[0].name , symbolStrings.get(0));
        assertEquals(result[1].name , symbolStrings.get(1));
        assertEquals(result[2].name , symbolStrings.get(2));
        assertEquals(result[3].name , symbolStrings.get(3));

        assertEquals(newlyCreatedSymbols.size(), 0);  // should be zero!



        // error test: try to creat a new
        creation_StartLevel = 999999;
        has_SymbolCreation = false; //  false! no sym creation


        symbolStrings = new ArrayList<String>();
        symbolStrings.add("sym 1");         //  all of these are existing symbols, except:
        symbolStrings.add("child 1");
        symbolStrings.add("new child 2222");   // this one is new - should throw an error
        symbolStrings.add("child 3");
        symbolStrings.add("child 4");

        newlyCreatedSymbols = new ArrayList<Symbol_Single>();
        had_Error = false;
        try {
            result = multiPartSymbol_Worker.getOrCreateEachSingleSymbol(SymbolType.Symbol, symbolStrings, has_SymbolCreation, creation_StartLevel, newlyCreatedSymbols);
        } catch (Exception_MultiPartSymbolAccess e) {
            had_Error = true;
        }
        assertEquals(had_Error, true);


    }


    /**
     * Test of addOrAccess_MultiPartSymbol_To_Indexes method, of class multiPartSymbol_Worker.
     *
     * NOTE: These tests use the symbol objects created in the previous tests!
     */
    @Test
    public void testAddOrAccess_MultiPartSymbol_To_Indexes() throws Exception {
        System.out.println("addOrAccess_MultiPartSymbol_To_Indexes");


        Symbol_Single[] symbols = new Symbol_Single[]
            {symbolControl.appSymbolsIndex.single_Index_ByName.get("sym 1"), symbolControl.appSymbolsIndex.single_Index_ByName.get("child 1"),
             symbolControl.appSymbolsIndex.single_Index_ByName.get("child 2") };

        SymbolName multiPartName = new SymbolName(symbols, SymbolNameConstructor_MultiPart.constructor);
        String nameString = "`sym 1`.`child 1`.`child 2`";
        String nameString_no_backtiks = "sym 1.child 1.child 2";
        String name_IdentFormat = "sym$32$1$__$child$32$1$__$child$32$2";
        int creation_StartLevel = 0;
        boolean has_StaticVersion = true;

        Symbol_MultiPart result = multiPartSymbol_Worker.addOrAccess_MultiPartSymbol_To_Indexes(SymbolType.Symbol, symbols,
                                                                                                creation_StartLevel, has_StaticVersion);
        for (int i = 0; i < symbols.length; ++i)
            assertEquals(symbols[i], result.symbols[i]);
        assertEquals(multiPartName, result.name_MultiPart);
        assertEquals(nameString, result.name);
        assertEquals(nameString_no_backtiks, result.name_MultiPart.name_no_backtiks);
        assertEquals(name_IdentFormat, result.name_IdentFormat);


        // Now, check the multi-part index
        Symbol_MultiPart_WorkerTest_Utilities.checkFor_CorrectAddOfMultiPartSymbol_To_MultiLevelIndex(
                symbolControl.appSymbolsIndex, symbols);


        //  ____________________________________________________________________________________________________________
        //
        //  now, test creation of new multipart at level 3
        //  ____________________________________________________________________________________________________________

        symbols = new Symbol_Single[]
            {symbolControl.appSymbolsIndex.single_Index_ByName.get("sym 1"), symbolControl.appSymbolsIndex.single_Index_ByName.get("child 1"),
             symbolControl.appSymbolsIndex.single_Index_ByName.get("new child 2"), symbolControl.appSymbolsIndex.single_Index_ByName.get("new child 3") };
        // Note: "new child 2" and "new child 3" actually already exist, from prev test.

        multiPartName = new SymbolName(symbols, SymbolNameConstructor_MultiPart.constructor);
        nameString = "`sym 1`.`child 1`.`new child 2`.`new child 3`";
        nameString_no_backtiks = "sym 1.child 1.new child 2.new child 3";
        name_IdentFormat = "sym$32$1$__$child$32$1$__$new$32$child$32$2$__$new$32$child$32$3";
        creation_StartLevel = 3;
        has_StaticVersion = true;

        result = multiPartSymbol_Worker.addOrAccess_MultiPartSymbol_To_Indexes(SymbolType.Symbol, symbols, creation_StartLevel, has_StaticVersion);
        for (int i = 0; i < symbols.length; ++i)
            assertEquals(symbols[i], result.symbols[i]);
        assertEquals(multiPartName, result.name_MultiPart);
        assertEquals(nameString, result.name);
        assertEquals(nameString_no_backtiks, result.name_MultiPart.name_no_backtiks);
        assertEquals(name_IdentFormat, result.name_IdentFormat);


        // Now, check the multi-part index
        Symbol_MultiPart_WorkerTest_Utilities.checkFor_CorrectAddOfMultiPartSymbol_To_MultiLevelIndex(
                symbolControl.appSymbolsIndex, symbols);





        //  ____________________________________________________________________________________________________________
        //
        //  now, test creation of new multipart at level 3 ("new child 22"), but with creation level set at 1
        //  ____________________________________________________________________________________________________________

        symbols = new Symbol_Single[]
            {symbolControl.appSymbolsIndex.single_Index_ByName.get("sym 1"), symbolControl.appSymbolsIndex.single_Index_ByName.get("child 1"),
             symbolControl.appSymbolsIndex.single_Index_ByName.get("new child 22"), symbolControl.appSymbolsIndex.single_Index_ByName.get("new child 3") };


        multiPartName = new SymbolName(symbols, SymbolNameConstructor_MultiPart.constructor);
        nameString = "`sym 1`.`child 1`.`new child 22`.`new child 3`";
        name_IdentFormat = "sym$32$1$__$child$32$1$__$new$32$child$32$22$__$new$32$child$32$3";
        creation_StartLevel = 1;
        has_StaticVersion = true;

        result = multiPartSymbol_Worker.addOrAccess_MultiPartSymbol_To_Indexes(SymbolType.Symbol, symbols, creation_StartLevel, has_StaticVersion);
        for (int i = 0; i < symbols.length; ++i)
            assertEquals(symbols[i], result.symbols[i]);
        assertEquals(multiPartName, result.name_MultiPart);
        assertEquals(nameString, result.name);
        assertEquals(name_IdentFormat, result.name_IdentFormat);

        // Now, check the multi-part index
        Symbol_MultiPart_WorkerTest_Utilities.checkFor_CorrectAddOfMultiPartSymbol_To_MultiLevelIndex(
                symbolControl.appSymbolsIndex, symbols);

        //  ____________________________________________________________________________________________________________
        //
        //  ** creation of new multipart at level 2 ("new child 222"), but with a single symbol that has NOT
        //     been used in a multipart symbol before!!
        //         ex.  +:syma // new
        //              :syma.+:symb // sym b is new
        //        The reason this is an important test is because :syma has NOT been added to th multipart index at
        //        level 1 yet, but creation level is at level 2!! so, the index must know that at the first level,
        //        any single symbol can be added to the index even if the creation level is greater than 1!!
        //  ____________________________________________________________________________________________________________

        symbols = new Symbol_Single[]
            {symbolControl.appSymbolsIndex.single_Index_ByName.get("child 1"),  // existing, but not in level 1 of multi-level index
             symbolControl.appSymbolsIndex.single_Index_ByName.get("child 2"),   // set the creation level here, to 2
             symbolControl.appSymbolsIndex.single_Index_ByName.get("child 3") };


        //  Check to see that child1 is NOT already in level of multi-level index:
        Symbol_Single child1 = symbolControl.appSymbolsIndex.getSingleSymbol_ByName("child 1");
        HashOrMultiPartSymbol_Bucket child1_Level1_Bucket = symbolControl.appSymbolsIndex.multiPart.multiTreeLevel_MultiPart_Index_By_Id.get(child1.ID);
        assertNull(child1_Level1_Bucket);


        multiPartName = new SymbolName(symbols, SymbolNameConstructor_MultiPart.constructor);
        nameString = "`child 1`.`child 2`.`child 3`";
        name_IdentFormat = "child$32$1$__$child$32$2$__$child$32$3";
        creation_StartLevel = 2;
        has_StaticVersion = true;

        result = multiPartSymbol_Worker.addOrAccess_MultiPartSymbol_To_Indexes(SymbolType.Symbol, symbols, creation_StartLevel, has_StaticVersion);
        for (int i = 0; i < symbols.length; ++i)
            assertEquals(symbols[i], result.symbols[i]);
        assertEquals(multiPartName, result.name_MultiPart);
        assertEquals(nameString, result.name);
        assertEquals(name_IdentFormat, result.name_IdentFormat);

        // Now, check the multi-part index
        Symbol_MultiPart_WorkerTest_Utilities.checkFor_CorrectAddOfMultiPartSymbol_To_MultiLevelIndex(
                symbolControl.appSymbolsIndex, symbols);




        //  ____________________________________________________________________________________________________________
        //
        //  error test: creation of new multipart at level 2 ("new child 222"), but with creation level set at 3
        //  ____________________________________________________________________________________________________________

        symbols = new Symbol_Single[]
            {symbolControl.appSymbolsIndex.single_Index_ByName.get("sym 1"), symbolControl.appSymbolsIndex.single_Index_ByName.get("new child 222"),
             symbolControl.appSymbolsIndex.single_Index_ByName.get("new child 2")};


        multiPartName = new SymbolName(symbols, SymbolNameConstructor_MultiPart.constructor);
        creation_StartLevel = 3;
        has_StaticVersion = true;

        boolean had_error = false;
        try {
            result = multiPartSymbol_Worker.addOrAccess_MultiPartSymbol_To_Indexes(SymbolType.Symbol, symbols, creation_StartLevel, has_StaticVersion);
        } catch (Exception_MultiPartSymbolAccess e) {
            had_error = true;
        } catch (Exception_MultiPartSymbolCreation e) {
            had_error = true;
        }
        assertEquals(true, had_error);

    }




    /**
     * Test of access_MultiPartSymbol method, of class multiPartSymbol_Worker.
     */
    @Test
    public void testAccess_MultiPartSymbol() throws Exception {
        Symbol_Single[] symbols = new Symbol_Single[]
            {symbolControl.appSymbolsIndex.single_Index_ByName.get("sym 1"), symbolControl.appSymbolsIndex.single_Index_ByName.get("child 1"),
             symbolControl.appSymbolsIndex.single_Index_ByName.get("child 2") };

        SymbolName multiPartName = new SymbolName(symbols, SymbolNameConstructor_MultiPart.constructor);
        String nameString = "`sym 1`.`child 1`.`child 2`";
        String name_IdentFormat = "sym$32$1$__$child$32$1$__$child$32$2";

        Symbol_MultiPart result = multiPartSymbol_Worker.access_MultiPartSymbol(SymbolType.Symbol, symbols);
        for (int i = 0; i < symbols.length; ++i)
            assertEquals(symbols[i], result.symbols[i]);
        assertEquals(multiPartName, result.name_MultiPart);
        assertEquals(nameString, result.name);
        assertEquals(name_IdentFormat, result.name_IdentFormat);


        // Now, check the multi-part index
        Symbol_MultiPart_WorkerTest_Utilities.checkFor_CorrectAddOfMultiPartSymbol_To_MultiLevelIndex(
                symbolControl.appSymbolsIndex, symbols);
    }





    /**
     * Test of find method, of class multiPartSymbol_Worker.
     */
    @Test
    public void testFind() throws Exception {

        System.out.println("find");
        List<String> symbolStrings = new ArrayList<String>();
        symbolStrings.add("sym 1");
        symbolStrings.add("child 1");
        symbolStrings.add("new child 22");
        symbolStrings.add("new child 3");

        Symbol result = multiPartSymbol_Worker.find(SymbolType.Symbol, symbolStrings);
        for (int i = 0; i < symbolStrings.size(); ++i)
            assertEquals(symbolStrings.get(i), ((Symbol_MultiPart)result).symbols[i].name);

        SymbolName multiPartName = SymbolNameConstructor_MultiPart.createNew_UsingStringList(symbolStrings);
        assertEquals(multiPartName, result.name_MultiPart);
        assertEquals(multiPartName.name, result.name);
        assertEquals(multiPartName.name_IdentFormat, result.name_IdentFormat);

        
        //  Error test!: should not find a `child 1` off of `child 1`
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("sym 1");
        symbolStrings.add("child 1");
        symbolStrings.add("child 1");

        boolean had_error = false;
        try {
            result = multiPartSymbol_Worker.find(SymbolType.Symbol, symbolStrings);
        } catch (Exception_MultiPartSymbolAccess e) {
            had_error = true;
        }
        assertTrue(had_error);

    }





}