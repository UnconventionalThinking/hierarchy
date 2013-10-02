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

package net.unconventionalthinking.hierarchy.langexpressions;

import net.unconventionalthinking.hierarchy.langsymboltable.ExceptRuntime_LangSymbols_FindTypeName;
import net.unconventionalthinking.hierarchy.langsymboltable.Exception_FindTypeName;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbolTable_App;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbolTable_File;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol_Type;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol_Variable;
import net.unconventionalthinking.hierarchy.langsymboltable.TypeFinder__inSrcCodeFile_Scope;
import net.unconventionalthinking.hierarchy.langsymboltable.TypeInfo;
import java.util.Arrays;

/**
 *
 * @author peterjoh
 */
public class ExpressionPart_Identifier extends ExpressionPart {

    public ExpressionPart_Identifier(String partCode_Actual) {
        super(partCode_Actual);
    }

    
    /**  Collects useful about the expression part, for parts that are the FIRST part in an expression (meaning, you shouldn't call this
     * on a part that is a second or third part). The most important info is typically the full type name of the part */
    @Override
    public ExpressionPart_ExpressionInfo collect_FirstPart_ExpressionInfo(boolean isFirstAccess, LangSymbolTable_App symbolTable_App,
            LangSymbolTable_File symbolTable_File)
        throws Exception_FindTypeName {

        ExpressionPart_ExpressionInfo part_ExpressionInfo = null;

        // search the symbol scope stack for the nearest matching var
        LangSymbol_Variable identifier_SymVar = symbolTable_File.lookup_Var(partCode_Actual);

        if (identifier_SymVar != null) {
            boolean is_ClassAccess = false;
            String typeName = (identifier_SymVar.isComplexType() || identifier_SymVar.isDescriptorVar()) ?
                                identifier_SymVar.getFullTypeName() :
                                identifier_SymVar.getPrimitiveType().getAsJavaKeyword();
            part_ExpressionInfo = new ExpressionPart_ExpressionInfo(this, identifier_SymVar, typeName, is_ClassAccess);


        } else if (isFirstAccess) { // check to see if this is static class access

            TypeFinder__inSrcCodeFile_Scope typeFinder = new TypeFinder__inSrcCodeFile_Scope(symbolTable_File, symbolTable_App);
            TypeInfo part_TypeInfo = symbolTable_File.lookup_Type_InScope();
            if (part_TypeInfo == null)
                throw new ExceptRuntime_LangSymbols_FindTypeName("While collecting info on the the first part of a matrix access, could not find the type, \"" +
                                                                  partCode_Actual + "\", for the current scope");
            String found_FullTypeName = typeFinder.find_FullTypeName(Arrays.asList(partCode_Actual),
                    part_TypeInfo.get_Name_withNestedNames(), symbolTable_File.getSrcCodeFilePackage());

            if (found_FullTypeName != null) {
                TypeInfo typeInfo = symbolTable_App.getTypeInfo_byFullTypeName(found_FullTypeName);
                if (typeInfo == null)
                    throw new ExceptRuntime_LangSymbols_FindTypeName("Couldn't find the type info for the type: " + found_FullTypeName + ". This shouldn't happen.");
                
                boolean is_ClassAccess = true;
                part_ExpressionInfo = new ExpressionPart_ExpressionInfo(this, (LangSymbol_Type)part_TypeInfo, typeInfo.get_FullTypeName(),
                        is_ClassAccess);
            }
        }

        return part_ExpressionInfo;

    }



    public String getIdentifier() { return partCode_Actual; }


}
