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


import org.junit.Test;
import static org.junit.Assert.*;

import net.unconventionalthinking.compiler.tools.Token_Utilities;

/**
 *
 * @author peterjoh
 */
public class Token_UtilitiesTest {

    public Token_UtilitiesTest() {
    }

    /**
     * Test of token_code method, of class Token_Utilities.
     */
    @Test
    public void testToken_code() {
        //____________________________________________________________________________________________________________

        System.out.println("TokenUtilities: token_code(): This tests the utility method that is called the sablecc Token class's code() method ");
        //____________________________________________________________________________________________________________


        CodeBuilder codeBuilder = null;
        String text = "abstract";
        String result = Token_Utilities.token_code(text, codeBuilder).toString();
        String expResult = "abstract";
        assertEquals(expResult, result);


        //  In this test, the codebuilder should be dominant over the text passed in. so if codebuilder exists, return it, not the text.
        codeBuilder = new CodeBuilder("dominant");
        text = "secondary";
        result = Token_Utilities.token_code(text, codeBuilder).toString();
        expResult = "dominant";
        assertEquals(expResult, result);

    }

}