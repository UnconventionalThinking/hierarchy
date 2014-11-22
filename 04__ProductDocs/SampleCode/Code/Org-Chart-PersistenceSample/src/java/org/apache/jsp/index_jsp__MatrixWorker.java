/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package org.apache.jsp;


import net . unconventionalthinking . hierarchy . persistence . * ;

import com.mycompany.hr.AppControl;
import java . io . IOException ;

import java . util . Iterator ;

import java . net . URL ;

import com . mycompany . hr . * ;

import com.mycompany.hr.AppSymbols;
import com.mycompany.hr.AppSymbols_MatrixName;
import net.unconventionalthinking.matrix.symbols.*;
import java . util . Arrays ;

import java . text . Format ;

import javax . servlet . jsp . * ;

import com.mycompany.hr.AppSymbols_DescTag;
import net.unconventionalthinking.exceptions.*;
import com.mycompany.hr.AppSymbols_Label;
import net.unconventionalthinking.matrix.*;
import com.mycompany.hr.AppSymbols_SchemaName;
import net.unconventionalthinking.lang.*;
import java . text . SimpleDateFormat ;

import com.mycompany.hr.AppSymbols_DescTagName;
import javax . servlet . * ;

import net . unconventional . persistence . * ;

import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import java . util . List ;

import javax . servlet . http . * ;

import java . net . MalformedURLException ;




public class index_jsp__MatrixWorker {



	public static Descriptor accessMatrix_OrgChart__27(ExecutionInfo executeInfo, index_jsp__Annotations callerObj) {

		//  Static Descriptor Access by Static Label, id1.
		Descriptor Descriptor__46__STATIC__LBL_id1 = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, com.mycompany.hr.OrgChart.matrix)) {
			try{
				Descriptor__46__STATIC__LBL_id1 = com.mycompany.hr.OrgChart.matrix.get_ChildDescriptor(executeInfo, AppSymbols_Label.id1);
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
				Descriptor__46__STATIC__LBL_id1 = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (Descriptor)annotateRetVal;
		}



		return Descriptor__46__STATIC__LBL_id1;

	}





	//  Continued Access
	public static MatrixSet<Descriptor> accessMatrix___28(ExecutionInfo executeInfo, Descriptor descriptor, index_jsp__Annotations callerObj, DescriptorTagName accessParam_0__value1) {


		//  Multi Access with access expression: AppSymbols_DescTagName.EMPLOYEE.
		MatrixSet<Descriptor> DescriptorSet__47__MULTI_ACCESS = null;
		if (DescriptorUtilities.validDescriptors(executeInfo, descriptor)) {
			try{
				DescriptorSet__47__MULTI_ACCESS = descriptor.get_ChildDescriptors(executeInfo,accessParam_0__value1);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.DescriptorSet, accessReturnType_OutParam, descriptor, descriptor, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(accessParam_0__value1, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named descriptor but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				DescriptorSet__47__MULTI_ACCESS = (MatrixSet<Descriptor>)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (MatrixSet<Descriptor>)annotateRetVal;
		}



		return DescriptorSet__47__MULTI_ACCESS;

	}






}
