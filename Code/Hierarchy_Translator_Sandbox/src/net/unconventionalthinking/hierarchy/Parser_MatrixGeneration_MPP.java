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

package net.unconventionalthinking.hierarchy;

import net.unconventionalthinking.hierarchy.grammar.analysis.DepthFirstAdapter;
import net.unconventionalthinking.compiler.tools.*;
import net.unconventionalthinking.reflection.*;
import java.util.*;
import java.lang.reflect.*;


/**
 *
 * @author peterjoh
 */
public class Parser_MatrixGeneration_MPP {


    public void generateOutput() {

        // <*PHASE: 1.1: Matrix Generation /*>
        // <*//___________________________________________________________________________________________________ /*>

        CodeBuilder outputCode = new CodeBuilder();

        //  Get the list of 'out' Methods
        List<Method> outMethodsList = Reflection.getMethods(DepthFirstAdapter.class, "out.*", null, null);


        for (Method method : outMethodsList) {

           //  Each out method has one parameter passed in, the node for the production alternative. Get the class obj
           //  for it and then its methods.
           Class nodeType = method.getParameterTypes()[0];
           List<Method> childMethodList = Reflection.getMethods(nodeType, "get.*", null, null);


           //  Create Matrix entry
           outputCode.append("");



        }


    }


}
