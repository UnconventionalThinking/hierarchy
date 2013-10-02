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
import java.io.IOException;

/**
 * The purpose of this class is to let you traverse a directory tree, processing each dir using a callback method.
 * you can set as "Process then Traverse" call back, or a "Traverse then Process" call back (or both).
 * 
 * @author peterjoh
 */
public class FileUtilities_DirTreeProcessor {


    private FileUtilities_DirTreeProcessor_Method dirProcessorMethod_ProcessThenTraverse;
    private FileUtilities_DirTreeProcessor_Method dirProcessorMethod_TraverseThenProcess;
    private Object[] otherParams;

    private File baseDir;

    //  Setup FileUtilities methods
    public void reset() { baseDir = null; dirProcessorMethod_ProcessThenTraverse = null; dirProcessorMethod_TraverseThenProcess = null; otherParams = null; }

    public void setDirProcessorMethod_ProcessThenTraverse(FileUtilities_DirTreeProcessor_Method dirProcessorMethod) {
        this.dirProcessorMethod_ProcessThenTraverse = dirProcessorMethod;
    }
    public void setDirProcessorMethod_TraverseThenProcess(FileUtilities_DirTreeProcessor_Method dirProcessorMethod) {
        this.dirProcessorMethod_TraverseThenProcess = dirProcessorMethod;
    }

    public void setOtherParams(Object[] otherParams) { this.otherParams = otherParams; }



    /** Pass in the path name as a string, and process sub directories. */
    public void traverseAndProcess(String currDir_Path) throws IOException, Exception_FileUtilities_ProcessingError
        { traverseAndProcess(new File(currDir_Path), true); }

    /** Pass in the path name as a string, and pass in whether you want to process sub dir. */
    public void traverseAndProcess(String currDir_Path, boolean traverse_SubDirNodes) throws IOException, Exception_FileUtilities_ProcessingError
        { traverseAndProcess(new File(currDir_Path), traverse_SubDirNodes); }

    /** Pass in the path name as a File object, and process sub directories. */
    public void traverseAndProcess(File currDir_Path) throws IOException, Exception_FileUtilities_ProcessingError
        { traverseAndProcess(currDir_Path, true); }

    /** Pass in the path name as a File object, and pass in whether you want to process sub dir. */
    public void traverseAndProcess(File currDir_Path, boolean traverse_SubDirNodes)
            throws IOException, Exception_FileUtilities_ProcessingError {

        if (baseDir == null)
            baseDir = currDir_Path;

        if (dirProcessorMethod_ProcessThenTraverse != null)
            dirProcessorMethod_ProcessThenTraverse.processDir(currDir_Path, baseDir, otherParams);

        if (traverse_SubDirNodes) {
            File[] allSubDir = currDir_Path.listFiles(FileUtilities.Dir_FileFilter);
            if (allSubDir != null)
                for (File subDir : allSubDir)
                    traverseAndProcess(subDir);
        }

        if (dirProcessorMethod_TraverseThenProcess != null)
            dirProcessorMethod_TraverseThenProcess.processDir(currDir_Path, baseDir, otherParams);

    }




    public FileUtilities_DirTreeProcessor_Method getDirProcessorMethod_ProcessThenTraverse() { return dirProcessorMethod_ProcessThenTraverse; }
    public FileUtilities_DirTreeProcessor_Method getDirProcessorMethod_TraverseThenProcess() { return dirProcessorMethod_TraverseThenProcess; }

    public Object[] getOtherParams() { return otherParams;}

}
