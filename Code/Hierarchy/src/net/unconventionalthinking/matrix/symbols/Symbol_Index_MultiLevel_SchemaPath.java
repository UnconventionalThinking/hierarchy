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
public class Symbol_Index_MultiLevel_SchemaPath extends Symbol_Index_MultiLevel {

    Map<TwoID_Key, SchemaPath> schemaPathIndex_BySchemaNameAndDescPath = new HashMap<TwoID_Key, SchemaPath>();


    MultiValueMap descTag_MultiValueIndex_BySchemaNameFullID = new MultiValueMap();
    MultiValueMap descTag_MultiValueIndex_ByDescPathID = new MultiValueMap();



    //  Descriptor Tag Methods _____________________________________________________________________________________

    @Override
    public void add(Symbol schemaPath_Symbol) {

        super.add((Symbol) schemaPath_Symbol);

        SchemaPath_MultiLevel schemaPath = (SchemaPath_MultiLevel)schemaPath_Symbol;

        schemaPathIndex_BySchemaNameAndDescPath.put(new TwoID_Key(schemaPath.schemaName.getID(), schemaPath.descriptorPath.getID()),
                schemaPath);


        descTag_MultiValueIndex_BySchemaNameFullID.put(new Integer(schemaPath.schemaName.getID()), schemaPath_Symbol);
        descTag_MultiValueIndex_ByDescPathID.put(new Integer(schemaPath.descriptorPath.getID()), schemaPath_Symbol);
    }

    public Collection getSchemaPaths(MatrixName schemaName) {
        return descTag_MultiValueIndex_BySchemaNameFullID.getCollection(new Integer(schemaName.getID()));
    }
    public Collection getSchemaPaths(DescriptorPath descPath) {
        return descTag_MultiValueIndex_ByDescPathID.getCollection(new Integer(descPath.getID()));
    }




    public SchemaPath get(MatrixName schemaName_Full, DescriptorPath descPath) {
        return schemaPathIndex_BySchemaNameAndDescPath.get(new TwoID_Key(((Symbol)schemaName_Full).ID, ((Symbol)descPath).ID));
    }



}
