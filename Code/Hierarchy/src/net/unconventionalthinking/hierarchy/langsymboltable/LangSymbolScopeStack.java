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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import net.unconventionalthinking.hierarchy.HierarchySettings;

/**
 *
 * @author peterjoh
 */
public class LangSymbolScopeStack {


    public enum ClosedStackState { Global, Class, NonStatic_InnerClass, Method, None }

    public static final ScopeInfo NullScopeInfo = new ScopeInfo(-99, -99, -99, ClosedStackState.Global, false);


    private LinkedList<ScopeInfo> scopeStack;
    private Map<Integer, ScopeInfo> scopeInfo_Index__byScopeId;
    private int scope_ID_counter;

    private HierarchySettings hierarchySettings;

    public LangSymbolScopeStack(HierarchySettings hierarchySettings) {
        this.scopeStack = new LinkedList<ScopeInfo>();
        this.scopeInfo_Index__byScopeId = new HashMap<Integer, ScopeInfo>();
        this.hierarchySettings = hierarchySettings;

        this.scope_ID_counter = -1;
    }


    /** Push the initial, global scope onto the stack. This is the first thing you should do when you start to process a file.
     * @return  returns new scope id, should be 0 */
    public int push_Global_Scope() { 
        if (hierarchySettings.debug_ScopeStack) System.out.print("~DSS~ pushed global scope onto stack: ");
        return pushNewScope(ClosedStackState.Global);
    }
    /** Push the scope for class (or interface or enum) or method scopes onto stack.
     * if it's a non static inner class, pass in true
     * @return  Returns the new scope id */
    public int push_Class_Scope(boolean is_NonStatic_InnerClass) {
        if (hierarchySettings.debug_ScopeStack) System.out.print("~DSS~ pushed class scope onto stack: ");
        return pushNewScope( is_NonStatic_InnerClass ? ClosedStackState.NonStatic_InnerClass : ClosedStackState.Class,
                            !is_NonStatic_InnerClass);
    }
    /** Push the scope for class (or interface or enum) or method scopes onto stack.
     * @return  Returns the new scope id */
    public int push_Method_Scope(boolean is_Static) {
        if (hierarchySettings.debug_ScopeStack) System.out.print("~DSS~ pushed method scope onto stack: ");
        return pushNewScope(ClosedStackState.Method, is_Static);
    }

    /** Push the scope for non-class (or interface or enum) or method scopes onto stack. For instance, push the scope of a 'for' or an 'if' blocks on to stack.
     * @return  Returns the new scope id */
    public int push_NonClassOrMethod_Scope() { 
        if (hierarchySettings.debug_ScopeStack) System.out.print("~DSS~ pushed non-class/method scope onto stack: ");
        return pushNewScope(ClosedStackState.None);
    }

    
    /**
     * @return  Returns the new scope id
     */
    public int pushNewScope(ClosedStackState closedStackState) {
        return pushNewScope(closedStackState, false);
    }
    /**
     * @return  Returns the new scope id
     */
    public int pushNewScope(ClosedStackState closedStackState, boolean is_Static) {
        ++scope_ID_counter;
        if (hierarchySettings.debug_ScopeStack)
            System.out.println(scope_ID_counter);

       if (closedStackState == null)
           closedStackState = ClosedStackState.None;

       //  Determine the new scope boundaries __________________________________________________________________________________________

        ScopeInfo prevScopeInfo = viewCurrentScope();
       //  the new scope's id is the classOrMethod boundary if this is Global, Class, or Method closed stack-state
       //  else, use the previous scope's boundary scope id.
       int newScopeID_for_ClassOrMethod_ScopeBoundary = (closedStackState == ClosedStackState.Global ||
               closedStackState == ClosedStackState.Class || closedStackState == ClosedStackState.Method) ?
           scope_ID_counter : prevScopeInfo.currScopeID_for_ClassOrMethod_ScopeBoundary;
       //  (similar to prev comment)
       int newScopeID_for_Method_ScopeBoundary = (closedStackState == ClosedStackState.Method) ?
           scope_ID_counter : prevScopeInfo.currScopeID_for_Method_ScopeBoundary;

       //  ______________________________________________________________________________________________________________________________

       ScopeInfo newScopeInfo = new ScopeInfo(scope_ID_counter, newScopeID_for_ClassOrMethod_ScopeBoundary, newScopeID_for_Method_ScopeBoundary,
               closedStackState, is_Static);
       scopeStack.addLast(newScopeInfo);
       scopeInfo_Index__byScopeId.put(newScopeInfo.scope_Id, newScopeInfo);

       return scope_ID_counter;
    }


    public ScopeInfo popCurrentScope() { 
        if (hierarchySettings.debug_ScopeStack) System.out.println("~DSS~ popped scope off stack: " + viewCurrentScope().scope_Id);
        return (scopeStack.size() > 0 ? scopeStack.removeLast() : null);
    }
    public ScopeInfo viewCurrentScope() { return (scopeStack.size() > 0 ? scopeStack.getLast() : NullScopeInfo); }
    public LinkedList<ScopeInfo> getScopeStack() { return scopeStack; }

    public int peekAt_NextScopeId() { return scope_ID_counter + 1; }

    /** For the current scope, get the closest method or class scope boundary (meaning, what is the scope id of the closest new class,
     * enum, interface, or method definition. */
    public int getCurrScopeID_for_ClassOrMethod_ScopeBoundary() { return viewCurrentScope().currScopeID_for_ClassOrMethod_ScopeBoundary; }
    /** For the current scope, get the closest method or class scope boundary (meaning, what is the scope id of the closest new class,
     * enum, interface, or method definition. */
    public ScopeInfo getCurrScopeInfo_for_ClassOrMethod_ScopeBoundary() {
        return scopeInfo_Index__byScopeId.get(viewCurrentScope().currScopeID_for_ClassOrMethod_ScopeBoundary);
    }

    /** For the current scope, get the closest method scope id. */
    public int getCurrScopeID_for_Method_ScopeBoundary() { return viewCurrentScope().currScopeID_for_Method_ScopeBoundary; }
    /** For the current scope, get the closest method scope Info. */
    public ScopeInfo getCurrScopeInfo_for_Method_ScopeBoundary() { return scopeInfo_Index__byScopeId.get(viewCurrentScope().currScopeID_for_Method_ScopeBoundary); }

    /** We reuse the file symbol table after the symbol creation phase. Before we reuse, we need to remove all the scopes that were created during.
     * the previous phase.
     * It's also used during testing */
    public void reset() { scopeStack.clear(); this.scope_ID_counter = -1; }



    public static class ScopeInfo {

        public ScopeInfo(int scope_Id, int currScopeID_for_ClassOrMethod_ScopeBoundary, int currScopeID_for_Method_ScopeBoundary,
                ClosedStackState closedStackState, boolean is_Static) {
            this.scope_Id = scope_Id;
            this.closedStackState = closedStackState;
            this.is_Static = is_Static;
            
            this.currScopeID_for_ClassOrMethod_ScopeBoundary = currScopeID_for_ClassOrMethod_ScopeBoundary;
            this.currScopeID_for_Method_ScopeBoundary = currScopeID_for_Method_ScopeBoundary;
        }


        public final int scope_Id;
        /** For the current scope, what is the closest method or class scope boundary (meaning, what is the scope id of the closest new class,
         * enum, interface, or method definition. */
        public final int currScopeID_for_ClassOrMethod_ScopeBoundary;
        public final int currScopeID_for_Method_ScopeBoundary;
        
        public final ClosedStackState closedStackState;

        public final boolean is_Static;
    }
}
