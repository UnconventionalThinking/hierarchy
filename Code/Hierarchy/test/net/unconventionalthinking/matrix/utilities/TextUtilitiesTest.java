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

package net.unconventionalthinking.matrix.utilities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import net.unconventionalthinking.lang.*;

/**
 *
 * @author peterjoh
 */
public class TextUtilitiesTest {

    public TextUtilitiesTest() {
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
     * Test of convertTextToIdentifier and convertIdentiferToText methods, of class TextUtilities.
     */
    @Test
    public void testConvertTextToIdentifier_And_convertIdentiferToText () throws Exception {
        System.out.println("FormatAsIdentifier");

        String text = "simple";
        String expResult = "simple";
        String result = TextUtilities.convertTextToIdentifier(text);
        assertEquals(expResult, result);
        // convert back
        String convertedBack = TextUtilities.convertIdentiferToText(result);
        assertEquals(convertedBack, text);


        text = "FORM.REQUIRED";
        expResult = "FORM_REQUIRED";
        result = TextUtilities.convertTextToIdentifier(text);
        assertEquals(expResult, result);
        // convert back
        convertedBack = TextUtilities.convertIdentiferToText(result);
        assertEquals(convertedBack, text);

        text = "WEB.FORM.FORM.REQUIRED";
        expResult = "WEB_FORM_FORM_REQUIRED";
        result = TextUtilities.convertTextToIdentifier(text);
        assertEquals(expResult, result);
        // convert back
        convertedBack = TextUtilities.convertIdentiferToText(result);
        assertEquals(convertedBack, text);

        text = "1. HI,_Ho";
        expResult = "$" + Integer.toString('1') + "$" + "_" + "$" + Integer.toString(' ') + "$" +  "HI" +
                "$" + Integer.toString(',') + "$" + "$" + Integer.toString('_') + "$" + "Ho";
        result = TextUtilities.convertTextToIdentifier(text);
        assertEquals(expResult, result);
        // convert back
        convertedBack = TextUtilities.convertIdentiferToText(result);
        assertEquals(convertedBack, text);


    }


    /**
     * Test of convertCharToIdentifier_FirstChar method, of class TextUtilities.
     */
    @Test
    public void testFormatCharAsIdentifier_FirstChar() {
        System.out.println("FormatCharAsIdentifier_FirstChar");

        char ch = 'a';
        String expResult = "a";
        String result = TextUtilities.convertCharToIdentifier_FirstChar(ch);
        assertEquals(expResult, result);

        ch = 'Z';
        expResult = "Z";
        result = TextUtilities.convertCharToIdentifier_FirstChar(ch);
        assertEquals(expResult, result);

        ch = '1';
        expResult = "$" + Integer.toString(ch) + "$";
        result = TextUtilities.convertCharToIdentifier_FirstChar(ch);
        assertEquals(expResult, result);

        ch = '@';
        expResult = "$" + Integer.toString(ch) + "$";
        result = TextUtilities.convertCharToIdentifier_FirstChar(ch);
        assertEquals(expResult, result);

        ch = ' ';
        expResult = "$" + Integer.toString(ch) + "$";
        result = TextUtilities.convertCharToIdentifier_FirstChar(ch);
        assertEquals(expResult, result);


    }
    /**
     * Test of convertCharToIdentifier_NonFirstChar method, of class TextUtilities.
     */

    @Test
    public void testFormatCharAsIdentifier_NonFirstChar() {
        System.out.println("FormatCharAsIdentifier_NonFirstChar");
        char ch = 'a';
        String expResult = "a";
        String result = TextUtilities.convertCharToIdentifier_NonFirstChar(ch);
        assertEquals(expResult, result);

        ch = 'Z';
        expResult = "Z";
        result = TextUtilities.convertCharToIdentifier_NonFirstChar(ch);
        assertEquals(expResult, result);

        ch = '1';
        expResult = "1";
        result = TextUtilities.convertCharToIdentifier_NonFirstChar(ch);
        assertEquals(expResult, result);


        ch = '.';
        expResult = "_";
        result = TextUtilities.convertCharToIdentifier_NonFirstChar(ch);
        assertEquals(expResult, result);

        ch = ' ';
        expResult = "$" + Integer.toString(ch) + "$";
        result = TextUtilities.convertCharToIdentifier_NonFirstChar(ch);
        assertEquals(expResult, result);

        ch = '_';
        expResult = "$" + Integer.toString(ch) + "$";
        result = TextUtilities.convertCharToIdentifier_NonFirstChar(ch);
        assertEquals(expResult, result);

        ch = '@';
        expResult = "$" + Integer.toString(ch) + "$";
        result = TextUtilities.convertCharToIdentifier_NonFirstChar(ch);
        assertEquals(expResult, result);
    }








    /**
     * Test of convertIdentiferToChar_FirstCharElement method, of class TextUtilities.
     */
    @Test
    public void testConvertIdentiferToChar_FirstCharElement() throws Exception {
        System.out.println("convertIdentiferToChar_FirstCharElement");

        String identifierString = "a";
        Integer_Mutable indexOfSecondChar = new Integer_Mutable(-1);
        Character expResult = 'a';
        Character result = TextUtilities.convertIdentiferToChar_FirstCharElement(identifierString, indexOfSecondChar);
        assertEquals(expResult, result);
        assertEquals(indexOfSecondChar.value, 1);

        identifierString = "ab";
        indexOfSecondChar = new Integer_Mutable(-1);
        expResult = 'a';
        result = TextUtilities.convertIdentiferToChar_FirstCharElement(identifierString, indexOfSecondChar);
        assertEquals(expResult, result);
        assertEquals(indexOfSecondChar.value, 1);

        identifierString = "$" + Integer.toString('-') + "$b";
        indexOfSecondChar = new Integer_Mutable(-1);
        expResult = '-';
        result = TextUtilities.convertIdentiferToChar_FirstCharElement(identifierString, indexOfSecondChar);
        assertEquals(expResult, result);
        assertEquals(indexOfSecondChar.value, 4);

    }

    /**
     * Test of convertIdentiferToChar_NonFirstCharElement method, of class TextUtilities.
     */
    @Test
    public void testConvertIdentiferToChar_NonFirstCharElement() throws Exception {
        System.out.println("convertIdentiferToChar_NonFirstCharElement");

        String identifierString = "ab$" + Integer.toString('-') + "$1_";
        Integer_Mutable indexOfNextChar = new Integer_Mutable(-1);
        Character expResult = 'b';
        Character result = TextUtilities.convertIdentiferToChar_NonFirstCharElement(identifierString, 1, indexOfNextChar);
        assertEquals(expResult, result);
        assertEquals(indexOfNextChar.value, 2);

        expResult = '-';
        result = TextUtilities.convertIdentiferToChar_NonFirstCharElement(identifierString, 2, indexOfNextChar);
        assertEquals(expResult, result);
        assertEquals(indexOfNextChar.value, 6);


        expResult = '1';
        result = TextUtilities.convertIdentiferToChar_NonFirstCharElement(identifierString, 6, indexOfNextChar);
        assertEquals(expResult, result);
        assertEquals(indexOfNextChar.value, 7);

        expResult = '.';
        result = TextUtilities.convertIdentiferToChar_NonFirstCharElement(identifierString, 7, indexOfNextChar);
        assertEquals(expResult, result);
        assertEquals(indexOfNextChar.value, 8);

    }


    /**
     * Test of getCharCodeString method, of class TextUtilities.
     */
    @Test
    public void testGetCharCodeString() throws Exception {
        System.out.println("getCharCodeString");

        String identifierString = "a$" + Integer.toString('-') + "$b";
        int charCodeString_StartIndex = 1;
        Integer_Mutable indexOfNextChar = new Integer_Mutable(-1);
        char expResult = '-';
        char result = TextUtilities.getCharCodeString(identifierString, charCodeString_StartIndex, indexOfNextChar);
        assertEquals(expResult, result);
        assertEquals(indexOfNextChar.value, 5);

        identifierString = "$" + Integer.toString('a') + "$b";
        charCodeString_StartIndex = 0;
        indexOfNextChar = new Integer_Mutable(-1);
        expResult = 'a';
        result = TextUtilities.getCharCodeString(identifierString, charCodeString_StartIndex, indexOfNextChar);
        assertEquals(expResult, result);
        assertEquals(indexOfNextChar.value, 4);

        identifierString = "aaaa$" + Integer.toString('1') + "$";
        charCodeString_StartIndex = 4;
        indexOfNextChar = new Integer_Mutable(-1);
        expResult = '1';
        result = TextUtilities.getCharCodeString(identifierString, charCodeString_StartIndex, indexOfNextChar);
        assertEquals(expResult, result);
        assertEquals(indexOfNextChar.value, identifierString.length());

        identifierString = "$" + Integer.toString('!') + "$";
        charCodeString_StartIndex = 0;
        indexOfNextChar = new Integer_Mutable(-1);
        expResult = '!';
        result = TextUtilities.getCharCodeString(identifierString, charCodeString_StartIndex, indexOfNextChar);
        assertEquals(expResult, result);
        assertEquals(indexOfNextChar.value, identifierString.length() );
    }




}