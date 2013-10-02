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

import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol.PrimitiveType;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol_Variable.VariableCategory;
import java.util.List;



/**
 * A TypeUsageInfo is a element in the code that uses a type, and may need to resolved to a full type name. Good examples are:
 * variable declarations, return types, inheritence declarations, implemented interfaces...
 *
 * The way it works is first, you set the actualUsage codeString. then, later, when the symbol tables have been created with all the type info,
 * you go back and find all these typeUsageInfo objects, and set their full types.
 * @author peterjoh
 */
public class TypeUsageInfo {



    private LangSymbol                      parentSymbol;
    private LangSymbolTable_File            parent_SymbolTableFile;
    private TypeInfo                        parentTypeInfo;

    private LangSymbol_Variable             associated_LangSymbolVar;

    private boolean                                 is_TypeUsageFor_Inheritence;
    private LangSymbol_Variable.VariableCategory    variableCategory;

    private String          actualUsage;
    private String[]        actualUsage_Parts;

    private LangSymbol.PrimitiveType                primitiveType;

    private String          fullTypeName;
    private String[]        fullTypeName_Parts;
    private String          nameWithNestedNames;
    private String[]        nameWithNestedNames_Parts;
    private String          packageName;





    /**
     * Void TypeUsageInfo
     *
     * @param parent_SymbolTableFile   The parent_SymbolTableFile that this TypeUsageInfo belongs in. The reason it's passed in is so that
     *                                  when we go back and find the full type for this Type Usage, we have its File symbolTable
     */
    public TypeUsageInfo(LangSymbolTable_File parent_SymbolTableFile, TypeInfo parentTypeInfo, List<TypeUsageInfo> typeInfoList_Full) {
        this(LangSymbol_Variable.VariableCategory.Void, null, null, null, parent_SymbolTableFile, parentTypeInfo, typeInfoList_Full);
    }
    /**
     * Primitive TypeUsageInfo
     *
     * @param parent_SymbolTableFile   The parent_SymbolTableFile that this TypeUsageInfo belongs in. The reason it's passed in is so that
     *                                  when we go back and find the full type for this Type Usage, we have its File symbolTable
     */
    public TypeUsageInfo(PrimitiveType primitiveType, LangSymbolTable_File parent_SymbolTableFile, TypeInfo parentTypeInfo,
            List<TypeUsageInfo> typeInfoList_Full) {
        this(LangSymbol_Variable.VariableCategory.Primitive, primitiveType, null, null, parent_SymbolTableFile, parentTypeInfo, typeInfoList_Full);
    }
    /**
     * Complex TypeUsageInfo
     *
     * @param parent_SymbolTableFile   The parent_SymbolTableFile that this TypeUsageInfo belongs in. The reason it's passed in is so that
     *                                  when we go back and find the full type for this Type Usage, we have its File symbolTable
     */
    public TypeUsageInfo(String complexType_ActualCodeString, LangSymbolTable_File parent_SymbolTableFile, TypeInfo parentTypeInfo,
            List<TypeUsageInfo> typeInfoList_Full) {
        this(LangSymbol_Variable.VariableCategory.ComplexType, null, complexType_ActualCodeString, null, parent_SymbolTableFile, parentTypeInfo, typeInfoList_Full);
    }


    /**
     * Descriptor Var TypeUsageInfo
     *
     * @param parent_SymbolTableFile   The parent_SymbolTableFile that this TypeUsageInfo belongs in. The reason it's passed in is so that
     *                                  when we go back and find the full type for this Type Usage, we have its File symbolTable
     */
    public TypeUsageInfo(String complexType_ActualCodeString, boolean isDescriptorVar, LangSymbolTable_File parent_SymbolTableFile,
            TypeInfo parentTypeInfo, List<TypeUsageInfo> typeInfoList_Full) {
        this(LangSymbol_Variable.VariableCategory.DescriptorVar, null, complexType_ActualCodeString, null, parent_SymbolTableFile, parentTypeInfo, typeInfoList_Full);
    }


    private TypeUsageInfo(LangSymbol_Variable.VariableCategory variableCategory, PrimitiveType primitiveType, 
            String actualUsage_CodeString,
            LangSymbol parentSymbol, LangSymbolTable_File parent_SymbolTableFile, TypeInfo parentTypeInfo, List<TypeUsageInfo> typeInfoList_Full) {

        this.variableCategory = variableCategory;
        this.primitiveType = primitiveType;
        if (actualUsage_CodeString != null)
            setActualUsage(actualUsage_CodeString);

        this.parentSymbol = parentSymbol;
        this.parent_SymbolTableFile = parent_SymbolTableFile;
        this.parentTypeInfo = parentTypeInfo;

        this.is_TypeUsageFor_Inheritence = false;

        fullTypeName = null;

        if (typeInfoList_Full != null)
            typeInfoList_Full.add(this);

    }






    
    public void setParentSymbol(LangSymbol parentSymbol) { this.parentSymbol = parentSymbol; }
    public void setParentTypeInfo(TypeInfo parentTypeInfo) { this.parentTypeInfo = parentTypeInfo; }
    public void setParent_SymbolTableFile(LangSymbolTable_File parent_SymbolTableFile) { this.parent_SymbolTableFile = parent_SymbolTableFile; }
    /** May or may not have this! It's the associated var symbol for the type usage info obj. ttypeInfUsage objs for things like fields and local vars have
     *  Associated LangSymbol Vars, but return types and inherited types do not. This is used by the Metacompiler. Once it's updated the type usage info
     *  with its full type name, if there's an associated langsym var, it will go and update this var with the new info. */
    public void setAssociated_LangSymbolVar(LangSymbol_Variable associated_LangSymbolVar) { this.associated_LangSymbolVar = associated_LangSymbolVar;}




    public void setActualUsage(String actualUsage) {
        this.actualUsage = actualUsage;
        actualUsage_Parts = actualUsage.split("\\."); // TODO - this is wrong!! why? because the stuff inside of the generics an have '.' too!
    }

    public void set__Is_TypeUsageFor_Inheritence(boolean is_TypeUsageFor_Inheritence) { this.is_TypeUsageFor_Inheritence = is_TypeUsageFor_Inheritence; }
    public void setVariableCategory(VariableCategory variableCategory) { this.variableCategory = variableCategory; }

    public void setPrimitiveType(PrimitiveType primitiveType) { this.primitiveType = primitiveType; }
    public void setFullTypeName(String fullTypeName) {
        this.fullTypeName = fullTypeName;
        fullTypeName_Parts = fullTypeName.split("\\."); // TODO - this is wrong!! why? because the stuff inside of the generics an have '.' too!
    }
    public void setNameWithNestedNames(String nameWithNestedNames) {
        this.nameWithNestedNames = nameWithNestedNames;
        nameWithNestedNames_Parts = nameWithNestedNames.split("\\."); // TODO - this is wrong!! why? because the stuff inside of the generics an have '.' too!
    }
    public void setPackageName(String packageName) { this.packageName = packageName; }



    public LangSymbol           getParentSymbol() { return parentSymbol; }
    public LangSymbolTable_File getParent_SymbolTableFile() { return parent_SymbolTableFile;}
    public TypeInfo             getCurrTypeInfo() { return parentTypeInfo; }

    /** See Javadoc for setAssociated_LangSymbolVar() for more info. */
    public boolean              has_Associated_LangSymbolVar() { return associated_LangSymbolVar != null; }
    /** See Javadoc for setAssociated_LangSymbolVar() for more info. */
    public LangSymbol_Variable  getAssociated_LangSymbolVar() { return associated_LangSymbolVar; }


    public String               getActualUsage() { return actualUsage; }
    public String[]             getActualUsage_Parts() { return actualUsage_Parts; }

    public boolean              is_TypeUsageFor_Inheritence() {return is_TypeUsageFor_Inheritence; }
    public VariableCategory     getVariableCategory() { return variableCategory; }

    public PrimitiveType        getPrimitiveType() { return primitiveType; }
    public String               getFullTypeName() { return fullTypeName; }
    public String[]             getFullTypeName_Parts() { return fullTypeName_Parts; }
    public String               getNameWithNestedNames() { return nameWithNestedNames; }
    public String[]             getNameWithNestedNames_Parts() { return nameWithNestedNames_Parts; }
    public String               getPackageName() { return packageName; }



    

}
