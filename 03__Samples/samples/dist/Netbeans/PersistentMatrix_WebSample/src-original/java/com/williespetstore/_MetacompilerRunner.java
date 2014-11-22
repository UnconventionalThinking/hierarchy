package com.williespetstore;


import net.unconventionalthinking.utilities.FileUtilities;
import net.unconventionalthinking.hierarchy.HierarchyMetaCompiler;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import java.io.File;


/**
 * *** IMPORTANT NOTE ****
 * Before you run this, if you've made any changes to any type of matrix file, you should delete the generated .java files and clean
 * the build (not sure which one causes the problem)) Why? because when you run this class and the the JVM starts up, It's primary class loader
 * will load the current classes into memory, and they cannot be replaced by the dynamically compiled versions!!!!
 *
 * @author peterjoh
 */
public class _MetacompilerRunner {


    
    public static void main(String[] args) throws Exception {
        System.out.println("Generating maintests");

        //  Check if the project path is passed in. This happens when an outside project like the HierarchyController project
        //  calls this method.
        String prePath = "";
        if (args != null && args.length == 1) {
            prePath = args[0].trim() + "/";
        }
        HierarchyMetaCompiler.main(new String[] { "-mpropfile", prePath + "client-matrix-persistence.properties" });

    }

}