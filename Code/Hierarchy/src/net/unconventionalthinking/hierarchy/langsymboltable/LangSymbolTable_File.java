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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol.SymbolType;
import org.apache.commons.collections.map.MultiValueMap;



/**
 * <b>Symbol Table:</b><p>
 *
 * The symbol table has 2 types hash maps: one that must have unique symbol names at a scope level, and one that doesn't.
 * The reason there are two types is because some lang elements, like methods, can be overloaded, and have multiple method names symbols in
 * the same scope. Others like vars, must be unique at a scope level.<p>
 *
 * The var symbol table is structured as follows:<br>
 * The var symbolTable hash map has keys that are the symbol names and whose values are a TreeMap of Symbol objects (of course, all
 * the symbols in an entry's treemap will all have the same symbol name). Each symbol object in the treemap is a symbol at a particular
 * scope level. The symbol treemap is ordered by scope id.<p>
 *
 * For instance, <p>
 *
 *     Symbol Table<br>
 *     Key:          Value:<br>
 *     myVar1   ->   myVar1 TreeMap<br>
 *     myVar2   ->   myVar2 TreeMap<p>
 *
 *
 *     myVar1 TreeMap<br>
 *     Key (scope id):          Value:<br>
 *     1                    ->  myVar1 @ scope 1<br>
 *     3                    ->  myVar1 @ scope 3<p>
 *
 * The method symbol table is structured to allow method symbols with the same
 * name and the same scope id (overloaded methods), the TreeMap key (scope id) maps to a LIST of method symbols (not just one symbol).<p>
 *
 * No symbol that is encountered is ever deleted. The reason for this is because you may need to use a symbol's info later on
 * (like in the debugger). Instead, there is a separate scope stack that tells you what scope you're in, and what scope's you have seen.
 * <p>
 * This design is based on the symbol table described in the book, Programming Language Pragmatics, by Scott. Actually, it's not in the book,
 * it's on the book's CD, in the supplemental material for Ch 3.<br>
 * 
 * @author peterjoh
 */
public class LangSymbolTable_File implements TypeInfo_SrcCodeFileInfo {

    public final LangSymbolTable_File__forMatrixAccess  matrixAccess_SymbolTableFile;


    private Map<String, TreeMap<Integer, List<LangSymbol>>> symbolTable_All;

    /**
     * This symbolTable is organized first by symbolType, then by scope id. It's useful for things like matrixAccess, where at a certain
     * scope level, you want to know if there are any matrix accesses at a certain scope.
     */
    private Map<LangSymbol.SymbolType, TreeMap<Integer, List<LangSymbol>>>  symbolTable_bySymbolType;
    public final LangSymbolTable_File__SymbolTableByType_Worker             symbolTable_bySymbolType__Worker;

    // only one type with symbol name per scope: Can't have: enum MyType {} and the inner class: public static MyType {} defined at same scope
    private Map<String, TreeMap<Integer, LangSymbol>>       symbolTable_Types;
    /** a type body has a unique scope id attached to it. you can map from scopeid to the type for that scope id (note, not every scope id maps
     *  to a type though */
    private Map<Integer, LangSymbol_Type>                   symbolTable_Types__typeBodyScopeid_to_TypeSym;
    /** a method body has a unique scope id attached to it. you can map from scopeid to the type for that scope id (note, not every scope id maps
     *  to a method body though */
    private Map<Integer, LangSymbol_Method>                 symbolTable_Method__methodBodyScopeid_to_MethodSym;

    //  only one var with symbol name per scope: can't have a method param and a local var in the method with the same name
    private Map<String, TreeMap<Integer, LangSymbol>>       symbolTable_Vars;
    
    //  can have overloaded method names
    private Map<String, TreeMap<Integer, List<LangSymbol>>>     symbolTable_Methods;

    private LinkedHashMap<String, LangSymbol_Import>            symbolTable_Imports;



    private LinkedHashMap<String, LangSymbol_Import_Type>       symbolTable_Import_Type;
    private LinkedHashMap<String, LangSymbol_Import_Type>       symbolTable_Import_MPType__Matrix;
    private LinkedHashMap<String, LangSymbol_Import_Type>       symbolTable_Import_MPType__Schema;
    /**
     * The multi-value index, symbolTableMultiValueIndex_ImportType_byFinalTypeName maps a the final type name to all the imports that
     * have this final name:
     *   ex.   import mypackage1.MyClass; import mypackage2.MyClass;
     *      these two would have the final type name of MyClass, which in this index, would map to the same List entry.
     * The List is ordered by when each was added.
     */
    private Map<String, List<LangSymbol_Import_Type>>           symbolTableMultiValueIndex_ImportType__bySimpleName;
    private Map<String, List<LangSymbol_Import_Type>>           symbolTableMultiValueIndex_Import_MPType_Matrix__bySimpleName;
    private Map<String, List<LangSymbol_Import_Type>>           symbolTableMultiValueIndex_Import_MPType_Schema__bySimpleName;


    private LinkedHashMap<String, LangSymbol_Import_Package>    symbolTable_Import_Package;



    /** client objs can access the scopeStack directly */
    public final LangSymbolScopeStack scopeStack;


    //  Used for Source-Code File Type-Info
    private String          fileName;
    private String          packageName;
    private List<TypeInfo>  typeInfo_List;

    private HierarchySettings hierarchySettings;


    public LangSymbolTable_File(HierarchySettings hierarchySettings) {


        symbolTable_All = new HashMap<String, TreeMap<Integer, List<LangSymbol>>>();
        symbolTable_bySymbolType = new EnumMap<LangSymbol.SymbolType, TreeMap<Integer, List<LangSymbol>>>(LangSymbol.SymbolType.class);
        symbolTable_bySymbolType__Worker = new LangSymbolTable_File__SymbolTableByType_Worker(symbolTable_bySymbolType);
        
        symbolTable_Types = new HashMap<String, TreeMap<Integer, LangSymbol>>();
        symbolTable_Types__typeBodyScopeid_to_TypeSym = new HashMap<Integer, LangSymbol_Type>();
        symbolTable_Method__methodBodyScopeid_to_MethodSym = new HashMap<Integer, LangSymbol_Method>();

        symbolTable_Vars = new HashMap<String, TreeMap<Integer, LangSymbol>>();
        symbolTable_Methods = new HashMap<String, TreeMap<Integer, List<LangSymbol>>>();

        symbolTable_Imports = new LinkedHashMap<String, LangSymbol_Import>();
        symbolTable_Import_Package = new LinkedHashMap<String, LangSymbol_Import_Package>();

        symbolTable_Import_Type = new LinkedHashMap<String, LangSymbol_Import_Type>();
        symbolTable_Import_MPType__Matrix = new LinkedHashMap<String, LangSymbol_Import_Type>();
        symbolTable_Import_MPType__Schema = new LinkedHashMap<String, LangSymbol_Import_Type>();
        symbolTableMultiValueIndex_ImportType__bySimpleName = new HashMap<String, List<LangSymbol_Import_Type>>();
        symbolTableMultiValueIndex_Import_MPType_Matrix__bySimpleName = new HashMap<String, List<LangSymbol_Import_Type>>();
        symbolTableMultiValueIndex_Import_MPType_Schema__bySimpleName = new HashMap<String, List<LangSymbol_Import_Type>>();

        matrixAccess_SymbolTableFile = new LangSymbolTable_File__forMatrixAccess(this, hierarchySettings);

        scopeStack = new LangSymbolScopeStack(hierarchySettings);

        typeInfo_List = new ArrayList<TypeInfo>();

        this.hierarchySettings = hierarchySettings;

    }

    //  Source Code File-Info Setup methods
    @Override
    public void setSrcCodeFileName(String fileName) { this.fileName = fileName;}
    @Override
    public void setSrcCodeFilePackage(String packageName) { this.packageName = packageName; }


    //  __________________________________________________________________________________________________________
    //
    //    Add Symbol Methods
    //  __________________________________________________________________________________________________________

    public void addSymbol_Var(LangSymbol_Variable langSymbol_Var) {

        addSymbolto__Maps_w_UniqueSymNameAtScope(langSymbol_Var, symbolTable_Vars);
        addSymbol_All(langSymbol_Var);
    }
    public void addSymbol_Type(LangSymbol_Type langSymbol_Type, boolean alreadyPushed_TypeBodyScope_OnToStack) {

        addSymbolto__Maps_w_UniqueSymNameAtScope(langSymbol_Type, symbolTable_Types);
        addSymbol_All(langSymbol_Type);


        // if you haven't already pushed the scope for the type body onto the stack, then you need to add one to the scope id for the type body
        int scopeid_forType = (alreadyPushed_TypeBodyScope_OnToStack ? scopeStack.viewCurrentScope().scope_Id :
            scopeStack.peekAt_NextScopeId());
        symbolTable_Types__typeBodyScopeid_to_TypeSym.put(scopeid_forType, langSymbol_Type);

        addTypeInfo_to_FilesTypeList(langSymbol_Type);
    }



    public void addSymbol_Method(LangSymbol_Method langSymbol_Method, boolean alreadyPushed_MethodBodyScope_OnToStack) {

        //  Method names can be overloaded, so it's map can have duplicate sym names at same scope level
        addSymbolto__Maps_w_DuplicateSymNamesAtScope(langSymbol_Method, symbolTable_Methods);

        // if you haven't already pushed the scope for the type body onto the stack, then you need to add one to the scope id for the type body
        int scopeid_forMethodbody = (alreadyPushed_MethodBodyScope_OnToStack ? scopeStack.viewCurrentScope().scope_Id :
            scopeStack.peekAt_NextScopeId());
        symbolTable_Method__methodBodyScopeid_to_MethodSym.put(scopeid_forMethodbody, langSymbol_Method);

        // add the symbol to the all symbol's symbol table
        addSymbol_All(langSymbol_Method);

    }



    @Override
    public void addSymbol_Import_Package(LangSymbol_Import_Package langSymbol) {
        symbolTable_Import_Package.put(langSymbol.name, langSymbol);
        addSymbol_Import(langSymbol);
    }





    public void addSymbol_Import_MPType__Schema(LangSymbol_Import_Type importSymbol) {
        addSymbol_Import_Type__Worker(this.symbolTable_Import_MPType__Schema, this.symbolTableMultiValueIndex_Import_MPType_Schema__bySimpleName,
                importSymbol);
    }
    public void addSymbol_Import_MPType__Matrix(LangSymbol_Import_Type importSymbol) {
        addSymbol_Import_Type__Worker(this.symbolTable_Import_MPType__Matrix, this.symbolTableMultiValueIndex_Import_MPType_Matrix__bySimpleName,
                importSymbol);
    }
    @Override
    public void addSymbol_Import_Type(LangSymbol_Import_Type importSymbol) {
        addSymbol_Import_Type__Worker(this.symbolTable_Import_Type, this.symbolTableMultiValueIndex_ImportType__bySimpleName, importSymbol);
    }

    private void addSymbol_Import_Type__Worker(LinkedHashMap<String, LangSymbol_Import_Type> symbolTable_Import_Type,
            Map<String, List<LangSymbol_Import_Type>> symbolTableMultiValueIndex_ImportType_bySimpleName,
            LangSymbol_Import_Type importSymbol) {

        symbolTable_Import_Type.put(importSymbol.name, importSymbol);


        //  Add it to the multi-value index, symbolTableMultiValueIndex_ImportType_bySimpleName. entries with the same simple name
        //  are ordered by when each was added.
        List<LangSymbol_Import_Type> importTypes_w_same_SimpleName = symbolTableMultiValueIndex_ImportType_bySimpleName.get(
                                                                        importSymbol.name_Simple);
        if (importTypes_w_same_SimpleName == null) {
            importTypes_w_same_SimpleName = new ArrayList<LangSymbol_Import_Type>();

            symbolTableMultiValueIndex_ImportType_bySimpleName.put(importSymbol.name_Simple, importTypes_w_same_SimpleName);
        }
        // add it to the arrayList, Ordered by when the importType was added
        importTypes_w_same_SimpleName.add(importSymbol);


        addSymbol_Import(importSymbol);
    }
    void addSymbol_Import(LangSymbol_Import langSymbol) {

        symbolTable_Imports.put(langSymbol.name, langSymbol);
        addSymbol_All(langSymbol);
    }

    public void addMatrixSymbol_AnnotationHandler(LangSymbolMatrix_AnnotationHandler annotationHandler_LangSym) {
        symbolTable_bySymbolType__Worker.addSymbolto_SymbolTypesMap(LangSymbol.SymbolType.Matrix_AnnotationHandler, annotationHandler_LangSym);
        addSymbol_All(annotationHandler_LangSym);
    }

    


    void addSymbol_All(LangSymbol langSymbol) {
        addSymbolto__Maps_w_DuplicateSymNamesAtScope(langSymbol, symbolTable_All);

    }

    void addSymbolto__Maps_w_UniqueSymNameAtScope(LangSymbol langSymbol, Map<String, TreeMap<Integer, LangSymbol>> symbolTable) {

        TreeMap<Integer, LangSymbol> symbol_TreeMap = symbolTable.get(langSymbol.name);
        if (symbol_TreeMap == null) {
            symbol_TreeMap = new TreeMap<Integer, LangSymbol>();
            symbolTable.put(langSymbol.name, symbol_TreeMap);
        }
        
        symbol_TreeMap.put(new Integer(langSymbol.scopeID), langSymbol);

    }


    private void addSymbolto__Maps_w_DuplicateSymNamesAtScope(LangSymbol langSymbol,
            Map<String, TreeMap<Integer, List<LangSymbol>>> symbolTable) {

        TreeMap<Integer, List<LangSymbol>> symbol_TreeMap = symbolTable.get(langSymbol.name);
        if (symbol_TreeMap == null) {
            symbol_TreeMap = new TreeMap<Integer, List<LangSymbol>>();
            symbolTable.put(langSymbol.name, symbol_TreeMap);
        }


        // now, see there is a list of symbols there already (the list contains all the symbols with the same name at the same scope level)
        Integer scopeID = new Integer(langSymbol.scopeID);
        List<LangSymbol> symbolsList__hasSameName_forScopeLevel = symbol_TreeMap.get(scopeID);
        if (symbolsList__hasSameName_forScopeLevel == null) {
            symbolsList__hasSameName_forScopeLevel = new ArrayList<LangSymbol>();
            symbol_TreeMap.put(scopeID, symbolsList__hasSameName_forScopeLevel);
        }


        // add the sym to the symbol list
        symbolsList__hasSameName_forScopeLevel.add(langSymbol);


    }

    //  __________________________________________________________________________________________________________
    //
    //    Lookup Symbol Methods
    //  __________________________________________________________________________________________________________



    public List<LangSymbol> lookup(String symbolName) {
        return (List<LangSymbol>)lookup_Worker(symbolTable_All, symbolName);
    }

    public LangSymbol_Variable lookup_Var(String symbolName) {
        return (LangSymbol_Variable)lookup_Worker(symbolTable_Vars, symbolName);
    }
    
    public LangSymbol_Type lookup_Type(String symbolName) {
        return (LangSymbol_Type)lookup_Worker(symbolTable_Types, symbolName);
    }

    /** search down through the scope stack to find the type that is in scope */
    public LangSymbol_Type lookup_Type_InScope() {
        LangSymbolScopeStack.ScopeInfo[] currScopeStack = scopeStack.getScopeStack().toArray(
                new LangSymbolScopeStack.ScopeInfo[scopeStack.getScopeStack().size()]);

        LangSymbol_Type foundType = null;
        for (int i = currScopeStack.length - 1; foundType == null && i >= 0; --i) {

            LangSymbolScopeStack.ScopeInfo currScopeInfo = currScopeStack[i];

            foundType = symbolTable_Types__typeBodyScopeid_to_TypeSym.get(currScopeInfo.scope_Id);
        }

        return foundType;
    }


    


    public LangSymbol_Method lookup_Method(String methodName, LangSymbol_Variable... methodParameters) {
        List<LangSymbol> overLoadedMethods_List = (List<LangSymbol>)lookup_Worker(symbolTable_Methods, methodName);

        Iterator<LangSymbol> methodsList_Iter = overLoadedMethods_List.iterator();
        LangSymbol_Method found_OverLoadedMethod = null;

        while (methodsList_Iter.hasNext() && found_OverLoadedMethod == null) {
            LangSymbol_Method curr_OverLoadedMethod = (LangSymbol_Method)methodsList_Iter.next();

            if (LangSymbol_Method.equalParameters(curr_OverLoadedMethod.getMethodParam_List(), Arrays.asList(methodParameters)))
                found_OverLoadedMethod = curr_OverLoadedMethod;
        }

        return found_OverLoadedMethod;
    }
    public List<LangSymbol> lookup_Method(String methodName) {
        return (List<LangSymbol>)lookup_Worker(symbolTable_Methods, methodName);
    }



    
    /** Searches down through the scope stack to find the method that is in scope.<br>
      This version of the method does NOT peek at the next scope on the stack, and use this method body scope as the starting point for the
      search. The reason this is would be used is if you are, for instance, processing the method params for a method, and have not
      entered the method body yet, so when you start the search, you won't find the current method. */
    public LangSymbol_Method lookup_Method_InScope() {
        return lookup_Method_InScope(false);
    }
    /** Searches down through the scope stack to find the method that is in scope.<br>
     * If currentlyProcessingMethodParam_AddNextScopeIdOnStackToSearch is true, then this method peeks at the next scope on the stack,
     * and use this method body scope as the starting point for the search. The reason this is would be used is if you are,
     * for instance, processing the method params for a method, and have not
     * entered the method body yet, so when you start the search, you won't find the current method. */
    public LangSymbol_Method lookup_Method_InScope(boolean currentlyProcessingMethodParam_AddNextScopeIdOnStackToSearch) {


        LangSymbol_Method foundMethod = null;
        if (currentlyProcessingMethodParam_AddNextScopeIdOnStackToSearch) {
            foundMethod = symbolTable_Method__methodBodyScopeid_to_MethodSym.get(scopeStack.peekAt_NextScopeId());

        }
        
        if (foundMethod == null) {
            LangSymbolScopeStack.ScopeInfo[] currScopeStack = scopeStack.getScopeStack().toArray(
                    new LangSymbolScopeStack.ScopeInfo[scopeStack.getScopeStack().size()]);

            for (int i = currScopeStack.length - 1; foundMethod == null && i >= 0; --i) {

                LangSymbolScopeStack.ScopeInfo currScopeInfo = currScopeStack[i];

                foundMethod = symbolTable_Method__methodBodyScopeid_to_MethodSym.get(currScopeInfo.scope_Id);
            }
        }

        return foundMethod;
    }

    

    /**  Look up any import by its full name string (Java package, Java class, Matrix or Schema imports) */
    @Override
    public LangSymbol_Import lookup_Import(String importName_ClassOrPackage) {
        return symbolTable_Imports.get(importName_ClassOrPackage);
    }


    /**  Look up a Java import type by its full name string */
    @Override
    public LangSymbol_Import lookup_ImportType(String importName_Type) {
        return symbolTable_Import_Type.get(importName_Type);
    }
    /** Look up a Java type import by its simple name. Ex, com.mypackage.MyClass, it'd be the simple name, MyClass. */
    @Override
    public List<LangSymbol_Import_Type> lookup_ImportType__bySimpleName(String simpleName) {
        return symbolTableMultiValueIndex_ImportType__bySimpleName.get(simpleName);
    }

    /**  Look up a Matrix import type by its full name string. Ex, com.mypackage::My.Matrix */
    public LangSymbol_Import lookup_ImportMPType__Matrix(String importName_Type) {
        return symbolTable_Import_MPType__Matrix.get(importName_Type);
    }
    /** Look up a Matrix type import by its simple name. Ex, com.mypackage::My.Matrix, it'd be the simple name, My.Matrix . */
    public List<LangSymbol_Import_Type> lookup_ImportMPType__Matrix__bySimpleName(String simpleName) {
        return symbolTableMultiValueIndex_Import_MPType_Matrix__bySimpleName.get(simpleName);
    }
    /**  Look up a Matrix import type by its full name string. Ex, com.mypackage::My.Schema */
    public LangSymbol_Import lookup_ImportMPType__Schema(String importName_Type) {
        return symbolTable_Import_MPType__Schema.get(importName_Type);
    }
    /** Look up a Schema type import by its simple name. Ex, com.mypackage::My.Schema, it'd be the simple name, My.Schema . */
    public List<LangSymbol_Import_Type> lookup_ImportMPType__Schema__bySimpleName(String simpleName) {
        return symbolTableMultiValueIndex_Import_MPType_Schema__bySimpleName.get(simpleName);
    }


    /**  Look up a Java package import. */
    @Override
    public LangSymbol_Import lookup_ImportPackage(String importName_Package) {
        return symbolTable_Import_Package.get(importName_Package);
    }




    private Object lookup_Worker(Map symbolTableToSearch, String symbolName) {

        TreeMap symbol_TreeMap = (TreeMap)symbolTableToSearch.get(symbolName);


        if (symbol_TreeMap != null) {

            //  search from the top the scope to bottom for the first match
            Object highestMatching_SymbolOrOverloadedMethodsList = null;


            LangSymbolScopeStack.ScopeInfo[] currScopeStack = scopeStack.getScopeStack().toArray(
                    new LangSymbolScopeStack.ScopeInfo[scopeStack.getScopeStack().size()]);

            for (int i = currScopeStack.length - 1; highestMatching_SymbolOrOverloadedMethodsList == null && i >= 0; --i) {

                LangSymbolScopeStack.ScopeInfo currScopeInfo = currScopeStack[i];

                highestMatching_SymbolOrOverloadedMethodsList = symbol_TreeMap.get(new Integer(currScopeInfo.scope_Id));
            }

            return highestMatching_SymbolOrOverloadedMethodsList;

        } else {
            return null;
        }

    }


    //  __________________________________________________________________________________________________________
    //
    //    Get Methods
    //  __________________________________________________________________________________________________________


    public TreeMap<Integer, List<LangSymbol>> getSymbolTable_bySymbolType(SymbolType symbolType) {
        return symbolTable_bySymbolType.get(symbolType);
    }

    @Override
    public LinkedHashMap<String, LangSymbol_Import>         getSymbolTable_Imports() { return symbolTable_Imports; }
    @Override
    public LinkedHashMap<String, LangSymbol_Import_Type>    getSymbolTable_Import_Type() { return symbolTable_Import_Type;}
    public LinkedHashMap<String, LangSymbol_Import_Type>    getSymbolTable_Import_MPType__Matrix() { return symbolTable_Import_MPType__Matrix; }
    public LinkedHashMap<String, LangSymbol_Import_Type>    getSymbolTable_Import_MPType__Schema() { return symbolTable_Import_MPType__Schema; }
    @Override
    public LinkedHashMap<String, LangSymbol_Import_Package> getSymbolTable_Import_Package() { return symbolTable_Import_Package;}



    public Iterator<LangSymbol_Import> getSymbolTable_ImportsIterator__ordered() {
        return symbolTable_Imports.values().iterator();
    }




    //  __________________________________________________________________________________________________________
    //
    //    Source-Code File Type Info implemented methods (NOTE: some are in the previous sections)
    //  __________________________________________________________________________________________________________

    /** don't call this directly, the langSymbol_Type table will call this when necessary */
    @Override
    public void addTypeInfo_to_FilesTypeList(TypeInfo typeInfo) { typeInfo_List.add(typeInfo); }


    @Override
    public String getSrcCodeFileName() { return fileName; }
    @Override
    public String getSrcCodeFilePackage() { return packageName; }

    @Override
    public List<TypeInfo> getTypeInfo_List() { return typeInfo_List; }




}
