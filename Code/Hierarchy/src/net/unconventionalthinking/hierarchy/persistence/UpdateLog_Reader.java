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

import net.unconventionalthinking.lang.Boolean_Mutable;
import net.unconventionalthinking.lang.Integer_Mutable;
import net.unconventionalthinking.lang.OutputParameter;
import net.unconventionalthinking.lang.io.ObjectInputStream_Utilities;
import net.unconventionalthinking.hierarchy.persistence.actions.CmdAction;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 *
 * @author peterjoh
 */
public class UpdateLog_Reader {

    
    private ObjectInputStream logFile_In;
    private CommandDecoder commandDecoder;

    public UpdateLog_Reader() {
        this.commandDecoder = new CommandDecoder();
    }
    

    public UpdateLog_Reader(ObjectInputStream logFile) {
        this();

        this.logFile_In = logFile;
    }

    public UpdateLog_Reader(File logFile_Obj) throws IOException {
        this();
        
        this.logFile_In = new ObjectInputStream(new FileInputStream(logFile_Obj));
    }






    public boolean hasCharactersToRead() throws IOException {
        return (logFile_In.available() != 0);
    }

    
    public Command readCommand() throws IOException, Exception_PersistenceError {
        
        String commandString = readCommandCode(true);
        Command command = null;
        CmdAction commandAction = null;

        if (commandString == null) {
            return null;
        }

        OutputParameter commandAction_OUT = new OutputParameter();
        CommandType commandType = commandDecoder.decode_CommandType(commandString, commandAction_OUT);
        commandAction = (CmdAction)commandAction_OUT.value;

        if (commandType == null || commandAction == null)
            throw new Exception_PersistenceError("Tried to read a command from the log file, but had an unexpected error. There was a command that could not be decoded. The command was, " +
                                                                commandString + ".");

        int cmdID = readCmdID();

        if (commandType == CommandType.CloseCmd) {
            command = new Command(commandType, cmdID, -1, null);

        } else {
            int logVarID = readLogVar_Assignment();

            if (commandType == CommandType.ObjectCreate) {
                Object object = null;
                try {
                    object = readValues_ObjectCreate();
                } catch (Exception e) {
                    throw new Exception_PersistenceError("Tried to read the object from the update log, but had an error.", e);
                }
                command = new Command(commandType, cmdID, logVarID, object, null);
            } else {
                Object[] params = readValues_Parameters();
                command = new Command(commandType, cmdID, logVarID, params);
            }
        }
        command.set_CmdAction(commandAction);

        
        readEndOfLine();

        return command;

    }

    public String readCommandCode(boolean ignorePreceding_WhiteSpace) throws IOException {

        char commandChar;
        String commandString;

        if (ignorePreceding_WhiteSpace) {
            Boolean_Mutable readWhiteSpaceChars = new Boolean_Mutable(false);
            Boolean_Mutable readOneCharPastWhiteSpace = new Boolean_Mutable(false);

            commandChar = ObjectInputStream_Utilities.ignoreWhiteSpace(logFile_In, readWhiteSpaceChars, readOneCharPastWhiteSpace);

            if (!readOneCharPastWhiteSpace.value && logFile_In.available() != 0)
                commandChar = logFile_In.readChar();

        } else {
            commandChar = logFile_In.readChar();
        }

        if (commandChar != '@')
            return null;

        commandString = ObjectInputStream_Utilities.readChars(logFile_In, CommandConstants.CommandLength);
        return commandString;

    }


    public int readCmdID() throws IOException, Exception_PersistenceError {

        ObjectInputStream_Utilities.readExpectedChar(logFile_In, ':', "cmd id", true);
        int cmdID = logFile_In.readInt();

        return cmdID;

    }

    /**
     *
     */
    public int readLogVar_Assignment() throws IOException, Exception_PersistenceError {


        ObjectInputStream_Utilities.readExpectedChar(logFile_In, ':', "log var name", true);
        int logVarID = logFile_In.readInt();
        ObjectInputStream_Utilities.readExpectedChar(logFile_In, '=', "log var name", false);

        return logVarID;

    }


    public Object[] readValues_Parameters() throws IOException, Exception_PersistenceError {

        int numParams = logFile_In.readInt();
        ObjectInputStream_Utilities.readExpectedChar(logFile_In, ':', "parameters", false);

        Object[] params = new Object[numParams];

        for (int i = 0; i < numParams; i++) {
            Object paramValue = null;

            if (i >= 1)
                ObjectInputStream_Utilities.readExpectedChar(logFile_In, ',', "parameters", false);

            char paramType = logFile_In.readChar();
            switch (paramType) {
                case CommandParamTypes.Null:
                    paramValue = null;
                    break;

                case CommandParamTypes.Int:
                    int intValue = logFile_In.readInt();
                    paramValue = new Integer(intValue);
                    break;

                case CommandParamTypes.String:
                    paramValue = logFile_In.readUTF();
                    break;


                default:
            }

            params[i] = paramValue;
        }

        return params;
    }

    
    public Object readValues_ObjectCreate() throws ClassNotFoundException, IOException {
        Object objValue = logFile_In.readObject();
        return objValue;
    }

    public void readEndOfLine() throws IOException, Exception_PersistenceError {

        ObjectInputStream_Utilities.readExpectedChar(logFile_In, ';', "end of line", false);
        ObjectInputStream_Utilities.readExpectedChar(logFile_In, '\n', "end of line", true);
    }





}
