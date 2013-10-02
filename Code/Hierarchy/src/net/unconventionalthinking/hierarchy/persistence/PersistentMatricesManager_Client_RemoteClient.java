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

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import net.unconventionalthinking.rmi.RmiClient;

/**
 * I normally hate classes that are just wrappers with little in them, but the reason for this one is to provide a little bit of abstraction
 * from the remoting technology used. This way, we're not tied to rmi or web services or whatever.
 * 
 * @author peterjoh
 */
public class PersistentMatricesManager_Client_RemoteClient extends PersistentMatricesManager_RemoteService_Base{

    /**  Use default rmi registery host of localhost, default port of 1099 */
    public PersistentMatricesManager_Client_RemoteClient() { this(null, -1); }
    /**  Use default rmi registery port of 1099 */
    public PersistentMatricesManager_Client_RemoteClient(String rmiRegistery_HostName) {
        this(rmiRegistery_HostName, -1);
    }
    /** if pass in a host with 'null', by default, localhost is used */
    public PersistentMatricesManager_Client_RemoteClient(String rmiRegistery_HostName, int rmiRegistery_Port) {
        super(rmiRegistery_HostName, rmiRegistery_Port);
    }

    public PersistentMatricesManager_Server_RemoteMethods getRemoteMethodsService_ProxyObj()
        throws RemoteException, NotBoundException {
        
        return (PersistentMatricesManager_Server_RemoteMethods)RmiClient.getRemoteMethodsService_ProxyObj(
                PersistentMatricesManagerConstants.RMI_REGISTRYENTRY__REMOTEMETHODS_STUBOBJ,
                rmiRegistery_HostName, rmiRegistery_Port);
    }


}
