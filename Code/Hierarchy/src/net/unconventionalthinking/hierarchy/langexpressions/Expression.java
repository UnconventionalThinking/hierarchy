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

import net.unconventionalthinking.utilities.ListUtilities;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author peterjoh
 */
public class Expression {


    List<ExpressionPart> expressionParts_List;

    public Expression() {
        expressionParts_List = new ArrayList<ExpressionPart>();
    }


    public void addExpressionPart(ExpressionPart expressionPart) { 
        expressionParts_List.add(expressionPart);
    }

    public List<ExpressionPart> getExpressionParts_List() { return expressionParts_List; }


    public ExpressionPart getPart_Last() {
        if (expressionParts_List.size() > 0) {
            return expressionParts_List.get(expressionParts_List.size() - 1);
        } else {
            return null;
        }

    }

    public ExpressionPart getPart_First() {
        if (expressionParts_List.size() > 0) {
            return expressionParts_List.get(0);
        } else {
            return null;
        }
    }


    @Override
    public String toString() {
        return ListUtilities.printWithDot(expressionParts_List);
    }
}
