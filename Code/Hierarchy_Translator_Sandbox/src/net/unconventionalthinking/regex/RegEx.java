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

package net.unconventionalthinking.regex;

import java.util.*;
import java.util.regex.*;


/**
 *
 * @author peterjoh
 */
public class RegEx {


    /**
     * Trim the regex expression string, then if 'add_SearchFromBeginning' is true, then add a 'search from the
     * beginning' symbol the to start of te regular expresion <b>if one doesn't already exist</b>. Then,
     * compile the regex.
     *
     * @param regex                     A regular expression.
     * @param add_SearchFromBeginning   set this to true to have a 'search from the beginning' symbol '^' added to
     *                                  regex if one doesn't already exist
     * @return                          a regular expression Pattern object
     */
    public static Pattern prepare_RegEx(String regex, boolean add_SearchFromBeginning) {

        if (regex != null) {
            String regex_temp = regex.trim();

            if (regex_temp.length() != 0 &&
                add_SearchFromBeginning && regex_temp.charAt(0) != '^')
                regex_temp = "^" + regex_temp; // it is assumed that we are searching from the beginning of the string!

            return (Pattern.compile(regex_temp));
        }
        return null;
    }



    /**
     * For each the regEx in the array, trim the regex expression string, then if 'add_SearchFromBeginning' is true,
     * then add a 'search from the beginning' symbol the to start of te regular expresion <b>if one doesn't already exist</b>.
     * Then, compile the regex. Return all these compiled regex in an ArrayList.
     *
     * @param regexArray                An Array of regular expressions.
     * @param add_SearchFromBeginning   set this to true to have a 'search from the beginning' symbol '^' added to
     *                                  regex if one doesn't already exist
     * @return                          An ArrayList of regular expression Pattern objects
     */
    public static List<Pattern> prepare_RegExArray(String[] regexArray, boolean add_SearchFromBeginning) {

        List<Pattern> regexPattern_List =  null;

        // Add all the excludeMethods to an excludePattern List
        if (regexArray != null) {
            regexPattern_List = new ArrayList<Pattern>();

            for (int i = 0; i < regexArray.length; ++i) {
                if (regexArray[i] != null) {
                    Pattern cleanExcludeRegex = prepare_RegEx(regexArray[i], add_SearchFromBeginning);
                    regexPattern_List.add(cleanExcludeRegex);
                }
            }
        }
        return regexPattern_List;
    }


    /**
     * Match the text string against a list of reg expression patterns. This is typically useful for situations
     * where you have a bunch of very simple, short strings of text that you want to check to see if it matches the
     * a certain piece of text. For example, if you have a list of strings you want to exclude from a large set of strings.
     *
     * @param textToMatch   text string you want to check to see if it matches on anything in the list of reg expressions.
     * @param regexList     A list of regular expressions.
     * @return              true if found a match for text in list.
     */
    public static boolean matchOn_RegExList(String textToMatch, List<Pattern> regexList) {

        boolean matchFound = false;

        if (regexList != null) {
            for (Pattern regexPattern : regexList) {
                if (regexPattern.matcher(textToMatch).matches()) {
                    matchFound = true;
                    break;
                }
            }
        }
        return matchFound;

    }



}
