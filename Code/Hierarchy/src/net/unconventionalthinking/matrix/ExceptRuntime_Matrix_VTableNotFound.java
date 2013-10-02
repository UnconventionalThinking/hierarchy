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

import net.unconventionalthinking.lang.*;

/**
 * This exception is thrown if a 'Task' can not find a vtable for the vTable symbol that was passed in.
 *
 * This is an Unchecked exception, so it can be throw at any time, and doesn't need to be declared in a method's throw statment. 
 * Why unchecked? because
 * it is a more fundamental, low level exception that really could be throw at any time.
 *
 * @author peterjoh
 */
public class ExceptRuntime_Matrix_VTableNotFound extends RuntimeException {

    public ExceptRuntime_Matrix_VTableNotFound(String message) {
        super(message);
    }
    public ExceptRuntime_Matrix_VTableNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
