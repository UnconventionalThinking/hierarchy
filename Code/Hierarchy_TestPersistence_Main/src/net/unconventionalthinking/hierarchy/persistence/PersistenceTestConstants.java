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
 * @author Peter Joh
 */
public class PersistenceTestConstants {
    
    public final static String ProjDir__Hierarchy = "../Hierarchy";
    public final static String ProjDir__Hierarchy_GenerationTestProject = "../Hierarchy_GenerationTestProject";
    public final static String ProjDir__PersistenceTestMain = "../Hierarchy_TestPersistence_Main";
    public final static String ProjDir__PersistenceTestServer = "../Hierarchy_TestPersistence1_Server";
    public final static String ProjDir__PersistenceTestClient = "../Hierarchy_TestPersistence2_Client";

    public final static String PersistenceTestMain__TestResults_Dir = ProjDir__PersistenceTestMain + "/testresults";
    public final static String PersistenceTestMain__TestResults_BasicEndToEnd_FileName =
            "TEST-net.unconventionalthinking.hierarchy.persistence.PersistTest_02_Server__BasicEndToEndTest.xml";
    public final static String PersistenceTestMain__TestResults_BasicEndToEnd_FilePath = PersistenceTestMain__TestResults_Dir + "/" + PersistenceTestMain__TestResults_BasicEndToEnd_FileName;


    public final static String PersistenceTestMain__TestResults_UpdatedMatrixCheck_FileName =
            "TEST-net.unconventionalthinking.hierarchy.persistence.PersistTest_03_Server__CheckNewPersistedMatrix.xml";
    public final static String PersistenceTestMain__TestResults_UpdatedMatrixCheck_FilePath = PersistenceTestMain__TestResults_Dir + "/" + PersistenceTestMain__TestResults_UpdatedMatrixCheck_FileName;


    public final static String Persistence_RmiRegistry_ConnectionSettings_forServer__Hostname = "127.0.0.1";
    public final static String Persistence_RmiRegistry_ConnectionSettings_forClient__Hostname = Persistence_RmiRegistry_ConnectionSettings_forServer__Hostname;

}
