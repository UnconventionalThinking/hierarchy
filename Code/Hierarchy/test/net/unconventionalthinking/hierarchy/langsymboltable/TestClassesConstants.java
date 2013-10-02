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

package net.unconventionalthinking.hierarchy.langsymboltable;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author peterjoh
 */
public class TestClassesConstants {


	public static final String TypeInfoTest_Package = "maintests.samples.typeinfotest";
	public static final List<String> TypeInfoTest_Package_Parts = Arrays.asList("maintests", "samples", "typeinfotest");

	public static final String JavaTypeInfoTestSample_SimpleClassName = "Java_TypeInfoTestSample";
	public static final String JavaTypeInfoTestSample_FullClassName = TypeInfoTest_Package + "." + JavaTypeInfoTestSample_SimpleClassName;

	public static final String innerClassName_Simple = "innerClass";
	public static final String innerClassName_withNestedNames = "Java_TypeInfoTestSample.innerClass";
	public static final String innerClass_FullName = TypeInfoTest_Package + "." + innerClassName_withNestedNames;
	public static final List<String> innerClassName_Parts = Arrays.asList("Java_TypeInfoTestSample", "innerClass");

    public static final String innerClassMethod = "innerClassMethod";

    public static final String secondInnerClass_SimpleName = "secondInnerClass";
    public static final String secondInnerClass_withNestedNames = innerClassName_withNestedNames + "." + secondInnerClass_SimpleName;
    public static final String secondInnerClass_FullTypeName = TypeInfoTest_Package + "." + secondInnerClass_withNestedNames;


    public static final String Java_TestSample_Simple_SimpleClassName = "Java_TestSample_Simple";
    public static final String Java_TestSample_Simple_FullClassName = TypeInfoTest_Package + "." + Java_TestSample_Simple_SimpleClassName;


	public static final String MjavaTypeInfoTestSample_SimpleClassName = "Mjava_TypeInfoTestSample";
	public static final String MjavaTypeInfoTestSample_FullClassName = TypeInfoTest_Package + "." + MjavaTypeInfoTestSample_SimpleClassName;


	public static final String TestClass_InSamePackage = "TestClass";
	public static final String TestClass_FullName_InSamePackage = "maintests.samples.typeinfotest.TestClass";

	public static final String TestClassInOtherPackage_SimpleName = "TestClassInOtherPackage";
	public static final String TestClassInOtherPackage_FullName = "maintests.samples.typeinfotest.otherpackage.TestClassInOtherPackage";

    public static final String TestChildClass_InOtherPackage_FullName = "maintests.samples.typeinfotest.otherpackage.TestChildClass";


	public static final String TestClassInAnotherPackage_SimpleName = "TestClassInAnotherPackage";
	public static final String TestClassInAnotherPackage_FullName = "maintests.samples.typeinfotest.anotherpackage.TestClassInAnotherPackage";


	public static final String TestClassInThirdPackage_SimpleName = "TestClassInThirdPackage";
	public static final String TestClassInThirdPackage_FullName = "maintests.samples.typeinfotest.thirdpackage.TestClassInThirdPackage";

	public static final String TestClass2_InThirdPackage_SimpleName = "TestClass2_InThirdPackage";
	public static final String TestClass2_InThirdPackage_FullName = "maintests.samples.typeinfotest.thirdpackage.TestClass2_InThirdPackage";



}
