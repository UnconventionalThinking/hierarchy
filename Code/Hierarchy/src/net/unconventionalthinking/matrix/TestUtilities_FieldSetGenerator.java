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

import net.unconventionalthinking.matrix.*;
import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.metacompiler.codefilegen.FieldSetTupleSpecialized_CodeGenerator;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.matrix.symbols.SymbolType;
import net.unconventionalthinking.hierarchy.Class_FileInfo;
import net.unconventionalthinking.utilities.FileUtilities;
import net.unconventionalthinking.hierarchy.HierarchyMetaCompiler;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author peterjoh
 */
public class TestUtilities_FieldSetGenerator {

    // we don't need the real thing right now. just a tester object to do testing with.
    private AppControl_Base appControl_MockObj;
    private ExecutionInfo executeInfo;
    private SymbolControl symbolControl;
    private SchemaControl schemaControl;
    private HierarchySettings hierarchySettings;

    private String fieldSet_Package;
    private String fieldSet_PackagePath_Relative;

    private String output_Dir;


    public TestUtilities_1_Schema schemaAndMatrix_Utilities;
    public TestUtilities_1_Schema2 schemaAndMatrix_Utilities_2;

    private SchemaInfo_Schema schemaForSchema;
    private SchemaInfo_Schema webForm_Schema;
    private SchemaInfo_Schema testSchema2;




    public TestUtilities_FieldSetGenerator(SymbolControl symbolControl, ExecutionInfo executeInfo, HierarchySettings hierarchySettings, 
            String fieldSet_Package, String output_Dir, TestUtilities_1_Schema schemaAndMatrix_Utilities, SchemaInfo_Schema webForm_Schema,
            TestUtilities_1_Schema2 schemaAndMatrix_Utilities_2, SchemaInfo_Schema testSchema2) throws Exception {

        this.appControl_MockObj = new AppControl_Simple();
        this.symbolControl = symbolControl;
        this.executeInfo = executeInfo;

        appControl_MockObj.executionInfo = executeInfo;
        appControl_MockObj.symbolControl = symbolControl;
        this.schemaControl = new SchemaControl(executeInfo, appControl_MockObj);
        this.hierarchySettings = hierarchySettings;

        this.fieldSet_Package = fieldSet_Package;
        this.hierarchySettings.appClasses_PackageName = fieldSet_Package;
        this.fieldSet_PackagePath_Relative = FileUtilities.convert_DotName_to_Path(fieldSet_Package);
        this.output_Dir = output_Dir;

        schemaForSchema = schemaControl.schemaForSchema;

        this.schemaAndMatrix_Utilities = schemaAndMatrix_Utilities;
        this.webForm_Schema = webForm_Schema;
        this.schemaAndMatrix_Utilities_2 = schemaAndMatrix_Utilities_2;
        this.testSchema2 = testSchema2;
    }
    
    public TestUtilities_FieldSetGenerator(SymbolControl symbolControl, ExecutionInfo executeInfo, String fieldSet_Package,
            String output_Dir) throws Exception {

        this.appControl_MockObj = new AppControl_Simple();
        this.symbolControl = symbolControl;
        this.executeInfo = executeInfo;
        
        appControl_MockObj.executionInfo = executeInfo;
        appControl_MockObj.symbolControl = symbolControl;
        this.schemaControl = new SchemaControl(executeInfo, appControl_MockObj);
        this.hierarchySettings = new HierarchySettings();


        this.fieldSet_Package = fieldSet_Package;
        this.hierarchySettings.appClasses_PackageName = fieldSet_Package;
        this.output_Dir = output_Dir;

        schemaForSchema = schemaControl.schemaForSchema;

        createTestSchemas();

    }

    private void createTestSchemas() throws Exception {

        schemaAndMatrix_Utilities = new TestUtilities_1_Schema(executeInfo, schemaControl, symbolControl);
        webForm_Schema = schemaAndMatrix_Utilities.buildTestSchema(0);

        schemaAndMatrix_Utilities_2 = new TestUtilities_1_Schema2(executeInfo, schemaControl, symbolControl);
        testSchema2 = schemaAndMatrix_Utilities_2.buildTestSchema(0);
    }
    public List<Class_FileInfo> generateTest_FieldSetCode() throws Exception_MetaCompilerError, IOException {
        return generateTest_FieldSetCode(false);
    }

    public List<Class_FileInfo> generateTest_FieldSetCode(boolean create_TestFieldSet_UsingUserTypes) throws Exception_MetaCompilerError, IOException {

        List<Class_FileInfo> fieldSet_ClassFileInfo_List = new ArrayList<Class_FileInfo>();



        //  FORM.REQUIRED fieldset defined the Web.Form schema _________________________________________________________
        String formRequired = "`FORM`.`REQUIRED`";
        SchemaInfo_Descriptor formRequired_SchemaInfoDesc = webForm_Schema.getChild_SchemaInfoDescriptor(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.multiPart.get_MultiPartSymbol_ByName(formRequired));


        FieldSetTupleSpecialized_CodeGenerator fieldSetCodeGen = new FieldSetTupleSpecialized_CodeGenerator(
                hierarchySettings, formRequired_SchemaInfoDesc.get_SchemaInfoFieldSet(executeInfo));
        CodeBuilder expResult = null;

        CodeBuilder result = fieldSetCodeGen.generate_Specialized_FieldSetTupleClass(executeInfo, fieldSet_Package, symbolControl);
        String fieldSetTuple_FormRequired_Code = result.toString();

        fieldSet_ClassFileInfo_List.add(new Class_FileInfo(null, fieldSet_PackagePath_Relative,
                fieldSetCodeGen.getFieldSetTuple_TypeName() + ".java", fieldSet_Package, fieldSetCodeGen.getFieldSetTuple_TypeName()));

        FileUtilities.writeToFile(output_Dir,
            formRequired_SchemaInfoDesc.get_SchemaInfoFieldSet(executeInfo).get_FieldSetTypeString() + ".java", true,
            fieldSetTuple_FormRequired_Code, hierarchySettings.DEBUG);



        //  Test a fieldset with continuation and NO other fields  _____________________________________________________
        //  result: only 1 constructor should be created with no parameters for fields passed in. Just the continuation list should be created
        SchemaInfo_Descriptor descriptorDescriptor_SchemaInfoDesc = schemaForSchema.getChild_SchemaInfoDescriptor(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.getSingleSymbol_ByName("DESCRIPTOR") );
        SchemaInfo_Descriptor fieldTypes_SchemaInfo_Descriptor =  (SchemaInfo_Descriptor)  ((Descriptor)descriptorDescriptor_SchemaInfoDesc).get_ChildDescriptor(executeInfo,
                (Label)symbolControl.labels_Index.multiPart.get_MultiPartSymbol_ByName("`FIELD`.`TYPES`"));

        fieldSetCodeGen = new FieldSetTupleSpecialized_CodeGenerator(hierarchySettings,
                fieldTypes_SchemaInfo_Descriptor.get_SchemaInfoFieldSet(executeInfo));

        result = fieldSetCodeGen.generate_Specialized_FieldSetTupleClass(executeInfo, fieldSet_Package, symbolControl);
        String fieldSetTuple_fieldTypes_Code = result.toString();
        fieldSet_ClassFileInfo_List.add(new Class_FileInfo(null, fieldSet_PackagePath_Relative,
                fieldSetCodeGen.getFieldSetTuple_TypeName() + ".java", fieldSet_Package, fieldSetCodeGen.getFieldSetTuple_TypeName()));


        FileUtilities.writeToFile(output_Dir,
            fieldTypes_SchemaInfo_Descriptor.get_SchemaInfoFieldSet(executeInfo).get_FieldSetTypeString() + ".java", true,
            fieldSetTuple_fieldTypes_Code, hierarchySettings.DEBUG);



        //  MY_DESC.NUM1 - field set defined in the test schema
        //  has a primtive continuation ________________________________________________________________________________
        String myDescNum1 = "`MY_DESC`.`NUM1`";
        SchemaInfo_Descriptor myDescNum1_SchemaInfoDesc = testSchema2.getChild_SchemaInfoDescriptor(executeInfo,
                (DescriptorTagName)symbolControl.descTagNames_Index.multiPart.get_MultiPartSymbol_ByName(myDescNum1));

        fieldSetCodeGen = new FieldSetTupleSpecialized_CodeGenerator(hierarchySettings,
                myDescNum1_SchemaInfoDesc.get_SchemaInfoFieldSet(executeInfo));

        result = fieldSetCodeGen.generate_Specialized_FieldSetTupleClass(executeInfo, fieldSet_Package, symbolControl);
        String fieldSetTuple_myDescNum1_Code = result.toString();
        fieldSet_ClassFileInfo_List.add(new Class_FileInfo(null, fieldSet_PackagePath_Relative,
                fieldSetCodeGen.getFieldSetTuple_TypeName() + ".java", fieldSet_Package, fieldSetCodeGen.getFieldSetTuple_TypeName()));

        FileUtilities.writeToFile(output_Dir,
            myDescNum1_SchemaInfoDesc.get_SchemaInfoFieldSet(executeInfo).get_FieldSetTypeString() + ".java", true,
            fieldSetTuple_myDescNum1_Code, hierarchySettings.DEBUG);


        //  MY_DESC.NUM2 - field set defined in the test schema
        //  has a user types ________________________________________________________________________________
        if (create_TestFieldSet_UsingUserTypes) {
            String myDescNum2 = "`MY_DESC`.`NUM2`";
            SchemaInfo_Descriptor myDescNum2_SchemaInfoDesc = testSchema2.getChild_SchemaInfoDescriptor(executeInfo,
                    (DescriptorTagName)symbolControl.descTagNames_Index.multiPart.get_MultiPartSymbol_ByName(myDescNum2));

            fieldSetCodeGen = new FieldSetTupleSpecialized_CodeGenerator(hierarchySettings,
                    myDescNum2_SchemaInfoDesc.get_SchemaInfoFieldSet(executeInfo));

            result = fieldSetCodeGen.generate_Specialized_FieldSetTupleClass(executeInfo, fieldSet_Package, symbolControl);
            String fieldSetTuple_myDescNum2_Code = result.toString();
            fieldSet_ClassFileInfo_List.add(new Class_FileInfo(null, fieldSet_PackagePath_Relative,
                fieldSetCodeGen.getFieldSetTuple_TypeName() + ".java", fieldSet_Package, fieldSetCodeGen.getFieldSetTuple_TypeName()));

            FileUtilities.writeToFile(output_Dir,
                myDescNum2_SchemaInfoDesc.get_SchemaInfoFieldSet(executeInfo).get_FieldSetTypeString() + ".java", true,
                fieldSetTuple_myDescNum2_Code, hierarchySettings.DEBUG);
        }


        
        return fieldSet_ClassFileInfo_List;
    }
}
