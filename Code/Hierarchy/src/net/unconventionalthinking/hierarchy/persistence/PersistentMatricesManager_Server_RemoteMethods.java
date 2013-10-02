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
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author peterjoh
 */
public interface PersistentMatricesManager_Server_RemoteMethods extends Remote {

    void startServer(String userName, String password) throws RemoteException;
    /**
     * Tells the Server to stop processing, but if it's currently processing something, let it finish.
     * You need to call awaitTermination() to see if the shutdown of the monitor thread was successful.
     */
    void shutdownServer(String userName, String password) throws RemoteException;
    boolean awaitTerminationOfServer() throws RemoteException;
    void rebootServer(String userName, String password) throws RemoteException;


    boolean checkForAndProcessChunks(boolean sendClient_UpdatedPersistedMatrix_MetaSrcAndBuild)
            throws RemoteException, IOException, Exception_PersistenceEventHandler, Exception_PersistenceError;

    void generate_PersistedMatrixCode() throws RemoteException, IOException, Exception_PersistenceError, Exception_PersistenceEventHandler;
    void copy_ServerPersistedMatrix_to_Client() throws RemoteException, IOException;
    


}
