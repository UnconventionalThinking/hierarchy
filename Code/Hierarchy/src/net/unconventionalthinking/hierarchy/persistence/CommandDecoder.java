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

import net.unconventionalthinking.lang.OutputParameter;
import net.unconventionalthinking.hierarchy.persistence.actions.CmdActionList;

/**
 *
 * @author peterjoh
 */
public class CommandDecoder {

    /**
     * Returns the command type and commandAction for the commandString
     */
    public CommandType decode_CommandType(String commandString, OutputParameter commandAction_OUT)throws Exception_PersistenceError{

        switch(commandString.charAt(0)) {
            
            case 'C': // Command
                switch(commandString.charAt(1)) {
                    case 'C': // Close
                        commandAction_OUT.value = CmdActionList.CloseCommand;
                        return CommandType.CloseCmd;
                    default: throw new Exception_PersistenceError("Tried decoding the command, but it was not found. The command was: " + commandString);
                }

            case 'D': // Descriptor
                
                switch(commandString.charAt(1)) {
                    case 'A': // Add Child Desc
                        commandAction_OUT.value = CmdActionList.DescriptorAddChildDesc;
                        return CommandType.DescriptorAddChildDesc;

                    case 'C': // Create
                        switch(commandString.charAt(2)) {
                            case 'S':
                                switch(commandString.charAt(3)) {
                                    case 'i': // DescriptorCreate_useSchemaInfo
                                        commandAction_OUT.value = CmdActionList.DescriptorCreate_useSchemaInfo;
                                        return CommandType.DescriptorCreate_useSchemaInfo;

                                    default: throw new Exception_PersistenceError("Tried decoding the command, but it was not found. The command was: " + commandString);
                                }

                            default: throw new Exception_PersistenceError("Tried decoding the command, but it was not found. The command was: " + commandString);
                        }


                    case 'S': // Set operation

                        switch(commandString.charAt(2)) {
                            case 'f': // field
                                switch(commandString.charAt(3)) {
                                    case 'I': // DescriptorSetField_byIndex
                                        commandAction_OUT.value = CmdActionList.DescriptorSetField_ByIndex;
                                        return CommandType.DescriptorSetField_byIndex;

                                    case 'S': // DescriptorSetFields (multiple values)
                                        commandAction_OUT.value = CmdActionList.DescriptorSetFields;
                                        return CommandType.DescriptorSetFields;

                                    default: throw new Exception_PersistenceError("Tried decoding the command, but it was not found. The command was: " + commandString);
                                }

                            default: throw new Exception_PersistenceError("Tried decoding the command, but it was not found. The command was: " + commandString);
                        }

                    default: throw new Exception_PersistenceError("Tried decoding the command, but it was not found. The command was: " + commandString);
                }


            case 'O': // Object
                switch(commandString.charAt(1)) {
                    case 'C': // Create
                        switch(commandString.charAt(2)) {
                            case '_': // ObjectCreate
                                commandAction_OUT.value = CmdActionList.ObjectCreate;
                                return CommandType.ObjectCreate;
                                
                            /* // Unnecessary? delete later
                            case 'E':  // ObjectCreate_Existing
                                commandAction_OUT.value = CmdActionList.ObjectCreate_Existing;
                                return CommandType.ObjectCreate_Existing;
                            */
                            default: throw new Exception_PersistenceError("Tried decoding the command, but it was not found. The command was: " + commandString);
                        }
                    default: throw new Exception_PersistenceError("Tried decoding the command, but it was not found. The command was: " + commandString);
                }



            case 'S': // Symbol
                switch(commandString.charAt(1)) {

                    case 'C': // Create
                        switch(commandString.charAt(2)) {
                            case '_': // Std Symbol
                                commandAction_OUT.value = CmdActionList.SymbolCreate;
                                return CommandType.SymbolCreate;

                            case 'D': // DescriptorTag related symbols

                                switch(commandString.charAt(3)) {
                                    case 'n': // DescriptorTagName
                                        commandAction_OUT.value = CmdActionList.SymbolCreate_DescTagName;
                                        return CommandType.SymbolCreate_DescTagName;
                                    case 't': // DescriptorTag
                                        commandAction_OUT.value = CmdActionList.SymbolCreate_DescTag;
                                        return CommandType.SymbolCreate_DescTag;
                                    case 'p': // DescriptorPath
                                        commandAction_OUT.value = CmdActionList.SymbolCreate_DescPath;
                                        return CommandType.SymbolCreate_DescPath;
                                    default: throw new Exception_PersistenceError("Tried decoding the command, but it was not found. The command was: " + commandString);
                                }

                            case 'L': // Label
                                commandAction_OUT.value = CmdActionList.SymbolCreate_Label;
                                return CommandType.SymbolCreate_Label;

                            case 'S': // schema related symbols
                                switch(commandString.charAt(3)) {
                                    case 'n': // SchemaName
                                        commandAction_OUT.value = CmdActionList.SymbolCreate_SchemaName;
                                        return CommandType.SymbolCreate_SchemaName;

                                    case 'p': // SchemaPath
                                        commandAction_OUT.value = CmdActionList.SymbolCreate_SchemaPath;
                                        return CommandType.SymbolCreate_SchemaPath;

                                    default: throw new Exception_PersistenceError("Tried decoding the command, but it was not found. The command was: " + commandString);
                                }
                            default: throw new Exception_PersistenceError("Tried decoding the command, but it was not found. The command was: " + commandString);
                        }
                    default: throw new Exception_PersistenceError("Tried decoding the command, but it was not found. The command was: " + commandString);
                }

            default: throw new Exception_PersistenceError("Tried decoding the command, but it was not found. The command was: " + commandString);
        }

    }


}
