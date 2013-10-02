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

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import net.unconventionalthinking.matrix.AppControl_Base;
import net.unconventionalthinking.matrix.Matrix;
import net.unconventionalthinking.utilities.FileUtilities;
import net.unconventionalthinking.utilities.FileUtilities_Delete;


import static org.junit.Assert.*;

/**
 * Before running the actual client, we need to update the client matrix. this should be done run in an entirely separate jvm from the
 * PersistTest_02b_Client__BasicEndToEndTest test. Why? because I think if you don't, you'll have one JVM which when the client first starts, will
 * load the old generated classes. Then. It will update the classes, and try to reload them. But, since they are classes loaded that are apart
 * of the class path, you can't dynamically reload them!
 *
 * @author peterjoh
 */
public class PersistenceTestClient_Utilities {

    public static void updateClientMatrix(boolean grabFreshCopyOfMatrix, boolean useClientExecutor) throws Exception {
///*
        AppControl_Base appControl = maintests.samples.persistenceclient.AppControl.initializeApp();
        Matrix testMatrix_Original = maintests.samples.persistenceclient.Test$__$Matrix.matrix;
//*/
        // delete old log files first.
        if (grabFreshCopyOfMatrix) {
            FileUtilities_Delete.deleteFilesInDir(PersistenceTestWorker_Constants.PersistTestClient_UpdateLog_DirPath);
            FileUtilities_Delete.deleteFilesInDir(PersistenceTestWorker_Constants.PersistTestServer_ChunkInbox_DirPath);

            FileUtilities.copyFilesInDir_Recursive(PersistenceTestWorker_Constants.PersistTestClient_CleanTestMatrices_BaseDirPath,
                    PersistenceTestWorker_Constants.PersistTestClient_SrcMetaCode_DirPath, true, true);
        }

        //  Setup the client.
        //  You can do this two ways. One, with the Client executor, which uses a configurator (meaning, it gets its settings from a properties file).
        //  Two, you can manually set the settings in code.
        PersistentMatricesManager_Client persistenceClient = null;
        if (useClientExecutor) {

            PersistentMatricesExecutor_Client clientExecutor = new PersistentMatricesExecutor_Client(
                    PersistTest_02a_Client__UpdatePersistentMatrix.ClientPropertiesFile_Path);

            persistenceClient = clientExecutor.updateClientCode_fromServer();

        } else {
            PersistenceTestWorker persistenceTest_Worker = new PersistenceTestWorker();
            persistenceTest_Worker.setupClient(appControl.matrixControl);

            persistenceClient = persistenceTest_Worker.persistenceClient;
            persistenceClient.printSettings();
            persistenceClient.initialize1_REQUIRED();
            persistenceClient.initialize2_UpdatePersistentMatrices();
        }
    }

    

    public static final String[] JunitTestResults_ErrorTokens_List = {
        "org.junit.ComparisonFailure",
        "Exception",
        "AssertionFailedError",
        "MONITOR: ERROR: Had ERROR!"
    };
    public static final int ServerFileResultsCreation_TimeLimit_ms = 90 * 1000;


    public static void checkServerResults(String resultsFilePath) throws IOException, InterruptedException {

        //  1. Wait for server results to show up
        File serverResultsFile = new File(resultsFilePath);

        // Wait for file to shw up, and for it to be populated with data
        System.out.println("Waiting until server test-results file shows up and has information:");
        boolean serverFileResultsCreation_TimeLimitExpired = false;
        long startTime = System.currentTimeMillis();
        while ((!serverResultsFile.exists() || serverResultsFile.length() < 5) && !serverFileResultsCreation_TimeLimitExpired) {
            System.out.print("Sleep...");
            System.out.flush();
            Thread.sleep(1000);

            if (System.currentTimeMillis() - startTime > ServerFileResultsCreation_TimeLimit_ms)
                serverFileResultsCreation_TimeLimitExpired = true;
        }
        System.out.println("");
        if (serverFileResultsCreation_TimeLimitExpired)
            System.out.println("\n*** NO TEST RESULTS FILE WITH INFORMATION FOUND! *** \n(NOTE: the file may have been created, but no info put in it!)");
        assertFalse(serverFileResultsCreation_TimeLimitExpired);
        System.out.println("... detected file with information in it.\n");


        //  2. check the results
        System.out.println("Checking the test results for errors:");
        DataInputStream in = new DataInputStream(new FileInputStream(serverResultsFile));
        BufferedReader serverResults_FileReader = new BufferedReader(new InputStreamReader(in));

        String line;
        //Read File Line By Line
        boolean foundError = false;
        String errorLine = null;
        while ( ((line = serverResults_FileReader.readLine()) != null) &&
                !foundError) {

            for  (int i = 0; i < JunitTestResults_ErrorTokens_List.length && !foundError; ++i) {
                String errorToken = JunitTestResults_ErrorTokens_List[i];
                if (line.contains(errorToken)) {
                    foundError = true;
                    errorLine = line;
                }
            }
        }


        if (foundError)
            System.out.println("*** SERVER RESULTS HAD ERROR: ***\n" + errorLine);
        assertFalse(foundError);

        System.out.println("None found!");
    }

}
