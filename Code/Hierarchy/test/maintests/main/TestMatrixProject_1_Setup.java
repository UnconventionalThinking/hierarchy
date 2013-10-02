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

package maintests.main;


import net.unconventionalthinking.utilities.FileUtilities;
import net.unconventionalthinking.hierarchy.HierarchyMetaCompiler;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import java.io.File;


/**
 * *** IMPORTANT NOTE ****
 * Before you run this, if you've made any changes to any type of matrix file, you should delete the generated .java files and clean
 * the build (not sure which one causes the problem)) Why? because when you run this class and the the JVM starts up, It's primary class loader
 * will load the current classes into memory, and they cannot be replaced by the dynamically compiled versions!!!!
 *
 * @author peterjoh
 */
public class TestMatrixProject_1_Setup {


    
    public static void main(String[] args) throws Exception {
        System.out.println("Generating maintests");

        //  Check if the project path is passed in. This happens when an outside project like the HierarchyController project
        //  calls this method.
        String prePath = "";
        if (args != null && args.length == 1) {
            prePath = args[0].trim() + "/";
        }
        HierarchyMetaCompiler.main(new String[] { "-mpropfile", prePath + "test/maintests/main/TestMatrixProject_1.properties" });

        /*
        HierarchyMetaCompiler hierarchyCompiler = setup_HierarchyCompilerForTests(false);

        hierarchyCompiler.clean();
        
        hierarchyCompiler.phase1_MetacompileSchemaCode();
        hierarchyCompiler.phase2_GenerateFieldSets();
        hierarchyCompiler.phase3_MetacompileMatrices();
        hierarchyCompiler.phase4_CollectTypeInfo();
        hierarchyCompiler.phase5_MetaCompileEmbeddedJavaFiles();
         */

    }

    public static HierarchyMetaCompiler setup_HierarchyCompilerForTests() throws Exception {
        HierarchyMetaCompiler hierarchyCompiler = new HierarchyMetaCompiler();

        hierarchyCompiler.set_HierarchyJar_Dir(HierarchySettings.test_HierarchyJar_Dir);
        hierarchyCompiler.set_javac_Dir(HierarchySettings.test_Javac_Dir);

        //  set the location of the source code to be compiled to the typeinfotest sample code dir
        hierarchyCompiler.set_SrcMetaCode_BaseDir(TestMatrixProject_1_Constants.testProj_srcBase_DirPath);


        hierarchyCompiler.set_AppClasses_PackageName(TestMatrixProject_1_Constants.testProj_typeInfoTest_PackageName);

        hierarchyCompiler.set_BuildMeta_BaseDir(TestMatrixProject_1_Constants.testProj_BuildMeta_DirPath);
        hierarchyCompiler.set_BuildFinal_BaseDir(TestMatrixProject_1_Constants.testProj_BuildFinal_DirPath );

        hierarchyCompiler.set_InitiallyCompileAllJavaCode(true);
        hierarchyCompiler.set_PrintVerboseErrors(true);
        
        
        return hierarchyCompiler;
    }

}