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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.unconventionalthinking.matrix.metacompiler.codegen;

/**
 *
 * @author peterjoh
 */
public class CodeConstants {

    /**
     * this is added to the end of the set methods in the specialized fieldSet class, to get the setField__Special() methods
     */
    public static final String FieldSet_SetMethodNameSuffix_Special = "__Special";


    public static final String OutVarName_Descriptor_Suffix = "__Descriptor";
    public static final String OutVarName_Descriptor_UsesSchemaSet_Suffix = "__UsesSchemaSet";

    public static final String OutVarName_FieldSet_Suffix = "__FieldSet";

    /**
     * String for the call to the getSingleSymbolById() method
     */
    public static final String SymbolIndex__getSingleSymbol_ById = "symbolControl.appSymbolsIndex.getSingleSymbol_ById";
    public static final String SymbolIndex__getSingleDescTagName_ById = "symbolControl.descTagNames_Index.getSingleSymbol_ById";
    public static final String SymbolIndex__getSingleLabel_ById = "symbolControl.labels_Index.getSingleSymbol_ById";


    public static final String SymbolIndex__getMultiPartSymbol_ById = "symbolControl.appSymbolsIndex.multiPart.get_MultiPartSymbol_ById";
    public static final String SymbolIndex__getMultiPartDescTagName_ById = "symbolControl.descTagNames_Index.multiPart.get_MultiPartSymbol_ById";
    public static final String SymbolIndex__getMultiPartLabel_ById = "symbolControl.labels_Index.multiPart.get_MultiPartSymbol_ById";


    public static String SymbolIndex__getDescTag_ById = "symbolControl.descTag_Index.get_MultiLevelSymbol_ById";
    public static String SymbolIndex__getSchemaName_ById = "symbolControl.schemaName_Index.get_MultiLevelSymbol_ById";
    public static String SymbolIndex__getMatrixName_ById = "symbolControl.matrixName_Index.get_MultiLevelSymbol_ById";



    public static final String MatrixImports_Sets =     "import net.unconventionalthinking.matrix.*;";
    public static final String MatrixImports_Symbols =  "import net.unconventionalthinking.matrix.symbols.*;";
    public static final String MatrixImports_AbstractLang =         "import net.unconventionalthinking.lang.*;";
    public static final String MatrixImports_AbstractExceptions =   "import net.unconventionalthinking.exceptions.*;";
    public static final String MatrixImports_Main = "import net.unconventionalthinking.matrix.*;";


    public static final String MATRIX_KEYWORD = "MATRIX";
    public static final String SCHEMA_KEYWORD = "SCHEMA";
    public static final String ITEM_KEYWORD = "ITEM";
    public static final String DESCRIPTOR_KEYWORD = "DESCRIPTOR";


    public static final String OutMethodName_AccessMatrix_Suffix = "accessMatrix_";
    public static final String OutMethodName_AccessMatrix_Suffix_ForFieldAssignment = "accessMatrixForFieldAssign_";
    public static final String OutMethodName_AccessMatrix_Modifier_InStaticMethod = "inStaticMethod_";
    public static final String OutMethodName_AnnotationMethod_Suffix = "annotationHandler_";
    public static final String OutMethodName_FilterAnnotationMethod_Suffix = "filter_AnnotationHandler_";


}
