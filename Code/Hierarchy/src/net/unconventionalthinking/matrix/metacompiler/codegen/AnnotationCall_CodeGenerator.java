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
import net.unconventionalthinking.lang.Pair;
import net.unconventionalthinking.matrix.metacompiler.codefilegen.AnnotationsInterface_FileGenerator;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import java.util.List;

/**
 *
 * @author peterjoh
 */
public abstract class AnnotationCall_CodeGenerator {


    AnnotationsCodeGenerator_Control annotationsCodeGenerator_Control;
    HierarchySettings hierarchySettings;
    AnnotationsInterface_FileGenerator annotationInterface_FileGen;

    public AnnotationCall_CodeGenerator(HierarchySettings hierarchySettings, AnnotationsInterface_FileGenerator annotationInterface_FileGen,
            AnnotationsCodeGenerator_Control annotationsCodeGenerator_Control) {
        this.hierarchySettings = hierarchySettings;
        this.annotationInterface_FileGen = annotationInterface_FileGen;
        this.annotationsCodeGenerator_Control = annotationsCodeGenerator_Control;
    }



    public abstract void starting_NewAccess();

    public abstract void determine_AnotationRef(DescriptorAccess_ChildAccessInfo childAccessInfo, int childAccess_Index) throws Exception_MetaCompilerError;

    public abstract CodeBuilder generateCall(CodeBuilder codeBuilder, int childIndex,
            String matrix_OutExpression, String parentDescriptor_OutVar, String currDesc_OutVarName, DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed typeOfMatrixAccess,
            Symbol accessValue_Type, boolean is_Continuation_Field_Access, boolean is_MultiAccess, boolean prevAccess_isMultiAccess,
            boolean is_MatrixAccess_In_StaticMethod, String embeddedFile_ClassName,
            List<Pair<String, String>> childAccessPairs_List);

    public abstract CodeBuilder generateCall(CodeBuilder codeBuilder, int childIndex,
            String matrix_OutExpression, String parentDescriptor_OutVar, String currDesc_OutVarName, DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed typeOfMatrixAccess,
            Symbol accessValue_Type, boolean is_Continuation_Field_Access, boolean is_MultiAccess, boolean prevAccess_isMultiAccess,
            boolean is_MatrixAccess_In_StaticMethod, String embeddedFile_ClassName,
            List<Pair<String, String>> childAccessPairs_List, boolean passInException, String exceptionObj_OutVarName);




    public String get_AnnotationInterfaceName() { return annotationInterface_FileGen.get_InterfaceName(); }

}
