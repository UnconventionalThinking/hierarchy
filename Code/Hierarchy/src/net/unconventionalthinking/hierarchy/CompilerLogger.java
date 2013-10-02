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


package net.unconventionalthinking.hierarchy;

import net.unconventionalthinking.hierarchy.grammar.node.Token;
import net.unconventionalthinking.hierarchy.grammar.parser.ParserException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;

/**
 *
 * @author peterjoh
 */
public class CompilerLogger {

    public final List<InfoOrError> message_List = new ArrayList<InfoOrError>();

    public String currPackage;
    public String currFileName;
    public int currLine;
    public int currPos;

    public boolean searchForParseException;
    public ParserException parserException;
    public Token parserException_Token;

    private boolean hadError;
    private boolean onReportError_ThrowException_insteadOfExiting;
    private HierarchySettings hierarchySettings;

    
    public CompilerLogger(HierarchySettings hierarchySettings) {
        this.hierarchySettings = hierarchySettings;
        this.onReportError_ThrowException_insteadOfExiting = false;
        
        currLine = 0;
        currPos = 0;
    }

    public void set_onReportError_ThrowException_insteadOfExiting(boolean enableThrowException) {
        this.onReportError_ThrowException_insteadOfExiting = enableThrowException;
    }

    public void setCurrFileName(String currFileName) { this.currFileName = currFileName; }
    public void setCurrPackage(String currPackage) { this.currPackage = currPackage;}

    public void setCurrLineNumAndColumn(int currLine, int currPos) {
        this.currLine = currLine;
        this.currPos = currPos;
    }

    public void set_SearchForParseException(boolean searchForParseException) { this.searchForParseException = searchForParseException; }
    

    public void reportError_And_Exit(Exception exception) {
        if (onReportError_ThrowException_insteadOfExiting) {
            throw new ExceptRuntime_HierarchyMetaCompilerError("Error!", exception);
        } else {
            hadError = true;
            message_List.add(new InfoOrError(exception));
            printMessages();
            System.exit(-1);
        }
    }
    public void reportError_And_Exit(String infoMessage, Exception exception) {
        if (onReportError_ThrowException_insteadOfExiting) {
            throw new ExceptRuntime_HierarchyMetaCompilerError(infoMessage, exception);
        } else {
            hadError = true;
            message_List.add(new InfoOrError(infoMessage, exception));
            printMessages();
            System.exit(-1);
        }
    }
    public void reportInfo_And_Exit(String infoMessage) {
        if (onReportError_ThrowException_insteadOfExiting) {
            throw new ExceptRuntime_HierarchyMetaCompilerError(infoMessage);
        } else {
            message_List.add(new InfoOrError(infoMessage));
            printMessages();
            System.exit(0);
        }
    }


    public void logError(Exception exception) {
        message_List.add(new InfoOrError(exception));
    }
    public void logError(String infoMessage, Exception exception) {
        message_List.add(new InfoOrError(infoMessage, exception));
    }
    public void logInfo(String infoMessage) {
        message_List.add(new InfoOrError(infoMessage));
    }


    public void printMessages() {

        System.out.println("________________________________________________________________\n");

        if (hadError)
            System.out.println("*** ERROR ***\n");
        
        if (searchForParseException)
            searchMsgList_forParseException();

        if (currFileName != null) {
            System.out.print("In the file: '" + currFileName + "'");
            if (currPackage != null)
                System.out.print(", in the package: '" + currPackage + "'");
        
        } else      
            System.out.print("Hierarchy Meta-Compiler results:\n");


        String parserToken_String = null;
        if (parserException != null) {
            System.out.print(",\nhad a error trying to parse the file");
            parserException_Token = parserException.getToken();
            if (parserException_Token != null) {
                currLine = parserException_Token.getLine();
                currPos = parserException_Token.getPos();

                parserToken_String = parserException_Token.getText();
            }

        }

        if (currLine >= 0) {
            System.out.print(", on line " + currLine );
            if (currPos >= 0)
                System.out.print(", near the token" +
                        (parserToken_String != null ? ", '" + parserToken_String + "', " : " ")
                        + "at position " + currPos);
        }

        System.out.println(":");
        if (parserException != null)
            System.out.println("    " + parserException.getMessage());



        if (parserException == null) {
            System.out.println("________________________________________________________________\n");

            System.out.println("  Nested-Exceptions Print out (no stack trace)");
            System.out.println("________________________________________________________________\n");
            for (InfoOrError message : message_List) {
                if (message.infoMessage != null)
                    System.out.println(message.infoMessage);

                if (message.exception != null) {

                    Throwable nestedExceptionToPrint = message.exception;

                    String indent = "";
                    while (nestedExceptionToPrint != null) {
                        System.out.println("\n" + indent + nestedExceptionToPrint.getClass().getCanonicalName() + ": \"" +
                                nestedExceptionToPrint.getMessage() + "\"");

                        nestedExceptionToPrint = nestedExceptionToPrint.getCause();
                        indent += "    ";
                    }
                }
                System.out.print("\n\n");
            }

            if (hierarchySettings.print_VerboseErrors) {
                System.out.println("\n________________________________________________________________\n");

                System.out.println("  Full Stack Trace ");
                System.out.println("________________________________________________________________\n");
                for (InfoOrError message : message_List) {
                    if (message.infoMessage != null)
                        System.out.println(message.infoMessage);

                    if (message.exception != null) {

                        Throwable nestedExceptionToPrint = message.exception;

                        while (nestedExceptionToPrint != null) {
                            StringWriter stackTrace = new StringWriter();
                            nestedExceptionToPrint.printStackTrace(new PrintWriter(stackTrace));
                            System.out.println(stackTrace.toString());

                            nestedExceptionToPrint = nestedExceptionToPrint.getCause();
                        }
                    }
                    System.out.print("\n\n");
                }
            }
        }
    }


    
    private void searchMsgList_forParseException() {
        for (InfoOrError message : message_List) {

            for(Throwable e = message.exception; e != null && parserException == null; e = e.getCause()) {
                if (e instanceof ParserException) {
                    parserException = (ParserException)e;
                    return;
                }
            }
        }
    }




    public class InfoOrError {
        public InfoOrError(String infoMessage) { this.infoMessage = infoMessage; }
        public InfoOrError(Exception exception) { this.exception = exception; }
        public InfoOrError(String infoMessage, Exception exception) { this.infoMessage = infoMessage; this.exception = exception; }

        public String infoMessage;
        public Exception exception;

    }



}
