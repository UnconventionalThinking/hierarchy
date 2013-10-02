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

import net.unconventionalthinking.lang.TwoID_Key;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.map.MultiValueMap;



/**
 *
 * @author peterjoh
 */
public class Symbol_Index_MultiLevel_MatrixName extends Symbol_Index_MultiLevel {

    Map<TwoID_Key, MatrixName> matrixNameIndex_ByPackageAndMatrixName = new HashMap<TwoID_Key, MatrixName>();

    
    MultiValueMap matrixName_MultiValueIndex_ByPackageID = new MultiValueMap();
    MultiValueMap matrixName_MultiValueIndex_ByPackageName = new MultiValueMap();
    MultiValueMap matrixName_MultiValueIndex_ByMatrixNameID = new MultiValueMap();
    MultiValueMap matrixName_MultiValueIndex_ByMatrixName = new MultiValueMap();

    


    //  Descriptor Tag Methods _____________________________________________________________________________________

    @Override
    public void add(Symbol matrixName_Symbol) {

        super.add((Symbol) matrixName_Symbol);

        MatrixName matrixName_Full = (MatrixName)matrixName_Symbol;

        matrixNameIndex_ByPackageAndMatrixName.put(new TwoID_Key(matrixName_Full.getPackageName().getID(),
                matrixName_Full.getMatrixName().getID()), matrixName_Full);


        matrixName_MultiValueIndex_ByPackageID.put(new Integer(matrixName_Full.getPackageName().getID()), matrixName_Symbol);
        matrixName_MultiValueIndex_ByPackageName.put(matrixName_Full.getPackageName().getName(), matrixName_Symbol);
        matrixName_MultiValueIndex_ByMatrixNameID.put(new Integer(matrixName_Full.getMatrixName().getID()), matrixName_Symbol);
        matrixName_MultiValueIndex_ByMatrixName.put(matrixName_Full.getMatrixName().getName(), matrixName_Symbol);

    }


    public MatrixName getMatrixName_ByPackageAndMatrixName(DescriptorTagName packageSymbol, DescriptorTagName matrixName) {
        return matrixNameIndex_ByPackageAndMatrixName.get(new TwoID_Key(((Symbol)packageSymbol).ID, ((Symbol)matrixName).ID));
    }



    public Collection getMatrixNames_ByPackageID(int packageID) {
        return matrixName_MultiValueIndex_ByPackageID.getCollection(new Integer(packageID));
    }
    public Collection getMatrixNames_ByPackageName(String packageName) {
        return matrixName_MultiValueIndex_ByPackageName.getCollection(packageName);
    }


    public Collection getMatrixNames_ByMatrixNameID(int matrixNameID) {
        return matrixName_MultiValueIndex_ByMatrixNameID.getCollection(new Integer(matrixNameID));
    }
    public Collection getMatrixNames_ByMatrixName(String matrixName) {
        return matrixName_MultiValueIndex_ByMatrixName.getCollection(matrixName);
    }




}

