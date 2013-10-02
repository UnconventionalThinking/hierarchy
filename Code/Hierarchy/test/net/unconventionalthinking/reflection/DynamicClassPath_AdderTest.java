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
public class DynamicClassPath_AdderTest {

    public DynamicClassPath_AdderTest() { }
    @BeforeClass
    public static void setUpClass() throws Exception { }
    @AfterClass
    public static void tearDownClass() throws Exception { }
    @Before
    public void setUp() {}
    @After
    public void tearDown() {}


    /**
     * Test of add_ClassPathElement method, of class DynamicClassPath_Adder.
     */
    @Test
    public void testAdd_ClassPathElement_String() throws Exception {
        System.out.println("add_ClassPathElement");

        File testJar_FileObj = new File("./testdata/testlib/org.restlet.ext.net.jar");

        assertTrue(testJar_FileObj.exists());
        boolean expResult = false;
        boolean wasAdded = DynamicClassPath_Adder.add_ClassPathElement(testJar_FileObj);
        assertTrue(wasAdded);


        boolean classExists = DynamicClassUtilities.appClassPath__ClassExists("org.restlet.ext.net.internal.HttpUrlConnectionCall");
        assertTrue(classExists);
    }


}