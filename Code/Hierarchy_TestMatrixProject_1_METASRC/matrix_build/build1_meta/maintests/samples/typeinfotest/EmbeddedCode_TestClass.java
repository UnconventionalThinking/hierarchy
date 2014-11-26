/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package maintests . samples . typeinfotest ;

import net.unconventionalthinking.matrix.*;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.symbols.*;
import java . util . * ;
public  class EmbeddedCode_TestClass implements EmbeddedCode_TestClass__Annotations {


	private final static AppControl_Base appControl = maintests.samples.typeinfotest.AppControl.initializeApp();
	private final static ExecutionInfo executeInfo = appControl.executionInfo;


	String requiredImagePath_Expected ;
	Symbol isRequired_Expected ;
	Symbol NotRequired_Expected ;
	Symbol testSym1_Expected ;
	int testField2_Expected ;
	public EmbeddedCode_TestClass ( ) throws Exception {
		requiredImagePath_Expected  = "/images/isRequired" ;
		isRequired_Expected  = AppSymbols.IsRequired ;
		NotRequired_Expected  = AppSymbols.NotRequired ;
		testSym1_Expected  = AppSymbols.testSym1 ;
		testField2_Expected  = 6 ;
		
	}
	public void testAccess ( ) throws Exception {
		String resultString = EmbeddedCode_TestClass__MatrixWorker.accessMatrix_Test$__$Matrix__17(executeInfo, this);
		assertEquals ( requiredImagePath_Expected , resultString ) ;
		FieldSet formRequired_FieldSet = ( EmbeddedCode_TestClass__MatrixWorker.accessMatrix_Test$__$Matrix__18(executeInfo, this)) . get_FieldSet ( ) ;
		assertEquals ( true , formRequired_FieldSet . is_SpecializedFieldSet ( ) ) ;
		Symbol resultSymbol = ( ( FieldSetTuple__maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED ) formRequired_FieldSet ) . get_IsRequired ( executeInfo ) ;
		assertEquals ( isRequired_Expected , resultSymbol ) ;
		
	}
	public static void assertEquals ( Object expected , Object actual ) throws Exception {
		if ( expected == actual ) return ;
		else if ( expected != null && actual != null ) {
			if ( expected . equals ( actual ) ) return ;
			
		}
		throw new Exception ( "Expected result does not equal actual. Expected was '" + expected + "' and actual was '" + actual + "'." ) ;
		
	}
	
	public  Object annotationHandler_0(ExecutionInfo executeInfo, 
		boolean annotationReference_Exists, Symbol annotationRef_Base, int annotationRef_AccessCounter,
		int childAccessIndex, AnnotationParameters.AccessType accessType, AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam, 
		Descriptor rootAccessDescriptor, Descriptor currAccessors_ParentDescriptor, MatrixSet<Descriptor> currAccessors_ParentDescriptorSet, 
		boolean passingInException, Exception e, Pair<Object, Object>... childAccessor_Pairs) {

		if (annotationRef_Base == AppSymbols.$42$1) {
			return AppSymbols.$49$_0 ;

		}
		//  Default:
		return null ;


	}





}
