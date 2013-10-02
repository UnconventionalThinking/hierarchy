package com.abstractsystems.partita.metacode;


/**
 *
 * @author peterjoh
 */

import com.abstractsystems.partita.metacode.grammar.parser.*;
import com.abstractsystems.partita.metacode.grammar.lexer.*;
import com.abstractsystems.partita.metacode.grammar.node.*;
import java.io.*;

/*
 *
 * usage:
 java -jar ../dist/Partita_Meta-Code_Generator.jar -cp ../dist/lib/sablecc.jar -f input.txt
 *
 * type in text, then to send end of file character, hit ctrl-d
 *
 *
 *
 */


public class Partita_MetaCode_Translator {

    public static void main(String[] args) throws Exception
    {



        BufferedReader sourceFileReader = null;
        boolean hasSourceFilePath = false;
        String filePath = null;

        for (int i = 0; i < args.length; ++i) {
            String parameter = args[i];

            if (parameter != null && parameter.trim().equals("-f")) {
                String filePathArg = args[i + 1];
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
        tree.apply(new Partita_MetaCode_Translator_Actions());

        System.out.println();
    }



}
