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

package net.unconventionalthinking.matrix;

import net.unconventionalthinking.lang.ExecutionInfo;
import java.util.*;

import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.matrix.Descriptor.DescriptorIndex_Type;
import net.unconventionalthinking.matrix.FieldSet.Type;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Label;
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
public class _05_MatrixAndDescriptorTest {

    private static TestUtilities_3_TestTheMatrix testUtilities_3;


    public _05_MatrixAndDescriptorTest() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
        testUtilities_3 = new TestUtilities_3_TestTheMatrix();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {    }

    @Before
    public void setUp() throws Exception {    }

    @After
    public void tearDown() {    }




    /**
     * Test of add_ChildDescriptor method, of class Descriptor.
     */
    @Test
    public void testMatrixCreation() throws Exception {

        testUtilities_3.createAndTestMatrix(false);

    }
}
