/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package maintests.samples.typeinfotest;

import net.unconventionalthinking.exceptions.*;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.*;
import java . util . * ;




public class EmbeddedCode_TestClass__MatrixWorker {



	public static String accessMatrix_Test$__$Matrix__17(ExecutionInfo executeInfo, EmbeddedCode_TestClass__Annotations callerObj) {

		//  Static Descriptor Access by Static Label, First Name.
		Descriptor Descriptor__86__STATIC__LBL_First$32$Name = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, maintests.samples.typeinfotest.Test$__$Matrix.matrix)) {
			try{
				Descriptor__86__STATIC__LBL_First$32$Name = maintests.samples.typeinfotest.Test$__$Matrix.matrix.get_ChildDescriptor(executeInfo, AppSymbols_Label.First$32$Name);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_0(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.typeinfotest.Test$__$Matrix.matrix, maintests.samples.typeinfotest.Test$__$Matrix.matrix, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.First$32$Name, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named maintests.samples.typeinfotest.Test$__$Matrix.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__86__STATIC__LBL_First$32$Name = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (String)annotateRetVal;
		}


		//  Static Descriptor Access by Static Descriptor Tag, maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED.
		Descriptor Descriptor__87__STATIC__DTAG_maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__86__STATIC__LBL_First$32$Name)) {
			try{
				Descriptor__87__STATIC__DTAG_maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED = Descriptor__86__STATIC__LBL_First$32$Name.get_ChildDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_0(executeInfo, false, null, 1, 1, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.typeinfotest.Test$__$Matrix.matrix, Descriptor__86__STATIC__LBL_First$32$Name, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.First$32$Name, null), new Pair<Object, Object>(AppSymbols_DescTag.maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the second access of the Matrix named maintests.samples.typeinfotest.Test$__$Matrix.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__87__STATIC__DTAG_maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (String)annotateRetVal;
		}



		//  Static Field Access by Static Descriptor Tag Name, RequiredImagePath.
		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__87__STATIC__DTAG_maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED)) {
			try{
				if (Descriptor__87__STATIC__DTAG_maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED.has_FieldSet()) {
					return ((maintests.samples.typeinfotest.FieldSetTuple__maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)Descriptor__87__STATIC__DTAG_maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED.get_FieldSet()).get_RequiredImagePath(executeInfo);
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
		Object annotateRetVal = callerObj.annotationHandler_0(executeInfo, false, null, 2, 2, AnnotationParameters.AccessType.Field, accessReturnType_OutParam, maintests.samples.typeinfotest.Test$__$Matrix.matrix, Descriptor__87__STATIC__DTAG_maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.First$32$Name, null), new Pair<Object, Object>(AppSymbols_DescTag.maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED, null), new Pair<Object, Object>(AppSymbols_DescTagName.RequiredImagePath, null));

		if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
			throw new ExceptRuntime_MatrixAccessError("Was trying the third access of the Matrix named maintests.samples.typeinfotest.Test$__$Matrix.matrix but had an error. The annotation handler tried to process this error but was not able to.");

		return (String)annotateRetVal;

	}





	public static Descriptor accessMatrix_Test$__$Matrix__18(ExecutionInfo executeInfo, EmbeddedCode_TestClass__Annotations callerObj) {

		//  Static Descriptor Access by Static Label, First Name.
		Descriptor Descriptor__89__STATIC__LBL_First$32$Name = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, maintests.samples.typeinfotest.Test$__$Matrix.matrix)) {
			try{
				Descriptor__89__STATIC__LBL_First$32$Name = maintests.samples.typeinfotest.Test$__$Matrix.matrix.get_ChildDescriptor(executeInfo, AppSymbols_Label.First$32$Name);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_0(executeInfo, true, AppSymbols.$42$1, 0, 0, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.typeinfotest.Test$__$Matrix.matrix, maintests.samples.typeinfotest.Test$__$Matrix.matrix, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.First$32$Name, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named maintests.samples.typeinfotest.Test$__$Matrix.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__89__STATIC__LBL_First$32$Name = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (Descriptor)annotateRetVal;
		}


		//  Static Descriptor Access by Static Descriptor Tag, maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED.
		Descriptor Descriptor__90__STATIC__DTAG_maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__89__STATIC__LBL_First$32$Name)) {
			try{
				Descriptor__90__STATIC__DTAG_maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED = Descriptor__89__STATIC__LBL_First$32$Name.get_ChildDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_0(executeInfo, true, AppSymbols.$42$1, 1, 1, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.typeinfotest.Test$__$Matrix.matrix, Descriptor__89__STATIC__LBL_First$32$Name, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.First$32$Name, null), new Pair<Object, Object>(AppSymbols_DescTag.maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the second access of the Matrix named maintests.samples.typeinfotest.Test$__$Matrix.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__90__STATIC__DTAG_maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (Descriptor)annotateRetVal;
		}



		return Descriptor__90__STATIC__DTAG_maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED;

	}






}
