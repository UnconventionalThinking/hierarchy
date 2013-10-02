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

import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null;
import net.unconventionalthinking.lang.Boolean_Mutable;
import net.unconventionalthinking.matrix.utilities.TextUtilities;
import java.util.List;

/**
 *
 * @author peterjoh
 */
public class SymbolNameConstructor_MultiPart implements SymbolNameConstructor {



    public static SymbolNameConstructor_MultiPart constructor = new SymbolNameConstructor_MultiPart();


    
    /**
     * This method is needed because we need a constructor that takes List<String> but the problem is that
     * a constructor with this signature has a conflict with: SymbolName(List<Symbol_Single> names)
     *
     * @param names
     * @return
     * @throws net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null
     */
    public static SymbolName createNew_UsingStringList(List<String> names) throws Exception_InvalidArgumentPassed_Null {

        String[] nameStrings = new String[names.size()];
        for (int i = 0; i < names.size(); ++i)
            nameStrings[i] = names.get(i);

        return new SymbolName(nameStrings, constructor);
    }




    public String[] construct(Object listOfNames, SymbolName.NameListType nameListType, int numOfNames, StringBuilder nameBuilder,
            StringBuilder nameBuilder_no_backtiks, StringBuilder nameBuilder_IdentFormat)
            throws Exception_InvalidArgumentPassed_Null {


        String[] names = new String[numOfNames];

        for (int i = 0; i < names.length;  ++i) {
            if (nameListType == nameListType.arrayOfStrings)
                names[i] = ((String[])listOfNames)[i];
            else if (nameListType == nameListType.arrayOfSymbols)
                names[i] = ((Symbol_Single[])listOfNames)[i].name;
            else // is a list of SingleSymbols
                names[i] = ((List<Symbol_Single>)listOfNames).get(i).name;


            Boolean_Mutable have_ModifiedString = new Boolean_Mutable(false);
            String name_Cleaned;
            try {
                name_Cleaned = TextUtilities.escapeAllBacktiks(names[i], have_ModifiedString);
            } catch (Exception_InvalidArgumentPassed_Null e) {
                throw e;
            }


            //  standard format name with backtiks:
            nameBuilder.append("`").append(name_Cleaned).append("`");
            //  without back tiks:
            nameBuilder_no_backtiks.append(names[i]);

            //  identifier formatted
            nameBuilder_IdentFormat.append(TextUtilities.convertTextToIdentifier(name_Cleaned));


            // separator:
            if (i < (names.length - 1)) { // not the last
                nameBuilder.append("."); // just the standard dot
                nameBuilder_no_backtiks.append("."); // just the standard dot
                nameBuilder_IdentFormat.append(SymbolConstants.MultiPart_Separator_IdentFormat);
            }

        }


        return names;
    }





}
