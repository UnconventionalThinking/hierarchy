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

import net.unconventionalthinking.hierarchy.persistence.PersistenceTestConstants;
import net.unconventionalthinking.utilities.FileUtilities;

/**
 * This class needs to be here in the PersistenceMain project instead of in PersistenceClient. Why?
 * because the PersistenceTest_Worker class uses it (which sets up the server too).
 * 
 * @author peterjoh
 */
public class PersistClient_MainTests_Constants extends PersistenceTestConstants {

    //  ******************************
    //    SET THIS TO CORRECT PROJECT!
    //  ******************************
    public final static String CURR_PROJECT_DIR = ProjDir__PersistenceTestClient;

    public final static String maintests_generatedCode_PackageName = "maintests.samples.persistenceclient";

    public final static String maintests_DirPath = CURR_PROJECT_DIR + "/src";
    public final static String maintests_maintestsSamples_DirPath = maintests_DirPath + "/" +
                                            FileUtilities.convert_DotName_to_Path(maintests_generatedCode_PackageName);

    public final static String maintests_Build_DirPath = CURR_PROJECT_DIR + "/testbuild";
    public final static String maintests_BuildMeta_DirPath = maintests_Build_DirPath + "/build1_meta";
    public final static String maintests_BuildMeta_maintestsSamples_DirPath = maintests_BuildMeta_DirPath + "/" +
                                            FileUtilities.convert_DotName_to_Path(maintests_generatedCode_PackageName);
    public final static String maintests_BuildFinal_DirPath = maintests_Build_DirPath + "/build2_final";


}
