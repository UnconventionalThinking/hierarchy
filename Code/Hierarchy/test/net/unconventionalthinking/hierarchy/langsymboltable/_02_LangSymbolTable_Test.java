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

import net.unconventionalthinking.matrix.Descriptor;
import net.unconventionalthinking.hierarchy.HierarchyMetaCompiler;
import net.unconventionalthinking.utilities.StringUtilities;
import java.util.Collection;
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
public class _02_LangSymbolTable_Test {


    static HierarchyMetaCompiler hierarchyCompiler;


    
    public _02_LangSymbolTable_Test() {
    }


    @BeforeClass
    public static void setUpClass() throws Exception {

        hierarchyCompiler = TestMatrixProject_1_Setup.setup_HierarchyCompilerForTests();

        hierarchyCompiler.phase1_MetacompileSchemaCode();
        hierarchyCompiler.phase2_GenerateFieldSets();
        hierarchyCompiler.phase3_MetacompileMatrices();
        hierarchyCompiler.phase4_CollectTypeInfo();

    }

    @AfterClass
    public static void tearDownClass() throws Exception {}
    @Before
    public void setUp() {} 
    @After
    public void tearDown() {}

    static TypeInfo mjavaFile_TypeInfo;
    static TypeInfo javaFile_TypeInfo;
    static TypeInfo innerClass_TypeInfo;

    static TypeInfo nonPublicClass2_TypeInfo;
    static TypeInfo testClassInOtherPackage_TypeInfo;

    static LangSymbol_Method innerClassMethod_Symbol;
    /*
     *
     * scope id's of Java_TypeInfoTestSample:
     *
     * scope id     scope name
     *     parent
     *     scope id
     * _________________________
     *  0   -       global
     *  1   0       class Java_TypeInfoTestSample (outer most class)
     *  2   1       class innerClass (inner class)
     *  3   3       class secondInnerClass_SimpleName (inner class of innerClass)
     *  4   3       method innerClassMethod (method of secondInnerClass_SimpleName)
     *  5   1       innerEnum
     *
     *  6   0       nonPublicClass2
     *  7   0       nonPublicClass3
     *
     */

    @Test
    public void testSymbolTable_Types() throws Exception {

        LangSymbolTable_App symbolTable_App = hierarchyCompiler.getSymbolTable_App();


        mjavaFile_TypeInfo =
                symbolTable_App.getTypeInfo_byFullTypeName("maintests.samples.typeinfotest.Mjava_TypeInfoTestSample");

        assertEquals(false, mjavaFile_TypeInfo.is_NestedType());

        assertEquals("Mjava_TypeInfoTestSample", mjavaFile_TypeInfo.get_Name_Simple());
        assertEquals("maintests.samples.typeinfotest.Mjava_TypeInfoTestSample", mjavaFile_TypeInfo.get_FullTypeName());
        assertEquals(0, ((LangSymbol_Type)mjavaFile_TypeInfo).scopeID); // should be '0', global scope


        javaFile_TypeInfo =
                symbolTable_App.getTypeInfo_byFullTypeName("maintests.samples.typeinfotest.Java_TypeInfoTestSample");

        assertEquals(false, javaFile_TypeInfo.is_NestedType());

        assertEquals("Java_TypeInfoTestSample", javaFile_TypeInfo.get_Name_Simple());
        assertEquals("maintests.samples.typeinfotest.Java_TypeInfoTestSample", javaFile_TypeInfo.get_FullTypeName());
        assertEquals(0, ((LangSymbol_Type)javaFile_TypeInfo).scopeID); // should be '0', global scope

        javaFile_TypeInfo =
                symbolTable_App.getTypeInfo_byFullTypeName("maintests.samples.typeinfotest.Java_TypeInfoTestSample");

        assertEquals(false, javaFile_TypeInfo.is_NestedType());

        assertEquals("Java_TypeInfoTestSample", javaFile_TypeInfo.get_Name_Simple());
        assertEquals("maintests.samples.typeinfotest.Java_TypeInfoTestSample", javaFile_TypeInfo.get_FullTypeName());
        assertEquals(0, ((LangSymbol_Type)javaFile_TypeInfo).scopeID); // should be '0', global scope



        innerClass_TypeInfo = symbolTable_App.getTypeInfo_byFullTypeName("maintests.samples.typeinfotest.Java_TypeInfoTestSample.innerClass");
        assertEquals(javaFile_TypeInfo, innerClass_TypeInfo.get_ParentTypeInfo());


        TypeInfo secondInnerClass_TypeInfo = symbolTable_App.getTypeInfo_byFullTypeName("maintests.samples.typeinfotest.Java_TypeInfoTestSample.innerClass.secondInnerClass");

        assertEquals("secondInnerClass", secondInnerClass_TypeInfo.get_Name_Simple());
        assertEquals("Java_TypeInfoTestSample.innerClass.secondInnerClass", secondInnerClass_TypeInfo.get_Name_withNestedNames());
        assertEquals("maintests.samples.typeinfotest.Java_TypeInfoTestSample.innerClass.secondInnerClass", secondInnerClass_TypeInfo.get_FullTypeName());
        assertEquals("maintests.samples.typeinfotest", secondInnerClass_TypeInfo.get_PackageName());


        assertEquals(true, secondInnerClass_TypeInfo.is_NestedType());
        assertEquals(3, secondInnerClass_TypeInfo.get_TypeNestingLevel());
        assertEquals(2, ((LangSymbol_Type)secondInnerClass_TypeInfo).scopeID); // should be '2', inside 'innerClass' scope
        assertEquals(innerClass_TypeInfo, secondInnerClass_TypeInfo.get_ParentTypeInfo());


        assertEquals("Java_TypeInfoTestSample", secondInnerClass_TypeInfo.get_Name_withNestedNames_Parts().get(0));
        assertEquals("innerClass", secondInnerClass_TypeInfo.get_Name_withNestedNames_Parts().get(1));
        assertEquals("secondInnerClass", secondInnerClass_TypeInfo.get_Name_withNestedNames_Parts().get(2));

/*
        // COMMENTED OUT INHERITENCE TEST
        // check inheritance
        assertEquals("Java_TypeInfoTestSample", mjavaFile_TypeInfo.get_Inheritance_TypeUsageInfo().getActualUsage());
        assertEquals(TestClassesConstants.JavaTypeInfoTestSample_FullClassName, mjavaFile_TypeInfo.get_Inheritance_TypeUsageInfo().getFullTypeName());
*/
        /*
        //  comment out the extra, non-public classes, causing problems because the meta compiler doesn't support these yet
        nonPublicClass2_TypeInfo =
                symbolTable_App.getTypeInfo_byFullTypeName("maintests.samples.typeinfotest.nonPublicClass2");
        assertEquals("maintests.samples.typeinfotest.Java_TypeInfoTestSample.innerClass",
                nonPublicClass2_TypeInfo.get_Inheritance_TypeUsageInfo().getActualUsage());
*/


        //  check other packages

        testClassInOtherPackage_TypeInfo =
                symbolTable_App.getTypeInfo_byFullTypeName("maintests.samples.typeinfotest.otherpackage.TestClassInOtherPackage");

        assertEquals("TestClassInOtherPackage", testClassInOtherPackage_TypeInfo.get_Name_Simple());
        assertEquals("TestClassInOtherPackage", testClassInOtherPackage_TypeInfo.get_Name_withNestedNames());
        assertEquals("maintests.samples.typeinfotest.otherpackage.TestClassInOtherPackage", testClassInOtherPackage_TypeInfo.get_FullTypeName());
    }



    @Test
    public void testSymbolTableMethods() throws Exception {

        LangSymbolTable_App symbolTable_App = hierarchyCompiler.getSymbolTable_App();

        LangSymbolTable_File symbolTable_File = symbolTable_App.get_SymbolTableFile_forType__byFullTypeName(
                TestClassesConstants.JavaTypeInfoTestSample_FullClassName);


/*
        // get to second inner class scope
        symbolTable_File.scopeStack.pushNewScope(false);  // 0 global
        symbolTable_File.scopeStack.pushNewScope(true);   // 1 class Java_TypeInfoTestSample
        symbolTable_File.scopeStack.pushNewScope(false);  // 2 class innerClass
        symbolTable_File.scopeStack.pushNewScope(false);  // 3 class second innerClass

*/
        //  check methods
        Collection symbolMethods_List = symbolTable_App.getTypeInfo_byFullTypeName(TestClassesConstants.innerClass_FullName)
                .getMethods(TestClassesConstants.innerClassMethod);
        innerClassMethod_Symbol = (LangSymbol_Method)symbolMethods_List.toArray()[0];

        assertEquals(TestClassesConstants.innerClassMethod, innerClassMethod_Symbol.name);
        assertEquals(innerClass_TypeInfo, innerClassMethod_Symbol.getParentType());

        assertEquals(TestClassesConstants.TestClassInThirdPackage_FullName, innerClassMethod_Symbol.returnType_TypeUsageInfo.getFullTypeName());

    }

    @Test
    public void testSymbolTableVariables() throws Exception {

        LangSymbolTable_App symbolTable_App = hierarchyCompiler.getSymbolTable_App();

        LangSymbolTable_File symbolTable_File = symbolTable_App.get_SymbolTableFile_forType__byFullTypeName(
                TestClassesConstants.JavaTypeInfoTestSample_FullClassName);


        LangSymbol_Variable f_Var = symbolTable_App.getTypeInfo_byFullTypeName(TestClassesConstants.JavaTypeInfoTestSample_FullClassName)
                .getField("f");

        assertEquals(LangSymbol.PrimitiveType.Int, f_Var.getPrimitiveType());
        assertEquals(LangSymbol.SymbolType.Variable_Class, f_Var.symbolType);
        assertEquals(javaFile_TypeInfo, f_Var.getParentSymbol());


        LangSymbol_Variable f0_Var = symbolTable_App.getTypeInfo_byFullTypeName(TestClassesConstants.JavaTypeInfoTestSample_FullClassName)
                .getField("f0");

        assertEquals(TestClassesConstants.innerClassName_Simple, f0_Var.getActualUsage());
        assertEquals(TestClassesConstants.innerClass_FullName, f0_Var.getFullTypeName());
        assertEquals(javaFile_TypeInfo, f0_Var.getParentSymbol());


        LangSymbol_Variable f1_Var = symbolTable_App.getTypeInfo_byFullTypeName(TestClassesConstants.JavaTypeInfoTestSample_FullClassName)
                .getField("f1");

        assertEquals(TestClassesConstants.innerClassName_Simple + "." + TestClassesConstants.secondInnerClass_SimpleName, f1_Var.getActualUsage());
        assertEquals(TestClassesConstants.secondInnerClass_FullTypeName, f1_Var.getFullTypeName());
        assertEquals(javaFile_TypeInfo, f1_Var.getParentSymbol());


        LangSymbol_Variable f2_Var = symbolTable_App.getTypeInfo_byFullTypeName(TestClassesConstants.JavaTypeInfoTestSample_FullClassName)
                .getField("f2");

        assertEquals(TestClassesConstants.secondInnerClass_withNestedNames, f2_Var.getActualUsage());
        assertEquals(TestClassesConstants.secondInnerClass_FullTypeName, f2_Var.getFullTypeName());
        assertEquals(LangSymbol.SymbolType.Variable_Class, f2_Var.symbolType);
        assertEquals(javaFile_TypeInfo, f2_Var.getParentSymbol());



        // **** Descriptor Var tests
        // __________________________________________________________________________________________________________________________________

        //  This one is in the OTHER file, MJavaTypeInfoTestSample_FullClassName
        LangSymbol_Variable descVar_Var = symbolTable_App.getTypeInfo_byFullTypeName(TestClassesConstants.MjavaTypeInfoTestSample_FullClassName)
                .getField("descVar");

        assertEquals(Descriptor.class.getCanonicalName(), descVar_Var.getFullTypeName());
        assertEquals(true, descVar_Var.isDescriptorVar());
        assertEquals(LangSymbol.SymbolType.Variable_Class, descVar_Var.symbolType);
//        assertEquals(mjavaFile_TypeInfo, descVar_Var.getParentSymbol());

        LangSymbol_Variable_DescriptorVar descVar_DescVar = (LangSymbol_Variable_DescriptorVar)descVar_Var; // this cast should be valid.

        MatrixAccessState matrixAccessState = descVar_DescVar.getMatrixAccessState();
        assertNotNull(matrixAccessState.lastAccessSettings);

        assertEquals("FORM.REQUIRED",
                matrixAccessState.lastAccessSettings.parent_DescriptorFlattened.cast_as_Descriptor().descTagName.getTagName());


        // __________________________________________________________________________________________________________________________________


        Collection methods_List = symbolTable_App.getTypeInfo_byFullTypeName(TestClassesConstants.innerClass_FullName)
                .getMethods("innerClassMethod");
        LangSymbol_Method innerClassMethod_Sym = (LangSymbol_Method)methods_List.toArray()[0];

        LangSymbol_Variable innerClassMethod_param__p1 = innerClassMethod_Sym.getVariable_MethodParam("p1");
        assertEquals(LangSymbol.PrimitiveType.Int, innerClassMethod_param__p1.getPrimitiveType());
        assertEquals(LangSymbol.SymbolType.Variable_MethodParameter, innerClassMethod_param__p1.symbolType);
        assertEquals(innerClassMethod_Symbol, innerClassMethod_param__p1.getParentSymbol());

        LangSymbol_Variable innerClassMethod_param__p2 = innerClassMethod_Sym.getVariable_MethodParam("p2");
        assertEquals(TestClassesConstants.TestClassInOtherPackage_SimpleName, innerClassMethod_param__p2.getActualUsage());
        assertEquals(TestClassesConstants.TestClassInOtherPackage_FullName, innerClassMethod_param__p2.getFullTypeName());
        assertEquals(LangSymbol.SymbolType.Variable_MethodParameter, innerClassMethod_param__p2.symbolType);
        assertEquals(innerClassMethod_Symbol, innerClassMethod_param__p2.getParentSymbol());


        LangSymbol_Variable innerClassMethod_Var__var1 = innerClassMethod_Sym.getField("var1");

        assertEquals(TestClassesConstants.JavaTypeInfoTestSample_SimpleClassName, innerClassMethod_Var__var1.getActualUsage());
        assertEquals(TestClassesConstants.JavaTypeInfoTestSample_FullClassName, innerClassMethod_Var__var1.getFullTypeName());
        assertEquals(LangSymbol.SymbolType.Variable_Local, innerClassMethod_Var__var1.symbolType);
        assertEquals(innerClassMethod_Symbol, innerClassMethod_Var__var1.getParentSymbol());



        //  Test constructor
        methods_List = symbolTable_App.getTypeInfo_byFullTypeName(TestClassesConstants.JavaTypeInfoTestSample_FullClassName)
                .getMethods("Java_TypeInfoTestSample");
        LangSymbol_Method Java_TypeInfoTestSample_Sym = (LangSymbol_Method)methods_List.toArray()[0];

        LangSymbol_Variable Java_TypeInfoTestSample_param__p3 = Java_TypeInfoTestSample_Sym.getVariable_MethodParam("p3");
        assertEquals(TestClassesConstants.TestClassInOtherPackage_SimpleName, Java_TypeInfoTestSample_param__p3.getActualUsage());
        assertEquals(TestClassesConstants.TestClassInOtherPackage_FullName, Java_TypeInfoTestSample_param__p3.getFullTypeName());
        assertEquals(LangSymbol.SymbolType.Variable_MethodParameter, Java_TypeInfoTestSample_param__p3.symbolType);
        assertEquals(Java_TypeInfoTestSample_Sym, Java_TypeInfoTestSample_param__p3.getParentSymbol());


        LangSymbol_Variable Java_TypeInfoTestSample_Var__var1 = Java_TypeInfoTestSample_Sym.getField("var1");

        assertEquals(TestClassesConstants.JavaTypeInfoTestSample_SimpleClassName, Java_TypeInfoTestSample_Var__var1.getActualUsage());
        assertEquals(TestClassesConstants.JavaTypeInfoTestSample_FullClassName, Java_TypeInfoTestSample_Var__var1.getFullTypeName());
        assertEquals(LangSymbol.SymbolType.Variable_Local, Java_TypeInfoTestSample_Var__var1.symbolType);
        assertEquals(Java_TypeInfoTestSample_Sym, Java_TypeInfoTestSample_Var__var1.getParentSymbol());


    }


}