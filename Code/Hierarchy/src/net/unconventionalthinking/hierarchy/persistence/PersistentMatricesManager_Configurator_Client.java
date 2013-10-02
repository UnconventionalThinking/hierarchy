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

import java.io.IOException;
import net.unconventionalthinking.matrix.MatrixControl;

/**
 *
 * @author Peter Joh
 */
public class PersistentMatricesManager_Configurator_Client extends PersistentMatricesManager_Configurator {

    MatrixControl matrixControl;

    /**
     * Use this constructor for the "update client src-code" client. More specifically, this is the code called by the
     * PersistentMatricesExecutor_Client, to do the updates of the client src code from the server.
     */
    public PersistentMatricesManager_Configurator_Client(String propertiesFile_Path) throws IOException {
        super(propertiesFile_Path);
    }
    /**
     * Use this constructor in the main client application. A developer's code that needs act as a client to a persistent server (meaning,
     * it needs to read and write to a persistent matrix) will use this constructor, passing in the matrix control for the app.
     */
    public PersistentMatricesManager_Configurator_Client(String propertiesFile_Path, MatrixControl matrixControl) throws IOException {
        super(propertiesFile_Path);

        this.matrixControl = matrixControl;
    }


    @Override
    public PersistentMatricesManager_Client configure() throws IOException {
        System.out.println("Setting up Client using Configurator");
        
        //  Do all the client specific config of the client
        //  NOTE: if the PersistentMatricesManager_Configurator_Client(String propertiesFile_Path) is used to build this configurator,
        //  then the matrixControl reference will be null! this is okay, because if we're using this constructor, then we won't be doing anything
        //  with matrices anyway, just doing updates to client src.
        super.persistentMatricesManager = new PersistentMatricesManager_Client(
                properties.checkAndGetRequiredProperty_String(FieldName.PersistentClient_UpdateLog_DirPath.toString()),
                properties.checkAndGetRequiredProperty_String(FieldName.PersistentClient_UpdateLog_FileName.toString()),
                true, matrixControl);
        PersistentMatricesManager_Client persistentMatricesManager_ClientRef = (PersistentMatricesManager_Client)persistentMatricesManager;

        persistentMatricesManager_ClientRef.setChunkSizeBoundary_LineCount(
                properties.checkAndGetRequiredProperty_Int(FieldName.ChunkSizeBoundary_LineCount.toString()));

        //  Do the rest of the config
        super.finishConfigure();

        return persistentMatricesManager_ClientRef;
    }




    public enum FieldName {
        PersistentClient_UpdateLog_DirPath("persist.client.updatelog.dir"),
        PersistentClient_UpdateLog_FileName("persist.client.updatelog.filename"),
        ChunkSizeBoundary_LineCount("persist.client.chunk.sizeboundary.linecount");

        private String propertyFile_FieldName;
        private FieldName(String propertyFile_FieldName) {
            this.propertyFile_FieldName = propertyFile_FieldName;
        }

        @Override
        public String toString() {
            return propertyFile_FieldName;
        }
    }


}
