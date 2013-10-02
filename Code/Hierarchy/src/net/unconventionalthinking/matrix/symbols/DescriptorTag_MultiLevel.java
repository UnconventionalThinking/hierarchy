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
public class DescriptorTag_MultiLevel extends Symbol_MultiLevel implements DescriptorTag {


    public final MatrixName schemaName_Full;

    public final DescriptorTagName descTagName;


    DescriptorTag_MultiLevel(MatrixName schemaName_Full, DescriptorTagName descTagName, boolean has_StaticVersion)
            throws Exception_InvalidArgumentPassed {
        super(new Symbol[] { (Symbol)schemaName_Full, (Symbol)descTagName },
                has_StaticVersion);

        this.schemaName_Full = schemaName_Full;
        this.descTagName = descTagName;
    }

    DescriptorTag_MultiLevel(MatrixName schemaName_Full, DescriptorTagName descTagName, int multiLevel_SymbolID, boolean has_StaticVersion)
            throws Exception_InvalidArgumentPassed {
        super(new Symbol[] { (Symbol)schemaName_Full, (Symbol)descTagName },
                multiLevel_SymbolID, has_StaticVersion);

        this.schemaName_Full = schemaName_Full;
        this.descTagName = descTagName;
    }



    public DescriptorTagName getDescTagName() {
        return descTagName;
    }
    public MatrixName getSchemaName_Full() {
        return schemaName_Full;
    }

    public DescriptorTagName getPackageName() {
        return ((MatrixName_MultiLevel)schemaName_Full).packageName;
    }
    public DescriptorTagName getSchemaName() {
        return ((MatrixName_MultiLevel)schemaName_Full).matrixName;
    }


    
    @Override
    public SymbolType getSymbolType() { return SymbolType.DescriptorTag; }




}
