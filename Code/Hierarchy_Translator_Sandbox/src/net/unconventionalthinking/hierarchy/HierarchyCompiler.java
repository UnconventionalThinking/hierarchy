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


/**
 *
 * @author peterjoh
 */

import net.unconventionalthinking.compiler.tools.CompilerSettings;
import net.unconventionalthinking.hierarchy.grammar.parser.*;
import net.unconventionalthinking.hierarchy.grammar.lexer.*;
import net.unconventionalthinking.hierarchy.grammar.node.*;
import java.io.*;

/*
 *
 * usage:
 java -jar ../dist/Hierarchy_Translator_Sandbox.jar -cp ../dist/lib/sablecc.jar -f ../testdata/input.txt
 win: 
 java -jar ..\dist\Hierarchy_Translator_Sandbox.jar -cp ..\dist\lib\sablecc.jar -f ..\testdata\input.txt
 *
 * type in text, then to send end of file character, hit ctrl-d
 *
 *
 *
 */


public class HierarchyCompiler {

    public static void main(String[] args) throws Exception
    {



        BufferedReader sourceFileReader = null;
        boolean hasSourceFilePath = false;
        String filePath = null;

        for (int i = 0; i < args.length; ++i) {
            String parameter = args[i];

            if (parameter != null && parameter.trim().equals("-f")) {
                String filePathArg = args[++i];
                if (filePathArg != null && filePathArg.trim().length() != 0) {
                    filePath = filePathArg.trim();
                    hasSourceFilePath = true;
                }
            }
        }

        if(hasSourceFilePath) {
            System.out.println("Reading code from input file: " + filePath);
            sourceFileReader = new BufferedReader(new FileReader(filePath));
        } else {
            System.out.println("Type in your code and send EOF (usually ctrl-d) to parse it:");
            sourceFileReader = new BufferedReader(new InputStreamReader(System.in));
        }

        //  Create a new parser instance

        Parser p = new Parser(new Lexer(new PushbackReader(sourceFileReader)));

        Start tree = null;
        try {
            //  Parse the input
            tree = p.parse();
        } catch (ParserException pexcept) {
            System.out.println("ERROR: Parser Exception: " + pexcept);
        } catch (LexerException lexcept) {
            System.out.println("ERROR: Lexer Exception: " + lexcept);
        } catch (IOException ioexcept) {
            System.out.println("ERROR: IO Exception: " + ioexcept);
        }


        //  Apply the translation
        CompilerSettings compilerSettings = new CompilerSettings();
        compilerSettings.matrixCode_Passthrough_Code = true;

        tree.apply(new HierarchyCompiler_Actions(compilerSettings));

        System.out.println();
    }



}
