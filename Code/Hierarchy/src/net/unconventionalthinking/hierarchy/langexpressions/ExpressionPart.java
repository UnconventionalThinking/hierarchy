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
 * The subclasses of this class are:
 * literal, primitive type, indentifier, method invocation, class token, super access, array access, cast
 *
 *
 * @author peterjoh
 */
public abstract class ExpressionPart {


    String partCode_Actual;

    public ExpressionPart(String partCode_Actual) {
        this.partCode_Actual = partCode_Actual;
    }

    public void setPartCode_Actual(String partCode_Actual) { this.partCode_Actual = partCode_Actual; }


    
    public String getPartCode_Actual() { return partCode_Actual; }


    /**  Collects useful about the expression part, for parts that are the FIRST part in an expression (meaning, you shouldn't call this
     * on a part that is a second or third part). The most important info is typically the full type name of the part */
    abstract public ExpressionPart_ExpressionInfo collect_FirstPart_ExpressionInfo(boolean isFirstAccess, LangSymbolTable_App symbolTable_App,
            LangSymbolTable_File symbolTable_File) throws Exception_FindTypeName;


    public boolean is_Identifier() { return this instanceof ExpressionPart_Identifier; }
    public boolean is_MethodInvocation() { return this instanceof ExpressionPart_MethodInvocation; }
    public boolean is_Literal() { return this instanceof ExpressionPart_Literal; }


    @Override
    public String toString() {
        return toString(0);
    }

	public String toString(int indentLevel) {
		StringBuilder indent_Builder = new StringBuilder();
		for(int i = 0; i < indentLevel; ++i)
			indent_Builder.append("\t");
		String indent = indent_Builder.toString();
				
		String out = indent + "ExpressionPart:\n" + 
				indent + "\tPart's Code: " + partCode_Actual + "\n" +
				indent + "\tExpressionPart Type: " + this.getClass().toString() + "\n";
		return out;
	}

}
