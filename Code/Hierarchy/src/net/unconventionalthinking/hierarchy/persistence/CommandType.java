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
public enum CommandType {


    DescriptorCreate_useSchemaInfo("DCSi_"),

    DescriptorSetField_byIndex("DSfI_"),
    DescriptorSetFields("DSfS_"),

    DescriptorAddChildDesc("DAdd_"),


    ObjectCreate("OC___"),
//    ObjectCreate_Existing("OCEx__"), // unnecessary? because will write all java objects out when orig matrix first starts to be used by persisted matrix

    SymbolCreate("SC___"),
    SymbolCreate_Label("SCLa_"),
    SymbolCreate_DescTagName("SCDn_"),
    SymbolCreate_DescTag("SCDt_"),
    SymbolCreate_MatrixName("SCMn_"),
    SymbolCreate_SchemaName("SCSn_"),
    SymbolCreate_DescPath("SCDp_"),
    SymbolCreate_SchemaPath("SCSp_"),

    CloseCmd("CC___");




    private CommandType(String commandString) {
        this.commandString = commandString;
    }

    
    @Override
    public String toString() {
        return commandString;
    }


    public String getCommandString() {
        return commandString;
    }

    private String commandString;


}
