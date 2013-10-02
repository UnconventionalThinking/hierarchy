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

package net.unconventionalthinking.hierarchy;

/**
 *
 * @author peterjoh
 */
public class AppControl_Info {

    public String fullTypeName;

    public AppControl_Info(String fullTypeName) {
        this.fullTypeName = fullTypeName;
    }








    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AppControl_Info other = (AppControl_Info) obj;
        if ((this.fullTypeName == null) ? (other.fullTypeName != null) : !this.fullTypeName.equals(other.fullTypeName)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.fullTypeName != null ? this.fullTypeName.hashCode() : 0);
        return hash;
    }



}
