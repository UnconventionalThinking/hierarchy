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



package net.unconventionalthinking.hierarchy;

import net.unconventionalthinking.matrix.SchemaInfo_FieldSet;
import net.unconventionalthinking.matrix.SchemaInfo_Schema;
import java.util.*;
import java.util.regex.*;

import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.lang.Boolean_Mutable;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.SchemaInfo;
import net.unconventionalthinking.matrix.SchemaInfo_Descriptor;
import net.unconventionalthinking.reflection.MethodInvoker;
import net.unconventionalthinking.utilities.CmdLine_Utilities;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 *
 * @author peterjoh
 */
public class HierarchyMetaCompilerUtilities {





    public static CodeBuilder add_MatrixImports_To_JavaFile(CodeBuilder srcCode, Set<String> importSet) {

        StringBuilder importStatements = new StringBuilder();
        for(String string : importSet)
            importStatements.append(string + "\n");

        String packageRegex = "\\s*(package\\s+\\w+(\\.\\w+)*\\s*\\;)";
        String anyCharactersRegex = "(.*)";
        String packageMatchRegex = packageRegex + anyCharactersRegex;


        // the DOTALL flag means that when you have the '.' in a regex, it will match all characters, including the \n
        Pattern packageMatchPattern = Pattern.compile(packageMatchRegex, Pattern.DOTALL);
        Matcher packageMatcher = packageMatchPattern.matcher(srcCode);


        if (packageMatcher.matches()) {
            int endOfPackageStmt_Index = packageMatcher.end(1); // get the index of the end of the package statement

            importStatements.insert(0, "\n\n");
            srcCode.insert(endOfPackageStmt_Index, importStatements);

        } else {
            srcCode.insert(0, importStatements);
        }

        return srcCode;
    }













    public static Object invokeMethod(Object targetObject, Class targetClass, String methodName, Boolean_Mutable methodThrewException)
            throws Exception {
        return invokeMethod(targetObject, targetClass, methodName, methodThrewException, new Class[] {}, new Object[] {});
    }

    public static Object invokeMethod(Object targetObject, Class targetClass, String methodName, Boolean_Mutable methodThrewException,
            Class[] parameterTypes, Object[] parameterValues) throws Exception {

        MethodInvoker methodInvoker = new MethodInvoker();

        methodInvoker.setParameterTypes(parameterTypes);
        methodInvoker.setParameterValuesArray(parameterValues);

        return methodInvoker.invokeMethod(targetObject, targetClass, methodName, methodThrewException);

    }




    public static void collect_SchemaInfoFieldSets(SchemaInfo_Descriptor schemaInfo_Descriptor, List<SchemaInfo_FieldSet> schemaInfoFieldSets_List) {
        ExecutionInfo executeInfo = new ExecutionInfo();

        //  Collect the schemaInfo fieldSets if this it not the initial schemaInfoSchema object
        if (schemaInfo_Descriptor.getSchemaInfo_SchemaInfoType() != SchemaInfo.Type.SchemaInfoSchema) {

            if (schemaInfo_Descriptor.getSchemaInfo_canHave_FieldSet())
                schemaInfoFieldSets_List.add(schemaInfo_Descriptor.get_SchemaInfoFieldSet(executeInfo));
        }


        List<SchemaInfo_Descriptor> child_SchemaInfoDesc_List = schemaInfo_Descriptor.getChild_SchemaInfoDescriptors(executeInfo);
        if (child_SchemaInfoDesc_List != null) {
            for (SchemaInfo_Descriptor child_SchemaInfoDesc : child_SchemaInfoDesc_List) {
                collect_SchemaInfoFieldSets(child_SchemaInfoDesc, schemaInfoFieldSets_List);
            }
        }

    }


    public static String getPackageDirPath_ForCurrPackageDir(File currDir, String srcMetaCode_BaseDir) throws IOException {

        File srcCode_BaseDir_FileObj = new File(srcMetaCode_BaseDir);

        if (currDir.equals(srcCode_BaseDir_FileObj))
            return "";

        int packagePath_startIndex = srcCode_BaseDir_FileObj.getCanonicalPath().length();
        String packagePath = currDir.getCanonicalPath().substring(packagePath_startIndex + 1);

        return packagePath;
    }

    public static String getPackageName_ForCurrPackageDir(File currDir, String srcMetaCode_BaseDir) throws IOException {

        File srcCode_BaseDir_FileObj = new File(srcMetaCode_BaseDir);

        if (currDir.equals(srcCode_BaseDir_FileObj))
            return "";
        
        int packagePath_startIndex = srcCode_BaseDir_FileObj.getCanonicalPath().length();
        String packagePath = currDir.getCanonicalPath().substring(packagePath_startIndex + 1);
        String packageName = packagePath.replace('/', '.');
        packageName = packageName.replace('\\', '.');

        return packageName;
    }


}
