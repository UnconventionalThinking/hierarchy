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

package net.unconventionalthinking.matrix.symbols;

import net.unconventionalthinking.lang.Boolean_Mutable;
import java.util.*;
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
public class MultiLevelSymbol_Test {

    public MultiLevelSymbol_Test() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        symbolControl = new SymbolControl();
        symbolControl.intialize_All_MPSymbols();
        
        multiLevelSym_Factory = symbolControl.multiLevelSymbol_Factory;
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


    public static SymbolControl symbolControl;
    public static Symbol_MultiLevel_Factory multiLevelSym_Factory;


    public static MatrixName testSchemaName;

    @Test
    public void testCreateNew_SchemaName() throws Exception {
        System.out.println("CreateNew_SchemaName");

        boolean creation_Has_StaticVersion = true;
        DescriptorTagName packageName = MPSymbols_DescTagName.MATRIX$__$BASE;
        DescriptorTagName schemaName = MPSymbols_DescTagName.STANDARD;

        MatrixName result = multiLevelSym_Factory.createNew_SchemaName(packageName, schemaName, creation_Has_StaticVersion);
        
        String schemaNameFull_String = packageName.get_Name_no_backtiks() + "::" + schemaName.get_Name_no_backtiks();

        assertEquals(packageName, result.getPackageName());
        assertEquals(schemaName, result.getMatrixName());
        assertEquals(schemaNameFull_String, result.get_Name_no_backtiks());


        // test descTagOrLabel is being put in right index
        Symbol foundSymbol = symbolControl.schemaName_Index.get_MultiLevelSymbol_ById(result.getID());
        assertEquals(result, foundSymbol);

        
        
        // Now, test if try to create identical one, same object is returned

        MatrixName result2 = multiLevelSym_Factory.createNew_SchemaName(packageName, schemaName, creation_Has_StaticVersion);
        assertTrue(result2 == result);

        testSchemaName = result;
    }






    @Test
    public void testCreateNew_DescTagName() throws Exception {
        System.out.println("CreateNew_DescTagName");

        boolean creation_Has_StaticVersion = true;
        MatrixName schemaName = testSchemaName;
        DescriptorTagName descTagName = MPSymbols_DescTagName.ITEM;

        DescriptorTag result = multiLevelSym_Factory.createNew_DescriptorTag(schemaName, descTagName, creation_Has_StaticVersion);

        String descTag_String = schemaName.get_Name_no_backtiks() + "::" + descTagName.get_Name_no_backtiks();

        assertEquals(schemaName, result.getSchemaName_Full());
        assertEquals(descTagName, result.getDescTagName());
        assertEquals(descTag_String, result.get_Name_no_backtiks());

        // Now, check the multi-part index

        // test descTagOrLabel is being put in right index
        Symbol foundSymbol = symbolControl.descTag_Index.get_MultiLevelSymbol_ById(result.getID());
        assertEquals(result, foundSymbol);

        // Now, test if try to create identical one, same object is returned
        DescriptorTag result2 = multiLevelSym_Factory.createNew_DescriptorTag(schemaName, descTagName, creation_Has_StaticVersion);
        assertTrue(result2 == result);



        //  Test 2 _________________________________________
        DescriptorTagName packageName = MPSymbols_DescTagName.FIELD$__$TYPES;
        DescriptorTagName schemaNameDescTagName = MPSymbols_DescTagName.MATRIX$__$BASE;
        descTagName = MPSymbols_DescTagName.FIELD$__$DEFAULTS;

        result = multiLevelSym_Factory.createNew_DescriptorTag(packageName, schemaNameDescTagName, descTagName, creation_Has_StaticVersion);

        descTag_String = packageName.get_Name_no_backtiks() + "::" + schemaNameDescTagName.get_Name_no_backtiks() + "::" +
                                    descTagName.get_Name_no_backtiks();

        assertEquals(packageName, result.getPackageName());
        assertEquals(schemaNameDescTagName, result.getSchemaName());
        assertEquals(descTagName, result.getDescTagName());
        assertEquals(descTag_String, result.get_Name_no_backtiks());

        // test descTagOrLabel is being put in right index
        foundSymbol = symbolControl.descTag_Index.get_MultiLevelSymbol_ById(result.getID());
        assertEquals(result, foundSymbol);

        // Now, test if try to create identical one, same object is returned
        result2 = multiLevelSym_Factory.createNew_DescriptorTag(packageName, schemaNameDescTagName, descTagName, creation_Has_StaticVersion);
        assertTrue(result2 == result);
    }



}