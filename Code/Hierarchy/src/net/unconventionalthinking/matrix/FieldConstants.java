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

/**
 *
 * @author peterjoh
 */
public class FieldConstants {

    public enum FieldValues { HAS_STANDARD_VALUE, NULL, UNUSED, DEFAULT  }

    public FieldConstants(FieldValues fieldValue) { value = fieldValue; }

    public final FieldValues value;



    public static final FieldConstants HAS_STANDARD_VALUE = new FieldConstants(FieldValues.HAS_STANDARD_VALUE);
    public static final FieldConstants NULL = new FieldConstants(FieldValues.NULL);
    public static final FieldConstants UNUSED = new FieldConstants(FieldValues.UNUSED);
    public static final FieldConstants DEFAULT = new FieldConstants(FieldValues.DEFAULT);


    @Override
    public String toString() {
        return value.toString();
    }
}
