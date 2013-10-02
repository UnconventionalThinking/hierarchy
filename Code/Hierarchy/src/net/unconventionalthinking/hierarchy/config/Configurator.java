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

package net.unconventionalthinking.hierarchy.config;

import java.io.IOException;
import net.unconventionalthinking.utilities.PropertyFile;

/**
 * The purpose of this base Configurator class is so that all hierarchy configurators (for things like the main, hierarchy, meta-compiler settings
 * and persistence) all config the same way.
 *
 * @author Peter Joh
 */
public abstract class Configurator {

    public PropertyFile properties;

    public Configurator(String propertiesFile_Path) throws IOException {
        properties = new PropertyFile(propertiesFile_Path);
    }
    /**
     * This constructor typically is called by other configurator objects that already have a PropertyFile, and don't need one constructed.
     */
    public Configurator(PropertyFile properties) throws IOException {
        this.properties = properties;
    }


    abstract public Object configure() throws Exception;

}
