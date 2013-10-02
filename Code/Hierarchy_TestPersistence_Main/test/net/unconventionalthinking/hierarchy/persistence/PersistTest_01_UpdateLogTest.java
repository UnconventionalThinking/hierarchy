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

package net.unconventionalthinking.hierarchy.persistence;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
public class PersistTest_01_UpdateLogTest {

    public PersistTest_01_UpdateLogTest() {}


    static Employee employee1;
    static Employee employee2;
    static Employee manager;

    
    File javaObjects_File;
    ObjectOutputStream javaObjects_Out;

    
    @BeforeClass
    public static void setUpClass() throws Exception {
        manager = new Employee("Bill", 1, null);
        employee1 = new Employee("Joe", 2, manager);
        employee2 = new Employee("Tom", 3, manager);



    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {}
    @Before
    public void setUp() {}
    @After
    public void tearDown() {}

/*

    @Test
    public void updateLogReader_Cmds_Test() throws Exception {

        javaObjects_File = new File(PersistenceTestWorker_Constants.JavaObjects_OutputFile_Path);
        if (javaObjects_File.exists())
            javaObjects_File.delete();
        javaObjects_File.createNewFile();

        javaObjects_Out = new ObjectOutputStream(new FileOutputStream(javaObjects_File));


        javaObjects_Out.writeChars("@AAAAA(");
        javaObjects_Out.writeObject(manager);
        javaObjects_Out.writeChars(");\n");
        javaObjects_Out.writeChars("@BBBBB(");
        javaObjects_Out.writeObject(employee1);
        javaObjects_Out.writeChars(");\n");
        javaObjects_Out.writeChars("@CCCCC(");
        javaObjects_Out.writeObject(employee2);
        javaObjects_Out.writeChars("); \n");

        javaObjects_Out.close();



        UpdateLog_Reader updateLog_Reader = new UpdateLog_Reader(javaObjects_File);


        int cmdCount = 0;
        while (updateLog_Reader.hasCharactersToRead()) {

            String command = updateLog_Reader.readCommandCode(true);
            if (command != null) {
                assertEquals(CommandConstants.CommandLength, command.length());

                Employee employee = (Employee)updateLog_Reader.readJavaObject();
                updateLog_Reader.readEndOfLine();

                assertNotNull(employee);


                cmdCount++;

            } else {
                assertEquals(3, cmdCount);
            }
        }

    }


*/

    


    @Test
    public void updateLogReader_JavaObjects_Test() throws Exception {

        javaObjects_File = new File(PersistenceTestWorker_Constants.JavaObjects_OutputFile_Path);
        if (javaObjects_File.exists())
            javaObjects_File.delete();
        javaObjects_File.createNewFile();

        javaObjects_Out = new ObjectOutputStream(new FileOutputStream(javaObjects_File));


        javaObjects_Out.writeChars("@AAAAA");
        javaObjects_Out.writeObject(manager);
        javaObjects_Out.writeChars(";\n");
        javaObjects_Out.writeChars("@BBBBB");
        javaObjects_Out.writeObject(employee1);
        javaObjects_Out.writeChars(";\n");
        javaObjects_Out.writeChars("@CCCCC");
        javaObjects_Out.writeObject(employee2);
        javaObjects_Out.writeChars(";\n");

        javaObjects_Out.close();



        UpdateLog_Reader updateLog_Reader = new UpdateLog_Reader(javaObjects_File);

        List<Employee> employeelist = new ArrayList<Employee>();

        int countEmployee = 0;
        while (updateLog_Reader.hasCharactersToRead()) {

            String command = updateLog_Reader.readCommandCode(true);
            if (command != null) {
                assertEquals(CommandConstants.CommandLength, command.length());

                Employee employee = (Employee)updateLog_Reader.readValues_ObjectCreate();
                updateLog_Reader.readEndOfLine();

                assertNotNull(employee);

                employeelist.add(employee);

                countEmployee++;
                
            } else {
                assertEquals(3, countEmployee);
            }
        }

        assertEquals(manager.name, employeelist.get(0).name);
        assertEquals(employee1.name, employeelist.get(1).name);
        assertEquals(employee2.name, employeelist.get(2).name);

        assertEquals(employeelist.get(0), employeelist.get(1).manager);
        assertEquals(employeelist.get(0), employeelist.get(2).manager);
    }


}





class Employee implements Serializable {

    Employee(String name, int age, Employee manager) {
        this.name = name;
        this.age = age;
        this.manager = manager;
    }

    String name;
    int age;
    Employee manager;
}