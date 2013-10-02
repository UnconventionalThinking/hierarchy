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

/**
 *
 * @author Peter Joh
 */
public class FileLoader {

    public static File openFileAndCheckExists(String filePath)
            throws FileNotFoundException {

        File file = new File(filePath);

        if (!file.exists()) {
            throw new FileNotFoundException("Could not find the file at the path: " + file.getAbsolutePath());
        }
        return file;
    }

    public static String openFile_and_LoadAsString(String filePath) throws FileNotFoundException,
            IOException {

        File file = openFileAndCheckExists(filePath);

        // Get the object of DataInputStream
        DataInputStream inputStream = new DataInputStream(new FileInputStream(file));
        BufferedReader bufferedFileReader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        StringBuilder strBuilder = new StringBuilder();
        while ((line = bufferedFileReader.readLine()) != null) {
            strBuilder.append(line).append("\n");
        }
        //Close the input stream
        inputStream.close();

        return strBuilder.toString();
    }
}
