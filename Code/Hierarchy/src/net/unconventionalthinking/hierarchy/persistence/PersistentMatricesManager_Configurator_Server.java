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

/**
 *
 * @author Peter Joh
 */
public class PersistentMatricesManager_Configurator_Server  extends PersistentMatricesManager_Configurator {


    public PersistentMatricesManager_Configurator_Server(String propertiesFile_Path) throws IOException {
        super(propertiesFile_Path);

    }

    @Override
    public PersistentMatricesManager_Server configure() throws IOException {
        System.out.println("Setting up Server using Configurator");
        //  Do all the client specific config of the client
        super.persistentMatricesManager = new PersistentMatricesManager_Server();
        PersistentMatricesManager_Server persistentMatricesManager_ServerRef = (PersistentMatricesManager_Server)persistentMatricesManager;

        persistentMatricesManager_ServerRef.setPersistenceControl_RootDir(
            properties.checkAndGetRequiredProperty_String(FieldName.PersistenceControl_RootDir.toString()));
        if (properties.propertyExists(FieldName.PersistenceControl_DirBaseName.toString()))
            persistentMatricesManager_ServerRef.setPersistenceControl_DirBaseName(
                properties.checkAndGetRequiredProperty_String(FieldName.PersistenceControl_DirBaseName.toString()));
        if (properties.propertyExists(FieldName.PersistenceControl_FileBaseName.toString()))
            persistentMatricesManager_ServerRef.setPersistenceControl_FileBaseName(
                properties.checkAndGetRequiredProperty_String(FieldName.PersistenceControl_FileBaseName.toString()));

        persistentMatricesManager_ServerRef.setClient__SrcMetaCode_BaseDir(
            properties.checkAndGetRequiredProperty_String(FieldName.Client__SrcMetaCode_BaseDir.toString()));
        persistentMatricesManager_ServerRef.setClient__BuildMeta_BaseDir(
            properties.checkAndGetRequiredProperty_String(FieldName.Client__BuildMeta_BaseDir.toString()));
        if (properties.propertyExists(FieldName.Client__BuildFinal_BaseDir.toString()))
            persistentMatricesManager_ServerRef.setClient__BuildFinal_BaseDir(
                properties.checkAndGetRequiredProperty_String(FieldName.Client__BuildFinal_BaseDir.toString()));


        //  Do the rest of the config
        super.finishConfigure();

        return persistentMatricesManager_ServerRef;
    }




    public enum FieldName {
        PersistenceControl_RootDir("persist.server.persistencecontrol.rootdir"),
        PersistenceControl_DirBaseName("persist.server.persistencecontrol.dirbasename"),
        PersistenceControl_FileBaseName("persist.server.persistencecontrol.filebasename"),

        Client__SrcMetaCode_BaseDir("persist.client.source.metacode.basedir"),
        Client__BuildMeta_BaseDir("persist.client.build.meta.basedir"),
        Client__BuildFinal_BaseDir("persist.client.build.final.basedir");

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
