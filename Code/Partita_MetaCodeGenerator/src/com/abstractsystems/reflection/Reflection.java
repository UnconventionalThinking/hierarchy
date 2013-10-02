/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abstractsystems.reflection;

import java.util.*;
import java.lang.reflect.*;
import java.util.regex.*;

import com.abstractsystems.regex.*;


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
