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

/**
 *
 * @author peterjoh
 */


public class ObjectKey {

    Object objectKey;

    ObjectKey(Object objectKey) {
        this.objectKey = objectKey;
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(objectKey);
    }

    /**
     * In an object key, the to keys are equal if they are the same java object.
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ObjectKey other = (ObjectKey) obj;

        return (this.objectKey == other.objectKey);

    }




}
