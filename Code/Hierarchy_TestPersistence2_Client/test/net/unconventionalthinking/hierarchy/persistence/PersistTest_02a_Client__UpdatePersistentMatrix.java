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
 * Before running the actual client, we need to update the client matrix. this should be done run in an entirely separate jvm from the
 * PersistTest_02b_Client__BasicEndToEndTest test. Why? because I think if you don't, you'll have one JVM which when the client first starts, will
 * load the old generated classes. Then. It will update the classes, and try to reload them. But, since they are classes loaded that are apart
 * of the class path, you can't dynamically reload them!
 *
 * @author peterjoh
 */
public class PersistTest_02a_Client__UpdatePersistentMatrix {

    //  Setup the client.
    //  You can do this two ways. One, with the Client executor, which uses a configurator (meaning, it gets its settings from a properties file).
    //  Two, you can manually set the settings in code.
    public static boolean runClient_ExecutorOrConfigurator = true;
    public static String ClientPropertiesFile_Path =
            PersistenceTestConstants.ProjDir__PersistenceTestMain + "/src/maintests/main/PersistClient_MainTests.properties";

    /**
     * @param args the command line arguments
     */
    @BeforeClass
    public static void setUpClass() throws Exception {

        PersistenceTestClient_Utilities.updateClientMatrix(true, runClient_ExecutorOrConfigurator);
    }

    @Test
    public void doNothingTest() {
        
    }

}
