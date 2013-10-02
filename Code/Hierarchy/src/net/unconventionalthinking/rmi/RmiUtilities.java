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
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteStub;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Peter Joh
 */
public class RmiUtilities {

    public static Registry getRmiRegistry(String rmiRegistery_HostName, int rmiRegistery_Port) throws RemoteException {
        Registry registry = null;
        if (rmiRegistery_Port > 0) {
            registry = LocateRegistry.getRegistry(rmiRegistery_HostName, rmiRegistery_Port);
        } else {
            registry = LocateRegistry.getRegistry(rmiRegistery_HostName);
        }
        return registry;
    }
}
