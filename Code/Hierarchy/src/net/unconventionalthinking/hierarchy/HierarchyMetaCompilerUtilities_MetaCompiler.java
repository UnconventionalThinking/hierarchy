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
import net.unconventionalthinking.hierarchy.compileractions.LangSymbolTableActions__SymCreator;
import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null;
import net.unconventionalthinking.matrix.AppControl_Base;
import net.unconventionalthinking.matrix.metacompiler.codefilegen.AppControlFile_Generator;
import net.unconventionalthinking.matrix.metacompiler.codefilegen.EmbeddedFile_Worker_FileGenerator;
import net.unconventionalthinking.matrix.metacompiler.codefilegen.MatrixAndSchema_FileGenerator;
import net.unconventionalthinking.matrix.metacompiler.codefilegen.SymbolFile_Generator;
import net.unconventionalthinking.matrix.metacompiler.codefilegen.SymbolFile_Generator_MultiLevel;
import net.unconventionalthinking.matrix.metacompiler.codegen.CodeGen_OutputResults;
import net.unconventionalthinking.matrix.metacompiler.codegen.CodeGenerators_MatrixAccess;
import net.unconventionalthinking.matrix.metacompiler.codegen.DescriptorCreation_CodeGenerator;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.MatrixStructInfo_DescriptorContainer;
import net.unconventionalthinking.matrix.symbols.MatrixName;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.matrix.symbols.SymbolType;
import net.unconventionalthinking.matrix.symbols.Symbol_Index;
import net.unconventionalthinking.matrix.symbols.Symbol_Index_MultiLevel;
import net.unconventionalthinking.hierarchy.compileractions.MetaCompilation_Phase;
import net.unconventionalthinking.utilities.FileUtilities;
import net.unconventionalthinking.hierarchy.compileractions.HierarchyActions;
import net.unconventionalthinking.hierarchy.grammar.lexer.Lexer;
import net.unconventionalthinking.hierarchy.grammar.lexer.LexerException;
import net.unconventionalthinking.hierarchy.grammar.node.Start;
import net.unconventionalthinking.hierarchy.grammar.parser.Parser;
import net.unconventionalthinking.hierarchy.grammar.parser.ParserException;
import net.unconventionalthinking.hierarchy.langsymboltable.TypeInfo;
import net.unconventionalthinking.hierarchy.langsymboltable.TypeInfo_SrcCodeFileInfo;
import net.unconventionalthinking.utilities.ListUtilities;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author peterjoh
 */
public class HierarchyMetaCompilerUtilities_MetaCompiler {



    private HierarchySettings hierarchySettings;
    private LangSymbolTable_App symbolTable_App;

    private HashSet<AppControl_Info> externalAppControlSet_forFile;


    public HierarchyMetaCompilerUtilities_MetaCompiler(HierarchySettings hierarchySettings) {
        this.hierarchySettings = hierarchySettings;
    }

    public void setSymbolTable_App(LangSymbolTable_App symbolTable_App) { this.symbolTable_App = symbolTable_App; }

    


    public MatrixAndSchema_FileGenerator metaCompileFile(MetaCompilation_Phase metaCompilation_Phase, String srcFile_Path, String destDir_Path,
            boolean is_Schema, String fileName, String packageName, HierarchySettings_forMatrix matrixSettings, boolean fileSymbolTable_Enabled,
            HierarchyControl hierarchyControl, List<URL> classPath)
            throws FileNotFoundException, Exception_HierarchyCompiler, Exception_MetaCompilerError {
        //  Create a new parser instance
        BufferedReader sourceFileReader = new BufferedReader(new FileReader(srcFile_Path));

        return metaCompileFile(metaCompilation_Phase, sourceFileReader, destDir_Path, is_Schema, fileName, packageName, matrixSettings, fileSymbolTable_Enabled, hierarchyControl,
                null, null, classPath);
    }
    public MatrixAndSchema_FileGenerator metaCompileFile(MetaCompilation_Phase metaCompilation_Phase, String srcFile_Path, String destDir_Path,
            boolean is_Schema, String fileName, String packageName, HierarchySettings_forMatrix matrixSettings, boolean fileSymbolTable_Enabled,
            AppControl_Base appControl, Set<String> existing_ImportSet, List<URL> classPath)
            throws FileNotFoundException, Exception_HierarchyCompiler, Exception_MetaCompilerError {

        //  Create a new parser instance
        BufferedReader sourceFileReader = new BufferedReader(new FileReader(srcFile_Path));

        return metaCompileFile(metaCompilation_Phase, sourceFileReader, destDir_Path, is_Schema, fileName, packageName, matrixSettings, fileSymbolTable_Enabled, appControl,
                existing_ImportSet, classPath);
    }


    public MatrixAndSchema_FileGenerator metaCompileFile(MetaCompilation_Phase metaCompilation_Phase, BufferedReader sourceFileReader,
            String destDir_Path, boolean is_Schema, String fileName, String packageName, HierarchySettings_forMatrix matrixSettings,
            boolean fileSymbolTable_Enabled, HierarchyControl hierarchyControl, List<URL> classPath)
            throws Exception_HierarchyCompiler, Exception_MetaCompilerError {
        return metaCompileFile(metaCompilation_Phase, sourceFileReader, destDir_Path, is_Schema, fileName, packageName, matrixSettings, fileSymbolTable_Enabled, hierarchyControl,
                null, null, classPath);
    }
    public MatrixAndSchema_FileGenerator metaCompileFile(MetaCompilation_Phase metaCompilation_Phase, BufferedReader sourceFileReader,
            String destDir_Path, boolean is_Schema, String fileName, String packageName, HierarchySettings_forMatrix matrixSettings,
            boolean fileSymbolTable_Enabled, AppControl_Base appControl, Set<String> existing_ImportSet, List<URL> classPath)
            throws Exception_HierarchyCompiler, Exception_MetaCompilerError {
        return metaCompileFile(metaCompilation_Phase, sourceFileReader, destDir_Path, is_Schema, fileName, packageName, matrixSettings, fileSymbolTable_Enabled, null, appControl,
                null, classPath);
    }


    private MatrixAndSchema_FileGenerator metaCompileFile(MetaCompilation_Phase metaCompilation_Phase,
            BufferedReader sourceFileReader, String destDir_Path, boolean is_Schema,
            String fileName, String packageName, HierarchySettings_forMatrix matrixSettings, boolean fileSymbolTable_Enabled, HierarchyControl hierarchyControl, AppControl_Base appControl, Set<String> existing_ImportSet,
            List<URL> classPath)
            throws Exception_HierarchyCompiler, Exception_MetaCompilerError {

        Parser p = new Parser(new Lexer(new PushbackReader(sourceFileReader)));

        Start tree = null;
        try {
            //  Parse the input
            tree = p.parse();
        } catch (ParserException pexcept) {
            throw new Exception_MetaCompilerError("Metacompiler error on matrix or schema file", pexcept);
        } catch (LexerException lexcept) {
            throw new Exception_MetaCompilerError("Metacompiler error on matrix or schema file", lexcept);
        } catch (IOException ioe) {
            throw new Exception_MetaCompilerError("Metacompiler error on matrix or schema file", ioe);
        }


        //  Apply the translation
        HierarchyActions hierarchyMetaCompiler_Actions = null;
        if (appControl == null ) {
            hierarchyMetaCompiler_Actions = new HierarchyActions(metaCompilation_Phase, hierarchyControl, matrixSettings, fileName, packageName,
                    fileSymbolTable_Enabled);
        } else {
            hierarchyMetaCompiler_Actions = new HierarchyActions(metaCompilation_Phase, appControl, hierarchySettings, matrixSettings, 
                    fileName, packageName, fileSymbolTable_Enabled, existing_ImportSet);
        }
        hierarchyMetaCompiler_Actions.setClassPath_List(classPath);

        tree.apply(hierarchyMetaCompiler_Actions);
        CodeBuilder matrixConstruction_CodeBuilder = hierarchyMetaCompiler_Actions.codeBuilder_MatrixConstruction;

        hierarchyControl = hierarchyMetaCompiler_Actions.hierarchyControl;
        externalAppControlSet_forFile = hierarchyMetaCompiler_Actions.get_ExternalAppControlSet_forFile();


        MatrixAndSchema_FileGenerator matrixOrSchema_FileGen = null;
        try {

            matrixOrSchema_FileGen = generate_SchemaOrMatrixFile(is_Schema, matrixConstruction_CodeBuilder, 
                    hierarchyMetaCompiler_Actions.getSchemaOrMatrix_DescCodeGen(), destDir_Path,
                    hierarchyMetaCompiler_Actions.outputResults, hierarchySettings.appClasses_PackageName, hierarchyControl.symbolControl);

        } catch (IOException e) {
            hierarchySettings.logger.reportError_And_Exit("Tried to write out the code for the file: but had an error.", e);
        }

        return matrixOrSchema_FileGen;
    }






    public void metaCompileFile_GetTypeInfo(String srcFile_Path, String fileName, String packageName, String primaryClassName,
            LangSymbolTable_App typeInfoIndex, AppControl_Base appControl, List<URL> classPath_URLS)
            throws FileNotFoundException, Exception_HierarchyCompiler, Exception_MetaCompilerError, IOException {

        //  Create a new parser instance
        BufferedReader sourceFileReader = new BufferedReader(new FileReader(srcFile_Path));

        metaCompileFile_GetTypeInfo(sourceFileReader, fileName, packageName, primaryClassName, typeInfoIndex, appControl, classPath_URLS);
    }


    public void metaCompileFile_GetTypeInfo(BufferedReader sourceFileReader, String fileName, String packageName, String primaryClassName,
            LangSymbolTable_App typeInfoIndex, AppControl_Base appControl, List<URL> classPath_URLS)
            throws Exception_HierarchyCompiler, Exception_MetaCompilerError, IOException {

        Parser p = new Parser(new Lexer(new PushbackReader(sourceFileReader)));

        Start tree = null;
        try {
            //  Parse the input
            tree = p.parse();
        } catch (ParserException pexcept) {
            throw new Exception_MetaCompilerError("Metacompiler, typeInfo phase error: for the file, '" + fileName + "', in package, '" + packageName + "'.", pexcept);
        } catch (LexerException lexcept) {
            throw new Exception_MetaCompilerError("Metacompiler, typeInfo phase error: for the file, '" + fileName + "', in package, '" + packageName + "'.", lexcept);
        } catch (IOException ioe) {
            throw new Exception_MetaCompilerError("Metacompiler, typeInfo phase error: for the file, '" + fileName + "', in package, '" + packageName + "'.", ioe);
        }


        //  Apply the translation
        LangSymbolTableActions__SymCreator typeInfo_Actions =
                new LangSymbolTableActions__SymCreator(appControl, hierarchySettings, fileName, primaryClassName, packageName, typeInfoIndex, null);

        typeInfo_Actions.setClassPath_List(classPath_URLS);
        tree.apply(typeInfo_Actions);


        externalAppControlSet_forFile = typeInfo_Actions.get_ExternalAppControlSet_forFile();

    }






    public String metaCompileEmbeddedFile(String srcFile_Path, String destBaseDir_Path,
            String fileName, String packageName, String primaryClassName, boolean fileSymbolTable_Enabled, AppControl_Base appControl,
            List<URL> classPath)
            throws FileNotFoundException, Exception_HierarchyCompiler, Exception_MetaCompilerError, IOException {

        //  Create a new parser instance
        BufferedReader sourceFileReader = new BufferedReader(new FileReader(srcFile_Path));

        return metaCompileEmbeddedFile(sourceFileReader, destBaseDir_Path, fileName, packageName, primaryClassName,
                fileSymbolTable_Enabled, appControl, classPath);
    }


    public String metaCompileEmbeddedFile(BufferedReader sourceFileReader,
            String destBaseDir_Path, String fileName, String packageName, String primaryClassName, boolean fileSymbolTable_Enabled,
            AppControl_Base appControl, List<URL> classPath)
            throws Exception_HierarchyCompiler, Exception_MetaCompilerError, IOException {

        Parser p = new Parser(new Lexer(new PushbackReader(sourceFileReader)));

        Start tree = null;
        try {
            //  Parse the input
            tree = p.parse();
        } catch (ParserException pexcept) {
            throw new Exception_MetaCompilerError("Metacompiler error on embedded file", pexcept);
        } catch (LexerException lexcept) {
            throw new Exception_MetaCompilerError("Metacompiler error on embedded file", lexcept);
        } catch (IOException ioe) {
            throw new Exception_MetaCompilerError("Metacompiler error on embedded file", ioe);
        }


        //  Apply the translation
        HierarchyActions hierarchyMetaCompiler_Actions = new HierarchyActions(MetaCompilation_Phase.MetaCompiling_EmbeddedJavaFile, appControl,
                hierarchySettings, fileName,primaryClassName, packageName, fileSymbolTable_Enabled, symbolTable_App, null);
        hierarchyMetaCompiler_Actions.setClassPath_List(classPath);

        
        tree.apply(hierarchyMetaCompiler_Actions);

        CodeGenerators_MatrixAccess codeGenerators_MatrixAccess = hierarchyMetaCompiler_Actions.get_CodeGenerators_MatrixAccess();
        String embeddedFile_ClassName = hierarchyMetaCompiler_Actions.getClassName();

        CodeBuilder matrixConstruction_CodeBuilder = hierarchyMetaCompiler_Actions.codeBuilder_MatrixConstruction;
        String translatedCode = hierarchyMetaCompiler_Actions.getTranslatedCode();
        externalAppControlSet_forFile = hierarchyMetaCompiler_Actions.get_ExternalAppControlSet_forFile();


        String embeddedFiles_PackagePath = FileUtilities.convert_DotName_to_Path(hierarchyMetaCompiler_Actions.outputResults.getDestPackage());


        //  generate the annotation interface File ____________________________
        codeGenerators_MatrixAccess.annotationsInterface_FileGen._1_set_Package(hierarchyMetaCompiler_Actions.outputResults.getDestPackage());
        codeGenerators_MatrixAccess.annotationsInterface_FileGen._1_set_InterfaceName(embeddedFile_ClassName);
        codeGenerators_MatrixAccess.annotationsInterface_FileGen._2_generateClass(hierarchyMetaCompiler_Actions.outputResults);
        codeGenerators_MatrixAccess.annotationsInterface_FileGen._1_set_FileDirPath(destBaseDir_Path + File.separator + embeddedFiles_PackagePath);
        codeGenerators_MatrixAccess.annotationsInterface_FileGen.writeToFile(hierarchySettings.DEBUG);



        //  Add generated methods to the shared DynMethod's file.
        //  Generate the dyn methods for each embedded file ___________________________________________________
        EmbeddedFile_Worker_FileGenerator embeddedFile_Worker_FileGen = new EmbeddedFile_Worker_FileGenerator(appControl.getSymbolControl());
        embeddedFile_Worker_FileGen._1_set_Package(hierarchyMetaCompiler_Actions.outputResults.getDestPackage());
        embeddedFile_Worker_FileGen._1_set_ClassName(embeddedFile_ClassName);
        embeddedFile_Worker_FileGen._1_set_AppClassesPackage(hierarchySettings.appClasses_PackageName);
        embeddedFile_Worker_FileGen._1_set_AppClassesName(hierarchySettings.appControl_ClassName);

        //  Add all the access methods
        embeddedFile_Worker_FileGen._1_addCode_MethodsList(codeGenerators_MatrixAccess.codeBuildersList__AccessMethods_All);

        embeddedFile_Worker_FileGen._1_set_FileDirPath(destBaseDir_Path + File.separator + embeddedFiles_PackagePath);


        embeddedFile_Worker_FileGen._2_generateClass(hierarchyMetaCompiler_Actions.outputResults);
        embeddedFile_Worker_FileGen.writeToFile(hierarchySettings.DEBUG);


        //  generate the translated Embedded file________________________________________________________
        FileUtilities.writeToFile(destBaseDir_Path + File.separator + embeddedFiles_PackagePath, embeddedFile_ClassName + ".java", true,
                translatedCode, hierarchySettings.DEBUG);


        return embeddedFile_ClassName;

    }







    public MatrixAndSchema_FileGenerator generate_SchemaOrMatrixFile(boolean is_Schema, CodeBuilder schemaOrMatrix_ConstructionCodeBuilder,
            DescriptorCreation_CodeGenerator schemaOrMatrix_DescCodeGen, String dest_BaseDir, CodeGen_OutputResults outputResults,
            String appClasses_PackageName, SymbolControl symbolControl)
        throws Exception_MetaCompilerError, IOException {


        MatrixAndSchema_FileGenerator matrixOrSchemaFileGen = new MatrixAndSchema_FileGenerator(symbolControl);
        MatrixStructInfo_DescriptorContainer schemaOrMatrix_DescContainer = schemaOrMatrix_DescCodeGen.postGenerate_Get_DescriptorContainer();
        String schemaOrMatrixDesc_OutVarName = schemaOrMatrix_DescCodeGen.postGenerate_Get_DescriptorOutVarName();

        matrixOrSchemaFileGen._1_set_Package(outputResults.getDestPackage());
        matrixOrSchemaFileGen._1_set_AppClassesPackage(appClasses_PackageName);
        matrixOrSchemaFileGen._1_set_AppClassesName(hierarchySettings.appControl_ClassName);
        matrixOrSchemaFileGen._1_set_SchemaOrMatrixNameLabel(Arrays.asList(schemaOrMatrix_DescContainer.descriptor_Actual.get_Label().getSymbolNames()),
                -1);
        matrixOrSchemaFileGen._1_setCode_MatrixConstruction(schemaOrMatrix_ConstructionCodeBuilder);

        String packagePath = dest_BaseDir + File.separator + FileUtilities.convert_DotName_to_Path(outputResults.getDestPackage());
        matrixOrSchemaFileGen._1_set_FileDirPath(packagePath);
        
        if (is_Schema) {
            matrixOrSchemaFileGen._2_addCode_SchemaClass(HierarchyActions.SchemaSetScopeStack_OutVarName, schemaOrMatrixDesc_OutVarName,
                hierarchySettings.appControl_OutVarName, outputResults);
        } else {
            matrixOrSchemaFileGen._2_addCode_MatrixClass(HierarchyActions.SchemaSetScopeStack_OutVarName, schemaOrMatrixDesc_OutVarName,
                outputResults);

        }


        matrixOrSchemaFileGen.writeToFile(hierarchySettings.DEBUG);

        return matrixOrSchemaFileGen;
    }



    
    public void generate_AppControl(String appControl_PackageName, String metaCompiledFiles_BaseDestDir, String appControl_FileName,
            Set<AppControl_Info> externalAppControl_Set, List<Class_FileInfo> internalSchema_ClassFileInfo_List,
            List<Class_FileInfo> internalMatrix_ClassFileInfo_List, List<Class_FileInfo> fieldSetTuple_ClassFileInfo_List) {

        String appControl_DirPath = metaCompiledFiles_BaseDestDir + File.separator + FileUtilities.convert_DotName_to_Path(appControl_PackageName);

        try {
            CodeBuilder codeBuilder = AppControlFile_Generator.generate(null, appControl_PackageName, hierarchySettings.appControl_ClassName,
                internalSchema_ClassFileInfo_List, internalMatrix_ClassFileInfo_List, fieldSetTuple_ClassFileInfo_List,
                externalAppControl_Set);

            FileUtilities.makeDir(appControl_DirPath, true);
            FileUtilities.writeToFile(appControl_DirPath, appControl_FileName, true, codeBuilder.toString(), hierarchySettings.DEBUG);

        } catch (IOException e) {
            hierarchySettings.logger.reportError_And_Exit("Tried to write the appControl file, but had an error.", e);
        }
    }

    public void generateAll_SymbolFiles(String symbol_PackageName, String metaCompiledCode_DestDir, SymbolControl symbolControl) {

        generate_SymbolFile(SymbolType.Symbol, symbolControl.appSymbolsIndex, hierarchySettings.appSymbols_ClassName,
                symbol_PackageName, metaCompiledCode_DestDir, true);
        generate_SymbolFile(SymbolType.DescriptorTagName, symbolControl.descTagNames_Index, hierarchySettings.appSymbolClassName_DescTagName,
                symbol_PackageName, metaCompiledCode_DestDir, false);
        generate_SymbolFile(SymbolType.Label, symbolControl.labels_Index, hierarchySettings.appSymbolClassName_Label,
                symbol_PackageName, metaCompiledCode_DestDir, false);

        generate_SymbolFile_MultiLevel(SymbolType.MatrixName, symbolControl.matrixName_Index, hierarchySettings.appSymbolClassName_MatrixName,
                symbol_PackageName, metaCompiledCode_DestDir, false);
        generate_SymbolFile_MultiLevel(SymbolType.SchemaName, symbolControl.schemaName_Index, hierarchySettings.appSymbolClassName_SchemaName,
                symbol_PackageName, metaCompiledCode_DestDir, false);
        generate_SymbolFile_MultiLevel(SymbolType.DescriptorTag, symbolControl.descTag_Index, hierarchySettings.appSymbolClassName_DescTag,
                symbol_PackageName, metaCompiledCode_DestDir, false);

    }

    // TODO: this method will create the necessary directories if needed!
    public void generate_SymbolFile(SymbolType symbolType, Symbol_Index symbolIndex, String symbol_ClassName, String symbol_PackageName,
            String metaCompiledCode_DestDir, boolean generate_Global_SymbolInitializer) {

        String appControl_DirPath = metaCompiledCode_DestDir + File.separator + FileUtilities.convert_DotName_to_Path(symbol_PackageName);

        CodeBuilder symbol_ClassCode = SymbolFile_Generator.generate_SymbolFile(null, symbolType, symbolIndex,
                symbol_PackageName, symbol_ClassName);
        try {
            FileUtilities.makeDir(appControl_DirPath, true);
            FileUtilities.writeToFile(appControl_DirPath, symbol_ClassName + ".java", true, symbol_ClassCode.toString(), hierarchySettings.DEBUG);

        } catch (IOException e) {
            hierarchySettings.logger.reportError_And_Exit("Tried to write the single symbol file, but had an error.", e);
        }

    }



    // TODO: this method will create the necessary directories if needed!
    public void generate_SymbolFile_MultiLevel(SymbolType symbolType, Symbol_Index_MultiLevel symbolIndex, String symbol_ClassName,
            String symbol_PackageName, String metaCompiledCode_DestDir, boolean generate_Global_SymbolInitializer) {

        String appControl_DirPath = metaCompiledCode_DestDir + File.separator + FileUtilities.convert_DotName_to_Path(symbol_PackageName);

        CodeBuilder symbol_ClassCode = SymbolFile_Generator_MultiLevel.generate_SymbolFile(null, hierarchySettings, symbolType, symbolIndex,
                symbol_PackageName, symbol_ClassName);
        try {
            FileUtilities.makeDir(appControl_DirPath, true);
            FileUtilities.writeToFile(appControl_DirPath, symbol_ClassName + ".java", true, symbol_ClassCode.toString(), hierarchySettings.DEBUG);

        } catch (IOException e) {
            hierarchySettings.logger.reportError_And_Exit("Tried to write the single symbol file, but had an error.", e);
        }

    }









    //  Post metacompile methods:
    //  ______________________________________________________________________________________________________________________________________________

    public HashSet<AppControl_Info> postMetaCompile_GetExternalAppControlSet_forFile() { return externalAppControlSet_forFile; }

}
