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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author peterjoh
 */
public interface TypeInfo_SrcCodeFileInfo {

    //  TypeInfo Related Methods
    public void addTypeInfo_to_FilesTypeList(TypeInfo typeInfo);
    public void setSrcCodeFileName(String fileName);
    public void setSrcCodeFilePackage(String packageName);


    //  Import Related Methods


    public void addSymbol_Import_Package(LangSymbol_Import_Package importSymbol);
    public void addSymbol_Import_Type(LangSymbol_Import_Type importSymbol);

    public LangSymbol_Import lookup_Import(String importName_ClassOrPackage);
    public LangSymbol_Import lookup_ImportType(String importName_Type);
    public List<LangSymbol_Import_Type> lookup_ImportType__bySimpleName(String finalTypeName);

    public LangSymbol_Import lookup_ImportPackage(String importName_Package);




    
    //  Get Methods

    public LinkedHashMap<String, LangSymbol_Import>         getSymbolTable_Imports();
    public LinkedHashMap<String, LangSymbol_Import_Type>    getSymbolTable_Import_Type();
    public LinkedHashMap<String, LangSymbol_Import_Package> getSymbolTable_Import_Package();



    public String getSrcCodeFileName();
    public String getSrcCodeFilePackage();

    public List<TypeInfo> getTypeInfo_List();



}