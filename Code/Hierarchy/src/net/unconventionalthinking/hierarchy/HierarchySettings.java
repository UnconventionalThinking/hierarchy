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

import net.unconventionalthinking.matrix.metacompiler.codegen.CodeConstants;
import net.unconventionalthinking.utilities.FileUtilities;
import java.io.File;
import java.util.EnumSet;
import java.util.List;
import net.unconventionalthinking.utilities.SystemInfo_Collector;


/**
 *
 * @author peterjoh
 */
public class HierarchySettings {

    public enum BuildMode_ProjectOrSingleAppPackage { BuildProject, BuildSingleAppPackage; }

    public enum Warnings { Invalid_ClassPathElement }
    public enum Errors { Invalid_ClassPathElement }

    static {


    }

    public static final SystemInfo_Collector systemInfo_Collector = new SystemInfo_Collector();

    public final CompilerLogger logger;


    public boolean DEBUG = false;
    public boolean DEBUG_PRINT_FLATTENEDMATRICES = false;
    public boolean DEBUG_PERSISTENCE_CLIENT_VERBOSE = true;
    public boolean debug_ScopeStack = false;

    /** If there's an error, print out the internal stack trace of the error. */
    public boolean print_VerboseErrors = true;

    //  Build directories and files
    public String hierarchyJar_Dir;
    public String javac_Dir;

    public BuildMode_ProjectOrSingleAppPackage buildMode_ProjectOrSingleAppPackage;

    public String srcMetaCode_BaseDir;
    public String srcMetaCode_AppDirPath;
    public String appClasses_PackageName;
    public String get_AppClasses_PackageDirPath_Relative() {
        return srcMetaCode_AppDirPath.substring(srcMetaCode_BaseDir.length() + 1);
    };
    public String buildMeta_BaseDir;
    public String buildFinal_BaseDir; // for example : /Projects/GenerationTestProject/build_meta";

    public String get_DestMeta_MatrixAppFiles_DestDir() { return buildMeta_BaseDir + File.separator +
            FileUtilities.convert_DotName_to_Path(appClasses_PackageName); }
    public String get_DestBuild_MatrixAppFiles_DestDir() { return buildFinal_BaseDir + File.separator +
            FileUtilities.convert_DotName_to_Path(appClasses_PackageName); }


    //  TODO - ** delete these later!!
    /*
    // Unix
    public static final String test_Javac_Dir = "/System/Library/Frameworks/JavaVM.framework/Versions/1.5.0/Home/bin"; // java 1.5
    public static final String test_HierarchyJar_Dir = "/Users/peterjoh/Projects/NDA_and_MP/Code/Hierarchy/dist";
    public static final String Matrix_Projects_Dir = "/Users/peterjoh/Projects/NDA_and_MP/Code";
     */
    //  PC
    public static final String test_Javac_Dir = "C:/Program Files/Java/jdk1.6.0_21/bin";
    public static final String test_HierarchyJar_Dir = "C:/Projects/Hierarchy/Code/Hierarchy/dist";
    public static final String Matrix_Projects_Dir = "C:/Projects/Hierarchy/Code";

    
    public static final String generationtestproject_package = "generationtestproject";
    public static final String generationTestProj_generationtestproj_Dir = Matrix_Projects_Dir + "/Hierarchy_GenerationTestProject/src";
    public static final String generationTestProj_matrixPackage_Dir = Matrix_Projects_Dir + "/Hierarchy_GenerationTestProject/src/net/unconventionalthinking/matrix";
    public static final String build_DestDir_generationtestproject= Matrix_Projects_Dir +  "/Hierarchy_GenerationTestProject/build_meta";


    //  MetaCompiler Settings:
    public boolean              compileMetaFiles_into_FinalClassFiles;
    /** There are two settings for initiallyCompiledJava:
     *   1. compile only a passed-in list of Java files (default)
     *   2. compile all Java files
     *   If this is false, then compile only the passed-in list */
    public boolean              initiallyCompiledJava_CompileAllJavaFiles;
    public List<String>         initiallyCompiledJava_SelectedClasses_List;

    public String               classpath_AllPhases;
    public String               classpath_Java_Raw;
    public String               classpath_Schemas_Raw;
    public String               classpath_Matrices_Raw;
    public String               classpath_EmbeddedFiles_Raw;

    public boolean              printClassPath_forAppClasses = false;
    public boolean              printClassPath_MetacompilerJVMs_Classpath = true;

    public EnumSet<Warnings>    warningSettings = EnumSet.noneOf(Warnings.class);
    public EnumSet<Errors>      errorsSettings = EnumSet.noneOf(Errors.class);


    
    //  File Name Suffix settings:

    public static final String symbolClassSuffix_DescTagName = "_DescTagName";
    public static final String symbolClassSuffix_Label = "_Label";
    public static final String symbolClassSuffix_DescTag = "_DescTag";
    public static final String symbolClassSuffix_SchemaName = "_SchemaName";
    public static final String symbolClassSuffix_MatrixName = "_MatrixName";

    
    public static final String embeddedFile_WorkerClassName_Suffix = "__MatrixWorker";
    public static final String annotations_InterfaceName_Suffix = "__Annotations";




    //  App Control settings
    public String appControl_ClassName = "AppControl";
    public String appControl_OutVarName = "appControl";


    //  AppSymbols
    public String appSymbols_ClassName = "AppSymbols";

    public String appSymbolClassName_DescTagName = appSymbols_ClassName + symbolClassSuffix_DescTagName;
    public String appSymbolClassName_Label = appSymbols_ClassName + symbolClassSuffix_Label;
    public String appSymbolClassName_DescTag = appSymbols_ClassName + symbolClassSuffix_DescTag;

    public String appSymbolClassName_MatrixName = appSymbols_ClassName + symbolClassSuffix_MatrixName;
    public String appSymbolClassName_SchemaName = appSymbols_ClassName + symbolClassSuffix_SchemaName;


    //  MPSymbols
    public String mpSymbols_ClassName = "MPSymbols";

    public String mpSymbolClassName_DescTagName = mpSymbols_ClassName + symbolClassSuffix_DescTagName;
    public String mpSymbolClassName_Label = mpSymbols_ClassName + symbolClassSuffix_Label;
    public String mpSymbolClassName_DescTag = mpSymbols_ClassName + symbolClassSuffix_DescTag;

    public String mpSymbolClassName_MatrixName = mpSymbols_ClassName + symbolClassSuffix_MatrixName;
    public String mpSymbolClassName_SchemaName = mpSymbols_ClassName + symbolClassSuffix_SchemaName;

    //  Annotations:
    public String accessReturnTypeOutParam_ParamName = "accessReturnType_OutParam";


    public HierarchySettings() {
        logger = new CompilerLogger(this);
    }

}
