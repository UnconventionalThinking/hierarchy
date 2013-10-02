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
import net.unconventionalthinking.hierarchy.Exception_HierarchyCompiler;
import net.unconventionalthinking.hierarchy.langsymboltable.Exception_FindTypeName;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.utilities.Exception_FileUtilities_ProcessingError;

/**
 * Use this class to run the Persistence Server standalone, in it's own JVM.
 *
 * In addition, this is a convenience / facade class for setting up and running the Persistence Server that you can call from code.
 * 
 * @author Peter Joh
 */
public class PersistentMatricesExecutor_Client extends PersistentMatricesExecutor {
   

    public static void main(String[] args) throws Exception {

        String clientPropertiesFile_Path = null;
        boolean updateClientMetaSrc = false;
        boolean updateServerMetaSrc = false;

        for (int i = 0; i < args.length; ++i) {
            String parameter = args[i];

            if (parameter != null && parameter.trim().equals("-propfilepath")) {
                String filePathArg = args[++i];
                if (filePathArg != null && filePathArg.trim().length() != 0) {
                    clientPropertiesFile_Path = filePathArg.trim();
                }
            }
            if (parameter != null && parameter.trim().equals("-updateClientMetaSrc"))
                updateClientMetaSrc = true;
            if (parameter != null && parameter.trim().equals("-updateServerMetaSrc"))
                updateServerMetaSrc = true;

        }

        PersistentMatricesExecutor_Client persistMatrices_ClientExec = new PersistentMatricesExecutor_Client(clientPropertiesFile_Path);
        if (updateServerMetaSrc)
            persistMatrices_ClientExec.updateServerCode_fromClient();
        if (updateClientMetaSrc)
            persistMatrices_ClientExec.updateClientCode_fromServer();
    }


    
    PersistentMatricesManager_Client persistentMatricesManager_Client;


    public PersistentMatricesExecutor_Client(String clientPropertiesFile_Path) {
        super(clientPropertiesFile_Path);
    }



    public PersistentMatricesManager_Client updateClientCode_fromServer()
            throws Exception_FileUtilities_ProcessingError, Exception_FindTypeName, Exception_HierarchyCompiler, Exception_MetaCompilerError,
                Exception_PersistenceError, IOException, Exception_PersistenceEventHandler {

        System.out.println("Updating the Persistent Matrices for the Client");
        System.out.println("  Using properties file: " + propertiesFile_Path);

        PersistentMatricesManager_Configurator_Client clientConfigurator = new PersistentMatricesManager_Configurator_Client(propertiesFile_Path);
        persistentMatricesManager_Client = clientConfigurator.configure();

        persistentMatricesManager_Client.printSettings();
        persistentMatricesManager_Client.initialize1_REQUIRED();
        persistentMatricesManager_Client.initialize2_UpdatePersistentMatrices();

        return persistentMatricesManager_Client;
    }



    public PersistentMatricesManager_Client getPersistentMatricesManager_Client() {
        return persistentMatricesManager_Client;
    }

    private void updateServerCode_fromClient() {
        throw new UnsupportedOperationException("Not yet implemented");
    }



}
