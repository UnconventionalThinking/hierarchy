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

import net.unconventionalthinking.hierarchy.ExceptRuntime_HierarchyMetaCompilerError;

/**
 *
 * @author peterjoh
 */
public class LangSymbol_Variable_DescriptorVar extends LangSymbol_Variable {


     private MatrixAccessState matrixAccessState;

    /**
     * This version takes no scope id. It uses the current, top most scope. This is probably the version of the method that will be most used.
     */
    public static LangSymbol_Variable createSymbol__Variable_DescriptorVar(String varName, SymbolType varSymbolType,
            TypeUsageInfo var_TypeUsageInfo, MatrixAccessState matrixAccessState, LangSymbol parentSymbol, Object otherInfo,
            LangSymbolTable_File symbolTable, SymbolModifier... modifiers) {

        return createSymbol__Variable_DescriptorVar(varName, varSymbolType, var_TypeUsageInfo, matrixAccessState,
                symbolTable.scopeStack.viewCurrentScope().scope_Id, parentSymbol, otherInfo, symbolTable, modifiers);
    }

    public static LangSymbol_Variable createSymbol__Variable_DescriptorVar(String varName, SymbolType varSymbolType,
            TypeUsageInfo var_TypeUsageInfo, MatrixAccessState matrixAccessState, int scopeID, LangSymbol parentSymbol, Object otherInfo,
            LangSymbolTable_File symbolTable, SymbolModifier... modifiers) {

        if (varSymbolType != SymbolType.Variable_Class && varSymbolType != SymbolType.Variable_Local)
            throw new ExceptRuntime_HierarchyMetaCompilerError("Tried to create a variable symbol in the symbol table, but the " +
                    "symbol type was incorrect. It should have been a class or local var, but was: " + varSymbolType + ". the name of " +
                    "the symbol is " + varName);

        LangSymbol_Variable langSymbol_Var = new LangSymbol_Variable_DescriptorVar(varName, var_TypeUsageInfo, matrixAccessState,
                varSymbolType, scopeID, parentSymbol, otherInfo, modifiers);

        symbolTable.addSymbol_Var(langSymbol_Var);
        return langSymbol_Var;
    }






    LangSymbol_Variable_DescriptorVar(String varName, TypeUsageInfo var_TypeUsageInfo, MatrixAccessState matrixAccessState,
            SymbolType symbolType, int scopeID, LangSymbol parentSymbol, Object otherInfo, SymbolModifier... modifiers) {

        super(varName, var_TypeUsageInfo, symbolType, scopeID, parentSymbol, otherInfo, modifiers);


        this.matrixAccessState = matrixAccessState;
    }
    public void setMatrixAccessState(MatrixAccessState matrixAccessState) { this.matrixAccessState = matrixAccessState; }



    
    public MatrixAccessState getMatrixAccessState() { return matrixAccessState; }



}
