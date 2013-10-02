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

package net.unconventionalthinking.matrix;

import net.unconventionalthinking.matrix.symbols.*;

import java.lang.reflect.Constructor;
import java.util.*;

/**
 * What is the purpose SchemaControl_Info? to be able to pass parts of the schemaControl variables to objects
 * that are actually created or initializer _IN_ the SchemaControl constructor. For example, the SchemaForSchema_Container
 *
 * @author peterjoh
 */
public class SchemaControl_Info {

    public final Map<Symbol, Constructor> fieldSetTupleSpecialized_Constructor_Index_byTypeSymbol;


    public SchemaControl_Info(Map<Symbol, Constructor> fieldSetTupleSpecialized_Constructor_Index_byTypeSymbol) {
        
        this.fieldSetTupleSpecialized_Constructor_Index_byTypeSymbol = fieldSetTupleSpecialized_Constructor_Index_byTypeSymbol;
    }

}
