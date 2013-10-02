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

package net.unconventionalthinking.matrix;

import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.SchemaInfo.Type;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.matrix.symbols.Symbol_MultiPart;
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
public class SchemaInfo_FieldTest {


    private static ExecutionInfo executeInfo = new ExecutionInfo();
    public static SymbolControl symbolControl = new SymbolControl();


    public SchemaInfo_FieldTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {

        symbolControl.intialize_All_MPSymbols();
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





    @Test
    public void test_SchemaInfoField_w_Continuation() throws Exception {

        //  SchemaInfo_Field with continuation with one extra symbol level
        int fieldIndex = 0;

        SchemaInfo_Field schemaInfoField_SingleLevelContinuation = new SchemaInfo_Field(executeInfo, fieldIndex, null, null,
                MPSymbols.ContinuationType$__$Symbol, symbolControl, null);

        assertNotNull(MPSymbols.Symbol); // make sure it's initialized
        assertEquals(MPSymbols.Symbol, schemaInfoField_SingleLevelContinuation.fieldType_Symbol_No_ContinuationType);



        //  SchemaInfo_Field with continuation with many extra symbol level
        List<String> symbolStrings = new ArrayList<String>();

        symbolStrings = new ArrayList<String>();
        symbolStrings.add(MPSymbols.ContinuationType.name);
        symbolStrings.add("level1");
        symbolStrings.add("level2");
        symbolStrings.add("myType");
        Symbol testType_withContinunation = symbolControl.multiPartSymbol_Factory.createNew(symbolStrings, 1, true);
        Symbol testType_NoContinuation = ((Symbol_MultiPart)testType_withContinunation).createSymbol_StartingAtLevel(
                                                                                        symbolControl.multiPartSymbol_Factory, 2, true);

        SchemaInfo_Field schemaInfoField_MultiLevelContinuation = new SchemaInfo_Field(executeInfo, fieldIndex, null, null,
                testType_withContinunation, symbolControl, null);

        assertEquals(testType_NoContinuation, schemaInfoField_MultiLevelContinuation.fieldType_Symbol_No_ContinuationType);
    }



}