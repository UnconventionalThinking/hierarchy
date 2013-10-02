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


package net.unconventionalthinking.matrix.metacompiler.codegen;


import net.unconventionalthinking.utilities.ListUtilities;
import java.util.*;

import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.compiler.tools.CodeBuilder;

import net.unconventionalthinking.exceptions.*;
import net.unconventionalthinking.matrix.utilities.*;
import net.unconventionalthinking.hierarchy.HierarchySettings;



/**
 *
 * @author peterjoh
 */
public class Symbol_MultiLevel__CodeGenerator {

    public SymbolControl symbolControl;
    public Symbol_MultiLevel_Factory multiLevelSymbolFactory;

    public Symbol_MultiLevel__CodeGenerator(SymbolControl symbolControl) {
        this.symbolControl = symbolControl;
        multiLevelSymbolFactory = symbolControl.multiLevelSymbol_Factory;
    }





    public DescriptorTag generate_DescriptorTag_CreationCode(CodeBuilder codeBuilder, CodeGen_OutputResults outputResults,
            DescriptorTagName descTagName, MatrixName schemaName, boolean creation_Has_StaticVersion, String symbolFileName)
            throws Exception_InvalidArgumentPassed, Exception_MultiLevelSymbolCreationOrAccess {

        DescriptorTag descTag = null;

        descTag = multiLevelSymbolFactory.createNew_DescriptorTag(schemaName, descTagName, creation_Has_StaticVersion);
        if (descTag == null)
            throw new Exception_MultiLevelSymbolCreationOrAccess("Could not create the DescriptorTag symbol, with descriptorTagname, " + descTagName +
                    ", and with schema name: " + schemaName);


        //  The symbol should be a multilevel symbol at this point
        create_MultiLevelSymbol_AccessCode(codeBuilder, outputResults, SymbolType.DescriptorTag, descTag, symbolFileName);

        return descTag;
    }

    public DescriptorTag generate_DescriptorTag_AccessCode(CodeBuilder codeBuilder, CodeGen_OutputResults outputResults,
            DescriptorTagName descTagName, MatrixName schemaName, String symbolFileName)
            throws Exception_InvalidArgumentPassed, Exception_MultiLevelSymbolCreationOrAccess {


        DescriptorTag descTag = null;
        descTag = symbolControl.descTag_Index.getDescriptorTag_BySchemaNameAndDescTagName(schemaName, descTagName);
        if (descTag == null)
            throw new Exception_MultiLevelSymbolCreationOrAccess("Could not access the DescriptorTag symbol, with descriptorTagname, " + descTagName +
                    ", and with schema name: " + schemaName);


        create_MultiLevelSymbol_AccessCode(codeBuilder, outputResults, SymbolType.DescriptorTag, descTag, symbolFileName);

        return descTag;
    }




    public MatrixName generate_SchemaOrMatrixName_CreationCode(CodeBuilder codeBuilder, CodeGen_OutputResults outputResults,
            boolean creatingSchemaName, DescriptorTagName schemaOrMatrixName_DescTagName, DescriptorTagName packageName,
            boolean creation_Has_StaticVersion, String symbolFileName)
            throws Exception_InvalidArgumentPassed, Exception_MultiLevelSymbolCreationOrAccess {

        MatrixName schemaOrMatrixName = null;

        if (creatingSchemaName) {
            schemaOrMatrixName = multiLevelSymbolFactory.createNew_SchemaName(packageName, schemaOrMatrixName_DescTagName, creation_Has_StaticVersion);
        } else {
            schemaOrMatrixName = multiLevelSymbolFactory.createNew_MatrixName(packageName, schemaOrMatrixName_DescTagName, creation_Has_StaticVersion);
        }

        if (schemaOrMatrixName == null)
            throw new Exception_MultiLevelSymbolCreationOrAccess("Could not create the Schema or Matrix Name symbol, with name, " + schemaOrMatrixName +
                    ", in package: " + packageName);


        SymbolType symbolType = (creatingSchemaName) ? SymbolType.SchemaName : SymbolType.MatrixName;
        create_MultiLevelSymbol_AccessCode(codeBuilder, outputResults, symbolType, schemaOrMatrixName, symbolFileName);

        return schemaOrMatrixName;
    }

    public MatrixName generate_SchemaOrMatrixName_AccessCode(CodeBuilder codeBuilder, CodeGen_OutputResults outputResults,
            boolean creatingSchemaName, DescriptorTagName schemaOrMatrixName_DescTagName, DescriptorTagName packageName,
            String symbolFileName)
            throws Exception_InvalidArgumentPassed, Exception_MultiLevelSymbolCreationOrAccess {

        MatrixName schemaOrMatrixName = null;

        if (creatingSchemaName) {
            schemaOrMatrixName = symbolControl.schemaName_Index.getSchemaName_ByPackageAndSchemaName(packageName, schemaOrMatrixName_DescTagName);
        } else {
            schemaOrMatrixName = symbolControl.matrixName_Index.getMatrixName_ByPackageAndMatrixName(packageName, schemaOrMatrixName_DescTagName);
        }

        if (schemaOrMatrixName == null)
            throw new Exception_MultiLevelSymbolCreationOrAccess("Could not access the Schema or Matrix Name symbol, with name, " + schemaOrMatrixName +
                    ", in package: " + packageName);


        SymbolType symbolType = (creatingSchemaName) ? SymbolType.SchemaName : SymbolType.MatrixName;
        create_MultiLevelSymbol_AccessCode(codeBuilder, outputResults, symbolType, schemaOrMatrixName, symbolFileName);

        return schemaOrMatrixName;
    }


    


    public CodeBuilder create_MultiLevelSymbol_AccessCode(CodeBuilder codeBuilder, CodeGen_OutputResults outputResults,
            SymbolType symbolType, Symbol_MultiLevel_Base multiLevelSymbol, String symbolFile_BaseName)
            throws Exception_InvalidArgumentPassed_Null {

        if (multiLevelSymbol.has_StaticReference()) {
            if (symbolFile_BaseName != null) {
                
                String symbolFileName = null;
                if (symbolType == SymbolType.DescriptorTag)
                    symbolFileName = symbolFile_BaseName + HierarchySettings.symbolClassSuffix_DescTag;
                else if (symbolType == SymbolType.SchemaName)
                    symbolFileName = symbolFile_BaseName + HierarchySettings.symbolClassSuffix_SchemaName;
                else if (symbolType == SymbolType.MatrixName)
                    symbolFileName = symbolFile_BaseName + HierarchySettings.symbolClassSuffix_MatrixName;


                codeBuilder.append(symbolFileName + "." + multiLevelSymbol.get_Name_IdentFormat());

            } else
                throw new Exception_InvalidArgumentPassed_Null( "Tried to create the static access code for the multiLevel " + symbolType.toString() + ": "
                        + multiLevelSymbol.get_Name_IdentFormat() + ", with id " + multiLevelSymbol.getID() + ", but you passed in a null SymbolFile Name.");


        } else {// do dynamic access
            if (symbolType == SymbolType.DescriptorTag)
                codeBuilder.append(CodeConstants.SymbolIndex__getDescTag_ById + "(" + multiLevelSymbol.getID() +")");
            else if (symbolType == SymbolType.SchemaName)
                codeBuilder.append(CodeConstants.SymbolIndex__getSchemaName_ById + "(" + multiLevelSymbol.getID() +")");
            else if (symbolType == SymbolType.MatrixName)
                codeBuilder.append(CodeConstants.SymbolIndex__getMatrixName_ById + "(" + multiLevelSymbol.getID() +")");
        }

        //  Add import for symbols
        outputResults.addImport(CodeConstants.MatrixImports_Symbols);

        return codeBuilder;

    }



}
