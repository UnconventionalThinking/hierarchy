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
public class MatrixName_MultiLevel extends Symbol_MultiLevel implements MatrixName {


    public final DescriptorTagName packageName;
    public final DescriptorTagName matrixName;


    public final String            className_Full;



    MatrixName_MultiLevel(DescriptorTagName packageName, DescriptorTagName matrixName, boolean has_StaticVersion)
            throws Exception_InvalidArgumentPassed {
        super(new Symbol[] {(Symbol)packageName, (Symbol)matrixName },
                has_StaticVersion);

        this.packageName = packageName;
        this.matrixName = matrixName;

        this.className_Full = ((Symbol)packageName).name_no_backtiks + "." + ((Symbol)matrixName).name_IdentFormat;

    }

    MatrixName_MultiLevel(DescriptorTagName packageName, DescriptorTagName matrixName, int multiLevel_SymbolID,
            boolean has_StaticVersion)
            throws Exception_InvalidArgumentPassed {
        super(new Symbol[] {(Symbol)packageName, (Symbol)matrixName },
                multiLevel_SymbolID, has_StaticVersion);

        this.packageName = packageName;
        this.matrixName = matrixName;

        this.className_Full = ((Symbol)packageName).name_IdentFormat + "." + ((Symbol)matrixName).name_IdentFormat;
    }



    public DescriptorTagName getPackageName() {
        return packageName;
    }

    public DescriptorTagName getMatrixName() {
        return matrixName;
    }


    public String getClassName() {
        return ((Symbol)matrixName).name_IdentFormat;
    }
    public String getClassName_Full() {
        return className_Full;
    }

}
