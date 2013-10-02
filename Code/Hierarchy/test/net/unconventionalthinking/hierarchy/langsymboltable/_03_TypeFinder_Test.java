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

import net.unconventionalthinking.hierarchy.HierarchyMetaCompiler;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol_Import_Type;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol_Import_Package;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbolTable_File;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbolTable_App;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
public class _03_TypeFinder_Test {


    static HierarchyMetaCompiler hierarchyCompiler;


    
    public _03_TypeFinder_Test() {
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



    /**
     * **** This test uses the code, Java_TypeInfoTestSample.java, is it's current source code ******
     */
    @Test
    public void testClassFinder() throws Exception {

        LangSymbolTable_File symbolTable = new LangSymbolTable_File(hierarchyCompiler.get_HierarchySettings());

        // fill it up with imports:
        LangSymbol_Import_Type.createSymbol__ImportType("maintests.samples.typeinfotest.otherpackage.TestClassInOtherPackage",
                0, null, symbolTable);
        LangSymbol_Import_Package.createSymbol__ImportPackage("maintests.samples.typeinfotest.anotherpackage.*", 0, null, symbolTable);




        LangSymbolTable_App typeInfoIndex = hierarchyCompiler.getSymbolTable_App();
        TypeFinder__inSrcCodeFile_Scope typeFinder = new TypeFinder__inSrcCodeFile_Scope(symbolTable, typeInfoIndex);






        //  Match full type name - maintests.samples.typeinfotest.Mjava_TypeInfoTestSample
        List<String> searchType_Parts = new ArrayList<String>(TestClassesConstants.TypeInfoTest_Package_Parts); //  copy
        searchType_Parts.add(TestClassesConstants.MjavaTypeInfoTestSample_SimpleClassName);

        String found_FullTypeName = typeFinder.find_FullTypeName(searchType_Parts, TestClassesConstants.JavaTypeInfoTestSample_SimpleClassName, TestClassesConstants.TypeInfoTest_Package);
        assertEquals(TestClassesConstants.MjavaTypeInfoTestSample_FullClassName, found_FullTypeName);
        assertEquals(TypeFinder__inSrcCodeFile_Scope.TypeFindLocation.SearchTypeIsFullTypeName, typeFinder.getTypeFindLocation());

        //  Match curr class
        searchType_Parts = Arrays.asList(TestClassesConstants.JavaTypeInfoTestSample_SimpleClassName);
        found_FullTypeName = typeFinder.find_FullTypeName(searchType_Parts, TestClassesConstants.JavaTypeInfoTestSample_SimpleClassName, TestClassesConstants.TypeInfoTest_Package);
        assertEquals(TestClassesConstants.JavaTypeInfoTestSample_FullClassName, found_FullTypeName);
        assertEquals(TypeFinder__inSrcCodeFile_Scope.TypeFindLocation.CurrType, typeFinder.getTypeFindLocation());


        //  Match Inheritance 
        searchType_Parts = Arrays.asList(TestClassesConstants.TestClassInThirdPackage_SimpleName);
        found_FullTypeName = typeFinder.find_FullTypeName(searchType_Parts, TestClassesConstants.JavaTypeInfoTestSample_SimpleClassName, TestClassesConstants.TypeInfoTest_Package);
        assertEquals(TestClassesConstants.TestClassInThirdPackage_FullName, found_FullTypeName);
        assertEquals(TypeFinder__inSrcCodeFile_Scope.TypeFindLocation.InheritedTypes, typeFinder.getTypeFindLocation());

        searchType_Parts = Arrays.asList(TestClassesConstants.TestClass2_InThirdPackage_SimpleName);
        found_FullTypeName = typeFinder.find_FullTypeName(searchType_Parts, TestClassesConstants.JavaTypeInfoTestSample_SimpleClassName, TestClassesConstants.TypeInfoTest_Package);
        assertEquals(TestClassesConstants.TestClass2_InThirdPackage_FullName, found_FullTypeName);
        assertEquals(TypeFinder__inSrcCodeFile_Scope.TypeFindLocation.InheritedTypes, typeFinder.getTypeFindLocation());



        //  Match Nested types
        searchType_Parts = TestClassesConstants.innerClassName_Parts;
        found_FullTypeName = typeFinder.find_FullTypeName(searchType_Parts, TestClassesConstants.JavaTypeInfoTestSample_SimpleClassName, TestClassesConstants.TypeInfoTest_Package);
        assertEquals(TestClassesConstants.innerClass_FullName, found_FullTypeName);
        assertEquals(TypeFinder__inSrcCodeFile_Scope.TypeFindLocation.NestedType, typeFinder.getTypeFindLocation());


        //  Match Explicit Import Types
        searchType_Parts = Arrays.asList(TestClassesConstants.TestClassInOtherPackage_SimpleName);
        found_FullTypeName = typeFinder.find_FullTypeName(searchType_Parts, TestClassesConstants.JavaTypeInfoTestSample_SimpleClassName, TestClassesConstants.TypeInfoTest_Package);
        assertEquals(TestClassesConstants.TestClassInOtherPackage_FullName, found_FullTypeName);
        assertEquals(TypeFinder__inSrcCodeFile_Scope.TypeFindLocation.ExplicitImport, typeFinder.getTypeFindLocation());


        //  Match type in same Package
        searchType_Parts = Arrays.asList(TestClassesConstants.MjavaTypeInfoTestSample_SimpleClassName);
        found_FullTypeName = typeFinder.find_FullTypeName(searchType_Parts, TestClassesConstants.JavaTypeInfoTestSample_SimpleClassName, TestClassesConstants.TypeInfoTest_Package);
        assertEquals(TestClassesConstants.MjavaTypeInfoTestSample_FullClassName, found_FullTypeName);
        assertEquals(TypeFinder__inSrcCodeFile_Scope.TypeFindLocation.TypeInSamePackage, typeFinder.getTypeFindLocation());


        //  Match Implicit Import
        searchType_Parts = Arrays.asList(TestClassesConstants.TestClassInAnotherPackage_SimpleName);
        found_FullTypeName = typeFinder.find_FullTypeName(searchType_Parts, TestClassesConstants.JavaTypeInfoTestSample_SimpleClassName, TestClassesConstants.TypeInfoTest_Package);
        assertEquals(TestClassesConstants.TestClassInAnotherPackage_FullName, found_FullTypeName);
        assertEquals(TypeFinder__inSrcCodeFile_Scope.TypeFindLocation.ImplicitImport, typeFinder.getTypeFindLocation());

    }


}