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

package net.unconventionalthinking.reflection;

import java.net.MalformedURLException;
import net.unconventionalthinking.matrix.AnnotationParameters;
import net.unconventionalthinking.matrix.Matrix;
import net.unconventionalthinking.matrix.Schema;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
public class DynamicClassUtilitiesTest {

    public DynamicClassUtilitiesTest() { }

    @BeforeClass
    public static void setUpClass() throws Exception { }
    @AfterClass
    public static void tearDownClass() throws Exception { }
    @Before
    public void setUp() { }
    @After
    public void tearDown() { }



    /**
     * Test of appClassPath__ClassExists method, of class DynamicClassUtilities.
     */
    @Test
    public void testAppClassPath__ClassExists_String() throws MalformedURLException {

        System.out.println("appClassPath__ClassExists");
        String fullClassName = Matrix.class.getCanonicalName();
        boolean expResult = true;
        boolean result = DynamicClassUtilities.appClassPath__ClassExists(fullClassName);
        assertEquals(expResult, result);


        fullClassName = Integer.class.getCanonicalName();
        result = DynamicClassUtilities.appClassPath__ClassExists(fullClassName);
        assertEquals(expResult, result);


        System.out.println("classPath__ClassExists");
        fullClassName = "org.apache.commons.collections.ArrayStack";
        expResult = true;
        List<URL> urls = DynamicClassUtilities.classPath__CreateUrls(new String[] {"../lib/commons-collections-3.2.1.jar" },
                DynamicClassUtilities.WarningAndError_Settings.Error,
                Arrays.asList(new String[]{"ERROR:"}) );
        
        System.out.println("common collections url: " + urls.get(0).toString());
        result = DynamicClassUtilities.classPath__ClassExists(urls, fullClassName);
        assertEquals(expResult, result);

        /*
        //  comment this out. have this code here in case you want ot test to see if you can access the testMatrix jar (and, it must already be built
        System.out.println("classPath__ClassExists in the testMatrixProject 5 jar");
        fullClassName = "maintests.samples.typeinfotest.anotherpackage.Test$__$Schema";
        expResult = true;
        urls = DynamicClassUtilities.classPath__CreateUrls(
                new String[] {"../Hierarchy_TestMatrixProject_5_JarTests_METABUILD/dist/Hierarchy_TestMatrixProject_5_JarTests_METABUILD.jar" },
                DynamicClassUtilities.WarningAndError_Settings.Error,
                Arrays.asList(new String[]{"ERROR:"}) );
        result = DynamicClassUtilities.classPath__ClassExists(urls, fullClassName);
        assertEquals(expResult, result);
        */
    }

    /**
     * Test of appClassPath__LoadClass method, of class DynamicClassUtilities.
     */
    @Test
    public void testAppClassPath__LoadClass_String() {

        System.out.println("appClassPath__LoadClass");

        String fullClassName = Matrix.class.getCanonicalName();
        Class expResult = Matrix.class;
        Class result = DynamicClassUtilities.appClassPath__LoadClass(fullClassName);
        assertEquals(expResult, result);


        fullClassName = Integer.class.getCanonicalName();
        expResult = Integer.class;
        result = DynamicClassUtilities.appClassPath__LoadClass(fullClassName);
        assertEquals(expResult, result);

        
    }

}