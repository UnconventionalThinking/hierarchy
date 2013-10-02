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
import net.unconventionalthinking.hierarchy.HierarchyMetaCompiler_Configurator;
import net.unconventionalthinking.hierarchy.config.Configurator;

/**
 *
 * @author Peter Joh
 */
public abstract class PersistentMatricesManager_Configurator extends Configurator {

    
    public PersistentMatricesManager_Configurator(String propertiesFile_Path) throws IOException{
        super(propertiesFile_Path);
    }

    PersistentMatricesManager persistentMatricesManager;


    /**
     * This method should never be called directly by client objects, only by child configurator classes.
     */
    void finishConfigure() throws IOException {

        //  Setup Client
        persistentMatricesManager.setPersistenceServer_LogFileChunk_InboxDir(
            properties.checkAndGetRequiredProperty_String(FieldName.PersistenceServer_LogFileChunk_InboxDir.toString()));
        persistentMatricesManager.setChunkCheck_Interval__Initial_ms(
            properties.checkAndGetRequiredProperty_Int(FieldName.ChunkCheck_Interval__Initial_ms.toString()));
        persistentMatricesManager.setChunkCheck_Interval_ms(
            properties.checkAndGetRequiredProperty_Int(FieldName.ChunkCheck_Interval_ms.toString()));

        if (properties.propertyExists(FieldName.RmiRegistery_HostName.toString()))
            persistentMatricesManager.setRmiRegistery_HostName(
                properties.checkAndGetRequiredProperty_String(FieldName.RmiRegistery_HostName.toString()));
        if (properties.propertyExists(FieldName.RmiRegistery_Port.toString()))
            persistentMatricesManager.setRmiRegistery_Port(
                properties.checkAndGetRequiredProperty_Int(FieldName.RmiRegistery_Port.toString()));

        //  Configure the client persistence meta-compiler. Use the metacompiler configurator
        HierarchyMetaCompiler_Configurator metaCompilerConfigurator = new HierarchyMetaCompiler_Configurator(properties,
                persistentMatricesManager.hierarchyMetaCompiler);
        metaCompilerConfigurator.configure();

    }




    public enum FieldName {
        PersistenceServer_LogFileChunk_InboxDir("persist.server.logfilechunk.inbox.dir"),
        ChunkCheck_Interval__Initial_ms("persist.chunkcheck.interval.initial.ms"),
        ChunkCheck_Interval_ms("persist.chunkcheck.interval.ms"),

        RmiRegistery_HostName("persist.rmi.registery.hostname"),
        RmiRegistery_Port("persist.rmi.registery.port ");

        
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
