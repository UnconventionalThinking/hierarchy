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

package net.unconventionalthinking.hierarchy.compilertools;


import org.junit.Test;
import static org.junit.Assert.*;

import net.unconventionalthinking.hierarchy.grammar.node.TIdentifier;

/**
 *
 * @author peterjoh
 */
public class Token_Test {

    public Token_Test() {
    }

    /**
     * Test of token_code method, of class Token_Utilities.
     */
    @Test
    public void testToken_code() {
        //____________________________________________________________________________________________________________

        System.out.println("Token: code(): This tests the code() method that is inserted into the sablecc Token class\n" +
                            "**NOTE: This version of test goes through an actual sableCC generated class, TIdentifier,\n " +
                            "testing the Token_Utilities.token_code() method ");
        //____________________________________________________________________________________________________________

        TIdentifier packageId = new TIdentifier("package");

        String result = packageId.code().toString();
        String expResult = "package";
        assertEquals(expResult, result);


        //  Empty token test
        TIdentifier empty = new TIdentifier(null);
        result = empty.code().toString();
        expResult = "";
        assertEquals(expResult, result);


    }

}