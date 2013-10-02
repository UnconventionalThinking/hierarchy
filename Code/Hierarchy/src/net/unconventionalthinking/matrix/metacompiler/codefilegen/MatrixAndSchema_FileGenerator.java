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

package net.unconventionalthinking.matrix.metacompiler.codefilegen;


import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null;
import net.unconventionalthinking.lang.Pair;
import net.unconventionalthinking.matrix.metacompiler.codegen.CodeGen_OutputResults;
import net.unconventionalthinking.matrix.metacompiler.codegen.DescriptorCodeGenerator_Utilities;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.utilities.FileUtilities;
import net.unconventionalthinking.matrix.utilities.TextUtilities;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import java.io.IOException;
import java.util.List;

/**
 * This fileGenerator remembers the parts of the code that were generated. The reason this is important is because you can call the
 * _2_addCode_SchemaClass(), and the call writeFile() to create the file. And then later, with the same fileGen object,
 * call _3_addCode_MatrixMethods(), adding in the matrix access code, and call writeFile() to regenerate the file.
 *
 * @author peterjoh
 */
public class MatrixAndSchema_FileGenerator extends FileGenerator_Base {

    private CodeBuilder codeBuilder_MatrixConstruction;
    private CodeBuilder codeBuilder_MatrixConstructionEnd;
    private CodeBuilder codeBuilder_MatrixMethods;

    private Label  schemaOrMatrixNameLabel;
    private String schemaOrMatrixNameString;


    
    /**
     * Pass in the metacompiler generator matrix build code.
     * @param matrixConstructionCode
     */
    public MatrixAndSchema_FileGenerator(SymbolControl symbolControl) {
        super(symbolControl);

        this.add_AppClassesImports = true;

    }


    public void _1_set_SchemaOrMatrixNameLabel(List<String> schemaOrMatrixName_Parts, int label_CreationStartLevel)
        throws Exception_MetaCompilerError {

        try {
            Pair<Label, String> labelInfo = DescriptorCodeGenerator_Utilities.createLabelAndLabelString(schemaOrMatrixName_Parts, 
                    label_CreationStartLevel, symbolControl);
            schemaOrMatrixNameLabel = labelInfo.first;
            schemaOrMatrixNameString = labelInfo.second;

        } catch (Exception e) {
            throw new Exception_MetaCompilerError("As we were building the matrix class file, we could not create the label", e);
        }

    }

    public void _1_setCode_MatrixConstruction(CodeBuilder matrixConstructionCode) {
        this.codeBuilder_MatrixConstruction = matrixConstructionCode;
    }

    public void _2_addCode_SchemaClass(String schemaSetScopeStack_OutVarName, String schema_OutVarName, String appControl_OutVarName,
            CodeGen_OutputResults outputResults)
            throws Exception_MetaCompilerError {

        generate_ImportSection(outputResults);
        codeBuilder_ClassStart = new CodeBuilder();
        codeBuilder_MatrixConstructionEnd = new CodeBuilder();
        codeBuilder_ClassEnd = new CodeBuilder();



        codeBuilder_ClassStart.append("\n\n\n\n" +
            "public class " + schemaOrMatrixNameLabel.getSymbol().name_IdentFormat + " implements SchemaContainer {\n\n" +

            "\tpublic static SchemaInfo_Schema schema;\n\n\n" +


            "\tpublic static SchemaInfo_Schema construct(AppControl_Base " + appControl_OutVarName +  ", ExecutionInfo executeInfo)\n" +
            "\t\tthrows Exception_MatrixRuntime_Checked {\n\n" +

            "\t\tLinkedList<MatrixSet<SchemaInfo_Schema>> " + schemaSetScopeStack_OutVarName + " = new LinkedList<MatrixSet<SchemaInfo_Schema>>();\n\n");



        codeBuilder_MatrixConstructionEnd.append("\n\t\t//  Initialize the Schema:\n");
        codeBuilder_MatrixConstructionEnd.append("\t\ttry {\n");
        codeBuilder_MatrixConstructionEnd.append("\t\t\t((SchemaInfo_Descriptor)" + schema_OutVarName + ").initialize_SchemaInfo(executeInfo, " +
                appControl_OutVarName + ".symbolControl, " + appControl_OutVarName +  ".schemaControl.schemaControl_Info);\n\n");
        codeBuilder_MatrixConstructionEnd.append("\t\t} catch (Exception_SchemaInfo e) {\n");
        codeBuilder_MatrixConstructionEnd.append("\t\t\tthrow new Exception_MatrixRuntime_Checked(\"Tried to initialize the Schema named, " + schemaOrMatrixNameLabel.getSymbol().name_IdentFormat +
                 ", but had an error.\", e);\n");
        codeBuilder_MatrixConstructionEnd.append("\t\t}\n");

        codeBuilder_MatrixConstructionEnd.append("\t\tschema = (SchemaInfo_Schema)" + schema_OutVarName + ";\n\n");

        codeBuilder_MatrixConstructionEnd.append("\t\treturn (SchemaInfo_Schema)" + schema_OutVarName + ";\n")
                .append("\t}\n\n");

        add_MatrixContainerMethods();

        codeBuilder_ClassEnd
                .append("}\n");

    }


    public void _2_addCode_MatrixClass(String schemaSetScopeStack_OutVarName, String matrix_OutVarName, CodeGen_OutputResults outputResults)
            throws Exception_MetaCompilerError {


        generate_ImportSection(outputResults);
        codeBuilder_ClassStart = new CodeBuilder();
        codeBuilder_MatrixConstructionEnd = new CodeBuilder();
        codeBuilder_ClassEnd = new CodeBuilder();

        
        codeBuilder_ClassStart.append("\n\n\n\n" +
            "public class " + schemaOrMatrixNameLabel.getSymbol().name_IdentFormat + " implements MatrixContainer {\n\n" +

            "\tpublic static Matrix matrix;\n\n\n" +

            
            "\tpublic static Matrix construct(AppControl_Base appControl, ExecutionInfo executeInfo)\n" +
            "\t\tthrows Exception_MatrixRuntime_Checked {\n\n" +

            "\t\tLinkedList<MatrixSet<SchemaInfo_Schema>> " + schemaSetScopeStack_OutVarName + " = new LinkedList<MatrixSet<SchemaInfo_Schema>>();\n");




        codeBuilder_MatrixConstructionEnd.append("\t\tmatrix = (Matrix)" + matrix_OutVarName + ";\n\n");

        codeBuilder_MatrixConstructionEnd.append("\t\treturn (Matrix)" + matrix_OutVarName + ";\n")
                .append("\t}\n\n");

        add_MatrixContainerMethods();
        
        codeBuilder_ClassEnd
                .append("}\n");

    }


    void add_MatrixContainerMethods() {

        String appControl_FullName = appControl_PackageName + '.' + appClassName;

        codeBuilder_ClassEnd

            .append("\tpublic Class<?> get_AppControl_Class() throws ClassNotFoundException {\n")
            .append("\t\treturn ").append(appControl_FullName).append(".class;\n")
            .append("\t}\n")


            .append("\tpublic AppControl_Base initialize_AppControl() { return initialize_AppControl(null, false); }\n")
            .append("\tpublic AppControl_Base initialize_AppControl(boolean running_AppControl_forMetacompilation) { return initialize_AppControl(null, running_AppControl_forMetacompilation); }\n")
            .append("\tpublic AppControl_Base initialize_AppControl(AppControl_Base existing_AppControl) { return initialize_AppControl(existing_AppControl, false); }\n")
            .append("\tpublic AppControl_Base initialize_AppControl(AppControl_Base existing_AppControl, boolean running_AppControl_forMetacompilation) {\n")
            .append("\t\tif (existing_AppControl != null)\n")
            .append("\t\t\treturn ").append(appControl_FullName).append(".initializeApp(existing_AppControl, running_AppControl_forMetacompilation);\n")
            .append("\t\telse\n")
            .append("\t\t\treturn ").append(appControl_FullName).append(".initializeApp(running_AppControl_forMetacompilation);\n")
            .append("\t}\n\n")

            .append("\tpublic AppControl_Base get_AppControl() {\n")
            .append("\t\treturn ").append(appControl_FullName).append(".appControl").append(";\n")
            .append("\t}\n\n");
        
    }



    public void _3_addCode_MatrixMethods(CodeBuilder codeBuilder_MatrixAccessMethods, CodeGen_OutputResults outputResults) {

        generate_ImportSection(outputResults);

        this.codeBuilder_MatrixMethods = codeBuilder_MatrixAccessMethods;
    }





    @Override
    public String writeToFile(boolean autoFlushBufferForDebug) throws IOException {
        codeBuilder_fullCode = new CodeBuilder();
        className = schemaOrMatrixNameLabel.getSymbol().name_IdentFormat;
        fileName = className + ".java";

        codeBuilder_fullCode.append(codeBuilder_ImportSection);
        codeBuilder_fullCode.append(codeBuilder_ClassStart);
        codeBuilder_fullCode.append(codeBuilder_MatrixConstruction);
        codeBuilder_fullCode.append(codeBuilder_MatrixConstructionEnd).append("\n");
        codeBuilder_fullCode.append(codeBuilder_MatrixMethods).append("\n\n");
        codeBuilder_fullCode.append(codeBuilder_ClassEnd);

        
        FileUtilities.makeDir(fileDirPath, true);
        FileUtilities.writeToFile(fileDirPath, fileName, true,
                codeBuilder_fullCode.toString(), autoFlushBufferForDebug);

        return fileName;
    }






}
