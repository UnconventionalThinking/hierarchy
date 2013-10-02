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

/**
 *
 * @author peterjoh
 */

import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol.PrimitiveType;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol.SymbolModifier;
import net.unconventionalthinking.hierarchy.grammar.node.*;
import java.util.LinkedList;

import net.unconventionalthinking.compiler.tools.*;
import net.unconventionalthinking.matrix.AppControl_Base;
import net.unconventionalthinking.hierarchy.Exception_HierarchyCompiler;
import net.unconventionalthinking.hierarchy.Node_ToStringProcessor;
import net.unconventionalthinking.hierarchy.HierarchyControl;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import net.unconventionalthinking.hierarchy.langsymboltable.ExceptRuntime_LangSymbolTable;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbolTable_App;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbolTable_MethodConstants;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol_Import_Package;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol_Import_Type;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol_Method;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol_Type;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol_Variable;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol_Variable_DescriptorVar;
import net.unconventionalthinking.hierarchy.langsymboltable.MatrixAccessState;
import net.unconventionalthinking.hierarchy.langsymboltable.TypeInfo;
import net.unconventionalthinking.hierarchy.langsymboltable.TypeUsageInfo;
import net.unconventionalthinking.utilities.HashTools;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import net.unconventionalthinking.hierarchy.ExceptRuntime_UnsupportedLanguageFeature;




/**
 * Why does this class extend HierarchyActions? because it needs the matrix access productions.
 *
 * @author peterjoh
 */
public class LangSymbolTableActions__SymCreator extends HierarchyActions {

    public String packageName;

    List<TypeUsageInfo>     typeUsageInfoList_FullTypesToBeResolved;
    String                  inheritedTypeName;


    LinkedList<TypeInfo>    nestedTypeInfo_Stack;
    TypeInfo                parentTypeInfo;

    

    public LangSymbolTableActions__SymCreator(AppControl_Base appControl,
            HierarchySettings hierarchySettings, String fileName, String primaryClassName, String packageName, LangSymbolTable_App symbolTable_App,
            java.util.Set<String> existing_ImportSet)
            throws Exception_HierarchyCompiler {


        super(MetaCompilation_Phase.Collecting_LangSymbols, appControl, hierarchySettings, fileName, primaryClassName, packageName,
                true, symbolTable_App, existing_ImportSet);

        nestedTypeInfo_Stack = new LinkedList<TypeInfo>();
        parentTypeInfo = null;

        this.symbolTable_App = symbolTable_App;
        this.typeUsageInfoList_FullTypesToBeResolved = symbolTable_App.getTypeUsageInfoList_FullTypesToBeResolved();

        inheritedTypeName = null;

    }

    





	//  ______________________________________________________________________________________________________________________________________________
    //
    //   Package & Import Productions
    //  ______________________________________________________________________________________________________________________________________________


    /**
     * Package Declaration
     *
     * This production is Not a generation method. It grabs the package declaration and puts it in the CodeOutput_Results
     */
    @Override
    public void inAPackageDeclaration(APackageDeclaration node) {
        super.inAPackageDeclaration(node);
        identifier_Parts.createNewIdentifier();
    }
    @Override
    public void outAPackageDeclaration(APackageDeclaration node) {
        super.outAPackageDeclaration(node);

        packageName = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
        identifier_Parts.clearParts();

        symbolTable_File.setSrcCodeFilePackage(packageName);

    }


    @Override
    public void inASingleTypeImportDeclaration(ASingleTypeImportDeclaration node) {
        defaultIn(node);

        identifier_Parts.createNewIdentifier();
    }
    @Override
    public void outASingleTypeImportDeclaration(ASingleTypeImportDeclaration node) {
        defaultOut(node);
        String importType = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
        identifier_Parts.clearParts();

        LangSymbol_Import_Type.createSymbol__ImportType(importType, -1, null, symbolTable_File);
    }


    @Override
    public void inATypeImportOnDemandDeclaration(ATypeImportOnDemandDeclaration node) {
        defaultIn(node);

        identifier_Parts.createNewIdentifier();
    }
    @Override
    public void outATypeImportOnDemandDeclaration(ATypeImportOnDemandDeclaration node) {
        defaultOut(node);

        String importPackage = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
        identifier_Parts.clearParts();

        LangSymbol_Import_Package.createSymbol__ImportPackage(importPackage, -1, null, symbolTable_File);

    }



	//  ______________________________________________________________________________________________________________________________________________
    //
    //    Type-Declaration Related Productions
	//  ______________________________________________________________________________________________________________________________________________

    @Override
    public void caseANormalClassDeclaration(ANormalClassDeclaration node)
    {
        inANormalClassDeclaration(node);

        //  Wait until you have the type name until you create the type symbol
        
        String className = null;
        List<LangSymbol.SymbolModifier> modifiers = new ArrayList<LangSymbol.SymbolModifier>();

        {
            List<PModifier> copy = new ArrayList<PModifier>(node.getModifiers());
            for(PModifier e : copy) {
                e.apply(this);

                modifiers.add(LangSymbol.SymbolModifier.getEnumForStringValue(e.toString().trim()));
            }
        }


        if(node.getClassToken() != null) {
            node.getClassToken().apply(this);
        }
        if(node.getIdentifier() != null) {
            identifier_Parts.createNewIdentifier();

            node.getIdentifier().apply(this);

            className = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
            identifier_Parts.clearParts();

        }

        //  Create Type Symbol ___________________________________________

        //  you can't add the typeInfo to the nestedTypeInfo stack until you set the name on the type info (because, set_Name uses
        //  the stack to generate the name)>
        LangSymbol_Type typeInfo =  LangSymbol_Type.createSymbol__Class(className, packageName, null, 
                symbolTable_File, false, symbolTable_App, nestedTypeInfo_Stack,
                modifiers.toArray(new LangSymbol.SymbolModifier[0]));
        typeInfo.set_TypeNestingLevel(typeNestingLevel);

        if (typeNestingLevel > 1) {
            typeInfo.set_IsNestedType(true);
        } else
            typeInfo.set_IsNestedType(false);

        typeInfo.set_Package(packageName);

        nestedTypeInfo_Stack.addLast(typeInfo);


        //  You also can't set the add_childNested Type Info until the name is set:
        if (typeNestingLevel > 1) {
            typeInfo.set_ParentTypeInfo(parentTypeInfo);
            parentTypeInfo.add_ChildNestedTypeInfo(typeInfo);
        }

        //  _______________________________________________________________

        if(node.getTypeParameters() != null) {
            node.getTypeParameters().apply(this);
        }
        if(node.getSuper() != null) {
            inheritedTypeName = null; // this will be set in the "super" production
            node.getSuper().apply(this);
            
            TypeUsageInfo inheritedType_TypeUsageInfo = new TypeUsageInfo(inheritedTypeName, symbolTable_File,
                    typeInfo, typeUsageInfoList_FullTypesToBeResolved);
            inheritedType_TypeUsageInfo.set__Is_TypeUsageFor_Inheritence(true);
            typeInfo.set_Inheritance_TypeUsageInfo(inheritedType_TypeUsageInfo);
        }
        if(node.getInterfaces() != null){
            node.getInterfaces().apply(this);
        }
        if(node.getClassBody() != null) {

            // before you process any possible nested types, set the parentTypeInfo
            parentTypeInfo = typeInfo;

            node.getClassBody().apply(this);
        }

        nestedTypeInfo_Stack.removeLast();


        outANormalClassDeclaration(node);
    }



    @Override
    public void inASuper(ASuper node) {
        defaultIn(node);

        identifier_Parts.createNewIdentifier();

    }
    @Override
    public void outASuper(ASuper node){
        defaultOut(node);

        inheritedTypeName = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
        identifier_Parts.clearParts();
    }


    /**
     * ***** INTERFACES ARE NOT CURRENTLY SUPPORTED BY THE SYMBOL CREATOR Parser ******
     */
    @Override
    public void inANormalInterfaceInterfaceDeclaration(ANormalInterfaceInterfaceDeclaration node)
    {

        throw new ExceptRuntime_UnsupportedLanguageFeature(ExceptRuntime_UnsupportedLanguageFeature.UnsupportedLanguageFeature.Intefaces,
                "Interfaces are not currently supported by the Symbol Creator Parser");
    }

    /**
     * ***** ANNOTATED INTERFACES ARE NOT CURRENTLY SUPPORTED BY THE SYMBOL CREATOR ACTION ******
     */
    @Override
    public void inAAnnotationTypeInterfaceDeclaration(AAnnotationTypeInterfaceDeclaration node)
    {
        throw new ExceptRuntime_UnsupportedLanguageFeature(ExceptRuntime_UnsupportedLanguageFeature.UnsupportedLanguageFeature.Intefaces,
                "Annotated Interfaces are not currently supported by the Symbol Creator Parser");
    }

    // ______________________________________________________________________________________________________________________________
    //
    //  Method related-productions
    //
    //  NOTE: the parent method production usually collects some info and pass it to the child method production,
    //  (typically, the method declarator production), and it actually creates the method symbol. Why? because
    //  the method name and method params are matched in the _declarator_ production, and we need to create the method symbol
    //  in between the two.
    // ______________________________________________________________________________________________________________________________

    //  Class Method Productions ____________________________________________________________________________________________________
    @Override
    public void caseAPrimitiveMethodHeader(APrimitiveMethodHeader node)
    {
        inAPrimitiveMethodHeader(node);

        MethodAttributeSet methodAttribs = node.createMethodAttributes(LangSymbolTable_MethodConstants.method_MethodHeader,
                node, hierarchyControl);


        String returnType_PrimitiveTypeString = null;
        List<LangSymbol.SymbolModifier> modifiers = new ArrayList<LangSymbol.SymbolModifier>();


        {
            List<PModifier> copy = new ArrayList<PModifier>(node.getModifiers());
            for(PModifier e : copy) {
                e.apply(this);

                // * add the modifier
                modifiers.add(LangSymbol.SymbolModifier.getEnumForStringValue(e.toString().trim()));
            }


            // * pass the info to the method declarator for further processing
            methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_Modifiers, modifiers);

        }
        if(node.getTypeParameters() != null) {
            node.getTypeParameters().apply(this);
        }

        if(node.getPrimitiveType() != null) {
            node.getPrimitiveType().apply(this);
            
            // * Get primitive type string
            returnType_PrimitiveTypeString = node.getPrimitiveType().toString().trim();
            
            LangSymbol.PrimitiveType returnType_PrimitiveType = LangSymbol.PrimitiveType.getEnumForStringValue(returnType_PrimitiveTypeString);
            // * pass the info to the method declarator for further processing
            methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_returnType_PrimitiveType, returnType_PrimitiveType);


        }

        {
            List<PDim> copy = new ArrayList<PDim>(node.getDims());
            for(PDim e : copy) {
                e.apply(this);
            }
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
    public void caseAReferenceMethodHeader(AReferenceMethodHeader node)
    {
        inAReferenceMethodHeader(node);

        MethodAttributeSet methodAttribs = node.createMethodAttributes(LangSymbolTable_MethodConstants.method_MethodHeader,
                node, hierarchyControl);

        String returnType_ActualCodeString = null;
        List<LangSymbol.SymbolModifier> modifiers = new ArrayList<LangSymbol.SymbolModifier>();



        {
            List<PModifier> copy = new ArrayList<PModifier>(node.getModifiers());
            for(PModifier e : copy) {
                e.apply(this);

                modifiers.add(LangSymbol.SymbolModifier.getEnumForStringValue(e.toString().trim()));
            }


            // * pass the info to the method declarator for further processing
            methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_Modifiers, modifiers);

        }
        if(node.getTypeParameters() != null){
            node.getTypeParameters().apply(this);
        }



        // * create new identifier
        identifier_Parts.createNewIdentifier();

        if(node.getIdentifier() != null) {
            node.getIdentifier().apply(this);
        }
        {
            List<PAdditionalIdentifier> copy = new ArrayList<PAdditionalIdentifier>(node.getAdditionalIdentifiers());
            for(PAdditionalIdentifier e : copy) {
                e.apply(this);
            }
        }


        returnType_ActualCodeString = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
        identifier_Parts.clearParts();
        // * pass the info to the method declarator for further processing
        methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_returnType_ActualCodeString, returnType_ActualCodeString);


        {
            List<PTypeComponent> copy = new ArrayList<PTypeComponent>(node.getTypeComponents());
            for(PTypeComponent e : copy) {
                e.apply(this);
            }
        }
        if(node.getTypeArguments() != null) {
            node.getTypeArguments().apply(this);
        }
        {
            List<PDim> copy = new ArrayList<PDim>(node.getDims());
            for(PDim e : copy) {
                e.apply(this);
            }
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


        MethodAttributeSet methodAttribs = node.createMethodAttributes(LangSymbolTable_MethodConstants.method_MethodHeader,
                node, hierarchyControl);


        List<LangSymbol.SymbolModifier> modifiers = new ArrayList<LangSymbol.SymbolModifier>();


        {
            List<PModifier> copy = new ArrayList<PModifier>(node.getModifiers());
            for(PModifier e : copy) {
                e.apply(this);

                // * add the modifier
                modifiers.add(LangSymbol.SymbolModifier.getEnumForStringValue(e.toString().trim()));
            }

            // * pass the info to the method declarator for further processing
            methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_Modifiers, modifiers);
        }
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



    @Override
    public void caseAMethodDeclarator(AMethodDeclarator node)
    {
        inAMethodDeclarator(node);
        MethodAttributeSet methodHeader_AttribSet = node.getMethodAttributes();


        List<LangSymbol.SymbolModifier> modifiers = (List<LangSymbol.SymbolModifier>)methodHeader_AttribSet.vars.get(
                LangSymbolTable_MethodConstants.var_Modifiers);

        LangSymbol.PrimitiveType returnType_PrimitiveType = (LangSymbol.PrimitiveType)methodHeader_AttribSet.vars.get(
                LangSymbolTable_MethodConstants.var_returnType_PrimitiveType);
        String returnType_ActualCodeString = (String)methodHeader_AttribSet.vars.get(
                LangSymbolTable_MethodConstants.var_returnType_ActualCodeString);


        
        String methodName = null;


        if(node.getIdentifier() != null) {
            identifier_Parts.createNewIdentifier();

            node.getIdentifier().apply(this);

            methodName = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
            identifier_Parts.clearParts();

        }



        // * create the method symbol _________________________________________________________

        TypeUsageInfo returnType_TypeUsageInfo = null;
        if (returnType_PrimitiveType != null)
            returnType_TypeUsageInfo = new TypeUsageInfo(returnType_PrimitiveType, symbolTable_File, symbolTable_File.lookup_Type_InScope(),
                                                        typeUsageInfoList_FullTypesToBeResolved);
        else if (returnType_ActualCodeString != null)
            returnType_TypeUsageInfo = new TypeUsageInfo(returnType_ActualCodeString, symbolTable_File, symbolTable_File.lookup_Type_InScope(),
                                                        typeUsageInfoList_FullTypesToBeResolved);
        else
            returnType_TypeUsageInfo = new TypeUsageInfo(symbolTable_File, symbolTable_File.lookup_Type_InScope(),
                                                        typeUsageInfoList_FullTypesToBeResolved); // void return type

        LangSymbol_Method method = LangSymbol_Method.createSymbol__Method(methodName, symbolTable_File.lookup_Type_InScope(), returnType_TypeUsageInfo, 
                false, null, symbolTable_File, modifiers.toArray(new LangSymbol.SymbolModifier[0]));

        //  ____________________________________________________________________________________


        if(node.getLPar() != null) {
            node.getLPar().apply(this);
        }
        if(node.getFormalParameterList() != null)
        {
            node.getFormalParameterList().apply(this);
        }
        if(node.getRPar() != null) {
            node.getRPar().apply(this);
        }
        {
            List<PDim> copy = new ArrayList<PDim>(node.getDims());
            for(PDim e : copy) {
                e.apply(this);
            }
        }
        outAMethodDeclarator(node);
    }


    //  Constructor Productions   _____________________________________

    @Override
    public void caseAConstructorDeclaration(AConstructorDeclaration node)
    {
        inAConstructorDeclaration(node);
        MethodAttributeSet methodAttribs = node.createMethodAttributes(LangSymbolTable_MethodConstants.method_MethodHeader,
                node, hierarchyControl);


        List<LangSymbol.SymbolModifier> modifiers = new ArrayList<LangSymbol.SymbolModifier>();


        {
            List<PModifier> copy = new ArrayList<PModifier>(node.getModifiers());
            for(PModifier e : copy) {
                e.apply(this);

                // * add the modifier
                modifiers.add(LangSymbol.SymbolModifier.getEnumForStringValue(e.toString().trim()));
            }
            // * pass the info to the method declarator for further processing
            methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_Modifiers, modifiers);
        }
        if(node.getConstructorDeclarator() != null) {
            node.getConstructorDeclarator().apply(this);
        }
        if(node.getThrows() != null) {
            node.getThrows().apply(this);
        }
        if(node.getConstructorBody() != null) {
            node.getConstructorBody().apply(this);
        }
        outAConstructorDeclaration(node);
    }
    @Override
    public void caseAConstructorDeclarator(AConstructorDeclarator node)
    {
        inAConstructorDeclarator(node);
        MethodAttributeSet methodHeader_AttribSet = node.getMethodAttributes();

        List<LangSymbol.SymbolModifier> modifiers = (List<LangSymbol.SymbolModifier>)methodHeader_AttribSet.vars.get(
                LangSymbolTable_MethodConstants.var_Modifiers);

        String methodName = null;

        if(node.getTypeParameters() != null) {
            node.getTypeParameters().apply(this);
        }
        if(node.getIdentifier() != null) {
            identifier_Parts.createNewIdentifier();

            node.getIdentifier().apply(this);

            methodName = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
            identifier_Parts.clearParts();
        }


        // * create the method symbol _________________________________________________________

        TypeUsageInfo returnType_TypeUsageInfo = returnType_TypeUsageInfo = new TypeUsageInfo(symbolTable_File, symbolTable_File.lookup_Type_InScope(),
                                                        typeUsageInfoList_FullTypesToBeResolved); // void return type

        LangSymbol_Method method = LangSymbol_Method.createSymbol__Method(methodName, symbolTable_File.lookup_Type_InScope(),
                returnType_TypeUsageInfo, false, null, symbolTable_File, modifiers.toArray(new LangSymbol.SymbolModifier[0]));

        //  ____________________________________________________________________________________


        if(node.getLPar() != null) {
            node.getLPar().apply(this);
        }
        if(node.getFormalParameterList() != null) {
            node.getFormalParameterList().apply(this);
        }
        if(node.getRPar() != null) {
            node.getRPar().apply(this);
        }
        outAConstructorDeclarator(node);
    }







	//  ______________________________________________________________________________________________________________________________________________
    //
    //    Variable-Declaration Related Productions
	//  ______________________________________________________________________________________________________________________________________________




	//  Field Declaration Productions
	//  _____________________________________________________________________________

    @Override
    public void caseAPrimitiveFieldDeclaration(APrimitiveFieldDeclaration node) {
        inAPrimitiveFieldDeclaration(node);

        MethodAttributeSet methodAttribs = node.createMethodAttributes(LangSymbolTable_MethodConstants.method_FieldDeclaration,
                node, hierarchyControl);

        List<LangSymbol.SymbolModifier> modifiers = new ArrayList<LangSymbol.SymbolModifier>();
        String primitiveType_String = null;
        LangSymbol.PrimitiveType primitiveType = null;

        {
            List<PModifier> copy = new ArrayList<PModifier>(node.getModifiers());
            for(PModifier e : copy) {
                e.apply(this);

                // * add the modifier
                modifiers.add(LangSymbol.SymbolModifier.getEnumForStringValue(e.toString().trim()));
            }
        }
        if(node.getPrimitiveType() != null) {
            node.getPrimitiveType().apply(this);


            // * Get primitive type string
            primitiveType_String = node.getPrimitiveType().toString().trim();
            primitiveType = LangSymbol.PrimitiveType.getEnumForStringValue(primitiveType_String);
        }
        {
            List<PDim> copy = new ArrayList<PDim>(node.getDims());
            for(PDim e : copy) {
                e.apply(this);
            }
        }

        
        // * pass the info to the variable declarator for further processing _________________________________________________

        methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_variable_SymbolType, LangSymbol.SymbolType.Variable_Class);
        methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_Modifiers, modifiers);
        methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_variable_PrimitiveType, primitiveType);
        // ____________________________________________________________________________________________________________________


        if(node.getVariableDeclarators() != null) {
            node.getVariableDeclarators().apply(this);
        }
        if(node.getSemi() != null) {
            node.getSemi().apply(this);
        }
        outAPrimitiveFieldDeclaration(node);
    }


    @Override
    public void caseAReferenceFieldDeclaration(AReferenceFieldDeclaration node) {
        inAReferenceFieldDeclaration(node);

        MethodAttributeSet methodAttribs = node.createMethodAttributes(LangSymbolTable_MethodConstants.method_FieldDeclaration,
                node, hierarchyControl);

        List<LangSymbol.SymbolModifier> modifiers = new ArrayList<LangSymbol.SymbolModifier>();
        String variableType_ActualCodeString = null;


        {
            List<PModifier> copy = new ArrayList<PModifier>(node.getModifiers());
            for(PModifier e : copy) {
                e.apply(this);

                // * add the modifier
                modifiers.add(LangSymbol.SymbolModifier.getEnumForStringValue(e.toString().trim()));
            }
        }
        // * Get type string
        identifier_Parts.createNewIdentifier();
        if(node.getIdentifier() != null) {
            node.getIdentifier().apply(this);
        }
        {
            List<PAdditionalIdentifier> copy = new ArrayList<PAdditionalIdentifier>(node.getAdditionalIdentifiers());
            for(PAdditionalIdentifier e : copy) {
                e.apply(this);
            }
        }
        variableType_ActualCodeString = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
        identifier_Parts.clearParts();

        {
            List<PTypeComponent> copy = new ArrayList<PTypeComponent>(node.getTypeComponents());
            for(PTypeComponent e : copy) {
                e.apply(this);
            }
        }
        if(node.getTypeArguments() != null) {
            node.getTypeArguments().apply(this);
        }
        {
            List<PDim> copy = new ArrayList<PDim>(node.getDims());
            for(PDim e : copy) {
                e.apply(this);
            }
        }


        // * pass the info to the variable declarator for further processing _________________________________________________

        methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_variable_SymbolType, LangSymbol.SymbolType.Variable_Class);
        methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_Modifiers, modifiers);
        methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_variableType_ActualCodeString, variableType_ActualCodeString);
        // ____________________________________________________________________________________________________________________


        if(node.getVariableDeclarators() != null) {
            node.getVariableDeclarators().apply(this);
        }
        if(node.getSemi() != null) {
            node.getSemi().apply(this);
        }
        outAReferenceFieldDeclaration(node);
    }




    @Override
    public void caseAMjDescVarFieldDeclaration(AMjDescVarFieldDeclaration node) {
        inAMjDescVarFieldDeclaration(node);

        MethodAttributeSet methodAttribs = node.createMethodAttributes(LangSymbolTable_MethodConstants.method_FieldDeclaration,
                node, hierarchyControl);

        List<LangSymbol.SymbolModifier> modifiers = new ArrayList<LangSymbol.SymbolModifier>();

        String variableType_ActualCodeString = null;


        //  Get the matrix access state  _______________________________________________
        
        if(node.getDescriptorVariableType() != null) {
            node.getDescriptorVariableType().apply(this);
        }

        //  The actual code string of the DESCRIPTOR var with access type if it exists
        variableType_ActualCodeString = node.getDescriptorVariableType().toString_ProcessCurrent().trim();

        MatrixAccessState matrixAccessState = (MatrixAccessState)hierarchyControl.returnValues_getMap_for(
                HierarchyMethodConstants.method_Process_DescriptorVarDeclaration).get(HierarchyMethodConstants.retVal_MatrixAccessState);

        methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_MatrixAccessState, matrixAccessState);

        // don't forget to clear the method call values passed _to_ the method and the returnvalues passed _from_ the method
        methodAttribs.methodCall_ClearAllValues();
        hierarchyControl.returnValues_clearMap_for(HierarchyMethodConstants.method_Process_DescriptorVarDeclaration);

        //  _______________________________________________




        // * pass the info to the variable declarator for further processing _________________________________________________

        methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_variable_SymbolType, LangSymbol.SymbolType.Variable_Class);
        methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_Modifiers, modifiers);
        methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_variableType_ActualCodeString, variableType_ActualCodeString);
        methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_variable_IsDescriptorVar, new Boolean(true));
        // ____________________________________________________________________________________________________________________


        if(node.getVariableDeclarators() != null) {
            node.getVariableDeclarators().apply(this);
        }
        if(node.getSemi() != null) {
            node.getSemi().apply(this);
        }
        outAMjDescVarFieldDeclaration(node);
    }




	//  Local Variable Declaration Productions
	//  _____________________________________________________________________________

    @Override
    public void caseAPrimitiveLocalVariableDeclaration(APrimitiveLocalVariableDeclaration node) {
        inAPrimitiveLocalVariableDeclaration(node);

        MethodAttributeSet methodAttribs = node.createMethodAttributes(LangSymbolTable_MethodConstants.method_LocalVarDeclaration,
                node, hierarchyControl);

        List<LangSymbol.SymbolModifier> modifiers = new ArrayList<LangSymbol.SymbolModifier>();
        String primitiveType_String = null;
        LangSymbol.PrimitiveType primitiveType = null;

        {
            List<PModifier> copy = new ArrayList<PModifier>(node.getModifiers());
            for(PModifier e : copy) {
                e.apply(this);

                // * add the modifier
                modifiers.add(LangSymbol.SymbolModifier.getEnumForStringValue(e.toString().trim()));
            }
        }
        if(node.getPrimitiveType() != null) {
            node.getPrimitiveType().apply(this);

            // * Get primitive type string
            primitiveType_String = node.getPrimitiveType().toString().trim();
            primitiveType = LangSymbol.PrimitiveType.getEnumForStringValue(primitiveType_String);
        }
        {
            List<PDim> copy = new ArrayList<PDim>(node.getDims());
            for(PDim e : copy) {
                e.apply(this);
            }
        }


        // * pass the info to the variable declarator for further processing _________________________________________________

        methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_variable_SymbolType, LangSymbol.SymbolType.Variable_Local);
        methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_Modifiers, modifiers);
        methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_variable_PrimitiveType, primitiveType);
        // ____________________________________________________________________________________________________________________


        if(node.getVariableDeclarators() != null) {
            node.getVariableDeclarators().apply(this);
        }
        outAPrimitiveLocalVariableDeclaration(node);
    }




    @Override
    public void caseAReferenceLocalVariableDeclaration(AReferenceLocalVariableDeclaration node) {
        inAReferenceLocalVariableDeclaration(node);


        MethodAttributeSet methodAttribs = node.createMethodAttributes(LangSymbolTable_MethodConstants.method_LocalVarDeclaration,
                node, hierarchyControl);

        List<LangSymbol.SymbolModifier> modifiers = new ArrayList<LangSymbol.SymbolModifier>();
        String variableType_ActualCodeString = null;
        String fieldName = null;

        {
            List<PModifier> copy = new ArrayList<PModifier>(node.getModifiers());
            for(PModifier e : copy) {
                e.apply(this);

                // * add the modifier
                modifiers.add(LangSymbol.SymbolModifier.getEnumForStringValue(e.toString().trim()));
            }
        }

        // * Get type string
        identifier_Parts.createNewIdentifier();
        if(node.getIdentifier() != null) {
            node.getIdentifier().apply(this);
        }
        {
            List<PAdditionalIdentifier> copy = new ArrayList<PAdditionalIdentifier>(node.getAdditionalIdentifiers());
            for(PAdditionalIdentifier e : copy) {
                e.apply(this);
            }
        }
        variableType_ActualCodeString = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
        identifier_Parts.clearParts();
        {
            List<PTypeComponent> copy = new ArrayList<PTypeComponent>(node.getTypeComponents());
            for(PTypeComponent e : copy) {
                e.apply(this);
            }
        }
        if(node.getTypeArguments() != null) {
            node.getTypeArguments().apply(this);
        }
        {
            List<PDim> copy = new ArrayList<PDim>(node.getDims());
            for(PDim e : copy) {
                e.apply(this);
            }
        }


        // * pass the info to the variable declarator for further processing _________________________________________________

        methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_variable_SymbolType, LangSymbol.SymbolType.Variable_Local);
        methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_Modifiers, modifiers);
        methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_variableType_ActualCodeString, variableType_ActualCodeString);
        // ____________________________________________________________________________________________________________________

        if(node.getVariableDeclarators() != null) {
            node.getVariableDeclarators().apply(this);
        }
        outAReferenceLocalVariableDeclaration(node);
    }



    @Override
    public void caseAMjDescVarLocalVariableDeclaration(AMjDescVarLocalVariableDeclaration node)
    {
        inAMjDescVarLocalVariableDeclaration(node);

        MethodAttributeSet methodAttribs = node.createMethodAttributes(LangSymbolTable_MethodConstants.method_LocalVarDeclaration,
                node, hierarchyControl);

        List<LangSymbol.SymbolModifier> modifiers = new ArrayList<LangSymbol.SymbolModifier>();

        String variableType_ActualCodeString = null;


        //  Get the matrix access state  _______________________________________________

        //  These productions can call generate_MatrixAccess()
        if(node.getDescriptorVariableType() != null) {
            node.getDescriptorVariableType().apply(this);
        }

        //  The actual code string of the DESCRIPTOR var with access type if it exists
        variableType_ActualCodeString = node.getDescriptorVariableType().toString_ProcessCurrent().trim();

        MatrixAccessState matrixAccessState = (MatrixAccessState)hierarchyControl.returnValues_getMap_for(
                HierarchyMethodConstants.method_Process_DescriptorVarDeclaration).get(HierarchyMethodConstants.retVal_MatrixAccessState);

        methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_MatrixAccessState, matrixAccessState);

        // don't forget to clear the method call values passed _to_ the method and the returnvalues passed _from_ the method
        methodAttribs.methodCall_ClearAllValues();
        hierarchyControl.returnValues_clearMap_for(HierarchyMethodConstants.method_Process_DescriptorVarDeclaration);

        //  _______________________________________________




        // * pass the info to the variable declarator for further processing _________________________________________________

        methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_variable_SymbolType, LangSymbol.SymbolType.Variable_Local);
        methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_Modifiers, modifiers);
        methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_variableType_ActualCodeString, variableType_ActualCodeString);
        methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_variable_IsDescriptorVar, new Boolean(true));
        // ____________________________________________________________________________________________________________________



        if(node.getVariableDeclarators() != null) {
            node.getVariableDeclarators().apply(this);
        }
        outAMjDescVarLocalVariableDeclaration(node);
    }






	//  Method Parameter Declaration Productions
	//  _____________________________________________________________________________


    @Override
    public void caseAPrimitiveFormalParameter(APrimitiveFormalParameter node) {
        inAPrimitiveFormalParameter(node);

        MethodAttributeSet methodAttribs = node.createMethodAttributes(LangSymbolTable_MethodConstants.method_MethodParamDeclaration,
                node, hierarchyControl);

        List<LangSymbol.SymbolModifier> modifiers = new ArrayList<LangSymbol.SymbolModifier>();
        String primitiveType_String = null;
        LangSymbol.PrimitiveType primitiveType = null;

        {
            List<PModifier> copy = new ArrayList<PModifier>(node.getModifiers());
            for(PModifier e : copy) {
                e.apply(this);

                // * add the modifier
                modifiers.add(LangSymbol.SymbolModifier.getEnumForStringValue(e.toString().trim()));
            }
        }
        if(node.getPrimitiveType() != null) {
            node.getPrimitiveType().apply(this);

            // * Get primitive type string
            primitiveType_String = node.getPrimitiveType().toString().trim();
            primitiveType = LangSymbol.PrimitiveType.getEnumForStringValue(primitiveType_String);
        }
        {
            List<PDim> copy = new ArrayList<PDim>(node.getDims1());
            for(PDim e : copy) {
                e.apply(this);
            }
        }


        identifier_Parts.createNewIdentifier();
        if(node.getIdentifier() != null) {
            node.getIdentifier().apply(this);
        }
        {
            List<PDim> copy = new ArrayList<PDim>(node.getDims2());
            for(PDim e : copy) {
                e.apply(this);
            }
        }
        String variableName = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
        identifier_Parts.clearParts();

        create_VariableSymbol(variableName, LangSymbol.SymbolType.Variable_MethodParameter, modifiers, primitiveType, null);

        
        outAPrimitiveFormalParameter(node);
    }




    @Override
    public void caseAReferenceFormalParameter(AReferenceFormalParameter node) {
        inAReferenceFormalParameter(node);


        MethodAttributeSet methodAttribs = node.createMethodAttributes(LangSymbolTable_MethodConstants.method_MethodParamDeclaration,
                node, hierarchyControl);

        List<LangSymbol.SymbolModifier> modifiers = new ArrayList<LangSymbol.SymbolModifier>();
        String variableType_ActualCodeString = null;

        {
            List<PModifier> copy = new ArrayList<PModifier>(node.getModifiers());
            for(PModifier e : copy) {
                e.apply(this);

                // * add the modifier
                modifiers.add(LangSymbol.SymbolModifier.getEnumForStringValue(e.toString().trim()));
            }
        }

        // * Get type string
        identifier_Parts.createNewIdentifier();
        if(node.getIdentifier1() != null) {
            node.getIdentifier1().apply(this);
        }
        {
            List<PAdditionalIdentifier> copy = new ArrayList<PAdditionalIdentifier>(node.getAdditionalIdentifiers());
            for(PAdditionalIdentifier e : copy) {
                e.apply(this);
            }
        }
        variableType_ActualCodeString = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
        identifier_Parts.clearParts();

        {
            List<PTypeComponent> copy = new ArrayList<PTypeComponent>(node.getTypeComponents());
            for(PTypeComponent e : copy) {
                e.apply(this);
            }
        }
        if(node.getTypeArguments() != null) {
            node.getTypeArguments().apply(this);
        }
        {
            List<PDim> copy = new ArrayList<PDim>(node.getDims1());
            for(PDim e : copy) {
                e.apply(this);
            }
        }


        identifier_Parts.createNewIdentifier();
        if(node.getIdentifier2() != null) {
            node.getIdentifier2().apply(this);
        }
        {
            List<PDim> copy = new ArrayList<PDim>(node.getDims2());
            for(PDim e : copy)
            {
                e.apply(this);
            }
        }
        String variableName = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
        identifier_Parts.clearParts();


        create_VariableSymbol(variableName, LangSymbol.SymbolType.Variable_MethodParameter, modifiers, null, variableType_ActualCodeString);

        outAReferenceFormalParameter(node);
    }




    @Override
    public void caseAMpDescVarFormalParameter(AMpDescVarFormalParameter node) {
        inAMpDescVarFormalParameter(node);
        MethodAttributeSet methodAttribs = node.createMethodAttributes(LangSymbolTable_MethodConstants.method_MethodParamDeclaration,
                node, hierarchyControl);

        List<LangSymbol.SymbolModifier> modifiers = new ArrayList<LangSymbol.SymbolModifier>();

        
        String variableType_ActualCodeString = null;


        //  Get the matrix access state  _______________________________________________

        //  These productions can call generate_MatrixAccess()

        if(node.getDescriptorVariableType() != null) {
            node.getDescriptorVariableType().apply(this);
        }
        //  The actual code string of the DESCRIPTOR var with access type if it exists
        variableType_ActualCodeString = node.getDescriptorVariableType().toString_ProcessCurrent().trim();

        MatrixAccessState matrixAccessState = (MatrixAccessState)hierarchyControl.returnValues_getMap_for(
                HierarchyMethodConstants.method_Process_DescriptorVarDeclaration).get(HierarchyMethodConstants.retVal_MatrixAccessState);

        methodAttribs.vars.put(LangSymbolTable_MethodConstants.var_MatrixAccessState, matrixAccessState);

        // don't forget to clear the method call values passed _to_ the method and the returnvalues passed _from_ the method
        methodAttribs.methodCall_ClearAllValues();
        hierarchyControl.returnValues_clearMap_for(HierarchyMethodConstants.method_Process_DescriptorVarDeclaration);

        //  _______________________________________________
        



        identifier_Parts.createNewIdentifier();
        if(node.getIdentifier() != null) {
            node.getIdentifier().apply(this);
        }
        String variableName = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
        identifier_Parts.clearParts();


        create_VariableSymbol(variableName, LangSymbol.SymbolType.Variable_MethodParameter, modifiers, null, variableType_ActualCodeString, 
                new Boolean(true), matrixAccessState);


        outAMpDescVarFormalParameter(node);
    }






    @Override
    public void caseAPrimitiveVarArgLastFormalParameter(APrimitiveVarArgLastFormalParameter node) {
        inAPrimitiveVarArgLastFormalParameter(node);


        MethodAttributeSet methodAttribs = node.createMethodAttributes(LangSymbolTable_MethodConstants.method_MethodLastParamDeclaration,
                node, hierarchyControl);

        List<LangSymbol.SymbolModifier> modifiers = new ArrayList<LangSymbol.SymbolModifier>();
        String primitiveType_String = null;
        LangSymbol.PrimitiveType primitiveType = null;

        {
            List<PModifier> copy = new ArrayList<PModifier>(node.getModifiers());
            for(PModifier e : copy) {
                e.apply(this);

                // * add the modifier
                modifiers.add(LangSymbol.SymbolModifier.getEnumForStringValue(e.toString().trim()));
            }
        }
        if(node.getPrimitiveType() != null) {
            node.getPrimitiveType().apply(this);

            // * Get primitive type string
            primitiveType_String = node.getPrimitiveType().toString().trim();
            primitiveType = LangSymbol.PrimitiveType.getEnumForStringValue(primitiveType_String);
        }
        {
            List<PDim> copy = new ArrayList<PDim>(node.getDims1());
            for(PDim e : copy) {
                e.apply(this);
            }

        }
        if(node.getDotDotDot() != null) {
            node.getDotDotDot().apply(this);
        }

        identifier_Parts.createNewIdentifier();
        if(node.getIdentifier() != null) {
            node.getIdentifier().apply(this);
        }
        {
            List<PDim> copy = new ArrayList<PDim>(node.getDims2());
            for(PDim e : copy) {
                e.apply(this);
            }
        }
        String variableName = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
        identifier_Parts.clearParts();

        create_VariableSymbol(variableName, LangSymbol.SymbolType.Variable_MethodParameter, modifiers, primitiveType, null);

        outAPrimitiveVarArgLastFormalParameter(node);
    }

    @Override
    public void caseAReferenceVarArgLastFormalParameter(AReferenceVarArgLastFormalParameter node) {
        inAReferenceVarArgLastFormalParameter(node);


        MethodAttributeSet methodAttribs = node.createMethodAttributes(LangSymbolTable_MethodConstants.method_MethodLastParamDeclaration,
                node, hierarchyControl);

        List<LangSymbol.SymbolModifier> modifiers = new ArrayList<LangSymbol.SymbolModifier>();
        String variableType_ActualCodeString = null;

        {
            List<PModifier> copy = new ArrayList<PModifier>(node.getModifiers());
            for(PModifier e : copy) {
                e.apply(this);

                // * add the modifier
                modifiers.add(LangSymbol.SymbolModifier.getEnumForStringValue(e.toString().trim()));
            }
        }

        // * Get type string
        identifier_Parts.createNewIdentifier();
        if(node.getIdentifier1() != null) {
            node.getIdentifier1().apply(this);
        }
        {
            List<PAdditionalIdentifier> copy = new ArrayList<PAdditionalIdentifier>(node.getAdditionalIdentifiers());
            for(PAdditionalIdentifier e : copy) {
                e.apply(this);
            }
        }
        variableType_ActualCodeString = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
        identifier_Parts.clearParts();

        {
            List<PTypeComponent> copy = new ArrayList<PTypeComponent>(node.getTypeComponents());
            for(PTypeComponent e : copy) {
                e.apply(this);
            }
        }
        if(node.getTypeArguments() != null) {
            node.getTypeArguments().apply(this);
        }
        {
            List<PDim> copy = new ArrayList<PDim>(node.getDims1());
            for(PDim e : copy) {
                e.apply(this);
            }
        }
        if(node.getDotDotDot() != null) {
            node.getDotDotDot().apply(this);
        }

        identifier_Parts.createNewIdentifier();
        if(node.getIdentifier2() != null) {
            node.getIdentifier2().apply(this);
        }
        {
            List<PDim> copy = new ArrayList<PDim>(node.getDims2());
            for(PDim e : copy) {
                e.apply(this);
            }
        }
        String variableName = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
        identifier_Parts.clearParts();


        create_VariableSymbol(variableName, LangSymbol.SymbolType.Variable_MethodParameter, modifiers, null, variableType_ActualCodeString);


        outAReferenceVarArgLastFormalParameter(node);
    }






    //  Enhanced For loop
	//  ______________________________________________________________________________________________________________________________________________


    @Override
    public void caseAPrimitiveExpressionEnhancedForStatement(APrimitiveExpressionEnhancedForStatement node) {
        inAPrimitiveExpressionEnhancedForStatement(node);
        MethodAttributeSet methodAttribs = node.createMethodAttributes(LangSymbolTable_MethodConstants.method_MethodParamDeclaration,
                node, hierarchyControl);

        List<LangSymbol.SymbolModifier> modifiers = new ArrayList<LangSymbol.SymbolModifier>();
        String primitiveType_String = null;
        LangSymbol.PrimitiveType primitiveType = null;


        if(node.getFor() != null) {
            node.getFor().apply(this);
        }
        if(node.getLPar() != null) {
            node.getLPar().apply(this);
        }
        {
            List<PModifier> copy = new ArrayList<PModifier>(node.getModifiers());
            for(PModifier e : copy) {
                e.apply(this);
                // * add the modifier
                modifiers.add(LangSymbol.SymbolModifier.getEnumForStringValue(e.toString().trim()));
            }
        }
        if(node.getPrimitiveType() != null) {
            node.getPrimitiveType().apply(this);

            // * Get primitive type string
            primitiveType_String = node.getPrimitiveType().toString().trim();
            primitiveType = LangSymbol.PrimitiveType.getEnumForStringValue(primitiveType_String);
        }
        {
            List<PDim> copy = new ArrayList<PDim>(node.getDims());
            for(PDim e : copy) {
                e.apply(this);
            }
        }


        identifier_Parts.createNewIdentifier();
        if(node.getIdentifier() != null) {
            node.getIdentifier().apply(this);
        }
        String variableName = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
        identifier_Parts.clearParts();

        create_VariableSymbol(variableName, LangSymbol.SymbolType.Variable_Local, modifiers, primitiveType, null);


        if(node.getColon() != null) {
            node.getColon().apply(this);
        }
        if(node.getExpression() != null) {
            node.getExpression().apply(this);
        }
        if(node.getRPar() != null) {
            node.getRPar().apply(this);
        }
        if(node.getStatement() != null) {
            node.getStatement().apply(this);
        }

        
        outAPrimitiveExpressionEnhancedForStatement(node);
    }

    @Override
    public void caseAPrimitiveIdentifierEnhancedForStatement(APrimitiveIdentifierEnhancedForStatement node) {
        inAPrimitiveIdentifierEnhancedForStatement(node);

        MethodAttributeSet methodAttribs = node.createMethodAttributes(LangSymbolTable_MethodConstants.method_MethodParamDeclaration,
                node, hierarchyControl);

        List<LangSymbol.SymbolModifier> modifiers = new ArrayList<LangSymbol.SymbolModifier>();
        String primitiveType_String = null;
        LangSymbol.PrimitiveType primitiveType = null;

        
        if(node.getFor() != null) {
            node.getFor().apply(this);
        }
        if(node.getLPar() != null) {
            node.getLPar().apply(this);
        }
        {
            List<PModifier> copy = new ArrayList<PModifier>(node.getModifiers());
            for(PModifier e : copy) {
                e.apply(this);

                // * add the modifier
                modifiers.add(LangSymbol.SymbolModifier.getEnumForStringValue(e.toString().trim()));
            }
        }
        if(node.getPrimitiveType() != null) {
            node.getPrimitiveType().apply(this);

            // * Get primitive type string
            primitiveType_String = node.getPrimitiveType().toString().trim();
            primitiveType = LangSymbol.PrimitiveType.getEnumForStringValue(primitiveType_String);
        }
        {
            List<PDim> copy = new ArrayList<PDim>(node.getDims());
            for(PDim e : copy) {
                e.apply(this);
            }
        }


        identifier_Parts.createNewIdentifier();
        if(node.getIdentifier1() != null) {
            node.getIdentifier1().apply(this);
        }
        String variableName = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
        identifier_Parts.clearParts();

        create_VariableSymbol(variableName, LangSymbol.SymbolType.Variable_Local, modifiers, primitiveType, null);

        if(node.getColon() != null) {
            node.getColon().apply(this);
        }
        if(node.getIdentifier2() != null) {
            node.getIdentifier2().apply(this);
        }
        {
            List<PAdditionalIdentifier> copy = new ArrayList<PAdditionalIdentifier>(node.getAdditionalIdentifiers());
            for(PAdditionalIdentifier e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getRPar() != null) {
            node.getRPar().apply(this);
        }
        if(node.getStatement() != null) {
            node.getStatement().apply(this);
        }

        outAPrimitiveIdentifierEnhancedForStatement(node);
    }




    @Override
    public void caseAReferenceExpressionEnhancedForStatement(AReferenceExpressionEnhancedForStatement node)
    {
        inAReferenceExpressionEnhancedForStatement(node);
        MethodAttributeSet methodAttribs = node.createMethodAttributes(LangSymbolTable_MethodConstants.method_MethodParamDeclaration,
                node, hierarchyControl);

        List<LangSymbol.SymbolModifier> modifiers = new ArrayList<LangSymbol.SymbolModifier>();
        String variableType_ActualCodeString = null;


        if(node.getFor() != null) {
            node.getFor().apply(this);
        }
        if(node.getLPar() != null) {
            node.getLPar().apply(this);
        }
        {
            List<PModifier> copy = new ArrayList<PModifier>(node.getModifiers());
            for(PModifier e : copy) {
                e.apply(this);

                // * add the modifier
                modifiers.add(LangSymbol.SymbolModifier.getEnumForStringValue(e.toString().trim()));
            }
        }


        // * Get type string
        identifier_Parts.createNewIdentifier();
        if(node.getIdentifier1() != null) {
            node.getIdentifier1().apply(this);
        }
        {
            List<PAdditionalIdentifier> copy = new ArrayList<PAdditionalIdentifier>(node.getAdditionalIdentifiers());
            for(PAdditionalIdentifier e : copy) {
                e.apply(this);
            }
        }
        variableType_ActualCodeString = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
        identifier_Parts.clearParts();


        {
            List<PTypeComponent> copy = new ArrayList<PTypeComponent>(node.getTypeComponents());
            for(PTypeComponent e : copy) {
                e.apply(this);
            }
        }
        if(node.getTypeArguments() != null) {
            node.getTypeArguments().apply(this);
        }
        {
            List<PDim> copy = new ArrayList<PDim>(node.getDims());
            for(PDim e : copy) {
                e.apply(this);
            }
        }


        identifier_Parts.createNewIdentifier();
        if(node.getIdentifier2() != null) {
            node.getIdentifier2().apply(this);
        }
        String variableName = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
        identifier_Parts.clearParts();


        create_VariableSymbol(variableName, LangSymbol.SymbolType.Variable_Local, modifiers, null, variableType_ActualCodeString);


        if(node.getColon() != null) {
            node.getColon().apply(this);
        }
        if(node.getExpression() != null) {
            node.getExpression().apply(this);
        }
        if(node.getRPar() != null) {
            node.getRPar().apply(this);
        }
        if(node.getStatement() != null) {
            node.getStatement().apply(this);
        }
        outAReferenceExpressionEnhancedForStatement(node);
    }



    @Override
    public void caseAReferenceIdentifierEnhancedForStatement(AReferenceIdentifierEnhancedForStatement node)
    {
        inAReferenceIdentifierEnhancedForStatement(node);
        MethodAttributeSet methodAttribs = node.createMethodAttributes(LangSymbolTable_MethodConstants.method_MethodParamDeclaration,
                node, hierarchyControl);

        List<LangSymbol.SymbolModifier> modifiers = new ArrayList<LangSymbol.SymbolModifier>();
        String variableType_ActualCodeString = null;


        if(node.getFor() != null) {
            node.getFor().apply(this);
        }

        if(node.getLPar() != null) {
            node.getLPar().apply(this);
        }
        {
            List<PModifier> copy = new ArrayList<PModifier>(node.getModifiers());
            for(PModifier e : copy) {
                e.apply(this);

                // * add the modifier
                modifiers.add(LangSymbol.SymbolModifier.getEnumForStringValue(e.toString().trim()));
            }
        }

        // * Get type string
        identifier_Parts.createNewIdentifier();
        if(node.getIdentifier1() != null) {
            node.getIdentifier1().apply(this);
        }
        {
            List<PAdditionalIdentifier> copy = new ArrayList<PAdditionalIdentifier>(node.getAdditionalIdentifiers1());
            for(PAdditionalIdentifier e : copy) {
                e.apply(this);
            }
        }
        variableType_ActualCodeString = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
        identifier_Parts.clearParts();

        {
            List<PTypeComponent> copy = new ArrayList<PTypeComponent>(node.getTypeComponents());
            for(PTypeComponent e : copy) {
                e.apply(this);
            }
        }
        if(node.getTypeArguments() != null) {
            node.getTypeArguments().apply(this);
        }
        {
            List<PDim> copy = new ArrayList<PDim>(node.getDims());
            for(PDim e : copy) {
                e.apply(this);
            }
        }

        
        identifier_Parts.createNewIdentifier();
        if(node.getIdentifier2() != null) {
            node.getIdentifier2().apply(this);
        }
        String variableName = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
        identifier_Parts.clearParts();


        create_VariableSymbol(variableName, LangSymbol.SymbolType.Variable_Local, modifiers, null, variableType_ActualCodeString);



        if(node.getColon() != null) {
            node.getColon().apply(this);
        }
        if(node.getIdentifier3() != null) {
            node.getIdentifier3().apply(this);
        }
        {
            List<PAdditionalIdentifier> copy = new ArrayList<PAdditionalIdentifier>(node.getAdditionalIdentifiers2());
            for(PAdditionalIdentifier e : copy) {
                e.apply(this);
            }
        }
        if(node.getRPar() != null) {
            node.getRPar().apply(this);
        }
        if(node.getStatement() != null) {
            node.getStatement().apply(this);
        }
        outAReferenceIdentifierEnhancedForStatement(node);
    }









    @Override
    public void caseAMjDescvarExpressionEnhancedForStatement(AMjDescvarExpressionEnhancedForStatement node)
    {
        inAMjDescvarExpressionEnhancedForStatement(node);
        MethodAttributeSet enhForLoop_Attribs = node.createMethodAttributes(LangSymbolTable_MethodConstants.method_EnhancedForLoopDeclaration,
                node, hierarchyControl);

        List<LangSymbol.SymbolModifier> modifiers = new ArrayList<LangSymbol.SymbolModifier>();

        String variableType_ActualCodeString = null;

        if(node.getFor() != null) {
            node.getFor().apply(this);
        }
        if(node.getLPar() != null) {
            node.getLPar().apply(this);
        }


        //  Get the matrix access state  _______________________________________________

        //  These productions can call generate_MatrixAccess()
        if(node.getDescriptorVariableType() != null) {
            node.getDescriptorVariableType().apply(this);
        }
        //  The actual code string of the DESCRIPTOR var with access type if it exists
        variableType_ActualCodeString = node.getDescriptorVariableType().toString_ProcessCurrent().trim();

        MatrixAccessState matrixAccessState = (MatrixAccessState)hierarchyControl.returnValues_getMap_for(
                HierarchyMethodConstants.method_Process_DescriptorVarDeclaration).get(HierarchyMethodConstants.retVal_MatrixAccessState);

        enhForLoop_Attribs.vars.put(LangSymbolTable_MethodConstants.var_MatrixAccessState, matrixAccessState);

        // don't forget to clear the method call values passed _to_ the method and the returnvalues passed _from_ the method
        enhForLoop_Attribs.methodCall_ClearAllValues();
        hierarchyControl.returnValues_clearMap_for(HierarchyMethodConstants.method_Process_DescriptorVarDeclaration);

        //  _______________________________________________



        identifier_Parts.createNewIdentifier();
        if(node.getIdentifier() != null) {
            node.getIdentifier().apply(this);
        }
        String variableName = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
        identifier_Parts.clearParts();



        create_VariableSymbol(variableName, LangSymbol.SymbolType.Variable_Local, modifiers, null, variableType_ActualCodeString,
                new Boolean(true), matrixAccessState);



        if(node.getColon() != null) {
            node.getColon().apply(this);
        }
        if(node.getExpression() != null) {
            node.getExpression().apply(this);
        }
        if(node.getRPar() != null) {
            node.getRPar().apply(this);
        }
        if(node.getStatement() != null) {
            node.getStatement().apply(this);
        }

        
        outAMjDescvarExpressionEnhancedForStatement(node);
    }





    @Override
    public void caseAMjDescvarIdentifierEnhancedForStatement(AMjDescvarIdentifierEnhancedForStatement node) {
        inAMjDescvarIdentifierEnhancedForStatement(node);
        MethodAttributeSet enhForLoop_Attribs = node.createMethodAttributes(LangSymbolTable_MethodConstants.method_EnhancedForLoopDeclaration,
                node, hierarchyControl);

        List<LangSymbol.SymbolModifier> modifiers = new ArrayList<LangSymbol.SymbolModifier>();

        String variableType_ActualCodeString = null;
        
        if(node.getFor() != null) {
            node.getFor().apply(this);
        }
        if(node.getLPar() != null) {
            node.getLPar().apply(this);
        }


        //  Get the matrix access state  _______________________________________________

        //  These productions can call generate_MatrixAccess()
        if(node.getDescriptorVariableType() != null) {
            node.getDescriptorVariableType().apply(this);
        }
        //  The actual code string of the DESCRIPTOR var with access type if it exists
        variableType_ActualCodeString = node.getDescriptorVariableType().toString_ProcessCurrent().trim();

        MatrixAccessState matrixAccessState = (MatrixAccessState)hierarchyControl.returnValues_getMap_for(
                HierarchyMethodConstants.method_Process_DescriptorVarDeclaration).get(HierarchyMethodConstants.retVal_MatrixAccessState);

        enhForLoop_Attribs.vars.put(LangSymbolTable_MethodConstants.var_MatrixAccessState, matrixAccessState);

        // don't forget to clear the method call values passed _to_ the method and the returnvalues passed _from_ the method
        enhForLoop_Attribs.methodCall_ClearAllValues();
        hierarchyControl.returnValues_clearMap_for(HierarchyMethodConstants.method_Process_DescriptorVarDeclaration);

        //  _______________________________________________


        identifier_Parts.createNewIdentifier();
        if(node.getIdentifier() != null) {
            node.getIdentifier().apply(this);
        }
         String variableName = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
        identifier_Parts.clearParts();



        create_VariableSymbol(variableName, LangSymbol.SymbolType.Variable_Local, modifiers, null, variableType_ActualCodeString,
                new Boolean(true), matrixAccessState);




        if(node.getColon() != null) {
            node.getColon().apply(this);
        }
        if(node.getIdentifier2() != null) {
            node.getIdentifier2().apply(this);
        }
        {
            List<PAdditionalIdentifier> copy = new ArrayList<PAdditionalIdentifier>(node.getAdditionalIdentifiers());
            for(PAdditionalIdentifier e : copy) {
                e.apply(this);
            }
        }
        if(node.getRPar() != null) {
            node.getRPar().apply(this);
        }
        if(node.getStatement() != null) {
            node.getStatement().apply(this);
        }

        outAMjDescvarIdentifierEnhancedForStatement(node);
    }







	//  ______________________________________________________________________________________________________________________________________________
    //
    //  Variable Declarator Productions
	//  ______________________________________________________________________________________________________________________________________________

    @Override
    public void inASimpleVariableDeclarator(ASimpleVariableDeclarator node) {
        defaultIn(node);

        identifier_Parts.createNewIdentifier();
    }
    @Override
    public void outASimpleVariableDeclarator(ASimpleVariableDeclarator node) {
        defaultOut(node);
        
        MethodAttributeSet methodHeader_AttribSet = node.getMethodAttributes();

        String variableName = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
        identifier_Parts.clearParts();


        List<LangSymbol.SymbolModifier> modifiers = (List<LangSymbol.SymbolModifier>)methodHeader_AttribSet.vars.get(
                LangSymbolTable_MethodConstants.var_Modifiers);

        LangSymbol.PrimitiveType variable_PrimitiveType = (LangSymbol.PrimitiveType)methodHeader_AttribSet.vars.get(
                LangSymbolTable_MethodConstants.var_variable_PrimitiveType);
        String variable_ActualCodeString = (String)methodHeader_AttribSet.vars.get(
                LangSymbolTable_MethodConstants.var_variableType_ActualCodeString);
        Boolean variable_IsDescriptorVar = (Boolean)methodHeader_AttribSet.vars.get(
                LangSymbolTable_MethodConstants.var_variable_IsDescriptorVar);
        MatrixAccessState matrixAccessState = (MatrixAccessState)methodHeader_AttribSet.vars.get(
                LangSymbolTable_MethodConstants.var_MatrixAccessState);

        LangSymbol.SymbolType variable_SymbolType = (LangSymbol.SymbolType)methodHeader_AttribSet.vars.get(
                LangSymbolTable_MethodConstants.var_variable_SymbolType);


        create_VariableSymbol(variableName, variable_SymbolType, modifiers, variable_PrimitiveType, variable_ActualCodeString, 
                variable_IsDescriptorVar, matrixAccessState);

    }

    
    @Override
    public void caseAInitializerVariableDeclarator(AInitializerVariableDeclarator node) {
        inAInitializerVariableDeclarator(node);

        MethodAttributeSet methodHeader_AttribSet = node.getMethodAttributes();

        identifier_Parts.createNewIdentifier();

        if(node.getIdentifier() != null) {
            node.getIdentifier().apply(this);
        }
        String variableName = (!identifier_Parts.isEmpty() ? identifier_Parts.generateIdentifier() : "");
        identifier_Parts.clearParts();

        List<LangSymbol.SymbolModifier> modifiers = (List<LangSymbol.SymbolModifier>)methodHeader_AttribSet.vars.get(
                LangSymbolTable_MethodConstants.var_Modifiers);

        LangSymbol.PrimitiveType variable_PrimitiveType = (LangSymbol.PrimitiveType)methodHeader_AttribSet.vars.get(
                LangSymbolTable_MethodConstants.var_variable_PrimitiveType);
        String variable_ActualCodeString = (String)methodHeader_AttribSet.vars.get(
                LangSymbolTable_MethodConstants.var_variableType_ActualCodeString);
        Boolean variable_IsDescriptorVar = (Boolean)methodHeader_AttribSet.vars.get(
                LangSymbolTable_MethodConstants.var_variable_IsDescriptorVar);
        MatrixAccessState matrixAccessState = (MatrixAccessState)methodHeader_AttribSet.vars.get(
                LangSymbolTable_MethodConstants.var_MatrixAccessState);

        LangSymbol.SymbolType variable_SymbolType = (LangSymbol.SymbolType)methodHeader_AttribSet.vars.get(
                LangSymbolTable_MethodConstants.var_variable_SymbolType);


        create_VariableSymbol(variableName, variable_SymbolType, modifiers, variable_PrimitiveType, variable_ActualCodeString, 
                variable_IsDescriptorVar, matrixAccessState);


        {
            List<PDim> copy = new ArrayList<PDim>(node.getDims());
            for(PDim e : copy) {
                e.apply(this);
            }
        }
        if(node.getAssign() != null) {
            node.getAssign().apply(this);
        }
        if(node.getVariableInitializer() != null) {
            node.getVariableInitializer().apply(this);
        }
        outAInitializerVariableDeclarator(node);
    }






    /** not creating a desc var */
    private void create_VariableSymbol(String variableName, LangSymbol.SymbolType variable_SymbolType, List<SymbolModifier> modifiers,
            PrimitiveType variable_PrimitiveType, String variable_ActualCodeString) {
        create_VariableSymbol(variableName, variable_SymbolType, modifiers, variable_PrimitiveType, variable_ActualCodeString,
                false, null);
    }

    /** can create a desc var with this version */
    private void create_VariableSymbol(String variableName, LangSymbol.SymbolType variable_SymbolType, List<SymbolModifier> modifiers,
            PrimitiveType variable_PrimitiveType, String variable_ActualCodeString, Boolean variable_IsDescriptorVar,
            MatrixAccessState matrixAccessState) {

        TypeUsageInfo variable_TypeUsageInfo = null;
        LangSymbol_Variable variableSym = null;



        if (variable_PrimitiveType != null) {
            variable_TypeUsageInfo = new TypeUsageInfo(variable_PrimitiveType, symbolTable_File, symbolTable_File.lookup_Type_InScope(),
                                                        typeUsageInfoList_FullTypesToBeResolved);
        } else if (variable_IsDescriptorVar != null && variable_IsDescriptorVar.booleanValue()) {
            variable_TypeUsageInfo = new TypeUsageInfo(variable_ActualCodeString, true, symbolTable_File, symbolTable_File.lookup_Type_InScope(),
                                                        typeUsageInfoList_FullTypesToBeResolved);
        } else if (variable_ActualCodeString != null) {
            variable_TypeUsageInfo = new TypeUsageInfo(variable_ActualCodeString, symbolTable_File, symbolTable_File.lookup_Type_InScope(),
                                                        typeUsageInfoList_FullTypesToBeResolved);
        } else {
            ExceptRuntime_LangSymbolTable e = new ExceptRuntime_LangSymbolTable("Error, creating the language symbol for a variable, but it was not either a " +
                    "primitive type or a complex type. This should not happen. The variable name was: " + variableName);
            hierarchySettings.logger.reportError_And_Exit(e);
        }


        // setup the parent type info & create the var
        LangSymbol parent_Symbol = null;
        if (variable_SymbolType == LangSymbol.SymbolType.Variable_Class)
            parent_Symbol = symbolTable_File.lookup_Type_InScope();
        else // it's a method param or a local var
            parent_Symbol = symbolTable_File.lookup_Method_InScope(true);




        // Create the Variable
        if (variable_SymbolType == LangSymbol.SymbolType.Variable_Class || variable_SymbolType == LangSymbol.SymbolType.Variable_Local) {

            if (variable_IsDescriptorVar != null && variable_IsDescriptorVar)
                variableSym = LangSymbol_Variable_DescriptorVar.createSymbol__Variable_DescriptorVar(variableName, variable_SymbolType, variable_TypeUsageInfo, 
                    matrixAccessState, parent_Symbol, null, symbolTable_File, modifiers.toArray(new LangSymbol.SymbolModifier[0]));
            else
                variableSym = LangSymbol_Variable.createSymbol__Variable(variableName, variable_SymbolType, variable_TypeUsageInfo,
                    parent_Symbol, null, symbolTable_File, modifiers.toArray(new LangSymbol.SymbolModifier[0]));

        } else { // it's a method param
            
            if (variable_IsDescriptorVar != null && variable_IsDescriptorVar)
                variableSym = LangSymbol_Method.createSymbol__MethodParameter_DescVar(variableName, variable_TypeUsageInfo, matrixAccessState,
                    (LangSymbol_Method)parent_Symbol, null, symbolTable_File, modifiers.toArray(new LangSymbol.SymbolModifier[0]));
            else
                variableSym = LangSymbol_Method.createSymbol__MethodParameter(variableName, variable_TypeUsageInfo, (LangSymbol_Method)parent_Symbol,
                    null, symbolTable_File, modifiers.toArray(new LangSymbol.SymbolModifier[0]));
        }


        variable_TypeUsageInfo.setAssociated_LangSymbolVar(variableSym);

    }


    

    //  ______________________________________________________________________________________________________________________________________________
    //
    //    Descriptor Variable Type Productions - uses the production from the super class, HierarchyActions.java
	//  ______________________________________________________________________________________________________________________________________________





	//  ______________________________________________________________________________________________________________________________________________
    //
    //    Smaller Productions
	//  ______________________________________________________________________________________________________________________________________________




}





