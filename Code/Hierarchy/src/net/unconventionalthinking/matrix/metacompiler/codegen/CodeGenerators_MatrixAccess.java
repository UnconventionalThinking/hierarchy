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
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author peterjoh
 */
public class CodeGenerators_MatrixAccess {

    private HierarchySettings hierarchySettings;

    public CodeGenerators_MatrixAccess(String annotations_InterfaceName, HierarchySettings hierarchySettings, SymbolControl symbolControl) {

        annotationsCodeGenerator_Control = new AnnotationsCodeGenerator_Control();

        annotationsInterface_FileGen = new AnnotationsInterface_FileGenerator(symbolControl);
 

        annotationCall_CodeGen = new AnnotationCall_CodeGenerator_Std(hierarchySettings, annotationsInterface_FileGen,
                annotationsCodeGenerator_Control);
        annotationCall_CodeGen_Filters  = new AnnotationCall_CodeGenerator_Filters(hierarchySettings, annotationsInterface_FileGen,
                annotationsCodeGenerator_Control);
        annotationHandlers_CodeGen  = new AnnotationHandler_CodeGenerator_MethodGen_Std(hierarchySettings, 1, annotationsCodeGenerator_Control);
        annotationHandlers_CodeGen_Filters = new AnnotationHandler_CodeGenerator_MethodGen_Filters(hierarchySettings, 1,
                annotationsCodeGenerator_Control);


        codeBuildersList__AccessMethods_Static = new ArrayList<CodeBuilder>();
        codeBuildersList__AccessMethods_Dyn = new ArrayList<CodeBuilder>();
        codeBuildersList__AccessMethods_All = new ArrayList<CodeBuilder>();

        codeBuildersList__AnnotationHandlers = new ArrayList<CodeBuilder>();

        this.hierarchySettings = hierarchySettings;
        this.symbolControl = symbolControl;
    }

    
    /**
     * The DescriptorAccess_CodeGen adds the code for both dyn and static access methods to this index.
     */
    public final List<CodeBuilder> codeBuildersList__AccessMethods_Static;
    public final List<CodeBuilder> codeBuildersList__AccessMethods_Dyn;
    public final List<CodeBuilder> codeBuildersList__AccessMethods_All;
    
    public final List<CodeBuilder> codeBuildersList__AnnotationHandlers;

    public final AnnotationsCodeGenerator_Control       annotationsCodeGenerator_Control;
    public final AnnotationsInterface_FileGenerator     annotationsInterface_FileGen;
    public final AnnotationCall_CodeGenerator_Std       annotationCall_CodeGen;
    public final AnnotationCall_CodeGenerator_Filters   annotationCall_CodeGen_Filters;

    public final AnnotationHandler_CodeGenerator_MethodGen_Std annotationHandlers_CodeGen;
    public final AnnotationHandler_CodeGenerator_MethodGen_Filters annotationHandlers_CodeGen_Filters;


    private SymbolControl symbolControl;

    public void set_EmbeddedFile_ClassName(String className) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
