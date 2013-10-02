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

import net.unconventionalthinking.lang.Boolean_Mutable;
import net.unconventionalthinking.lang.String_Mutable;
import net.unconventionalthinking.matrix.Matrix;
import net.unconventionalthinking.matrix.SchemaControl;
import net.unconventionalthinking.matrix.SchemaInfo_Schema;
import net.unconventionalthinking.hierarchy.compileractions.HierarchyActions;
import java.net.MalformedURLException;

/**
 *
 * @author peterjoh
 */
public class ClassPath_SearchUtilities {







    public static SchemaInfo_Schema classPath__FindSchema(String schemaName, String packageName, HierarchyActions hierarchyActions)
            throws MalformedURLException {
        String schemaNameFull = packageName + "::" + schemaName;
        return classPath__FindSchema(schemaNameFull, hierarchyActions);
    }
    public static SchemaInfo_Schema classPath__FindSchema(String schemaName_Full, HierarchyActions hierarchyActions)
            throws MalformedURLException {

        Boolean_Mutable OUT_is_ExternalSchema = new Boolean_Mutable(false);
        String_Mutable OUT_externalAppControl_FullName = new String_Mutable(null);
        SchemaInfo_Schema foundSchema = hierarchyActions.getHierarchyControl().schemaControl
                .classPath__FindSchema(schemaName_Full, hierarchyActions.getClassPath_List(),
                    OUT_is_ExternalSchema, OUT_externalAppControl_FullName);
        if (OUT_is_ExternalSchema.value)
            hierarchyActions.get_ExternalAppControlSet_forFile().add(new AppControl_Info(OUT_externalAppControl_FullName.value));

        return foundSchema;
    }


    public static Matrix classPath__FindMatrix(String matrixName, String packageName, HierarchyActions hierarchyActions)
            throws MalformedURLException {
        String matrixNameFull = packageName + "::" + matrixName;
        return classPath__FindMatrix(matrixNameFull, hierarchyActions);
    }

    public static Matrix classPath__FindMatrix(String matrixName_Full, HierarchyActions hierarchyActions) throws MalformedURLException {

        Boolean_Mutable OUT_is_ExternalMatrix = new Boolean_Mutable(false);
        String_Mutable OUT_externalAppControl_FullName = new String_Mutable(null);
        Matrix foundMatrix = hierarchyActions.getHierarchyControl().matrixControl.classPath__FindMatrix(matrixName_Full,
                hierarchyActions.getClassPath_List(),
                OUT_is_ExternalMatrix, OUT_externalAppControl_FullName);
        if (OUT_is_ExternalMatrix.value)
            hierarchyActions.get_ExternalAppControlSet_forFile().add(new AppControl_Info(OUT_externalAppControl_FullName.value));

        return foundMatrix;
    }
}
