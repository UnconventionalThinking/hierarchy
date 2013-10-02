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

package net.unconventionalthinking.regex;

import java.util.*;
import java.util.regex.Pattern;
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
public class RegExTest {

    public RegExTest() {
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
     * Test of prepare_RegEx method, of class RegEx.
     */
    @Test
    public void testPrepare_RegEx() {

        //____________________________________________________________________________________________________________

        System.out.println("RegularExpressions: prepare_RegEx():");
        //____________________________________________________________________________________________________________

        String regex = "  Blah  ";
        boolean add_SearchFromBeginning = true;
        Pattern expResult = Pattern.compile("^" + regex.trim());
        Pattern result = RegEx.prepare_RegEx(regex, add_SearchFromBeginning);
        System.out.printf("   test1: expected regex: '%s', real regex: '%s', and equals is: %s\n", expResult, result, expResult.toString().equals(result.toString()));

        //   Check doesn't add a second '^'
        regex = "  ^Blah.*   ";
        add_SearchFromBeginning = true;
        expResult = Pattern.compile(regex.trim());
        result = RegEx.prepare_RegEx(regex, add_SearchFromBeginning);
        System.out.printf("   test2: no second '^': expected regex: '%s', real regex: '%s', and equals is: %s\n", expResult, result, expResult.toString().equals(result.toString()));

        //   Check doesn't add any '^'
        regex = "Blah.*";
        add_SearchFromBeginning = false;
        expResult = Pattern.compile(regex);
        result = RegEx.prepare_RegEx(regex, add_SearchFromBeginning);
        System.out.printf("   test3: no '^': expected regex: '%s', real regex: '%s', and equals is: %s\n", expResult, result, expResult.toString().equals(result.toString()));


        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of prepare_RegExArray method, of class RegEx.
     */
    @Test
    public void testPrepare_RegExArray() {
        //____________________________________________________________________________________________________________

        System.out.println("RegularExpressions: prepare_RegExArray():");
        //____________________________________________________________________________________________________________

        String[] regexArray = {"Stuff", "  ^blah.*  ", "   good.*"};
        
        List<Pattern> expResult = new ArrayList<Pattern>();
        expResult.add(Pattern.compile("^Stuff"));
        expResult.add(Pattern.compile("^blah.*")); //  no space, no extra ^
        expResult.add(Pattern.compile("^good.*")); //  ^ added

        boolean add_SearchFromBeginning = true;
        List<Pattern> result = RegEx.prepare_RegExArray(regexArray, add_SearchFromBeginning);

        assertEquals(expResult.get(0).toString(), result.get(0).toString());
        assertEquals(expResult.get(1).toString(), result.get(1).toString());
        assertEquals(expResult.get(2).toString(), result.get(2).toString());
    }

    /**
     * Test of matchOn_RegExList method, of class RegEx.
     */
    @Test
    public void testMatchOn_RegExList() {
        //____________________________________________________________________________________________________________

        System.out.println("RegularExpressions: matchOn_RegExList():");
        //____________________________________________________________________________________________________________

        String textToMatch = null;
        boolean expResult = false;
        boolean result = false;


        String[] regexArray = {"Stuff", "  ^blah.*  ", "good.*"};
        boolean add_SearchFromBeginning = true;

        List<Pattern> regexList = RegEx.prepare_RegExArray(regexArray, add_SearchFromBeginning);

        //  Test 1:
        textToMatch = "asdfasdf";
        expResult = false;
        result = RegEx.matchOn_RegExList(textToMatch, regexList);
        assertEquals(expResult, result);

        //  Test 2:
        textToMatch = "Stuff";
        expResult = true;
        result = RegEx.matchOn_RegExList(textToMatch, regexList);
        assertEquals(expResult, result);

        //  Test 3: Should not match, because no '.*' in pattern
        textToMatch = "Stuffasdf";
        expResult = false;
        result = RegEx.matchOn_RegExList(textToMatch, regexList);
        assertEquals(expResult, result);

        //  Test 4: have spaces in text, should not match cause of ^ in pattern
        textToMatch = "  Stuffasdf";
        expResult = false;
        result = RegEx.matchOn_RegExList(textToMatch, regexList);
        assertEquals(expResult, result);

        //  Test 5: try second pattern
        textToMatch = "blahgood";
        expResult = true;
        result = RegEx.matchOn_RegExList(textToMatch, regexList);
        assertEquals(expResult, result);

        //  Test 6: try close match but no match pattern
        textToMatch = "bla";
        expResult = false;
        result = RegEx.matchOn_RegExList(textToMatch, regexList);
        assertEquals(expResult, result);
    }

}