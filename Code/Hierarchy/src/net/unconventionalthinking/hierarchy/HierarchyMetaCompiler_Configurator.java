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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.unconventionalthinking.hierarchy.config.Configurator;
import net.unconventionalthinking.utilities.PropertyFile;


/**
 *
 * @author peterjoh
 */
public class HierarchyMetaCompiler_Configurator extends Configurator {

    public boolean cleanBuildDir;

    private HierarchyMetaCompiler hierarchyMetaCompiler;

    public HierarchyMetaCompiler_Configurator(String propertiesFile_Path) throws IOException {
        super(propertiesFile_Path);

        cleanBuildDir = false;
        hierarchyMetaCompiler = new HierarchyMetaCompiler();
    }

    /**
     * This constructor is called by the other configurator objects that already have a PropertyFile and Metacompiler, and don't need one constructed.
     * For instance, by the persistence configurators.
     */
    public HierarchyMetaCompiler_Configurator(PropertyFile properties, HierarchyMetaCompiler hierarchyMetaCompiler) throws IOException {
        super(properties);

        this.hierarchyMetaCompiler = hierarchyMetaCompiler;
        cleanBuildDir = false;
    }


    @Override
    public HierarchyMetaCompiler configure() throws IOException {

        hierarchyMetaCompiler.set_HierarchyJar_Dir(properties.checkAndGetRequiredProperty_String(HierarchyMetaCompiler_PropertyFieldNames.hierarchy_jar_dir));
        hierarchyMetaCompiler.set_javac_Dir(properties.checkAndGetRequiredProperty_String(HierarchyMetaCompiler_PropertyFieldNames.javac_dir));

        hierarchyMetaCompiler.set_SrcMetaCode_BaseDir(properties.checkAndGetRequiredProperty_String(HierarchyMetaCompiler_PropertyFieldNames.source_metacode_basedir));
        hierarchyMetaCompiler.set_AppClasses_PackageName(properties.checkAndGetRequiredProperty_String(HierarchyMetaCompiler_PropertyFieldNames.matrix_appclasses_package));
        hierarchyMetaCompiler.set_BuildMeta_BaseDir(properties.checkAndGetRequiredProperty_String(HierarchyMetaCompiler_PropertyFieldNames.build_meta_basedir));
        hierarchyMetaCompiler.set_BuildFinal_BaseDir(properties.checkAndGetRequiredProperty_String(HierarchyMetaCompiler_PropertyFieldNames.build_final_basedir));


        //  Classpath properties
        hierarchyMetaCompiler.set_Classpath_AllPhases(properties.getProperties().getProperty(HierarchyMetaCompiler_PropertyFieldNames.classpath_allphases));
        hierarchyMetaCompiler.set_Classpath_Java(properties.getProperties().getProperty(HierarchyMetaCompiler_PropertyFieldNames.classpath_java_phase));
        hierarchyMetaCompiler.set_Classpath_Schemas(properties.getProperties().getProperty(HierarchyMetaCompiler_PropertyFieldNames.classpath_schema_phase));
        hierarchyMetaCompiler.set_Classpath_Matrices(properties.getProperties().getProperty(HierarchyMetaCompiler_PropertyFieldNames.classpath_matrix_phase));
        hierarchyMetaCompiler.set_Classpath_EmbeddedFiles(properties.getProperties().getProperty(HierarchyMetaCompiler_PropertyFieldNames.classpath_embedded_phase));

        //  Errors
        String print_VerboseErrors_Raw = properties.getProperties().getProperty(HierarchyMetaCompiler_PropertyFieldNames.printVerboseErrors);
        hierarchyMetaCompiler.set_PrintVerboseErrors(
                print_VerboseErrors_Raw != null && print_VerboseErrors_Raw.equalsIgnoreCase("true"));  // default is false
        hierarchyMetaCompiler.set_Errors_Add(HierarchySettings.Errors.Invalid_ClassPathElement);


        String compileMetaFiles_into_finalClassFiles_PropertyValue
                = properties.getProperties().getProperty(HierarchyMetaCompiler_PropertyFieldNames.compileMetaFiles_into_finalClassFiles);
        hierarchyMetaCompiler.set_CompileMetaFiles_into_FinalClassFiles(
                compileMetaFiles_into_finalClassFiles_PropertyValue == null ||
                compileMetaFiles_into_finalClassFiles_PropertyValue.equalsIgnoreCase("true"));  // default is true

        String clean_PropertyValue = properties.getProperties().getProperty(HierarchyMetaCompiler_PropertyFieldNames.clean);
        cleanBuildDir = (clean_PropertyValue != null && clean_PropertyValue.equalsIgnoreCase("true")); // default is false

        process_InitiallyCompileJavaFiles_Settings();


        return hierarchyMetaCompiler;
    }



    private void process_InitiallyCompileJavaFiles_Settings() {
        String initiallyCompileAllJavaCode_PropertyValue = properties.getProperties().getProperty(HierarchyMetaCompiler_PropertyFieldNames.initiallyCompileAllJavaCode);
        // default is false
        hierarchyMetaCompiler.set_InitiallyCompileAllJavaCode(
                initiallyCompileAllJavaCode_PropertyValue != null && initiallyCompileAllJavaCode_PropertyValue.equalsIgnoreCase("true"));
        String initiallyCompileJavaCode_ClassesList = properties.getProperties().getProperty(
                HierarchyMetaCompiler_PropertyFieldNames.initiallyCompileJavaCode_SelectedClassesList);
        List<String> initiallyCompiledJava_SelectedClasses_List = parseClassList_intoStrings(initiallyCompileJavaCode_ClassesList);
        hierarchyMetaCompiler.set_InitiallyCompiledJava_SelectedClasses_List(initiallyCompiledJava_SelectedClasses_List);
    }




    public static List<String> parseClassList_intoStrings(String classList_Text) {

        List<String> initiallyCompiledJava_SelectedClasses_List = new ArrayList<String>();
        
        if (classList_Text != null && classList_Text.trim().length() > 0) {
            String[] class_Strings = classList_Text.split(",");
            for (int i = 0; i < class_Strings.length; i++) {
                class_Strings[i] = (class_Strings[i] != null ? class_Strings[i].trim() : null);
            }

            if (class_Strings != null)
                initiallyCompiledJava_SelectedClasses_List = Arrays.asList(class_Strings);
        }

        return initiallyCompiledJava_SelectedClasses_List;
    }


}
