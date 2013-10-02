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
 *
 * @author peterjoh
 */
public class LangSymbol_Import_Package extends LangSymbol_Import {

    public final String packageName;

    public static LangSymbol_Import_Package createSymbol__ImportPackage(String packageName, int scopeID, Object otherInfo,
            LangSymbolTable_File symbolTable) {

        LangSymbol_Import_Package langSym = new LangSymbol_Import_Package(packageName, scopeID, otherInfo);

        symbolTable.addSymbol_Import_Package(langSym);
        return langSym;

    }


    private LangSymbol_Import_Package(String packageName, int scopeID, Object otherInfo) {
        super(packageName, SymbolType.Import_Package, scopeID, otherInfo);

        int packageNameLength = packageName.length();
        // remove the ".*"
        if (packageNameLength >= 3) {
            if (packageName.charAt(packageNameLength - 2) == '.' && packageName.charAt(packageNameLength - 1) == '*')
                this.packageName = packageName.substring(0, packageNameLength - 2);
            else
                this.packageName = packageName;
        } else
            this.packageName = packageName;
    }
}

