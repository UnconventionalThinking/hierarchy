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



import net.unconventionalthinking.lang.Boolean_Mutable;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.FieldConstants;
import net.unconventionalthinking.matrix.SchemaControl;
import net.unconventionalthinking.matrix.SchemaInfo_Field;
import net.unconventionalthinking.matrix.SchemaInfo_FieldSet;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.matrix.symbols.Symbol_Single;
import net.unconventionalthinking.matrix.symbols.Symbol_Single_Factory;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import net.unconventionalthinking.matrix.FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_S_$DESCRIPTOR$_S_$FIELD$__$TYPES;
import net.unconventionalthinking.matrix.FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.SymbolType;
import net.unconventionalthinking.hierarchy.HierarchyMetaCompiler;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import java.util.ArrayList;





/**
 * These tests need to be in the net.unconventionalthinking.matrix package. Why? so they can get inside of the schemaInfo_FieldSet objects
 * and set their protected members.
 * 
 * Also, the generated FieldSet_Tuple classes (such as FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED) need to also be in this package,
 * for the same reason (to access protected members).
 *
 * @author peterjoh
 */
public class FieldSetTupleSpecialized_Test {

    private ExecutionInfo executeInfo = new ExecutionInfo();

    public SymbolControl symbolControl;
    public Symbol_Single_Factory symbolFactory;


	private SchemaInfo_Schema webForm_Schema;
	private SchemaInfo_FieldSet schemaInfoFieldSet_formRequired;
	String isRequiredSymbolString = "IsRequired";
    String notRequiredSymbolString = "NotRequired";
	Boolean_Mutable createdNew_Symbol = new Boolean_Mutable();
	Symbol_Single isRequired;
	Symbol_Single notRequired;

	String requiredImage_Path ="/images/required.gif";
	int requiredImage_Height = 11;
	int requiredImage_Width = 12;


    private SchemaInfo_FieldSet mock_schemaInfoFieldSet_fieldTypes;
    private SchemaInfo_FieldSet mock_schemaInfoFieldSet_descNum1;
    private Symbol intContinuationType;



    public FieldSetTupleSpecialized_Test() throws Exception {

    }

    public void init(SymbolControl symbolControl, SchemaInfo_Schema webForm_Schema) throws Exception {
    
    	System.out.println("FieldSetTupleSpecialized_Test: init()");
    
        this.symbolControl = symbolControl;
        this.symbolFactory = symbolControl.singleSymbol_Factory;
 
        this.webForm_Schema = webForm_Schema;

		//  Form.Required stuff:
        DescriptorTagName formRequired = (DescriptorTagName)symbolControl.descTagNames_Index.multiPart.get_MultiPartSymbol_ByName("`FORM`.`REQUIRED`");
        schemaInfoFieldSet_formRequired = webForm_Schema.getChild_SchemaInfoDescriptor(executeInfo, formRequired).get_SchemaInfoFieldSet(executeInfo);

		boolean has_StaticVersion = false;
		isRequired = symbolFactory.createNew(isRequiredSymbolString, has_StaticVersion, createdNew_Symbol);
		notRequired = symbolFactory.createNew(notRequiredSymbolString, has_StaticVersion, createdNew_Symbol);
        
        
        
        

        //  mock schemaInfo object for FIELD.TYPES
        mock_schemaInfoFieldSet_fieldTypes = new SchemaInfo_FieldSet(executeInfo, null);
        List<SchemaInfo_Field> fields_List = mock_schemaInfoFieldSet_fieldTypes.get_SchemaInfoFields();
        SchemaInfo_Field contField = new SchemaInfo_Field(executeInfo, 0, mock_schemaInfoFieldSet_fieldTypes, null, null, symbolControl, "DescTagName continuation", MPSymbols.boolean$_sym_$);
        contField.is_Continuation_Field = true;  // I don't know if this is enough. may need to pass in the type as a contiunation type in field constructor
        fields_List.add(contField);

        mock_schemaInfoFieldSet_fieldTypes.num_NonContinuationFields = 0;
        mock_schemaInfoFieldSet_fieldTypes.has_ContinuationField = true;


        //  Field Types init

        List<String> intCont_SymbolStrings = new ArrayList<String>();
        intCont_SymbolStrings.add(MPSymbols.ContinuationType.toString());
        intCont_SymbolStrings.add(MPSymbols.int$_sym_$.toString());
        intContinuationType = symbolControl.multiPartSymbol_Factory.createNew(intCont_SymbolStrings, 1, false);

        //  mock schemaInfo object for DESC.NUM1
        mock_schemaInfoFieldSet_descNum1 = new SchemaInfo_FieldSet(executeInfo, null);
        fields_List = mock_schemaInfoFieldSet_descNum1.get_SchemaInfoFields();
        SchemaInfo_Field field = new SchemaInfo_Field(executeInfo, 0, mock_schemaInfoFieldSet_descNum1, null, MPSymbols.String, symbolControl, "field1 string", "hi");
        field.is_Continuation_Field = true;
        fields_List.add(field);
        field = new SchemaInfo_Field(executeInfo, 1, mock_schemaInfoFieldSet_descNum1, null, MPSymbols.short$_sym_$, symbolControl, "field2 short");
        field.setDefaultValue_short((short)-1001);
        field.is_Continuation_Field = true;
        fields_List.add(field);
        field = new SchemaInfo_Field(executeInfo, 2, mock_schemaInfoFieldSet_descNum1, null, intContinuationType, symbolControl, "field3 continuation int");
        field.setDefaultValue_int(-1000);
        field.is_Continuation_Field = true;
        fields_List.add(field);

        mock_schemaInfoFieldSet_descNum1.num_NonContinuationFields = 2;
        mock_schemaInfoFieldSet_descNum1.has_ContinuationField = true;
        
        
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
     * Test of test_getAndSet_FieldName_Methods method, of class FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED.
     *
     * <Field Type> get_<Field Name>()
     * set_<Field Name>(<Field Type> value)
     */
    @Test
    public void test_getAndSetFieldName_Methods() throws Exception {
        System.out.println("test_getAndSet_FieldName_Methods");
        //  FieldSet test values


        FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED formRequired_FieldSet = new FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED(executeInfo, null);

        formRequired_FieldSet.schemaInfo_Positioned = schemaInfoFieldSet_formRequired;




        //  Test the Special Field-Value Get & Set methods______________________________________________________________



        FieldSet_TestUtilities.test_SetAndGetFieldName(executeInfo, formRequired_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED.class ,
                "set_IsRequired", Symbol.class, "set_IsRequired__Special", "get_IsRequired",
                notRequired, null, null, notRequired);  // last 4 params: expected value, null expected value, unused expected value, default expected value 


        FieldSet_TestUtilities.test_SetAndGetFieldName(executeInfo, formRequired_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED.class ,
                "set_RequiredImagePath", String.class, "set_RequiredImagePath__Special", "get_RequiredImagePath",
                "\test\required.gif", null, null, "/images/required.gif");  // last 4 params: expected value, null expected value, unused expected value, default expected value 

        FieldSet_TestUtilities.test_SetAndGetFieldName(executeInfo, formRequired_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED.class ,
                "set_ImageHeight", Integer.TYPE, "set_ImageHeight__Special", "get_ImageHeight",
                11, -1, -1, 6);  // last 4 params: expected value, null expected value, unused expected value, default expected value 

        FieldSet_TestUtilities.test_SetAndGetFieldName(executeInfo, formRequired_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED.class ,
                "set_ImageWidth", Integer.TYPE, "set_ImageWidth__Special", "get_ImageWidth",
                12, -1, -1, 7);  // last 4 params: expected value, null expected value, unused expected value, default expected value 



    }





    /**
     *  Test 2: FieldSet with object type continuation:
     *
     *    <some object type> get_<Field Name>(continuationIndex)
     *    set_<Field Name>(continuationIndex, <some object type> value)
     * 
     *  using schemaInfo_Fieldsets from schema for schema, the FIELD.TYPES schemaInfo Descriptor's fieldSet:
     *          DESCRIPTOR FIELD.TYPES:
     *              FIELD.TYPES:    {Symbol...}
     */
    @Test
    public void test_getAndSetFieldName_ObjectContinuation() throws Exception {

        FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_S_$DESCRIPTOR$_S_$FIELD$__$TYPES fieldTypes_FieldSet = new FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_S_$DESCRIPTOR$_S_$FIELD$__$TYPES(
            executeInfo, null);



        fieldTypes_FieldSet.schemaInfo_Positioned = mock_schemaInfoFieldSet_fieldTypes;

        //  Test the Get & Set methods _________________________________________________________________________________



        FieldSet_TestUtilities.test_SetAndGet_useIndex(executeInfo, fieldTypes_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_S_$DESCRIPTOR$_S_$FIELD$__$TYPES.class,
                "set_TYPES", Symbol.class, "set_TYPES__Special", "get_TYPES", 0,
                MPSymbols.char$_sym_$, null, null, MPSymbols.boolean$_sym_$);  /* last 4 params: expected value, null expected value, unused expected value, default expected value */

        FieldSet_TestUtilities.test_SetAndGet_useIndex(executeInfo, fieldTypes_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_S_$DESCRIPTOR$_S_$FIELD$__$TYPES.class,
                "set_TYPES", Symbol.class, "set_TYPES__Special", "get_TYPES", 1,
                MPSymbols.int$_sym_$, null, null, MPSymbols.boolean$_sym_$);  /* last 4 params: expected value, null expected value, unused expected value, default expected value */

        FieldSet_TestUtilities.test_SetAndGet_useIndex(executeInfo, fieldTypes_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_S_$DESCRIPTOR$_S_$FIELD$__$TYPES.class,
                "set_TYPES", Symbol.class, "set_TYPES__Special", "get_TYPES", 2,
                MPSymbols.byte$_sym_$, null, null, MPSymbols.boolean$_sym_$);  /* last 4 params: expected value, null expected value, unused expected value, default expected value */

    }





    /**
     *  Test 3: FieldSet with primitive type continuation:
     *
     *    <primtiive Type> get_<Field Name>(continuationIndex)
     *    set_<Field Name>(continuationIndex, <primitive Type> value)
     *
     *     from testSchema2
     *          DESCRIPTOR DESC.NUM:
     *              FIELD.NAMES:    {`field1Str`, `field2Short`, `field3ContInt`}
     *              FIELD.TYPES:    {String, short, int...}
     */
    @Test
    public void test_getAndSetFieldName_PrimitiveTypeContinuation() throws Exception {

        FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1 descNum1_FieldSet = new FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1(
            executeInfo, null);

        descNum1_FieldSet.schemaInfo_Positioned = mock_schemaInfoFieldSet_descNum1;


        FieldSet_TestUtilities.test_SetAndGet_useIndex(executeInfo, descNum1_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1.class,
                "set_field3ContInt", Integer.TYPE, "set_field3ContInt__Special", "get_field3ContInt", 0,
                10, -1, -1, -1000);  /* last 4 params: expected value, null expected value, unused expected value, default expected value */

        FieldSet_TestUtilities.test_SetAndGet_useIndex(executeInfo, descNum1_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1.class,
                "set_field3ContInt", Integer.TYPE, "set_field3ContInt__Special", "get_field3ContInt", 1,
                11, -1, -1, -1000);  /* last 4 params: expected value, null expected value, unused expected value, default expected value */

        FieldSet_TestUtilities.test_SetAndGet_useIndex(executeInfo, descNum1_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1.class,
                "set_field3ContInt", Integer.TYPE, "set_field3ContInt__Special", "get_field3ContInt", 2,
                12, -1, -1, -1000);  /* last 4 params: expected value, null expected value, unused expected value, default expected value */

    }




    /**
     * Object getField(int index)
     * setField(int index, Object value)
     * setField__Special(int index, specialValue)
     */
    @Test
    public void test_getAndSet_ByIndex_GenericMethods() throws Exception {

        FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1 descNum1_FieldSet = new FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1(
            executeInfo, null);



        descNum1_FieldSet.schemaInfo_Positioned = mock_schemaInfoFieldSet_descNum1;


        //  Test the Get & Set methods & the Special Field-Value Get & Set methods - Object Type (string)  _______________________________________
        FieldSet_TestUtilities.test_SetAndGet_useIndex(executeInfo, descNum1_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1.class,
                "setField", Object.class, "setField__Special", "getField", 0,
                "hello", null, null, "hi");  /* last 4 params: expected value, null expected value, unused expected value, default expected value */


        FieldSet_TestUtilities.test_SetAndGet_useIndex(executeInfo, descNum1_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1.class,
                "setField", Object.class, "setField__Special", "getField", 1,
                (short)10, null, null, (short)-1001);  /* last 4 params: expected value, null expected value, unused expected value, default expected value */


        //  Continuation Field
        FieldSet_TestUtilities.test_SetAndGet_useIndex(executeInfo, descNum1_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1.class,
                "setField", Object.class, "setField__Special", "getField", 2,
                11, null, null, -1000);  /* last 4 params: expected value, null expected value, unused expected value, default expected value */
        FieldSet_TestUtilities.test_SetAndGet_useIndex(executeInfo, descNum1_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1.class,
                "setField", Object.class, "setField__Special", "getField", 3,
                12, null, null, -1000);  /* last 4 params: expected value, null expected value, unused expected value, default expected value */


        //  Object Continuation ________________________________________________________________________________________
        FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_S_$DESCRIPTOR$_S_$FIELD$__$TYPES fieldTypes_FieldSet = new FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_S_$DESCRIPTOR$_S_$FIELD$__$TYPES(
            executeInfo, null);

        fieldTypes_FieldSet.schemaInfo_Positioned = mock_schemaInfoFieldSet_fieldTypes;

        FieldSet_TestUtilities.test_SetAndGet_useIndex(executeInfo, fieldTypes_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_S_$DESCRIPTOR$_S_$FIELD$__$TYPES.class,
                "setField", Object.class, "setField__Special", "getField", 0,
                MPSymbols.char$_sym_$, null, null, MPSymbols.boolean$_sym_$);  /* last 4 params: expected value, null expected value, unused expected value, default expected value */

        FieldSet_TestUtilities.test_SetAndGet_useIndex(executeInfo, fieldTypes_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_S_$DESCRIPTOR$_S_$FIELD$__$TYPES.class,
                "setField", Object.class, "setField__Special", "getField", 1,
                MPSymbols.int$_sym_$, null, null, MPSymbols.boolean$_sym_$);  /* last 4 params: expected value, null expected value, unused expected value, default expected value */

    }



    /**
     * Object getField_String(int index)
     * <Field Type> setField_<FieldType>(int index, Object value)
     * setField__Special(int index, specialValue)
     */
    @Test
    public void test_getAndSet_ByIndex_TypedMethods() throws Exception {

        FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1 descNum1_FieldSet = new FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1(
            executeInfo, null);



        descNum1_FieldSet.schemaInfo_Positioned = mock_schemaInfoFieldSet_descNum1;

        //  Test the Get & Set methods _________________________________________________________________________________


        FieldSet_TestUtilities.test_SetAndGet_useIndex(executeInfo, descNum1_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1.class,
                "setField_String", String.class, "setField__Special", "getField_String", 0,
                "stuff", null, null, "hi");  /* last 4 params: expected value, null expected value, unused expected value, default expected value */

        FieldSet_TestUtilities.test_SetAndGet_useIndex(executeInfo, descNum1_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1.class,
                "setField_short", Short.TYPE, "setField__Special", "getField_short", 1,
                (short)123, (short)-1, (short)-1, (short)-1001);  /* last 4 params: expected value, getField_short expected value, unused expected value, default expected value */

        //  continuation primiative field
        FieldSet_TestUtilities.test_SetAndGet_useIndex(executeInfo, descNum1_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1.class,
                "setField_int", Integer.TYPE, "setField__Special", "getField_int", 2,
                456, -1, -1, -1000);  /* last 4 params: expected value, getField_short expected value, unused expected value, default expected value */

        FieldSet_TestUtilities.test_SetAndGet_useIndex(executeInfo, descNum1_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1.class,
                "setField_int", Integer.TYPE, "setField__Special", "getField_int", 3,
                789, -1, -1, -1000);  /* last 4 params: expected value, getField_short expected value, unused expected value, default expected value */






        //  Object Continuation
        FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_S_$DESCRIPTOR$_S_$FIELD$__$TYPES fieldTypes_FieldSet = new FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_S_$DESCRIPTOR$_S_$FIELD$__$TYPES(
            executeInfo, null);

        fieldTypes_FieldSet.schemaInfo_Positioned = mock_schemaInfoFieldSet_fieldTypes;


        //  Test the Get & Set methods _________________________________________________________________________________
        FieldSet_TestUtilities.test_SetAndGet_useIndex(executeInfo, fieldTypes_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_S_$DESCRIPTOR$_S_$FIELD$__$TYPES.class,
                "setField_Symbol", Symbol.class, "setField__Special", "getField_Symbol", 0,
                MPSymbols.char$_sym_$, null, null, MPSymbols.boolean$_sym_$);  /* last 4 params: expected value, getField_short expected value, unused expected value, default expected value */

        FieldSet_TestUtilities.test_SetAndGet_useIndex(executeInfo, fieldTypes_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_S_$DESCRIPTOR$_S_$FIELD$__$TYPES.class,
                "setField_Symbol", Symbol.class, "setField__Special", "getField_Symbol", 1,
                MPSymbols.byte$_sym_$, null, null, MPSymbols.boolean$_sym_$);  /* last 4 params: expected value, getField_short expected value, unused expected value, default expected value */



    }




    /**
     * Object getField(fieldName)
     * setField(fieldName, Object value)
     * setField__Special(fieldNmae, specialValue)
     */
    @Test
    public void test_getAndSet_ByFieldName_GenericMethods() throws Exception {

        FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1 descNum1_FieldSet = new FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1(
            executeInfo, null);



        descNum1_FieldSet.schemaInfo_Positioned = mock_schemaInfoFieldSet_descNum1;


        //  Test primitive types _______________________________________

        FieldSet_TestUtilities.test_SetAndGet_useFieldName(executeInfo, descNum1_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1.class,
                "setField", Object.class, "setField__Special", "getField", "field1Str", symbolControl,
                "hello", null, null, "hi");  // last 4 params: expected value, null expected value, unused expected value, default expected value 


        FieldSet_TestUtilities.test_SetAndGet_useFieldName(executeInfo, descNum1_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1.class,
                "setField", Object.class, "setField__Special", "getField", "field2Short", symbolControl,
                (short)10, null, null, (short)-1001);  // last 4 params: expected value, null expected value, unused expected value, default expected value 


        //  Continuation Field - can not call the generic setField(fieldName) and getField(fieldName) on a cont field.
        //  this should throw an exception (which is returned by the test method.
        Exception exception = FieldSet_TestUtilities.test_SetAndGet_useFieldName(executeInfo, descNum1_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1.class,
                "setField", Object.class, "setField__Special", "getField", "field3ContInt", symbolControl,
                11, null, null, -1000, true);  // last 5 params: expected value, null expected value, unused expected value, default expected value, returnExceptions 
        
        assertTrue(exception != null);
        


        //  Test Object Types ________________________________________________________________________________________
        FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED formRequired_FieldSet = new FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED(executeInfo, null);

        formRequired_FieldSet.schemaInfo_Positioned = schemaInfoFieldSet_formRequired;


        FieldSet_TestUtilities.test_SetAndGet_useFieldName(executeInfo, formRequired_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED.class,
                "setField", Object.class, "setField__Special", "getField", "IsRequired", symbolControl,
                notRequired, null, null, notRequired);  // last 4 params: expected value, null expected value, unused expected value, default expected value 

        FieldSet_TestUtilities.test_SetAndGet_useFieldName(executeInfo, formRequired_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED.class,
                "setField", Object.class, "setField__Special", "getField", "RequiredImagePath", symbolControl,
                "\test\required.gif", null, null, "/images/required.gif");  // last 4 params: expected value, null expected value, unused expected value, default expected value 

    }




    /**
     * Object getField_String(fieldName)
     * <Field Type> setField_<FieldType>(fieldName, Object value)
     * setField__Special(fieldName, specialValue)
     */
    @Test
    public void test_getAndSet_ByFieldName_TypedMethods() throws Exception {

        FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1 descNum1_FieldSet = new FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1(
            executeInfo, null);



        descNum1_FieldSet.schemaInfo_Positioned = mock_schemaInfoFieldSet_descNum1;

        //  Test the Get & Set methods: primitive types ______________________________________________________________


        FieldSet_TestUtilities.test_SetAndGet_useFieldName(executeInfo, descNum1_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1.class,
                "setField_String", String.class, "setField__Special", "getField_String", "field1Str", symbolControl,
                "stuff", null, null, "hi");  /* last 4 params: expected value, null expected value, unused expected value, default expected value */

        FieldSet_TestUtilities.test_SetAndGet_useFieldName(executeInfo, descNum1_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1.class,
                "setField_short", Short.TYPE, "setField__Special", "getField_short", "field2Short", symbolControl,
                (short)123, (short)-1, (short)-1, (short)-1001);  /* last 4 params: expected value, getField_short expected value, unused expected value, default expected value */

        //  Continuation Field - can not call the generic setField(fieldName) and getField(fieldName) on a cont field.
        //  this should throw an exception (which is returned by the test method).
        Exception exception = FieldSet_TestUtilities.test_SetAndGet_useFieldName(executeInfo, descNum1_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1.class,
                "setField_int", Integer.TYPE, "setField__Special", "getField_int", "field3ContInt", symbolControl,
                456, -1, -1, -1000, true);  // last 5 params: expected value, null expected value, unused expected value, default expected value, returnExceptions

        assertTrue(exception != null);


        //  Test Object Types ________________________________________________________________________________________
        FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED formRequired_FieldSet = new FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED(executeInfo, null);

        formRequired_FieldSet.schemaInfo_Positioned = schemaInfoFieldSet_formRequired;


        FieldSet_TestUtilities.test_SetAndGet_useFieldName(executeInfo, formRequired_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED.class,
                "setField_Symbol", Symbol.class, "setField__Special", "getField_Symbol", "IsRequired", symbolControl,
                notRequired, null, null, notRequired);  // last 4 params: expected value, null expected value, unused expected value, default expected value 

        FieldSet_TestUtilities.test_SetAndGet_useFieldName(executeInfo, formRequired_FieldSet, FieldSetTuple__net$__$unconventionalthinking$__$matrix$__$schema$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED.class,
                "setField_String", String.class, "setField__Special", "getField_String", "RequiredImagePath", symbolControl,
                "\test\required.gif", null, null, "/images/required.gif");  // last 4 params: expected value, null expected value, unused expected value, default expected value 


    }




}