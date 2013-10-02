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
import java.util.HashMap;
import java.util.Map;
import net.unconventionalthinking.utilities.FileUtilities_Search;

/**
 *
 * @author Peter Joh
 */
public class HierarchyMetaCompilerWorker_MatrixSettingsCollector {

    public HierarchySettings                        hierarchySettings;

    public HierarchyMetaCompilerWorker_MatrixSettingsCollector(HierarchySettings hierarchySettings) {
        this.hierarchySettings = hierarchySettings;
    }


    /**
     * THIS IMPLEMENTATION OF THIS METHOD IS A TEMPORARY SOLUTION!
     * In the future, we'll collect the settings from the MATRIX descriptor's field set.
     *
     * For now, search the matrix file for:
     * MATRIXPROG.PERSISTENCE.SETTINGS: {  +:IsPersistent  }
     */
    public HierarchySettings_forMatrix getMatrixSettings(String matrixFilePath) throws IOException {

        HierarchySettings_forMatrix matrixSettings = new HierarchySettings_forMatrix();

        // search through file for MATRIXPROG.PERSISTENCE.SETTINGS: followed by : { :IsPersistent }
        String persistenceSettings_RegEx = "MATRIXPROG.PERSISTENCE.SETTINGS:\\s*\\{\\s*\\+?:IsPersistent";
        File matrixFile = new File(matrixFilePath);
        if (!matrixFile.exists())
            throw new IOException("Couldn't open matrix file with path: " + matrixFile.getAbsolutePath());

        matrixSettings.IsPersitentMatrix = FileUtilities_Search.searchFileForString(matrixFile, persistenceSettings_RegEx, true, -1);


        return matrixSettings;
    }
}
