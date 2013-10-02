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

import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author peterjoh
 */
public class FileUtilities {

    public static FileFilter Dir_FileFilter = new FileFilter() {
        public boolean accept(File file) {
            return file.isDirectory();
        }
    };
    public static FileFilter File_FileFilter = new FileFilter() {
        public boolean accept(File file) {
            return file.isFile();
        }
    };

    public static void writeToFile(String fileDir, String fileName, boolean deleteFileIfExists, String output, boolean autoFlushBufferForDebug)
            throws IOException {
        writeToFile(fileDir + "/" + fileName, deleteFileIfExists, output, autoFlushBufferForDebug);
    }

    public static void writeToFile(String filePath, boolean deleteFileIfExists, String output, boolean autoFlushBufferForDebug)
            throws IOException {
        File fileObj = new File(filePath);

        if (fileObj.exists()) {
            //  remove old file
            fileObj.delete();
        }


        PrintWriter symbolWriter = null;
        try {
            //  if autoFlushBufferForDebug == true, then you automatic autoflush of print buffer everytime you do a newline.
            symbolWriter = new PrintWriter(new FileWriter(fileObj), autoFlushBufferForDebug);

            symbolWriter.print(output);
            symbolWriter.close();
        } catch (IOException e) {
            throw e;
        }

    }

    public static File[] getFilesInDir(String dirPath) throws IOException {
        return getFilesInDir(dirPath, (FilenameFilter) null);
    }

    public static File[] getFilesInDir(String dirPath, FilenameFilter fileNameFilter) throws IOException {

        File dir = new File(dirPath);

        if (!dir.exists()) {
            throw new IOException("The path to the dir does not exist: " + dirPath);
        }
        if (!dir.isDirectory()) {
            throw new IOException("The path given is not for a directory: " + dirPath);
        }

        File[] fileList = null;
        if (fileNameFilter != null) {
            fileList = dir.listFiles(fileNameFilter);
        } else {
            fileList = dir.listFiles();
        }

        return fileList;
    }

    /**
     * The Dir_FileFilter will be passed File object that it can use to filter out files (such as checking to see if it's a directory).
     */
    public static File[] getFilesInDir(String dirPath, FileFilter fileFilter) throws IOException {

        File dir = new File(dirPath);

        if (!dir.exists()) {
            throw new IOException("The path to the dir does not exist: " + dirPath);
        }
        if (!dir.isDirectory()) {
            throw new IOException("The path given is not for a directory: " + dirPath);
        }

        File[] fileList = null;
        if (fileFilter != null) {
            fileList = dir.listFiles(fileFilter);
        } else {
            fileList = dir.listFiles();
        }

        return fileList;
    }

    public static File[] getDirectoriesInDir(String dirPath) throws IOException {
        return getDirectoriesInDir(dirPath, null);
    }

    public static File[] getDirectoriesInDir(String dirPath, FilenameFilter fileNameFilter) throws IOException {

        File dir = new File(dirPath);

        if (!dir.exists()) {
            throw new IOException("The path to the dir does not exist: " + dirPath);
        }
        if (!dir.isDirectory()) {
            throw new IOException("The path given is not for a directory: " + dirPath);
        }

        File[] fileList = null;
        if (fileNameFilter != null) {
            FileAndFilenameFilter fileAndFilenameFilter = new FileAndFilenameFilter(Dir_FileFilter, fileNameFilter);
            fileList = dir.listFiles(fileAndFilenameFilter);
        } else {
            fileList = dir.listFiles(Dir_FileFilter);
        }

        return fileList;
    }

    public static void copyFilesInDir(String srcDir_Path, String destDir_Path, boolean replace_If_FileAlreadyExists) throws IOException {
        copyFilesInDir(srcDir_Path, null, destDir_Path, replace_If_FileAlreadyExists);
    }

    public static void copyFilesInDir(String srcDir_Path, FilenameFilter fileNameFilter, String destDir_Path, boolean replace_If_FileAlreadyExists)
            throws IOException {
        copyFilesInDir(new File(srcDir_Path), null, new File(destDir_Path), replace_If_FileAlreadyExists);
    }

    public static void copyFilesInDir(File srcDir, FilenameFilter fileNameFilter, File destDir, boolean replace_If_FileAlreadyExists)
            throws IOException {

        if (srcDir == null) {
            throw new IOException("The path to the src directory is null.");
        }
        if (!srcDir.exists()) {
            throw new IOException("The path to the src directory does not exist: " + srcDir.getAbsolutePath());
        }
        if (!srcDir.isDirectory()) {
            throw new IOException("The source directory path given is not for a directory: " + srcDir.getAbsolutePath());
        }

        if (destDir == null) {
            throw new IOException("The path to the destination directory is null.");
        }
        if (!destDir.exists()) {
            throw new IOException("The path to the destination directory does not exist: " + destDir.getAbsolutePath());
        }
        if (!destDir.isDirectory()) {
            throw new IOException("The destination directory path given is not for a directory: " + destDir.getAbsolutePath());
        }


        File[] src_FileList = null;
        if (fileNameFilter != null) {
            src_FileList = srcDir.listFiles(fileNameFilter);
        } else {
            src_FileList = srcDir.listFiles();
        }


        if (src_FileList != null) {
            for (File file : src_FileList) {

                if (file.isFile() && !file.isHidden() && file.canRead()) {
                    File existing_SrcFile = new File(destDir.getPath() + "/" + file.getName());

                    if (existing_SrcFile != null && existing_SrcFile.exists()) {
                        if (replace_If_FileAlreadyExists) {
                            FileUtilities_Delete.deleteFile(existing_SrcFile);
                        } else {
                            throw new IOException("Cannot copy file," + file.getName() + ", it already exists in the destination directory. The soure dir is, "
                                    + srcDir.getPath() + ", and the destination dir is, " + destDir.getPath());
                        }
                    }

                    copyFile(file, existing_SrcFile);
                }
            }
        }

    }

    public static void copyFilesInDir_Recursive(String srcDir_Path, String destDir_Path, boolean createDir_If_NotExist, boolean replace_If_FileAlreadyExists)
            throws IOException {
        copyFilesInDir_Recursive(new File(srcDir_Path), null, new File(destDir_Path), createDir_If_NotExist, replace_If_FileAlreadyExists);
    }

    public static void copyFilesInDir_Recursive(File srcDir, File destDir, boolean createDir_If_NotExist, boolean replace_If_FileAlreadyExists)
            throws IOException {
        copyFilesInDir_Recursive(srcDir, null, destDir, createDir_If_NotExist, replace_If_FileAlreadyExists);
    }

    public static void copyFilesInDir_Recursive(String srcDir_Path, FilenameFilter fileNameFilter, String destDir_Path,
            boolean createDir_If_NotExist, boolean replace_If_FileAlreadyExists) throws IOException {
        copyFilesInDir_Recursive(new File(srcDir_Path), null, new File(destDir_Path), createDir_If_NotExist, replace_If_FileAlreadyExists);
    }

    public static void copyFilesInDir_Recursive(File srcDir, FilenameFilter fileNameFilter, File destDir,
            boolean createDir_If_NotExist, boolean replace_If_FileAlreadyExists) throws IOException {

        if (!destDir.exists()) {
            if (createDir_If_NotExist) {
                destDir.mkdir();
            } else {
                throw new IOException("Tried to recusively copy multiple files from one directory to another. But, in the destination, a sub-dir was missing "
                        + "(and 'create directory if not exist' was not turned on). The src directory was: " + srcDir.getPath() + ", and the destination directory was: " + destDir.getPath() + ".");
            }
        }

        copyFilesInDir(srcDir, fileNameFilter, destDir, replace_If_FileAlreadyExists);

        File[] subDir_List = getDirectoriesInDir(srcDir.getPath());

        for (File subDir : subDir_List) {
            copyFilesInDir_Recursive(subDir, fileNameFilter, new File(destDir, subDir.getName()), createDir_If_NotExist, replace_If_FileAlreadyExists);
        }
    }

    public static void copyFileToDestDir(String srcFilePath, String destFileDir) throws IOException {
        File srcFile = new File(srcFilePath);
        File destFile = new File(destFileDir + "/" + srcFile.getName());

        copyFile(srcFile, destFile);
    }

    public static void copyFileToDestDir(File srcFile, String destFileDir) throws IOException {
        File destFile = new File(destFileDir + "/" + srcFile.getName());

        copyFile(srcFile, destFile);
    }

    public static void copyFileToDestDir(File srcFile, File destDir) throws IOException {
        File destFile = new File(destDir, srcFile.getName());

        copyFile(srcFile, destFile);
    }

    public static void copyFile(String srcFilePath, String destFilePath) throws IOException {


        File srcFile = new File(srcFilePath);
        File destFile = new File(destFilePath);

        copyFile(srcFile, destFile);
    }

    public static void copyFile(File srcFile, File destFile) throws IOException {
        if (srcFile == null) {
            throw new IOException("the path to the src file is null.");
        }
        if (!srcFile.exists()) {
            throw new IOException("For the move operation, the path to the src file does not exist: " + srcFile.getAbsolutePath());
        }


        InputStream in = new FileInputStream(srcFile);

        //For Overwrite the file.
        OutputStream out = new FileOutputStream(destFile);


        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();

    }

    public static File moveFile(String srcFile_Dir, String srcFile_Name, String destDir) throws IOException {
        return moveFile(new File(srcFile_Dir, srcFile_Name), new File(destDir));
    }

    public static File moveFile(String srcFile_Path, String destDir) throws IOException {
        return moveFile(new File(srcFile_Path), new File(destDir));
    }

    public static File moveFile(File srcFile, String destDir) throws IOException {
        return moveFile(srcFile, new File(destDir));
    }

    public static File moveFile(File srcFile, File destDir) throws IOException {
        if (srcFile == null) {
            throw new IOException("the path to the src file is null.");
        }
        if (!srcFile.exists()) {
            throw new IOException("For the move operation, the path to the src file does not exist: " + srcFile.getAbsolutePath());
        }

        File destFile = new File(destDir, srcFile.getName());
        boolean renameSucceeded = srcFile.renameTo(destFile);

        if (!renameSucceeded) {
            throw new IOException("Couldn't move the file. Tried to move, " + srcFile.getAbsolutePath() + ", to the director, " + destDir.getPath()
                    + " but had an error.");
        }

        return destFile;
    }

    /**
     * This can only create a directory in an existing parent directory (meaning, it won't create any ancestor directories if they don't exist).
     */
    public static File makeDir(String dirPath) throws IOException {
        return makeDir(dirPath, false);
    }

    /**
     * This method can create any non-existing ancestor directories.
     */
    public static File makeDir(String dirPath, boolean createAncestorDirectories) throws IOException {
        File dir = new File(dirPath);
        return makeDir(dir, createAncestorDirectories);
    }

    /**
     * This can only create a directory in an existing parent directory (meaning, it won't create any ancestor directories if they don't exist).
     */
    public static File makeDir(File parentDir, String dirName) throws IOException {
        return makeDir(parentDir, dirName, false);
    }

    /**
     * This method can create any non-existing ancestor directories.
     */
    public static File makeDir(File parentDir, String dirName, boolean createAncestorDirectories) throws IOException {
        File dir = new File(parentDir, dirName);
        return makeDir(dir, createAncestorDirectories);
    }

    /**
     * This can only create a directory in an existing parent directory (meaning, it won't create any ancestor directories if they don't exist).
     */
    public static File makeDir(File dir) throws IOException {
        return makeDir(dir, false);
    }

    /**
     * This method can create any non-existing ancestor directories.
     */
    public static File makeDir(File dir, boolean createAncestorDirectories) throws IOException {
        File parentDir = dir.getParentFile();


        if (createAncestorDirectories) {
            dir.mkdirs();
        } else {
            if (!parentDir.exists()) {
                throw new IOException("The parent directory of director to be created does not exist. Parent directory path is: " + parentDir.getPath());
            }
            if (!parentDir.canWrite()) {
                throw new IOException("The parent directory can not be modified: " + parentDir.getPath());
            }

            dir.mkdir();
        }

        return dir;
    }

    public static String convert_DotName_to_Path(String stringWithDots) {
        return stringWithDots != null ? stringWithDots.replaceAll("\\.", "/") : "";
    }
}

class FileAndFilenameFilter implements FileFilter {

    private FileFilter fileFilter;
    private FilenameFilter filenameFilter;

    public FileAndFilenameFilter(FileFilter fileFilter, FilenameFilter filenameFilter) {
        this.fileFilter = fileFilter;
        this.filenameFilter = filenameFilter;
    }

    public boolean accept(File file) {
        return fileFilter.accept(file) && filenameFilter.accept(file.getParentFile(), file.getName());
    }
};
