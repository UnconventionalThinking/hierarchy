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

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import net.unconventionalthinking.utilities.ListUtilities;

/**
 *
 * @author peterjoh
 */
public class RmiClient {

    /**
     * Use default rmi registery host of localhost, default port of 1099
     */
    public static Remote getRemoteMethodsService_ProxyObj(String serviceName)
            throws RemoteException, NotBoundException {
        return getRemoteMethodsService_ProxyObj(serviceName, null, -1);
    }

    /**
     * Use default rmi registery port of 1099
     */
    public static Remote getRemoteMethodsService_ProxyObj(String serviceName, String rmiRegistery_HostName)
            throws RemoteException, NotBoundException {
        return getRemoteMethodsService_ProxyObj(serviceName, rmiRegistery_HostName, -1);
    }

    /**
     * if pass in a host with 'null', by default, localhost is used
     */
    public static Remote getRemoteMethodsService_ProxyObj(String serviceName, String rmiRegistery_HostName, int rmiRegistery_Port)
            throws RemoteException, NotBoundException {

        Registry registry = RmiUtilities.getRmiRegistry(rmiRegistery_HostName, rmiRegistery_Port);

        Remote remotePersistServerMethods_Stub = null;
        try {
            remotePersistServerMethods_Stub = registry.lookup(serviceName);

        } catch (RemoteException re) {
            RemoteException generatedException = generateRmiException(registry, re);
            if (generatedException != null) {
                throw generatedException;
            } else {
                throw re;
            }
        } catch (NotBoundException e) {
            RemoteException generatedException = generateRmiException(registry, e);
            if (generatedException != null) {
                throw generatedException;
            } else {
                throw e;
            }
        }
        return remotePersistServerMethods_Stub;
    }

    private static RemoteException generateRmiException(Registry registry, Exception e) {

        // we couldn't bind. why? try to return the list of registered objects.
        if (registry != null) {
            String[] registeredObjects = null;
            try {
                registeredObjects = registry.list();

            } catch (Exception except) {
                // do nothing
            }
            if (registeredObjects != null) {
                String listOfRegisteredObj = ListUtilities.print(registeredObjects, ", ");
                return new RemoteException("RMI error: Couldn't bind the client stub to the server methods. Here's the "
                        + "list of objects in the registry:\n\t" + listOfRegisteredObj, e);
            }

        }
        return null;

    }
}
