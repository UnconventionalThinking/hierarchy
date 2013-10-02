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
public class FieldValueInfo {

    public enum Type { None, Standard, Default, Unused, Null, Ditto, Ditto_PrevLevel }

    public boolean is_ContinuationValue;
    public FieldValueInfo.Type type;


    public FieldValueInfo() {
        this.type = Type.None;
        this.is_ContinuationValue = false;
    }
    public FieldValueInfo(Type fieldValueType) {
        this.type = fieldValueType;
        this.is_ContinuationValue = false;
    }
    public FieldValueInfo(boolean is_ContinuationValue, Type fieldValueType) {
        this.is_ContinuationValue = is_ContinuationValue;
        this.type = fieldValueType;
    }




    public boolean is_SpecialValue() {
        return (type != null && type != Type.Standard && type != Type.None);
    }
}
