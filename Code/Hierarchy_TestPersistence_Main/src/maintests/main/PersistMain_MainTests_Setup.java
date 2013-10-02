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
public class PersistMain_MainTests_Setup {
    
    public static void main(String[] args) throws Exception {
        System.out.println("Generating maintests");

        
        HierarchyMetaCompiler hierarchyCompiler = setup_HierarchyCompilerForTests(true, true);

        hierarchyCompiler.set_BuildMode_ProjectOrPackage(HierarchySettings.BuildMode_ProjectOrSingleAppPackage.BuildSingleAppPackage);

        hierarchyCompiler.phase1_MetacompileSchemaCode();
        hierarchyCompiler.phase2_GenerateFieldSets();
        hierarchyCompiler.phase3_MetacompileMatrices();
        hierarchyCompiler.phase4_CollectTypeInfo();
        hierarchyCompiler.phase5_MetaCompileEmbeddedJavaFiles();


    }

    public static HierarchyMetaCompiler setup_HierarchyCompilerForTests() throws Exception {
        return setup_HierarchyCompilerForTests(false, true);
    }

    public static HierarchyMetaCompiler setup_HierarchyCompilerForTests(boolean building_PersistentMatrix, boolean cleanUpOldFiles) throws Exception {


        HierarchyMetaCompiler hierarchyCompiler = new HierarchyMetaCompiler();

        hierarchyCompiler.set_HierarchyJar_Dir(HierarchySettings.test_HierarchyJar_Dir);
        hierarchyCompiler.set_javac_Dir(HierarchySettings.test_Javac_Dir);


        hierarchyCompiler.set_SrcMetaCode_BaseDir(PersistMain_MainTests_Constants.maintests_DirPath);
        hierarchyCompiler.set_AppClasses_PackageName(PersistMain_MainTests_Constants.maintests_generatedCode_PackageName);

        // NOTE: output the generated meta files back to the test dir, so they can be used to run the embedded code test
        hierarchyCompiler.set_BuildMeta_BaseDir(PersistMain_MainTests_Constants.maintests_DirPath);
        hierarchyCompiler.set_BuildFinal_BaseDir(PersistMain_MainTests_Constants.maintests_BuildFinal_DirPath);

        hierarchyCompiler.set_Errors_Add(HierarchySettings.Errors.Invalid_ClassPathElement);
        hierarchyCompiler.set_PrintVerboseErrors(true);

        if (cleanUpOldFiles)
            hierarchyCompiler.clean();
        
        return hierarchyCompiler;
    }

}