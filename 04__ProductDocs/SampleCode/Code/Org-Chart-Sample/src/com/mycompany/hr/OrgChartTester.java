/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package com . mycompany . hr ;

import samples.matrix.app.AppControl;
import samples.matrix.app.AppSymbols;
import samples.matrix.app.AppSymbols_DescTagName;
import samples.matrix.app.AppSymbols_Label;
import samples.matrix.app.AppSymbols_DescTag;
import samples.matrix.app.AppSymbols_MatrixName;
import samples.matrix.app.AppSymbols_SchemaName;

import net.unconventionalthinking.matrix.*;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.symbols.*;
import samples . matrix . app . * ;
public  class OrgChartTester implements OrgChartTester__Annotations {


	private final static AppControl_Base appControl = samples.matrix.app.AppControl.initializeApp();
	private final static ExecutionInfo executeInfo = appControl.executionInfo;


	public static void main ( String [ ] args ) throws Exception {
		System . out . println ( "\n\nJohn Jones' employees\n_________________________________" ) ;
		for ( net.unconventionalthinking.matrix.Descriptor employee : OrgChartTester__MatrixWorker.accessMatrix_inStaticMethod_OrgChart__4(executeInfo, AppSymbols_DescTagName.EMPLOYEE)) {
			System . out . println ( "  o " + OrgChartTester__MatrixWorker.accessMatrix_inStaticMethod___5(executeInfo, employee)+ " - " + OrgChartTester__MatrixWorker.accessMatrix_inStaticMethod___6(executeInfo, employee)) ;
			
		}
		System . out . println ( "\n" ) ;
		
	}
	
	public static  Object annotationHandler_0(ExecutionInfo executeInfo, 
		boolean annotationReference_Exists, Symbol annotationRef_Base, int annotationRef_AccessCounter,
		int childAccessIndex, AnnotationParameters.AccessType accessType, AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam, 
		Descriptor rootAccessDescriptor, Descriptor currAccessors_ParentDescriptor, MatrixSet<Descriptor> currAccessors_ParentDescriptorSet, 
		boolean passingInException, Exception e, Pair<Object, Object>... childAccessor_Pairs) {

		
		//  Default:
				return null ;


	}





}
