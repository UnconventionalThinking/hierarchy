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

import net.unconventionalthinking.compiler.tools.CodeBuilder;
import java.util.ArrayList;
import java.util.List;
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
public class Set_CodeGeneratorTest {

    public Set_CodeGeneratorTest() {
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
     * Test of generate_SetCode method, of class Set_CodeGenerator.
     */
    @Test
    public void testGenerate_SetCode() {
        System.out.println("generate_SetCode");
        CodeBuilder codeBuilder = null;
        CodeGen_OutputResults outputResults = new CodeGen_OutputResults();

        List<String> itemExpressions =  new ArrayList<String>();
        itemExpressions.add("+:sym1");
        itemExpressions.add("(i + 1)");
        itemExpressions.add("methodcall()");

        String expResult = "new MatrixSet().add(+:sym1, (i + 1), methodcall())";

        CodeBuilder result = Set_CodeGenerator.generate_SetCode(codeBuilder, outputResults, false, null, itemExpressions);
        String resultString = result.toString();
        assertEquals(expResult, resultString);


        

        codeBuilder = null;
        outputResults = new CodeGen_OutputResults();


        expResult = "new MatrixSet<String>().add(+:sym1, (i + 1), methodcall())";

        result = Set_CodeGenerator.generate_SetCode(codeBuilder, outputResults, true, "String", itemExpressions);
        resultString = result.toString();
        assertEquals(expResult, resultString);

    }

}