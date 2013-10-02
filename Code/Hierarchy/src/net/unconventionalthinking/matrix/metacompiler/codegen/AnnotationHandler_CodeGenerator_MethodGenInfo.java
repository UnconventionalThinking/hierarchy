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

/**
 *
 * @author Peter Joh
 */
public class AnnotationHandler_CodeGenerator_MethodGenInfo {

    public AnnotationHandler_CodeGenerator_MethodGenInfo(CodeBuilder annotationCodeBuilder, boolean is_MatrixAccess_In_StaticMethod) {
        this.annotationCodeBuilder = annotationCodeBuilder;
        this.is_MatrixAccess_In_StaticMethod = is_MatrixAccess_In_StaticMethod;
    }

    public CodeBuilder annotationCodeBuilder;
    public boolean is_MatrixAccess_In_StaticMethod;
}
