/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abstractsystems.compiler.tools;



/**
 *
 * @author peterjoh
 */
public class CodeBuilder implements Appendable, CharSequence {

    private StringBuilder codeBuffer;


    public CodeBuilder() {
        codeBuffer = new StringBuilder();
    }

    public CodeBuilder(StringBuilder strBuilder) {
        codeBuffer = new StringBuilder(strBuilder);
    }
    public CodeBuilder(String str) {
        codeBuffer = new StringBuilder(str);

    }



    public CodeBuilder addToStart(String str) {
        codeBuffer.insert(0, str);
        return this;
    }
    public CodeBuilder addToStart(StringBuilder strBuilder) {
        codeBuffer.insert(0, strBuilder);
        return this;
    }
    public CodeBuilder addToStart(CodeBuilder newCodeBuilder) {
        codeBuffer.insert(0, newCodeBuilder);
        return this;
    }



    /**
     * Add a bunch of text strings to the start of the code builder. You can pass as many text strings into
     * method as you'd like. You can think of the textstrings as being append together, one after another, then added
     * To the start of this codeBuilder. Also, the textStrings don't need to be strings. They can be CodeBuilders, StringBuffers,
     * StringBuilders, or Strings
     *
     * @param textStrings                   pass in CodeBuilders, StringBuffers, StringBuilders, or Strings (can be mixed together)
     * @return              CodeBuilder with all the added strings.
     */
    public CodeBuilder addToStart(Object ... textStrings) {

        return addToStart_Utility(null, textStrings);
    }

    /**
     * Add a bunch of text strings to the start of the code builder. You can pass as many text strings into
     * method as you'd like. You can think of the textstrings as being append together, one after another, then added
     * To the start of this codeBuilder. Also, the textStrings don't need to be strings. They can be CodeBuilders, StringBuffers,
     * StringBuilders, or Strings
     *
     * @param add_InBeetween_PaddingString  If you'd like to have some text between each string (typically, a single space)
     *                                      pass it is as a string.
     * @param textStrings                   pass in CodeBuilders, StringBuffers, StringBuilders, or Strings (can be mixed together)
     * @return                              CodeBuilder with all the added strings.
     */
    public CodeBuilder addToStart(String add_InBeetween_PaddingString, Object ... textStrings) {
        return addToStart_Utility(add_InBeetween_PaddingString, textStrings);
    }




    private CodeBuilder addToStart_Utility(String add_InBeetween_PaddingString, Object[] textStrings) {

        int codeBuilder_initialLength = this.length();

        // NOTE: This loop counts BACKWARDS!
        int lastElementIndex = textStrings.length - 1;

        for (int i = lastElementIndex; i >= 0; --i) {

            if (textStrings[i] != null) {
                if (add_InBeetween_PaddingString != null) {

                    if (i < lastElementIndex ||
                        (i == lastElementIndex && codeBuilder_initialLength > 0))
                     codeBuffer.insert(0, add_InBeetween_PaddingString);
                }
                codeBuffer.insert(0, textStrings[i]);
            }
        }
        return this;
    }


    /* // string version exists below
    public CodeBuilder append(String str) {}
     */





    public CodeBuilder append(StringBuilder strBuilder) {
        if (strBuilder != null)
            codeBuffer.append(strBuilder);
        return this;
    }
    public CodeBuilder append(CodeBuilder codeBuilder) {
        if (codeBuilder!=null)
            codeBuffer.append(codeBuilder.codeBuffer);
        return this;
    }



    /**
     * Add a bunch of text strings to the start of the code builder. You can pass as many text strings into
     * method as you'd like. You can think of the textstrings as being append together, one after another, then added
     * To the end of this codeBuilder. Also, the textStrings don't need to be strings. They can be CodeBuilders, StringBuffers,
     * StringBuilders, or Strings
     *
     * @param textStrings                   pass in CodeBuilders, StringBuffers, StringBuilders, or Strings (can be mixed together)
     * @return                              CodeBuilder with all the added strings.
     */
    public CodeBuilder append(Object ... textStrings) {
        return append_Utility(null, textStrings);
    }

    /**
     * Add a bunch of text strings to the start of the code builder. You can pass as many text strings into
     * method as you'd like. You can think of the textstrings as being append together, one after another, then added
     * To the end of this codeBuilder. Also, the textStrings don't need to be strings. They can be CodeBuilders, StringBuffers,
     * StringBuilders, or Strings
     *
     * @param add_InBeetween_PaddingString  If you'd like to have some text between each string (typically, a single space)
     *                                      pass it is as a string.
     * @param textStrings                   pass in CodeBuilders, StringBuffers, StringBuilders, or Strings (can be mixed together)
     * @return                              CodeBuilder with all the added strings.
     */
    public CodeBuilder append(String add_InBeetween_PaddingString, Object ... textStrings) {
        return append_Utility(add_InBeetween_PaddingString, textStrings);
    }



    private CodeBuilder append_Utility(String add_InBeetween_PaddingString, Object[]textStrings) {

        int codeBuilder_initialLength = this.length();

        for (int i = 0; i < textStrings.length ; ++i) {

            if (textStrings[i] != null) {
                if (add_InBeetween_PaddingString != null)
                    if (i > 0 || (i == 0 && codeBuilder_initialLength > 0))
                     codeBuffer.append(add_InBeetween_PaddingString);

                codeBuffer.append(textStrings[i]);
            }
        }
        return this;
    }






    //______________________________________________________________________________________________
    //
    // THE FOLLOWING METHODS ARE FROM THE STRING BUILDER CLASS
    //______________________________________________________________________________________________

    public CodeBuilder append(Object obj) {
        codeBuffer.append(String.valueOf(obj));
        return this;
    }


    public CodeBuilder append(String str) {
        codeBuffer.append(str);
        return this;
    }

    public CodeBuilder append(StringBuffer sb) {
        codeBuffer.append(sb);
        return this;
    }

    /**
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public CodeBuilder append(CharSequence s) {
        codeBuffer.append(s);
        return this;
    }

    /**
     * @throws     IndexOutOfBoundsException {@inheritDoc}
     */
    public CodeBuilder append(CharSequence s, int start, int end) {
        codeBuffer.append(s, start, end);
        return this;
    }

    public CodeBuilder append(char str[]) {
        codeBuffer.append(str);
        return this;
    }

    public CodeBuilder append(char str[], int offset, int len) {
        codeBuffer.append(str, offset, len);
        return this;
    }

    public CodeBuilder append(boolean b) {
        codeBuffer.append(b);
        return this;
    }

    public CodeBuilder append(char c) {
        codeBuffer.append(c);
        return this;
    }

    public CodeBuilder append(int i) {
        codeBuffer.append(i);
        return this;
    }

    public CodeBuilder append(long lng) {
        codeBuffer.append(lng);
        return this;
    }

    public CodeBuilder append(float f) {
        codeBuffer.append(f);
        return this;
    }

    public CodeBuilder append(double d) {
        codeBuffer.append(d);
        return this;
    }

    public CodeBuilder appendCodePoint(int codePoint) {
        codeBuffer.appendCodePoint(codePoint);
        return this;
    }

    public CodeBuilder delete(int start, int end) {
        codeBuffer.delete(start, end);
        return this;
    }

    public CodeBuilder deleteCharAt(int index) {
        codeBuffer.deleteCharAt(index);
        return this;
    }

    public CodeBuilder replace(int start, int end, String str) {
        codeBuffer.replace(start, end, str);
        return this;
    }

    public CodeBuilder insert(int index, char str[], int offset,
                                int len)
    {
        codeBuffer.insert(index, str, offset, len);
        return this;
    }

    public CodeBuilder insert(int offset, Object obj) {
        return insert(offset, String.valueOf(obj));
    }

    public CodeBuilder insert(int offset, String str) {
        codeBuffer.insert(offset, str);
        return this;
    }

    public CodeBuilder insert(int offset, char str[]) {
        codeBuffer.insert(offset, str);
        return this;
    }

    public CodeBuilder insert(int dstOffset, CharSequence s) {
        codeBuffer.insert(dstOffset, s);
        return this;
    }

    public CodeBuilder insert(int dstOffset, CharSequence s, int start, int end) {
        codeBuffer.insert(dstOffset, s, start, end);
        return this;
    }

    public CodeBuilder insert(int offset, boolean b) {
        codeBuffer.insert(offset, b);
        return this;
    }

    public CodeBuilder insert(int offset, char c) {
        codeBuffer.insert(offset, c);
        return this;
    }

    public CodeBuilder insert(int offset, int i) {
        return insert(offset, String.valueOf(i));
    }

    public CodeBuilder insert(int offset, long l) {
        return insert(offset, String.valueOf(l));
    }

    public CodeBuilder insert(int offset, float f) {
        return insert(offset, String.valueOf(f));
    }

    public CodeBuilder insert(int offset, double d) {
        return insert(offset, String.valueOf(d));
    }

    /**
     * @throws NullPointerException {@inheritDoc}
     */
    public int indexOf(String str) {
        return indexOf(str, 0);
    }

    /**
     * @throws NullPointerException {@inheritDoc}
     */
    public int indexOf(String str, int fromIndex) {
        return codeBuffer.indexOf(str, fromIndex);
    }

    /**
     * @throws NullPointerException {@inheritDoc}
     */
    public int lastIndexOf(String str) {
        return codeBuffer.lastIndexOf(str);
    }

    /**
     * @throws NullPointerException {@inheritDoc}
     */
    public int lastIndexOf(String str, int fromIndex) {
        return codeBuffer.lastIndexOf(str, fromIndex);
    }

    public CodeBuilder reverse() {
        codeBuffer.reverse();
        return this;
    }

    @Override
    public String toString() {
        // Create a copy, don't share the array
        return codeBuffer.toString();
    }

    public int length() {
        return codeBuffer.length();
    }

    public char charAt(int arg0) {
        return codeBuffer.charAt(arg0);
    }

    public CharSequence subSequence(int arg0, int arg1) {
        return codeBuffer.subSequence(arg0, arg1);
    }

    public String subString(int start, int end) {
        return codeBuffer.substring(start, end);
    }



}
