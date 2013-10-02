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

import net.unconventionalthinking.cmdline.CmdLine_Tools;
import net.unconventionalthinking.lang.Boolean_Mutable;
import net.unconventionalthinking.matrix.AppControl_Base;
import net.unconventionalthinking.matrix.ExceptRuntime_Matrix_UnexpectedError;
import net.unconventionalthinking.reflection.DynamicClassUtilities;
import net.unconventionalthinking.reflection.MethodInvoker;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 *
 * @author peterjoh
 */
public class HierarchyMetaCompilerUtilities_Compiler {



    private HierarchySettings hierarchySettings;

    public HierarchyMetaCompilerUtilities_Compiler(HierarchySettings hierarchySettings) {
        this.hierarchySettings = hierarchySettings;
    }



    /** This version takes no embedded classes, or java files*/
    public void compileAllMatrixFiles(String sourceCode_Dir, String dest_BaseDir, String appCode_PackageDirPath_Relative,
            List<Class_FileInfo> classesToCompile_List, String... classPaths)
            throws Exception_HierarchyCompiler, IOException {
        compileAllMatrixFiles(sourceCode_Dir, dest_BaseDir, appCode_PackageDirPath_Relative, classesToCompile_List, null, null, classPaths);
    }

    public void compileAllMatrixFiles(String sourceCode_BaseDir, String dest_BaseDir, String appCode_PackageDirPath_Relative,
            List<Class_FileInfo> classesToCompile_List, List<Class_FileInfo> embeddedClassesToCompile_List,
            List<Class_FileInfo> javaFilesToCompile_List, String... classPaths) throws Exception_HierarchyCompiler, IOException {


        List<String> fileName_w_PackageDir__List = new ArrayList();

        //  Add the classes to compile
        for (Class_FileInfo classFile_Info : classesToCompile_List)
            fileName_w_PackageDir__List.add(classFile_Info.packageDirPath_Relative + File.separatorChar + classFile_Info.className + ".java");

        //  Add symbol files
        fileName_w_PackageDir__List.add(appCode_PackageDirPath_Relative + File.separatorChar +
                                        hierarchySettings.appSymbolClassName_DescTagName + ".java");
        fileName_w_PackageDir__List.add(appCode_PackageDirPath_Relative + File.separatorChar +
                                        hierarchySettings.appSymbolClassName_Label + ".java");
        fileName_w_PackageDir__List.add(appCode_PackageDirPath_Relative + File.separatorChar +
                                        hierarchySettings.appSymbols_ClassName + ".java");
        fileName_w_PackageDir__List.add(appCode_PackageDirPath_Relative + File.separatorChar +
                                        hierarchySettings.appSymbolClassName_MatrixName + ".java");
        fileName_w_PackageDir__List.add(appCode_PackageDirPath_Relative + File.separatorChar +
                                        hierarchySettings.appSymbolClassName_SchemaName + ".java");
        fileName_w_PackageDir__List.add(appCode_PackageDirPath_Relative + File.separatorChar +
                                        hierarchySettings.appSymbolClassName_DescTag + ".java");


        //  Add Initializer
        fileName_w_PackageDir__List.add(appCode_PackageDirPath_Relative + File.separatorChar +
                                        hierarchySettings.appControl_ClassName + ".java");


        if (embeddedClassesToCompile_List != null) {
            for (Class_FileInfo embedded_ClassFileInfo : embeddedClassesToCompile_List) {
                String embeddedClassNameBase_w_Path = embedded_ClassFileInfo.packageDirPath_Relative + File.separatorChar +
                        embedded_ClassFileInfo.className;

                fileName_w_PackageDir__List.add(embeddedClassNameBase_w_Path + ".java");
                fileName_w_PackageDir__List.add(embeddedClassNameBase_w_Path + hierarchySettings.annotations_InterfaceName_Suffix + ".java");
                fileName_w_PackageDir__List.add(embeddedClassNameBase_w_Path + hierarchySettings.embeddedFile_WorkerClassName_Suffix + ".java");
            }
        }


        if (javaFilesToCompile_List != null) {
            for (Class_FileInfo java_ClassFileInfo : javaFilesToCompile_List) {
                fileName_w_PackageDir__List.add(java_ClassFileInfo.packageDirPath_Relative + File.separatorChar +
                        java_ClassFileInfo.className + ".java");
            }
        }


        List<String> classPaths_w_HierarchyPaths =  new ArrayList();
        classPaths_w_HierarchyPaths.addAll(Arrays.asList(classPaths));
        classPaths_w_HierarchyPaths.add(hierarchySettings.hierarchyJar_Dir + "/Hierarchy.jar" + File.pathSeparator + dest_BaseDir);

        compileFiles(sourceCode_BaseDir, fileName_w_PackageDir__List,
                hierarchySettings.javac_Dir, dest_BaseDir, true, classPaths_w_HierarchyPaths.toArray(new String[classPaths_w_HierarchyPaths.size()]));



    }


    public void compileAllJavaFiles_forPhase0(String srcMetaCode_BaseDir, String dest_BaseDir, List<Class_FileInfo> java_ClassFileInfo_List,
            String... classPaths) throws Exception_HierarchyCompiler, IOException {


        List<String> fileName_w_PackageDir__List = new ArrayList();

        for (Class_FileInfo java_ClassFileInfo : java_ClassFileInfo_List) {
            fileName_w_PackageDir__List.add(java_ClassFileInfo.packageDirPath_Relative + File.separatorChar +
                    java_ClassFileInfo.className + ".java");
        }


        List<String> classPaths_w_HierarchyPaths =  new ArrayList();
        classPaths_w_HierarchyPaths.addAll(Arrays.asList(classPaths));
        classPaths_w_HierarchyPaths.add(hierarchySettings.hierarchyJar_Dir + "/Hierarchy.jar" + File.pathSeparator + dest_BaseDir);

        compileFiles(srcMetaCode_BaseDir, fileName_w_PackageDir__List,
                hierarchySettings.javac_Dir, dest_BaseDir, true, classPaths_w_HierarchyPaths.toArray(new String[classPaths_w_HierarchyPaths.size()]));

    }



    public void print_Javac_Version(String javac_Dir) throws IOException {
        String javacCmd = javac_Dir + "/" + "javac";

        List<String> commandArgs = new ArrayList<String>(Arrays.asList(javacCmd, "-version"));

        CmdLine_Tools.ExecutionResults executionResults = null;
        try {
            executionResults = CmdLine_Tools.executeCmd(commandArgs, new File("."), false, false, false);
        } catch (InterruptedException e) {
            throw new ExceptRuntime_Matrix_UnexpectedError("While trying to execute the Java command to get the version number of Javac, the command was interrupted.");
        }
        BufferedReader outReader = executionResults.getProcessOutput();
        
        System.out.print("Javac Version info: ");
        if (outReader != null) {
            String line;
            boolean error = false;

            line = outReader.readLine();
            if (line != null) {
                String line_trimmed = line.trim();

                if (line_trimmed.startsWith("javac")) {
                    System.out.println(line_trimmed);
                } else {
                    error = true;
                }
            } else
                error = true;



            if (error) {

                System.out.println("ERROR! could not print out javac version");

                StringBuilder errorMsg = new StringBuilder("ERROR! could not print out javac version");
                if (line != null) // there's already a line, add to err
                    errorMsg.append(line).append("\n");

                while ((line = outReader.readLine()) != null) {
                    errorMsg.append(line).append("\n");
                }
                
                throw new ExceptRuntime_Matrix_UnexpectedError(errorMsg.toString());
            }

        } else {
            throw new ExceptRuntime_Matrix_UnexpectedError("ERROR! tried to execute the 'javac -version' cmd on the cmdline, but had no output for some reason.");
        }

    }



    /**
     * Compile a single file
     *
     * ** May move to using different code for this method. Many options:
     * 1. the commented code below
     * 2. Janino
     * 3. java 6
     *
     * @param outBaseDir    this points to the BASE directory of where the classes should go! (meaning not actually into directories of
     *                      the package folders themselves)
     * @param classPaths
     * @return
     * @throws Exception_HierarchyCompiler
     * @throws IOException
     */
    public CmdLine_Tools.ExecutionResults compileFile(String srcBaseDir, String fileName, String javac_Dir, String outBaseDir, 
            boolean exitOnFailedCompilation, String... classPaths)
            throws Exception_HierarchyCompiler, IOException {
        return compileFiles(srcBaseDir, Arrays.asList(fileName), javac_Dir, outBaseDir, exitOnFailedCompilation, classPaths);
    }

    /**
     * Compile multiple files.
     *
     * ** May move to using different code for this method. Many options:
     * 1. the commented code below
     * 2. Janino
     * 3. java 6
     *
     * @param srcBaseDir
     * @param fileNames_w_PackageDir     List of file names (including their package directories), to compile.
     * @param javac_Dir
     * @param outBaseDir    this points to the BASE directory of where the classes should go! (meaning not actually into directories of
     *                      the package folders themselves)
     * @param classPaths
     * @return              if the ExecutionResults.processResultValue is NOT 0, then there was an error in compilation
     * @throws Exception_HierarchyCompiler
     * @throws IOException
     */
    public CmdLine_Tools.ExecutionResults compileFiles(String srcBaseDir, List<String> fileNames_w_PackageDir_List, String javac_Dir,
            String outBaseDir, boolean exitOnFailedCompilation, String... classPaths)
            throws Exception_HierarchyCompiler, IOException {

        File srcBase_Directory = new File(srcBaseDir);
        File outBase_Directory = new File(outBaseDir);

        if (!srcBase_Directory.exists())
            throw new Exception_HierarchyCompiler("Error: tried to compile files, but the base, source directory does not exist: " + srcBaseDir);
        if (!outBase_Directory.exists())
            outBase_Directory.mkdirs();


        String combinedClassPath = combineClassPaths(classPaths);

        /*
        //  Later on, may use this code to compile
        //  ** REQUIRES tools.jar ** can find this in JDK!
        com.sun.tools.javac.Main javac = new com.sun.tools.javac.Main();

        // You can call the compile method on the javac instance passing in an array of strings as options. For example,
        // here are the options that include the classpath and the output directory for the file to compile.

        String[] options = new String[] {
        “-classpath”, classpath, “-d”, outputDir, filename
        };

        // And of course you can use any of the other options such as -deprecation or -g. To compile a source file, just invoke compile
        // as in the following code bit.

        javac.compile(options);
        */
        String javacCmd = javac_Dir + "/" + "javac";

        List<String> commandArgs = new ArrayList<String>(Arrays.asList(javacCmd, "-d", outBaseDir, "-cp", combinedClassPath ));


        /*
        StringBuilder filesToCompile_StrBuilder = new StringBuilder();
        boolean is_FirstIter = true;
        for (String fileName_w_PackageDir : fileNames_w_PackageDir_List) {
            if (is_FirstIter)
                is_FirstIter = false;
            else
                filesToCompile_StrBuilder.append(';');

            filesToCompile_StrBuilder.append(fileName_w_PackageDir);
        }
        commandArgs.add(filesToCompile_StrBuilder.toString());
*/
        for (String fileName_w_PackageDir : fileNames_w_PackageDir_List )
            commandArgs.add(fileName_w_PackageDir);

        CmdLine_Tools.ExecutionResults executionResults = null;
        int processResultValue = -1;
        try {
            executionResults = CmdLine_Tools.executeCmd(commandArgs, srcBase_Directory, true, false, false);
            processResultValue = executionResults.getProcessReturnValue();
        } catch (InterruptedException e) {
            throw new ExceptRuntime_Matrix_UnexpectedError("While trying to compile some files, the command was interrupted.", e);
        }
        if (exitOnFailedCompilation && processResultValue != 0) {
            //  Compilation failed, exit
            System.exit(processResultValue);
        }

        return executionResults;

    }






    /**
     * TODO - *** REMOVE THIS LATER - this is only used by one of the junit tests!!
     *
     * @param sourceCode_BaseDir
     * @param dest_BaseDir      this points to the BASE directory of where the classes should go! (meaning not actually into the directories of
     *                          the package folders themselves)
     * @param hierarchyJar_Dir    the path of the directory where the hierarchy.jar file is located
     * @param String javac_Dir  the path of the directory where the javac executable is located
     *
     * @throws Exception
     */
    public void compileAll_SymbolFiles(String sourceCode_Dir, String dest_BaseDir, String hierarchyJar_Dir, String javac_Dir) throws Exception {

        // NOTE: appsymbols needs to compile last! Why? because it creates teh dlobal initializer, which depends on the previous two.
        // Also note that for appSymbols, it has the destination baseDir on its classpath so it can see the class files of the previous two.
        compileFile(sourceCode_Dir, hierarchySettings.appSymbolClassName_DescTagName + ".java",
                javac_Dir, dest_BaseDir, true, hierarchyJar_Dir + "/Hierarchy.jar" + File.pathSeparator + dest_BaseDir);
        compileFile(sourceCode_Dir, hierarchySettings.appSymbolClassName_Label + ".java",
                javac_Dir, dest_BaseDir, true, hierarchyJar_Dir + "/Hierarchy.jar" + File.pathSeparator + dest_BaseDir);
        compileFile(sourceCode_Dir, hierarchySettings.appSymbols_ClassName + ".java",
                javac_Dir, dest_BaseDir, true, hierarchyJar_Dir + "/Hierarchy.jar" + File.pathSeparator + dest_BaseDir);
        compileFile(sourceCode_Dir, hierarchySettings.appSymbolClassName_DescTag + ".java",
                javac_Dir, dest_BaseDir, true, hierarchyJar_Dir + "/Hierarchy.jar" + File.pathSeparator + dest_BaseDir);
        compileFile(sourceCode_Dir, hierarchySettings.appSymbolClassName_MatrixName + ".java",
                javac_Dir, dest_BaseDir, true, hierarchyJar_Dir + "/Hierarchy.jar" + File.pathSeparator + dest_BaseDir);
        compileFile(sourceCode_Dir, hierarchySettings.appSymbolClassName_SchemaName + ".java",
                javac_Dir, dest_BaseDir, true, hierarchyJar_Dir + "/Hierarchy.jar" + File.pathSeparator + dest_BaseDir);

    }




    /**
     * After each phase of the metacompiler, it regenerates the matrix app files (appControl and the symbol files). These files needed to be
     * dynamically reloaded after each regeneration.
     *
     * There are a couple of rules that need to followed in order to dynamically reload classes.
     * 1. The path to the base of the dynamically loaded classes must not be in jvm's classpath. Why? because when the jvm loads, it will search
     * its classpath, and it will put any class it finds will be loaded using the "primordial class loader"
     * (for those classes found on the class path when the jvm started).
     * But, if sometime after the jvm start up, you compile a new class file and you try to reload it, if this class was already in the classpath,
     * the jvm will not reload the file from the newly generated class file, but it will use the "primordial class loader".
     * To solve this, make sure the base dir of the dyn loaded classes is not in the classpath.
     *
     * 2. after you dynamically load the class object using a classloader:
     *    ex. classObj = classLoader.loadClass(className);
     *   you need to create an instance of the class to actually have it dynamically reloaded. Even if all you're interested in is the static members,
     *   you can't just access a static field, you need to create an instance of the class to have it actually reload.
     */
    public AppControl_Base dynReload_AppClasses(String appClassFiles_BaseDir, String appClassFiles_PackageName, List<URL> classPath_List,
            boolean running_AppControl_forMetacompilation)
        throws Exception_HierarchyCompiler {

        List<URL> classPath_AppClasses_URLS = null;

        try {
            // Dyn reload the symbol classes
            List<String> symbolClassNames = Arrays.asList(hierarchySettings.appSymbols_ClassName, hierarchySettings.appSymbolClassName_Label,
                    hierarchySettings.appSymbolClassName_DescTagName, hierarchySettings.appSymbolClassName_DescTag, hierarchySettings.appSymbolClassName_MatrixName,
                    hierarchySettings.appSymbolClassName_SchemaName);

            String[] appClassFiles_ClassPath_List = new String[] { appClassFiles_BaseDir + File.separator };
            classPath_AppClasses_URLS = new ArrayList(classPath_List);

            DynamicClassUtilities.WarningAndError_Settings warningAndErrorSettings_InvalidClassPaths =
                    HierarchySettings_Utilities.warningsAndErrors__ConvertInvalidClassPathElementSetting(hierarchySettings);
            List<String> warningMessage_List = new ArrayList<String>();

            classPath_AppClasses_URLS.addAll(DynamicClassUtilities.classPath__CreateUrls(appClassFiles_ClassPath_List, warningAndErrorSettings_InvalidClassPaths,
                    warningMessage_List));

            for (String warningMessage : warningMessage_List)
                System.out.println(warningMessage);


            if (hierarchySettings.printClassPath_forAppClasses) {
                System.out.println("   Printing classpath for dynamical Load of appclasses:");
                for(URL classPath_URL : classPath_AppClasses_URLS)
                    System.out.println("      - " + classPath_URL.getFile());
            }

            for (String symClassName : symbolClassNames) {
                Class dynLoadedClass = DynamicClassUtilities.classPath__dynLoadClass(classPath_AppClasses_URLS,
                        (appClassFiles_PackageName != null ? appClassFiles_PackageName + '.' + symClassName : symClassName));
                Object dynLoadedClass_Obj = dynLoadedClass.newInstance();
            }

        } catch (Exception e) {
            throw new Exception_HierarchyCompiler("While metacompiling a matrix, had problems trying to reload the symbol classes.", e);
        }



        //  Dyn reload the appControl.
        //  The reloading of the appControl object must happen AFTER all the symbol classes have been reloaded. Because the appControl calls the
        //  symbol file initializers. If the symbol files are reloaded after the appControl is loaded (and calls it's initializer), it will use
        //  the OLD versions of the symbol classes, not the updated ones!!
        AppControl_Base appControl = null;
        try {

            Class appControlClass = DynamicClassUtilities.classPath__dynLoadClass(classPath_AppClasses_URLS,
                     (appClassFiles_PackageName != null ? 
                         appClassFiles_PackageName + '.' + hierarchySettings.appControl_ClassName : hierarchySettings.appControl_ClassName)
                     );

            Class[] paramTypes = new Class[] { boolean.class };
            // pass in the 'running_AppControl_forMetacompilation' value
            Object[] paramValues = new Object[] { running_AppControl_forMetacompilation };

            appControl = (AppControl_Base)MethodInvoker.invokeMethod_Helper(null, appControlClass, "initializeApp", new Boolean_Mutable(), paramTypes, paramValues);

            
        } catch (Exception e) {
            throw new Exception_HierarchyCompiler("While metacompiling a matrix, had problems trying to reload the updated appControl.", e);
        }

        return appControl;

    }








    public static String combineClassPaths(String[] classPaths_List) {


        if (classPaths_List != null) {
            StringBuilder classPaths_StrBuilder = new StringBuilder();

            boolean first_Iter = true;
            for (String classPath : classPaths_List) {

                if (classPath != null && classPath.length() > 0) { // ignore empty class paths
                    if (first_Iter)
                        first_Iter = false;
                    else
                        classPaths_StrBuilder.append(File.pathSeparatorChar);


                    if (classPath != null) {
                        String classpath_Trimmed = classPath.trim();

                        if (classpath_Trimmed.length() > 0) {
                            classPaths_StrBuilder.append(classPath);
                        }

                    }
                }
            }

            return classPaths_StrBuilder.toString();

        } else {
            return null;
        }


    }




}
