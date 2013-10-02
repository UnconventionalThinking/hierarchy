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

package maintests.main;


import net.unconventionalthinking.hierarchy.HierarchyMetaCompiler;


/**
 *
 * @author peterjoh
 */
public class PersistClient_MainTests_Setup {


    public static void main(String[] args) throws Exception {
        System.out.println("Generating maintests");

        //  Check if the project path is passed in. This happens when an outside project like the HierarchyController project
        //  calls this method.
        String prePath = "";
        if (args != null && args.length == 1) {
            prePath = args[0].trim() + "/";
        }
        HierarchyMetaCompiler.main(new String[] { "-mpropfile", prePath + "src/maintests/main/PersistClient_MainTests.properties" });

    }

}