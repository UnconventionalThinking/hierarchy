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

package net.unconventionalthinking.compiler.tools;

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
public class CodeBuilderTest {

    public CodeBuilderTest() {
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



    @Test
    public void testAddToStart_ObjectArray_1() {
        //____________________________________________________________________________________________________________

        System.out.println("CodeBuilder: addToStart(Object textStrings...): Basic Case");
        //____________________________________________________________________________________________________________

        Object[] textStrings =  {"String1,", "String2,", "gggg"};
        CodeBuilder instance = new CodeBuilder("Stuff");
        String expResult = textStrings[0].toString() + textStrings[1].toString() + textStrings[2].toString() + instance.toString();
        String result = instance.addToStart(textStrings).toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testAddToStart_ObjectArray_2() {
        //____________________________________________________________________________________________________________

        System.out.println("CodeBuilder: addToStart(Object textStrings...): null test");
        //____________________________________________________________________________________________________________

        Object[] textStrings =  {"String1,", null, "gggg"};
        CodeBuilder instance = new CodeBuilder("Stuff");
        String expResult = textStrings[0].toString() + textStrings[2].toString() + instance.toString();
        String result = instance.addToStart(textStrings).toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testAddToStart_boolean_ObjectArray_3() {
        //____________________________________________________________________________________________________________

        System.out.println("CodeBuilder: addToStart(Object textStrings...): Padding Between strings");
        //____________________________________________________________________________________________________________

        String addInBeetweenPaddingSpaces = " ";
        Object[] textStrings =  {"String1", "String2", "String3"};
        CodeBuilder instance = new CodeBuilder("Stuff");
        String expResult = textStrings[0].toString() + " " + textStrings[1].toString() + " " + textStrings[2].toString() + " " + instance.toString();
        String result = instance.addToStart(addInBeetweenPaddingSpaces, textStrings).toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testAddToStart_boolean_ObjectArray_4() {
        //____________________________________________________________________________________________________________

        System.out.println("CodeBuilder: addToStart(Object textStrings...): Padding Between strings w/ no codebuilder text");
        //____________________________________________________________________________________________________________

        String addInBeetweenPaddingSpaces = " ";
        Object[] textStrings =  {"String1", "String2", "String3"};
        CodeBuilder instance = new CodeBuilder(); // empty
        String expResult = textStrings[0].toString() + " " + textStrings[1].toString() + " " + textStrings[2].toString();
        String result = instance.addToStart(addInBeetweenPaddingSpaces, textStrings).toString();
        assertEquals(expResult, result);
    }








    @Test
    public void testAppend_ObjectArray_1() {
        //____________________________________________________________________________________________________________

        System.out.println("CodeBuilder: append(Object textStrings...): Basic Case");
        //____________________________________________________________________________________________________________

        Object[] textStrings =  {"String1,", "String2,", "gggg"};
        CodeBuilder instance = new CodeBuilder("Stuff");
        String expResult = instance.toString() + textStrings[0].toString() + textStrings[1].toString() + textStrings[2].toString();
        String result = instance.append(textStrings).toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testAppend_ObjectArray_2() {
        //____________________________________________________________________________________________________________

        System.out.println("CodeBuilder: append(Object textStrings...): null test");
        //____________________________________________________________________________________________________________

        Object[] textStrings =  {"String1,", null, "gggg"};
        CodeBuilder instance = new CodeBuilder("Stuff");
        String expResult = instance.toString() + textStrings[0].toString() + textStrings[2].toString();
        String result = instance.append(textStrings).toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testAppend_boolean_ObjectArray_3() {
        //____________________________________________________________________________________________________________

        System.out.println("CodeBuilder: append(Object textStrings...): Padding Between strings");
        //____________________________________________________________________________________________________________

        String addInBeetweenPaddingSpaces = " ";
        Object[] textStrings =  {"String1", "String2", "String3"};
        CodeBuilder instance = new CodeBuilder("Stuff");
        String expResult = instance.toString() + " " + textStrings[0].toString() + " " + textStrings[1].toString() + " " + textStrings[2].toString();
        String result = instance.append(addInBeetweenPaddingSpaces, textStrings).toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testAppend_boolean_ObjectArray_4() {
        //____________________________________________________________________________________________________________

        System.out.println("CodeBuilder: append(Object textStrings...): Padding Between strings w/ no codebuilder text");
        //____________________________________________________________________________________________________________

        String addInBeetweenPaddingSpaces = " ";
        Object[] textStrings =  {"String1", "String2", "String3"};
        CodeBuilder instance = new CodeBuilder(); // empty
        String expResult = textStrings[0].toString() + " " + textStrings[1].toString() + " " + textStrings[2].toString();
        String result = instance.append(addInBeetweenPaddingSpaces, textStrings).toString();
        assertEquals(expResult, result);
    }





}