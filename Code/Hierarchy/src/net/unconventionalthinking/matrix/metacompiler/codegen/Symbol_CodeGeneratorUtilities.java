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

import net.unconventionalthinking.compiler.tools.CodeBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author peterjoh
 */
public class Symbol_CodeGeneratorUtilities {

    /**
     *
     * @param outputResults
     * @param appControlObjectName  ** This is either something like: "AppControl.appControl" or often, just "appControl"
     * @param label_Parts
     * @param label_CreationStartLevel
     * @param createStaticVersion
     * @return
     */
    public static String generateNewLabel(CodeGen_OutputResults outputResults, String appControlObjectName, List<String> label_Parts,
            int label_CreationStartLevel, boolean createStaticVersion) {

        if (label_Parts == null || label_Parts.size() == 0) {
            return "null";
        } else {
            CodeBuilder label_Code = new CodeBuilder("Arrays.asList(");
            for (int i = 0; i <  label_Parts.size(); ++i) {
                if (i > 0)
                    label_Code.append(", ");
                label_Code.append("\"" + label_Parts.get(i) +"\"");
            }
            label_Code.append(")");

            label_Code.addToStart(appControlObjectName + ".symbolControl.multiPartSymbol_Factory.createNew_Label(");
            label_Code.append(", " + Integer.toString(label_CreationStartLevel) + ", " + createStaticVersion + ")");


            outputResults.addImport("import java.util.Arrays;");

            return label_Code.toString();
        }
    }
}
