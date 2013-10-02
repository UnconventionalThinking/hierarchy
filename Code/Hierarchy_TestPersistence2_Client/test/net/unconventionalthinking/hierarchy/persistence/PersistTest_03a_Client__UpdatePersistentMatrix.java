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


import org.junit.BeforeClass;
import org.junit.Test;


/**
 * This does the same thing as PersistTest_02a_Client__UpdatePersistentMatrix
 *
 * @author peterjoh
 */
public class PersistTest_03a_Client__UpdatePersistentMatrix {

    //  Setup the client.
    //  You can do this two ways. One, with the Client executor, which uses a configurator (meaning, it gets its settings from a properties file).
    //  Two, you can manually set the settings in code.
    public static boolean runClient_ExecutorOrConfigurator = true;
    /**
     * @param args the command line arguments
     */
    @BeforeClass
    public static void setUpClass() throws Exception {
        //  IMPORTANT! - we pass in 'false' because we are NOT passing getting a fresh copy of the matrix from the server.
        //  We want the exisiting one.
        PersistenceTestClient_Utilities.updateClientMatrix(false, runClient_ExecutorOrConfigurator);
    }

    @Test
    public void doNothingTest() {
        
    }

}
