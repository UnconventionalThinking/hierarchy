/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package maintests . samples . jaraccesstests ;

import net.unconventionalthinking.matrix.*;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.symbols.*;
import java . util . * ;
import maintests . samples . typeinfotest . EmbeddedCode_TestClass ;
import org . junit . After ;
import org . junit . AfterClass ;
import org . junit . Before ;
import org . junit . BeforeClass ;
import org . junit . Test ;
import static org . junit . Assert . * ;
public  class EmbeddedCodeTest_JarAccessTest implements EmbeddedCodeTest_JarAccessTest__Annotations {


	private final static AppControl_Base appControl = maintests.samples.jaraccesstests.AppControl.initializeApp();
	private final static ExecutionInfo executeInfo = appControl.executionInfo;


	@ BeforeClass public static void setUpClass ( ) throws Exception {
		
	}
	@ AfterClass public static void tearDownClass ( ) throws Exception {
		
	}
	@ Before public void setUp ( ) {
		
	}
	@ After public void tearDown ( ) {
		
	}
	@ Test public void testAccess ( ) throws Exception {
		String resultString = EmbeddedCodeTest_JarAccessTest__MatrixWorker.accessMatrix_Test$__$Matrix__5(executeInfo, this);
		String requiredImagePath_Expected = "/images/isRequired" ;
		Symbol isRequired_Expected = AppSymbols.IsRequired ;
		Symbol NotRequired_Expected = AppSymbols.NotRequired ;
		Symbol testSym1_Expected = AppSymbols.testSym1 ;
		int testField2_Expected = 6 ;
		assertEquals ( requiredImagePath_Expected , resultString ) ;
		FieldSet formRequired_FieldSet = ( EmbeddedCodeTest_JarAccessTest__MatrixWorker.accessMatrix_Test$__$Matrix__6(executeInfo, this)) . get_FieldSet ( ) ;
		assertEquals ( true , formRequired_FieldSet . is_SpecializedFieldSet ( ) ) ;
		Symbol resultSymbol = ( ( maintests . samples . typeinfotest . FieldSetTuple__maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED ) formRequired_FieldSet ) . get_IsRequired ( executeInfo ) ;
		assertEquals ( isRequired_Expected , resultSymbol ) ;
		DescriptorTagName testDesc_DescTagName = AppSymbols_DescTagName . TEST$__$DESC ;
		Object resultObj = EmbeddedCodeTest_JarAccessTest__MatrixWorker.accessMatrix_Test$__$Matrix2__7(executeInfo, maintests.samples.typeinfotest.Test$__$Matrix2.matrix, this, AppSymbols_Label.test$32$item, testDesc_DescTagName, AppSymbols_DescTagName.testField1);
		assertEquals ( testSym1_Expected , resultObj ) ;
		DescriptorTag testDesc_DescTag = AppSymbols_DescTag . maintests$__$samples$__$typeinfotest$__$anotherpackage$_CC_$Test$__$Schema$_CC_$TEST$__$DESC ;
		resultObj  = EmbeddedCodeTest_JarAccessTest__MatrixWorker.accessMatrix_Test$__$Matrix2__8(executeInfo, maintests.samples.typeinfotest.Test$__$Matrix2.matrix, this, AppSymbols_Label.test$32$item, testDesc_DescTag, AppSymbols_DescTagName.testField1);
		assertEquals ( testSym1_Expected , resultObj ) ;
		int testField2 = EmbeddedCodeTest_JarAccessTest__MatrixWorker.accessMatrix_Test$__$Matrix2__9(executeInfo, this);
		assertEquals ( testField2_Expected , testField2 ) ;
		EmbeddedCode_TestClass embeddedCode_Testclass = new EmbeddedCode_TestClass ( ) ;
		embeddedCode_Testclass . testAccess ( ) ;
		
	}
	
	public  Object annotationHandler_4(ExecutionInfo executeInfo, 
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
