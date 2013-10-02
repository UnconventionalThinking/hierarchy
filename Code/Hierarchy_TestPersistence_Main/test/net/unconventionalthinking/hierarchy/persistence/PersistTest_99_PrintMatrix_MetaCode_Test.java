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

package net.unconventionalthinking.hierarchy.persistence;

import net.unconventionalthinking.matrix.*;
import net.unconventionalthinking.lang.ExecutionInfo;
import java.util.*;

import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.matrix.Descriptor.DescriptorIndex_Type;
import net.unconventionalthinking.matrix.FieldSet.Type;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Label;
import java.io.File;
import maintests.main.PersistMain_MainTests_Constants;
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
public class PersistTest_99_PrintMatrix_MetaCode_Test {

    private static TestUtilities_3_TestTheMatrix testUtilities_3;


    public PersistTest_99_PrintMatrix_MetaCode_Test() {}

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




    @Test
    public void testPrintMatrixMetaCode() throws Exception {

        List<String> schemas = Arrays.asList(new String[] { "WEB.FORM" });

        StringBuilder matrixcode = new StringBuilder();
        Matrix testMatrix = testUtilities_3.createTestMatrix();
        testMatrix.print_MetaCode(matrixcode, 0, schemas);

        System.out.println(matrixcode.toString());

        PersistentMatrixCodeGenerator matrixCodeGen = new PersistentMatrixCodeGenerator(
                PersistMain_MainTests_Constants.maintests_maintestsSamples_DirPath, "Test_Matrix.matrix");

        String replacedMatrixCode = matrixCodeGen.generateCodeFromMatrix(testMatrix);


        matrixCodeGen.writeToFile(PersistMain_MainTests_Constants.CURR_PROJECT_DIR + File.separator + "temp", true, true);
    }
}
