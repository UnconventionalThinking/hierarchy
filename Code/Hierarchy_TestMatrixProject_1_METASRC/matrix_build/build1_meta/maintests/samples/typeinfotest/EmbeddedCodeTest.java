/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package maintests . samples . typeinfotest ;

import net.unconventionalthinking.matrix.*;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.symbols.*;
import java . util . * ;
import org . junit . After ;
import org . junit . AfterClass ;
import org . junit . Before ;
import org . junit . BeforeClass ;
import org . junit . Test ;
import static org . junit . Assert . * ;
public  class EmbeddedCodeTest implements EmbeddedCodeTest__Annotations {


	private final static AppControl_Base appControl = maintests.samples.typeinfotest.AppControl.initializeApp();
	private final static ExecutionInfo executeInfo = appControl.executionInfo;


	static String requiredImagePath_Expected ;
	static Symbol isRequired_Expected ;
	static Symbol NotRequired_Expected ;
	static Symbol testSym1_Expected ;
	static int testField2_Expected ;
	@ BeforeClass public static void setUpClass ( ) throws Exception {
		requiredImagePath_Expected  = "/images/isRequired" ;
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
		String resultString = EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__19(executeInfo, this);
		assertEquals ( requiredImagePath_Expected , resultString ) ;
		Symbol resultSymbol = ( Symbol ) EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix2__20(executeInfo, maintests.samples.typeinfotest.Test$__$Matrix2.matrix, this, AppSymbols_Label.test$32$item, AppSymbols_DescTagName.TEST$__$DESC, AppSymbols_DescTagName.testField1);
		assertEquals ( AppSymbols.testSym1 , resultSymbol ) ;
		resultSymbol  = ( Symbol ) EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix2$95$1__21(executeInfo, maintests.samples.typeinfotest.Test$__$Matrix2$95$1.matrix, this, AppSymbols_Label.test$32$item, AppSymbols_DescTagName.TEST$__$DESC, AppSymbols_DescTagName.testField1);
		assertEquals ( AppSymbols.testSym2 , resultSymbol ) ;
		FieldSet formRequired_FieldSet = ( EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__22(executeInfo, this)) . get_FieldSet ( ) ;
		assertEquals ( true , formRequired_FieldSet . is_SpecializedFieldSet ( ) ) ;
		resultSymbol  = ( ( FieldSetTuple__maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED ) formRequired_FieldSet ) . get_IsRequired ( executeInfo ) ;
		assertEquals ( isRequired_Expected , resultSymbol ) ;
		
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
