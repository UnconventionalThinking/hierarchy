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

package net.unconventionalthinking.matrix.metacompiler.codegen;

import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.utilities.TypeUtilities;
import net.unconventionalthinking.utilities.IdCreator;

/**
 *
 * @author peterjoh
 */
public class CodeGeneratorUtilities {

    /**
     * Used to create var names with a unique id in them, to ensure the var names are unique.
     */
    public static IdCreator var_IdCreator = new IdCreator();
    /**
     * Used to create method names with a unique id in them, to ensure the method names are unique.
     */
    public static IdCreator methodName_IdCreator = new IdCreator();



    
    public static CodeBuilder generate_UnusedDefaultType_Object(Symbol typeSymbol, boolean creatingTypedMethod) {
        CodeBuilder codeBuilder = new CodeBuilder();

        if (!creatingTypedMethod && TypeUtilities.is_PrimitiveType(typeSymbol)) {
            codeBuilder.append(
                CodeGeneratorUtilities.generate_WrapPrimitiveInPrimitiveObject(
                    CodeGeneratorUtilities.generate_UnusedDefaultValueForType(typeSymbol),
                    typeSymbol
                )
            );
        } else {
            codeBuilder.append("(").append(typeSymbol.name_no_backtiks).append(")").append(
                CodeGeneratorUtilities.generate_UnusedDefaultValueForType(typeSymbol)
            );

        }

        return codeBuilder;
    }



    public static String generate_UnusedDefaultValueForType(Symbol typeSymbol) {

        if (TypeUtilities.is_PrimitiveType(typeSymbol) && typeSymbol != MPSymbols.boolean$_sym_$) {
            return "-1";

        } else if (typeSymbol == MPSymbols.boolean$_sym_$) {
            return "false";

        } else {
            return null;
        }
    }

    /**
     * If the type is a primitive, will return something like:<br>
     *   (Integer)<i>object-code-string)</i>).intValue()<br>
     * <br>
     * If it's an object type, will return:<br>
     *   (my-class)<i>object-code-string</i><br>
     *
     * @param codeBuilder
     * @param objectCodeString
     * @param typeSymbol
     */
    public static CodeBuilder generate_CastObjectToCorrectType(String objectCodeString, Symbol typeSymbol) {

        if (!TypeUtilities.is_PrimitiveType(typeSymbol)) {
            CodeBuilder codeBuilder = new CodeBuilder();
            return codeBuilder.append("(").append(typeSymbol.name_no_backtiks).append(")").append(objectCodeString);

        } else {
            return generate_CastPrimitiveObjectToPrimitive(objectCodeString, typeSymbol);
        }
    }

    /**
     * Generates the code to cast a primitive object to just a primitive. It will return something like:
     *   (Integer)<i>object-code-string</i>)).intValue()
     *
     * @param codeBuilder
     * @param objectCodeString
     * @param typeSymbol
     */
    public static CodeBuilder generate_CastPrimitiveObjectToPrimitive(String objectCodeString, Symbol typeSymbol) {

        CodeBuilder codeBuilder = new CodeBuilder();

        // example:  ((Integer)<my object code>)).intValue()
        codeBuilder.append("((").append(TypeUtilities.getString_PrimitiveObjectTypeForPrimitive(typeSymbol)).append(")").append(objectCodeString)
                    .append(").").append(TypeUtilities.getString_PrimitiveValueMethod_on_PrimitiveObject(typeSymbol));
        return codeBuilder;
    }




    /**
     * Generates the code to wrap a Primitive into a Primitive Object. The purpose of using this is to avoid the overhead
     * of autoboxing.
     * ex: new Integer(<i>primitive code string</i>)
     *
     * @param objectCodeString
     * @param typeSymbol
     * @return
     */
    public static CodeBuilder generate_WrapPrimitiveInPrimitiveObject(String primitiveCodeString, Symbol typeSymbol) {
        CodeBuilder codeBuilder = new CodeBuilder();

        codeBuilder.append("new ").append(TypeUtilities.getString_PrimitiveObjectTypeForPrimitive(typeSymbol))
                .append("((").append(typeSymbol.name_no_backtiks).append(")")
                .append(primitiveCodeString).append(")");

        return codeBuilder;


    }
}
