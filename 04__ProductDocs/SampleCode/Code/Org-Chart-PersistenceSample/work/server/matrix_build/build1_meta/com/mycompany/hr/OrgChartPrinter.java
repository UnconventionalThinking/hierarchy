/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package com . mycompany . hr ;

import net.unconventionalthinking.matrix.*;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.symbols.*;
import java . util . ArrayDeque ;
import java . util . Deque ;
import net . unconventionalthinking . exceptions . Exception_InvalidArgumentPassed ;
public  class OrgChartPrinter implements OrgChartPrinter__Annotations {


	private final static AppControl_Base appControl = com.mycompany.hr.AppControl.initializeApp();
	private final static ExecutionInfo executeInfo = appControl.executionInfo;


	int depthOfTree = 0 ;
	Deque < EmployeeNode > currNodeProcessing_Queue = new ArrayDeque < EmployeeNode > ( ) ;
	Deque < EmployeeNode > buildTable_Queue = new ArrayDeque < EmployeeNode > ( ) ;
	public static void main ( String args [ ] ) throws Exception {
		OrgChartPrinter orgChartPrinter = new OrgChartPrinter ( ) ;
		System . out . println ( orgChartPrinter . print ( ) ) ;
		
	}
	public StringBuilder print ( ) throws Exception_InvalidArgumentPassed {
		int numColumns = pass1_CalculateNumColumnsForNode ( OrgChartPrinter__MatrixWorker.accessMatrix_OrgChart__36(executeInfo, this), 1 ) ;
		pass2_CreateBuildTableQueue ( ) ;
		StringBuilder out = pass3_PrintTable ( ) ;
		return out ;
		
	}
	public int pass1_CalculateNumColumnsForNode ( net.unconventionalthinking.matrix.Descriptor currEmployee , int currTreeDepth ) throws Exception_InvalidArgumentPassed {
		if ( currTreeDepth > depthOfTree ) depthOfTree  = currTreeDepth;
		if ( currEmployee . get_ChildDescriptors_Size ( executeInfo ) == 0 ) {
			((com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE)OrgChartPrinter__MatrixWorker.accessMatrixForFieldAssign___37(executeInfo, currEmployee, this).get_FieldSet()).set_NumColumns(executeInfo, 1 );
			return 1 ;
			
		}
		else {
			int sum_ChildNumCols = 0 ;
			for ( net.unconventionalthinking.matrix.Descriptor childEmployee : OrgChartPrinter__MatrixWorker.accessMatrix___38(executeInfo, currEmployee, this, AppSymbols_DescTagName.EMPLOYEE)) {
				sum_ChildNumCols  = sum_ChildNumCols + pass1_CalculateNumColumnsForNode ( childEmployee , currTreeDepth + 1 ) ;
				
			}
			((com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE)OrgChartPrinter__MatrixWorker.accessMatrixForFieldAssign___39(executeInfo, currEmployee, this).get_FieldSet()).set_NumColumns(executeInfo, sum_ChildNumCols);
			return sum_ChildNumCols ;
			
		}
		
	}
	public void pass2_CreateBuildTableQueue ( ) throws Exception_InvalidArgumentPassed {
		EmployeeNode rootEmployeeNode = new EmployeeNode ( OrgChartPrinter__MatrixWorker.accessMatrix_OrgChart__40(executeInfo, this), 1 ) ;
		currNodeProcessing_Queue . addLast ( rootEmployeeNode ) ;
		buildTable_Queue . addLast ( rootEmployeeNode ) ;
		for ( EmployeeNode currEmployee = currNodeProcessing_Queue . pollFirst ( ) ;
		currEmployee != null ;
		currEmployee  = currNodeProcessing_Queue . pollFirst ( ) ) {
			if ( currEmployee . employeeDesc != null && currEmployee . employeeDesc . get_ChildDescriptors_Size ( executeInfo ) > 0 ) {
				for ( net.unconventionalthinking.matrix.Descriptor childEmployeeDesc : currEmployee . employeeDesc . get_ChildDescriptors_List ( executeInfo ) ) {
					EmployeeNode childEmployeeNode = new EmployeeNode ( childEmployeeDesc , currEmployee . rowLevel + 1 ) ;
					currNodeProcessing_Queue . addLast ( childEmployeeNode ) ;
					buildTable_Queue . addLast ( childEmployeeNode ) ;
					
				}
				
			}
			else {
				if ( currEmployee . rowLevel + 1 <= depthOfTree ) {
					EmployeeNode childEmployeeNode = new EmployeeNode ( null , currEmployee . rowLevel + 1 ) ;
					currNodeProcessing_Queue . addLast ( childEmployeeNode ) ;
					buildTable_Queue . addLast ( childEmployeeNode ) ;
					
				}
				
			}
			
		}
		
	}
	public StringBuilder pass3_PrintTable ( ) {
		StringBuilder out = new StringBuilder ( ) ;
		EmployeeNode prevEmployeeNode = null ;
		for ( EmployeeNode currEmployeeNode = buildTable_Queue . pollFirst ( ) ;
		currEmployeeNode != null ;
		currEmployeeNode  = buildTable_Queue . pollFirst ( ) ) {
			if ( prevEmployeeNode == null || ( currEmployeeNode . rowLevel != prevEmployeeNode . rowLevel ) ) out . append ( "<tr>\n" ) ;
			net.unconventionalthinking.matrix.Descriptor currEmployeeDesc = currEmployeeNode . employeeDesc ;
			int colSpan = currEmployeeDesc != null ? ( Integer ) OrgChartPrinter__MatrixWorker.accessMatrix___41(executeInfo, currEmployeeDesc, this): 1 ;
			if ( currEmployeeDesc != null ) {
				out . append ( "\t<td colspan='" + colSpan + "' style='text-align: center; border:solid;'>\n" ) ;
				out . append ( "\t\t<b>" + OrgChartPrinter__MatrixWorker.accessMatrix___42(executeInfo, currEmployeeDesc, this)+ "</b><br>\n" ) ;
				out . append ( "\t\t" + OrgChartPrinter__MatrixWorker.accessMatrix___43(executeInfo, currEmployeeDesc, this)+ " (<i>" + currEmployeeDesc . get_Label ( ) . toString ( ) + "</i>)\n" ) ;
				
			}
			else {
				out . append ( "\t<td colspan='" + colSpan + "' style='text-align: center; '>\n" ) ;
				out . append ( "\t\t&nbsp;\n" ) ;
				
			}
			out . append ( "\t</td>\n" ) ;
			if ( buildTable_Queue . size ( ) == 0 || ( currEmployeeNode . rowLevel != buildTable_Queue . peekFirst ( ) . rowLevel ) ) out . append ( "</tr>\n" ) ;
			prevEmployeeNode  = currEmployeeNode;
			
		}
		return out ;
		
	}
	
	public  Object annotationHandler_1(ExecutionInfo executeInfo, 
		boolean annotationReference_Exists, Symbol annotationRef_Base, int annotationRef_AccessCounter,
		int childAccessIndex, AnnotationParameters.AccessType accessType, AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam, 
		Descriptor rootAccessDescriptor, Descriptor currAccessors_ParentDescriptor, MatrixSet<Descriptor> currAccessors_ParentDescriptorSet, 
		boolean passingInException, Exception e, Pair<Object, Object>... childAccessor_Pairs) {

		
		//  Default:
				return null ;


	}

	public  Object annotationHandler_2(ExecutionInfo executeInfo, 
		boolean annotationReference_Exists, Symbol annotationRef_Base, int annotationRef_AccessCounter,
		int childAccessIndex, AnnotationParameters.AccessType accessType, AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam, 
		Descriptor rootAccessDescriptor, Descriptor currAccessors_ParentDescriptor, MatrixSet<Descriptor> currAccessors_ParentDescriptorSet, 
		boolean passingInException, Exception e, Pair<Object, Object>... childAccessor_Pairs) {

		
		//  Default:
				return null ;


	}

	public  Object annotationHandler_3(ExecutionInfo executeInfo, 
		boolean annotationReference_Exists, Symbol annotationRef_Base, int annotationRef_AccessCounter,
		int childAccessIndex, AnnotationParameters.AccessType accessType, AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam, 
		Descriptor rootAccessDescriptor, Descriptor currAccessors_ParentDescriptor, MatrixSet<Descriptor> currAccessors_ParentDescriptorSet, 
		boolean passingInException, Exception e, Pair<Object, Object>... childAccessor_Pairs) {

		
		//  Default:
				return null ;


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
