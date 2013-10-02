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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author peterjoh
 */
public class LangSymbol_Method extends LangSymbol implements LangSymbolProperty_HasVariables {



    public final TypeUsageInfo                  returnType_TypeUsageInfo;




    private List<LangSymbol_Variable>           methodParamSym_List;
    private Map<String, LangSymbol_Variable>    methodParamSymIndex;

    private Map<String, LangSymbol_Variable>    localVarSymIndex;

    private Map<String, LangSymbol_Variable>    allVarSymIndex;
    private LangSymbol_Type                     parentTypeSym;


    private LangSymbolMatrix_AnnotationHandler  annotationHandler_Symbol;


    //  ____________________________________________________________________________________________________________
    //
    //  Construction methods
    //  ____________________________________________________________________________________________________________


    /**
     * This version takes no scope id. It uses the current, top most scope. This is probably the version of the method that will be most used.
     */
    public static LangSymbol_Method createSymbol__Method(String name, LangSymbol_Type parentType, TypeUsageInfo returnType_TypeUsageInfo,
             boolean alreadyPushed_MethodBodyScope_OnToStack, Object otherInfo, LangSymbolTable_File symbolTable, SymbolModifier... modifiers) {
        return createSymbol__Method(name, symbolTable.scopeStack.viewCurrentScope().scope_Id, parentType, returnType_TypeUsageInfo, alreadyPushed_MethodBodyScope_OnToStack, otherInfo, symbolTable, modifiers);
    }

    public static LangSymbol_Method createSymbol__Method(String name, int scopeID, LangSymbol_Type parentType, TypeUsageInfo returnType_TypeUsageInfo,
             boolean alreadyPushed_MethodBodyScope_OnToStack, Object otherInfo, LangSymbolTable_File symbolTable_File, SymbolModifier... modifiers) {
        LangSymbol_Method langSym = new LangSymbol_Method(name, scopeID, parentType, returnType_TypeUsageInfo, otherInfo, modifiers);
        if (returnType_TypeUsageInfo != null)
            returnType_TypeUsageInfo.setParentSymbol(langSym);

        symbolTable_File.addSymbol_Method(langSym, alreadyPushed_MethodBodyScope_OnToStack);
        return langSym;
    }





    /** This version is used to create a param symbol object for method call values. These symbol objets are NOT entered into the symbol table,
     *  and do not require a parent method. */
    public static LangSymbol_Variable createSymbol__MethodParameter_PrimitiveType__Unregistered(String varName,
            LangSymbol_Variable.PrimitiveType primitiveType, Object otherInfo, SymbolModifier... modifiers) {

        TypeUsageInfo var_TypeUsageInfo = new TypeUsageInfo(primitiveType, null, null, null);
        return new LangSymbol_Variable(varName, var_TypeUsageInfo, SymbolType.Variable_MethodParameter, -1, null, otherInfo, modifiers);
    }
    /** This version is used to create a param symbol object for method call values. These symbol objets are NOT entered into the symbol table,
     *  and do not require a parent method. */
    public static LangSymbol_Variable createSymbol__MethodParameter_ComplexType__Unregistered(String varName,
            String actualType_CodeString, Object otherInfo, SymbolModifier... modifiers) {

        TypeUsageInfo var_TypeUsageInfo = new TypeUsageInfo(actualType_CodeString, null, null, null);
        return new LangSymbol_Variable(varName, var_TypeUsageInfo, SymbolType.Variable_MethodParameter, -1, null, otherInfo, modifiers);
    }


    /**
     * This version takes no scope id. It uses the NEXT scope id on the stack. It assumes you are processing the method header, so current
     * scope id is that of the scope BELOW the method body scope. So, peek at the next scope id and use this for the method params <br>
     * This is probably the version of the method that will be most used.
     */
    public static LangSymbol_Variable createSymbol__MethodParameter(String varName, TypeUsageInfo var_TypeUsageInfo,
            LangSymbol_Method methodSymbol, Object otherInfo, LangSymbolTable_File symbolTable,
            SymbolModifier... modifiers) {
        return createSymbol__MethodParameter(varName, var_TypeUsageInfo, methodSymbol,
                symbolTable.scopeStack.peekAt_NextScopeId(), otherInfo, symbolTable, modifiers);
    }
    /**
     * This version takes a scope id.
     */
    public static LangSymbol_Variable createSymbol__MethodParameter(String varName, TypeUsageInfo var_TypeUsageInfo,
            LangSymbol_Method methodSymbol, int scopeID, Object otherInfo, LangSymbolTable_File symbolTable, SymbolModifier... modifiers) {
        return createSymbol__MethodParameter_Worker(false, varName, var_TypeUsageInfo, null, methodSymbol, scopeID, otherInfo, symbolTable, modifiers);
    }


    /**
     * This version creates a desc var with access state.
     * Also, this version takes no scope id. It uses the NEXT scope id on the stack. It assumes you are processing the method header, so current
     * scope id is that of the scope BELOW the method body scope. So, peek at the next scope id and use this for the method params <br>
     * This is probably the version of the method that will be most used.
     */
    public static LangSymbol_Variable createSymbol__MethodParameter_DescVar(String varName, TypeUsageInfo var_TypeUsageInfo,
            MatrixAccessState matrixAccessState, LangSymbol_Method methodSymbol, Object otherInfo, LangSymbolTable_File symbolTable,
            SymbolModifier... modifiers) {
        return createSymbol__MethodParameter_DescVar(varName, var_TypeUsageInfo, matrixAccessState, methodSymbol,
                symbolTable.scopeStack.peekAt_NextScopeId(), otherInfo, symbolTable, modifiers);
    }

    /**
     * This version creates a desc var with access state, and takes a scope id.
     */
    public static LangSymbol_Variable createSymbol__MethodParameter_DescVar(String varName, TypeUsageInfo var_TypeUsageInfo,
            MatrixAccessState matrixAccessState, LangSymbol_Method methodSymbol,
            int scopeID, Object otherInfo, LangSymbolTable_File symbolTable, SymbolModifier... modifiers) {
        return createSymbol__MethodParameter_Worker(true, varName, var_TypeUsageInfo, matrixAccessState, methodSymbol,
                scopeID, otherInfo, symbolTable, modifiers);
    }



    private static LangSymbol_Variable createSymbol__MethodParameter_Worker(boolean createDescVar, String varName, TypeUsageInfo var_TypeUsageInfo,
            MatrixAccessState matrixAccessState, LangSymbol_Method methodSymbol,
            int scopeID, Object otherInfo, LangSymbolTable_File symbolTable, SymbolModifier... modifiers) {

        if (scopeID == methodSymbol.scopeID)
            throw new ExceptRuntime_HierarchyMetaCompilerError("For some reason, the scope of the method parameters is the same as the method itself. " +
                    "This should never happen (the Scope id for the method param should be that of the method's body, not the method symbol itself)" +
                    ". The method name is :" + (methodSymbol != null ? methodSymbol.name : null));
        
        LangSymbol_Variable paramSymbol = null;
        if (createDescVar)
            paramSymbol = new LangSymbol_Variable_DescriptorVar(varName, var_TypeUsageInfo, matrixAccessState, SymbolType.Variable_MethodParameter,
                scopeID, methodSymbol, otherInfo, modifiers);
        else
            paramSymbol = new LangSymbol_Variable(varName, var_TypeUsageInfo, SymbolType.Variable_MethodParameter, scopeID,
                methodSymbol, otherInfo, modifiers);

        symbolTable.addSymbol_Var(paramSymbol);
        return paramSymbol;

    }



    


    //  ____________________________________________________________________________________________________________
    //
    //  Static Utility methods
    //  ____________________________________________________________________________________________________________
    
    public static boolean equalParameters(List<LangSymbol_Variable> methodParameterSymbols_First,
            List<LangSymbol_Variable> methodParameterSymbols_Second) {


        if (methodParameterSymbols_First.size() == methodParameterSymbols_Second.size()) {

            Iterator<LangSymbol_Variable> parametersFirst_Iter = methodParameterSymbols_First.iterator();
            Iterator<LangSymbol_Variable> parametersSecond_Iter = methodParameterSymbols_Second.iterator();

            boolean areEqual = true;
            while (parametersFirst_Iter.hasNext() && areEqual) {
                LangSymbol_Variable param_FromFirst = parametersFirst_Iter.next();
                LangSymbol_Variable param_FromSecond = parametersSecond_Iter.next();

                if (!param_FromFirst.equals(param_FromSecond))
                    areEqual = false;
            }
            
            return areEqual;
        } else
            return false;

    }



    
    //  ____________________________________________________________________________________________________________
    //
    //  Constructors (notice, not public, cause should use the static construction methods instead)
    //  ____________________________________________________________________________________________________________

    private LangSymbol_Method(String name, int scopeID, LangSymbol_Type parentType, TypeUsageInfo returnType_TypeUsageInfo, Object otherInfo,
            SymbolModifier... modifiers) {
        super(name, SymbolType.Method, scopeID, otherInfo, modifiers);

        if (parentType != null)
            setParentType(parentType);
        this.returnType_TypeUsageInfo = returnType_TypeUsageInfo;

        this.methodParamSym_List = new ArrayList<LangSymbol_Variable>();
        this.methodParamSymIndex = new HashMap<String, LangSymbol_Variable>();
        this.localVarSymIndex = new HashMap<String, LangSymbol_Variable>();
        this.allVarSymIndex = new HashMap<String, LangSymbol_Variable>();
    }


    public void setParentType(LangSymbol_Type parentType) {
        this.parentTypeSym = parentType;

        parentType.addSymbol_Method(this);
    }

    @Override
    public void addSymbol_Variable(LangSymbol_Variable varSymbol) {

        if (varSymbol.symbolType == SymbolType.Variable_MethodParameter) {
            methodParamSym_List.add(varSymbol);
            methodParamSymIndex.put(varSymbol.name, varSymbol);
        } else if (varSymbol.symbolType == SymbolType.Variable_Local) {
            localVarSymIndex.put(varSymbol.name, varSymbol);
        } else {
            throw new ExceptRuntime_LangSymbolTable("Was adding a variable symbol to a method symbol, and its type was not a method param or a local var." +
                    "This should never happen. The method name is, " + this.name + ", and the variable name is, " + varSymbol.name + ", and the " +
                    "variable symbol type was, " + varSymbol.symbolType + ".");
        }
        allVarSymIndex.put(varSymbol.name, varSymbol);
    }


    public void add_AnnotationHandler(LangSymbolMatrix_AnnotationHandler annotationHandler_Symbol) {
        this.annotationHandler_Symbol = annotationHandler_Symbol;
    }


    
    public LangSymbol_Type getParentType() { return parentTypeSym;}


    @Override
    public LangSymbol_Variable getField(String varName) { return allVarSymIndex.get(varName); }
    public LangSymbol_Variable getVariable_MethodParam(String paramName) { return methodParamSymIndex.get(paramName); }
    public LangSymbol_Variable getVariable_LocalVar(String fieldName) { return localVarSymIndex.get(fieldName); }

    public List<LangSymbol_Variable> getMethodParam_List() { return methodParamSym_List; }

    public boolean has_AnnotationHandler() { return annotationHandler_Symbol != null; }
    public LangSymbolMatrix_AnnotationHandler get_AnnotationHandler() { return annotationHandler_Symbol; }



}
