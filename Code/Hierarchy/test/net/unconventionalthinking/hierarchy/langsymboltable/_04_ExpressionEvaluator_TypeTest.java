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

package net.unconventionalthinking.hierarchy.langsymboltable;

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
public class _04_ExpressionEvaluator_TypeTest {

    static HierarchyMetaCompiler hierarchyCompiler;
    static LangSymbolTable_App symbolTable_App;
    static LangSymbolTable_File symbolTable_File;

    public _04_ExpressionEvaluator_TypeTest() { }

    @BeforeClass
    public static void setUpClass() throws Exception {

        hierarchyCompiler = TestMatrixProject_1_Setup.setup_HierarchyCompilerForTests();

        hierarchyCompiler.clean();

        hierarchyCompiler.phase1_MetacompileSchemaCode();
        hierarchyCompiler.phase2_GenerateFieldSets();
        hierarchyCompiler.phase3_MetacompileMatrices();
        hierarchyCompiler.phase4_CollectTypeInfo();


        symbolTable_App = hierarchyCompiler.getSymbolTable_App();

        symbolTable_File = symbolTable_App.get_SymbolTableFile_forType__byFullTypeName(
                TestClassesConstants.JavaTypeInfoTestSample_FullClassName);

    }


    @AfterClass
    public static void tearDownClass() throws Exception { }
    @Before
    public void setUp() { }
    @After
    public void tearDown() { }



    /**
     * Test of determineType method, of class ExpressionEvaluator_Type.
     */
    @Test
    public void testDetermineType() throws Exception {
        System.out.println("determineType");

        symbolTable_File.scopeStack.reset();

        symbolTable_File.scopeStack.push_Global_Scope(); // global scope, scope id should be '0'
        int scopeOf__JavaTypeInfoTestSample_ClassDefn = symbolTable_File.scopeStack.push_Class_Scope(false); // class Java_TypeInfoTestSample scope, scope id should be '1'




        //  Java_TypeInfoTestSample:
        //  expression: f4.testChildClass
        Expression expression = new Expression();
        expression.addExpressionPart(new ExpressionPart_Identifier("f4"));
        expression.addExpressionPart(new ExpressionPart_Identifier("testChildClass"));

        
        Boolean_Mutable couldNotFindType = new Boolean_Mutable(true);
        ExpressionEvaluator_Type expressionEvaluator = new ExpressionEvaluator_Type(symbolTable_App, symbolTable_File);
        List<ExpressionPart_ExpressionInfo> result = expressionEvaluator.determineType(expression, couldNotFindType);

        
        assertEquals(2, result.size());
        assertEquals(false, couldNotFindType.value);

        ExpressionPart_ExpressionInfo testClassInOtherPackage_ExprInfo = result.get(0);
        assertEquals(TestClassesConstants.TestClassInOtherPackage_FullName, testClassInOtherPackage_ExprInfo.typeName_Full);
        ExpressionPart_ExpressionInfo testChildClass_ExprInfo = result.get(1);
        assertEquals(TestClassesConstants.TestChildClass_InOtherPackage_FullName, testChildClass_ExprInfo.typeName_Full);


        // f - which is an int
        expression = new Expression();
        expression.addExpressionPart(new ExpressionPart_Identifier("f"));


        couldNotFindType = new Boolean_Mutable(true);
        expressionEvaluator = new ExpressionEvaluator_Type(symbolTable_App, symbolTable_File);
        result = expressionEvaluator.determineType(expression, couldNotFindType);


        assertEquals(1, result.size());
        assertEquals(false, couldNotFindType.value);

        ExpressionPart_ExpressionInfo f_ExprInfo = result.get(0);
        assertEquals("int", f_ExprInfo.typeName_Full); // is primitive type



        // test static class access:
        // TestClassInAnotherPackage.myShort

        expression = new Expression();
        expression.addExpressionPart(new ExpressionPart_Identifier("TestClassInAnotherPackage"));
        expression.addExpressionPart(new ExpressionPart_Identifier("myShort"));


        couldNotFindType = new Boolean_Mutable(true);
        expressionEvaluator = new ExpressionEvaluator_Type(symbolTable_App, symbolTable_File);
        result = expressionEvaluator.determineType(expression, couldNotFindType);


        assertEquals(false, couldNotFindType.value);
        assertEquals(2, result.size());

        ExpressionPart_ExpressionInfo testClassInAnotherPackage_ExprInfo = result.get(0);
        assertEquals(TestClassesConstants.TestClassInAnotherPackage_FullName, testClassInAnotherPackage_ExprInfo.typeName_Full);
        ExpressionPart_ExpressionInfo myShort_ExprInfo = result.get(1);
        assertEquals("short", myShort_ExprInfo.typeName_Full); // is primitive type
        




        
        symbolTable_File.scopeStack.push_Class_Scope(true); // class innerClass scope, scope id should be '2'
        symbolTable_File.scopeStack.push_Class_Scope(true); // class secondInnerClass scope, scope id should be '3'
        symbolTable_File.scopeStack.popCurrentScope(); // back to innerClass Scopescope id should be '2'
        symbolTable_File.scopeStack.push_Class_Scope(true); // innerClassMethod() scope, scope id should be '4'


        // Test static access of an inner class
        // Java_TypeInfoTestSample.innerClass.myLong

        expression = new Expression();
        expression.addExpressionPart(new ExpressionPart_Identifier("innerClass"));
        expression.addExpressionPart(new ExpressionPart_Identifier("myLong"));


        couldNotFindType = new Boolean_Mutable(true);
        expressionEvaluator = new ExpressionEvaluator_Type(symbolTable_App, symbolTable_File);
        result = expressionEvaluator.determineType(expression, couldNotFindType);


        assertEquals(false, couldNotFindType.value);
        assertEquals(2, result.size());

        ExpressionPart_ExpressionInfo innerClass_ExprInfo = result.get(0);
        assertEquals(TestClassesConstants.JavaTypeInfoTestSample_FullClassName + ".innerClass", innerClass_ExprInfo.typeName_Full);
        ExpressionPart_ExpressionInfo myLong_ExprInfo = result.get(1);
        assertEquals("long", myLong_ExprInfo.typeName_Full); // is primitive type



        // Same test of Java_TypeInfoTestSample.innerClass.myLong, but with full class name

        expression = new Expression();
        expression.addExpressionPart(new ExpressionPart_Identifier("Java_TypeInfoTestSample"));
        expression.addExpressionPart(new ExpressionPart_Identifier("innerClass"));
        expression.addExpressionPart(new ExpressionPart_Identifier("myLong"));


        couldNotFindType = new Boolean_Mutable(true);
        expressionEvaluator = new ExpressionEvaluator_Type(symbolTable_App, symbolTable_File);
        result = expressionEvaluator.determineType(expression, couldNotFindType);


        assertEquals(false, couldNotFindType.value);
        assertEquals(3, result.size());

        ExpressionPart_ExpressionInfo JavaTypeInfoTestSample_ExprInfo = result.get(0);
        assertEquals(TestClassesConstants.JavaTypeInfoTestSample_FullClassName, JavaTypeInfoTestSample_ExprInfo.typeName_Full);
        innerClass_ExprInfo = result.get(1);
        assertEquals(TestClassesConstants.JavaTypeInfoTestSample_FullClassName + ".innerClass", innerClass_ExprInfo.typeName_Full);
        myLong_ExprInfo = result.get(2);
        assertEquals("long", myLong_ExprInfo.typeName_Full); // is primitive type


    }


    
}