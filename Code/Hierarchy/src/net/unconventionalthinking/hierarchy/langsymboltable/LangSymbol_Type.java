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
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.map.MultiValueMap;

/**
 *
 * @author peterjoh
 */
public class LangSymbol_Type extends LangSymbol implements TypeInfo {



    String               packageName;

    boolean              classOrEnum_IsInner;
    String               classOrEnum_InnerPath;


    //    Type Info variables
    //  ________________________________________________________________________________________________________________
    int                         typeNestingLevel;
    boolean                     is_NestedType;

    LangSymbolTable_File        symbolTable_File;
    TypeInfo                    parentTypeInfo;
    List<TypeInfo>              childNestedTypeInfo_List;
    Map<String, TypeInfo>       childNestedTypeInfo_Index_bySimpleName;

    String              name_Simple;
    String              name_withNestedNames;
    List<String>        name_withNestedNames_PartsList;
    String              name_Root;

    TypeUsageInfo       inheritance_TypeUsageInfo;

    List<TypeUsageInfo> interfaces_TypeUsageInfo_List;
    List<TypeInfo>      interfaces_TypeInfoList;


    MultiValueMap                       methodName_MultiValueIndex;
    Map<String, LangSymbol_Variable>    fieldVarIndex;



    //  ________________________________________________________________________________________________________________
    //
    //    Construction Methods
    //  ________________________________________________________________________________________________________________
    

    /**
     * This version takes no scope id. It uses the current, top most scope. This is probably the version of the method that will be most used.
     *
     * @param alreadyPushed_TypeBodyScope_OnToStack    before calling this class symbol construction method, did you already push the body type's
     *                                              scope on to the scope stack? most of the time, it's false (because you normally increase
     *                                              the scope stack when you get to the type's body section}
     */
    public static LangSymbol_Type createSymbol__Class(String className_Simple, String packageName, Object otherInfo,
            LangSymbolTable_File symbolTable_File, boolean alreadyPushed_TypeBodyScope_OnToStack,
            LangSymbolTable_App symbolTable_App, LinkedList<TypeInfo> nestedTypeStack, SymbolModifier... modifiers) {
        return createSymbol__Class(className_Simple, packageName, symbolTable_File.scopeStack.viewCurrentScope().scope_Id, otherInfo,
                symbolTable_File, alreadyPushed_TypeBodyScope_OnToStack, symbolTable_App, nestedTypeStack, modifiers);
    }
    /** SEE JAVADOC FOR OTHER VERSIONS OF THIS METHOD */
    public static LangSymbol_Type createSymbol__Class(String className_Simple, String packageName, int scopeID, Object otherInfo,
            LangSymbolTable_File symbolTable_File, boolean alreadyPushed_TypeBodyScope_OnToStack,
            LangSymbolTable_App symbolTable_App, LinkedList<TypeInfo> nestedTypeStack, SymbolModifier... modifiers) {

        LangSymbol_Type langSymbol_Type = new LangSymbol_Type(className_Simple, packageName, SymbolType.Class,
                scopeID, symbolTable_File, otherInfo, false, null, modifiers);


        langSymbol_Type.set_Name(className_Simple, nestedTypeStack);

        symbolTable_File.addSymbol_Type(langSymbol_Type, alreadyPushed_TypeBodyScope_OnToStack);
        symbolTable_App.addSymbol_Type(langSymbol_Type, symbolTable_File);



        return langSymbol_Type;

    }


    /**
     * This version takes no scope id. It uses the current, top most scope. This is probably the version of the method that will be most used.
     *
     * @param alreadyPushed_TypeBodyScope_OnToStack    before calling this class symbol construction method, did you already push the type body's
     *                                              scope on to the scope stack? most of the time, it's false (because you normally increase
     *                                              the scope stack when you get to the type's body section}
     */
    public static LangSymbol_Type createSymbol__Class_Inner(String className_Simple, String packageName, Object otherInfo,
            LangSymbolTable_File symbolTable_File, boolean alreadyPushed_TypeBodyScope_OnToStack,
            LangSymbolTable_App symbolTable_App, LinkedList<TypeInfo> nestedTypeStack,
            SymbolModifier... modifiers) {
        return createSymbol__Class_Inner(className_Simple, packageName, symbolTable_File.scopeStack.viewCurrentScope().scope_Id, 
                otherInfo, symbolTable_File, alreadyPushed_TypeBodyScope_OnToStack, symbolTable_App, nestedTypeStack, modifiers);
    }
    /** SEE JAVADOC FOR OTHER VERSIONS OF THIS METHOD */
    public static LangSymbol_Type createSymbol__Class_Inner(String className_Simple, String packageName, int scopeID, Object otherInfo,
            LangSymbolTable_File symbolTable_File, boolean alreadyPushed_TypeBodyScope_OnToStack,
            LangSymbolTable_App symbolTable_App, LinkedList<TypeInfo> nestedTypeStack,
            SymbolModifier... modifiers) {

        // TODO - this method should determine classOrEnum_InnerClassPath
        String classOrEnum_InnerClassPath = null;
        
        LangSymbol_Type langSymbol_Type = new LangSymbol_Type(className_Simple, packageName, SymbolType.Class, scopeID, symbolTable_File,
                otherInfo, true, classOrEnum_InnerClassPath, modifiers);

        langSymbol_Type.set_Name(className_Simple, nestedTypeStack);

        symbolTable_File.addSymbol_Type(langSymbol_Type, alreadyPushed_TypeBodyScope_OnToStack);
        symbolTable_App.addSymbol_Type(langSymbol_Type, symbolTable_File);
        
        return langSymbol_Type;
    }




    /**
     * This version takes no scope id. It uses the current, top most scope. This is probably the version of the method that will be most used.
     *
     * @param alreadyPushed_TypeBodyScope_OnToStack    before calling this class symbol construction method, did you already push the body type's
     *                                              scope on to the scope stack? most of the time, it's false (because you normally increase
     *                                              the scope stack when you get to the type's body section}
     */
    public static LangSymbol_Type createSymbol__Interface(String interfaceName_Simple, String packageName, Object otherInfo,
            LangSymbolTable_File symbolTable_File, boolean alreadyPushed_TypeBodyScope_OnToStack,
            LangSymbolTable_App symbolTable_App, LinkedList<TypeInfo> nestedTypeStack, SymbolModifier... modifiers) {
        return createSymbol__Interface(interfaceName_Simple, packageName, symbolTable_File.scopeStack.viewCurrentScope().scope_Id, otherInfo,
                symbolTable_File, alreadyPushed_TypeBodyScope_OnToStack, symbolTable_App, nestedTypeStack, modifiers);
    }
    /** SEE JAVADOC FOR OTHER VERSIONS OF THIS METHOD */
    public static LangSymbol_Type createSymbol__Interface(String interfaceName_Simple, String packageName, int scopeID, Object otherInfo,
            LangSymbolTable_File symbolTable_File, boolean alreadyPushed_TypeBodyScope_OnToStack,
            LangSymbolTable_App symbolTable_App, LinkedList<TypeInfo> nestedTypeStack,SymbolModifier... modifiers) {
        throw new UnsupportedOperationException("This method has not yet been implemented");

    }



    /**
     * This version takes no scope id. It uses the current, top most scope. This is probably the version of the method that will be most used.
     *
     * @param alreadyPushed_TypeBodyScope_OnToStack    before calling this class symbol construction method, did you already push the type body's
     *                                              scope on to the scope stack? most of the time, it's false (because you normally increase
     *                                              the scope stack when you get to the type's body section}
     */
    public static LangSymbol_Type createSymbol__Enum(String enumName_Simple, String packageName, Object otherInfo,
            LangSymbolTable_File symbolTable_File, boolean alreadyPushed_TypeBodyScope_OnToStack,
            LangSymbolTable_App symbolTable_App, LinkedList<TypeInfo> nestedTypeStack,
            SymbolModifier... modifiers) {
        return createSymbol__Enum(enumName_Simple, packageName, symbolTable_File.scopeStack.viewCurrentScope().scope_Id, otherInfo,
                symbolTable_File, alreadyPushed_TypeBodyScope_OnToStack, symbolTable_App, nestedTypeStack, modifiers);
    }
    /** SEE JAVADOC FOR OTHER VERSIONS OF THIS METHOD */
    public static LangSymbol_Type createSymbol__Enum(String enumName_Simple, String packageName, int scopeID, Object otherInfo,
            LangSymbolTable_File symbolTable_File, boolean alreadyPushed_TypeBodyScope_OnToStack,
            LangSymbolTable_App symbolTable_App, LinkedList<TypeInfo> nestedTypeStack,
            SymbolModifier... modifiers) {
        throw new UnsupportedOperationException("This method has not yet been implemented");
    }


    
    /**
     * This version takes no scope id. It uses the current, top most scope. This is probably the version of the method that will be most used.
     *
     * @param alreadyPushed_TypeBodyScope_OnToStack    before calling this class symbol construction method, did you already push the type body's
     *                                              scope on to the scope stack? most of the time, it's false (because you normally increase
     *                                              the scope stack when you get to the type's body section}
     */
    public static LangSymbol_Type createSymbol__Enum_Inner(String enumName_Simple, String packageName, Object otherInfo,
            LangSymbolTable_File symbolTable_File, boolean alreadyPushed_TypeBodyScope_OnToStack,
            LangSymbolTable_App symbolTable_App, LinkedList<TypeInfo> nestedTypeStack,
            SymbolModifier... modifiers) {
        return createSymbol__Enum_Inner(enumName_Simple, packageName, symbolTable_File.scopeStack.viewCurrentScope().scope_Id, otherInfo,
                symbolTable_File, alreadyPushed_TypeBodyScope_OnToStack, symbolTable_App, nestedTypeStack, modifiers);
    }
    /** SEE JAVADOC FOR OTHER VERSIONS OF THIS METHOD */
    public static LangSymbol_Type createSymbol__Enum_Inner(String enumName_Simple, String packageName, int scopeID, Object otherInfo,
            LangSymbolTable_File symbolTable_File, boolean alreadyPushed_TypeBodyScope_OnToStack,
            LangSymbolTable_App symbolTable_App, LinkedList<TypeInfo> nestedTypeStack,
            SymbolModifier... modifiers) {
        // this method should determine classOrEnum_InnerClassPath
        throw new UnsupportedOperationException("This method has not yet been implemented");
    }







    private LangSymbol_Type(String name, String PackageName, SymbolType symbolType, int scopeID, LangSymbolTable_File symbolTable_File,
            Object otherInfo, boolean classOrEnum_IsInner, String classOrEnum_InnerPath,
            SymbolModifier... modifiers) {
        super(name, symbolType, scopeID, otherInfo, modifiers);

        this.symbolTable_File = symbolTable_File;

        interfaces_TypeUsageInfo_List = new ArrayList<TypeUsageInfo>();

        childNestedTypeInfo_List = new ArrayList<TypeInfo>();
        childNestedTypeInfo_Index_bySimpleName = new HashMap<String, TypeInfo>();
        
        methodName_MultiValueIndex = new MultiValueMap();
        fieldVarIndex = new HashMap<String, LangSymbol_Variable>();


        this.packageName = PackageName;
        this.classOrEnum_IsInner = classOrEnum_IsInner;
        this.classOrEnum_InnerPath = classOrEnum_InnerPath;
    }




    //  ________________________________________________________________________________________________________________
    //
    //    TypeInfo Interface Methods
    //  ________________________________________________________________________________________________________________

    public void set_Type(Type type) {  throw new UnsupportedOperationException("You should not call this directly. Type will be set when the Symbol Type object is created."); }
    public void set_TypeNestingLevel(int typeNestingLevel) { this.typeNestingLevel = typeNestingLevel; }
    public void set_IsNestedType(boolean is_NestedType) { this.is_NestedType = is_NestedType; }

    public void set_ParentTypeInfo(TypeInfo parentTypeInfo) {
        this.parentTypeInfo = parentTypeInfo;
    }
    public void add_ChildNestedTypeInfo(TypeInfo typeInfo) {
        childNestedTypeInfo_List.add(typeInfo);
        childNestedTypeInfo_Index_bySimpleName.put(typeInfo.get_Name_Simple(), typeInfo);
    }
    public void addSymbol_Method(LangSymbol_Method methodSymbol) { methodName_MultiValueIndex.put(methodSymbol.name, methodSymbol); }
    public void addSymbol_Variable(LangSymbol_Variable varSymbol) { fieldVarIndex.put(varSymbol.name, varSymbol); }


    public void set_Name(String simpleName, LinkedList<TypeInfo> nestedTypeStack) {

        name_withNestedNames_PartsList = new ArrayList<String>();
        for (int i = 0; i < nestedTypeStack.size(); ++ i)
            name_withNestedNames_PartsList.add(nestedTypeStack.get(i).get_Name_Simple());
        // add the simpleName too
        name_withNestedNames_PartsList.add(simpleName);


        StringBuilder fullName = new StringBuilder();
        boolean isNotFirstIter = false;
        for (String namePart : name_withNestedNames_PartsList) {
            if (isNotFirstIter)
                fullName.append(".");
            else {
                isNotFirstIter = true;
                name_Root = namePart;
            }
            fullName.append(namePart);
        }
        name_withNestedNames = fullName.toString();


        name_Simple = simpleName;

    }



    public void set_Package(String packageName) { this.packageName = packageName; }
    public void set_Modifiers(Set<SymbolModifier> modifiers) { super.modifiers = modifiers; }


    public boolean has_InheritedType() { return (inheritance_TypeUsageInfo != null); }
    public void set_Inheritance_TypeUsageInfo(TypeUsageInfo inheritance_TypeUsageInfo) { 
        this.inheritance_TypeUsageInfo = inheritance_TypeUsageInfo;
    }

    public void add_Interface_TypeUsageInfo(TypeUsageInfo inheritance_TypeUsageInfo) {
        interfaces_TypeUsageInfo_List.add(inheritance_TypeUsageInfo); }
    public void set_Interfaces_TypeInfoList(List<TypeInfo> interfaces_TypeInfoList) {
        this.interfaces_TypeInfoList = interfaces_TypeInfoList;
    }




    public boolean is_NestedType() { return is_NestedType; }
    public int get_TypeNestingLevel() { return typeNestingLevel; }

    public List<TypeInfo> get_ChildNestedTypeInfo_List() { return childNestedTypeInfo_List;}
    public TypeInfo get_ParentTypeInfo() { return parentTypeInfo; }

    public TypeInfo_SrcCodeFileInfo get_SrcCodeFileInfo() { return  symbolTable_File;}



    public String get_Name_Simple() { return name_Simple; }
    public List<String> get_Name_withNestedNames_Parts() { return name_withNestedNames_PartsList;}
    public String get_Name_withNestedNames() { return name_withNestedNames; }
    public TypeInfo get_NestedChildTypeInfo(String namePart) {
        return childNestedTypeInfo_Index_bySimpleName.get(namePart);
    }


    public String get_PackageName() { return packageName;}
    public String get_FullTypeName() {
        return packageName + '.' + name_withNestedNames;

    }

    /** this is used for nested types. you can get the full name of the root type name.<BR>
     * for example, for the type, mypackage.MyRootClass.MyInnerClass, this method would return "mypackage.MyRootClass". */
    public String get_FullTypeName_Root() {
        return packageName + '.' + name_Root;
    }
    /** this is used for nested types. you can get the full name of the root type name.<BR>
     * for example, for the type, mypackage.MyRootClass.MyInnerClass, this method would return "MyRootClass". */
    public String getName_Root() { return name_Root; }



    public Type get_Type() {
        switch (super.symbolType) {
            case Class:
                return Type.CLASS;
            case Enum:
                return Type.ENUM;
            case Interface:
                return Type.INTERFACE;
            default:
                return null;
        }
    }

    public Set<LangSymbol.SymbolModifier> get_Modifiers() { return super.modifiers; }


    public TypeUsageInfo get_Inheritance_TypeUsageInfo() { return inheritance_TypeUsageInfo; }
    public List<TypeUsageInfo> get_Interfaces_TypeUsageInfoList() { return interfaces_TypeUsageInfo_List; }
    public List<TypeInfo> get_Interfaces_TypeInfoList() { return interfaces_TypeInfoList; }



    public Collection getMethods(String methodName) { return methodName_MultiValueIndex.getCollection(methodName); }
    public LangSymbol_Variable getField(String fieldName) { return fieldVarIndex.get(fieldName); }



    //  ________________________________________________________________________________________________________________
    //
    //    Get Methods (non Type-Info)
    //  ________________________________________________________________________________________________________________


    public LangSymbolTable_File getSymbolTable_File() { return symbolTable_File; }


}
