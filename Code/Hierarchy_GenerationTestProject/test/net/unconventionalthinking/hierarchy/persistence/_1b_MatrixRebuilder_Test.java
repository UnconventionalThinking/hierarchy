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

import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.Matrix;
import net.unconventionalthinking.matrix.MatrixControl;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author peterjoh
 */
public class _1b_MatrixRebuilder_Test {


    static ExecutionInfo executeInfo;
    static MatrixControl matrixControl;
    static SymbolControl symbolControl;
    static HierarchySettings hierarchySettings;

    static PersistentMatricesManager_Server persistMatrix_Manager;

    static Matrix testMatrix_Persistant;




    public _1b_MatrixRebuilder_Test() {    }


    @BeforeClass
    public static void setUpClass() throws Exception {

        persistMatrix_Manager = new PersistentMatricesManager_Server();
        hierarchySettings = persistMatrix_Manager.getHierarchySettings();
        
        persistMatrix_Manager.setMetaCompiler__HierarchyJar_Dir(HierarchySettings.test_HierarchyJar_Dir);
        persistMatrix_Manager.setMetaCompiler__javac_Dir(HierarchySettings.test_Javac_Dir);
        persistMatrix_Manager.setMetaCompiler__SrcMetaCode_BaseDir(MainTests_Constants.maintests_DirPath);
        persistMatrix_Manager.setMetaCompiler__AppClasses_PackageName(MainTests_Constants.maintests_generatedCode_PackageName);

        // output to a separate build_generatedmeta dir
        persistMatrix_Manager.setMetaCompiler__BuildMeta_BaseDir(MainTests_Constants.maintests_BuildMeta_DirPath);
        persistMatrix_Manager.setMetaCompiler__BuildFinal_BaseDir(MainTests_Constants.maintests_BuildFinal_DirPath);

        persistMatrix_Manager.set_PersistentMatrixName_Simple(PersistenceTestConstants.PersistentMatrixName_Simple);

        
        //  load the persistent matrix from the class files
        persistMatrix_Manager.load_PersistentMatrices();
 
        assertNotNull(persistMatrix_Manager.getPersistMatrix());

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {}
    @After
    public void tearDown() {}




    @Test
    public void _02_updatePersistentMatrix_Test() throws Exception {

        
        persistMatrix_Manager.loadAndRead_LogFile_Chunk(new File(PersistenceTestConstants.UpdateLog_FilePath), null);
    }

}