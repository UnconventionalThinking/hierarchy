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

package net.unconventionalthinking.hierarchy;

import net.unconventionalthinking.compiler.tools.CodeBuilder;
import java.util.*;
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
public class HierarchyCompiler_UtilitiesTest {

    public HierarchyCompiler_UtilitiesTest() {
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
     * Test of add_MatrixImports_To_JavaFile method, of class HierarchyMetaCompilerUtilities.
     */
    @Test
    public void testAdd_MatrixImports_To_JavaFile() {
        System.out.println("add_MatrixImports_To_JavaFile");


        // test imports add to file with package

        CodeBuilder srcCode = new CodeBuilder("\npackage net.unconventionalthinking.hierarchy  ;\n" +
                "import blah;\n");
        Set<String> importSet = new HashSet<String>(); // NOTE: ordering never guaranteed!!!
        importSet.add("import asd.bb;");
        importSet.add("import asd.aa;");

        String expResult = "\npackage net.unconventionalthinking.hierarchy  ;\n" +
            "\n" +
            "import asd.aa;\n" +
            "import asd.bb;\n" +
            "\n" +
            "import blah;\n";

        String expResult2 = "\npackage net.unconventionalthinking.hierarchy  ;\n" +
            "\n" +
            "import asd.bb;\n" +
            "import asd.aa;\n" +
            "\n" +
            "import blah;\n";


        CodeBuilder result = HierarchyMetaCompilerUtilities.add_MatrixImports_To_JavaFile(srcCode, importSet);
        String temp = result.toString();
        assertTrue( expResult.equals(temp) || expResult2.equals(temp) );




        // test imports add to file with no package

        srcCode = new CodeBuilder("\n import blah;\n");
        importSet = new HashSet<String>();   // NOTE: ordering never guaranteed!!!
        importSet.add("import asd.aa;");
        importSet.add("import asd.bb;");

        expResult =
            "import asd.aa;\n" +
            "import asd.bb;\n" +
            "\n import blah;\n";
        expResult2 =
            "import asd.bb;\n" +
            "import asd.aa;\n" +
            "\n import blah;\n";


        result = HierarchyMetaCompilerUtilities.add_MatrixImports_To_JavaFile(srcCode, importSet);
        temp = result.toString();
        assertTrue( expResult.equals(temp) || expResult2.equals(temp) );


    }

}