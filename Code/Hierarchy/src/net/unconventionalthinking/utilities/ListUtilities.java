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

import net.unconventionalthinking.matrix.Descriptor;
import java.util.*;

/**
 *
 * @author peterjoh
 */
public class ListUtilities {

    public static String print(List list) {
        return print(list, ", ");
    }

    public static String printWithDot(List list) {
        return print(list, ".");
    }

    public static String print(List list, String separator) {

        StringBuilder stringBuilder = new StringBuilder();

        if (list != null) {
            boolean isFirstItem = true;
            for (Object item : list) {
                if (!isFirstItem) {
                    stringBuilder.append(separator);
                }

                stringBuilder.append(item.toString());

                isFirstItem = false;
            }

        } else {
            return "";
        }


        return stringBuilder.toString();

    }

    public static String print(Object[] array) {
        return print(array, ", ");
    }

    public static String printWithDot(Object[] array) {
        return print(array, ".");
    }

    public static String print(Object[] array, String separator) {

        StringBuilder stringBuilder = new StringBuilder();

        if (array != null) {
            boolean isFirstItem = true;
            for (Object item : array) {
                if (!isFirstItem) {
                    stringBuilder.append(separator);
                }

                stringBuilder.append(item.toString());

                isFirstItem = false;
            }

        } else {
            return "";
        }


        return stringBuilder.toString();

    }

    public static void arrayList_Set__IncreaseSizeIfNeeded(ArrayList arrayList, int index, Object value) {

        int neededSize = index + 1;
        if (arrayList.size() < neededSize) {
            for (int i = arrayList.size(); i < neededSize; i++) {
                arrayList.add(null);
            }
        }
        arrayList.set(index, value);


    }
}
