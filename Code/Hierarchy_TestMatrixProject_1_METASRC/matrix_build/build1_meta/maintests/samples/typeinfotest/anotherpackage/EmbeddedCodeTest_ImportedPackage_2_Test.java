/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package maintests . samples . typeinfotest . anotherpackage ;

import maintests.samples.typeinfotest.AppControl;
import maintests.samples.typeinfotest.AppSymbols;
import maintests.samples.typeinfotest.AppSymbols_DescTagName;
import maintests.samples.typeinfotest.AppSymbols_Label;
import maintests.samples.typeinfotest.AppSymbols_DescTag;
import maintests.samples.typeinfotest.AppSymbols_MatrixName;
import maintests.samples.typeinfotest.AppSymbols_SchemaName;

import net.unconventionalthinking.matrix.*;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.symbols.*;
import java . util . * ;
import maintests . samples . typeinfotest . * ;
import org . junit . After ;
import org . junit . AfterClass ;
import org . junit . Before ;
import org . junit . BeforeClass ;
import org . junit . Test ;
import static org . junit . Assert . * ;
public  class EmbeddedCodeTest_ImportedPackage_2_Test implements EmbeddedCodeTest_ImportedPackage_2_Test__Annotations {


	private final static AppControl_Base appControl = maintests.samples.typeinfotest.AppControl.initializeApp();
	private final static ExecutionInfo executeInfo = appControl.executionInfo;


	static String requiredImagePath_Expected ;
	static Symbol isRequired_Expected ;
	static Symbol NotRequired_Expected ;
	@ BeforeClass public static void setUpClass ( ) throws Exception {
		requiredImagePath_Expected  = "/images/isRequired" ;
		isRequired_Expected  = AppSymbols.IsRequired ;
		NotRequired_Expected  = AppSymbols.NotRequired ;
		
	}
	@ AfterClass public static void tearDownClass ( ) throws Exception {
		
	}
	@ Before public void setUp ( ) {
		
	}
	@ After public void tearDown ( ) {
		
	}
	@ Test public void testImportedMatrixAccess ( ) throws Exception {
		String resultString = EmbeddedCodeTest_ImportedPackage_2_Test__MatrixWorker.accessMatrix_Test$__$Matrix__25(executeInfo, this);
		assertEquals ( requiredImagePath_Expected , resultString ) ;
		Symbol resultSymbol = ( Symbol ) EmbeddedCodeTest_ImportedPackage_2_Test__MatrixWorker.accessMatrix_Test$__$Matrix2__26(executeInfo, maintests.samples.typeinfotest.Test$__$Matrix2.matrix, this, AppSymbols_Label.test$32$item, AppSymbols_DescTagName.TEST$__$DESC, AppSymbols_DescTagName.testField1);
		assertEquals ( AppSymbols.testSym1 , resultSymbol ) ;
		FieldSet formRequired_FieldSet = ( EmbeddedCodeTest_ImportedPackage_2_Test__MatrixWorker.accessMatrix_Test$__$Matrix__27(executeInfo, this)) . get_FieldSet ( ) ;
		assertEquals ( true , formRequired_FieldSet . is_SpecializedFieldSet ( ) ) ;
		resultSymbol  = ( ( FieldSetTuple__maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED ) formRequired_FieldSet ) . get_IsRequired ( executeInfo ) ;
		assertEquals ( isRequired_Expected , resultSymbol ) ;
		resultString  = EmbeddedCodeTest_ImportedPackage_2_Test__MatrixWorker.accessMatrix_Test$__$Matrix3__28(executeInfo, this);
		assertEquals ( requiredImagePath_Expected , resultString ) ;
		
	}
	
	public  Object annotationHandler_4(ExecutionInfo executeInfo, 
		boolean annotationReference_Exists, Symbol annotationRef_Base, int annotationRef_AccessCounter,
		int childAccessIndex, AnnotationParameters.AccessType accessType, AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam, 
		Descriptor rootAccessDescriptor, Descriptor currAccessors_ParentDescriptor, MatrixSet<Descriptor> currAccessors_ParentDescriptorSet, 
		boolean passingInException, Exception e, Pair<Object, Object>... childAccessor_Pairs) {

		
		//  Default:
				return null ;


	}





}
