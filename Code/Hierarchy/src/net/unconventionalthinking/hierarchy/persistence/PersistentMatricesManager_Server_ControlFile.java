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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;



/**
 * Control File Structure:
 * _______________________
 * <timestamp of the last chunk file for this Processing Set> '\n'
 * <number of unprocessed chunks for this Processing Set> '\n'
 * then, the names of each chunk, each followed by a '\n'
 * then "XXXX" '\n' (that's the "XXXX" string and then a '\n' character)
 *
 *
 * @author peterjoh
 */
public class PersistentMatricesManager_Server_ControlFile {

    public static final String CONTROLFILE_CLOSING_STRING = "XXXX";

    public final int  numChunks;
    public final long chunkTimeStamp_First;
    public final long chunkTimeStamp_Last;
    public final long control_TimeStamp;

    public final List<File> chunkFiles;


    private String chunkFile_BaseName;
    private PersistentMatricesManager_Server persistenceServer;
    private File controlFileObj;
    private final Object controlSets_Lock;


    public static PersistentMatricesManager_Server_ControlFile writeNewControlFile_and_CreateNewControlFileObj(
            PersistentMatricesManager_Server persistenceServer, File controlFileObj, long control_TimeStamp,
            TreeMap<Long, File> processedChunks_OrderedMap, String chunkFileBaseName)
            throws IOException {


        //  Write out control file__________________________________________
        if (processedChunks_OrderedMap.size() > 0) {

            synchronized (persistenceServer.controlSets_Lock) {
                ObjectOutputStream newControlFile_Out = new ObjectOutputStream(new FileOutputStream(controlFileObj));

                //  <timestamp of last chunk>
                String lastTimeStamp_String = processedChunks_OrderedMap.get(processedChunks_OrderedMap.lastKey())
                                                                    .getName().substring(chunkFileBaseName.length());
                Long lastTimeStamp = Long.parseLong(lastTimeStamp_String);
                newControlFile_Out.writeLong(lastTimeStamp);
                newControlFile_Out.writeChar('\n');

                //  <number of unprocessed chunks>
                newControlFile_Out.writeInt(processedChunks_OrderedMap.size());
                newControlFile_Out.writeChar('\n');

                //  write out names of each chunk file
                for (File processedChunkFile : processedChunks_OrderedMap.values()) {
                    newControlFile_Out.writeUTF(processedChunkFile.getName());
                    newControlFile_Out.writeChar('\n');
                }

                //  write out closing characters
                newControlFile_Out.writeUTF(CONTROLFILE_CLOSING_STRING);
                newControlFile_Out.writeChar('\n');


                newControlFile_Out.close();


                String firstTimeStamp_String = processedChunks_OrderedMap.get(processedChunks_OrderedMap.firstKey())
                                                                        .getName().substring(chunkFileBaseName.length());
                Long firstTimeStamp = Long.parseLong(firstTimeStamp_String);

                PersistentMatricesManager_Server_ControlFile persistentControlFile = new PersistentMatricesManager_Server_ControlFile(controlFileObj,
                        persistenceServer, processedChunks_OrderedMap.size(), firstTimeStamp, lastTimeStamp,
                        control_TimeStamp);
                return persistentControlFile;
                
            }  //  end of synchronized ()
        }

        return null;
    }


    public static PersistentMatricesManager_Server_ControlFile loadControlFile(File validControlFile) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public PersistentMatricesManager_Server_ControlFile(File controlFileObj, PersistentMatricesManager_Server persistenceServer,
            int numChunks, long chunkTimeStamp_First, long chunkTimeStamp_Last, long control_TimeStamp) {
        this.persistenceServer = persistenceServer;
        this.controlFileObj = controlFileObj;
        this.controlSets_Lock = persistenceServer.controlSets_Lock;
        
        this.numChunks = numChunks;
        this.chunkTimeStamp_First = chunkTimeStamp_First;
        this.chunkTimeStamp_Last = chunkTimeStamp_Last;
        this.control_TimeStamp = control_TimeStamp;

        this.chunkFiles = new ArrayList<File>();
    }


    public void setChunkFiles(List<String> chunkFileNames_OUT, String server_ChunkInbox_DirPath, String chunkFileBaseName) {
        for (String chunkFileName : chunkFileNames_OUT) {
            chunkFiles.add(new File(server_ChunkInbox_DirPath, chunkFileName));
        }

        this.chunkFile_BaseName = chunkFileBaseName;
    }

    public boolean checkIfChunkFilesExist() {
        for (File chunkFile : chunkFiles) {
            if (!chunkFile.exists())
                return false;
        }
        return true;
    }
    

    TreeMap<Long, File> determine_UnprocessedChunks(File[] currInboxChunks_FileList) {

        TreeMap<Long, File> unprocessedChunks_OrderedMap = new TreeMap<Long, File>();

        for(File chunkFile : currInboxChunks_FileList) {
            try {
                long timeStamp = PersistentMatricesManager_Utilities.getTimeStamp_from_FileName(chunkFile.getName(), chunkFile_BaseName);
                if (timeStamp > chunkTimeStamp_Last)
                    unprocessedChunks_OrderedMap.put(timeStamp, chunkFile);
            } catch (NumberFormatException e) {
                throw new ExceptRuntime_PersistenceManagerError("Had a chunk with a Bad timestamp: " + chunkFile.getName());
            }
        }
        return unprocessedChunks_OrderedMap;
    }



    //  _________________________________________________________________________________________________________________________________________
    //
    //    STATIC UTILITY METHODS
    //  _________________________________________________________________________________________________________________________________________

    public static PersistentMatricesManager_Server_ControlFile validateFile_and_Load(File controlFile, String controlFileNameBase,
            String chunkFileName_Base, PersistentMatricesManager_Server persistServer,
            List<String> chunkFileNames_OUT, OutputParameter controlFile_ValidationError_OUT) {

        synchronized(persistServer.controlSets_Lock) {

            PersistentMatricesManager_Server_ControlFile persistControlFile = null;
            Exception controlFile_Exception = null;

            int actual_ChunkFileName_Count = 0;
            long chunkTimeStamp = -1;
            long first_TimeStamp = -1;

            try {
                ObjectInputStream controlFile_In = new ObjectInputStream(new FileInputStream(controlFile));

                char ch;

                Long expected_LastChunk_TimeStamp = controlFile_In.readLong();
                ch = controlFile_In.readChar();
                if (ch != '\n') controlFile_Exception = new Exception_PersistenceError("Control file (" + controlFile.getName() + ") has an invalid format. Expected a newline after the " +
                            "'last chunk timestamp', but it was something different.");
                int expected_ChunkFileName_Count = controlFile_In.readInt();
                ch = controlFile_In.readChar();
                if (ch != '\n') controlFile_Exception = new Exception_PersistenceError("Control file (" + controlFile.getName() + ") has an invalid format. Expected a newline after the " +
                            "'number of chunks', but it was something different.");


                boolean reached_LastLine = false;
                boolean invalidNameFound;
                boolean is_FirstIter = true;


                do {
                    invalidNameFound = true; // prove that this is false!

                    String chunkFileName = controlFile_In.readUTF();
                    ch = controlFile_In.readChar();
                    if (ch != '\n') controlFile_Exception = new Exception_PersistenceError("Control file (" + controlFile.getName() + ") has an invalid format. Expected a newline after the " +
                                "'the chunk file name', but it was something different. The chunk file name was: " + chunkFileName + ".");


                    if (!chunkFileName.equals(CONTROLFILE_CLOSING_STRING)) {

                        //  check the chunkfile name
                        if (chunkFileName.startsWith(chunkFileName_Base)) {
                            try {
                                chunkTimeStamp = Long.parseLong(chunkFileName.substring(chunkFileName_Base.length()));

                                invalidNameFound = false;

                                chunkFileNames_OUT.add(chunkFileName);
                                if (is_FirstIter)
                                    first_TimeStamp = chunkTimeStamp;

                                actual_ChunkFileName_Count++;
                            } catch (NumberFormatException e) {
                                controlFile_Exception = new Exception_PersistenceError("Control file (" + controlFile.getName() + ") has an invalid format. A chunk file name had an invalid timestamp. " +
                                    "The chunk file name was: " + chunkFileName + ".");
                            }

                        } else {
                            controlFile_Exception = new Exception_PersistenceError("Control file (" + controlFile.getName() + ") has an invalid format. A chunk file name had the wrong base name. " +
                                "The chunk file name was: " + chunkFileName + ".");
                        }

                    } else { // last line "XXXX"
                        reached_LastLine = true;

                        if (actual_ChunkFileName_Count != expected_ChunkFileName_Count)
                            controlFile_Exception = new Exception_PersistenceError("Control file (" + controlFile.getName() + ") has an invalid format. The number of actual chunks is not the expected number. The expected number was" +
                                    + expected_ChunkFileName_Count + ", and the actual number was " + actual_ChunkFileName_Count + ".");

                        if (chunkTimeStamp != expected_LastChunk_TimeStamp)
                            controlFile_Exception = new Exception_PersistenceError("Control file (" + controlFile.getName() + ") has an invalid format. The timestamp of the newest (and last chunk) listed in the control file was not the expected value. The expected time stamp was " +
                                    + expected_LastChunk_TimeStamp + ", and the actual timestamp of the last chunk file name listed was " + chunkTimeStamp + ".");

                    }

                    if (is_FirstIter)
                        is_FirstIter = false;

                } while (!reached_LastLine && !invalidNameFound && controlFile_Exception == null);



            } catch (Exception e) {
                controlFile_Exception = new Exception_PersistenceError("We received an unexpected error while checking if the control file (" + controlFile.getName() + ") was valid (see inner exception).", e);
            }

            controlFile_ValidationError_OUT.value = controlFile_Exception;
            persistControlFile = new PersistentMatricesManager_Server_ControlFile(controlFile, persistServer, actual_ChunkFileName_Count, first_TimeStamp,
                    chunkTimeStamp,
                    PersistentMatricesManager_Utilities.getTimeStamp_from_FileName(controlFile.getName(), controlFileNameBase));

            return persistControlFile;
            
        } // end of synchronized (controlSets_Lock)
    }

}
