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

import net.unconventionalthinking.hierarchy.langexpressions.Expression;
import java.util.List;

/**
 *
 * @author peterjoh
 */
public class Expression_Utilities {


    /**
     * The purpose of this method is to check to make sure that an expression object is actually an Identifier expression. The
     * way we're gonna check this is very simple. We compare the number of parts in the identifer that was created, and compre it to the number of
     * parts that was created for the same expression in the Expression object.
     */
    public static boolean check_IsValidIdentifierExpression(Expression expression, List<String> identifier_Parts) {
        return (expression.getExpressionParts_List().size() == identifier_Parts.size());
    }
}
