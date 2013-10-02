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

package net.unconventionalthinking.matrix;

import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;
import net.unconventionalthinking.matrix.AppControl_Base;
import net.unconventionalthinking.matrix.Exception_Descriptor;
import net.unconventionalthinking.matrix.Exception_MatrixRuntime_Checked;
import net.unconventionalthinking.matrix.Exception_SchemaInfo;
import net.unconventionalthinking.matrix.symbols.Exception_SymbolCreation;

/**
 * Used for testing purposes.
 * @author peterjoh
 */
public class AppControl_Simple extends AppControl_Base {

    @Override
    public void initialize_ExternalAppControls_List() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void initialize_Symbols() throws Exception_SymbolCreation {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void initialize_AppObjects() throws Exception_Descriptor, Exception_InvalidArgumentPassed, Exception_SchemaInfo, Exception_MatrixRuntime_Checked {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
