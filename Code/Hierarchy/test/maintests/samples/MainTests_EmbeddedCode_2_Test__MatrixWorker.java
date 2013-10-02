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
import org . junit . Test ;

import org . junit . After ;

import java . util . * ;

import org . junit . AfterClass ;

import static org . junit . Assert . * ;

import org . junit . BeforeClass ;

import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;



public class MainTests_EmbeddedCode_2_Test__MatrixWorker {



	public static Descriptor accessMatrix_Abstract$__$Content__226(ExecutionInfo executeInfo, MainTests_EmbeddedCode_2_Test__Annotations callerObj) {

		//  Static Descriptor Access by Static Label, People.
		Descriptor Descriptor__590__STATIC__LBL_People = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, maintests.samples.Abstract$__$Content.matrix)) {
			try{
				Descriptor__590__STATIC__LBL_People = maintests.samples.Abstract$__$Content.matrix.get_ChildDescriptor(executeInfo, AppSymbols_Label.People);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.Abstract$__$Content.matrix, maintests.samples.Abstract$__$Content.matrix, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.People, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named maintests.samples.Abstract$__$Content.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__590__STATIC__LBL_People = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (Descriptor)annotateRetVal;
		}


		//  Static Field Access by Static Descriptor Tag Name, PEOPLE.
		Descriptor Descriptor__591__STATIC__DTAGNAME_PEOPLE = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__590__STATIC__LBL_People)) {
			try{
				Descriptor__591__STATIC__DTAGNAME_PEOPLE = Descriptor__590__STATIC__LBL_People.get_ChildDescriptor(executeInfo, AppSymbols_DescTagName.PEOPLE);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 1, 1, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.Abstract$__$Content.matrix, Descriptor__590__STATIC__LBL_People, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.People, null), new Pair<Object, Object>(AppSymbols_DescTagName.PEOPLE, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the second access of the Matrix named maintests.samples.Abstract$__$Content.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__591__STATIC__DTAGNAME_PEOPLE = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (Descriptor)annotateRetVal;
		}



		return Descriptor__591__STATIC__DTAGNAME_PEOPLE;

	}





	public static MatrixSet<Descriptor> accessMatrix_Abstract$__$Content__227(ExecutionInfo executeInfo, MainTests_EmbeddedCode_2_Test__Annotations callerObj, DescriptorTagName accessParam_2__value1) {

		//  Static Descriptor Access by Static Label, People.
		Descriptor Descriptor__592__STATIC__LBL_People = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, maintests.samples.Abstract$__$Content.matrix)) {
			try{
				Descriptor__592__STATIC__LBL_People = maintests.samples.Abstract$__$Content.matrix.get_ChildDescriptor(executeInfo, AppSymbols_Label.People);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.Abstract$__$Content.matrix, maintests.samples.Abstract$__$Content.matrix, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.People, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named maintests.samples.Abstract$__$Content.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__592__STATIC__LBL_People = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (MatrixSet<Descriptor>)annotateRetVal;
		}


		//  Static Field Access by Static Descriptor Tag Name, PEOPLE.
		Descriptor Descriptor__593__STATIC__DTAGNAME_PEOPLE = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__592__STATIC__LBL_People)) {
			try{
				Descriptor__593__STATIC__DTAGNAME_PEOPLE = Descriptor__592__STATIC__LBL_People.get_ChildDescriptor(executeInfo, AppSymbols_DescTagName.PEOPLE);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 1, 1, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.Abstract$__$Content.matrix, Descriptor__592__STATIC__LBL_People, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.People, null), new Pair<Object, Object>(AppSymbols_DescTagName.PEOPLE, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the second access of the Matrix named maintests.samples.Abstract$__$Content.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__593__STATIC__DTAGNAME_PEOPLE = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (MatrixSet<Descriptor>)annotateRetVal;
		}



		//  Multi Access with access expression: AppSymbols_DescTagName.PERSON$__$INFO.
		MatrixSet<Descriptor> DescriptorSet__594__MULTI_ACCESS = new MatrixSet<Descriptor>();
		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__593__STATIC__DTAGNAME_PEOPLE)) {
			try{
				Descriptor__593__STATIC__DTAGNAME_PEOPLE.get_ChildDescriptors(executeInfo,accessParam_2__value1, DescriptorSet__594__MULTI_ACCESS);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_4(executeInfo, false, null, 2, 2, AnnotationParameters.AccessType.DescriptorSet, accessReturnType_OutParam, maintests.samples.Abstract$__$Content.matrix, Descriptor__593__STATIC__DTAGNAME_PEOPLE, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.People, null), new Pair<Object, Object>(AppSymbols_DescTagName.PEOPLE, null), new Pair<Object, Object>(accessParam_2__value1, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the third access of the Matrix named maintests.samples.Abstract$__$Content.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				DescriptorSet__594__MULTI_ACCESS = (MatrixSet<Descriptor>)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (MatrixSet<Descriptor>)annotateRetVal;
		}



		return DescriptorSet__594__MULTI_ACCESS;

	}





	public static Descriptor accessMatrixForFieldAssign_Test$__$Matrix2__228(ExecutionInfo executeInfo, MainTests_EmbeddedCode_2_Test__Annotations callerObj) {

		//  Static Descriptor Access by Static Label, field assignment test.
		Descriptor Descriptor__595__STATIC__LBL_field$32$assignment$32$test = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, maintests.samples.Test$__$Matrix2.matrix)) {
			try{
				Descriptor__595__STATIC__LBL_field$32$assignment$32$test = maintests.samples.Test$__$Matrix2.matrix.get_ChildDescriptor(executeInfo, AppSymbols_Label.field$32$assignment$32$test);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_5(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.Test$__$Matrix2.matrix, maintests.samples.Test$__$Matrix2.matrix, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.field$32$assignment$32$test, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named maintests.samples.Test$__$Matrix2.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__595__STATIC__LBL_field$32$assignment$32$test = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (Descriptor)annotateRetVal;
		}


		//  Static Field Access by Static Descriptor Tag Name, TEST$__$DESC.
		Descriptor Descriptor__596__STATIC__DTAGNAME_TEST$__$DESC = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__595__STATIC__LBL_field$32$assignment$32$test)) {
			try{
				Descriptor__596__STATIC__DTAGNAME_TEST$__$DESC = Descriptor__595__STATIC__LBL_field$32$assignment$32$test.get_ChildDescriptor(executeInfo, AppSymbols_DescTagName.TEST$__$DESC);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_5(executeInfo, false, null, 1, 1, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.Test$__$Matrix2.matrix, Descriptor__595__STATIC__LBL_field$32$assignment$32$test, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.field$32$assignment$32$test, null), new Pair<Object, Object>(AppSymbols_DescTagName.TEST$__$DESC, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the second access of the Matrix named maintests.samples.Test$__$Matrix2.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__596__STATIC__DTAGNAME_TEST$__$DESC = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (Descriptor)annotateRetVal;
		}



		return Descriptor__596__STATIC__DTAGNAME_TEST$__$DESC;

	}





	public static int accessMatrix_Test$__$Matrix2__229(ExecutionInfo executeInfo, MainTests_EmbeddedCode_2_Test__Annotations callerObj) {

		//  Static Descriptor Access by Static Label, field assignment test.
		Descriptor Descriptor__598__STATIC__LBL_field$32$assignment$32$test = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, maintests.samples.Test$__$Matrix2.matrix)) {
			try{
				Descriptor__598__STATIC__LBL_field$32$assignment$32$test = maintests.samples.Test$__$Matrix2.matrix.get_ChildDescriptor(executeInfo, AppSymbols_Label.field$32$assignment$32$test);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_5(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.Test$__$Matrix2.matrix, maintests.samples.Test$__$Matrix2.matrix, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.field$32$assignment$32$test, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named maintests.samples.Test$__$Matrix2.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__598__STATIC__LBL_field$32$assignment$32$test = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return ((Integer)annotateRetVal).intValue();
		}


		//  Static Field Access by Static Descriptor Tag Name, TEST$__$DESC.
		Descriptor Descriptor__599__STATIC__DTAGNAME_TEST$__$DESC = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__598__STATIC__LBL_field$32$assignment$32$test)) {
			try{
				Descriptor__599__STATIC__DTAGNAME_TEST$__$DESC = Descriptor__598__STATIC__LBL_field$32$assignment$32$test.get_ChildDescriptor(executeInfo, AppSymbols_DescTagName.TEST$__$DESC);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_5(executeInfo, false, null, 1, 1, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.Test$__$Matrix2.matrix, Descriptor__598__STATIC__LBL_field$32$assignment$32$test, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.field$32$assignment$32$test, null), new Pair<Object, Object>(AppSymbols_DescTagName.TEST$__$DESC, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the second access of the Matrix named maintests.samples.Test$__$Matrix2.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__599__STATIC__DTAGNAME_TEST$__$DESC = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return ((Integer)annotateRetVal).intValue();
		}



		//  Static Field Access by Static Descriptor Tag Name, testField2.
		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__599__STATIC__DTAGNAME_TEST$__$DESC)) {
			try{
				if (Descriptor__599__STATIC__DTAGNAME_TEST$__$DESC.has_FieldSet()) {
					return ((maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Test$__$Schema$_S_$TEST$__$DESC)Descriptor__599__STATIC__DTAGNAME_TEST$__$DESC.get_FieldSet()).get_testField2(executeInfo);
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
		Object annotateRetVal = callerObj.annotationHandler_5(executeInfo, false, null, 2, 2, AnnotationParameters.AccessType.Field, accessReturnType_OutParam, maintests.samples.Test$__$Matrix2.matrix, Descriptor__599__STATIC__DTAGNAME_TEST$__$DESC, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.field$32$assignment$32$test, null), new Pair<Object, Object>(AppSymbols_DescTagName.TEST$__$DESC, null), new Pair<Object, Object>(AppSymbols_DescTagName.testField2, null));

		if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
			throw new ExceptRuntime_MatrixAccessError("Was trying the third access of the Matrix named maintests.samples.Test$__$Matrix2.matrix but had an error. The annotation handler tried to process this error but was not able to.");

		return ((Integer)annotateRetVal).intValue();

	}





	public static Descriptor accessMatrix_Test$__$Matrix2__230(ExecutionInfo executeInfo, MainTests_EmbeddedCode_2_Test__Annotations callerObj) {

		//  Static Descriptor Access by Static Label, field assignment test.
		Descriptor Descriptor__601__STATIC__LBL_field$32$assignment$32$test = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, maintests.samples.Test$__$Matrix2.matrix)) {
			try{
				Descriptor__601__STATIC__LBL_field$32$assignment$32$test = maintests.samples.Test$__$Matrix2.matrix.get_ChildDescriptor(executeInfo, AppSymbols_Label.field$32$assignment$32$test);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_5(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.Test$__$Matrix2.matrix, maintests.samples.Test$__$Matrix2.matrix, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.field$32$assignment$32$test, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named maintests.samples.Test$__$Matrix2.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__601__STATIC__LBL_field$32$assignment$32$test = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (Descriptor)annotateRetVal;
		}


		//  Static Field Access by Static Descriptor Tag Name, TEST$__$DESC.
		Descriptor Descriptor__602__STATIC__DTAGNAME_TEST$__$DESC = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__601__STATIC__LBL_field$32$assignment$32$test)) {
			try{
				Descriptor__602__STATIC__DTAGNAME_TEST$__$DESC = Descriptor__601__STATIC__LBL_field$32$assignment$32$test.get_ChildDescriptor(executeInfo, AppSymbols_DescTagName.TEST$__$DESC);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_5(executeInfo, false, null, 1, 1, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.Test$__$Matrix2.matrix, Descriptor__601__STATIC__LBL_field$32$assignment$32$test, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.field$32$assignment$32$test, null), new Pair<Object, Object>(AppSymbols_DescTagName.TEST$__$DESC, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the second access of the Matrix named maintests.samples.Test$__$Matrix2.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__602__STATIC__DTAGNAME_TEST$__$DESC = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (Descriptor)annotateRetVal;
		}



		return Descriptor__602__STATIC__DTAGNAME_TEST$__$DESC;

	}





	//  Continued Access
	public static Descriptor accessMatrixForFieldAssign___231(ExecutionInfo executeInfo, Descriptor descriptor, MainTests_EmbeddedCode_2_Test__Annotations callerObj) {


		return descriptor;

	}





	//  Continued Access
	public static int accessMatrix___232(ExecutionInfo executeInfo, Descriptor descriptor, MainTests_EmbeddedCode_2_Test__Annotations callerObj) {


		//  Static Field Access by Static Descriptor Tag Name, testField2.
		if (DescriptorUtilities.validDescriptors(executeInfo, descriptor)) {
			try{
				if (descriptor.has_FieldSet()) {
					return ((maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Test$__$Schema$_S_$TEST$__$DESC)descriptor.get_FieldSet()).get_testField2(executeInfo);
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
		Object annotateRetVal = callerObj.annotationHandler_5(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Field, accessReturnType_OutParam, descriptor, descriptor, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_DescTagName.testField2, null));

		if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
			throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named descriptor but had an error. The annotation handler tried to process this error but was not able to.");

		return ((Integer)annotateRetVal).intValue();

	}





	public static Descriptor accessMatrix_Test$__$Matrix2__233(ExecutionInfo executeInfo, MainTests_EmbeddedCode_2_Test__Annotations callerObj) {

		//  Static Descriptor Access by Static Label, field assignment test.
		Descriptor Descriptor__605__STATIC__LBL_field$32$assignment$32$test = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, maintests.samples.Test$__$Matrix2.matrix)) {
			try{
				Descriptor__605__STATIC__LBL_field$32$assignment$32$test = maintests.samples.Test$__$Matrix2.matrix.get_ChildDescriptor(executeInfo, AppSymbols_Label.field$32$assignment$32$test);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_5(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.Test$__$Matrix2.matrix, maintests.samples.Test$__$Matrix2.matrix, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.field$32$assignment$32$test, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named maintests.samples.Test$__$Matrix2.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__605__STATIC__LBL_field$32$assignment$32$test = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (Descriptor)annotateRetVal;
		}



		return Descriptor__605__STATIC__LBL_field$32$assignment$32$test;

	}





	//  Continued Access
	public static Descriptor accessMatrixForFieldAssign___234(ExecutionInfo executeInfo, Descriptor descriptor, MainTests_EmbeddedCode_2_Test__Annotations callerObj) {

		//  Static Field Access by Static Descriptor Tag Name, TEST$__$DESC.
		Descriptor Descriptor__606__STATIC__DTAGNAME_TEST$__$DESC = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, descriptor)) {
			try{
				Descriptor__606__STATIC__DTAGNAME_TEST$__$DESC = descriptor.get_ChildDescriptor(executeInfo, AppSymbols_DescTagName.TEST$__$DESC);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_5(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, descriptor, descriptor, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_DescTagName.TEST$__$DESC, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named descriptor but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__606__STATIC__DTAGNAME_TEST$__$DESC = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return (Descriptor)annotateRetVal;
		}



		return Descriptor__606__STATIC__DTAGNAME_TEST$__$DESC;

	}





	public static int accessMatrix_Test$__$Matrix2__235(ExecutionInfo executeInfo, MainTests_EmbeddedCode_2_Test__Annotations callerObj) {

		//  Static Descriptor Access by Static Label, test item.
		Descriptor Descriptor__608__STATIC__LBL_test$32$item = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, maintests.samples.Test$__$Matrix2.matrix)) {
			try{
				Descriptor__608__STATIC__LBL_test$32$item = maintests.samples.Test$__$Matrix2.matrix.get_ChildDescriptor(executeInfo, AppSymbols_Label.test$32$item);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_5(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.Test$__$Matrix2.matrix, maintests.samples.Test$__$Matrix2.matrix, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.test$32$item, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named maintests.samples.Test$__$Matrix2.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__608__STATIC__LBL_test$32$item = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return ((Integer)annotateRetVal).intValue();
		}


		//  Static Field Access by Static Descriptor Tag Name, TEST$__$DESC.
		Descriptor Descriptor__609__STATIC__DTAGNAME_TEST$__$DESC = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__608__STATIC__LBL_test$32$item)) {
			try{
				Descriptor__609__STATIC__DTAGNAME_TEST$__$DESC = Descriptor__608__STATIC__LBL_test$32$item.get_ChildDescriptor(executeInfo, AppSymbols_DescTagName.TEST$__$DESC);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_5(executeInfo, false, null, 1, 1, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.Test$__$Matrix2.matrix, Descriptor__608__STATIC__LBL_test$32$item, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.test$32$item, null), new Pair<Object, Object>(AppSymbols_DescTagName.TEST$__$DESC, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the second access of the Matrix named maintests.samples.Test$__$Matrix2.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__609__STATIC__DTAGNAME_TEST$__$DESC = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return ((Integer)annotateRetVal).intValue();
		}



		//  Static Field Access by Static Descriptor Tag Name, testField2.
		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__609__STATIC__DTAGNAME_TEST$__$DESC)) {
			try{
				if (Descriptor__609__STATIC__DTAGNAME_TEST$__$DESC.has_FieldSet()) {
					return ((maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Test$__$Schema$_S_$TEST$__$DESC)Descriptor__609__STATIC__DTAGNAME_TEST$__$DESC.get_FieldSet()).get_testField2(executeInfo);
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
		Object annotateRetVal = callerObj.annotationHandler_5(executeInfo, false, null, 2, 2, AnnotationParameters.AccessType.Field, accessReturnType_OutParam, maintests.samples.Test$__$Matrix2.matrix, Descriptor__609__STATIC__DTAGNAME_TEST$__$DESC, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.test$32$item, null), new Pair<Object, Object>(AppSymbols_DescTagName.TEST$__$DESC, null), new Pair<Object, Object>(AppSymbols_DescTagName.testField2, null));

		if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
			throw new ExceptRuntime_MatrixAccessError("Was trying the third access of the Matrix named maintests.samples.Test$__$Matrix2.matrix but had an error. The annotation handler tried to process this error but was not able to.");

		return ((Integer)annotateRetVal).intValue();

	}





	public static int accessMatrix_Test$__$Matrix2__236(ExecutionInfo executeInfo, MainTests_EmbeddedCode_2_Test__Annotations callerObj) {

		//  Static Descriptor Access by Static Label, field assignment test.
		Descriptor Descriptor__611__STATIC__LBL_field$32$assignment$32$test = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, maintests.samples.Test$__$Matrix2.matrix)) {
			try{
				Descriptor__611__STATIC__LBL_field$32$assignment$32$test = maintests.samples.Test$__$Matrix2.matrix.get_ChildDescriptor(executeInfo, AppSymbols_Label.field$32$assignment$32$test);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_5(executeInfo, false, null, 0, 0, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.Test$__$Matrix2.matrix, maintests.samples.Test$__$Matrix2.matrix, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.field$32$assignment$32$test, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the first access of the Matrix named maintests.samples.Test$__$Matrix2.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__611__STATIC__LBL_field$32$assignment$32$test = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return ((Integer)annotateRetVal).intValue();
		}


		//  Static Field Access by Static Descriptor Tag Name, TEST$__$DESC.
		Descriptor Descriptor__612__STATIC__DTAGNAME_TEST$__$DESC = null;

		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__611__STATIC__LBL_field$32$assignment$32$test)) {
			try{
				Descriptor__612__STATIC__DTAGNAME_TEST$__$DESC = Descriptor__611__STATIC__LBL_field$32$assignment$32$test.get_ChildDescriptor(executeInfo, AppSymbols_DescTagName.TEST$__$DESC);
			} catch (Exception e) {
				executeInfo.setErrorException(e);
			}

		} else { // end of if (validDescriptors())
			executeInfo.addErrorInfo(ExecutionInfo.ErrorType.AccessedDescriptorThatWasNotFound);
		}

		// Error handling code
		if (executeInfo.get_HadError()) {
			AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam = new AnnotationParameters_AccessReturnType_OutParam();
			Object annotateRetVal = callerObj.annotationHandler_5(executeInfo, false, null, 1, 1, AnnotationParameters.AccessType.Descriptor, accessReturnType_OutParam, maintests.samples.Test$__$Matrix2.matrix, Descriptor__611__STATIC__LBL_field$32$assignment$32$test, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.field$32$assignment$32$test, null), new Pair<Object, Object>(AppSymbols_DescTagName.TEST$__$DESC, null));

			if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
				throw new ExceptRuntime_MatrixAccessError("Was trying the second access of the Matrix named maintests.samples.Test$__$Matrix2.matrix but had an error. The annotation handler tried to process this error but was not able to.");

			if (accessReturnType_OutParam != null && accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessorValue)
				Descriptor__612__STATIC__DTAGNAME_TEST$__$DESC = (Descriptor)annotateRetVal;
			else // accessReturnType_OutParam.returnType == AnnotationParameters.AccessReturnType.accessValue)
				return ((Integer)annotateRetVal).intValue();
		}



		//  Static Field Access by Static Descriptor Tag Name, testField2.
		if (DescriptorUtilities.validDescriptors(executeInfo, Descriptor__612__STATIC__DTAGNAME_TEST$__$DESC)) {
			try{
				if (Descriptor__612__STATIC__DTAGNAME_TEST$__$DESC.has_FieldSet()) {
					return ((maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Test$__$Schema$_S_$TEST$__$DESC)Descriptor__612__STATIC__DTAGNAME_TEST$__$DESC.get_FieldSet()).get_testField2(executeInfo);
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
		Object annotateRetVal = callerObj.annotationHandler_5(executeInfo, false, null, 2, 2, AnnotationParameters.AccessType.Field, accessReturnType_OutParam, maintests.samples.Test$__$Matrix2.matrix, Descriptor__612__STATIC__DTAGNAME_TEST$__$DESC, null, true, executeInfo.getErrorException(), new Pair<Object, Object>(AppSymbols_Label.field$32$assignment$32$test, null), new Pair<Object, Object>(AppSymbols_DescTagName.TEST$__$DESC, null), new Pair<Object, Object>(AppSymbols_DescTagName.testField2, null));

		if (executeInfo.get_HadError() && executeInfo.containsError(ExecutionInfo.ErrorType.AbortAccess)) 
			throw new ExceptRuntime_MatrixAccessError("Was trying the third access of the Matrix named maintests.samples.Test$__$Matrix2.matrix but had an error. The annotation handler tried to process this error but was not able to.");

		return ((Integer)annotateRetVal).intValue();

	}






}
