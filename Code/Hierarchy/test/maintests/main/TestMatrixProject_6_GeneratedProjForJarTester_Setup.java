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
import net.unconventionalthinking.utilities.FileUtilities_Delete;


/**
 *
 * @author peterjoh
 */
public class TestMatrixProject_6_GeneratedProjForJarTester_Setup {


    
    public static void main(String[] args) throws Exception {
        System.out.println("Generating maintests");



        HierarchyMetaCompiler hierarchyCompiler = setup_HierarchyCompilerForTests();
        
        hierarchyCompiler.clean();
        hierarchyCompiler.phase0_InitiallyCompileJavaCode();
        hierarchyCompiler.phase1_MetacompileSchemaCode();
        hierarchyCompiler.phase2_GenerateFieldSets();
        hierarchyCompiler.phase3_MetacompileMatrices();
        hierarchyCompiler.phase4_CollectTypeInfo();
        hierarchyCompiler.phase5_MetaCompileEmbeddedJavaFiles();

    }

    public static HierarchyMetaCompiler setup_HierarchyCompilerForTests() throws Exception {


        HierarchyMetaCompiler hierarchyCompiler = new HierarchyMetaCompiler();

        hierarchyCompiler.set_HierarchyJar_Dir(HierarchySettings.test_HierarchyJar_Dir);
        hierarchyCompiler.set_javac_Dir(HierarchySettings.test_Javac_Dir);

        //  ***** This test uses an external Jar. Add it to the class paths ***
        hierarchyCompiler.set_Classpath_AllPhases(
                new File(TestMatrixProject_6_GeneratedProjForJarTester_Constant.Hierarchy_TestMatrixProject_Jar_Path).getCanonicalPath());

        //  set the location of the source code to be compiled to the typeinfotest sample code dir
        hierarchyCompiler.set_SrcMetaCode_BaseDir(TestMatrixProject_6_GeneratedProjForJarTester_Constant.maintests_DirPath);


        hierarchyCompiler.set_AppClasses_PackageName(TestMatrixProject_6_GeneratedProjForJarTester_Constant.maintests_generatedCode_PackageName);

        hierarchyCompiler.set_BuildMeta_BaseDir(TestMatrixProject_6_GeneratedProjForJarTester_Constant.maintests_DirPath);
        hierarchyCompiler.set_BuildFinal_BaseDir(TestMatrixProject_6_GeneratedProjForJarTester_Constant.maintests_BuildFinal_DirPath );

        hierarchyCompiler.set_InitiallyCompileAllJavaCode(true);


        hierarchyCompiler.set_Errors_Add(HierarchySettings.Errors.Invalid_ClassPathElement);
        hierarchyCompiler.set_PrintVerboseErrors(true);
        
        return hierarchyCompiler;
    }

}