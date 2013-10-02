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

package net.unconventionalthinking.matrix.metacompiler.codegen;

import net.unconventionalthinking.compiler.tools.CodeBuilder;
import java.util.*;

/**
 *
 * @author peterjoh
 */
public class Set_CodeGenerator {

    public static CodeBuilder generate_SetCode(CodeBuilder codeBuilder, CodeGen_OutputResults outputResults, boolean hasItemType, String itemType,
            List itemExpressions) {
        return generate_SetCode(codeBuilder, outputResults, hasItemType, itemType, itemExpressions, null, null, null);
    }


    public static CodeBuilder generate_SetCode(CodeBuilder codeBuilder, CodeGen_OutputResults outputResults, boolean hasItemType, String itemType,
            List itemExpressions, List<Set_CodeGenerator_ItemProcessor_CallBack> itemProcessor_CallBacks_List,
            Set_CodeGenerator_ItemProcessor_CallBack default_ItemProcessor_Callback, Object[] callbackArgs) {


        //  Output the access code
        if (codeBuilder == null)
            codeBuilder = new CodeBuilder();

        String setItemType = "";
        if (hasItemType)
            setItemType = "<" + itemType + ">";

        if (itemExpressions == null || itemExpressions.size() == 0) {
            codeBuilder.append("new MatrixSet").append(setItemType).append("()");
            

        } else {
            codeBuilder.append("new MatrixSet").append(setItemType).append("().add(");
            for (int i = 0; i < itemExpressions.size(); ++i) {
                if (i > 0)
                    codeBuilder.append(", ");

                Object itemExprObj = itemExpressions.get(i);

                //  Process the itemExpression by an itemProcessor Callback from the callBack list, or if there isn't one,
                //  use the default processor, or, if there are neither of these two, just use the expression
                Set_CodeGenerator_ItemProcessor_CallBack itemProcessor_CallBack;
                boolean itemProcessor_NotFoundInArray = false;


                String item_Code = "null";

                if (itemProcessor_CallBacks_List != null && i < itemProcessor_CallBacks_List.size()) {

                    itemProcessor_CallBack = itemProcessor_CallBacks_List.get(i);
                    if (itemProcessor_CallBack != null)
                        item_Code = itemProcessor_CallBack.processItemExpression(itemExprObj, callbackArgs);
                    else
                        itemProcessor_NotFoundInArray = true;

                } else {
                    itemProcessor_NotFoundInArray = true;
                }

                if (itemProcessor_NotFoundInArray) {
                    if (default_ItemProcessor_Callback != null)
                        item_Code = default_ItemProcessor_Callback.processItemExpression(itemExprObj, callbackArgs);
                    else
                        item_Code = itemExprObj.toString();
                }
                
                codeBuilder.append(item_Code);
            }
            codeBuilder.append(")");
        }

        outputResults.addImport(CodeConstants.MatrixImports_Sets);

        return codeBuilder;
    }
}
