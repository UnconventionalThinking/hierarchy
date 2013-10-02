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

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import maintests.main.MainTests_Constants;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Peter Joh
 */
public class HierarchyMetaCompilerWorker_InitallyCompiledJavaFiles_CompileSelectedClassesTest {

    public HierarchyMetaCompilerWorker_InitallyCompiledJavaFiles_CompileSelectedClassesTest() {}
    @BeforeClass
    public static void setUpClass() throws Exception {}
    @AfterClass
    public static void tearDownClass() throws Exception { }
    @Before
    public void setUp() { }
    @After
    public void tearDown() { }


    /**
     * Test of collectClassFileList method, of class HierarchyMetaCompilerWorker_InitallyCompileJavaFiles_CompileSelectedClasses.
     */
    @Test
    public void testCollectClassFileList() throws Exception {
        System.out.println("collectClassFileList");

        HierarchyMetaCompiler metaCompiler = new HierarchyMetaCompiler();
        String srcMetaCode_BaseDir__RelPath = MainTests_Constants.HierarchyProject_Path + "/src";
        metaCompiler.set_SrcMetaCode_BaseDir(srcMetaCode_BaseDir__RelPath );
        metaCompiler.set_InitiallyCompileAllJavaCode(false);

        List<String> selectedClassesToCompile = HierarchyMetaCompiler_Configurator.parseClassList_intoStrings(
            "net.unconventionalthinking.hierarchy.HierarchyControl, net.unconventionalthinking.hierarchy.Hierarchy");

        metaCompiler.set_InitiallyCompiledJava_SelectedClasses_List(selectedClassesToCompile);
        HierarchyMetaCompilerWorker_InitallyCompileJavaFiles_CompileSelectedClasses initiallyCompileJava_Worker =
                new HierarchyMetaCompilerWorker_InitallyCompileJavaFiles_CompileSelectedClasses(metaCompiler);

        List<Class_FileInfo> collectedClass_FileInfo_List = initiallyCompileJava_Worker.collectClassFileList();
        assertEquals(2, collectedClass_FileInfo_List.size());
        String dirPathToPackage_Cleaned = collectedClass_FileInfo_List.get(0).dirPath.replace('\\', '/');
        String expectedPath = new File(srcMetaCode_BaseDir__RelPath).getCanonicalPath().replace('\\', '/') + "/net/unconventionalthinking/hierarchy";
        assertEquals(expectedPath, dirPathToPackage_Cleaned);
    }


}