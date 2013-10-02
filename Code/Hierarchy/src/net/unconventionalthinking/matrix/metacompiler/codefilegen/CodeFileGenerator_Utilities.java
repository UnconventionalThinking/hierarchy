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

/**
 *
 * @author Peter Joh
 */
public class CodeFileGenerator_Utilities {


    /**
     * input: a import string of the format: "import com.mypackage . myclass ; "
     * output: "import com.mypackage.myclass;"
     */
    public static CodeBuilder cleanImportString(String importString_Raw) {

        CodeBuilder cleanedImportString = new CodeBuilder();

        cleanedImportString.append("import ");

        for (int i = 7; i < importString_Raw.length(); i++) {
            char ch = importString_Raw.charAt(i);
            if (ch != ' ' && ch != '\n' && ch != '\t')
                cleanedImportString.append(importString_Raw.charAt(i));
        }

        return cleanedImportString;
    }


    public static CodeBuilder createMetaCompiledCommentToken()  {
        return addMetaCompiledCommentToken(null);
    }
    public static CodeBuilder addMetaCompiledCommentToken(CodeBuilder codeBuilder)  {
        if (codeBuilder == null)
            codeBuilder = new CodeBuilder();
        codeBuilder
            .append("/*  " + CodeGeneratorConstants.METACOMPILIED_FILE__COMMENT_TOKEN + "  */\n\n");

        return codeBuilder;
    }


}
