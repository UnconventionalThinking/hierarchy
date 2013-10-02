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

import net.unconventionalthinking.matrix.Descriptor;
import net.unconventionalthinking.hierarchy.langsymboltable.TypeInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.MultiValueMap;

/**
 *
 * @author peterjoh
 */
public class LangSymbolTable_App {

    public static final String DescriptorClass_FullTypeName = Descriptor.class.getName();
    public static final String DescriptorClass_SimpleName = Descriptor.class.getSimpleName();
    public static final String DescriptorClass_PackageName = Descriptor.class.getPackage().getName();


    List<TypeInfo>          typeInfo_List;

    Map<String, TypeInfo>   typeInfoIndex__byFullTypeName_to_TypeInfo;
    MultiValueMap           typeInfoMultiValueIndex__byRootFullTypeName_to_TypeInfo;

    List<TypeUsageInfo>     typeUsageInfoList_FullTypesToBeResolved;



    Map<String, LangSymbolTable_File>       typeName_to_SymbolTableFile_Map__byFullTypeName;
    MultiValueMap                           typeName_to_SymbolTableFile_MultiValueMap__bySimpleNameWithNestedNames;
    MultiValueMap                           typeName_to_SymbolTableFile_MultiValueMap__bySimpleName;


    public LangSymbolTable_App() {
        typeInfo_List = new ArrayList<TypeInfo>();
        typeInfoIndex__byFullTypeName_to_TypeInfo = new HashMap<String, TypeInfo>();
        typeInfoMultiValueIndex__byRootFullTypeName_to_TypeInfo = new MultiValueMap();

        typeUsageInfoList_FullTypesToBeResolved = new ArrayList<TypeUsageInfo>();

        typeName_to_SymbolTableFile_Map__byFullTypeName = new HashMap<String, LangSymbolTable_File>();
        typeName_to_SymbolTableFile_MultiValueMap__bySimpleNameWithNestedNames = new MultiValueMap();
        typeName_to_SymbolTableFile_MultiValueMap__bySimpleName = new MultiValueMap();
    }



    public void addSymbol_Type(LangSymbol_Type langSymbol_Type, LangSymbolTable_File symbolTable_File) {

        typeName_to_SymbolTableFile_Map__byFullTypeName.put(langSymbol_Type.get_FullTypeName(), symbolTable_File);
        typeName_to_SymbolTableFile_MultiValueMap__bySimpleNameWithNestedNames.put(langSymbol_Type.name_withNestedNames, symbolTable_File);
        typeName_to_SymbolTableFile_MultiValueMap__bySimpleName.put(langSymbol_Type.name_Simple, symbolTable_File);

        add_TypeInfo(langSymbol_Type);
    }
    /**  Call addSymbol_Type() instead. But, this is left available for testing purposes */
    public void add_TypeInfo(TypeInfo typeInfo) {
        typeInfoIndex__byFullTypeName_to_TypeInfo.put(typeInfo.get_FullTypeName(), typeInfo);
        typeInfoMultiValueIndex__byRootFullTypeName_to_TypeInfo.put(typeInfo.get_FullTypeName_Root(), typeInfo);

        typeInfo_List.add(typeInfo);
    }









    public TypeInfo getTypeInfo_byFullTypeName(String fullTypeName) {
        return typeInfoIndex__byFullTypeName_to_TypeInfo.get(fullTypeName);
    }


    public TypeInfo getTypeInfo_byFullTypeName(String packageName, String... nestedTypeNames) {

        StringBuilder fullTypeName = new StringBuilder(packageName);

        for (String nestedName : nestedTypeNames) {
            fullTypeName.append('.').append(nestedName);
        }

        return getTypeInfo_byFullTypeName(fullTypeName.toString());

    }

    public Collection getTypeInfoList_byRootTypeName(String rootTypeName) {
        return typeInfoMultiValueIndex__byRootFullTypeName_to_TypeInfo.getCollection(rootTypeName);
    }


    public LangSymbolTable_File get_SymbolTableFile_forType__byFullTypeName(String fullTypeName) {
        return typeName_to_SymbolTableFile_Map__byFullTypeName.get(fullTypeName);
    }
    public Collection get_SymbolTableFileList_forTypes__bySimpleNameWithNestedName(String simpleNameWithNestedNames) {
        return typeName_to_SymbolTableFile_MultiValueMap__bySimpleNameWithNestedNames.getCollection(simpleNameWithNestedNames);
    }
    public Collection get_SymbolTableFileList_forTypes__bySimpleName(String simpleName) {
        return typeName_to_SymbolTableFile_MultiValueMap__bySimpleName.getCollection(simpleName);
    }



    public Collection getFromType_MethodList(String fullTypeName, String methodName) throws Exception_FindTypeName {
        TypeInfo typeInfo = getTypeInfo_byFullTypeName(fullTypeName);

        if (typeInfo != null) {
            Collection methodLangSymbol_List = typeInfo.getMethods(methodName);
            if (methodLangSymbol_List != null)
                return methodLangSymbol_List;
            else
                throw new Exception_FindTypeName("Could not find a method, " + methodName +", for the type, " + fullTypeName);
        } else {
            throw new Exception_FindTypeName("While accessing the method, " + methodName +", could not find its type: " + fullTypeName);
        }
    }

    public LangSymbol_Variable getFromType_FieldVar(String fullTypeName, String fieldVarName) throws Exception_FindTypeName {
        TypeInfo typeInfo = getTypeInfo_byFullTypeName(fullTypeName);

        if (typeInfo != null) {
            LangSymbol_Variable fieldLangSymbol = typeInfo.getField(fieldVarName);
            if (fieldLangSymbol != null)
                return fieldLangSymbol;
            else
                throw new Exception_FindTypeName("Could not find the field varaible, " + fieldVarName +", for the type, " + fullTypeName);
        } else {
            throw new Exception_FindTypeName("While accessing the field variable, " + fieldVarName +", could not find its type: " + fullTypeName);
        }
    }


    public List<TypeUsageInfo> getTypeUsageInfoList_FullTypesToBeResolved() { return typeUsageInfoList_FullTypesToBeResolved;}











    /**
     * Set the full type names for the types usages (liked extending a type or local vars or fields...) using the class finder.
     * We had to wait until now to do this
     * because we need to have the typeInfo's for all the different types in the system before we can use the class finder to search
     * for the inherited types' full type names.
     */
    public void setTypeUsage_FullTypeName() throws Exception_FindTypeName {

        //  inheritance type, interfaces, field vars, method: return types, parameters, local vars
        //

        for (TypeUsageInfo typeUsageInfo : typeUsageInfoList_FullTypesToBeResolved) {
        
            if (typeUsageInfo.getVariableCategory() == LangSymbol_Variable.VariableCategory.ComplexType) {

                TypeInfo_SrcCodeFileInfo srcCodeFileInfo = typeUsageInfo.getParent_SymbolTableFile();
                TypeFinder__inSrcCodeFile_Scope typeFinder = new TypeFinder__inSrcCodeFile_Scope(srcCodeFileInfo, this);


                String fullTypeName = null;

    //  TODO - implement interfaces;
                if (typeUsageInfo.is_TypeUsageFor_Inheritence()) {
                    fullTypeName = typeFinder.find_FullTypeName_forInheritedTypes(
                        Arrays.asList(typeUsageInfo.getActualUsage_Parts()), typeUsageInfo.getCurrTypeInfo(),
                        srcCodeFileInfo.getSrcCodeFilePackage());
                } else {
                    if (typeUsageInfo.getCurrTypeInfo() != null)
                        fullTypeName = typeFinder.find_FullTypeName(Arrays.asList(typeUsageInfo.getActualUsage_Parts()),
                            typeUsageInfo.getCurrTypeInfo().get_Name_withNestedNames(), srcCodeFileInfo.getSrcCodeFilePackage());
                    else {
    //  TODO - turn this type check error back on, when you've implemented interfaces;
                    }
                }

                if (fullTypeName != null) {
                    typeUsageInfo.setFullTypeName(fullTypeName);
                    typeUsageInfo.setNameWithNestedNames(typeFinder.getTypeNameWithNestedNames());
                    typeUsageInfo.setPackageName(typeFinder.getTypeNamePackage());
                } else {
    //  TODO - turn this type check error back on, when you've implemented typeFinder that uses jars/class files
    //                    throw new Exception_FindTypeName("Could not find the type in the classpath for the type name," + fullTypeName);
                }


                
            } else if (typeUsageInfo.getVariableCategory() == LangSymbol_Variable.VariableCategory.DescriptorVar) {

                typeUsageInfo.setFullTypeName(DescriptorClass_FullTypeName);
                typeUsageInfo.setNameWithNestedNames(DescriptorClass_SimpleName);
                typeUsageInfo.setPackageName(DescriptorClass_PackageName);
            }
            
        }


    }


}
