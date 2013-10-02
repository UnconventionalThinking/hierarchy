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

import net.unconventionalthinking.matrix.symbols.MatrixName;
import java.util.Map;

/**
 *
 * @author peterjoh
 */
public class MatrixStructInfoIndex_Container {

    public Map<MatrixName, MatrixStructInfo_DescriptorContainer>   matrixStructInfoIndex_byMatrixName;
    public Map<String, MatrixStructInfo_DescriptorContainer>       matrixStructInfoIndex_byString;



    public MatrixStructInfoIndex_Container(Map<MatrixName, MatrixStructInfo_DescriptorContainer> matrixStructINfoIndex_byMatrixName, 
            Map<String, MatrixStructInfo_DescriptorContainer> matrixStructInfoIndex_byString) {

        this.matrixStructInfoIndex_byMatrixName = matrixStructINfoIndex_byMatrixName;
        this.matrixStructInfoIndex_byString = matrixStructInfoIndex_byString;
    }



}
