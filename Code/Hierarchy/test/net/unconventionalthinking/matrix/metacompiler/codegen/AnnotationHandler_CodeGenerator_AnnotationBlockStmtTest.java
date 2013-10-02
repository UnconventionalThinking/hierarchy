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

package net.unconventionalthinking.matrix.metacompiler.codegen;

import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.hierarchy.HierarchySettings;
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
public class AnnotationHandler_CodeGenerator_AnnotationBlockStmtTest {

    private static SymbolControl symbolControl;
    private static HierarchySettings hierarchySettings;


    
    public AnnotationHandler_CodeGenerator_AnnotationBlockStmtTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        symbolControl = new SymbolControl();
        symbolControl.intialize_All_MPSymbols();

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
     * Test of generate_AnnoteBlockStmt method, of class AnnotationHandler_CodeGenerator_AnnotationBlockStmt.
     */
    @Test
    public void testGenerate_AnnoteBlockStmt() throws Exception {
        System.out.println("generate_AnnoteBlockStmt");


        AnnotationHandler_CodeGenerator_AnnotationBlockStmt parent = new AnnotationHandler_CodeGenerator_AnnotationBlockStmt(null, null, null, 
                hierarchySettings, 1);
        AnnotationHandler_CodeGenerator_AnnotationBlockStmt child1 = new AnnotationHandler_CodeGenerator_AnnotationBlockStmt(null, null, null,
                hierarchySettings, 2);
        AnnotationHandler_CodeGenerator_AnnotationBlockStmt child2 = new AnnotationHandler_CodeGenerator_AnnotationBlockStmt(null, null, null,
                hierarchySettings, 2);

        parent.set_AnnotateHandlerReference(symbolControl.singleSymbol_Factory.createNew("*1", true));

        List<String> ref_1_1_parts = new ArrayList<String>();
        ref_1_1_parts.add("*1");
        ref_1_1_parts.add("1");
        child1.set_AnnotateHandlerReference(symbolControl.multiPartSymbol_Factory.createNew(ref_1_1_parts, 1, true));

        List<String> ref_1_2_parts = new ArrayList<String>();
        ref_1_2_parts.add("*1");
        ref_1_2_parts.add("2");
        child2.set_AnnotateHandlerReference(symbolControl.multiPartSymbol_Factory.createNew(ref_1_2_parts, 1, true));

        parent.add_Child_AnnotationBlockStmt(new CodeBuilder("int somevar = 1;"));


        child1.add_Child_AnnotationBlockStmt("return null;");

        child2.add_Child_AnnotationBlockStmt("return stuff;");

        parent.add_Child_AnnotationBlockStmt(child1);
        parent.add_Child_AnnotationBlockStmt(child2);

        child1.set_IsFirst_AnnotationBlockStmtCodeGen_Sibling(true);
        child1.set_NextSiblingInfo(child2);
        child2.set_IsLast_AnnotationBlockStmtCodeGen_Sibling(true);

        
        CodeBuilder expResult = null;
        CodeBuilder result = parent.generate_AnnoteBlockStmt();

//        assertEquals(expResult, result);
        System.out.println("Annotation\n" + result.toString());
    }

}