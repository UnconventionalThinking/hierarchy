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
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author peterjoh
 */
public class AnnotationsCodeGenerator_Control {

    public SortedMap<Integer, AnnotationHandler_CodeGenerator_MethodGenInfo> annotationCode_ByAnnotationMethodIndex__Std = new TreeMap<Integer, AnnotationHandler_CodeGenerator_MethodGenInfo>();
    public SortedMap<Integer, AnnotationHandler_CodeGenerator_MethodGenInfo> annotationCode_ByAnnotationMethodIndex__Filters = new TreeMap<Integer, AnnotationHandler_CodeGenerator_MethodGenInfo>();
    public SortedMap<Integer, AnnotationHandler_CodeGenerator_MethodGenInfo> annotationCode_ByAnnotationMethodIndex__All = new TreeMap<Integer, AnnotationHandler_CodeGenerator_MethodGenInfo>();

    int methodIndex  = -1; // need to start at -1, because it's incremented to 0

    /**
     * For each new Java method, must increment the method index for it.
     * @param methodName
     */
    public void increment_MethodIndex() { methodIndex++; }

    public int get_MethodIndex() { return methodIndex; }


}
