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

import net.unconventionalthinking.matrix.AppControl_Base;
import net.unconventionalthinking.hierarchy.HierarchySettings.BuildMode_ProjectOrSingleAppPackage;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbolTable_App;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
public class HierarchyMetaCompilerTest {

    public HierarchyMetaCompilerTest() { }

    @BeforeClass
    public static void setUpClass() throws Exception { }
    @AfterClass
    public static void tearDownClass() throws Exception { }
    @Before
    public void setUp() { }
    @After
    public void tearDown() { }


    
    /**
     * Test of parseClassPath_intoURLs method, of class HierarchyMetaCompiler.
     */
    @Test
    public void testParseClassPath_intoURLs() throws Exception {
        System.out.println("parseClassPath_intoURLs");

        HierarchySettings hierarchySettings = new HierarchySettings();

        String classpath = "";
        List<URL> expResult = new ArrayList<URL>();
        List<URL> result = HierarchyMetaCompiler.parseClassPath_intoURLs(classpath, hierarchySettings );
        assertEquals(expResult, result);

        classpath = null;
        expResult = new ArrayList<URL>();
        result = HierarchyMetaCompiler.parseClassPath_intoURLs(classpath, hierarchySettings);
        assertEquals(expResult, result);


        classpath = "../lib/sablecc-3.2/sablecc.jar";
        expResult = Arrays.asList(new URL[]{  new File("../lib/sablecc-3.2/sablecc.jar").toURI().toURL()}) ;
        result = HierarchyMetaCompiler.parseClassPath_intoURLs(classpath, hierarchySettings);
        assertEquals(expResult.size(), result.size());
        assertEquals(expResult.get(0), result.get(0));


        classpath = "../lib/sablecc-3.2/sablecc.jar" + File.pathSeparator + "my/path";
        expResult = Arrays.asList(new URL[]{  new File("../lib/sablecc-3.2/sablecc.jar").toURI().toURL(),
                                new File("my/path").toURI().toURL() }) ;
        result = HierarchyMetaCompiler.parseClassPath_intoURLs(classpath, hierarchySettings);
        assertEquals(expResult.size(), result.size());
        assertEquals(expResult.get(0), result.get(0));
        assertEquals(expResult.get(1), result.get(1));


        boolean hadError = false;
        try {
            hierarchySettings.errorsSettings.add(HierarchySettings.Errors.Invalid_ClassPathElement);
            classpath = "../lib/sablecc-3.2/sablecc.jar:my/path";
            expResult = Arrays.asList(new URL[]{  new File("../lib/sablecc-3.2/sablecc.jar").toURI().toURL(),
                                    new File("my/path").toURI().toURL() }) ;
            result = HierarchyMetaCompiler.parseClassPath_intoURLs(classpath, hierarchySettings);
        } catch (Throwable e) {
            hadError = true;
        }

        assertTrue(hadError);
    }

}