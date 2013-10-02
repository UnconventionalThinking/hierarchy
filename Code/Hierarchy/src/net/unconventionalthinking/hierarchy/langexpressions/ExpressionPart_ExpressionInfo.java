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

import net.unconventionalthinking.hierarchy.langsymboltable.MatrixAccessState;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol;


/**
 * Holds useful information about the expression part. The most important info is typically the full type name of the part.
 *
 * @author peterjoh
 */
public class ExpressionPart_ExpressionInfo {


    public ExpressionPart                   expressionPart;

    /** Contains the associated symbol if the expression part has one. For instance, if the expression part is field on
     * an object, then the field's LangSymbol_Variable would be associated with it. If the expression part is a method, then the
     * method's LangSymbol_Method would be associated with it. */
    public LangSymbol                       associatedSymbol;

    public String                           typeName_Full;
    public boolean                          is_ClassAccess;



    /** Use this constructor if there is no lang symbol var associate with it. */
    private ExpressionPart_ExpressionInfo(ExpressionPart expressionPart, String typeName_Full, boolean is_ClassAccess) {
        this(expressionPart, null, typeName_Full, is_ClassAccess);
    }
    /**
     * Use this constructor if there is an associated symbol with this expression part. For instance, if the expression part is field on
     * an object, then the field's LangSymbol_Variable would be associated with it. If the expression part is a method, then the
     * method's LangSymbol_Method would be associated with it.
     */
    public ExpressionPart_ExpressionInfo(ExpressionPart expressionPart, LangSymbol associatedSymbol, String typeName_Full, boolean is_ClassAccess) {
        this.expressionPart = expressionPart;

        this.associatedSymbol = associatedSymbol;
        this.typeName_Full = typeName_Full;
        this.is_ClassAccess = is_ClassAccess;

    }

    @Override
    public String toString() {
    	String out = 
    			"Expression Info:\n" +
    		    expressionPart.toString(1) +
    		    associatedSymbol.toString(1) +
    		    "\tTypeName: " + typeName_Full + "\n" +
    		    "\tis_ClassAccess: " + is_ClassAccess + "\n" ;
    	return out;
    }
    
}
