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


import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.compiler.tools.MethodAttributeSet;
import net.unconventionalthinking.lang.Boolean_Mutable;
import net.unconventionalthinking.lang.Integer_Mutable;
import net.unconventionalthinking.lang.OutputParameter;
import net.unconventionalthinking.lang.String_Mutable;
import net.unconventionalthinking.matrix.Descriptor;
import net.unconventionalthinking.hierarchy.ExceptRuntime_Matrix_SyntaxError;
import net.unconventionalthinking.matrix.ExceptRuntime_Matrix_UnexpectedError;
import net.unconventionalthinking.matrix.Matrix;
import net.unconventionalthinking.matrix.MatrixSet;
import net.unconventionalthinking.matrix.SchemaInfoProperty_Type;
import net.unconventionalthinking.matrix.SchemaInfoUtilities;
import net.unconventionalthinking.matrix.SchemaInfo_Descriptor;
import net.unconventionalthinking.matrix.SchemaInfo_Schema;
import net.unconventionalthinking.matrix.SearchType;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.MatrixStructInfo_DescriptorContainer;
import net.unconventionalthinking.matrix.metacompiler.codegen.DescriptorCodeGenerator_Utilities;
import net.unconventionalthinking.matrix.metacompiler.codegen.DescriptorCreation_CodeGenerator;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.MatrixName;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolType;
import net.unconventionalthinking.hierarchy.AppControl_Info;
import net.unconventionalthinking.hierarchy.ClassPath_SearchUtilities;
import net.unconventionalthinking.hierarchy.HierarchyControl;
import net.unconventionalthinking.hierarchy.grammar.node.Node;
import net.unconventionalthinking.hierarchy.langexpressions.DescriptorVar_Utilities;
import net.unconventionalthinking.hierarchy.langexpressions.Expression;
import net.unconventionalthinking.hierarchy.langexpressions.ExpressionEvaluator_Type;
import net.unconventionalthinking.hierarchy.langexpressions.ExpressionPart_ExpressionInfo;
import net.unconventionalthinking.hierarchy.langexpressions.Expression_Utilities;
import net.unconventionalthinking.hierarchy.langsymboltable.Exception_FindTypeName;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbolTable_App;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbolTable_File;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol_Import_Type;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbol_Variable_DescriptorVar;
import net.unconventionalthinking.utilities.ListUtilities;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


/**
 *
 * @author peterjoh
 */
public class HierarchyActionsWorker_MatrixElementName extends HierarchyActionsWorker {


    public HierarchyActionsWorker_MatrixElementName(HierarchyActions hierarchyActions, HierarchyControl hierarchyControl, int baseIndentLevel) {
        super(hierarchyActions, hierarchyControl, baseIndentLevel);
    }






    public void process_DescTag(LinkedList<String> identifier_Parts, List<DescriptorTagName> nameScope_Parts_DescTagNames,
            boolean is_MatrixOrSchemaCreation, Node node) {



        MethodAttributeSet generate_MatrixElemName_AttribSet = node.getMethodAttributes();

        DescriptorTagName matrixElem_PackageName = null;
        DescriptorTagName matrixElem_SchemaName = null;
        MatrixName matrixElem_SchemaName_Full = null;

        try {
            if (nameScope_Parts_DescTagNames.size() == 0) { // need to search for matching descriptors
                DescriptorTagName matrixElemName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(identifier_Parts,
                        -1, false);

                if (is_MatrixOrSchemaCreation) {
                    matrixElem_SchemaName_Full = searchScopeStack_for_SchemaName_by_DescriptorTagName(matrixElemName);

                    matrixElem_SchemaName = matrixElem_SchemaName_Full.getMatrixName();
                    matrixElem_PackageName = matrixElem_SchemaName_Full.getPackageName();
                }

            } else if (nameScope_Parts_DescTagNames.size() == 1) {
                matrixElem_SchemaName = nameScope_Parts_DescTagNames.get(0);

                if (is_MatrixOrSchemaCreation) {
                    matrixElem_SchemaName_Full = searchScopeStack_for_SchemaName_by_SchemaNameSimple(matrixElem_SchemaName);
                    matrixElem_PackageName = matrixElem_SchemaName_Full.getPackageName();

                } else { // matrixOrSchema access

                    matrixElem_SchemaName_Full = find_SchemaName_forCurrFileScope(matrixElem_SchemaName.get_Name_no_backtiks(),
                            hierarchyActions.packageName_DescTagName, hierarchyActions.classPath_List);


                    if (matrixElem_SchemaName_Full != null)
                        matrixElem_PackageName = matrixElem_SchemaName_Full.getPackageName();
                }

            } else if (nameScope_Parts_DescTagNames.size() == 2) {
                matrixElem_PackageName = nameScope_Parts_DescTagNames.get(0);
                matrixElem_SchemaName = nameScope_Parts_DescTagNames.get(1);

                SchemaInfo_Schema foundSchema = ClassPath_SearchUtilities.classPath__FindSchema(matrixElem_SchemaName.get_Name_no_backtiks(),
                        matrixElem_PackageName.get_Name_no_backtiks(), hierarchyActions);
                matrixElem_SchemaName_Full = foundSchema.getSchemaInfo_SchemaNameFull();


            } else { // no name scope, do nothing

            }

        } catch (Exception e) {
            StringWriter stackTrack = new StringWriter();
            e.printStackTrace(new PrintWriter(stackTrack));
            hierarchySettings.logger.reportError_And_Exit("Tried to create a Descriptor tag with the name, " + ListUtilities.print(identifier_Parts) +
                    ", but had a error.", e);
        }




        if (is_MatrixOrSchemaCreation) {
            generate_Symbol_ForMatrixElement(node, generate_MatrixElemName_AttribSet, identifier_Parts, matrixElem_SchemaName_Full, matrixElem_PackageName);


        } else { // matrixOrSchema access

            Symbol symbol_Actual = null;
            if (matrixElem_SchemaName_Full != null) { // create the descTag and return it
                symbol_Actual = (Symbol)hierarchyActions.workers.symbols.generate_CreateOrAccessDescriptorTag(
                        generate_MatrixElemName_AttribSet.codeBuilder, identifier_Parts, matrixElem_SchemaName_Full, false);

            } else { // just return the descTagName

                symbol_Actual = hierarchyActions.workers.symbols.generate_CreateOrAccessSymbols(generate_MatrixElemName_AttribSet.codeBuilder,
                    SymbolType.DescriptorTagName, identifier_Parts, new Integer_Mutable(identifier_Parts.size()), new Integer_Mutable(Integer.MAX_VALUE));
            }


            node.code(generate_MatrixElemName_AttribSet.codeBuilder).append(' ');
            generate_MatrixElemName_AttribSet.returnValues.put(HierarchyMethodConstants.retVal_Symbol_Actual, symbol_Actual);

        }


    }



    public MatrixAccess_FirstAccessInfo determine_Is_SchemaName_MatrixName_Identifier_Or_DescVarRef(MethodAttributeSet generateAccess_Attribs,
            String identifier_Full, List<String> identifier_Parts, List<DescriptorTagName> nameScope_PartsList,
            Expression identifer_Expression)
            throws Exception_FindTypeName, Exception_MetaCompilerError {

        MatrixAccess_FirstAccessInfo firstAccessInfo = new MatrixAccess_FirstAccessInfo();

        MatrixName schemaName = null;
        MatrixName matrixName = null;


        if (nameScope_PartsList == null || nameScope_PartsList.size() == 0) {
            //  Here, we don't have any scope resolution. So, search the schemas & matrices first using the current package, and also through the
            //  import list to see if it exists

            //  See if it's a schema access.
            schemaName = find_SchemaName_forCurrFileScope(identifier_Full, hierarchyActions.packageName_DescTagName, hierarchyActions.classPath_List);
            // See if it's matrixOrSchema access
            matrixName = find_MatrixName_forCurrFileScope(identifier_Full, hierarchyActions.packageName_DescTagName, hierarchyActions.classPath_List);

            

            //  Determine if the type of the expression is a desc var access
            //  But, don't do this in the collecting lang symbol phase. Why? because, the symbol table is not full of types yet, so
            //  a type evaluation of an expression will have a lot of missing type info, and will be worthless.
            if (hierarchyActions.metaCompilation_Phase != MetaCompilation_Phase.Collecting_LangSymbols &&
                    schemaName == null && matrixName == null) { // This is possibly object dereferencing of a descriptor variable
                if (Expression_Utilities.check_IsValidIdentifierExpression(identifer_Expression, identifier_Parts)) {

                    Boolean_Mutable couldNotFindType = new Boolean_Mutable(true);
                    ExpressionEvaluator_Type expressionEvaluator = new ExpressionEvaluator_Type(symbolTable_App, symbolTable_File);
                    List<ExpressionPart_ExpressionInfo> identifierPartInfo_List =
                            expressionEvaluator.determineType(identifer_Expression, couldNotFindType);

                    if (couldNotFindType.value == false) {
                        //  found the type, it should be a descriptor var
                        ExpressionPart_ExpressionInfo lastIdentifierPart_PartInfo = identifierPartInfo_List.get(identifierPartInfo_List.size() - 1);

                        if (DescriptorVar_Utilities.check_Variable_is_DescriptorType(lastIdentifierPart_PartInfo.typeName_Full,
                                lastIdentifierPart_PartInfo.associatedSymbol)) {

                            LangSymbol_Variable_DescriptorVar descVar_Symbol =
                                    (LangSymbol_Variable_DescriptorVar)lastIdentifierPart_PartInfo.associatedSymbol;

                            firstAccessInfo.continuedAccess_IsContinuedAccess = true;
                            firstAccessInfo.continuedAccess_MatrixAccessState = descVar_Symbol.getMatrixAccessState();

                        } else {
                              //  *** I think this error is wrong, not sure, but why can we assume this must be a descriptor var at this point???
                            throw new Exception_FindTypeName("Error: the type of this expression should have been " + Descriptor.class.getName() +
                                    ", but was not. The expression was: " + identifer_Expression.toString() + ". And the type of the expression was: " + lastIdentifierPart_PartInfo.typeName_Full + "." );
                        }

                        

                    } else {
                        //  TODO - when the evaluation system is fully functional, add this exception back in
                        /*throw new Exception_FindTypeName("Error: the type of this expression should have been DESCRIPTOR, but could not be determined. The expression was: " +
                              identifer_Expression.toString() + "."); */
                    }


                }
            }



        } else { // there's scope resolution. It must be a schema or a matrixOrSchema

            String schemaOrMatrixName_Full = ListUtilities.print(nameScope_PartsList, ".") + "::" + identifier_Full.toString();

            
            SchemaInfo_Schema schema = null;
            Matrix matrix = null;
            try {
                //  See if it's a schema access.
                schema = ClassPath_SearchUtilities.classPath__FindSchema(schemaOrMatrixName_Full, hierarchyActions);
                if (schema != null)
                    schemaName = schema.getSchemaInfo_SchemaNameFull();

                // See if it's matrixOrSchema access
                matrix = ClassPath_SearchUtilities.classPath__FindMatrix(schemaOrMatrixName_Full, hierarchyActions);
                if (matrix != null)
                    matrixName = matrix.getMatrixName();

            } catch (MalformedURLException mue) {
                Exception_MetaCompilerError e = new Exception_MetaCompilerError("Tried to find the matrix/schema name for this schema/matrix access, " +
                    "but the class path had a bad path.", mue);
                hierarchySettings.logger.reportError_And_Exit(e);
            }

            if (schemaName == null && matrixName == null) {
                Exception_MetaCompilerError e = new Exception_MetaCompilerError("Tried to find the matrix/schema name for this schema/matrix access, " +
                    "but had an error. It must be either a matrix or a schema, but this name was not found in the classpath. The name of the object we were checking was:" +
                    schemaOrMatrixName_Full + "." );
                hierarchySettings.logger.reportError_And_Exit(e);
            }
        }


        if (schemaName != null) {
            firstAccessInfo.accessExpr_Type = MatrixAccess_FirstAccessInfo.AccessExpressionType.SchemaName;
            firstAccessInfo.accessExpr_SymbolActual = schemaName;
            firstAccessInfo.accessExpr = schemaName.getClassName_Full();
        } else if (matrixName != null) {
            firstAccessInfo.accessExpr_Type = MatrixAccess_FirstAccessInfo.AccessExpressionType.MatrixName;
            firstAccessInfo.accessExpr_SymbolActual = matrixName;
            firstAccessInfo.accessExpr = matrixName.getClassName_Full();
        } else {
            firstAccessInfo.accessExpr_Type = MatrixAccess_FirstAccessInfo.AccessExpressionType.Identifier;
            firstAccessInfo.accessExpr_SymbolActual = null;
            firstAccessInfo.accessExpr = identifier_Full.toString();
        }


        return firstAccessInfo;
    }



    public void add_SchemaOrMatrix_Import(MethodAttributeSet generateAccess_Attribs,
            boolean is_SchemaName, String identifier_Full, List<String> identifier_Parts, List<DescriptorTagName> nameScope_PartsList,
            Expression identifer_Expression) {

            String schemaOrMatrixName_Full = ListUtilities.print(nameScope_PartsList, ".") + "::" + identifier_Full.toString();
            String schemaOrMatrix_Text = (is_SchemaName ? "schema" : "matrix");

            MatrixName schemaOrMatrixName = null;
            SchemaInfo_Schema schema = null;
            Matrix matrix = null;
            try {
                if (is_SchemaName) {

                    schema = ClassPath_SearchUtilities.classPath__FindSchema(schemaOrMatrixName_Full, hierarchyActions);
                    if (schema != null)
                        schemaOrMatrixName = schema.getSchemaInfo_SchemaNameFull();
                } else {

                    matrix = ClassPath_SearchUtilities.classPath__FindMatrix(schemaOrMatrixName_Full, hierarchyActions);
                    if (matrix != null)
                        schemaOrMatrixName = matrix.getMatrixName();
                }

            } catch (MalformedURLException mue) {

                Exception_MetaCompilerError e = new Exception_MetaCompilerError("Tried to find the " + schemaOrMatrix_Text + " for this " +
                        schemaOrMatrix_Text + " import, but the class path had a bad path.", mue);
                hierarchySettings.logger.reportError_And_Exit(e);
            }


            if (schemaOrMatrixName != null) {
                //  you need to add it to the file's symbol table, so that it can be searched on to find if a matrixOrSchema/schema access by
                //  simple name is valid for the current file:
                if (is_SchemaName)
                    LangSymbol_Import_Type.createSymbol__SchemaImportType(identifier_Full, identifier_Parts, nameScope_PartsList, -1, null, symbolTable_File);
                else
                    LangSymbol_Import_Type.createSymbol__MatrixImportType(identifier_Full, identifier_Parts, nameScope_PartsList, -1, null, symbolTable_File);

            } else {
                Exception_MetaCompilerError e = new Exception_MetaCompilerError("Tried to find the " + schemaOrMatrix_Text + 
                        " for this " + schemaOrMatrix_Text + " import, " +
                        "but had an error, it was not found in the classpath. The name of the " + schemaOrMatrix_Text + " we were searching for was:" +
                        schemaOrMatrixName_Full + "." );
                hierarchySettings.logger.reportError_And_Exit(e);

            }



    }










    public DescriptorTagName create_DescTagName_ForMatrixElement(LinkedList<String> descTagName_Parts, CodeBuilder codeBuilder_DescTagNameAccess) {

        Integer_Mutable partCount = new Integer_Mutable(descTagName_Parts.size());


        Integer_Mutable creation_StartLevel = new Integer_Mutable(-1);

        Symbol symbol_Actual = hierarchyActions.workers.symbols.generate_CreateOrAccessSymbols(codeBuilder_DescTagNameAccess,
                SymbolType.DescriptorTagName, descTagName_Parts, partCount, creation_StartLevel);

        return (DescriptorTagName)symbol_Actual;
    }




    public MatrixName find_SchemaName(DescriptorTagName matrixElem_SchemaName, DescriptorTagName matrixElem_PackageName) {


        MatrixName schemaName_Full = null;

        // check schema name exists. if it does, return it
        schemaName_Full = symbolControl.schemaName_Index.getSchemaName_ByPackageAndSchemaName(matrixElem_PackageName, matrixElem_SchemaName);

        if (schemaName_Full != null && (schemaControl.schemaIndex_Find(schemaName_Full) != null))
            return schemaName_Full;
        else
            return null;

    }




    public void generate_SchemaName_ForMatrixElement(Node node, MethodAttributeSet generate_MatrixElemName_AttribSet,
            DescriptorTagName schemaName_descTag, DescriptorTagName packageName) {


        Object matrixElementName_Type_Raw = node.getMethodAttributes().params.get(HierarchyMethodConstants.param_MatrixElementName_Type);


        Symbol symbol_Actual = (Symbol)hierarchyActions.workers.symbols.generate_CreateOrAccess_MatrixOrSchemaName(
                generate_MatrixElemName_AttribSet.codeBuilder, schemaName_descTag, packageName, true, true);


        node.code(generate_MatrixElemName_AttribSet.codeBuilder).append(' ');
        generate_MatrixElemName_AttribSet.returnValues.put(HierarchyMethodConstants.retVal_Symbol_Actual, symbol_Actual);
    }


    /**
     *
     * @param node
     * @param generate_MatrixElemName_AttribSet
     * @param child_Symbols
     * @param descTag_SchemaName
     * @param schemaOrMatrixName_PackageName        **only used for matrixOrSchema or Schema name creation during Schema/Matrix Descriptor creation
     */
    public void generate_Symbol_ForMatrixElement(Node node, MethodAttributeSet generate_MatrixElemName_AttribSet,
            LinkedList<String> child_Symbols, MatrixName descTag_SchemaName, DescriptorTagName schemaOrMatrixName_PackageName) {

        Integer_Mutable symbolCount = new Integer_Mutable(child_Symbols.size());


        Object matrixElementName_Type_Raw = node.getMethodAttributes().params.get(HierarchyMethodConstants.param_MatrixElementName_Type);
        MatrixElementName_Type matrixElementName_Type = matrixElementName_Type_Raw != null
                ? (MatrixElementName_Type) matrixElementName_Type_Raw : MatrixElementName_Type.DescriptorTag;



        Symbol symbol_Actual = null;



        if (matrixElementName_Type == MatrixElementName_Type.DescriptorTag) { // create a DescriptorTag object

            boolean is_DescriptorTag_Creation = false; // should always be doing access.
            symbol_Actual = (Symbol)hierarchyActions.workers.symbols.generate_CreateOrAccessDescriptorTag(generate_MatrixElemName_AttribSet.codeBuilder,
                    child_Symbols, descTag_SchemaName, is_DescriptorTag_Creation);

        } else if (matrixElementName_Type == MatrixElementName_Type.SchemaName_Label) {

            boolean is_schemaName_Creation = true; // should always be doing creation .
            symbol_Actual = (Symbol)hierarchyActions.workers.symbols.generate_Create_SchemaOrMatrixNameLabel(generate_MatrixElemName_AttribSet.codeBuilder,
                    true, child_Symbols, symbolCount, schemaOrMatrixName_PackageName);

        } else if (matrixElementName_Type == MatrixElementName_Type.MatrixName_Label) {

            boolean is_matrixName_Creation = true; // should always be doing creation .
            symbol_Actual = (Symbol)hierarchyActions.workers.symbols.generate_Create_SchemaOrMatrixNameLabel(generate_MatrixElemName_AttribSet.codeBuilder,
                    false, child_Symbols,symbolCount, schemaOrMatrixName_PackageName);

        } else {

            //  If it's descriptor access or field access, should be Integer.Max (always accessing)
            Integer_Mutable creation_StartLevel =
                    (matrixElementName_Type == MatrixElementName_Type.MatrixName_Label)
                    ? new Integer_Mutable(-1) : new Integer_Mutable(Integer.MAX_VALUE);

            symbol_Actual = hierarchyActions.workers.symbols.generate_CreateOrAccessSymbols(generate_MatrixElemName_AttribSet.codeBuilder, 
                    matrixElementName_Type, child_Symbols, symbolCount, creation_StartLevel);
        }

        node.code(generate_MatrixElemName_AttribSet.codeBuilder).append(' ');
        generate_MatrixElemName_AttribSet.returnValues.put(HierarchyMethodConstants.retVal_Symbol_Actual, symbol_Actual);
    }







    public MatrixName searchScopeStack_for_SchemaName_by_DescriptorTagName(DescriptorTagName descriptorTagName)
        throws Exception_MetaCompilerError {

        MatrixStructInfo_DescriptorContainer curr_DescContainer = null;
        if (hierarchyActions.descCodeGen_Stack.size() > 0) {
            DescriptorCreation_CodeGenerator currDescCodeGen = hierarchyActions.descCodeGen_Stack.getLast();
            curr_DescContainer = currDescCodeGen.postGenerate_Get_DescriptorContainer();

        }
        Integer_Mutable depthLevel = new Integer_Mutable(0);


        SchemaInfo_Descriptor curr_SchemaInfoDesc = null;
        // first, search the current descriptor's child schema infos
        if (curr_DescContainer != null) {

            curr_SchemaInfoDesc = (SchemaInfo_Descriptor)curr_DescContainer.getSchemaInfo();

            SchemaInfo_Descriptor found_SchemaInfoDesc = (SchemaInfo_Descriptor)curr_SchemaInfoDesc.findChild_SchemaInfo(executeInfo,
                    SchemaInfoProperty_Type.Descriptor, SearchType.SearchOnlyOneLevel, descriptorTagName, null);

            if (found_SchemaInfoDesc != null)
                return found_SchemaInfoDesc.getSchemaInfo_SchemaNameFull();

        }


        //  second, search through the schemaSet Scope Stack for the nearest matching descriptors.
        try {
            SchemaInfo_Descriptor schemaInfo_Desc = find_SchemaInfoDescriptor_AtSameLevel_in_Stack(descriptorTagName, curr_SchemaInfoDesc);

            return (schemaInfo_Desc != null ? schemaInfo_Desc.getSchemaInfo_SchemaNameFull() : null);

        } catch(Exception_MetaCompilerError e) {
            throw new Exception_MetaCompilerError(e.getMessage() +
                    "The parent descriptor was: " +
                        (curr_DescContainer != null ? curr_DescContainer.getSchemaInfo().getSchemaInfo_DescTagName_FullPath_String(executeInfo) : "<null>" )+
                    " and was found at a depth of " + depthLevel.value +
                    " from the top of the scope stack (the parent descriptor is the top of the stack with depth 0. The schemas in the parent descriptor is depth 1).");
        }

    }


    public SchemaInfo_Descriptor find_SchemaInfoDescriptor_AtSameLevel_in_Stack(DescriptorTagName descTagName,
            SchemaInfo_Descriptor curr_SchemaInfoDesc)
        throws Exception_MetaCompilerError {

        MatrixSet<SchemaInfo_Descriptor> foundSchemaInfoDescriptors_At_Level = null;
        try {
            foundSchemaInfoDescriptors_At_Level = SchemaInfoUtilities.find_SchemaInfoDescriptors_AtSameLevel_in_Stack(executeInfo,
                descTagName, curr_SchemaInfoDesc, hierarchyActions.schemaSet_ScopeStack, false);

        } catch (Exception e) {
            throw new Exception_MetaCompilerError("Tried to find the schema with the name, "  + descTagName + ", in the scope stack, but could not find it.", e);
        }



        if (foundSchemaInfoDescriptors_At_Level != null && foundSchemaInfoDescriptors_At_Level.size() == 1) {
            return foundSchemaInfoDescriptors_At_Level.get(0);

        } else if (foundSchemaInfoDescriptors_At_Level != null && foundSchemaInfoDescriptors_At_Level.size() > 1) {

            throw new Exception_MetaCompilerError("Error, tried finding a schema with a descriptor tag named, " + descTagName +
                    ", but had a conflict. Found " + foundSchemaInfoDescriptors_At_Level.size() + " schemas at the same depth in the schema scope stack that have this descriptor. " +
                    " The found schemaInfo_Descriptors with name conflicts were: (" + ListUtilities.print(foundSchemaInfoDescriptors_At_Level.getItems()) +
                    "). You may need to add the schema name to the descriptor tag to solve this problem. ");

        } else {
            throw new Exception_MetaCompilerError("Error, tried finding a schema with a descriptor tag named, " + descTagName +
                    ", but did not find a schema with the descriptor at its first level with this name. ");
        }

    }





    public MatrixName searchScopeStack_for_SchemaName_by_SchemaNameSimple(DescriptorTagName matrixElem_SchemaName)
        throws Exception_MetaCompilerError {

        MatrixStructInfo_DescriptorContainer curr_DescContainer = null;
        if (hierarchyActions.descCodeGen_Stack.size() > 0) {
            DescriptorCreation_CodeGenerator currDescCodeGen = hierarchyActions.descCodeGen_Stack.getLast();
            curr_DescContainer = currDescCodeGen.postGenerate_Get_DescriptorContainer();

        }
        
        //  second, search through the schemaSet Scope Stack for the nearest matching schemaName.
        Integer_Mutable depthLevel = new Integer_Mutable(1);
        Set<SchemaInfo_Schema> foundSchemas_At_Level = SchemaInfoUtilities.find_Schemas_AtSameLevelinStack_by_SchemaNameSimple(executeInfo,
                matrixElem_SchemaName, hierarchyActions.schemaSet_ScopeStack, depthLevel);


        SchemaInfo_Schema[] found_Schemas = foundSchemas_At_Level.toArray(new SchemaInfo_Schema[0]);

        if (found_Schemas.length == 1) {
            return found_Schemas[0].getSchemaInfo_SchemaNameFull();
        } else if (found_Schemas.length > 1) {

            throw new Exception_MetaCompilerError("Error, tried finding the full schema name for the simple schema name, " + matrixElem_SchemaName +
                    ", but had a conflict. Found " + found_Schemas.length + " schemas with the same name at the same depth in the schema scope stack. " +
                    " The schemas with name conflicts were: (" + ListUtilities.print(found_Schemas) + "). You may need to add the schema name to the" +
                    " descriptor tag to solve this problem. " +
                    "The current descriptor was: " +
                     (curr_DescContainer != null ? curr_DescContainer.getSchemaInfo().getSchemaInfo_DescTagName_FullPath_String(executeInfo) : "<null>") +
                    " and was found at a depth of " + depthLevel.value +
                    " from the top of the scope stack (The schemas in the curr descriptor is depth 1).");

        } else {
            throw new Exception_MetaCompilerError("Error, tried finding the full schema name for the simple schema name, " + matrixElem_SchemaName +
                    ", did not find a matching schema. " +
                    "The current descriptor was: " +
                     (curr_DescContainer != null ? curr_DescContainer.getSchemaInfo().getSchemaInfo_DescTagName_FullPath_String(executeInfo) : "<null>") +
                     ".");
        }



    }




    

    public MatrixName find_SchemaName_forCurrFileScope(String matrixName_Simple, DescriptorTagName currFile_Package_DescTagName, List<URL> classPath_List) throws Exception_MetaCompilerError {
        return find_MatrixOrSchemaName_forCurrFileScope(false, matrixName_Simple, currFile_Package_DescTagName, classPath_List);
    }
    public MatrixName find_MatrixName_forCurrFileScope(String matrixName_Simple, DescriptorTagName currFile_Package_DescTagName, List<URL> classPath_List) throws Exception_MetaCompilerError {
        return find_MatrixOrSchemaName_forCurrFileScope(true, matrixName_Simple, currFile_Package_DescTagName, classPath_List);
    }
    /** 
     * This method will try to find the Matrix/Schema Name for the simple matrixOrSchema name, for the current file scope.<br>
     * More specifically:<br>
     *   - First, it checks the Matrix/Schema import list to find a matching matrix/schema with the same simple name. If it's not found, <br>
     *   - Second, It checks the import list for it in the same package.
     *   - It returns null if the matrixOrSchema or schema cannot be found.
     */
    public MatrixName find_MatrixOrSchemaName_forCurrFileScope(boolean searchForMatrix, String matrixName_Simple, DescriptorTagName currFile_Package_DescTagName, List<URL> classPath_List) throws Exception_MetaCompilerError {

        MatrixName matrixOrSchemaName = null;
        String matrixOrSchemaText = (searchForMatrix ? "matrix" : "schema");

        //  first, check to see if it's in the explicit import list
        List<LangSymbol_Import_Type> found_ExplicitImports = null;
        if (searchForMatrix)
          found_ExplicitImports = symbolTable_File.lookup_ImportMPType__Matrix__bySimpleName(matrixName_Simple);
        else
          found_ExplicitImports = symbolTable_File.lookup_ImportMPType__Schema__bySimpleName(matrixName_Simple);


        if (found_ExplicitImports != null && found_ExplicitImports.size() > 0) {

            // take the top one and use that.
            LangSymbol_Import_Type found_MatrixOrSchemaImport_LangSym = found_ExplicitImports.get(0);
            OutputParameter OUT_foundMatrixOrSchema = new OutputParameter();

            Matrix matrixOrSchema = null;
            MatrixName found_MatrixOrSchemaName = null;
            Exception except = null;
            try {
                DescriptorTagName packageName_DescTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(
                        found_MatrixOrSchemaImport_LangSym.mpImport_GetPackageName(), 1, true, null, null);
                if (searchForMatrix)
                    found_MatrixOrSchemaName = find_MatrixOrSchema_InClassPath(true, true, matrixName_Simple, packageName_DescTagName, classPath_List, OUT_foundMatrixOrSchema);
                else
                    found_MatrixOrSchemaName = find_MatrixOrSchema_InClassPath(false, true, matrixName_Simple, packageName_DescTagName, classPath_List, OUT_foundMatrixOrSchema);

                matrixOrSchema = (Matrix)OUT_foundMatrixOrSchema.value;
            } catch (Exception e) {
                except = e;
            }



            if (matrixOrSchema != null && except == null)
                matrixOrSchemaName = found_MatrixOrSchemaName;
            else
                throw new Exception_MetaCompilerError("Could not find the imported " + matrixOrSchemaText + " in the classpath: " +
                        found_MatrixOrSchemaImport_LangSym.mpImport__MatrixName_Full, except);
        }



        if (matrixOrSchemaName == null) {

            //  it wasn't in the import list. try the current package
            OutputParameter OUT_foundMatrixOrSchema = new OutputParameter();

            Matrix matrixOrSchema = null;
            MatrixName found_MatrixOrSchemaName = null;
            Exception except = null;
            try {
                if (searchForMatrix)
                    found_MatrixOrSchemaName = find_MatrixOrSchema_InClassPath(true, false, matrixName_Simple, currFile_Package_DescTagName,
                            classPath_List, OUT_foundMatrixOrSchema);
                else
                    found_MatrixOrSchemaName = find_MatrixOrSchema_InClassPath(false, false, matrixName_Simple, currFile_Package_DescTagName,
                            classPath_List, OUT_foundMatrixOrSchema);

                matrixOrSchema = (Matrix)OUT_foundMatrixOrSchema.value;

            } catch (Exception e) {
                except = e;
            }

            if (except != null)
                throw new Exception_MetaCompilerError("Had an error while trying to find the " + matrixOrSchemaText + ", " + matrixName_Simple +
                        ", in the current package, " +
                        (currFile_Package_DescTagName != null ? currFile_Package_DescTagName.get_Name_no_backtiks() : null) + 
                        ", in the classpath", except);

            if (matrixOrSchema != null)
                matrixOrSchemaName = found_MatrixOrSchemaName;
        }


        return matrixOrSchemaName;
    }




    public MatrixName find_MatrixOrSchema_InClassPath(boolean searchForMatrix, boolean is_Import, String matrixName_Simple, DescriptorTagName currFile_PackageName,
        List<URL> classPath_List, OutputParameter OUT_foundMatrixOrSchema) throws Exception_MetaCompilerError {

        String matrixName_Full = currFile_PackageName + "::" + matrixName_Simple;
        String matrixOrSchemaText = (searchForMatrix ? "matrix" : "schema");

        // Now, make sure it is in the classpath
        Boolean_Mutable OUT_is_ExternalMatrixOrSchema = new Boolean_Mutable(false);
        String_Mutable OUT_externalAppControl_FullName = new String_Mutable(null);

        MatrixName matrixOrSchemaName = null;
        Matrix matrixOrSchema = null;
        try {
            DescriptorTagName matrixNameSimple_DescTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(matrixName_Simple,
                    1, false, null, null);

            if (searchForMatrix) {
                matrixOrSchemaName = symbolControl.multiLevelSymbol_Factory.createNew_MatrixName(currFile_PackageName, matrixNameSimple_DescTagName, false);
                matrixOrSchema = matrixControl.classPath__FindMatrix(matrixOrSchemaName.get_Name_no_backtiks(), classPath_List, OUT_is_ExternalMatrixOrSchema,
                    OUT_externalAppControl_FullName);
            } else {
                matrixOrSchemaName = symbolControl.multiLevelSymbol_Factory.createNew_SchemaName(currFile_PackageName, matrixNameSimple_DescTagName, false);
                matrixOrSchema = (Matrix)schemaControl.classPath__FindSchema(matrixOrSchemaName.get_Name_no_backtiks(), classPath_List, OUT_is_ExternalMatrixOrSchema,
                    OUT_externalAppControl_FullName);

            }
        } catch(Exception e) {
            throw new Exception_MetaCompilerError("While trying to find " +
                 (is_Import ? "the imported " : "the ") + matrixOrSchemaText +
                 ", " + matrixName_Full + ", in the classpath, had an error.", e);
        }

        if (OUT_is_ExternalMatrixOrSchema.value)
            hierarchyActions.externalAppControlSet_forFile.add(new AppControl_Info(OUT_externalAppControl_FullName.value));

        OUT_foundMatrixOrSchema.value = matrixOrSchema;
        return matrixOrSchemaName;

    }

}
