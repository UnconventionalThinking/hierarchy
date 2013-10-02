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

/**
 * Note that this is NOT the info for the .class file, but for the java file for the class.
 * @author peterjoh
 */
public class Class_FileInfo {

    public final String dirPath;
    public final String srcCode_FileName;
    public final String className;
    public final String packageDirPath_Relative;
    public final String packageName;


    public String get_FileName_w_Path() { return dirPath + File.separator + srcCode_FileName; }
    public String get_FullClassName() { return (packageName != null && packageName.length() > 0 ? packageName + '.' + className : className ); }


    public Class_FileInfo(String dirPath, String packageDirPath_Relative, String srcCode_FileName, String packageName, String className) {
        this.dirPath = dirPath;
        this.srcCode_FileName = srcCode_FileName;
        this.className = className;

        this.packageName = packageName;
        this.packageDirPath_Relative = packageDirPath_Relative;
    }


}
