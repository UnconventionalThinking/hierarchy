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
public class Symbol_Index_MultiLevel_SchemaName extends Symbol_Index_MultiLevel {

    Map<TwoID_Key, MatrixName> schemaNameIndex_ByPackageAndSchemaName = new HashMap<TwoID_Key, MatrixName>();

    
    MultiValueMap schemaName_MultiValueIndex_ByPackageID = new MultiValueMap();
    MultiValueMap schemaName_MultiValueIndex_ByPackageName = new MultiValueMap();
    MultiValueMap schemaName_MultiValueIndex_BySchemaNameID = new MultiValueMap();
    MultiValueMap schemaName_MultiValueIndex_BySchemaName = new MultiValueMap();

    


    //  Descriptor Tag Methods _____________________________________________________________________________________

    @Override
    public void add(Symbol schemaName_Symbol) {

        super.add((Symbol) schemaName_Symbol);

        MatrixName schemaName_Full = (MatrixName)schemaName_Symbol;

        schemaNameIndex_ByPackageAndSchemaName.put(new TwoID_Key(schemaName_Full.getPackageName().getID(),
                schemaName_Full.getMatrixName().getID()), schemaName_Full);


        schemaName_MultiValueIndex_ByPackageID.put(new Integer(schemaName_Full.getPackageName().getID()), schemaName_Symbol);
        schemaName_MultiValueIndex_ByPackageName.put(schemaName_Full.getPackageName().getName(), schemaName_Symbol);
        schemaName_MultiValueIndex_BySchemaNameID.put(new Integer(schemaName_Full.getMatrixName().getID()), schemaName_Symbol);
        schemaName_MultiValueIndex_BySchemaName.put(schemaName_Full.getMatrixName().getName(), schemaName_Symbol);

    }


    public MatrixName getSchemaName_ByPackageAndSchemaName(DescriptorTagName packageSymbol, DescriptorTagName schemaName) {
        return schemaNameIndex_ByPackageAndSchemaName.get(new TwoID_Key(((Symbol)packageSymbol).ID, ((Symbol)schemaName).ID));
    }



    public Collection getSchemaNames_ByPackageID(int packageID) {
        return schemaName_MultiValueIndex_ByPackageID.getCollection(new Integer(packageID));
    }
    public Collection getSchemaNames_ByPackageName(String packageName) {
        return schemaName_MultiValueIndex_ByPackageName.getCollection(packageName);
    }


    public Collection getSchemaNames_BySchemaNameID(int schemaNameID) {
        return schemaName_MultiValueIndex_BySchemaNameID.getCollection(new Integer(schemaNameID));
    }
    public Collection getSchemaNames_BySchemaName(String schemaName) {
        return schemaName_MultiValueIndex_BySchemaName.getCollection(schemaName);
    }




}

