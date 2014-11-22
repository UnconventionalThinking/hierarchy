package com.williespetstore;

/**
 *
 * @author Peter Joh
 */
public class WebUtilities {


    public static String convertStringForWeb(String srcString) {
        StringBuilder convertedString = new StringBuilder();

        for (int i = 0; i < srcString.length(); ++i) {
            char ch = srcString.charAt(i);
            String convertedChar = null;
            boolean ignoreChar = false;

            switch (ch) {
                case '\n':
                    convertedChar = "<br>";
                    break;
                case '\t':
                    convertedChar = "&nbsp;&nbsp;&nbsp;&nbsp;";
                    break;
                case '"':
                    convertedChar = "&quot;";
                    break;

                case '\r': // \r are found in pairs with \n
                    ignoreChar = true;
                    break;
                default:
            }


            if (!ignoreChar) {
                if (convertedChar != null)
                    convertedString.append(convertedChar);
                else
                    convertedString.append(ch);
            }
        }

        return convertedString.toString();
    }
}
