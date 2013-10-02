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

import net.unconventionalthinking.matrix.metacompiler.codegen.*;
import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.matrix.metacompiler.codegen.CodeGen_OutputResults;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.utilities.FileUtilities;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import java.io.IOException;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author peterjoh
 */
public class AnnotationsInterface_FileGenerator extends FileGenerator_Base {


    private CodeBuilder codeBuilder_AnnotationMethods_Full;

    private String interfaceName;

    private Map<AnnotationType, Set<Integer>> annotationMethodIndexes;

    /**
     * Pass in the metacompiler generator matrix build code.
     * @param matrixConstructionCode
     */
    public AnnotationsInterface_FileGenerator(SymbolControl symbolControl) {
        super(symbolControl);

        codeBuilder_AnnotationMethods_Full = new CodeBuilder();
        annotationMethodIndexes = new EnumMap<AnnotationType, Set<Integer>>(AnnotationType.class);

        super.add_AppClassesImports = false;
    }


    public void _1_set_InterfaceName(String embeddedFile_ClassName) {

        this.interfaceName = generateInterfaceName(embeddedFile_ClassName);
    }

    public void _1_add_AnnotationMethodSignature(AnnotationType annotateType, int annotationMethodIndex, CodeBuilder codeBuilder_AnnotationMethods) {

        _1_add_AnnotationMethodSignature(annotateType, annotationMethodIndex, codeBuilder_AnnotationMethods.toString());

    }

    public void _1_add_AnnotationMethodSignature(AnnotationType annotateType, int annotationMethodIndex, String annotationMethods_String) {
        Set<Integer> annotationMethodsIndex_forAnnoteType = annotationMethodIndexes.get(annotateType);

        if (annotationMethodsIndex_forAnnoteType == null) {
            annotationMethodsIndex_forAnnoteType = new HashSet<Integer>();
            annotationMethodIndexes.put(annotateType, annotationMethodsIndex_forAnnoteType);
        }

        if (!annotationMethodsIndex_forAnnoteType.contains(new Integer(annotationMethodIndex))) {
            this.codeBuilder_AnnotationMethods_Full.append("\t").append(annotationMethods_String).append("\n\n");
            annotationMethodsIndex_forAnnoteType.add(new Integer(annotationMethodIndex));

        }
    }




    public void _2_generateClass(CodeGen_OutputResults outputResults)
            throws Exception_MetaCompilerError {


        generate_ImportSection(outputResults);

        codeBuilder_ClassStart = new CodeBuilder();
        codeBuilder_ClassEnd = new CodeBuilder();


        codeBuilder_ClassStart.append("\n\n\n\n" +
            "public interface " + interfaceName + " {\n\n");


        codeBuilder_ClassEnd
                .append("}\n");

    }


    @Override
    public String writeToFile(boolean autoFlushBufferForDebug) throws IOException {
        codeBuilder_fullCode = new CodeBuilder();

        codeBuilder_fullCode.append(codeBuilder_ImportSection);
        codeBuilder_fullCode.append(codeBuilder_ClassStart);
        codeBuilder_fullCode.append(codeBuilder_AnnotationMethods_Full).append("\n\n");
        codeBuilder_fullCode.append(codeBuilder_ClassEnd);

        FileUtilities.makeDir(fileDirPath, true);
        FileUtilities.writeToFile(fileDirPath, interfaceName + ".java", true,
                codeBuilder_fullCode.toString(), autoFlushBufferForDebug);

        return (interfaceName + ".java");
    }

    public String get_InterfaceName() {
        return interfaceName;
    }



    public static String generateInterfaceName(String embeddedFile_ClassName) {
        return embeddedFile_ClassName + HierarchySettings.annotations_InterfaceName_Suffix;
    }

    

}
