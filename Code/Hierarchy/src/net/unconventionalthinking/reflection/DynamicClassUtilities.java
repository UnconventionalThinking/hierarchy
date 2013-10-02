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

package net.unconventionalthinking.reflection;

import net.unconventionalthinking.matrix.ExceptRuntime_Matrix_UnexpectedError;
import net.unconventionalthinking.matrix.Schema;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author peterjoh
 */
public class DynamicClassUtilities {

    public enum WarningAndError_Settings { Warn, Error, None }


    public static List<URL> classPath__CreateUrls(List<String> classPath_List, WarningAndError_Settings warnAndErrorSettings_InvalidClassPaths,
            List<String> warningMessage)
            throws MalformedURLException {
        List<URL> urls = new ArrayList<URL>();

        try {
            for (String classPath : classPath_List) {
                URL url = create_ClassPathElement_URL(classPath, warnAndErrorSettings_InvalidClassPaths, warningMessage);
                urls.add(url);
            }
        } catch (MalformedURLException e) {
            throw e;
        }
        return urls;
    }
    public static List<URL> classPath__CreateUrls(String[] classPath_List, WarningAndError_Settings warnAndErrorSettings_InvalidClassPaths,
            List<String> warningMessage)
            throws MalformedURLException {
        List<URL> urls = new ArrayList<URL>();

        try {
            for (String classPath : classPath_List) {
                URL url = create_ClassPathElement_URL(classPath, warnAndErrorSettings_InvalidClassPaths, warningMessage);
                urls.add(url);
            }
        } catch (MalformedURLException e) {
            throw e;
        }
        return urls;
    }


    private static URL create_ClassPathElement_URL(String classPath, WarningAndError_Settings warnAndErrorSettings_InvalidClassPaths,
            List<String> warningMessage) throws MalformedURLException {

        // Convert the file object to a URL
        File classPath_FileObj = new File(classPath);
        if (warnAndErrorSettings_InvalidClassPaths != null || warningMessage != null) {
            if (!classPath_FileObj.exists()) {
                if (warnAndErrorSettings_InvalidClassPaths == WarningAndError_Settings.Warn || warnAndErrorSettings_InvalidClassPaths == null)
                    warningMessage.add("The following class path does not refer to an existing directory or file: " + classPath);
                else if (warnAndErrorSettings_InvalidClassPaths == WarningAndError_Settings.Error)
                    throw new ExceptRuntime_Matrix_UnexpectedError("The following class path does not refer to an existing directory or file: " + classPath);
                else { // none
                    // do nothing
                }
            }
        }
        URL url = classPath_FileObj.toURI().toURL(); // ex. file:/c:/code/build_meta/

        return url;
    }







    public static boolean classPath__ClassExists(List<URL> classPath__Urls, String packageName, String className) throws MalformedURLException {
        return classPath__ClassExists(classPath__Urls,
                    (packageName != null && !packageName.trim().equals("")) ? packageName + "." + className : className
                );
    }
    public static boolean classPath__ClassExists(List<URL> classPath__Urls, String fullClassName) throws MalformedURLException {

        // Create a new class loader with the directory
        ClassLoader classLoader = new URLClassLoader(classPath__Urls.toArray(new URL[classPath__Urls.size()]));
        // Load in the class
        Class classObj = null;
        URL classUrl = classLoader.getResource(fullClassName.replace('.', '/') +".class");
        return (classUrl != null);
    }




    /**
     * This version takes in an array of the classFile base directories.<p>
     *
     * SEE JAVA DOC FOR OTHER VERSION OF THIS METHOD FOR REST OF DOCUMENTATION!!!
     */
    public static Class classPath__dynLoadClass(String fullClassName, String[] classPath_List,
            WarningAndError_Settings warnAndErrorSettings_InvalidClassPaths, List<String> warningMessage)
            throws ClassNotFoundException, MalformedURLException {
        return classPath__dynLoadClass(classPath__CreateUrls(classPath_List, warnAndErrorSettings_InvalidClassPaths, warningMessage), fullClassName);

    }
    /**
     * This version takes in a list of the classFile base directories.<p>
     *
     * SEE JAVA DOC FOR OTHER VERSION OF THIS METHOD FOR REST OF DOCUMENTATION!!!
     */
    public static Class classPath__dynLoadClass(String fullClassName, List<String> classPath_List,
            WarningAndError_Settings warnAndErrorSettings_InvalidClassPaths, List<String> warningMessage)
            throws ClassNotFoundException, MalformedURLException {
        return classPath__dynLoadClass(classPath__CreateUrls(classPath_List, warnAndErrorSettings_InvalidClassPaths, warningMessage), fullClassName);

    }


    /**
     * This version takes in a list of URL's for the classPaths.<p>
     *
     * SEE JAVA DOC FOR OTHER VERSION OF THIS METHOD FOR REST OF DOCUMENTATION!!!
     */
    public static Class classPath__dynLoadClass(List<URL> classPath_List, String fullClassName)
            throws ClassNotFoundException {
        return classPath__dynLoadClass(classPath_List.toArray(new URL[classPath_List.size()]),
                null, fullClassName);
    }



    /**
     * load a class from the given classpath List.
     *
     * <p>
     * This method will load classes dynamically, and will reload a class to (for instance, if your program modifies a class' source code, and
     * recompiles it, you cna use this method to reload it). BUT NOTE: the class file must not be in the class path! because we don't want the
     * class to be loaded by the "primordial" class loader, but by the dynamic one!! More specifically:<P>

     * There are a couple of rules that need to followed in order to dynamically reload classes.
     * 1. The path to the base of the dynamically loaded classes must not be in jvm's classpath. Why? because when the jvm loads, it will search
     * its classpath, and it will put any class it finds will be loaded using the "primordial class loader"
     * (for those classes found on the class path when the jvm started).
     * But, if sometime after the jvm start up, you compile a new class file and you try to reload it, if this class was already in the classpath,
     * the jvm will not reload the file from the newly generated class file, but it will use the "primordial class loader".
     * To solve this, make sure the base classPath_FileObj of the dyn loaded classes is not in the classpath.
     *
     * 2. after you dynamically load the class object using a classloader:
     *    ex. classObj = classLoader.loadClass(className);
     *   you need to create an instance of the class to actually have it dynamically reloaded. Even if all you're interested in is the static members,
     *   you can't just access a static field, you need to create an instance of the class to have it actually reload.
     *
     *
     * @param classPaths_List    The list of classpaths: base directories for class files and jars.
     * @param packageName
     * @param className
     * @return
     * @throws ClassNotFoundException
     */
    public static Class classPath__dynLoadClass(URL[] classPaths_List, String packageName, String className)
            throws ClassNotFoundException {
        try {
            // Create a new class loader with the directory
            ClassLoader classLoader = new URLClassLoader(classPaths_List);
            // Load in the class
            Class classObj = null;
            if (packageName != null)
                classObj = classLoader.loadClass(packageName + "." + className);
            else
                classObj = classLoader.loadClass(className);

            return classObj;

        } catch (ClassNotFoundException e) {
            throw e;
        }
    }





    public static boolean appClassPath__ClassExists(String packageName, String className) {
        return appClassPath__ClassExists(
                    (packageName != null && !packageName.trim().equals("")) ? packageName + "." + className : className
                );
    }
    public static boolean appClassPath__ClassExists(String fullClassName) {

        URL schema_Url = ClassLoader.getSystemResource(fullClassName.replace('.', '/') + ".class");
        return (schema_Url != null);
    }





    public static Class<?> appClassPath__LoadClass(String packageName, String className) {
        return appClassPath__LoadClass(
                    (packageName != null && !packageName.trim().equals("")) ? packageName + "." + className : className
                );
    }
    public static Class<?> appClassPath__LoadClass(String fullClassName) {
        try {
            return ClassLoader.getSystemClassLoader().loadClass(fullClassName);
        } catch (ClassNotFoundException e) {
            return null;
        }
        
    }




    public static void printJVMClassPath() {
        //Get the System Classloader
        ClassLoader sysClassLoader = ClassLoader.getSystemClassLoader();
        //Get the URLs
        URL[] urls = ((URLClassLoader)sysClassLoader).getURLs();
        for(int i=0; i< urls.length; i++)
            System.out.println("   - " + urls[i].getFile());
    }


}
