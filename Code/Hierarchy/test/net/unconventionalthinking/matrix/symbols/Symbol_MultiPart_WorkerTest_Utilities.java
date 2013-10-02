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

package net.unconventionalthinking.matrix.symbols;

import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null;
import net.unconventionalthinking.lang.Boolean_Mutable;
import net.unconventionalthinking.matrix.utilities.TextUtilities;
import static org.junit.Assert.*;
import java.util.*;

/**
 *
 * @author peterjoh
 */
public class Symbol_MultiPart_WorkerTest_Utilities {


    public static void checkFor_CorrectAddOfMultiPartSymbol_To_MultiLevelIndex(Symbol_Index symbolIndex,
            Symbol_Single[] symbols) throws Exception_InvalidArgumentPassed_Null {

        String expected_MP_Sym_Name = "";
        Map<Integer, HashOrMultiPartSymbol_Bucket> curr_ChildHash =  symbolIndex.multiPart.multiTreeLevel_MultiPart_Index_By_Id;

        for (int i = 0; i < symbols.length; ++i) {

            if (i > 0)
                expected_MP_Sym_Name += ".";
            Boolean_Mutable have_Modified_String = new Boolean_Mutable();
            expected_MP_Sym_Name = expected_MP_Sym_Name + "`"
                    + TextUtilities.escapeAllBacktiks(symbols[i].name, have_Modified_String) + "`";

            Symbol_MultiPart expected_MP_Sym = symbolIndex.multiPart.multiPart_Index_ByName.get(expected_MP_Sym_Name);
            // Make sure the expected MP Symbol_Single is the right one, before you use it to test the results.
            assertEquals(expected_MP_Sym_Name, expected_MP_Sym.name);

            HashOrMultiPartSymbol_Bucket bucket = curr_ChildHash.get(symbols[i].ID);
            assertEquals(bucket.multiPartSymbol.name, expected_MP_Sym_Name);
            assertEquals(bucket.multiPartSymbol, expected_MP_Sym);  // they should be the same object!


            curr_ChildHash = bucket.hash;
        }

    }
}
