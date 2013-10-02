/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package maintests.samples.typeinfotest;

import net.unconventionalthinking.exceptions.*;
import org . junit . After ;

import org . junit . Before ;

import java . util . * ;

import org . junit . AfterClass ;

import static org . junit . Assert . * ;

import net.unconventionalthinking.matrix.*;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.*;
import org . junit . BeforeClass ;

import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import org . junit . Test ;




public class EmbeddedCodeTest__MatrixWorker {



	public static String accessMatrix_Test$__$Matrix__17(ExecutionInfo executeInfo, EmbeddedCodeTest__Annotations callerObj) {

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
			Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.typeinfotest.Test$__$Matrix.matrix, maintests.samples.typeinfotest.Test$__$Matrix.matrix, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.First$32$Name, null));

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
			Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 1, 1, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.typeinfotest.Test$__$Matrix.matrix, Descriptor__86__STATIC__LBL_First$32$Name, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.First$32$Name, null), new Pair<Object, Object>(AppSymbols_DescTag.maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED, null));

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
		Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 2, 2, AnnotationParameters.AccessType.Field, accessReturnType_OutParam, maintests.samples.typeinfotest.Test$__$Matrix.matrix, Descriptor__87__STATIC__DTAG_maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.First$32$Name, null), new Pair<Object, Object>(AppSymbols_DescTag.maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED, null), new Pair<Object, Object>(AppSymbols_DescTagName.RequiredImagePath, null));

		if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
			throw new ExceptRuntime_MatrixAccessError("Was trying the third access of the Matrix named maintests.samples.typeinfotest.Test$__$Matrix.matrix but had an error. The annotation handler tried to process this error but was not able to.");

		return (String)annotateRetVal;

	}





	public static Object accessMatrix_Test$__$Matrix2__18(ExecutionInfo executeInfo, Matrix matrix, EmbeddedCodeTest__Annotations callerObj, Symbol_Base accessParam_0__value1, Symbol_Base accessParam_1__value1, Symbol_Base accessParam_2__value1) {

		//  Dynamic Access with 1 access expression: AppSymbols_Label.test$32$item.
		Descriptor Descriptor__89__DYN__w_1_EXPR = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, matrix)) {
			try{
				Descriptor__89__DYN__w_1_EXPR = ((Descriptor)matrix).get_ChildDescriptor(executeInfo, accessParam_0__value1);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, matrix, matrix, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(accessParam_0__value1, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__89__DYN__w_1_EXPR = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return annotateRetVal;
		}


		//  Dynamic Access with 1 access expression: AppSymbols_DescTagName.TEST$__$DESC.
		Descriptor Descriptor__90__DYN__w_1_EXPR = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__89__DYN__w_1_EXPR)) {
			try{
				Descriptor__90__DYN__w_1_EXPR = ((Descriptor)Descriptor__89__DYN__w_1_EXPR).get_ChildDescriptor(executeInfo, accessParam_1__value1);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 1, 1, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, matrix, Descriptor__89__DYN__w_1_EXPR, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(accessParam_0__value1, null), new Pair<Object, Object>(accessParam_1__value1, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the second access of the Matrix named matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__90__DYN__w_1_EXPR = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return annotateRetVal;
		}



		//  Dynamic Access with 1 access expression: AppSymbols_DescTagName.testField1.
		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__90__DYN__w_1_EXPR)) {
			try{
				if (Descriptor__90__DYN__w_1_EXPR.has_FieldSet()) {
					return Descriptor__90__DYN__w_1_EXPR.get_FieldSet().getField(executeInfo,  (DescriptorTagName)accessParam_2__value1);
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
		Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 2, 2, AnnotationParameters.AccessType.Field, accessReturnType_OutParam, matrix, Descriptor__90__DYN__w_1_EXPR, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(accessParam_0__value1, null), new Pair<Object, Object>(accessParam_1__value1, null), new Pair<Object, Object>(accessParam_2__value1, null));

		if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
			throw new ExceptRuntime_MatrixAccessError("Was trying the third access of the Matrix named matrix but had an error. The annotation handler tried to process this error but was not able to.");

		return annotateRetVal;

	}





	public static Object accessMatrix_Test$__$Matrix2$95$1__19(ExecutionInfo executeInfo, Matrix matrix, EmbeddedCodeTest__Annotations callerObj, Symbol_Base accessParam_0__value1, Symbol_Base accessParam_1__value1, Symbol_Base accessParam_2__value1) {

		//  Dynamic Access with 1 access expression: AppSymbols_Label.test$32$item.
		Descriptor Descriptor__92__DYN__w_1_EXPR = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, matrix)) {
			try{
				Descriptor__92__DYN__w_1_EXPR = ((Descriptor)matrix).get_ChildDescriptor(executeInfo, accessParam_0__value1);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, matrix, matrix, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(accessParam_0__value1, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__92__DYN__w_1_EXPR = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return annotateRetVal;
		}


		//  Dynamic Access with 1 access expression: AppSymbols_DescTagName.TEST$__$DESC.
		Descriptor Descriptor__93__DYN__w_1_EXPR = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__92__DYN__w_1_EXPR)) {
			try{
				Descriptor__93__DYN__w_1_EXPR = ((Descriptor)Descriptor__92__DYN__w_1_EXPR).get_ChildDescriptor(executeInfo, accessParam_1__value1);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 1, 1, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, matrix, Descriptor__92__DYN__w_1_EXPR, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(accessParam_0__value1, null), new Pair<Object, Object>(accessParam_1__value1, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the second access of the Matrix named matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__93__DYN__w_1_EXPR = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return annotateRetVal;
		}



		//  Dynamic Access with 1 access expression: AppSymbols_DescTagName.testField1.
		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__93__DYN__w_1_EXPR)) {
			try{
				if (Descriptor__93__DYN__w_1_EXPR.has_FieldSet()) {
					return Descriptor__93__DYN__w_1_EXPR.get_FieldSet().getField(executeInfo,  (DescriptorTagName)accessParam_2__value1);
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
		Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 2, 2, AnnotationParameters.AccessType.Field, accessReturnType_OutParam, matrix, Descriptor__93__DYN__w_1_EXPR, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(accessParam_0__value1, null), new Pair<Object, Object>(accessParam_1__value1, null), new Pair<Object, Object>(accessParam_2__value1, null));

		if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
			throw new ExceptRuntime_MatrixAccessError("Was trying the third access of the Matrix named matrix but had an error. The annotation handler tried to process this error but was not able to.");

		return annotateRetVal;

	}





	public static Descriptor accessMatrix_Test$__$Matrix__20(ExecutionInfo executeInfo, EmbeddedCodeTest__Annotations callerObj) {

		//  Static Descriptor Access by Static Label, First Name.
		Descriptor Descriptor__95__STATIC__LBL_First$32$Name = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, maintests.samples.typeinfotest.Test$__$Matrix.matrix)) {
			try{
				Descriptor__95__STATIC__LBL_First$32$Name = maintests.samples.typeinfotest.Test$__$Matrix.matrix.get_ChildDescriptor(executeInfo, AppSymbols_Label.First$32$Name);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, true, AppSymbols.$42$1, 0, 0, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.typeinfotest.Test$__$Matrix.matrix, maintests.samples.typeinfotest.Test$__$Matrix.matrix, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.First$32$Name, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named maintests.samples.typeinfotest.Test$__$Matrix.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__95__STATIC__LBL_First$32$Name = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (Descriptor)annotateRetVal;
		}


		//  Static Descriptor Access by Static Descriptor Tag, maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED.
		Descriptor Descriptor__96__STATIC__DTAG_maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__95__STATIC__LBL_First$32$Name)) {
			try{
				Descriptor__96__STATIC__DTAG_maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED = Descriptor__95__STATIC__LBL_First$32$Name.get_ChildDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, true, AppSymbols.$42$1, 1, 1, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.typeinfotest.Test$__$Matrix.matrix, Descriptor__95__STATIC__LBL_First$32$Name, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.First$32$Name, null), new Pair<Object, Object>(AppSymbols_DescTag.maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the second access of the Matrix named maintests.samples.typeinfotest.Test$__$Matrix.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__96__STATIC__DTAG_maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (Descriptor)annotateRetVal;
		}



		return Descriptor__96__STATIC__DTAG_maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED;

	}






}
