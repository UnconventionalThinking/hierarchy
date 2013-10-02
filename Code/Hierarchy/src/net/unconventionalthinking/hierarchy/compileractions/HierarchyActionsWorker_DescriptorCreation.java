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
import net.unconventionalthinking.lang.Pair;
import net.unconventionalthinking.matrix.FieldValueInfo;
import net.unconventionalthinking.matrix.MatrixSet;
import net.unconventionalthinking.matrix.SchemaInfo_Schema;
import net.unconventionalthinking.matrix.metacompiler.codegen.DescriptorCreation_CodeGenerator;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.MatrixStructInfo_DescriptorContainer;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.MPSymbols_DescTagName;
import net.unconventionalthinking.matrix.symbols.MPSymbols_SchemaName;
import net.unconventionalthinking.matrix.symbols.MatrixName;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolUtilities;
import net.unconventionalthinking.hierarchy.HierarchyControl;
import net.unconventionalthinking.hierarchy.SchemaSet_ScopeStack;
import net.unconventionalthinking.hierarchy.compileractions.HierarchyActions.FieldSetCreationType;

import java.util.List;



/**
 *
 * @author peterjoh
 */
public class HierarchyActionsWorker_DescriptorCreation extends HierarchyActionsWorker {

    public HierarchyActionsWorker_DescriptorCreation(HierarchyActions hierarchyActions, HierarchyControl hierarchyControl, int baseIndentLevel) {
        super(hierarchyActions, hierarchyControl, baseIndentLevel);
    }




    //    public helpers for Matrix, Schema, and Descriptor Desclarations
    //  ________________________________________________________________________________________________________________


    public void init_SchemaOrMatrixDescriptor_Creation(boolean is_Matrix) {

        hierarchyActions.schemaSet_ScopeStack = new SchemaSet_ScopeStack(executeInfo, schemaControl);

        if (is_Matrix) { // add the Base schema to the scope stack
            try {
                hierarchyActions.schemaSet_ScopeStack.add_BaseSchema_toStack();
            } catch (Exception_MetaCompilerError e) {
                hierarchySettings.logger.reportError_And_Exit("Started to create a matrix, and tried to add the base schema to the schema scope stack, but had an error.", e);
            }
        }

    }


    /**
     *
     * @param generateDesc_Attribs
     * @param buildingMatrixOrSchemaElem
     * @param descTagName
     * @param schemaName
     * @param descTag_SchemaName      is often null, if user code has no schemaName for the schemaOrMatrixName
     * @param usesSchema_Set
     * @return
     */
    public DescriptorCreation_CodeGenerator setup_SchemaOrMatrixDescriptor_Creation(MethodAttributeSet generateDesc_Attribs,
            Symbol buildingMatrixOrSchemaElem, DescriptorTagName descTagName, MatrixName schemaNameOrMatrixName,
            MatrixSet<SchemaInfo_Schema> usesSchema_Set, SchemaSet_ScopeStack schemaSet_ScopeStack, boolean building_PersistentMatrix) {


        MatrixName descTag_SchemaName;
        if (buildingMatrixOrSchemaElem == MPSymbols.BuildingMatrixElement)
            descTag_SchemaName = MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$BASE;
        else // building schema
            descTag_SchemaName = MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA;


        Label schemaOrMatrixName_Label = null;
        try {
            schemaOrMatrixName_Label = SymbolUtilities.convert_DescriptorTagName_to_Label(schemaNameOrMatrixName.getMatrixName(), symbolControl);
        } catch (Exception e) {
            hierarchySettings.logger.reportError_And_Exit("Tried to create a matrix or schema name label, but had an error creating the label, " +
                    (schemaNameOrMatrixName != null ? schemaNameOrMatrixName.getMatrixName() : "null") + ".", e);
        }
        return setup_DescriptorCreation(generateDesc_Attribs, buildingMatrixOrSchemaElem, descTagName, descTag_SchemaName,
                schemaOrMatrixName_Label, null, usesSchema_Set, schemaSet_ScopeStack, null, null, building_PersistentMatrix);
    }



    public DescriptorCreation_CodeGenerator setup_DescriptorCreation(MethodAttributeSet generateDesc_Attribs,
            Symbol buildingMatrixOrSchemaElem, DescriptorTagName descTagName, MatrixName descTag_SchemaName, Label label, MatrixName schemaOrMatrixName,
            MatrixSet<SchemaInfo_Schema> usesSchema_Set, SchemaSet_ScopeStack schemaSet_ScopeStack,
            MatrixStructInfo_DescriptorContainer parent_DescContainer, String parentDesc_VarName, boolean building_PersistentMatrix) {


        DescriptorCreation_CodeGenerator desc_CodeGen = new DescriptorCreation_CodeGenerator(symbolControl, schemaControl, matrixControl,
                hierarchySettings, hierarchyActions.outputResults, baseIndentLevel);

        desc_CodeGen.set_PackageName(hierarchyActions.packageName_DescTagName);
        desc_CodeGen.set_SchemaOrMatrixName(schemaOrMatrixName);
        desc_CodeGen.set_DescriptorTag(descTag_SchemaName, descTagName);
        desc_CodeGen.set_Label(label);
        desc_CodeGen.set_Parent(parent_DescContainer, parentDesc_VarName);
        desc_CodeGen.set_SchemaRelatedValues(usesSchema_Set, schemaSet_ScopeStack, HierarchyActions.SchemaSetScopeStack_OutVarName);
        desc_CodeGen.set_Building_PersistentMatrix(building_PersistentMatrix);

        generateDesc_Attribs.vars.put(HierarchyMethodConstants.var_BuildingMatrixOrSchemaElem, buildingMatrixOrSchemaElem);
        generateDesc_Attribs.vars.put(HierarchyMethodConstants.var_Descriptor_CodeGen, desc_CodeGen);

        return desc_CodeGen;

    }






    /**
     * If you're building a scheam, and you are generating the FIELD.NAMES descriptor, then symbols created in the FIELD.NAMES fieldset should
     * be descTags! (not standard symbols)
     */
    public void checkFor_Schema_FieldNamesDescriptor(DescriptorTagName descTagName, Symbol buildingMatrixOrSchemaElem,
            MethodAttributeSet generateDesc_Attribs) {

        if ((buildingMatrixOrSchemaElem == MPSymbols.BuildingMatrixElementForSchema || buildingMatrixOrSchemaElem == MPSymbols.BuildingSchemaElement)
                && descTagName == MPSymbols_DescTagName.FIELD$__$NAMES) {
            generateDesc_Attribs.methodCall_AddValue(HierarchyMethodConstants.method_Generate_Symbol,
                    HierarchyMethodConstants.param_GenerateAndReturn_DescTagName, new Boolean(true));
        }
    }

    public void clear_Schema_FieldNamesDescriptor_Settings(DescriptorTagName descTagName, Symbol buildingMatrixOrSchemaElem,
            MethodAttributeSet generateDesc_Attribs) {

        if ((buildingMatrixOrSchemaElem == MPSymbols.BuildingMatrixElementForSchema || buildingMatrixOrSchemaElem == MPSymbols.BuildingSchemaElement)
                && descTagName == MPSymbols_DescTagName.FIELD$__$NAMES) {

            generateDesc_Attribs.methodCall_ClearAllValues();
        }
    }






    public void create_SchemaOrMatrixDescriptor(AttributeNode node, FieldSetCreationType fieldSetCreationType) {
        create_Descriptor(node, fieldSetCreationType, true);
    }

    public void create_Descriptor(AttributeNode node, FieldSetCreationType fieldSetCreationType) {
        create_Descriptor(node, fieldSetCreationType, false);
    }

    /**
     * TODO - Descriptor creation uses the codeBuilder from the MethodAttributeSet, not the node's code builder. Explain why that is. (don't know why I did that)
     */
    public void create_Descriptor(AttributeNode node, FieldSetCreationType fieldSetCreationType, boolean create_InitialMatrixDescriptor) {

        MethodAttributeSet generateDesc_Attribs = node.getMethodAttributes();
        CodeBuilder codeBuilder = generateDesc_Attribs.codeBuilder;

        Symbol buildingMatrixOrSchemaElem =
                (Symbol) generateDesc_Attribs.vars.get(HierarchyMethodConstants.var_BuildingMatrixOrSchemaElem);
        DescriptorCreation_CodeGenerator descriptor_CodeGen =
                (DescriptorCreation_CodeGenerator) generateDesc_Attribs.vars.get(HierarchyMethodConstants.var_Descriptor_CodeGen);


        List<String> fieldValueExpr_List = (List<String>) generateDesc_Attribs.vars.get(HierarchyMethodConstants.var_FieldValueExpr_List);
        List<Pair<DescriptorTagName, String>> paramMap_fieldToValue_List = (List<Pair<DescriptorTagName, String>>) generateDesc_Attribs.vars.get(HierarchyMethodConstants.var_ParamMap_fieldToValue_List);
        List<FieldValueInfo> fieldValueInfo_List = (List<FieldValueInfo>) generateDesc_Attribs.vars.get(HierarchyMethodConstants.var_FieldValueInfo_List);


        try {
            if (fieldSetCreationType == null) {
                fieldSetCreationType = FieldSetCreationType.None;
            }
            switch (fieldSetCreationType) {
                case None:
                    descriptor_CodeGen.generate_CreateDescriptor(codeBuilder, buildingMatrixOrSchemaElem, create_InitialMatrixDescriptor);
                    break;
                case FieldSet_Tuple:
                    descriptor_CodeGen.generate_CreateDescriptor_w_FieldSetTuple(codeBuilder, buildingMatrixOrSchemaElem,
                            create_InitialMatrixDescriptor, fieldValueExpr_List, fieldValueInfo_List);
                    break;
                case FieldSet_ParamMap:
                    descriptor_CodeGen.generate_CreateDescriptor_w_FieldSetParameterMap(codeBuilder, buildingMatrixOrSchemaElem,
                            create_InitialMatrixDescriptor, paramMap_fieldToValue_List, fieldValueInfo_List);
                    break;
            }

        } catch (Exception_MetaCompilerError e) {
            hierarchySettings.logger.reportError_And_Exit("Tried to create a descriptor, but had an error.", e);
        }



        MatrixStructInfo_DescriptorContainer descContainer = descriptor_CodeGen.postGenerate_Get_DescriptorContainer();
        generateDesc_Attribs.vars.put(HierarchyMethodConstants.var_Descriptor_Container, descContainer);
        String desc_OutVarName = descriptor_CodeGen.postGenerate_Get_DescriptorOutVarName();
        generateDesc_Attribs.vars.put(HierarchyMethodConstants.var_Descriptor_OutVarName, desc_OutVarName);

    }





    
    public void setup_ChildDescCreation(MethodAttributeSet generateDesc_Attribs, boolean create_InitialMatrixDescriptor) {

        generateDesc_Attribs.methodCall_AddValue(HierarchyMethodConstants.method_Generate_Descriptor,
                HierarchyMethodConstants.param_BuildingMatrixOrSchemaElem,
                generateDesc_Attribs.vars.get(HierarchyMethodConstants.var_BuildingMatrixOrSchemaElem));
        generateDesc_Attribs.methodCall_AddValue(HierarchyMethodConstants.method_Generate_Descriptor,
                HierarchyMethodConstants.param_ParentDesc_Container,
                generateDesc_Attribs.vars.get(HierarchyMethodConstants.var_Descriptor_Container));
        generateDesc_Attribs.methodCall_AddValue(HierarchyMethodConstants.method_Generate_Descriptor,
                HierarchyMethodConstants.param_ParentDesc_OutVarName,
                generateDesc_Attribs.vars.get(HierarchyMethodConstants.var_Descriptor_OutVarName));


    }

    public void descFinalProcessing_postChildDescCreation(MethodAttributeSet generateDesc_Attribs) {

        //  Add the CURRENT descriptor's generated code to its parent codebuilder (NOT the child descriptor's generated code.
        //  Why do it here? because a descriptor doesn't have it's full code until the child adds it in their code. We should be in
        //  this state after the children have been created.
        //
        //  TOD0 - THIS NEEDS A BETTER EXPLANATION OF WHAT'S GOING ON.
        if (generateDesc_Attribs.parent != null) {
            generateDesc_Attribs.parent.codeBuilder.append(generateDesc_Attribs.codeBuilder);
        }

        // don't forget to clear the method call values passed _to_ the method and the returnvalues passed _from_ the method
        generateDesc_Attribs.methodCall_ClearAllValues();
        hierarchyControl.returnValues_clearMap_for(HierarchyMethodConstants.method_Generate_Descriptor);

    }


}
