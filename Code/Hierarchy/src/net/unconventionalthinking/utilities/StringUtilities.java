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
public class StringUtilities {

    public static String convertToEscapedString(String srcString) {

        StringBuilder destString = new StringBuilder();

        for (int i = 0; i < srcString.length(); ++i) {
            char ch = srcString.charAt(i);

            String outCharSeq = null;

            switch (ch) {
                // Backspace
                case 0x0008:
                    outCharSeq = "\\b";
                    break;
                // Tab
                case 0x0009:
                    outCharSeq = "\\t";
                    break;
                // Linefeed
                case 0x000a:
                    outCharSeq = "\\n";
                    break;
                // Carriage return
                case 0x000d:
                    outCharSeq = "\\r";
                    break;
                // Double quote
                case 0x0022:
                    outCharSeq = "\\\"";
                    break;
                // Single Quote
                case 0x0027:
                    outCharSeq = "\\'";
                    break;
                // Backslash
                case 0x005c:
                    outCharSeq = "\\\\";
                    break;

                default:
                    outCharSeq = String.valueOf(ch);
            }

            destString.append(outCharSeq);
        }

        return destString.toString();

    }

    /**
     * Test whether the string is a valid java identifier
     *
     * @param stringToCheck
     * @return
     */
    public static boolean is_Identifier(String stringToCheck) {


        if (stringToCheck.length() <= 0) {
            return false;
        }

        // Check the first char. it is can be a different set of char's than the rest
        if (!Character.isJavaIdentifierStart(stringToCheck.charAt(0))) {
            return false;
        }

        //  now, check the rest
        boolean found_Invalid_Ch = false;
        for (int i = 1; i < stringToCheck.length() && !found_Invalid_Ch; ++i) {
            found_Invalid_Ch = !Character.isJavaIdentifierPart(stringToCheck.charAt(i));
        }

        if (found_Invalid_Ch) {
            return false;
        } else {
            return true;
        }
    }

    public static String removeSpaces(String srcString) {

        StringBuilder destString = new StringBuilder();
        for (int i = 0; i < srcString.length(); i++) {
            char ch = srcString.charAt(i);

            if (ch != ' ' && ch != '\t' && ch != '\n') {
                destString.append(ch);
            }

        }

        return destString.toString();
    }
}
