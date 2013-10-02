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

package net.unconventionalthinking.matrix.metacompiler.codefilegen;

import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.matrix.metacompiler.codegen.CodeGen_OutputResults;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author peterjoh
 */
public abstract class FileGenerator_Base {


    CodeBuilder codeBuilder_ImportSection;
    CodeBuilder codeBuilder_ClassStart;
    CodeBuilder codeBuilder_ClassEnd;
    CodeBuilder codeBuilder_fullCode;
    SymbolControl symbolControl;
    CodeGen_OutputResults codeGen_OutputResults;

    String packageName;
    String appControl_PackageName;
    String appClassName;
    String className;
    String fileName;
    String fileDirPath;

    boolean add_AppClassesImports;


    Set<String> combined_Imports;

    public FileGenerator_Base(SymbolControl symbolControl) {
        this.symbolControl = symbolControl;

        this.add_AppClassesImports = false;  // default is false;
    }

    public void _1_set_Package(String packageName) { this.packageName = packageName; }
    public void _1_set_AppClassesPackage(String appControl_PackageName) { this.appControl_PackageName = appControl_PackageName; }
    public void _1_set_AppClassesName(String appClassName) { this.appClassName = appClassName; }


    public void _1_set_FileDirPath(String fileDirPath) { this.fileDirPath = fileDirPath; }


    /**
     * Can be called multiple times with new imports. It remembers the older ones and adds them back in.
     */
    void generate_ImportSection(CodeGen_OutputResults outputResults) {
        generate_ImportSection(outputResults, true);
    }
    /**
     * Can be called multiple times with new imports. It remembers the older ones and adds them back in.
     */
    void generate_ImportSection(CodeGen_OutputResults outputResults, boolean addMatrixImports) {
        this.codeGen_OutputResults = outputResults;

        codeBuilder_ImportSection = new CodeBuilder();

        CodeFileGenerator_Utilities.addMetaCompiledCommentToken(codeBuilder_ImportSection);
        
        codeBuilder_ImportSection.append("package " + packageName + ";\n\n");
        if (combined_Imports == null) {
            combined_Imports = new HashSet<String>();
        }


        for (String importString : outputResults.getImportSet()) {
            combined_Imports.add(importString);
        }

        
        // make sure the Matrix imports are added in
        if (addMatrixImports) 
            ImportUtilities.addMatrixImports(combined_Imports);

        //  if this schema, matrix, or embbedded file is outside of the appControl package, add the appControl imports
        if (add_AppClassesImports)
            ImportUtilities.addAppClassImports(true, packageName, appControl_PackageName, combined_Imports);

        for (String importString : combined_Imports) {
            codeBuilder_ImportSection.append(importString + "\n");
        }
    }

    
    public abstract String writeToFile(boolean autoFlushBufferForDebug) throws IOException;

    public CodeBuilder getCodeBuilder() { return codeBuilder_fullCode; }
    public String getClassName() { return className; }
    public String getFileName() { return fileName; }
    public CodeGen_OutputResults getCodeGen_OutputResults() { return codeGen_OutputResults; }


}
