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

package net.unconventionalthinking.matrix.symbols;

import net.unconventionalthinking.exceptions.*;
import java.util.*;

/**
 *
 * @author peterjoh
 */
public class SymbolUtilities {


    public static DescriptorTagName convert_Label_to_DescTagName(Label label, SymbolControl symbolControl)
        throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed, Exception_MultiPartSymbolCreation,
        Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreationOrAccess
    {

        Symbol label_Symbol = (Symbol)label;

        if(label_Symbol.is_SingleSymbol) {
            // if one already exists and it does have astatic version, then the "false" has static should not change it from true.
            return symbolControl.singleSymbol_Factory.createNew_DescTagName(label_Symbol.name, false);
        }

        else  {// is multipart symbol
            List<String> symbolNameStrings = new ArrayList<String>();
            Symbol_MultiPart label_MultiPartSymbol = (Symbol_MultiPart)label;

            for (String name : label_MultiPartSymbol.symbolNames)
                symbolNameStrings.add(name);

            // if one already exists and it does have astatic version, then the "false" has static should not change it from true.
            return symbolControl.multiPartSymbol_Factory.createNew_DescTagName(symbolNameStrings, 1, false);
        }

    }


    public static Label convert_DescriptorTagName_to_Label(DescriptorTagName descTagName, SymbolControl symbolControl)
        throws Exception_InvalidArgumentPassed, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreation,
        Exception_MultiPartSymbolCreationOrAccess {

        Symbol descTagName_Symbol = (Symbol)descTagName;

        if(descTagName_Symbol.is_SingleSymbol) {
            // Note if a label already exists with the same name and it has a "ture" hasStatic value, then passing in "false" not change it to true.
            return symbolControl.singleSymbol_Factory.createNew_Label(descTagName_Symbol.name, false);
            
        } else  {// is multipart symbol
            List<String> symbolNameStrings = new ArrayList<String>();
            Symbol_MultiPart descTagName_MultiPartSymbol = (Symbol_MultiPart)descTagName;

            for (String name : descTagName_MultiPartSymbol.symbolNames)
                symbolNameStrings.add(name);

            // if one already exists and it does have astatic version, then the "false" has static should not change it from true.
            return symbolControl.multiPartSymbol_Factory.createNew_Label(symbolNameStrings, 1, false);
        }
    }


    public static String convert_DescTagNameString_to_Identifier(String descTagNameString) {

        String[] descTagName_Parts = descTagNameString.split("\\.");

        StringBuilder identifier_StringBuilder = new StringBuilder();

        boolean is_FirstIter = true;
        for (String namePart : descTagName_Parts) {
            if (is_FirstIter)
                is_FirstIter = false;
            else
                identifier_StringBuilder.append(SymbolConstants.MultiPart_Separator_IdentFormat);

            identifier_StringBuilder.append(namePart);

        }

        return identifier_StringBuilder.toString();
    }



    
    public static DescriptorTagName convert_Symbol_to_DescTagName(Symbol symbol, SymbolControl symbolControl)
        throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed, Exception_MultiPartSymbolCreation,
        Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreationOrAccess
    {

        if(symbol.is_SingleSymbol) {
            // if one already exists and it does have astatic version, then the "false" has static should not change it from true.
            return symbolControl.singleSymbol_Factory.createNew_DescTagName(symbol.name, false);
        }

        else  {// is multipart symbol
            List<String> symbolNameStrings = new ArrayList<String>();
            Symbol_MultiPart symbol_MultiPartSymbol = (Symbol_MultiPart)symbol;

            for (String name : symbol_MultiPartSymbol.symbolNames)
                symbolNameStrings.add(name);

            // if one already exists and it does have astatic version, then the "false" has static should not change it from true.
            return symbolControl.multiPartSymbol_Factory.createNew_DescTagName(symbolNameStrings, 1, false);
        }
    }



    
    public static String createSymbolNameString_From_Parts(List<String> descTagName_Parts) {

        if (descTagName_Parts == null)
            return null;
        
        StringBuffer descTagBuffer = new StringBuffer();
        
        boolean firstPart = true;
        for (String part : descTagName_Parts) {
            if (!firstPart)
                descTagBuffer.append(".");
            else
                firstPart = false;

            descTagBuffer.append(part);
        }

        return descTagBuffer.toString();
    }
}
