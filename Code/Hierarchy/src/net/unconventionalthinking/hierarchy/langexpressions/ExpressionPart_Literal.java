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

import net.unconventionalthinking.hierarchy.langsymboltable.Exception_FindTypeName;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbolTable_App;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbolTable_File;

/**
 *
 * @author peterjoh
 */
public class ExpressionPart_Literal extends ExpressionPart {

    public ExpressionPart_Literal(String partCode_Actual) {
        super(partCode_Actual);
    }


    /**  Collects useful about the expression part, for parts that are the FIRST part in an expression (meaning, you shouldn't call this
     * on a part that is a second or third part). The most important info is typically the full type name of the part */
    @Override
    public ExpressionPart_ExpressionInfo collect_FirstPart_ExpressionInfo(boolean isFirstAccess, LangSymbolTable_App symbolTable_App, LangSymbolTable_File symbolTable_File)
         throws Exception_FindTypeName {
        return null;
    }



}
