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

import java.util.HashMap;


/**
 * DON'T USE THIS CLASS!!!: use the IdentityHashMap instead!!!
 *    Only left this class here just in case the IdentityHashMap doesn't do everything we need it to.
 *
 *
 * The purpose of this class is to be hash map for java objects,  meaning the key of the map is the java object itself. So,
 * if I have a java object, and it use it as the key for an item in the hash. Then, I do a get with this same java object as the key, then it should
 * return the previously placed item.
 *
 * What is this useful for? if you are pulling serialized java objects from a file, and some of the pulled objects are actually the same instance
 * (serialization supports this), how does the application know that these objects are actual the same object?
 * It'd be great if you could get a unique id for each object (not supported in java. Object.hashCode() is close, but does not support 64 bit address spaces).
 *
 * One way is you could keep a list of all the previously seen objects, and then when you pull an object that might be one that you already pulled, you
 * can iterate over the list and test each object ot see if they are '==' (if they are the same object). This is slow.
 *
 * So, have a hash map that has a object wrapper as it's key, whose equals simply checks to see if the two objects are the same object.
 *
 *
 * The way this is implemented is using a ObjectKey wrapper class as a key.
 *
 * @author peterjoh
 */
public class Objects_HashMap<T> extends HashMap<Object, T> {


    @Override
    public T put(Object objectKey, T value) {
        return super.put(new ObjectKey(objectKey), value);
    }

    @Override
    public T get(Object objectKey) {
        return super.get(new ObjectKey(objectKey));
    }

}
