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
public class DescTagNameAndLabel_MultiPart_Test {

    public DescTagNameAndLabel_MultiPart_Test() {
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
    public static Symbol_MultiPart_Factory multiPartSym_Factory = symbolControl.multiPartSymbol_Factory;


    /**
     * Test of createNew_DescTagName method, of class Symbol_MultiPart_Factory.
     */
    @Test
    public void testCreateNew_DescTagName() throws Exception {
        System.out.println("createNew_DescTagName");

        List<String> symbolStrings = new ArrayList<String>();
        symbolStrings.add("desc1");
        symbolStrings.add("descChild1");
        symbolStrings.add("descChild2");
        symbolStrings.add("descChild3");
        SymbolName multiPartName = SymbolNameConstructor_MultiPart.createNew_UsingStringList(symbolStrings);
        String nameString = "`desc1`.`descChild1`.`descChild2`.`descChild3`";
        String name_IdentFormat = multiPartName.name_IdentFormat;

        int creation_StartLevel = 0;
        boolean creation_Has_StaticVersion = true;
        Boolean_Mutable have_Created_New_MultiPartSymbol = new Boolean_Mutable(false);
        List<Symbol_Single> newlyCreatedSymbols = new ArrayList<Symbol_Single>();
        DescriptorTagName_MultiPart result = (DescriptorTagName_MultiPart)multiPartSym_Factory.createNew_DescTagName(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);
        assertEquals(multiPartName, result.name_MultiPart);
        assertEquals(nameString, result.name);
        assertEquals(name_IdentFormat, result.name_IdentFormat);

        // Now, check the multi-part index
        Symbol_MultiPart_WorkerTest_Utilities.checkFor_CorrectAddOfMultiPartSymbol_To_MultiLevelIndex(
                symbolControl.descTagNames_Index, result.symbols);

        // test descTagOrLabel is being put in right index
        Symbol foundSymbol = symbolControl.descTagNames_Index.multiPart.get_MultiPartSymbol_ById(result.ID);
        assertEquals(foundSymbol.name, nameString);
        assertEquals(symbolControl.appSymbolsIndex.multiPart.multiPart_Index_ByName.size(), 0);  // check that the symbols index has no elements



        //  Test bad desc tag namename
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("desc1");
        symbolStrings.add("descChild1 bad!");
        symbolStrings.add("descChild2");
        symbolStrings.add("descChild3");
        multiPartName = SymbolNameConstructor_MultiPart.createNew_UsingStringList(symbolStrings);
        nameString = "`desc1`.`descChild1 bad!`.`descChild2`.`descChild3`";
        name_IdentFormat = multiPartName.name_IdentFormat;

        creation_StartLevel = 0;
        creation_Has_StaticVersion = true;
        have_Created_New_MultiPartSymbol = new Boolean_Mutable(false);
        newlyCreatedSymbols = new ArrayList<Symbol_Single>();
        
        boolean saw_error = false;
        try {
            result = (DescriptorTagName_MultiPart)multiPartSym_Factory.createNew_DescTagName(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);
        } catch(Exception_MultiPartSymbolCreation e) {
            saw_error = true;
        }
        assertEquals(true, saw_error);

    }




    /**
     * Test of createNew_Label method, of class Symbol_MultiPart_Factory.
     */
    @Test
    public void testCreateNew_Label() throws Exception {
        System.out.println("createNew_Label");

        List<String> symbolStrings = new ArrayList<String>();
        symbolStrings.add("descOrLabel 1");
        symbolStrings.add("child1");
        symbolStrings.add("child2");
        symbolStrings.add("child3");
        SymbolName multiPartName = SymbolNameConstructor_MultiPart.createNew_UsingStringList(symbolStrings);
        String nameString = "`descOrLabel 1`.`child1`.`child2`.`child3`";
        String name_IdentFormat = multiPartName.name_IdentFormat;

        int creation_StartLevel = 0;
        boolean creation_Has_StaticVersion = true;
        Boolean_Mutable have_Created_New_MultiPartSymbol = new Boolean_Mutable(false);
        List<Symbol_Single> newlyCreatedSymbols = new ArrayList<Symbol_Single>();
        Label_MultiPart result = (Label_MultiPart)multiPartSym_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);
        assertEquals(multiPartName, result.name_MultiPart);
        assertEquals(nameString, result.name);
        assertEquals(name_IdentFormat, result.name_IdentFormat);

        // Now, check the multi-part index
        Symbol_MultiPart_WorkerTest_Utilities.checkFor_CorrectAddOfMultiPartSymbol_To_MultiLevelIndex(
                symbolControl.labels_Index, result.symbols);

        // test descTagOrLabel is being put in right index
        Symbol foundSymbol = symbolControl.labels_Index.multiPart.get_MultiPartSymbol_ById(result.ID);
        assertEquals(foundSymbol.name, nameString);
        assertEquals(symbolControl.appSymbolsIndex.multiPart.multiPart_Index_ByName.size(), 0);  // check that the symbols index has no elements
        assertEquals(symbolControl.labels_Index.multiPart.multiPart_Index_ByName.size(), 4);


        // check label info
        String nameString_TwoPart = "`descOrLabel 1` IN child1.child2.child3";
        assertEquals(result.getLabel_Simple(), nameString);
        assertEquals(result.getLabel_TwoPart(), nameString_TwoPart);
        assertEquals(result.getPrimaryLabel(false), "descOrLabel 1");
        assertEquals(result.getPrimaryLabel(true), "`descOrLabel 1`");
        assertEquals(result.getSecondaryLabel(), "child1.child2.child3");



    }


    /**
     * Test of find method, of class Symbol_MultiPart_Factory.
     */
    @Test
    public void testFind() throws Exception {

        System.out.println("find DescTagName");
        SymbolType symbolType = SymbolType.DescriptorTagName;
        List<String> symbolStrings = new ArrayList<String>();

        symbolStrings.add("desc1");
        symbolStrings.add("descChild1");
        symbolStrings.add("descChild2");
        symbolStrings.add("descChild3");

        SymbolName multiPartName = SymbolNameConstructor_MultiPart.createNew_UsingStringList(symbolStrings);
        String nameString = "`desc1`.`descChild1`.`descChild2`.`descChild3`";

        Symbol_MultiPart expResult = null;
        DescriptorTagName_MultiPart result = (DescriptorTagName_MultiPart)multiPartSym_Factory.find(symbolType, symbolStrings);
        assertEquals(multiPartName, result.name_MultiPart);
        assertEquals(nameString, result.name);

        Symbol foundSymbol = symbolControl.descTagNames_Index.multiPart.get_MultiPartSymbol_ById(result.ID);
        assertEquals(foundSymbol.name, nameString);




        System.out.println("find Label");
        symbolType = SymbolType.Label;
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("descOrLabel 1");
        symbolStrings.add("child1");
        symbolStrings.add("child2");
        symbolStrings.add("child3");
        multiPartName = SymbolNameConstructor_MultiPart.createNew_UsingStringList(symbolStrings);
        nameString = "`descOrLabel 1`.`child1`.`child2`.`child3`";

        Label_MultiPart result_Label = (Label_MultiPart)multiPartSym_Factory.find(symbolType, symbolStrings);
        assertEquals(multiPartName, result_Label.name_MultiPart);
        assertEquals(nameString, result_Label.name);

        foundSymbol = symbolControl.labels_Index.multiPart.get_MultiPartSymbol_ById(result_Label.ID);
        assertEquals(foundSymbol.name, nameString);
    }



}