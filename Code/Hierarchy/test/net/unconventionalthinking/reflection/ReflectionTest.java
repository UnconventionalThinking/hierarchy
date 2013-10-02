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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.unconventionalthinking.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author peterjoh
 */
public class ReflectionTest {

    public ReflectionTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getMethods method, of class Reflection.
     */
    @Test
    public void testGetMethods() {
        //____________________________________________________________________________________________________________

        System.out.println("Reflection: getMethods(): Basic case");
        //____________________________________________________________________________________________________________

        Class classObj = ReflectionSampleClass.class;
        String filter = "get.*";
        String[] includeMethods_List = null;
        String[] excludeMethods_List = null;


        List<Method> result = Reflection.getMethods(classObj, filter, includeMethods_List, excludeMethods_List);
        assertEquals("getMethod1", result.get(0).getName());
        assertEquals("getMethod2", result.get(1).getName());
        assertEquals("getMethod3", result.get(2).getName());
        assertEquals("getMethod4", result.get(3).getName());
        assertEquals(result.size(), 4);

    }

    /**
     * Test of getMethods method, of class Reflection.
     */
    @Test
    public void testGetMethods_InclusionExclusion_FirstTestSet() {

        //____________________________________________________________________________________________________________

        System.out.println("Reflection: getMethods(): Exclusion Test 1: one exclusion");
        //____________________________________________________________________________________________________________

        Class classObj = ReflectionSampleClass.class;
        String filter = "get.*";
        String[] includeMethods_List = null;
        String[] excludeMethods_List = {"getMethod2"};


        List<Method> result = Reflection.getMethods(classObj, filter, includeMethods_List, excludeMethods_List);
        assertEquals("getMethod1", result.get(0).getName());
        assertEquals("getMethod3", result.get(1).getName());
        assertEquals("getMethod4", result.get(2).getName());
        assertEquals(result.size(), 3);



        //____________________________________________________________________________________________________________

        System.out.println("Reflection: getMethods(): Exclusion Test 2: multiple exclusions");
        //____________________________________________________________________________________________________________

        classObj = ReflectionSampleClass.class;
        filter = "get.*";
        String[] includeMethods_List2 = null;
        String[] excludeMethods_List2 = {"getMethod2", "getMethod1"};


        result = Reflection.getMethods(classObj, filter, includeMethods_List2, excludeMethods_List2);
        assertEquals("getMethod3", result.get(0).getName());
        assertEquals("getMethod4", result.get(1).getName());
        assertEquals(result.size(), 2);



        //____________________________________________________________________________________________________________

        System.out.println("Reflection: getMethods(): Exclusion: Test 3: with Inclusion");
        //____________________________________________________________________________________________________________

        classObj = ReflectionSampleClass.class;
        filter = "get.*2";
        String[] includeMethods_List3 = {"getMethod3"};
        String[] excludeMethods_List3 = {"getMethod1"};


        result = Reflection.getMethods(classObj, filter, includeMethods_List3, excludeMethods_List3);
        assertEquals("getMethod2", result.get(0).getName());
        assertEquals("getMethod3", result.get(1).getName());
        assertEquals(result.size(), 2);



        //____________________________________________________________________________________________________________

        System.out.println("Reflection: getMethods(): Exclusion Test 4: Test that exclusion wins over inclusion");
        //____________________________________________________________________________________________________________

        classObj = ReflectionSampleClass.class;
        filter = "get.*2";
        String[] includeMethods_List4 = {"getMethod3"};
        String[] excludeMethods_List4 = {"getMethod3"};


        result = Reflection.getMethods(classObj, filter, includeMethods_List4, excludeMethods_List4);
        assertEquals("getMethod2", result.get(0).getName());
        assertEquals(result.size(), 1);

   }




    /**
     * Test of getMethods method, of class Reflection.
     */
    @Test
    public void testGetMethods_InclusionExclusion_SecondTestSet() {

        //____________________________________________________________________________________________________________

        System.out.println("Reflection: getMethods(): EmptyFilter Test 1: test no filter and empty inclusion list " +
                                " but with an exclusion list (that will have no matches!)");
        //____________________________________________________________________________________________________________

        Class classObj = ReflectionSampleClass.class;
        String filter = "";
        String[] includeMethods_List = null;
        String[] excludeMethods_List = {"getMethod3"};


        List<Method> result = Reflection.getMethods(classObj, filter, includeMethods_List, excludeMethods_List);
        assertEquals(result.size(), 0);


        //____________________________________________________________________________________________________________

        System.out.println("Reflection: getMethods(): Test Multiple Inclusions");
        //____________________________________________________________________________________________________________

        classObj = ReflectionSampleClass.class;
        filter = "";
        String[] includeMethods_List2 = {"getMethod1", "getMethod2", "getMethod3"};
        String[] excludeMethods_List2 = {"getMethod3"};


        result = Reflection.getMethods(classObj, filter, includeMethods_List2, excludeMethods_List2);
        assertEquals("getMethod1", result.get(0).getName());
        assertEquals("getMethod2", result.get(1).getName());
        assertEquals(result.size(), 2);


        //____________________________________________________________________________________________________________

        System.out.println("Reflection: getMethods(): Test Multiple Inclusions & Exclusions");
        //____________________________________________________________________________________________________________

        classObj = ReflectionSampleClass.class;
        filter = "";
        String[] includeMethods_List3 = {"getMethod2", "getMethod3", "getMethod1"};
        String[] excludeMethods_List3 = {"getMethod3", "getMethod2"};


        result = Reflection.getMethods(classObj, filter, includeMethods_List3, excludeMethods_List3);
        assertEquals("getMethod1", result.get(0).getName());
        assertEquals(result.size(), 1);


        //____________________________________________________________________________________________________________

        System.out.println("Reflection: getMethods(): Inclusions List with no Matches");
        //____________________________________________________________________________________________________________

        classObj = ReflectionSampleClass.class;
        filter = "";
        String[] includeMethods_List4 = {"Method2", "getMethod", "getA"}; // has no matches
        String[] excludeMethods_List4 = null;


        result = Reflection.getMethods(classObj, filter, includeMethods_List4, excludeMethods_List4);
        assertEquals(result.size(), 0);


        //____________________________________________________________________________________________________________

        System.out.println("Reflection: getMethods(): Exclusion & Inclusions List with a mix of matches, no matches");
        //____________________________________________________________________________________________________________

        classObj = ReflectionSampleClass.class;
        filter = "getMethod4";
        String[] includeMethods_List5 = {"Metho", "getMethod2", "getA", ".*3"}; // includes method 2 & 3
        String[] excludeMethods_List5 = {"sdf", ".*3", "getMe", ".*22"}; // excludes only method 3


        result = Reflection.getMethods(classObj, filter, includeMethods_List5, excludeMethods_List5);
        assertEquals("getMethod2", result.get(0).getName());
        assertEquals("getMethod4", result.get(1).getName());
        assertEquals(result.size(), 2);

   }


}