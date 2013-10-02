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

import net.unconventionalthinking.matrix.ExceptRuntime_Matrix_GeneralError;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;


/**
 * Don't use this. Use DynamicClassUtilities instead.
 * 
 * Dynamically adds Jars (or whatever classpath elements) to Classpath, by adding them to System class loader.
 *
 * This is a hack. It calls the non-public method, addUrl on the system class loader, to add the class path element.
 * @author peterjoh
 */
public class DynamicClassPath_Adder {


    private static final Class[] addUrl_ParamTypes = new Class[] { URL.class };

    private static final Class urlClassLoader_Class;
    private static final Method addUrl_Method;
    private static final URLClassLoader systemClassLoader;

    static {

        urlClassLoader_Class = URLClassLoader.class;
        try {
            addUrl_Method = urlClassLoader_Class.getDeclaredMethod("addURL", addUrl_ParamTypes);

        } catch (NoSuchMethodException e) {
            throw new ExceptRuntime_Matrix_GeneralError("This should not happen. We are trying to dynmically load a class, and while setting up the " +
                    "URL Class Loader, we could not get the addURL method from the urlclassloader object using reflection.");
        }

        
        systemClassLoader = (URLClassLoader)ClassLoader.getSystemClassLoader();
        
        
    }




    public static boolean add_ClassPathElement(String classPathElement_Path) throws MalformedURLException {
        return add_ClassPathElement(new File(classPathElement_Path));
    }

    public static boolean add_ClassPathElement(File classPathElement_FileObj) throws MalformedURLException {

        if (!classPathElement_FileObj.exists())
            return false;
        URL classPathElement_URL = classPathElement_FileObj.toURI().toURL();
        String classPathElement_Path = classPathElement_FileObj.getAbsolutePath();

        //  turn of java method accessibility check
        addUrl_Method.setAccessible(true);
        try {
            addUrl_Method.invoke(systemClassLoader, classPathElement_URL);
        } catch (Exception e) {
            throw new ExceptRuntime_Matrix_GeneralError("Tried to add a the class path, " + classPathElement_Path +
                    ", to the current application, but could not invoke the addURL() method on the systemClassLoader.");
        }
        
        return true;
    }

}
