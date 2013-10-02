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

package net.unconventionalthinking.lang.io;

import net.unconventionalthinking.lang.Boolean_Mutable;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author peterjoh
 */
public class ObjectInputStream_Utilities {




    public static void readExpectedChar(ObjectInputStream objInputStream, char expectedChar, String elementTypeName, boolean expectedCharPrecedes_notFollows)
            throws IOException {

        char actualChar = objInputStream.readChar();
        if (actualChar != expectedChar)
            throw new IOException ("Tried to read a " + elementTypeName +
                    ", but had an error. It should have been " + (expectedCharPrecedes_notFollows ? "preceded" : "followed") +
                    "'" + expectedChar + "',  but it as a '" + actualChar + "' instead.");
    }


    /**
     *      readWhiteSpace() reads in the first character after the white space. Can't be avoided
     */
    public static char ignoreWhiteSpace(ObjectInputStream objInputStream, Boolean_Mutable readWhiteSpaceChars, Boolean_Mutable readOneCharPastWhiteSpace)
        throws IOException {

       char ch = 0;
       boolean readNonWhitespaceChar = false;

       while (objInputStream.available() != 0 && !readNonWhitespaceChar) {
            ch = objInputStream.readChar();

            if (ch != ' ' && ch != '\t' && ch != '\n')
                readNonWhitespaceChar = true;
            else
                readWhiteSpaceChars.value = true;
       }

       readOneCharPastWhiteSpace.value = readNonWhitespaceChar;

       return ch;
    }


    public static String readUntil_Inclusive(ObjectInputStream objInputStream, char... searchChars) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();

        boolean found_SearchChar = false;

        while(objInputStream.available() != 0 && !found_SearchChar) {
            char ch = objInputStream.readChar();
            stringBuilder.append(ch);

            for (char searchChar : searchChars) {
                if (ch == searchChar)
                    found_SearchChar = true;
            }

        }

        return stringBuilder.toString();
    }

    public static String readUntil_Exclusive(ObjectInputStream objInputStream, char... searchChars) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();

        boolean found_SearchChar = false;

        while(objInputStream.available() != 0 && !found_SearchChar) {
            char ch = objInputStream.readChar();

            for (char searchChar : searchChars) {
                if (ch == searchChar)
                    found_SearchChar = true;
            }
            if (!found_SearchChar)
                stringBuilder.append(ch);

        }

        return stringBuilder.toString();
    }

    /**  You probably don't need to use this method. Use readUTF()/writeUTF() instead */
    public static String readChars(ObjectInputStream objInputStream, int numChars) throws IOException {

        StringBuilder stringBuilder = new StringBuilder(numChars);

        for (int i = 0; i < numChars; i++) {
            stringBuilder.append(objInputStream.readChar());
        }

        return stringBuilder.toString();
    }
    /**  You probably don't need to use this method. Use readUTF()/writeUTF() instead */
    public static StringBuilder readChars_StringBuilder(ObjectInputStream objInputStream, int numChars) throws IOException {

        StringBuilder stringBuilder = new StringBuilder(numChars);

        for (int i = 0; i < numChars; i++) {
            stringBuilder.append(objInputStream.readChar());
        }

        return stringBuilder;
    }



}
