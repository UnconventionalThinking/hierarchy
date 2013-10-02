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

package maintests.samples;

import net.unconventionalthinking.exceptions.*;
import org . junit . Before ;

import net.unconventionalthinking.matrix.*;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.*;
import java . util . concurrent . ConcurrentHashMap ;

import org . junit . Test ;

import org . junit . After ;

import java . util . * ;

import org . junit . AfterClass ;

import static org . junit . Assert . * ;

import org . junit . BeforeClass ;

import java . util . concurrent . ConcurrentMap ;

import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;



public class MainTests_EmbeddedCodeTest__MatrixWorker {



	public static Symbol accessMatrix_Test$__$Matrix__5(ExecutionInfo executeInfo, MainTests_EmbeddedCodeTest__Annotations callerObj, Label accessParam_1__value2) {

		//  Static Descriptor Access by Static Label, `Two`.`Part Label`.
		Descriptor Descriptor__37__STATIC__LBL_Two$__$Part$32$Label = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, maintests.samples.Test$__$Matrix.matrix)) {
			try{
				Descriptor__37__STATIC__LBL_Two$__$Part$32$Label = maintests.samples.Test$__$Matrix.matrix.get_ChildDescriptor(executeInfo, AppSymbols_Label.Two$__$Part$32$Label);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.Test$__$Matrix.matrix, maintests.samples.Test$__$Matrix.matrix, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.Two$__$Part$32$Label, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named maintests.samples.Test$__$Matrix.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__37__STATIC__LBL_Two$__$Part$32$Label = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (Symbol)annotateRetVal;
		}


		//  Static Field Access by Static Descriptor Tag Name, FORM$__$REQUIRED, and with a dynamic label.
		Descriptor Descriptor__38__STATIC__DTAGNAME_FORM$__$REQUIRED___DYN_LBL = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__37__STATIC__LBL_Two$__$Part$32$Label)) {
			try{
				Descriptor__38__STATIC__DTAGNAME_FORM$__$REQUIRED___DYN_LBL = Descriptor__37__STATIC__LBL_Two$__$Part$32$Label.get_ChildDescriptor(executeInfo, AppSymbols_DescTagName.FORM$__$REQUIRED, accessParam_1__value2);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 1, 1, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.Test$__$Matrix.matrix, Descriptor__37__STATIC__LBL_Two$__$Part$32$Label, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.Two$__$Part$32$Label, null), new Pair<Object, Object>(AppSymbols_DescTagName.FORM$__$REQUIRED, accessParam_1__value2));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the second access of the Matrix named maintests.samples.Test$__$Matrix.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__38__STATIC__DTAGNAME_FORM$__$REQUIRED___DYN_LBL = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (Symbol)annotateRetVal;
		}



		//  Static Field Access by Static Descriptor Tag Name, IsRequired.
		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__38__STATIC__DTAGNAME_FORM$__$REQUIRED___DYN_LBL)) {
			try{
				if (Descriptor__38__STATIC__DTAGNAME_FORM$__$REQUIRED___DYN_LBL.has_FieldSet()) {
					return ((maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)Descriptor__38__STATIC__DTAGNAME_FORM$__$REQUIRED___DYN_LBL.get_FieldSet()).get_IsRequired(executeInfo);
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
		Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 2, 2, AnnotationParameters.AccessType.Field, accessReturnType_OutParam, maintests.samples.Test$__$Matrix.matrix, Descriptor__38__STATIC__DTAGNAME_FORM$__$REQUIRED___DYN_LBL, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.Two$__$Part$32$Label, null), new Pair<Object, Object>(AppSymbols_DescTagName.FORM$__$REQUIRED, accessParam_1__value2), new Pair<Object, Object>(AppSymbols_DescTagName.IsRequired, null));

		if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
			throw new ExceptRuntime_MatrixAccessError("Was trying the third access of the Matrix named maintests.samples.Test$__$Matrix.matrix but had an error. The annotation handler tried to process this error but was not able to.");

		return (Symbol)annotateRetVal;

	}





	public static Descriptor accessMatrix_Test$__$Matrix__6(ExecutionInfo executeInfo, MainTests_EmbeddedCodeTest__Annotations callerObj) {

		//  Static Descriptor Access by Static Label, `Two`.`Part Label`.
		Descriptor Descriptor__40__STATIC__LBL_Two$__$Part$32$Label = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, maintests.samples.Test$__$Matrix.matrix)) {
			try{
				Descriptor__40__STATIC__LBL_Two$__$Part$32$Label = maintests.samples.Test$__$Matrix.matrix.get_ChildDescriptor(executeInfo, AppSymbols_Label.Two$__$Part$32$Label);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.Test$__$Matrix.matrix, maintests.samples.Test$__$Matrix.matrix, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.Two$__$Part$32$Label, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named maintests.samples.Test$__$Matrix.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__40__STATIC__LBL_Two$__$Part$32$Label = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (Descriptor)annotateRetVal;
		}



		return Descriptor__40__STATIC__LBL_Two$__$Part$32$Label;

	}





	//  Continued Access
	public static Symbol accessMatrix___7(ExecutionInfo executeInfo, Descriptor descriptor, MainTests_EmbeddedCodeTest__Annotations callerObj, Label accessParam_0__value2) {

		//  Static Field Access by Static Descriptor Tag Name, FORM$__$REQUIRED, and with a dynamic label.
		Descriptor Descriptor__41__STATIC__DTAGNAME_FORM$__$REQUIRED___DYN_LBL = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, descriptor)) {
			try{
				Descriptor__41__STATIC__DTAGNAME_FORM$__$REQUIRED___DYN_LBL = descriptor.get_ChildDescriptor(executeInfo, AppSymbols_DescTagName.FORM$__$REQUIRED, accessParam_0__value2);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, descriptor, descriptor, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_DescTagName.FORM$__$REQUIRED, accessParam_0__value2));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named descriptor but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__41__STATIC__DTAGNAME_FORM$__$REQUIRED___DYN_LBL = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (Symbol)annotateRetVal;
		}



		//  Static Field Access by Static Descriptor Tag Name, IsRequired.
		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__41__STATIC__DTAGNAME_FORM$__$REQUIRED___DYN_LBL)) {
			try{
				if (Descriptor__41__STATIC__DTAGNAME_FORM$__$REQUIRED___DYN_LBL.has_FieldSet()) {
					return ((maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)Descriptor__41__STATIC__DTAGNAME_FORM$__$REQUIRED___DYN_LBL.get_FieldSet()).get_IsRequired(executeInfo);
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
		Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 1, 1, AnnotationParameters.AccessType.Field, accessReturnType_OutParam, descriptor, Descriptor__41__STATIC__DTAGNAME_FORM$__$REQUIRED___DYN_LBL, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_DescTagName.FORM$__$REQUIRED, accessParam_0__value2), new Pair<Object, Object>(AppSymbols_DescTagName.IsRequired, null));

		if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
			throw new ExceptRuntime_MatrixAccessError("Was trying the second access of the Matrix named descriptor but had an error. The annotation handler tried to process this error but was not able to.");

		return (Symbol)annotateRetVal;

	}






}
