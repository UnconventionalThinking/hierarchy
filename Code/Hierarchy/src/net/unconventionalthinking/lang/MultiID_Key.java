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


package net.unconventionalthinking.lang;

import java.util.List;

/**
 *
 * @author peterjoh
 */

public class MultiID_Key {

    public final List<Integer> id_List;

    public MultiID_Key(List<Integer> id_List) {
        this.id_List = id_List;
    }


    @Override
    public int hashCode() {
        int hash = 13;
        int multiplier = 17;
        for (Integer id : id_List) {
            hash += (id * 7) * multiplier;
            multiplier *= 11;
        }
        return hash;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final MultiID_Key other = (MultiID_Key) obj;

        if (this.id_List.size() == other.id_List.size()) {
            boolean ids_AreEqual = true;

            int listSize = this.id_List.size();
            for (int i = 0; ids_AreEqual && i < listSize; i++) {
                Integer id = this.id_List.get(i);
                Integer otherID = other.id_List.get(i);

                if (id != otherID)
                    ids_AreEqual = false;

            }
            return ids_AreEqual;
            
        } else {
            return false;
        }
    }
}