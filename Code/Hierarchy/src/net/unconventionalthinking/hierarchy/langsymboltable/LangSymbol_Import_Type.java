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

import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.SymbolUtilities;
import net.unconventionalthinking.utilities.ListUtilities;
import java.util.List;

/**
 *
 * @author peterjoh
 */
public class LangSymbol_Import_Type extends LangSymbol_Import {

    public enum ImportType_Class { JavaImport, MP_SchemaImport, MP_MatrixImport }

    /** This is just the short, simple name of an imported type. Ex, for a Matrix import like com.mypackage::My.Matrix, it'd be the simple
     *  matrix name, My.Matrix. */
    public final String             name_Simple;
    public final ImportType_Class   importType_Class;

    public final String                     mpImport__Identifier_Full;
    public final List<String>               mpImport__Identifier_Parts;
    public final List<DescriptorTagName>    mpImport__NameScope_PartsList;

    public final String                     mpImport__MatrixName_Full;



    public static LangSymbol_Import_Type createSymbol__SchemaImportType(String identifier_Full, List<String> identifier_Parts,
            List<DescriptorTagName> nameScope_PartsList, int scopeID, Object otherInfo,
            LangSymbolTable_File symbolTable) {

        return createSymbol__MatrixOrSchema_ImportType(true, identifier_Full, identifier_Parts, nameScope_PartsList, scopeID, otherInfo, symbolTable);
    }

    public static LangSymbol_Import_Type createSymbol__MatrixImportType(String identifier_Full, List<String> identifier_Parts,
            List<DescriptorTagName> nameScope_PartsList, int scopeID, Object otherInfo,
            LangSymbolTable_File symbolTable) {

        return createSymbol__MatrixOrSchema_ImportType(false, identifier_Full, identifier_Parts, nameScope_PartsList, scopeID, otherInfo, symbolTable);
    }
    
    public static LangSymbol_Import_Type createSymbol__MatrixOrSchema_ImportType(boolean is_Schema, String identifier_Full,
            List<String> identifier_Parts, List<DescriptorTagName> nameScope_PartsList, int scopeID, Object otherInfo,
            LangSymbolTable_File symbolTable) {

        String typeName_Full = ListUtilities.printWithDot(nameScope_PartsList) + "::" +
                SymbolUtilities.createSymbolNameString_From_Parts(identifier_Parts);

        LangSymbol_Import_Type langSym = new LangSymbol_Import_Type(identifier_Full, identifier_Parts, nameScope_PartsList, typeName_Full,
                (is_Schema ? ImportType_Class.MP_SchemaImport : ImportType_Class.MP_MatrixImport), scopeID, otherInfo);

        if (is_Schema)
            symbolTable.addSymbol_Import_MPType__Schema(langSym);
        else
            symbolTable.addSymbol_Import_MPType__Matrix(langSym);
        
        return langSym;
    }


    public static LangSymbol_Import_Type createSymbol__ImportType(String typeName_withNestedTypes, String packageName, int scopeID, Object otherInfo,
            LangSymbolTable_File symbolTable) {
        return createSymbol__ImportType(packageName + "." + typeName_withNestedTypes, scopeID, otherInfo, symbolTable);
    }
    
    public static LangSymbol_Import_Type createSymbol__ImportType(String typeName_Full, int scopeID, Object otherInfo,
            LangSymbolTable_File symbolTable) {

        LangSymbol_Import_Type langSym = new LangSymbol_Import_Type(typeName_Full, ImportType_Class.JavaImport, scopeID, otherInfo);

        symbolTable.addSymbol_Import_Type(langSym);
        return langSym;

    }



    public String mpImport_GetPackageName() {
        return ListUtilities.printWithDot(mpImport__NameScope_PartsList);
    }

    
    /** This constructor used by Matrix Imports */
    private LangSymbol_Import_Type(String identifier_Full, List<String> identifier_Parts,
            List<DescriptorTagName> nameScope_PartsList, String typeName_Full,  ImportType_Class importType_Class, int scopeID, Object otherInfo) {
        super(typeName_Full, SymbolType.Import_Type, scopeID, otherInfo);


        // this is a matrix import, look for "::"
        int indexOfLastColon = typeName_Full.lastIndexOf("::");

        if (indexOfLastColon < 0) {
            name_Simple = typeName_Full;
        } else {
            name_Simple = typeName_Full.substring(indexOfLastColon + 2);
        }

        this.importType_Class = importType_Class;



        this.mpImport__Identifier_Full = identifier_Full;
        this.mpImport__Identifier_Parts = identifier_Parts;
        this.mpImport__NameScope_PartsList = nameScope_PartsList;

        this.mpImport__MatrixName_Full = ListUtilities.printWithDot(nameScope_PartsList) + "::" + identifier_Full;
        
    }

    /** This constructor is by Java Imports create method. */
    private LangSymbol_Import_Type(String typeName_Full, ImportType_Class importType_Class, int scopeID, Object otherInfo) {
        super(typeName_Full, SymbolType.Import_Type, scopeID, otherInfo);

        int indexOfLastPart = typeName_Full.lastIndexOf('.');
        if (indexOfLastPart < 0) {
            name_Simple = typeName_Full;
        } else {
            name_Simple = typeName_Full.substring(indexOfLastPart + 1);
        }

        this.importType_Class = importType_Class;


        mpImport__Identifier_Full = null;
        mpImport__Identifier_Parts = null;
        mpImport__NameScope_PartsList = null;

        mpImport__MatrixName_Full = null;

    }


}
