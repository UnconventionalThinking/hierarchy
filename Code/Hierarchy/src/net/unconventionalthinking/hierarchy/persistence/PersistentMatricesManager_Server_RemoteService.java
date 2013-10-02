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

import net.unconventionalthinking.rmi.RmiServer;
import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;



/**
 * Provides remote server methods through rmi to client.
 * NOTE:  The first time a client is run (or whenenver the PersistentMatricesManager_Server_RemoteMethods), the rmi_registery must be started first so client
 * can get stub object.
 *
 * 1. start rmiregistery:
 *   in your terminal, cd to the base directory where the class file for PersistentMatricesManager_Server_RemoteMethods.class is located. then type in:
 *     rmiregistry -J-classpath -J.&
 * 2. run the server.
 *    If you get following this error, it means the registry was not started in the right directory.
 *    Make sure "net.unconventionalthinking.hierarchy.persistence.PersistentMatricesManager_Server_RemoteMethods" is in the correct subdir of the dir where you started rmiregistery.
 *    ERROR:
 *        java.rmi.ServerException: RemoteException occurred in server thread; nested exception is:
 *        java.rmi.UnmarshalException: error unmarshalling arguments; nested exception is:
 *        java.lang.ClassNotFoundException: net.unconventionalthinking.hierarchy.persistence.PersistentMatricesManager_Server_RemoteMethods
 * 3. run the client.
 *
 * @author peterjoh
 */
public class PersistentMatricesManager_Server_RemoteService extends PersistentMatricesManager_RemoteService_Base
        implements PersistentMatricesManager_Server_RemoteMethods {

    private PersistentMatricesManager_Server    persistServer;
    private RmiServer                           remoteServices_Server;
    private PersistentMatricesManager_Server_RemoteMethods remotePersistServerMethods_Stub;


    //  ______________________________________________________________________________________________________________________
    //
    //  Constructor and setup methods
    //  ______________________________________________________________________________________________________________________


    /**  Use default rmi registery host of localhost, default port of 1099 */
    public PersistentMatricesManager_Server_RemoteService(PersistentMatricesManager_Server persistServer)  {
        this(persistServer, null, -1);
    }
    /**  Use default rmi registery port of 1099 */
    public PersistentMatricesManager_Server_RemoteService(PersistentMatricesManager_Server persistServer, String rmiRegistery_HostName) {
        this(persistServer, rmiRegistery_HostName, -1);
    }
    public PersistentMatricesManager_Server_RemoteService(PersistentMatricesManager_Server persistServer, String rmiRegistery_HostName, int rmiRegistery_Port) {
        super(rmiRegistery_HostName, rmiRegistery_Port);
        this.persistServer = persistServer;
    }



    public void setRmiRegistery_HostName(String rmiRegistery_HostName) { this.rmiRegistery_HostName = rmiRegistery_HostName; }
    public void setRmiRegistery_Port(int rmiRegistery_Port) { this.rmiRegistery_Port = rmiRegistery_Port; }



    //  ______________________________________________________________________________________________________________________
    //
    //  Service Management methods
    //  ______________________________________________________________________________________________________________________


    public void startService() throws AlreadyBoundException, RemoteException {
        remoteServices_Server = new RmiServer(rmiRegistery_HostName, rmiRegistery_Port);
        remotePersistServerMethods_Stub = (PersistentMatricesManager_Server_RemoteMethods)remoteServices_Server.registerService(this,
                PersistentMatricesManagerConstants.RMI_REGISTRYENTRY__REMOTEMETHODS_STUBOBJ);
    }

    
    public void stopService() throws NotBoundException, RemoteException {
        remoteServices_Server.unregisterService(this, PersistentMatricesManagerConstants.RMI_REGISTRYENTRY__REMOTEMETHODS_STUBOBJ, true);
    }


    public String getRmiRegistery_HostName() { return rmiRegistery_HostName; }
    public int getRmiRegistery_Port() { return rmiRegistery_Port; }
    public PersistentMatricesManager_Server_RemoteMethods getRemotePersistServerMethods_Stub() { return remotePersistServerMethods_Stub; }


    //  ______________________________________________________________________________________________________________________
    //
    //  Remotely Available Methods
    //  ______________________________________________________________________________________________________________________

    public void startServer(String userName, String password) throws RemoteException {
        throw new UnsupportedOperationException("Start Server is not supported yet.");
    }
    public void shutdownServer(String userName, String password) throws RemoteException {
        try {
            persistServer.shutdown();
        } catch (Exception e) {
            throw new RemoteException("Error while trying to shutdown.", e);
        }
    }
    public boolean awaitTerminationOfServer() throws RemoteException {
        try {
            return persistServer.awaitTermination();
        } catch (Exception e) {
            throw new RemoteException("Error while waiting for the server to shutdown.", e);
        }
    }
    
    public void rebootServer(String userName, String password) throws RemoteException {
        throw new UnsupportedOperationException("Start Server is not supported yet.");
    }

    
    public boolean checkForAndProcessChunks(boolean sendClient_UpdatedPersistedMatrix_MetaSrcAndBuild)
            throws RemoteException, IOException, Exception_PersistenceEventHandler, Exception_PersistenceError  {
        return persistServer.checkForAndProcessChunks(sendClient_UpdatedPersistedMatrix_MetaSrcAndBuild);
    }

    public void generate_PersistedMatrixCode() throws RemoteException, IOException, Exception_PersistenceError, Exception_PersistenceEventHandler {
        persistServer.generate_PersistedMatrixCode();
    }

    public void copy_ServerPersistedMatrix_to_Client() throws RemoteException, IOException {
        persistServer.copy_ClientPersistedMatrixSrcDir_to_Server();
    }

}
