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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import net.unconventionalthinking.compiler.tools.CodeBuilder;

/**
 *
 * @author Peter Joh
 */
public class ImportUtilities {

    public static List<String> MatrixImports_List = Arrays.asList("import net.unconventionalthinking.matrix.*;",
        "import net.unconventionalthinking.lang.*;",
        "import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;",
        "import net.unconventionalthinking.matrix.symbols.*;"
    );


    /** Call this version if you only want to add the imports to the set, and not to the codebuilder too. **/
    public static void addMatrixImports(Set<String> imports_Set) {
        addMatrixImports(imports_Set, null);
    }
    /** Call this version if you want to add the imports to the set and to the codebuilder too. **/
    public static void addMatrixImports(Set<String> imports_Set, CodeBuilder codeBuilder) {

        for (String matrixImport : MatrixImports_List)
            imports_Set.add(matrixImport);

        if (codeBuilder != null) {
            codeBuilder.append("\n");

            for (String matrixImport : MatrixImports_List)
                codeBuilder.append(matrixImport).append("\n");
        }
    }


    
    /** Call this version if you only want to add the imports to the set, and not to the codebuilder too. **/
    public static void addAppClassImports(boolean dontAdd_if_AppClassesSamePackageAsDestPackage, String curr_PackageName,
            String appControl_PackageName, Set<String> imports_Set) {
        addAppClassImports(null, dontAdd_if_AppClassesSamePackageAsDestPackage, curr_PackageName, appControl_PackageName, imports_Set);
    }

    /** Call this version if you want to add the imports to the set and to the codebuilder too. **/
    public static void addAppClassImports(CodeBuilder codeBuilder, boolean dontAdd_if_AppClassesSamePackageAsDestPackage, String curr_PackageName,
            String appControl_PackageName, Set<String> imports_Set) {

        if (!dontAdd_if_AppClassesSamePackageAsDestPackage  || !curr_PackageName.equals(appControl_PackageName)) {

            List<String> appControlImports_List = new ArrayList<String>();

            appControlImports_List.add("import " + appControl_PackageName + ".AppControl;");
            appControlImports_List.add("import " + appControl_PackageName + ".AppSymbols;");
            appControlImports_List.add("import " + appControl_PackageName + ".AppSymbols_DescTagName;");
            appControlImports_List.add("import " + appControl_PackageName + ".AppSymbols_Label;");
            appControlImports_List.add("import " + appControl_PackageName + ".AppSymbols_DescTag;");
            appControlImports_List.add("import " + appControl_PackageName + ".AppSymbols_MatrixName;");
            appControlImports_List.add("import " + appControl_PackageName + ".AppSymbols_SchemaName;");

            //  NOTE: For the usage of specialized fieldsets in matrices, they will use the full class name when using one. So, no
            //  import needed for these.


            for (String appControlImport : appControlImports_List)
                imports_Set.add(appControlImport);

            if (codeBuilder != null) {
                codeBuilder.append("\n");

                for (String appControlImport : appControlImports_List)
                    codeBuilder.append(appControlImport).append("\n");
            }

        }
    }

}
