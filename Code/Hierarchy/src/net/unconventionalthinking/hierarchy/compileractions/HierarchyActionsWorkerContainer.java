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

package net.unconventionalthinking.hierarchy.compileractions;

import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.hierarchy.HierarchyControl;

/**
 *
 * @author peterjoh
 */
public class HierarchyActionsWorkerContainer {

    public final HierarchyActionsWorker_MatrixElementName matrixElementName;
    public final HierarchyActionsWorker_Symbols symbols;
    public final HierarchyActionsWorker_DescriptorCreation descCreation;
    public final HierarchyActionsWorker_DescriptorAccess descAccess;



    public HierarchyActionsWorkerContainer(HierarchyActions hierarchyActions, HierarchyControl hierarchyControl, int baseIndentLevel) {

        matrixElementName = new HierarchyActionsWorker_MatrixElementName(hierarchyActions, hierarchyControl, baseIndentLevel);
        symbols = new HierarchyActionsWorker_Symbols(hierarchyActions, hierarchyControl, baseIndentLevel);
        descCreation = new HierarchyActionsWorker_DescriptorCreation(hierarchyActions, hierarchyControl, baseIndentLevel);
        descAccess = new HierarchyActionsWorker_DescriptorAccess(hierarchyActions, hierarchyControl, baseIndentLevel);
    }

}
