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

/**
 *
 * @author peterjoh
 */
public class AnnotationParameters {

    //  NOTE: these are the same as DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed. Why didn't we just use those?
    //  Because the metac comiled code is read by the user, so he shouldn't use of the more internal enum's to Hierarchy.
    public enum AccessType { Descriptor, Field, DescriptorSet, FieldValueSet  }

    public enum AccessReturnType { accessValue, accessorValue }
    
}
