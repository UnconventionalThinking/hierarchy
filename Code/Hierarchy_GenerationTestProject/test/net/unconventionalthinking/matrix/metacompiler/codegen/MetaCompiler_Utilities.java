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

package net.unconventionalthinking.matrix.metacompiler.codegen;

import net.unconventionalthinking.matrix.symbols.MatrixName;
import net.unconventionalthinking.hierarchy.Class_FileInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author peterjoh
 */
public class MetaCompiler_Utilities {


    public static List<Class_FileInfo> create_ClassFileInfo_List(Iterator<MatrixName> matrixName_Iter) {

        String currDir_Path = "UNUSED";
        String packageDirPath_Relative = "UNUSED";
        List<Class_FileInfo> matrix_ClassFileInfo_List = new ArrayList<Class_FileInfo>();
        while (matrixName_Iter.hasNext()) {
            MatrixName matrixName = matrixName_Iter.next();

            Class_FileInfo matrixFile_Info = new Class_FileInfo(currDir_Path, packageDirPath_Relative, matrixName.getClassName() + ".java",
                    matrixName.getPackageName().get_Name_no_backtiks(),
                    matrixName.getClassName());
            matrix_ClassFileInfo_List.add(matrixFile_Info);

        }

        return matrix_ClassFileInfo_List;
    }


}
