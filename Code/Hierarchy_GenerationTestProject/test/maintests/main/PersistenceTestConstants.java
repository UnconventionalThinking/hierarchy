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

package maintests.main;

import net.unconventionalthinking.utilities.FileUtilities;

/**
 *
 * @author peterjoh
 */
public class PersistenceTestConstants {


    public final static String TestData_DirPath = MainTests_Constants.HierarchyProject_Path +"/testdata/serialization";

    public final static String JavaObjects_OutputFileName = "javaObjects.data";
    public final static String JavaObjects_OutputFile_Path = TestData_DirPath + "/" + JavaObjects_OutputFileName;

    
    public final static String UpdateLog_FileName = "matrixUpdates.log";
    public final static String UpdateLog_FilePath = TestData_DirPath + "/" + UpdateLog_FileName;

    
    public final static String PersistentMatrixName_Simple = "Test.Matrix";


}
