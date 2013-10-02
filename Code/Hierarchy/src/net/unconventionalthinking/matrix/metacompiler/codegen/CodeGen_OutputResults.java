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

import net.unconventionalthinking.matrix.ExceptRuntime_Matrix_UnexpectedError;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import java.util.*;
import net.unconventionalthinking.matrix.metacompiler.codefilegen.FileGenerator_Base;

/**
 *
 * @author peterjoh
 */
public class CodeGen_OutputResults {

    private Set<String> importSet;
    private String destPackage = "";

    public CodeGen_OutputResults() { 
        importSet = new HashSet<String>();
    }
    public CodeGen_OutputResults(Set<String> existing_ImportSet) {
        if (existing_ImportSet != null)
            importSet = existing_ImportSet;
        else
            importSet = new HashSet<String>();
    }


    public void setImportSet(Set<String> importSet) {
        this.importSet = importSet;
    }
    public Set<String> getImportSet() {
        return importSet;
    }
    public void addImport(String newImport) {
        importSet.add(newImport);
    }



    public String getDestPackage() { return destPackage; }
    public void setDestPackage(String destPackage) { this.destPackage = destPackage;}

    
    //  The purpose of this is so the code generators can pass back a bunch of output variables out of a code generation method
    //  (like multple return values).
    public Map<String, String> returnParameters = new HashMap<String, String>();
}
