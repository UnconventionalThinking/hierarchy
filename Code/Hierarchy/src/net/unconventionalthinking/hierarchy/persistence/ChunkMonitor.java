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
import net.unconventionalthinking.hierarchy.persistence.PersistentMatricesManager.PersistenceEventType;

/**
 *
 * @author Peter Joh
 */


class PersistentMatrix_ChunkMonitor_TaskWrapper implements Runnable {

    private final ChunkMonitor_ChunkProcessor chunkMonitor_ChunkProcessor;
    private final boolean isClient_notServer;
    private final PersistentMatricesManager persistentMatricesManager;

    private boolean hadError;
    private Throwable errorReceived;



    PersistentMatrix_ChunkMonitor_TaskWrapper(ChunkMonitor_ChunkProcessor chunkMonitor_ChunkProcessor,
            PersistentMatricesManager persistentMatricesManager) {

        this.chunkMonitor_ChunkProcessor = chunkMonitor_ChunkProcessor;
        this.persistentMatricesManager = persistentMatricesManager;

        this.hadError = false;
        this.errorReceived = null;

        isClient_notServer = persistentMatricesManager instanceof PersistentMatricesManager_Client;
    }




    @Override
    public void run() {

        try {
            chunkMonitor_ChunkProcessor.process();

        //  All exception will be swallowed up. Why? we don't want the chunk processing thread to ever die. Instead, pass the
        //  error back to the thread owner through an event handler.
        } catch (Exception_PersistenceError e) {
            processChunkMonitorError(e);

        } catch (Exception_PersistenceEventHandler e) {
            processChunkMonitorError(e);

        } catch (InterruptedException e) {
            //  If we received the interruptedException, we're probably Shutting Down Now. Do nothing and let task end

        } catch (IOException e) {
            // had a problem with creating the new chunk file
            processChunkMonitorError(e);

        } catch (Throwable t) {
            processChunkMonitorError(t);

        } finally {


        }


    }  // end of run



    private void processChunkMonitorError(Throwable errorReceived) {

        System.out.println("PERSITENT MATRIX MANAGER: MONITOR: ERROR: " + (errorReceived != null ? errorReceived.getMessage() : null));
        errorReceived.printStackTrace();
        try {
            PersistenceEventType clientOrServer_EventError = (isClient_notServer ? PersistenceEventType.ClientChunkMonitor_Error :
                PersistenceEventType.ServerChunkMonitor_Error);
            persistentMatricesManager.sendPersistenceEvent(clientOrServer_EventError, errorReceived);

        } catch (Exception e) {
            String ClientOrServer_String = (isClient_notServer ? "Client" : "Server");
            throw new ExceptRuntime_PersistenceManagerError("In the PersistentMatrixManager_" + ClientOrServer_String +
                    ", had an error, and then also tried to send a PersistenceEvent about the error, but one of the event handlers threw an exception.", e);
        }
    }

}



interface ChunkMonitor_ChunkProcessor {
    public void process() throws InterruptedException, IOException, Exception_PersistenceEventHandler, Exception_PersistenceError;
}

