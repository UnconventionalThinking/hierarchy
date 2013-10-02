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



import java.io.File;
import net.unconventionalthinking.matrix.*;
import net.unconventionalthinking.lang.Boolean_Mutable;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.metacompiler.codefilegen.AppControlFile_Generator;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.matrix.symbols.Symbol_Single;
import net.unconventionalthinking.matrix.symbols.Symbol_Single_Factory;
import java.util.List;

import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.MPSymbols_DescTagName;
import net.unconventionalthinking.matrix.symbols.SymbolType;
import net.unconventionalthinking.hierarchy.AppControl_Info;
import net.unconventionalthinking.hierarchy.Class_FileInfo;
import net.unconventionalthinking.utilities.FileUtilities;
import net.unconventionalthinking.hierarchy.Exception_HierarchyCompiler;
import net.unconventionalthinking.hierarchy.HierarchyMetaCompiler;
import net.unconventionalthinking.hierarchy.HierarchyMetaCompilerUtilities_Compiler;
import net.unconventionalthinking.hierarchy.HierarchyMetaCompilerUtilities_MetaCompiler;
import net.unconventionalthinking.hierarchy.HierarchyMetaCompilerUtilities;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import net.unconventionalthinking.reflection.MethodInvoker;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import net.unconventionalthinking.utilities.FileUtilities_Delete;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * This testgenerator outputs it's generated files to /testout
 * ** in the testout dir, you need to have two files already there!
 *   1. FieldSetTupleSpecialized_Test.java
 *   2. FieldSet_TestUtilities.java
 *
 * This will also be dynamically compiled along with all the generated fieldset code (why? because the fieldsettupleSpecailzed_Test depends on these files).
 * 
 * the generated FieldSet_Tuple classes (such as FieldSetTuple__SCHEMA$___$FORM$__$REQUIRED) need to also be in the net.unconventionalthinking.matrix package,
 * for the same reason (to access protected members).
 *
 * @author peterjoh
 */
public class _10_FieldSetTupleSpecialized_TestGenerator_Test {

    // we don't need the real thing right now. just a tester object to do testing with.
    private static AppControl_Base appControl_MockObj;

    private static ExecutionInfo executeInfo = new ExecutionInfo();
    private static SymbolControl symbolControl;
    private static SchemaControl schemaControl;
    private static HierarchySettings hierarchySettings;


    private static SchemaInfo_FieldSet schemaInfoFieldSet_formRequired;


    private static SchemaInfo_FieldSet mock_schemaInfoFieldSet_fieldTypes;
    private static SchemaInfo_FieldSet mock_schemaInfoFieldSet_descNum1;
    private static Symbol intContinuationType;

    private static SchemaInfo_Schema webForm_Schema;
    private static SchemaInfo_Schema testSchema2;



    private static final String matrixPackage = "net.unconventionalthinking.matrix";


    private static final String Test_SrcDir =
            HierarchySettings.Matrix_Projects_Dir + "/Hierarchy/test";
    private static final String Test_MatrixPackage_Dir =
            HierarchySettings.Matrix_Projects_Dir + "/Hierarchy/test/net/unconventionalthinking/matrix";
    private static final String TestOut_SrcDir =
            HierarchySettings.Matrix_Projects_Dir + "/Hierarchy/testout";
    private static final String TestOut_MatrixPackage_Dir =
            HierarchySettings.Matrix_Projects_Dir + "/Hierarchy/testout/net/unconventionalthinking/matrix";

    private static String hierarchyJar_Dir =  HierarchySettings.test_HierarchyJar_Dir;
    private static String javac_Dir = HierarchySettings.test_Javac_Dir;

    private static String JunitLib_Path = HierarchySettings.Matrix_Projects_Dir + "/lib/junit-4.6.jar";



//    public static void main(String[] args) throws Exception {


    @Test
    public void testMain() throws Throwable {

        appControl_MockObj = new AppControl_Simple();
        symbolControl = new SymbolControl();
        symbolControl.intialize_All_MPSymbols();
        appControl_MockObj.executionInfo = executeInfo;
        appControl_MockObj.symbolControl = symbolControl;

        schemaControl = new SchemaControl(executeInfo, appControl_MockObj);
        hierarchySettings = new HierarchySettings();


        //  Form Required init
        TestUtilities_1_Schema schemaAndMatrix_Utilities = new TestUtilities_1_Schema(executeInfo, schemaControl, symbolControl);
        schemaAndMatrix_Utilities.set_SchemaPackage(MPSymbols_DescTagName.net$__$unconventionalthinking$__$matrix$__$schema);
        webForm_Schema = schemaAndMatrix_Utilities.buildTestSchema(0);

        TestUtilities_1_Schema2 schemaAndMatrix_Utilities_2 = new TestUtilities_1_Schema2(executeInfo, schemaControl, symbolControl);
        schemaAndMatrix_Utilities_2.set_SchemaPackage(MPSymbols_DescTagName.net$__$unconventionalthinking$__$matrix$__$schema);
        testSchema2 = schemaAndMatrix_Utilities_2.buildTestSchema(0);


        DescriptorTagName formRequired = (DescriptorTagName)symbolControl.descTagNames_Index.multiPart.get_MultiPartSymbol_ByName("`FORM`.`REQUIRED`");
        schemaInfoFieldSet_formRequired = webForm_Schema.getChild_SchemaInfoDescriptor(executeInfo, formRequired).get_SchemaInfoFieldSet(executeInfo);


        //  Here's a mock version of the formRequired schemaInfo    _FieldSet. Just keep this around for an example of how to do it.
        /*
        SchemaInfo_FieldSet mock_schemaInfoFieldSet = new SchemaInfo_FieldSet(executeInfo, null);
        List<SchemaInfo_Field> fields_List = mock_schemaInfoFieldSet.get_SchemaInfoFields();

        fields_List.add(new SchemaInfo_Field(executeInfo, 0, mock_schemaInfoFieldSet, null, null, symbolControl, "Is Required field", notRequired));
        fields_List.add(new SchemaInfo_Field(executeInfo, 1, mock_schemaInfoFieldSet, null, null, symbolControl, "Required Image Path field", "/images/req.gif"));
        fields_List.add(new SchemaInfo_Field(executeInfo, 2, mock_schemaInfoFieldSet, null, null, symbolControl, "height", 11));
        mock_schemaInfoFieldSet.num_NonContinuationFields = 4;

        formRequired_FieldSet.schemaInfo_Positioned = mock_schemaInfoFieldSet;
        */



		//  Field Types init
		List<String> intCont_SymbolStrings = new ArrayList<String>();
		intCont_SymbolStrings.add(MPSymbols.ContinuationType.toString());
		intCont_SymbolStrings.add(MPSymbols.int$_sym_$.toString());
		intContinuationType = symbolControl.multiPartSymbol_Factory.createNew(intCont_SymbolStrings, 1, false);


        //  mock schemaInfo object for FIELD.TYPES
        mock_schemaInfoFieldSet_fieldTypes = new SchemaInfo_FieldSet(executeInfo, null);
        List<SchemaInfo_Field> fields_List = mock_schemaInfoFieldSet_fieldTypes.get_SchemaInfoFields();
        SchemaInfo_Field contField = new SchemaInfo_Field(executeInfo, 0, mock_schemaInfoFieldSet_fieldTypes, null, null, symbolControl, "DescTagName continuation", MPSymbols.boolean$_sym_$);
        contField.is_Continuation_Field = true;  // I don't know if this is enough. may need to pass in the type as a contiunation type in field constructor
        fields_List.add(contField);

        mock_schemaInfoFieldSet_fieldTypes.num_NonContinuationFields = 0;
        mock_schemaInfoFieldSet_fieldTypes.has_ContinuationField = true;




        //  mock schemaInfo object for DESC.NUM1
        mock_schemaInfoFieldSet_descNum1 = new SchemaInfo_FieldSet(executeInfo, null);
        fields_List = mock_schemaInfoFieldSet_descNum1.get_SchemaInfoFields();
        SchemaInfo_Field field = new SchemaInfo_Field(executeInfo, 0, mock_schemaInfoFieldSet_descNum1, null, MPSymbols.String, symbolControl, "field1 string", "hi");
        field.is_Continuation_Field = true;
        fields_List.add(field);
        field = new SchemaInfo_Field(executeInfo, 1, mock_schemaInfoFieldSet_descNum1, null, MPSymbols.short$_sym_$, symbolControl, "field2 short");
        field.setDefaultValue_short((short)-1001);
        field.is_Continuation_Field = true;
        fields_List.add(field);
        field = new SchemaInfo_Field(executeInfo, 2, mock_schemaInfoFieldSet_descNum1, null, intContinuationType, symbolControl, "field3 continuation int");
        field.setDefaultValue_int(-1000);
        field.is_Continuation_Field = true;
        fields_List.add(field);

        mock_schemaInfoFieldSet_descNum1.num_NonContinuationFields = 2;
        mock_schemaInfoFieldSet_descNum1.has_ContinuationField = true;


        //  Clean out the testout/net/unconventionalthinking/matrix directory
        FileUtilities_Delete.deleteFilesInDir(TestOut_MatrixPackage_Dir);
        //  Copy the FieldSet_TestUtilities.java file and the FieldSetTupleSpecialized_Test.java into the testout/com/... dir
        FileUtilities.copyFilesInDir(TestOut_SrcDir, TestOut_MatrixPackage_Dir, true);


        //  Generate the fieldSet code from the test schemas
        TestUtilities_FieldSetGenerator fieldSetCodeGen_TestUtilities = new TestUtilities_FieldSetGenerator(symbolControl, executeInfo, hierarchySettings,
                matrixPackage, TestOut_MatrixPackage_Dir, schemaAndMatrix_Utilities, webForm_Schema, schemaAndMatrix_Utilities_2, testSchema2);


        //  Generate the symbol files
        HierarchyMetaCompilerUtilities_Compiler compilerUtilities = new HierarchyMetaCompilerUtilities_Compiler(hierarchySettings);
        HierarchyMetaCompilerUtilities_MetaCompiler metaCompilerUtilities = new HierarchyMetaCompilerUtilities_MetaCompiler(hierarchySettings);


        metaCompilerUtilities.generateAll_SymbolFiles(matrixPackage, TestOut_SrcDir, symbolControl);


        //  Generate the fieldSetCode that uses the symbol files
        List<Class_FileInfo> fieldSet_NameList = fieldSetCodeGen_TestUtilities.generateTest_FieldSetCode();
        Set<AppControl_Info> externalAppControl_Set = new HashSet<AppControl_Info>();
        //  Generate the initializer file
        metaCompilerUtilities.generate_AppControl(matrixPackage, TestOut_SrcDir, hierarchySettings.appControl_ClassName + ".java",
                externalAppControl_Set, null, null,  fieldSet_NameList);


        //  Compile symbols
        compilerUtilities.compileAll_SymbolFiles(TestOut_MatrixPackage_Dir, TestOut_SrcDir, hierarchyJar_Dir,
                javac_Dir);

        
        //  Compile fieldsets (which use the symbol files)

        for (Class_FileInfo fieldSet_ClassFileInfo : fieldSet_NameList) {
            compilerUtilities.compileFile(TestOut_MatrixPackage_Dir, fieldSet_ClassFileInfo.className + ".java",
                    javac_Dir, TestOut_SrcDir, true, hierarchyJar_Dir + "/Hierarchy.jar" + File.pathSeparator + TestOut_SrcDir);
        }
        

        //  Compile Initializer
        compilerUtilities.compileFile(TestOut_MatrixPackage_Dir, hierarchySettings.appControl_ClassName + ".java",
                javac_Dir, TestOut_SrcDir, true, hierarchyJar_Dir + "/Hierarchy.jar" + File.pathSeparator + TestOut_SrcDir);

        //  Compile the field Set tester
        compilerUtilities.compileFile(TestOut_MatrixPackage_Dir, "FieldSet_TestUtilities.java",
                javac_Dir, TestOut_SrcDir, true, hierarchyJar_Dir + "/Hierarchy.jar" + File.pathSeparator + TestOut_SrcDir + File.pathSeparator + JunitLib_Path);
        compilerUtilities.compileFile(TestOut_MatrixPackage_Dir, "FieldSetTupleSpecialized_Test.java",
                javac_Dir, TestOut_SrcDir, true, hierarchyJar_Dir + "/Hierarchy.jar" + File.pathSeparator + TestOut_SrcDir + File.pathSeparator + JunitLib_Path);



        
        Class fieldSet_TesterClass = Class.forName("net.unconventionalthinking.matrix.FieldSetTupleSpecialized_Test");
        Object fieldSet_TesterObj = fieldSet_TesterClass.newInstance();

        boolean hadError = false;

        try {
            Boolean_Mutable methodThrewException = new Boolean_Mutable(false);
            Object retVal;
            
            retVal = HierarchyMetaCompilerUtilities.invokeMethod(fieldSet_TesterObj, fieldSet_TesterClass, "init", methodThrewException,
                    new Class[] { SymbolControl.class,  SchemaInfo_Schema.class}, new Object[] {symbolControl, webForm_Schema});
            hadError = hadError || methodThrewException.value;

            methodThrewException.value = false;
            retVal = HierarchyMetaCompilerUtilities.invokeMethod(fieldSet_TesterObj, fieldSet_TesterClass, "test_getAndSetFieldName_Methods", methodThrewException);
            if (methodThrewException.value) throw (Exception)retVal;

            methodThrewException.value = false;
            retVal = HierarchyMetaCompilerUtilities.invokeMethod(fieldSet_TesterObj, fieldSet_TesterClass, "test_getAndSetFieldName_ObjectContinuation", methodThrewException);
            if (methodThrewException.value) throw (Exception)retVal;

            methodThrewException.value = false;
            retVal = HierarchyMetaCompilerUtilities.invokeMethod(fieldSet_TesterObj, fieldSet_TesterClass, "test_getAndSetFieldName_PrimitiveTypeContinuation", methodThrewException);
            if (methodThrewException.value) throw (Exception)retVal;

            methodThrewException.value = false;
            retVal = HierarchyMetaCompilerUtilities.invokeMethod(fieldSet_TesterObj, fieldSet_TesterClass, "test_getAndSet_ByIndex_GenericMethods", methodThrewException);
            if (methodThrewException.value) throw (Exception)retVal;

            methodThrewException.value = false;
            retVal = HierarchyMetaCompilerUtilities.invokeMethod(fieldSet_TesterObj, fieldSet_TesterClass, "test_getAndSet_ByIndex_TypedMethods", methodThrewException);
            if (methodThrewException.value) throw (Exception)retVal;

            methodThrewException.value = false;
            retVal = HierarchyMetaCompilerUtilities.invokeMethod(fieldSet_TesterObj, fieldSet_TesterClass, "test_getAndSet_ByFieldName_GenericMethods", methodThrewException);
            if (methodThrewException.value) throw (Exception)retVal;

            methodThrewException.value = false;
            retVal = HierarchyMetaCompilerUtilities.invokeMethod(fieldSet_TesterObj, fieldSet_TesterClass, "test_getAndSet_ByFieldName_TypedMethods", methodThrewException);
            if (methodThrewException.value) throw (Exception)retVal;

        } catch (Exception_HierarchyCompiler e) {
            throw e.getCause();
//            hadError = true;

        } catch (Exception e) {
            hadError = true;
        
        }

        assertFalse(hadError);



    }


}