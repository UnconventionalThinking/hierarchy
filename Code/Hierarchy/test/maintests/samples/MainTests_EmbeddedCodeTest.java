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

/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package maintests . samples ;

import net.unconventionalthinking.matrix.*;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.symbols.*;
import java . util . * ;
import java . util . concurrent . ConcurrentMap ;
import java . util . concurrent . ConcurrentHashMap ;
import org . junit . After ;
import org . junit . AfterClass ;
import org . junit . Before ;
import org . junit . BeforeClass ;
import org . junit . Test ;
import static org . junit . Assert . * ;
public  class MainTests_EmbeddedCodeTest implements MainTests_EmbeddedCodeTest__Annotations {


	private final static AppControl_Base appControl = maintests.samples.AppControl.initializeApp();
	private final static ExecutionInfo executeInfo = appControl.executionInfo;


	static String requiredImagePath_Expected ;
	static Symbol isRequired_Expected ;
	static Symbol NotRequired_Expected ;
	static Symbol testSym1_Expected ;
	static int testField2_Expected ;
	private  net.unconventionalthinking.matrix.Descriptor testDescField_Item ;
	boolean enteredFilter = false ;
	@ BeforeClass public static void setUpClass ( ) throws Exception {
		requiredImagePath_Expected  = TestConstants.RequiredImagePath;
		isRequired_Expected  = AppSymbols.IsRequired ;
		NotRequired_Expected  = AppSymbols.NotRequired ;
		testSym1_Expected  = AppSymbols.testSym1 ;
		testField2_Expected  = 6 ;
		
	}
	@ AfterClass public static void tearDownClass ( ) throws Exception {
		
	}
	@ Before public void setUp ( ) {
		
	}
	@ After public void tearDown ( ) {
		
	}
	@ Test public void testAccess ( ) throws Exception {
		String resultString = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__128(executeInfo, this);
		assertEquals ( requiredImagePath_Expected , resultString ) ;
		FieldSet formRequired_FieldSet = ( MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__129(executeInfo, this)) . get_FieldSet ( ) ;
		assertEquals ( true , formRequired_FieldSet . is_SpecializedFieldSet ( ) ) ;
		Symbol resultSymbol = ( ( FieldSetTuple__maintests$__$samples$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED ) formRequired_FieldSet ) . get_IsRequired ( executeInfo ) ;
		assertEquals ( isRequired_Expected , resultSymbol ) ;
		resultString  = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__130(executeInfo, this);
		assertEquals ( requiredImagePath_Expected , resultString ) ;
		resultString  = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__131(executeInfo, this);
		assertEquals ( requiredImagePath_Expected , resultString ) ;
		Label firstName_Label = AppSymbols_Label.First$32$Name ;
		resultSymbol  = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__132(executeInfo, this, firstName_Label);
		assertEquals ( isRequired_Expected , resultSymbol ) ;
		Label twoPartLabel = AppSymbols_Label.Two$__$Part$32$Label ;
		resultSymbol  = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__133(executeInfo, this, twoPartLabel);
		assertEquals ( isRequired_Expected , resultSymbol ) ;
		Label testLabel = AppSymbols_Label.Test$__$Label ;
		resultSymbol  = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__134(executeInfo, this, testLabel);
		assertEquals ( isRequired_Expected , resultSymbol ) ;
		net.unconventionalthinking.matrix.Descriptor testDescVar = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__135(executeInfo, this);
		resultSymbol  = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix___136(executeInfo, testDescVar, this, testLabel);
		assertEquals ( isRequired_Expected , resultSymbol ) ;
		Date currDate = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix2__137(executeInfo, this);
		Object out = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix2__138(executeInfo, this);
		assertNotNull ( currDate ) ;
		assertNotNull ( out ) ;
		Object resultObj = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__139(executeInfo, maintests.samples.Test$__$Matrix.matrix, this, AppSymbols_Label.First$32$Name, AppSymbols_DescTag.maintests$__$samples$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED, AppSymbols_DescTagName.IsRequired);
		assertEquals ( isRequired_Expected , resultObj ) ;
		resultObj  = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__140(executeInfo, maintests.samples.Test$__$Matrix.matrix, this, AppSymbols_Label.First$32$Name, AppSymbols_DescTagName.FORM$__$REQUIRED, AppSymbols_DescTagName.RequiredImagePath);
		assertEquals ( requiredImagePath_Expected , resultObj ) ;
		resultObj  = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__141(executeInfo, maintests.samples.Test$__$Matrix.matrix, this, firstName_Label, AppSymbols_DescTagName.FORM$__$REQUIRED, AppSymbols_DescTagName.IsRequired);
		assertEquals ( isRequired_Expected , resultObj ) ;
		DescriptorTagName testDesc_DescTagName = AppSymbols_DescTagName . TEST$__$DESC ;
		resultObj  = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix2__142(executeInfo, maintests.samples.Test$__$Matrix2.matrix, this, AppSymbols_Label.test$32$item, testDesc_DescTagName, AppSymbols_DescTagName.testField1);
		assertEquals ( testSym1_Expected , resultObj ) ;
		DescriptorTag testDesc_DescTag = AppSymbols_DescTag . maintests$__$samples$_CC_$Test$__$Schema$_CC_$TEST$__$DESC ;
		resultObj  = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix2__143(executeInfo, maintests.samples.Test$__$Matrix2.matrix, this, AppSymbols_Label.test$32$item, testDesc_DescTag, AppSymbols_DescTagName.testField1);
		assertEquals ( testSym1_Expected , resultObj ) ;
		int testField2 = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix2__144(executeInfo, this);
		assertEquals ( testField2_Expected , testField2 ) ;
		Object annoteAccessTest_1 = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__145(executeInfo, maintests.samples.Test$__$Matrix.matrix, this, AppSymbols_DescTagName.Junk, AppSymbols_DescTag.maintests$__$samples$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED, AppSymbols_DescTagName.IsRequired);
		assertEquals ( AppSymbols.$49$_1 , annoteAccessTest_1 ) ;
		Object annoteAccessTest_2 = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__146(executeInfo, this, AppSymbols_DescTagName.Junk, AppSymbols_DescTagName.IsRequired);
		assertEquals ( AppSymbols.$49$_1 , annoteAccessTest_2 ) ;
		Object annoteAccessTest_3 = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix___147(executeInfo, ( ( Matrix ) null ) , this, AppSymbols_Label.First$32$Name, AppSymbols_DescTagName.FORM$__$REQUIRED, AppSymbols_DescTagName.IsRequired);
		assertEquals ( isRequired_Expected , annoteAccessTest_3 ) ;
		Object annoteAccessTest_4 = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__148(executeInfo, maintests.samples.Test$__$Matrix.matrix, this, AppSymbols_Label.First$32$Name, AppSymbols_DescTagName.Junk, AppSymbols_DescTagName.RequiredImagePath);
		assertEquals ( "\\annotatedPath" , annoteAccessTest_4 ) ;
		Object annoteAccessTest_5 = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__149(executeInfo, maintests.samples.Test$__$Matrix.matrix, this, AppSymbols_Label.First$32$Name, AppSymbols_DescTagName.Junk, AppSymbols_DescTagName.RequiredImagePath);
		assertEquals ( "stuff" , annoteAccessTest_5 ) ;
		MatrixSet < Object > IsRequired_Set = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__150(executeInfo, this, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM, AppSymbols_DescTagName.FORM$__$REQUIRED, AppSymbols_DescTagName.IsRequired);
		assertEquals ( 3 , IsRequired_Set . size ( ) ) ;
		assertEquals ( isRequired_Expected , IsRequired_Set . get ( 0 ) ) ;
		assertEquals ( NotRequired_Expected , IsRequired_Set . get ( 1 ) ) ;
		IsRequired_Set  = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__151(executeInfo, this, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM, AppSymbols_DescTag.maintests$__$samples$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED, AppSymbols_DescTagName.IsRequired);
		assertEquals ( 3 , IsRequired_Set . size ( ) ) ;
		assertEquals ( isRequired_Expected , IsRequired_Set . get ( 0 ) ) ;
		assertEquals ( NotRequired_Expected , IsRequired_Set . get ( 1 ) ) ;
		MatrixSet < Descriptor > options_Set = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__152(executeInfo, this, AppSymbols_DescTagName.OPTION);
		assertEquals ( 3 , options_Set . size ( ) ) ;
		assertEquals ( AppSymbols_DescTagName.OPTION , options_Set . get ( 0 ) . descTagName ) ;
		assertEquals ( AppSymbols_DescTagName.OPTION , options_Set . get ( 1 ) . descTagName ) ;
		assertEquals ( AppSymbols_DescTagName.OPTION , options_Set . get ( 2 ) . descTagName ) ;
		MatrixSet < Descriptor > item_Set = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__153(executeInfo, this, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM);
		assertEquals ( 3 , item_Set . size ( ) ) ;
		enteredFilter  = false ;
		MatrixSet < Descriptor > item_Set2 = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__154(executeInfo, this, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM);
		assertEquals ( 1 , item_Set2 . size ( ) ) ;
		assertTrue ( enteredFilter ) ;
		enteredFilter  = false ;
		IsRequired_Set  = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__155(executeInfo, this, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM, AppSymbols_DescTagName.FORM$__$REQUIRED, AppSymbols_DescTagName.IsRequired);
		assertEquals ( 1 , IsRequired_Set . size ( ) ) ;
		assertEquals ( isRequired_Expected , IsRequired_Set . get ( 0 ) ) ;
		assertTrue ( enteredFilter ) ;
		enteredFilter  = false ;
		IsRequired_Set  = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__156(executeInfo, this, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM, AppSymbols_DescTagName.FORM$__$REQUIRED, AppSymbols_DescTagName.IsRequired);
		assertEquals ( 1 , IsRequired_Set . size ( ) ) ;
		assertEquals ( NotRequired_Expected , IsRequired_Set . get ( 0 ) ) ;
		assertTrue ( enteredFilter ) ;
		net.unconventionalthinking.matrix.Descriptor testDescVar_FormRequired = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__157(executeInfo, this);
		resultSymbol  = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix___158(executeInfo, testDescVar_FormRequired, this);
		assertEquals ( AppSymbols . IsRequired , resultSymbol ) ;
		resultObj  = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix___159(executeInfo, testDescVar_FormRequired, this, AppSymbols_DescTagName.IsRequired);
		assertEquals ( AppSymbols . IsRequired , resultObj ) ;
		descVar_methodParamTest ( MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__160(executeInfo, this)) ;
		testDescField_Item  = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__161(executeInfo, this);
		resultString  = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix___162(executeInfo, testDescField_Item, this);
		assertEquals ( "more required stuff" , resultString ) ;
		net.unconventionalthinking.matrix.Descriptor testDesc = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix2__163(executeInfo, this);
		Symbol testField1 = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix___164(executeInfo, testDesc, this);
		assertEquals ( AppSymbols.testSymA , testField1 ) ;
		testField1  = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix___165(executeInfo, testDesc, this);
		assertEquals ( AppSymbols.testSymC , testField1 ) ;
		resultObj  = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix___166(executeInfo, testDescField_Item, this, AppSymbols_DescTagName.FORM$__$REQUIRED, AppSymbols_DescTagName.RequiredImagePath);
		assertEquals ( "more required stuff" , resultObj ) ;
		DescriptorTagName formRequired_DescTagName = AppSymbols_DescTagName.FORM$__$REQUIRED ;
		assertNotNull ( formRequired_DescTagName ) ;
		assertEquals ( AppSymbols_DescTagName . FORM$__$REQUIRED , formRequired_DescTagName ) ;
		int count = 0 ;
		for ( net.unconventionalthinking.matrix.Descriptor formReq_Desc : MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__167(executeInfo, this, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM, AppSymbols_DescTagName.FORM$__$REQUIRED)) {
			assertNotNull ( formReq_Desc ) ;
			formRequired_FieldSet  = formReq_Desc . get_FieldSet ( ) ;
			assertEquals ( true , formRequired_FieldSet . is_SpecializedFieldSet ( ) ) ;
			resultString  = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix___168(executeInfo, formReq_Desc, this);
			assertEquals ( requiredImagePath_Expected , resultString ) ;
			count ++ ;
			
		}
		assertEquals ( 3 , count ) ;
		count  = 0 ;
		MatrixSet < Descriptor > forReq_Set = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__169(executeInfo, this, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM, AppSymbols_DescTagName.FORM$__$REQUIRED);
		for ( net.unconventionalthinking.matrix.Descriptor formReq_Desc : forReq_Set ) {
			assertNotNull ( formReq_Desc ) ;
			formRequired_FieldSet  = formReq_Desc . get_FieldSet ( ) ;
			assertEquals ( true , formRequired_FieldSet . is_SpecializedFieldSet ( ) ) ;
			resultString  = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix___170(executeInfo, formReq_Desc, this);
			assertEquals ( requiredImagePath_Expected , resultString ) ;
			count ++ ;
			
		}
		assertEquals ( 3 , count ) ;
		net.unconventionalthinking.matrix.Descriptor testImportingTypes_desc = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix2__171(executeInfo, this);
		assertEquals ( java . util . concurrent . ConcurrentHashMap . class , ( MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix___172(executeInfo, testImportingTypes_desc, this)) . getClass ( ) ) ;
		assertEquals ( java . util . concurrent . ConcurrentHashMap . class , ( MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix___173(executeInfo, testImportingTypes_desc, this)) . getClass ( ) ) ;
		assertEquals ( java . util . concurrent . ConcurrentHashMap . class , ( MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix___174(executeInfo, testImportingTypes_desc, this)) . getClass ( ) ) ;
		assertEquals ( java . util . concurrent . ConcurrentHashMap . class , ( MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix___175(executeInfo, testImportingTypes_desc, this)) . getClass ( ) ) ;
		
	}
	private void descVar_methodParamTest ( net.unconventionalthinking.matrix.Descriptor testDescVar_Item ) throws Exception {
		String resultString = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix___177(executeInfo, testDescVar_Item, this);
		assertEquals ( "required stuff" , resultString ) ;
		Object resultObj = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix___178(executeInfo, testDescVar_Item, this, AppSymbols_DescTagName.FORM$__$REQUIRED, AppSymbols_DescTagName.RequiredImagePath);
		assertEquals ( "required stuff" , resultObj ) ;
		
	}
	
	public  Object annotationHandler_4(ExecutionInfo executeInfo, 
		boolean annotationReference_Exists, Symbol annotationRef_Base, int annotationRef_AccessCounter,
		int childAccessIndex, AnnotationParameters.AccessType accessType, AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam, 
		Descriptor rootAccessDescriptor, Descriptor currAccessors_ParentDescriptor, MatrixSet<Descriptor> currAccessors_ParentDescriptorSet, 
		boolean passingInException, Exception e, Pair<Object, Object>... childAccessor_Pairs) {

		if (annotationRef_Base == AppSymbols.$42$1) {
			if (annotationRef_AccessCounter >= 0 && annotationRef_AccessCounter < 1) {
				accessReturnType_OutParam.returnType = AnnotationParameters.AccessReturnType.accessorValue;  return ( MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__176(executeInfo, maintests.samples.Test$__$Matrix.matrix, this, AppSymbols_Label.First$32$Name)) ;
			} else { 
				return AppSymbols.$49$_1 ;

			}		} else if (annotationRef_Base == AppSymbols.$42$two) {
			return "\\annotatedPath" ;

		} else if (annotationRef_Base == AppSymbols.$42$3) {
			return "\\anotherAnnotatedPath" ;

		} else if (annotationRef_Base == AppSymbols.$42$annotationTest$95$IntNull) {
			return null ;

		}
		//  Default:
		return "stuff" ;


	}

	public  Object annotationHandler_5(ExecutionInfo executeInfo, 
		boolean annotationReference_Exists, Symbol annotationRef_Base, int annotationRef_AccessCounter,
		int childAccessIndex, AnnotationParameters.AccessType accessType, AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam, 
		Descriptor rootAccessDescriptor, Descriptor currAccessors_ParentDescriptor, MatrixSet<Descriptor> currAccessors_ParentDescriptorSet, 
		boolean passingInException, Exception e, Pair<Object, Object>... childAccessor_Pairs) {

		
		//  Default:
				return "stuff" ;


	}




	public  MatrixSet<?> filter_AnnotationHandler_4(ExecutionInfo executeInfo, 
		Symbol annotationRef, int childAccessIndex, AnnotationParameters.AccessType accessType, 
		Descriptor rootAccessDescriptor, Descriptor currAccessors_ParentDescriptor, 
		MatrixSet<Descriptor> parent_DescriptorSet, MatrixSet<?> curr_ValueSet_Full, 
		Pair<Object, Object>... childAccessor_Pairs) {

		if (annotationRef == AppSymbols.$42$F1) {
			MatrixSet < Descriptor > itemSet_Full = ( MatrixSet < Descriptor > ) curr_ValueSet_Full ;

			MatrixSet < Descriptor > itemSet_Filtered = new MatrixSet < Descriptor > ( ) ;

			itemSet_Filtered . add ( itemSet_Full . get ( 0 ) ) ;

			enteredFilter  = true ;

			return itemSet_Filtered ;

		}
 else if (annotationRef == AppSymbols.$42$F2) {
			MatrixSet < Object > valueSet_Full = ( MatrixSet < Object > ) curr_ValueSet_Full ;

			MatrixSet < Object > valueSet_Filtered = new MatrixSet < Object > ( ) ;

			valueSet_Filtered . add ( valueSet_Full . get ( 1 ) ) ;

			enteredFilter  = true ;

			return valueSet_Filtered ;

		}
		 else {
			return null;
		}


	}


}
