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

package net.unconventionalthinking.reflection;

import java.util.*;
import java.lang.reflect.*;
import java.util.regex.*;

import net.unconventionalthinking.regex.*;


/**
 *
 * @author peterjoh
 */
public class Reflection {



    /**
     * Get all the methods for a class.
     * For all the filter regex (for the params: filter, includeMethods_List, & excludeMethods_list), it is assumed that
     * we are searching from the beginning of the string! (meaning we add a '^' to regex if one doesn't already exist)
     */
    public static List<Method> getMethods(Class classObj, String filter, String[] includeMethods_List, String[] excludeMethods_List) {

        Method[] methods = classObj.getDeclaredMethods();

        List<Method> includedMethods_List = new ArrayList<Method>();

        Pattern filterPattern = RegEx.prepare_RegEx(filter, true);
        List<Pattern> excludePattern_List = RegEx.prepare_RegExArray(excludeMethods_List, true);
        List<Pattern> includePattern_List = RegEx.prepare_RegExArray(includeMethods_List, true);


        for (int i = 0; i < methods.length; ++i) {
            String methodName = methods[i].getName();


            if (
                (filterPattern != null && filterPattern.matcher(methodName).matches()) ||
                //  Check to see if method is on include method List
                (includePattern_List != null && RegEx.matchOn_RegExList(methodName, includePattern_List))
               ) {

                //  Check the exclusion Pattern list to see if the method should be excluded
                boolean excludeThisMethod = RegEx.matchOn_RegExList(methodName, excludePattern_List);

                if (!excludeThisMethod)
                    includedMethods_List.add(methods[i]);
            }
        }

        return includedMethods_List;


    }





}
