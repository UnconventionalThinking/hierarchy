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
public class PersistentMatricesExecutor_Server extends PersistentMatricesExecutor {
   

    public static void main(String[] args) throws Exception {

        String serverPropertiesFile_Path = null;
        boolean deletePersistentMatrices_onStartup = false;

        for (int i = 0; i < args.length; ++i) {
            String parameter = args[i];

            if (parameter != null && parameter.trim().equals("-propfilepath")) {
                String filePathArg = args[++i];
                if (filePathArg != null && filePathArg.trim().length() != 0) {
                    serverPropertiesFile_Path = filePathArg.trim();
                }
            }
            if (parameter != null && parameter.trim().equals("-deletepersistmatrices")) {
                deletePersistentMatrices_onStartup = true;
            }
        }

        PersistentMatricesExecutor_Server persistMatricesServer = new PersistentMatricesExecutor_Server(serverPropertiesFile_Path, deletePersistentMatrices_onStartup);
        persistMatricesServer.startServer();
        persistMatricesServer.awaitTermination_Indefinitely();
    }


    
    boolean deletePersistentMatrices_onStartup;
    PersistentMatricesManager_Server persistentMatricesManager_Server;


    public PersistentMatricesExecutor_Server(String serverPropertiesFile_Path, boolean deletePersistentMatrices_onStartup) {
        super(serverPropertiesFile_Path);
        this.deletePersistentMatrices_onStartup = deletePersistentMatrices_onStartup;
    }




    public PersistentMatricesManager_Server startServer() 
            throws Exception_FileUtilities_ProcessingError, Exception_FindTypeName, Exception_HierarchyCompiler, Exception_MetaCompilerError,
                Exception_PersistenceError, IOException {

        System.out.println("Starting PersistentMatrices Server");
        System.out.println("  Using properties file: " + propertiesFile_Path);

        PersistentMatricesManager_Configurator_Server serverConfigurator = new PersistentMatricesManager_Configurator_Server(
                propertiesFile_Path);
        persistentMatricesManager_Server = serverConfigurator.configure();

        if (deletePersistentMatrices_onStartup)
            persistentMatricesManager_Server.deletePersistentMatrices();

        persistentMatricesManager_Server.startServer();

        return persistentMatricesManager_Server;
    }


    public void awaitTermination_Indefinitely() throws InterruptedException {
        persistentMatricesManager_Server.awaitTermination_Indefinitely();
    }



    public boolean getDeletePersistentMatrices_onStartup() { return deletePersistentMatrices_onStartup; }

    public PersistentMatricesManager_Server getPersistentMatricesManager_Server() { return persistentMatricesManager_Server; }



}
