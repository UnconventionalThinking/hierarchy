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


package net.unconventionalthinking.cmdline;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

/**
 *
 * @author peterjoh
 */
public class CmdLine_Tools {

    /** 
     * executes a cmd on the command line. passes back the output reader and the error reader.<br>
     * NOTE: if you print the output/error stream, the passed back reader will be useless, because this reader have already read in all the
     * text.
     */
    public static ExecutionResults executeCmd(List<String> commandArgs, File workingDir, boolean print_Output, boolean print_Errors,
            boolean print_ProcessReturnValue)
            throws IOException, InterruptedException {
        
        ProcessBuilder processBuilder = new ProcessBuilder(commandArgs);
        processBuilder.directory(workingDir);

        Map<String, String> env = processBuilder.environment();
        Process process = processBuilder.start();


        //  Note, eventhough it's processOutput, the actual object is an inputStream
        InputStream processOutputStream = process.getErrorStream();
        BufferedReader processOutput = new BufferedReader(new InputStreamReader(processOutputStream));
        if (print_Output) {
            System.out.println("Output is:");

            String line;
            while ((line = processOutput.readLine()) != null) {
                System.out.println(line);
            }
        }

        
        InputStream errorOutputStream = process.getErrorStream();
        BufferedReader errorOutput = new BufferedReader(new InputStreamReader(errorOutputStream));
        if (print_Errors) {
            System.out.println("Errors are:");

            String line;
            while ((line = errorOutput.readLine()) != null) {
                System.out.println(line);
            }
        }

        if (print_ProcessReturnValue) {
            process.waitFor();
            System.out.println("The process's return value is: " + process.exitValue());
        }
        
        return new ExecutionResults(process, processOutput, errorOutput);
    }



    
    public static class ExecutionResults {

        private Process         process;

        private BufferedReader   processOutput;
        private BufferedReader   errorOutput;

        public ExecutionResults(Process process, BufferedReader processOutput, BufferedReader errorOutput) {
            this.process = process;
            this.processOutput = processOutput;
            this.errorOutput = errorOutput;
        }


        /** If the process has already finished, This method will return immediately */
        public int waitForProcessToTerminate() throws InterruptedException { return process.waitFor(); }
        /** This method waits for process to terminate before getting the results. Typically, 0 means normal termination. */
        public int getProcessReturnValue() throws InterruptedException {
            return getProcessReturnValue(false);
        }
        /** This method waits for process to terminate before getting the results, which you can disable. Typically, 0 means normal termination. */
        public int getProcessReturnValue(boolean disableWaitForProcess) throws InterruptedException {
            if (!disableWaitForProcess)
                waitForProcessToTerminate();
            return process.exitValue();
        }

        public Process getExecutingProcess() { return process; }

        public BufferedReader getProcessOutput() { return processOutput; }
        public BufferedReader getErrorOutput() { return errorOutput; }


    }
}
