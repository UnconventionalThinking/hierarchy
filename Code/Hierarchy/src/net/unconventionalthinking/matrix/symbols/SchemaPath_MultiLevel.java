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

import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;

/**
 *
 * @author peterjoh
 */
public class SchemaPath_MultiLevel extends Symbol_MultiLevel implements SchemaPath {


    public final MatrixName schemaName;
    public final DescriptorPath descriptorPath;



    SchemaPath_MultiLevel(MatrixName schemaName, DescriptorPath descriptorPath, boolean has_StaticVersion)
            throws Exception_InvalidArgumentPassed {
        super(new Symbol[] {(Symbol)schemaName, (Symbol)descriptorPath },
                has_StaticVersion);

        this.schemaName = schemaName;
        this.descriptorPath = descriptorPath;

    }

    SchemaPath_MultiLevel(MatrixName schemaName, DescriptorPath descriptorPath, int multiLevel_SymbolID, boolean has_StaticVersion)
            throws Exception_InvalidArgumentPassed {
        super(new Symbol[] {(Symbol)schemaName, (Symbol)descriptorPath },
                multiLevel_SymbolID, has_StaticVersion);

        this.schemaName = schemaName;
        this.descriptorPath = descriptorPath;

    }

    public MatrixName getSchemaName() {
        return schemaName;
    }


    public DescriptorPath getDescriptorPath() {
        return descriptorPath;
    }


    @Override
    public SymbolType getSymbolType() { return SymbolType.SchemaPath; }


}
