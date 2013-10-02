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




import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.MatrixControl;
import net.unconventionalthinking.matrix.SchemaControl;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.hierarchy.HierarchyControl;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbolTable_App;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbolTable_File;


/**
 *
 * @author peterjoh
 */
public abstract class HierarchyActionsWorker {



    HierarchyControl    hierarchyControl;
    int                 baseIndentLevel;
    HierarchyActions    hierarchyActions;

    SymbolControl symbolControl;
    SchemaControl schemaControl;
    MatrixControl matrixControl;
    ExecutionInfo executeInfo;

    HierarchySettings hierarchySettings;

    LangSymbolTable_App     symbolTable_App;
    LangSymbolTable_File    symbolTable_File;


    
    public HierarchyActionsWorker(HierarchyActions hierarchyActions, HierarchyControl hierarchyControl, int baseIndentLevel) {

        this.hierarchyActions = hierarchyActions;
        this.hierarchyControl = hierarchyControl;
        this.baseIndentLevel = baseIndentLevel;

        symbolControl = hierarchyControl.symbolControl;
        schemaControl = hierarchyControl.schemaControl;
        matrixControl = hierarchyControl.matrixControl;
        executeInfo = hierarchyControl.executionInfo;

        hierarchySettings = hierarchyControl.hierarchySettings;

        symbolTable_App = hierarchyActions.symbolTable_App;
        symbolTable_File = hierarchyActions.symbolTable_File;
    }





}
