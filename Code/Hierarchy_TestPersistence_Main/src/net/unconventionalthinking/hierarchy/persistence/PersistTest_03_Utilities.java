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

package net.unconventionalthinking.hierarchy.persistence;

import java.util.Arrays;
import java.util.List;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.Descriptor;
import net.unconventionalthinking.matrix.Matrix;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.SymbolControl;

import static org.junit.Assert.*;

/**
 *
 * @author Peter Joh
 */
public class PersistTest_03_Utilities {

    public static void testUpdatedMatrix(Matrix curr_TestMatrix, SymbolControl symbolControl, ExecutionInfo executeInfo) throws Exception {

        System.out.println("Testing updated matrix with name: " + curr_TestMatrix.label.getSymbol().name_no_backtiks);

        List<String> labelParts = Arrays.asList("my", "formSelector");
        Label label = symbolControl.multiPartSymbol_Factory.createNew_Label(labelParts, 1, false);
        Descriptor formSelector_Desc = curr_TestMatrix.get_ChildDescriptor(executeInfo, label);

        assertEquals(formSelector_Desc.label, label);

        labelParts = Arrays.asList("First Name");
        label = symbolControl.multiPartSymbol_Factory.createNew_Label(labelParts, 1, false);
        Descriptor firstName_Item = curr_TestMatrix.get_ChildDescriptor(executeInfo, label);

        DescriptorTagName descTag = symbolControl.multiPartSymbol_Factory.createNew_DescTagName("FORM.REQUIRED", 1, false, null, null);
        Descriptor formReq_Desc = firstName_Item.get_ChildDescriptor(executeInfo, descTag);

        assertEquals("*** TEST PATH 1t ***", formReq_Desc.get_FieldSet().getField(executeInfo, 1));
        assertEquals(PersistTestResultsConstants_forClientServerTests.FORMREQUIRED_NEW_FIELDVALUE__IMAGE_HEIGHT, formReq_Desc.get_FieldSet().getField(executeInfo, 2));
        assertEquals(PersistTestResultsConstants_forClientServerTests.FORMREQUIRED_NEW_FIELDVALUE__IMAGE_WIDTH, formReq_Desc.get_FieldSet().getField(executeInfo, 3));

        System.out.println("Done!");
    }

}
