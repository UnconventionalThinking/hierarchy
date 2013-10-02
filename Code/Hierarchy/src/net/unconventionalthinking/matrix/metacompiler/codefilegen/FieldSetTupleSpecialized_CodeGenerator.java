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

package net.unconventionalthinking.matrix.metacompiler.codefilegen;

import net.unconventionalthinking.matrix.metacompiler.codegen.*;
import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.Exception_SchemaInfo;
import net.unconventionalthinking.matrix.FieldConstants;
import net.unconventionalthinking.matrix.FieldSet_FieldValueBucket;
import net.unconventionalthinking.matrix.SchemaInfo_Field;
import net.unconventionalthinking.matrix.SchemaInfo_FieldSet;
import net.unconventionalthinking.matrix.symbols.Exception_MultiPartSymbolAccess;
import net.unconventionalthinking.matrix.symbols.Exception_MultiPartSymbolCreation;
import net.unconventionalthinking.matrix.symbols.Exception_MultiPartSymbolCreationOrAccess;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.matrix.utilities.TypeUtilities;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.unconventionalthinking.reflection.DynamicClassUtilities;
import net.unconventionalthinking.reflection.MethodInvoker;


/**
 *
 * @author peterjoh
 */
public class FieldSetTupleSpecialized_CodeGenerator {

    public static final String GetImportsSet_MethodName = "getImportsSet";
    
    public CodeBuilder codeBuilder;

    public SchemaInfo_FieldSet schemaInfo_FieldSet;
    public List<SchemaInfo_Field> fields;


    private HierarchySettings hierarchySettings;
    private List<Symbol> mustImportTypes_List = new ArrayList<Symbol>();
    private Set<Symbol> mustImportTypes_Set = new HashSet<Symbol>();
    private Set<String> associatedSchemas_ImportSet;
    private Set<String> combined_Imports;
    
    private boolean is_ExternalFieldSet;
    private Class   externalFieldSet_ClassObj;

    private String fieldSetTuple_OutClassName;



    public FieldSetTupleSpecialized_CodeGenerator(HierarchySettings hierarchySettings, SchemaInfo_FieldSet schemaInfo_FieldSet) {
        this.hierarchySettings = hierarchySettings;

        codeBuilder = new CodeBuilder();

        this.schemaInfo_FieldSet = schemaInfo_FieldSet;
        fields =  schemaInfo_FieldSet.get_SchemaInfoFields();

        fieldSetTuple_OutClassName = schemaInfo_FieldSet.get_FieldSetTypeString();
    }

    public void set_ExternalFieldSet_ClassObj(Class externalFieldSet_ClassObj) {
        is_ExternalFieldSet = (externalFieldSet_ClassObj != null);

        this.externalFieldSet_ClassObj = externalFieldSet_ClassObj;
    }
    /** The fieldset should have the all the imports that are imported in its schema. Pass in the schema's import list */
    public void set_AssociatedSchemas_ImportSet(Set<String> importSet) {
        this.associatedSchemas_ImportSet = importSet;
    }

    

    public String getFieldSetTuple_TypeName() {
        return fieldSetTuple_OutClassName;
    }

    public CodeBuilder generate_Specialized_FieldSetTupleClass(ExecutionInfo executeInfo, String packageNameString, SymbolControl symbolControl)
            throws Exception_MetaCompilerError {

        CodeFileGenerator_Utilities.addMetaCompiledCommentToken(codeBuilder);

        if (packageNameString != null)
            codeBuilder.append("package ").append(packageNameString).append(";\n\n");


        //  Create the field type list

        //  First, create the mustImportTypes list
        try {
            create_MustImportList(symbolControl);
        } catch (Exception e) {
            throw new Exception_MetaCompilerError("FieldSetTupleSpecialized_CodeGenerator.genrate_Sepcialize_FieldSetTupleClass: tried to create_MustImportList(), " +
                    "but had an error. couldn't create one of the type symbols", e);
        }


        List<Symbol> fieldTypes_List = new ArrayList<Symbol>();
        Set<Symbol>  fieldTypes_Set = new HashSet<Symbol>();
        List<Symbol> fieldTypes_List_NoPrimitives = new ArrayList<Symbol>();
        List<Symbol> fieldTypes_List_NoPrimitives_NotImported = new ArrayList<Symbol>();


        for (SchemaInfo_Field field : fields) {
            if (!fieldTypes_Set.contains(field.fieldType_Symbol_No_ContinuationType)) {
                fieldTypes_Set.add(field.fieldType_Symbol_No_ContinuationType);
                
                fieldTypes_List.add(field.fieldType_Symbol_No_ContinuationType);

                if (!TypeUtilities.is_PrimitiveType(field.fieldType_Symbol_No_ContinuationType)) {
                    fieldTypes_List_NoPrimitives.add(field.fieldType_Symbol_No_ContinuationType);

                    // if the num of levels = 1, it's probably a java.lang or one of the Matrix program types (like Symbol)
                    if (field.fieldType_Symbol_No_ContinuationType.getNumOfParts() > 1) {
                        if (notImportedYet(field.fieldType_Symbol_No_ContinuationType) && !donotImport(field.fieldType_Symbol_No_ContinuationType))
                            fieldTypes_List_NoPrimitives_NotImported.add(field.fieldType_Symbol_No_ContinuationType);
                    }
                }
            }
        }
        

        //  Combine the must import set, the fieldType's imports, with the associated schema's imported set
        combined_Imports = new HashSet<String>();
        for (Symbol typeSymbol : mustImportTypes_List)
            combined_Imports.add("import " + typeSymbol.name_no_backtiks + ";");
        for (Symbol typeSymbol : fieldTypes_List_NoPrimitives_NotImported)
            combined_Imports.add("import " + typeSymbol.name_no_backtiks + ";");

        if (associatedSchemas_ImportSet != null) {
            for (String importString : associatedSchemas_ImportSet)
                combined_Imports.add(CodeFileGenerator_Utilities.cleanImportString(importString).toString());

        } else if (is_ExternalFieldSet) {
            // This is specialized fieldset from an external jar, get the imports from the specialized schema's fieldset
            Set<String> externalFieldSet_ImportSet = null;
            try {
                externalFieldSet_ImportSet = (Set<String>)MethodInvoker.invokeMethod_Helper(null, externalFieldSet_ClassObj,
                        GetImportsSet_MethodName, null);
            } catch (Exception e) {
                throw new Exception_MetaCompilerError("Tried to dynamically call a method on the specialized fieldset, " + getFieldSetTuple_TypeName() + ", from an external jar, but could not.", e);
            }
            for (String importString : externalFieldSet_ImportSet)
                combined_Imports.add(CodeFileGenerator_Utilities.cleanImportString(importString).toString());
        }

        //  Print out the imports:
        for (String importString : combined_Imports)
            codeBuilder.append(importString + "\n");

        CodeBuilder importsSetMethod_CodeBuilder = generateImportsSetMethod(combined_Imports);


        codeBuilder.append("\n\npublic class ").append(fieldSetTuple_OutClassName);
        if (is_ExternalFieldSet)
            codeBuilder.append(" extends " + externalFieldSet_ClassObj.getCanonicalName() + " {\n\n");
        else
            codeBuilder.append(" extends FieldSet_Tuple {\n\n");

        

        //  Create variables for fields
        boolean haveCreatedContinuation = false;

        codeBuilder.append("\t//  private variables (for fields) _______________________________________________________\n\n");

        for (SchemaInfo_Field field : fields) {

            if (!field.is_ContinuationField()) {
                codeBuilder.append("\t").append(field.fieldType_Symbol.name_no_backtiks).append(" ").append(field.fieldName.getTagName()).append(";\n");
                codeBuilder.append("\tFieldConstants ").append(field.fieldName.getTagName())
                        .append(CodeConstants.FieldSet_SetMethodNameSuffix_Special + ";\n");

            } else if (!haveCreatedContinuation) { // create continuation values
                codeBuilder.append("\n\t//  Continuation Values List\n");
                codeBuilder.append("\tList<FieldSet_FieldValueBucket> continuationValues;\n");

                haveCreatedContinuation = true;
            }
        }


        //  Create constructors _____________________________________________________________________________________________
        codeBuilder.append("\n\n\t//  Constructors _________________________________________________________________________\n");

        createConstructor(fieldSetTuple_OutClassName);


        //  Create FieldSet State Methods
        codeBuilder.append("\n\n\t//  FieldSet State Methods _______________________________________________________________\n")
            .append("\t@Override\n")
            .append("\tpublic boolean is_SpecializedFieldSet() {\n")
            .append("\t\treturn true;\n")
            .append("\t}\n");



        //  Create get_<Field Name>(), set_<Field Name>(), and set_<Field Name>__Special() methods
        codeBuilder.append("\n\n\t//  get_<Field Name>(), set_<Field Name>(), and set_<Field Name>__Special() methods_______\n\n");
        FieldSetTupleSpecialized_GetAndSet_byFieldName codeGen_GetAndSet_ByFieldName =
                new FieldSetTupleSpecialized_GetAndSet_byFieldName(hierarchySettings, codeBuilder, schemaInfo_FieldSet);
        
        codeGen_GetAndSet_ByFieldName.create_get_FieldName_Methods();
        codeGen_GetAndSet_ByFieldName.create_set_FieldName_Methods();


        codeGen_GetAndSet_ByFieldName.create_setField_byFieldName_Methods(executeInfo, false, null, false);
        codeGen_GetAndSet_ByFieldName.create_setField_byFieldName_Methods(executeInfo, false, null, true);
        for (Symbol typeSymbol : fieldTypes_List) {
            codeGen_GetAndSet_ByFieldName.create_setField_byFieldName_Methods(executeInfo, true, typeSymbol);
        }

        codeGen_GetAndSet_ByFieldName.create_getField_byFieldName_Methods(executeInfo, false, null); 
        for (Symbol typeSymbol : fieldTypes_List) {
            codeGen_GetAndSet_ByFieldName.create_getField_byFieldName_Methods(executeInfo, true, typeSymbol);
        }



        //  Create getField(index), setField(index), and set_<Field>__Special(index) methods
        codeBuilder.append("\n\n\t//  getField(index), setField(index), and set_<Field>__Special(index) methods_____________\n\n");
        codeBuilder
            .append("\t//  These two methods just call the setField()'s with no symbol type\n")
            .append("\t@Override\n")
            .append("\tpublic void setField(ExecutionInfo executeInfo, int index, Object value, Symbol typeSymbol) throws Exception_InvalidArgumentPassed {\n")
            .append("\t\tsetField(executeInfo, index, value);\n")
            .append("\t}\n\n")

            .append("\t@Override\n")
            .append("\tpublic void setField(ExecutionInfo executeInfo, DescriptorTagName fieldName, Object value, Symbol typeSymbol) throws Exception_InvalidArgumentPassed {\n")
            .append("\t\tsetField(executeInfo, fieldName, value);\n")
            .append("\t}\n\n\n");


        FieldSetTupleSpecialized_GetAndSet_byIndex codeGen_GetAndSet_ByIndex =
                new FieldSetTupleSpecialized_GetAndSet_byIndex(codeBuilder, schemaInfo_FieldSet);
        codeGen_GetAndSet_ByIndex.create_getField_byIndex_Methods(executeInfo, false, null);
        for (Symbol typeSymbol : fieldTypes_List) {
            codeGen_GetAndSet_ByIndex.create_getField_byIndex_Methods(executeInfo, true, typeSymbol);
        }
        
        codeGen_GetAndSet_ByIndex.create_setField_byIndex_Methods(executeInfo, false, null);
        for (Symbol typeSymbol : fieldTypes_List) {
            codeGen_GetAndSet_ByIndex.create_setField_byIndex_Methods(executeInfo, true, typeSymbol);
        }
        codeGen_GetAndSet_ByIndex.create_setFieldSpecial_byIndex_Method(executeInfo);


        codeBuilder.append("\n\n\t//  Public static methods ____________________________________________________\n\n");
        codeBuilder.append(importsSetMethod_CodeBuilder).append("\n");

        //  end of class definition
        codeBuilder.append("\n}\n");
        return codeBuilder;

    }



    void createConstructor(String constructor_MethodName) {

        codeBuilder.append("\n\tpublic ").append(constructor_MethodName).append("(ExecutionInfo executeInfo, Descriptor parentDescriptor");
        codeBuilder.append(") {\n");


        if (is_ExternalFieldSet) {
            codeBuilder.append("\n\t\tsuper(executeInfo, parentDescriptor);\n\n");
        } else {
            codeBuilder.append("\n\t\t//  passing in 'false' to FieldSet_Tuple parent constructor so that the dynAccessed_Field List is not created.\n");
            codeBuilder.append("\t\tsuper(executeInfo, parentDescriptor, false);\n\n");
        }

        //  create variable assignment stmts
        for (SchemaInfo_Field field : schemaInfo_FieldSet.get_SchemaInfoFields()) {
            if (!field.is_ContinuationField()) {

                codeBuilder.append("\t\tthis.").append(field.getFieldName()).append(CodeConstants.FieldSet_SetMethodNameSuffix_Special).
                        append(" = null;\n");
            }
        }


        if (schemaInfo_FieldSet.hasContinuationField()) {
            codeBuilder.append("\n\t\tcontinuationValues = new ArrayList<FieldSet_FieldValueBucket>();\n");
        }

        codeBuilder.append("\n\t}\n\n");
    }





    private void create_MustImportList(SymbolControl symbolControl) throws Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreation,
        Exception_MultiPartSymbolCreationOrAccess {

        List<String> symbolList = new ArrayList<String>();
        symbolList.add("net");
        symbolList.add("unconventionalthinking");
        symbolList.add("exceptions");
        symbolList.add("Exception_InvalidArgumentPassed");
        Symbol typeSymbol = symbolControl.multiPartSymbol_Factory.createNew(symbolList, 1, true);
        mustImportTypes_List.add(typeSymbol);
        mustImportTypes_Set.add(typeSymbol);

        symbolList.clear();
        symbolList.add("net");
        symbolList.add("unconventionalthinking");
        symbolList.add("lang");
        symbolList.add("ExecutionInfo");
        typeSymbol = symbolControl.multiPartSymbol_Factory.createNew(symbolList, 1, true);
        mustImportTypes_List.add(typeSymbol);
        mustImportTypes_Set.add(typeSymbol);

        symbolList.clear();
        symbolList.add("net");
        symbolList.add("unconventionalthinking");
        symbolList.add("matrix");
        symbolList.add("Descriptor");
        typeSymbol = symbolControl.multiPartSymbol_Factory.createNew(symbolList, 1, true);
        mustImportTypes_List.add(typeSymbol);
        mustImportTypes_Set.add(typeSymbol);


        symbolList.clear();
        symbolList.add("net");
        symbolList.add("unconventionalthinking");
        symbolList.add("matrix");
        symbolList.add("FieldConstants");
        typeSymbol = symbolControl.multiPartSymbol_Factory.createNew(symbolList, 1, true);
        mustImportTypes_List.add(typeSymbol);
        mustImportTypes_Set.add(typeSymbol);

        symbolList.clear();
        symbolList.add("net");
        symbolList.add("unconventionalthinking");
        symbolList.add("matrix");
        symbolList.add("FieldSet_Tuple");
        typeSymbol = symbolControl.multiPartSymbol_Factory.createNew(symbolList, 1, true);
        mustImportTypes_List.add(typeSymbol);
        mustImportTypes_Set.add(typeSymbol);

        symbolList.clear();
        symbolList.add("net");
        symbolList.add("unconventionalthinking");
        symbolList.add("matrix");
        symbolList.add("FieldSet_FieldValueBucket");
        typeSymbol = symbolControl.multiPartSymbol_Factory.createNew(symbolList, 1, true);
        mustImportTypes_List.add(typeSymbol);
        mustImportTypes_Set.add(typeSymbol);

        symbolList.clear();
        symbolList.add("net");
        symbolList.add("unconventionalthinking");
        symbolList.add("matrix");
        symbolList.add("FieldSet_Worker");
        typeSymbol = symbolControl.multiPartSymbol_Factory.createNew(symbolList, 1, true);
        mustImportTypes_List.add(typeSymbol);
        mustImportTypes_Set.add(typeSymbol);

        symbolList.clear();
        symbolList.add("net");
        symbolList.add("unconventionalthinking");
        symbolList.add("matrix");
        symbolList.add("symbols");
        symbolList.add("DescriptorTagName");
        typeSymbol = symbolControl.multiPartSymbol_Factory.createNew(symbolList, 1, true);
        mustImportTypes_List.add(typeSymbol);
        mustImportTypes_Set.add(typeSymbol);

        symbolList.clear();
        symbolList.add("net");
        symbolList.add("unconventionalthinking");
        symbolList.add("matrix");
        symbolList.add("symbols");
        symbolList.add("Symbol");
        typeSymbol = symbolControl.multiPartSymbol_Factory.createNew(symbolList, 1, true);
        mustImportTypes_List.add(typeSymbol);
        mustImportTypes_Set.add(typeSymbol);

        symbolList.clear();
        symbolList.add("java");
        symbolList.add("util");
        symbolList.add("ArrayList");
        typeSymbol = symbolControl.multiPartSymbol_Factory.createNew(symbolList, 1, true);
        mustImportTypes_List.add(typeSymbol);
        mustImportTypes_Set.add(typeSymbol);

        symbolList.clear();
        symbolList.add("java");
        symbolList.add("util");
        symbolList.add("Set");
        typeSymbol = symbolControl.multiPartSymbol_Factory.createNew(symbolList, 1, true);
        mustImportTypes_List.add(typeSymbol);
        mustImportTypes_Set.add(typeSymbol);

        symbolList.clear();
        symbolList.add("java");
        symbolList.add("util");
        symbolList.add("HashSet");
        typeSymbol = symbolControl.multiPartSymbol_Factory.createNew(symbolList, 1, true);
        mustImportTypes_List.add(typeSymbol);
        mustImportTypes_Set.add(typeSymbol);

        symbolList.clear();
        symbolList.add("java");
        symbolList.add("util");
        symbolList.add("List");
        typeSymbol = symbolControl.multiPartSymbol_Factory.createNew(symbolList, 1, true);
        mustImportTypes_List.add(typeSymbol);
        mustImportTypes_Set.add(typeSymbol);

    }

    private boolean notImportedYet(Symbol typeSymbol) {

        return (!mustImportTypes_Set.contains(typeSymbol));
    }
    private boolean donotImport(Symbol typeSymbol) {

        return (typeSymbol == MPSymbols.Symbol || typeSymbol == MPSymbols.DescriptorTagName || typeSymbol == MPSymbols.Label);
    }



    /**
     * This method generates the code for a static method that returns a set of imports that were used for this specialized fieldset.
     * This is used in the metacompiler when generating fieldsets for schemas in external jars, to generate the import list.
     */
    private CodeBuilder generateImportsSetMethod(Set<String> combined_Imports) {
        CodeBuilder importsSetMethod_CodeBuilder = new CodeBuilder();

        importsSetMethod_CodeBuilder
            .append("\tprivate static Set<String> importsSet;\n\n")

            .append("\t/** This method returns the set of imports that were used for this specialized fieldset. This is used in the metacompiler when generating "
            + "\t    fieldsets for schemas in external jars, to generate the import list. */\n")
            .append("\tpublic static Set<String> " + GetImportsSet_MethodName + "() {\n\n")

            .append("\t\tif (importsSet == null ) {\n")
            .append("\t\t\timportsSet = new HashSet<String>();\n");

        for (String importString : combined_Imports)
            importsSetMethod_CodeBuilder.append("\t\t\timportsSet.add(\"" ).append(importString).append("\");\n");

        importsSetMethod_CodeBuilder.append("\t\t}\n\n");

        importsSetMethod_CodeBuilder.append("\t\treturn importsSet;\n");
        importsSetMethod_CodeBuilder.append("\t}\n");

        return importsSetMethod_CodeBuilder;
    }


}
