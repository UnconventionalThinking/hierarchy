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

/**
 *
 * @author peterjoh
 */
public class TestMatrixProject_1_Constants {

    public final static String HierarchyProject_Path = "../Hierarchy";
    public final static String Hierarchy_GenerationTestProject_Path = "../Hierarchy_GenerationTestProject";
    public final static String Hierarchy_TestMatrixProject_Path = "../Hierarchy_TestMatrixProject_1";


    //  ******************************
    //    SET THIS TO CORRECT PROJECT!
    //  ******************************
    public final static String CURR_PROJECT_DIR = Hierarchy_TestMatrixProject_Path;

    public final static String testProj_mainTests_PackageName = "maintests.samples";
    public final static String testProj_typeInfoTest_PackageName = "maintests.samples.typeinfotest";

    public final static String testProj_srcBase_DirPath = CURR_PROJECT_DIR + "/src";
    public final static String testProj_maintestsSamples_DirPath = testProj_srcBase_DirPath + "/" +
                                            FileUtilities.convert_DotName_to_Path(testProj_mainTests_PackageName);
    public final static String testProj_typeInfoTest_DirPath = testProj_srcBase_DirPath + "/" +
                                            FileUtilities.convert_DotName_to_Path(testProj_typeInfoTest_PackageName);

    
    public final static String testProj_Build_DirPath = CURR_PROJECT_DIR + "/matrix_build";
    public final static String testProj_BuildMeta_DirPath = testProj_Build_DirPath + "/build1_meta";
    public final static String testProj_BuildMeta_typeInfoTest_DirPath = testProj_BuildMeta_DirPath + "/" +
                                            FileUtilities.convert_DotName_to_Path(testProj_typeInfoTest_PackageName);
    public final static String testProj_BuildFinal_DirPath = testProj_Build_DirPath + "/build2_final";


}
