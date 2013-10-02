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

import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol_Variable;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol_Method;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbolTable_File;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol_Type;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author peterjoh
 */
public class _01_LangSymbolTable_File_Test {

    public _01_LangSymbolTable_File_Test() {}

    static LangSymbolTable_App symbolTable_App;
    static LangSymbolTable_File symbolTable_File;

    static HierarchySettings hierarchySettings = new HierarchySettings();

    @BeforeClass
    public static void setUpClass() throws Exception {

        symbolTable_App = new LangSymbolTable_App();
        symbolTable_File = new LangSymbolTable_File(hierarchySettings);
    }

    @AfterClass
    public static void tearDownClass() throws Exception { }
    @Before
    public void setUp() {}
    @After
    public void tearDown() {}



/* Sample code for test
public abstract class MyClass {

    private int myVar = 1;
    private int myVar2 = myVar + 1;

    private Int myInteger = new Int(1);
    public  Int myInteger2 = myInteger + 1;


    public MyClass(int myParam1, MyOtherClass myOtherclass) {

    }
    public short myMethod(MyContainer<MyItem> myContainer, int myInt) {

        short myShort = 1;
        short myShort2 = (short)(myShort + 1);

        return myShort2;
    }
    //  Overloaded method
    public short myMethod(MyContainer<MyItem> myContainer) {
        return (short)-1;
    }

    static int myStaticInt = 1;

    private static void myStaticMethod() {

        myStaticInt = 2;
    }

}
*/

    @Test
    public void test_CreateAndLookupSymbols() {
        System.out.println("test_CreateAndLookupSymbols");

        LinkedList<TypeInfo> nestTypeStack = new LinkedList<TypeInfo>();

        symbolTable_File.scopeStack.push_Global_Scope(); // global scope, scope id should be '0'

        int globalScopeID = 0;
        String myClass_Name = "MyClass";
        assertEquals(globalScopeID, symbolTable_File.scopeStack.viewCurrentScope().scope_Id);


        LangSymbol_Type.createSymbol__Class(myClass_Name, "mypackage", null, symbolTable_File, false, symbolTable_App,
                nestTypeStack, LangSymbol.SymbolModifier.Access_Public, LangSymbol.SymbolModifier.Abstract);

        final int ExpectedClassScopeID = 1;

        symbolTable_File.scopeStack.push_Class_Scope(false); // class scope, scope id should be '1'
        LangSymbol_Type myClass_Symbol = symbolTable_File.lookup_Type(myClass_Name);

        assertEquals(myClass_Name, myClass_Symbol.name);
        assertEquals(globalScopeID, myClass_Symbol.scopeID);
        assertEquals(LangSymbol.SymbolType.Class, myClass_Symbol.symbolType);

        assertEquals(ExpectedClassScopeID, symbolTable_File.scopeStack.viewCurrentScope().scope_Id);
        assertEquals(LangSymbolScopeStack.ClosedStackState.Class, symbolTable_File.scopeStack.viewCurrentScope().closedStackState);
        assertEquals(ExpectedClassScopeID, symbolTable_File.scopeStack.getCurrScopeID_for_ClassOrMethod_ScopeBoundary());


        String myVar_Name = "myVar";
        TypeUsageInfo variable_TypeUsageInfo = new TypeUsageInfo(LangSymbol.PrimitiveType.Int, symbolTable_File, symbolTable_File.lookup_Type_InScope(),
                                                    symbolTable_App.typeUsageInfoList_FullTypesToBeResolved);
        LangSymbol_Variable.createSymbol__Variable(myVar_Name, LangSymbol.SymbolType.Variable_Class, variable_TypeUsageInfo,
                myClass_Symbol, null, symbolTable_File, LangSymbol.SymbolModifier.Access_Private);

        LangSymbol_Variable myVar_Sym = (LangSymbol_Variable)symbolTable_File.lookup_Var(myVar_Name);
        
        assertEquals(myVar_Name, myVar_Sym.name);
        assertEquals(ExpectedClassScopeID, myVar_Sym.scopeID);
        assertEquals(LangSymbol.SymbolType.Variable_Class, myVar_Sym.symbolType);
        assertEquals(false, myVar_Sym.isComplexType());
        assertEquals(myClass_Symbol, myVar_Sym.getParentSymbol());


        // skipping myVar2 - the stmt is only there to test a lookup of myVar, which we just did.


        String myInteger_Name = "myInteger";
        String myInteger_ClassType = "java.lang.Integer";
        variable_TypeUsageInfo = new TypeUsageInfo(myInteger_ClassType, symbolTable_File, symbolTable_File.lookup_Type_InScope(),
                                                    symbolTable_App.typeUsageInfoList_FullTypesToBeResolved);
        LangSymbol_Variable.createSymbol__Variable(myInteger_Name, LangSymbol.SymbolType.Variable_Class, variable_TypeUsageInfo,
                myClass_Symbol, null, symbolTable_File, LangSymbol.SymbolModifier.Access_Private);

        LangSymbol_Variable myInteger_Sym = (LangSymbol_Variable)symbolTable_File.lookup_Var(myInteger_Name);

        assertEquals(myInteger_Name, myInteger_Sym.name);
        assertEquals(ExpectedClassScopeID, myInteger_Sym.scopeID);
        assertEquals(LangSymbol.SymbolType.Variable_Class, myInteger_Sym.symbolType);
        assertEquals(true, myInteger_Sym.isComplexType());
        assertEquals(myInteger_ClassType, myInteger_Sym.getActualUsage());
        assertEquals(myClass_Symbol, myInteger_Sym.getParentSymbol());


        // skipping myInteger2 - the stmt is only there to test a lookup of myInteger, which we just did.




        //  Create Method symbols ___________________________________________________________________________________________________
        String myMethod_Name = "myMethod";

        // public short myMethod(MyContainer<MyItem> myContainer, int myInt)

        TypeUsageInfo returnType_TypeUsageInfo = new TypeUsageInfo(LangSymbol.PrimitiveType.Short, symbolTable_File, myClass_Symbol,
                symbolTable_App.getTypeUsageInfoList_FullTypesToBeResolved());

        LangSymbol_Method myMethod_Symbol = LangSymbol_Method.createSymbol__Method(myMethod_Name, myClass_Symbol, returnType_TypeUsageInfo, false, 
                null, symbolTable_File, LangSymbol.SymbolModifier.Access_Public);


        assertEquals(myClass_Symbol, myMethod_Symbol.getParentType());
        assertEquals(1, myMethod_Symbol.scopeID);
        

        
        String myContainer_ParamName = "myContainer";
        String myContainer_ClassTypeString = "MyContainer<MyItem>";
        variable_TypeUsageInfo = new TypeUsageInfo(myContainer_ClassTypeString, symbolTable_File, symbolTable_File.lookup_Type_InScope(),
                                                    symbolTable_App.typeUsageInfoList_FullTypesToBeResolved);
        LangSymbol_Method.createSymbol__MethodParameter(myContainer_ParamName, variable_TypeUsageInfo, myMethod_Symbol,
                null, symbolTable_File);
        
        String myInt_ParamName = "myInt";
        variable_TypeUsageInfo = new TypeUsageInfo(LangSymbol.PrimitiveType.Int, symbolTable_File, symbolTable_File.lookup_Type_InScope(),
                                                    symbolTable_App.typeUsageInfoList_FullTypesToBeResolved);
        LangSymbol_Method.createSymbol__MethodParameter(myInt_ParamName, variable_TypeUsageInfo, myMethod_Symbol,
                null, symbolTable_File);


        // myMethod() scope body, scope id should be '2'
        // ***  IMPORTANT ***  the push of the new scope should happen AFTER the method params have been created
        // eventhough, the scope of the method params is that of the method body!!
        final int MyMethod_ExpectedScopeId = 2;
        symbolTable_File.scopeStack.push_Method_Scope(false);


        assertEquals(MyMethod_ExpectedScopeId, symbolTable_File.scopeStack.viewCurrentScope().scope_Id);
        assertEquals(LangSymbolScopeStack.ClosedStackState.Method, symbolTable_File.scopeStack.viewCurrentScope().closedStackState);
        assertEquals(MyMethod_ExpectedScopeId, symbolTable_File.scopeStack.getCurrScopeID_for_ClassOrMethod_ScopeBoundary());

        //  Create local method vars _________________________________________________________


        String myShort_Name = "myShort";
        variable_TypeUsageInfo = new TypeUsageInfo(LangSymbol.PrimitiveType.Short, symbolTable_File, symbolTable_File.lookup_Type_InScope(),
                                                    symbolTable_App.typeUsageInfoList_FullTypesToBeResolved);
        LangSymbol_Variable.createSymbol__Variable(myShort_Name, LangSymbol.SymbolType.Variable_Local, variable_TypeUsageInfo,
                myMethod_Symbol, null, symbolTable_File);



        //  Test method params and local vars

        LangSymbol_Variable myContainer_Param = (LangSymbol_Variable)symbolTable_File.lookup_Var(myContainer_ParamName);

        assertEquals(myContainer_ParamName, myContainer_Param.name);
        assertEquals(MyMethod_ExpectedScopeId, myContainer_Param.scopeID);
        assertEquals(myMethod_Symbol, myContainer_Param.getParentSymbol());
        
        LangSymbol_Variable myInt_Param = (LangSymbol_Variable)symbolTable_File.lookup_Var(myInt_ParamName);

        assertEquals(myInt_ParamName, myInt_Param.name);
        assertEquals(MyMethod_ExpectedScopeId, myInt_Param.scopeID);
        assertEquals(myMethod_Symbol, myInt_Param.getParentSymbol());


        LangSymbol_Variable myShort_Sym = (LangSymbol_Variable)symbolTable_File.lookup_Var(myShort_Name);

        assertEquals(myShort_Name, myShort_Sym.name);
        assertEquals(MyMethod_ExpectedScopeId, myShort_Sym.scopeID);
        assertEquals(myMethod_Symbol, myShort_Sym.getParentSymbol());

        assertEquals(ExpectedClassScopeID, myMethod_Symbol.scopeID);


        //  Test you can access a class field from this method's scope:
        myInteger_Sym = (LangSymbol_Variable)symbolTable_File.lookup_Var(myInteger_Name);

        assertEquals(myInteger_Name, myInteger_Sym.name);
        assertEquals(ExpectedClassScopeID, myInteger_Sym.scopeID);



        //  Create for block _____________________________________________
        //  Used to test the getCurrScopeID_for_ClassOrMethod_ScopeBoundary() method. Should be the scope ID of the method, NOT the for block
        final int ForBlock_ExpectedScopeID = 3;
        symbolTable_File.scopeStack.push_NonClassOrMethod_Scope(); // for block, scope id should be '3'
        assertEquals(ForBlock_ExpectedScopeID, symbolTable_File.scopeStack.viewCurrentScope().scope_Id);
        assertEquals(MyMethod_ExpectedScopeId, symbolTable_File.scopeStack.getCurrScopeID_for_ClassOrMethod_ScopeBoundary());

        //  Test the matrix access symboltable:
        boolean containsMatrixAccess = symbolTable_File.matrixAccess_SymbolTableFile.contains_MatrixAccesses_atMethodScope(MyMethod_ExpectedScopeId);
        assertFalse(containsMatrixAccess);
        symbolTable_File.matrixAccess_SymbolTableFile.addMatrixAccess("MyMatrix->descritptor:>field", ExpectedClassScopeID);

        containsMatrixAccess = symbolTable_File.matrixAccess_SymbolTableFile.contains_MatrixAccesses_atMethodScope(MyMethod_ExpectedScopeId);
        assertTrue(containsMatrixAccess);

        symbolTable_File.scopeStack.popCurrentScope();

        //  End Create for block _________________________________________


        //  pop the method scope
        symbolTable_File.scopeStack.popCurrentScope();
        //  should be back in class scope
        assertEquals(ExpectedClassScopeID, symbolTable_File.scopeStack.viewCurrentScope().scope_Id);




        //  Create Overloaded method call ______________________________________________________________________________
        // public short myMethod(MyContainer<MyItem> myContainer)

        returnType_TypeUsageInfo = new TypeUsageInfo(LangSymbol.PrimitiveType.Short, symbolTable_File, myClass_Symbol,
                symbolTable_App.getTypeUsageInfoList_FullTypesToBeResolved());
        LangSymbol_Method myMethod_Symbol_Overloaded = LangSymbol_Method.createSymbol__Method(myMethod_Name, myClass_Symbol, 
                returnType_TypeUsageInfo, false, null, symbolTable_File, LangSymbol.SymbolModifier.Access_Public);


        variable_TypeUsageInfo = new TypeUsageInfo(myContainer_ClassTypeString, symbolTable_File, symbolTable_File.lookup_Type_InScope(),
                                                    symbolTable_App.typeUsageInfoList_FullTypesToBeResolved);
        LangSymbol_Method.createSymbol__MethodParameter(myContainer_ParamName, variable_TypeUsageInfo, myMethod_Symbol_Overloaded, 
                null, symbolTable_File);

        assertEquals(ExpectedClassScopeID, myMethod_Symbol_Overloaded.scopeID);


        // ***  IMPORTANT ***  the push of the new scope should happen AFTER the method params have been created
        // eventhough, the scope of the method params is that of the method body!!
        symbolTable_File.scopeStack.push_Method_Scope(false); // myMethod()scope, scope id should be '4'


        final int MyMethodOverloaded_Body__ExpectedScopeID = 4;
        assertEquals(MyMethodOverloaded_Body__ExpectedScopeID, symbolTable_File.scopeStack.viewCurrentScope().scope_Id);
        assertEquals(3, symbolTable_File.scopeStack.getScopeStack().size());




        //  Create local method vars _________________________________________________________

        //  Test method params and local vars

        myContainer_Param = (LangSymbol_Variable)symbolTable_File.lookup_Var(myContainer_ParamName);

        assertEquals(myContainer_ParamName, myContainer_Param.name);
        assertEquals(MyMethodOverloaded_Body__ExpectedScopeID, myContainer_Param.scopeID);


        symbolTable_File.scopeStack.popCurrentScope();
        //  should be back in class scope
        assertEquals(ExpectedClassScopeID, symbolTable_File.scopeStack.viewCurrentScope().scope_Id);



        //  Lookup Method. First, create method call params list  _________________________

        LangSymbol_Variable[] methodCall_ParamSymbols = new LangSymbol_Variable[2];
        LangSymbol_Variable myContainer_ParamCallValue = LangSymbol_Method.createSymbol__MethodParameter_ComplexType__Unregistered(
                myContainer_ParamName, myContainer_ClassTypeString, null);
        LangSymbol_Variable myInt_ParamCallValue = LangSymbol_Method.createSymbol__MethodParameter_PrimitiveType__Unregistered(
                myInt_ParamName, LangSymbol.PrimitiveType.Int, null);

        methodCall_ParamSymbols[0] = myContainer_ParamCallValue;
        methodCall_ParamSymbols[1] = myInt_ParamCallValue;


        List<LangSymbol> myMethod_Overloaded_MethodSymbols = symbolTable_File.lookup_Method(myMethod_Name);
        assertEquals(2, myMethod_Overloaded_MethodSymbols.size());
        
        LangSymbol_Method myMethod_Symbol_Found = symbolTable_File.lookup_Method(myMethod_Name, methodCall_ParamSymbols);

        //  these should be the same objects
        assertTrue(myMethod_Symbol == myMethod_Symbol_Found);


        //  try looking up the overloaded call
        methodCall_ParamSymbols = new LangSymbol_Variable[1];
        methodCall_ParamSymbols[0] = myContainer_ParamCallValue;


        myMethod_Symbol_Found = symbolTable_File.lookup_Method(myMethod_Name, methodCall_ParamSymbols);

        //  these should be the same objects
        assertTrue(myMethod_Symbol_Overloaded == myMethod_Symbol_Found);

    }


}
