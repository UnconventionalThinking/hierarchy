/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package com.mycompany.hr;

import net.unconventionalthinking.exceptions.*;
import java . util . Deque ;

import net.unconventionalthinking.matrix.*;
import net.unconventionalthinking.lang.*;
import net . unconventionalthinking . exceptions . Exception_InvalidArgumentPassed ;

import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import java . util . ArrayDeque ;




public class OrgChartPrinter__MatrixWorker {



	public static Descriptor accessMatrix_OrgChart__36(ExecutionInfo executeInfo, OrgChartPrinter__Annotations callerObj) {

		//  Static Descriptor Access by Static Label, id1.
		Descriptor Descriptor__74__STATIC__LBL_id1 = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, com.mycompany.hr.OrgChart.matrix)) {
			try{
				Descriptor__74__STATIC__LBL_id1 = com.mycompany.hr.OrgChart.matrix.get_ChildDescriptor(executeInfo, AppSymbols_Label.id1);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_1(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, com.mycompany.hr.OrgChart.matrix, com.mycompany.hr.OrgChart.matrix, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.id1, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named com.mycompany.hr.OrgChart.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__74__STATIC__LBL_id1 = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (Descriptor)annotateRetVal;
		}



		return Descriptor__74__STATIC__LBL_id1;

	}





	//  Continued Access
	public static Descriptor accessMatrixForFieldAssign___37(ExecutionInfo executeInfo, Descriptor descriptor, OrgChartPrinter__Annotations callerObj) {


		return descriptor;

	}





	//  Continued Access
	public static MatrixSet<Descriptor> accessMatrix___38(ExecutionInfo executeInfo, Descriptor descriptor, OrgChartPrinter__Annotations callerObj, DescriptorTagName accessParam_0__value1) {


		//  Multi Access with access expression: AppSymbols_DescTagName.EMPLOYEE.
		MatrixSet<Descriptor> DescriptorSet__76__MULTI_ACCESS = null;
		if (DescriptorUtilities.validDescriptors(executeInfo, descriptor)) {
			try{
				DescriptorSet__76__MULTI_ACCESS = descriptor.get_ChildDescriptors(executeInfo,accessParam_0__value1);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_2(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.DescriptorSet, accessReturnType_OutParam, descriptor, descriptor, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(accessParam_0__value1, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named descriptor but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				DescriptorSet__76__MULTI_ACCESS = (MatrixSet<Descriptor>)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (MatrixSet<Descriptor>)annotateRetVal;
		}



		return DescriptorSet__76__MULTI_ACCESS;

	}





	//  Continued Access
	public static Descriptor accessMatrixForFieldAssign___39(ExecutionInfo executeInfo, Descriptor descriptor, OrgChartPrinter__Annotations callerObj) {


		return descriptor;

	}





	public static Descriptor accessMatrix_OrgChart__40(ExecutionInfo executeInfo, OrgChartPrinter__Annotations callerObj) {

		//  Static Descriptor Access by Static Label, id1.
		Descriptor Descriptor__78__STATIC__LBL_id1 = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, com.mycompany.hr.OrgChart.matrix)) {
			try{
				Descriptor__78__STATIC__LBL_id1 = com.mycompany.hr.OrgChart.matrix.get_ChildDescriptor(executeInfo, AppSymbols_Label.id1);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_3(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, com.mycompany.hr.OrgChart.matrix, com.mycompany.hr.OrgChart.matrix, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.id1, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named com.mycompany.hr.OrgChart.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__78__STATIC__LBL_id1 = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (Descriptor)annotateRetVal;
		}



		return Descriptor__78__STATIC__LBL_id1;

	}





	//  Continued Access
	public static int accessMatrix___41(ExecutionInfo executeInfo, Descriptor descriptor, OrgChartPrinter__Annotations callerObj) {


		//  Static Field Access by Static Descriptor Tag Name, NumColumns.
		if (DescriptorUtilities.validDescriptors(executeInfo, descriptor)) {
			try{
				if (descriptor.has_FieldSet()) {
					return ((com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE)descriptor.get_FieldSet()).get_NumColumns(executeInfo);
				} else {
					executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedFieldButNoFieldSetExists);
				}

			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
		Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Field, accessReturnType_OutParam, descriptor, descriptor, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_DescTagName.NumColumns, null));

		if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
			throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named descriptor but had an error. The annotation handler tried to process this error but was not able to.");

		return ((Integer)annotateRetVal).intValue();

	}





	//  Continued Access
	public static String accessMatrix___42(ExecutionInfo executeInfo, Descriptor descriptor, OrgChartPrinter__Annotations callerObj) {


		//  Static Field Access by Static Descriptor Tag Name, FullName.
		if (DescriptorUtilities.validDescriptors(executeInfo, descriptor)) {
			try{
				if (descriptor.has_FieldSet()) {
					return ((com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE)descriptor.get_FieldSet()).get_FullName(executeInfo);
				} else {
					executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedFieldButNoFieldSetExists);
				}

			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
		Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Field, accessReturnType_OutParam, descriptor, descriptor, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_DescTagName.FullName, null));

		if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
			throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named descriptor but had an error. The annotation handler tried to process this error but was not able to.");

		return (String)annotateRetVal;

	}





	//  Continued Access
	public static String accessMatrix___43(ExecutionInfo executeInfo, Descriptor descriptor, OrgChartPrinter__Annotations callerObj) {


		//  Static Field Access by Static Descriptor Tag Name, Title.
		if (DescriptorUtilities.validDescriptors(executeInfo, descriptor)) {
			try{
				if (descriptor.has_FieldSet()) {
					return ((com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE)descriptor.get_FieldSet()).get_Title(executeInfo);
				} else {
					executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedFieldButNoFieldSetExists);
				}

			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
		Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Field, accessReturnType_OutParam, descriptor, descriptor, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_DescTagName.Title, null));

		if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
			throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named descriptor but had an error. The annotation handler tried to process this error but was not able to.");

		return (String)annotateRetVal;

	}






}
