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

package net.unconventionalthinking.hierarchy.langsymboltable;

import java.util.Collection;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import org.apache.commons.collections.map.MultiValueMap;



/**
 * The matrix access symbols don't work the same as the regular Java symbols - specifically, they don't really have a 'name', and don't run into
 * duplicate name conflicts. for instance, two Java vars in the same scope can not have the same variable name, but it's perfectly fine if
 * two matrix accesses are identical.
 *
 * In fact, they're not really symbols at all, and the only reason we're including them in the symboltable is because
 * we want to know what scope they were used in.
 *
 * @author Peter Joh
 */
public class LangSymbolTable_File__forMatrixAccess {

    LangSymbolTable_File langSymbolTable_File;
    HierarchySettings hierarchySettings;

    /**
     * Multi-value map of matrixaccesses, whose key is 'method' scope-id. Meaning, the scope id of the closes method scope. This is useful
     * because at the end of a method, we want to know if there were any matrix accesses used anywhere in the method.
     */
    MultiValueMap matrixAccessMap_byMethodScopeID;


    public LangSymbolTable_File__forMatrixAccess(LangSymbolTable_File langSymbolTable_File, HierarchySettings hierarchySettings) {
        this.langSymbolTable_File = langSymbolTable_File;
        this.hierarchySettings = hierarchySettings;
        
        matrixAccessMap_byMethodScopeID = new MultiValueMap();
    }

    

    public void addMatrixAccess(String matrixAccess_String, int matrixAccessNumber) {
        int currMethodScopeID = langSymbolTable_File.scopeStack.getCurrScopeID_for_ClassOrMethod_ScopeBoundary();
        
        matrixAccessMap_byMethodScopeID.put(currMethodScopeID, 
                LangSymbolMatrix_MatrixAccess.createSymbol__MatrixAccess(matrixAccess_String, null, matrixAccessNumber, null,
                    langSymbolTable_File));

        if (hierarchySettings.debug_ScopeStack)
            System.out.println("~DSS MatrixSym~ Adding matrix access at method scope id (" + currMethodScopeID + "), #" + matrixAccessNumber + ", "  + matrixAccess_String);
    }

    public Collection get_MatrixAccesses_atMethodScope(int methodScopeId) {
        return matrixAccessMap_byMethodScopeID.getCollection(methodScopeId);
    }
    public boolean contains_MatrixAccesses_atMethodScope(int methodScopeId) {
        Collection matrixAcceses_forMethodScope = matrixAccessMap_byMethodScopeID.getCollection(methodScopeId);
        return matrixAcceses_forMethodScope != null && !matrixAcceses_forMethodScope.isEmpty();
    }


}
