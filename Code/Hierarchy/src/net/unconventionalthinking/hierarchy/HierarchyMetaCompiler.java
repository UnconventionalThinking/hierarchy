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

package net.unconventionalthinking.hierarchy;


import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbolTable_App;
import java.io.*;
import java.util.*;

import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.AppControl_Base;
import net.unconventionalthinking.matrix.SchemaInfo_FieldSet;
import net.unconventionalthinking.matrix.SchemaInfo_Schema;
import net.unconventionalthinking.matrix.metacompiler.codefilegen.FieldSetTupleSpecialized_CodeGenerator;
import net.unconventionalthinking.matrix.metacompiler.codefilegen.MatrixAndSchema_FileGenerator;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.hierarchy.compileractions.MetaCompilation_Phase;

import net.unconventionalthinking.hierarchy.langsymboltable.Exception_FindTypeName;


import net.unconventionalthinking.utilities.FileUtilities;
import net.unconventionalthinking.reflection.*;
import net.unconventionalthinking.utilities.Exception_FileUtilities_ProcessingError;
import net.unconventionalthinking.utilities.FileUtilities_DirTreeProcessor;

import net.unconventionalthinking.utilities.FileUtilities_DirTreeProcessor_Method;

import net.unconventionalthinking.utilities.FilenameFilter_ByExt;
import net.unconventionalthinking.utilities.FilenameMultipleFilters_ByExt;
import java.lang.reflect.Constructor;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import net.unconventionalthinking.matrix.Descriptor;
import net.unconventionalthinking.matrix.MatrixStructInfoIndex_Container;
import net.unconventionalthinking.matrix.MatrixStructInfo_DescriptorContainer;
import net.unconventionalthinking.matrix.metacompiler.codegen.CodeGen_OutputResults;
import net.unconventionalthinking.utilities.FileUtilities_Delete;



public class HierarchyMetaCompiler {


  /**
    * Remember, you need to setup you java home stuff correctly.
    * usage:
    * java -jar ../dist/Hierarchy.jar -cp ../lib/sablecc.jar:../lib/commons-collections-3.2.1.jar -mpropfile <my hierarchy .properties filename>
    * for example:
    * java -jar dist/Hierarchy.jar -cp ../lib/sablecc.jar:../lib/commons-collections-3.2.1.jar -mpropfile test/maintests/main/TestMatrixProject_1.properties
  s  *
    *
    *
    */
    public static void main(String[] args) throws Exception {
   
        boolean hasPropertiesFile = false;
        String propertiesFile_Path = null;

        for (int i = 0; i < args.length; ++i) {
            String parameter = args[i];

            if (parameter != null && parameter.trim().equals("-mpropfile")) {
                String filePathArg = args[++i];
                if (filePathArg != null && filePathArg.trim().length() != 0) {
                    propertiesFile_Path = filePathArg.trim();
                    hasPropertiesFile = true;
                }
            }
        }

        HierarchyMetaCompiler_Configurator propertiesUtilities = null;
        if (hasPropertiesFile)
            propertiesUtilities = new HierarchyMetaCompiler_Configurator(propertiesFile_Path);
        else
             throw new IOException("No properties file given. Pass in the path to the properties file using the -mpropfile switch.");


        HierarchyMetaCompiler hierarchyMetaCompiler = propertiesUtilities.configure();

        if (propertiesUtilities.cleanBuildDir)
            hierarchyMetaCompiler.clean();

        hierarchyMetaCompiler.phase0_InitiallyCompileJavaCode();

        hierarchyMetaCompiler.phase1_MetacompileSchemaCode();
        hierarchyMetaCompiler.phase2_GenerateFieldSets();
        hierarchyMetaCompiler.phase3_MetacompileMatrices();
        hierarchyMetaCompiler.phase4_CollectTypeInfo();
        hierarchyMetaCompiler.phase5_MetaCompileEmbeddedJavaFiles();
    }



    public final static FilenameFilter schemaFiles_Filter = new FilenameFilter_ByExt("schema");
    public final static FilenameFilter matrixFiles_Filter = new FilenameFilter_ByExt("matrix");
    public final static FilenameFilter embeddedFiles_Filter = new FilenameFilter_ByExt("mjava");
    public final static FilenameFilter javaFiles_Filter = new FilenameFilter_ByExt("java");
    public final static FilenameFilter javaAndEmbeddedFiles_Filter = new FilenameMultipleFilters_ByExt("java", "mjava");
    

    public HierarchySettings                                hierarchySettings;
    public Map<String, HierarchySettings_forMatrix>         matrixSettings_Index__byFullClassName;

    HierarchyMetaCompilerUtilities_MetaCompiler             hierarchyUtilities_MetaCompiler;
    HierarchyMetaCompilerUtilities_Compiler                 hierarchyUtilities_Compiler;
    HierarchyMetaCompilerWorker_MatrixSettingsCollector     hierarchyWorker_MatrixSettingsCollector;
    HierarchyMetaCompilerWorker_InitallyCompiledJavaFiles   hierarchyWorker_InitiallyCompiledJavaFiles;


    LangSymbolTable_App symbolTable_App;


    File                currDir;

    HierarchyControl    schemaPhase_hierarchyControl_ForSchema;
    AppControl_Base     appControl;
    ExecutionInfo       executeInfo;


    List<URL>       classpath_AllPhases_URLS;

    String          classpath_Java;
    List<URL>       classpath_Java_URLS;

    String          classpath_Schemas;
    List<URL>       classpath_Schemas_URLS;

    String          classpath_Matrices;
    List<URL>       classpath_Matrices_URLS;
    
    String          classpath_EmbeddedFiles;
    List<URL>       classpath_EmbeddedFiles_URLS;

    

    List<Class_FileInfo>        schema__Class_FileInfo__List;
    Map<String, Class_FileInfo> schema__Class_FileInfo__Index__byFullClassName;
    Map<String, MatrixAndSchema_FileGenerator>  schemaFileGenerator_Index__byFullClassName;
    List<SchemaInfo_FieldSet>   schemaInfoFieldSets_List;

    List<Class_FileInfo>        matrix__Class_FileInfo__List;
    Map<String, Class_FileInfo> matrix__Class_FileInfo__Index__byFullClassName;
    Map<String, MatrixAndSchema_FileGenerator>  matrixFileGenerator_Index__byFullClassName;

    List<Class_FileInfo>        fieldSet__Class_FileInfo__List;
//    Map<String, Class_FileInfo> fieldSet__Class_FileInfo__Index__byFieldSetClassName; // add later
    List<Class_FileInfo>        embedded__Class_FileInfo__List;
//    Map<String, Class_FileInfo> embedded__Class_FileInfo__Index__byFullClassName;  // add later
    List<Class_FileInfo>        initiallyCompiliedJava__Class_FileInfo__List;
//    Map<String, Class_FileInfo> java__Class_FileInfo__Index__byFullClassName; // add later


    HashSet<AppControl_Info>    externalAppControl_Set;

    /** This boolean is used each time when the appControl is dyn loaded during metacompilation. The new AppControl object needs to know that
     *  it's been loaded during metacompilation, and not during an actual running app. This value should be true for all of metacompilation.*/
    boolean                     running_AppControl_forMetacompilation;

    /** This is set true if the Java code was compiled. This way this is used is if 'phase 0'executes, and the Java code is compiled, then
     *  in 'phase 5', we don't need to copy over the Java code again, so we can skip redoing it. */
    boolean                     initiallyCompiledJava_haveCompiledJavainPhase0;



    public HierarchyMetaCompiler() {
        // For now, turn on DEBUG:
        hierarchySettings = new HierarchySettings();
        hierarchySettings.DEBUG = true;
        hierarchySettings.buildMode_ProjectOrSingleAppPackage = HierarchySettings.BuildMode_ProjectOrSingleAppPackage.BuildProject;

        hierarchySettings.compileMetaFiles_into_FinalClassFiles = true;  // default is true;

        resetMetaCompiler();
    }


    public final void resetMetaCompiler() {

        classpath_Java_URLS = new ArrayList<URL>();
        classpath_Schemas_URLS = new ArrayList<URL>();
        classpath_Matrices_URLS = new ArrayList<URL>();
        classpath_EmbeddedFiles_URLS = new ArrayList<URL>();

        hierarchyUtilities_MetaCompiler = new HierarchyMetaCompilerUtilities_MetaCompiler(hierarchySettings);
        hierarchyUtilities_Compiler = new HierarchyMetaCompilerUtilities_Compiler(hierarchySettings);

        hierarchyWorker_MatrixSettingsCollector = new HierarchyMetaCompilerWorker_MatrixSettingsCollector(hierarchySettings);
        matrixSettings_Index__byFullClassName = new HashMap<String, HierarchySettings_forMatrix>();

        hierarchyWorker_InitiallyCompiledJavaFiles = null; // this is setup later! in Phase 0

        symbolTable_App = new LangSymbolTable_App();


        appControl = null;
        executeInfo = null;

        matrix__Class_FileInfo__List = null;
        fieldSet__Class_FileInfo__List = null;
        externalAppControl_Set = new HashSet<AppControl_Info>();

        running_AppControl_forMetacompilation = true; // should be true for all of metacompilation
        initiallyCompiledJava_haveCompiledJavainPhase0 = false;
    }



    /** The directory where the hierarchy jar file is located. */
    public void set_HierarchyJar_Dir(String hierarchyJar_Dir) { hierarchySettings.hierarchyJar_Dir = hierarchyJar_Dir; }
    /** The directory where the javac compiler executable is located. */
    public void set_javac_Dir(String javac_Dir) { hierarchySettings.javac_Dir = javac_Dir; }


    public void set_Classpath_AllPhases(String classpath_ALL) { hierarchySettings.classpath_AllPhases = classpath_ALL; }
    public void set_Classpath_Java(String classpath_Java) { hierarchySettings.classpath_Java_Raw = classpath_Java; }
    public void set_Classpath_Schemas(String classpath_Schemas) { hierarchySettings.classpath_Schemas_Raw = classpath_Schemas; }
    public void set_Classpath_Matrices(String classpath_Matrices) { hierarchySettings.classpath_Matrices_Raw = classpath_Matrices; }
    public void set_Classpath_EmbeddedFiles(String classpath_EmbeddedFiles) { hierarchySettings.classpath_EmbeddedFiles_Raw = classpath_EmbeddedFiles; }

    /**
     * There are two settings for initiallyCompiledJava:
     *   1. compile only a passed-in list of Java files (default)
     *   2. compile all Java files
     *   If this is false, then compile only the passed-in list
     */
    public void set_InitiallyCompileAllJavaCode(boolean initiallyCompiledJava_CompileAllJavaFiles) { hierarchySettings.initiallyCompiledJava_CompileAllJavaFiles = initiallyCompiledJava_CompileAllJavaFiles; }
    public void set_InitiallyCompiledJava_SelectedClasses_List(List<String> selectedJavaClassesToCompile) { hierarchySettings.initiallyCompiledJava_SelectedClasses_List = selectedJavaClassesToCompile; }
    
    /**
     * The reason for this setting is: typically, you want to meta compile an entire project. But, sometimes, like for testing,
     * you need to be able just to compile one package, the app package. The default setting is to build all packages in a base dir.
     */
    public void set_BuildMode_ProjectOrPackage(HierarchySettings.BuildMode_ProjectOrSingleAppPackage buildMode) {
        hierarchySettings.buildMode_ProjectOrSingleAppPackage = buildMode;
    }

    /** The base directory where the source files to metacompile are located. */
    public void set_SrcMetaCode_BaseDir(String srcBaseDir) throws IOException {
        if (srcBaseDir != null)
            currDir = new File(srcBaseDir);
        else
            currDir = new File(".");
        String currDir_Path = currDir.getCanonicalPath();

        hierarchySettings.srcMetaCode_BaseDir = currDir_Path;
   }


    /**  The name of the package for all the Matrix application classes (such as AppControl, AppSymbols, AppSymbols_DescTag...). */
    public void set_AppClasses_PackageName(String packageName) throws IOException {
        hierarchySettings.appClasses_PackageName = packageName;

        set_SrcMetaCode_AppClasses(packageName);

    }

    /** The actual directory where the source files to metacompile are located (including package directories). */
    private void set_SrcMetaCode_AppClasses(String packageName) throws IOException {

        if (hierarchySettings.srcMetaCode_BaseDir == null)
            throw new IOException("You need to set the srcMetaCode_BaseDir() before you call the set_SrcMetaCode_AppClasses() method.");

        currDir = new File(hierarchySettings.srcMetaCode_BaseDir + File.separator +
                FileUtilities.convert_DotName_to_Path(hierarchySettings.appClasses_PackageName));
        String currDir_Path = currDir.getCanonicalPath();

        hierarchySettings.srcMetaCode_AppDirPath = currDir_Path;
    }

    
    /**  The base directory where the metacompiled java files are placed. */
    public void set_BuildMeta_BaseDir(String baseDestDir) throws IOException {
        File destDirObj;
        if (baseDestDir != null)
            destDirObj = new File(baseDestDir);
        else
            destDirObj = new File(".");

        hierarchySettings.buildMeta_BaseDir = destDirObj.getCanonicalPath();
    }

    /**  The base directory where the final (and intermediate) classes files are placed. */
    public void set_BuildFinal_BaseDir(String baseDestDir) throws IOException {
        File destDirObj;
        if (baseDestDir != null)
            destDirObj = new File(baseDestDir);
        else
            destDirObj = new File(".");

        hierarchySettings.buildFinal_BaseDir = destDirObj.getCanonicalPath();

    }


    /** If you enable this, the metacompiler will throw an exception instead of printing out the error an exiting. Useful during unit testing. */
    public void set_onReportError_ThrowException_insteadOfExiting(boolean onReportError_ThrowException_insteadOfExiting) {
        hierarchySettings.logger.set_onReportError_ThrowException_insteadOfExiting(onReportError_ThrowException_insteadOfExiting);
    }
    /** If there's an error, print out the internal stack trace of the error. */
    public void set_PrintVerboseErrors(boolean enable) { hierarchySettings.print_VerboseErrors = enable; }
    public void set_Errors_Add(HierarchySettings.Errors error) { hierarchySettings.errorsSettings.add(error); }
    public void set_Warnings_Add(HierarchySettings.Warnings warning) { hierarchySettings.warningSettings.add(warning); }
    
    public void set_CompileMetaFiles_into_FinalClassFiles(boolean compileMetaFiles_into_FinalClassFiles) {
        hierarchySettings.compileMetaFiles_into_FinalClassFiles = compileMetaFiles_into_FinalClassFiles;
    }




    public void clean() throws IOException, Exception_MetaCompilerError {
        System.out.println("Cleaning:");
        if (hierarchySettings.srcMetaCode_BaseDir.equals(hierarchySettings.buildMeta_BaseDir))
            System.out.println("   Note: You've setup the metacompiler to output the generated java files back into \n"
                    + "   your source directory. During the clean, we'll only delete the generated \n"
                    + "   java files, and leave the rest untouched.");
        FileUtilities_Delete.deleteFilesInDir_Recursive(get_BuildMeta_BaseDir(), null,
                HierarchyMetaCompilerUtilities_File.checkJavaFile_for_MetacompilationToken__Filter);
        FileUtilities_Delete.deltree(hierarchySettings.buildFinal_BaseDir, false);

        resetMetaCompiler();
        
        System.out.println("Done!\n");
    }


    public void phase0_InitiallyCompileJavaCode() throws Exception_FileUtilities_ProcessingError, IOException, Exception_HierarchyCompiler {
        
        printIntroductoryInfo();

        System.out.println("\nInitially Compiling Java-files:");

        classpath_Java = setupClassPathForPhase(hierarchySettings.classpath_Java_Raw, classpath_Java_URLS);

        if (hierarchySettings.initiallyCompiledJava_CompileAllJavaFiles)
            hierarchyWorker_InitiallyCompiledJavaFiles = new HierarchyMetaCompilerWorker_InitallyCompiledJavaFiles_CompileAll(this);
        else
            hierarchyWorker_InitiallyCompiledJavaFiles = new HierarchyMetaCompilerWorker_InitallyCompileJavaFiles_CompileSelectedClasses(this);

        initiallyCompiliedJava__Class_FileInfo__List = hierarchyWorker_InitiallyCompiledJavaFiles.collectClassFileList();

        if (initiallyCompiliedJava__Class_FileInfo__List.size() > 0)
           hierarchyUtilities_Compiler.compileAllJavaFiles_forPhase0(hierarchySettings.srcMetaCode_BaseDir, hierarchySettings.buildFinal_BaseDir,
                initiallyCompiliedJava__Class_FileInfo__List, classpath_Java);

        initiallyCompiledJava_haveCompiledJavainPhase0 = true;
        System.out.println("done! " + initiallyCompiliedJava__Class_FileInfo__List.size() + " Java files compiled.\n");
    }



    public void phase1_MetacompileSchemaCode() throws IOException, Exception_HierarchyCompiler {

        if (!initiallyCompiledJava_haveCompiledJavainPhase0)
            printIntroductoryInfo();

        
        System.out.println("\nMetaCompiling Schema Code:");

        schema__Class_FileInfo__List = new ArrayList<Class_FileInfo>();
        schema__Class_FileInfo__Index__byFullClassName = new HashMap<String, Class_FileInfo>();
        schemaFileGenerator_Index__byFullClassName = new HashMap<String, MatrixAndSchema_FileGenerator>();

        schemaPhase_hierarchyControl_ForSchema = new HierarchyControl(hierarchySettings);

        if (hierarchySettings.classpath_AllPhases == null || hierarchySettings.classpath_AllPhases.length() == 0)
            hierarchySettings.classpath_AllPhases = "";
        classpath_Schemas = setupClassPathForPhase(hierarchySettings.classpath_Schemas_Raw, classpath_Schemas_URLS);


        FileUtilities_DirTreeProcessor_Method metaCompileSchemas_DirProcessorMethod = new FileUtilities_DirTreeProcessor_Method() {

            public void processDir(File currDir, File baseDir, Object[] otherParams)
                    throws IOException, Exception_FileUtilities_ProcessingError {

                String packageName = HierarchyMetaCompilerUtilities.getPackageName_ForCurrPackageDir(currDir, hierarchySettings.srcMetaCode_BaseDir);
                String packageDirPath_Relative = HierarchyMetaCompilerUtilities.getPackageDirPath_ForCurrPackageDir(currDir, hierarchySettings.srcMetaCode_BaseDir);
                boolean currPackage_is_AppPackage = packageName.equals(hierarchySettings.appClasses_PackageName);
                String currDir_Path = currDir.getCanonicalPath();
                hierarchySettings.logger.setCurrPackage(packageName);
                hierarchySettings.logger.setCurrLineNumAndColumn(-1, -1);


                String[] schemaFiles_List = currDir.list(schemaFiles_Filter);
                String schemaFileName = null;
                MatrixAndSchema_FileGenerator schemaFileGen = null;

                if (schemaFiles_List != null) {
                    try {
                        for (String schemaFile : schemaFiles_List) {
                            schemaFileName = schemaFile;
                            hierarchySettings.logger.setCurrFileName(schemaFileName);
                            hierarchySettings.logger.setCurrLineNumAndColumn(-1, -1);
                            
                            schemaFileGen = hierarchyUtilities_MetaCompiler.metaCompileFile(MetaCompilation_Phase.MetaCompiling_Schemas,
                                    currDir_Path + "/" + schemaFile,
                                    hierarchySettings.buildMeta_BaseDir, true, schemaFile, packageName, null,
                                    false, schemaPhase_hierarchyControl_ForSchema,
                                    classpath_Schemas_URLS);


                            // add this matrix file gen to the file gen index
                            Class_FileInfo schemaFile_Info = new Class_FileInfo(currDir_Path, packageDirPath_Relative, schemaFileName, packageName,
                                    schemaFileGen.getClassName());
                            schema__Class_FileInfo__List.add(schemaFile_Info);
                            schema__Class_FileInfo__Index__byFullClassName.put(schemaFile_Info.get_FullClassName(), schemaFile_Info);
                            schemaFileGenerator_Index__byFullClassName.put(schemaFile_Info.get_FullClassName(), schemaFileGen);
                            //  Add the external appControl set to the full list of external appcontrols.
                            externalAppControl_Set.addAll(hierarchyUtilities_MetaCompiler.postMetaCompile_GetExternalAppControlSet_forFile());
                        }

                    } catch (IOException e) {
                            throw e;
                    } catch (Exception e) {
                        throw new Exception_FileUtilities_ProcessingError("Had error metacompiling the Schema file, " + schemaFileName + ", in package, " + packageName, e);
                    }
                }
            }
        };





        FileUtilities_DirTreeProcessor dirTreeProcessor = new FileUtilities_DirTreeProcessor();
        dirTreeProcessor.setDirProcessorMethod_ProcessThenTraverse(metaCompileSchemas_DirProcessorMethod);

        try {
            if (hierarchySettings.buildMode_ProjectOrSingleAppPackage == HierarchySettings.BuildMode_ProjectOrSingleAppPackage.BuildProject)
                dirTreeProcessor.traverseAndProcess(hierarchySettings.srcMetaCode_BaseDir);
            else
                dirTreeProcessor.traverseAndProcess(hierarchySettings.srcMetaCode_AppDirPath, false); // only process the app dir!!

        } catch (IOException e) {
            hierarchySettings.logger.reportError_And_Exit(e);
        } catch (Exception e) {
            hierarchySettings.logger.set_SearchForParseException(true);
            hierarchySettings.logger.reportError_And_Exit(e);
        }



        //  Generate appControl and symbol files
        hierarchyUtilities_MetaCompiler.generate_AppControl(hierarchySettings.appClasses_PackageName, hierarchySettings.buildMeta_BaseDir,
                hierarchySettings.appControl_ClassName + ".java", 
                externalAppControl_Set, schema__Class_FileInfo__List, matrix__Class_FileInfo__List, null);
        hierarchyUtilities_MetaCompiler.generateAll_SymbolFiles(hierarchySettings.appClasses_PackageName, hierarchySettings.buildMeta_BaseDir,
                schemaPhase_hierarchyControl_ForSchema.symbolControl);


        //  Compile all the Schema generated files 
        hierarchyUtilities_Compiler.compileAllMatrixFiles(hierarchySettings.buildMeta_BaseDir, hierarchySettings.buildFinal_BaseDir,
                hierarchySettings.get_AppClasses_PackageDirPath_Relative(), schema__Class_FileInfo__List, classpath_Schemas);

        System.out.println("done! " + schema__Class_FileInfo__List.size() +" schema files compiled.\n");

    }
    


    
    //  ____________________________________________________________________________________________________________
    //
    //  Generate FieldSets
    //  ____________________________________________________________________________________________________________
    public void phase2_GenerateFieldSets() throws Exception_MetaCompilerError, Exception_HierarchyCompiler, IOException {
        regenerate_GenerateFieldSets(true);
    }

    public List<Class_FileInfo> regenerate_GenerateFieldSets(boolean is_Phase2)
            throws Exception_MetaCompilerError, Exception_HierarchyCompiler, IOException {

        System.out.println("\nGenerate FieldSets:\nFirst, Load the appControl to create the schemas");


        //  Only need to reload the app class if in phase 2. Nothing new is added during phases 3 and 5 that is needed by the specialized fieldsets.
        if (is_Phase2) {
            //  dyn load the appControl class and all the sym classes.
            appControl = hierarchyUtilities_Compiler.dynReload_AppClasses(hierarchySettings.buildFinal_BaseDir, hierarchySettings.appClasses_PackageName,
                                                                        classpath_Schemas_URLS, running_AppControl_forMetacompilation);
            executeInfo = appControl.getExecutionInfo();
        }


        //  Get all the schemaInfo_FieldSets from the schemas
        schemaInfoFieldSets_List = new ArrayList<SchemaInfo_FieldSet>();

        for (SchemaInfo_Schema schema : appControl.getSchemaControl().schemaIndex_GetStaticSchemas()) {
            HierarchyMetaCompilerUtilities.collect_SchemaInfoFieldSets(schema, schemaInfoFieldSets_List);
        }


        fieldSet__Class_FileInfo__List = new ArrayList<Class_FileInfo>();
        Map<String, Class> externalFieldSets_Index__fromClassName_to_ClassObj =
                appControl.schemaControl.get_FieldSetTupleSpecialized_ExternalFieldSets_Index__fromClassName_to_ClassObj();
        String fieldSet_FileName = null;

        //  Generate the fieldsets for each schemaInfo Fieldset
        for (SchemaInfo_FieldSet schemaInfo_FieldSet : schemaInfoFieldSets_List) {
            FieldSetTupleSpecialized_CodeGenerator fieldSet_CodeGen = new FieldSetTupleSpecialized_CodeGenerator(hierarchySettings, schemaInfo_FieldSet);

            String fieldSet_ClassName = schemaInfo_FieldSet.get_FieldSetTypeString();
            fieldSet_FileName = fieldSet_ClassName + ".java";

            currDir = new File(hierarchySettings.srcMetaCode_AppDirPath); //  *** FOR NOW, just set to this!

            String packageName = HierarchyMetaCompilerUtilities.getPackageName_ForCurrPackageDir(currDir, hierarchySettings.srcMetaCode_BaseDir);
            String packageDirPath_Relative = HierarchyMetaCompilerUtilities.getPackageDirPath_ForCurrPackageDir(currDir, hierarchySettings.srcMetaCode_BaseDir);
            String currDir_Path = currDir.getCanonicalPath();
            String outputDir_Path = hierarchySettings.buildMeta_BaseDir + File.separatorChar + packageDirPath_Relative;

            //  For this fieldset, find its associated schema's codegen_OutputResults. We need the import list from it to add to this 
            //  fieldset's code. NOTE: if this is a fieldset from a schema from an external jar, you won't find an associated output result!
            CodeGen_OutputResults associatedSchemas_OutputResults_for_FieldSet = getAssociatedSchemas_OutputResults_for_FieldSet(
                    schemaInfo_FieldSet, schemaFileGenerator_Index__byFullClassName);
            if (associatedSchemas_OutputResults_for_FieldSet != null)
                fieldSet_CodeGen.set_AssociatedSchemas_ImportSet(associatedSchemas_OutputResults_for_FieldSet.getImportSet());

            //  if this is an external fieldset, pass in the external fieldsets full class name.
            Class externalFieldSet_ClassObj = externalFieldSets_Index__fromClassName_to_ClassObj.get(fieldSet_ClassName);
            if (externalFieldSet_ClassObj != null)
                fieldSet_CodeGen.set_ExternalFieldSet_ClassObj(externalFieldSet_ClassObj);

            CodeBuilder fieldSet_CodeBuilder = fieldSet_CodeGen.generate_Specialized_FieldSetTupleClass(executeInfo,
                    packageName, appControl.getSymbolControl());
            FileUtilities.writeToFile(outputDir_Path, fieldSet_FileName, true, fieldSet_CodeBuilder.toString(), hierarchySettings.DEBUG);


            Class_FileInfo fieldSetFile_Info = new Class_FileInfo(outputDir_Path, packageDirPath_Relative, fieldSet_FileName,
                    packageName, fieldSet_ClassName);
            fieldSet__Class_FileInfo__List.add(fieldSetFile_Info);
        }



        if (is_Phase2) {
            //  Generate appControl and symbol files
            hierarchyUtilities_MetaCompiler.generate_AppControl(hierarchySettings.appClasses_PackageName, hierarchySettings.buildMeta_BaseDir,
                    hierarchySettings.appControl_ClassName + ".java", externalAppControl_Set, 
                    schema__Class_FileInfo__List, matrix__Class_FileInfo__List, fieldSet__Class_FileInfo__List);
            hierarchyUtilities_MetaCompiler.generateAll_SymbolFiles(hierarchySettings.appClasses_PackageName, hierarchySettings.buildMeta_BaseDir,
                    appControl.symbolControl);


            //  Compile all the fieldset generated files (except the Schema files - maybe needed though)
            hierarchyUtilities_Compiler.compileAllMatrixFiles(hierarchySettings.buildMeta_BaseDir, hierarchySettings.buildFinal_BaseDir,
                    hierarchySettings.get_AppClasses_PackageDirPath_Relative(), fieldSet__Class_FileInfo__List,
                    classpath_Schemas);

            System.out.println("done! " + fieldSet__Class_FileInfo__List.size() +" specialized fieldsets compiled.\n");

        } else {
            System.out.println("done! " + fieldSet__Class_FileInfo__List.size() +" specialized fieldsets generated.\n");
        }

        return new ArrayList<Class_FileInfo>(fieldSet__Class_FileInfo__List);
    }


    
    private CodeGen_OutputResults getAssociatedSchemas_OutputResults_for_FieldSet(SchemaInfo_FieldSet schemaInfo_FieldSet,
            Map<String, MatrixAndSchema_FileGenerator> schemaFileGenerator_Index__byFullClassName)
            throws ExceptRuntime_HierarchyMetaCompilerError {

        MatrixAndSchema_FileGenerator schemaFileGen_for_FieldSet = schemaFileGenerator_Index__byFullClassName.get(
                schemaInfo_FieldSet.getSchemaInfo_SchemaNameFull().getClassName_Full());
        /*
        if (schemaFileGen_for_FieldSet == null) {
            String schemaName = null;
            try {
                schemaName = schemaInfo_FieldSet.getSchemaInfo_SchemaNameFull().getClassName_Full();
            } catch(Exception e) { }
            String fieldSetName = null;
            try {
                fieldSetName = schemaInfo_FieldSet.getSchemaInfo_DescTagName_FullPath_String(executeInfo);
            } catch(Exception e) {  }
            throw new ExceptRuntime_HierarchyMetaCompilerError("For a fieldset named, " + fieldSetName +
                    ", Tried to find the metacompilation results for the fieldset's associated schema, but could not find it. The schema name we"
                    + " looked for was, " + schemaName);
        }
        */

        if (schemaFileGen_for_FieldSet != null)
            return schemaFileGen_for_FieldSet.getCodeGen_OutputResults();
        else
            return null;
    }


    //  ____________________________________________________________________________________________________________
    //
    //  MetaCompile Matrices
    //  ____________________________________________________________________________________________________________

    public void phase3_MetacompileMatrices() throws Exception_MetaCompilerError, Exception_HierarchyCompiler, IOException {

        System.out.println("\n\nMetaCompiling Matrix Code:");


        //  Dyn reload all the regenerated appControl files: the appControl class (w/ the fieldsets) and all the sym classes
        //  Use the classpath from phase 1 plus HierarchyJar and build final
        appControl =  hierarchyUtilities_Compiler.dynReload_AppClasses(hierarchySettings.buildFinal_BaseDir, hierarchySettings.appClasses_PackageName,
                                classpath_Schemas_URLS, running_AppControl_forMetacompilation);
        executeInfo = appControl.getExecutionInfo();

        checkAppControl_FieldSetIndex();

        classpath_Matrices = setupClassPathForPhase(hierarchySettings.classpath_Matrices_Raw, classpath_Matrices_URLS);

        matrix__Class_FileInfo__List = new ArrayList<Class_FileInfo>();
        matrix__Class_FileInfo__Index__byFullClassName = new HashMap<String, Class_FileInfo>();
        matrixFileGenerator_Index__byFullClassName = new HashMap<String, MatrixAndSchema_FileGenerator>();
        

        FileUtilities_DirTreeProcessor_Method metaCompileMatrices_DirProcessorMethod = new FileUtilities_DirTreeProcessor_Method() {

            public void processDir(File currDir, File baseDir, Object[] otherParams)
                    throws IOException, Exception_FileUtilities_ProcessingError {

                String packageName = HierarchyMetaCompilerUtilities.getPackageName_ForCurrPackageDir(currDir, hierarchySettings.srcMetaCode_BaseDir);
                String packageDirPath_Relative = HierarchyMetaCompilerUtilities.getPackageDirPath_ForCurrPackageDir(currDir, hierarchySettings.srcMetaCode_BaseDir);
                boolean currPackage_is_AppPackage = packageName.equals(hierarchySettings.appClasses_PackageName);
                String currDir_Path = currDir.getCanonicalPath();
                hierarchySettings.logger.setCurrPackage(packageName);
                hierarchySettings.logger.setCurrLineNumAndColumn(-1, -1);


                String matrixFileName = null;
                String[] matrixFiles_List = currDir.list(matrixFiles_Filter);

                if (matrixFiles_List != null) {
                    try {

                        for (String matrixFile : matrixFiles_List) {
                            matrixFileName = matrixFile;
                            hierarchySettings.logger.setCurrFileName(matrixFileName);
                            hierarchySettings.logger.setCurrLineNumAndColumn(-1, -1);

                            //  First, pre-processes the Matix file and grab it's matrix settings.
                            HierarchySettings_forMatrix matrixSettings = hierarchyWorker_MatrixSettingsCollector.getMatrixSettings(
                                    currDir_Path + "/" + matrixFileName);
                            System.out.println("   - Metacompiling Matrix [" + currDir_Path + "/" + matrixFileName + "], Is Persistent Matrix ["
                                    + matrixSettings.IsPersitentMatrix + "]");

                            MatrixAndSchema_FileGenerator matrixFileGen = hierarchyUtilities_MetaCompiler.metaCompileFile(
                                    MetaCompilation_Phase.MetaCompiling_Matrices, currDir_Path + "/" + matrixFile, 
                                    hierarchySettings.buildMeta_BaseDir, false, matrixFile, packageName, matrixSettings, 
                                    false, appControl, null, classpath_Matrices_URLS);


                            // add this matrix file gen to the file gen index
                            Class_FileInfo matrixFile_Info = new Class_FileInfo(currDir_Path, packageDirPath_Relative, matrixFileName,
                                    packageName, matrixFileGen.getClassName());
                            matrix__Class_FileInfo__List.add(matrixFile_Info);
                            matrix__Class_FileInfo__Index__byFullClassName.put(matrixFile_Info.get_FullClassName(), matrixFile_Info);

                            matrixFileGenerator_Index__byFullClassName.put(matrixFile_Info.get_FullClassName(), matrixFileGen);
                            //  Add the external appControl set to the full list of external appcontrols.
                            externalAppControl_Set.addAll(hierarchyUtilities_MetaCompiler.postMetaCompile_GetExternalAppControlSet_forFile());

                            matrixSettings_Index__byFullClassName.put(matrixFile_Info.get_FullClassName(), matrixSettings);
                        }

                    } catch (IOException e) {
                            throw e;
                    } catch (Exception e) {
                        throw new Exception_FileUtilities_ProcessingError("Had error metacompiling the Matrix file, " + matrixFileName + ", in package, " + packageName, e);
                    }
                }
            }
        };



        FileUtilities_DirTreeProcessor dirTreeProcessor = new FileUtilities_DirTreeProcessor();
        dirTreeProcessor.setDirProcessorMethod_ProcessThenTraverse(metaCompileMatrices_DirProcessorMethod);

        try {
            if (hierarchySettings.buildMode_ProjectOrSingleAppPackage == HierarchySettings.BuildMode_ProjectOrSingleAppPackage.BuildProject)
                dirTreeProcessor.traverseAndProcess(hierarchySettings.srcMetaCode_BaseDir);
            else
                dirTreeProcessor.traverseAndProcess(hierarchySettings.srcMetaCode_AppDirPath, false); // only process the app dir!!
        } catch (IOException e) {
            hierarchySettings.logger.reportError_And_Exit(e);
        } catch (Exception e) {
            hierarchySettings.logger.set_SearchForParseException(true);
            hierarchySettings.logger.reportError_And_Exit(e);
        }


        //  Before you can recompile any files, you need to generate all the specialized fieldsets for external schemas used directly
        //  or used in external matrices by the embedded files.
        List<Class_FileInfo> MatrixAndFieldSet__Class_FileInfo__List = this.regenerate_GenerateFieldSets(false);
        //  add matrixClassFiles
        MatrixAndFieldSet__Class_FileInfo__List.addAll(matrix__Class_FileInfo__List);



        //  Generate appControl and symbol files
        hierarchyUtilities_MetaCompiler.generate_AppControl(hierarchySettings.appClasses_PackageName, hierarchySettings.buildMeta_BaseDir,
                hierarchySettings.appControl_ClassName + ".java",
                externalAppControl_Set, schema__Class_FileInfo__List, matrix__Class_FileInfo__List, fieldSet__Class_FileInfo__List);

        hierarchyUtilities_MetaCompiler.generateAll_SymbolFiles(hierarchySettings.appClasses_PackageName, hierarchySettings.buildMeta_BaseDir,
                appControl.symbolControl);


        //  Compile all the matrix generated files
        hierarchyUtilities_Compiler.compileAllMatrixFiles(hierarchySettings.buildMeta_BaseDir, hierarchySettings.buildFinal_BaseDir,
                hierarchySettings.get_AppClasses_PackageDirPath_Relative(), MatrixAndFieldSet__Class_FileInfo__List, classpath_Matrices);


        System.out.println("done! " + matrix__Class_FileInfo__List.size() +" matrices compiled.\n");

    }



    //  ____________________________________________________________________________________________________________
    //
    //  Collect typeinfo for classes, enums and interfaces, so the typeinfo index can be used by the metacompiler.
    //  ____________________________________________________________________________________________________________

    public void phase4_CollectTypeInfo() throws IOException, Exception_FindTypeName, Exception_HierarchyCompiler  {

        if (hierarchySettings.DEBUG_PRINT_FLATTENEDMATRICES)
            printFlattenedMatrices();


        // add the ALL classpaths to the matrix classpaths
        classpath_EmbeddedFiles = setupClassPathForPhase(hierarchySettings.classpath_EmbeddedFiles_Raw, classpath_EmbeddedFiles_URLS);


        FileUtilities_DirTreeProcessor_Method collectTypeInfo_DirProcessorMethod = new FileUtilities_DirTreeProcessor_Method() {

            public void processDir(File currDir, File baseDir, Object[] otherParams) 
                    throws IOException, Exception_FileUtilities_ProcessingError {

                String packageName = HierarchyMetaCompilerUtilities.getPackageName_ForCurrPackageDir(currDir, hierarchySettings.srcMetaCode_BaseDir);
                boolean currPackage_is_AppPackage = packageName.equals(hierarchySettings.appClasses_PackageName);
                hierarchySettings.logger.setCurrPackage(packageName);
                hierarchySettings.logger.setCurrLineNumAndColumn(-1, -1);


                File[] javaAndEmbeddedFiles_List = currDir.listFiles(javaAndEmbeddedFiles_Filter);
                if (javaAndEmbeddedFiles_List != null) {
                    for (File file : javaAndEmbeddedFiles_List) {
                        String fileName = null;
                        String primaryClassName = null;
                        try {
                            fileName = file.getName();
                            primaryClassName = fileName.substring(0, fileName.lastIndexOf('.'));
                            hierarchySettings.logger.setCurrFileName(fileName);
                            hierarchySettings.logger.setCurrLineNumAndColumn(-1, -1);

                            
                            //  Only compile the non app control files.
                            if (!(currPackage_is_AppPackage && (
                                     fileName.startsWith(hierarchySettings.appSymbols_ClassName) || primaryClassName.equals(hierarchySettings.appControl_ClassName)
                                   )
                               )) {
                                
                                boolean wasInterface_Skip = false;
                                try {
                                    hierarchyUtilities_MetaCompiler.metaCompileFile_GetTypeInfo(file.getAbsolutePath(), fileName, packageName,
                                          primaryClassName, symbolTable_App, appControl, classpath_EmbeddedFiles_URLS);
                                    
                                } catch (ExceptRuntime_UnsupportedLanguageFeature e) {
                                    //  **** Interfaces and Annotated interfaces are NOT currently supported by metacompilation. skip these files
                                    wasInterface_Skip = true;
                                }
                                if (!wasInterface_Skip) {
                                    //  Add the external appControl set to the full list of external appcontrols.
                                    externalAppControl_Set.addAll(hierarchyUtilities_MetaCompiler.postMetaCompile_GetExternalAppControlSet_forFile());
                                }
                            }

                        } catch (IOException e) {
                            throw e;
                        } catch (Exception e) {
                            throw new Exception_FileUtilities_ProcessingError("Had error collecting type info for the file, " + fileName +
                                    ", whose class name is, " + primaryClassName + " and whose package is, " + packageName, e);
                        }
                    }
                }
            }
        };



        FileUtilities_DirTreeProcessor dirTreeProcessor = new FileUtilities_DirTreeProcessor();
        dirTreeProcessor.setDirProcessorMethod_ProcessThenTraverse(collectTypeInfo_DirProcessorMethod);

        try {
            if (hierarchySettings.buildMode_ProjectOrSingleAppPackage == HierarchySettings.BuildMode_ProjectOrSingleAppPackage.BuildProject)
                dirTreeProcessor.traverseAndProcess(hierarchySettings.srcMetaCode_BaseDir);
            else
                dirTreeProcessor.traverseAndProcess(hierarchySettings.srcMetaCode_AppDirPath, false); // only process the app dir!!
        } catch (IOException e) {
            hierarchySettings.logger.reportError_And_Exit(e);
        } catch (Exception e) {
            hierarchySettings.logger.set_SearchForParseException(true);
            hierarchySettings.logger.reportError_And_Exit(e);
        }



        // Phase 4.1 - Set the full type names for the types usages (liked extending a type or local vars or fields...) using the class finder.
        // We had to wait until now to do this
        // because we need to have the typeInfo's for all the different types in the system before we can use the class finder to search
        // for the inherited types' full type names.

        symbolTable_App.setTypeUsage_FullTypeName();


    }





    //  ____________________________________________________________________________________________________________
    //
    //  MetaCompile Embedded Java files
    //  ____________________________________________________________________________________________________________


    public void phase5_MetaCompileEmbeddedJavaFiles() 
            throws Exception_HierarchyCompiler, Exception_MetaCompilerError, IOException, Exception_FileUtilities_ProcessingError {

        System.out.println("\n\nMetaCompiling Embedded Java Files:");

/*
        //  reload the updated appControl with the Matrices.
        //  dyn reload all the regenerated appControl files: the appControl class  and all the sym classes
        appControl = (AppControl_Base)appControlClass.newInstance();
        executeInfo = appControl.getExecutionInfo();

        checkAppControl_FieldSetIndex();
*/

        embedded__Class_FileInfo__List = new ArrayList<Class_FileInfo>();
        String packageName = HierarchyMetaCompilerUtilities.getPackageName_ForCurrPackageDir(currDir, hierarchySettings.srcMetaCode_BaseDir);
        hierarchyUtilities_MetaCompiler.setSymbolTable_App(symbolTable_App);


        FileUtilities_DirTreeProcessor_Method metaCompileEmbedded_DirProcessorMethod = new FileUtilities_DirTreeProcessor_Method() {

            public void processDir(File currDir, File baseDir, Object[] otherParams)
                    throws IOException, Exception_FileUtilities_ProcessingError {

                String packageName = HierarchyMetaCompilerUtilities.getPackageName_ForCurrPackageDir(currDir, hierarchySettings.srcMetaCode_BaseDir);
                String packageDirPath_Relative = HierarchyMetaCompilerUtilities.getPackageDirPath_ForCurrPackageDir(currDir, hierarchySettings.srcMetaCode_BaseDir);
                boolean currPackage_is_AppPackage = packageName.equals(hierarchySettings.appClasses_PackageName);
                String currDir_Path = currDir.getCanonicalPath();
                hierarchySettings.logger.setCurrPackage(packageName);
                hierarchySettings.logger.setCurrLineNumAndColumn(-1, -1);


                String[] embeddedFiles_List = currDir.list(embeddedFiles_Filter);
                String embeddedFileName = null;

                if (embeddedFiles_List != null) {
                    try {
                        for (String embeddedFile : embeddedFiles_List) {
                            embeddedFileName = embeddedFile;
                            String primaryClassName = embeddedFile.substring(0, embeddedFile.lastIndexOf('.'));
                            hierarchySettings.logger.setCurrFileName(embeddedFileName);
                            hierarchySettings.logger.setCurrLineNumAndColumn(-1, -1);

                
                            String embeddedClassName = hierarchyUtilities_MetaCompiler.metaCompileEmbeddedFile(
                                    currDir_Path + "/" + embeddedFile,
                                    hierarchySettings.buildMeta_BaseDir, embeddedFile, packageName, primaryClassName, true, appControl,
                                    classpath_EmbeddedFiles_URLS);


                            Class_FileInfo embeddedFile_Info = new Class_FileInfo(currDir_Path, packageDirPath_Relative, embeddedFileName, packageName,
                                    embeddedClassName);
                            embedded__Class_FileInfo__List.add(embeddedFile_Info);
                            //  Add the external appControl set to the full list of external appcontrols.
                            externalAppControl_Set.addAll(hierarchyUtilities_MetaCompiler.postMetaCompile_GetExternalAppControlSet_forFile());
                        }

                    } catch (IOException e) {
                            throw e;
                    } catch (Exception e) {
                        throw new Exception_FileUtilities_ProcessingError("Had error metacompiling the embedded file, " + embeddedFileName + ", in package, " + packageName, e);
                    }
                }
            }
        };



        FileUtilities_DirTreeProcessor dirTreeProcessor = new FileUtilities_DirTreeProcessor();
        dirTreeProcessor.setDirProcessorMethod_ProcessThenTraverse(metaCompileEmbedded_DirProcessorMethod);

        try {
            if (hierarchySettings.buildMode_ProjectOrSingleAppPackage == HierarchySettings.BuildMode_ProjectOrSingleAppPackage.BuildProject)
                dirTreeProcessor.traverseAndProcess(hierarchySettings.srcMetaCode_BaseDir);
            else
                dirTreeProcessor.traverseAndProcess(hierarchySettings.srcMetaCode_AppDirPath, false); // only process the app dir!!

        } catch (IOException e) {
            hierarchySettings.logger.reportError_And_Exit(e);
        } catch (Exception e) {
            hierarchySettings.logger.set_SearchForParseException(true);
            hierarchySettings.logger.reportError_And_Exit(e);
        }

        if (!initiallyCompiledJava_haveCompiledJavainPhase0)  { // if you haven't already copied over the Java code, do so now (this could have already happened in phase 0)
            classpath_Java = setupClassPathForPhase(hierarchySettings.classpath_Java_Raw, classpath_Java_URLS);
            initiallyCompiliedJava__Class_FileInfo__List = (hierarchyWorker_InitiallyCompiledJavaFiles != null ?
                hierarchyWorker_InitiallyCompiledJavaFiles.copyToBuild() : null);
        }


        //  Re-generate the modified Matrix files.
        for (MatrixAndSchema_FileGenerator matrix_FileGen : matrixFileGenerator_Index__byFullClassName.values()) {
            matrix_FileGen.writeToFile(hierarchySettings.DEBUG);
        }

        //  Before you can recompile any files, you need to generate all the specialized fieldsets for external schemas used directly
        //  or used in external matrices by the embedded files.
        List<Class_FileInfo> fieldSetAndMatrix__Class_FileInfo__List = this.regenerate_GenerateFieldSets(false);
        //  add matrixClassFiles
        fieldSetAndMatrix__Class_FileInfo__List.addAll(matrix__Class_FileInfo__List);


        //  Generate appControl and symbol files
        hierarchyUtilities_MetaCompiler.generate_AppControl(hierarchySettings.appClasses_PackageName, hierarchySettings.buildMeta_BaseDir,
                hierarchySettings.appControl_ClassName + ".java",
                externalAppControl_Set, schema__Class_FileInfo__List, matrix__Class_FileInfo__List, fieldSet__Class_FileInfo__List);

        hierarchyUtilities_MetaCompiler.generateAll_SymbolFiles(hierarchySettings.appClasses_PackageName, hierarchySettings.buildMeta_BaseDir,
                appControl.symbolControl);




        //  Compile all the matrix generated files

        // default should be you want to compile all the meta files into class files.
        if (hierarchySettings.compileMetaFiles_into_FinalClassFiles) {
            System.out.println("\n\nCompiling Generated Java-Files into Class files:");
            hierarchyUtilities_Compiler.compileAllMatrixFiles(hierarchySettings.buildMeta_BaseDir, hierarchySettings.buildFinal_BaseDir,
                    hierarchySettings.get_AppClasses_PackageDirPath_Relative(),
                    fieldSetAndMatrix__Class_FileInfo__List, embedded__Class_FileInfo__List, initiallyCompiliedJava__Class_FileInfo__List,
                    classpath_EmbeddedFiles);

            System.out.println("    Compiled metafiles into final class files.");

        } else {
            System.out.println("    CompileMetaFiles.into.finalClassFiles setting was false, did not compile final class files.");
        }

        System.out.println("\ndone! " + embedded__Class_FileInfo__List.size() +" embedded files meta-compiled.\n");

    }



    public HierarchySettings get_HierarchySettings() { return hierarchySettings; }
    public AppControl_Base get_AppControl() { return appControl;}


    /**  The directory where the hierarchy jar file is located. */
    public String get_HierarchyJar_Dir() { return hierarchySettings.hierarchyJar_Dir; }
    /**  The directory where the javac compiler executable is located. */
    public String get_javac_Dir() { return hierarchySettings.javac_Dir; }

    public String get_SrcMetaCode_BaseDirPath() { return hierarchySettings.srcMetaCode_BaseDir; }
    /**  The actual directory where the source files to metacompile are located (including package directories). */
    public String get_SrcMetaCode_FullDirPath() { return hierarchySettings.srcMetaCode_AppDirPath; }
    /**  The base directory where the metacompiled java files are placed. */
    public String get_BuildMeta_BaseDir() { return hierarchySettings.buildMeta_BaseDir; }
    public String get_BuildMeta_MatrixAppFiles_DestDir() { return hierarchySettings.get_DestMeta_MatrixAppFiles_DestDir(); }

    /**  The base directory where the final (and intermediate) classes files are placed. */
    public String get_BuildFinal_BaseDir() { return hierarchySettings.buildFinal_BaseDir;}
    public String get_BuildFinal_MatrixAppFiles_DestDir() { return hierarchySettings.get_DestBuild_MatrixAppFiles_DestDir(); };

    /**  The name of the package for all the Matrix application classes (such as AppControl, AppSymbols, AppSymbols_DescTag...).*/
    public String get_AppClasses_PackageName() { return hierarchySettings.appClasses_PackageName; }



/*
    public List<String> getMatrixClassNames_List() {
        return matrix__Class_FileInfo__List;
    }

    public Map<String, MatrixAndSchema_FileGenerator> getMatrixFileGenerator_Index_byName() {
        return matrixFileGenerator_Index__byFullClassName;
    }

    public List<String> getSchemaClassNames_List() {
        return schema__Class_FileInfo__List;
    }
*/
    public Map<String, MatrixAndSchema_FileGenerator> getSchemaFileGenerator_Index_byFullClassName() {
        return schemaFileGenerator_Index__byFullClassName;
    }

    public LangSymbolTable_App getSymbolTable_App() {
        return symbolTable_App;
    }


    public String get_Classpath_AllPhases() { return hierarchySettings.classpath_AllPhases; }
    public String get_Classpath_Schemas() { return classpath_Schemas;}
    public String get_Classpath_Matrices() { return classpath_Matrices; }
    public String get_Classpath_EmbeddedFiles() { return classpath_EmbeddedFiles; }

    public List<URL> get_Classpath_AllPhases_URLS() { return classpath_AllPhases_URLS; }
    public List<URL> get_Classpath_EmbeddedFiles_URLS() { return classpath_EmbeddedFiles_URLS; }
    public List<URL> get_Classpath_Matrices_URLS() { return classpath_Matrices_URLS; }
    public List<URL> get_Classpath_Schemas_URLS() { return classpath_Schemas_URLS; }



    public static List<URL> parseClassPath_intoURLs(String classpath, HierarchySettings hierarchySettings) throws MalformedURLException {

        DynamicClassUtilities.WarningAndError_Settings warningAndErrorSettings_InvalidClassPaths = 
                HierarchySettings_Utilities.warningsAndErrors__ConvertInvalidClassPathElementSetting(hierarchySettings);
        List<String> warningMessage_List = new ArrayList<String>();

        List<URL> classPath_URLs = new ArrayList<URL>();
        
        if (classpath != null && classpath.trim().length() > 0) {
            String[] classPath_Strings = classpath.split(File.pathSeparator);
            if (classPath_Strings != null)
                classPath_URLs = DynamicClassUtilities.classPath__CreateUrls(classPath_Strings, warningAndErrorSettings_InvalidClassPaths, warningMessage_List);
        }

        for (String warningMessageString : warningMessage_List)
            System.out.println(warningMessageString);

        
        return classPath_URLs;
    }

    

    void checkAppControl_FieldSetIndex() throws Exception_MetaCompilerError {

        Map<Symbol, Constructor> fieldSet_Index = appControl.get_FieldSetTupleSpecialized_Constructor_Index();
        if (fieldSet_Index == null || fieldSet_Index.size() != fieldSet__Class_FileInfo__List.size()) {
            throw new Exception_MetaCompilerError("Have built the specialized fieldsets, but the newly generated app control does not have the correct number of specialized fieldsets in its fieldset index. It has " +
                    (fieldSet_Index != null ? fieldSet_Index.size() : 0) + " fieldsets and it should have " + fieldSet__Class_FileInfo__List.size() + ".");
        }
    }


    //  Setup classpaths for phase
    //  add the ALL classpaths to the phase's classpaths
    //  returns the classpath_<for Phase> string.
    String setupClassPathForPhase(String classpath_forPhase_Raw, List<URL> OUT__classpath_forPhase_URLS)
            throws MalformedURLException {
        if (classpath_AllPhases_URLS == null)
            classpath_AllPhases_URLS = parseClassPath_intoURLs(hierarchySettings.classpath_AllPhases, hierarchySettings);

        List<URL> classPath_URLS = parseClassPath_intoURLs(classpath_forPhase_Raw, hierarchySettings);
        OUT__classpath_forPhase_URLS.addAll(classPath_URLS);
        OUT__classpath_forPhase_URLS.addAll(classpath_AllPhases_URLS);

        String classpath_forPhase = null;
        if (hierarchySettings.classpath_AllPhases != null && hierarchySettings.classpath_AllPhases.length() > 0) {
            if (classpath_forPhase_Raw != null && classpath_forPhase_Raw.length() > 0)
                classpath_forPhase = classpath_forPhase_Raw + File.pathSeparatorChar + hierarchySettings.classpath_AllPhases;
            else
                classpath_forPhase = hierarchySettings.classpath_AllPhases;
        } else
                classpath_forPhase = classpath_forPhase_Raw;
        
        return classpath_forPhase;
    }



    void printFlattenedMatrices() {
        //  TODO - add a metacompiler switch so you can print these out
        /*
        StringBuilder strBuilder = new StringBuilder();

        MatrixStructInfoIndex_Container container = appControl.getMatrixControl().get_MatrixUsageStructIndex_Container();
        MatrixStructInfo_DescriptorContainer descContainer = container.matrixStructInfoIndex_byString.get("maintests.samples::Test.Matrix2");
        ((Descriptor)descContainer.descriptor_Flattened).print(strBuilder, 0, false);
        System.out.println(strBuilder);
        System.out.println("\n\nIn your Embedded Java files - Collecting Type Info information:");

         */
    }

    private void printIntroductoryInfo() throws IOException {

        System.out.println("____________________________________________________________________________________________________________________\n");

        System.out.println("  Hierarchy Metacompiler Settings");
        System.out.println("____________________________________________________________________________________________________________________\n");
        
        System.out.println(" o Base Directory of Meta-code Source: " + hierarchySettings.srcMetaCode_BaseDir);
        System.out.println(" o Meta-Build Directory where the generated Java Files are placed: " + hierarchySettings.buildMeta_BaseDir);
        System.out.println(" o Final-Build Directory where the class files are placed: " + hierarchySettings.buildFinal_BaseDir);
        
        System.out.print(" o ");
        hierarchyUtilities_Compiler.print_Javac_Version(hierarchySettings.javac_Dir);

        if (hierarchySettings.printClassPath_MetacompilerJVMs_Classpath) {
            System.out.println("\nClasspath of the Metacompiler's JVM:");
            DynamicClassUtilities.printJVMClassPath();
            System.out.println("\n");
        }
        System.out.println("____________________________________________________________________________________________________________________\n");

        System.out.println("  Meta-compilation Output");
        System.out.println("____________________________________________________________________________________________________________________");
    }






}
