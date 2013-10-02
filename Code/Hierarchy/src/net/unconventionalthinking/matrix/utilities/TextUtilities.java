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


package net.unconventionalthinking.matrix.utilities;

import net.unconventionalthinking.exceptions.*;
import net.unconventionalthinking.lang.*;

/**
 *
 * @author peterjoh
 */
public class TextUtilities {

   /**
     * Takes a string and format it so it can be used as an identifier. for instance, as a variable name. The only
     * acceptable characters in this format as is are letters and digits. So:<P>
     *
     *   letters and digits -> kept as is<P>
     *
     *   '.' (period) -> '_'<br>
     *   any character except [letter | digit | period ] ->  $<unicode value>$<p>
     *
     * The first character is a little different, only letter is accepted as is (no digits for this one). So:<br>
     *   letter -> kept as is<br>
     *   any character except [letter] ->  $<unicode value>$<br>
     *
     * @param text
     * @return
     */
    public static String convertTextToIdentifier(String text) {
        return convertTextToIdentifier(text, null);
    }




    /**
     * Takes a string and format it so it can be used as an identifier. for instance, as a variable name. The only
     * acceptable characters in this format as is are letters and digits. So:<P>
     *
     *   letters and digits -> kept as is<P>
     *
     *   '.' (period) -> '_'<br>
     *   any character except [letter | digit | period ] ->  $<unicode value>$<p>
     *
     * The first character is a little different, only letter is accepted as is (no digits for this one). So:<br>
     *   letter -> kept as is<br>
     *   any character except [letter] ->  $<unicode value>$<br>
     *
     *
     * @param text
     * @param have_Modified_String
     * @return
     */
    public static String convertTextToIdentifier(String text, Boolean_Mutable have_Modified_String) {
        StringBuilder stringBuilder;

        if (text == null)
            throw new ExceptRuntime_InvalidArgumentPassed_Null("Should have had a text string passed in.");

        int textLength = text.length();

        if (textLength > 0) {
            stringBuilder = new StringBuilder();

            Boolean_Mutable have_Modified_Char = new Boolean_Mutable(false);
            stringBuilder.append(convertCharToIdentifier_FirstChar(text.charAt(0), have_Modified_Char));
            if (have_Modified_String != null && have_Modified_String.value) have_Modified_String.value = true;


            for (int i = 1; i < textLength; ++i) {
                have_Modified_Char.value = false;
                stringBuilder.append(convertCharToIdentifier_NonFirstChar(text.charAt(i), have_Modified_Char));
                if (have_Modified_String != null && have_Modified_Char.value) have_Modified_String.value = true;
            }
            return stringBuilder.toString();

        } else {
            return "";
        }



    }



    /**
     * Pass in the first character of a string and format it for use as in identifier So:
     *   letter -> kept as is
     *   any character except [letter] ->  $<unicode value>$
     */
    public static String convertCharToIdentifier_FirstChar(char ch) {
        return convertCharToIdentifier_FirstChar(ch, null);
    }

    /**
     * Pass in the first character of a string and format it for use as in identifier So:
     *   letter -> kept as is
     *   any character except [letter] ->  $<unicode value>$
     */
    public static String convertCharToIdentifier_FirstChar(char ch, Boolean_Mutable have_Modified_Char) {

        if (Character.isLetter(ch)) {
            return Character.toString(ch); // return as is
        } else {
            String retString = '$' + Integer.toString(ch) + '$';
            if (have_Modified_Char != null) have_Modified_Char.value = true;
            return retString;
        }

    }



    /**
     * Pass in a non first-character of a string and format it for use as in identifier So:
     *   letters and digits -> kept as is
     *
     *   '.' (period) -> '__'
     *   any character except [letter | digit | space | period ] ->  $<unicode value>$
     */
    public static String convertCharToIdentifier_NonFirstChar(char ch) {
        return convertCharToIdentifier_NonFirstChar(ch, null);
    }

    /**
     * Pass in a non first-character of a string and format it for use as in identifier So:
     *   letters and digits -> kept as is
     *
     *   '.' (period) -> '__'
     *   any character except [letter | digit | space | period ] ->  $<unicode value>$
     */
    public static String convertCharToIdentifier_NonFirstChar(char ch, Boolean_Mutable have_Modified_Char) {

        if (Character.isLetter(ch) || Character.isDigit(ch)) {
            return Character.toString(ch); // return as is
        } else if (ch == '.') {
            return "_";
        } else {
            String retString = '$' + Integer.toString(ch) + '$';
            if (have_Modified_Char != null) have_Modified_Char.value = true;
            return retString;
        }

    }





    public static String convertIdentiferToText(String identifierString) throws Exception_InvalidArgumentPassed_Null,
        Exception_NotIdentifierFormattedString {

        StringBuilder stringBuilder;

        if (identifierString == null)
            throw new Exception_InvalidArgumentPassed_Null("Should have had a text string passed in.");


        int textLength = identifierString.length();

        if (textLength > 0) {
            stringBuilder = new StringBuilder();

            Integer_Mutable indexOfNextChar = new Integer_Mutable(-1);
            Character firstCh = convertIdentiferToChar_FirstCharElement(identifierString, indexOfNextChar);
            if (firstCh != null)
                stringBuilder.append(firstCh.charValue());
            else
                throw new Exception_NotIdentifierFormattedString("Problem with first character of string: " + identifierString +
                        ". Specifically, had problems converting it to a regular char.");

            for (Character nextCh = convertIdentiferToChar_NonFirstCharElement(identifierString, indexOfNextChar.value, indexOfNextChar);
                nextCh != null;
                nextCh = convertIdentiferToChar_NonFirstCharElement(identifierString, indexOfNextChar.value, indexOfNextChar)) {

                stringBuilder.append(nextCh.charValue());
            }

            return stringBuilder.toString();

        } else {
            return "";
        }

    }

    public static Character convertIdentiferToChar_FirstCharElement(String identifierString, Integer_Mutable indexOfSecondChar)
            throws Exception_NotIdentifierFormattedString {

        if (identifierString == null)
            return null;
        else if(identifierString.length() == 0)
            return null;


        char firstCh = identifierString.charAt(0);

        if (Character.isLetter(firstCh)) {
            indexOfSecondChar.value = 1;
            return new Character(firstCh);

        } else if (firstCh == '$') {
            char ch;
            try {
                ch = getCharCodeString(identifierString, 0, indexOfSecondChar);
            } catch (Exception_NotIdentifierFormattedString e) {
                throw new Exception_NotIdentifierFormattedString("Problem with first character of string: " + identifierString + ". Specifically: " + e.getMessage());
            }
            return new Character(ch);

        } else {
            throw new Exception_NotIdentifierFormattedString("Problem with non-first character of string: " +
                    identifierString + " at first character. It is not a proper converted, identifier character.");
        }

    }

    public static Character convertIdentiferToChar_NonFirstCharElement(String identifierString, int indexOfChar, Integer_Mutable indexOfNextChar)
            throws Exception_NotIdentifierFormattedString {

        if (indexOfChar >= identifierString.length()) {
            //past end of string, return null;
            return null;
        } else {
            char ch = identifierString.charAt(indexOfChar);

            if (Character.isLetter(ch) || Character.isDigit(ch)) {
                indexOfNextChar.value = indexOfChar + 1;
                return new Character(ch);

            } else if (ch == '_') {
                indexOfNextChar.value = indexOfChar + 1;
                return new Character('.');

            } else if (ch == '$') {
                try {
                    ch = getCharCodeString(identifierString, indexOfChar, indexOfNextChar);
                } catch (Exception_NotIdentifierFormattedString e) {
                    throw new Exception_NotIdentifierFormattedString("Problem with a non-first character of string: " + identifierString + ". Specifically: " + e.getMessage());
                }

                return new Character(ch);
            } else {
                throw new Exception_NotIdentifierFormattedString("Problem with non-first character of string: " +
                        identifierString + " at index " + indexOfChar + ". Not a proper converted, identifier character.");
            }
        }
    }




    public static char getCharCodeString(String identifierString, int charCodeString_StartIndex, Integer_Mutable indexOfNextChar)
            throws Exception_NotIdentifierFormattedString {
        if (identifierString.charAt(charCodeString_StartIndex) == '$') {

            String numString = "";

            int i;
            for (i = charCodeString_StartIndex + 1; i < identifierString.length() && Character.isDigit(identifierString.charAt(i)); ++i) {
                numString += identifierString.charAt(i);
            }

            if (numString.length() <= 0)
                throw new Exception_NotIdentifierFormattedString("The character is not a properly encode char -'$<char code>$'. No character number found at index " +
                        charCodeString_StartIndex + ". The string is: " + identifierString);
            else if (identifierString.charAt(i) != '$')
                throw new Exception_NotIdentifierFormattedString("The character is not a properly encode char -'$<char code>$'. The character at index " +
                    i + " has start '$' and code, but no closing '$'. The string is: " + identifierString);
            else {
                indexOfNextChar.value = i + 1; // go past the '$'
                int charCode = Integer.parseInt(numString);
                return (char) charCode;
            }

        } else {
            throw new Exception_NotIdentifierFormattedString("The character is not a properly encode char -'$<char code>$'. The character at index " +
                    charCodeString_StartIndex + " does not start with a $. The string is: " + identifierString);
        }
    }











    /**
     * Put any backtiks as an escape character sequence
     *
     * @param srcString
     * @param have_Modified_String
     * @return
     */
    public static String escapeAllBacktiks(String srcString, Boolean_Mutable have_Modified_String)
        throws Exception_InvalidArgumentPassed_Null {

        if (srcString == null) throw new Exception_InvalidArgumentPassed_Null("Trying to escape all backtiks in this string, but was passed a null source string.");

        StringBuilder strBuilder = new StringBuilder(srcString.length() + 10);
        for (int i = 0; i < srcString.length(); ++i) {
            char ch = srcString.charAt(i);
            if (ch == '`')
                strBuilder.append(TextUtilities_Constants.unicodeBacktik_HexValue_EscapeString);
            else
                strBuilder.append(ch);
        }

        return strBuilder.toString();
    }

}
