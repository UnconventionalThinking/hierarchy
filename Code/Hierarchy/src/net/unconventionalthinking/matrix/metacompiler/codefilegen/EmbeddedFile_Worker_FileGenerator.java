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
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.utilities.FileUtilities;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import java.io.IOException;
import java.util.List;


/**
 *
 * @author peterjoh
 */
public class EmbeddedFile_Worker_FileGenerator extends FileGenerator_Base {

    private CodeBuilder codeBuilder_Methods;


    /**
     * Pass in the metacompiler generator matrix build code.
     * @param matrixConstructionCode
     */
    public EmbeddedFile_Worker_FileGenerator(SymbolControl symbolControl) {
        super(symbolControl);
        
        this.add_AppClassesImports = true;

        codeBuilder_Methods = new CodeBuilder();
    }


    public void _1_set_ClassName(String embeddedFile_ClassName) {
        this.className = generateClassName(embeddedFile_ClassName);
    }

    public void _1_addCode_Method(CodeBuilder codeBuilder_Method) {
        this.codeBuilder_Methods.append("\n\n").append(codeBuilder_Method);
    }

   public void _1_addCode_MethodsList(List<CodeBuilder> codeBuilderMethods_List) {

       for (CodeBuilder codeBuilder_Method : codeBuilderMethods_List)
           _1_addCode_Method(codeBuilder_Method);

       this.codeBuilder_Methods.append("\n\n");
    }



    public void _2_generateClass(CodeGen_OutputResults outputResults)
            throws Exception_MetaCompilerError {


        generate_ImportSection(outputResults);
        
        codeBuilder_ClassStart = new CodeBuilder();
        codeBuilder_ClassEnd = new CodeBuilder();


        codeBuilder_ClassStart.append("\n\n\n" +
            "public class " + className + " {\n");


        codeBuilder_ClassEnd
                .append("}\n");

    }



    public String writeToFile(boolean autoFlushBufferForDebug) throws IOException {
        codeBuilder_fullCode = new CodeBuilder();

        codeBuilder_fullCode.append(codeBuilder_ImportSection);
        codeBuilder_fullCode.append(codeBuilder_ClassStart);
        codeBuilder_fullCode.append(codeBuilder_Methods).append("\n\n");
        codeBuilder_fullCode.append(codeBuilder_ClassEnd);

        FileUtilities.writeToFile(fileDirPath, className + ".java", true,
                codeBuilder_fullCode.toString(), autoFlushBufferForDebug);

        return className + ".java";
    }


    public static String generateClassName(String embeddedFile_ClassName) {
        return embeddedFile_ClassName + HierarchySettings.embeddedFile_WorkerClassName_Suffix ;
    }

}
