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

package net.unconventionalthinking.hierarchy.compileractions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import net.unconventionalthinking.hierarchy.grammar.analysis.*;
import net.unconventionalthinking.hierarchy.grammar.node.*;
import net.unconventionalthinking.hierarchy.langsymboltable.ExceptRuntime_LangSymbolTable;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbolMatrix_AnnotationHandler;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbolTable_App;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbolTable_File;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol_Method;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol_Type;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;






/**
 * The purpose of this class is to give a class that inherits from it a File Symbol Table. It automatically pushes and pops scope on to the
 * stack when needed.
 *
 * @author peterjoh
 */

public abstract class LangSymbolTableActions__FileSymTableClient extends DepthFirstAdapter {

    protected String                    fileName;

    protected LangSymbolTable_File      symbolTable_File;
    protected int                       typeNestingLevel;

    protected boolean                   fileSymbolTable_Enabled;

    /** To pass values around from action to action, use an object hash. Child classes should not use the hash to pass around values.
     * The reason is because the main child class for this client is the HierarchyActions, and it
     * should not use a second method to pass around values (it already uses the "Compiler Methods" concept to pass local vars and 
     * return values). */
    Map<String, Object>                 symTableActions_ObjectHash;

    HierarchySettings                   hierarchySettings;

    /** This constructor is for the metacompiler phase when the symbols are collected. */
    public LangSymbolTableActions__FileSymTableClient(String fileName, boolean fileSymbolTable_Enabled, HierarchySettings hierarchySettings) {

        symbolTable_File = new LangSymbolTable_File(hierarchySettings);
        construct_Finish(fileSymbolTable_Enabled, fileName, hierarchySettings);
    }



    /**
     * This constructor is for either:
     * 1. the metacompiler phase when the symbols are collected.
     * 2. The metacompiler phase after the symbols are collected, and you're metacompiling a file that uses
     * a created symbolTable_File. This constructor will search the symbolTable_App for it's symbolTable_File.
     */
    public LangSymbolTableActions__FileSymTableClient(MetaCompilation_Phase metaCompilation_Phase, 
            String fileName, String srcFile_FullTypeName, LangSymbolTable_App langSymbolTable_App, boolean fileSymbolTable_Enabled,
            HierarchySettings hierarchySettings) {


        if (metaCompilation_Phase == MetaCompilation_Phase.Collecting_LangSymbols) {
            symbolTable_File = new LangSymbolTable_File(hierarchySettings);

        } else { // The metacompiler phase when you're metacompiling a file that uses a created symbolTable_File.
            symbolTable_File = langSymbolTable_App.get_SymbolTableFile_forType__byFullTypeName(srcFile_FullTypeName);

            if (symbolTable_File == null)
                throw new ExceptRuntime_LangSymbolTable("Could not find the file symbol-table for the file," + srcFile_FullTypeName + ".");

            // need to remove all the scope's that were added during the symbol creation phase
            symbolTable_File.scopeStack.reset();
        }

        construct_Finish(fileSymbolTable_Enabled, fileName, hierarchySettings);
    }

    public final void construct_Finish(boolean fileSymbolTable_Enabled, String fileName, HierarchySettings hierarchySettings) {
        this.fileSymbolTable_Enabled = fileSymbolTable_Enabled;

        typeNestingLevel = 0;
        if (fileSymbolTable_Enabled)
            symbolTable_File.scopeStack.push_Global_Scope(); // push the global scope on to the stack

        this.fileName = fileName;

        symTableActions_ObjectHash = new HashMap<String, Object>();

        this.hierarchySettings = hierarchySettings;

    }



    public void setFileSymbolTable_Enabled(boolean fileSymbolTable_Enabled) { this.fileSymbolTable_Enabled = fileSymbolTable_Enabled; }


    
    public LangSymbolTable_File getSymbolTable_File() { return symbolTable_File; }
    public boolean              isFileSymbolTable_Enabled() { return fileSymbolTable_Enabled; }
    public int                  getTypeNestingLevel() { return typeNestingLevel; }




	//  ______________________________________________________________________________________________________________________________________________
    //
    //    LangSymbol Related Helper Methods (most are called by child classes to add symbols that can't be added using the actions of this
    //    parent class.
	//  ______________________________________________________________________________________________________________________________________________

    /**
     * Add an annotation handler symbol for the current method scope
     */
    protected void addLangSymbol_AnnotationsHandler() {
        LangSymbol_Method method_LangSymbol = symbolTable_File.lookup_Method_InScope();

        LangSymbolMatrix_AnnotationHandler.createSymbol__Matrix_AnnotationHandler(method_LangSymbol.name, method_LangSymbol, null,
                symbolTable_File);
    }

    

	//  ______________________________________________________________________________________________________________________________________________
    //
    //    Type-Declaration Related Productions
	//  ______________________________________________________________________________________________________________________________________________


    @Override
    public void inANormalClassDeclaration(ANormalClassDeclaration node) {
        defaultIn(node);
        
        String className = node.getIdentifier().toString();
        symTableActions_ObjectHash.put(LangSymbolTableActions__FileSymTableClient_ObjectHash_Keys.ClassName, className);

        typeNestingLevel++;
    }
    @Override
    public void outANormalClassDeclaration(ANormalClassDeclaration node) {
        defaultOut(node);

        typeNestingLevel--;
    }



    @Override
    public void inAClassBody(AClassBody node) {
        defaultIn(node);
        String className = (String)symTableActions_ObjectHash.get(LangSymbolTableActions__FileSymTableClient_ObjectHash_Keys.ClassName);

        if (fileSymbolTable_Enabled) {

            // if this is the outer most Type, the scope is closed. If it's an inner Type, then it should be able to access out class vars.
            // But, if it's a static inner type, then its also closed scope
            boolean is_NonStatic = false;  // TODO - need to pass this value in
            boolean is_NonStatic_InnerClass = typeNestingLevel > 1 && is_NonStatic;
            symbolTable_File.scopeStack.push_Class_Scope(is_NonStatic_InnerClass);
            if (hierarchySettings.debug_ScopeStack)
                System.out.println("    class name: " + className);
        }
    }
    @Override
    public void outAClassBody(AClassBody node) {
        defaultOut(node);

        if (fileSymbolTable_Enabled)
            symbolTable_File.scopeStack.popCurrentScope();
    }



    @Override
    public void inAInterfaces(AInterfaces node) {
        defaultIn(node);

        if (fileSymbolTable_Enabled) {
            // if this is the outer most Type, the scope is closed. If it's an inner Type, then it should be able to access out class vars.
            // But, if it's a static inner type, then its also closed scope
            boolean is_NonStatic = false;  // TODO - need to pass this value
            boolean is_NonStatic_InnerClass = typeNestingLevel > 1 && is_NonStatic;
            symbolTable_File.scopeStack.push_Class_Scope(is_NonStatic_InnerClass);
        }
    }
    @Override
    public void outAInterfaces(AInterfaces node) {
        defaultOut(node);

        if (fileSymbolTable_Enabled)
            symbolTable_File.scopeStack.popCurrentScope();
    }


    @Override
    public void inAEnumBody(AEnumBody node) {
        defaultIn(node);

        if (fileSymbolTable_Enabled) {
            // if this is the outer most Type, the scope is closed. If it's an inner Type, then it should be able to access out class vars.
            // But, if it's a static inner type, then its also closed scope
            boolean is_NonStatic = false;  // TODO - need to pass this value
            boolean is_NonStatic_InnerClass = typeNestingLevel > 1 && is_NonStatic;
            symbolTable_File.scopeStack.push_Class_Scope(is_NonStatic_InnerClass);
        }
    }
    @Override
    public void outAEnumBody(AEnumBody node) {
        defaultOut(node);

        if (fileSymbolTable_Enabled)
            symbolTable_File.scopeStack.popCurrentScope();
    }



    //  _________________________________________________________________________________________________________________________________________
    //
    //   Bodies that use the Block action (for example, methods this action)
    //  _________________________________________________________________________________________________________________________________________

    
    //   METHOD Actions ___________

    /**
     * For right now, the only thing we do in these method header actions is to get the modifiers, to determine if it's a static method or not
     */
    @Override
    public void caseAPrimitiveMethodHeader(APrimitiveMethodHeader node) {
        inAPrimitiveMethodHeader(node);

        List<PModifier> copy = new ArrayList<PModifier>(node.getModifiers());
        for(PModifier e : copy) {
            e.apply(this);
        }
        checkModifierForStatic(copy);

        if(node.getTypeParameters() != null) {
            node.getTypeParameters().apply(this);
        }
        if(node.getPrimitiveType() != null) {
            node.getPrimitiveType().apply(this);
        }

        List<PDim> copy1 = new ArrayList<PDim>(node.getDims());
        for(PDim e : copy1) {
            e.apply(this);
        }

        if(node.getMethodDeclarator() != null) {
            node.getMethodDeclarator().apply(this);
        }
        if(node.getThrows() != null) {
            node.getThrows().apply(this);
        }
        
        outAPrimitiveMethodHeader(node);
    }

    @Override
    public void caseAReferenceMethodHeader(AReferenceMethodHeader node) {
        inAReferenceMethodHeader(node);

        List<PModifier> copy = new ArrayList<PModifier>(node.getModifiers());
        for(PModifier e : copy) {
            e.apply(this);
        }
        
        checkModifierForStatic(copy);

        if(node.getTypeParameters() != null) {
            node.getTypeParameters().apply(this);
        }
        if(node.getIdentifier() != null) {
            node.getIdentifier().apply(this);
        }
        List<PAdditionalIdentifier> copy1 = new ArrayList<PAdditionalIdentifier>(node.getAdditionalIdentifiers());
        for(PAdditionalIdentifier e : copy1) {
            e.apply(this);
        }
        List<PTypeComponent> copy2 = new ArrayList<PTypeComponent>(node.getTypeComponents());
        for(PTypeComponent e : copy2) {
            e.apply(this);
        }
        if(node.getTypeArguments() != null) {
            node.getTypeArguments().apply(this);
        }
        List<PDim> copy3 = new ArrayList<PDim>(node.getDims());
        for(PDim e : copy3) {
            e.apply(this);
        }
        if(node.getMethodDeclarator() != null) {
            node.getMethodDeclarator().apply(this);
        }
        if(node.getThrows() != null) {
            node.getThrows().apply(this);
        }
        outAReferenceMethodHeader(node);
    }

    @Override
    public void caseAVoidMethodHeader(AVoidMethodHeader node)
    {
        inAVoidMethodHeader(node);
        List<PModifier> copy = new ArrayList<PModifier>(node.getModifiers());
        for(PModifier e : copy) {
            e.apply(this);
        }

        checkModifierForStatic(copy);

        if(node.getTypeParameters() != null) {
            node.getTypeParameters().apply(this);
        }
        if(node.getVoid() != null) {
            node.getVoid().apply(this);
        }
        if(node.getMethodDeclarator() != null) {
            node.getMethodDeclarator().apply(this);
        }
        if(node.getThrows() != null) {
            node.getThrows().apply(this);
        }
        outAVoidMethodHeader(node);
    }

    /**  Checks a method's modifiers to determines if a method is static or not. */
    private void checkModifierForStatic(List<PModifier> modifierList) {

        boolean isStaticMethod = false;

        for (PModifier modifier : modifierList) {
            String modifierText = modifier.toString();
            if (modifierText.trim().equals("static"))
                isStaticMethod = true;
        }
        //  isStaticMethod needs to be cleared quickly, in case there are nested method definitions in this method definition.
        symTableActions_ObjectHash.put(LangSymbolTableActions__FileSymTableClient_ObjectHash_Keys.Method_IsStatic, isStaticMethod);

    }


    @Override
    public void inAMethodDeclarator(AMethodDeclarator node) {
        defaultIn(node);
        String methodName = node.getIdentifier().toString();
        symTableActions_ObjectHash.put(LangSymbolTableActions__FileSymTableClient_ObjectHash_Keys.Method_Name, methodName);
    }

    @Override
    public void inABlockMethodBody(ABlockMethodBody node) {
        defaultIn(node);

        //  This should be cleared quickly, in the caseABlock
        symTableActions_ObjectHash.put(LangSymbolTableActions__FileSymTableClient_ObjectHash_Keys.IsMethodDefinition, true);
    }

    @Override
    public void outABlockMethodBody(ABlockMethodBody node) {
        defaultOut(node);
    }



    @Override
    public void inABlock(ABlock node) {
        defaultIn(node);

        Boolean isMethodBlock_Raw = (Boolean)symTableActions_ObjectHash.get(LangSymbolTableActions__FileSymTableClient_ObjectHash_Keys.IsMethodDefinition);
        boolean isMethodBlock = isMethodBlock_Raw != null && isMethodBlock_Raw == true;
        //  Don't forget to clear the object hash map
        symTableActions_ObjectHash.put(LangSymbolTableActions__FileSymTableClient_ObjectHash_Keys.IsMethodDefinition, null);

        Boolean isStaticMethod_Raw = (Boolean)symTableActions_ObjectHash.get(LangSymbolTableActions__FileSymTableClient_ObjectHash_Keys.Method_IsStatic);
        boolean isStaticMethod = isStaticMethod_Raw != null && isStaticMethod_Raw == true;
        //  Don't forget to clear the object hash map
        symTableActions_ObjectHash.put(LangSymbolTableActions__FileSymTableClient_ObjectHash_Keys.Method_IsStatic, null);

        String methodName = (String)symTableActions_ObjectHash.get(LangSymbolTableActions__FileSymTableClient_ObjectHash_Keys.Method_Name);

        if (fileSymbolTable_Enabled) {
            if (isMethodBlock) {
                symbolTable_File.scopeStack.push_Method_Scope(isStaticMethod);
                if (hierarchySettings.debug_ScopeStack)
                    System.out.println("    method name: " + methodName);

            } else
                symbolTable_File.scopeStack.push_NonClassOrMethod_Scope();
        }
    }

    @Override
    public void outABlock(ABlock node) {
        defaultOut(node);

        if (fileSymbolTable_Enabled)
            symbolTable_File.scopeStack.popCurrentScope();

    }



    protected Exception_MetaCompilerError checkFor_AnnotationHandlerBlock(int curr_MethodScopeId) {

        //  First, check if we even need an annotation handler block for this method. Were there any matrix accesses?
        boolean methodContains_MatrixAccesses =
                symbolTable_File.matrixAccess_SymbolTableFile.contains_MatrixAccesses_atMethodScope(curr_MethodScopeId);

        if (methodContains_MatrixAccesses) {
            //  There were matrix accesses. now, check for annotation handler
            LangSymbol_Method currMethodSymbol = symbolTable_File.lookup_Method_InScope();
            boolean methodContains_AnnotationHandler = currMethodSymbol.has_AnnotationHandler();

            if (!methodContains_AnnotationHandler) {
                return new Exception_MetaCompilerError("The method named, '" + currMethodSymbol.name + "()' has one or more matrix-access statements, but "
                        + "no annotation handler. Please add the annotation handler in.");
            }

        }
        return null;
    }




    //  _________________________________________________________________________________________________________________________________________
    //
    //   Bodies that use DON'T the Block action
    //  _________________________________________________________________________________________________________________________________________

    @Override
    public void inAConstructorBody(AConstructorBody node) {
        defaultIn(node);

        if (fileSymbolTable_Enabled) {
            symbolTable_File.scopeStack.push_Method_Scope(false);
        }
    }

    @Override
    public void outAConstructorBody(AConstructorBody node) {
        defaultOut(node);

        if (fileSymbolTable_Enabled)
            symbolTable_File.scopeStack.popCurrentScope();
    }


    @Override
    public void inASwitchBlock(ASwitchBlock node) {
        defaultIn(node);

        if (fileSymbolTable_Enabled) {
            symbolTable_File.scopeStack.push_NonClassOrMethod_Scope();
        }
    }
    @Override
    public void outASwitchBlock(ASwitchBlock node) {
        defaultOut(node);

        if (fileSymbolTable_Enabled)
            symbolTable_File.scopeStack.popCurrentScope();
    }




}


