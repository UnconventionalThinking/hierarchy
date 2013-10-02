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


import net.unconventionalthinking.matrix.MatrixStructInfo_DescriptorContainer;
import net.unconventionalthinking.hierarchy.grammar.analysis.*;
import net.unconventionalthinking.hierarchy.grammar.node.*;

import net.unconventionalthinking.compiler.tools.*;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.AppControl_Base;
import net.unconventionalthinking.matrix.Descriptor;
import net.unconventionalthinking.matrix.FieldConstants;
import net.unconventionalthinking.matrix.FieldValueInfo;
import net.unconventionalthinking.matrix.MatrixControl;
import net.unconventionalthinking.matrix.SchemaControl;
import net.unconventionalthinking.matrix.SchemaInfo_Schema;
import net.unconventionalthinking.matrix.MatrixSet;
import net.unconventionalthinking.matrix.metacompiler.codefilegen.AnnotationsInterface_FileGenerator;
import net.unconventionalthinking.utilities.*;


import net.unconventionalthinking.matrix.metacompiler.codegen.*;
import net.unconventionalthinking.matrix.symbols.DescriptorTag;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.MPSymbols_DescTag;
import net.unconventionalthinking.matrix.symbols.MPSymbols_DescTagName;
import net.unconventionalthinking.matrix.symbols.MPSymbols_SchemaName;
import net.unconventionalthinking.matrix.symbols.MatrixName;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.matrix.symbols.SymbolType;
import net.unconventionalthinking.hierarchy.AppControl_Info;
import net.unconventionalthinking.hierarchy.Exception_HierarchyCompiler;
import net.unconventionalthinking.hierarchy.Node_ToStringProcessor;
import net.unconventionalthinking.hierarchy.HierarchyControl;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import net.unconventionalthinking.hierarchy.SchemaSet_ScopeStack;
import net.unconventionalthinking.hierarchy.langexpressions.Expression;
import net.unconventionalthinking.hierarchy.langexpressions.ExpressionPart_Identifier;
import net.unconventionalthinking.hierarchy.langsymboltable.LangSymbolTable_App;
import net.unconventionalthinking.hierarchy.langsymboltable.MatrixAccessState;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import net.unconventionalthinking.hierarchy.HierarchySettings_forMatrix;
import net.unconventionalthinking.matrix.metacompiler.codefilegen.CodeFileGenerator_Utilities;
import net.unconventionalthinking.matrix.metacompiler.codefilegen.ImportUtilities;
import net.unconventionalthinking.matrix.symbols.SymbolUtilities;


import org.apache.commons.collections.map.MultiValueMap;




/**
 *
 * @author peterjoh
 */
public class HierarchyActions extends LangSymbolTableActions__FileSymTableClient {



    public enum FieldSetCreationType { None, FieldSet_Tuple, FieldSet_ParamMap }
    // This is an enum describing the type of production that matched for the element name: ITEM, identifier, FIELD.*...
    // NOTE: The reason the name is so long is because there already is a MatrixElementName_Type enum.
    public enum MatrixElementName_MatchedProductionType { ITEM, DESCRIPTOR, FIELD_w_Children, Identifier, Identifier_w_OneOrMoreNameScopes }



    public CodeGen_OutputResults    outputResults;
    public HierarchyControl         hierarchyControl;
    public CodeBuilder              codeBuilder_MatrixConstruction;
    public int                      baseIndentLevel = 2;

    SymbolControl                   symbolControl;
    SchemaControl                   schemaControl;
    MatrixControl                   matrixControl;
    ExecutionInfo                   executeInfo;

    HashSet<AppControl_Info>        externalAppControlSet_forFile;


    LangSymbolTable_App             symbolTable_App;

    HierarchySettings_forMatrix         matrixSettings;
    List<URL>                           classPath_List;


    CodeGenerators                      codeGenerators;
    CodeGenerators_MatrixAccess         codeGenerators_MatrixAccess;
    String                              translatedCode;


    String                              className;
    DescriptorTagName                   packageName_DescTagName;
    CodeBuilder                         packageName_DescTagName_AccessCode;


    MultiValueMap                       imports__SchemaNames_Index__BySchemaNameSimple;
    MultiValueMap                       imports__MatrixNames_Index__ByMatrixNameSimple;

    DescriptorCreation_CodeGenerator                descCodeGen_CurrSchemaOrMatrix;
    LinkedList<DescriptorCreation_CodeGenerator>    descCodeGen_Stack;
    SchemaSet_ScopeStack                            schemaSet_ScopeStack;

    MetaCompilation_Phase               metaCompilation_Phase;
    boolean                             metaCompiling_EmbeddedJavaFile;
    boolean                             collecting_LangSymbols;

    HierarchyActionsWorkerContainer     workers;


    IdentifierParts                     identifier_Parts;

    public static final String          SchemaSetScopeStack_OutVarName = "schemaSet_ScopeStack";





    //  ________________________________________________________________________________________________________________
    //
    //    Constructors and Setup methods
    //  ________________________________________________________________________________________________________________


    /** This constructor usually called when compiling the schemas, which come first, so there is no appControl yet */
    public HierarchyActions(MetaCompilation_Phase metaCompilation_Phase, HierarchyControl hierarchyControl,
            HierarchySettings_forMatrix matrixSettings, String fileName, String packageName,
            boolean fileSymbolTable_Enabled) throws Exception_HierarchyCompiler {
        super(fileName, fileSymbolTable_Enabled, hierarchyControl.hierarchySettings);

        this.hierarchyControl = hierarchyControl;

        construct_Finish(metaCompilation_Phase, null, null, matrixSettings, fileName, packageName);
    }

    /**  Call this constructor for creating matrices and schemas */
    public HierarchyActions(MetaCompilation_Phase metaCompilation_Phase, AppControl_Base appControl, 
            HierarchySettings hierarchySettings, HierarchySettings_forMatrix matrixSettings,
            String fileName, String packageName, boolean fileSymbolTable_Enabled,
            java.util.Set<String> existing_ImportSet) throws Exception_HierarchyCompiler {
        super(fileName, fileSymbolTable_Enabled, hierarchySettings);

        if (appControl != null) {
            hierarchyControl = new HierarchyControl(hierarchySettings, appControl); // get symControl,schemaControl... from existing appControl
        }

        construct_Finish(metaCompilation_Phase, existing_ImportSet, null, matrixSettings, fileName, packageName);
    }


    /** Call this constructor for collecting lang-symbols. Should only be called by the child class, LangSymbolTableActions__SymCreator*/
    HierarchyActions(AppControl_Base appControl, HierarchySettings hierarchySettings,
            String fileName, String primaryClassName, String packageName, boolean fileSymbolTable_Enabled,
            java.util.Set<String> existing_ImportSet) throws Exception_HierarchyCompiler {

        // pass in the symolTable_App, so the super part of this object can find it's symbolTableFile
        super(fileName, true, hierarchySettings);

        if (appControl != null) {
            hierarchyControl = new HierarchyControl(hierarchySettings, appControl); // get symControl,schemaControl... from existing appControl
        }

        construct_Finish(MetaCompilation_Phase.Collecting_LangSymbols, existing_ImportSet, null, matrixSettings, fileName, packageName);
    }



    /** Call this constructor for meta-compiling embedded java files, with the metaCompiling_EmbeddedJavaFile set to true; */
    public HierarchyActions(MetaCompilation_Phase metaCompilation_Phase, AppControl_Base appControl, HierarchySettings hierarchySettings,
            String fileName, String primaryClassName, String packageName, boolean fileSymbolTable_Enabled,
            LangSymbolTable_App symbolTable_App, java.util.Set<String> existing_ImportSet) throws Exception_HierarchyCompiler {

        // pass in the symolTable_App, so the super part of this object can find it's symbolTableFile
        super(metaCompilation_Phase, fileName, packageName + "." + primaryClassName, symbolTable_App, fileSymbolTable_Enabled, hierarchySettings);

        if (appControl != null) {
            hierarchyControl = new HierarchyControl(hierarchySettings, appControl); // get symControl,schemaControl... from existing appControl
        }

        construct_Finish(metaCompilation_Phase, existing_ImportSet, symbolTable_App, null, fileName, packageName);
    }



    private void construct_Finish(MetaCompilation_Phase metaCompilation_Phase, java.util.Set<String> existing_ImportSet,
            LangSymbolTable_App symbolTable_App, HierarchySettings_forMatrix matrixSettings, String fileName, String packageName) {

        symbolControl = hierarchyControl.symbolControl;
        schemaControl = hierarchyControl.schemaControl;
        matrixControl = hierarchyControl.matrixControl;
        executeInfo = hierarchyControl.executionInfo;

        super.hierarchySettings = hierarchyControl.hierarchySettings;
        //  give the logger the filename.
        super.hierarchySettings.logger.currFileName = fileName;
        super.hierarchySettings.logger.currPackage = packageName;

        this.matrixSettings = (matrixSettings != null ? matrixSettings : new HierarchySettings_forMatrix());
        
        externalAppControlSet_forFile = new HashSet<AppControl_Info>();
        descCodeGen_Stack = new LinkedList<DescriptorCreation_CodeGenerator>();
        codeGenerators = new CodeGenerators(hierarchyControl.symbolControl);
        identifier_Parts = new IdentifierParts();


        this.symbolTable_App = symbolTable_App;


        workers = new HierarchyActionsWorkerContainer(this, hierarchyControl, baseIndentLevel);


        this.metaCompilation_Phase = metaCompilation_Phase;
        this.metaCompiling_EmbeddedJavaFile = (metaCompilation_Phase == MetaCompilation_Phase.MetaCompiling_EmbeddedJavaFile);
        this.collecting_LangSymbols = metaCompilation_Phase == MetaCompilation_Phase.Collecting_LangSymbols;
        if (metaCompiling_EmbeddedJavaFile || collecting_LangSymbols) {
            codeGenerators_MatrixAccess = new CodeGenerators_MatrixAccess(HierarchySettings.annotations_InterfaceName_Suffix, hierarchySettings,
                    hierarchyControl.symbolControl);
        }


        if (existing_ImportSet == null) {
            outputResults = new CodeGen_OutputResults();
            // Add some core matrix packages
            outputResults.addImport("import net.unconventionalthinking.exceptions.*;");
        } else {
            outputResults = new CodeGen_OutputResults(existing_ImportSet);
        }


    }


    public void setClassPath_List(List<URL> classPath_List) { this.classPath_List = classPath_List; }





    //  ________________________________________________________________________________________________________________
    //
    //    Get Methods
    //  ________________________________________________________________________________________________________________

    public CodeGenerators_MatrixAccess  get_CodeGenerators_MatrixAccess() { return codeGenerators_MatrixAccess;}
    public CodeBuilder                  getCodeBuilder_MatrixConstruction() { return codeBuilder_MatrixConstruction;}
    public CodeGen_OutputResults        getOutputResults() { return outputResults; }
    public HierarchyControl             getHierarchyControl() { return hierarchyControl; }

    /** This is the set of all the external appcontrols that need to be initialized for this matrix/schema/embedded file. */
    public HashSet<AppControl_Info>     get_ExternalAppControlSet_forFile() { return externalAppControlSet_forFile; }

    public List<URL>                    getClassPath_List() { return classPath_List; }



    public DescriptorCreation_CodeGenerator getSchemaOrMatrix_DescCodeGen() { return descCodeGen_CurrSchemaOrMatrix;}
    public String                       getClassName() { return className; }
    public String                       getTranslatedCode() { return translatedCode;}
    public LangSymbolTable_App          getSymbolTable_App() { return symbolTable_App; }






    //  ________________________________________________________________________________________________________________
    //
    //    Productions
    //  ________________________________________________________________________________________________________________


    /**
     * The defaultIn is the default "In" method called when a node is visited. By overriding the method like we did here,
     * we can customize the default behavior for the In method.
     *
     * What we've done here is to have a parent automatically pass its child its method-attribute set (actually,
     * the child is grabbing the attrib set from its parent).
     */
    @Override
    public void defaultIn(Node node) {
        if (node != null && node.parent() != null) {
            node.setMethodAttributes(node.parent().getMethodAttributes());
        }
    }

    /**
     * This is the default case statement for processing a node. This isn't used by the production actIons, they use
     * defaultIn() and defaultOut(), but by tokens actions.
     *
     * So, what we're going to do is when a node is processed, it will call this defaultCase(). We have all nodes that are
     * being processed set their line number and column to the error logger, to be used in error messages to the user.
     * @param node
     */
    @Override
    public void defaultCase(Node node)
    {
        // do nothing

        if (node instanceof Token) {
            Token token = (Token)node;
            hierarchySettings.logger.setCurrLineNumAndColumn(token.getLine(), token.getPos());

        }
    }




    //  Do initial Setup here:
    @Override
    public void inStart(Start node) {
        defaultIn(node);

        //  MatrixSet the default toString Processor for the nodes:
        AttributeNode.set_Default_ToStringProcessor(new Node_ToStringProcessor(false));
    }





    @Override
    public void outACompilationUnit(ACompilationUnit node) {

        List<PImportDeclaration> importsDeclaration_List = node.getImportDeclarations();
        
        for (PImportDeclaration importDeclaration : importsDeclaration_List)
            outputResults.addImport(importDeclaration.toString());


        if (metaCompiling_EmbeddedJavaFile) {

            translatedCode = CodeFileGenerator_Utilities.createMetaCompiledCommentToken().toString() +
                    node.toString();
        }

    }


    /**
     * Package Declaration
     *
     * This production is Not a generation method. It grabs the package declaration and puts it in the CodeOutput_Results
     */
    @Override
    public void inAPackageDeclaration(APackageDeclaration node) {

        MethodAttributeSet methodAttribs = node.createMethodAttributes(HierarchyMethodConstants.method_Process_PackageName, node, hierarchyControl);
        methodAttribs.vars.put(HierarchyMethodConstants.var_Identifier_PartsList, new LinkedList<String>());
    }
    @Override
    public void outAPackageDeclaration(APackageDeclaration node) {
        defaultOut(node);

        MethodAttributeSet methodAttribs = node.getMethodAttributes();
        LinkedList<String> packageName_Parts = (LinkedList<String>)methodAttribs.vars.get(HierarchyMethodConstants.var_Identifier_PartsList);

        packageName_DescTagName_AccessCode = new CodeBuilder();
        packageName_DescTagName = create_DescTagName_ForPackage(packageName_Parts, packageName_DescTagName_AccessCode);

        outputResults.setDestPackage(packageName_DescTagName.get_Name_no_backtiks());

        //  Need to add the package declaration to the codebuilder first, before we can add any imports.
        node.code(node.toString_ProcessCurrent());
        
        if (metaCompiling_EmbeddedJavaFile) {
            ImportUtilities.addAppClassImports(node.code(), true, outputResults.getDestPackage().trim(),
                    hierarchySettings.appClasses_PackageName.trim(), outputResults.getImportSet());
        } else {
            ImportUtilities.addAppClassImports(true, outputResults.getDestPackage().trim(),
                    hierarchySettings.appClasses_PackageName.trim(), outputResults.getImportSet());
        }

        if (metaCompiling_EmbeddedJavaFile)
            ImportUtilities.addMatrixImports(outputResults.getImportSet(), node.code());
    }



    private DescriptorTagName create_DescTagName_ForPackage(LinkedList<String> packageName_Parts, CodeBuilder codeBuilder_PackageNameAccess) {

        Integer_Mutable partCount = new Integer_Mutable(packageName_Parts.size());
        Integer_Mutable creation_StartLevel = new Integer_Mutable(-1);
        Symbol symbol_Actual = workers.symbols.generate_CreateOrAccessSymbols(codeBuilder_PackageNameAccess, SymbolType.DescriptorTagName,
                packageName_Parts, partCount, creation_StartLevel);

        return (DescriptorTagName)symbol_Actual;
    }






    @Override
    public void inAMpSchemaImportDeclaration(AMpSchemaImportDeclaration node) {
        defaultIn(node);
        MethodAttributeSet methodAttribs = node.createMethodAttributes(HierarchyMethodConstants.method_Process_MatrixImportHeader,
                node, hierarchyControl);

        //  pass the correct matrixelem name setting
        methodAttribs.methodCall_AddValue(HierarchyMethodConstants.method_Generate_MatrixElementName,
                HierarchyMethodConstants.param_MatrixElementName_Type, MatrixElementName_Type.Imported_Schema);
    }

    @Override
    public void outAMpSchemaImportDeclaration(AMpSchemaImportDeclaration node) {
        defaultOut(node);
        MethodAttributeSet methodHeader_AttribSet = node.getMethodAttributes();

        // don't forget to clear the method call values passed _to_ the method and the returnvalues passed _from_ the method
        methodHeader_AttribSet.methodCall_ClearAllValues();

        //  TODO - fow now, don't add the import. later import the class.
        node.code("");
    }

    @Override
    public void inAMpMatrixImportDeclaration(AMpMatrixImportDeclaration node)
    {
        defaultIn(node);
        MethodAttributeSet methodAttribs = node.createMethodAttributes(HierarchyMethodConstants.method_Process_MatrixImportHeader,
                node, hierarchyControl);

        //  pass the correct matrixelem name setting
        methodAttribs.methodCall_AddValue(HierarchyMethodConstants.method_Generate_MatrixElementName,
                HierarchyMethodConstants.param_MatrixElementName_Type, MatrixElementName_Type.Imported_Matrix);

    }

    @Override
    public void outAMpMatrixImportDeclaration(AMpMatrixImportDeclaration node)
    {
        defaultOut(node);
        MethodAttributeSet methodHeader_AttribSet = node.getMethodAttributes();

        // don't forget to clear the method call values passed _to_ the method and the returnvalues passed _from_ the method
        methodHeader_AttribSet.methodCall_ClearAllValues();

        //  TODO - fow now, don't add the import. later import the class.
        node.code("");
    }





    /**
     * Class Declaration - used for Embedded java files
     */
    @Override
    public void inAClassTypeDeclaration(AClassTypeDeclaration node) {
        defaultIn(node);
    }

    @Override
    public void outAClassTypeDeclaration(AClassTypeDeclaration node) {
        defaultOut(node);
    }



    @Override
    public void caseANormalClassDeclaration(ANormalClassDeclaration node) {
        inANormalClassDeclaration(node);


        {
            List<PModifier> copy = new ArrayList<PModifier>(node.getModifiers());
            for (PModifier e : copy) {
                e.apply(this);
            }
        }
        if (node.getClassToken() != null) {
            node.getClassToken().apply(this);
        }
        if (node.getIdentifier() != null) {
            node.getIdentifier().apply(this);
        }

        //  get the classname so it can be used by the other actions.
        className = node.getIdentifier().getText().trim();


        if (node.getTypeParameters() != null) {
            node.getTypeParameters().apply(this);
        }
        if (node.getSuper() != null) {
            node.getSuper().apply(this);
        }
        if (node.getInterfaces() != null) {
            node.getInterfaces().apply(this);
        }
        if (node.getClassBody() != null) {
            node.getClassBody().apply(this);
        }



        if (metaCompiling_EmbeddedJavaFile) {

            CodeBuilder codeBuilder = new CodeBuilder();

            if (node.getModifiers() != null) {
                for (PModifier pMod_Node : node.getModifiers()) {
                    codeBuilder.append(pMod_Node.toString()).append(' ');
                }
            }
            codeBuilder.append(node.getClassToken().getText()).append(' ').append(node.getIdentifier().getText()).append(' ');

            if (node.getTypeParameters() != null) {
                codeBuilder.append(node.getTypeParameters().toString()).append(' ');
            }
            if (node.getSuper() != null) {
                codeBuilder.append(node.getSuper().toString()).append(' ');
            }

            //  Add the Matrix annotations interfaces
            String implementsText = null;
            className = node.getIdentifier().getText().trim();

            if (node.getInterfaces() == null) {
                implementsText = "implements " + AnnotationsInterface_FileGenerator.generateInterfaceName(className);
            } else {
                implementsText = node.getInterfaces().toString() + ", " + AnnotationsInterface_FileGenerator.generateInterfaceName(className);
            }

            codeBuilder.append(implementsText).append(' ');

            if (node.getClassBody() != null) {
                codeBuilder.append(node.getClassBody().toString());
            }

            node.code(codeBuilder);
        }


        outANormalClassDeclaration(node);
    }




    @Override
    public void caseAClassBody(AClassBody node) {
        inAClassBody(node);

        if(node.getLBrc() != null) {
            node.getLBrc().apply(this);
        }

        {
            List<PClassBodyDeclaration> copy = new ArrayList<PClassBodyDeclaration>(node.getClassBodyDeclarations());
            for(PClassBodyDeclaration e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getRBrc() != null) {
            node.getRBrc().apply(this);
        }

        outAClassBody(node);
    }
    
    @Override
    public void outAClassBody(AClassBody node) {

        if (metaCompiling_EmbeddedJavaFile) {

            TLBrc lbrc_Node = node.getLBrc();
            CodeBuilder codebuilder = new CodeBuilder();
            //  Add the appControl and execution info static var declarations:
            codebuilder.append("\n\n\tprivate final static AppControl_Base appControl = " + hierarchySettings.appClasses_PackageName
                                        + ".AppControl.initializeApp();\n");
            codebuilder.append("\tprivate final static ExecutionInfo executeInfo = appControl.executionInfo;\n\n");
            lbrc_Node.code(lbrc_Node.getText()).append("\n").append(codebuilder);
            
            //  *************************************************************************
            //  Add Extra Methods Code here:
            //  *************************************************************************

            //  generate Embedded Code's annotation handlers____________________________

            TRBrc rBrcNode = node.getRBrc();
            CodeBuilder annotationHandlers = codeGenerators_MatrixAccess.annotationHandlers_CodeGen.generate_AnnotationHandlers(
                    codeGenerators_MatrixAccess.annotationsInterface_FileGen);


            CodeBuilder filter_AnnotationHandlers = codeGenerators_MatrixAccess.annotationHandlers_CodeGen_Filters.generate_AnnotationHandlers(
                    codeGenerators_MatrixAccess.annotationsInterface_FileGen);

            //  Add annotation handlers to embedded code ____________________________________________________________
            rBrcNode.code(annotationHandlers).append("\n\n\n").append(filter_AnnotationHandlers).append("\n").append(rBrcNode.getText());


        }


        //   Since you're overridding outAClassBody, you must call the super's version of this action, so it can manage the scope stack
        super.outAClassBody(node);
    }





    //  ________________________________________________________________________________________________________________
    //
    //    Matrix, Schema, and Descriptor Desclarations
    //  ________________________________________________________________________________________________________________

    /**
     * schemaOrMatrixDescriptor_Creation() -
     *    Used to create the initial schema or matrix descriptor's.
     *
     * Method Parameters:
     *    None
     *
     * Local Vars:
     *    Symbol                                buildingMatrixOrSchemaElem;
     *    DescriptorCreation_CodeGenerator      descriptor_CodeGen;
     *    MatrixSet<SchemaInfo_Schema>          usesSchema_Set;
     *
     * Returns:
     *    Matrix - the actualy Matrix Descriptor that is cretaed.
     * codeBuilder:
     *    Descriptor Creation Code is added to it.
     *
     */
    @Override
    public void caseAMpMatrixNewDeclaration(AMpMatrixNewDeclaration node) {
        MethodAttributeSet generate_MatrixDesc_Attribs = node.createMethodAttributes(HierarchyMethodConstants.method_Generate_Matrix, node,
                hierarchyControl);

        workers.descCreation.init_SchemaOrMatrixDescriptor_Creation(true);

        DescriptorTagName descTagName = MPSymbols_DescTagName.MATRIX;
        MatrixName matrixName = null;
        MatrixSet<SchemaInfo_Schema> usesSchema_Set = null;


        if (node.getMatrixNew() != null) {
            node.getMatrixNew().apply(this);
        }
        if (node.getMatrixName() != null) {
            //  pass it the matrixElementType for MatrixName Label
            generate_MatrixDesc_Attribs.methodCall_AddValue(HierarchyMethodConstants.method_Generate_MatrixElementName,
                    HierarchyMethodConstants.param_MatrixElementName_Type, MatrixElementName_Type.MatrixName_Label);
            node.getMatrixName().apply(this);

            matrixName = (MatrixName)hierarchyControl.returnValues_getMap_for(HierarchyMethodConstants.method_Generate_MatrixElementName).get(
                                                                                                   HierarchyMethodConstants.retVal_Symbol_Actual);

            // don't forget to clear the method call values passed _to_ the method and the returnvalues passed _from_ the method
            generate_MatrixDesc_Attribs.methodCall_ClearAllValues();
            hierarchyControl.returnValues_clearMap_for(HierarchyMethodConstants.method_Generate_MatrixElementName);
        }


        if (node.getUsesSchemas() != null) {
            node.getUsesSchemas().apply(this);
            usesSchema_Set = (MatrixSet<SchemaInfo_Schema>) generate_MatrixDesc_Attribs.vars.get(HierarchyMethodConstants.var_UsesSchema_Set);
        }


        DescriptorCreation_CodeGenerator desc_CodeGen = workers.descCreation.setup_SchemaOrMatrixDescriptor_Creation(node.getMethodAttributes(),
            MPSymbols.BuildingMatrixElement, descTagName, matrixName, usesSchema_Set, schemaSet_ScopeStack, matrixSettings.IsPersitentMatrix);

        descCodeGen_CurrSchemaOrMatrix = desc_CodeGen;
        descCodeGen_Stack.addLast(desc_CodeGen);

        if (node.getMatrixFieldAndBodyOptions() != null) {
            node.getMatrixFieldAndBodyOptions().apply(this);
        }


        //  Pop the matrix descCodeGen off the stack
        descCodeGen_Stack.removeLast();

        codeBuilder_MatrixConstruction = generate_MatrixDesc_Attribs.codeBuilder;
    }



    /**
     * (same as javadoc for caseAMpMatrixNewDeclaration)
     * @param node
     */
    @Override
    public void caseAMpSchemaNewDeclaration(AMpSchemaNewDeclaration node) {
        MethodAttributeSet generate_SchemaDesc_Attribs = node.createMethodAttributes(HierarchyMethodConstants.method_Generate_Schema, node, hierarchyControl);

        workers.descCreation.init_SchemaOrMatrixDescriptor_Creation(false);

        DescriptorTagName descTagName = MPSymbols_DescTagName.SCHEMA;
        MatrixName schemaName = null;
        // add schema_for_schema to the usesSchema_Set
        MatrixSet<SchemaInfo_Schema> usesSchema_Set = new MatrixSet<SchemaInfo_Schema>();
        usesSchema_Set.add(schemaControl.schemaForSchema);


        if (node.getSchemaNew() != null) {
            node.getSchemaNew().apply(this);
        }
        if (node.getMatrixName() != null) {
            //  pass it the matrixElementType for MatrixName Label
            generate_SchemaDesc_Attribs.methodCall_AddValue(HierarchyMethodConstants.method_Generate_MatrixElementName,
                    HierarchyMethodConstants.param_MatrixElementName_Type, MatrixElementName_Type.SchemaName_Label);
            node.getMatrixName().apply(this);

            schemaName = (MatrixName) hierarchyControl.returnValues_getMap_for(HierarchyMethodConstants.method_Generate_MatrixElementName)
                    .get(HierarchyMethodConstants.retVal_Symbol_Actual);

            // don't forget to clear the method call values passed _to_ the method and the returnvalues passed _from_ the method
            generate_SchemaDesc_Attribs.methodCall_ClearAllValues();
            hierarchyControl.returnValues_clearMap_for(HierarchyMethodConstants.method_Generate_MatrixElementName);
        }

        DescriptorCreation_CodeGenerator desc_CodeGen = workers.descCreation.setup_SchemaOrMatrixDescriptor_Creation(node.getMethodAttributes(),
                MPSymbols.BuildingSchemaElement, descTagName, schemaName, usesSchema_Set, schemaSet_ScopeStack,
                matrixSettings.IsPersitentMatrix);
        descCodeGen_CurrSchemaOrMatrix = desc_CodeGen;
        descCodeGen_Stack.addLast(desc_CodeGen);


        if (node.getMatrixFieldAndBodyOptions() != null) {
            node.getMatrixFieldAndBodyOptions().apply(this);
        }

        //  Pop the schema descCodeGen off the stack
        descCodeGen_Stack.removeLast();
        codeBuilder_MatrixConstruction = generate_SchemaDesc_Attribs.codeBuilder;
    }


    @Override
    public void outAMpEmptyMatrixFieldAndBodyOptions(AMpEmptyMatrixFieldAndBodyOptions node) {
        MethodAttributeSet generateDesc_Attribs = node.getMethodAttributes();

        workers.descCreation.create_SchemaOrMatrixDescriptor(node, FieldSetCreationType.None);

        // even though no child desc.s created, must still call descFinalProcessing_postChildDescCreation to finish processing current descriptor
        workers.descCreation.descFinalProcessing_postChildDescCreation(generateDesc_Attribs);
    }

    @Override
    public void outAMpFieldsetMatrixFieldAndBodyOptions(AMpFieldsetMatrixFieldAndBodyOptions node) {
        MethodAttributeSet generateDesc_Attribs = node.getMethodAttributes();

        workers.descCreation.create_SchemaOrMatrixDescriptor(node, FieldSetCreationType.FieldSet_ParamMap);

        // even though no child desc.s created, must still call descFinalProcessing_postChildDescCreation to finish processing current descriptor
        workers.descCreation.descFinalProcessing_postChildDescCreation(generateDesc_Attribs);
    }

    @Override
    public void caseAMpFieldsetAndBodyMatrixFieldAndBodyOptions(AMpFieldsetAndBodyMatrixFieldAndBodyOptions node) {
        inAMpFieldsetAndBodyMatrixFieldAndBodyOptions(node);


        if (node.getFieldsetParametermapWColon() != null) {
            node.getFieldsetParametermapWColon().apply(this);
        }

        MethodAttributeSet generateDesc_Attribs = node.getMethodAttributes();

        //  Create the parent schema/matrix descriptor before you create the child descriptors
        workers.descCreation.create_SchemaOrMatrixDescriptor(node, FieldSetCreationType.FieldSet_ParamMap);


        workers.descCreation.setup_ChildDescCreation(generateDesc_Attribs, false);
        if (node.getDescriptorBody() != null) {
            node.getDescriptorBody().apply(this);
        }
        workers.descCreation.descFinalProcessing_postChildDescCreation(generateDesc_Attribs);


        outAMpFieldsetAndBodyMatrixFieldAndBodyOptions(node);
    }


    //    Descriptor Declarations
    //  ________________________________________________________________________________________________________________
    /**
     * Descriptor_Creation() -
     *    Used to create descriptors.
     *
     * Method Parameters:
     *    Symbol                                        buildingMatrixOrSchemaElem;
     *    MatrixStructInfo_DescriptorContainer    parent_DescContainer;
     *    String                                        parentDesc_VarName;
     *    // actually, it just uses the constant value for this found in the class
     *    String                                        schemaSetScopeStack_OutVarName;
     *
     * Local Vars:
     *    // NOTE: the "buildingMatrixOrSchemaElem" param is copied over to the var section, so it descriptor declaration can use the same helper
     *    // methods as matrix/schema declarations
     *    Symbol                                buildingMatrixOrSchemaElem;
     *    DescriptorCreation_CodeGenerator      descriptor_CodeGen;
     *    Label                                 schemaName;
     *    DescriptorTag                         descTag;
     *    MatrixSet<SchemaInfo_Schema>          usesSchema_Set;
     *
     * Local Vars for fieldsets:
     *    FieldSetCreationType                  fieldSetCreationType;
     *
     *    List<String>                          fieldValueExpr_List;
     *    List<Pair<DescriptorTag, String>> paramMap_fieldToValue_List;
     *    List<FieldValueInfo>                  fieldValueInfo_List;
     *
     * Global vars used (HierarchyActions vars):
     *    SchemaSet_ScopeStack                  schemaSet_ScopeStack;
     *
     * Returns:
     *    Descriptor created.
     * codeBuilder:
     *    Descriptor Creation Code is added to it.
     *
     */
    @Override
    public void caseAMpDeclarationDescriptorDeclaration(AMpDeclarationDescriptorDeclaration node) {

        MethodAttributeSet generateDesc_Attribs = node.createMethodAttributes(HierarchyMethodConstants.method_Generate_Descriptor, node,
                hierarchyControl);

        Symbol buildingMatrixOrSchemaElem = (Symbol) generateDesc_Attribs.params.get(HierarchyMethodConstants.param_BuildingMatrixOrSchemaElem);
        MatrixStructInfo_DescriptorContainer parent_DescContainer = (MatrixStructInfo_DescriptorContainer) generateDesc_Attribs.params.get(
                HierarchyMethodConstants.param_ParentDesc_Container);
        String parentDesc_VarName = (String) generateDesc_Attribs.params.get(HierarchyMethodConstants.param_ParentDesc_OutVarName);


        DescriptorTag descTag = null;
        Label label = null;
        MatrixSet<SchemaInfo_Schema> usesSchema_Set = null;


        if (node.getDescriptorHeadOptions() != null) {
            node.getDescriptorHeadOptions().apply(this);

            descTag = (DescriptorTag) generateDesc_Attribs.vars.get(HierarchyMethodConstants.var_DescTag);
            label = (Label) generateDesc_Attribs.vars.get(HierarchyMethodConstants.var_Label);
        }

        if (node.getUsesSchemas() != null) {
            node.getUsesSchemas().apply(this);

            usesSchema_Set = (MatrixSet<SchemaInfo_Schema>) generateDesc_Attribs.vars.get(HierarchyMethodConstants.var_UsesSchema_Set);
        }


        DescriptorCreation_CodeGenerator desc_CodeGen = workers.descCreation.setup_DescriptorCreation(node.getMethodAttributes(),
                buildingMatrixOrSchemaElem, descTag.getDescTagName(), descTag.getSchemaName_Full(), label,
                descCodeGen_CurrSchemaOrMatrix.postGenerate_Get_SchemaOrMatrixName(), usesSchema_Set, schemaSet_ScopeStack, parent_DescContainer,
                parentDesc_VarName, matrixSettings.IsPersitentMatrix);
        descCodeGen_Stack.addLast(desc_CodeGen);



        workers.descCreation.checkFor_Schema_FieldNamesDescriptor(descTag.getDescTagName(), buildingMatrixOrSchemaElem, generateDesc_Attribs);

        if (node.getDescriptorFieldAndBodyOptions() != null) {
            node.getDescriptorFieldAndBodyOptions().apply(this);
        }
        workers.descCreation.clear_Schema_FieldNamesDescriptor_Settings(descTag.getDescTagName(), buildingMatrixOrSchemaElem, generateDesc_Attribs);


        if (node.getSemi() != null) {
            node.getSemi().apply(this);
        }

        //  Pop the descCodeGen off the stack
        descCodeGen_Stack.removeLast();

    }

    //  FieldSet and Child Body actions ______________________________________________________________
    @Override
    public void outAMpEmptyDescriptorFieldAndBodyOptions(AMpEmptyDescriptorFieldAndBodyOptions node) {
        MethodAttributeSet generateDesc_Attribs = node.getMethodAttributes();

        workers.descCreation.create_Descriptor(node, FieldSetCreationType.None);

        // even though no child desc.s created, must still call descFinalProcessing_postChildDescCreation to finish processing current descriptor
        workers.descCreation.descFinalProcessing_postChildDescCreation(generateDesc_Attribs);
    }

    @Override
    public void outAMpOnlyFieldsetDescriptorFieldAndBodyOptions(AMpOnlyFieldsetDescriptorFieldAndBodyOptions node) {
        MethodAttributeSet generateDesc_Attribs = node.getMethodAttributes();
        FieldSetCreationType fieldSetCreationType =
                (FieldSetCreationType) generateDesc_Attribs.vars.get(HierarchyMethodConstants.var_FieldSetCreationType);

        workers.descCreation.create_Descriptor(node, fieldSetCreationType);

        // even though no child desc.s created, must still call descFinalProcessing_postChildDescCreation to finish processing current descriptor
        workers.descCreation.descFinalProcessing_postChildDescCreation(generateDesc_Attribs);
    }

    @Override
    public void caseAMpFieldsetAndBodyDescriptorFieldAndBodyOptions(AMpFieldsetAndBodyDescriptorFieldAndBodyOptions node) {
        inAMpFieldsetAndBodyDescriptorFieldAndBodyOptions(node);
        if (node.getFieldsetOptionsWColon() != null) {
            node.getFieldsetOptionsWColon().apply(this);
        }

        MethodAttributeSet generateDesc_Attribs = node.getMethodAttributes();
        FieldSetCreationType fieldSetCreationType =
                (FieldSetCreationType) generateDesc_Attribs.vars.get(HierarchyMethodConstants.var_FieldSetCreationType);

        workers.descCreation.create_Descriptor(node, fieldSetCreationType);


        workers.descCreation.setup_ChildDescCreation(generateDesc_Attribs, false);

        if (node.getDescriptorBody() != null) {
            node.getDescriptorBody().apply(this);
        }
        workers.descCreation.descFinalProcessing_postChildDescCreation(generateDesc_Attribs);



        outAMpFieldsetAndBodyDescriptorFieldAndBodyOptions(node);
    }

    //  Descriptor Head actions _____________________________________________________________________
    //  TODO - hierarchyActions - Descriptor Head set - create the code for this.
    //  NOTE: no modifications have been made yet to this method!!!
    @Override
    public void caseAMpDescriptorHeadSet(AMpDescriptorHeadSet node) {
        inAMpDescriptorHeadSet(node);
        if (node.getMpSetCreationOperator() != null) {
            node.getMpSetCreationOperator().apply(this);
        }
        if (node.getDescriptorHeadSetItem() != null) {
            node.getDescriptorHeadSetItem().apply(this);
        }
        {
            List<PDescriptorHeadChildren> copy = new ArrayList<PDescriptorHeadChildren>(node.getDescriptorHeadChildren());
            for (PDescriptorHeadChildren e : copy) {
                e.apply(this);
            }
        }
        if (node.getRBrc() != null) {
            node.getRBrc().apply(this);
        }
        outAMpDescriptorHeadSet(node);
    }

    @Override
    public void caseAMpStdDescriptorHeadStd(AMpStdDescriptorHeadStd node) {
        inAMpStdDescriptorHeadStd(node);

        MethodAttributeSet generateDesc_Attribs = node.getMethodAttributes();
        DescriptorTag descTag = null;
        Label label = null;

        if (node.getMatrixElementName() != null) {
            //  The DescriptorTag will match on the matrix_element_name production (and the
            //  generate_MatrixElementName() method. Pass it the matrixElementType for DescriptorTag
            generateDesc_Attribs.methodCall_AddValue(HierarchyMethodConstants.method_Generate_MatrixElementName,
                    HierarchyMethodConstants.param_MatrixElementName_Type, MatrixElementName_Type.DescriptorTag);

            node.getMatrixElementName().apply(this);

            descTag = (hierarchyControl.returnValues_getMap_for(HierarchyMethodConstants.method_Generate_MatrixElementName) != null)
                    ? (DescriptorTag) hierarchyControl.returnValues_getMap_for(
                    HierarchyMethodConstants.method_Generate_MatrixElementName).get(HierarchyMethodConstants.retVal_Symbol_Actual)
                    : null;


            // don't forget to clear the method call values passed _to_ the method and the returnvalues passed _from_ the method
            generateDesc_Attribs.methodCall_ClearAllValues();
            hierarchyControl.returnValues_clearMap_for(HierarchyMethodConstants.method_Generate_MatrixElementName);
        }

        if (node.getDescriptorLabel() != null) {
            node.getDescriptorLabel().apply(this);

            label = (hierarchyControl.returnValues_getMap_for(HierarchyMethodConstants.method_Generate_Label) != null)
                    ? (Label) hierarchyControl.returnValues_getMap_for(
                    HierarchyMethodConstants.method_Generate_Label).get(HierarchyMethodConstants.retVal_Label)
                    : null;

            // don't forget to clear the method call values passed _to_ the method and the returnvalues passed _from_ the method
            hierarchyControl.returnValues_clearMap_for(HierarchyMethodConstants.method_Generate_Label);
        }

        generateDesc_Attribs.vars.put(HierarchyMethodConstants.var_DescTag, descTag);
        generateDesc_Attribs.vars.put(HierarchyMethodConstants.var_Label, label);


        outAMpStdDescriptorHeadStd(node);
    }

    @Override
    public void caseAMpHiddenDescriptorHeadHiddenTagname(AMpHiddenDescriptorHeadHiddenTagname node) {
        inAMpHiddenDescriptorHeadHiddenTagname(node);

        MethodAttributeSet generateDesc_Attribs = node.getMethodAttributes();
        DescriptorTag descTag = MPSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM;
        Label label = null;


        if (node.getLabelname() != null) {

            generateDesc_Attribs.methodCall_AddValue(HierarchyMethodConstants.method_Generate_Label,
                    HierarchyMethodConstants.param_Creation_StartLevel, new Integer_Mutable(-1)); // can always create new items

            node.getLabelname().apply(this);

            label = (Label) hierarchyControl.returnValues_getMap_for(
                    HierarchyMethodConstants.method_Generate_Label).get(HierarchyMethodConstants.retVal_Label);

            // don't forget to clear the method call values passed _to_ the method and the returnvalues passed _from_ the method
            generateDesc_Attribs.methodCall_ClearAllValues();
            hierarchyControl.returnValues_clearMap_for(HierarchyMethodConstants.method_Generate_Label);
        }

        generateDesc_Attribs.vars.put(HierarchyMethodConstants.var_DescTag, descTag);
        generateDesc_Attribs.vars.put(HierarchyMethodConstants.var_Label, label);



        outAMpHiddenDescriptorHeadHiddenTagname(node);
    }





    //  ________________________________________________________________________________________________________________
    //
    //    Uses Schema
    //    NOTE: this are not their own methods. They are apart of Descriptor Creation
    //  ________________________________________________________________________________________________________________
    /**
     * vars created:
     *    List<MatrixName> usesSchema_Set;
     *    MatrixSet<SchemaInfo_Schema> usesSchema_Set;
     */

    @Override
    public void caseAMpSchemaNameList(AMpSchemaNameList node) {
        inAMpSchemaNameList(node);

        MethodAttributeSet generateDesc_Attribs = node.getMethodAttributes();

        List<MatrixName> usesSchema_List = (List<MatrixName>) HashTools.put(generateDesc_Attribs.vars, HierarchyMethodConstants.var_UsesSchema_List,
                new ArrayList<MatrixName>());


        //  NOTE: the MatrixElementName_Type param will be used for ALL the calls the generate_MatrixElementName() method (not just the first)
        generateDesc_Attribs.methodCall_AddValue(HierarchyMethodConstants.method_Generate_MatrixElementName,
                HierarchyMethodConstants.param_MatrixElementName_Type, MatrixElementName_Type.SchemaName);

        if (node.getSchemaName() != null) {
            node.getSchemaName().apply(this);
        }
        {
            List<PSchemaNameListChildren> copy = new ArrayList<PSchemaNameListChildren>(node.getSchemaNameListChildren());
            for (PSchemaNameListChildren e : copy) {
                e.apply(this);
            }
        }
        // don't forget to clear the method call values passed _to_ the method and the returnvalues passed _from_ the method
        generateDesc_Attribs.methodCall_ClearAllValues();



        //  Create uses schema. ____________________________________
        //  do NOT add to Scope Stack until a search for the new descriptor has been done! Why? because the useSchema_Set is for the
        //  _child_ descriptors, not the current one.
        MatrixSet<SchemaInfo_Schema> usesSchema_Set = null;
        try {
            usesSchema_Set = SchemaSet_ScopeStack.create_SchemaSet(usesSchema_List, this);
        } catch (Exception e)  {
            hierarchySettings.logger.reportError_And_Exit("Tried to create a uses schemaset, but had an error. The list of schemas was: " +
                    (usesSchema_List != null ? ListUtilities.print(usesSchema_List) : "<null>") + ".", e);
        }

        generateDesc_Attribs.vars.put(HierarchyMethodConstants.var_UsesSchema_Set, usesSchema_Set);


        outAMpSchemaNameList(node);
    }




    @Override
    public void outAMpSchemaName(AMpSchemaName node) {
        defaultOut(node);

        MethodAttributeSet generateDesc_Attribs = node.getMethodAttributes();

        List<MatrixName> usesSchema_List = (List<MatrixName>) generateDesc_Attribs.vars.get(HierarchyMethodConstants.var_UsesSchema_List);

        MatrixName schemaName = (hierarchyControl.returnValues_getMap_for(HierarchyMethodConstants.method_Generate_MatrixElementName) != null)
                ? (MatrixName) hierarchyControl.returnValues_getMap_for(
                HierarchyMethodConstants.method_Generate_MatrixElementName).get(HierarchyMethodConstants.retVal_Symbol_Actual)
                : null;

        usesSchema_List.add(schemaName);

        // don't forget to clear the method call values passed _to_ the method and the returnvalues passed _from_ the method
        hierarchyControl.returnValues_clearMap_for(HierarchyMethodConstants.method_Generate_MatrixElementName);
    }

    //  ________________________________________________________________________________________________________________
    //
    //    FieldSet Tuple and Parameter Map Creation
    //    NOTE: this are not their own methods. They are apart of Descriptor Creation
    //  ________________________________________________________________________________________________________________
    /**
     * additonal vars to the DescriptorCreation() method:
     * vars:
     *    FieldValueInfo currFieldValueInfo;
     */
    @Override
    public void caseAMpFieldsetTuple(AMpFieldsetTuple node) {
        inAMpFieldsetTuple(node);
        MethodAttributeSet generateDesc_Attribs = node.getMethodAttributes();

        List<String> fieldValueExpr_List = (List<String>) HashTools.put(generateDesc_Attribs.vars, HierarchyMethodConstants.var_FieldValueExpr_List,
                new ArrayList<String>());
        List<FieldValueInfo> fieldValueInfo_List = (List<FieldValueInfo>) HashTools.put(generateDesc_Attribs.vars,
                HierarchyMethodConstants.var_FieldValueInfo_List, new ArrayList<FieldValueInfo>());

        generateDesc_Attribs.vars.put(HierarchyMethodConstants.var_FieldSetCreationType, FieldSetCreationType.FieldSet_Tuple);



        if (node.getMatrixFieldExpression() != null) {
            node.getMatrixFieldExpression().apply(this);
        }
        {
            List<PFieldsetParameter> copy = new ArrayList<PFieldsetParameter>(node.getFieldsetParameter());
            for (PFieldsetParameter e : copy) {
                e.apply(this);
            }
        }
        outAMpFieldsetTuple(node);
    }

    /**
     * additonal vars to the DescriptorCreation() method:
     * vars:
     *    FieldValueInfo currFieldValueInfo;
     *    DescriptorTag currParamMap_FieldName;
     */
    @Override
    public void caseAMpFieldsetParametermap(AMpFieldsetParametermap node) {
        inAMpFieldsetParametermap(node);
        MethodAttributeSet generateDesc_Attribs = node.getMethodAttributes();


        List<Pair<DescriptorTagName, String>> paramMap_fieldToValue_List = (List<Pair<DescriptorTagName, String>>) HashTools.put(
                generateDesc_Attribs.vars, HierarchyMethodConstants.var_ParamMap_fieldToValue_List, new ArrayList<Pair<DescriptorTagName, String>>());
        List<FieldValueInfo> fieldValueInfo_List = (List<FieldValueInfo>) HashTools.put(generateDesc_Attribs.vars,
                HierarchyMethodConstants.var_FieldValueInfo_List, new ArrayList<FieldValueInfo>());

        generateDesc_Attribs.vars.put(HierarchyMethodConstants.var_FieldSetCreationType, FieldSetCreationType.FieldSet_ParamMap);


        if (node.getFieldname() != null) {
            node.getFieldname().apply(this);
        }
        if (node.getParameterMappingToValue() != null) {
            node.getParameterMappingToValue().apply(this);
        }
        {
            List<PFieldsetParameterChildren> copy = new ArrayList<PFieldsetParameterChildren>(node.getFieldsetParameterChildren());
            for (PFieldsetParameterChildren e : copy) {
                e.apply(this);
            }
        }
        outAMpFieldsetParametermap(node);
    }

    //  ________________________________________________________________________________________________________________
    //
    //  Field Value Productions
    //  NOTE: this is not a method, only called by FieldSets, so they're an extension of the FieldSet Productions
    //  These methods do two things:
    //  1. set the _node's_ codebuilder to the correct output expression for the field value
    //  2. create a FieldValueInfo object add set any fieldValue properties found for the value.
    //
    //  to get the output expression, simply use the matrixExpression node's toString() method.
    //  to get the FieldValueInfo object, look in the method's matrixElemName_Attribs.
    //
    //  vars:
    //     FieldValueInfo currFieldValueInfo; // local scope!
    //  ________________________________________________________________________________________________________________
    @Override
    public void inAMpMatrixFieldExpression(AMpMatrixFieldExpression node) {
        defaultIn(node);

        MethodAttributeSet generateDesc_Attribs = node.getMethodAttributes();

        generateDesc_Attribs.vars.put(HierarchyMethodConstants.var_CurrFieldValueInfo, new FieldValueInfo());
    }

    @Override
    public void outAMpMatrixFieldExpression(AMpMatrixFieldExpression node) {
        defaultOut(node);

        MethodAttributeSet generateDesc_Attribs = node.getMethodAttributes();

        //  Put the values in either the tuple's fieldValueExpr_List, or the param map's paramMap_fieldToValue_List
        FieldValueInfo fieldValueInfo = (FieldValueInfo) generateDesc_Attribs.vars.get(HierarchyMethodConstants.var_CurrFieldValueInfo);


        List<String> fieldValueExpr_List = (List<String>) generateDesc_Attribs.vars.get(HierarchyMethodConstants.var_FieldValueExpr_List);
        List<Pair<DescriptorTagName, String>> paramMap_fieldToValue_List = (List<Pair<DescriptorTagName, String>>) generateDesc_Attribs.vars.get(
                HierarchyMethodConstants.var_ParamMap_fieldToValue_List);
        List<FieldValueInfo> fieldValueInfo_List = (List<FieldValueInfo>) generateDesc_Attribs.vars.get(HierarchyMethodConstants.var_FieldValueInfo_List);



        if (fieldValueExpr_List != null) {
            fieldValueExpr_List.add(node.toString());
        }
        if (paramMap_fieldToValue_List != null) {
            DescriptorTagName currParamMap_FieldName = (DescriptorTagName) generateDesc_Attribs.vars.get(
                    HierarchyMethodConstants.var_CurrParamMap_FieldName);
            paramMap_fieldToValue_List.add(new Pair<DescriptorTagName, String>(currParamMap_FieldName, node.toString()));
        }

        fieldValueInfo_List.add(fieldValueInfo);
    }

    @Override
    public void outAMpDefaultFieldValueOperatorOptions(AMpDefaultFieldValueOperatorOptions node) {
        defaultOut(node);
        set_FieldValueInfo(node, FieldValueInfo.Type.Default, FieldConstants.DEFAULT.toString());
    }

    @Override
    public void outAMpUnusedFieldValueOperatorOptions(AMpUnusedFieldValueOperatorOptions node) {
        defaultOut(node);
        set_FieldValueInfo(node, FieldValueInfo.Type.Unused, FieldConstants.UNUSED.toString());
    }

    @Override
    public void outAMpDittoPrevFieldValueOperatorOptions(AMpDittoPrevFieldValueOperatorOptions node) {
        defaultOut(node);
        set_FieldValueInfo(node, FieldValueInfo.Type.Ditto, null);
    }

    @Override
    public void outAMpDittoPrevLevelFieldValueOperatorOptions(AMpDittoPrevLevelFieldValueOperatorOptions node) {
        defaultOut(node);
        set_FieldValueInfo(node, FieldValueInfo.Type.Ditto_PrevLevel, null);
    }

    private void set_FieldValueInfo(Node node, FieldValueInfo.Type fieldValueType, String specialValue_OutputCode) {
        MethodAttributeSet generateDesc_Attribs = node.getMethodAttributes();

        FieldValueInfo fieldValueInfo = (FieldValueInfo) generateDesc_Attribs.vars.get(HierarchyMethodConstants.var_CurrFieldValueInfo);
        fieldValueInfo.type = fieldValueType;

        //  set the output code for the field value
        if (specialValue_OutputCode != null) {
            node.code(FieldConstants.class.getSimpleName() + "." + specialValue_OutputCode);
        } else {
            node.code("");
        }
    }

    /**
     * vars set:
     *    DescriptorTag currParamMap_FieldName
     */
    @Override
    public void inAMpFieldname(AMpFieldname node) {
        defaultIn(node);
        MethodAttributeSet generateDesc_Attribs = node.getMethodAttributes();

        //  Call matrixElementName_Creation()
        //  The DescriptorTag will match on the matrix_element_name production (and the
        //  generate_MatrixElementName() method. Pass it the matrixElementType for DescriptorTag
        generateDesc_Attribs.methodCall_AddValue(HierarchyMethodConstants.method_Generate_MatrixElementName,
                HierarchyMethodConstants.param_MatrixElementName_Type, MatrixElementName_Type.DescriptorTagName);

    }

    @Override
    public void outAMpFieldname(AMpFieldname node) {
        defaultOut(node);
        MethodAttributeSet generateDesc_Attribs = node.getMethodAttributes();

        DescriptorTagName currParamMap_FieldName = (hierarchyControl.returnValues_getMap_for(HierarchyMethodConstants.method_Generate_MatrixElementName) != null)
                ? (DescriptorTagName) hierarchyControl.returnValues_getMap_for(
                HierarchyMethodConstants.method_Generate_MatrixElementName).get(HierarchyMethodConstants.retVal_Symbol_Actual)
                : null;

        //  set the currParamMap_FieldName var
        generateDesc_Attribs.vars.put(HierarchyMethodConstants.var_CurrParamMap_FieldName, currParamMap_FieldName);

        // don't forget to clear the method call values passed _to_ the method and the returnvalues passed _from_ the method
        generateDesc_Attribs.methodCall_ClearAllValues();
        hierarchyControl.returnValues_clearMap_for(HierarchyMethodConstants.method_Generate_MatrixElementName);


    }



    //  ________________________________________________________________________________________________________________
    //
    //    Matrix Element Name - Descriptor TagNames and FieldNames
    //  ________________________________________________________________________________________________________________
    /**
     *
     * symbol matrixElementName_Creation(MatrixElementName_Type matrixElementName_Type) -
     *      used to create descriptor tagNames and fieldNames, and used by schemas to create descriptor tags.
     *
     * Method Parameters:
     *    MatrixElementName_Type matrixElementName_Type;
     *    Boolean is_MatrixOrSchemaAccess;  // if false, it's Matrix/Schema creation. Default value is 'false'.  This one is used by the IdentifierMatrixElementName action.
     *
     * Local Vars:
     *    Boolean_Mutable       is_LabelAccessOrCreation;
     *    LinkedList<String>    identifier_PartsList;
     *    Integer_Mutable       partCount;
     *    Integer_Mutable       creation_StartLevel;
     *
     *    DescriptorTag matrixElem_PackageName;
     *
     * Returns:
     *    Symbol symbol_Actual;  // which could be schema/MatrixName, DescriptorTag; DescriptorTagName. It depends on the context the method/prod used in
     *    //  BUT!! matrix access, the first expression does NOT return a symbol_Actual. it returns a firstAccessInfo object!!
     *    MatrixAccess_FirstAccessInfo  firstAccessInfo;
     *    LinkedList<String>            identifier_PartsList;
     *    MatrixElementName_MatchedProductionType         matrixElementName_MatchedProductionType;  // this is an enum describing the type of production that matched for the
     *                                                                                              // element name: ITEM, identifier, FIELD.*
     *
     * codeBuilder:
     *    symbolAccess Code - ex. "AppSymbols.MySymbol"
     *
     */
    @Override
    public void caseAMpItemMatrixElementName(AMpItemMatrixElementName node) {
        inAMpItemMatrixElementName(node);


        MethodAttributeSet generate_MatrixElemName_AttribSet = node.createMethodAttributes(HierarchyMethodConstants.method_Generate_MatrixElementName,
                node, hierarchyControl);

        if (node.getMpItemKeyword() != null) {
            node.getMpItemKeyword().apply(this);
        }

        LinkedList<String> child_Symbols = new LinkedList<String>();
        child_Symbols.add(node.getMpItemKeyword().getText());
        workers.matrixElementName.generate_Symbol_ForMatrixElement(node, generate_MatrixElemName_AttribSet, child_Symbols,
                MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD, null);

        generate_MatrixElemName_AttribSet.returnValues.put(HierarchyMethodConstants.retVal_IdentifierPartsList, child_Symbols);
        generate_MatrixElemName_AttribSet.returnValues.put(HierarchyMethodConstants.retVal_MatrixElementName_MatchedProductionType,
                MatrixElementName_MatchedProductionType.ITEM);

        outAMpItemMatrixElementName(node);

    }

    @Override
    public void caseAMpDescriptorMatrixElementName(AMpDescriptorMatrixElementName node) {
        inAMpDescriptorMatrixElementName(node);

        MethodAttributeSet generate_MatrixElemName_AttribSet = node.createMethodAttributes(HierarchyMethodConstants.method_Generate_MatrixElementName,
                node, hierarchyControl);


        if (node.getMpDescriptorKeyword() != null) {
            node.getMpDescriptorKeyword().apply(this);
        }

        LinkedList<String> child_Symbols = new LinkedList<String>();
        child_Symbols.add(node.getMpDescriptorKeyword().getText());
        workers.matrixElementName.generate_Symbol_ForMatrixElement(node, generate_MatrixElemName_AttribSet, child_Symbols,
                MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, null);


        generate_MatrixElemName_AttribSet.returnValues.put(HierarchyMethodConstants.retVal_IdentifierPartsList, child_Symbols);
        generate_MatrixElemName_AttribSet.returnValues.put(HierarchyMethodConstants.retVal_MatrixElementName_MatchedProductionType,
                MatrixElementName_MatchedProductionType.DESCRIPTOR);

        outAMpDescriptorMatrixElementName(node);
    }

    @Override
    public void caseAMpFieldWChildrenMatrixElementName(AMpFieldWChildrenMatrixElementName node) {
        inAMpFieldWChildrenMatrixElementName(node);

        MethodAttributeSet generate_MatrixElemName_AttribSet = node.createMethodAttributes(HierarchyMethodConstants.method_Generate_MatrixElementName,
                node, hierarchyControl);


        List<String> identifier_PartsList = (List<String>) HashTools.put(generate_MatrixElemName_AttribSet.vars,
                HierarchyMethodConstants.var_Identifier_PartsList,
                new ArrayList<String>());

        if (node.getMpFieldKeyword() != null) {
            node.getMpFieldKeyword().apply(this);
        }
        List<PAdditionalIdentifier> copy = new ArrayList<PAdditionalIdentifier>(node.getAdditionalIdentifier());
        for (PAdditionalIdentifier e : copy) {
            e.apply(this);
        }


        LinkedList<String> child_Symbols = new LinkedList<String>();
        child_Symbols.add(node.getMpFieldKeyword().getText());


        for (String identifier_Part : identifier_PartsList) {
            child_Symbols.add(identifier_Part);
        }


        workers.matrixElementName.generate_Symbol_ForMatrixElement(node, generate_MatrixElemName_AttribSet, child_Symbols,
                MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, null);


        generate_MatrixElemName_AttribSet.returnValues.put(HierarchyMethodConstants.retVal_IdentifierPartsList, child_Symbols);
        generate_MatrixElemName_AttribSet.returnValues.put(HierarchyMethodConstants.retVal_MatrixElementName_MatchedProductionType,
                MatrixElementName_MatchedProductionType.FIELD_w_Children);

        outAMpFieldWChildrenMatrixElementName(node);
    }





    @Override
    public void caseAMpIdentifierMatrixElementName(AMpIdentifierMatrixElementName node) {
        inAMpIdentifierMatrixElementName(node);

        MethodAttributeSet generate_MatrixElemName_AttribSet = node.createMethodAttributes(HierarchyMethodConstants.method_Generate_MatrixElementName,
                node, hierarchyControl);
        MatrixElementName_Type matrixElementName_Type = (MatrixElementName_Type)generate_MatrixElemName_AttribSet.params.get(
                HierarchyMethodConstants.param_MatrixElementName_Type);
        Boolean is_MatrixOrSchemaAccess_Raw = (Boolean)generate_MatrixElemName_AttribSet.params.get(HierarchyMethodConstants.param_Is_MatrixOrSchemaAccess);
        boolean is_MatrixOrSchemaCreation = !(is_MatrixOrSchemaAccess_Raw != null && is_MatrixOrSchemaAccess_Raw.booleanValue() == true);


        List<DescriptorTagName> nameScope_Parts_DescTagNames = new ArrayList<DescriptorTagName>();
        {
            List<PNameScope> copy = new ArrayList<PNameScope>(node.getNameScope());
            for (PNameScope e : copy) {
                //  There can be multiple parts to a name scope. get each part

                e.apply(this);
                nameScope_Parts_DescTagNames.add((DescriptorTagName)generate_MatrixElemName_AttribSet.vars.get(HierarchyMethodConstants.var_NameScope_DescTagName));
            }
        }


        //  Put the the identifier_PartsList List in the attrib set, so the TIdentifier action can put the identifier parts in it.
        LinkedList<String> identifier_PartsList = (LinkedList<String>)HashTools.put(generate_MatrixElemName_AttribSet.vars,
                HierarchyMethodConstants.var_Identifier_PartsList, new LinkedList<String>());
        CodeBuilder identifier_Full_Codebuilder = (CodeBuilder)HashTools.put(generate_MatrixElemName_AttribSet.vars,
                HierarchyMethodConstants.var_Identifier_Full, new CodeBuilder());
        Expression identifier_Expression = (Expression)HashTools.put(generate_MatrixElemName_AttribSet.vars,
                HierarchyMethodConstants.var_Identifier_Expression, new Expression());

        if (node.getIdentifier() != null) {
            node.getIdentifier().apply(this);
        }
        {
            List<PAdditionalIdentifier> copy = new ArrayList<PAdditionalIdentifier>(node.getAdditionalIdentifier());
            for (PAdditionalIdentifier e : copy) {
                e.apply(this);
            }
        }





        //  ** Matrix Creation always returns a descriptor tag!!
        //  ** Matrix Access returns a desciptor tag when it can. If it can't returns a descriptor tag name


        DescriptorTagName matrixElem_PackageName = null;
        DescriptorTagName matrixElem_SchemaName = null;
        MatrixName matrixElem_SchemaName_Full = null;


        if (matrixElementName_Type == MatrixElementName_Type.Imported_Matrix ||
            matrixElementName_Type == MatrixElementName_Type.Imported_Schema ) {

            //  The main phase you need to collect imports for his tthe Collecting Language Symbol phase.
            //  But, also doing this in the Matrix and Schema metacompilation phases (do they need to have a pre, collect symbols phase too?)
            if (metaCompilation_Phase == MetaCompilation_Phase.Collecting_LangSymbols ||
                metaCompilation_Phase == MetaCompilation_Phase.MetaCompiling_Matrices ||
                metaCompilation_Phase == MetaCompilation_Phase.MetaCompiling_Schemas) {
                boolean is_SchemaName = matrixElementName_Type == MatrixElementName_Type.Imported_Schema;

                workers.matrixElementName.add_SchemaOrMatrix_Import(generate_MatrixElemName_AttribSet, is_SchemaName,
                        identifier_Full_Codebuilder.toString(), identifier_PartsList, nameScope_Parts_DescTagNames,
                        identifier_Expression);
            }


        } else if (matrixElementName_Type == MatrixElementName_Type.SchemaNameOrMatrixNameOrIdentifier) {
            //  This is matrix/schema access of the first element (which is either going to be a matrix, a schema, or an identifier)
            //  Figure out which it is. Return the matrix name symbol if it's a schema or matrix, or if it's an identifier, just set the
            //  identifier code string to the code for this node. Also, return the type of element created.


            MatrixAccess_FirstAccessInfo firstAccessInfo = null;
            try {
                firstAccessInfo = workers.matrixElementName.determine_Is_SchemaName_MatrixName_Identifier_Or_DescVarRef(
                    generate_MatrixElemName_AttribSet, identifier_Full_Codebuilder.toString(), identifier_PartsList, nameScope_Parts_DescTagNames,
                    identifier_Expression);
            } catch (Exception e) {
                hierarchySettings.logger.reportError_And_Exit(e);
            }

            node.code(firstAccessInfo.accessExpr).append(' ');
            generate_MatrixElemName_AttribSet.returnValues.put(HierarchyMethodConstants.retVal_FirstAccessInfo, firstAccessInfo);



        } else if (matrixElementName_Type == MatrixElementName_Type.SchemaName ||  // this is a schema name for the Uses SchemaSet
            matrixElementName_Type == MatrixElementName_Type.SchemaName_Label ||  // this is a new schema name that must be created for a schema
            matrixElementName_Type == MatrixElementName_Type.MatrixName_Label     // this is a new matrix name that must be created for a matrix
                ) {

            CodeBuilder codeBuilder_SchemaDescTagName_Access = new CodeBuilder();
            matrixElem_SchemaName = workers.matrixElementName.create_DescTagName_ForMatrixElement(identifier_PartsList,
                    codeBuilder_SchemaDescTagName_Access);

            if (nameScope_Parts_DescTagNames.isEmpty()) {
                
                if (matrixElementName_Type == MatrixElementName_Type.SchemaName ) { //  Schema name in USES Schema List: 
                    //  search through the schema import list for the simple schema name. If not found, try the current package.
                    try {
                        MatrixName found_SchemaName = workers.matrixElementName.find_SchemaName_forCurrFileScope(
                                matrixElem_SchemaName.get_Name_no_backtiks().toString(), packageName_DescTagName, classPath_List);
                        if (found_SchemaName != null)
                            matrixElem_PackageName = found_SchemaName.getPackageName();
                        else
                            throw new Exception_MetaCompilerError("Could not find schema with simple name: " +
                                    (matrixElem_SchemaName != null ? matrixElem_SchemaName.get_Name_no_backtiks() : "<null>"));
                    } catch (Exception e) {
                        String errorMessage = "Tried to create the USES schema set for a descriptor, but had an error. "
                                + "Could not find the schema with the name, '" + matrixElem_SchemaName.get_Name_no_backtiks().toString()
                                + ",' in the import list or the current package.";
                        hierarchySettings.logger.reportError_And_Exit(errorMessage, e);
                    }

                } else { // A Schema or Matrix Name label
                    matrixElem_PackageName = packageName_DescTagName;  //  use current class package
                }
                
            } else if (nameScope_Parts_DescTagNames.size() == 1) {
                matrixElem_PackageName = nameScope_Parts_DescTagNames.get(0);

            } else { // no name scope, do nothing

            }

            workers.matrixElementName.generate_SchemaName_ForMatrixElement(node, generate_MatrixElemName_AttribSet, matrixElem_SchemaName,
                    matrixElem_PackageName);



        } else { // descriptor tags typically
                workers.matrixElementName.process_DescTag(identifier_PartsList, nameScope_Parts_DescTagNames, is_MatrixOrSchemaCreation, node);
        }



        generate_MatrixElemName_AttribSet.returnValues.put(HierarchyMethodConstants.retVal_IdentifierPartsList, identifier_PartsList);
        generate_MatrixElemName_AttribSet.returnValues.put(HierarchyMethodConstants.retVal_MatrixElementName_MatchedProductionType,
                MatrixElementName_MatchedProductionType.Identifier);

        outAMpIdentifierMatrixElementName(node);

    }


    @Override
    public void caseAMpMatrixElementNameIdentifierWOneOrMoreNamescopes(AMpMatrixElementNameIdentifierWOneOrMoreNamescopes node)
    {
        inAMpMatrixElementNameIdentifierWOneOrMoreNamescopes(node);

        MethodAttributeSet generate_MatrixElemName_AttribSet = node.createMethodAttributes(HierarchyMethodConstants.method_Generate_MatrixElementName,
                node, hierarchyControl);


        List<DescriptorTagName> nameScope_Parts_DescTagNames = new ArrayList<DescriptorTagName>();
        {
            List<PNameScope> copy = new ArrayList<PNameScope>(node.getNameScope());
            for(PNameScope e : copy)
            {
                e.apply(this);

                nameScope_Parts_DescTagNames.add((DescriptorTagName)generate_MatrixElemName_AttribSet.vars.get(HierarchyMethodConstants.var_NameScope_DescTagName));
            }
        }


        //  Put the the identifier_PartsList List in the attrib set, so the TIdentifier action can put the identifier parts in it.
        LinkedList<String> identifier_PartsList = (LinkedList<String>)HashTools.put(generate_MatrixElemName_AttribSet.vars,
                HierarchyMethodConstants.var_Identifier_PartsList, new LinkedList<String>());
        {
            node.getIdentifier().apply(this);
        }
        {
            List<PAdditionalIdentifier> copy = new ArrayList<PAdditionalIdentifier>(node.getAdditionalIdentifier());
            for(PAdditionalIdentifier e : copy)
            {
                e.apply(this);
            }
        }




        workers.matrixElementName.process_DescTag(identifier_PartsList, nameScope_Parts_DescTagNames, false, node);

        generate_MatrixElemName_AttribSet.returnValues.put(HierarchyMethodConstants.retVal_IdentifierPartsList, identifier_PartsList);
        generate_MatrixElemName_AttribSet.returnValues.put(HierarchyMethodConstants.retVal_MatrixElementName_MatchedProductionType,
                MatrixElementName_MatchedProductionType.Identifier_w_OneOrMoreNameScopes);

        outAMpMatrixElementNameIdentifierWOneOrMoreNamescopes(node);
    }






    //  Name-Scope (package name) production actions
    //  __________________________________________________________

    @Override
    public void inAMpNameScopeName(AMpNameScopeName node) {
        defaultIn(node);

        MethodAttributeSet matrixElemName_Attribs = node.getMethodAttributes();

        //  Used by the Identifier Action
        List<String> identifier_PartsList = (List<String>) HashTools.put(matrixElemName_Attribs.vars, HierarchyMethodConstants.var_Identifier_PartsList,
                new LinkedList<String>());

    }

    @Override
    public void outAMpNameScopeName(AMpNameScopeName node) {
        defaultOut(node);

        MethodAttributeSet matrixElemName_Attribs = node.getMethodAttributes();
        List<String> identifier_PartsList = (List<String>) matrixElemName_Attribs.vars.get(HierarchyMethodConstants.var_Identifier_PartsList);

        CodeBuilder codeBuilder_NameScopeDescTagName_AccessCode = new CodeBuilder();


        DescriptorTagName nameScope_DescTagName = workers.matrixElementName.create_DescTagName_ForMatrixElement((LinkedList)identifier_PartsList,
                codeBuilder_NameScopeDescTagName_AccessCode);

        matrixElemName_Attribs.vars.put(HierarchyMethodConstants.var_NameScope_DescTagName, nameScope_DescTagName);

    }








    //  ________________________________________________________________________________________________________________
    //
    //    Annotations Useage
    //  ________________________________________________________________________________________________________________
    //  Annotations Reference-Name Options
    //  ________________________________________________________________________________________________________________

    /*
     * Annotation reference names are not their own method!!
     *
     * var params - vars created BEFORE using these actions:
     *
     *   //  When doing annotation useage (like during a matrix access), you are always creating new symbols (creation level at 1!!).
     *   //  When doing annotation definition, the creation level is 2!!! This means in an Annotation, you can not create a new
     *   //  annotation-reference BASE-name (like *1). You can only create the second part of reference names (like *1.1, *1.2...)
     *   Boolean creating_AnnotationDefinition;
     *
     * local vars:
     *   Integer_Mutable annoteRef__Creation_StartLevel;
     *   CodeBuilder codeBuilder_AnnoteRef_AccessCode;
     *
     * var retValues - vars created DURING these actions:
     *   Symbol retVal_AnnoteRef_Actual;
     */
    //  Annotation Name Options - Production Alternatives______________________
    /**
     * star Identifier
     */
    @Override
    public void outAMpIdAnnotationNameOptions(AMpIdAnnotationNameOptions node) {
        defaultOut(node);

        LinkedList<String> symbol_Parts = new LinkedList<String>();
        symbol_Parts.add(node.getStar().getText() + node.getIdentifier().getText());

        create_AnnotationReference(symbol_Parts, node);

    }

    /**
     * star integer-Literal
     */
    @Override
    public void outAMpIntAnnotationNameOptions(AMpIntAnnotationNameOptions node) {
        defaultOut(node);

        LinkedList<String> symbol_Parts = new LinkedList<String>();
        symbol_Parts.add(node.getStar().getText() + node.getIntegerLiteral().getText());

        create_AnnotationReference(symbol_Parts, node);
    }

    /**
     * star floating-point-Literal
     */
    @Override
    public void outAMpFloatAnnotationNameOptions(AMpFloatAnnotationNameOptions node) {
        defaultOut(node);

        LinkedList<String> symbol_Parts = new LinkedList<String>();
        String[] floatingPoint_Parts = node.getFloatingPointLiteral().getText().split("\\.");
        if (floatingPoint_Parts == null || floatingPoint_Parts.length != 2) {
            Exception_MetaCompilerError e = new Exception_MetaCompilerError("Had an annotation reference name that was supposed to have two parts (like *1.1), but it didn't");
            hierarchySettings.logger.reportError_And_Exit(e);
        }


        symbol_Parts.add(node.getStar().getText() + floatingPoint_Parts[0]);
        symbol_Parts.add(floatingPoint_Parts[1]);


        create_AnnotationReference(symbol_Parts, node);
    }

    /**
     * DEFAULT
     * @param node
     */
    @Override
    public void outAMpDefaultAnnotationHandlerNameOptions(AMpDefaultAnnotationHandlerNameOptions node)
    {
        MethodAttributeSet attribSet = node.getMethodAttributes();
        attribSet.vars.put(HierarchyMethodConstants.var_RetVal_AnnoteRef_Actual, MPSymbols.DEFAULT);
    }


    private void create_AnnotationReference(LinkedList<String> symbol_Parts, AttributeNode node) {

        MethodAttributeSet attribSet = node.getMethodAttributes();

        //  Variable Parameters
        Boolean creating_AnnotationDefinition = (Boolean) attribSet.vars.get(HierarchyMethodConstants.var_Creating_AnnotationDefinition);

        //  Local Vars
        Integer_Mutable annoteRef__Creation_StartLevel = (Integer_Mutable) HashTools.put(attribSet.vars,
                HierarchyMethodConstants.var_AnnoteRef__Creation_StartLevel, new Integer_Mutable(-1));
        CodeBuilder codeBuilder_AnnoteRef_AccessCode = new CodeBuilder();
        Integer_Mutable symbolCount = new Integer_Mutable(symbol_Parts.size());

        //  When doing annotation useage (like during a matrix access), you are always creating new symbols (creation level at 1!!).
        //  When doing annotation definition, the creation level is 2!!! This means in an Annotation, you can not create a new
        //  annotation-reference BASE-name (like *1). You can only create the second part of reference names (like *1.1, *1.2...)
        if (creating_AnnotationDefinition != null && creating_AnnotationDefinition == true) {
            annoteRef__Creation_StartLevel.value = 2;
        } else {
            annoteRef__Creation_StartLevel.value = 1;
        }



        Symbol symbol_Actual = workers.symbols.generate_CreateOrAccessSymbols(codeBuilder_AnnoteRef_AccessCode, SymbolType.Symbol, symbol_Parts,
                symbolCount, annoteRef__Creation_StartLevel);

        attribSet.vars.put(HierarchyMethodConstants.var_RetVal_AnnoteRef_Actual, symbol_Actual);
    }




    //  ________________________________________________________________________________________________________________
    //
    //    Annotations Handler Definition
    //  ________________________________________________________________________________________________________________

    /*
     * Annotation reference names are not their own method!!
     *
     * var params - vars created BEFORE using these actions:
     *
     * local vars:
     *   Boolean is_MatrixAccess_In_StaticMethod;  // this value is grabbed from the scope stack, and is not passed in!
     *
     * var retValues
     *   Boolean annotationCreated    //  A Boolean object with a true value is returned if annotation generated (which should
     *                                //  always happen if you hit this action). This value is used by default annotation handler generator.
     *                                //  Specifically, if the def annote handler gen doesn't see this value, then it generates the default handler.
     *   List<Object> child_AnnoteBlockStmt_List;
     *   List<Object> child_FilterAnnoteBlockStmt_List;
     */
    @Override
    public void caseAMpMpAnnotationsDeclaration(AMpMpAnnotationsDeclaration node) {
        inAMpMpAnnotationsDeclaration(node);

        super.addLangSymbol_AnnotationsHandler();

        MethodAttributeSet generate_Annotations_Attribs = node.createMethodAttributes(HierarchyMethodConstants.method_Generate_Annotations,
                node, hierarchyControl);

        //  Vars
        //  this value is grabbed from the scope stack, and is not passed in!
        Boolean is_MatrixAccess_In_StaticMethod = (Boolean)HashTools.put(generate_Annotations_Attribs.vars,
                HierarchyMethodConstants.var_Is_MatrixAccess_In_StaticMethod, 
                is_CurrentMatrixAccess_InStaticMethod());

        List<Object> child_AnnoteBlockStmt_List = (List<Object>)HashTools.put(generate_Annotations_Attribs.vars,
                HierarchyMethodConstants.vars_Child_AnnoteBlockStmt_List, new ArrayList<Object>());
        List<Object> child_FilterAnnoteBlockStmt_List = (List<Object>)HashTools.put(generate_Annotations_Attribs.vars,
                HierarchyMethodConstants.vars_Child_FiltersAnnoteBlockStmt_List, new ArrayList<Object>());

        if (node.getMpAnnotationsKeyword() != null) {
            node.getMpAnnotationsKeyword().apply(this);
        }
        if (node.getLBrc() != null) {
            node.getLBrc().apply(this);
        }
        {
            List<PMpAnnotationsBodyOptions> copy = new ArrayList<PMpAnnotationsBodyOptions>(node.getMpAnnotationsBodyOptions());
            for (PMpAnnotationsBodyOptions e : copy) {
                e.apply(this);

                get_Child_AnnoteBlockStmt_CodeGen__IfExists(child_AnnoteBlockStmt_List, child_FilterAnnoteBlockStmt_List);
            }
        }
        if (node.getRBrc() != null) {
            node.getRBrc().apply(this);
        }


        //  Generate the annotations stmts _____________________________________________________________________________________________


        CodeBuilder codeBuilder_AnnoteBody = get_AnnotationBlockStmts(child_AnnoteBlockStmt_List);

        CodeBuilder codeBuilder_FiltersAnnoteBody = get_AnnotationBlockStmts(child_FilterAnnoteBlockStmt_List);




        codeGenerators_MatrixAccess.annotationHandlers_CodeGen.add_CodeForAnnotationHandler(
            codeGenerators_MatrixAccess.annotationsCodeGenerator_Control.get_MethodIndex(), codeBuilder_AnnoteBody,
            is_MatrixAccess_In_StaticMethod);

        if (codeBuilder_FiltersAnnoteBody.toString().trim().length() > 0) {
            // add a default return value
            codeBuilder_FiltersAnnoteBody
                .append("\t\t else {\n")
                .append("\t\t\treturn null;\n")
                .append("\t\t}\n\n");
            codeGenerators_MatrixAccess.annotationHandlers_CodeGen_Filters.add_CodeForAnnotationHandler(
                codeGenerators_MatrixAccess.annotationsCodeGenerator_Control.get_MethodIndex(), codeBuilder_FiltersAnnoteBody,
                is_MatrixAccess_In_StaticMethod);
        }


        //  ** MatrixSet the CodeBuilder for this node to an empty string, so that toString() of the root node doesn't cause the raw annotation code to
        //  print out
        node.code("");

        outAMpMpAnnotationsDeclaration(node);
    }


    private CodeBuilder get_AnnotationBlockStmts(List<Object> child_AnnoteBlockStmt_List) {

        //  first: set the next sibling info
        AnnotationHandler_CodeGenerator_AnnotationBlockStmt.setupChildren_Helper(child_AnnoteBlockStmt_List);

        CodeBuilder codeBuilder_AnnoteBody = new CodeBuilder();
        try {
            for (Object child_BlockStmt : child_AnnoteBlockStmt_List) {
                AnnotationHandler_CodeGenerator_AnnotationBlockStmt child_AnnoteBlockStmt_CodeGen =
                        (AnnotationHandler_CodeGenerator_AnnotationBlockStmt) child_BlockStmt;

                    codeBuilder_AnnoteBody.append(child_AnnoteBlockStmt_CodeGen.generate_AnnoteBlockStmt());
            }

        } catch (Exception_MetaCompilerError e) {
            hierarchySettings.logger.reportError_And_Exit("Tried to create the Annotation definition for a method, but had a error.", e);
        }

        return codeBuilder_AnnoteBody;
    }


    private void get_Child_AnnoteBlockStmt_CodeGen__IfExists(List<Object> child_AnnoteBlockStmt_List, List<Object> child_FilterAnnoteBlockStmt_List) {

        AnnotationHandler_CodeGenerator_AnnotationBlockStmt child_AnnoteBlockStmt_CodeGen = (AnnotationHandler_CodeGenerator_AnnotationBlockStmt)
            ( hierarchyControl.returnValues_getMap_for(HierarchyMethodConstants.method_Generate_AnnoteBlockStmt) != null ?
                hierarchyControl.returnValues_getMap_for(
                    HierarchyMethodConstants.method_Generate_AnnoteBlockStmt).get(HierarchyMethodConstants.retVal_AnnoteBlockStmt_CodeGen) :
                null
            );

        //  first, check for child annotation block stmt_____
        if (child_AnnoteBlockStmt_CodeGen != null) {
            if (child_AnnoteBlockStmt_CodeGen instanceof AnnotationHandler_CodeGenerator_AnnotationBlockStmt__Filters)
                child_FilterAnnoteBlockStmt_List.add(child_AnnoteBlockStmt_CodeGen);
            else
                child_AnnoteBlockStmt_List.add(child_AnnoteBlockStmt_CodeGen);

            //  clear the child generateAnnoteBlockStmt's retValues
            hierarchyControl.returnValues_clearMap_for(HierarchyMethodConstants.method_Generate_AnnoteBlockStmt);

        }

    }






    @Override
    public void caseAMpCatchBlockDeclaration(AMpCatchBlockDeclaration node)
    {
        inAMpCatchBlockDeclaration(node);
        MethodAttributeSet generate_Annotations_Attribs = node.getMethodAttributes();

        List<Object> child_AnnoteBlockStmt_List = (List<Object>)generate_Annotations_Attribs.vars.get(
                HierarchyMethodConstants.vars_Child_AnnoteBlockStmt_List);
        List<Object> child_FiltersAnnoteBlockStmt_List = (List<Object>)generate_Annotations_Attribs.vars.get(
                HierarchyMethodConstants.vars_Child_FiltersAnnoteBlockStmt_List);

        //  ** annotation type get's set here **

        if(node.getCatchTypeList() != null) {
            node.getCatchTypeList().apply(this);
        }

        AnnotationType annotationType = (AnnotationType)generate_Annotations_Attribs.vars.get(HierarchyMethodConstants.param_AnnotationType);



        //  ** pass the annotation type to the child method, generate_AnnoteBlockStmt()
        generate_Annotations_Attribs.methodCall_AddValue(HierarchyMethodConstants.method_Generate_AnnoteBlockStmt,
                HierarchyMethodConstants.param_AnnotationType, annotationType);


        if(node.getLBrc() != null) {
            node.getLBrc().apply(this);
        }
        {
            List<PCatchBlockStatement> copy = new ArrayList<PCatchBlockStatement>(node.getCatchBlockStatement());
            for(PCatchBlockStatement e : copy) {
                e.apply(this);
                get_Child_AnnoteBlockStmt_CodeGen__IfExists(child_AnnoteBlockStmt_List, child_FiltersAnnoteBlockStmt_List);

            }
        }
        if(node.getRBrc() != null) {
            node.getRBrc().apply(this);
        }


        //  ** clear the annotation type here
        generate_Annotations_Attribs.vars.put(HierarchyMethodConstants.param_AnnotationType, null);

        outAMpCatchBlockDeclaration(node);
    }

    @Override
    public void outAMpFiltersCatchType(AMpFiltersCatchType node)
    {
        MethodAttributeSet generate_Annotations_Attribs = node.getMethodAttributes();

        generate_Annotations_Attribs.vars.put(HierarchyMethodConstants.param_AnnotationType, AnnotationType.FILTERS);

        defaultOut(node);
    }


    /**
     *
     * AnnotationHandler_CodeGenerator_AnnotationBlockStmt generate_AnnoteBlockStmt() // recursive method
     *
     * Method Parameters:
     *    // can be null if it's just a regular annotation. Another one of the most common values is FILTERS, for filter annotations
     *    AnnotationType annotationType;
     *
     * Local Vars:
     *    Boolean is_MatrixAccess_In_StaticMethod;  // this value is grabbed from the scope stack, and is not passed in!
     *    AnnotationHandler_CodeGenerator_AnnotationBlockStmtTest annoteBlockStmt_CodeGen;
     *
     * Returns:
     *    AnnotationHandler_CodeGenerator_AnnotationBlockStmtTest annoteBlockStmt_CodeGen;
     *
     */
    @Override
    public void caseAMpAnnotationHandlerDeclaration(AMpAnnotationHandlerDeclaration node) {
        inAMpAnnotationHandlerDeclaration(node);


        MethodAttributeSet generate_AnnoteBlockStmt_Attribs = node.createMethodAttributes(HierarchyMethodConstants.method_Generate_AnnoteBlockStmt,
                node, hierarchyControl, true);  // NOTE: setting getExistingOrCreateNew_ReturnValuesMap = true for recursive calls!!

        AnnotationType annotationType = (AnnotationType)generate_AnnoteBlockStmt_Attribs.params.get(HierarchyMethodConstants.param_AnnotationType);
        Boolean is_MatrixAccess_In_StaticMethod = (Boolean)HashTools.put(generate_AnnoteBlockStmt_Attribs.vars,
                HierarchyMethodConstants.var_Is_MatrixAccess_In_StaticMethod, 
                is_CurrentMatrixAccess_InStaticMethod());

        List<AnnotationHandler_CodeGenerator_AnnotationBlockStmt> child_AnnoteBlockStmt_CodeGen__List =
                new ArrayList<AnnotationHandler_CodeGenerator_AnnotationBlockStmt>();


        AnnotationHandler_CodeGenerator_AnnotationBlockStmt annoteBlockStmt_CodeGen = null;
        //  Determine which type of annotation codegen to create
        if (annotationType == AnnotationType.FILTERS)
            annoteBlockStmt_CodeGen = (AnnotationHandler_CodeGenerator_AnnotationBlockStmt) HashTools.put(generate_AnnoteBlockStmt_Attribs.vars, HierarchyMethodConstants.var_AnnoteBlockStmt_CodeGen,
                new AnnotationHandler_CodeGenerator_AnnotationBlockStmt__Filters(symbolControl, schemaControl, matrixControl,
                                                                                    hierarchySettings, baseIndentLevel));
        else  // standard
            annoteBlockStmt_CodeGen = (AnnotationHandler_CodeGenerator_AnnotationBlockStmt) HashTools.put(generate_AnnoteBlockStmt_Attribs.vars,
                    HierarchyMethodConstants.var_AnnoteBlockStmt_CodeGen,
                new AnnotationHandler_CodeGenerator_AnnotationBlockStmt(symbolControl, schemaControl, matrixControl, hierarchySettings, baseIndentLevel));


        if (node.getAnnotationHandlerNameOptions() != null) {
            node.getAnnotationHandlerNameOptions().apply(this);


            try {
                Symbol annoteReference = (Symbol)generate_AnnoteBlockStmt_Attribs.vars.get(HierarchyMethodConstants.var_RetVal_AnnoteRef_Actual);
                annoteBlockStmt_CodeGen.set_AnnotateHandlerReference(annoteReference);

            } catch (Exception_MetaCompilerError e) {
                hierarchySettings.logger.reportError_And_Exit(e);
            }
        }


        if (node.getAnnotationParameters() != null) {
            node.getAnnotationParameters().apply(this);
        }
        if (node.getLBrc() != null) {
            node.getLBrc().apply(this);
        }
        {
            List<PAnnotationBlockStatement> copy = new ArrayList<PAnnotationBlockStatement>(node.getAnnotationBlockStatement());
            for (PAnnotationBlockStatement e : copy) {
                e.apply(this);

                //  *****************************************************************************
                //  All the child annoteBlockStmt and child matrix stmts (and all the other types of stmt's) are added to the
                //  annotationCodeGen in the "Annotation Block Statement Production-Alternatives"
                //  *****************************************************************************
            }
        }

        if (node.getRBrc() != null) {
            node.getRBrc().apply(this);
        }


        generate_AnnoteBlockStmt_Attribs.returnValues.put(HierarchyMethodConstants.retVal_AnnoteBlockStmt_CodeGen, annoteBlockStmt_CodeGen);


        outAMpAnnotationHandlerDeclaration(node);
    }




    //  Annotation Block Statement Production-Alternatives
    //  ________________________________________________________________________________________________________________
    @Override
    public void outAMpAccessorReturnAnnotationBlockStatement(AMpAccessorReturnAnnotationBlockStatement node) {
        defaultOut(node);
        MethodAttributeSet generate_AnnoteBlockStmt_Attribs = node.getMethodAttributes();

        AnnotationHandler_CodeGenerator_AnnotationBlockStmt curr_AnnoteBlockStmt_CodeGen = (AnnotationHandler_CodeGenerator_AnnotationBlockStmt) generate_AnnoteBlockStmt_Attribs.vars.get(HierarchyMethodConstants.var_AnnoteBlockStmt_CodeGen);

        curr_AnnoteBlockStmt_CodeGen.add_Child_AnnotationBlockStmt(node.getAccessorReturnStatement().toString_ProcessCurrent());
    }

    @Override
    public void outAMpAccessorReturnStatement(AMpAccessorReturnStatement node) {
        defaultOut(node);

        CodeBuilder codeBuilder_AccessorReturnType = new CodeBuilder();
        codeBuilder_AccessorReturnType.append("accessReturnType_OutParam.returnType = AnnotationParameters.AccessReturnType.accessorValue;  ").append("return " + node.getMatrixExpression().toString() + ";");

        node.code(codeBuilder_AccessorReturnType);

    }

    @Override
    public void outAMpMatrixStmtAnnotationBlockStatement(AMpMatrixStmtAnnotationBlockStatement node) {
        defaultOut(node);
        MethodAttributeSet generate_AnnoteBlockStmt_Attribs = node.getMethodAttributes();

        AnnotationHandler_CodeGenerator_AnnotationBlockStmt curr_AnnoteBlockStmt_CodeGen = (AnnotationHandler_CodeGenerator_AnnotationBlockStmt) generate_AnnoteBlockStmt_Attribs.vars.get(HierarchyMethodConstants.var_AnnoteBlockStmt_CodeGen);

        //  add the child annotation block stmt to the current one
        curr_AnnoteBlockStmt_CodeGen.add_Child_AnnotationBlockStmt(node.getMatrixStatement().toString());

    }

    @Override
    public void outAMpFilterAnnotationBlockStatement(AMpFilterAnnotationBlockStatement node) {
        defaultOut(node);
    }


    @Override
    public void inAMpAnnotationHandlerAnnotationBlockStatement(AMpAnnotationHandlerAnnotationBlockStatement node) {
        defaultIn(node);
        MethodAttributeSet generate_AnnoteBlockStmt_Attribs = node.getMethodAttributes();

    }
    @Override
    public void outAMpAnnotationHandlerAnnotationBlockStatement(AMpAnnotationHandlerAnnotationBlockStatement node) {
        defaultOut(node);
        MethodAttributeSet generate_AnnoteBlockStmt_Attribs = node.getMethodAttributes();

        AnnotationHandler_CodeGenerator_AnnotationBlockStmt curr_AnnoteBlockStmt_CodeGen = (AnnotationHandler_CodeGenerator_AnnotationBlockStmt)
                generate_AnnoteBlockStmt_Attribs.vars.get(HierarchyMethodConstants.var_AnnoteBlockStmt_CodeGen);



        AnnotationHandler_CodeGenerator_AnnotationBlockStmt child_AnnoteBlockStmt_CodeGen =
                (AnnotationHandler_CodeGenerator_AnnotationBlockStmt) hierarchyControl.returnValues_getMap_for(
                HierarchyMethodConstants.method_Generate_AnnoteBlockStmt).get(HierarchyMethodConstants.retVal_AnnoteBlockStmt_CodeGen);

        //  if there is a curr_AnnoteBlockStmt_CodeGen, add the child annotation block stmt to the current one, and clear the annotation call

        if (curr_AnnoteBlockStmt_CodeGen != null) {
            curr_AnnoteBlockStmt_CodeGen.add_Child_AnnotationBlockStmt(child_AnnoteBlockStmt_CodeGen);

            //  clear the child generateAnnoteBlockStmt's retValues
            hierarchyControl.returnValues_clearMap_for(HierarchyMethodConstants.method_Generate_AnnoteBlockStmt);
        } else {
            //  there is no curr_AnnoteBlockStmt_CodeGen, this is a filter. let the retVal_AnnoteBlockStmt_CodeGen be passed to the outer
            //  caseAMpCatchBlockDeclaration production
        }
    }

    @Override
    public void outAMpCatchBlockAnnotationBlockStatement(AMpCatchBlockAnnotationBlockStatement node) {
        defaultOut(node);
    }






    //  ________________________________________________________________________________________________________________
    //
    //    Sets
    //  ________________________________________________________________________________________________________________
    @Override
    public void caseAMpSimpleSetCreate(AMpSimpleSetCreate node) {
        MethodAttributeSet generateSet_AttribSet = node.createMethodAttributes(HierarchyMethodConstants.method_Generate_Set, node, hierarchyControl);

        List<String> item_Expressions = new ArrayList<String>();
        generateSet_AttribSet.vars.put("item_Expressions", item_Expressions);


        if (node.getSetCreateSimple() != null) {
            node.getSetCreateSimple().apply(this);
        }

        generateSet_AttribSet.codeBuilder = Set_CodeGenerator.generate_SetCode(null, outputResults, false, null, item_Expressions);
        node.code(generateSet_AttribSet.codeBuilder);
    }

    @Override
    public void caseAMpSetItems(AMpSetItems node) {
        inAMpSetItems(node); // sets this node's getMethodAttributes to its parent's
        MethodAttributeSet generateSet_Attribs = node.getMethodAttributes();

        List<String> item_Expressions = (List<String>) generateSet_Attribs.vars.get("item_Expressions");


        if (node.getMatrixExpression() != null) {
            node.getMatrixExpression().apply(this);
            String matrixExpression = node.getMatrixExpression().toString();

            if (matrixExpression != null && matrixExpression.trim().length() > 0) {
                item_Expressions.add(matrixExpression);
            }

        }
        {
            List<PSetItemsChildren> copy = new ArrayList<PSetItemsChildren>(node.getSetItemsChildren());
            for (PSetItemsChildren e : copy) {
                e.apply(this);
            }
        }
    }

    @Override
    public void caseAMpSetItemsChildren(AMpSetItemsChildren node) {
        inAMpSetItemsChildren(node);
        MethodAttributeSet generateSet_Attribs = node.getMethodAttributes();

        List<String> item_Expressions = (List<String>) generateSet_Attribs.vars.get("item_Expressions");


        if (node.getComma() != null) {
            node.getComma().apply(this);
        }
        if (node.getMatrixExpression() != null) {
            node.getMatrixExpression().apply(this);
            String matrixExpression = node.getMatrixExpression().toString();

            if (matrixExpression != null && matrixExpression.trim().length() > 0) {
                item_Expressions.add(matrixExpression);
            }
        }
    }




    //  ________________________________________________________________________________________________________________
    //
    //     Descriptor Labels
    //  ________________________________________________________________________________________________________________
    /**
     * Label generateLabel_Simple()
     *   * NOTE: SINCE SYM METHOD SETTINGS IS AN OBJECT, IT'S IMPORTANT TO KEEP THIS LIST OF LOCAL VARS UP TO DATE!!!!
     *
     * Params:
     *    Integer_Mutable creation_StartLevel; // can pass in the creation_StartLevel. Used for ITEM'S. they don't need a "+" to create a new schemaName.
     *
     * Local Vars:
     *    Integer_Mutable symbolCount;
     *    LinkedList<String> child_Symbols;
     *    Integer_Mutable creation_StartLevel; // if passed in as a param, set to this var so it acts like the rest of the sym creation productions
     *
     *    Boolean_Mutable haveSeen_Plus;
     * 
     * Returns:
     *    Label label;
     * codeBuilder:
     *    symbolAccess Code - ex. "AppSymbols.MySymbol"
     *
     */
    @Override
    public void caseAMpLabelnameBacktikSimple(AMpLabelnameBacktikSimple node) {
        MethodAttributeSet generateLabel_Attribs = node.createMethodAttributes(HierarchyMethodConstants.method_Generate_Label, node, hierarchyControl);

        HierarchyActionsWorker_SymbolMethodSettings symbolMethodSettings = new HierarchyActionsWorker_SymbolMethodSettings();
        boolean is_NewSymbolCreation = false;
        boolean checkParamsFor_CreationStartlevel = true;
        symbolMethodSettings.initialize(is_NewSymbolCreation, checkParamsFor_CreationStartlevel, generateLabel_Attribs);

        if (node.getPlus() != null) {
            node.getPlus().apply(this);

            symbolMethodSettings.creation_StartLevel.value = 1;
            symbolMethodSettings.haveSeen_Plus.value = true;
        }
        if (node.getMpSymbolLiteralBacktiks() != null) {
            node.getMpSymbolLiteralBacktiks().apply(this);

            String childLabel_Raw = node.getMpSymbolLiteralBacktiks().getText();
            addChildLabel(node, childLabel_Raw, false);
        }
        {
            List<PLabelnameBacktiksChildren> copy = new ArrayList<PLabelnameBacktiksChildren>(node.getLabelnameBacktiksChildren());
            for (PLabelnameBacktiksChildren e : copy) {
                e.apply(this);
            }
        }

        Label label = (Label) workers.symbols.generate_CreateOrAccessSymbols(generateLabel_Attribs.codeBuilder, SymbolType.Label, 
                symbolMethodSettings.child_Symbols, symbolMethodSettings.symbolCount, symbolMethodSettings.creation_StartLevel);
        node.code(generateLabel_Attribs.codeBuilder);
        generateLabel_Attribs.returnValues.put(HierarchyMethodConstants.retVal_Label, label);
    }

    @Override
    public void outAMpLabelnameBacktiksChildren(AMpLabelnameBacktiksChildren node) {
        defaultOut(node);

        String childLabel_Raw = node.getMpSymbolLiteralBacktiks().getText();
        addChildLabel(node, childLabel_Raw, false);
    }


    /**
     * Label generateLabel_TwoPart()
     *   * NOTE: SINCE SYM METHOD SETTINGS IS AN OBJECT, IT'S IMPORTANT TO KEEP THIS LIST OF LOCAL VARS UP TO DATE!!!!
     *
     * Params:
     *    Integer_Mutable creation_StartLevel; // can pass in the creation_StartLevel. Used for ITEM'S. they don't need a "+" to create a new schemaName.
     *
     * Local Vars:
     *    Integer_Mutable creation_StartLevel; // if passed in as a param, set to this var so it acts like the rest of the sym creation productions
     *    Integer_Mutable symbolCount;
     *    LinkedList<String> child_Symbols;
     *    Boolean_Mutable haveSeen_Plus;
     *
     * Returns:
     *    Label label;
     * codeBuilder:
     *    symbolAccess Code - ex. "AppSymbols.MySymbol"
     *
     */
    @Override
    public void caseAMpLabelnameBacktikTwopart(AMpLabelnameBacktikTwopart node) {
        MethodAttributeSet generateLabel_Attribs = node.createMethodAttributes(HierarchyMethodConstants.method_Generate_Label, node, hierarchyControl);

        HierarchyActionsWorker_SymbolMethodSettings symbolMethodSettings = new HierarchyActionsWorker_SymbolMethodSettings();
        boolean is_NewSymbolCreation = false;
        boolean checkParamsFor_CreationStartlevel = true;
        symbolMethodSettings.initialize(is_NewSymbolCreation, checkParamsFor_CreationStartlevel, generateLabel_Attribs);

        if (node.getPlus() != null) {
            node.getPlus().apply(this);

            symbolMethodSettings.creation_StartLevel.value = 1;
            symbolMethodSettings.haveSeen_Plus.value = true;
        }
        if (node.getMpSymbolLiteralBacktiks() != null) {
            node.getMpSymbolLiteralBacktiks().apply(this);

            String childLabel_Raw = node.getMpSymbolLiteralBacktiks().getText();
            addChildLabel(node, childLabel_Raw, false);
        }
        if (node.getInNamePackage() != null) {
            node.getInNamePackage().apply(this);
        }


        Label label = (Label) workers.symbols.generate_CreateOrAccessSymbols(generateLabel_Attribs.codeBuilder, SymbolType.Label, 
                                 symbolMethodSettings.child_Symbols, symbolMethodSettings.symbolCount, symbolMethodSettings.creation_StartLevel);
        node.code(generateLabel_Attribs.codeBuilder);
        generateLabel_Attribs.returnValues.put(HierarchyMethodConstants.retVal_Label, label);


        outAMpLabelnameBacktikTwopart(node);
    }

    @Override
    public void outAMpNamePackageName(AMpNamePackageName node) {
        defaultOut(node);

        String childLabel_Raw = node.getIdentifier().getText();
        addChildLabel(node, childLabel_Raw, true);
    }

    @Override
    public void outAMpNamePackageNameChildren(AMpNamePackageNameChildren node) {
        defaultOut(node);

        String childLabel_Raw = node.getIdentifier().getText();
        addChildLabel(node, childLabel_Raw, true);
    }

    private void addChildLabel(AttributeNode node, String childLabel_Raw, boolean is_PackageName) {

        MethodAttributeSet generateLabel_Attribs = node.getMethodAttributes();
        LinkedList<String> child_Symbols = (LinkedList<String>) generateLabel_Attribs.vars.get(HierarchyMethodConstants.var_Child_Symbols);
        Integer_Mutable symbolCount = (Integer_Mutable) generateLabel_Attribs.vars.get(HierarchyMethodConstants.var_SymbolCount);

        if (childLabel_Raw != null) {
            if (!is_PackageName && childLabel_Raw.length() >= 2) {
                String childLabel = childLabel_Raw.substring(1, childLabel_Raw.length() - 1);

                child_Symbols.add(childLabel);
                ++symbolCount.value;

            } else if (is_PackageName && childLabel_Raw.length() >= 0) {
                child_Symbols.add(childLabel_Raw);
                ++symbolCount.value;
            }
        }
    }



    //  ________________________________________________________________________________________________________________
    //
    //    DescriptorTagName For Label Productions
    //  ________________________________________________________________________________________________________________
    /**
     * Label generateDescriptorTagnameForlabel()
     *   * NOTE: SINCE SYM METHOD SETTINGS IS AN OBJECT, IT'S IMPORTANT TO KEEP THIS LIST OF LOCAL VARS UP TO DATE!!!!
     *
     * Params:
     *    Integer_Mutable creation_StartLevel; // can pass in the creation_StartLevel. Used for ITEM'S. they don't need a "+" to create a new schemaName.
     *
     * Local Vars:
     *    Integer_Mutable symbolCount;
     *    LinkedList<String> child_Symbols;
     *    Integer_Mutable creation_StartLevel; // if passed in as a param, set to this var so it acts like the rest of the sym creation productions
     *
     *    Boolean_Mutable haveSeen_Plus;
     *
     * Returns:
     *    Label label;
     *    DescriptorTagName descrTagName;
     * codeBuilder:
     *    symbolAccess Code - ex. "AppSymbols.MySymbol"
     *
     */
    @Override
    public void caseAMpDescriptorTagnameForlabel(AMpDescriptorTagnameForlabel node) {
        MethodAttributeSet generateLabel_Attribs = node.createMethodAttributes(HierarchyMethodConstants.method_Generate_Label, node, hierarchyControl);

        HierarchyActionsWorker_SymbolMethodSettings symbolMethodSettings = new HierarchyActionsWorker_SymbolMethodSettings();
        boolean is_NewSymbolCreation = false;
        boolean checkParamsFor_CreationStartlevel = true;
        symbolMethodSettings.initialize(is_NewSymbolCreation, checkParamsFor_CreationStartlevel, generateLabel_Attribs);
        
        if(node.getPlus() != null) {
            node.getPlus().apply(this);

            symbolMethodSettings.creation_StartLevel.value = 1;
            symbolMethodSettings.haveSeen_Plus.value = true;
        }
        if(node.getMpColonPercentOperator() != null) {
            node.getMpColonPercentOperator().apply(this);
        }
        if(node.getIdentifier() != null) {
            node.getIdentifier().apply(this);

            String childDescTagName_Raw = node.getIdentifier().getText();
            addChildDescTagName(node, childDescTagName_Raw);
        }
        {
            List<PDescriptorTagnameForlabelChildren> copy = new ArrayList<PDescriptorTagnameForlabelChildren>(node.getDescriptorTagnameForlabelChildren());
            for(PDescriptorTagnameForlabelChildren e : copy) {
                e.apply(this);
            }
        }


        //  **** Oddly enough, generate the LABEL first, then convert it to a desctTagName (instead of the other way around like you'd think).
        //  Why? because we want the access code that is generated to be for the LABEL, not the descriptorTagName!
        Label label = (Label) workers.symbols.generate_CreateOrAccessSymbols(generateLabel_Attribs.codeBuilder, SymbolType.Label,
                symbolMethodSettings.child_Symbols, symbolMethodSettings.symbolCount, symbolMethodSettings.creation_StartLevel);
        DescriptorTagName descTagName = null;
        try {
            descTagName = SymbolUtilities.convert_Label_to_DescTagName(label, symbolControl);
        } catch (Exception e) {
            hierarchySettings.logger.reportError_And_Exit("While trying to use the descriptor tag name, " +
                    (descTagName != null ? descTagName.getTagName() : "null") + ", in an expression that requires a label, had a problem trying to converting it.", e);
        }


        node.code(generateLabel_Attribs.codeBuilder);
        generateLabel_Attribs.returnValues.put(HierarchyMethodConstants.retVal_Label, label);
        generateLabel_Attribs.returnValues.put(HierarchyMethodConstants.retVal_DescTagName, descTagName);
    }


    @Override
    public void outAMpDescriptorTagnameForlabelChildren(AMpDescriptorTagnameForlabelChildren node) {
        defaultOut(node);

        String childDescTagName_Raw = node.getIdentifier().getText();
        addChildDescTagName(node, childDescTagName_Raw);
    }

    private void addChildDescTagName(AttributeNode node, String childDescTagName_Raw) {

        MethodAttributeSet generateLabel_Attribs = node.getMethodAttributes();
        LinkedList<String> child_Symbols = (LinkedList<String>) generateLabel_Attribs.vars.get(HierarchyMethodConstants.var_Child_Symbols);
        Integer_Mutable symbolCount = (Integer_Mutable) generateLabel_Attribs.vars.get(HierarchyMethodConstants.var_SymbolCount);

        child_Symbols.add(childDescTagName_Raw);
        ++symbolCount.value;
    }
    //  ________________________________________________________________________________________________________________
    //
    //    Symbol Access and Creation
    //  ________________________________________________________________________________________________________________
    /**
     * Symbol symbolAccess()
     *  * NOTE: SINCE SYM METHOD SETTINGS IS AN OBJECT, IT'S IMPORTANT TO KEEP THIS LIST OF LOCAL VARS UP TO DATE!!!!
     *
     * Params
     *    Boolean generateAndReturn_DescTagName;  // used for schemaInfo_FieldSets, FIELD.NAMES - these the field name symbols should be descTagNames
     *
     * Local Vars:
     *    Boolean_Mutable is_LabelAccessOrCreation;
     *    Integer_Mutable labelCount;  // if creating a schemaName, labelCount should equal partCount
     *    Boolean_Mutable is_DescTagNameAccessOrCreation;
     *
     *    Integer_Mutable symbolCount;
     *    LinkedList<String> child_Symbols;
     *
     *    Boolean_Mutable is_LateStartCreation;
     *    Integer_Mutable creation_StartLevel;
     *
     * Returns:
     *    Symbol symbol_Actual - the Symbol Object created (will be a schemaOrMatrixName if 'generateAndReturn_DescTagName' is true)
     * codeBuilder:
     *    symbolAccess Code - ex. "AppSymbols.MySymbol"
     *
     */
    @Override
    public void caseAMpAccessMpSymbolUseage(AMpAccessMpSymbolUseage node) {
        MethodAttributeSet generateSym_Attribs = node.createMethodAttributes(HierarchyMethodConstants.method_Generate_Symbol, node, hierarchyControl);

        HierarchyActionsWorker_SymbolMethodSettings symbolMethodSettings = new HierarchyActionsWorker_SymbolMethodSettings();
        boolean is_NewSymbolCreation = false;
        symbolMethodSettings.initialize(is_NewSymbolCreation, generateSym_Attribs);
        
        if (node.getSymbolAccess() != null) {
            node.getSymbolAccess().apply(this);
        }

        workers.symbols.generateSymbol_Helper(symbolMethodSettings, node, generateSym_Attribs);
    }

    /**
     *
     * Symbol symbolCreation()
     *   * SITUATIONAL METHOD* - meaning it is only a method if it is called directly. But, is not a method if it is called
     *       by the AMPSymbolAccess production!!!
     *   * NOTE: SINCE SYM METHOD SETTINGS IS AN OBJECT, IT'S IMPORTANT TO KEEP THIS LIST OF LOCAL VARS UP TO DATE!!!!
     *
     * Params
     *    Boolean generateAndReturn_DescTagName;  // used for schemaInfo_FieldSets, FIELD.NAMES - these the field name symbols should be descTagNames
     *
     * Local Vars:
     *    Boolean_Mutable is_LabelAccessOrCreation;
     *    Integer_Mutable labelCount;  // if creating a schemaName, labelCount should equal partCount
     *    Boolean_Mutable is_DescTagNameAccessOrCreation;
     *
     *    Integer_Mutable symbolCount;
     *    LinkedList<String> child_Symbols;
     *
     *    Boolean_Mutable is_LateStartCreation;
     *    Integer_Mutable creation_StartLevel;
     *
     * Returns:
     *    Symbol symbol_Actual - the Symbol Object created
     * codeBuilder:
     *    symbolAccess Code - ex. "AppSymbols.MySymbol"
     *
     */
    @Override
    public void caseAMpSymbolCreation(AMpSymbolCreation node) {

        MethodAttributeSet generateSym_Attribs = node.getMethodAttributes();

        HierarchyActionsWorker_SymbolMethodSettings symbolMethodSettings = new HierarchyActionsWorker_SymbolMethodSettings();
        if (generateSym_Attribs == null || !generateSym_Attribs.methodName.equals(HierarchyMethodConstants.method_Generate_Symbol)) {

            // this means this is NOT late start creation, but totally new symbol creation. for example: +:sym1.sym2
            // created a new method attribute set:
            generateSym_Attribs = node.createMethodAttributes(HierarchyMethodConstants.method_Generate_Symbol, node, hierarchyControl);

            boolean is_NewSymbolCreation = true;
            symbolMethodSettings.initialize(is_NewSymbolCreation, generateSym_Attribs);

        } else {

            // this means this is late start creation, because we have a methodAttribSet for the generateSymbolCode method.
            // the symbolAccess nodes are passing us this! An example of late start sym creation is: :sym1.+:sym2
            node.setMethodAttributes(generateSym_Attribs);

            symbolMethodSettings.is_LateStartCreation = (Boolean_Mutable) HashTools.get(generateSym_Attribs.vars, HierarchyMethodConstants.var_Is_LateStartCreation);
            if (!symbolMethodSettings.is_LateStartCreation.value) {// this should be true!
                System.exit(1);  // TODO - HierarchyActions caseAMpSymbolCreation() - handle this error - should say "this was supposed to be last start symbol creation, but the lateStartCreation flag is not true!"
            }
            symbolMethodSettings.generateAndReturn_DescTagName = (Boolean) generateSym_Attribs.params.get(
                                                                            HierarchyMethodConstants.param_GenerateAndReturn_DescTagName);
            symbolMethodSettings.is_LabelAccessOrCreation = (Boolean_Mutable) HashTools.get(generateSym_Attribs.vars,
                                                                            HierarchyMethodConstants.var_Is_LabelAccessOrCreation);
            symbolMethodSettings.labelCount = (Integer_Mutable) HashTools.get(generateSym_Attribs.vars, HierarchyMethodConstants.var_LabelCount);

            symbolMethodSettings.child_Symbols = (LinkedList<String>) HashTools.get(generateSym_Attribs.vars, HierarchyMethodConstants.var_Child_Symbols);
            symbolMethodSettings.symbolCount = (Integer_Mutable) HashTools.get(generateSym_Attribs.vars, HierarchyMethodConstants.var_SymbolCount);

            // ** since it's late start creation, must set the creation level
            symbolMethodSettings.creation_StartLevel = (Integer_Mutable) HashTools.get(generateSym_Attribs.vars, HierarchyMethodConstants.var_Creation_StartLevel);
            symbolMethodSettings.creation_StartLevel.value = symbolMethodSettings.symbolCount.value + 1;
        }


        if (node.getPlus() != null) {
            node.getPlus().apply(this);
        }
        if (node.getSymbolOptions() != null) {
            node.getSymbolOptions().apply(this);
        }
        if (node.getSymbolCreationChildrenOptions() != null) {
            node.getSymbolCreationChildrenOptions().apply(this);
        }

        if (!symbolMethodSettings.is_LateStartCreation.value) {
            workers.symbols.generateSymbol_Helper(symbolMethodSettings, node, generateSym_Attribs);
        }
    }


    @Override
    public void inAMpLatestartSymbolCreation(AMpLatestartSymbolCreation node) {
        defaultIn(node); //  for in-actions, need to always call this to pass attrib set

        MethodAttributeSet generateSym_Attribs = node.getMethodAttributes();

        Boolean_Mutable is_LateStartCreation = (Boolean_Mutable) HashTools.get(generateSym_Attribs.vars, HierarchyMethodConstants.var_Is_LateStartCreation);
        is_LateStartCreation.value = true; // MatrixSet to TRUE!!
    }








    //  SymbolChild_Options
    @Override
    public void outAMpIdSymbolchildOptions(AMpIdSymbolchildOptions node) {
        String symbolName = node.getIdentifier().getText();
        workers.symbols.processSymbolOption(symbolName, node.getMethodAttributes());
    }

    @Override
    public void outAMpBacktiksSymbolchildOptions(AMpBacktiksSymbolchildOptions node) {
        String backtikSymbol = node.getMpSymbolLiteralBacktiks().getText();
        int last_Char_Index = backtikSymbol.length();
        String symbolName = backtikSymbol.substring(1, last_Char_Index - 1);  // removes the '`' and the '`';
        workers.symbols.processSymbolOption(symbolName, node.getMethodAttributes());

        workers.symbols.set_LabelAccessOrCreation(node);
    }

    //  Symbol_Options ________________________________________________________________________________________________
    @Override
    public void outAMpStandardSymbolOptions(AMpStandardSymbolOptions node) {
        String symbolName = node.getIdentifier().getText();
        workers.symbols.processSymbolOption(symbolName, node.getMethodAttributes());
    }

    @Override
    public void outAMpQuotesSymbolOptions(AMpQuotesSymbolOptions node) {
        String quotedSymbol = node.getMpSymbolLiteralQuotes().getText();
        int last_Char_Index = quotedSymbol.length();
        String symbolName = quotedSymbol.substring(2, last_Char_Index - 1);  // removes the '+"' and the '"';
        workers.symbols.processSymbolOption(symbolName, node.getMethodAttributes());
    }

    @Override
    public void outAMpBacktiksSymbolOptions(AMpBacktiksSymbolOptions node) {

        String backtikSymbol = node.getMpSymbolLiteralBacktiks().getText();
        int last_Char_Index = backtikSymbol.length();
        String symbolName = backtikSymbol.substring(1, last_Char_Index - 1);  // removes the '`' and the '`';
        workers.symbols.processSymbolOption(symbolName, node.getMethodAttributes());

        workers.symbols.set_LabelAccessOrCreation(node);
    }


    @Override
    public void outAMpDesctagnameSymbolOptions(AMpDesctagnameSymbolOptions node)
    {
        defaultOut(node);

        String symbolName = node.getIdentifier().getText();
        workers.symbols.processSymbolOption(symbolName, node.getMethodAttributes());

        workers.symbols.set_DescTagNameAccessOrCreation(node);

    }



    //  ________________________________________________________________________________________________________________
    //
    //    Matrix Access Productions
    //  ________________________________________________________________________________________________________________
    /**
     * generate_MatrixAccess() - starts with a Primary Java Expression
     * params:
     *   Boolean collecting_MatrixAccessState;
     *   Boolean is_MatrixFieldAssignment; // if this is a matrix access for a field assignment, then generate a matrix access with a setfield() call.
     *   Boolean is_MatrixAccess_andNotSchema;
     *
     * vars:
     *   Boolean is_MatrixAccess_In_StaticMethod;  // this value is grabbed from the scope stack, and is not passed in!
     *
     *   // has 2 codeBuilders: codeBuilder_AccessMethods, CodeBuilder codeBuilder_EmbeddedCode; and other info.
     *   DescriptorAccess_CodeGenerator descAccess_CodeGen;
     *   List<DescriptorAccess_ChildAccessInfo> childAccessInfo_List;
     *
     *   DescriptorAccess_ChildAccessInfo curr_ChildAccessInfo;
     *
     * return values:
     *   DescriptorAccess_CodeGenerator descAccess_CodeGen;
     */
    @Override
    public void caseAMpStartsWithPrimaryMatrixAccess(AMpStartsWithPrimaryMatrixAccess node) {
        MethodAttributeSet generateAccess_Attribs = node.createMethodAttributes(HierarchyMethodConstants.method_Generate_MatrixAccess, node, hierarchyControl);

        //  Params
        Boolean collecting_MatrixAccessState = (Boolean)generateAccess_Attribs.params.get(HierarchyMethodConstants.param_Collecting_MatrixAccessState);
        Boolean is_MatrixFieldAssignment = (Boolean)generateAccess_Attribs.params.get(HierarchyMethodConstants.param_Is_MatrixFieldAssignment);


        //  Local vars
        //  this value is grabbed from the scope stack, and is not passed in!
        Boolean is_MatrixAccess_In_StaticMethod = (Boolean)HashTools.put(generateAccess_Attribs.vars,
                HierarchyMethodConstants.var_Is_MatrixAccess_In_StaticMethod, 
                is_CurrentMatrixAccess_InStaticMethod());
        DescriptorAccess_CodeGenerator descAccess_CodeGen = (DescriptorAccess_CodeGenerator) HashTools.put(generateAccess_Attribs.vars,
                HierarchyMethodConstants.var_DescAccess_CodeGen, new DescriptorAccess_CodeGenerator(symbolControl, schemaControl, matrixControl, 1,
                                                                                        hierarchySettings, outputResults));
        List<DescriptorAccess_ChildAccessInfo> childAccessInfo_List = (List<DescriptorAccess_ChildAccessInfo>) HashTools.put(generateAccess_Attribs.vars,
                HierarchyMethodConstants.var_ChildAccessInfo_List, new ArrayList<DescriptorAccess_ChildAccessInfo>());

        //  Do not create Matrix Access State if this matrix access is for a desc var (a "matrix access state") and you're in the
        //  Collecting Lang Symbols phase. This info will be collected during the phase mentioned.
        boolean doNotCreateMatrixAccess = (metaCompilation_Phase == metaCompilation_Phase.Collecting_LangSymbols &&
                collecting_MatrixAccessState != null && collecting_MatrixAccessState);

        CodeBuilder codeBuilder_EmbeddedCode = new CodeBuilder();

        descAccess_CodeGen.set_1_CodeBuilders(codeGenerators_MatrixAccess.codeBuildersList__AccessMethods_Static, codeGenerators_MatrixAccess.codeBuildersList__AccessMethods_Dyn,
                codeGenerators_MatrixAccess.codeBuildersList__AccessMethods_All, codeBuilder_EmbeddedCode);

        descAccess_CodeGen.set_1_EmbeddedFile_ClassName(className);
        descAccess_CodeGen.set_1_AccessMethodClass_Name(className + HierarchySettings.embeddedFile_WorkerClassName_Suffix);
        descAccess_CodeGen.set_1_Is_MatrixAccess_In_StaticMethod(is_MatrixAccess_In_StaticMethod);

        descAccess_CodeGen.set_1_AnnotationInfo(codeGenerators_MatrixAccess.annotationCall_CodeGen);
        descAccess_CodeGen.set_AnnotationCall_CodeGen_Filters__OPTIONAL(codeGenerators_MatrixAccess.annotationCall_CodeGen_Filters);


        // Matrix Access Info
        String rootAccessorExpr;
        boolean rootAccessorExpr_Is_Identifier = false;
        boolean is_MatrixAccess_andNotSchema = true; // Unknown actually!!

        String matrixAccess_MetaCode_String = node.toString_ProcessCurrent();

        
        if (node.getPrimary() != null) {
            node.getPrimary().apply(this);
            rootAccessorExpr = node.getPrimary().toString();

            descAccess_CodeGen.set_3_RootAccessorInfo(rootAccessorExpr, rootAccessorExpr_Is_Identifier, is_MatrixAccess_andNotSchema);

        }
        {

            //  Set the is_MatrixAccess parameter for MatrixElement creation method
            generateAccess_Attribs.methodCall_AddValue(HierarchyMethodConstants.method_Generate_MatrixElementName,
                    HierarchyMethodConstants.param_Is_MatrixOrSchemaAccess, true);

            List<PMatrixElemAccess> copy = new ArrayList<PMatrixElemAccess>(node.getMatrixElemAccess());
            for (PMatrixElemAccess e : copy) {
                e.apply(this);
            }

            // don't forget to clear the method call values passed _to_ the method and the returnvalues passed _from_ the method
            generateAccess_Attribs.methodCall_ClearAllValues();
        }


        if (!doNotCreateMatrixAccess) {
            workers.descAccess.generate_MatrixAccess(descAccess_CodeGen, childAccessInfo_List, collecting_MatrixAccessState, is_MatrixFieldAssignment,
                    node);
        }


        generateAccess_Attribs.returnValues.put(HierarchyMethodConstants.retVal_DescAccess_CodeGen, descAccess_CodeGen);
        addMatrixAccessToSymbolTable(matrixAccess_MetaCode_String, descAccess_CodeGen.postGen__getMethodAccessNumber());

        outAMpStartsWithPrimaryMatrixAccess(node);
    }




    /**
     * generate_MatrixAccess() - starts with an Identifier
     * params:
     *   Boolean collecting_MatrixAccessState;
     *   Boolean is_MatrixFieldAssignment; // if this is a matrix access for a field assignment, then generate a matrix access with a setfield() call.
     *   Boolean is_MatrixAccess_andNotSchema;
     *
     * vars:
     *   Boolean is_MatrixAccess_In_StaticMethod;  // this value is grabbed from the scope stack, and is not passed in!
     *
     *   // has 2 codeBuilders: codeBuilder_AccessMethods, CodeBuilder codeBuilder_EmbeddedCode; and other info.
     *   DescriptorAccess_CodeGenerator descAccess_CodeGen;
     *   List<DescriptorAccess_ChildAccessInfo> childAccessInfo_List;
     *
     *   DescriptorAccess_ChildAccessInfo curr_ChildAccessInfo;
     *
     *
     * return values:
     *
     */
    @Override
    public void caseAMpStartsWithMatrixelementMatrixAccess(AMpStartsWithMatrixelementMatrixAccess node)
    {
        inAMpStartsWithMatrixelementMatrixAccess(node);
        MethodAttributeSet generateAccess_Attribs = node.createMethodAttributes(HierarchyMethodConstants.method_Generate_MatrixAccess, node, hierarchyControl);

        //  Params
        Boolean collecting_MatrixAccessState = (Boolean)generateAccess_Attribs.params.get(HierarchyMethodConstants.param_Collecting_MatrixAccessState);
        Boolean is_MatrixFieldAssignment = (Boolean)generateAccess_Attribs.params.get(HierarchyMethodConstants.param_Is_MatrixFieldAssignment);

        //  Local Vars
        //  this value is grabbed from the scope stack, and is not passed in!
        Boolean is_MatrixAccess_In_StaticMethod = (Boolean)HashTools.put(generateAccess_Attribs.vars,
                HierarchyMethodConstants.var_Is_MatrixAccess_In_StaticMethod,
                is_CurrentMatrixAccess_InStaticMethod());
        DescriptorAccess_CodeGenerator descAccess_CodeGen = (DescriptorAccess_CodeGenerator) HashTools.put(generateAccess_Attribs.vars,
                HierarchyMethodConstants.var_DescAccess_CodeGen, new DescriptorAccess_CodeGenerator(symbolControl, schemaControl, matrixControl, 1,
                                                                                                    hierarchySettings, outputResults));
        List<DescriptorAccess_ChildAccessInfo> childAccessInfo_List = (List<DescriptorAccess_ChildAccessInfo>) HashTools.put(generateAccess_Attribs.vars,
                HierarchyMethodConstants.var_ChildAccessInfo_List, new ArrayList<DescriptorAccess_ChildAccessInfo>());

        //  Do not create Matrix Access State if this matrix access is for a desc var (a "matrix access state") and you're NOT in the
        //  Collecting Lang Symbols phase. This info will be collected during the phase mentioned.
        boolean doNotCreateMatrixAccess = (metaCompilation_Phase != metaCompilation_Phase.Collecting_LangSymbols &&
                collecting_MatrixAccessState != null && collecting_MatrixAccessState);


        CodeBuilder codeBuilder_EmbeddedCode = new CodeBuilder();

        descAccess_CodeGen.set_1_CodeBuilders(codeGenerators_MatrixAccess.codeBuildersList__AccessMethods_Static, codeGenerators_MatrixAccess.codeBuildersList__AccessMethods_Dyn,
                codeGenerators_MatrixAccess.codeBuildersList__AccessMethods_All, codeBuilder_EmbeddedCode);

        descAccess_CodeGen.set_1_EmbeddedFile_ClassName(className);
        descAccess_CodeGen.set_1_AccessMethodClass_Name(className + HierarchySettings.embeddedFile_WorkerClassName_Suffix);
        descAccess_CodeGen.set_1_Is_MatrixAccess_In_StaticMethod(is_MatrixAccess_In_StaticMethod);
        descAccess_CodeGen.set_1_AnnotationInfo(codeGenerators_MatrixAccess.annotationCall_CodeGen);
        descAccess_CodeGen.set_AnnotationCall_CodeGen_Filters__OPTIONAL(codeGenerators_MatrixAccess.annotationCall_CodeGen_Filters);




        // Matrix Access Info
        String rootAccessorExpr;
        boolean rootAccessorExpr_Is_Identifier = true;
        boolean is_MatrixAccess_andNotSchema = true;  // initial value is true, but maybe set to false later in code;

        String matrixAccess_MetaCode_String = node.toString_ProcessCurrent();


        //  METHOD CALL TO: matrixElementName() ______________________________

        generateAccess_Attribs.methodCall_AddValue(HierarchyMethodConstants.method_Generate_MatrixElementName,
                HierarchyMethodConstants.param_MatrixElementName_Type, MatrixElementName_Type.SchemaNameOrMatrixNameOrIdentifier);
        //  Set the is_MatrixOrSchemaAccess parameter for MatrixElement creation method
        generateAccess_Attribs.methodCall_AddValue(HierarchyMethodConstants.method_Generate_MatrixElementName,
                HierarchyMethodConstants.param_Is_MatrixOrSchemaAccess, true);

        if(node.getMatrixElementName() != null) {
            node.getMatrixElementName().apply(this);
        }

        Map<String, Object> retValue_Map = hierarchyControl.returnValues_getMap_for(HierarchyMethodConstants.method_Generate_MatrixElementName);
        MatrixAccess_FirstAccessInfo firstAccessInfo = null;
        List<String> identifier_PartsList = null;
        MatrixElementName_MatchedProductionType matrixElementName_MatchedProductionType = null;

        if (retValue_Map != null) {
            firstAccessInfo = (MatrixAccess_FirstAccessInfo)retValue_Map.get(HierarchyMethodConstants.retVal_FirstAccessInfo);
            identifier_PartsList = (List<String>)retValue_Map.get(HierarchyMethodConstants.retVal_IdentifierPartsList);
            matrixElementName_MatchedProductionType = (MatrixElementName_MatchedProductionType)retValue_Map.get(HierarchyMethodConstants.retVal_MatrixElementName_MatchedProductionType);

            //  check for continued access
            if (firstAccessInfo.continuedAccess_IsContinuedAccess)
                descAccess_CodeGen.set_2_ContinuedAccess_MatrixAccessState(true, firstAccessInfo.continuedAccess_MatrixAccessState);

        }

        // don't forget to clear the method call values passed _to_ the method and the returnvalues passed _from_ the method
        generateAccess_Attribs.methodCall_ClearAllValues();
        hierarchyControl.returnValues_clearMap_for(HierarchyMethodConstants.method_Generate_MatrixElementName);

        // END METHOD CALL ___________________________________



        is_MatrixAccess_andNotSchema = (firstAccessInfo.accessExpr_Type == MatrixAccess_FirstAccessInfo.AccessExpressionType.MatrixName ||
                                        firstAccessInfo.accessExpr_Type == MatrixAccess_FirstAccessInfo.AccessExpressionType.Identifier);

        descAccess_CodeGen.set_3_RootAccessorInfo(firstAccessInfo.accessExpr, rootAccessorExpr_Is_Identifier, is_MatrixAccess_andNotSchema);




        //  Set the is_MatrixOrSchemaAccess parameter for MatrixElement creation method
        generateAccess_Attribs.methodCall_AddValue(HierarchyMethodConstants.method_Generate_MatrixElementName,
                HierarchyMethodConstants.param_Is_MatrixOrSchemaAccess, true);
        generateAccess_Attribs.methodCall_AddValue(HierarchyMethodConstants.method_Generate_MatrixElementName,
                HierarchyMethodConstants.param_MatrixElementName_Type, MatrixElementName_Type.DescriptorTag);

        {
            List<PMatrixElemAccess> copy = new ArrayList<PMatrixElemAccess>(node.getMatrixElemAccess());
            for(PMatrixElemAccess e : copy) {
                e.apply(this);
            }
        }
        // don't forget to clear the method call values passed _to_ the method and the returnvalues passed _from_ the method
        generateAccess_Attribs.methodCall_ClearAllValues();
        hierarchyControl.returnValues_clearMap_for(HierarchyMethodConstants.method_Generate_MatrixElementName);


        if (!doNotCreateMatrixAccess)
            workers.descAccess.generate_MatrixAccess(descAccess_CodeGen, childAccessInfo_List, collecting_MatrixAccessState,
                    is_MatrixFieldAssignment, node);

        generateAccess_Attribs.returnValues.put(HierarchyMethodConstants.retVal_DescAccess_CodeGen, descAccess_CodeGen);
        addMatrixAccessToSymbolTable(matrixAccess_MetaCode_String, descAccess_CodeGen.postGen__getMethodAccessNumber());

        outAMpStartsWithMatrixelementMatrixAccess(node);
    }


    private void addMatrixAccessToSymbolTable(String matrixAccessString, int methodAccessNumber) {
        super.symbolTable_File.matrixAccess_SymbolTableFile.addMatrixAccess(matrixAccessString, methodAccessNumber);
    }
    private boolean is_CurrentMatrixAccess_InStaticMethod() {
        //  if the symbolTable_File.scopeStack.getCurrScopeID_for_Method_ScopeBoundary() <= 0, then you are in class scope, are not
        //  even in a method. return false
        return (symbolTable_File.scopeStack.getCurrScopeID_for_Method_ScopeBoundary() > 0 ?
            symbolTable_File.scopeStack.getCurrScopeInfo_for_ClassOrMethod_ScopeBoundary().is_Static : false);
    }


    @Override
    public void caseAMpMatrixElemAccess(AMpMatrixElemAccess node) {
        inAMpMatrixElemAccess(node);
        MethodAttributeSet generateAccess_Attribs = node.getMethodAttributes();

        DescriptorAccess_ChildAccessInfo curr_ChildAccessInfo = (DescriptorAccess_ChildAccessInfo) HashTools.put(generateAccess_Attribs.vars,
                HierarchyMethodConstants.var_Curr_ChildAccessInfo, new DescriptorAccess_ChildAccessInfo());



        if (node.getMatrixElemAccessOperatorOptions() != null) {
            node.getMatrixElemAccessOperatorOptions().apply(this);
        }
        if (node.getElementNameSpecifierOptions() != null) {
            node.getElementNameSpecifierOptions().apply(this);
        }
        if (node.getMatrixElemMultipleAccessOptions() != null) {
            node.getMatrixElemMultipleAccessOptions().apply(this);
        }


        List<DescriptorAccess_ChildAccessInfo> childAccessInfo_List = (List<DescriptorAccess_ChildAccessInfo>) generateAccess_Attribs.vars.get(
                HierarchyMethodConstants.var_ChildAccessInfo_List);
        childAccessInfo_List.add(curr_ChildAccessInfo);

        outAMpMatrixElemAccess(node);
    }



    //  Matrix-Elem Access Operator-Options Production-Alternatives_____________________________________________________
    /**
     *  '->'  - Descriptor Access
     */
    @Override
    public void outAMpStdArrowMatrixElemAccessOperatorOptions(AMpStdArrowMatrixElemAccessOperatorOptions node) {
        defaultOut(node);

        workers.descAccess.initialize_ChildAccessInfo(node, DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.Descriptor, false, null);
    }

    /**
     *  '-<*1>'  - Annotated Descriptor Access
     */
    @Override
    public void outAMpAnnotatedArrowMatrixElemAccessOperatorOptions(AMpAnnotatedArrowMatrixElemAccessOperatorOptions node) {
        defaultOut(node);

        MethodAttributeSet generateAccess_Attribs = node.getMethodAttributes();
        Symbol annoteRef = (Symbol) generateAccess_Attribs.vars.get(HierarchyMethodConstants.var_RetVal_AnnoteRef_Actual);

        workers.descAccess.initialize_ChildAccessInfo(node, DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.Descriptor, true, annoteRef);
    }

    /**
     *  ':>'  - Field Access
     */
    @Override
    public void outAMpStdFieldaccessMatrixElemAccessOperatorOptions(AMpStdFieldaccessMatrixElemAccessOperatorOptions node) {
        defaultOut(node);

        workers.descAccess.initialize_ChildAccessInfo(node, DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.Field, false, null);
    }

    /**
     *  ':<*1>'  - Annotated Field-Access
     */
    @Override
    public void outAMpAnnotatedFieldaccessMatrixElemAccessOperatorOptions(AMpAnnotatedFieldaccessMatrixElemAccessOperatorOptions node) {
        defaultOut(node);

        MethodAttributeSet generateAccess_Attribs = node.getMethodAttributes();
        Symbol annoteRef = (Symbol) generateAccess_Attribs.vars.get(HierarchyMethodConstants.var_RetVal_AnnoteRef_Actual);

        workers.descAccess.initialize_ChildAccessInfo(node, DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.Field, true, annoteRef);
    }


    //  ________________________________________________________________________________________________________________
    //
    //  Matrix Assignment productions
    //  ________________________________________________________________________________________________________________

    /**
     * generate_MatrixFieldAssignment()
     * params:
     *
     * vars:
     *   //  This is the important field for this method! If this is a matrix field assignment, then we must generate the matrix access w/
     *   //  setfield() method.
     *   //  Matrix access is checked for in the "left_hand_side" productions,
     *   Boolean_Mutable is_MatrixFieldAssignment;
     *
     * return values:
     */
    @Override
    public void caseAExpressionAssignment(AExpressionAssignment node) {
        MethodAttributeSet generateAssignment_Attribs = node.createMethodAttributes(HierarchyMethodConstants.method_Generate_MatrixFieldAssignment,
                node, hierarchyControl);

        //  Vars
        Boolean_Mutable is_MatrixFieldAssignment = (Boolean_Mutable)HashTools.put(generateAssignment_Attribs.vars,
                HierarchyMethodConstants.var_is_MatrixFieldAssignment, new Boolean_Mutable(false));

        CodeBuilder codeBuilder_MatrixFieldAssign = new CodeBuilder();

        if(node.getLeftHandSide() != null) {
            node.getLeftHandSide().apply(this);
        }
        if(node.getAssignmentOperator() != null) {
            node.getAssignmentOperator().apply(this);
        }
        if(node.getAssignmentExpression() != null) {
            node.getAssignmentExpression().apply(this);
        }


        generate_AssignmentCode(node, is_MatrixFieldAssignment, node.getLeftHandSide().toString_ProcessCurrent(), node.getAssignmentExpression().toString_ProcessCurrent());


        outAExpressionAssignment(node);
    }


    @Override
    public void caseAIdentifierAssignment(AIdentifierAssignment node) {
        MethodAttributeSet generateAssignment_Attribs = node.createMethodAttributes(HierarchyMethodConstants.method_Generate_MatrixFieldAssignment,
                node, hierarchyControl);

        //  Vars
        Boolean_Mutable is_MatrixFieldAssignment = (Boolean_Mutable)HashTools.put(generateAssignment_Attribs.vars,
                HierarchyMethodConstants.var_is_MatrixFieldAssignment, new Boolean_Mutable(false));

        if(node.getLeftHandSide() != null) {
            node.getLeftHandSide().apply(this);
        }
        if(node.getAssignmentOperator() != null) {
            node.getAssignmentOperator().apply(this);
        }

        identifier_Parts.createNewIdentifier();
        if(node.getIdentifier() != null) {
            node.getIdentifier().apply(this);
        }
        {
            List<PAdditionalIdentifier> copy = new ArrayList<PAdditionalIdentifier>(node.getAdditionalIdentifiers());
            for(PAdditionalIdentifier e : copy) {
                e.apply(this);
            }
        }

        String identifier_Full =  identifier_Parts.generateIdentifier();
        identifier_Parts.clearParts();

        generate_AssignmentCode(node, is_MatrixFieldAssignment, node.getLeftHandSide().toString_ProcessCurrent(), identifier_Full);


        outAIdentifierAssignment(node);
    }



    @Override
    public void caseAMjOutsideIncludedAssignment(AMjOutsideIncludedAssignment node) {
        inAMjOutsideIncludedAssignment(node);
        MethodAttributeSet generateAssignment_Attribs = node.createMethodAttributes(HierarchyMethodConstants.method_Generate_MatrixFieldAssignment,
                node, hierarchyControl);

        //  Vars
        Boolean_Mutable is_MatrixFieldAssignment = (Boolean_Mutable)HashTools.put(generateAssignment_Attribs.vars,
                HierarchyMethodConstants.var_is_MatrixFieldAssignment, new Boolean_Mutable(false));


        if(node.getLeftHandSide() != null) {
            node.getLeftHandSide().apply(this);
        }
        if(node.getAssignmentOperator() != null) {
            node.getAssignmentOperator().apply(this);
        }
        if(node.getMpOutsideIncludedExpressionRelatedProd() != null) {
            node.getMpOutsideIncludedExpressionRelatedProd().apply(this);
        }


        generate_AssignmentCode(node, is_MatrixFieldAssignment, node.getLeftHandSide().toString_ProcessCurrent(),
                node.getMpOutsideIncludedExpressionRelatedProd().toString_ProcessCurrent());

        outAMjOutsideIncludedAssignment(node);
    }


    private void generate_AssignmentCode(Node node,
            Boolean_Mutable is_MatrixFieldAssignment, String leftHandSide_Code, String valueExpression) {

        CodeBuilder codeBuilder_Assign = new CodeBuilder();

        codeBuilder_Assign.append(leftHandSide_Code);
        //  if it's matrix field assignment, don't include the assignment operator (because, the metacode is a call to the "setField()" operator
        if (!is_MatrixFieldAssignment.value)
            codeBuilder_Assign.append(" = ");
        codeBuilder_Assign.append(valueExpression);

        //  if it's matrix field assignment, close the set field method call
        if (is_MatrixFieldAssignment.value)
            codeBuilder_Assign.append(")");

        node.code(codeBuilder_Assign);
    }




    //  Matrix-Access, Left-hand side Production
    @Override
    public void inAMjMatrixAccessLeftHandSide(AMjMatrixAccessLeftHandSide node) {
        defaultIn(node);
        MethodAttributeSet generateAssignment_Attribs = node.getMethodAttributes();

        //  Vars
        Boolean_Mutable is_MatrixFieldAssignment = (Boolean_Mutable)generateAssignment_Attribs.vars.get(HierarchyMethodConstants.var_is_MatrixFieldAssignment);

        is_MatrixFieldAssignment.value = true;

        //  call the matrix access method, passing in the is_MatrixFieldAssignment param as true
        generateAssignment_Attribs.methodCall_AddValue(HierarchyMethodConstants.method_Generate_MatrixAccess,
                HierarchyMethodConstants.param_Is_MatrixFieldAssignment, is_MatrixFieldAssignment.value);

    }

    @Override
    public void outAMjMatrixAccessLeftHandSide(AMjMatrixAccessLeftHandSide node) {

        MethodAttributeSet generateAssignment_Attribs = node.getMethodAttributes();

        // don't forget to clear the method call values passed _to_ the method and the returnvalues passed _from_ the method
        generateAssignment_Attribs.methodCall_ClearAllValues();


        defaultOut(node);
    }




    //  ________________________________________________________________________________________________________________
    //
    //  Element-Name Specifier Options Production-Alternatives
    //  ________________________________________________________________________________________________________________
    /**
     * Dyn Access
     * ->[<DescTag Or DescTagName> (, schemaName Expr)]  - dyn access of descriptor (can also be field access)
     */
    @Override
    public void caseAMpElementNameSpecifyByBracket(AMpElementNameSpecifyByBracket node) {
        inAMpElementNameSpecifyByBracket(node);
        MethodAttributeSet generateAccess_Attribs = node.getMethodAttributes();

        DescriptorAccess_ChildAccessInfo curr_ChildAccessInfo = (DescriptorAccess_ChildAccessInfo) generateAccess_Attribs.vars.get(
                HierarchyMethodConstants.var_Curr_ChildAccessInfo);

        curr_ChildAccessInfo.is_StaticAccess = false;

        if (node.getLBkt() != null) {
            node.getLBkt().apply(this);
        }
        if(node.getFirstDynAccessor() != null) {

            //  If the first accessor expression is only a symbol, then in generateSymbols(), it should be created as a desctagName!!
            String symbolExpr_UnTranslated = node.getFirstDynAccessor().toString().trim();

            if (CodeUtilities.checkCode_Is_SymbolAccessOrCreation(symbolExpr_UnTranslated)) {
                generateAccess_Attribs.methodCall_AddValue(HierarchyMethodConstants.method_Generate_Symbol,
                        HierarchyMethodConstants.param_GenerateAndReturn_DescTagName, true);
            }

            node.getFirstDynAccessor().apply(this);
            String symExpr1 = node.getFirstDynAccessor().toString().trim();

            workers.descAccess.setSymbolExpr(symExpr1, 1, curr_ChildAccessInfo, HierarchyMethodConstants.method_Generate_Symbol,
                    HierarchyMethodConstants.retVal_Symbol_Actual);

            generateAccess_Attribs.methodCall_ClearAllValues();
            hierarchyControl.returnValues_clearMap_for(HierarchyMethodConstants.method_Generate_Symbol);

        }
        if (node.getSecondDynAccessor() != null) {
            node.getSecondDynAccessor().apply(this);
            String symExpr2 = node.getSecondDynAccessor().toString().trim();

            workers.descAccess.setSymbolExpr(symExpr2, 2, curr_ChildAccessInfo, HierarchyMethodConstants.method_Generate_Symbol,
                    HierarchyMethodConstants.retVal_Symbol_Actual);

            hierarchyControl.returnValues_clearMap_for(HierarchyMethodConstants.method_Generate_Symbol);

        }
        if (node.getRBkt() != null) {
            node.getRBkt().apply(this);
        }
        outAMpElementNameSpecifyByBracket(node);
    }



    @Override
    public void inAMpMatrixelementOneOrMoreNamescopesFirstDynAccessor(AMpMatrixelementOneOrMoreNamescopesFirstDynAccessor node)
    {
        defaultIn(node);


    }

    //  ________________________________________________________________________________________________________________
    //
    //  End of ElementNameSpecifyByBracket related productions
    //  ________________________________________________________________________________________________________________


    /**
     * Static Access (1 accessor)
     * -><static DescTag/DescTagName> - can also be field access
     * @param node
     */
    @Override
    public void caseAMpTagNameElementNameOrDescriptorLabel(AMpTagNameElementNameOrDescriptorLabel node) {
        inAMpTagNameElementNameOrDescriptorLabel(node);
        MethodAttributeSet generateAccess_Attribs = node.getMethodAttributes();

        DescriptorAccess_ChildAccessInfo curr_ChildAccessInfo = (DescriptorAccess_ChildAccessInfo) generateAccess_Attribs.vars.get(
                HierarchyMethodConstants.var_Curr_ChildAccessInfo);

        curr_ChildAccessInfo.is_StaticAccess = true;



        if (node.getMatrixElementName() != null) {
            node.getMatrixElementName().apply(this);

            String symExpr1 = node.getMatrixElementName().toString_ProcessCurrent().trim();
            workers.descAccess.setSymbolExpr(symExpr1, 1, curr_ChildAccessInfo, HierarchyMethodConstants.method_Generate_MatrixElementName,
                    HierarchyMethodConstants.retVal_Symbol_Actual);

            hierarchyControl.returnValues_clearMap_for(HierarchyMethodConstants.method_Generate_MatrixElementName);
        }



        outAMpTagNameElementNameOrDescriptorLabel(node);
    }

    @Override
    public void caseAMpLabelNameElementNameOrDescriptorLabel(AMpLabelNameElementNameOrDescriptorLabel node) {
        inAMpLabelNameElementNameOrDescriptorLabel(node);
        MethodAttributeSet generateAccess_Attribs = node.getMethodAttributes();

        DescriptorAccess_ChildAccessInfo curr_ChildAccessInfo = (DescriptorAccess_ChildAccessInfo) generateAccess_Attribs.vars.get(
                HierarchyMethodConstants.var_Curr_ChildAccessInfo);

        curr_ChildAccessInfo.is_StaticAccess = true;


        if (node.getLabelnameBacktik() != null) {
            node.getLabelnameBacktik().apply(this);
            String symExpr1 = node.getLabelnameBacktik().toString_ProcessCurrent().trim();
            workers.descAccess.setSymbolExpr(symExpr1, 1, curr_ChildAccessInfo, HierarchyMethodConstants.method_Generate_Label,
                    HierarchyMethodConstants.retVal_Label);

            hierarchyControl.returnValues_clearMap_for(HierarchyMethodConstants.method_Generate_Label);
        }
        outAMpLabelNameElementNameOrDescriptorLabel(node);
    }

    /**
     * Static Access (2 accessors)
     * -><static schemaOrMatrixName> [<schemaName Expr>] - can NOT also be field access
     * @param node
     */
    @Override
    public void caseAMpElemNameAndSecondAccessor(AMpElemNameAndSecondAccessor node) {
        inAMpElemNameAndSecondAccessor(node);
        MethodAttributeSet generateAccess_Attribs = node.getMethodAttributes();

        DescriptorAccess_ChildAccessInfo curr_ChildAccessInfo = (DescriptorAccess_ChildAccessInfo) generateAccess_Attribs.vars.get(
                HierarchyMethodConstants.var_Curr_ChildAccessInfo);

        curr_ChildAccessInfo.is_StaticAccess = true;
        if (node.getMatrixElementName() != null) {
            node.getMatrixElementName().apply(this);
            String symExpr1 = node.getMatrixElementName().toString_ProcessCurrent().trim();
            workers.descAccess.setSymbolExpr(symExpr1, 1, curr_ChildAccessInfo, HierarchyMethodConstants.method_Generate_MatrixElementName,
                    HierarchyMethodConstants.retVal_Symbol_Actual);

            hierarchyControl.returnValues_clearMap_for(HierarchyMethodConstants.method_Generate_MatrixElementName);
        }
        if (node.getLBkt() != null) {
            node.getLBkt().apply(this);
        }
        if (node.getSecondAccessor() != null) {
            node.getSecondAccessor().apply(this);
            String symExpr2 = node.getSecondAccessor().toString().trim();
            workers.descAccess.setSymbolExpr(symExpr2, 2, curr_ChildAccessInfo, HierarchyMethodConstants.method_Generate_Symbol, HierarchyMethodConstants.retVal_Symbol_Actual);

            hierarchyControl.returnValues_clearMap_for(HierarchyMethodConstants.method_Generate_Symbol);
        }
        if (node.getRBkt() != null) {
            node.getRBkt().apply(this);
        }
        outAMpElemNameAndSecondAccessor(node);
    }







    //  Misc Matrix-Access-Related Production-Alternatives_____________________________________________________
    @Override
    public void outAMpSecondDynAccessor(AMpSecondDynAccessor node) {
        defaultOut(node);
    }

    @Override
    public void outAMpSecondAccessor(AMpSecondAccessor node) {
        defaultOut(node);
    }

    @Override
    public void outAMpAnnotationSpaceshipUseage(AMpAnnotationSpaceshipUseage node) {
        defaultOut(node);
    }




    //  Matrix-Elem Multiple-Access Options Prod-Alternatives __________________________________________________________
    @Override
    public void caseAMpStdMatrixElemMultipleAccessOptions(AMpStdMatrixElemMultipleAccessOptions node) {

        inAMpStdMatrixElemMultipleAccessOptions(node);
        MethodAttributeSet generateAccess_Attribs = node.getMethodAttributes();


        boolean has_FiltersAnnotationReference = false;


        if (node.getSubsetCreate() != null) {
            node.getSubsetCreate().apply(this);
        }


        String subSetCreate_FullExpr = node.getSubsetCreate().toString();
        //  get rid of the subset tokens and all empty spaces
        String subSetCreate_Expr = subSetCreate_FullExpr.substring(1, subSetCreate_FullExpr.length() - 2).replaceAll("\\s", "");

        Symbol annoteRef = (Symbol) generateAccess_Attribs.vars.get(HierarchyMethodConstants.var_RetVal_AnnoteRef_Actual);
        String annoteRef_String = null;
        if (annoteRef != null)
            annoteRef_String = annoteRef.name_no_backtiks;

        if (annoteRef_String != null && annoteRef_String.equals(subSetCreate_Expr))
            has_FiltersAnnotationReference = true;

        workers.descAccess.setupMultiAccess(generateAccess_Attribs, has_FiltersAnnotationReference, annoteRef);


        outAMpStdMatrixElemMultipleAccessOptions(node);
    }

    @Override
    public void caseAMpAbbrMatrixElemMultipleAccessOptions(AMpAbbrMatrixElemMultipleAccessOptions node) {
        inAMpAbbrMatrixElemMultipleAccessOptions(node);
        MethodAttributeSet generateAccess_Attribs = node.getMethodAttributes();


        boolean has_FiltersAnnotationReference = false;


        if (node.getSubsetCreateAbbr() != null) {
            node.getSubsetCreateAbbr().apply(this);
        }


        String subSetCreate_FullExpr = node.getSubsetCreateAbbr().toString();
        //  get rid of the subset tokens and all empty spaces
        String subSetCreate_Expr = subSetCreate_FullExpr.substring(1, subSetCreate_FullExpr.length() - 2).replaceAll("\\s", "");

        Symbol annoteRef = (Symbol) generateAccess_Attribs.vars.get(HierarchyMethodConstants.var_RetVal_AnnoteRef_Actual);
        String annoteRef_String = null;
        if (annoteRef != null)
            annoteRef_String = annoteRef.name_no_backtiks;

        if (annoteRef_String != null && annoteRef_String.equals(subSetCreate_Expr))
            has_FiltersAnnotationReference = true;


        workers.descAccess.setupMultiAccess(generateAccess_Attribs, has_FiltersAnnotationReference, annoteRef);


        outAMpAbbrMatrixElemMultipleAccessOptions(node);
    }






	//  ______________________________________________________________________________________________________________________________________________
    //
    //    Descriptor Variable Type Productions
	//  ______________________________________________________________________________________________________________________________________________




    /**
     * process_DescriptorVarDeclaration()
     * params:
     *
     * vars:
     *    boolean collecting_MatrixAccessState;
     *    MatrixAccessState MatrixAccessState;  // the matrix access state created from the call to generate_MatrixAccess();
     *
     * return values:
     */    @Override
    public void inAMpDescriptorVariableType(AMpDescriptorVariableType node)
    {
        defaultIn(node);
        MethodAttributeSet variableDeclaration_Attribs = node.createMethodAttributes(HierarchyMethodConstants.method_Process_DescriptorVarDeclaration,
                node, hierarchyControl);

    }

    @Override
    public void outAMpDescriptorVariableType(AMpDescriptorVariableType node)
    {
        defaultOut(node);
        MethodAttributeSet variableDeclaration_Attribs = node.getMethodAttributes();

        CodeBuilder modifierText = new CodeBuilder();
        List<PModifier> modifierProductions_List = new ArrayList<PModifier>(node.getModifiers());
        for(PModifier modifierProduction : modifierProductions_List) {
            modifierText.append(modifierProduction.toString()).append(" ");
        }

        //  get the matrix access state and return it
        MatrixAccessState matrixAccessState = (MatrixAccessState)variableDeclaration_Attribs.vars.get(HierarchyMethodConstants.var_MatrixAccessState);

        variableDeclaration_Attribs.returnValues.put(HierarchyMethodConstants.retVal_MatrixAccessState, matrixAccessState);


        //  don't output the matrix access type, just the DESCRIPTOR type keyword:
        node.code(modifierText + Descriptor.class.getName() + " ");
    }






    /**
     * These desc vars can have matrix accesses:<br>
     * DESCRIPTOR<MyMatrix->MY.FIELD> myDescVar;<p>
     *
     * and this production will make a call to the Matrix Access method in the super class (or, actually, will make sub-matches on the
     * Matrix Access production in the super class). You need to make a call to the Matrix Access methods to let it know that you're doing a
     * "collecting_MatrixAccessState"
     * @param node
     */
    @Override
    public void inAMpMatrixAccessMatrixAccessType(AMpMatrixAccessMatrixAccessType node) {
        defaultIn(node);

        MethodAttributeSet variableDeclaration_Attribs = node.getMethodAttributes();

        //  pass it the matrixElementType for MatrixName Label
        variableDeclaration_Attribs.methodCall_AddValue(HierarchyMethodConstants.method_Generate_MatrixAccess,
                HierarchyMethodConstants.param_Collecting_MatrixAccessState, true);

    }

    @Override
    public void outAMpMatrixAccessMatrixAccessType(AMpMatrixAccessMatrixAccessType node) {
        defaultOut(node);
        MethodAttributeSet variableDeclaration_Attribs = node.getMethodAttributes();

        //  get the matrix access state from the returned matrixAccess Code Gen
        DescriptorAccess_CodeGenerator descAccessCodeGen = (DescriptorAccess_CodeGenerator)hierarchyControl.returnValues_getMap_for(
                HierarchyMethodConstants.method_Generate_MatrixAccess).get(HierarchyMethodConstants.retVal_DescAccess_CodeGen);

        if (descAccessCodeGen != null)
            variableDeclaration_Attribs.vars.put(HierarchyMethodConstants.var_MatrixAccessState, descAccessCodeGen.postGen__create_MatrixAccessState());

        // don't forget to clear the method call values passed _to_ the method and the returnvalues passed _from_ the method
        variableDeclaration_Attribs.methodCall_ClearAllValues();
        hierarchyControl.returnValues_clearMap_for(HierarchyMethodConstants.method_Generate_MatrixAccess);

    }





    //  ________________________________________________________________________________________________________________
    //
    //    Java Productions
    //  ________________________________________________________________________________________________________________


    // Class Method declarations _______________________________________________________________________________________
    @Override
    public void inAMethodDeclaration(AMethodDeclaration node) {
        defaultIn(node);

        codeGenerators_MatrixAccess.annotationsCodeGenerator_Control.increment_MethodIndex();
    }
    @Override
    public void outAMethodDeclaration(AMethodDeclaration node) {
        defaultOut(node);
    }


    @Override
    public void outABlock(ABlock node) {
        boolean isMethodBlock =
                symbolTable_File.scopeStack.getCurrScopeID_for_Method_ScopeBoundary() ==
                symbolTable_File.scopeStack.viewCurrentScope().scope_Id;

        if (isMethodBlock) {
            Exception_MetaCompilerError error = super.checkFor_AnnotationHandlerBlock(symbolTable_File.scopeStack.viewCurrentScope().scope_Id);
            if (error != null)
                hierarchySettings.logger.reportError_And_Exit(error);
        }

        //  Call the LangSymbolTableActions__FileSymTableClient's outABlock(), to let it update the sym table
        super.outABlock(node);
    }


    @Override
    public void outAConstructorBody(AConstructorBody node) {
        
        Exception_MetaCompilerError error = super.checkFor_AnnotationHandlerBlock(symbolTable_File.scopeStack.viewCurrentScope().scope_Id);
        if (error != null)
            hierarchySettings.logger.reportError_And_Exit(error);


        //  Call the LangSymbolTableActions__FileSymTableClient's outAConstructorBody(), to let it update the sym table
        super.outAConstructorBody(node);
    }


    // _________________________________________________________________________________________________________________
    /**
     * vars used:
     *   List <String> identifier_PartsList; if this var exists, then use it and set the parts of identifier to it
     *   CodeBuilder identifier_Full; // set by TIdentifer parserException_Token
     *
     * NOT IT'S OWN METHOD
     */
    @Override
    public void caseTIdentifier(TIdentifier node) {
        defaultCase(node);
        MethodAttributeSet methodAttribs = node.parent().getMethodAttributes();

        String identifierText = null;
        if (!identifier_Parts.isNull() || methodAttribs != null)
            identifierText = node.getText().trim();



        // TODO - later on, get rid of the identifier_PartsList and use the identifier_Parts obj */
        if (!identifier_Parts.isNull())
            identifier_Parts.addPart(identifierText);

        // if there is a var named: "identifier_PartsList", then use it and set the parts of identifier to it.
        // ** Also, if there is a language expression object, then add the identifier expresion part to it.
        if (methodAttribs != null) {

            List<String> identifier_PartsList = (List<String>)methodAttribs.vars.get(HierarchyMethodConstants.var_Identifier_PartsList);
            Expression identifier_Expression = (Expression)methodAttribs.vars.get(HierarchyMethodConstants.var_Identifier_Expression);


            if (identifier_PartsList != null)
                identifier_PartsList.add(identifierText);





            if (identifier_Expression != null)
                identifier_Expression.addExpressionPart(new ExpressionPart_Identifier(identifierText));



            CodeBuilder identifier_Full = (CodeBuilder) methodAttribs.vars.get(HierarchyMethodConstants.var_Identifier_Full);
            if (identifier_Full == null)
                identifier_Full = (CodeBuilder) HashTools.put(methodAttribs.vars, HierarchyMethodConstants.var_Identifier_Full, new CodeBuilder());


            if (identifier_Full.length() == 0) {
                identifier_Full.append(identifierText);
            } else {
                identifier_Full.append('.').append(identifierText);
            }
        }


    }


}
