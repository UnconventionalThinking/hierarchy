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
import net.unconventionalthinking.matrix.metacompiler.codefilegen.AnnotationsInterface_FileGenerator;
import net.unconventionalthinking.matrix.AnnotationParameters;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author peterjoh
 */
public class AnnotationHandler_CodeGenerator_MethodGen_Std extends AnnotationHandler_CodeGenerator_MethodGen {



    
    public AnnotationHandler_CodeGenerator_MethodGen_Std(HierarchySettings hierarchySettings, int baseIndentLevel, 
            AnnotationsCodeGenerator_Control annotationsCodeGenerator_Control) {
        super(annotationsCodeGenerator_Control, baseIndentLevel, hierarchySettings);
    }

    @Override
    public void add_CodeForAnnotationHandler(int annotationMethodIndex, CodeBuilder code, boolean is_MatrixAccess_In_StaticMethod) {
        annotationsCodeGenerator_Control.annotationCode_ByAnnotationMethodIndex__Std.put(new Integer(annotationMethodIndex), 
                new AnnotationHandler_CodeGenerator_MethodGenInfo(code, is_MatrixAccess_In_StaticMethod));

    }


    @Override
    public CodeBuilder generate_AnnotationHandlers(AnnotationsInterface_FileGenerator annotationsInterface_FileGen){

        CodeBuilder codeBuilder = new CodeBuilder();

        Iterator<Entry<Integer, AnnotationHandler_CodeGenerator_MethodGenInfo>> annotationCode_Iterator
                = annotationsCodeGenerator_Control.annotationCode_ByAnnotationMethodIndex__Std.entrySet().iterator();

        while (annotationCode_Iterator.hasNext()) {
            Entry<Integer, AnnotationHandler_CodeGenerator_MethodGenInfo> annotationEntry = annotationCode_Iterator.next();
            int annotationIndex = annotationEntry.getKey().intValue();
            AnnotationHandler_CodeGenerator_MethodGenInfo annotationMethodGen_Info = annotationEntry.getValue();
            CodeBuilder annotationCode = annotationMethodGen_Info.annotationCodeBuilder;


            String annotationHandler_Signature =
                "public " +
                (annotationMethodGen_Info.is_MatrixAccess_In_StaticMethod ? "static " : "")
                + " Object " + CodeConstants.OutMethodName_AnnotationMethod_Suffix + annotationIndex +
                "(ExecutionInfo executeInfo, \n" +
                baseIndent + "\tboolean annotationReference_Exists, Symbol annotationRef_Base, int annotationRef_AccessCounter,\n" +
                baseIndent + "\tint childAccessIndex, AnnotationParameters.AccessType accessType, AnnotationParameters_AccessReturnType_OutParam " +
                                                        hierarchySettings.accessReturnTypeOutParam_ParamName + ", \n" +
                baseIndent + "\tDescriptor rootAccessDescriptor, Descriptor currAccessors_ParentDescriptor, MatrixSet<Descriptor> currAccessors_ParentDescriptorSet, \n" +
                baseIndent + "\tboolean passingInException, Exception e, Pair<Object, Object>... childAccessor_Pairs)";
            codeBuilder
                .append(baseIndent).append(annotationHandler_Signature).append(" {\n\n");

            if (annotationCode != null)
                codeBuilder.append(annotationCode);
            else
                codeBuilder.append(baseIndent + "\treturn null;\n");

            codeBuilder.append("\n" + baseIndent + "}\n\n");


            
            //  create annotation interface method
            //  Static methods don't need to be apart of the annotation's interface (because, static annotation methods are not called through
            //  the caller object
            if (!annotationMethodGen_Info.is_MatrixAccess_In_StaticMethod)
                annotationsInterface_FileGen._1_add_AnnotationMethodSignature(AnnotationType.STANDARD, annotationIndex, annotationHandler_Signature + ";");
            
        }

        return codeBuilder;
    }




}
