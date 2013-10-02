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

import maintests.main.PersistClient_MainTests_Constants;
import net.unconventionalthinking.utilities.FileUtilities;
import maintests.main.PersistMain_MainTests_Constants;

/**
 *
 * @author peterjoh
 */
public class PersistenceTestWorker_Constants {


    public final static String TestData_DirPath = PersistMain_MainTests_Constants.CURR_PROJECT_DIR + "/testdata/serialization";

    public final static String JavaObjects_OutputFileName = "javaObjects.data";
    public final static String JavaObjects_OutputFile_Path = TestData_DirPath + "/" + JavaObjects_OutputFileName;


    public final static String UpdateLog_FileName = "matrixUpdates.log";
    public final static String UpdateLog_FilePath = TestData_DirPath + "/" + UpdateLog_FileName;

    public final static String PersistentMatrixName_Simple = "Test.Matrix";

    
    //  ______________________________________________________________________________________________________________________
    //
    //  Persistence Test Client & Server Constants
    //  ______________________________________________________________________________________________________________________

    //  Chunk Test - Constants
    public final static String PersistTest_MatrixData_DirName = "matrix_data";

    public final static String PersistTestClient_UpdateLog_DirPath = PersistenceTestConstants.ProjDir__PersistenceTestClient +
                                                                "/" + PersistTest_MatrixData_DirName + "/serialization_ChunkTest";
    public final static String PersistTestServer_ChunkInbox_DirPath = PersistenceTestConstants.ProjDir__PersistenceTestServer +
                                                                "/" + PersistTest_MatrixData_DirName + "/serialization_ChunkTest_ServerInbox";
    public final static String PersistTestServer_PersistenceControl_RootDirPath = PersistenceTestConstants.ProjDir__PersistenceTestServer +
                                                                "/" + PersistTest_MatrixData_DirName + "/serialization_ChunkTest_ServerControl";


    
    //  Persistence Test Client Constants __________________________________________________________________________
    
    public final static String PersistTestClient_Base_DirPath = PersistenceTestConstants.ProjDir__PersistenceTestClient;
    public final static String PersistTestClient_MatrixBuild_DirPath =  PersistTestClient_Base_DirPath + "/matrix_build";
    public final static String PersistTestClient_BuildMeta_DirPath = PersistTestClient_MatrixBuild_DirPath + "/build1_meta";
    public final static String PersistTestClient_BuildMeta_maintestsSamples_DirPath = PersistTestClient_BuildMeta_DirPath + "/" +
                                    FileUtilities.convert_DotName_to_Path(PersistClient_MainTests_Constants.maintests_generatedCode_PackageName);

    /** NOTICE - The final build location of the client is the project's build dir! Why? because, the client does NOT dyn load the matrix classes.
     *  It uses them directly (because, it may actually directly reference a generated class */
    public final static String PersistTestClient_BuildFinal_DirPath = PersistTestClient_Base_DirPath + "/build/classes";

    /** points to the project's src/maintests.samples dir **/
    public final static String PersistTestClient_SrcMetaCode_DirPath = PersistTestClient_Base_DirPath + "/src";
    public final static String PersistTestClient_SrcMetaCode_maintestsSamples_DirPath = PersistTestClient_SrcMetaCode_DirPath + "/" +
            FileUtilities.convert_DotName_to_Path(PersistClient_MainTests_Constants.maintests_generatedCode_PackageName);


    public final static String PersistTestClient_CleanTestMatrices_BaseDirPath = PersistTestClient_Base_DirPath + "/zz_orig_code";


    
    //  Persistence Test Server Constants __________________________________________________________________________

    public final static String PersistTestServer_Base_DirPath =  PersistenceTestConstants.ProjDir__PersistenceTestServer;
    
    public final static String PersistTestServer_SrcMetaCode_BaseDirPath =  PersistTestServer_Base_DirPath + "/src_meta/";
    public final static String PersistTestServer_SrcMetaCode_maintestsSamples_DirPath = PersistTestServer_SrcMetaCode_BaseDirPath +
            FileUtilities.convert_DotName_to_Path(PersistClient_MainTests_Constants.maintests_generatedCode_PackageName);

    public final static String PersistTestServer_Build_DirPath =  PersistTestServer_Base_DirPath + "/matrix_build";
    public final static String PersistTestServer_BuildMeta_DirPath = PersistTestServer_Build_DirPath + "/build1_meta";
    public final static String PersistTestServer_BuildMeta_maintestsSamples_DirPath = PersistTestServer_BuildMeta_DirPath + "/" +
                                            FileUtilities.convert_DotName_to_Path(PersistClient_MainTests_Constants.maintests_generatedCode_PackageName);
    public final static String PersistTestServer_BuildFinal_DirPath = PersistTestServer_Build_DirPath + "/build2_final";


}