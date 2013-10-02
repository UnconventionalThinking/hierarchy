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

import net.unconventionalthinking.lang.ExecutionInfo;

/**
 *
 * @author peterjoh
 */
public class DescriptorUtilities {

    public static boolean validDescriptors(ExecutionInfo executeInfo, Descriptor descriptor) {
        if (descriptor == null)
            return false;
        return true; // TODO - create valid descriptors method

    }
    public static boolean validDescriptors(ExecutionInfo executeInfo, MatrixSet<Descriptor> descriptorSet) {
        return true; // TODO - create valid descriptors method

    }

    public static boolean check_ChildDescriptorIsAddable(Descriptor parentDescriptor, Descriptor childDescriptor) {
        /*FIX*/
        return true;
    }
}
