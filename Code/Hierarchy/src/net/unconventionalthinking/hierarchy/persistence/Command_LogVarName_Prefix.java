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

package net.unconventionalthinking.hierarchy.persistence;

/**
 *
 * @author peterjoh
 */
public enum Command_LogVarName_Prefix {

     Descriptor("%d__"),
     
     Object("%o__"),

     Symbol("%sym"),
     Symbol_Label("%sl_"),
     Symbol_DescTagName("%sdn"),
     Symbol_DescTag("%sdt"),
     Symbol_MatrixName("%smn"),
     Symbol_SchemaName("%ssn"),
     Symbol_DescriptorPath("%sdp"),
     Symbol_SchemaPath("%ssp");


     private String prefixString;

     private Command_LogVarName_Prefix(String prefixString) {
         this.prefixString = prefixString;
     }

     @Override
     public String toString() {
         return prefixString;
     }

     public String get_PrefixString() {
         return prefixString;
     }
}
