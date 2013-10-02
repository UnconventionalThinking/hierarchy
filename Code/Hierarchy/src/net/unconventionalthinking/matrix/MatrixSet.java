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

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author peterjoh
 */

//  TODO implement List<Type> instead of Iterable<Type> (List<Type> extends Iteraable<Type>)
public class MatrixSet<Type> implements Iterable<Type> {


    public MatrixSet() {
        subset_Min = 0;
        has_SubsetMax = false;
        subset_Max = -1;
    }



    public MatrixSet(int subset_Max) {
        this(0, subset_Max);
    }

    public MatrixSet(int subset_Min, int subset_Max) {
        this.subset_Min = 0;
        this.subset_Max = -1;
        if (subset_Max > 0)
            this.has_SubsetMax = false;
        else
            this.has_SubsetMax = true;
    }


    public MatrixSet(ArrayList arrayList) {
        this(arrayList, 0, -1);
    }
    public MatrixSet(ArrayList arrayList, int subset_Max) {
        this(arrayList, 0, subset_Max);
    }

    public MatrixSet(ArrayList arrayList, int subset_Min, int subset_Max) {

        items = arrayList;
        for (Object item : arrayList)
            items_HashSet.add((Type)item);


        this.subset_Min = subset_Min;
        this.subset_Max = subset_Max;
        if (subset_Max > 0)
            this.has_SubsetMax = false;
        else
            this.has_SubsetMax = true;
    }



    public MatrixSet<Type> add(Type item) {
        items.add(item);
        items_HashSet.add(item);

        return this;
    }
    public MatrixSet<Type> add(Type... items) {

        for (Type item : items) {
            this.items.add(item);
            this.items_HashSet.add(item);
        }
        return this;
    }

    public MatrixSet<Type> add(Collection<Type> items) {
        for (Type item : items) {
            this.items.add(item);
            this.items_HashSet.add(item);
        }
        return this;
    }

    
    public Type get(int index) {
        return items.get(index);
    }
    public boolean contains(Type objectToCheck_UsesHashCode) {
        return items_HashSet.contains(objectToCheck_UsesHashCode);
    }

    public int size() { return items.size(); }


    public Iterator<Type> iterator() {
        return items.iterator();
    }
    public Iterator<Type> reverseIterator() {
        Iterator<Type> reverseIterator = new ReverseIterator();
        return reverseIterator;
    }


    public List<Type> getItems() { return items; }


    public void union(MatrixSet<Type> setToUnion, boolean noDuplicates) {

        if (setToUnion != null) {

            if (noDuplicates) {
                for (Type itemToAdd : setToUnion) {
                    if (!this.contains(itemToAdd))
                        this.add(itemToAdd);
                }

            } else {
                for (Type itemToAdd : setToUnion) {
                    this.add(itemToAdd);
                }
            }

        }
    }

    
    protected int subset_Min;

    protected boolean has_SubsetMax;
    protected int subset_Max;

    protected List<Type> items = new ArrayList<Type>();
    protected java.util.Set<Type> items_HashSet = new java.util.HashSet<Type>();




    private class ReverseIterator implements Iterator<Type> {

        int numItems = items.size();
        int currIndex = items.size();

        public ReverseIterator() {
        }

        public boolean hasNext() {
            return currIndex > 0;
        }

        public Type next() {
            return items.get(--currIndex);
        }

        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }


}
