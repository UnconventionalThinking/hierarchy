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
public class Symbol_Single_Test {

    public Symbol_Single_Test() {
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
    public void testCreateNew() throws Exception {
        System.out.println("createNew");

        //  Test the 3 arg version

        String name = "sym1";
        boolean has_StaticVersion = false;
        Boolean_Mutable createdNew_Symbol = new Boolean_Mutable();
        
        Symbol_Single result = symbolFactory.createNew(name, has_StaticVersion, createdNew_Symbol);
        assertEquals(result.ID, 0);
        assertEquals(result.name, name);
        String name_IdentFormat = TextUtilities.convertTextToIdentifier(name);
        assertEquals(result.name_IdentFormat, name_IdentFormat);
        assertEquals(result.has_StaticReference, false);
        assertEquals(createdNew_Symbol.value, true);



        name = "! sym 2.2-2";
        has_StaticVersion = true;
        createdNew_Symbol = new Boolean_Mutable();

        result = symbolFactory.createNew(name, has_StaticVersion, createdNew_Symbol);
        assertEquals(result.ID, 1);
        assertEquals(result.name, name);
        name_IdentFormat = TextUtilities.convertTextToIdentifier(name);
        assertEquals(result.name_IdentFormat, name_IdentFormat);
        assertEquals(result.has_StaticReference, true);
        assertEquals(createdNew_Symbol.value, true);


        name = "sym 3";
        has_StaticVersion = true;
        createdNew_Symbol = new Boolean_Mutable();

        result = symbolFactory.createNew(name, has_StaticVersion, createdNew_Symbol);
        assertEquals(result.ID, 2);
        assertEquals(result.name, name);
        name_IdentFormat = TextUtilities.convertTextToIdentifier(name);
        assertEquals(result.name_IdentFormat, name_IdentFormat);
        assertEquals(result.has_StaticReference, true);
        assertEquals(createdNew_Symbol.value, true);


        // try to create an existing symbol!! should just return old one
        name = "! sym 2.2-2";
        has_StaticVersion = true;
        createdNew_Symbol = new Boolean_Mutable();

        result = symbolFactory.createNew(name, has_StaticVersion, createdNew_Symbol);
        assertEquals(result.ID, 1);
        assertEquals(result.name, name);
        name_IdentFormat = TextUtilities.convertTextToIdentifier(name);
        assertEquals(result.name_IdentFormat, name_IdentFormat);
        assertEquals(result.has_StaticReference, true);
        assertEquals(createdNew_Symbol.value, false); //  false!!!





        // now, test 4 arg version of createNew_____________________________________________

        SymbolType symbolType = SymbolType.Symbol;

        name = "sym 4 !@#%";
        int id = 3;
        has_StaticVersion = false;
        createdNew_Symbol = new Boolean_Mutable();

        result = symbolFactory.createNew(symbolType, name, id, has_StaticVersion, createdNew_Symbol);
        assertEquals(result.ID, 3);
        assertEquals(result.name, name);
        name_IdentFormat = TextUtilities.convertTextToIdentifier(name);
        assertEquals(result.name_IdentFormat, name_IdentFormat);
        assertEquals(result.has_StaticReference, false);
        assertEquals(createdNew_Symbol.value, true);


        // do a _3_ arg test to make sure increment of id still working
        name = "! sym 5";
        has_StaticVersion = true;
        createdNew_Symbol = new Boolean_Mutable();

        result = symbolFactory.createNew(symbolType, name, has_StaticVersion, createdNew_Symbol);
        assertEquals(result.ID, 4);
        assertEquals(result.name, name);
        name_IdentFormat = TextUtilities.convertTextToIdentifier(name);
        assertEquals(result.name_IdentFormat, name_IdentFormat);
        assertEquals(result.has_StaticReference, true);
        assertEquals(createdNew_Symbol.value, true);


        // jump the id using a _4_ arg create New
        name = "6 sym 6";
        id = 100;
        has_StaticVersion = true;
        createdNew_Symbol = new Boolean_Mutable();

        result = symbolFactory.createNew(symbolType, name, id, has_StaticVersion, createdNew_Symbol);
        assertEquals(result.ID, 100);
        assertEquals(result.name, name);
        name_IdentFormat = TextUtilities.convertTextToIdentifier(name);
        assertEquals(result.name_IdentFormat, name_IdentFormat);
        assertEquals(result.has_StaticReference, true);
        assertEquals(createdNew_Symbol.value, true);


        // back to a 3 arg createNew to test increment again
        name = "sym 7 ...";
        has_StaticVersion = true;
        createdNew_Symbol = new Boolean_Mutable();

        result = symbolFactory.createNew(symbolType, name, has_StaticVersion, createdNew_Symbol);
        assertEquals(result.ID, 101);
        assertEquals(result.name, name);
        name_IdentFormat = TextUtilities.convertTextToIdentifier(name);
        assertEquals(result.name_IdentFormat, name_IdentFormat);
        assertEquals(result.has_StaticReference, true);
        assertEquals(createdNew_Symbol.value, true);



        // now, test to see if can get an existing one with _4_ arg verison - also, test to see if it changes
        // the has_StaticReference member of symbol.
        name = "! sym 5";
        id = 4;
        has_StaticVersion = false;
        createdNew_Symbol = new Boolean_Mutable();

        result = symbolFactory.createNew(symbolType, name, id, has_StaticVersion, createdNew_Symbol);
        assertEquals(result.ID, 4);
        assertEquals(result.name, name);
        name_IdentFormat = TextUtilities.convertTextToIdentifier(name);
        assertEquals(result.name_IdentFormat, name_IdentFormat);
        assertEquals(result.has_StaticReference, false); // changed from true to false!!
        assertEquals(createdNew_Symbol.value, false);  //  false!!

        // now, test to if you get the right error when you try to create a new symbol with a name that already exists
        // but the wrong id.
        name = "! sym 5";
        id = 1111; // wrong id!!
        has_StaticVersion = true;
        createdNew_Symbol = new Boolean_Mutable();
        boolean saw_Exception = false;
        try {
            result = symbolFactory.createNew(symbolType, name, id, has_StaticVersion, createdNew_Symbol);
        } catch (Exception_SymbolCreation e) {
            saw_Exception = true;
        }
        assertEquals(saw_Exception, true);


    }



}