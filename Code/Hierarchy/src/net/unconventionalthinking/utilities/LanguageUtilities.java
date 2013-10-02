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

package net.unconventionalthinking.utilities;

/**
 *
 * @author peterjoh
 */
public class LanguageUtilities {

    public static String convertNumIntoOrderingString(int number) {

        switch (number) {
            case 1:
                return "first";
            case 2:
                return "second";
            case 3:
                return "third";
            case 4:
                return "forth";
            case 5:
                return "fifth";
            case 6:
                return "sixth";
            case 7:
                return "seventh";
            case 8:
                return "eight";
            case 9:
                return "ninth";
            case 10:
                return "tenth";
            case 11:
                return "eleventh";
            case 12:
                return "twelfth";
            case 13:
                return "thirteenth";
            case 14:
                return "fourteenth";
            case 15:
                return "fifthteenth";
            case 16:
                return "sixtheenth";
            case 17:
                return "seventeenth";
            case 18:
                return "eighteenth";
            case 19:
                return "ninetenth";
            case 20:
                return "twentieth";
            case 21:
                return "twenty-first";
            case 22:
                return "twenty-second";
            case 23:
                return "twenty-third";
            case 24:
                return "twenty-fourth";
            case 25:
                return "twenty-fifth";
            case 26:
                return "twenty-sixith";
            case 27:
                return "twenty-seventh";
            case 28:
                return "twenty-eighth";
            case 29:
                return "twenty-ninth";
            case 30:
                return "thirtieth";
            case 31:
                return "thirtieth-first";
            case 32:
                return "thirtieth-second";
            case 33:
                return "thirtieth-third";
            case 34:
                return "thirtieth-forth";
            case 35:
                return "thirtieth-fifth";
            case 36:
                return "thirtieth-sixth";
            case 37:
                return "thirtieth-seventh";
            case 38:
                return "thirtieth-eighth";
            case 39:
                return "thirtieth-ninth";
            case 40:
                return "fortieth";

            default:
                return Integer.toString(number);
        }
    }
}
