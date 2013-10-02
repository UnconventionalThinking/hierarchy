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

package net.unconventionalthinking.hierarchy.persistence;

import net.unconventionalthinking.utilities.FileUtilities;

/**
 *
 * @author peterjoh
 */
public class PersistenceTestConstants {


    public final static String TestData_DirPath = maintests.main.MainTests_Constants.HierarchyProject_Path + "/testdata/serialization";

    public final static String JavaObjects_OutputFileName = "javaObjects.data";
    public final static String JavaObjects_OutputFile_Path = TestData_DirPath + "/" + JavaObjects_OutputFileName;


    public final static String UpdateLog_FileName = "matrixUpdates.log";
    public final static String UpdateLog_FilePath = TestData_DirPath + "/" + UpdateLog_FileName;

    public final static String PersistentMatrixName_Simple = "Test.Matrix";

    //  Chunk Test - Constants
    public final static String ChunkTestData_DirPath = maintests.main.MainTests_Constants.HierarchyProject_Path + "/testdata/serialization_ChunkTest";
    public final static String ChunkTestData_ServerInbox_DirPath = maintests.main.MainTests_Constants.HierarchyProject_Path + "/testdata/serialization_ChunkTest_ServerInbox";

    //  Persistence Client with Server Test constants
    public final static String PersistTest_BaseDir = maintests.main.MainTests_Constants.CURR_PROJECT_DIR + "/testbuild/test_persist";
    
    public final static String PersistTestClient_Base_DirPath =  PersistTest_BaseDir + "/client";
    public final static String PersistTestClient_Build_DirPath =  PersistTestClient_Base_DirPath + "/build";
    public final static String PersistTestClient_BuildMeta_DirPath = PersistTestClient_Build_DirPath + "/build1_meta";
    public final static String PersistTestClient_BuildMeta_maintestsSamples_DirPath = PersistTestClient_BuildMeta_DirPath + "/" +
                                            FileUtilities.convert_DotName_to_Path(maintests.main.MainTests_Constants.maintests_generatedCode_PackageName);
    public final static String PersistTestClient_BuildFinal_DirPath = PersistTestClient_Build_DirPath + "/build2_final";


    public final static String PersistTestServer_Base_DirPath =  PersistTest_BaseDir + "/server";
    public final static String PersistTestServer_Build_DirPath =  PersistTestServer_Base_DirPath + "/build";
    public final static String PersistTestServer_BuildMeta_DirPath = PersistTestServer_Build_DirPath + "/build1_meta";
    public final static String PersistTestServer_BuildMeta_maintestsSamples_DirPath = PersistTestServer_BuildMeta_DirPath + "/" +
                                            FileUtilities.convert_DotName_to_Path(maintests.main.MainTests_Constants.maintests_generatedCode_PackageName);
    public final static String PersistTestServer_BuildFinal_DirPath = PersistTestServer_Build_DirPath + "/build2_final";


};