package com.williespetstore;



import net.unconventionalthinking.hierarchy.persistence.PersistentMatricesExecutor_Server;
import net.unconventionalthinking.hierarchy.persistence.PersistentMatricesManager_Server;

/**
 *
 * @author Peter Joh
 */
public class _ServerRunner {

    public static final String ServerPropertiesFile_Path = "../PersistentMatrix_WebSample/server-matrix-persistence.properties";

    static PersistentMatricesManager_Server persistManager_Server;


    public static void main(String[] args) throws Exception {

        boolean deletePersistentMatrices_onStartup = false;
        PersistentMatricesExecutor_Server persistMatricesServer_Main = new PersistentMatricesExecutor_Server(ServerPropertiesFile_Path,
                deletePersistentMatrices_onStartup);

        persistManager_Server = persistMatricesServer_Main.startServer();
    }
}
