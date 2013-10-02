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
		Label testLabel = AppSymbols_Label.Test$__$Label ;
		Symbol resultSymbol = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__5(executeInfo, this, testLabel);
		assertEquals ( isRequired_Expected , resultSymbol ) ;
		testLabel  = AppSymbols_Label.Test$__$Label ;
		net.unconventionalthinking.matrix.Descriptor testDescVar = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix_Test$__$Matrix__6(executeInfo, this);
		resultSymbol  = MainTests_EmbeddedCodeTest__MatrixWorker.accessMatrix___7(executeInfo, testDescVar, this, testLabel);
		assertEquals ( isRequired_Expected , resultSymbol ) ;
		
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
