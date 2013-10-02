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
public class HierarchyMetaCompiler_PropertyFieldNames {

    
    /**  Set the path to the Hierarchy.jar directory. */
    public static final String hierarchy_jar_dir = "hierarchy.jar.dir";
    /**  Set the path to the javac directory. */
    public static final String javac_dir = "javac.dir";

    /**  Set the class path used in All Phases of metacompilation */
    public static final String classpath_allphases = "classpath.allphases";
    /**  Set the class path used in the Java Phase of metacompilation */
    public static String classpath_java_phase = "classpath.java.phase";;
    /**  Set the class path used in the Schema Phase of metacompilation */
    public static final String classpath_schema_phase = "classpath.schema.phase";
    /**  Set the class path used in the Matrix Phase of metacompilation */
    public static final String classpath_matrix_phase = "classpath.matrix.phase";
    /**  Set the class path used in the Embedded Phase of metacompilation */
    public static final String classpath_embedded_phase = "classpath.embedded.phase";


    /**  Set the location of base dir of the matrix source (in other words, the base dir of your project which has matrix/schema/embedded code files) */
    public static final String source_metacode_basedir = "source.metacode.basedir";
    /**  Set the package name that the Matrix application classes will be placed */
    public static final String matrix_appclasses_package = "matrix.appclasses.package";
    /**  Set the path the the base directory where the intermediate, meta build files (generated java files) will be placed. */
    public static final String build_meta_basedir = "build.meta.basedir";
    /**  Set the path the the base directory where the final class files will be placed. */
    public static final String build_final_basedir = "build.final.basedir";

    /** Set whether to the final stage of compilation: Compiling the java files from the meta phase into the final class files. Default is true */
    public static final String compileMetaFiles_into_finalClassFiles = "compileMetaFiles.into.finalClassFiles";
    /**  Set whether to clean the build meta and build final directories before metacompilation (true or false) */
    public static final String clean = "clean";
    /**
     * Set whether before any metacompilation is done, to compile all Java files in the src first. These compiled Java classes will be available
     * to the schemas/matrices/embedded code.
     */
    public static final String initiallyCompileAllJavaCode = "initiallyCompileAllJavaCode";
    public static final String initiallyCompileJavaCode_SelectedClassesList = "initiallyCompileJavaCode.SelectedClassesList";
    
    public static final String printVerboseErrors = "printVerboseErrors";
}
