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


import net.unconventionalthinking.matrix.metacompiler.codegen.*;
import net.unconventionalthinking.utilities.*;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import java.util.List;

/**
 *
 *
 * @author peterjoh
 */
public class SymbolFile_Generator_MultiLevel {

    public static CodeBuilder generate_SymbolFile(CodeBuilder codeBuilder, HierarchySettings hierarchySettings, SymbolType symbolType,
            Symbol_Index_MultiLevel symbol_Index, String symbolFile_Package, String symbolClassName) {

        if (codeBuilder == null)
            codeBuilder = new CodeBuilder();

        CodeFileGenerator_Utilities.addMetaCompiledCommentToken(codeBuilder);

        // Create header of file:
        if (symbolFile_Package != null && symbolFile_Package.trim().length() > 0)
            codeBuilder.append("package " + symbolFile_Package + ";\n\n");

        codeBuilder
            .append("import java.util.*;\n")
            .append("import net.unconventionalthinking.lang.*;\n")
            .append(CodeConstants.MatrixImports_Symbols + "\n")
            .append(CodeConstants.MatrixImports_AbstractExceptions +" \n\n")

            .append("public class " + symbolClassName + " { \n\n");



        CodeBuilder variablesCode = new CodeBuilder();
        CodeBuilder staticInitCode = new CodeBuilder();

        staticInitCode
            .append("\tpublic static boolean have_Intialized = false;\n\n\n")

            
            .append("\tstatic void initialize(SymbolControl symbol_Control) throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed {\n")
            .append("\t\tinitialize(symbol_Control, false);\n")
            .append("\t}\n\n")

            .append("\t/**\n")
            .append("\t * NOTE: have_ParentAppControl is currently not used by multi-level symbols. It made be in the future. The purpose of this field is:<p>\n")
            .append("\t *\n")
            .append("\t * If you set have_ParentAppControl to true, then the symbolControl you pass in should be from a parent AppControl (which means this class\n")
            .append("\t * and all of the other app control classes for this application context are probably in a jar, being used by a parent application. <p>\n")
            .append("\t *\n")
            .append("\t * What this means is that all the ID fields for this class are INCORRECT!! The Id's for symbols will not be hard coded, but set dynamically.<br>\n")
            .append("\t * What this also means is that for right now, jar files can not have embedded matrix classes methods with matrix accesses that are called from\n")
            .append("\t * a parent application (because matrix access uses these id's).\n")
            .append("\t */\n")

            .append("\tstatic void initialize(SymbolControl symbol_Control, boolean have_ParentAppControl) throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed {\n\n")

            .append("\t\tSymbolControl symbolControl = symbol_Control;\n")
            .append("\t\tSymbol_MultiLevel_Factory multiLevelSymbol_Factory = symbolControl.multiLevelSymbol_Factory;\n\n")

            .append("\t\tboolean creation_Has_StaticVersion = true;\n\n");


        
        generate_MultiLevelSymbolVariables(hierarchySettings, symbolType, variablesCode, staticInitCode, symbol_Index);

        codeBuilder.append(variablesCode);

        codeBuilder.append("\n\n\t//  Initializer for Symbols:\n");

        codeBuilder.append(staticInitCode);

/*
        codeBuilder
            .append("\n\t//  AppControl needs to be initialized before the static objects in the class can be used\n")
            .append("\tstatic {\n")
            .append("\t\tAppControl.initializeApp();\n")
            .append("\t}\n\n");
  */

        codeBuilder.append("\n}\n");
        return codeBuilder;
    }






    public static void generate_MultiLevelSymbolVariables(HierarchySettings hierarchySettings, 
            SymbolType symbolType, CodeBuilder variablesCode, CodeBuilder staticInitCode, Symbol_Index_MultiLevel symbol_Index) {



        if (symbol_Index.get_MultiLevelSymbol_List().size() > 0) {

            variablesCode.append("\n\n\t//  " + symbolType.toString() + ":\n");
            staticInitCode.append("\n\t\t// " + symbolType.toString() + " _________________________________________________________________________\n\n");


            List<Symbol_MultiLevel> multiLevelSymbols = symbol_Index.get_MultiLevelSymbol_List();

            for (int i = 0; i < multiLevelSymbols.size(); ++i) {

                Symbol_MultiLevel multiLevelSymbol = multiLevelSymbols.get(i);

                String symbolVariableName = symbolVariableName = multiLevelSymbol.name_IdentFormat;
                String symbolID_VarName = symbolVariableName + SymbolConstants.SymbolFile_SymbolName__SymbolID_Suffix;




                String symbol1 = "";
                String symbol2 = "";
                if (symbolType == SymbolType.DescriptorTag) {
                    DescriptorTag descTag = (DescriptorTag)multiLevelSymbol;

                    symbol1 = hierarchySettings.appSymbolClassName_SchemaName + "." + descTag.getSchemaName_Full().get_Name_IdentFormat();
                    symbol2 = hierarchySettings.appSymbolClassName_DescTagName + "." + descTag.getDescTagName().get_Name_IdentFormat();

                } else if (symbolType == SymbolType.SchemaName || symbolType == SymbolType.MatrixName) {
                    MatrixName schemaName = (MatrixName)multiLevelSymbol;

                    symbol1 = hierarchySettings.appSymbolClassName_DescTagName + "." + schemaName.getPackageName().get_Name_IdentFormat();
                    symbol2 = hierarchySettings.appSymbolClassName_DescTagName + "." + schemaName.getMatrixName().get_Name_IdentFormat();

                }


                variablesCode.append("\tpublic static " + 
                        (symbolType == SymbolType.SchemaName ? SymbolType.MatrixName : symbolType.toString()) +
                        " " + symbolVariableName + ";\n");
                //  symbol ids for multi-level symbols unused for now
                //variablesCode.append("\tpublic static final int " + symbolID_VarName + " = " + multiLevelSymbol.ID+ ";\n");

                staticInitCode.append("\t\t//  " + StringUtilities.convertToEscapedString(multiLevelSymbol.name) + "\n");

                staticInitCode.append("\n\t\t"+ symbolVariableName + " = multiLevelSymbol_Factory.createNew");
                if (symbolType == SymbolType.DescriptorTag)
                    staticInitCode.append("_DescriptorTag");
                else if (symbolType == SymbolType.SchemaName)
                    staticInitCode.append("_SchemaName");
                else if (symbolType == SymbolType.MatrixName)
                    staticInitCode.append("_MatrixName");
                staticInitCode.append("(" + symbol1 + ", " + symbol2 +
                        ",creation_Has_StaticVersion);\n\n");

            }


        } else {
            staticInitCode.append("\t//  empty!\n\n");
        }

        staticInitCode
            .append("\t\thave_Intialized = true;\n")
        .append("\t}\n\n");

    }



}
