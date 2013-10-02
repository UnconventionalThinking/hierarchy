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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.unconventionalthinking.reflection;

import net.unconventionalthinking.hierarchy.Exception_HierarchyCompiler;
import java.lang.reflect.Field;

/**
 *
 * @author peterjoh
 */
public class FieldAccessor {

    /**
     * For static access, pass null as target object.
     *
     * @param targetObject          For static access, pass null as target object.
     * @param targetObjectClass
     * @param fieldName
     * @return
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static Object access(Object targetObject, Class targetObjectClass, String fieldName)
        throws Exception_HierarchyCompiler {

        try {

            Field field = targetObjectClass.getField(fieldName);

            return field.get(targetObject);
        } catch (Exception e) {
            throw new Exception_HierarchyCompiler("Tried to dynamically load and init the appControl for the Schemas, but had an error.", e);
        }

    }
}
