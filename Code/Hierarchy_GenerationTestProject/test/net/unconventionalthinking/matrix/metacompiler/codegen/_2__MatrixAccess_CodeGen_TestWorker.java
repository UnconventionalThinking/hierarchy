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

package net.unconventionalthinking.matrix.metacompiler.codegen;


import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.matrix.MatrixControl;
import net.unconventionalthinking.matrix.SchemaControl;
import net.unconventionalthinking.matrix.symbols.DescriptorTag;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.MPSymbols_DescTagName;
import net.unconventionalthinking.matrix.symbols.MPSymbols_SchemaName;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.matrix.symbols.Symbol_Base;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import net.unconventionalthinking.hierarchy.langsymboltable.MatrixAccessState;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;


/**
 *
 * @author peterjoh
 */
public class _2__MatrixAccess_CodeGen_TestWorker {


    public static DescriptorAccess_CodeGenerator generate_MatrixAccess(String matrixClassNameFull, String embeddedFile_ClassName,
            String packageName,
            boolean is_StaticAccess, boolean test_FieldAccess,
            boolean is_SingleAccess, String dynAccess_ClassName, List<CodeBuilder> codeBuildersList_AccessMethods,
            List<CodeBuilder> codeBuildersList_AccessMethods__Dyn, List<CodeBuilder> codeBuildersList_AccessMethods__All,
            CodeBuilder codeBuilder_Access, AnnotationCall_CodeGenerator_Std annotation_CodeGen,
            SymbolControl symbolControl, SchemaControl schemaControl, MatrixControl matrixControl, HierarchySettings hierarchySettings,
            CodeGen_OutputResults outputResults)
            throws Exception {


        DescriptorAccess_CodeGenerator descriptorAccess_CodeGenerator = new DescriptorAccess_CodeGenerator(symbolControl, schemaControl, matrixControl,
                1, hierarchySettings, outputResults);

        descriptorAccess_CodeGenerator.set_1_PackageInfo(packageName, null);
        descriptorAccess_CodeGenerator.set_1_CodeBuilders(codeBuildersList_AccessMethods, codeBuildersList_AccessMethods__Dyn,
                codeBuildersList_AccessMethods__All, codeBuilder_Access);
        descriptorAccess_CodeGenerator.set_1_EmbeddedFile_ClassName(embeddedFile_ClassName);
        descriptorAccess_CodeGenerator.set_1_AccessMethodClass_Name(dynAccess_ClassName);
        descriptorAccess_CodeGenerator.set_1_AnnotationInfo(annotation_CodeGen);




        String rootAccessor_Expr = matrixClassNameFull;
        boolean rootAccessorExpr_is_Identifier = true;

        List<DescriptorAccess_ChildAccessInfo> childAccessInfo_List = new ArrayList<DescriptorAccess_ChildAccessInfo>();


        DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed typeOfElementAccessed = null;
        if (is_SingleAccess)
            typeOfElementAccessed = DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.Descriptor;
        else
            typeOfElementAccessed = DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.DescriptorSet;
        short numberOfExpresions = 1;

        String accessExrp1 = "AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED";
        boolean accessExrp1_Is_Static_DescTag = true;
        boolean accessExrp1_Is_Static_DescTagName = false;
        boolean accessExrp1_Is_Static_Label = false;
        String accessExrp1_DescTagName_String = "FORM.REQUIRED";
        DescriptorTagName descTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(accessExrp1_DescTagName_String, 1,
                true, null, null);
        Symbol_Base accessExrp1_DescTagOrLabel_Actual = symbolControl.multiLevelSymbol_Factory.createNew_DescriptorTag(
                MPSymbols_DescTagName.net$__$unconventionalthinking$__$matrix, MPSymbols_DescTagName.WEB$__$FORM, descTagName, true);



        boolean annotationReference_Exists = false;
        String annotationReference = null;
        String annotationReference_no_Star = null;
        
        DescriptorAccess_ChildAccessInfo formRequiredAccess = new DescriptorAccess_ChildAccessInfo(is_StaticAccess, typeOfElementAccessed,
                numberOfExpresions, is_SingleAccess);
        formRequiredAccess.set_AccessExpression1(accessExrp1, accessExrp1_Is_Static_DescTag, accessExrp1_Is_Static_DescTagName,
                accessExrp1_Is_Static_Label, 
                Arrays.asList(((DescriptorTag)accessExrp1_DescTagOrLabel_Actual).getDescTagName().getSymbolNames()),
                accessExrp1_DescTagOrLabel_Actual);
        childAccessInfo_List.add(formRequiredAccess);



        accessExrp1 = "AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$TEST$__$CHILD";
        accessExrp1_Is_Static_DescTag = true;
        accessExrp1_Is_Static_DescTagName = false;
        accessExrp1_Is_Static_Label = false;
        accessExrp1_DescTagName_String = "TEST.CHILD";
        descTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(accessExrp1_DescTagName_String, 1,
                true, null, null);
        accessExrp1_DescTagOrLabel_Actual = symbolControl.multiLevelSymbol_Factory.createNew_DescriptorTag(
                MPSymbols_DescTagName.net$__$unconventionalthinking$__$matrix, MPSymbols_DescTagName.WEB$__$FORM, descTagName, true);

        DescriptorAccess_ChildAccessInfo testChildAccess = new DescriptorAccess_ChildAccessInfo(is_StaticAccess, typeOfElementAccessed,
                numberOfExpresions, is_SingleAccess);
        testChildAccess.set_AccessExpression1(accessExrp1, accessExrp1_Is_Static_DescTag, accessExrp1_Is_Static_DescTagName,
                accessExrp1_Is_Static_Label,
                Arrays.asList(((DescriptorTag)accessExrp1_DescTagOrLabel_Actual).getDescTagName().getSymbolNames()),
                accessExrp1_DescTagOrLabel_Actual);
        childAccessInfo_List.add(testChildAccess);


        if (test_FieldAccess) {

            if (is_SingleAccess)
                typeOfElementAccessed = DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.Field;
            else
                typeOfElementAccessed = DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.FieldValueSet;


            accessExrp1 = "AppSymbols_DescTagName.Field1int";
            accessExrp1_Is_Static_DescTag = false;
            accessExrp1_Is_Static_DescTagName = true;
            accessExrp1_Is_Static_Label = false;
            List<String> accessExrp1_SymbolParts = new ArrayList<String>();

            accessExrp1_SymbolParts.add("Field1int");
            accessExrp1_DescTagOrLabel_Actual = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(accessExrp1_SymbolParts, 1, true);

            DescriptorAccess_ChildAccessInfo field1Access = new DescriptorAccess_ChildAccessInfo(is_StaticAccess, typeOfElementAccessed,
                    numberOfExpresions, is_SingleAccess);
            field1Access.set_AccessExpression1(accessExrp1, accessExrp1_Is_Static_DescTag, accessExrp1_Is_Static_DescTagName, 
                    accessExrp1_Is_Static_Label, accessExrp1_SymbolParts, accessExrp1_DescTagOrLabel_Actual);
            childAccessInfo_List.add(field1Access);



        }




        descriptorAccess_CodeGenerator.set_3_RootAccessorInfo(rootAccessor_Expr, rootAccessorExpr_is_Identifier, is_StaticAccess);
        descriptorAccess_CodeGenerator.set_3_ChildAccessInfo(childAccessInfo_List);

        descriptorAccess_CodeGenerator.generate_MartrixAccess_Method(outputResults);

//    System.out.println(codeBuildersList_AccessMethods);
//    System.out.println("\n\n");
//    System.out.println(codeBuilder_Access);

        return descriptorAccess_CodeGenerator;
    }




    public static void generate_MatrixAccess_ContinuationField(String matrixName, String embeddedFile_ClassName, String packageName,
            boolean is_StaticAccess, boolean test_FieldAccess, String dynAccess_ClassName, List<CodeBuilder> codeBuildersList_AccessMethods,
            List<CodeBuilder> codeBuildersList_AccessMethods__Dyn, List<CodeBuilder> codeBuildersList_AccessMethods__All,
            CodeBuilder codeBuilder_Access,  AnnotationCall_CodeGenerator_Std annotation_CodeGen,
            SymbolControl symbolControl, SchemaControl schemaControl, MatrixControl matrixControl, HierarchySettings hierarchySettings,
            CodeGen_OutputResults outputResults)
            throws Exception {


        DescriptorAccess_CodeGenerator descriptorAccess_CodeGenerator = new DescriptorAccess_CodeGenerator(symbolControl, schemaControl, matrixControl,
                1, hierarchySettings, outputResults);

        descriptorAccess_CodeGenerator.set_1_PackageInfo(packageName, null);
        descriptorAccess_CodeGenerator.set_1_CodeBuilders(codeBuildersList_AccessMethods, codeBuildersList_AccessMethods__Dyn,
                codeBuildersList_AccessMethods__All, codeBuilder_Access);
        descriptorAccess_CodeGenerator.set_1_EmbeddedFile_ClassName(embeddedFile_ClassName);
        descriptorAccess_CodeGenerator.set_1_AccessMethodClass_Name(dynAccess_ClassName);
        descriptorAccess_CodeGenerator.set_1_AnnotationInfo(annotation_CodeGen);



        String rootAccessor_Expr = matrixName;
        boolean rootAccessorExpr_is_Identifier = true;

        List<DescriptorAccess_ChildAccessInfo> childAccessInfo_List = new ArrayList<DescriptorAccess_ChildAccessInfo>();


        DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed typeOfElementAccessed =
                DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.Descriptor;
        short numberOfExpresions = 1;
        boolean is_SingleAccess = true;

        String accessExrp1 = "AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$TEST$__$CONT";
        boolean accessExrp1_Is_Static_DescTag = true;
        boolean accessExrp1_Is_Static_DescTagName = false;
        boolean accessExrp1_Is_Static_Label = false;
        String accessExrp1_DescTagName_String = "TEST.CONT";
        DescriptorTagName descTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(accessExrp1_DescTagName_String, 1,
                true, null, null);
        Symbol_Base accessExrp1_DescTagOrLabel_Actual = symbolControl.multiLevelSymbol_Factory.createNew_DescriptorTag(
                MPSymbols_DescTagName.net$__$unconventionalthinking$__$matrix, MPSymbols_DescTagName.WEB$__$FORM, descTagName, true);

        DescriptorAccess_ChildAccessInfo myDescNum1_Access = new DescriptorAccess_ChildAccessInfo(is_StaticAccess, typeOfElementAccessed,
                numberOfExpresions, is_SingleAccess);
        myDescNum1_Access.set_AccessExpression1(accessExrp1, accessExrp1_Is_Static_DescTag, accessExrp1_Is_Static_DescTagName, accessExrp1_Is_Static_Label,
                Arrays.asList(((DescriptorTag)accessExrp1_DescTagOrLabel_Actual).getDescTagName().getSymbolNames()),
                accessExrp1_DescTagOrLabel_Actual);
        childAccessInfo_List.add(myDescNum1_Access);


        if (test_FieldAccess) {

            typeOfElementAccessed = DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.Field;

            accessExrp1 = "AppSymbols_DescTagName.field2ContInt";
            accessExrp1_Is_Static_DescTag = false;
            accessExrp1_Is_Static_DescTagName = true;
            accessExrp1_Is_Static_Label = false;
            List<String> accessExrp1_SymbolParts = new ArrayList<String>();

            accessExrp1_SymbolParts.add("field2ContInt");
            accessExrp1_DescTagOrLabel_Actual = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(accessExrp1_SymbolParts, 1, true);


            String accessExpr2 = "2";
            boolean accessExpr2_Is_Static_Label = false;
            List<String> accessExpr2_LabelParts = null;
            Label accessExpr2_Label_Actual = null;

            boolean accessExpr2_Is_ContinuationIndex = true;


            DescriptorAccess_ChildAccessInfo field1Access = new DescriptorAccess_ChildAccessInfo(is_StaticAccess, typeOfElementAccessed,
                    numberOfExpresions, is_SingleAccess);
            field1Access.set_AccessExpression1(accessExrp1, accessExrp1_Is_Static_DescTag, accessExrp1_Is_Static_DescTagName, accessExrp1_Is_Static_Label,
                    accessExrp1_SymbolParts, accessExrp1_DescTagOrLabel_Actual);
            field1Access.set_AccessExpression2(accessExpr2, accessExpr2_Is_Static_Label, accessExpr2_LabelParts, accessExpr2_Label_Actual, 
                    accessExpr2_Is_ContinuationIndex);

            childAccessInfo_List.add(field1Access);
        }



        descriptorAccess_CodeGenerator.set_3_RootAccessorInfo(rootAccessor_Expr, rootAccessorExpr_is_Identifier, is_StaticAccess);
        descriptorAccess_CodeGenerator.set_3_ChildAccessInfo(childAccessInfo_List);

        descriptorAccess_CodeGenerator.generate_MartrixAccess_Method(outputResults);

    }




    public static void generate_MatrixAccess_ContinuedAccess(MatrixAccessState matrixAccessState, String rootAccessor_Expr, String embeddedFile_ClassName,
            String packageName,
            boolean is_StaticAccess, boolean test_FieldAccess,
            boolean is_SingleAccess, String dynAccess_ClassName, List<CodeBuilder> codeBuildersList_AccessMethods,
            List<CodeBuilder> codeBuildersList_AccessMethods__Dyn, List<CodeBuilder> codeBuildersList_AccessMethods__All,
            CodeBuilder codeBuilder_Access, AnnotationCall_CodeGenerator_Std annotation_CodeGen,
            SymbolControl symbolControl, SchemaControl schemaControl, MatrixControl matrixControl, HierarchySettings hierarchySettings,
            CodeGen_OutputResults outputResults)
            throws Exception {


        DescriptorAccess_CodeGenerator descriptorAccess_CodeGenerator = new DescriptorAccess_CodeGenerator(symbolControl, schemaControl, matrixControl,
                1, hierarchySettings, outputResults);

        descriptorAccess_CodeGenerator.set_1_PackageInfo(packageName, null);
        descriptorAccess_CodeGenerator.set_1_CodeBuilders(codeBuildersList_AccessMethods, codeBuildersList_AccessMethods__Dyn,
                codeBuildersList_AccessMethods__All, codeBuilder_Access);
        descriptorAccess_CodeGenerator.set_1_EmbeddedFile_ClassName(embeddedFile_ClassName);
        descriptorAccess_CodeGenerator.set_1_AccessMethodClass_Name(dynAccess_ClassName);
        descriptorAccess_CodeGenerator.set_1_AnnotationInfo(annotation_CodeGen);


        descriptorAccess_CodeGenerator.set_2_ContinuedAccess_MatrixAccessState(true, matrixAccessState);



        boolean rootAccessorExpr_is_Identifier = true;

        List<DescriptorAccess_ChildAccessInfo> childAccessInfo_List = new ArrayList<DescriptorAccess_ChildAccessInfo>();


        DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed typeOfElementAccessed = null;
        if (is_SingleAccess)
            typeOfElementAccessed = DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.Descriptor;
        else
            typeOfElementAccessed = DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.DescriptorSet;
        short numberOfExpresions = 1;

        String accessExrp1 = "AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED";
        boolean accessExrp1_Is_Static_DescTag = true;
        boolean accessExrp1_Is_Static_DescTagName = false;
        boolean accessExrp1_Is_Static_Label = false;
        String accessExrp1_DescTagName_String = "FORM.REQUIRED";
        DescriptorTagName descTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(accessExrp1_DescTagName_String, 1,
                true, null, null);
        Symbol_Base accessExrp1_DescTagOrLabel_Actual = symbolControl.multiLevelSymbol_Factory.createNew_DescriptorTag(
                MPSymbols_DescTagName.net$__$unconventionalthinking$__$matrix, MPSymbols_DescTagName.WEB$__$FORM, descTagName, true);



        boolean annotationReference_Exists = false;
        String annotationReference = null;
        String annotationReference_no_Star = null;

        DescriptorAccess_ChildAccessInfo formRequiredAccess = new DescriptorAccess_ChildAccessInfo(is_StaticAccess, typeOfElementAccessed,
                numberOfExpresions, is_SingleAccess);
        formRequiredAccess.set_AccessExpression1(accessExrp1, accessExrp1_Is_Static_DescTag, accessExrp1_Is_Static_DescTagName,
                accessExrp1_Is_Static_Label,
                Arrays.asList(((DescriptorTag)accessExrp1_DescTagOrLabel_Actual).getDescTagName().getSymbolNames()),
                accessExrp1_DescTagOrLabel_Actual);
        childAccessInfo_List.add(formRequiredAccess);




        if (test_FieldAccess) {

            if (is_SingleAccess)
                typeOfElementAccessed = DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.Field;
            else
                typeOfElementAccessed = DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.FieldValueSet;


            accessExrp1 = "AppSymbols_DescTagName.IsRequired";
            accessExrp1_Is_Static_DescTag = false;
            accessExrp1_Is_Static_DescTagName = true;
            accessExrp1_Is_Static_Label = false;
            List<String> accessExrp1_SymbolParts = new ArrayList<String>();

            accessExrp1_SymbolParts.add("IsRequired");
            accessExrp1_DescTagOrLabel_Actual = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(accessExrp1_SymbolParts, 1, true);

            DescriptorAccess_ChildAccessInfo field1Access = new DescriptorAccess_ChildAccessInfo(is_StaticAccess, typeOfElementAccessed,
                    numberOfExpresions, is_SingleAccess);
            field1Access.set_AccessExpression1(accessExrp1, accessExrp1_Is_Static_DescTag, accessExrp1_Is_Static_DescTagName,
                    accessExrp1_Is_Static_Label, accessExrp1_SymbolParts, accessExrp1_DescTagOrLabel_Actual);
            childAccessInfo_List.add(field1Access);



        }



        descriptorAccess_CodeGenerator.set_3_RootAccessorInfo(rootAccessor_Expr, rootAccessorExpr_is_Identifier, is_StaticAccess);
        descriptorAccess_CodeGenerator.set_3_ChildAccessInfo(childAccessInfo_List);

        descriptorAccess_CodeGenerator.generate_MartrixAccess_Method(outputResults);

//    System.out.println(codeBuildersList_AccessMethods);
//    System.out.println("\n\n");
//    System.out.println(codeBuilder_Access);

    }



}
