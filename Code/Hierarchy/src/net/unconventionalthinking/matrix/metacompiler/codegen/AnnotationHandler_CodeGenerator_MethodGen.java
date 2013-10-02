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
import net.unconventionalthinking.hierarchy.HierarchySettings;

/**
 *
 * @author peterjoh
 */
public abstract class AnnotationHandler_CodeGenerator_MethodGen {

    AnnotationsCodeGenerator_Control annotationsCodeGenerator_Control;

    int     baseIndentLevel;
    String  baseIndent;

    HierarchySettings hierarchySettings;

    public AnnotationHandler_CodeGenerator_MethodGen(AnnotationsCodeGenerator_Control annotationsCodeGenerator_Control, int baseIndentLevel, HierarchySettings hierarchySettings) {
        
        this.annotationsCodeGenerator_Control = annotationsCodeGenerator_Control;
        this.baseIndentLevel = baseIndentLevel;
        this.hierarchySettings = hierarchySettings;


        this.baseIndent = "";
        for (int i = 0; i < baseIndentLevel; ++i)
            baseIndent += "\t";

        this.annotationsCodeGenerator_Control = annotationsCodeGenerator_Control;

    }


    public abstract void add_CodeForAnnotationHandler(int annotationMethodIndex, CodeBuilder code, boolean is_MatrixAccess_In_StaticMethod);

    public abstract CodeBuilder generate_AnnotationHandlers(AnnotationsInterface_FileGenerator annotationsInterface_FileGen);


}
