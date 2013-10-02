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

package net.unconventionalthinking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import net.unconventionalthinking.exceptions.ExceptRuntime_InvalidArgumentPassed;
import net.unconventionalthinking.exceptions.ExceptRuntime_MissingRequiredProperty;

/**
 *
 * @author Peter Joh
 */
public class PropertyFile {

    Properties properties;
    File propertiesFile;

    public PropertyFile(String propertiesFile_Path) throws IOException {

        File propertiesFile_Obj = new File(propertiesFile_Path);
        properties = loadPropertiesFile(propertiesFile_Obj, propertiesFile_Path);
    }

    public PropertyFile(File propertiesFile) throws IOException {
        this.propertiesFile = propertiesFile;
        loadPropertiesFile(propertiesFile, null);
    }

    public Properties getProperties() {
        return properties;
    }

    public File getPropertiesFile() {
        return propertiesFile;
    }

    public boolean propertyExists(String propertyName) {
        String propertyValue_String = properties.getProperty(propertyName);

        return (propertyValue_String != null && propertyValue_String.trim().length() > 0);
    }

    public String checkAndGetRequiredProperty_String(String propertyName) {
        String propertyValue_String = properties.getProperty(propertyName);

        if (propertyValue_String == null || propertyValue_String.trim().length() == 0) {
            throw new ExceptRuntime_MissingRequiredProperty("The required property, " + propertyName
                    + ", did not have a value in the properties file: " + propertiesFile.getAbsolutePath() + ".");
        }
        return propertyValue_String;

    }

    public int checkAndGetRequiredProperty_Int(String propertyName) {
        String propertyValue_String = properties.getProperty(propertyName);

        if (propertyValue_String == null || propertyValue_String.trim().length() == 0) {
            throw new ExceptRuntime_MissingRequiredProperty("The required property, " + propertyName
                    + ", did not have a value in the properties file: " + propertiesFile.getAbsolutePath() + ".");
        }
        try {
            return Integer.parseInt(propertyValue_String);
        } catch (NumberFormatException e) {
            throw new ExceptRuntime_InvalidArgumentPassed("The property, " + propertyName
                    + ", did not have an integer value in the properties file: " + propertiesFile.getAbsolutePath()
                    + ". It's value was: " + propertyValue_String + ".");
        }
    }

    public static Properties loadPropertiesFile(String propertiesFile_Path) throws IOException {
        File propertiesFile_Obj = new File(propertiesFile_Path);
        return loadPropertiesFile(propertiesFile_Obj, propertiesFile_Path);
    }

    public static Properties loadPropertiesFile(File propertiesFile) throws IOException {
        return loadPropertiesFile(propertiesFile, null);
    }

    /**
     *
     * @param propertiesFile
     * @param propertiesFile_Path_REDUDANT This path value is not used to load the file in any way, just in the output of errors.
     * @return
     * @throws IOException
     */
    private static Properties loadPropertiesFile(File propertiesFile, String propertiesFile_Path_REDUDANT) throws IOException {

        Properties properties;
        if (propertiesFile.exists()) {

            properties = new Properties();
            try {
                properties.load(new FileInputStream(propertiesFile));
                System.out.println("Loaded metacompiler file located at: " + propertiesFile.getCanonicalPath());

            } catch (IOException e) {
                throw e;
            }

        } else {
            boolean is_AbsolutePath = false;
            String filePath = propertiesFile_Path_REDUDANT;
            try {
                if (propertiesFile.getAbsolutePath() != null) {
                    filePath = propertiesFile.getAbsolutePath();
                    is_AbsolutePath = true;
                }
            } catch (Throwable t) {
                // do nothing
            }
            throw new IOException("Could not find the properties file located at "
                    + (is_AbsolutePath ? "absolute path: " : "relative path: ")
                    + filePath
                    + ".\nThe path passed in for the properties file is relative to the directory in which you ran the JVM.");
        }

        return properties;
    }
}
