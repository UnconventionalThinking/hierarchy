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

import net.unconventionalthinking.matrix.symbols.SymbolType;
import net.unconventionalthinking.hierarchy.HierarchySettings;
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
public class CodeUtilitiesTest {


    private static HierarchySettings hierarchySettings;

    
    public CodeUtilitiesTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        hierarchySettings = new HierarchySettings();

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
     * Test of getSymbolType_FromCodeString method, of class CodeUtilities.
     */
    @Test
    public void testGetSymbolType_FromCodeString() {
        System.out.println("getSymbolType_FromCodeString");

        String symExpression = hierarchySettings.appSymbols_ClassName + ".sym1";
        SymbolType expResult = SymbolType.Symbol;
        SymbolType result = CodeUtilities.getSymbolType_FromCodeString(symExpression, hierarchySettings.appSymbols_ClassName);
        assertEquals(expResult, result);

        symExpression = hierarchySettings.appSymbols_ClassName + hierarchySettings.symbolClassSuffix_Label + ".sym2";
        expResult = SymbolType.Label;
        result = CodeUtilities.getSymbolType_FromCodeString(symExpression, hierarchySettings.appSymbols_ClassName);
        assertEquals(expResult, result);

        symExpression = hierarchySettings.appSymbols_ClassName +  hierarchySettings.symbolClassSuffix_DescTagName + ".sym2";
        expResult = SymbolType.DescriptorTagName;
        result = CodeUtilities.getSymbolType_FromCodeString(symExpression, hierarchySettings.appSymbols_ClassName);
        assertEquals(expResult, result);

        symExpression = "MPSymbols" + hierarchySettings.symbolClassSuffix_Label + ".sym1";
        expResult = SymbolType.Label;
        result = CodeUtilities.getSymbolType_FromCodeString(symExpression, hierarchySettings.appSymbols_ClassName);
        assertEquals(expResult, result);

        symExpression = "junk";
        expResult = null;
        result = CodeUtilities.getSymbolType_FromCodeString(symExpression, hierarchySettings.appSymbols_ClassName);
        assertEquals(expResult, result);
    }





    /**
     * Test of checkCode_Is_SymbolAccessOrCreation method, of class RegEx.
     */
    @Test
    public void testCheckCode_Is_SymbolAccessOrCreation() {
        //____________________________________________________________________________________________________________

        System.out.println("RegularExpressions: checkCode_Is_SymbolAccessOrCreation():");
        //____________________________________________________________________________________________________________

        String textToMatch = null;
        boolean expResult = false;
        boolean result = false;


        //  Test 1:
        textToMatch = ":Symbol1";
        expResult = true;
        result = CodeUtilities.checkCode_Is_SymbolAccessOrCreation(textToMatch);
        assertEquals(expResult, result);

        //  Test 1:
        textToMatch = "  :  FORM . REQUIRED  ";
        expResult = true;
        result = CodeUtilities.checkCode_Is_SymbolAccessOrCreation(textToMatch);
        assertEquals(expResult, result);

        //  Test 1:
        textToMatch = " +:Symbol1 . sisdf234_$$sdf ";
        expResult = true;
        result = CodeUtilities.checkCode_Is_SymbolAccessOrCreation(textToMatch);
        assertEquals(expResult, result);

        textToMatch = " +  :sdfsd ";
        expResult = true;
        result = CodeUtilities.checkCode_Is_SymbolAccessOrCreation(textToMatch);
        assertEquals(expResult, result);

        textToMatch = " fsd ";
        expResult = false;
        result = CodeUtilities.checkCode_Is_SymbolAccessOrCreation(textToMatch);
        assertEquals(expResult, result);


        textToMatch = " fsd +:symbol";
        expResult = false;
        result = CodeUtilities.checkCode_Is_SymbolAccessOrCreation(textToMatch);
        assertEquals(expResult, result);

        textToMatch = ":symbol stuff";
        expResult = false;
        result = CodeUtilities.checkCode_Is_SymbolAccessOrCreation(textToMatch);
        assertEquals(expResult, result);

    }
}