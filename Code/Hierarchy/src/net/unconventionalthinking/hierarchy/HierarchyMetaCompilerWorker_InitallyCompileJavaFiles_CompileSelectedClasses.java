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

/**
 * @author Peter Joh
 */
class HierarchyMetaCompilerWorker_InitallyCompileJavaFiles_CompileSelectedClasses extends HierarchyMetaCompilerWorker_InitallyCompiledJavaFiles {

    private List<String>         initiallyCompiledJava_SelectedClasses_List;

    public HierarchyMetaCompilerWorker_InitallyCompileJavaFiles_CompileSelectedClasses(HierarchyMetaCompiler metaCompiler) {
        super(metaCompiler);

        initiallyCompiledJava_SelectedClasses_List = hierarchySettings.initiallyCompiledJava_SelectedClasses_List;

    }


    
    @Override
    List<Class_FileInfo> copyToBuild() throws Exception_FileUtilities_ProcessingError, IOException {

        //  Don't copy the java file over if the src Metacode dir and the dest build Metacode dir are the same (because this means
        //  you are just copying the files back on to themselves
        if (hierarchySettings.srcMetaCode_BaseDir.equals(hierarchySettings.buildMeta_BaseDir))
            return null;
        return compileSelectFiles_Worker(true);
    }

    @Override
    List<Class_FileInfo> collectClassFileList() throws Exception_FileUtilities_ProcessingError, IOException {
        return compileSelectFiles_Worker(false);
    }


    List<Class_FileInfo>  compileSelectFiles_Worker(boolean copyToBuild) throws IOException {
        List<Class_FileInfo> initiallyCompiliedJava__Class_FileInfo__List = new ArrayList<Class_FileInfo>();

        if (initiallyCompiledJava_SelectedClasses_List == null)
            return initiallyCompiliedJava__Class_FileInfo__List;

        
        for (String fullJavaClassName : initiallyCompiledJava_SelectedClasses_List) {
            int lastIndexOfDot = fullJavaClassName.lastIndexOf('.');
            boolean hasPackage = lastIndexOfDot >= 0;
            String simpleClassName = (hasPackage ? fullJavaClassName.substring(lastIndexOfDot + 1) : fullJavaClassName);
            String packageName = (hasPackage ? fullJavaClassName.substring(0, lastIndexOfDot) : null);
            String javaFileName = simpleClassName + ".java";

            String packageDirPath_Relative = FileUtilities.convert_DotName_to_Path(packageName);
            String packageDirPath = hierarchySettings.srcMetaCode_BaseDir + File.separator + packageDirPath_Relative;;

            String fullFilePath = packageDirPath + File.separator + javaFileName;
            File fileObj = new File(fullFilePath);
            if (!fileObj.exists())
                throw new IOException("Tried to compile the Java class, " + fullJavaClassName + ", during the initial stage of metacompilation, but the file doesn't exist.\n "
                        + "Please check the 'initiallyCompileJavaCode' settings in your metacompilation.properties file. The full path we tried for the file was:\n"
                        + "  " + fullFilePath + "\nAlso check that this Java file actually exists." );


            Class_FileInfo javaFile_Info = new Class_FileInfo(packageDirPath, packageDirPath_Relative, javaFileName, packageName,
                    simpleClassName);
            initiallyCompiliedJava__Class_FileInfo__List.add(javaFile_Info);

            if (copyToBuild)
                FileUtilities.copyFileToDestDir(new File(javaFile_Info.get_FileName_w_Path()), hierarchySettings.buildMeta_BaseDir);
        }

        return initiallyCompiliedJava__Class_FileInfo__List;
    }


}
