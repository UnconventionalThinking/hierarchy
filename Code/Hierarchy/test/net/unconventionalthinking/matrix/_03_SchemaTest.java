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

import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
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
public class _03_SchemaTest {

    // we don't need the real thing right now. just a tester object to do testing with.
    private static AppControl_Base appControl_MockObj;
    private static ExecutionInfo executeInfo = new ExecutionInfo();
    private static SymbolControl symbolControl;
    private static SchemaControl schemaControl;
    private static TestUtilities_1_Schema schemaAndMatrix_Utilities;

    private static SchemaInfo_Schema webForm_Schema;




    public _03_SchemaTest() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
        appControl_MockObj = new AppControl_Simple();

        symbolControl = new SymbolControl();
        symbolControl.intialize_All_MPSymbols();

        appControl_MockObj.executionInfo = executeInfo;
        appControl_MockObj.symbolControl = symbolControl;
        schemaControl = new SchemaControl(executeInfo, appControl_MockObj);

        schemaAndMatrix_Utilities = new TestUtilities_1_Schema(executeInfo, schemaControl, symbolControl);
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
     * Test of add_ChildDescriptor method, of class Descriptor.
     */
    @Test
    public void testSchemaCreation() throws Exception {
        System.out.println("testSchemaCreation. Also test add_ChildDescriptor()");

        webForm_Schema = schemaAndMatrix_Utilities.buildTestSchema(0);

        TestUtilities_1_SchemaTester schemaTester = new TestUtilities_1_SchemaTester();
        schemaTester.testSchema_FirstPart(webForm_Schema, executeInfo, symbolControl);
        schemaTester.testSchema_SecondPart(webForm_Schema, executeInfo, symbolControl);

       
    }



    /**
     * Test of add_ChildDescriptor method, of class Descriptor.
     */
    @Test
    public void testSchemaInfo() throws Exception {
        System.out.println("testSchemaInfo");



    }
}