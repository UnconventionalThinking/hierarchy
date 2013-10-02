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

import net.unconventionalthinking.lang.Boolean_Mutable;
import net.unconventionalthinking.hierarchy.langexpressions.Expression;
import net.unconventionalthinking.hierarchy.langexpressions.ExpressionPart;
import net.unconventionalthinking.hierarchy.langexpressions.ExpressionPart_Identifier;
import net.unconventionalthinking.hierarchy.langsymboltable.Exception_FindTypeName;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbolTable_App;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbolTable_File;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol_Type;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol_Variable;
import net.unconventionalthinking.hierarchy.langsymboltable.TypeInfo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author peterjoh
 */
public class ExpressionEvaluator_Type {


    private LangSymbolTable_App symbolTable_App;
    private LangSymbolTable_File symbolTable_File;



    public ExpressionEvaluator_Type(LangSymbolTable_App symbolTable_App, LangSymbolTable_File symbolTable_File) {
        this.symbolTable_App = symbolTable_App;
        this.symbolTable_File = symbolTable_File;
    }



    public List<ExpressionPart_ExpressionInfo> determineType(Expression expression, Boolean_Mutable couldNotFindType) throws
            Exception_FindTypeName {

        couldNotFindType.value = true;

        
        if (expression.getPart_Last().is_Identifier()
           /* || expression.getPart_Last().is_MethodInvocation() || // add these in later
            expression.getPart_Last().is_ArrayAccess() ||  expression.getPart_Last().is_Cast() */ ) {

            //  Determine type (the expression info) of last access (while collecting types/expression-info's of all accesses)
            List<ExpressionPart_ExpressionInfo> part_ExprInfo_List = new ArrayList<ExpressionPart_ExpressionInfo>();
            ExpressionPart_ExpressionInfo currPart_ExprInfo = null, prevPart_ExprInfo = null;
            ExpressionPart firstPart = expression.getPart_First();

            ExpressionPart_ExpressionInfo firstPart_ExprInfo = null;

            // Step 1: Get Expression Info for first expression part:
            if (firstPart != null) {
                firstPart_ExprInfo = firstPart.collect_FirstPart_ExpressionInfo(true, symbolTable_App, symbolTable_File);
            }


            if (firstPart_ExprInfo == null) {
                couldNotFindType.value = true;
                return part_ExprInfo_List; // return what you've found so far
            } else {
                part_ExprInfo_List.add(firstPart_ExprInfo);
                currPart_ExprInfo = firstPart_ExprInfo;
            }





            //  Step 2: Loop through the rest of the parts and get their types/expression-info's
            //  NOTE: i starts on the second element!
            for (int i = 1; i < expression.expressionParts_List.size() && currPart_ExprInfo != null; i++) {

                prevPart_ExprInfo = currPart_ExprInfo;
                currPart_ExprInfo = null;

                ExpressionPart curr_ExpressionPart = expression.expressionParts_List.get(i);


                //  Step 2a: If the previous access was a class, check if this next access is also a class
                //  Example: OuterClass.InnerClass
                if (prevPart_ExprInfo.is_ClassAccess && curr_ExpressionPart.is_Identifier()) {

                    String possibleNestedType = prevPart_ExprInfo.typeName_Full + "." +
                            ((ExpressionPart_Identifier)curr_ExpressionPart).getIdentifier();

                    TypeInfo innerClass_TypeInfo = symbolTable_App.getTypeInfo_byFullTypeName(possibleNestedType);


                    //  Create type/expressionInfo
                    if (innerClass_TypeInfo != null) {
                        boolean is_ClassAccess = true;
                        currPart_ExprInfo = new ExpressionPart_ExpressionInfo(curr_ExpressionPart, (LangSymbol_Type)innerClass_TypeInfo,
                                possibleNestedType, is_ClassAccess);
                    }
                } 



                // Step 2b: See if this is field access.
                if (currPart_ExprInfo == null && curr_ExpressionPart.is_Identifier()) {

                    TypeInfo prevPart_TypeInfo = symbolTable_App.getTypeInfo_byFullTypeName(prevPart_ExprInfo.typeName_Full);

                    if (prevPart_TypeInfo != null) {
                        LangSymbol_Variable field_SymVar = prevPart_TypeInfo.getField(
                                ((ExpressionPart_Identifier)curr_ExpressionPart).getIdentifier());

                        //  Create type/expressionInfo
                        if (field_SymVar != null) {
                            boolean is_ClassAccess = false;
                            String typeName = (field_SymVar.isComplexType() ? field_SymVar.getFullTypeName() :
                                field_SymVar.getPrimitiveType().getAsJavaKeyword());
                            currPart_ExprInfo = new ExpressionPart_ExpressionInfo(curr_ExpressionPart, field_SymVar, typeName,
                                    is_ClassAccess);
                        }
                    }

                }



                //  see if you able to get the type/expression-info for the part
                if (currPart_ExprInfo != null) {
                    part_ExprInfo_List.add(currPart_ExprInfo);
                } else {
                    couldNotFindType.value = true;
                    return part_ExprInfo_List; // return what you've found so far
                }


            } // end of for loop



            
            if (currPart_ExprInfo != null)
                couldNotFindType.value = false;
            else
                couldNotFindType.value = true;

            return part_ExprInfo_List; // return what you've found so far

            
        } else {
            couldNotFindType.value = true;
            return null;
        }
    }


}
