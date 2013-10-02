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
 */

package net.unconventionalthinking.hierarchy.compilertools;

import net.unconventionalthinking.hierarchy.*;
import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.hierarchy.grammar.node.TIdentifier;

import java.util.LinkedList;
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
public class Node_UtilitiesTest {

    public Node_UtilitiesTest() {
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


    /**
     * Test of createCode_fromManyChildNodes method, of class Node_Utilities.
     * NOTE: this also test the Token classes code for the 'code()' method that is inserted.
     */
    @Test
    public void testCreateCode_fromManyChildNodes_test1() {

        //____________________________________________________________________________________________________________

        System.out.println("Node_Utilities:createCode_fromManyChildNodes(): Basic Case");
        //____________________________________________________________________________________________________________

        LinkedList<TIdentifier> childNodes = new LinkedList<TIdentifier>();
        // NOTE: there is no param1. The reason is in the production grammar, param1 is matched first, and then
        // the other params are matched recursively. The reason is because the all the other params will match on
        // ', myParam' (with a comma)
        childNodes.add(new TIdentifier("param2"));
        childNodes.add(new TIdentifier("param3"));
        childNodes.add(new TIdentifier("param4"));

        String addBeforeTextString = ", ";
        String appendTextString = null;
        CodeBuilder expResult = new CodeBuilder(", param2, param3, param4");

        CodeBuilder result = Node_Utilities.createCode_fromManyChildNodes(addBeforeTextString, childNodes, appendTextString);
        
        // just so you can see results in debugger
        String temp1 = expResult.toString(); String temp2 = result.toString().trim();

        assertEquals(expResult.toString(), result.toString().trim());

    }



    @Test
    public void testCreateCode_fromManyChildNodes_test2() {

        //____________________________________________________________________________________________________________

        System.out.println("Node_Utilities:createCode_fromManyChildNodes(): null test");
        //____________________________________________________________________________________________________________

        LinkedList<TIdentifier> childNodes = new LinkedList<TIdentifier>();
        childNodes.add(new TIdentifier("param2"));
        childNodes.add(null);
        childNodes.add(new TIdentifier("param4"));

        String addBeforeTextString = ", ";
        String appendTextString = null;
        CodeBuilder expResult = new CodeBuilder(", param2, param4");

        CodeBuilder result = Node_Utilities.createCode_fromManyChildNodes(addBeforeTextString, childNodes, appendTextString);

        // just so you can see results in debugger
        String temp1 = expResult.toString(); String temp2 = result.toString().trim();

        assertEquals(expResult.toString(), result.toString().trim());

    }


}