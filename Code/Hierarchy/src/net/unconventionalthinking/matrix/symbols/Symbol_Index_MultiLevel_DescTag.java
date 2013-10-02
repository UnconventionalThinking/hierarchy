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
public class Symbol_Index_MultiLevel_DescTag extends Symbol_Index_MultiLevel {

    Map<TwoID_Key, DescriptorTag> descTagIndex_BySchemaNameAndDescTag = new HashMap<TwoID_Key, DescriptorTag>();


    MultiValueMap descTag_MultiValueIndex_ByDescTagNameID = new MultiValueMap();
    MultiValueMap descTag_MultiValueIndex_BySchemaNameFullID = new MultiValueMap();



    //  Descriptor Tag Methods _____________________________________________________________________________________

    @Override
    public void add(Symbol descTag_Symbol) {

        super.add((Symbol) descTag_Symbol);

        DescriptorTag_MultiLevel descTag = (DescriptorTag_MultiLevel)descTag_Symbol;

        descTagIndex_BySchemaNameAndDescTag.put( new TwoID_Key(descTag.getSchemaName_Full().getID(), descTag.getDescTagName().getID()),
                descTag);


        descTag_MultiValueIndex_ByDescTagNameID.put(new Integer(descTag_Symbol.getID()), descTag_Symbol);
        descTag_MultiValueIndex_BySchemaNameFullID.put(new Integer(((Symbol)((DescriptorTag)descTag_Symbol).getSchemaName_Full()).getID()), descTag_Symbol);
    }

    public Collection getDescriptorTags_ByDescTagNameID(int descTagName_ID) {
        return descTag_MultiValueIndex_ByDescTagNameID.getCollection(new Integer(descTagName_ID));
    }
    public Collection getDescriptorTags_BySchemaNameFullID(int schemaNameFull_MultiLevel_SymbolID) {
        return descTag_MultiValueIndex_BySchemaNameFullID.getCollection(new Integer(schemaNameFull_MultiLevel_SymbolID));
    }




    public DescriptorTag getDescriptorTag_BySchemaNameAndDescTagName(MatrixName schemaName_Full, DescriptorTagName descTagName) {
        return descTagIndex_BySchemaNameAndDescTag.get(new TwoID_Key(((Symbol)schemaName_Full).ID, ((Symbol)descTagName).ID));
    }



}
