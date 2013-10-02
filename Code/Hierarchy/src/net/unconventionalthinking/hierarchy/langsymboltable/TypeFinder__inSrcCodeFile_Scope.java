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

import net.unconventionalthinking.utilities.ListUtilities;
import net.unconventionalthinking.utilities.StringUtilities;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author peterjoh
 */
public class TypeFinder__inSrcCodeFile_Scope {


    /**  IMPORTANT - Since we don't search Jars/class files yet, we can't check for Not found yet.
     * Remove this when you do add it in!!!
     */
    static final boolean HANDLE_NOTFOUND_ERROR__REMOVE_LATER = false;

    public enum TypeFindLocation { SearchTypeIsFullTypeName, CurrType, InheritedTypes, NestedType, ExplicitImport, TypeInSamePackage, ImplicitImport }

    private TypeInfo_SrcCodeFileInfo srcCodeFileInfo;
    private LangSymbolTable_App typeInfoIndex;

    private String fullTypeName;
    private String typeNameWithNestedNames;
    private String typeNamePackage;

    private TypeFindLocation typeFindLocation;


    public TypeFinder__inSrcCodeFile_Scope(TypeInfo_SrcCodeFileInfo srcCodeFileInfo, LangSymbolTable_App typeInfoIndex) {
        this.srcCodeFileInfo = srcCodeFileInfo;
        this.typeInfoIndex = typeInfoIndex;

        typeFindLocation = null;
    }




 
    /**
     *
     * Examples of when you'd use this is if you're compiling a class and you're in the scope of one of the methods, and you have
     * some type that you want to get the full type name for. For instance, you have a local var declared (MyClass myLocalVar), or a parameter, and you
     * want to find its full type name. Also, if you're class extends a type:  class MyClass extends AnotherClass, and you want
     * to get the full type name of the extended class (so, here it'd be something like "mypackage.AnotherClass").
      */
    public String find_FullTypeName(List<String> searchTypeName_Parts, String currTypeName_withNestedNames, String currPackage)
        throws Exception_FindTypeName {

        typeFindLocation = null;
        fullTypeName = null;
        
        boolean foundTypeName = false;

        int indexOfLastDot = currTypeName_withNestedNames.lastIndexOf('.');
        String currTypeName_Simple = (indexOfLastDot > 0 ? currTypeName_withNestedNames.substring(indexOfLastDot + 1) : currTypeName_withNestedNames);
        
        String currTypeName_Full = currPackage + "." + currTypeName_withNestedNames;
        TypeInfo currType_TypeInfo = typeInfoIndex.getTypeInfo_byFullTypeName(currTypeName_Full);

        String searchTypeName = ListUtilities.printWithDot(searchTypeName_Parts);

        

        //  First, see if this type name is actuall a full, type name
        if (searchTypeName_Parts.size() > 0)
            foundTypeName  = check_FullTypeName(searchTypeName);


        if (foundTypeName) {
            typeFindLocation = TypeFindLocation.SearchTypeIsFullTypeName;

        } else { // not a full typeName, it's a simple name (or a simple name with nested elements)

            //  Find the class name. This information is taken from, "The Java Language Specification," pg. 469

            //  Step 1 - Check against current type's name
            if (searchTypeName.equals(currTypeName_withNestedNames) || 
                searchTypeName.equals(currTypeName_Simple)) {
                
                fullTypeName = currTypeName_Full;
                typeNameWithNestedNames = currTypeName_withNestedNames;
                typeNamePackage = currPackage;
                typeFindLocation = TypeFindLocation.CurrType;

            //  Step 2 - Check against the current type's inherited types
            } else if (findMatch_InheritedTypes(searchTypeName, currType_TypeInfo)) {
                typeFindLocation = TypeFindLocation.InheritedTypes;

            //  Step 3 - check against any nested types
            } else if (findMatch_NestedTypes(searchTypeName_Parts, currType_TypeInfo)) {
                typeFindLocation = TypeFindLocation.NestedType;

            //  Step 4 - check "Explicitly named import types"
            } else if (findMatch_ExplicitImportsTypes(searchTypeName_Parts)) {
                typeFindLocation = TypeFindLocation.ExplicitImport;

            //  Step 5 - check types in the same package
            } else if (findMatch_TypesInSamePackage(searchTypeName, currPackage)) {
                typeFindLocation = TypeFindLocation.TypeInSamePackage;

            //  Step 6 - check "Implicitly imported types"
            } else if (findMatch_ImplicitImportsTypes(searchTypeName)) {
                typeFindLocation = TypeFindLocation.ImplicitImport;

            } 
        }

        // TODO - remove HANDLE_NOTFOUND_ERROR__REMOVE_LATER when you add jar/class search.
        if (HANDLE_NOTFOUND_ERROR__REMOVE_LATER && fullTypeName == null)
            throw new Exception_FindTypeName("Could not find the type, '" + searchTypeName+ "'. You may need to add it to your imports.");

        return fullTypeName;

    }



    /**
     * This version is used my a metacompiler to find the full type name of inherited types
     */
    public String find_FullTypeName_forInheritedTypes(List<String> typeNameParts, TypeInfo currType_TypeInfo, String currPackage)
            throws Exception_FindTypeName {

        typeFindLocation = null;
        fullTypeName = null;

        String searchTypeName = ListUtilities.printWithDot(typeNameParts);
        boolean foundTypeName = false;
        if (typeNameParts.size() > 0)
            foundTypeName = check_FullTypeName(searchTypeName);

        if (foundTypeName)
            return fullTypeName;

        //  Step 3 - check against any nested types
        if (findMatch_NestedTypes(typeNameParts, currType_TypeInfo)) {
            typeFindLocation = TypeFindLocation.NestedType;

        //  Step 4 - check "Explicitly named import types"
        } else if (findMatch_ExplicitImportsTypes(typeNameParts)) {
            typeFindLocation = TypeFindLocation.ExplicitImport;

        //  Step 5 - check types in the same package
        } else if (findMatch_TypesInSamePackage(searchTypeName, currPackage)) {
            typeFindLocation = TypeFindLocation.TypeInSamePackage;

        //  Step 6 - check "Implicitly imported types"
        } else if (findMatch_ImplicitImportsTypes(searchTypeName)) {
            typeFindLocation = TypeFindLocation.ImplicitImport;

        }

        if (HANDLE_NOTFOUND_ERROR__REMOVE_LATER && fullTypeName == null)
            throw new Exception_FindTypeName("Could not find the type, '" + searchTypeName+ "'. You may need to add it to your imports.");

        return fullTypeName;

    }



    public TypeFindLocation getTypeFindLocation() { return typeFindLocation; }

    public String getFullTypeName() { return fullTypeName; }
    public String getTypeNamePackage() { return typeNamePackage;}
    public String getTypeNameWithNestedNames() { return typeNameWithNestedNames;}







    private boolean check_FullTypeName(String searchTypeName) {

        boolean foundTypeName = false;
        TypeInfo foundTypeInfo = typeInfoIndex.getTypeInfo_byFullTypeName(searchTypeName);
        if (foundTypeInfo != null) {
            foundTypeName = true;
            setFoundTypeNameValues(foundTypeInfo);
        }


        return foundTypeName;
    }

    private boolean findMatch_InheritedTypes(String searchTypeName, TypeInfo currType_TypeInfo) {

    
        boolean foundTypeName = false;

        if (currType_TypeInfo.has_InheritedType()) {


            if (searchTypeName.equals(currType_TypeInfo.get_Inheritance_TypeUsageInfo().getNameWithNestedNames())) { // match!!

                String inheritedTypeFullTypeName = currType_TypeInfo.get_Inheritance_TypeUsageInfo().getFullTypeName();

                //  try the current source code:
                foundTypeName = check_FullTypeName(inheritedTypeFullTypeName);

                if (!foundTypeName) {
                    // it's a type from a jar or class file - NOT SUPPORTED YET!
                }
            } else {
                // no match, try further up the inheritence chain

                TypeInfo inheritedType_TypeInfo = typeInfoIndex.getTypeInfo_byFullTypeName(currType_TypeInfo.get_Inheritance_TypeUsageInfo().getFullTypeName());
                if (inheritedType_TypeInfo != null) {
                    foundTypeName = findMatch_InheritedTypes(searchTypeName, inheritedType_TypeInfo);
                } else {
                    // the inherited type is from a jar or class files - NOT SUPPORTED YET
                }
            }

        }

        return foundTypeName;
    }

    /**
        We need to be able to handle all these situations for inner classes types references:
        public class OuterClass {
            public InnerClass f0;
            public InnerClass.SecondInnerClass f1;
            public OuterClass.InnerClass.SecondInnerClass f2;
            //public SecondInnerClass f2; // bad, not in scope
   
            class InnerClass {
                class OuterClass { }
            }
        }
     */
    private boolean findMatch_NestedTypes(List<String> searchTypeName_Parts, TypeInfo outer_TypeInfo) {

        TypeInfo prev_TypeInfo = outer_TypeInfo;
        TypeInfo curr_TypeInfo = null;

        int i = 0;
        //  this means the searchTypeNames starts with the OuterClass. Skip to the next search part (and note,
        //  if the this is true, then there MUST be a second part name, because if there was only one part, then the previous check
        //  against the current class name would be true and we don't reach this point);
        if (searchTypeName_Parts.get(0).equals(outer_TypeInfo.get_Name_Simple()))
            i = 1;

        boolean continueSearching__haveFoundMatches = true;
        for (; continueSearching__haveFoundMatches && i < searchTypeName_Parts.size(); i++) {
            String namePart = searchTypeName_Parts.get(i);
            curr_TypeInfo = prev_TypeInfo.get_NestedChildTypeInfo(namePart);

            if (curr_TypeInfo == null)
                continueSearching__haveFoundMatches = false;
            else
                prev_TypeInfo = curr_TypeInfo;

        }

        if (curr_TypeInfo != null) {
            // we found a matching nested type.
            setFoundTypeNameValues(curr_TypeInfo);
            return true;
        } else {
            return false;
        }


    }



    private boolean findMatch_ExplicitImportsTypes(List<String> searchTypeName_Parts) throws Exception_FindTypeName {

        // For explicit imports, we only need to search the first part of the type name. Why? because you import the type that
        // you can then start to reference off of:
        // import mypackage.OuterClass;
        // ...
        // OuterClass.InnerClass var;

        String firstPartName = searchTypeName_Parts.get(0);

        List<LangSymbol_Import_Type> matchingImports = srcCodeFileInfo.lookup_ImportType__bySimpleName(firstPartName);

        if (matchingImports != null) {
            if (matchingImports.size() == 1) {

                String foundMatchType = matchingImports.get(0).name;

                // now, add the rest of the inner types:
                StringBuilder fullTypeName_Builder = new StringBuilder(foundMatchType);
                for (int i = 1; i < searchTypeName_Parts.size(); i++) {
                    fullTypeName_Builder.append(".").append(searchTypeName_Parts.get(i));
                }

                String fullTypeNameString = fullTypeName_Builder.toString();
                boolean foundTypeName = false;
                TypeInfo foundTypeInfo = typeInfoIndex.getTypeInfo_byFullTypeName(fullTypeNameString);

                if (foundTypeInfo != null) {
                    setFoundTypeNameValues(foundTypeInfo);
                } else {
                    // it's a type from a jar or class file - NOT SUPPORTED YET!
                }
                return true;

            } else if (matchingImports.size() == 0) {
                return false;
            } else { // ERROR: multiple imports found
                throw new Exception_FindTypeName("There are multiple imports for the type, " + firstPartName + ". This is ambiguous. The types are: " +
                    ListUtilities.print(matchingImports, ", "));

            }
        } else {
            return false;
        }
    }

    
    private boolean findMatch_TypesInSamePackage(String searchTypeName, String currPackage) {

        TypeInfo foundTypeInfo = typeInfoIndex.getTypeInfo_byFullTypeName(currPackage, searchTypeName);
        if (foundTypeInfo != null) {
            setFoundTypeNameValues(foundTypeInfo);
            return true;

        } else {
            // Try searching jars and class files - NOT SUPPORTED YET!

        }

        return false;
    }

    private boolean findMatch_ImplicitImportsTypes(String searchTypeName) throws Exception_FindTypeName  {

        // *** Current Algorithm: Try each: <implicit import> + <search simple name> combination until you find a match.
        // This is probably not the best performing way to do this.
        //
        // TODO - findMatch_ImplicitImportsTypes() - Later, when you add a type to the typeInfo Index, create a multivalue hash that indexes types by their simple names (all the variations for nested types).


        Collection<LangSymbol_Import_Package> implicitImports = srcCodeFileInfo.getSymbolTable_Import_Package().values();

        if (implicitImports != null && implicitImports.size() > 0) {

            // try each <implicit import> + <search simple name> combination for all possible matches
            List<TypeInfo> foundTypes_List = new ArrayList<TypeInfo>();

            for (LangSymbol_Import_Package packageSymbol : implicitImports) {
                TypeInfo found_Import = null;
                if ((found_Import = typeInfoIndex.getTypeInfo_byFullTypeName(packageSymbol.packageName + "." + searchTypeName)) != null)
                    foundTypes_List.add(found_Import);
            }

            if (foundTypes_List.size() == 1) {
                setFoundTypeNameValues(foundTypes_List.get(0));
                return true;
                
            } else if (foundTypes_List.size() == 0) {

            } else { // ERROR: reference to <type name> is ambiguous. All these are possible matches:
                throw new Exception_FindTypeName("There are multiple matches for the type, " + searchTypeName + ". This is ambiguous. The matching types are: " +
                    ListUtilities.print(foundTypes_List, ", "));
            }


            return false;
 
        } else {
            return false;
        }
    }







    private void setFoundTypeNameValues(TypeInfo foundTypeInfo) {
        fullTypeName = foundTypeInfo.get_FullTypeName();
        typeNameWithNestedNames = foundTypeInfo.get_Name_withNestedNames();
        typeNamePackage = foundTypeInfo.get_PackageName();
    }



}
