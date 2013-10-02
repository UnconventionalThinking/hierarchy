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

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author peterjoh
 */
public interface TypeInfo extends LangSymbolProperty_HasVariables {

    public enum Type { CLASS, ENUM, INTERFACE }



    public void set_Type(Type type);
    public void set_TypeNestingLevel(int typeNestingLevel);
    public void set_IsNestedType(boolean is_NestedType);

    public void set_ParentTypeInfo(TypeInfo parentTypeInfo);
    public void add_ChildNestedTypeInfo(TypeInfo typeInfo);
    public void addSymbol_Method(LangSymbol_Method methodSymbol);
    public void addSymbol_Variable(LangSymbol_Variable varSymbol);
    

    public void set_Name(String simpleName, LinkedList<TypeInfo> nestedTypeStack);



    public void set_Package(String packageName);
    public void set_Modifiers(Set<LangSymbol.SymbolModifier> modifiers);


    public boolean has_InheritedType();
    public void set_Inheritance_TypeUsageInfo(TypeUsageInfo inheritance_TypeUsageInfo);

    public void add_Interface_TypeUsageInfo(TypeUsageInfo inheritance_TypeUsageInfo);
    public void set_Interfaces_TypeInfoList(List<TypeInfo> interfaces_TypeInfoList);




    public boolean is_NestedType();
    public int get_TypeNestingLevel();

    public List<TypeInfo> get_ChildNestedTypeInfo_List();
    public TypeInfo get_ParentTypeInfo();

    public TypeInfo_SrcCodeFileInfo get_SrcCodeFileInfo();



    public String get_Name_Simple();
    public List<String> get_Name_withNestedNames_Parts();
    public String get_Name_withNestedNames();
    public TypeInfo get_NestedChildTypeInfo(String namePart);


    public String get_PackageName();
    public String get_FullTypeName();

    /** this is used for nested types. you can get the full name of the root type name.<BR>
     * for example, for the type, mypackage.MyRootClass.MyInnerClass, this method would return "mypackage.MyRootClass". */
    public String get_FullTypeName_Root();
    /** this is used for nested types. you can get the full name of the root type name.<BR>
     * for example, for the type, mypackage.MyRootClass.MyInnerClass, this method would return "MyRootClass". */
    public String getName_Root();



    public Type get_Type();

    public Set<LangSymbol.SymbolModifier> get_Modifiers();

    public TypeUsageInfo get_Inheritance_TypeUsageInfo();
    public List<TypeUsageInfo> get_Interfaces_TypeUsageInfoList(); // maybe get rid of one of these
    public List<TypeInfo> get_Interfaces_TypeInfoList();


    public Collection getMethods(String methodName);
    public LangSymbol_Variable getField(String fieldName);



}
