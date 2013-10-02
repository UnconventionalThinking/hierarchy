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


import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.lang.Pair;
import net.unconventionalthinking.matrix.Descriptor;
import net.unconventionalthinking.matrix.Exception_Descriptor;
import net.unconventionalthinking.matrix.Matrix;
import net.unconventionalthinking.matrix.MatrixControl;
import net.unconventionalthinking.matrix.MatrixStructInfo_DescriptorContainer;
import net.unconventionalthinking.matrix.SchemaControl;
import net.unconventionalthinking.matrix.metacompiler.codefilegen.AnnotationsInterface_FileGenerator;
import net.unconventionalthinking.matrix.symbols.DescriptorTag;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import net.unconventionalthinking.hierarchy.langsymboltable.MatrixAccessState;
import net.unconventionalthinking.utilities.ListUtilities;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.unconventionalthinking.lang.String_Mutable;
import net.unconventionalthinking.matrix.ExceptRuntime_DescriptorAccess;
import net.unconventionalthinking.matrix.symbols.Symbol_Base;
import org.apache.commons.collections.map.MultiValueMap;




/**
 *
 * @author peterjoh
 */
public class DescriptorAccess_CodeGenerator extends DescriptorAccess_CodeGenerator__Base {


    CodeBuilder codeBuilder_ForMethod;


    String              rootAccessorExpr;
    String              matrixName;
    boolean             rootAccessorExpr_Is_Identifier;
    boolean             is_MatrixAccess;

    boolean             collecting_MatrixAccessState;
    boolean             is_MatrixFieldAssignment;
    boolean             is_ContinuedAccess;
    MatrixAccessState   continuedAccess_MatrixAccessState;

    /** This is an output value, determined during the generation of the matrix access. */
    int                 OUT_methodAccessNumber;

    String                                  packageName;
    MultiValueMap                           matrixPackage_Index_bySimpleName;

    List<DescriptorAccess_ChildAccessInfo>  childAccessInfo_List;
    List<ChildAccess_AccessResults>         childAccessResults_List;



    
    public DescriptorAccess_CodeGenerator(SymbolControl symbolControl, SchemaControl schemaControl, MatrixControl matrixControl, int baseIndentLevel,
            HierarchySettings hierarchySettings, CodeGen_OutputResults outputResults) {
        super(symbolControl, schemaControl, matrixControl, baseIndentLevel, hierarchySettings, outputResults);

        collecting_MatrixAccessState = false;
    }


    public void set_1_PackageInfo(String packageName, MultiValueMap matrixPackage_Index_bySimpleName) {
        this.packageName = packageName;
        this.matrixPackage_Index_bySimpleName = matrixPackage_Index_bySimpleName;
    }

    @Override
    public void set_1_AnnotationInfo(AnnotationCall_CodeGenerator_Std annotationCall_CodeGen) {
        super.set_1_AnnotationInfo(annotationCall_CodeGen);

        //  tell the annotationCall_CodeGen we're starting a new access
        annotationCall_CodeGen.starting_NewAccess();
    }


    /** Currently, not generating a matrix access, only collecting the matrix access state. This is typically done for a Descriptor Var access type */
    public void set_2_CollectMatrixAccessState() {
        this.collecting_MatrixAccessState = true;
        this.is_ContinuedAccess = false;
    }
    public void set_2_IsMatrixFieldAssignment() {
        this.is_MatrixFieldAssignment = true;
    }
    /** This access is a continued access, typically of something like a descriptor var. Pass in the Matrix Access state if it exists. */
    public void set_2_ContinuedAccess_MatrixAccessState(boolean is_ContinuedAccess, MatrixAccessState matrixAccessState) {
        if (is_ContinuedAccess) {
            this.collecting_MatrixAccessState = false;
            this.is_ContinuedAccess = true;
        } else {
            this.is_ContinuedAccess = false;
        }
        this.continuedAccess_MatrixAccessState = matrixAccessState;
    }


    public void set_3_RootAccessorInfo(String rootAccessorExpr, boolean rootAccessorExpr_Is_Identifier, boolean is_MatrixAccess_andNotSchema) {
        this.rootAccessorExpr = rootAccessorExpr;
        this.rootAccessorExpr_Is_Identifier = rootAccessorExpr_Is_Identifier;
        this.is_MatrixAccess = is_MatrixAccess_andNotSchema;
    }

    public void set_3_ChildAccessInfo(List<DescriptorAccess_ChildAccessInfo> childAccessInfo_List) {
        this.childAccessInfo_List = childAccessInfo_List;

        //  determine set_lastChildAccess

        if (childAccessInfo_List != null && childAccessInfo_List.size() > 0)
            last_ChildAccessInfo = childAccessInfo_List.get(childAccessInfo_List.size() - 1);
    }





    //  __________________________________________________________________________________________________________________________________________
    //
    //    Generate Matrix-Access - Top Level Methods
    //  __________________________________________________________________________________________________________________________________________

    public CodeBuilder generate_MartrixAccess_Method(CodeGen_OutputResults outputResults)
        throws Exception_MetaCompilerError {


        Matrix matrix = setupAccess();

        return generate_AccessMethod(matrix, outputResults);
    }


    private Matrix setupAccess() throws Exception_MetaCompiler_IncorrectMatrixAccess {


        rootAccessSettings.parent_DescriptorActual = null;
        rootAccessSettings.parent_DescriptorFlattened = null;
        rootAccessSettings.parent_OutExpression_Is_OutVar = false;
        root_AccessMethodCall_RootAccessorValue = null;  // this is only used for dynamic access
        firstAccess_Is_Static = childAccessInfo_List.get(0).is_StaticAccess;
        String matrixClassName = null;

        if (!collecting_MatrixAccessState && accessMethodClass_Name == null)
            throw new Exception_MetaCompiler_IncorrectMatrixAccess("You did not provide the class name for the access methods.");



        Matrix matrix = null;

        if (is_ContinuedAccess) {
            if (continuedAccess_MatrixAccessState != null && continuedAccess_MatrixAccessState.hasAccessState()) {
                //  This is a continued access, copy the last access settings from the matrix access state.
                rootAccessSettings.copyValues(continuedAccess_MatrixAccessState.lastAccessSettings);

                rootAccessSettings.parent_DescriptorActual = null;
                rootAccessSettings.determine_MatrixUsageDescriptor_Type_for_ContinuedAccess(); // should always be using DescriptorFlattened
                // it's using the root-accessor Method parameter, "descriptor", that is passed in
                rootAccessSettings.parent_OutExpression = "descriptor";
                root_AccessMethodCall_RootAccessorValue = rootAccessorExpr; // the value for the method call for the root accessor

            } else if (firstAccess_Is_Static) { // no access state and the first Access is static, throw an error
                throw new Exception_MetaCompiler_IncorrectMatrixAccess("Doing continued, static access, but could not determine the type of the root access expresion, '" +
                        rootAccessorExpr + "'. Change this to dynamic access.");
                
            } else { // no access state and doing dyn access
                rootAccessSettings.clearAll_ParentMatrixUsageDescriptor_Settings();
                rootAccessSettings.parent_OutExpression = rootAccessorExpr;
            }

        } else if (rootAccessorExpr_Is_Identifier) {

            //  If it's a static matrix, get the actual Matrix built by the Metacompiler ________________________________
            matrix = findMatrix_byClassNameFull();


            if (matrix != null) {

                rootAccessSettings.set_HaveParentMatrixUsageDescriptor(true);
                rootAccessSettings.parent_DescriptorActual = matrix;
                matrixClassName = matrix.matrixName.getClassName_Full();

                MatrixStructInfo_DescriptorContainer matrix_descContainer = matrixControl.findMatrixUsageStructure(matrix.matrixName);
                if (matrix_descContainer != null)
                    rootAccessSettings.parent_DescriptorFlattened = matrix_descContainer.descriptor_Flattened;
                else
                    throw new Exception_MetaCompiler_IncorrectMatrixAccess("Doing static access, but could not find the matrixFlattened for the matrix, " + matrixClassName);

                //  To determine the 'accessParentUsing_MatrixUsageDesc_Type', need the first childAccessInfo.
                //  There should be at least one child access, so we don't need to do any checks
                DescriptorAccess_ChildAccessInfo first_ChildAccessInfo = childAccessInfo_List.get(0);
                rootAccessSettings.determine_MatrixUsageDescriptor_Type_for_RootAccess(first_ChildAccessInfo);


                if (firstAccess_Is_Static)
                    rootAccessSettings.parent_OutExpression = matrixClassName + ".matrix";
                else {// the matrix object is passed into the generated, _dynamic or multi_-access method
                    root_AccessMethodCall_RootAccessorValue = matrixClassName + ".matrix";
                    rootAccessSettings.parent_OutExpression = "matrix";  // this is the matrix parameter that is passed in.
                }

            } else {
                // there is no matrix for this identifier. This means this could be a matrix variable that is set to a matrix. Must do
                // dynamic access
                rootAccessSettings.clearAll_ParentMatrixUsageDescriptor_Settings();
                rootAccessSettings.parent_OutExpression = rootAccessorExpr;
            }

            // So, if rootAccessorExpr is an Identifier, then rootAccessSettings.parent_OutExpression can be the actual matrix name,
            // or a matrix variable
            rootAccessSettings.parent_OutExpression_Is_OutVar = true;



        } else { // matrix access starts with a Java primary expression
            rootAccessSettings.clearAll_ParentMatrixUsageDescriptor_Settings();
            if (firstAccess_Is_Static)
                rootAccessSettings.parent_OutExpression = rootAccessorExpr;
            else {// the matrix expression result in a matrix object that is passed into the generated, _dynamic_-access method
                root_AccessMethodCall_RootAccessorValue = rootAccessorExpr;
                rootAccessSettings.parent_OutExpression = "matrix";  // this is the matrix parameter that is passed in.
            }
            rootAccessSettings.parent_OutExpression_Is_OutVar = false;

        }

        return matrix;
    }





    private CodeBuilder generate_AccessMethod(Matrix matrix, CodeGen_OutputResults outputResults)
        throws Exception_MetaCompilerError {

        codeBuilder_ForMethod = new CodeBuilder();

        CodeBuilder accessMethodSignature_ParamList = new CodeBuilder();
        CodeBuilder accessMethodCall_ParamList = new CodeBuilder();


        //  Create access method _____________________________________________________________________
        //  NOTE: no return type yet!
        String optionalMatrixName = (matrix != null) ? (matrix.get_Label().getSymbol().name_IdentFormat)
                : "";
        OUT_methodAccessNumber = CodeGeneratorUtilities.methodName_IdCreator.getAndInc_ID();
        String matrixAccessMethodName = (is_MatrixFieldAssignment ? 
                    CodeConstants.OutMethodName_AccessMatrix_Suffix_ForFieldAssignment : CodeConstants.OutMethodName_AccessMatrix_Suffix)
                + (is_MatrixAccess_In_StaticMethod?
                    CodeConstants.OutMethodName_AccessMatrix_Modifier_InStaticMethod : "")
                +  optionalMatrixName + "__" + OUT_methodAccessNumber;



        //  Process each child access: ___________________
        //  First, intialize the Parent parent_DescriptorActual vars.
        //  NOTE: currAccessSettings.parent_OutExpression is typically sometime of outVar (parent_DescriptorActual, field, or Set of descriptors or fields). But, the
        //  But, the first parent can be an expression that return a matrix, which would mean currAccessSettings.parent_OutExpression_Is_OutVar is false!
        currAccessSettings.copyValues(rootAccessSettings);
        prevAccessSettings = null;

        ChildAccess_AccessResults accessResults = null;
        childAccessResults_List = new ArrayList<ChildAccess_AccessResults>();
        //  a list of all the child accessor pairs (childAccess Expr1 and Expr2)
        List<Pair<String, String>> childAccessPairs_List = new ArrayList<Pair<String, String>>();



        //  Now, process all the subsequent child accesses off the root matrix
        for (int childAccess_Index = 0; childAccess_Index < childAccessInfo_List.size(); ++childAccess_Index) {

            DescriptorAccess_ChildAccessInfo childAccessInfo = childAccessInfo_List.get(childAccess_Index);
            prevChildAccessInfo = currChildAccessInfo;
            currChildAccessInfo = childAccessInfo;
            try {

                accessResults = generate_AccessChild_Code(childAccess_Index, accessMethodSignature_ParamList, accessMethodCall_ParamList,
                        childAccessInfo, childAccessPairs_List, last_ChildAccessInfo);
                childAccessResults_List.add(accessResults);

                setup_NextChildAccess(executeInfo, accessResults);


            } catch (Exception e) {
                handle_ChildAccessException(e, childAccessInfo, optionalMatrixName);
            }

        }




        //  The reason for assembling the access code strings in this loop is because we don't know what the 'outValue_Default' is of the
        //  last accessed element until all the access have been processed (and, more importantly, the in memory matrix has been created, so
        //  we can access the schemaInfo objects and get the default value of a field if it's a field access).

        ChildAccess_AccessResults last_AccessResults__forAccessMethod = null;
        String methodReturnType;
        if (is_MatrixFieldAssignment) { // this is field assignment, the last access result is not used in the method. so, get the 2nd to last one.
            if (childAccessResults_List.size() >= 2) {
                last_AccessResults__forAccessMethod = childAccessResults_List.get(childAccessResults_List.size() - 2);
                methodReturnType = last_AccessResults__forAccessMethod.outVar_TypeString;
            
            }  else if (childAccessResults_List.size() == 1) {
                //  Is continued access or a matrix access
                methodReturnType = "Descriptor";
                //  also, since this is field assignment, don't need to set a last_AccessResults__forAccessMethod

            } else {
                throw new ExceptRuntime_DescriptorAccess("This shouldn't have happened, doing a matrix access, but had no access results.");
            }

        } else {  // this is standard access, just use the last element in the list
            last_AccessResults__forAccessMethod = childAccessResults_List.get(childAccessResults_List.size() - 1);
            methodReturnType = last_AccessResults__forAccessMethod.outVar_TypeString;
        }

        
        for (ChildAccess_AccessResults childAccess_Result : childAccessResults_List) {

            if (childAccess_Result.fieldAssign__AccessIsFieldAssign) {
                // do nothing
            } else {
                codeBuilder_ForMethod.append(childAccess_Result.childAccessCode_without_finalElseStmt);
                String extraIndent = (childAccess_Result.outVarName_ElementType != DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.Field) ?
                                      "\t\t" : "";
                codeBuilder_ForMethod
                    .append(baseIndent + extraIndent +"\treturn " +
                        ((last_AccessResults__forAccessMethod.outVar_TypeSymbol != null) ?
                            CodeGeneratorUtilities.generate_CastObjectToCorrectType("annotateRetVal", last_AccessResults__forAccessMethod.outVar_TypeSymbol) :
                            "annotateRetVal")
                        +";\n");

                if (childAccess_Result.outVarName_ElementType != DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.Field)
                   codeBuilder_ForMethod
                    .append(baseIndent + "\t}\n\n\n");
            }
            
        }
        //  final return stmt for method: If it's a parent_DescriptorActual (or desc set), return the last parent_DescriptorActual var.
        //  If it's a field, it's already taken care of.
        if (last_AccessResults__forAccessMethod != null &&
                last_AccessResults__forAccessMethod.outVarName_ElementType != DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.Field) {
            codeBuilder_ForMethod.append("\n" + baseIndent + "\treturn " + last_AccessResults__forAccessMethod.outVarName + ";\n");

        //  if this is a continued access for a field assignment that is right off the desc var!!! (ex: myDesc:>field1 = 5), then
        //  this is an empty method that just returns the passed in desc!!!
        } else if (is_ContinuedAccess && is_MatrixFieldAssignment) {
            codeBuilder_ForMethod.append("\n" + baseIndent + "\treturn descriptor;\n");
        }

        //  Create Access Method Signature _________________________________________________________
        //  set the return type in the access method signature
        CodeBuilder accessMethodSignature = new CodeBuilder();
        if (is_ContinuedAccess)
            accessMethodSignature.append("\n" + baseIndent + "//  Continued Access");
        accessMethodSignature.append("\n" + baseIndent + "public static " + methodReturnType + " " +
                matrixAccessMethodName + "(ExecutionInfo executeInfo");

        if (is_ContinuedAccess) // continued access
            accessMethodSignature.append(", Descriptor descriptor");
        else if (!firstAccess_Is_Static) // dyn access
            accessMethodSignature.append(", Matrix matrix");

        //  If the matrix access is inside a static method, then you don't need a callerobj (because there is none)
        if (!is_MatrixAccess_In_StaticMethod)
            accessMethodSignature.append(", " + AnnotationsInterface_FileGenerator.generateInterfaceName(embeddedFile_ClassName) + " callerObj");
        accessMethodSignature.append(accessMethodSignature_ParamList + ") {\n\n");

        codeBuilder_ForMethod.addToStart(accessMethodSignature);
        // close method
        codeBuilder_ForMethod.append("\n" + baseIndent + "}\n\n\n");



        //  Create the Access Method call _________________________________________________________
        codeBuilder_EmbeddedCode.append(accessMethodClass_Name + "." + matrixAccessMethodName + "(executeInfo");
        
        if (!firstAccess_Is_Static || is_ContinuedAccess)
            codeBuilder_EmbeddedCode.append(", " + root_AccessMethodCall_RootAccessorValue);

        //  If the matrix access is inside a static method, then you don't need to pass 'this' as a callerobj (because there is none)
        if (!is_MatrixAccess_In_StaticMethod)
            codeBuilder_EmbeddedCode.append(", this");
        codeBuilder_EmbeddedCode.append(accessMethodCall_ParamList).append(")");
        
        //  if it's matrix field assignment, append to the setField call to the method call.
        if (is_MatrixFieldAssignment) {
            ChildAccess_AccessResults field_AccessResults = childAccessResults_List.get(childAccessResults_List.size() - 1);

            codeBuilder_EmbeddedCode.addToStart("((" + field_AccessResults.fieldAccess__SpecializedFieldSet_FullTypeName + ")");
            codeBuilder_EmbeddedCode.append(".get_FieldSet())").append(field_AccessResults.fieldAssign__codeBuilder_SetFieldCall);
        }



        outputResults.addImport("import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;");


        if (firstAccess_Is_Static) {
            codeBuildersList__AccessMethods_Static.add(codeBuilder_ForMethod);
        } else { // dyn access
            codeBuildersList__AccessMethods_Dyn.add(codeBuilder_ForMethod);
        }
        codeBuildersList__AccessMethods_All.add(codeBuilder_ForMethod);

        return codeBuilder_ForMethod;

    }







    //  __________________________________________________________________________________________________________________________________________
    //
    //    Generate Matrix-Access - Child Access Processing Methods
    //  __________________________________________________________________________________________________________________________________________


    /**
     * This method generates the access code for each child access.
     *
     * To generate the access method's signature for a Dynamic access: for each of the Access Expression (
     * such as a parent_DescriptorActual tag-name, label, or a descTag var, or even a method call that returns a descTagVar), it puts all the
     * accessExpressions into the parameters list of the method call.
     *
     *    Ex. matrixAccess_1_MyMatrix(AppSymbols_Label.MyMatrix, AppSymbols_Label.MyItem, AppSymbols_DescTagName.FORM.REQUIRED,
     *                                field_DescTagName_Variable)
     *
     * Why? because this could be a dynamic access expressions which needs to know what the value of the accessors, because they could be
     * descriptor Vars (as in 'field_DescTagName_Variable' in the example).
     *
     *
     * @param childAccess_Index
     * @param accessMethodSignature_ParamList
     * @param accessMethodCall_ParamList
     * @param childAccessInfo
     * @param intraMethod_ChildAccessExpr_Pairs__List   The list of expression pairs used at each child access.
     *                          By Intra-Method, we mean the expression that is used Inside the access method itself to refer to each
     *                          accessor (and not the expressions used as a value to the call to the method).
     * @param last_ChildAccessInfo
     * @return
     * @throws Exception_MetaCompiler_IncorrectMatrixAccess
     * @throws Exception_MetaCompilerError
     */
    private ChildAccess_AccessResults generate_AccessChild_Code(int childAccess_Index, CodeBuilder accessMethodSignature_ParamList,
            CodeBuilder accessMethodCall_ParamList, 
            DescriptorAccess_ChildAccessInfo childAccessInfo, List<Pair<String, String>> intraMethod_ChildAccessExpr_Pairs__List,
            DescriptorAccess_ChildAccessInfo last_ChildAccessInfo)
        throws Exception_MetaCompiler_IncorrectMatrixAccess, Exception_MetaCompilerError {


        CodeBuilder codeBuilder_ChildAccess = new CodeBuilder();

        DescriptorAccess_ChildAccessGeneratorInfo childAccessGenInfo =
                new DescriptorAccess_ChildAccessGeneratorInfo(childAccess_Index, childAccessInfo);

        childAccessGenInfo.setup_1_GeneratorInfo_and_AccessMethodSignature(accessMethodSignature_ParamList, accessMethodCall_ParamList);
        childAccessGenInfo.setup_2_getChildDescriptor_Parameters();
        childAccessGenInfo.setup_3_IntraMethod_ChildAccessPairs(intraMethod_ChildAccessExpr_Pairs__List);



        //  Create the access ouput code __________________________________________________________________________________________

        String outVarName = childAccessInfo.typeOfElementAccessed.toString() + "__" + CodeGeneratorUtilities.var_IdCreator.getAndInc_ID() +
                childAccessGenInfo.outVarName_DescriptionText;
        String outVar_TypeString = null;
        String outValue_Default = "null";
        Symbol outVar_TypeSymbol = null;

        String fieldAccess__SpecializedFieldSet_FullTypeName = null;
        CodeBuilder fieldAssign__codeBuilder_SetFieldCall = null;

        ChildAccess_AccessResults accessResults = new ChildAccess_AccessResults();


        if (childAccessInfo.is_SingleAccess) {

            if (childAccessInfo.typeOfElementAccessed == DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.Descriptor) {

                codeBuilder_ChildAccess
                    .append(baseIndent + "\t" + childAccessGenInfo.outComment_AccessDescription)
                    .append(baseIndent + "\tDescriptor " + outVarName + " = null;\n")
                    .append("\n" + baseIndent + "\tif (DescriptorUtilities.validDescriptors(executeInfo, " + 
                            currAccessSettings.parent_OutExpression + ")) {\n");

                codeBuilder_ChildAccess
                    .append(baseIndent + "\t\ttry{\n")
                    .append(baseIndent + "\t\t\t" + outVarName + " = ")
                    .append(
                        childAccessInfo.is_StaticAccess ? currAccessSettings.parent_OutExpression : "((Descriptor)" + currAccessSettings.parent_OutExpression + ")"
                           )
                    .append(".get_ChildDescriptor(executeInfo, ");
                codeBuilder_ChildAccess
                    .append(
                        childAccessInfo.numberOfExpresions == 1 ? childAccessGenInfo.getChildDescriptor_ParamValue1 :
                            childAccessGenInfo.getChildDescriptor_ParamValue1 + ", " + childAccessGenInfo.getChildDescriptor_ParamValue2
                           )
                    .append(");\n");
                //  Error Handling code:
                codeBuilder_ChildAccess
                    .append(baseIndent + "\t\t} catch (Exception e) {\n")
                    .append(baseIndent + "\t\t\texecuteInfo.setErrorException(e);\n")
                    .append(baseIndent + "\t\t}\n\n")

                    .append(baseIndent + "\t} else { // end of if (validDescriptors())\n")
                    .append(baseIndent + "\t\texecuteInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);\n")
                    .append(baseIndent + "\t}\n\n");

                generate_AccessChildCode_AccessErrorCode(codeBuilder_ChildAccess, false, true, is_MatrixAccess, MPSymbols.Descriptor,
                        childAccess_Index, childAccessInfo, intraMethod_ChildAccessExpr_Pairs__List, outVarName);



                outVar_TypeString = Descriptor.class.getSimpleName();
                outVar_TypeSymbol = MPSymbols.Descriptor;


            } else if (childAccessInfo.typeOfElementAccessed == DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.Field) {

                DescriptorAccess_CodeGenerator__FieldAccess fieldAccess_CodeGen = new DescriptorAccess_CodeGenerator__FieldAccess(symbolControl,
                        schemaControl, matrixControl, baseIndentLevel + 1, hierarchySettings, outputResults);
                fieldAccess_CodeGen.set_1_AccessMethodClass_Name(accessMethodClass_Name);
                fieldAccess_CodeGen.set_1_AnnotationInfo(annotationCall_CodeGen);
                fieldAccess_CodeGen.set_1_CodeBuilders(codeBuildersList__AccessMethods_Static, codeBuildersList__AccessMethods_Dyn,
                        codeBuildersList__AccessMethods_All, codeBuilder_EmbeddedCode);
                fieldAccess_CodeGen.set_1_Is_MatrixAccess_In_StaticMethod(is_MatrixAccess_In_StaticMethod);
                fieldAccess_CodeGen.set_1_EmbeddedFile_ClassName(embeddedFile_ClassName);
                
                fieldAccess_CodeGen.set_RootAccessSettings__OPTIONAL(rootAccessSettings);
                fieldAccess_CodeGen.set_lastChildAccess__OPTIONAL(last_ChildAccessInfo);
                fieldAccess_CodeGen.set_ParentAccessSettings__OPTIONAL(currAccessSettings);

                if (childAccessInfo.accessExpr2_Is_ContinuationIndex)
                    fieldAccess_CodeGen.set_ContinuationIndex_ParamName(childAccessGenInfo.childAccess_MethodParam_ContIndex_Name);


                if (is_MatrixFieldAssignment) {
                    String_Mutable OUT__fieldAccess_SpecializedFieldSet_FullTypeName = new String_Mutable(null);
                    fieldAssign__codeBuilder_SetFieldCall = fieldAccess_CodeGen.generate_FieldAssignment(childAccess_Index, childAccessInfo,
                            is_MatrixAccess, OUT__fieldAccess_SpecializedFieldSet_FullTypeName);
                    fieldAccess__SpecializedFieldSet_FullTypeName = OUT__fieldAccess_SpecializedFieldSet_FullTypeName.value;

                } else {
                    // Is standard matrix access
                    CodeBuilder codeBuilder_FieldAccess = fieldAccess_CodeGen.generate_FieldAccess(childAccess_Index, childAccessInfo,
                            childAccessGenInfo, intraMethod_ChildAccessExpr_Pairs__List, is_MatrixAccess);

                    codeBuilder_ChildAccess.append(codeBuilder_FieldAccess);
                    outVar_TypeString = fieldAccess_CodeGen.output_FieldType;
                    outVar_TypeSymbol = fieldAccess_CodeGen.output_FieldType_Symbol;
                    outValue_Default = fieldAccess_CodeGen.output_DefaultValue;

                }

            } else { // error, it's supposed to be single access, but the type of element accessed is a set.
                throw new Exception_MetaCompiler_IncorrectMatrixAccess("Was supposed be accessing a single element, but the type of elemented accessed is somehow set to return multiple elements.");
            }


            
        } else { // it's multi access

            DescriptorAccess_CodeGenerator__MultiAccess multiAccess_CodeGen = new DescriptorAccess_CodeGenerator__MultiAccess(symbolControl,
                    schemaControl, matrixControl, baseIndentLevel + 1, hierarchySettings, outputResults);
            multiAccess_CodeGen.set_1_AccessMethodClass_Name(accessMethodClass_Name);
            multiAccess_CodeGen.set_1_AnnotationInfo(annotationCall_CodeGen);
            multiAccess_CodeGen.set_1_CodeBuilders(codeBuildersList__AccessMethods_Static, codeBuildersList__AccessMethods_Dyn,
                    codeBuildersList__AccessMethods_All, codeBuilder_EmbeddedCode);
            multiAccess_CodeGen.set_1_Is_MatrixAccess_In_StaticMethod(is_MatrixAccess_In_StaticMethod);
            multiAccess_CodeGen.set_1_EmbeddedFile_ClassName(embeddedFile_ClassName);

            multiAccess_CodeGen.set_RootAccessSettings__OPTIONAL(rootAccessSettings);
            multiAccess_CodeGen.set_lastChildAccess__OPTIONAL(last_ChildAccessInfo);
            multiAccess_CodeGen.set_ParentAccessSettings__OPTIONAL(currAccessSettings);
            multiAccess_CodeGen.set_OutVarName(outVarName);
            multiAccess_CodeGen.set_AnnotationCall_CodeGen_Filters__OPTIONAL(annotationCall_CodeGen_Filters);

            multiAccess_CodeGen.set_ChildAccessInfos__OPTIONAL(childAccessInfo, prevChildAccessInfo);
            CodeBuilder codeBuilder_MultiAccess = multiAccess_CodeGen.generate_MultiAccess(childAccess_Index, 
                    childAccessGenInfo, intraMethod_ChildAccessExpr_Pairs__List, is_MatrixAccess);

            
            codeBuilder_ChildAccess.append(codeBuilder_MultiAccess);
            outVar_TypeString = multiAccess_CodeGen.outVar_TypeString;
            outVar_TypeSymbol = multiAccess_CodeGen.outVar_TypeSymbol;
            outValue_Default = multiAccess_CodeGen.output_DefaultValue;

        }



        if ((childAccessInfo.typeOfElementAccessed == DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.Field ||
             childAccessInfo.typeOfElementAccessed == DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.FieldValueSet) &&
                is_MatrixFieldAssignment) {
            accessResults.fieldAssign__AccessIsFieldAssign = true;
            accessResults.fieldAssign__codeBuilder_SetFieldCall = fieldAssign__codeBuilder_SetFieldCall;
            accessResults.fieldAccess__SpecializedFieldSet_FullTypeName = fieldAccess__SpecializedFieldSet_FullTypeName;
        }

        accessResults.childAccessCode_without_finalElseStmt = codeBuilder_ChildAccess;

        accessResults.outVarName = outVarName;
        accessResults.outVarName_ElementType = childAccessInfo.typeOfElementAccessed;
        accessResults.outVar_TypeString = outVar_TypeString;
        accessResults.outVar_TypeSymbol = outVar_TypeSymbol;
        accessResults.outValue_Default = outValue_Default;

        return accessResults;

    }




    private void setup_NextChildAccess(ExecutionInfo executeInfo, ChildAccess_AccessResults accessResults)
            throws Exception {

        prevAccessSettings = currAccessSettings;

        currAccessSettings = new DescriptorAccess_ChildAccessSettings();

        //  setup the parent descriptors for the next child
        currAccessSettings.parent_OutExpression = accessResults.outVarName;
        currAccessSettings.parent_OutExpression_Is_OutVar = true; // only the first access, to the matrix can be a expression. Afterwards, it can only be outvars

        //  determine the curr MatrixUsageType!
        currAccessSettings.determine_MatrixUsageDescriptor_Type(prevChildAccessInfo, prevAccessSettings, currChildAccessInfo,
                collecting_MatrixAccessState, is_ContinuedAccess);

        

        if (currChildAccessInfo.is_SingleAccess && currChildAccessInfo.is_StaticAccess && prevAccessSettings.has_ParentMatrixUsageDescriptor()) {

            if (currChildAccessInfo.typeOfElementAccessed == DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.Descriptor) {
                if (currChildAccessInfo.numberOfExpresions == 1) {

                    if (currChildAccessInfo.accessExpr1_Is_Static_DescTag) {

                        DescriptorAccess_CodeGenerator_Worker.matrixUsageStruct_GetDescriptor(executeInfo,
                            (DescriptorTag)currChildAccessInfo.accessExpr1_DescTagOrLabel_Actual,
                                currAccessSettings, prevAccessSettings.parent_DescriptorActual, (Descriptor)prevAccessSettings.parent_DescriptorFlattened);

                    } else if (currChildAccessInfo.accessExpr1_Is_Static_DescTagName) {

                        DescriptorAccess_CodeGenerator_Worker.matrixUsageStruct_GetDescriptor(executeInfo,
                            (DescriptorTagName)currChildAccessInfo.accessExpr1_DescTagOrLabel_Actual,
                                currAccessSettings, prevAccessSettings.parent_DescriptorActual, (Descriptor)prevAccessSettings.parent_DescriptorFlattened);

                        if (executeInfo.get_HadError()) {
                            if (executeInfo.containsError(ExecutionInfo.ErrorType.MoreThanOne_Item_Found))
                                throw new Exception_MetaCompilerError("You tried to do single access a descriptor using a static descriptor tag name:  " +
                                     currAccessSettings.parent_DescriptorActual.descTag.get_Name_no_backtiks() + "->" + currChildAccessInfo.accessExpr1_DescTagOrLabel_Actual.get_Name_no_backtiks() +
                                     ", but more than one descriptor was found for this descriptor. You may need to give the full descriptor name, or there may be multiple descriptors with this descriptor tag (try using multiple access). A last option is each child descriptor can be unique identified using a label. Add labels to your child descriptor and access by label." );
                            else
                                throw new Exception_MetaCompilerError("You tried to do single access a descriptor using a static descriptor tag name:  " +
                                     currAccessSettings.parent_DescriptorActual.descTag.get_Name_no_backtiks() + "->" + currChildAccessInfo.accessExpr1_DescTagOrLabel_Actual.get_Name_no_backtiks() +
                                     ", but had an error: " + executeInfo.getErrorMessage());

                        }
                    } else { // it's a static label
                        DescriptorAccess_CodeGenerator_Worker.matrixUsageStruct_GetDescriptor(executeInfo,
                            (Label)currChildAccessInfo.accessExpr1_DescTagOrLabel_Actual,
                                currAccessSettings, prevAccessSettings.parent_DescriptorActual, prevAccessSettings.parent_DescriptorFlattened);

                    }
                } else if (currChildAccessInfo.numberOfExpresions == 2) { //  must be a desc tag and a label. BUT! the label can be a static label, or a label expression.

                    if (currChildAccessInfo.accessExpr2_Is_Static_Label) {

                        if (currChildAccessInfo.accessExpr1_Is_Static_DescTag) {
                            DescriptorAccess_CodeGenerator_Worker.matrixUsageStruct_GetDescriptor(executeInfo,
                                (DescriptorTag)currChildAccessInfo.accessExpr1_DescTagOrLabel_Actual, (Label)currChildAccessInfo.accessExpr2_Label_Actual,
                                    currAccessSettings, prevAccessSettings.parent_DescriptorActual, prevAccessSettings.parent_DescriptorFlattened);

                        } else if (currChildAccessInfo.accessExpr1_Is_Static_DescTagName) {
                            DescriptorAccess_CodeGenerator_Worker.matrixUsageStruct_GetDescriptor(executeInfo,
                                (Label)currChildAccessInfo.accessExpr2_Label_Actual,
                                    currAccessSettings, prevAccessSettings.parent_DescriptorActual, prevAccessSettings.parent_DescriptorFlattened);
                        } else { // error
                            throw new Exception_InvalidArgumentPassed("doing static, single access with two accessors. The second one is a static label, but the first accessor was not either a descriptor tag or descriptor tagname.");
                        }

                        
                    } else {  // static descTag, dynamic label 
                        if (currChildAccessInfo.accessExpr1_Is_Static_DescTag) {
                            DescriptorAccess_CodeGenerator_Worker.matrixUsageStruct_GetDescriptorFlattened(executeInfo,
                                (DescriptorTag)currChildAccessInfo.accessExpr1_DescTagOrLabel_Actual,
                                    currAccessSettings, prevAccessSettings.parent_DescriptorActual, (Descriptor)prevAccessSettings.parent_DescriptorFlattened);
                        } else if (currChildAccessInfo.accessExpr1_Is_Static_DescTagName) {
                            DescriptorAccess_CodeGenerator_Worker.matrixUsageStruct_GetDescriptorFlattened(executeInfo,
                                (DescriptorTagName)currChildAccessInfo.accessExpr1_DescTagOrLabel_Actual,
                                    currAccessSettings, prevAccessSettings.parent_DescriptorActual, (Descriptor)prevAccessSettings.parent_DescriptorFlattened);
                        } else { // error
                            throw new Exception_InvalidArgumentPassed("doing static, single access with two accessors. The second one is a _dynamic_ label, but the first accessor was not either a descriptor tag or descriptor tagname.");
                        }
                    }
                    if (executeInfo.get_HadError())
                        throw new Exception_MetaCompilerError("Error while trying to get the descriptorFlattened for the current access: " + executeInfo.getErrorInfo().toString());

                } else { // error
                    throw new Exception_InvalidArgumentPassed("Expected either one or two access arguments (such as one DescriptorTagName or a DescriptorTagName and a Label), but had " + currChildAccessInfo.numberOfExpresions + " of them.");
                }

                currAccessSettings.determine_HaveParentMatrixUsageDescriptor();
                if (!currAccessSettings.has_ParentMatrixUsageDescriptor()) {

                    String_Mutable parentAccessExpr = new String_Mutable();
                    String_Mutable childAccessExpr = new String_Mutable();
                    determineParentAndChildExpr(parentAccessExpr, childAccessExpr);

                    throw new Exception_Descriptor("Could not find the child descriptor, " + childAccessExpr.value
                            + ", in the parent descriptor, " + parentAccessExpr.value + ".");
                }

            } else { //  This is field access
                //  Don't need to do any setup with the parent_DescriptorActual parents, because there are no more children to access.

            }


        } else { //  Is dynamic access
            currAccessSettings.clearAll_ParentMatrixUsageDescriptor_Settings();
        }


    }


    private void determineParentAndChildExpr(String_Mutable parentAccessExpr_OUT, String_Mutable childAccessExpr_OUT) {

        String parentDescTag = "<unknown>";
        String parentLabel = null;
        try {
            parentDescTag = currAccessSettings.parent_DescriptorActual.descTag.get_Name_no_backtiks();
            parentAccessExpr_OUT.value = parentDescTag;
            if (currAccessSettings.parent_DescriptorActual.has_Label()) {
                parentLabel = currAccessSettings.parent_DescriptorActual.label.getLabel_Simple();
                parentAccessExpr_OUT.value += " " + parentLabel;
            }
        } catch(Exception e) { }
        if (parentAccessExpr_OUT.value == null)
            parentAccessExpr_OUT.value = "<unknown>";

        String childAccessorExpr1 = "<unknown>";
        String childAccessorExpr2 = null;
        try {
            childAccessorExpr1 = currChildAccessInfo.accessExpr1_DescTagOrLabel_Actual.get_Name_no_backtiks();
            childAccessExpr_OUT.value = childAccessorExpr1;
            if (currChildAccessInfo.accessExpr2_Exists) {
                childAccessorExpr2 = currChildAccessInfo.accessExpr2_Label_Actual.getLabel_Simple();
                childAccessExpr_OUT.value += " " + childAccessorExpr2;
            }
        } catch(Exception e) {}
        
        if (childAccessExpr_OUT.value == null)
            childAccessExpr_OUT.value = "<unknown>";
    }


    
    //  __________________________________________________________________________________________________________________________________________
    //
    //    Post Generation Methods
    //  __________________________________________________________________________________________________________________________________________

    public MatrixAccessState postGen__create_MatrixAccessState() {
        MatrixAccessState matrixAccessState = new MatrixAccessState();

        matrixAccessState.lastAccessSettings = currAccessSettings;
        return matrixAccessState;
    }

    /** this is the access number found in the matrix-access method name. */
    public int postGen__getMethodAccessNumber() {
        return OUT_methodAccessNumber;
    }




    //  __________________________________________________________________________________________________________________________________________
    //
    //    Private Helper Methods
    //  __________________________________________________________________________________________________________________________________________


    private Matrix findMatrix_byClassNameFull() throws Exception_MetaCompiler_IncorrectMatrixAccess {

        Matrix matrix = null;

        //  First, try to find it by the full matrix name
        matrixName = rootAccessorExpr.trim();
        matrix = matrixControl.findStaticMatrix_ByClassNameFull(matrixName);


        if (matrix == null && matrixPackage_Index_bySimpleName != null) {
            //  Second, try to matrix package list
            Collection foundMatrices = matrixPackage_Index_bySimpleName.getCollection(matrixName);

            //  Third, it could be a simple name with the current package as its default package
            String matrixName_CurrentPackage = packageName + "::" + matrixName;
            Collection defaultPackages_FoundMatrices = matrixPackage_Index_bySimpleName.getCollection(matrixName_CurrentPackage);
            // it's a name conflict if it matrices exist in the default package and the matrix package declarations, so add the find results together
            foundMatrices.addAll(defaultPackages_FoundMatrices);


            if (foundMatrices != null) {
                if (foundMatrices.size() == 1) {
                    matrix = (Matrix)foundMatrices.iterator().next();

                } else if (foundMatrices.size() == 0) {
                    matrix = null;

                } else {
                    //  Name conflict, throw error
                    throw new Exception_MetaCompiler_IncorrectMatrixAccess(
                        "Name conflict. You are accessing a matrix by its simple name, but there are " + foundMatrices.size() +
                        " matrices that it could belong to. The name of the matrix you tried to access is, " + matrixName + ", and the possible matrices" +
                        " that match are: " + ListUtilities.print(new ArrayList(foundMatrices)));

                }

            } else {
                matrix = null;
            }
        }

        return matrix;
    }



    

    private static void handle_ChildAccessException(Exception e, DescriptorAccess_ChildAccessInfo childAccessInfo, String optionalMatrixName)
        throws Exception_MetaCompilerError {
        
        String matrixNameText = (optionalMatrixName != null && optionalMatrixName.length() > 0) ? " the Matrix, " + optionalMatrixName :
                                            " a Matrix";
        String DescriptorOrFieldSet = (childAccessInfo.typeOfElementAccessed ==
                DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.Descriptor) ? "Descriptor" : "FieldSet";
        String accessText = "";
        if (childAccessInfo.accessExpr1_Is_Static_DescTag)
            accessText = "The descriptor tagname for this access was, " + getAccessExprStringForHandleError(1, childAccessInfo) + ".";
        else if (childAccessInfo.accessExpr1_Is_Static_Label)
            accessText = "The label for this access was, " + getAccessExprStringForHandleError(1, childAccessInfo) + ".";
        else
            accessText = "The first expression for this access was, '" + getAccessExprStringForHandleError(1, childAccessInfo) + ".";

        if (childAccessInfo.numberOfExpresions == 2) {
            if (childAccessInfo.accessExpr2_Is_Static_Label)
                accessText += " The label for this access was, " + getAccessExprStringForHandleError(2, childAccessInfo) + ".";
            else
                accessText += " The label expression for this access was, '" + getAccessExprStringForHandleError(2, childAccessInfo) + "'.";
        }

        throw new Exception_MetaCompilerError("Tried to generate child access code for " + matrixNameText +
                ", but had a problem doing a static access of the matrix (** SEE INNER EXCEPTION). Was accessing a child " +
                DescriptorOrFieldSet + ". " + accessText, e);
    }

    /**
     * Try to get the symbol output string. If you can't, return the pure access expression.
     * @return
     */
    private static String getAccessExprStringForHandleError(int accessExprNumber, DescriptorAccess_ChildAccessInfo curr_ChildAccessInfo) {

        Symbol_Base currSymbol = null;
        String currAccessExpr = null;
        boolean currAccessExprIsLabel = false;

        String outputAccessExprString = null;


        if (accessExprNumber == 1) {
            currSymbol = curr_ChildAccessInfo.accessExpr1_DescTagOrLabel_Actual;
            currAccessExpr = curr_ChildAccessInfo.accessExpr1;
            currAccessExprIsLabel = curr_ChildAccessInfo.accessExpr1_Is_Static_Label;
        } else {
            currSymbol = curr_ChildAccessInfo.accessExpr2_Label_Actual;
            currAccessExpr = curr_ChildAccessInfo.accessExpr2;
            currAccessExprIsLabel = true;
        }

        if (currAccessExpr != null) {
            try {
                if (currAccessExprIsLabel)
                    outputAccessExprString = ((Label)currSymbol).getLabel_Simple();
                else
                    outputAccessExprString = currSymbol.getName();
            } catch (Exception e) {
                outputAccessExprString = currAccessExpr;
            }
        } else
            outputAccessExprString = currAccessExpr;


        return outputAccessExprString;
    }










    class ChildAccess_AccessResults {
        CodeBuilder childAccessCode_without_finalElseStmt;
        
        String outVarName;
        DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed outVarName_ElementType;
        String outVar_TypeString;
        Symbol outVar_TypeSymbol;
        String outValue_Default;

        
        boolean         fieldAssign__AccessIsFieldAssign;
        CodeBuilder     fieldAssign__codeBuilder_SetFieldCall;
        String          fieldAccess__SpecializedFieldSet_FullTypeName;
    }



}
