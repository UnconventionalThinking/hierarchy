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

import net.unconventionalthinking.hierarchy.AppControl_Info;
import net.unconventionalthinking.hierarchy.Class_FileInfo;
import net.unconventionalthinking.hierarchy.SchemaSet_ScopeStack;
import net.unconventionalthinking.matrix.*;
import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.matrix.SchemaInfo_Schema;
import net.unconventionalthinking.matrix.MatrixSet;
import net.unconventionalthinking.matrix.symbols.Symbol;

import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.lang.Pair;
import net.unconventionalthinking.matrix.SchemaControl;
import net.unconventionalthinking.matrix.metacompiler.codefilegen.AnnotationsInterface_FileGenerator;
import net.unconventionalthinking.matrix.metacompiler.codefilegen.EmbeddedFile_Worker_FileGenerator;
import net.unconventionalthinking.matrix.metacompiler.codefilegen.MatrixAndSchema_FileGenerator;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.MPSymbols_DescTagName;
import net.unconventionalthinking.matrix.symbols.MatrixName;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.hierarchy.AppControl_Info;
import net.unconventionalthinking.hierarchy.Class_FileInfo;
import net.unconventionalthinking.hierarchy.HierarchyControl;

import net.unconventionalthinking.hierarchy.HierarchyMetaCompilerUtilities_Compiler;
import net.unconventionalthinking.hierarchy.HierarchyMetaCompilerUtilities_MetaCompiler;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import net.unconventionalthinking.hierarchy.SchemaSet_ScopeStack;
import net.unconventionalthinking.hierarchy.compileractions.HierarchyActions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
public class _2_Descriptor_CodeGenerator_MatrixTest {

    private static AppControl_Base appControl;

    private static ExecutionInfo executeInfo;
    private static SymbolControl symbolControl;
    private static SchemaControl schemaControl;
    private static MatrixControl matrixControl;
    private static HierarchyControl hierarchyControl;
    private static HierarchySettings hierarchySettings;
    private static HierarchyActions mock_HierarchyActions;

    private static HierarchyMetaCompilerUtilities_Compiler compilerUtilities;
    private static HierarchyMetaCompilerUtilities_MetaCompiler metaCompilerUtilities;

    

    private static SchemaInfo_Schema webForm_GeneratedSchema;


    private static CodeGen_OutputResults outputResults;

    private static int baseIndentLevel = 2;

    private final static String matrixPackage = "net.unconventionalthinking.matrix";
    private static DescriptorTagName matrixPackage_Symbol;
    private static MatrixName webForm_SchemaName;


    private static String embeddedFile_ClassNameBase = "TestCode";
    private static EmbeddedFile_Worker_FileGenerator TestCode__MatrixWorkerFileGen;

    private static String annotations_InterfaceName = "TestCode";
    private static AnnotationsInterface_FileGenerator annotationsInterface_FileGen;
    private static AnnotationsCodeGenerator_Control annotationsCodeGenerator_Control = new AnnotationsCodeGenerator_Control();




    public _2_Descriptor_CodeGenerator_MatrixTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        appControl = AppControl.initializeApp();

        symbolControl = appControl.symbolControl;

        schemaControl = appControl.schemaControl;
        matrixControl = appControl.matrixControl;
        hierarchySettings = new HierarchySettings();
        hierarchySettings.appClasses_PackageName = matrixPackage;

        compilerUtilities = new HierarchyMetaCompilerUtilities_Compiler(hierarchySettings);
        metaCompilerUtilities = new HierarchyMetaCompilerUtilities_MetaCompiler(hierarchySettings);

        executeInfo = appControl.executionInfo;

        outputResults = new CodeGen_OutputResults();


        hierarchyControl = new HierarchyControl(hierarchySettings, appControl);
        mock_HierarchyActions = new HierarchyActions(null, hierarchyControl, null, null, null, true);
        

        TestCode__MatrixWorkerFileGen = new EmbeddedFile_Worker_FileGenerator(symbolControl);

        TestCode__MatrixWorkerFileGen._1_set_Package(matrixPackage);
        TestCode__MatrixWorkerFileGen._1_set_AppClassesPackage(matrixPackage);
        TestCode__MatrixWorkerFileGen._1_set_AppClassesName(hierarchySettings.appControl_ClassName);
        TestCode__MatrixWorkerFileGen._1_set_ClassName(embeddedFile_ClassNameBase);


        annotationsInterface_FileGen = new AnnotationsInterface_FileGenerator(symbolControl);

        annotationsInterface_FileGen._1_set_Package(matrixPackage);
        annotationsInterface_FileGen._1_set_AppClassesPackage(matrixPackage);
        annotationsInterface_FileGen._1_set_AppClassesName(hierarchySettings.appControl_ClassName);
        annotationsInterface_FileGen._1_set_InterfaceName(annotations_InterfaceName);



        matrixPackage_Symbol = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(matrixPackage, 1, true, null, null);
        webForm_SchemaName = symbolControl.multiLevelSymbol_Factory.createNew_SchemaName(matrixPackage_Symbol,
                MPSymbols_DescTagName.WEB$__$FORM, false);

    }

    public static void buildSchemas() throws Exception {

        // it's getting it's schema from the generated test project's generated WEB.FORM schema (in the net.unconventionalthinking.matrix package)
        webForm_GeneratedSchema = appControl.schemaControl.schemaIndex_Find(webForm_SchemaName);

    }

    @AfterClass
    public static void tearDownClass() throws Exception {

        // generate the TestCode__MatrixWorker class.
        TestCode__MatrixWorkerFileGen._1_set_FileDirPath(HierarchySettings.generationTestProj_matrixPackage_Dir);
        TestCode__MatrixWorkerFileGen._2_generateClass(outputResults);
        TestCode__MatrixWorkerFileGen.writeToFile(hierarchySettings.DEBUG);

        // generate the annotations interface
        annotationsInterface_FileGen._1_set_FileDirPath(HierarchySettings.generationTestProj_matrixPackage_Dir);
        annotationsInterface_FileGen._2_generateClass(outputResults);
        annotationsInterface_FileGen.writeToFile(hierarchySettings.DEBUG);



        //  Add the fieldSets back in to schemaControl by rebuilding them:
        TestUtilities_FieldSetGenerator fieldSet_TestCodeGenerator =
                new TestUtilities_FieldSetGenerator(symbolControl, executeInfo,
                matrixPackage, hierarchySettings.generationTestProj_matrixPackage_Dir);
        List<Class_FileInfo> fieldSet_ClassInfoList = fieldSet_TestCodeGenerator.generateTest_FieldSetCode(true);
        Set<AppControl_Info> externalAppControls_List = new HashSet<AppControl_Info>();


        List<Class_FileInfo> schema_ClassInfoList = MetaCompiler_Utilities.create_ClassFileInfo_List(schemaControl.schemaIndex_GetStaticSchemaNamesIterator());
        List<Class_FileInfo> matrix_ClassInfoList = MetaCompiler_Utilities.create_ClassFileInfo_List(matrixControl.getStaticMatrixNames_Iterator());

        metaCompilerUtilities.generate_AppControl(matrixPackage, HierarchySettings.generationTestProj_generationtestproj_Dir,
                hierarchySettings.appControl_ClassName + ".java", externalAppControls_List,
                schema_ClassInfoList, matrix_ClassInfoList, fieldSet_ClassInfoList);

        metaCompilerUtilities.generateAll_SymbolFiles(matrixPackage, hierarchySettings.generationTestProj_generationtestproj_Dir, symbolControl);

    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {


    }



    /**
     * Test of create_SchemaSet method, of class DescriptorCreation_CodeGenerator.
     */
    @Test
    public void testCreate_SchemaSet() throws Exception {
        System.out.println("testCreate_SchemaSet");

        CodeGen_OutputResults outputResults = new CodeGen_OutputResults();
        buildSchemas();

        SchemaSet_ScopeStack schemaSet_ScopeStack = new SchemaSet_ScopeStack(executeInfo, schemaControl);
        


        List<MatrixName> usesSchema_List = new ArrayList<MatrixName>();
        usesSchema_List.add(webForm_GeneratedSchema.getSchemaInfo_SchemaNameFull());
        DescriptorCreation_CodeGenerator desc_CodeGen = new DescriptorCreation_CodeGenerator(symbolControl, schemaControl, matrixControl, hierarchySettings,
                outputResults, baseIndentLevel);
        MatrixSet<SchemaInfo_Schema> result = SchemaSet_ScopeStack.create_SchemaSet(usesSchema_List, mock_HierarchyActions);


        int expectedNumberOfSchemas = 1;
        assertEquals(expectedNumberOfSchemas, result.size());
        SchemaInfo_Schema found_WebFormSchema = result.get(0);
        assertEquals(found_WebFormSchema, webForm_GeneratedSchema);

    }





    /**
     * Test of testGenerate_CreateDescriptor_Code_w_SpecializedFieldSets method, of class DescriptorCreation_CodeGenerator.
     */

    @Test
    public void testGenerate_CreateDescriptor_Code() throws Exception {

        String matrixNameString = "MyMatrix1";

        buildSchemas();

        List<String> matrixName_Parts = new ArrayList<String>();
        matrixName_Parts.add(matrixNameString);

        String schemaSetScopeStack_OutVarName = "schemaSet_ScopeStack";
        SchemaSet_ScopeStack schemaSet_ScopeStack = new SchemaSet_ScopeStack(executeInfo, schemaControl);
        schemaSet_ScopeStack.add_BaseSchema_toStack();
        
        CodeBuilder codeBuilder = new CodeBuilder();

        
        
        DescriptorCreation_CodeGenerator matrix_CodeGen = createMatrixDescriptorCode(matrixNameString, matrixPackage_Symbol, codeBuilder,
                schemaSetScopeStack_OutVarName, schemaSet_ScopeStack);
        MatrixStructInfo_DescriptorContainer matrixDescContainer = matrix_CodeGen.postGenerate_Get_DescriptorContainer();
        String matrix_OutVarName = matrix_CodeGen.postGenerate_Get_DescriptorOutVarName();


        //  Create Descriptor with specialized fieldSet codeGen________________________________
        String descTagNameString = "FORM.REQUIRED";
        DescriptorTagName descTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(descTagNameString, 1, true, null, null);

        Symbol buildingMatrixElemOrSchemaElem = MPSymbols.BuildingMatrixElement;
        boolean create_InitialMatrixDescriptor = false;
        String parentDesc_VarName = matrix_CodeGen.postGenerate_Get_DescriptorOutVarName();
        MatrixStructInfo_DescriptorContainer parentDescContainer = matrixDescContainer;
        DescriptorCreation_CodeGenerator desc_CodeGen = new DescriptorCreation_CodeGenerator(symbolControl, schemaControl, matrixControl, 
                 hierarchySettings, outputResults, baseIndentLevel);

        desc_CodeGen.set_PackageName(matrixPackage_Symbol);
        desc_CodeGen.set_DescriptorTag(webForm_SchemaName, descTagName);
        desc_CodeGen.set_Parent(parentDescContainer, parentDesc_VarName);
        desc_CodeGen.set_SchemaRelatedValues(null, schemaSet_ScopeStack, schemaSetScopeStack_OutVarName);


        // fieldSet settings:
        List<String> fieldValueExpr_List = new ArrayList<String>();
        List<FieldValueInfo> fieldValueInfo_List = new ArrayList<FieldValueInfo>();
        fieldValueExpr_List.add("AppSymbols.IsRequired");
        fieldValueInfo_List.add(new FieldValueInfo());
        fieldValueExpr_List.add("\"/images/required.jpg\"");
        fieldValueInfo_List.add(new FieldValueInfo());
        fieldValueExpr_List.add("6");
        fieldValueInfo_List.add(new FieldValueInfo());
        fieldValueExpr_List.add("FieldConstants.DEFAULT");
        fieldValueInfo_List.add(new FieldValueInfo(FieldValueInfo.Type.Default));


        CodeBuilder expResult = null;
        codeBuilder = desc_CodeGen.generate_CreateDescriptor_w_FieldSetTuple(codeBuilder, 
                buildingMatrixElemOrSchemaElem, create_InitialMatrixDescriptor, fieldValueExpr_List, fieldValueInfo_List);

        assertEquals(true, desc_CodeGen.postGenerate_Get_DescriptorContainer().descriptor_Actual.get_FieldSet().is_SpecializedFieldSet());

        String descriptorCode = codeBuilder.toString();
        assertNotNull(descriptorCode);



        //  Create Descriptor with specialized fieldSet codeGen________________________________
        descTagNameString = "TEST.CHILD";
        descTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(descTagNameString, 1, true, null, null);

        buildingMatrixElemOrSchemaElem = MPSymbols.BuildingMatrixElement;
        create_InitialMatrixDescriptor = false;
        parentDesc_VarName = desc_CodeGen.postGenerate_Get_DescriptorOutVarName();
        parentDescContainer = desc_CodeGen.postGenerate_Get_DescriptorContainer();
        desc_CodeGen = new DescriptorCreation_CodeGenerator(symbolControl, schemaControl, matrixControl,
                hierarchySettings, outputResults, baseIndentLevel);

        desc_CodeGen.set_PackageName(matrixPackage_Symbol);
        desc_CodeGen.set_DescriptorTag(webForm_SchemaName, descTagName);
        desc_CodeGen.set_Parent(parentDescContainer, parentDesc_VarName);
        desc_CodeGen.set_SchemaRelatedValues(null, schemaSet_ScopeStack, schemaSetScopeStack_OutVarName);


        // fieldSet settings:
        fieldValueExpr_List = new ArrayList<String>();
        fieldValueInfo_List = new ArrayList<FieldValueInfo>();
        fieldValueExpr_List.add("111");
        fieldValueInfo_List.add(new FieldValueInfo());
        fieldValueExpr_List.add("\"Test String\"");
        fieldValueInfo_List.add(new FieldValueInfo());


        expResult = null;
        codeBuilder = desc_CodeGen.generate_CreateDescriptor_w_FieldSetTuple(codeBuilder,
                buildingMatrixElemOrSchemaElem, create_InitialMatrixDescriptor, fieldValueExpr_List, fieldValueInfo_List);

        //  TEST.CHILD is NOT a specialized fieldset
        assertEquals(false, desc_CodeGen.postGenerate_Get_DescriptorContainer().descriptor_Actual.get_FieldSet().is_SpecializedFieldSet());

        descriptorCode = codeBuilder.toString();
        assertNotNull(descriptorCode);



        //  Create A Grand child descriptor ________________________________
        descTagNameString = "FORM.REQUIRED";
        descTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(descTagNameString, 1, true, null, null);

        buildingMatrixElemOrSchemaElem = MPSymbols.BuildingMatrixElement;
        create_InitialMatrixDescriptor = false;
        parentDesc_VarName = desc_CodeGen.postGenerate_Get_DescriptorOutVarName();
        parentDescContainer = desc_CodeGen.postGenerate_Get_DescriptorContainer();
        DescriptorCreation_CodeGenerator desc_CodeGen_GrandChild = new DescriptorCreation_CodeGenerator(symbolControl, schemaControl, matrixControl,
                hierarchySettings, outputResults, baseIndentLevel);

        desc_CodeGen_GrandChild.set_PackageName(matrixPackage_Symbol);
        desc_CodeGen_GrandChild.set_DescriptorTag(webForm_SchemaName, descTagName);
        desc_CodeGen_GrandChild.set_Parent(parentDescContainer, parentDesc_VarName);
        desc_CodeGen_GrandChild.set_SchemaRelatedValues(null, schemaSet_ScopeStack, schemaSetScopeStack_OutVarName);


        // fieldSet settings:
        fieldValueExpr_List = new ArrayList<String>();
        fieldValueInfo_List = new ArrayList<FieldValueInfo>();
        fieldValueExpr_List.add("AppSymbols.NotRequired");
        fieldValueInfo_List.add(new FieldValueInfo());


        expResult = null;
        codeBuilder = desc_CodeGen_GrandChild.generate_CreateDescriptor_w_FieldSetTuple(codeBuilder,
                buildingMatrixElemOrSchemaElem, create_InitialMatrixDescriptor, fieldValueExpr_List, fieldValueInfo_List);

        //  FORM.SELECT is a specialized fieldset
        assertEquals(true, desc_CodeGen_GrandChild.postGenerate_Get_DescriptorContainer().descriptor_Actual.get_FieldSet().is_SpecializedFieldSet());

        descriptorCode = codeBuilder.toString();
        assertNotNull(descriptorCode);




        //  Test fieldset continuation field ______________________________________

        descTagNameString = "TEST.CONT";
        descTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(descTagNameString, 1, true, null, null);

        buildingMatrixElemOrSchemaElem = MPSymbols.BuildingMatrixElement;
        create_InitialMatrixDescriptor = false;
        parentDesc_VarName = matrix_OutVarName;
        parentDescContainer = matrixDescContainer;

        desc_CodeGen = new DescriptorCreation_CodeGenerator(symbolControl, schemaControl, matrixControl,
                hierarchySettings, outputResults, baseIndentLevel);

        desc_CodeGen.set_PackageName(matrixPackage_Symbol);
        desc_CodeGen.set_DescriptorTag(webForm_SchemaName, descTagName);
        desc_CodeGen.set_Parent(parentDescContainer, parentDesc_VarName);
        desc_CodeGen.set_SchemaRelatedValues(null, schemaSet_ScopeStack, schemaSetScopeStack_OutVarName);

        // fieldSet settings:
        fieldValueExpr_List = new ArrayList<String>();
        fieldValueInfo_List = new ArrayList<FieldValueInfo>();
        fieldValueExpr_List.add("1111");
        fieldValueInfo_List.add(new FieldValueInfo());

        fieldValueExpr_List.add("1");
        fieldValueInfo_List.add(new FieldValueInfo());
        fieldValueExpr_List.add("2");
        fieldValueInfo_List.add(new FieldValueInfo());
        fieldValueExpr_List.add("3");
        fieldValueInfo_List.add(new FieldValueInfo());



        expResult = null;
        codeBuilder.append("\n\n");
        desc_CodeGen.generate_CreateDescriptor_w_FieldSetTuple(codeBuilder, buildingMatrixElemOrSchemaElem, create_InitialMatrixDescriptor,
                fieldValueExpr_List, fieldValueInfo_List);

        assertEquals(false, desc_CodeGen.postGenerate_Get_DescriptorContainer().descriptor_Actual.get_FieldSet().is_SpecializedFieldSet());



        MatrixAndSchema_FileGenerator matrixFileGen = new MatrixAndSchema_FileGenerator(symbolControl);

        matrixFileGen._1_set_Package("net.unconventionalthinking.matrix");
        matrixFileGen._1_set_AppClassesPackage(matrixPackage);
        matrixFileGen._1_set_AppClassesName(hierarchySettings.appControl_ClassName);
        matrixFileGen._1_set_SchemaOrMatrixNameLabel(matrixName_Parts, 1);
        matrixFileGen._1_setCode_MatrixConstruction(codeBuilder);
        matrixFileGen._1_set_FileDirPath(hierarchySettings.generationTestProj_matrixPackage_Dir);

        matrixFileGen._2_addCode_MatrixClass(schemaSetScopeStack_OutVarName, matrix_OutVarName, outputResults);
        matrixFileGen.writeToFile(hierarchySettings.DEBUG);





        //  Test Matrix Access - FieldSetTuple - Static  ___________________________________________________________________________
        AnnotationHandler_CodeGenerator_MethodGen_Std annotationHandlers_CodeGen  = new AnnotationHandler_CodeGenerator_MethodGen_Std(
                hierarchySettings, 1, annotationsCodeGenerator_Control);
        AnnotationCall_CodeGenerator_Std annotation_CodeGen = new AnnotationCall_CodeGenerator_Std(hierarchySettings, annotationsInterface_FileGen,
                annotationsCodeGenerator_Control);
        annotationsCodeGenerator_Control.increment_MethodIndex();

        boolean is_StaticAccess = true;
        boolean test_FieldAccess = false;
        boolean is_SingleAccess = true;
        String matrix1_MatrixClassNameFull = "net.unconventionalthinking.matrix.MyMatrix1";
        List<CodeBuilder> codeBuildersList_AccessMethods__Static = new ArrayList<CodeBuilder>();
        List<CodeBuilder> codeBuildersList_AccessMethods__Dyn = new ArrayList<CodeBuilder>();
        List<CodeBuilder> codeBuildersList_AccessMethods__All = new ArrayList<CodeBuilder>();

        CodeBuilder codeBuilder_AccessCode_Static = new CodeBuilder();

        //  Get the descAccessCode_Gen so you can get the matrix access state for the continued access test
        //  It does Test.Matrix->FORM.REQUIRED->TEST.CHILD
        DescriptorAccess_CodeGenerator descAccess_CodeGen = _2__MatrixAccess_CodeGen_TestWorker.generate_MatrixAccess(matrix1_MatrixClassNameFull,
                embeddedFile_ClassNameBase, matrixPackage, is_StaticAccess, test_FieldAccess, is_SingleAccess,"TestCode__MatrixWorker",
                codeBuildersList_AccessMethods__Static, codeBuildersList_AccessMethods__Dyn, codeBuildersList_AccessMethods__All,
                codeBuilder_AccessCode_Static,
                annotation_CodeGen, symbolControl, schemaControl, matrixControl, hierarchySettings, outputResults);
        codeBuilder_AccessCode_Static.append("\n");

        test_FieldAccess = true;
        _2__MatrixAccess_CodeGen_TestWorker.generate_MatrixAccess(matrix1_MatrixClassNameFull, embeddedFile_ClassNameBase, matrixPackage, is_StaticAccess, is_SingleAccess, test_FieldAccess, "TestCode__MatrixWorker",
                codeBuildersList_AccessMethods__Static, codeBuildersList_AccessMethods__Dyn, codeBuildersList_AccessMethods__All, codeBuilder_AccessCode_Static,
                annotation_CodeGen, symbolControl, schemaControl, matrixControl, hierarchySettings, outputResults);
        codeBuilder_AccessCode_Static.append("\n");

        //  Generate Static Continuation Field Access
        test_FieldAccess = true;
        _2__MatrixAccess_CodeGen_TestWorker.generate_MatrixAccess_ContinuationField(matrix1_MatrixClassNameFull, embeddedFile_ClassNameBase, matrixPackage, is_StaticAccess, test_FieldAccess, "TestCode__MatrixWorker",
                codeBuildersList_AccessMethods__Static, codeBuildersList_AccessMethods__Dyn, codeBuildersList_AccessMethods__All, codeBuilder_AccessCode_Static,
                annotation_CodeGen, symbolControl, schemaControl, matrixControl, hierarchySettings, outputResults);
        codeBuilder_AccessCode_Static.append("\n");



        //  Test Continued Access
        //  Use the descAccessCode_Gen from the first part of this test. It does descVar = Test.Matrix->FORM.REQUIRED->TEST.CHILD
        //  The continued access will do: descVar->FORM.REQUIRED->IsRequired (NOTE: this FORM.REQUIRED is a Grand child of the orig one!!)
        test_FieldAccess = true;
        _2__MatrixAccess_CodeGen_TestWorker.generate_MatrixAccess_ContinuedAccess(descAccess_CodeGen.postGen__create_MatrixAccessState(),
                "myDescriptorVar", embeddedFile_ClassNameBase, matrixPackage, is_StaticAccess, is_SingleAccess, test_FieldAccess, "TestCode__MatrixWorker",
                codeBuildersList_AccessMethods__Static, codeBuildersList_AccessMethods__Dyn, codeBuildersList_AccessMethods__All, codeBuilder_AccessCode_Static,
                annotation_CodeGen, symbolControl, schemaControl, matrixControl, hierarchySettings, outputResults);
        codeBuilder_AccessCode_Static.append("\n");




        //  Test Matrix Access - FieldSet  - Dyn___________________________________________________________________________
        is_StaticAccess = false;
        test_FieldAccess = false;
        is_SingleAccess = true;
        CodeBuilder codeBuilder_AccessCode_Dyn = new CodeBuilder();

        _2__MatrixAccess_CodeGen_TestWorker.generate_MatrixAccess(matrix1_MatrixClassNameFull, embeddedFile_ClassNameBase, matrixPackage, is_StaticAccess, test_FieldAccess, is_SingleAccess, "TestCode__MatrixWorker",
                codeBuildersList_AccessMethods__Static, codeBuildersList_AccessMethods__Dyn, codeBuildersList_AccessMethods__All, codeBuilder_AccessCode_Dyn,
                annotation_CodeGen, symbolControl, schemaControl, matrixControl, hierarchySettings, outputResults);
        codeBuilder_AccessCode_Dyn.append("\n");

        test_FieldAccess = true;
        _2__MatrixAccess_CodeGen_TestWorker.generate_MatrixAccess(matrix1_MatrixClassNameFull, embeddedFile_ClassNameBase, matrixPackage, is_StaticAccess, is_SingleAccess, test_FieldAccess, "TestCode__MatrixWorker",
                codeBuildersList_AccessMethods__Static, codeBuildersList_AccessMethods__Dyn, codeBuildersList_AccessMethods__All, codeBuilder_AccessCode_Dyn,
                annotation_CodeGen, symbolControl, schemaControl, matrixControl, hierarchySettings, outputResults);
        codeBuilder_AccessCode_Dyn.append("\n");

        //  Generate Static Continuation Field Access
        test_FieldAccess = true;
        _2__MatrixAccess_CodeGen_TestWorker.generate_MatrixAccess_ContinuationField(matrix1_MatrixClassNameFull, embeddedFile_ClassNameBase,
                matrixPackage, is_StaticAccess, test_FieldAccess, "TestCode__MatrixWorker",
                codeBuildersList_AccessMethods__Static, codeBuildersList_AccessMethods__Dyn, codeBuildersList_AccessMethods__All,
                codeBuilder_AccessCode_Dyn,
                annotation_CodeGen, symbolControl, schemaControl, matrixControl, hierarchySettings, outputResults);
        codeBuilder_AccessCode_Dyn.append("\n");


        //  Test Continued Access
        //  Use the descAccessCode_Gen from the first part of this test. It does descVar = Test.Matrix->FORM.REQUIRED->TEST.CHILD
        //  The continued access will do: descVar->[FORM.REQUIRED]:>[IsRequired] (NOTE: this FORM.REQUIRED is a Grand child of the orig one!!)
        test_FieldAccess = true;
        _2__MatrixAccess_CodeGen_TestWorker.generate_MatrixAccess_ContinuedAccess(descAccess_CodeGen.postGen__create_MatrixAccessState(),
                "myDescriptorVar", embeddedFile_ClassNameBase, matrixPackage, is_StaticAccess, is_SingleAccess, test_FieldAccess, "TestCode__MatrixWorker",
                codeBuildersList_AccessMethods__Static, codeBuildersList_AccessMethods__Dyn, codeBuildersList_AccessMethods__All, 
                codeBuilder_AccessCode_Dyn,
                annotation_CodeGen, symbolControl, schemaControl, matrixControl, hierarchySettings, outputResults);
        codeBuilder_AccessCode_Dyn.append("\n");





        //  Test MultiAccess ________________________________________________________________________________
        is_StaticAccess = false;
        test_FieldAccess = false;
        is_SingleAccess = false;

        _2__MatrixAccess_CodeGen_TestWorker.generate_MatrixAccess(matrix1_MatrixClassNameFull, embeddedFile_ClassNameBase, matrixPackage, is_StaticAccess, test_FieldAccess, is_SingleAccess, "TestCode__MatrixWorker",
                codeBuildersList_AccessMethods__Static, codeBuildersList_AccessMethods__Dyn, codeBuildersList_AccessMethods__All, codeBuilder_AccessCode_Dyn,
                annotation_CodeGen, symbolControl, schemaControl, matrixControl, hierarchySettings, outputResults);

        codeBuilder_AccessCode_Dyn.append("\n");


        test_FieldAccess = true;
        _2__MatrixAccess_CodeGen_TestWorker.generate_MatrixAccess(matrix1_MatrixClassNameFull, embeddedFile_ClassNameBase, matrixPackage, is_StaticAccess, test_FieldAccess, is_SingleAccess, "TestCode__MatrixWorker",
                codeBuildersList_AccessMethods__Static, codeBuildersList_AccessMethods__Dyn, codeBuildersList_AccessMethods__All, codeBuilder_AccessCode_Dyn,
                annotation_CodeGen, symbolControl, schemaControl, matrixControl, hierarchySettings, outputResults);
        codeBuilder_AccessCode_Dyn.append("\n");



        //  ___________________________________________________________________________
        annotationHandlers_CodeGen.add_CodeForAnnotationHandler(0, new CodeBuilder("\t\t// do nothing\n\t\treturn null;\n"));
        CodeBuilder annotationHandlers = annotationHandlers_CodeGen.generate_AnnotationHandlers(annotationsInterface_FileGen);


        matrixFileGen._1_set_Package("net.unconventionalthinking.matrix");
        matrixFileGen._1_set_AppClassesPackage("net.unconventionalthinking.matrix");
        matrixFileGen._1_set_AppClassesName(hierarchySettings.appControl_ClassName);
        matrixFileGen._1_set_SchemaOrMatrixNameLabel(matrixName_Parts, 1);
        matrixFileGen._1_setCode_MatrixConstruction(codeBuilder);
        matrixFileGen._1_set_FileDirPath(hierarchySettings.generationTestProj_matrixPackage_Dir);
        matrixFileGen._2_addCode_MatrixClass(schemaSetScopeStack_OutVarName, matrix_OutVarName, outputResults);
        matrixFileGen.writeToFile(hierarchySettings.DEBUG);

        TestCode__MatrixWorkerFileGen._1_addCode_MethodsList(codeBuildersList_AccessMethods__All);





    System.out.println("\n\nMatrix 1: Tuple \nACCESS CODE: Static________\n" + codeBuilder_AccessCode_Static);
    System.out.println("\n\n\nACCESS CODE: Dyn________\n" + codeBuilder_AccessCode_Dyn);





    System.out.println("\n\n\nAnnotation Handlers: to be added to the caller object code________\n" + annotationHandlers);
    }





    @Test
    public void testGenerate_CreateDescriptor_Code_w_ParameterMap() throws Exception {
        System.out.println("testGenerate_CreateDescriptor_Code_w_ParameterMap");

        buildSchemas();


        String schemaSetScopeStack_OutVarName = "schemaSetScopeStack";
        SchemaSet_ScopeStack schemaSet_ScopeStack = new SchemaSet_ScopeStack(executeInfo, schemaControl);
        schemaSet_ScopeStack.add_BaseSchema_toStack();
        CodeBuilder codeBuilder = new CodeBuilder();

        String matrixNameString = "MyMatrix2";
        List<String> matrixName_Parts = new ArrayList<String>();
        matrixName_Parts.add(matrixNameString);



        DescriptorCreation_CodeGenerator matrix_CodeGen = createMatrixDescriptorCode(matrixNameString, matrixPackage_Symbol, codeBuilder,
                schemaSetScopeStack_OutVarName, schemaSet_ScopeStack);
        MatrixStructInfo_DescriptorContainer matrixDescContainer = matrix_CodeGen.postGenerate_Get_DescriptorContainer();
        String matrix_OutVarName = matrix_CodeGen.postGenerate_Get_DescriptorOutVarName();


        //  Create Descriptor with specialized fieldSet codeGen________________________________
        String descTagNameString = "FORM.REQUIRED";
        DescriptorTagName descTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(descTagNameString, 1, true, null, null);

        Symbol buildingMatrixElemOrSchemaElem = MPSymbols.BuildingMatrixElement;
        boolean create_InitialMatrixDescriptor = false;
        String parentDesc_VarName = matrix_OutVarName;
        MatrixStructInfo_DescriptorContainer parentDescContainer = matrixDescContainer;


        DescriptorCreation_CodeGenerator desc_CodeGen = new DescriptorCreation_CodeGenerator(symbolControl, schemaControl, matrixControl,
                hierarchySettings, outputResults, baseIndentLevel);

        desc_CodeGen.set_PackageName(matrixPackage_Symbol);
        desc_CodeGen.set_DescriptorTag(webForm_SchemaName, descTagName);
        desc_CodeGen.set_Parent(parentDescContainer, parentDesc_VarName);
        desc_CodeGen.set_SchemaRelatedValues(null, schemaSet_ScopeStack, schemaSetScopeStack_OutVarName);

        // fieldSet settings:
        List<Pair<DescriptorTagName, String>> paramMap_fieldToValue_List = new ArrayList<Pair<DescriptorTagName, String>>();
        List<FieldValueInfo> fieldValueInfo_List = new ArrayList<FieldValueInfo>();

        DescriptorTagName fieldName = symbolControl.singleSymbol_Factory.createNew_DescTagName("ImageHeight", true);
        Pair<DescriptorTagName, String> fieldAndValue = new Pair<DescriptorTagName, String>(fieldName, "6");
        paramMap_fieldToValue_List.add(fieldAndValue);
        fieldValueInfo_List.add(new FieldValueInfo());

        fieldName = symbolControl.singleSymbol_Factory.createNew_DescTagName("ImageWidth", true);
        fieldAndValue = new Pair<DescriptorTagName, String>(fieldName, "FieldConstants.DEFAULT");
        paramMap_fieldToValue_List.add(fieldAndValue);
        fieldValueInfo_List.add(new FieldValueInfo(FieldValueInfo.Type.Default));

        fieldName = symbolControl.singleSymbol_Factory.createNew_DescTagName("IsRequired", true);
        fieldAndValue = new Pair<DescriptorTagName, String>(fieldName, "AppSymbols.IsRequired");
        paramMap_fieldToValue_List.add(fieldAndValue);
        fieldValueInfo_List.add(new FieldValueInfo());


        fieldName = symbolControl.singleSymbol_Factory.createNew_DescTagName("RequiredImagePath", true);
        fieldAndValue = new Pair<DescriptorTagName, String>(fieldName, "\"/images/required.jpg\"");
        paramMap_fieldToValue_List.add(fieldAndValue);
        fieldValueInfo_List.add(new FieldValueInfo());

        CodeBuilder expResult = null;
        codeBuilder = desc_CodeGen.generate_CreateDescriptor_w_FieldSetParameterMap(codeBuilder,
                buildingMatrixElemOrSchemaElem, create_InitialMatrixDescriptor, paramMap_fieldToValue_List, fieldValueInfo_List);
        String descriptorCode = codeBuilder.toString();
        assertNotNull(descriptorCode);

        assertTrue(desc_CodeGen.postGenerate_Get_DescriptorContainer().descriptor_Actual.get_FieldSet().is_ParameterMap());




        descTagNameString = "TEST.CHILD";
        descTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(descTagNameString, 1, true, null, null);

        buildingMatrixElemOrSchemaElem = MPSymbols.BuildingMatrixElement;
        create_InitialMatrixDescriptor = false;
        parentDesc_VarName = desc_CodeGen.postGenerate_Get_DescriptorOutVarName();
        parentDescContainer = desc_CodeGen.postGenerate_Get_DescriptorContainer();
        desc_CodeGen = new DescriptorCreation_CodeGenerator(symbolControl, schemaControl, matrixControl, hierarchySettings,
                outputResults, baseIndentLevel);

        desc_CodeGen.set_PackageName(matrixPackage_Symbol);
        desc_CodeGen.set_DescriptorTag(webForm_SchemaName, descTagName);
        desc_CodeGen.set_Parent(parentDescContainer, parentDesc_VarName);
        desc_CodeGen.set_SchemaRelatedValues(null, schemaSet_ScopeStack, schemaSetScopeStack_OutVarName);


        // fieldSet settings:
        paramMap_fieldToValue_List = new ArrayList<Pair<DescriptorTagName, String>>();
        fieldValueInfo_List = new ArrayList<FieldValueInfo>();

        fieldName = symbolControl.singleSymbol_Factory.createNew_DescTagName("Field1int", true);
        fieldAndValue = new Pair<DescriptorTagName, String>(fieldName, "111");
        paramMap_fieldToValue_List.add(fieldAndValue);
        fieldValueInfo_List.add(new FieldValueInfo());

        fieldName = symbolControl.singleSymbol_Factory.createNew_DescTagName("Field2String", true);
        fieldAndValue = new Pair<DescriptorTagName, String>(fieldName, "\"Test String\"");
        paramMap_fieldToValue_List.add(fieldAndValue);
        fieldValueInfo_List.add(new FieldValueInfo());


        expResult = null;
        codeBuilder = desc_CodeGen.generate_CreateDescriptor_w_FieldSetParameterMap(codeBuilder,
                buildingMatrixElemOrSchemaElem, create_InitialMatrixDescriptor, paramMap_fieldToValue_List, fieldValueInfo_List);
        descriptorCode = codeBuilder.toString();
        assertNotNull(descriptorCode);

        assertTrue(desc_CodeGen.postGenerate_Get_DescriptorContainer().descriptor_Actual.get_FieldSet().is_ParameterMap());



        MatrixAndSchema_FileGenerator matrixFileGen = new MatrixAndSchema_FileGenerator(symbolControl);

        matrixFileGen._1_set_Package("net.unconventionalthinking.matrix");
        matrixFileGen._1_set_AppClassesPackage("net.unconventionalthinking.matrix");
        matrixFileGen._1_set_AppClassesName(hierarchySettings.appControl_ClassName);
        matrixFileGen._1_set_SchemaOrMatrixNameLabel(matrixName_Parts, 1);
        matrixFileGen._1_setCode_MatrixConstruction(codeBuilder);
        matrixFileGen._1_set_FileDirPath(hierarchySettings.generationTestProj_matrixPackage_Dir);

        matrixFileGen._2_addCode_MatrixClass(schemaSetScopeStack_OutVarName, matrix_OutVarName, outputResults);
        matrixFileGen.writeToFile(hierarchySettings.DEBUG);




        //  Test Matrix Access - FieldSet ParamMap - Static  ___________________________________________________________________________
        AnnotationHandler_CodeGenerator_MethodGen_Std annotationHandlers_CodeGen  = new AnnotationHandler_CodeGenerator_MethodGen_Std(hierarchySettings, 1,
                annotationsCodeGenerator_Control);
        AnnotationCall_CodeGenerator_Std annotation_CodeGen = new AnnotationCall_CodeGenerator_Std(hierarchySettings, annotationsInterface_FileGen,
                annotationsCodeGenerator_Control);

        boolean is_StaticAccess = true;
        boolean test_FieldAccess = false;
        boolean is_SingleAccess = true;
        String matrix2_MatrixClassNameFull = "net.unconventionalthinking.matrix.MyMatrix2";

        List<CodeBuilder> codeBuildersList_AccessMethods__Static = new ArrayList<CodeBuilder>();
        List<CodeBuilder> codeBuildersList_AccessMethods__Dyn = new ArrayList<CodeBuilder>();
        List<CodeBuilder> codeBuildersList_AccessMethods__All = new ArrayList<CodeBuilder>();
        CodeBuilder codeBuilder_AccessCode_Static = new CodeBuilder();
        _2__MatrixAccess_CodeGen_TestWorker.generate_MatrixAccess(matrix2_MatrixClassNameFull, embeddedFile_ClassNameBase, matrixPackage, is_StaticAccess, test_FieldAccess, is_SingleAccess, "TestCode__MatrixWorker",
                codeBuildersList_AccessMethods__Static, codeBuildersList_AccessMethods__Dyn, codeBuildersList_AccessMethods__All,
                codeBuilder_AccessCode_Static,annotation_CodeGen, symbolControl, schemaControl, matrixControl, hierarchySettings, outputResults);


        codeBuilder_AccessCode_Static.append("\n");
        test_FieldAccess = true;
        _2__MatrixAccess_CodeGen_TestWorker.generate_MatrixAccess(matrix2_MatrixClassNameFull, embeddedFile_ClassNameBase, matrixPackage, is_StaticAccess, test_FieldAccess, is_SingleAccess, "TestCode__MatrixWorker",
                codeBuildersList_AccessMethods__Static, codeBuildersList_AccessMethods__Dyn, codeBuildersList_AccessMethods__All,
                codeBuilder_AccessCode_Static, annotation_CodeGen, symbolControl, schemaControl, matrixControl, hierarchySettings, outputResults);

        codeBuilder_AccessCode_Static.append("\n");

        //  Test Matrix Access - FieldSetMap - Dyn___________________________________________________________________________
        is_StaticAccess = false;
        test_FieldAccess = false;
        is_SingleAccess = true;
        CodeBuilder codeBuilder_AccessCode_Dyn = new CodeBuilder();

        _2__MatrixAccess_CodeGen_TestWorker.generate_MatrixAccess(matrix2_MatrixClassNameFull, embeddedFile_ClassNameBase, matrixPackage, is_StaticAccess, test_FieldAccess, is_SingleAccess, "TestCode__MatrixWorker",
                codeBuildersList_AccessMethods__Static, codeBuildersList_AccessMethods__Dyn, codeBuildersList_AccessMethods__All,
                codeBuilder_AccessCode_Dyn, annotation_CodeGen, symbolControl, schemaControl, matrixControl, hierarchySettings, outputResults);

        codeBuilder_AccessCode_Dyn.append("\n");
        test_FieldAccess = true;
        _2__MatrixAccess_CodeGen_TestWorker.generate_MatrixAccess(matrix2_MatrixClassNameFull, embeddedFile_ClassNameBase, matrixPackage, is_StaticAccess, test_FieldAccess, is_SingleAccess, "TestCode__MatrixWorker",
                codeBuildersList_AccessMethods__Static, codeBuildersList_AccessMethods__Dyn, codeBuildersList_AccessMethods__All,
                codeBuilder_AccessCode_Dyn,annotation_CodeGen, symbolControl, schemaControl, matrixControl, hierarchySettings, outputResults);

        codeBuilder_AccessCode_Dyn.append("\n");

        //  Test MultiAccess ________________________________________________________________________________
        is_StaticAccess = false;
        test_FieldAccess = false;
        is_SingleAccess = false;

        _2__MatrixAccess_CodeGen_TestWorker.generate_MatrixAccess(matrix2_MatrixClassNameFull, embeddedFile_ClassNameBase, matrixPackage, is_StaticAccess, test_FieldAccess, is_SingleAccess, "TestCode__MatrixWorker",
                codeBuildersList_AccessMethods__Static, codeBuildersList_AccessMethods__Dyn, codeBuildersList_AccessMethods__All, codeBuilder_AccessCode_Dyn,
                annotation_CodeGen, symbolControl, schemaControl, matrixControl, hierarchySettings, outputResults);

        codeBuilder_AccessCode_Dyn.append("\n");


        test_FieldAccess = true;
        _2__MatrixAccess_CodeGen_TestWorker.generate_MatrixAccess(matrix2_MatrixClassNameFull, embeddedFile_ClassNameBase, matrixPackage, is_StaticAccess, test_FieldAccess, is_SingleAccess, "TestCode__MatrixWorker",
                codeBuildersList_AccessMethods__Static, codeBuildersList_AccessMethods__Dyn, codeBuildersList_AccessMethods__All, codeBuilder_AccessCode_Dyn,
                annotation_CodeGen, symbolControl, schemaControl, matrixControl, hierarchySettings, outputResults);
        codeBuilder_AccessCode_Dyn.append("\n");

        
        
        //  ___________________________________________________________________________


        annotationHandlers_CodeGen.add_CodeForAnnotationHandler(0, new CodeBuilder("\t\t// do nothing\n\t\treturn null;\n"));
        CodeBuilder annotationHandlers = annotationHandlers_CodeGen.generate_AnnotationHandlers(annotationsInterface_FileGen);




        matrixFileGen._1_set_Package("net.unconventionalthinking.matrix");
        matrixFileGen._1_set_AppClassesPackage("net.unconventionalthinking.matrix");
        matrixFileGen._1_set_AppClassesName(hierarchySettings.appControl_ClassName);
        matrixFileGen._1_set_SchemaOrMatrixNameLabel(matrixName_Parts, 1);
        matrixFileGen._1_setCode_MatrixConstruction(codeBuilder);
        matrixFileGen._1_set_FileDirPath(hierarchySettings.generationTestProj_matrixPackage_Dir);
        matrixFileGen._2_addCode_MatrixClass(schemaSetScopeStack_OutVarName, matrix_OutVarName, outputResults);
        matrixFileGen.writeToFile(hierarchySettings.DEBUG);



        TestCode__MatrixWorkerFileGen._1_addCode_MethodsList(codeBuildersList_AccessMethods__All);





    System.out.println("\n\nMatrix 2: ParamMap \nACCESS CODE: Static________\n" + codeBuilder_AccessCode_Static);
    System.out.println("\n\n\nACCESS CODE: Dyn________\n" + codeBuilder_AccessCode_Dyn);
    System.out.println("\n\n\nAnnotation Handlers: to be added to the caller object code________\n" + annotationHandlers);

//    System.out.println(descriptorCode);
    }






    DescriptorCreation_CodeGenerator createMatrixDescriptorCode(String matrixNameString, DescriptorTagName packageName, CodeBuilder codeBuilder, 
            String schemaSetScopeStack_OutVarName, SchemaSet_ScopeStack schemaSet_ScopeStack) throws Exception {

        CodeGen_OutputResults outputResults = new CodeGen_OutputResults();

        //  Create Matrix
        List<String> label_Parts = new ArrayList<String>();
        label_Parts.add(matrixNameString);

        List<MatrixName> usesSchema_List = new ArrayList<MatrixName>();
        usesSchema_List.add(webForm_GeneratedSchema.getSchemaInfo_SchemaNameFull());

        MatrixSet<SchemaInfo_Schema> usesSchema_Set = SchemaSet_ScopeStack.create_SchemaSet(usesSchema_List, mock_HierarchyActions);


        Symbol buildingMatrixElemOrSchemaElem = MPSymbols.BuildingMatrixElement;
        boolean create_InitialMatrixDescriptor = true;
        String parentDesc_VarName = null;
        MatrixStructInfo_DescriptorContainer parentDescContainer = null;
        DescriptorCreation_CodeGenerator desc_CodeGen = new DescriptorCreation_CodeGenerator(symbolControl, schemaControl, matrixControl, 
                hierarchySettings, outputResults, baseIndentLevel);

        desc_CodeGen.set_PackageName(packageName);
        desc_CodeGen.set_Label((Label)symbolControl.multiPartSymbol_Factory.createNew_Label(label_Parts, 1, true));
        desc_CodeGen.set_Parent(parentDescContainer, parentDesc_VarName);
        desc_CodeGen.set_SchemaRelatedValues(usesSchema_Set, schemaSet_ScopeStack, schemaSetScopeStack_OutVarName);


        desc_CodeGen.generate_CreateDescriptor(codeBuilder, buildingMatrixElemOrSchemaElem, create_InitialMatrixDescriptor);
        String descriptorCode = codeBuilder.toString();


        return desc_CodeGen;

    }


}