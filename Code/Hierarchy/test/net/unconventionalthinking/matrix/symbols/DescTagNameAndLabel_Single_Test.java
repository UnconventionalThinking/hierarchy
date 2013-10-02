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

import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;
import net.unconventionalthinking.lang.Boolean_Mutable;
import net.unconventionalthinking.matrix.utilities.TextUtilities;
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
public class DescTagNameAndLabel_Single_Test {

    public DescTagNameAndLabel_Single_Test() {
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
    public static Symbol_Single_Factory symbolFactory = new Symbol_Single_Factory(symbolControl);


    /**
     * Test of createNew method, of class Symbol_Single.
     */
    @Test
    public void testCreateNew_DescTagName() throws Exception {
        System.out.println("createNew_DescTagName");

        //  Test the 3 arg version

        String name = "descTagOrLabel1";
        boolean has_StaticVersion = false;
        Boolean_Mutable createdNew_Symbol = new Boolean_Mutable();
        
        DescriptorTagName_Single result = symbolFactory.createNew_DescTagName(name, has_StaticVersion, createdNew_Symbol);
        assertEquals(result.ID, 0);
        assertEquals(result.name, name);
        String name_IdentFormat = TextUtilities.convertTextToIdentifier(name);
        assertEquals(result.name_IdentFormat, name_IdentFormat);
        assertEquals(result.has_StaticReference, false);
        assertEquals(createdNew_Symbol.value, true);

        // test descTagOrLabel is being put in right index
        Symbol foundSymbol = symbolControl.descTagNames_Index.single_Index_ByName.get(name);
        assertEquals(foundSymbol.name, name);
        assertEquals(symbolControl.appSymbolsIndex.single_Index_ByName.size(), 0);  // check that the symbols index has no elements



        name = "descTagOrLabel2_22";
        has_StaticVersion = true;
        createdNew_Symbol = new Boolean_Mutable();

        result = symbolFactory.createNew_DescTagName(name, has_StaticVersion, createdNew_Symbol);
        assertEquals(result.ID, 1);
        assertEquals(result.name, name);
        name_IdentFormat = TextUtilities.convertTextToIdentifier(name);
        assertEquals(result.name_IdentFormat, name_IdentFormat);
        assertEquals(result.has_StaticReference, true);
        assertEquals(createdNew_Symbol.value, true);

        // test descTagOrLabel is being put in right index
        foundSymbol = symbolControl.descTagNames_Index.single_Index_ByName.get(name);
        assertEquals(foundSymbol.name, name);
        assertEquals(symbolControl.appSymbolsIndex.single_Index_ByName.size(), 0);  // check that the symbols index has no elements




        // try to create an existing symbol!! should just return old one
        name = "descTagOrLabel2_22";
        has_StaticVersion = true;
        createdNew_Symbol = new Boolean_Mutable();

        result = symbolFactory.createNew_DescTagName(name, has_StaticVersion, createdNew_Symbol);
        assertEquals(result.ID, 1);
        assertEquals(result.name, name);
        name_IdentFormat = TextUtilities.convertTextToIdentifier(name);
        assertEquals(result.name_IdentFormat, name_IdentFormat);
        assertEquals(result.has_StaticReference, true);
        assertEquals(createdNew_Symbol.value, false); //  false!!!




        // test trying to create a descTag with an invalid name!!
        name = "badDescTag because of spaces";
        has_StaticVersion = true;
        createdNew_Symbol = new Boolean_Mutable();
        boolean saw_Exception = false;
        try {
            result = symbolFactory.createNew_DescTagName(name, has_StaticVersion, createdNew_Symbol);
        } catch (Exception_InvalidArgumentPassed e) {
            saw_Exception = true;
        }
        assertEquals(saw_Exception, true);


        // now, test 4 arg version of createNew_____________________________________________

        SymbolType symbolType = SymbolType.DescriptorTagName;

        name = "descTagOrLabel4";
        int id = 3;
        has_StaticVersion = false;
        createdNew_Symbol = new Boolean_Mutable();

        result = (DescriptorTagName_Single)symbolFactory.createNew(symbolType, name, id, has_StaticVersion, createdNew_Symbol);
        assertEquals(result.ID, 3);
        assertEquals(result.name, name);
        name_IdentFormat = TextUtilities.convertTextToIdentifier(name);
        assertEquals(result.name_IdentFormat, name_IdentFormat);
        assertEquals(result.has_StaticReference, false);
        assertEquals(createdNew_Symbol.value, true);




        // now, test to if you get the right error when you try to create a new symbol with a name that already exists
        // but the wrong id.
        name = "descTagOrLabel4";
        id = 1111; // wrong id!!
        has_StaticVersion = true;
        createdNew_Symbol = new Boolean_Mutable();
         saw_Exception = false;
        try {
            result = (DescriptorTagName_Single)symbolFactory.createNew(symbolType, name, id, has_StaticVersion, createdNew_Symbol);
        } catch (Exception_SymbolCreation e) {
            saw_Exception = true;
        }
        assertEquals(saw_Exception, true);


    }



    /**
     * Test of createNew method, of class Symbol_Single.
     */
    @Test
    public void testCreateNew_Label() throws Exception {
        System.out.println("createNew_Label");

        //  Test the 3 arg version

        String name = "Label 1";
        String name_w_backtiks = "`" + name +  "`";
        boolean has_StaticVersion = false;
        Boolean_Mutable createdNew_Symbol = new Boolean_Mutable();

        Label_Single result = symbolFactory.createNew_Label(name, has_StaticVersion, createdNew_Symbol);
        assertEquals(result.ID, 4);
        assertEquals(result.name, name);
        String name_IdentFormat = TextUtilities.convertTextToIdentifier(name);
        assertEquals(result.name_IdentFormat, name_IdentFormat);
        assertEquals(result.has_StaticReference, false);
        assertEquals(createdNew_Symbol.value, true);

        // test descTagOrLabel is being put in right index
        Symbol foundSymbol = symbolControl.labels_Index.single_Index_ByName.get(name);
        assertEquals(foundSymbol.name, name);
        assertEquals(symbolControl.appSymbolsIndex.single_Index_ByName.size(), 0);  // check that the symbols index has no elements
        assertEquals(symbolControl.descTagNames_Index.single_Index_ByName.size(), 3);  // check that the desc Tag index has not added any elements

        // check label info
        assertEquals(result.getLabel_Simple(), name_w_backtiks);
        assertEquals(result.getLabel_TwoPart(), name_w_backtiks);
        assertEquals(result.getPrimaryLabel(false), name);
        assertEquals(result.getPrimaryLabel(true), name_w_backtiks);
        assertEquals(result.getSecondaryLabel(), null);



        name = "Label 2";
        name_w_backtiks = "`" + name +  "`";
        has_StaticVersion = true;
        createdNew_Symbol = new Boolean_Mutable();

        result = symbolFactory.createNew_Label(name, has_StaticVersion, createdNew_Symbol);
        assertEquals(result.ID, 5);
        assertEquals(result.name, name);
        name_IdentFormat = TextUtilities.convertTextToIdentifier(name);
        assertEquals(result.name_IdentFormat, name_IdentFormat);
        assertEquals(result.has_StaticReference, true);
        assertEquals(createdNew_Symbol.value, true);

        // test descTagOrLabel is being put in right index
        foundSymbol = symbolControl.labels_Index.single_Index_ByName.get(name);
        assertEquals(foundSymbol.name, name);
        assertEquals(symbolControl.appSymbolsIndex.single_Index_ByName.size(), 0);  // check that the symbols index has no elements

        // check label info
        assertEquals(result.getLabel_Simple(), name_w_backtiks);
        assertEquals(result.getLabel_TwoPart(), name_w_backtiks);
        assertEquals(result.getPrimaryLabel(false), name);
        assertEquals(result.getPrimaryLabel(true), name_w_backtiks);
        assertEquals(result.getSecondaryLabel(), null);




        // try to create an existing symbol!! should just return old one
        name = "Label 2";
        name_w_backtiks = "`" + name +  "`";
        has_StaticVersion = true;
        createdNew_Symbol = new Boolean_Mutable();

        result = symbolFactory.createNew_Label(name, has_StaticVersion, createdNew_Symbol);
        assertEquals(result.ID, 5);
        assertEquals(result.name, name);
        name_IdentFormat = TextUtilities.convertTextToIdentifier(name);
        assertEquals(result.name_IdentFormat, name_IdentFormat);
        assertEquals(result.has_StaticReference, true);
        assertEquals(createdNew_Symbol.value, false); //  false!!!





        // now, test 4 arg version of createNew_____________________________________________

        SymbolType symbolType = SymbolType.Label;

        name = "Label 3";
        name_w_backtiks = "`" + name +  "`";
        int id = 10;
        has_StaticVersion = false;
        createdNew_Symbol = new Boolean_Mutable();

        result = (Label_Single)symbolFactory.createNew(symbolType, name, id, has_StaticVersion, createdNew_Symbol);
        assertEquals(result.ID, id);
        assertEquals(result.name, name);
        name_IdentFormat = TextUtilities.convertTextToIdentifier(name);
        assertEquals(result.name_IdentFormat, name_IdentFormat);
        assertEquals(result.has_StaticReference, false);
        assertEquals(createdNew_Symbol.value, true);




        // now, test to if you get the right error when you try to create a new symbol with a name that already exists
        // but the wrong id.
        name = "Label 3";
        id = 1111; // wrong id!!
        has_StaticVersion = true;
        createdNew_Symbol = new Boolean_Mutable();
        boolean saw_Exception = false;
        try {
            result = (Label_Single)symbolFactory.createNew(symbolType, name, id, has_StaticVersion, createdNew_Symbol);
        } catch (Exception_SymbolCreation e) {
            saw_Exception = true;
        }
        assertEquals(saw_Exception, true);


    }


}