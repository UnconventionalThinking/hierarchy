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

package net.unconventionalthinking.hierarchy.langsymboltable;

/**
 *
 * @author peterjoh
 */
public class LangSymbolMatrix_AnnotationHandler extends LangSymbol {

    LangSymbol_Method parentMethodSymbol;
    

    /**
     * This version takes no scope id. It uses the current, top most scope. This is probably the version of the method that will be most used.
     */
    public static LangSymbolMatrix_AnnotationHandler createSymbol__Matrix_AnnotationHandler(String annotations_ParentMethodName,
            LangSymbol_Method parentMethodSymbol, Object otherInfo, LangSymbolTable_File symbolTable, SymbolModifier... modifiers) {

        return createSymbol__Matrix_AnnotationHandler(annotations_ParentMethodName, symbolTable.scopeStack.viewCurrentScope().scope_Id, parentMethodSymbol,
                otherInfo, symbolTable, modifiers);
    }

    public static LangSymbolMatrix_AnnotationHandler createSymbol__Matrix_AnnotationHandler(String annotations_ParentMethodName,
            int scopeID, LangSymbol_Method parentMethodSymbol, Object otherInfo,
            LangSymbolTable_File symbolTable, SymbolModifier... modifiers) {

        LangSymbolMatrix_AnnotationHandler langSymbol_AnnotationHandler = new LangSymbolMatrix_AnnotationHandler(annotations_ParentMethodName,
                scopeID, parentMethodSymbol, otherInfo, modifiers);

        symbolTable.addMatrixSymbol_AnnotationHandler(langSymbol_AnnotationHandler);
        return langSymbol_AnnotationHandler;
    }






    LangSymbolMatrix_AnnotationHandler(String annotations_ParentMethodName, int scopeID, LangSymbol_Method parentMethodSymbol, Object otherInfo,
            SymbolModifier... modifiers) {

        super(annotations_ParentMethodName, LangSymbol_Type.SymbolType.Matrix_AnnotationHandler, scopeID, otherInfo, modifiers);

        this.parentMethodSymbol = parentMethodSymbol;

        parentMethodSymbol.add_AnnotationHandler(this);
    }


    
    public LangSymbol_Method getParentMethodSymbol() { return parentMethodSymbol; }


    

}
