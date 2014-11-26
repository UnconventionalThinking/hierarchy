/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package maintests.samples.typeinfotest;

import net.unconventionalthinking.exceptions.*;

import org . junit . After ;

import org . junit . AfterClass ;

import org . junit . BeforeClass ;

import net.unconventionalthinking.lang.*;
import org . junit . Before ;

import net.unconventionalthinking.matrix.*;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import org . junit . Test ;

import static org . junit . Assert . * ;

import java . util . * ;




public class EmbeddedCodeTest_ImportedPackage_Test__MatrixWorker {



	public static String accessMatrix_Test$__$Matrix3__23(ExecutionInfo executeInfo, EmbeddedCodeTest_ImportedPackage_Test__Annotations callerObj) {

		//  Static Descriptor Access by Static Label, First Name.
		Descriptor Descriptor__102__STATIC__LBL_First$32$Name = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, maintests.samples.typeinfotest.anotherpackage.Test$__$Matrix3.matrix)) {
			try{
				Descriptor__102__STATIC__LBL_First$32$Name = maintests.samples.typeinfotest.anotherpackage.Test$__$Matrix3.matrix.get_ChildDescriptor(executeInfo, AppSymbols_Label.First$32$Name);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.typeinfotest.anotherpackage.Test$__$Matrix3.matrix, maintests.samples.typeinfotest.anotherpackage.Test$__$Matrix3.matrix, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.First$32$Name, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named maintests.samples.typeinfotest.anotherpackage.Test$__$Matrix3.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__102__STATIC__LBL_First$32$Name = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (String)annotateRetVal;
		}


		//  Static Field Access by Static Descriptor Tag Name, FORM$__$REQUIRED.
		Descriptor Descriptor__103__STATIC__DTAGNAME_FORM$__$REQUIRED = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__102__STATIC__LBL_First$32$Name)) {
			try{
				Descriptor__103__STATIC__DTAGNAME_FORM$__$REQUIRED = Descriptor__102__STATIC__LBL_First$32$Name.get_ChildDescriptor(executeInfo, AppSymbols_DescTagName.FORM$__$REQUIRED);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 1, 1, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.typeinfotest.anotherpackage.Test$__$Matrix3.matrix, Descriptor__102__STATIC__LBL_First$32$Name, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.First$32$Name, null), new Pair<Object, Object>(AppSymbols_DescTagName.FORM$__$REQUIRED, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the second access of the Matrix named maintests.samples.typeinfotest.anotherpackage.Test$__$Matrix3.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__103__STATIC__DTAGNAME_FORM$__$REQUIRED = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (String)annotateRetVal;
		}



		//  Static Field Access by Static Descriptor Tag Name, RequiredImagePath.
		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__103__STATIC__DTAGNAME_FORM$__$REQUIRED)) {
			try{
				if (Descriptor__103__STATIC__DTAGNAME_FORM$__$REQUIRED.has_FieldSet()) {
					return ((maintests.samples.typeinfotest.FieldSetTuple__maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)Descriptor__103__STATIC__DTAGNAME_FORM$__$REQUIRED.get_FieldSet()).get_RequiredImagePath(executeInfo);
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
		Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 2, 2, AnnotationParameters.AccessType.Field, accessReturnType_OutParam, maintests.samples.typeinfotest.anotherpackage.Test$__$Matrix3.matrix, Descriptor__103__STATIC__DTAGNAME_FORM$__$REQUIRED, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.First$32$Name, null), new Pair<Object, Object>(AppSymbols_DescTagName.FORM$__$REQUIRED, null), new Pair<Object, Object>(AppSymbols_DescTagName.RequiredImagePath, null));

		if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
			throw new ExceptRuntime_MatrixAccessError("Was trying the third access of the Matrix named maintests.samples.typeinfotest.anotherpackage.Test$__$Matrix3.matrix but had an error. The annotation handler tried to process this error but was not able to.");

		return (String)annotateRetVal;

	}





	public static Descriptor accessMatrix_Test$__$Matrix3__24(ExecutionInfo executeInfo, EmbeddedCodeTest_ImportedPackage_Test__Annotations callerObj) {

		//  Static Descriptor Access by Static Label, First Name.
		Descriptor Descriptor__105__STATIC__LBL_First$32$Name = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, maintests.samples.typeinfotest.anotherpackage.Test$__$Matrix3.matrix)) {
			try{
				Descriptor__105__STATIC__LBL_First$32$Name = maintests.samples.typeinfotest.anotherpackage.Test$__$Matrix3.matrix.get_ChildDescriptor(executeInfo, AppSymbols_Label.First$32$Name);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, true, AppSymbols.$42$1, 0, 0, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.typeinfotest.anotherpackage.Test$__$Matrix3.matrix, maintests.samples.typeinfotest.anotherpackage.Test$__$Matrix3.matrix, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.First$32$Name, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named maintests.samples.typeinfotest.anotherpackage.Test$__$Matrix3.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__105__STATIC__LBL_First$32$Name = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (Descriptor)annotateRetVal;
		}


		//  Static Descriptor Access by Static Descriptor Tag, maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED.
		Descriptor Descriptor__106__STATIC__DTAG_maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__105__STATIC__LBL_First$32$Name)) {
			try{
				Descriptor__106__STATIC__DTAG_maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED = Descriptor__105__STATIC__LBL_First$32$Name.get_ChildDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, true, AppSymbols.$42$1, 1, 1, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.typeinfotest.anotherpackage.Test$__$Matrix3.matrix, Descriptor__105__STATIC__LBL_First$32$Name, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.First$32$Name, null), new Pair<Object, Object>(AppSymbols_DescTag.maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the second access of the Matrix named maintests.samples.typeinfotest.anotherpackage.Test$__$Matrix3.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__106__STATIC__DTAG_maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (Descriptor)annotateRetVal;
		}



		return Descriptor__106__STATIC__DTAG_maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED;

	}






}
