package com.williespetstore;

import net.unconventionalthinking.hierarchy.persistence.PersistentMatricesExecutor_Client;
import net.unconventionalthinking.hierarchy.persistence.PersistentMatricesManager_Client;

/**
 *
 * @author Peter Joh
 */
public class _ClientUpdater {

    public static final String ClientPropertiesFile_Path = "web/WEB-INF/client-matrix-persistence.properties";

    static PersistentMatricesManager_Client persistManager_Client;

    public static void main(String[] args) throws Exception {

        PersistentMatricesExecutor_Client clientExecutor = new PersistentMatricesExecutor_Client(ClientPropertiesFile_Path);

        persistManager_Client = clientExecutor.updateClientCode_fromServer();
    }
}
