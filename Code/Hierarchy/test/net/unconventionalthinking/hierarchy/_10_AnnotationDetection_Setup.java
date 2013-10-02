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
public class _10_AnnotationDetection_Setup {


    
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

        //  set the location of the source code to be compiled to the typeinfotest sample code dir
        hierarchyCompiler.set_SrcMetaCode_BaseDir(_10_AnnotationDetection_Constants.testProj_srcBase_DirPath);

        hierarchyCompiler.set_AppClasses_PackageName(_10_AnnotationDetection_Constants.testProj_appControl_PackageName);

        hierarchyCompiler.set_BuildMeta_BaseDir(_10_AnnotationDetection_Constants.testProj_BuildMeta_DirPath);
        hierarchyCompiler.set_BuildFinal_BaseDir(_10_AnnotationDetection_Constants.testProj_BuildFinal_DirPath );
        //  Setup the metacompiler to throw an exception instead of exiting
        hierarchyCompiler.set_onReportError_ThrowException_insteadOfExiting(true);
        hierarchyCompiler.set_PrintVerboseErrors(true);

        return hierarchyCompiler;
    }

}