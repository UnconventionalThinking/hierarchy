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

package net.unconventionalthinking.matrix.symbols;

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
public class MatrixName_UtilitiesTest {

    public MatrixName_UtilitiesTest() {}

    @BeforeClass
    public static void setUpClass() throws Exception { }
    @AfterClass
    public static void tearDownClass() throws Exception { }
    @Before
    public void setUp() { }
    @After
    public void tearDown() { }


    /**
     * Test of convert_MatrixNameWithPackage_to_IdentifierFormat method, of class MatrixName_Utilities.
     */
    @Test
    public void testConvert_MatrixNameWithPackage_to_IdentifierFormat() {
        System.out.println("convert_MatrixNameWithPackage_to_IdentifierFormat");


        String matrixName_w_Package = "com.matrix.test::My.Test.Matrix";
        String expResult = "com.matrix.test.My$__$Test$__$Matrix";

        String result = MatrixName_Utilities.convert_MatrixNameWithPackage_to_IdentifierFormat(matrixName_w_Package);
        assertEquals(expResult, result);



        matrixName_w_Package = "com.matrix.test::Matrix";
        expResult = "com.matrix.test.Matrix";

        result = MatrixName_Utilities.convert_MatrixNameWithPackage_to_IdentifierFormat(matrixName_w_Package);
        assertEquals(expResult, result);

    }

}