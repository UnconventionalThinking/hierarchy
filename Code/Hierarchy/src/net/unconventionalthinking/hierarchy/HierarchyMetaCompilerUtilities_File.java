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

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import net.unconventionalthinking.exceptions.ExceptRuntime_InvalidArgumentPassed;
import net.unconventionalthinking.matrix.metacompiler.codefilegen.CodeGeneratorConstants;
import net.unconventionalthinking.utilities.CustomFileFilter;
import net.unconventionalthinking.utilities.FileLoader;
import net.unconventionalthinking.utilities.FileUtilities_Search;

/**
 *
 * @author Peter Joh
 */
public class HierarchyMetaCompilerUtilities_File {

    public static final int MAX_NUM_LINES_CHECKED_FOR_TOKEN = 5;


    public static final CustomFileFilter checkJavaFile_for_MetacompilationToken__Filter = new CustomFileFilter() {

        public boolean accept(File currFile) {

            if (currFile.isDirectory() || !currFile.getName().toLowerCase().endsWith(".java"))
                return false;

            return FileUtilities_Search.searchFileForString(currFile, CodeGeneratorConstants.METACOMPILIED_FILE__COMMENT_TOKEN, false,
                    MAX_NUM_LINES_CHECKED_FOR_TOKEN);

        }
    };


}
