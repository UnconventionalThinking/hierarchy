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

import  maintests.samples.typeinfotest.otherpackage.TestClassInOtherPackage;
import  maintests.samples.typeinfotest.anotherpackage.*;
import  maintests.samples.typeinfotest.thirdpackage.TestClassInThirdPackage;


public class Java_TypeInfoTestSample extends TestClassInThirdPackage {
    public int f;
    public innerClass f0;
    public innerClass.secondInnerClass f1 = null;
    public Java_TypeInfoTestSample.innerClass.secondInnerClass f2;

    public TestClassInOtherPackage f4;

    public Java_TypeInfoTestSample f5;


    //public secondInnerClass f2; // bad, not in scope
    
    public static class innerClass {
       public class secondInnerClass{}

       public long myLong;
       
       private TestClassInThirdPackage innerClassMethod(int p1, TestClassInOtherPackage p2) {

           Java_TypeInfoTestSample var1;
           TestClassInAnotherPackage var2;

           return null;
       }

    }

    public enum innerEnum {}

    // Constructor
    public Java_TypeInfoTestSample(TestClassInOtherPackage p3) {

           Java_TypeInfoTestSample var1;
           TestClassInAnotherPackage var2;
    }


}

/*
class nonPublicClass2 extends maintests.samples.typeinfotest.Java_TypeInfoTestSample.innerClass {}

class nonPublicClass3 extends TestClassInAnotherPackage { }
 
 */