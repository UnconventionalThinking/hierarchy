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

/**
 *
 * @author peterjoh
 */
public class PersistentMatricesManagerConstants {

    //  _________________________________________________________________________________________________________________________________________
    //
    //    Constants shared by both client and server
    //  _________________________________________________________________________________________________________________________________________

    public static final String CHUNK_DEFAULT_LOGFILECHUNK_BASENAME = "matrix_UpdateLogChunk_";
    public static final String RMI_REGISTRYENTRY__REMOTEMETHODS_STUBOBJ = "rmi:remoteMethods_stubObj";

    /**
     * The reason this is used is because timestamps are added to filenames. And these values are longs, which could get very big. but we want to keep our
     * files names short. so, for persistence filename timestamps, remove some time to keep these values low, and the file names shorter.
     *
     * This long value is the time, 3/24/2010 10:52 PM  minus 10000;
     */
    public static final long PERSISTENCE_FILENAME_TIMESTAMP__REMOVED_TIME = 1269485449618L;

    
    //  _________________________________________________________________________________________________________________________________________
    //
    //    Client Constants
    //  _________________________________________________________________________________________________________________________________________
    public static final int CLIENT__CHUNK_DEFAULT_SIZEBOUNDARY__LINECOUNT = 1000;

    /** This constant is the chunk check interval for just the first one. */
    public static final int CLIENT__CHUNKMONITOR_CHECKFORCHUNKS_DEFAULT_INITIAL_INTERVAL__MS = 3 * 1000;
    public static final int CLIENT__CHUNKMONITOR_CHECKFORCHUNKS_DEFAULT_INTERVAL__MS = 7 * 1000;


    //  _________________________________________________________________________________________________________________________________________
    //
    //    Server Constants
    //  _________________________________________________________________________________________________________________________________________

    /** This constant is the chunk check interval for just the first one. */
    public static final int SERVER__CHUNKMONITOR_CHECKFORCHUNKS_DEFAULT_INITIAL_INTERVAL__MS = 0;
    public static final int SERVER__CHUNKMONITOR_CHECKFORCHUNKS_DEFAULT_INTERVAL__MS = 7 * 1000;


    public static final String SERVER__PERSISTENCECONTROL_DEFAULT_DIRBASENAME = "persistControlSet_";
    public static final String SERVER__PERSISTENCECONTROL_DEFAULT_FILEBASENAME ="persistControl_";




}
