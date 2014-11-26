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
public class MainTests_Constants {

    public final static String HierarchyProject_Path = "../Hierarchy";
    public final static String Hierarchy_GenerationTestProject_Path = "../Hierarchy_GenerationTestProject";
    public final static String Hierarchy_TestMatrixProject_Path = "../Hierarchy_TestMatrixProject_1_METASRC";


    //  ******************************
    //    SET THIS TO CORRECT PROJECT!
    //  ******************************
    public final static String CURR_PROJECT_DIR = HierarchyProject_Path;

    public final static String maintests_generatedCode_PackageName = "maintests.samples";

    public final static String maintests_DirPath = CURR_PROJECT_DIR + "/test";
    public final static String maintests_maintestsSamples_DirPath = maintests_DirPath + "/" +
                                            FileUtilities.convert_DotName_to_Path(maintests_generatedCode_PackageName);

    public final static String maintests_Build_DirPath = CURR_PROJECT_DIR + "/testbuild";
    
    /*  // unused, because the maintests places the meta compiled java files back into the source directory. here, "maintests_DirPath"
    public final static String maintests_BuildMeta_DirPath = maintests_Build_DirPath + "/build1_meta";
    public final static String maintests_BuildMeta_maintestsSamples_DirPath = maintests_BuildMeta_DirPath + "/" +
                                            FileUtilities.convert_DotName_to_Path(maintests_generatedCode_PackageName);
     */
    public final static String maintests_BuildFinal_DirPath = maintests_Build_DirPath + "/build2_final";


}
