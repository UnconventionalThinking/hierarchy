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

package net.unconventionalthinking.utilities;

/**
 *
 * @author peterjoh
 */
public class CmdLine_Utilities {

    public enum OSType { UNIX, DOS }

    public static String escape(OSType osType, String textToEscape) {

        if (osType == OSType.UNIX) {
            return escapeUnix(textToEscape);
        } else
            return textToEscape;

    }



    public static String escapeUnix(String srcString) {

        StringBuilder destString = new StringBuilder();

        for (int i = 0; i < srcString.length(); ++i) {
            char ch = srcString.charAt(i);

            String outCharSeq = null;

            switch (ch) {
                // '$'
                case 0x0004:
                    outCharSeq = "\\$"; break;


                default:
                    outCharSeq = String.valueOf(ch);
            }

            destString.append(outCharSeq);
        }

        return destString.toString();

    }

}
