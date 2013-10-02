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

import net.unconventionalthinking.compiler.tools.AttributeNode;
import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.compiler.tools.MethodAttributeSet;
import net.unconventionalthinking.lang.Boolean_Mutable;
import net.unconventionalthinking.lang.Integer_Mutable;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.symbols.DescriptorTag;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Exception_MultiPartSymbolAccess;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.MatrixName;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolType;
import net.unconventionalthinking.matrix.symbols.SymbolUtilities;
import net.unconventionalthinking.hierarchy.HierarchyControl;
import net.unconventionalthinking.utilities.HashTools;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.LinkedList;


/**
 *
 * @author peterjoh
 */
public class HierarchyActionsWorker_Symbols extends HierarchyActionsWorker {



    public HierarchyActionsWorker_Symbols(HierarchyActions hierarchyActions, HierarchyControl hierarchyControl, int baseIndentLevel) {
        super(hierarchyActions, hierarchyControl, baseIndentLevel);
    }



    public void generateSymbol_Helper(HierarchyActionsWorker_SymbolMethodSettings symbolMethodSettings, AttributeNode node,
            MethodAttributeSet generateSym_Attribs) {

        SymbolType symbolType = SymbolType.Symbol;
        if (symbolMethodSettings.is_LabelAccessOrCreation != null && symbolMethodSettings.is_LabelAccessOrCreation.value)
                symbolType = SymbolType.Label;

        //  Notice, 'generateAndReturn_DescTagName' trumps 'is_LabelAccessOrCreation'!!
        if ((symbolMethodSettings.is_DescTagNameAccessOrCreation != null && symbolMethodSettings.is_DescTagNameAccessOrCreation.value) ||
            (symbolMethodSettings.generateAndReturn_DescTagName != null && symbolMethodSettings.generateAndReturn_DescTagName.booleanValue()) )
            symbolType = SymbolType.DescriptorTagName;
        

        Symbol symbol_Actual = generate_CreateOrAccessSymbols(generateSym_Attribs.codeBuilder, symbolType, symbolMethodSettings.child_Symbols,
                symbolMethodSettings.symbolCount, symbolMethodSettings.creation_StartLevel);


        node.code(generateSym_Attribs.codeBuilder).append(' ');
        generateSym_Attribs.returnValues.put(HierarchyMethodConstants.retVal_Symbol_Actual, symbol_Actual);

    }




    public Symbol generate_CreateOrAccessSymbols(CodeBuilder codeBuilder, MatrixElementName_Type matrixElementName_Type,
            LinkedList<String> child_Symbols, Integer_Mutable symbolCount, Integer_Mutable creation_StartLevel) {

        SymbolType symbolType = null;
        if (matrixElementName_Type == MatrixElementName_Type.DescriptorTagName) {
            symbolType = SymbolType.DescriptorTagName;
        } else if (matrixElementName_Type == MatrixElementName_Type.Label) {
            symbolType = SymbolType.Label;
        } else if (matrixElementName_Type == MatrixElementName_Type.Symbol) {
            symbolType = SymbolType.Symbol;
        }


        Symbol symbol_Actual = generate_CreateOrAccessSymbols(codeBuilder, symbolType, child_Symbols, symbolCount, creation_StartLevel);

        return symbol_Actual;
    }


    public MatrixName generate_Create_SchemaOrMatrixNameLabel(CodeBuilder codeBuilder, boolean is_SchemaName,
            LinkedList<String> child_Symbols, Integer_Mutable symbolCount, DescriptorTagName packageName) {


        Integer_Mutable creation_StartLevel = new Integer_Mutable(-1); // always creating for schema/matrix name labels
        Symbol symbol_Actual = generate_CreateOrAccessSymbols(codeBuilder, SymbolType.Label, child_Symbols, symbolCount, creation_StartLevel);
        DescriptorTagName schemaOrMatrixName_DescTagName = null;

        try {
            schemaOrMatrixName_DescTagName = SymbolUtilities.convert_Label_to_DescTagName((Label)symbol_Actual, symbolControl);
        } catch (Exception e) {
            hierarchySettings.logger.reportError_And_Exit("Had a Label for a Schema Descriptor, and tried to convert it to a Label, but the passed in label was not valid. ", e);
        }

        // create the schema/matrix names
        boolean is_SchemaOrMatrixName_Creation = true; // always true for schema/matrix name labels
        return generate_CreateOrAccess_MatrixOrSchemaName(codeBuilder, schemaOrMatrixName_DescTagName, packageName, is_SchemaName,
                is_SchemaOrMatrixName_Creation);


    }

    public Symbol generate_CreateOrAccessSymbols(CodeBuilder codeBuilder, SymbolType symbolType,
            LinkedList<String> child_Symbols, Integer_Mutable symbolCount, Integer_Mutable creation_StartLevel) {

        Symbol symbol_Actual = null;


        if (symbolCount.value == 1) { // is single symbol
            String symbolName = child_Symbols.getFirst();


            if (creation_StartLevel.value <= 1) {  // is single creation
                try {
                    symbol_Actual = hierarchyActions.codeGenerators.symbol_CodeGenerator.generate_SymbolCreationCode(codeBuilder,
                            hierarchyActions.outputResults, symbolType, symbolName, hierarchySettings.appSymbols_ClassName);
                } catch (Exception e) {
                    hierarchySettings.logger.reportError_And_Exit("Tried to generate the creation code for a single symbol, but had an error.", e);
                }

            } else {  // is single access
                try {
                    symbol_Actual = hierarchyActions.codeGenerators.symbol_CodeGenerator.generate_SymbolAccessCode(codeBuilder,
                            hierarchyActions.outputResults, symbolType,symbolName, hierarchySettings.appSymbols_ClassName);
                } catch (Exception e) {
                    hierarchySettings.logger.reportError_And_Exit("Tried to generate the access code for a single symbol, but had an error.", e);
                }
            }

        } else {  // is multipart symbol access or creation
            try {
                symbol_Actual = hierarchyActions.codeGenerators.multiPartSymbol_CodeGenerator.generate_MultiPartSymbol_CreationCode(codeBuilder,
                        hierarchyActions.outputResults, symbolType, child_Symbols, creation_StartLevel.value, true, hierarchySettings.appSymbols_ClassName);
            } catch (Exception e) {
                hierarchySettings.logger.reportError_And_Exit("Tried to generate the creation code for a mutlipart symbol, but had an error.", e);
            }
        }


        return symbol_Actual;
    }




    public MatrixName generate_CreateOrAccess_MatrixOrSchemaName(CodeBuilder codeBuilder,
            DescriptorTagName matrixOrSchemaName, DescriptorTagName packageName, boolean is_SchemaName, boolean is_MatrixOrSchemaName_Creation) {


        MatrixName schemaOrMatrixName = null;
        if (is_MatrixOrSchemaName_Creation) {
            try {
                schemaOrMatrixName = hierarchyActions.codeGenerators.multiLevelSymbol_CodeGenerator.generate_SchemaOrMatrixName_CreationCode(codeBuilder,
                        hierarchyActions.outputResults, is_SchemaName, matrixOrSchemaName, packageName, true, hierarchySettings.appSymbols_ClassName);
            } catch (Exception e) {
                hierarchySettings.logger.reportError_And_Exit("Tried to generate the creation code for a Matrix or Schema Name, but had an error." +
                        "The matrix/schema name was," + matrixOrSchemaName + ", and the package name was " + packageName + ".", e);
            }

        } else {  // is access
            try {
                schemaOrMatrixName = hierarchyActions.codeGenerators.multiLevelSymbol_CodeGenerator.generate_SchemaOrMatrixName_AccessCode(codeBuilder,
                        hierarchyActions.outputResults, is_SchemaName, matrixOrSchemaName, packageName, hierarchySettings.appSymbols_ClassName);
            } catch (Exception e) {
                hierarchySettings.logger.reportError_And_Exit("Tried to generate the access code for a Matrix or Schema Name, but had an error." +
                        "The matrix/schema name was," + matrixOrSchemaName + ", and the package name was " + packageName + ".", e);
            }
        }


        return schemaOrMatrixName;
    }





    public DescriptorTag generate_CreateOrAccessDescriptorTag(CodeBuilder codeBuilder,
            LinkedList<String> descTagName_Parts, MatrixName descTag_SchemaName, boolean is_DescriptorTagCreation) {


        DescriptorTagName descTagName = null;
        Exception error = null;
        try {
            descTagName = (DescriptorTagName)symbolControl.multiPartSymbol_Factory.find(SymbolType.DescriptorTagName, descTagName_Parts);
        } catch (Exception_MultiPartSymbolAccess e) {
            error = e;
        }
        if (descTagName == null) {
            //  TODO - HierarchyActions.java - create error handling
            Exception_MetaCompilerError e = new Exception_MetaCompilerError("Trying to access or create a descriptorTag, and searched for the descriptorTagName, " +
                    SymbolUtilities.createSymbolNameString_From_Parts(descTagName_Parts) + ", but could not find it in the descriptorTagName index.", error);
            hierarchySettings.logger.reportError_And_Exit(e);
        }



        DescriptorTag descTag = null;
        if (is_DescriptorTagCreation) {
            try {
                descTag = hierarchyActions.codeGenerators.multiLevelSymbol_CodeGenerator.generate_DescriptorTag_CreationCode(codeBuilder,
                        hierarchyActions.outputResults, descTagName, descTag_SchemaName, true, hierarchySettings.appSymbols_ClassName);
            } catch (Exception e) {
                hierarchySettings.logger.reportError_And_Exit("Tried to generate the creation code for a DescriptorTag (multi-level symbol), but had an error." +
                        " The descriptorTagName was," + descTagName + ", with a schema name of, " + descTag_SchemaName + ".", e);
            }

        } else {  // is access
            try {
                descTag = hierarchyActions.codeGenerators.multiLevelSymbol_CodeGenerator.generate_DescriptorTag_AccessCode(codeBuilder,
                        hierarchyActions.outputResults, descTagName, descTag_SchemaName, hierarchySettings.appSymbols_ClassName);
            } catch (Exception e) {
                hierarchySettings.logger.reportError_And_Exit("Tried to generate the access code for a DescriptorTag (multi-level symbol), but had an error." +
                        " The descriptorTagName was," + descTagName + ", with a schema name of, " + descTag_SchemaName + ".", e);
            }
        }


        return descTag;
    }











    public void processSymbolOption(String symbolName, MethodAttributeSet generateSym_Attribs) {
        LinkedList<String> child_Symbols = (LinkedList<String>) generateSym_Attribs.vars.get(HierarchyMethodConstants.var_Child_Symbols);
        Integer_Mutable symbolCount = (Integer_Mutable) generateSym_Attribs.vars.get(HierarchyMethodConstants.var_SymbolCount);

        child_Symbols.add(symbolName);
        symbolCount.value++;

    }

    public void set_LabelAccessOrCreation(AttributeNode node) {
        MethodAttributeSet generateSym_Attribs = node.getMethodAttributes();

        Integer_Mutable labelCount = (Integer_Mutable) HashTools.get(generateSym_Attribs.vars, HierarchyMethodConstants.var_LabelCount);

        Boolean_Mutable is_LabelAccessOrCreation = (Boolean_Mutable) HashTools.get(generateSym_Attribs.vars, HierarchyMethodConstants.var_Is_LabelAccessOrCreation);

        labelCount.value++;
        is_LabelAccessOrCreation.value = true; // MatrixSet to TRUE!!

        //  Check to make sure every part of a multipart schemaName is schemaName (not a mix of labels and symbols)
        Integer_Mutable symbolCount = (Integer_Mutable) generateSym_Attribs.vars.get(HierarchyMethodConstants.var_SymbolCount);

        if (labelCount.value != symbolCount.value) {  // TODO - hierarchyCompiler error handling - schemaName creation check. *** also, need a more informative error msg with the schemaName names
            Exception_MetaCompilerError e = new Exception_MetaCompilerError("Tried to create a multi-part label, but not all the parts of the label are symbols. ");
            StringWriter stackTrack = new StringWriter();
            e.printStackTrace(new PrintWriter(stackTrack));
            hierarchySettings.logger.reportError_And_Exit(e);
        }
    }


    public void set_DescTagNameAccessOrCreation(AttributeNode node) {
        MethodAttributeSet generateSym_Attribs = node.getMethodAttributes();

        Boolean_Mutable is_DescTagNameAccess = (Boolean_Mutable) HashTools.get(generateSym_Attribs.vars, HierarchyMethodConstants.var_Is_DescTagNameAccessOrCreation);
        is_DescTagNameAccess.value = true; // MatrixSet to TRUE!!

    }

}
