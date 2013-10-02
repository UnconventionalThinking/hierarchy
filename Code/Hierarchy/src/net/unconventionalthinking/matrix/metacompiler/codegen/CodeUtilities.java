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

import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.SymbolType;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import net.unconventionalthinking.regex.RegEx;
import java.util.regex.Pattern;

/**
 *
 * @author peterjoh
 */
public class CodeUtilities {

    private static final String LabelSuffix_withDot = HierarchySettings.symbolClassSuffix_Label + ".";
    private static final String DescTagNameSuffix_withDot = HierarchySettings.symbolClassSuffix_DescTagName + ".";

    private static final String MatrixNameSuffix_withDot = HierarchySettings.symbolClassSuffix_MatrixName + ".";
    private static final String SchemaNameSuffix_withDot = HierarchySettings.symbolClassSuffix_SchemaName + ".";
    private static final String DescTagSuffix_withDot = HierarchySettings.symbolClassSuffix_DescTag + ".";

    private static final String MPSymbols_ClassName = MPSymbols.class.getSimpleName();


    
    /**
     * Check for "MpSymbols.<sym name>" or "MpSymbols_Labels.<sym name>" or "MpSymbols_DescTagName.<sym name>"
     *
     * @param symExpression
     * @return  returns null if this is not a symbol expression
     */
    public static SymbolType getSymbolType_FromCodeString(String symExpression, String appSymbols_ClassName) {

        SymbolType symbolType = null;

        String restOfString = null;
        if (symExpression.startsWith(appSymbols_ClassName))
            restOfString = symExpression.substring(appSymbols_ClassName.length());
        else if (symExpression.startsWith(MPSymbols_ClassName))
            restOfString = symExpression.substring(MPSymbols_ClassName.length());


        if (restOfString != null) {
            if (restOfString.charAt(0) == '.') {
                return SymbolType.Symbol;
            } else if (restOfString.startsWith(LabelSuffix_withDot)) {
                return SymbolType.Label;
            } else if (restOfString.startsWith(DescTagNameSuffix_withDot)) {
                return SymbolType.DescriptorTagName;
            } else if (restOfString.startsWith(MatrixNameSuffix_withDot)) {
                return SymbolType.MatrixName;
            } else if (restOfString.startsWith(SchemaNameSuffix_withDot)) {
                return SymbolType.SchemaName;
            } else if (restOfString.startsWith(DescTagSuffix_withDot)) {
                return SymbolType.DescriptorTag;
            }
        }
        return null;
    }


    static String regEx = "\\s*(\\+\\s*)?:\\s*[A-Za-z$_][A-Za-z0-9$_]*(\\s*\\.\\s*[A-Za-z$_][A-Za-z0-9$_]*)*\\s*$";
    static boolean add_SearchFromBeginning = true;
    static Pattern regexPattern = RegEx.prepare_RegEx(regEx, add_SearchFromBeginning);

    public static boolean checkCode_Is_SymbolAccessOrCreation(String symbolExpr_UnTranslated) {

        return regexPattern.matcher(symbolExpr_UnTranslated).matches();

    }
}
