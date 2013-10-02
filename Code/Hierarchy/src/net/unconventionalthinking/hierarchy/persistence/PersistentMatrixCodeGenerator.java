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

import net.unconventionalthinking.matrix.Matrix;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.utilities.FileUtilities;
import net.unconventionalthinking.hierarchy.Exception_HierarchyCompiler;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import net.unconventionalthinking.hierarchy.compileractions.HierarchyActions;
import net.unconventionalthinking.hierarchy.grammar.lexer.Lexer;
import net.unconventionalthinking.hierarchy.grammar.lexer.LexerException;
import net.unconventionalthinking.hierarchy.grammar.node.Start;
import net.unconventionalthinking.hierarchy.grammar.parser.Parser;
import net.unconventionalthinking.hierarchy.grammar.parser.ParserException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;



/**
 * The purpose of this class is to replace the existing matrix file with an updated copy.
 * The way this is done is a little bit of a hack (maybe change this in the future).
 * 1. Parse the existing (and out of date!) .matrix file, creating the AST for it (note, at this point, we have NOT applied any actions to the tree).
 * 2. Next, we need to replace just the MATRIX definition with the updated portion (leaving the rest untouched). The way we do this is using
 *    a custom action class that does this replacement. All it is doing is in the MatrixNewDeclaration rule, it IGNORES the MATRIX code from the,
 *    old file, and replaces it meta code generated from actual the updated persistent matrix.
 *
 * @author peterjoh
 */
public class PersistentMatrixCodeGenerator {

    private Start tree;
    private PersistentMatrixCodeGenerator_MatrixReplacer_MetaCompilerActions persistence_MatrixReplacer_Actions;

    private String srcMatrixFile_DirPath;
    private String srcMatrixFile_Name;

    public PersistentMatrixCodeGenerator(String srcMatrixFile_DirPath, String srcMatrixFile_Name) throws IOException, Exception_PersistenceError {

        this.srcMatrixFile_DirPath = srcMatrixFile_DirPath;
        this.srcMatrixFile_Name = srcMatrixFile_Name;

        BufferedReader sourceFileReader = new BufferedReader(new FileReader(new File(srcMatrixFile_DirPath, srcMatrixFile_Name)));
        Parser p = new Parser(new Lexer(new PushbackReader(sourceFileReader)));

        tree = null;
        try {
            //  Parse the input
            tree = p.parse();
        } catch (ParserException pexcept) {
            throw new Exception_PersistenceError("Parser Error: While trying to metacompile file, had an error", pexcept);
        } catch (LexerException lexcept) {
            throw new Exception_PersistenceError("Lexer Error: While trying to metacompile file, had an error", lexcept);
        } catch (IOException ioexcept) {
            throw new Exception_PersistenceError("Lexer Error: While trying to metacompile file, had an error", ioexcept);
        }


        persistence_MatrixReplacer_Actions = new PersistentMatrixCodeGenerator_MatrixReplacer_MetaCompilerActions();

    }

    public String generateCodeFromMatrix(Matrix persistMatrix) {
        

        persistence_MatrixReplacer_Actions.setMatrix(persistMatrix);
        tree.apply(persistence_MatrixReplacer_Actions);

        return persistence_MatrixReplacer_Actions.getReplacedCode();
    }



    public void writeToFile(String dest_DirPath, boolean replace_IfExists) throws IOException {
        writeToFile(dest_DirPath, replace_IfExists, false);
    }
    public void writeToFile(String dest_DirPath, boolean replace_IfExists, boolean autoFlushBufferForDebug) throws IOException {

        FileUtilities.writeToFile(dest_DirPath, srcMatrixFile_Name, replace_IfExists,
                persistence_MatrixReplacer_Actions.getReplacedCode(), autoFlushBufferForDebug);
    }

    
}
