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



/**
 *
 * @author peterjoh
 */
public class HierarchyMethodConstants {


    public static final String method_Process_PackageName = "process_PackageName";
    public static final String method_Process_MatrixImportHeader = "process_MatrixImportHeader";

    public static final String method_Generate_Schema = "generate_Schema";
    public static final String method_Generate_Matrix = "generate_Matrix";
    public static final String method_Generate_Descriptor = "generate_Descriptor";

    public static final String param_BuildingMatrixOrSchemaElem = "buildingMatrixOrSchemaElem";
    public static final String param_SchemaSet_ScopeStack = "schemaSet_ScopeStack";
    public static final String param_ParentDesc_Container = "parentDesc_Container";
    public static final String param_ParentDesc_OutVarName = "parentDesc_OutVarName";

    public static final String var_BuildingMatrixOrSchemaElem = "buildingMatrixElemOrSchemaElem";
    public static final String var_Descriptor_CodeGen = "descriptor_CodeGen";
    public static final String var_UsesSchema_List = "usesSchema_List";
    public static final String var_UsesSchema_Set = "usesSchema_Set";

    public static final String var_Descriptor_Container = "descriptor_Container";
    public static final String var_Descriptor_OutVarName = "descriptor_OutVarName";

    public static final String var_FieldSetCreationType = "fieldSetCreationType";
    public static final String var_FieldValueExpr_List = "fieldValueExpr_List";
    public static final String var_ParamMap_fieldToValue_List = "paramMap_fieldToValue_List";
    public static final String var_FieldValueInfo_List = "fieldValueInfo_List";

    public static final String var_CurrFieldValueInfo = "currFieldValueInfo";
    public static final String var_CurrParamMap_FieldName = "currParamMap_FieldName";


    public static final String method_Generate_Annotations = "generate_Annotations";
    public static final String vars_Child_AnnoteBlockStmt_List = "child_AnnoteBlockStmt_List";
    public static final String vars_Child_FiltersAnnoteBlockStmt_List = "child_FiltersAnnoteBlockStmt_List";
    public static final String param_AnnotationType = "annotationType";
    public static final String var_Creating_AnnotationDefinition = "creating_AnnotationDefinition";
    public static final String var_AnnoteRef__Creation_StartLevel = "annoteRef__Creation_StartLevel";
    public static final String var_RetVal_AnnoteRef_Actual = "retVal_AnnoteRef_Actual";


    public static final String method_Generate_AnnoteBlockStmt = "generate_AnnoteBlockStmt";
    public static final String var_AnnoteBlockStmt_CodeGen = "annoteBlockStmt_CodeGen";
    public static final String retVal_AnnoteBlockStmt_CodeGen = "annoteBlockStmt_CodeGen";
    

    public static final String method_Generate_MatrixElementName = "generate_MatrixElementName";
    public static final String param_MatrixElementName_Type = "matrixElementName_Type"; // MatrixElementName_Type
    public static final String param_Is_MatrixOrSchemaAccess = "is_MatrixOrSchemaAccess";
    public static final String retVal_IdentifierPartsList = "retVal_IdentifierPartsList";
    public static final String retVal_MatrixElementName_MatchedProductionType = "retVal_MatrixElemeName_ProdType";

    
    public static final String method_Generate_Label = "generate_Label";
    public static final String method_Generate_Symbol = "generate_Symbol";

    public static final String param_Creation_StartLevel = "creation_StartLevel";
    public static final String param_GenerateAndReturn_DescTagName = "generateAndReturn_DescTagName";
    
    public static final String var_SymbolCount = "symbolCount";
    public static final String var_Child_Symbols = "child_Symbols";
    public static final String var_HaveSeen_Plus = "haveSeen_Plus";
    public static final String var_Creation_StartLevel = "creation_StartLevel";
    public static final String var_Is_LateStartCreation = "is_LateStartCreation";

    public static final String var_Is_LabelAccessOrCreation = "is_LabelAccessOrCreation";
    public static final String var_LabelCount = "labelCount";
    public static final String var_Is_DescTagNameAccessOrCreation = "is_DescTagNameAccessOrCreation";

    public static final String var_DescTag = "descTag";
    public static final String var_DescTag_SchemaName ="descTag_SchemaName";
    public static final String var_Label = "label";

    public static final String var_NameScope_DescTagName = "nameScope_DescTagName";

    
    public static final String retVal_Symbol_Actual = "symbol_Actual"; // Symbol
    public static final String retVal_DescTagName = "descTagName";
    public static final String retVal_Label = "label";
    public static final String retVal_FirstAccessInfo = "firstAccessInfo";

    
    

    public static final String method_Generate_Set = "generate_Set";



    public static final String method_Generate_MatrixAccess = "generate_MatrixAccess";
    public static final String param_Collecting_MatrixAccessState = "param_Collecting_MatrixAccessState";
    public static final String param_Is_MatrixFieldAssignment = "param_Is_MatrixFieldAssignment";
    public static final String var_Is_MatrixAccess_In_StaticMethod = "is_MatrixAccess_In_StaticMethod";
    public static final String var_DescAccess_CodeGen = "descAccess_CodeGen";
    public static final String var_ChildAccessInfo_List = "childAccessInfo_List";

    public static final String var_Curr_ChildAccessInfo = "curr_ChildAccessInfo";

    public static final String var_Identifier_PartsList = "identifier_PartsList";
    public static final String var_Identifier_Parts_DescTagName = "identifier_Parts_DescTagName";
    public static final String var_Identifier_Full = "identifier_Full";
    public static final String var_Identifier_Expression = "identifier_Expression";

    public static final String retVal_DescAccess_CodeGen = "descAccess_CodeGen";


    public static final String method_Process_DescriptorVarDeclaration = "Process_DescVarDecl";

    public static final String var_MatrixAccessState = "matrixAccessState";

    public static final String retVal_MatrixAccessState = "matrixAccessState";



    public static final String method_Generate_MatrixFieldAssignment = "generate_MatrixFieldAssign";
    public static final String var_is_MatrixFieldAssignment = "is_MatrixFieldAssign";


}


