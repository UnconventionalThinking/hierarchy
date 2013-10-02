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



/**
 * Anytime there's a matrix access, it's basic info is thrown into the symbol table.
 * We use this info during metacompilation of .mjava files: For a method declaration with no annotation handler, we need to determine
 * if this method has had a matrix access. If it has, the metacompiler will throw out an error letting the dev know he needs to add one.
 *
 * @author peterjoh
 */
public class LangSymbolMatrix_MatrixAccess extends LangSymbol {

    public enum AccessType { Static, Dynamic }

    final String accessString;
    final int accessNumber;
    final AccessType accessType;

    /**
     * This version takes no scope id. It uses the current, top most scope. This is probably the version of the method that will be most used.
     */
    public static LangSymbolMatrix_MatrixAccess createSymbol__MatrixAccess(String accessString, AccessType accessType, int accessNumber,
            Object otherInfo, LangSymbolTable_File symbolTable, SymbolModifier... modifiers) {

        return createSymbol__MatrixAccess(accessString, accessType, accessNumber, symbolTable.scopeStack.viewCurrentScope().scope_Id,
                                      otherInfo, symbolTable, modifiers);
    }

    public static LangSymbolMatrix_MatrixAccess createSymbol__MatrixAccess(String accessString, AccessType accessType, int accessNumber,
            int scopeID, Object otherInfo, LangSymbolTable_File symbolTable, SymbolModifier... modifiers) {
        
        LangSymbolMatrix_MatrixAccess langSymbol_MatrixAccess = new LangSymbolMatrix_MatrixAccess(accessString, accessType, accessNumber, scopeID,
                                                                                                    otherInfo, modifiers);

        return langSymbol_MatrixAccess;
    }





    
    LangSymbolMatrix_MatrixAccess(String accessString, AccessType accessType, int accessNumber, int scopeID, Object otherInfo,
            SymbolModifier... modifiers) {

        super(null, SymbolType.Matrix_MatrixAccess, scopeID, otherInfo, modifiers);

        this.accessString = accessString;
        this.accessType = accessType;
        this.accessNumber = accessNumber;
    }

    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LangSymbolMatrix_MatrixAccess other = (LangSymbolMatrix_MatrixAccess) obj;
        if (this.accessNumber != other.accessNumber) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.accessNumber;
        return hash;
    }




    





    
}
