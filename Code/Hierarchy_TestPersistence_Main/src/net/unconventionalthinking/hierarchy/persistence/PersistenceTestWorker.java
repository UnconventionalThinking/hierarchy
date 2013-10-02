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

import net.unconventionalthinking.matrix.MatrixControl;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import maintests.main.PersistClient_MainTests_Constants;




/**
 *
 * @author peterjoh
 */
public class PersistenceTestWorker {

    public PersistentMatricesManager_Client persistenceClient;
    public PersistentMatricesManager_Server persistenceServer;
    public HierarchySettings hierarchySettings;



    public PersistenceTestWorker(){}

    public void setupServer() throws Exception {

        //  Setup Server
        persistenceServer = new PersistentMatricesManager_Server();
        hierarchySettings = persistenceServer.getHierarchySettings();

        persistenceServer.setPersistenceServer_LogFileChunk_InboxDir(PersistenceTestWorker_Constants.PersistTestServer_ChunkInbox_DirPath);
        persistenceServer.setChunkCheck_Interval__Initial_ms(7 * 1000);
        persistenceServer.setPersistenceControl_RootDir(PersistenceTestWorker_Constants.PersistTestServer_PersistenceControl_RootDirPath);
        persistenceServer.setRmiRegistery_HostName(PersistenceTestConstants.Persistence_RmiRegistry_ConnectionSettings_forServer__Hostname);


        persistenceServer.setMetaCompiler__HierarchyJar_Dir(HierarchySettings.test_HierarchyJar_Dir);
        persistenceServer.setMetaCompiler__javac_Dir(HierarchySettings.test_Javac_Dir);
        persistenceServer.setMetaCompiler__SrcMetaCode_BaseDir(PersistenceTestWorker_Constants.PersistTestServer_SrcMetaCode_BaseDirPath);
        persistenceServer.setMetaCompiler__AppClasses_PackageName(PersistClient_MainTests_Constants.maintests_generatedCode_PackageName);

        // output to a separate build_generatedmeta dir
        persistenceServer.setMetaCompiler__BuildMeta_BaseDir(PersistenceTestWorker_Constants.PersistTestServer_BuildMeta_DirPath);
        persistenceServer.setMetaCompiler__BuildFinal_BaseDir(PersistenceTestWorker_Constants.PersistTestServer_BuildFinal_DirPath);


        persistenceServer.setClient__SrcMetaCode_BaseDir(PersistenceTestWorker_Constants.PersistTestClient_SrcMetaCode_DirPath);
        persistenceServer.setClient__BuildMeta_BaseDir(PersistenceTestWorker_Constants.PersistTestClient_SrcMetaCode_DirPath);
        persistenceServer.setClient__BuildFinal_BaseDir(PersistenceTestWorker_Constants.PersistTestClient_BuildFinal_DirPath);


    }

    public void setupClient(MatrixControl matrixControl) throws Exception {

        //  Setup Client
        persistenceClient = new PersistentMatricesManager_Client(PersistenceTestWorker_Constants.PersistTestClient_UpdateLog_DirPath, PersistenceTestWorker_Constants.UpdateLog_FileName,
                true, matrixControl);
        persistenceClient.setPersistenceServer_LogFileChunk_InboxDir(PersistenceTestWorker_Constants.PersistTestServer_ChunkInbox_DirPath);
        persistenceClient.setChunkCheck_Interval__Initial_ms(3 * 1000);
        persistenceClient.setChunkCheck_Interval_ms(7 * 1000);
        persistenceClient.setChunkSizeBoundary_LineCount(4);

        persistenceClient.setRmiRegistery_HostName(PersistenceTestConstants.Persistence_RmiRegistry_ConnectionSettings_forClient__Hostname);

        persistenceClient.setMetaCompiler__HierarchyJar_Dir(HierarchySettings.test_HierarchyJar_Dir);
        persistenceClient.setMetaCompiler__javac_Dir(HierarchySettings.test_Javac_Dir);

        // NOTE: this points the this projects src dir
        persistenceClient.setMetaCompiler__SrcMetaCode_BaseDir(PersistenceTestWorker_Constants.PersistTestClient_SrcMetaCode_DirPath);
        persistenceClient.setMetaCompiler__AppClasses_PackageName(PersistClient_MainTests_Constants.maintests_generatedCode_PackageName);

        // output to a separate build_generatedmeta dir
        persistenceClient.setMetaCompiler__BuildMeta_BaseDir(PersistenceTestWorker_Constants.PersistTestClient_BuildMeta_DirPath);
        persistenceClient.setMetaCompiler__BuildFinal_BaseDir(PersistenceTestWorker_Constants.PersistTestClient_BuildFinal_DirPath);



    }

}
