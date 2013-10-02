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


import net.unconventionalthinking.matrix.MatrixStructInfoBuilder__builds_DescActualAndDescFlattened;
import net.unconventionalthinking.matrix.MatrixStructInfo_DescriptorContainer;
import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.lang.Pair;
import net.unconventionalthinking.matrix.FieldValueInfo;
import net.unconventionalthinking.matrix.MatrixControl;
import net.unconventionalthinking.matrix.SchemaControl;
import net.unconventionalthinking.matrix.SchemaInfoUtilities;
import net.unconventionalthinking.matrix.SchemaInfo_Descriptor;
import net.unconventionalthinking.matrix.SchemaInfo_Schema;
import net.unconventionalthinking.matrix.MatrixSet;
import net.unconventionalthinking.matrix.symbols.DescriptorTag;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.MPSymbols_DescTagName;
import net.unconventionalthinking.matrix.symbols.MatrixName;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolConstants;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.matrix.symbols.SymbolUtilities;
import net.unconventionalthinking.matrix.utilities.TextUtilities;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import net.unconventionalthinking.hierarchy.SchemaSet_ScopeStack;
import java.util.Arrays;
import java.util.List;




/**
 *
 * @author peterjoh
 */
public class DescriptorCreation_CodeGenerator {

    private SymbolControl           symbolControl;
    private SchemaControl           schemaControl;
    private MatrixControl           matrixControl;
    private ExecutionInfo           executeInfo;
    private HierarchySettings         hierarchySettings;
    private CodeGen_OutputResults   outputResults;

    
    private DescriptorTagName       packageName;
    private MatrixName              schemaOrMatrixName;
    private boolean                 creating_StaticMatrixOrSchema = true;  // for now, just allow static. will do dynamic later
    private boolean                 building_PersistentMatrix;


    private MatrixName              descTag_SchemaName_Actual;
    private String                  descTag_PrintOutString;
    
    private List<String>            descTagName_Parts;
    private DescriptorTagName       descTagName_Actual;
    private String                  descTagName_String;
    
    private String                  label_Full;
    private List<String>            label_Parts;
    private int                     label_CreationStartLevel;
    private Label                   label_Actual;


    private MatrixStructInfo_DescriptorContainer    parentDesc_Container;
    private SchemaInfo_Descriptor                   parentDesc_SchemaInfoDesc;
    private String                                  parentDesc_OutVarName;


    private MatrixSet<SchemaInfo_Schema>    usesSchema_Set;
    private SchemaSet_ScopeStack            schemaSet_ScopeStack;
    private String                          schemaSetScopeStack_OutVarName;


    private MatrixStructInfoBuilder__builds_DescActualAndDescFlattened schemaAndMatrixBuilder;

    private int                     baseIndentLevel;
    private String                  baseIndent;


    //  PostProcess - Output values _________________________________________________________
    private MatrixStructInfo_DescriptorContainer  descriptor_Container;
    private String                                descriptor_OutVarName;


    
    public static String            returnParamName__desc_OutVarName = "returnParamName__desc_OutVarName";


    public final static String      AppControl_OutVariableName = "appControl";





    

    public DescriptorCreation_CodeGenerator(SymbolControl symbolControl, SchemaControl schemaControl, MatrixControl matrixControl, 
            HierarchySettings hierarchySettings, CodeGen_OutputResults outputResults, int baseIndentLevel) {

        this.symbolControl = symbolControl;
        this.schemaControl = schemaControl;
        this.matrixControl = matrixControl;
        this.hierarchySettings = hierarchySettings;
        
        this.executeInfo = new ExecutionInfo();

        schemaAndMatrixBuilder = new MatrixStructInfoBuilder__builds_DescActualAndDescFlattened(executeInfo, symbolControl, schemaControl, matrixControl,
                creating_StaticMatrixOrSchema);

        this.outputResults = outputResults;

        this.baseIndentLevel = baseIndentLevel;
        this.baseIndent = "";
        for (int i = 0; i < baseIndentLevel; ++i)
            baseIndent += "\t";

        building_PersistentMatrix = false; // default value
    }

    public void set_PackageName(DescriptorTagName packageName) {
        this.packageName = packageName;
        
        schemaAndMatrixBuilder.setPackageName(packageName);
    }

    /**
     * NOTE: you probably won't have the schema or matrix name when creating the schema or matrix descriptors. In these two cases, don't need to set this.
     */
    public void set_SchemaOrMatrixName(MatrixName schemaOrMatrixName) {
        this.schemaOrMatrixName = schemaOrMatrixName;
    }


    /**
     * NOTE: often, you only have the descTagName, and will have no descTag_SchemaName
     */
    public void set_DescriptorTag(MatrixName descTag_SchemaName, DescriptorTagName descTagName) {
        if (descTagName != null) {
            this.descTag_SchemaName_Actual = descTag_SchemaName;
            this.descTagName_Actual = descTagName;
            this.descTagName_Parts = Arrays.asList(descTagName.getSymbolNames());
            this.descTagName_String = descTagName.get_Name_no_backtiks();

            this.descTag_PrintOutString = ((descTag_SchemaName != null) ? descTag_SchemaName.get_Name_no_backtiks() + "::" : "" )
                    + descTagName_String;
        }
    }
    public void set_Label(Label label) {
        if (label != null) {
            this.label_Actual = label;
            this.label_Parts = Arrays.asList(label.getSymbolNames());
            this.label_Full = label.getName();
        }
    }


    public void set_Parent(MatrixStructInfo_DescriptorContainer parent_DescContainer, String parentDesc_OutVarName) {
        this.parentDesc_Container = parent_DescContainer;
        if (parent_DescContainer != null)
            this.parentDesc_SchemaInfoDesc = (SchemaInfo_Descriptor)parent_DescContainer.getSchemaInfo();
        this.parentDesc_OutVarName = parentDesc_OutVarName;

    }

    public void set_SchemaRelatedValues(MatrixSet<SchemaInfo_Schema> usesSchema_Set, SchemaSet_ScopeStack schemaSet_ScopeStack,
                                        String schemaSetScopeStack_OutVarName) {
        this.usesSchema_Set = usesSchema_Set;
        this.schemaSet_ScopeStack = schemaSet_ScopeStack;
        this.schemaSetScopeStack_OutVarName = schemaSetScopeStack_OutVarName;
    }


    public void set_Building_PersistentMatrix(boolean building_PersistentMatrix) {
        this.building_PersistentMatrix = building_PersistentMatrix;
    }




    public CodeBuilder generate_CreateDescriptor(CodeBuilder codeBuilder, Symbol buildingMatrixOrSchemaElem, boolean create_InitialMatrixDescriptor)
        throws Exception_MetaCompilerError {

        return generate_CreateDescriptor(codeBuilder, buildingMatrixOrSchemaElem, create_InitialMatrixDescriptor,
                false, true, null, null, null);
    }



    public CodeBuilder generate_CreateDescriptor_w_FieldSetTuple(CodeBuilder codeBuilder, Symbol buildingMatrixOrSchemaElem,
            boolean create_InitialMatrixDescriptor,
            
            //  FieldSet parameters:
            List<String> fieldValueExpr_List, List<FieldValueInfo> fieldValueInfo_List)
        throws Exception_MetaCompilerError {

        return generate_CreateDescriptor(codeBuilder, buildingMatrixOrSchemaElem, create_InitialMatrixDescriptor,
                (fieldValueExpr_List != null), true,
                fieldValueExpr_List, null, fieldValueInfo_List);
    }

    public CodeBuilder generate_CreateDescriptor_w_FieldSetParameterMap(CodeBuilder codeBuilder,
            Symbol buildingMatrixOrSchemaElem, boolean create_InitialMatrixDescriptor,
            
            //  FieldSet Parameter map fields
            List<Pair<DescriptorTagName,String>> paramMap_fieldToValue_List, List<FieldValueInfo> fieldValueInfo_List)
        throws Exception_MetaCompilerError {

        return generate_CreateDescriptor(codeBuilder, buildingMatrixOrSchemaElem, create_InitialMatrixDescriptor,
                (paramMap_fieldToValue_List != null), false,
                null, paramMap_fieldToValue_List, fieldValueInfo_List);
    }

    
    public CodeBuilder generate_CreateDescriptor(CodeBuilder codeBuilder, Symbol buildingMatrixOrSchemaElem, boolean create_InitialMatrixDescriptor,
            
            //  FieldSet parameters:
            boolean has_FieldSet, boolean fieldSet_is_Tuple, 
            //  fieldSet tuple parameters
            List<String> tuple_FieldValueExpr_List,
            //  this parameter is only if it's a parameter map
            List<Pair<DescriptorTagName,String>> paramMap_FieldToValue_List,
            //  Used for both tuples and parametermaps
            List<FieldValueInfo> fieldValueInfo_List)
        throws Exception_MetaCompilerError {


        if (codeBuilder == null)
            codeBuilder = new CodeBuilder();

        //  If buildingMatrixOrSchemaElem equals BuildingSchemaElement, check to make sure that you are really building a schema DESCRIPTOR-descriptor,
        //  and not a regular descriptor for a schema.
        if (buildingMatrixOrSchemaElem == MPSymbols.BuildingSchemaElement && descTagName_Actual != null &&
                descTagName_Actual != MPSymbols_DescTagName.SCHEMA &&
                descTagName_Actual != MPSymbols_DescTagName.DESCRIPTOR)
            buildingMatrixOrSchemaElem = MPSymbols.BuildingMatrixElementForSchema;
        
        boolean buildingInitialMatrixDesc = (buildingMatrixOrSchemaElem == MPSymbols.BuildingMatrixElement) && create_InitialMatrixDescriptor;
        boolean buildingInitialSchemaDesc = (buildingMatrixOrSchemaElem == MPSymbols.BuildingSchemaElement) && create_InitialMatrixDescriptor;



        if (descTagName_Actual == null) {
            //  Determine if the desc tag should be MATRIX, SCHEMA, the descTag that was passed in, or DESCRIPTOR (for schemaInfo Descriptors)
            DescriptorTag descTag = DescriptorCodeGenerator_Utilities.determine_DescriptorTag(buildingMatrixOrSchemaElem, create_InitialMatrixDescriptor);
             set_DescriptorTag(descTag.getSchemaName_Full(), descTag.getDescTagName());
        }


        //  Schema: Create SchemaName & DescTag Symbols _____________________________________________
        if (buildingMatrixOrSchemaElem == MPSymbols.BuildingSchemaElement && label_Actual != null) {
            if (buildingInitialSchemaDesc) {
                try {
                    schemaOrMatrixName = symbolControl.multiLevelSymbol_Factory.createNew_SchemaName(packageName,
                        SymbolUtilities.convert_Label_to_DescTagName(label_Actual, symbolControl), creating_StaticMatrixOrSchema);
                } catch(Exception e) {
                    throw new Exception_MetaCompilerError("Tried to create a schema name for this schema, but had an error." +
                            "The schemaName that we tried to create was: " + (packageName != null ? packageName.get_Name_no_backtiks() : "null") + "::" +
                                (label_Actual != null ? label_Actual.get_Name_no_backtiks() : "null") + ".", e);
                }

            } else {
                //  we're creating a schema descriptor-descriptor, then you need to create a descTag symbol for the label(convert label into desctag)/schemaName pair. Why?
                //  so that it will be added to the symbol file.
                try {
                    symbolControl.multiLevelSymbol_Factory.createNew_DescriptorTag(schemaOrMatrixName,
                        SymbolUtilities.convert_Label_to_DescTagName(label_Actual, symbolControl), creating_StaticMatrixOrSchema);
                } catch(Exception e) {
                    throw new Exception_MetaCompilerError("Tried to create a descriptor tag for this schema descriptor-descriptor, but had an error. " +
                            "The descriptorTag that we tried to create was : " + (schemaOrMatrixName != null ? schemaOrMatrixName.get_Name_no_backtiks() : "null") + "::" +
                                (label_Actual != null ? label_Actual.get_Name_no_backtiks() : "null") + ".", e);
                }
            }
        }

        
        descriptor_OutVarName = "descriptor" + CodeGeneratorUtilities.var_IdCreator.getAndInc_ID() +
                SymbolConstants.SymbolPath_IdentifierGroupSeparator + TextUtilities.convertTextToIdentifier(descTagName_String) ;
        String descriptorUsesSchemaSet_OutVarName = descriptor_OutVarName +
                    SymbolConstants.SymbolPath_IdentifierGroupSeparator + CodeConstants.OutVarName_Descriptor_UsesSchemaSet_Suffix;





        //  OutComment _________________________________________________________
        String descriptorDescription = null;

        if (buildingMatrixOrSchemaElem == MPSymbols.BuildingMatrixElement) {
            if (create_InitialMatrixDescriptor)
                descriptorDescription = "Matrix with name, " + label_Actual.get_Name_no_backtiks();
            else
                descriptorDescription = "Descriptor with descriptor tag, " + descTag_PrintOutString
                        + (label_Actual != null ? (", and label, " + label_Actual.getLabel_withBacktiks()) : "");

        } else if (buildingMatrixOrSchemaElem == MPSymbols.BuildingMatrixElementForSchema) {
            descriptorDescription = "Field Descriptor for a schema with the name, " + descTag_PrintOutString;

        } else {
            if (create_InitialMatrixDescriptor)
                descriptorDescription = "Schema with name, " + label_Actual.get_Name_no_backtiks();
            else
                descriptorDescription = "SchemaInfo_Descriptor with descriptor tag with label, " + label_Actual.getName();
        }
        codeBuilder
            .append("\n" + baseIndent + "//  Creating " + descriptorDescription + " __________________________________________________\n");


        

        //  Initialize the Schema-MatrixSet Scope Stack______________________________
        //  Add the Matrix Base Schema and the Schema For Schema to the scope stack if we're creating a matrix.
        //  Do for both the output and the metacompiler versions of matrix
        if (create_InitialMatrixDescriptor) {
            codeBuilder
                .append(baseIndent + "try {\n")
                .append(baseIndent + "\t" + schemaSetScopeStack_OutVarName + ".add(new MatrixSet<SchemaInfo_Schema>().add(\n" +
                            baseIndent + "\t\t" + AppControl_OutVariableName + ".schemaControl.schemaFactory.get_BaseSchema(executeInfo),\n" +
                            baseIndent + "\t\t" + AppControl_OutVariableName + ".schemaControl.schemaForSchema\n" +
                            baseIndent + "\t));\n")
                .append(baseIndent + "} catch (Exception e) {\n")
                .append(baseIndent + "\tthrow new Exception_MatrixRuntime_Checked(\"while trying to create a new Matrix Or Schema descriptor with the name, " +
                            label_Full + ",\" + \n")
                .append(baseIndent +"\t\t\" tried to add the Base Schema to the scope stack, but had an error creating it (see inner exception).\", e);\n")
                .append(baseIndent + "}\n\n");


        }

        //  Setup output vars ______________________________________
        codeBuilder.append(baseIndent + "MatrixSet<SchemaInfo_Schema> " + descriptorUsesSchemaSet_OutVarName +";\n");
        codeBuilder.append(baseIndent + "Descriptor " + descriptor_OutVarName + ";\n\n");
        codeBuilder.append(baseIndent + "try {\n");


        //  MatrixSet up the setItem CallBack Processor to the GetSchemas() callback. This method will return the Output Code for finding each schema
        //  in the uses schema set.
        //  first, create the set
        Set_CodeGenerator_ItemProcessor_CallBack setItemProcessor_Callback = new Set_CodeGenerator_ItemProcessor_GetSchemas(
                hierarchySettings.appSymbolClassName_SchemaName);
        Object[] callbackArgs = new Object[] { schemaControl, AppControl_OutVariableName };

        codeBuilder.append(baseIndent + "\t" + descriptorUsesSchemaSet_OutVarName +
                " = " + Set_CodeGenerator.generate_SetCode(null, outputResults, true, "SchemaInfo_Schema", 
                (usesSchema_Set != null ? usesSchema_Set.getItems() : null), null,
                setItemProcessor_Callback, callbackArgs) + ";\n");



        

        //  now try to find the schemaInfo_Descriptor for the descTag __________________________________________
        SchemaInfo_Descriptor descriptor_SchemaInfo = null;
        if (descTag_SchemaName_Actual != null) {
            try {
                descriptor_SchemaInfo = SchemaInfoUtilities.find_SchemaInfoDescriptor_in_Stack(executeInfo, descTagName_Actual, descTag_SchemaName_Actual,
                    symbolControl, parentDesc_SchemaInfoDesc, schemaSet_ScopeStack, true);
            } catch (Exception_InvalidArgumentPassed e) {
                throw new Exception_MetaCompilerError("tried to find the schemaInfo for the descriptor tag, '" + descTag_PrintOutString +
                        "', but couldn't find it in the schema-set scope-stack. Was doing a search by DescriptorTagName (with it's schemaName), but had an error.", e);
            }


        } else { // There is no schemaName for this descriptor. Try to find 1 match for it!!

            MatrixSet<SchemaInfo_Descriptor> found_SchemaInfo_Descriptors = null;
            try {
                found_SchemaInfo_Descriptors = SchemaInfoUtilities.find_SchemaInfoDescriptors_AtSameLevel_in_Stack(executeInfo,
                        descTagName_Actual, parentDesc_SchemaInfoDesc, schemaSet_ScopeStack, true);
            } catch (Exception_InvalidArgumentPassed e) {
                throw new Exception_MetaCompilerError("tried to find the schemaInfo for the descriptor tag name, '" + descTag_PrintOutString +
                    "', but couldn't find it in the schema-set scope-stack. Was doing a search by just DescriptorTagName (no schemaName), but had an error.", e);
            }


            if (found_SchemaInfo_Descriptors != null || found_SchemaInfo_Descriptors.size() < 1) {
                throw new Exception_MetaCompilerError("tried to find the schemaInfo for the descriptor tag name, '" + descTag_PrintOutString +
                    "', but couldn't find it in the schema-set scope-stack. Was doing a search by just DescriptorTagName (no schemaName), but " +
                    "did not find any SchemaInfo_Descriptors matching te descriptor tag.");

            } else if (found_SchemaInfo_Descriptors.size() == 1) {
                descriptor_SchemaInfo = found_SchemaInfo_Descriptors.get(0);

            } else { // more than one schemaInfo_Descriptor found. Error
                throw new Exception_MetaCompilerError("tried to find the schemaInfo for the descriptor tag name, '" + descTag_PrintOutString +
                    "', but couldn't find it in the schema-set scope-stack. Was doing a search by just DescriptorTagName (no schemaName), but " +
                    ", at a given level in the scope stack, found more than 1 schemaInfo_Descriptor matching the descriptor tag name. Found " +
                    found_SchemaInfo_Descriptors.size() + " of them, at depth-level of " + executeInfo.getInfoParameterHash().get(SchemaInfoUtilities.Found_DepthLevel) + 
                    " (depth-level '0' would be the descriptor you started the search on)") ;

            }
        }


        //  Create the matrix usage (or schema) descriptor for the Metacompiler______________________
        descriptor_Container = schemaAndMatrixBuilder.forEachDescriptor__CreateMatrixUsageDescriptor_BasedOnType(descTagName_Actual, label_Actual,
                descriptor_SchemaInfo, parentDesc_Container, usesSchema_Set, buildingMatrixOrSchemaElem, create_InitialMatrixDescriptor);






        //  Now, generate the new descriptor ___________________________________________________________________________________________________

        String descriptor_FactoryMethod_Code = DescriptorCodeGenerator_Utilities.determine_DescriptorFactoryMethod_Code(buildingMatrixOrSchemaElem,
                create_InitialMatrixDescriptor);
        String descLabel_Code = Symbol_CodeGeneratorUtilities.generateNewLabel(outputResults, AppControl_OutVariableName, label_Parts,
                label_CreationStartLevel, true);



        CodeGeneratorTask_CreateSchemaInfo_AccessCode schemaInfoAccessCode_Generator = new CodeGeneratorTask_CreateSchemaInfo_AccessCode();
        String descSchemaInfo_AccessCode = null;

        if (buildingInitialSchemaDesc || buildingInitialMatrixDesc) {
            
            codeBuilder.append(baseIndent + "\t" + descriptor_OutVarName + " = (Descriptor)" + AppControl_OutVariableName + "." +
                    descriptor_FactoryMethod_Code + "(executeInfo, " + 
                    hierarchySettings.appSymbolClassName_Label + "." + label_Actual.get_Name_IdentFormat() + ", " +
                    hierarchySettings.appSymbolClassName_DescTagName + "." + packageName.get_Name_IdentFormat() +
                    ", true, " + descriptorUsesSchemaSet_OutVarName +
                    ", " + parentDesc_OutVarName + ", true");


        } else {
            descSchemaInfo_AccessCode = schemaInfoAccessCode_Generator.SchemaInfo_Descriptor__GenerateAccessCode(descriptor_SchemaInfo,
                    executeInfo, AppControl_OutVariableName, hierarchySettings.appSymbols_ClassName);

            codeBuilder.append(baseIndent + "\t" + descriptor_OutVarName + " = (Descriptor)" + AppControl_OutVariableName + "." +
                    descriptor_FactoryMethod_Code + "(executeInfo, " +
                    descSchemaInfo_AccessCode + ", " +
                    descLabel_Code + ", " + descriptorUsesSchemaSet_OutVarName +
                    ", " + parentDesc_OutVarName);
        }
        //  add the descriptor id if building a persistent matrix
        if (buildingMatrixOrSchemaElem == MPSymbols.BuildingMatrixElement && building_PersistentMatrix)
            codeBuilder
                .append(", " + descriptor_Container.descriptor_Actual.descriptorID);

        codeBuilder
            .append(");\n" );





        //  Metacompiler new Descriptor ________________________________________________________________________________________



        //  FieldSet: generate code to add values to fieldSet if there is one____________________________________
        if (has_FieldSet) {
            if (fieldSet_is_Tuple) {
                DescriptorCreation_CodeGenerator_FieldSetWorker.generate_FieldSetTuple(executeInfo, codeBuilder, (baseIndent + "\t"),
                        descriptor_SchemaInfo.get_SchemaInfoFieldSet(executeInfo), descriptor_OutVarName,
                        fieldSet_is_Tuple, tuple_FieldValueExpr_List, fieldValueInfo_List, hierarchySettings.appClasses_PackageName);


            } else {
                DescriptorCreation_CodeGenerator_FieldSetWorker.generate_FieldSetParameterMap(executeInfo, codeBuilder, symbolControl, hierarchySettings,
                        (baseIndent + "\t"), descriptor_SchemaInfo.get_SchemaInfoFieldSet(executeInfo),
                        descriptor_OutVarName, fieldSet_is_Tuple, paramMap_FieldToValue_List, fieldValueInfo_List);
            }

            //  For the InMemory Metacompiler matrices, don't need to actually add values to the descriptor_actual's fieldset,
            //  just create the fieldsets.
            schemaAndMatrixBuilder.forEachDescriptor__CreateFieldSetTuple(descriptor_Container, fieldSet_is_Tuple);
        }


        //  Add the usesSchema_Set to the schemaSet ScopeStack, so the schemas used by the current descriptor can be accessed by the
        //  child descriptors. Again, do for both the output version and the metacompiler version of matrix
        codeBuilder.append(baseIndent + "\t" + schemaSetScopeStack_OutVarName + ".add(" + descriptorUsesSchemaSet_OutVarName + ");\n");
        schemaSet_ScopeStack.stack.add(usesSchema_Set);

        
        //  Add Descriptor to its parent
        if (parentDesc_OutVarName != null && parentDesc_OutVarName.length() > 0) {
            String parentDesc_OutVarName_w_Cast = (buildingMatrixOrSchemaElem == MPSymbols.BuildingSchemaElement ||
                                                    buildingMatrixOrSchemaElem == MPSymbols.BuildingMatrixElementForSchema) ?
                "((SchemaInfo_Descriptor)" + parentDesc_OutVarName + ")" : parentDesc_OutVarName;
            String addChildDesc_Method = DescriptorCodeGenerator_Utilities.determine_AddChildDescriptor_Method(buildingMatrixOrSchemaElem,
                    descTagName_Actual);
            String childDescriptor_Cast_Code = DescriptorCodeGenerator_Utilities.determine_AddChildDescriptor_Parameter_Cast(
                    buildingMatrixOrSchemaElem, descTagName_Actual);
            
            codeBuilder.append(baseIndent + "\t" + parentDesc_OutVarName_w_Cast + "." + addChildDesc_Method + "(executeInfo, " +
                    childDescriptor_Cast_Code + descriptor_OutVarName + ");\n");


            //  For the Metacompiler matrix, add this new descriptor to its parent
            schemaAndMatrixBuilder.forEachDescriptor__AddChildDescToParent(parentDesc_Container, descriptor_Container, buildingMatrixOrSchemaElem, descTagName_Actual);
        }



        
        codeBuilder.append("\n" + baseIndent + "} catch(Exception e) {\n")
                .append(baseIndent + "\tthrow new Exception_MatrixRuntime_Checked(\"Tried to create a new descriptor with the name, "
                    + descTag_PrintOutString +
                    (label_Full != null ? (", and with label, " + label_Full ) : ", and with an empty label") +
                    ", but had an error\", e);\n")
                .append(baseIndent + "}\n\n");


        //  set the return parameter values
        outputResults.returnParameters.put(returnParamName__desc_OutVarName, descriptor_OutVarName);

        outputResults.addImport(CodeConstants.MatrixImports_Main);
        outputResults.addImport(CodeConstants.MatrixImports_Symbols);
        outputResults.addImport(CodeConstants.MatrixImports_AbstractExceptions);
        outputResults.addImport(CodeConstants.MatrixImports_AbstractLang);
        outputResults.addImport("import java.util.Arrays;");
        outputResults.addImport("import java.util.LinkedList;");

        return codeBuilder;
    }







    /**
     * In the creation of a matrix, surround the creation of the child descriptor set with these add + remove codeGen methods. The purpose
     * of these is to create the code to put the usesSchemaSet in the schemaSet scopeStack so that the child descriptor can see the parent's
     * uses SchemaSet.
     *
     * @param schemaSetScopeStack_OutVarName
     * @param usesSchemaSet_OutVarName
     * @return
     */
    public String generate__Add_UseSchemaListVar_ToScopeStack(String schemaSetScopeStack_OutVarName, String usesSchemaSet_OutVarName) {
        return schemaSetScopeStack_OutVarName + ".addFirst(" + usesSchemaSet_OutVarName + ");\n";
    }
    /**
     * See the generate__Add_UseSchemaListVar_ToScopeStack() javadoc
     *
     * @param schemaSetScopeStack_OutVarName
     * @param usesSchemaSet_OutVarName
     * @return
     */
    public String generate__Remove_UseSchemaListVar_ToScopeStack(String schemaSetScopeStack_OutVarName, String usesSchemaSet_OutVarName) {
        return schemaSetScopeStack_OutVarName + ".remove();\n";
    }


    /**
     * After generation, get the InMemory descriptors generated for the metacompiler versions of the matrix/schemas.
     * @return
     */
    public MatrixStructInfo_DescriptorContainer postGenerate_Get_DescriptorContainer() {
        return descriptor_Container;
    }

    /**
     * After generation, get the descriptor Out Variable Name
     * @return
     */
    public String postGenerate_Get_DescriptorOutVarName() {
        return descriptor_OutVarName;
    }

    public MatrixName postGenerate_Get_SchemaOrMatrixName() {
        return schemaOrMatrixName;
    }

    

    




}
