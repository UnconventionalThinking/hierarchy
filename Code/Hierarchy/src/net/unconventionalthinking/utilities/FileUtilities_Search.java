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
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import net.unconventionalthinking.exceptions.ExceptRuntime_InvalidArgumentPassed;
import net.unconventionalthinking.matrix.metacompiler.codefilegen.CodeGeneratorConstants;

/**
 *
 * @author Peter Joh
 */
public class FileUtilities_Search {

    /**
     * If you pass in a regular expression, it use the Java Matcher's find() method. This means it will be looking for subsequence, not a full match.
     *
     */
    public static boolean searchFileForString(File fileToSearch, String searchString, boolean isRegExp, int maxNumberOfLinesToSearch) {

            boolean search_MaxNumOfLines_Enabled = maxNumberOfLinesToSearch >= 0;

            Pattern searchPattern = null;
            if (isRegExp)
                searchPattern = Pattern.compile(searchString);



            BufferedReader bufferedFileReader = null;
            DataInputStream inputStream = null;
            try {
                File currFileObj = FileLoader.openFileAndCheckExists(fileToSearch.getAbsolutePath());

                // Get the object of DataInputStream
                inputStream = new DataInputStream(new FileInputStream(currFileObj));
                bufferedFileReader = new BufferedReader(new InputStreamReader(inputStream));
            } catch (FileNotFoundException e) {
                throw new ExceptRuntime_InvalidArgumentPassed("Could not open the file: " +
                        (fileToSearch != null ? fileToSearch.getAbsolutePath() : null), e);
            }


            boolean foundToken = false;
            try {
                
                String line;
                int lineNumber = 0;
                while ((!search_MaxNumOfLines_Enabled || lineNumber < maxNumberOfLinesToSearch) &&
                        (line = bufferedFileReader.readLine()) != null &&
                        !foundToken) {

                    if (isRegExp) {
                        foundToken = searchPattern.matcher(line).find();
                    } else {
                        if (line.contains(searchString))
                            foundToken = true;
                    }
                }

                //Close the input stream
                inputStream.close();

            } catch (IOException e) {
                throw new ExceptRuntime_InvalidArgumentPassed("Had problems reading the file: " +
                        (fileToSearch != null ? fileToSearch.getAbsolutePath() : null), e);
            }

            return foundToken;
    }
}
