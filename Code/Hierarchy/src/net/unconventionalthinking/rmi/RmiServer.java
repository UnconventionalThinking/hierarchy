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

package net.unconventionalthinking.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Peter Joh
 */
public class RmiServer {

    private String rmiRegistery_HostName;
    private int rmiRegistery_Port;

    public RmiServer() {
        this(null, -1);
    }

    public RmiServer(String rmiRegistery_HostName) {
        this(rmiRegistery_HostName, -1);
    }

    public RmiServer(String rmiRegistery_HostName, int rmiRegistery_Port) {
        this.rmiRegistery_HostName = rmiRegistery_HostName;
        this.rmiRegistery_Port = rmiRegistery_Port;
    }

    public Remote registerService(Remote remoteObjectToRegister, String serviceName) throws AlreadyBoundException, RemoteException {
        return registerService(remoteObjectToRegister, 0, serviceName);
    }

    public Remote registerService(Remote remoteObjectToRegister, int port, String serviceName) throws AlreadyBoundException, RemoteException {
        Remote remoteMethods_Stub = UnicastRemoteObject.exportObject(remoteObjectToRegister, port);

        // Bind the remote object's stub in the registry
        Registry registry = RmiUtilities.getRmiRegistry(rmiRegistery_HostName, rmiRegistery_Port);
        registry.rebind(serviceName, remoteMethods_Stub);
        return remoteMethods_Stub;
    }

    public void unregisterService(Remote remoteObjectToUnregister, String serviceName, boolean forceUnregistration)
            throws NotBoundException, RemoteException {

        Registry registry = RmiUtilities.getRmiRegistry(rmiRegistery_HostName, rmiRegistery_Port);
        registry.unbind(serviceName);
        UnicastRemoteObject.unexportObject(remoteObjectToUnregister, forceUnregistration);
    }
}
