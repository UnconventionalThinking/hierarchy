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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.unconventionalthinking.matrix;

import net.unconventionalthinking.matrix.symbols.Symbol;

/**
 *
 * @author peterjoh
 */
public class AnnotationReference_Utilities {


    public static int get_ReferenceCounter(Symbol annotationRef) throws Exception_MatrixRuntime_Checked {
        if (annotationRef.getNumOfParts() == 1)
            return 0;
        else {  // has a second part, which must be the annotation counter. get it.
            try {
                return Integer.parseInt(annotationRef.getSymbolName_AtPartNum(2));
            } catch (NumberFormatException e) {
                throw new Exception_MatrixRuntime_Checked("Tried to parse the annotation reference. It has two parts, but could not convert the second part to a number. The annotation reference was: " + annotationRef.toString());
            }
        }

    }
}
