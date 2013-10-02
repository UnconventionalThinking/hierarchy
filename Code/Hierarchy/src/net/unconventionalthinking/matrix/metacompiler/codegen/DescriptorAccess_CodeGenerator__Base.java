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
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.lang.Pair;
import net.unconventionalthinking.matrix.Descriptor;
import net.unconventionalthinking.matrix.ExceptRuntime_MatrixAccessError;
import net.unconventionalthinking.matrix.ExceptRuntime_Matrix_GeneralError;
import net.unconventionalthinking.matrix.MatrixControl;
import net.unconventionalthinking.matrix.SchemaControl;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.matrix.symbols.Symbol_Single;
import net.unconventionalthinking.matrix.utilities.TypeUtilities;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import net.unconventionalthinking.utilities.LanguageUtilities;
import java.util.List;

/**
 * Matrix Access in Static Methods:
 * ____________________________________________________________________________________________________________________________________________
 * If you have a matrix access in a static method:
 *   private static void myStaticMethod() {
 *       MyMatrix->MY.DESC:>Myfield;
 *   }
 * then the descriptorAccess_CodeGen will need to do a few things a little different. The reasons is Annotations for static methods need to be
 * able to access the static members of the class. So, the generated annotation-methods need to be static methods instead of regular members
 * of the instance. Because of this, in the generated Java files for the embedded class, a few things need to be done differently.
 * For a matrix access in a static method:
 *   1. The annotation method on the embedded class must be static:
 *   	public <b>static</b> Object annotationHandler_6(ExecutionInfo executeInfo ...)
 *
 *   2. The matrixAccess method in the matrix worker shouldn't use the callerObj to call the annotation method handler, it should
 *      use the class name (because, as we just mentioned, the annotation method is static now)
 *
 *   3. We shouldn't add the annotation method to the annotation interface.
 *
 * The passed-in value we use to determine if this is a "matrix access in a static access" is: is_MatrixAccess_In_StaticMethod.
 * 
 * @author peterjoh
 */
public abstract class DescriptorAccess_CodeGenerator__Base {

    SymbolControl   symbolControl;
    SchemaControl   schemaControl;
    MatrixControl   matrixControl;
    ExecutionInfo   executeInfo;

    HierarchySettings hierarchySettings;
    CodeGen_OutputResults outputResults;

    int             baseIndentLevel;
    String          baseIndent;

    String          embeddedFile_ClassName;
    String          accessMethodClass_Name;

    boolean         is_MatrixAccess_In_StaticMethod;
    
    AnnotationCall_CodeGenerator_Std        annotationCall_CodeGen;
    AnnotationCall_CodeGenerator_Filters    annotationCall_CodeGen_Filters;


    DescriptorAccess_ChildAccessSettings    rootAccessSettings;
    String                                  root_AccessMethodCall_RootAccessorValue;  // this is only used for dynamic access
    boolean                                 firstAccess_Is_Static;

    DescriptorAccess_ChildAccessSettings    currAccessSettings;
    DescriptorAccess_ChildAccessInfo        currChildAccessInfo;
    DescriptorAccess_ChildAccessSettings    prevAccessSettings;
    DescriptorAccess_ChildAccessInfo        prevChildAccessInfo;
    DescriptorAccess_ChildAccessInfo        last_ChildAccessInfo;



    List<CodeBuilder>   codeBuildersList__AccessMethods_Static;
    List<CodeBuilder>   codeBuildersList__AccessMethods_Dyn;
    List<CodeBuilder>   codeBuildersList__AccessMethods_All;
    CodeBuilder         codeBuilder_EmbeddedCode;



    
    public DescriptorAccess_CodeGenerator__Base(SymbolControl symbolControl, SchemaControl schemaControl, MatrixControl matrixControl, int baseIndentLevel,
            HierarchySettings hierarchySettings, CodeGen_OutputResults outputResults) {
        this.symbolControl = symbolControl;
        this.schemaControl = schemaControl;
        this.matrixControl = matrixControl;

        this.baseIndent = "";
        for (int i = 0; i < baseIndentLevel; ++i) {
            baseIndent += "\t";
        }

        this.hierarchySettings = hierarchySettings;
        this.outputResults = outputResults;
        executeInfo = new ExecutionInfo();

        this.rootAccessSettings = new DescriptorAccess_ChildAccessSettings();
        this.currAccessSettings = new DescriptorAccess_ChildAccessSettings();

    }

    public void set_1_EmbeddedFile_ClassName(String embeddedFile_ClassName) { this.embeddedFile_ClassName = embeddedFile_ClassName; }
    public void set_1_AccessMethodClass_Name(String accessMethodClass_Name) { this.accessMethodClass_Name = accessMethodClass_Name; }
    /**
     * Set whether this descriptor access is inside of a static method. For instance:
     *
     * private static void myStaticMethod() {
     *     MyMatrix->MY.DESC:>Myfield;
     * }
     *
     * For more information, see the above Javadoc. Specifically, the section on "matrix access in static methods"
     */
    public void set_1_Is_MatrixAccess_In_StaticMethod(boolean is_MatrixAccess_In_StaticMethod) {
        this.is_MatrixAccess_In_StaticMethod = is_MatrixAccess_In_StaticMethod;
    }

    public void set_1_CodeBuilders(List<CodeBuilder> codeBuildersList__AccessMethods_Static, List<CodeBuilder> codeBuildersList__AccessMethods_Dyn,
            List<CodeBuilder> codeBuildersList__AccessMethods_All, CodeBuilder codeBuilder_EmbeddedCode) {

        this.codeBuildersList__AccessMethods_Static = codeBuildersList__AccessMethods_Static;
        this.codeBuildersList__AccessMethods_Dyn = codeBuildersList__AccessMethods_Dyn;
        this.codeBuildersList__AccessMethods_All = codeBuildersList__AccessMethods_All;
        this.codeBuilder_EmbeddedCode = codeBuilder_EmbeddedCode;
    }

    public void set_1_AnnotationInfo(AnnotationCall_CodeGenerator_Std annotationCall_CodeGen) { this.annotationCall_CodeGen = annotationCall_CodeGen; }


    //
    //  These OPTIONAL settings are mainly used to pass information to the child objects of DescriptorAccess_CodeGen, like the DescriptorAccess_CodeGen_Field
    public void set_RootAccessSettings__OPTIONAL(DescriptorAccess_ChildAccessSettings rootAccessSettings) { this.rootAccessSettings = rootAccessSettings; }
    public void set_ParentAccessSettings__OPTIONAL(DescriptorAccess_ChildAccessSettings parentAccessSettings) { this.currAccessSettings = parentAccessSettings; }
    public void set_ChildAccessInfos__OPTIONAL(DescriptorAccess_ChildAccessInfo currChildAccessInfo, DescriptorAccess_ChildAccessInfo prevChildAccessInfo) {
        this.currChildAccessInfo = currChildAccessInfo;
        this.prevChildAccessInfo = prevChildAccessInfo;
    }
    public void set_lastChildAccess__OPTIONAL(DescriptorAccess_ChildAccessInfo last_ChildAccessInfo) { this.last_ChildAccessInfo = last_ChildAccessInfo;}

    /** only used by multi-access */
    public void set_AnnotationCall_CodeGen_Filters__OPTIONAL(AnnotationCall_CodeGenerator_Filters annotationCall_CodeGen_Filters) {
        this.annotationCall_CodeGen_Filters = annotationCall_CodeGen_Filters;
    }

    
    void generate_AccessChildCode_AccessErrorCode(CodeBuilder codeBuilder, boolean is_FieldAccess, boolean is_SingleAccess,
            boolean is_MatrixAccess, Symbol accessValue_Type, int childAccess_Index,
            DescriptorAccess_ChildAccessInfo childAccessInfo,
            List<Pair<String, String>> intraMethod_ChildAccessExpr_Pairs__List,
            String outVarName)
            throws Exception_MetaCompilerError {


        boolean is_SingleFieldAccess = (is_SingleAccess && is_FieldAccess);
        boolean prevAccessIsMultiAccess = (!is_SingleFieldAccess && prevChildAccessInfo != null && !prevChildAccessInfo.is_SingleAccess);

        String indent = (is_SingleFieldAccess) ? baseIndent : baseIndent + '\t';
        String annotateRetVal_Type = (accessValue_Type != null) ? accessValue_Type.name
                : "Object";  // dynamic field access

        annotationCall_CodeGen.determine_AnotationRef(childAccessInfo, childAccess_Index);



        codeBuilder.append(baseIndent + "\t// Error handling code\n");

        if (!is_SingleFieldAccess) {
            codeBuilder.append(indent + "if (executeInfo.get_HadError()) {\n");
        }

        codeBuilder
            .append(indent + "\tAnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();\n")
            .append(indent + "\tObject annotateRetVal = "
                + annotationCall_CodeGen.generateCall(null, childAccess_Index,
                rootAccessSettings.parent_OutExpression, currAccessSettings.parent_OutExpression, outVarName, childAccessInfo.typeOfElementAccessed,
                accessValue_Type, childAccessInfo.accessExpr2_Is_ContinuationIndex, !is_SingleAccess, prevAccessIsMultiAccess,
                is_MatrixAccess_In_StaticMethod, embeddedFile_ClassName,
                intraMethod_ChildAccessExpr_Pairs__List, true, "executeInfo.getErrorException()")
                + ";\n\n")
            .append(indent + "\tif (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) \n")
            .append(indent + "\t\tthrow new " + ExceptRuntime_MatrixAccessError.class.getSimpleName() + "(\"Was trying the "
                + LanguageUtilities.convertNumIntoOrderingString(childAccess_Index + 1) + " access of the "
                + (is_MatrixAccess ? "Matrix" : "Schema")
                + (rootAccessSettings.parent_OutExpression_Is_OutVar ? (" named " + rootAccessSettings.parent_OutExpression)
                : ", with the matrix access expression (" + rootAccessSettings.parent_OutExpression + ")")
                + " but had an error. The annotation handler tried to process this error but was not able to.\");\n");


        if (!is_SingleFieldAccess) {
            codeBuilder.append("\n")
                .append(indent + "\tif (accessReturnType_OutParam != null && "
                    + "accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)\n")
                .append(indent + "\t\t" + outVarName + " = (" + accessValue_Type.name + ")annotateRetVal;\n")
                .append(indent + "\telse // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)\n");
            // NOTE ** final return of annote value is done at Code creation loop, so descriptors access that hit an annotation and return a full
            // access value can be cast to the field type
            //            return annotateRetVal;\n");

        } else {
            codeBuilder.append("\n");
            // NOTE ** final return of annote value is done at Code creation loop, so descriptors access that hit an annotation and return a full
            // access value can be cast to the field type
            //            return annotateRetVal;\n");
        }




    }

    public List<CodeBuilder> getCodeBuildersList__AccessMethods_All() {
        return codeBuildersList__AccessMethods_All;
    }

    public List<CodeBuilder> getCodeBuildersList__AccessMethods_Dyn() {
        return codeBuildersList__AccessMethods_Dyn;
    }

    public List<CodeBuilder> getCodeBuildersList__AccessMethods_Static() {
        return codeBuildersList__AccessMethods_Static;
    }

    public CodeBuilder getCodeBuilder_EmbeddedCode() {
        return codeBuilder_EmbeddedCode;
    }
}
