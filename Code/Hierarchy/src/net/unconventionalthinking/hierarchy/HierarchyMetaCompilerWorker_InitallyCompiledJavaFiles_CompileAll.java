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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.unconventionalthinking.utilities.Exception_FileUtilities_ProcessingError;
import net.unconventionalthinking.utilities.FileUtilities;
import net.unconventionalthinking.utilities.FileUtilities_DirTreeProcessor;
import net.unconventionalthinking.utilities.FileUtilities_DirTreeProcessor_Method;

/**
 * @author Peter Joh
 */
class HierarchyMetaCompilerWorker_InitallyCompiledJavaFiles_CompileAll extends HierarchyMetaCompilerWorker_InitallyCompiledJavaFiles {

    HierarchyMetaCompilerWorker_InitallyCompiledJavaFiles_CompileAll(HierarchyMetaCompiler metaCompiler) {
        super(metaCompiler);
    }




    @Override
    List<Class_FileInfo> copyToBuild() throws Exception_FileUtilities_ProcessingError, IOException {

        //  Don't copy the java file over if the src Metacode dir and the dest build Metacode dir are the same (because this means
        //  you are just copying the files back on to themselves
        if (hierarchySettings.srcMetaCode_BaseDir.equals(hierarchySettings.buildMeta_BaseDir))
            return null;
        return compileAll_Worker(true);
    }

    @Override
    List<Class_FileInfo> collectClassFileList() throws Exception_FileUtilities_ProcessingError, IOException {
        return compileAll_Worker(false);
    }

    /**
     * This method collects all the Java files in your meta src. If you pass in copyToBuild = true, then it'll also copy each file to the
     * metabuild directory.
     *
     * @param copyToBuild
     * @return
     * @throws Exception_FileUtilities_ProcessingError
     * @throws IOException
     */
    private List<Class_FileInfo> compileAll_Worker(final boolean copyToBuild) throws Exception_FileUtilities_ProcessingError, IOException {

        final List<Class_FileInfo> initiallyCompiliedJava__Class_FileInfo__List = new ArrayList<Class_FileInfo>();

        FileUtilities_DirTreeProcessor_Method collectJavaFiles_DirProcessorMethod = new FileUtilities_DirTreeProcessor_Method() {

            @Override
            public void processDir(File currDir, File baseDir, Object[] otherParams)
                    throws IOException, Exception_FileUtilities_ProcessingError {

                String packageName = HierarchyMetaCompilerUtilities.getPackageName_ForCurrPackageDir(currDir, hierarchySettings.srcMetaCode_BaseDir);
                String packageDirPath_Relative = HierarchyMetaCompilerUtilities.getPackageDirPath_ForCurrPackageDir(currDir, hierarchySettings.srcMetaCode_BaseDir);
                String currDir_Path = currDir.getCanonicalPath();


                File destMetaDir = new File(hierarchySettings.buildMeta_BaseDir + File.separatorChar + packageDirPath_Relative);
                if (!destMetaDir.exists())
                    destMetaDir.mkdirs();

                String[] javaFiles_List = currDir.list(HierarchyMetaCompiler.javaFiles_Filter);
                String javaFileName = null;
                try {
                    for (String javaFile : javaFiles_List) {
                        javaFileName = javaFile;
                        String primaryClassName = javaFile.substring(0, javaFile.lastIndexOf('.'));

                        Class_FileInfo javaFile_Info = new Class_FileInfo(currDir_Path, packageDirPath_Relative, javaFileName, packageName,
                                primaryClassName);
                        initiallyCompiliedJava__Class_FileInfo__List.add(javaFile_Info);

                        if (copyToBuild)
                            FileUtilities.copyFileToDestDir(new File(javaFile_Info.get_FileName_w_Path()), destMetaDir);
                    }

                } catch (Exception e) {
                    throw new Exception_FileUtilities_ProcessingError("Had error collecting all the java files in the source code (to add to all the generated meta code files). The java file with the problem was,  " + javaFileName + ", in package, " + packageName, e);
                }
            }
        };



        FileUtilities_DirTreeProcessor dirTreeProcessor = new FileUtilities_DirTreeProcessor();
        dirTreeProcessor.setDirProcessorMethod_ProcessThenTraverse(collectJavaFiles_DirProcessorMethod);

        if (hierarchySettings.buildMode_ProjectOrSingleAppPackage == HierarchySettings.BuildMode_ProjectOrSingleAppPackage.BuildProject)
            dirTreeProcessor.traverseAndProcess(hierarchySettings.srcMetaCode_BaseDir);
        else
            dirTreeProcessor.traverseAndProcess(hierarchySettings.srcMetaCode_AppDirPath, false); // only process the app dir!!


        return initiallyCompiliedJava__Class_FileInfo__List;
    }

}
