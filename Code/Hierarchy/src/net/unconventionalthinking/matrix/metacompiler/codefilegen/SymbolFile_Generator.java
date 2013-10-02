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




//  TODO Symbolfile_Generator - accessing multipart symbols, generate inner classes!!
import net.unconventionalthinking.matrix.utilities.TypeUtilities;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import java.util.List;
/*
 * NOTE: Accessing MultiPartSymbols: for now, we will use identifier format as the variable name when accessing
 * multi-part multiPartSymbol names throug hte multiPartSymbol file. But, the problem is that identifier format is hard to read
 * in the output code (we want the output code to be readable). So, if the future, we want something like:
 *          :"sym 1".sym2  -> AppSymbols.sym$23$1.sym2
 *
 * To implement this, will generate classes with inner classes (see multiPartSymbol design docs!)
 */

/**
 *
 *
 * The way we will
 *
 * @author peterjoh
 */
public class SymbolFile_Generator {

    public static CodeBuilder generate_SymbolFile(CodeBuilder codeBuilder, SymbolType symbolType, Symbol_Index symbol_Index,
            String symbolFile_Package, String symbolClassName) {

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
        variablesCode.append("\t//  Single Symbols:\n");
        generate_SingleSymbolVariables(symbolType, variablesCode, staticInitCode, symbol_Index);

        variablesCode.append("\n\n\t//  MultiPart Symbols:\n");
        staticInitCode.append("\n\t\t//  MultiPart Symbols _________________________________________________________________________\n\n");
        generate_MultiPartSymbolVariables(symbolType, variablesCode, staticInitCode, symbol_Index);


        codeBuilder.append(variablesCode);

        codeBuilder.append("\n\n\t//  Initializer for Symbols:\n");

        codeBuilder.append(staticInitCode);

        //  This is not needed
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





    public static void generate_SingleSymbolVariables(SymbolType symbolType, CodeBuilder variablesCode, CodeBuilder staticInitCode, Symbol_Index symbol_Index) {

        if (symbol_Index.getSingleSymbol_List().size() > 0) {

            //  generate all single symbols:
            staticInitCode
                .append("\tpublic static boolean have_Intialized = false;\n\n\n\n")


				.append("\tstatic void initialize(SymbolControl symbol_Control) throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed,\n")
				.append("\t\tException_SymbolCreation, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolCreationOrAccess {\n")
				.append("\t\tinitialize(symbol_Control, false);\n")
				.append("\t}\n\n")

				.append("\t/**\n")
				.append("\t * If you set have_ParentAppControl to true, then the symbolControl you pass in should be from a parent AppControl (which means this class\n")
				.append("\t * and all of the other app control classes for this application context are probably in a jar, being used by a parent application. <p>\n")
				.append("\t *\n")
				.append("\t * What this means is that all the ID fields for this class are INCORRECT!! The Id's for symbols will not be hard coded, but set dynamically.<br>\n")
				.append("\t * What this also means is that for right now, jar files can not have embedded matrix classes methods with matrix accesses that are called from\n")
				.append("\t * a parent application (because matrix access uses these id's).\n")
				.append("\t */\n")

                .append("\tstatic void initialize(SymbolControl symbol_Control, boolean have_ParentAppControl) throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed,\n" +
                    "\t\t\tException_SymbolCreation, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolCreationOrAccess {\n\n")

                .append("\t\tSymbolControl symbolControl = symbol_Control;\n")
                .append("\t\tSymbol_Single_Factory singleSymbol_Factory = symbolControl.singleSymbol_Factory;\n")
                .append("\t\tSymbol_MultiPart_Factory multiPartSymbol_Factory = symbolControl.multiPartSymbol_Factory;\n\n")

                .append("\t\t//  Multipart-Symbol related variables:\n")
                .append("\t\tList<Symbol_Single> newlyCreatedSymbols = new ArrayList<Symbol_Single>();\n")
                .append("\t\tBoolean_Mutable have_Created_New_MultiPartSymbol = new Boolean_Mutable(false);\n")
                .append("\t\tint creation_StartLevel = 0;\n")
                .append("\t\tboolean creation_Has_StaticVersion = true;\n\n")

                .append("\t\tList<String> symbolStrings = null;\n\n");


            staticInitCode
                .append("\n\t\t//  Single Symbols _________________________________________________________________________\n\n");
            List<Symbol_Single> singleSymbols = symbol_Index.getSingleSymbol_List();

            for (int i = 0; i < singleSymbols.size(); ++i) {
                Symbol_Single symbol = singleSymbols.get(i);


                String symbol_VarName = symbol.name_IdentFormat;
                if (symbolType == SymbolType.Symbol) {
                    if (TypeUtilities.is_PrimitiveType(symbol)) {
                        symbol_VarName = symbol.name_IdentFormat + SymbolConstants.SymbolFile_SymbolName__ReservedWord_Suffix;
                    }
                }
                String symbolID_VarName = symbol_VarName + SymbolConstants.SymbolFile_SymbolName__SymbolID_Suffix;


                variablesCode.append("\tpublic static " + symbolType.toString() +" " + symbol_VarName + ";\n");
                variablesCode.append("\tpublic static final int " + symbolID_VarName + " = " + symbol.ID + ";\n");

                String symbolClass_Suffix = "";
                if (symbolType == SymbolType.DescriptorTagName)
                    symbolClass_Suffix = HierarchySettings.symbolClassSuffix_DescTagName;
                else if (symbolType == SymbolType.Label)
                    symbolClass_Suffix = HierarchySettings.symbolClassSuffix_Label;

                staticInitCode.append("\t\t" + symbol_VarName  +
                        " = (have_ParentAppControl) ? singleSymbol_Factory.createNew").append(symbolClass_Suffix);
                staticInitCode.append("(\"" + StringUtilities.convertToEscapedString(symbol.name) + "\", true) :\n");
                staticInitCode.append("\t\t\t\tsingleSymbol_Factory.createNew").append(symbolClass_Suffix);
                staticInitCode.append("(\"" + StringUtilities.convertToEscapedString(symbol.name) + "\", " + symbol.ID +", true, null);\n");

            }
            staticInitCode.append("\n\n");


        } else {
            staticInitCode.append("\t//  empty!\n\n");
        }
    }




    public static void generate_MultiPartSymbolVariables(SymbolType symbolType, CodeBuilder variablesCode, CodeBuilder staticInitCode,
            Symbol_Index symbol_Index) {

        if (symbol_Index.multiPart.get_MultiPartSymbol_List().size() > 0) {


            List<Symbol_MultiPart> multiPartSymbols = symbol_Index.multiPart.get_MultiPartSymbol_List();

            for (int i = 0; i < multiPartSymbols.size(); ++i) {

                Symbol_MultiPart multiPartSymbol = multiPartSymbols.get(i);

                String symbolVariableName = null;

                if (multiPartSymbol.getNumOfParts() > 1) {
                    symbolVariableName = multiPartSymbol.name_IdentFormat;

                } else if (multiPartSymbol.getNumOfParts() == 1) {
                    //  It's a single level symbol, don't do anything with it
                    continue;

                    /*  KEEP THIS CODE! in case we revert back to allowing single level multi-part symbols
                    //  this is a single-symbol, multipart symbol. Their names will conflict with their single-symbol counterparts (because,
                    //  They are the same. So, since we really don't use these much, give them a special name in the Symbol file by adding a prefix
                    symbolVariableName = SymbolConstants.MultiPartSymbol_w_SingleSymbol_Prefix
                            + multiPartSymbol.name_IdentFormat;
                     */
                } else {
                    //  error, multipart symbol with no single symbols
                    //  for now, do nothing, skip this symbol
                    continue;
                }
                String symbolID_VarName = symbolVariableName + SymbolConstants.SymbolFile_SymbolName__SymbolID_Suffix;



                variablesCode.append("\tpublic static " + symbolType.toString() +" " + symbolVariableName + ";\n");
                variablesCode.append("\tpublic static final int " + symbolID_VarName + " = " + multiPartSymbol.ID+ ";\n");

                staticInitCode.append("\t\t//  " + StringUtilities.convertToEscapedString(multiPartSymbol.name) + "\n");
                staticInitCode.append("\t\tsymbolStrings = new ArrayList<String>();\n");

                for (Symbol sym : multiPartSymbol.symbols) {
                    staticInitCode.append("\t\tsymbolStrings.add(\"" + StringUtilities.convertToEscapedString(sym.name) + "\");\n");
                }


                String symbolClass_Suffix = "";
                if (symbolType == SymbolType.DescriptorTagName)
                    symbolClass_Suffix = HierarchySettings.symbolClassSuffix_DescTagName;
                else if (symbolType == SymbolType.Label)
                    symbolClass_Suffix = HierarchySettings.symbolClassSuffix_Label;

                staticInitCode.append("\n\t\t"+ symbolVariableName + " = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew").append(symbolClass_Suffix);
                staticInitCode.append("(symbolStrings, " + multiPartSymbol.ID +", creation_StartLevel, " +
                        "creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :\n");
                staticInitCode.append("\n\t\t\t\tmultiPartSymbol_Factory.createNew").append(symbolClass_Suffix);
                staticInitCode.append("(symbolStrings, creation_StartLevel, " +
                        "creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);\n\n\n");

            }


        } else {
            staticInitCode.append("\t//  empty!\n\n");
        }

        staticInitCode
            .append("\t\thave_Intialized = true;\n")
        .append("\t}\n\n");

    }



}
