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

package net.unconventionalthinking.lang;

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
public class Objects_HashMapTest {

    public Objects_HashMapTest() {   }

    @BeforeClass
    public static void setUpClass() throws Exception {   }
    @AfterClass
    public static void tearDownClass() throws Exception {   }
    @Before
    public void setUp() {   }
    @After
    public void tearDown() {   }

    
    
    

    @Test
    public void testObjectHashMap() {

        System.out.println("Object_HashMap Test");
        Objects_HashMap objectMap_to_id = new Objects_HashMap<String>();

        TestObject t1 = new TestObject("t1");
        TestObject t2 = new TestObject("t2");
        TestObject t3 = new TestObject("t3");

        objectMap_to_id.put(t1, t1.value);
        objectMap_to_id.put(t2, t2.value);
        objectMap_to_id.put(t3, t3.value);


        TestObject t1ref = t1;

        assertEquals("t1", objectMap_to_id.get(t1ref));
        assertEquals("t2", objectMap_to_id.get(t2));
        assertEquals("t3", objectMap_to_id.get(t3));
    }


    

    class TestObject {

        public String value;

        public TestObject(String value) {
            this.value = value;
        }

        
        @Override
        public int hashCode() {
            throw new RuntimeException("ERROR: Objects_HashMap should not call this method!! it should use the ObjectKey.hashCode()");
        }

        @Override
        public boolean equals(Object obj) {
            throw new RuntimeException("ERROR: Objects_HashMap should not call this method!! it should use the ObjectKey.equals(), which use '==' operator");
        }

    }


}