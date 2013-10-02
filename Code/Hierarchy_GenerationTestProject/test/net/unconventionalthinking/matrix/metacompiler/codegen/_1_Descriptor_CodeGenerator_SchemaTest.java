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

import net.unconventionalthinking.matrix.*;
import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.matrix.SchemaInfo_Schema;
import net.unconventionalthinking.matrix.MatrixSet;
import net.unconventionalthinking.matrix.symbols.Symbol;

import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.SchemaControl;
import net.unconventionalthinking.matrix.SchemaFactory;
import net.unconventionalthinking.matrix.TestUtilities_1_Schema;
import net.unconventionalthinking.matrix.metacompiler.codefilegen.MatrixAndSchema_FileGenerator;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.MPSymbols_DescTagName;
import net.unconventionalthinking.matrix.symbols.MPSymbols_SchemaName;
import net.unconventionalthinking.matrix.symbols.MatrixName;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.hierarchy.AppControl_Info;
import net.unconventionalthinking.hierarchy.Class_FileInfo;

import net.unconventionalthinking.hierarchy.HierarchyMetaCompilerUtilities_Compiler;
import net.unconventionalthinking.hierarchy.HierarchyMetaCompilerUtilities_MetaCompiler;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import net.unconventionalthinking.hierarchy.SchemaSet_ScopeStack;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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
public class _1_Descriptor_CodeGenerator_SchemaTest {

    private static AppControl_Base appControl;

    private static ExecutionInfo executeInfo;
    private static SymbolControl symbolControl;
    private static SchemaControl schemaControl;
    private static MatrixControl matrixControl;
    private static HierarchySettings hierarchySettings;
    private static HierarchyMetaCompilerUtilities_Compiler compilerUtilities;
    private static HierarchyMetaCompilerUtilities_MetaCompiler metaCompilerUtilities;




    private static int baseIndentLevel = 2;

    private final static String matrixPackage = "net.unconventionalthinking.matrix";
    private static DescriptorTagName matrixPackage_Symbol;
    private static MatrixName webForm_SchemaName;
    

    public _1_Descriptor_CodeGenerator_SchemaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        appControl = AppControl.initializeApp();

        symbolControl = appControl.symbolControl;

        schemaControl = appControl.schemaControl;
        matrixControl = appControl.matrixControl;
        hierarchySettings = new HierarchySettings();

        compilerUtilities = new HierarchyMetaCompilerUtilities_Compiler(hierarchySettings);
        metaCompilerUtilities = new HierarchyMetaCompilerUtilities_MetaCompiler(hierarchySettings);

        executeInfo = appControl.executionInfo;




        matrixPackage_Symbol = MPSymbols_DescTagName.net$__$unconventionalthinking$__$matrix;
        webForm_SchemaName = symbolControl.multiLevelSymbol_Factory.createNew_SchemaName(MPSymbols_DescTagName.net$__$unconventionalthinking$__$matrix,
                MPSymbols_DescTagName.WEB$__$FORM, false);

    }

    public static void buildSchemas() throws Exception {



    }

    @AfterClass
    public static void tearDownClass() throws Exception {

        //  Add the fieldSets back in to schemaControl by rebuilding them:
        TestUtilities_FieldSetGenerator fieldSet_TestCodeGenerator =
                new TestUtilities_FieldSetGenerator(symbolControl, executeInfo,
                matrixPackage, HierarchySettings.generationTestProj_matrixPackage_Dir);

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
     * Test of testGenerate_CreateDescriptor_Code_w_SpecializedFieldSets method, of class DescriptorCreation_CodeGenerator.
     */

    @Test
    public void testGenerate_SchemaCode() throws Exception {

//        buildSchemas();


        CodeGen_OutputResults outputResults = new CodeGen_OutputResults();
        String schemaSetScopeStack_OutVarName = "schemaSet_ScopeStack";
        SchemaSet_ScopeStack schemaSet_ScopeStack = new SchemaSet_ScopeStack(executeInfo, schemaControl);
        CodeBuilder codeBuilder = new CodeBuilder();

        
        String schemaNameString = "WEB.FORM";
        List<String> label_Parts = new ArrayList<String>();
        label_Parts = new ArrayList<String>();
        label_Parts.add("WEB");
        label_Parts.add("FORM");
        List<String> schemaName_Parts = label_Parts;

        Label webForm_Label = symbolControl.multiPartSymbol_Factory.createNew_Label(label_Parts, 1, true);
        
        DescriptorCreation_CodeGenerator matrix_CodeGen = createSchemaDescriptorCode(label_Parts, matrixPackage_Symbol, codeBuilder,
                schemaSetScopeStack_OutVarName, schemaSet_ScopeStack);
        MatrixStructInfo_DescriptorContainer matrixDescContainer = matrix_CodeGen.postGenerate_Get_DescriptorContainer();
        String matrix_OutVarName = matrix_CodeGen.postGenerate_Get_DescriptorOutVarName();


        MatrixName schemaName = ((SchemaInfo_Schema)matrixDescContainer.descriptor_Actual).getSchemaInfo_SchemaNameFull();


        //  Create DESCRIPTOR `FORM.REQUIRED`________________________________
        List<String> descTagName_Parts = new ArrayList<String>();
        DescriptorTagName descTag = MPSymbols_DescTagName.DESCRIPTOR;

        label_Parts = new ArrayList<String>();
        label_Parts.add("FORM");
        label_Parts.add("REQUIRED");

        Symbol buildingMatrixElemOrSchemaElem = MPSymbols.BuildingSchemaElement;
        boolean create_InitialMatrixDescriptor = false;
        String parentDesc_VarName = matrix_CodeGen.postGenerate_Get_DescriptorOutVarName();
        MatrixStructInfo_DescriptorContainer parentDescContainer = matrixDescContainer;
        DescriptorCreation_CodeGenerator desc_CodeGen = new DescriptorCreation_CodeGenerator(symbolControl, schemaControl, matrixControl, hierarchySettings,
                outputResults, baseIndentLevel);

        desc_CodeGen.set_PackageName(matrixPackage_Symbol);
        desc_CodeGen.set_SchemaOrMatrixName(schemaName);
        desc_CodeGen.set_DescriptorTag(MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, descTag);
        desc_CodeGen.set_Label((Label)symbolControl.multiPartSymbol_Factory.createNew_Label(label_Parts, 1, true));
        desc_CodeGen.set_Parent(parentDescContainer, parentDesc_VarName);
        desc_CodeGen.set_SchemaRelatedValues(null, schemaSet_ScopeStack, schemaSetScopeStack_OutVarName);

        CodeBuilder expResult = null;
        codeBuilder = desc_CodeGen.generate_CreateDescriptor_w_FieldSetTuple(codeBuilder, 
            buildingMatrixElemOrSchemaElem, create_InitialMatrixDescriptor, null, null);


        String descriptorCode = codeBuilder.toString();
        assertNotNull(descriptorCode);



        //  Create DESCRIPTOR `FORM.REQUIRED`->FIELD.NAMES Desc ________________________________

        descTag = MPSymbols_DescTagName.FIELD$__$NAMES;
        label_Parts = new ArrayList<String>();

        buildingMatrixElemOrSchemaElem = MPSymbols.BuildingMatrixElementForSchema;  // LOOK! Field.names is a matrix descriptor, not a schema descriptor!!!
        create_InitialMatrixDescriptor = false;
        String formRequired_Desc_VarName = desc_CodeGen.postGenerate_Get_DescriptorOutVarName();
        MatrixStructInfo_DescriptorContainer formRequired_DescContainer = desc_CodeGen.postGenerate_Get_DescriptorContainer();
        desc_CodeGen = new DescriptorCreation_CodeGenerator(symbolControl, schemaControl, matrixControl, hierarchySettings,
                outputResults, baseIndentLevel);

        desc_CodeGen.set_PackageName(matrixPackage_Symbol);
        desc_CodeGen.set_SchemaOrMatrixName(schemaName);
        desc_CodeGen.set_DescriptorTag(MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, descTag);
        desc_CodeGen.set_Parent(formRequired_DescContainer, formRequired_Desc_VarName);
        desc_CodeGen.set_SchemaRelatedValues(null, schemaSet_ScopeStack, schemaSetScopeStack_OutVarName);

        // fieldSet settings:
        List<String> fieldValueExpr_List = new ArrayList<String>();
        List<FieldValueInfo> fieldValueInfo_List = new ArrayList<FieldValueInfo>();
        fieldValueExpr_List.add("appControl.symbolControl.multiPartSymbol_Factory.createNew_DescTagName(\"IsRequired\", 1, false, null, null)");
        fieldValueInfo_List.add(new FieldValueInfo());
        fieldValueExpr_List.add("appControl.symbolControl.multiPartSymbol_Factory.createNew_DescTagName(\"RequiredImagePath\", 1, false, null, null)");
        fieldValueInfo_List.add(new FieldValueInfo());
        fieldValueExpr_List.add("appControl.symbolControl.multiPartSymbol_Factory.createNew_DescTagName(\"ImageHeight\", 1, false, null, null)");
        fieldValueInfo_List.add(new FieldValueInfo());
        fieldValueExpr_List.add("appControl.symbolControl.multiPartSymbol_Factory.createNew_DescTagName(\"ImageWidth\", 1, false, null, null)");
        fieldValueInfo_List.add(new FieldValueInfo());
        
        expResult = null;
        codeBuilder = desc_CodeGen.generate_CreateDescriptor_w_FieldSetTuple(codeBuilder,
            buildingMatrixElemOrSchemaElem, create_InitialMatrixDescriptor, fieldValueExpr_List, fieldValueInfo_List);


        descriptorCode = codeBuilder.toString();
        assertNotNull(descriptorCode);


        //  Create DESCRIPTOR `FORM.REQUIRED`->FIELD.TYPES Desc ________________________________
        descTag = MPSymbols_DescTagName.FIELD$__$TYPES;

        label_Parts = new ArrayList<String>();

        buildingMatrixElemOrSchemaElem = MPSymbols.BuildingMatrixElementForSchema;  // LOOK! Field.names is a matrix descriptor, not a schema descriptor!!!
        create_InitialMatrixDescriptor = false;
        desc_CodeGen = new DescriptorCreation_CodeGenerator(symbolControl, schemaControl, matrixControl, hierarchySettings,
                outputResults, baseIndentLevel);

        desc_CodeGen.set_PackageName(matrixPackage_Symbol);
        desc_CodeGen.set_SchemaOrMatrixName(schemaName);
        desc_CodeGen.set_DescriptorTag(MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, descTag);
        desc_CodeGen.set_Parent(formRequired_DescContainer, formRequired_Desc_VarName);
        desc_CodeGen.set_SchemaRelatedValues(null, schemaSet_ScopeStack, schemaSetScopeStack_OutVarName);

        // fieldSet settings:
        fieldValueExpr_List = new ArrayList<String>();
        fieldValueInfo_List = new ArrayList<FieldValueInfo>();
        fieldValueExpr_List.add("MPSymbols.Symbol");
        fieldValueInfo_List.add(new FieldValueInfo());
        fieldValueExpr_List.add("MPSymbols.String");
        fieldValueInfo_List.add(new FieldValueInfo());
        fieldValueExpr_List.add("MPSymbols.int$_sym_$");
        fieldValueInfo_List.add(new FieldValueInfo());
        fieldValueExpr_List.add("MPSymbols.int$_sym_$");
        fieldValueInfo_List.add(new FieldValueInfo());

        expResult = null;
        codeBuilder = desc_CodeGen.generate_CreateDescriptor_w_FieldSetTuple(codeBuilder,
            buildingMatrixElemOrSchemaElem, create_InitialMatrixDescriptor, fieldValueExpr_List, fieldValueInfo_List);







        //  Create DESCRIPTOR `TEST.CHILD`  ________________________________
        descTag = MPSymbols_DescTagName.DESCRIPTOR;

        label_Parts = new ArrayList<String>();
        label_Parts.add("TEST");
        label_Parts.add("CHILD");

        buildingMatrixElemOrSchemaElem = MPSymbols.BuildingSchemaElement;
        create_InitialMatrixDescriptor = false;
        parentDesc_VarName = formRequired_Desc_VarName;
        parentDescContainer = formRequired_DescContainer;
        desc_CodeGen = new DescriptorCreation_CodeGenerator(symbolControl, schemaControl, matrixControl, hierarchySettings,
                outputResults, baseIndentLevel);

        desc_CodeGen.set_PackageName(matrixPackage_Symbol);
        desc_CodeGen.set_SchemaOrMatrixName(schemaName);
        desc_CodeGen.set_DescriptorTag(MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, descTag);
        desc_CodeGen.set_Label((Label)symbolControl.multiPartSymbol_Factory.createNew_Label(label_Parts, 1, true));
        desc_CodeGen.set_Parent(parentDescContainer, parentDesc_VarName);
        desc_CodeGen.set_SchemaRelatedValues(null, schemaSet_ScopeStack, schemaSetScopeStack_OutVarName);

        codeBuilder = desc_CodeGen.generate_CreateDescriptor_w_FieldSetTuple(codeBuilder,
            buildingMatrixElemOrSchemaElem, create_InitialMatrixDescriptor, null, null);


        descriptorCode = codeBuilder.toString();
        assertNotNull(descriptorCode);



        //  Create DESCRIPTOR `TEST.CHILD`->FIELD.NAMES Desc ________________________________
        descTag = MPSymbols_DescTagName.FIELD$__$NAMES;

        label_Parts = new ArrayList<String>();

        buildingMatrixElemOrSchemaElem = MPSymbols.BuildingMatrixElementForSchema;  // LOOK! Field.names is a matrix descriptor, not a schema descriptor!!!
        create_InitialMatrixDescriptor = false;
        String testChild_Desc_VarName = desc_CodeGen.postGenerate_Get_DescriptorOutVarName();
        MatrixStructInfo_DescriptorContainer testChild_DescContainer = desc_CodeGen.postGenerate_Get_DescriptorContainer();
        desc_CodeGen = new DescriptorCreation_CodeGenerator(symbolControl, schemaControl, matrixControl, hierarchySettings,
                outputResults, baseIndentLevel);

        desc_CodeGen.set_PackageName(matrixPackage_Symbol);
        desc_CodeGen.set_SchemaOrMatrixName(schemaName);
        desc_CodeGen.set_DescriptorTag(MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, descTag);
        desc_CodeGen.set_Parent(testChild_DescContainer, testChild_Desc_VarName);
        desc_CodeGen.set_SchemaRelatedValues(null, schemaSet_ScopeStack, schemaSetScopeStack_OutVarName);

        // fieldSet settings:
        fieldValueExpr_List = new ArrayList<String>();
        fieldValueInfo_List = new ArrayList<FieldValueInfo>();
        fieldValueExpr_List.add("appControl.symbolControl.multiPartSymbol_Factory.createNew_DescTagName(\"Field1int\", 1, false, null, null)");
        fieldValueInfo_List.add(new FieldValueInfo());
        fieldValueExpr_List.add("appControl.symbolControl.multiPartSymbol_Factory.createNew_DescTagName(\"Field2String\", 1, false, null, null)");
        fieldValueInfo_List.add(new FieldValueInfo());

        expResult = null;
        codeBuilder = desc_CodeGen.generate_CreateDescriptor_w_FieldSetTuple(codeBuilder,
            buildingMatrixElemOrSchemaElem, create_InitialMatrixDescriptor, fieldValueExpr_List, fieldValueInfo_List);


        descriptorCode = codeBuilder.toString();
        assertNotNull(descriptorCode);


        //  Create DESCRIPTOR `TEST.CHILD`->FIELD.TYPES Desc ________________________________
        descTag = MPSymbols_DescTagName.FIELD$__$TYPES;

        label_Parts = new ArrayList<String>();

        buildingMatrixElemOrSchemaElem = MPSymbols.BuildingMatrixElementForSchema;  // LOOK! Field.names is a matrix descriptor, not a schema descriptor!!!
        create_InitialMatrixDescriptor = false;
        desc_CodeGen = new DescriptorCreation_CodeGenerator(symbolControl, schemaControl, matrixControl, hierarchySettings,
                outputResults, baseIndentLevel);

        desc_CodeGen.set_PackageName(matrixPackage_Symbol);
        desc_CodeGen.set_SchemaOrMatrixName(schemaName);
        desc_CodeGen.set_DescriptorTag(MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, descTag);
        desc_CodeGen.set_Parent(testChild_DescContainer, testChild_Desc_VarName);
        desc_CodeGen.set_SchemaRelatedValues(null, schemaSet_ScopeStack, schemaSetScopeStack_OutVarName);

        // fieldSet settings:
        fieldValueExpr_List = new ArrayList<String>();
        fieldValueInfo_List = new ArrayList<FieldValueInfo>();
        fieldValueExpr_List.add("MPSymbols.int$_sym_$");
        fieldValueInfo_List.add(new FieldValueInfo());
        fieldValueExpr_List.add("MPSymbols.String");
        fieldValueInfo_List.add(new FieldValueInfo());

        expResult = null;
        codeBuilder = desc_CodeGen.generate_CreateDescriptor_w_FieldSetTuple(codeBuilder,
            buildingMatrixElemOrSchemaElem, create_InitialMatrixDescriptor, fieldValueExpr_List, fieldValueInfo_List);








        //  Create DESCRIPTOR `TEST.CONT`________________________________
        descTag = MPSymbols_DescTagName.DESCRIPTOR;

        label_Parts = new ArrayList<String>();
        label_Parts.add("TEST");
        label_Parts.add("CONT");

        buildingMatrixElemOrSchemaElem = MPSymbols.BuildingSchemaElement;
        create_InitialMatrixDescriptor = false;
        parentDesc_VarName = matrix_CodeGen.postGenerate_Get_DescriptorOutVarName();
        parentDescContainer = matrixDescContainer;
        desc_CodeGen = new DescriptorCreation_CodeGenerator(symbolControl, schemaControl, matrixControl, hierarchySettings,
                outputResults, baseIndentLevel);

        desc_CodeGen.set_PackageName(matrixPackage_Symbol);
        desc_CodeGen.set_SchemaOrMatrixName(schemaName);
        desc_CodeGen.set_DescriptorTag(MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, descTag);
        desc_CodeGen.set_Label((Label)symbolControl.multiPartSymbol_Factory.createNew_Label(label_Parts, 1, true));
        desc_CodeGen.set_Parent(parentDescContainer, parentDesc_VarName);
        desc_CodeGen.set_SchemaRelatedValues(null, schemaSet_ScopeStack, schemaSetScopeStack_OutVarName);

        expResult = null;
        codeBuilder = desc_CodeGen.generate_CreateDescriptor_w_FieldSetTuple(codeBuilder,
            buildingMatrixElemOrSchemaElem, create_InitialMatrixDescriptor, null, null);


        descriptorCode = codeBuilder.toString();
        assertNotNull(descriptorCode);



        //  Create DESCRIPTOR `TEST.CONT`->FIELD.NAMES Desc ________________________________
        descTag = MPSymbols_DescTagName.FIELD$__$NAMES;

        label_Parts = new ArrayList<String>();

        buildingMatrixElemOrSchemaElem = MPSymbols.BuildingMatrixElementForSchema;  // LOOK! Field.names is a matrix descriptor, not a schema descriptor!!!
        create_InitialMatrixDescriptor = false;
        String testCont_Desc_VarName = desc_CodeGen.postGenerate_Get_DescriptorOutVarName();
        MatrixStructInfo_DescriptorContainer testCont_DescContainer = desc_CodeGen.postGenerate_Get_DescriptorContainer();
        desc_CodeGen = new DescriptorCreation_CodeGenerator(symbolControl, schemaControl, matrixControl, hierarchySettings,
                outputResults, baseIndentLevel);

        desc_CodeGen.set_PackageName(matrixPackage_Symbol);
        desc_CodeGen.set_SchemaOrMatrixName(schemaName);
        desc_CodeGen.set_DescriptorTag(MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, descTag);
        desc_CodeGen.set_Parent(testCont_DescContainer, testCont_Desc_VarName);
        desc_CodeGen.set_SchemaRelatedValues(null, schemaSet_ScopeStack, schemaSetScopeStack_OutVarName);

        // fieldSet settings:
        fieldValueExpr_List = new ArrayList<String>();
        fieldValueInfo_List = new ArrayList<FieldValueInfo>();
        fieldValueExpr_List.add("appControl.symbolControl.multiPartSymbol_Factory.createNew_DescTagName(\"field1int\", 1, false, null, null)");
        fieldValueInfo_List.add(new FieldValueInfo());
        fieldValueExpr_List.add("appControl.symbolControl.multiPartSymbol_Factory.createNew_DescTagName(\"field2ContInt\", 1, false, null, null)");
        fieldValueInfo_List.add(new FieldValueInfo());

        expResult = null;
        codeBuilder = desc_CodeGen.generate_CreateDescriptor_w_FieldSetTuple(codeBuilder,
            buildingMatrixElemOrSchemaElem, create_InitialMatrixDescriptor, fieldValueExpr_List, fieldValueInfo_List);


        descriptorCode = codeBuilder.toString();
        assertNotNull(descriptorCode);


        //  Create DESCRIPTOR `TEST.CONT`->FIELD.TYPES Desc ________________________________
        descTag = MPSymbols_DescTagName.FIELD$__$TYPES;

        label_Parts = new ArrayList<String>();

        buildingMatrixElemOrSchemaElem = MPSymbols.BuildingMatrixElementForSchema;  // LOOK! Field.names is a matrix descriptor, not a schema descriptor!!!
        create_InitialMatrixDescriptor = false;
        desc_CodeGen = new DescriptorCreation_CodeGenerator(symbolControl, schemaControl, matrixControl, hierarchySettings,
                outputResults, baseIndentLevel);

        desc_CodeGen.set_PackageName(matrixPackage_Symbol);
        desc_CodeGen.set_SchemaOrMatrixName(schemaName);
        desc_CodeGen.set_DescriptorTag(MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, descTag);
        desc_CodeGen.set_Parent(testCont_DescContainer, testCont_Desc_VarName);
        desc_CodeGen.set_SchemaRelatedValues(null, schemaSet_ScopeStack, schemaSetScopeStack_OutVarName);

        // fieldSet settings:
        fieldValueExpr_List = new ArrayList<String>();
        fieldValueInfo_List = new ArrayList<FieldValueInfo>();
        fieldValueExpr_List.add("MPSymbols.int$_sym_$");
        fieldValueInfo_List.add(new FieldValueInfo());
        fieldValueExpr_List.add("MPSymbols.ContinuationType$__$int");
        fieldValueInfo_List.add(new FieldValueInfo());

        expResult = null;
        codeBuilder = desc_CodeGen.generate_CreateDescriptor_w_FieldSetTuple(codeBuilder,
            buildingMatrixElemOrSchemaElem, create_InitialMatrixDescriptor, fieldValueExpr_List, fieldValueInfo_List);






        descriptorCode = codeBuilder.toString();
        assertNotNull(descriptorCode);
    System.out.println(descriptorCode);



        MatrixAndSchema_FileGenerator matrixFileGen = new MatrixAndSchema_FileGenerator(symbolControl);

        matrixFileGen._1_set_Package("net.unconventionalthinking.matrix");
        matrixFileGen._1_set_AppClassesPackage("net.unconventionalthinking.matrix");
        matrixFileGen._1_set_AppClassesName(hierarchySettings.appControl_ClassName);

        matrixFileGen._1_set_SchemaOrMatrixNameLabel(schemaName_Parts, 1);
        matrixFileGen._1_setCode_MatrixConstruction(codeBuilder);
        matrixFileGen._1_set_FileDirPath(hierarchySettings.generationTestProj_matrixPackage_Dir);
        matrixFileGen._2_addCode_SchemaClass(schemaSetScopeStack_OutVarName, matrix_OutVarName, "appControl", outputResults);
        matrixFileGen.writeToFile(hierarchySettings.DEBUG);


    }





    DescriptorCreation_CodeGenerator createSchemaDescriptorCode(List<String> schemaName, DescriptorTagName packageName, 
            CodeBuilder codeBuilder, String schemaSetScopeStack_OutVarName,
            SchemaSet_ScopeStack schemaSet_ScopeStack) throws Exception {

        CodeGen_OutputResults outputResults = new CodeGen_OutputResults();


        MatrixSet<SchemaInfo_Schema> usesSchema_Set = new MatrixSet<SchemaInfo_Schema>();
        usesSchema_Set.add(schemaControl.schemaForSchema_Container.schema4Schema);

        
        Symbol buildingMatrixElemOrSchemaElem = MPSymbols.BuildingSchemaElement;
        boolean create_InitialMatrixDescriptor = true;
        String parentDesc_VarName = null;
        MatrixStructInfo_DescriptorContainer parentDescContainer = null;
        DescriptorCreation_CodeGenerator desc_CodeGen = new DescriptorCreation_CodeGenerator(symbolControl, schemaControl, matrixControl, 
                hierarchySettings, outputResults, baseIndentLevel);

        desc_CodeGen.set_PackageName(packageName);
        desc_CodeGen.set_Label((Label)symbolControl.multiPartSymbol_Factory.createNew_Label(schemaName, 1, true));
        desc_CodeGen.set_Parent(parentDescContainer, parentDesc_VarName);
        desc_CodeGen.set_SchemaRelatedValues(usesSchema_Set, schemaSet_ScopeStack, schemaSetScopeStack_OutVarName);

        desc_CodeGen.generate_CreateDescriptor(codeBuilder, buildingMatrixElemOrSchemaElem, create_InitialMatrixDescriptor);
        String descriptorCode = codeBuilder.toString();


        return desc_CodeGen;

    }


}