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

package net.unconventionalthinking.hierarchy;

import net.unconventionalthinking.lang.Boolean_Mutable;
import net.unconventionalthinking.hierarchy.HierarchyMetaCompiler;
import net.unconventionalthinking.hierarchy.langexpressions.Expression;
import net.unconventionalthinking.hierarchy.langexpressions.ExpressionEvaluator_Type;
import net.unconventionalthinking.hierarchy.langexpressions.ExpressionPart_ExpressionInfo;
import net.unconventionalthinking.hierarchy.langexpressions.ExpressionPart_Identifier;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbolTable_App;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbolTable_File;
import net.unconventionalthinking.hierarchy.langsymboltable.TestClassesConstants;
import java.util.List;
import maintests.main.MainTests_Constants;
import maintests.main.MainTests_Setup;
import maintests.main.TestMatrixProject_1_Setup;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbolTable_App;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbolTable_File;
import net.unconventionalthinking.hierarchy.langsymboltable.TestClassesConstants;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
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
public class _10_AnnotationDetection_Tester {

    static HierarchyMetaCompiler hierarchyCompiler;
    static LangSymbolTable_App symbolTable_App;
    static LangSymbolTable_File symbolTable_File;

    public _10_AnnotationDetection_Tester() { }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }


    @AfterClass
    public static void tearDownClass() throws Exception { }
    @Before
    public void setUp() { }
    @After
    public void tearDown() { }



    @Test
    public void testBadMethod_w_no_AnnotationHandler() throws Exception {
        
        ExceptRuntime_HierarchyMetaCompilerError except = null;
        try {
            //  this should throw an exception
            _10_AnnotationDetection_Setup.main(null);
        } catch (ExceptRuntime_HierarchyMetaCompilerError e) {
            except = e;
        }

        assertNotNull(except);
        //  Should be able to go three deep, to the root exception
        Throwable innerExcept = except.getCause().getCause().getCause();
        assertTrue(innerExcept instanceof Exception_MetaCompilerError);
    }


    
}