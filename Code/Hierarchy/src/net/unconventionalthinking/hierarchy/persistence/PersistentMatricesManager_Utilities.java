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
import java.io.IOException;
import net.unconventionalthinking.utilities.FileUtilities_Delete;

/**
 *
 * @author peterjoh
 */
public class PersistentMatricesManager_Utilities {

    public static long getTimeStamp_from_FileName(String chunkFileName, String chunkFile_BaseName) {
        String timeStamp_String = chunkFileName.substring(chunkFile_BaseName.length());

        return Long.parseLong(timeStamp_String);

    }


    public static long get_LogFileName_ShortenedTimestamp() {
        return System.currentTimeMillis() - PersistentMatricesManagerConstants.PERSISTENCE_FILENAME_TIMESTAMP__REMOVED_TIME;
    }



    /**
     * Multi-Threading Notes:
     *    This method needs both the ChunkFiles_Lock and the ControlSets_Lock. And the scope of both these locks is the entire method.
     *    Why? we don't want the list of chunk files to change while we're deleting chunks or control sets.
     */
    public static void delete_OldChunksAndControl(long chunks_OlderThan_TimeStamp, long control_OlderThan_TimeStamp,
            PersistentMatricesManager_Server persistenceServer) throws IOException {

        // delete old control
        File[] allChunkFiles = persistenceServer.getFromInbox_ChunkFiles();

        for (File chunkFile : allChunkFiles) {
            long timeStamp = PersistentMatricesManager_Utilities.getTimeStamp_from_FileName(chunkFile.getName(),
                    persistenceServer.getLogFileChunk_BaseName());

            if (timeStamp < chunks_OlderThan_TimeStamp)
                chunkFile.delete();
        }

        // delete old control
        File[] all_ControlDirectories = persistenceServer.getAll_ControlDirectories();

        for (File controlDir : all_ControlDirectories) {
            long timeStamp = PersistentMatricesManager_Utilities.getTimeStamp_from_FileName(controlDir.getName(),
                    persistenceServer.getPersistenceControl_DirBaseName());

            if (timeStamp < control_OlderThan_TimeStamp)
                FileUtilities_Delete.deltree(controlDir);
        }


    }

}
