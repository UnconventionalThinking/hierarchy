/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package com.mycompany.hr;

import net.unconventionalthinking.exceptions.*;
import samples.matrix.app.AppSymbols_MatrixName;
import samples.matrix.app.AppControl;
import net.unconventionalthinking.matrix.*;
import samples.matrix.app.AppSymbols;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.*;
import samples.matrix.app.AppSymbols_SchemaName;
import samples.matrix.app.AppSymbols_Label;
import samples . matrix . app . * ;

import samples.matrix.app.AppSymbols_DescTag;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import samples.matrix.app.AppSymbols_DescTagName;



public class OrgChartTester__MatrixWorker {



	public static MatrixSet<Descriptor> accessMatrix_inStaticMethod_OrgChart__4(ExecutionInfo executeInfo, DescriptorTagName accessParam_2__value1) {

		//  Static Descriptor Access by Static Label, id1.
		Descriptor Descriptor__20__STATIC__LBL_id1 = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, com.mycompany.hr.OrgChart.matrix)) {
			try{
				Descriptor__20__STATIC__LBL_id1 = com.mycompany.hr.OrgChart.matrix.get_ChildDescriptor(executeInfo, AppSymbols_Label.id1);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = OrgChartTester.annotationHandler_0(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, com.mycompany.hr.OrgChart.matrix, com.mycompany.hr.OrgChart.matrix, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.id1, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named com.mycompany.hr.OrgChart.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__20__STATIC__LBL_id1 = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (MatrixSet<Descriptor>)annotateRetVal;
		}


		//  Static Descriptor Access by Static Label, id4.
		Descriptor Descriptor__21__STATIC__LBL_id4 = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__20__STATIC__LBL_id1)) {
			try{
				Descriptor__21__STATIC__LBL_id4 = Descriptor__20__STATIC__LBL_id1.get_ChildDescriptor(executeInfo, AppSymbols_Label.id4);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = OrgChartTester.annotationHandler_0(executeInfo, false, null, 1, 1, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, com.mycompany.hr.OrgChart.matrix, Descriptor__20__STATIC__LBL_id1, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.id1, null), new Pair<Object, Object>(AppSymbols_Label.id4, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the second access of the Matrix named com.mycompany.hr.OrgChart.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__21__STATIC__LBL_id4 = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (MatrixSet<Descriptor>)annotateRetVal;
		}



		//  Multi Access with access expression: AppSymbols_DescTagName.EMPLOYEE.
		MatrixSet<Descriptor> DescriptorSet__22__MULTI_ACCESS = new MatrixSet<Descriptor>();
		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__21__STATIC__LBL_id4)) {
			try{
				Descriptor__21__STATIC__LBL_id4.get_ChildDescriptors(executeInfo,accessParam_2__value1, DescriptorSet__22__MULTI_ACCESS);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = OrgChartTester.annotationHandler_0(executeInfo, false, null, 2, 2, AnnotationParameters.AccessType.DescriptorSet, accessReturnType_OutParam, com.mycompany.hr.OrgChart.matrix, Descriptor__21__STATIC__LBL_id4, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.id1, null), new Pair<Object, Object>(AppSymbols_Label.id4, null), new Pair<Object, Object>(accessParam_2__value1, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the third access of the Matrix named com.mycompany.hr.OrgChart.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				DescriptorSet__22__MULTI_ACCESS = (MatrixSet<Descriptor>)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (MatrixSet<Descriptor>)annotateRetVal;
		}



		return DescriptorSet__22__MULTI_ACCESS;

	}





	//  Continued Access
	public static String accessMatrix_inStaticMethod___5(ExecutionInfo executeInfo, Descriptor descriptor) {


		//  Static Field Access by Static Descriptor Tag Name, FullName.
		if (DescriptorUtilities.validDescriptors(executeInfo, descriptor)) {
			try{
				if (descriptor.has_FieldSet()) {
					return ((samples.matrix.app.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE)descriptor.get_FieldSet()).get_FullName(executeInfo);
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
		Object annotateRetVal = OrgChartTester.annotationHandler_0(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Field, accessReturnType_OutParam, descriptor, descriptor, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_DescTagName.FullName, null));

		if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
			throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named descriptor but had an error. The annotation handler tried to process this error but was not able to.");

		return (String)annotateRetVal;

	}





	//  Continued Access
	public static String accessMatrix_inStaticMethod___6(ExecutionInfo executeInfo, Descriptor descriptor) {


		//  Static Field Access by Static Descriptor Tag Name, Title.
		if (DescriptorUtilities.validDescriptors(executeInfo, descriptor)) {
			try{
				if (descriptor.has_FieldSet()) {
					return ((samples.matrix.app.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE)descriptor.get_FieldSet()).get_Title(executeInfo);
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
		Object annotateRetVal = OrgChartTester.annotationHandler_0(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Field, accessReturnType_OutParam, descriptor, descriptor, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_DescTagName.Title, null));

		if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
			throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named descriptor but had an error. The annotation handler tried to process this error but was not able to.");

		return (String)annotateRetVal;

	}






}
