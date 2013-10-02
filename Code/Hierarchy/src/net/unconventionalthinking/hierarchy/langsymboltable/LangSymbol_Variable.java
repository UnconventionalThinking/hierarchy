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
public class LangSymbol_Variable extends LangSymbol {

    public enum VariableCategory { Primitive, ComplexType, DescriptorVar, Void }


    private LangSymbol           parentSymbol;
    private TypeUsageInfo        var_TypeUsageInfo;



    /**
     * This version takes no scope id. It uses the current, top most scope. This is probably the version of the method that will be most used.
     */
    public static LangSymbol_Variable createSymbol__Variable(String varName, SymbolType varSymbolType, TypeUsageInfo var_TypeUsageInfo,
            LangSymbol parentSymbol, Object otherInfo, LangSymbolTable_File symbolTable, SymbolModifier... modifiers) {

        return createSymbol__Variable(varName, varSymbolType, var_TypeUsageInfo,
                symbolTable.scopeStack.viewCurrentScope().scope_Id, parentSymbol, otherInfo, symbolTable, modifiers);
    }

    public static LangSymbol_Variable createSymbol__Variable(String varName, SymbolType varSymbolType, TypeUsageInfo var_TypeUsageInfo,
            int scopeID, LangSymbol parentSymbol, Object otherInfo, LangSymbolTable_File symbolTable, SymbolModifier... modifiers) {
        
        if (varSymbolType != SymbolType.Variable_Class && varSymbolType != SymbolType.Variable_Local)
            throw new ExceptRuntime_HierarchyMetaCompilerError("Tried to create a variable symbol in the symbol table, but the " +
                    "symbol type was incorrect. It should have been a class or local var, but was: " + varSymbolType + ". the name of " +
                    "the symbol is " + varName);

        LangSymbol_Variable langSymbol_Var = new LangSymbol_Variable(varName, var_TypeUsageInfo, varSymbolType, scopeID, parentSymbol, otherInfo, modifiers);

        symbolTable.addSymbol_Var(langSymbol_Var);
        return langSymbol_Var;
    }





    
    LangSymbol_Variable(String varName, TypeUsageInfo var_TypeUsageInfo, SymbolType symbolType, int scopeID, 
            LangSymbol parentSymbol, Object otherInfo,
            SymbolModifier... modifiers) {

        super(varName, symbolType, scopeID, otherInfo, modifiers);

        if (parentSymbol != null)
            setParentSymbol(parentSymbol);
        this.var_TypeUsageInfo = var_TypeUsageInfo;
    }



    public void setParentSymbol(LangSymbol parentSymbol) {
        this.parentSymbol = parentSymbol;

        if (parentSymbol instanceof LangSymbolProperty_HasVariables) {
            ((LangSymbolProperty_HasVariables)parentSymbol).addSymbol_Variable(this);
        }
    }


    public LangSymbol getParentSymbol() { return parentSymbol; }


    public TypeUsageInfo        getVar_TypeUsageInfo() { return var_TypeUsageInfo; }

    public String               getActualUsage() { return var_TypeUsageInfo.getActualUsage(); }
    public String[]             getActualUsage_Parts() { return var_TypeUsageInfo.getActualUsage_Parts(); }

    public VariableCategory     getVariableCategory() { return var_TypeUsageInfo.getVariableCategory(); }
    public boolean              isComplexType() {
        return var_TypeUsageInfo.getVariableCategory() != null && var_TypeUsageInfo.getVariableCategory() == VariableCategory.ComplexType;
    }
    public boolean              isPrimitiveType() {
        return var_TypeUsageInfo.getVariableCategory() != null && var_TypeUsageInfo.getVariableCategory() == VariableCategory.Primitive;
    }
    public boolean              isDescriptorVar() {
        return var_TypeUsageInfo.getVariableCategory() != null && var_TypeUsageInfo.getVariableCategory() == VariableCategory.DescriptorVar;
    }
    public PrimitiveType        getPrimitiveType() { return var_TypeUsageInfo.getPrimitiveType(); }
    public String               getFullTypeName() { return var_TypeUsageInfo.getFullTypeName(); }
    public String[]             getFullTypeName_Parts() { return var_TypeUsageInfo.getFullTypeName_Parts(); }
    public String               getNameWithNestedNames() { return var_TypeUsageInfo.getNameWithNestedNames(); }
    public String[]             getNameWithNestedNames_Parts() { return var_TypeUsageInfo.getNameWithNestedNames_Parts(); }
    public String               getPackageName() { return var_TypeUsageInfo.getPackageName(); }





    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LangSymbol_Variable other = (LangSymbol_Variable) obj;
        if (this.getVariableCategory() != other.getVariableCategory()) {
            return false;
        }
        if (this.getPrimitiveType() != other.getPrimitiveType() &&
                (this.getPrimitiveType() == null || !this.getPrimitiveType().equals(other.getPrimitiveType()))) {
            return false;
        }
        if ((this.getFullTypeName() == null) ? (other.getFullTypeName() != null) : !this.getFullTypeName().equals(other.getFullTypeName())) {
            return false;
        }

        //  now, need to call the super's equal!
        return super.equals(obj);
    }




    
}
