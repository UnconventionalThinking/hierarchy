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

package net.unconventionalthinking.hierarchy.compileractions;

import net.unconventionalthinking.compiler.tools.CodeBuilder;
import java.util.ArrayList;
import java.util.List;



/**
 * To use this class, before creating an identifier, assign an new ArrayList to collect the parts in. Then, afterwards, assign to null for
 * use by the next action that needs it.
 */
public class IdentifierParts {

    List<String> identifier_Parts;

    public void createNewIdentifier() {
        identifier_Parts = new ArrayList<String>();
    }


    public void addPart(String part) {
        identifier_Parts.add(part);
    }


    public String generateIdentifier() {
        CodeBuilder identifier_Full = new CodeBuilder();


        for (String part : identifier_Parts) {
            if (identifier_Full.length() == 0) {
                identifier_Full.append(part);
            } else {
                identifier_Full.append('.').append(part);
            }
        }

        return identifier_Full.toString();
    }



    public void clearParts() {
        identifier_Parts = null;
    }



    public boolean isEmpty() {
        return identifier_Parts == null || identifier_Parts.isEmpty();
    }

    public boolean isNull() {
        return identifier_Parts == null;
    }
}