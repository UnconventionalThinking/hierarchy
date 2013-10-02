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

package net.unconventionalthinking.matrix.utilities;

import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.Symbol_Single;

/**
 *
 * @author peterjoh
 */
public class TypeUtilities {


    public static boolean is_PrimitiveType(Symbol symbolToCheck) {

        if (symbolToCheck.ID >= MPSymbols.byte$_sym_$.ID && symbolToCheck.ID <= MPSymbols.boolean$_sym_$.ID)
            return true;
        else
            return false;

    }


    /**
     * For a primitive type symbol, this method gives you the name of the java class that corresponds to it. For ex. int -> Integer
     * @param type
     * @return
     */
    public static String getString_PrimitiveObjectTypeForPrimitive(Symbol type) {

        if (type == MPSymbols.byte$_sym_$) {
            return "Byte";
        } else if (type == MPSymbols.short$_sym_$) {
            return "Short";
        } else if (type == MPSymbols.int$_sym_$) {
            return "Integer";
        } else if (type == MPSymbols.long$_sym_$) {
            return "Long";
        } else if (type == MPSymbols.float$_sym_$) {
            return "Float";
        } else if (type == MPSymbols.double$_sym_$) {
            return "Double";
        } else if (type == MPSymbols.char$_sym_$) {
            return "Character";
        } else if (type == MPSymbols.boolean$_sym_$) {
            return "Boolean";
        } else {
            return null;
        }
    }

    /**
     * This method is used to generate the method name you need to call on a Primitive object to get the primitive value (non-object value).
     *
     * For instance:
     *     ((Integer)myIntObject).intValue()
     *
     * This is often used with the getString_PrimitiveObjectTypeForPrimitive() method.
     *
     * @param type
     * @return
     */
    public static String getString_PrimitiveValueMethod_on_PrimitiveObject(Symbol type) {
        
        if (type == MPSymbols.byte$_sym_$ || type == MPSymbols.short$_sym_$ || type == MPSymbols.int$_sym_$
         || type == MPSymbols.long$_sym_$ || type == MPSymbols.float$_sym_$ || type == MPSymbols.double$_sym_$
         || type == MPSymbols.char$_sym_$ || type == MPSymbols.boolean$_sym_$) {

            return type.name + "Value()";
        } else {
            return null;
        }
    }



    public static boolean is_SymbolType(Symbol symbolToCheck) {

        if (symbolToCheck.ID >= MPSymbols.Symbol.ID && symbolToCheck.ID <= MPSymbols.SchemaPath.ID)
            return true;
        else
            return false;

    }


    public static boolean is_JavaReservedWord(Symbol_Single symbol) {
        if (is_PrimitiveType(symbol))
            return true;
        //  TODO - add in all the other Reserved words
        
        return false;
    }




}
