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

package maintests.samples.typeinfotest;

import java.util.List;


/**
 * This class does not refer to any types outside of this class. Some test need this.
 */
public class Java_TestSample_Simple  {
    public int f;
    public innerClass f0;
    public innerClass.secondInnerClass f1 = null;
    public Java_TestSample_Simple.innerClass.secondInnerClass f2;


    public Java_TestSample_Simple f3;


    
    public static class innerClass {
       public class secondInnerClass{}

       public long myLong;
       
       private List innerClassMethod(int p1, List p2) {

           Java_TestSample_Simple var1;
 
           return null;
       }

    }

    public enum innerEnum {}

    // Constructor
    public Java_TestSample_Simple(int p3) {

           Java_TestSample_Simple var1;
    }


}

