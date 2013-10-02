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

import net.unconventionalthinking.utilities.FileUtilities;

/**
 *
 * @author peterjoh
 */
public class _10_AnnotationDetection_Constants {

    public final static String CURR_PROJECT_DIR = "C:/Projects/Hierarchy/Code/Hierarchy/testarea/annotationDetectionTests";

    public final static String testProj_appControl_PackageName = "annotationdetectiontests";

    public final static String testProj_srcBase_DirPath = CURR_PROJECT_DIR + "/src";
    public final static String testProj_appControl_DirPath = testProj_srcBase_DirPath + "/" +
                                            FileUtilities.convert_DotName_to_Path(testProj_appControl_PackageName);

    
    public final static String testProj_Build_DirPath = CURR_PROJECT_DIR + "/matrix_build";
    public final static String testProj_BuildMeta_DirPath = testProj_Build_DirPath + "/build1_meta";
    public final static String testProj_BuildFinal_DirPath = testProj_Build_DirPath + "/build2_final";


}
