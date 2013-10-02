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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.unconventionalthinking.utilities.Exception_FileUtilities_ProcessingError;
import net.unconventionalthinking.utilities.FileUtilities;
import net.unconventionalthinking.utilities.FileUtilities_DirTreeProcessor;
import net.unconventionalthinking.utilities.FileUtilities_DirTreeProcessor_Method;

/**
 * This class does the work of processing the java files that are initially compiled.
 *
 * There are two ways the process the Java files:
 * 1. provide a list of Java files to initially compile.
 * 2. initially compile all the Java files.
 * 
 * @author Peter Joh
 */
abstract class HierarchyMetaCompilerWorker_InitallyCompiledJavaFiles {

    HierarchyMetaCompiler       metaCompiler;
    HierarchySettings           hierarchySettings;

    HierarchyMetaCompilerWorker_InitallyCompiledJavaFiles(HierarchyMetaCompiler metaCompiler) {
        this.metaCompiler = metaCompiler;
        this.hierarchySettings = metaCompiler.hierarchySettings;
    }

    abstract List<Class_FileInfo> copyToBuild() throws Exception_FileUtilities_ProcessingError, IOException;

    abstract List<Class_FileInfo> collectClassFileList() throws Exception_FileUtilities_ProcessingError, IOException;

}
