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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.locks.ReentrantLock;




/**
 *
 * @author peterjoh
 */
public class UpdateLog_Writer {

    private final String logFile_DirPath;
    private final String logFileName;
    private final String fullLogFilePath;

    private volatile File logFile;
    private volatile ObjectOutputStream logFile_Out;

    private volatile long logFile_UsageStartTime;

    private ReentrantLock updateLogFile_Lock;


    private volatile int lineCount;


    //  A filelock is not really necessary. This is more if thre are multiple file objects (or multiple processes) trying to write to the same file.

    //private FileChannel fileChannel;
    //private FileLock fileLock;





    public UpdateLog_Writer(String logFile_DirPath, String logFileName, boolean replaceExistingFile) throws IOException {

        this.updateLogFile_Lock = new ReentrantLock();

        this.logFile_DirPath = logFile_DirPath;
        this.logFileName = logFileName;
        this.fullLogFilePath = logFile_DirPath + File.separator + logFileName;

        createNewLogFile(false);
    }





    //  ______________________________________________________________________________________________________________________
    //
    //  Write Command Methods
    //  ______________________________________________________________________________________________________________________



    public void writeCommand_Method(Command cmd) throws IOException {

        try {
            // The first thing this will do is get the reentrant lock
            writeCommand_Start(cmd);

            logFile_Out.writeInt(cmd.params.length); // the num of params
            logFile_Out.writeChar(':');


            boolean notFirstIter = false;
            for (Object param : cmd.params) {
                if (notFirstIter)
                    logFile_Out.writeChar(',');

                if (param == null) {
                    logFile_Out.writeChar(CommandParamTypes.Null);
                } else if (param instanceof Integer) {
                    logFile_Out.writeChar(CommandParamTypes.Int);
                    logFile_Out.writeInt(((Integer)param).intValue());
                } else {
                    logFile_Out.writeChar(CommandParamTypes.String);
                    logFile_Out.writeUTF((String)param);
                }
                notFirstIter = true;
            }


            logFile_Out.writeChar(';');
            logFile_Out.writeChar('\n');

            lineCount++;

        } finally {
            writeCommand_End(); // this will release the reentrant lock
        }

    }


    public void writeCommand_ObjectCreate(Command cmd) throws IOException {

        try {
            // The first thing this will do is get the reentrant lock
            writeCommand_Start(cmd);

            logFile_Out.writeObject(cmd.objValue);

            logFile_Out.writeChar(';');
            logFile_Out.writeChar('\n');

            lineCount++;

        } finally {
            writeCommand_End(); // this will release the reentrant lock
        }

    }

    

    public void closeCommand(int cmdID) throws IOException {

        updateLogFile_Lock.lock();
        try {
            logFile_Out.writeChars("@" + CommandType.CloseCmd.getCommandString() + ":");
            logFile_Out.writeInt(cmdID);
            logFile_Out.writeChar(';');
            logFile_Out.writeChar('\n');
            logFile_Out.flush();
            lineCount++;

        } finally {
            updateLogFile_Lock.unlock();
        }
    }



    //  Write Command Private Helper Methods
    //  ______________________________________________________________________________________________________________________

    private void writeCommand_Start(Command cmd) throws IOException {

        updateLogFile_Lock.lock();

        // UNUSED  - Use the file channel to create a lock on the file. This method blocks until it can retrieve the lock.
        //fileLock = fileChannel.lock();

        logFile_Out.writeChars("@" + cmd.cmdType.getCommandString() + ":");
        logFile_Out.writeInt(cmd.cmdID);
        logFile_Out.writeChar(':');
        logFile_Out.writeInt(cmd.logVarID);
        logFile_Out.writeChar('=');

    }


    private void writeCommand_End() {
        // UNUSED - Release the file lock
        // fileLock.release();

        updateLogFile_Lock.unlock();
    }



    //  ______________________________________________________________________________________________________________________
    //
    //  LogFile-related Methods
    //  ______________________________________________________________________________________________________________________

    public void closeLogFile_OutStream() throws IOException {
        updateLogFile_Lock.lock();

        try {
            //fileChannel.close();
            logFile_Out.close();

        } finally {
            updateLogFile_Lock.unlock();
        }
    }

    

    public final void createNewLogFile(boolean replaceExistingFile) throws IOException {
        
        updateLogFile_Lock.lock();

        try {
            if (logFile_Out != null)
                logFile_Out.close(); // can this be called multiple times?

            logFile = new File(fullLogFilePath);

            if (logFile.exists() && replaceExistingFile) {
                logFile.delete();
                logFile.createNewFile();
            } else {
                // do nothing, use the existing file.
            }

            logFile_Out = new ObjectOutputStream(new FileOutputStream(logFile));
            logFile_UsageStartTime = System.currentTimeMillis();
            //this.fileChannel = new RandomAccessFile(logFile, "rw").getChannel();

            lineCount = 0;


        } finally {
            updateLogFile_Lock.unlock();
        }
    }

    public File getLogFile() { return logFile; }


   
    //  ______________________________________________________________________________________________________________________
    //
    //  Get and Set Methods
    //  ______________________________________________________________________________________________________________________

    public String getLogFileFullPath() { return fullLogFilePath; }
    public String getLogFileName() { return logFileName; }
    public String getLogFile_DirPath() { return logFile_DirPath; }

    public int getLineCount() { return lineCount; }

    public long getLogFile_UsageStartTime() { return logFile_UsageStartTime; }



    //  ______________________________________________________________________________________________________________________
    //
    //  Private Helper Methods
    //  ______________________________________________________________________________________________________________________
    /**
     * This method should be used with care. This is so other objects like the PersistenceManager_Client can lock/unlock the log file when it needs to do
     * a chunk switch
     */
    void updateLogFileLock__Lock() {
        updateLogFile_Lock.lock();
    }
    /**
     * This method should be used with care. This is so other objects like the PersistenceManager_Client can lock/unlock the log file when it needs to do
     * a chunk switch
     */
    void updateLogFileLock__Unlock() {
        updateLogFile_Lock.unlock();
    }





}
