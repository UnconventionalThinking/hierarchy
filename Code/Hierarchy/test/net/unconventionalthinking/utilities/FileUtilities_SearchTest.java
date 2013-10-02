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


package net.unconventionalthinking.utilities;

import java.io.File;
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
public class FileUtilities_SearchTest {

    public FileUtilities_SearchTest() { }

    @BeforeClass
    public static void setUpClass() throws Exception { }
    @AfterClass
    public static void tearDownClass() throws Exception { }
    @Before
    public void setUp() { }
    @After
    public void tearDown() { }



    /**
     * Test of searchFileForString method, of class FileUtilities_Search.
     */
    @Test
    public void testSearchFileForString() {
        System.out.println("searchFileForString");

        File fileToSearch = new File("test/net/unconventionalthinking/utilities/" + "Test$__$Matrix.matrix");
        assertTrue(fileToSearch.exists());
        String searchString = "MATRIXPROG.PERSISTENCE.SETTINGS:\\s*\\{\\s*\\+?:IsPersistent";
        boolean isRegExp = true;
        int maxNumberOfLinesToSearch = -1;

        boolean expResult = true;
        boolean result = FileUtilities_Search.searchFileForString(fileToSearch, searchString, isRegExp, maxNumberOfLinesToSearch);
        assertEquals(expResult, result);

    }

}