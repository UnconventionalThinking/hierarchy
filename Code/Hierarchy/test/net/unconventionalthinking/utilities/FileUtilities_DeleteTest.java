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

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import net.unconventionalthinking.exceptions.ExceptRuntime_InvalidArgumentPassed;
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
public class FileUtilities_DeleteTest {

    public FileUtilities_DeleteTest() {   }
    @BeforeClass
    public static void setUpClass() throws Exception {  }
    @AfterClass
    public static void tearDownClass() throws Exception {   }
    @Before
    public void setUp() throws Exception {
        FileUtilities_Delete.deltree(TESTDATA_TEST_BASEDIR_PATH, true);
        FileUtilities.copyFilesInDir_Recursive(TESTDATA_ORIGINAL_BASEDIR_PATH, TESTDATA_TEST_BASEDIR_PATH, true, true);


    }
    @After
    public void tearDown() {   }

    public final static String TESTDATA_ORIGINAL_BASEDIR_PATH = "testdata/fileutilities/ORIGINAL";
    public final static String TESTDATA_TEST_BASEDIR_PATH = "testdata/fileutilities/TEST";

    public final static String TESTDATA_FILENAME__CHILD1DOC1 = "child1doc1.txt";
    public final static String TESTDATA_FILENAME__CHILD1DOC2 = "child1doc2.txt";

    public final static String TESTDATA_FILENAME__CHILD2DOC2 = "child2doc2.txt";



    CustomFileFilter customFileFilter = new CustomFileFilter() {

        static final String SEARCH_TOKEN = "DELETETOKEN";
        public boolean accept(File currFile) {

            if (currFile.isDirectory() || !currFile.getName().toLowerCase().endsWith(".txt"))
                return false;

            BufferedReader bufferedFileReader = null;
            DataInputStream inputStream = null;
            try {
                File currFileObj = FileLoader.openFileAndCheckExists(currFile.getAbsolutePath());

                // Get the object of DataInputStream
                inputStream = new DataInputStream(new FileInputStream(currFileObj));
                bufferedFileReader = new BufferedReader(new InputStreamReader(inputStream));
            } catch (FileNotFoundException e) {
                throw new ExceptRuntime_InvalidArgumentPassed("Could not open the file: " +
                        (currFile != null ? currFile.getAbsolutePath() : null), e);
            }

            boolean foundToken = false;
            try {
                String line;
                while ((line = bufferedFileReader.readLine()) != null && !foundToken) {
                    if (line.contains(SEARCH_TOKEN))
                        foundToken = true;
                }
                //Close the input stream
                inputStream.close();
            } catch (IOException e) {
                throw new ExceptRuntime_InvalidArgumentPassed("Had problems reading the file: " +
                        (currFile != null ? currFile.getAbsolutePath() : null), e);

            }
            return foundToken;
        }
    };






    /**
     * Test of deleteFilesInDir method, of class FileUtilities_Delete.
     */
    @Test
    public void testDeleteFilesInDir_String_CustomFileFilter() throws Exception {
        System.out.println("deleteFilesInDir");
        String dirPath = TESTDATA_TEST_BASEDIR_PATH + "/root/parent/child1";

        //  child1doc1.txt and child1doc2.txt should both be in this dir.
        File[] listOfFiles = FileUtilities.getFilesInDir(dirPath);
        assertNotNull(listOfFiles);
        assertTrue(listOfFiles.length == 2);

        FileUtilities_Delete.deleteFilesInDir(dirPath, customFileFilter);

        //  child1doc1.txt is the only file that should be left.
        listOfFiles = FileUtilities.getFilesInDir(dirPath);
        assertNotNull(listOfFiles);
        assertTrue(listOfFiles.length == 1);
        assertTrue(listOfFiles[0].getName().equals(TESTDATA_FILENAME__CHILD1DOC1));
    }

    /**
     * Test of deleteFilesInDir_Recursive method, of class FileUtilities_Delete.
     */
    @Test
    public void testDeleteFilesInDir_Recursive_4args() throws Exception {
        System.out.println("deleteFilesInDir_Recursive");

        String dirPath_Child1 = TESTDATA_TEST_BASEDIR_PATH + "/root/parent/child1";
        String dirPath_Child2 = TESTDATA_TEST_BASEDIR_PATH + "/root/parent/child2";

        //  child1doc1.txt and child1doc2.txt should both be in this dir.
        File[] listOfFiles = FileUtilities.getFilesInDir(dirPath_Child1);
        assertTrue(listOfFiles.length == 2);

        listOfFiles = FileUtilities.getFilesInDir(dirPath_Child2);
        assertTrue(listOfFiles.length == 2);

        FileUtilities_Delete.deleteFilesInDir_Recursive(TESTDATA_TEST_BASEDIR_PATH, null, customFileFilter);

        //  child1doc1.txt is the only file that should be left.
        listOfFiles = FileUtilities.getFilesInDir(dirPath_Child1);
        assertNotNull(listOfFiles);
        assertTrue(listOfFiles.length == 1);
        assertTrue(listOfFiles[0].getName().equals(TESTDATA_FILENAME__CHILD1DOC1));

        //  child2doc2.txt is the only file that should be left.
        listOfFiles = FileUtilities.getFilesInDir(dirPath_Child2);
        assertNotNull(listOfFiles);
        assertTrue(listOfFiles.length == 1);
        assertTrue(listOfFiles[0].getName().equals(TESTDATA_FILENAME__CHILD2DOC2));

    }

}