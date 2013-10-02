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

import net.unconventionalthinking.matrix.utilities.TextUtilities;
import net.unconventionalthinking.hierarchy.AppControl_Info;
import net.unconventionalthinking.hierarchy.Class_FileInfo;
import java.util.List;
import java.util.Set;



public class AppControlFile_Generator {


    public static CodeBuilder generate(CodeBuilder codeBuilder, String appControlFile_Package, String appControlFileName, 
            List<Class_FileInfo> internalSchema_ClassFileInfo_List, List<Class_FileInfo> internalMatrix_ClassFileInfo_List,
            List<Class_FileInfo> fieldSetTuple_ClassFileInfo_List,
            Set<AppControl_Info> externalAppControl_Set) {

        if (codeBuilder == null)
            codeBuilder = new CodeBuilder();

        codeBuilder
            .append("/*  " + CodeGeneratorConstants.METACOMPILIED_FILE__COMMENT_TOKEN + "  */\n\n");

        // Create header of file:
        if (appControlFile_Package != null && appControlFile_Package.trim().length() > 0)
            codeBuilder.append("package " + appControlFile_Package + ";\n\n");

        codeBuilder
            .append("import java.util.*;\n")
            .append("import java.lang.reflect.Constructor;\n")
            .append("import net.unconventionalthinking.lang.*;\n")
            .append("import java.util.concurrent.atomic.AtomicBoolean;\n")
            .append("import net.unconventionalthinking.reflection.MethodInvoker;\n\n")

            .append(CodeConstants.MatrixImports_Main + "\n")
            .append(CodeConstants.MatrixImports_Symbols + "\n")
            .append(CodeConstants.MatrixImports_AbstractExceptions +" \n\n\n")


            .append("public class " + appControlFileName + " extends AppControl_Base { \n\n")

            .append("\t//  Static initialization Code for appControl instance\n")
            .append("\t//  Public Static variables __________________________________________\n")
            .append("\tpublic static AppControl appControl = null;\n\n")

            .append("\t//  Private Static Variables _________________________________________\n")
            .append("\tprivate static AtomicBoolean initializationAtLeastStarted = new AtomicBoolean(false);\n\n")


            
            .append("\n\n\t//  Static Methods ___________________________________________________\n\n")


            .append("\tpublic static synchronized AppControl_Base initializeApp() {\n")
            .append("\t\treturn initializeApp(false);\n")
            .append("\t}\n\n")

            .append("\t/**\n")
            .append("\t * This version of the initializeApp should not be used when running the application, and is only called by the metacompiler\n")
            .append("\t *\n")
            .append("\t * @param running_AppControl_forMetacompilation   a boolean value indicating if the current app control is a non-final app Control\n")
            .append("\t *                                                running as an intermediate appcontrol for metacompilation.*/\n")
            .append("\tpublic static synchronized AppControl_Base initializeApp(boolean running_AppControl_forMetacompilation) {\n\n")

            .append("\t\ttry {\n")
            .append("\t\t\tif (!initializationAtLeastStarted.getAndSet(true)) {\n")
            .append("\t\t\t\tappControl = new AppControl(running_AppControl_forMetacompilation);\n")
            .append("\t\t\t}")
            .append("\t\t} catch (Exception e) {\n")
            .append("\t\t\tthrow new ExceptRuntime_Matrix_GeneralError(\"Tried to create the appControl for the system, but had an error (see inner exception)\", e);\n")
            .append("\t\t}\n\n")
            .append("\t\treturn appControl;\n")
            .append("\t}\n\n")

            .append("\t/**\n")
            .append("\t * The version takes an existing, parent app Control, and sets it as the appcontrol for this application context. In other words,\n")
            .append("\t * typically, if this method is being called, then this app control is probably a part of a jar file that is being called from a\n")
            .append("\t * parent application. This jar's app control should use the parent application's app control.\n")
            .append("\t *\n")
            .append("\t */\n")
            .append("\tpublic static synchronized AppControl_Base initializeApp(AppControl_Base parent_AppControl) {\n")
            .append("\t\t    return initializeApp(parent_AppControl, false);\n")
            .append("\t}\n\n")

            .append("\t/**  The version takes an existing, parent app Control, and sets it as the appcontrol for this application context. In other words,\n")
            .append("\t * typically, if this method is being called, then this app control is probably a part of a jar file that is being called from a\n")
            .append("\t * parent application. This jar's app control should use the parent application's app control.\n\n")
            .append("\t * @param running_AppControl_forMetacompilation   a boolean value indicating if the current app control is \n")
            .append("\t *                                                running as an intermediate appcontrol for metacompilation.*/\n")
            .append("\tpublic static synchronized AppControl_Base initializeApp(AppControl_Base parent_AppControl, boolean running_AppControl_forMetacompilation) {\n")

            .append("\t\ttry {\n")
            .append("\t\t\tif (!initializationAtLeastStarted.getAndSet(true)) {\n")
            .append("\t\t\t\tappControl = new AppControl(parent_AppControl, running_AppControl_forMetacompilation);\n")
            .append("\t\t\t}")
            .append("\t\t} catch (Exception e) {\n")
            .append("\t\t\tthrow new ExceptRuntime_Matrix_GeneralError(\"Tried to create the appControl for the system, but had an error (see inner exception)\", e);\n")
            .append("\t\t}\n\n")
            .append("\t\treturn appControl;\n")
            .append("\t}\n\n\n\n");



        codeBuilder
            .append("\t//  AppControl Methods ________________________________________________\n")
            .append("\tpublic " + appControlFileName + "(boolean running_AppControl_forMetacompilation) \n" +
                    "\t\tthrows Exception_SymbolCreation, Exception_Descriptor, Exception_InvalidArgumentPassed, Exception_SchemaInfo, Exception_MatrixRuntime_Checked {\n\n")

            .append("\t\tis_ExternalAppControl = false;\n")
            .append("\t\tthis.running_AppControl_forMetacompilation = running_AppControl_forMetacompilation;\n\n")

            .append("\t\texecutionInfo = new ExecutionInfo();\n")
            .append("\t\tsymbolControl = new SymbolControl();\n")
            .append("\t\tinitialize_Symbols();\n\n")

            .append("\t\t//  the schema control uses symbols, so it must be inited after the symbols have been initialized.\n")
            .append("\t\tschemaControl = new SchemaControl(executionInfo, this);\n")
            .append("\t\tfieldSetTupleSpecialized_Constructor_Index = schemaControl.get_FieldSetTupleSpecialized_Constructor_Index_byTypeSymbol();\n")
            .append("\t\tfieldSetTupleSpecialized_ExternalFieldSets_Index__fromClassName_to_ClassObj =\n")
            .append("\t\t\t\tschemaControl.get_FieldSetTupleSpecialized_ExternalFieldSets_Index__fromClassName_to_ClassObj();\n")
            .append("\t\tmatrixControl = new MatrixControl(this);\n\n")

            .append("\t\t//  The specialized fieldsets for this jar need to to be added before the externalappcontrols are.\n")
            .append("\t\t//  Why? because the external matrix/schema constructors should use the internal app context's specialized fieldsets, not its own\n")
            .append("\t\t//  The reason is because all the external fieldset's symbol id's are incorrect.\n")
            .append("\t\tinitialize_SpecializedFieldSets();\n")
            .append("\t\tinitialize_ExternalAppControls_List();\n")
            .append("\t\tinitialize_AppObjects();\n")
       		.append("\t} \n\n");

        codeBuilder
            .append("\tpublic " + appControlFileName + "(AppControl_Base parent_AppControl, boolean running_AppControl_forMetacompilation) \n" +
                     "\t\tthrows Exception_SymbolCreation, Exception_Descriptor, Exception_InvalidArgumentPassed, Exception_SchemaInfo, Exception_MatrixRuntime_Checked {\n\n")

            .append("\t\tis_ExternalAppControl = true;\n")
            .append("\t\tthis.running_AppControl_forMetacompilation = running_AppControl_forMetacompilation;\n\n")

            .append("\t\texecutionInfo = parent_AppControl.executionInfo;\n")
            .append("\t\tsymbolControl = parent_AppControl.symbolControl;\n")
            .append("\t\tinitialize_Symbols();\n\n")

            .append("\t\tschemaControl = parent_AppControl.schemaControl;\n")
            .append("\t\tfieldSetTupleSpecialized_Constructor_Index = schemaControl.get_FieldSetTupleSpecialized_Constructor_Index_byTypeSymbol();\n")
            .append("\t\tfieldSetTupleSpecialized_ExternalFieldSets_Index__fromClassName_to_ClassObj =\n")
            .append("\t\t\t\tschemaControl.get_FieldSetTupleSpecialized_ExternalFieldSets_Index__fromClassName_to_ClassObj();\n")
            .append("\t\tmatrixControl = parent_AppControl.matrixControl;\n\n")

            .append("\t\t//  this is an external app control, so the specialized fieldsets don't need to be initialized, but added to the external fieldSets list\n")
            .append("\t\tinitialize_SpecializedFieldSets();\n")
            .append("\t\tinitialize_ExternalAppControls_List();\n")
            .append("\t\tinitialize_AppObjects();\n")
       		.append("\t} \n\n\n");



        codeBuilder
            .append("\t@Override\n")
            .append("\tpublic void initialize_AppObjects()\n")
            .append("\tthrows Exception_Descriptor, Exception_InvalidArgumentPassed, Exception_SchemaInfo, Exception_MatrixRuntime_Checked  {\n\n")
            
            .append("\t\tinitialize_StaticSchemas();\n")
            .append("\t\tinitialize_StaticMatrices();\n")
            .append("\t}\n\n");
        


        generate_externalAppControlsInitializer(codeBuilder, externalAppControl_Set);
        generate_SymbolInitializer(codeBuilder);
        generate_FieldSetInitializer(codeBuilder, fieldSetTuple_ClassFileInfo_List);

        generate_SchemasOrMatricesInitializer(codeBuilder, true, internalSchema_ClassFileInfo_List);
        generate_SchemasOrMatricesInitializer(codeBuilder, false, internalMatrix_ClassFileInfo_List);
        codeBuilder.append("\n\n}\n");

        return codeBuilder;
    }


    private static void generate_externalAppControlsInitializer(CodeBuilder codeBuilder, Set<AppControl_Info> externalAppControl_Set) {
        codeBuilder
            .append("\t@Override\n")
            .append("\tpublic void initialize_ExternalAppControls_List() {\n")
            .append("\t\texternalAppControl_ClassList = new ArrayList<Class>();\n\n")

            .append("\t\t//  Add the external appControl classes to the externalAppControl_ClassList\n");
        for (AppControl_Info externalAppControl_Info :externalAppControl_Set)
            codeBuilder.append("\t\texternalAppControl_ClassList.add(" + externalAppControl_Info.fullTypeName + ".class);\n");

        codeBuilder
            .append("\t\t//  Intialize the list external app controls.\n\n")
            .append("\t\tfor (Class externalAppControl_Class : externalAppControl_ClassList) {\n")
			.append("\t\t\tClass[] paramTypes = new Class[] { AppControl_Base.class, boolean.class };\n")
			.append("\t\t\tObject[] paramValues = new Object[] { this, running_AppControl_forMetacompilation };\n\n")

			.append("\t\t\ttry {\n")
			.append("\t\t\t\tMethodInvoker.invokeMethod_Helper(null, externalAppControl_Class, \"initializeApp\", new Boolean_Mutable(),\n")
			.append("\t\t\t\t\t\tparamTypes, paramValues );\n")
			.append("\t\t\t} catch (Exception e) {\n")
			.append("\t\t\t\tthrow new ExceptRuntime_Matrix_GeneralError(\"Tried to initialize the external appcontrol, \" +  externalAppControl_Class.getName() +\n")
			.append("\t\t\t\t\t\t\", but had an error.\", e);\n")
			.append("\t\t\t}\n")
			.append("\t\t}\n\n")

            .append("\t}\n\n\n");
    }

    private static void generate_SymbolInitializer(CodeBuilder codeBuilder) {
        
        codeBuilder.append("\n\n\t//  Symbol initializer\n")
            .append("\t@Override\n")
            .append("\tpublic void initialize_Symbols() throws Exception_SymbolCreation {\n")
            .append("\t\ttry {\n")

            .append("\t\t\tAppSymbols.initialize(symbolControl, is_ExternalAppControl);\n")
            .append("\t\t\tAppSymbols_DescTagName.initialize(symbolControl, is_ExternalAppControl);\n")
            .append("\t\t\tAppSymbols_Label.initialize(symbolControl, is_ExternalAppControl);\n")
            .append("\t\t\t//  Schema Name & Matrix Name must init after DescTagName;\n")
            .append("\t\t\tAppSymbols_SchemaName.initialize(symbolControl, is_ExternalAppControl);\n")
            .append("\t\t\tAppSymbols_MatrixName.initialize(symbolControl, is_ExternalAppControl);\n")
            .append("\t\t\t//  DescTag must init after DescTagName & SchemaName;\n")
            .append("\t\t\tAppSymbols_DescTag.initialize(symbolControl, is_ExternalAppControl);\n\n")

            .append("\t\t\t//  MP Symbol classes don't need the is_ExternalAppControl value. Why? because they don't use fixed symbol id's \n")
            .append("\t\t\tsymbolControl.intialize_All_MPSymbols();\n\n")

            .append("\t\t} catch(Exception e) {\n")
            .append("\t\t\tthrow new Exception_SymbolCreation(\"Tried to initialize the appSymbols, but had a problem (see inner exception).\", e);\n")
            .append("\t\t}\n\n")

            .append("\t}  //  end of symbol init\n");
    }

    
    private static void generate_FieldSetInitializer(CodeBuilder codeBuilder, List<Class_FileInfo> fieldSetTuple_ClassFileInfo_List)  {
        

        codeBuilder
        .append("\n\n\t//  FieldSet Class initializer\n")
        .append("\t//  If this is an external app control, so the specialized fieldsets don't need to be initialized, and this method is not called.\n")
        .append("\tvoid initialize_SpecializedFieldSets() {\n\n")

        .append("\t\t//  If this is an external app control to the external fieldSets list.\n")
        .append("\t\tif (is_ExternalAppControl) {\n");

        if (fieldSetTuple_ClassFileInfo_List != null) {
            for (Class_FileInfo fieldSet_ClassFileInfo : fieldSetTuple_ClassFileInfo_List) {
                codeBuilder.append("\t\t\tfieldSetTupleSpecialized_ExternalFieldSets_Index__fromClassName_to_ClassObj.put(AppSymbols." +
                        TextUtilities.convertTextToIdentifier(fieldSet_ClassFileInfo.className) +
                        ".name_no_backtiks , " + fieldSet_ClassFileInfo.className + ".class);\n");
            }
        }
        codeBuilder
        .append("\n\t\t}\n\n")
                
        .append("\t\t//  This is a either the appControl for the application (a non-external one) OR\n")
        .append("\t\t//  you're creating an external appcontrol that is an appcontrol for metacompilation. In this last situation, we need\n")
        .append("\t\t//  to make sure there are constructors in the index for every fieldset. Why? anytime we construct a matrix during metacompilation, we\n")
        .append("\t\t//  need to make sure that all the specialized fieldsets exist, EVEN IF THERE THE WRONG ONES! This is okay during metacompilation,\n")
        .append("\t\t//  because the contructed matrices don't actually use the specialized fieldsets, they only construct them (which is all we need).\n")
        .append("\t\tif (!is_ExternalAppControl || running_AppControl_forMetacompilation) {\n");

        if (fieldSetTuple_ClassFileInfo_List != null) {
            for (Class_FileInfo fieldSet_ClassFileInfo : fieldSetTuple_ClassFileInfo_List) {
                codeBuilder.append("\t\t\taddConstructorForClass(AppSymbols." + TextUtilities.convertTextToIdentifier(fieldSet_ClassFileInfo.className) +
                        " , " + fieldSet_ClassFileInfo.className + ".class);\n");
            }
        }

        codeBuilder.append("\n\t\t}\n\n");
        codeBuilder.append("\t}\n\n\n");


        codeBuilder.append("\tprivate void addConstructorForClass(Symbol fieldSetTuple_TypeSymbol, Class fieldSetClass) {\n\n")

            .append("\t\tClass[] fieldSetTupleConstructor_ParamTypes = new Class[] { ExecutionInfo.class, Descriptor.class };\n\n")

            .append("\t\tConstructor fieldSetConstructor;\n\n")

            .append("\t\ttry {\n")
            .append("\t\t\tfieldSetConstructor = fieldSetClass.getConstructor(fieldSetTupleConstructor_ParamTypes);\n")
            .append("\t\t} catch (NoSuchMethodException e) {\n")
            .append("\t\t\tfieldSetConstructor = null;\n")
            .append("\t\t}\n\n")

            .append("\t\tif (fieldSetConstructor != null)\n")
            .append("\t\t\tfieldSetTupleSpecialized_Constructor_Index.put(fieldSetTuple_TypeSymbol, fieldSetConstructor);\n\n")

            .append("\t}\n");
    }




    private static void generate_SchemasOrMatricesInitializer(CodeBuilder codeBuilder, boolean generateSchemas, 
            List<Class_FileInfo> internalSchemaOrMatrix_ClassFileInfo_List) {

        String schemasOrMatrices_String = (generateSchemas) ? "Schemas" : "Matrices";

        codeBuilder
            .append("\n\t//  construct static " + schemasOrMatrices_String + "\n")
            .append("\tvoid initialize_Static" + schemasOrMatrices_String +"() throws Exception_MatrixRuntime_Checked {\n");

        if (internalSchemaOrMatrix_ClassFileInfo_List != null) {
            for (Class_FileInfo internalSchemaOrMatrix_ClassFileInfo : internalSchemaOrMatrix_ClassFileInfo_List) {
                    codeBuilder
                        .append("\t\t" + internalSchemaOrMatrix_ClassFileInfo.get_FullClassName() + ".construct(this, executionInfo);\n");
            }
        }

        codeBuilder
            .append("\n\t}\n");

    }

    
}
