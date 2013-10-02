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
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Peter Joh
 */
public class FileUtilities_Delete {



    public static void deleteFile(String filePath) throws IOException {
        deleteFile(filePath, false);
    }

    public static void deleteFile(String filePath, boolean checkIfExists) throws IOException {

        File file = new File(filePath);

        if (!file.exists()) {
            if (checkIfExists) // don't throw error, just return
                return;
            else
                throw new IOException("The file does not exist:" + filePath);
        }
        if (!file.isFile())
            throw new IOException("The path given is not for a file: " + filePath);
        if (!file.canWrite())
            throw new IOException("The file to delete is not deletable: " + filePath);

        file.delete();


    }

    public static void deleteFile(File file) throws IOException {
        deleteFile(file, false);
    }
    public static void deleteFile(File file, boolean checkIfExists) throws IOException {


        if (!file.exists()) {
            if (checkIfExists) // don't throw error, just return
                return;
            else
                throw new IOException("The file does not exist:" + file.getCanonicalPath());
        }
        if (!file.isFile())
            throw new IOException("The path given is not for a file: " + file.getCanonicalPath());
        if (!file.canWrite())
            throw new IOException("The file to delete is not deletable: " + file.getCanonicalPath());

        file.delete();


    }




    public static void deleteFilesInDir(String dirPath) throws IOException { deleteFilesInDir(new File(dirPath), null, null); }
    public static void deleteFilesInDir(File dir) throws IOException { deleteFilesInDir(dir, null, null); }
    /**
     * @param dirPath
     * @param fileNameFilter    pass in a fileName filter, so only that only files with a matching file name are deleted.
     * @throws IOException
     */
    public static void deleteFilesInDir(String dirPath, FilenameFilter fileNameFilter) throws IOException { 
        deleteFilesInDir(new File(dirPath), fileNameFilter, null);
    }
    /**
     * @param dirPath
     * @param fileFilter    pass in a custom fileFilter, so only that only files that pass the custom fileFilter are deleted.
     * @throws IOException
     */
    public static void deleteFilesInDir(String dirPath, CustomFileFilter fileFilter) throws IOException { 
        deleteFilesInDir(new File(dirPath), null, fileFilter);
    }

    /**
     * @param dir
     * @param fileNameFilter    pass in a fileName filter, so only that only files with a matching file name are deleted.
     * @throws IOException
     */
    public static void deleteFilesInDir(File dir, FilenameFilter fileNameFilter, CustomFileFilter customFileFilter) throws IOException {

        if (!dir.exists())
            throw new IOException("The path to the dir does not exist: " + dir.getAbsolutePath());
        if (!dir.isDirectory())
            throw new IOException("The path given is not for a directory: " + dir.getAbsolutePath());
        if (!dir.canWrite())
            throw new IOException("The directory can not be modified: " + dir.getAbsolutePath());

        // Filter out by fileName (if fileName filter exists)
        File[] fileList = null;
        if (fileNameFilter != null)
            fileList = dir.listFiles(fileNameFilter);
        else
            fileList = dir.listFiles();

        //  Filter out by custom file filter (if it exists)
        List<File> finalFileList = null;
        if (customFileFilter != null) {
            finalFileList = new ArrayList<File>();

            for(File file : fileList) {
                if (customFileFilter.accept(file))
                    finalFileList.add(file);
            }
        } else {
            //  This shouldn't be too big a hit in terms of performance. Because this just creates a wrapper around the fileList object.
            finalFileList = Arrays.asList(fileList);
        }

        
        if (finalFileList.size() > 0) {
            for (File file : finalFileList) {
                if (file.exists() && file.isFile() && file.canWrite())
                    file.delete();
            }
        }

    }
    


    /**
     * @param dir_Path
     * @param fileNameFilter    an optional fileNameFilter. If passed in, will only delete files with a matching file name. But should have at least
     *                          either a fileNameFilter or a customFileFilter (or both).
     * @param customFileFilter  an optional customFileFilter. If passed in, will only delete files that are accepted by the filter. But should have at least
     *                          either a fileNameFilter or a customFileFilter (or both).
     * @param keep_RootDir  pass in true if you want to remove the root directory too.
     * @throws IOException
     */
    public static void deleteFilesInDir_Recursive(String dir_Path, FilenameFilter fileNameFilter, CustomFileFilter customFileFilter) throws IOException {
        deleteFilesInDir_Recursive(new File(dir_Path), fileNameFilter, customFileFilter);
    }

    /**
     * @param dir
     * @param fileNameFilter    an optional fileNameFilter. If passed in, will only delete files with a matching file name. But should have at least
     *                          either a fileNameFilter or a customFileFilter (or both).
     * @param customFileFilter  an optional customFileFilter. If passed in, will only delete files that are accepted by the filter. But should have at least
     *                          either a fileNameFilter or a customFileFilter (or both).
     * @param keep_RootDir      pass in true if you want to remove the root directory too.
     * @throws IOException
     */
    public static void deleteFilesInDir_Recursive(File dir, FilenameFilter fileNameFilter, CustomFileFilter customFileFilter)
            throws IOException {

        if (dir.exists()) {
            File[] allSubDir = dir.listFiles(FileUtilities.Dir_FileFilter);
            if (allSubDir != null)
                for (File subDir : allSubDir)
                    deleteFilesInDir_Recursive(subDir, fileNameFilter, customFileFilter);

            deleteFilesInDir(dir, fileNameFilter, customFileFilter);
        }
    }






    public static void deltree(String dir_Path) throws IOException { deltree(new File(dir_Path), false); }
    public static void deltree(File dir) throws IOException { deltree(dir, false); }

    public static void deltree(String dir_Path, boolean keep_RootDir) throws IOException { deltree(new File(dir_Path), keep_RootDir); }
    public static void deltree(File dir, boolean keep_RootDir) throws IOException {
        if (dir.exists()) {
            File[] allSubDir = dir.listFiles(FileUtilities.Dir_FileFilter);
            if (allSubDir != null)
                for (File subDir : allSubDir)
                    deltree(subDir);

            deleteFilesInDir(dir);
            if (!keep_RootDir)
                dir.delete();
        }
    }


}
