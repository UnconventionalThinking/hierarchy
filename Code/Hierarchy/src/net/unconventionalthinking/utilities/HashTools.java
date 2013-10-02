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

package net.unconventionalthinking.utilities;

import java.util.*;

/**
 *
 * @author peterjoh
 */
public class HashTools {

    public enum Action {

        get, put
    }

    public static Object get(Map hash, String key) {
        return getOrPut(hash, Action.get, key, null);
    }

    public static Object put(Map hash, String key, Object valueToPut) {
        return getOrPut(hash, Action.put, key, valueToPut);
    }

    public static Object getOrPut(Map hash, Action hashAction, String key, Object valueToPut) {

        if (hashAction == Action.get) {
            return hash.get(key);
        } else {// hashPut
            hash.put(key, valueToPut);
            return valueToPut;
        }
    }
}
