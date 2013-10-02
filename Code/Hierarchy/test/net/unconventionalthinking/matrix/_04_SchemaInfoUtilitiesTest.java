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
import net.unconventionalthinking.lang.Integer_Mutable;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.hierarchy.SchemaSet_ScopeStack;
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
public class _04_SchemaInfoUtilitiesTest {

    // we don't need the real thing right now. just a tester object to do testing with.
    private static AppControl_Base appControl_MockObj;

    private static ExecutionInfo executeInfo = new ExecutionInfo();
    private static SymbolControl symbolControl;
    private static SchemaControl schemaControl;
    private static TestUtilities_1_Schema schemaAndMatrix_Utilities;

    private static MatrixName webForm_SchemaName;

    private static SchemaInfo_Schema webForm_Schema;
    private static SchemaInfo_Schema webForm_Schema2;
    private static SchemaInfo_Schema webForm_Schema3_NoIndexOnDescTags;
    private static SchemaInfo_Schema webForm_Schema4;
    private static SchemaInfo_Schema webForm_Schema5;



    private static DescriptorTagName formRequired_DescTagName;
    private static DescriptorTagName formSelect_DescTagName;
    private static DescriptorTagName option_DescTagName;
    private static DescriptorTagName formRequired2_DescTagName;
    private static DescriptorTagName formSelect2_DescTagName;
    private static DescriptorTagName option2_DescTagName;




    private static SchemaInfo_Descriptor formRequired_SchemaInfoDesc;
    private static SchemaInfo_Descriptor formSelect_SchemaInfoDesc;
    private static SchemaInfo_Descriptor option_SchemaInfoDesc;

    private static SchemaInfo_Descriptor formRequired2_SchemaInfoDesc;
    private static SchemaInfo_Descriptor formSelect2_SchemaInfoDesc;
    private static SchemaInfo_Descriptor option2_SchemaInfoDesc;




    public _04_SchemaInfoUtilitiesTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        appControl_MockObj = new AppControl_Simple();
        symbolControl = new SymbolControl();
        symbolControl.intialize_All_MPSymbols();

        appControl_MockObj.executionInfo = executeInfo;
        appControl_MockObj.symbolControl = symbolControl;
        schemaControl = new SchemaControl(executeInfo, appControl_MockObj);

        schemaAndMatrix_Utilities = new TestUtilities_1_Schema(executeInfo, schemaControl, symbolControl);

        schemaAndMatrix_Utilities.set_SchemaPackage(MPSymbols_DescTagName.net$__$unconventionalthinking$__$matrix$__$schema);
        

        //  Create test objects: ___________________________________________________________________________________
        webForm_Schema = schemaAndMatrix_Utilities.buildTestSchema("", 0);
        webForm_SchemaName = webForm_Schema.getSchemaInfo_SchemaNameFull();





        List<String> symbolStrings = new ArrayList<String>();
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("FORM");
        symbolStrings.add("REQUIRED");
        formRequired_DescTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, 1, false);

        symbolStrings = new ArrayList<String>();
        symbolStrings.add("FORM");
        symbolStrings.add("SELECT");
        formSelect_DescTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, 1, false);

        option_DescTagName = symbolControl.singleSymbol_Factory.createNew_DescTagName("OPTION", false);

        formRequired_SchemaInfoDesc = webForm_Schema.getChild_SchemaInfoDescriptor(executeInfo, formRequired_DescTagName);
        formSelect_SchemaInfoDesc = webForm_Schema.getChild_SchemaInfoDescriptor(executeInfo, formSelect_DescTagName);
        option_SchemaInfoDesc = formSelect_SchemaInfoDesc.getChild_SchemaInfoDescriptor(executeInfo, option_DescTagName);





        webForm_Schema2 = schemaAndMatrix_Utilities.buildTestSchema("2", 2);

        symbolStrings = new ArrayList<String>();
        symbolStrings.add("FORM");
        symbolStrings.add("REQUIRED2");
        formRequired2_DescTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, 1, false);

        symbolStrings = new ArrayList<String>();
        symbolStrings.add("FORM");
        symbolStrings.add("SELECT2");
        formSelect2_DescTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, 1, false);

        option2_DescTagName = symbolControl.singleSymbol_Factory.createNew_DescTagName("OPTION2", false);

        formRequired2_SchemaInfoDesc = webForm_Schema2.getChild_SchemaInfoDescriptor(executeInfo, formRequired2_DescTagName);
        formSelect2_SchemaInfoDesc = webForm_Schema2.getChild_SchemaInfoDescriptor(executeInfo, formSelect2_DescTagName);
        option2_SchemaInfoDesc = formSelect2_SchemaInfoDesc.getChild_SchemaInfoDescriptor(executeInfo, option2_DescTagName);




        // this will have standard descriptors tags with no index, like FORM.REQUIRED (not FORM.REQUIRED3)
        webForm_Schema3_NoIndexOnDescTags = schemaAndMatrix_Utilities.buildTestSchema("3", "", 3);
        webForm_Schema4 = schemaAndMatrix_Utilities.buildTestSchema("4", 4);
        webForm_Schema5 = schemaAndMatrix_Utilities.buildTestSchema("5", 5);

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
     * Test of find_SchemaInfoDescriptor_in_Stack method, of class SchemaInfoUtilities.
     */
    @Test
    public void testFind_SchemaInfoDescriptor_in_Stack() throws Exception {
        System.out.println("find_SchemaInfoDescriptor_in_Stack");


        assertEquals(MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$__$schema$_CC_$WEB$__$FORM, webForm_SchemaName);





        // test 1.1: should find match in parentDescriptor, but not in schema set__________
        MatrixSet<SchemaInfo_Schema> schemaSet1 = new MatrixSet<SchemaInfo_Schema>();
        schemaSet1.add(webForm_Schema2);
        schemaSet1.add(webForm_Schema3_NoIndexOnDescTags);
        SchemaSet_ScopeStack schemaSet_ScopeStack1 = new SchemaSet_ScopeStack(executeInfo, schemaControl);
        schemaSet_ScopeStack1.stack.add(schemaSet1);


        DescriptorTagName find_DescriptorTagName = formRequired_DescTagName;
        MatrixName find_DescTag_SchemaName = webForm_SchemaName;

        SchemaInfo_Descriptor parent_SchemaInfoDescriptor = webForm_Schema;

        SchemaInfo_Descriptor expResult = formRequired_SchemaInfoDesc;
        SchemaInfo_Descriptor result = SchemaInfoUtilities.find_SchemaInfoDescriptor_in_Stack(executeInfo, find_DescriptorTagName, find_DescTag_SchemaName,
                symbolControl, parent_SchemaInfoDescriptor, schemaSet_ScopeStack1, true);
        assertEquals(expResult, result);
        // check the findLocation Description results:
        assertTrue(executeInfo.containsResult(ExecutionInfo.ResultType.SchemaStackSearch_FoundInParent));
        Map<String, Object> infoParam = executeInfo.getInfoParameterHash();
        assertEquals(expResult, infoParam.get(SchemaInfoUtilities.Found_SchemaInfoDescriptor_Param));


        // test 1.2: again, find match in parentDescriptor, but try something a little deeper in schema, __________
        //        ... also, make schemaset more complex
        MatrixSet<SchemaInfo_Schema> schemaSet2 = new MatrixSet<SchemaInfo_Schema>();
        schemaSet2.add(webForm_Schema4);
        schemaSet2.add(webForm_Schema5);
        SchemaSet_ScopeStack schemaSet_ScopeStack2 = new SchemaSet_ScopeStack(executeInfo, schemaControl);
        schemaSet_ScopeStack1.stack.add(schemaSet1);
        schemaSet_ScopeStack1.stack.add(schemaSet2);


        find_DescriptorTagName = option_DescTagName;
        parent_SchemaInfoDescriptor = formSelect_SchemaInfoDesc;

        expResult = option_SchemaInfoDesc;
        result = SchemaInfoUtilities.find_SchemaInfoDescriptor_in_Stack(executeInfo, find_DescriptorTagName, find_DescTag_SchemaName,
                symbolControl, parent_SchemaInfoDescriptor, schemaSet_ScopeStack2);
        assertEquals(expResult, result);





        // test 2.1: should find match in schema set, but not in parent SchemaInfo__________
        find_DescriptorTagName = formRequired2_DescTagName;
        find_DescTag_SchemaName = webForm_Schema2.getSchemaInfo_SchemaNameFull();

        parent_SchemaInfoDescriptor = webForm_Schema;
        SchemaSet_ScopeStack schemaSet_ScopeStackToTest = schemaSet_ScopeStack1; // has webform2 and webform3 schemas
        expResult = formRequired2_SchemaInfoDesc;

        result = SchemaInfoUtilities.find_SchemaInfoDescriptor_in_Stack(executeInfo, find_DescriptorTagName, find_DescTag_SchemaName,
                symbolControl, parent_SchemaInfoDescriptor, schemaSet_ScopeStackToTest);
        assertEquals(expResult, result);



        //  test 2.2: more complex schemasets__________
        //  This Test is pretty important. Testing schemas with the SAME descriptors definitions, but with different schema names.
        //  The find should still find only the one we're looking for in the rith schema
        MatrixSet<SchemaInfo_Schema> schemaSet3 = new MatrixSet<SchemaInfo_Schema>();
        schemaSet3.add(webForm_Schema2);
        schemaSet3.add(webForm_Schema);
        
        // *** This has the same DescriptorTagNames, but should not be found here because schema name different!
        schemaSet3.add(webForm_Schema3_NoIndexOnDescTags);

        SchemaSet_ScopeStack schemaSet_ScopeStack3 = new SchemaSet_ScopeStack(executeInfo, schemaControl);
        schemaSet_ScopeStack3.stack.add(schemaSet2);
        schemaSet_ScopeStack3.stack.add(schemaSet3);

        find_DescriptorTagName = formSelect_DescTagName;
        find_DescTag_SchemaName = webForm_SchemaName;
        parent_SchemaInfoDescriptor = null;
        schemaSet_ScopeStackToTest = schemaSet_ScopeStack3;
        expResult = formSelect_SchemaInfoDesc;

        result = SchemaInfoUtilities.find_SchemaInfoDescriptor_in_Stack(executeInfo, find_DescriptorTagName, find_DescTag_SchemaName,
                symbolControl, parent_SchemaInfoDescriptor, schemaSet_ScopeStackToTest, true);
        assertEquals(expResult, result);

        // check the findLocation Description results:
        assertTrue(executeInfo.containsResult(ExecutionInfo.ResultType.SchemaStackSearch_FoundInStack));
        infoParam = executeInfo.getInfoParameterHash();
        assertEquals(expResult, infoParam.get(SchemaInfoUtilities.Found_SchemaInfoDescriptor_Param));
        assertEquals(webForm_Schema, infoParam.get(SchemaInfoUtilities.Found_in_Schema_Param));
        assertEquals(schemaSet3, infoParam.get(SchemaInfoUtilities.Found_SchemaSet_Param));




        // test 3.1: empty results__________

        find_DescriptorTagName = formSelect_DescTagName;
        find_DescTag_SchemaName = webForm_SchemaName;
        parent_SchemaInfoDescriptor = null;
        schemaSet_ScopeStackToTest = schemaSet_ScopeStack1;
        expResult = null;

        result = SchemaInfoUtilities.find_SchemaInfoDescriptor_in_Stack(executeInfo, find_DescriptorTagName, find_DescTag_SchemaName,
                symbolControl, parent_SchemaInfoDescriptor, schemaSet_ScopeStackToTest);
        assertEquals(expResult, result);
        assertTrue(executeInfo.hadEmptyResultSet());

        // test 3.2
        find_DescriptorTagName = formSelect_DescTagName;
        find_DescTag_SchemaName = webForm_SchemaName;
        schemaSet_ScopeStackToTest = null;
        expResult = null;

        result = SchemaInfoUtilities.find_SchemaInfoDescriptor_in_Stack(executeInfo, find_DescriptorTagName, find_DescTag_SchemaName,
                symbolControl, parent_SchemaInfoDescriptor, schemaSet_ScopeStackToTest);
        assertEquals(expResult, result);
        assertTrue(executeInfo.hadEmptyResultSet());


    }




    @Test
    public void find_SchemaInfoDescriptors_AtSameLevel_in_Stack_Test() throws Exception {


        // test 1.1: should find match in parentDescriptor, but not in schema set__________
        MatrixSet<SchemaInfo_Schema> schemaSet1 = new MatrixSet<SchemaInfo_Schema>();
        schemaSet1.add(webForm_Schema4);
        schemaSet1.add(webForm_Schema3_NoIndexOnDescTags);
        SchemaSet_ScopeStack schemaSet_ScopeStack1 = new SchemaSet_ScopeStack(executeInfo, schemaControl);
        schemaSet_ScopeStack1.stack.add(schemaSet1);


        DescriptorTagName find_DescriptorTagName = formRequired_DescTagName;
        MatrixName find_DescTag_SchemaName = webForm_SchemaName;

        SchemaInfo_Descriptor parent_SchemaInfoDescriptor = webForm_Schema;

        SchemaInfo_Descriptor expResult = formRequired_SchemaInfoDesc;
        MatrixSet<SchemaInfo_Descriptor> result = SchemaInfoUtilities.find_SchemaInfoDescriptors_AtSameLevel_in_Stack(executeInfo, find_DescriptorTagName,
                parent_SchemaInfoDescriptor, schemaSet_ScopeStack1, true);
        assertEquals(1, result.size());
        assertEquals(expResult, result.get(0));
        // check the findLocation Description results:
        assertTrue(executeInfo.containsResult(ExecutionInfo.ResultType.SchemaStackSearch_FoundInParent));
        Map<String, Object> infoParam = executeInfo.getInfoParameterHash();
        assertEquals(expResult, infoParam.get(SchemaInfoUtilities.Found_SchemaInfoDescriptor_Param));





        // test 2.1: should find match in schema set, but not in parent SchemaInfo__________
        find_DescriptorTagName = formRequired_DescTagName;

        parent_SchemaInfoDescriptor = webForm_Schema2;

        MatrixSet<SchemaInfo_Schema> schemaSet2 = new MatrixSet<SchemaInfo_Schema>();
        schemaSet2.add(webForm_Schema);
        schemaSet2.add(webForm_Schema2);
        schemaSet2.add(webForm_Schema3_NoIndexOnDescTags);
        MatrixSet<SchemaInfo_Schema> schemaSet3 = new MatrixSet<SchemaInfo_Schema>();
        schemaSet3.add(webForm_Schema);
        schemaSet3.add(webForm_Schema);
        schemaSet3.add(webForm_Schema);
        SchemaSet_ScopeStack schemaSet_ScopeStack2 = new SchemaSet_ScopeStack(executeInfo, schemaControl);
        schemaSet_ScopeStack2.stack.add(schemaSet2);
        schemaSet_ScopeStack2.stack.add(schemaSet3);

        expResult = formRequired2_SchemaInfoDesc;

        result = SchemaInfoUtilities.find_SchemaInfoDescriptors_AtSameLevel_in_Stack(executeInfo, find_DescriptorTagName,
                parent_SchemaInfoDescriptor, schemaSet_ScopeStack2, true);
        assertEquals(2, result.size());
        assertTrue(executeInfo.containsResult(ExecutionInfo.ResultType.SchemaStackSearch_FoundInStack));


        boolean found_SchemaInfoDesc = false;
        for (SchemaInfo_Descriptor schemaInfoDesc : result) {
            if (schemaInfoDesc.getSchemaInfo_DescriptorTagName() == find_DescriptorTagName &&
                schemaInfoDesc.getSchemaInfo_DescriptorTag().getSchemaName_Full() == webForm_Schema.getSchemaInfo_SchemaNameFull())
                found_SchemaInfoDesc = true;
        }
        assertTrue(found_SchemaInfoDesc);

        found_SchemaInfoDesc = false;
        for (SchemaInfo_Descriptor schemaInfoDesc : result) {
            if (schemaInfoDesc.getSchemaInfo_DescriptorTagName() == find_DescriptorTagName &&
                schemaInfoDesc.getSchemaInfo_DescriptorTag().getSchemaName_Full() == webForm_Schema3_NoIndexOnDescTags.getSchemaInfo_SchemaNameFull())
                found_SchemaInfoDesc = true;
        }
        assertTrue(found_SchemaInfoDesc);


        
        // test 3.1: empty results__________

        find_DescriptorTagName = formSelect2_DescTagName;
        find_DescTag_SchemaName = webForm_SchemaName;
        parent_SchemaInfoDescriptor = null;
        SchemaSet_ScopeStack schemaSet_ScopeStackToTest = schemaSet_ScopeStack1;
        expResult = null;

        result = SchemaInfoUtilities.find_SchemaInfoDescriptors_AtSameLevel_in_Stack(executeInfo, find_DescriptorTagName,
                parent_SchemaInfoDescriptor, schemaSet_ScopeStackToTest, true);
        assertEquals(expResult, result);
        assertTrue(executeInfo.hadEmptyResultSet());

    }




    @Test
    public void find_Schemas_AtSameLevelinStack_by_SchemaNameSimple_Test() throws Exception {




        // test 2.1: should find match in schema set, but not in parent SchemaInfo__________
        DescriptorTagName find_SchemaName_Simple = webForm_Schema.getSchemaInfo_SchemaNameFull().getMatrixName();

        //  Build Schema
        List<String> symbolStrings = new ArrayList<String>();

        symbolStrings = new ArrayList<String>();
        symbolStrings.add("WEB");
        symbolStrings.add("FORM");
        Label webForm_Label = symbolControl.multiPartSymbol_Factory.createNew_Label(symbolStrings, 1, true);
        SchemaInfo_Schema webForm_Schema_DifferentPackage = schemaControl.schemaFactory.createNew_Schema(executeInfo, webForm_Label,
                MPSymbols_DescTagName.net, true, null, null);



        MatrixSet<SchemaInfo_Schema> schemaSet1 = new MatrixSet<SchemaInfo_Schema>();
        // empty

        MatrixSet<SchemaInfo_Schema> schemaSet2 = new MatrixSet<SchemaInfo_Schema>();
        schemaSet2.add(webForm_Schema2);
        schemaSet2.add(webForm_Schema);
        schemaSet2.add(webForm_Schema); // included twice! but one returned one in the set of unique items!!!
        schemaSet2.add(webForm_Schema_DifferentPackage);
        schemaSet2.add(webForm_Schema3_NoIndexOnDescTags);
        MatrixSet<SchemaInfo_Schema> schemaSet3 = new MatrixSet<SchemaInfo_Schema>();
        schemaSet3.add(webForm_Schema);
        schemaSet3.add(webForm_Schema);
        schemaSet3.add(webForm_Schema2);
        schemaSet3.add(webForm_Schema);
        SchemaSet_ScopeStack schemaSet_ScopeStack2 = new SchemaSet_ScopeStack(executeInfo, schemaControl);
        schemaSet_ScopeStack2.stack.add(schemaSet1);
        schemaSet_ScopeStack2.stack.add(schemaSet2);
        schemaSet_ScopeStack2.stack.add(schemaSet3);


        Integer_Mutable depthLevel = new Integer_Mutable();

        Set<SchemaInfo_Schema> result = SchemaInfoUtilities.find_Schemas_AtSameLevelinStack_by_SchemaNameSimple(executeInfo, find_SchemaName_Simple,
                schemaSet_ScopeStack2, depthLevel);
        assertEquals(2, result.size());
        assertEquals(2, depthLevel.value);

        boolean found_Schema = false;
        for (SchemaInfo_Schema schema : result) {
            if (schema == webForm_Schema)
                found_Schema = true;
        }
        assertTrue(found_Schema);

        found_Schema = false;
        for (SchemaInfo_Schema schema : result) {
            if (schema == webForm_Schema_DifferentPackage)
                found_Schema = true;
        }
        assertTrue(found_Schema);


    }


}