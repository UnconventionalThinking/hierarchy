/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package maintests.samples.typeinfotest;

import maintests.samples.typeinfotest.AppSymbols_Label;
import maintests.samples.typeinfotest.AppSymbols_DescTag;
import net.unconventionalthinking.matrix.Descriptor;
import net.unconventionalthinking.matrix.symbols.*;
import maintests.samples.typeinfotest.AppSymbols_MatrixName;
import maintests.samples.typeinfotest.AppSymbols_SchemaName;
import net.unconventionalthinking.matrix.FieldSet_Worker;
import java.util.LinkedList;
import maintests.samples.typeinfotest.AppSymbols;
import java.util.HashSet;
import java.util.List;
import net.unconventionalthinking.exceptions.*;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.*;
import java.util.Arrays;
import maintests.samples.typeinfotest.AppControl;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import java.util.ArrayList;
import java.util.Set;
import net.unconventionalthinking.matrix.FieldSet_FieldValueBucket;
import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.FieldSet_Tuple;
import net.unconventionalthinking.matrix.FieldConstants;
import maintests.samples.typeinfotest.AppSymbols_DescTagName;


public class FieldSetTuple__maintests$__$samples$__$typeinfotest$__$anotherpackage$_CC_$Test$__$Schema$_S_$TEST$__$DESC$_S_$CHILD$__$DESC extends FieldSet_Tuple {

	//  private variables (for fields) _______________________________________________________

	String testField1;
	FieldConstants testField1__Special;


	//  Constructors _________________________________________________________________________

	public FieldSetTuple__maintests$__$samples$__$typeinfotest$__$anotherpackage$_CC_$Test$__$Schema$_S_$TEST$__$DESC$_S_$CHILD$__$DESC(ExecutionInfo executeInfo, Descriptor parentDescriptor) {

		//  passing in 'false' to FieldSet_Tuple parent constructor so that the dynAccessed_Field List is not created.
		super(executeInfo, parentDescriptor, false);

		this.testField1__Special = null;

	}



	//  FieldSet State Methods _______________________________________________________________
	@Override
	public boolean is_SpecializedFieldSet() {
		return true;
	}


	//  get_<Field Name>(), set_<Field Name>(), and set_<Field Name>__Special() methods_______

	public String get_testField1(ExecutionInfo executeInfo) throws Exception_InvalidArgumentPassed  {

		if (testField1__Special == FieldConstants.HAS_STANDARD_VALUE) {
			executeInfo.clearResultsInfo();
			return testField1;

		} else if (testField1__Special == FieldConstants.UNUSED) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
			return (String)null;

		} else if (testField1__Special == FieldConstants.NULL) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
			return (String)null;

		} else {
			// no value was set, return default value
			Object fieldDefaultValue_Raw = 
				FieldSet_Worker.getField_DefaultValue(executeInfo, 0, schemaInfo_Positioned);
			return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
		}
	}

	public void set_testField1(ExecutionInfo executeInfo, String value) throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.testField1__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.testField1 = value;
		this.testField1__Special = FieldConstants.HAS_STANDARD_VALUE;
	}
	public void set_testField1__Special(ExecutionInfo executeInfo, FieldConstants specialValue)
			throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.testField1__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.testField1__Special = specialValue;
		this.testField1 = null;
	}

	@Override
	public void setField(ExecutionInfo executeInfo, DescriptorTagName fieldName, Object value) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case maintests.samples.typeinfotest.AppSymbols_DescTagName.testField1$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.testField1__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.testField1 = (String)value;
				this.testField1__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was setField(ExecutionInfo executeInfo, DescriptorTagName fieldName, Object value) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public void setField__Special(ExecutionInfo executeInfo, DescriptorTagName fieldName, FieldConstants specialValue) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case maintests.samples.typeinfotest.AppSymbols_DescTagName.testField1$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.testField1__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.testField1__Special = specialValue;
				this.testField1 = null;
				return;
			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was setField__Special(ExecutionInfo executeInfo, DescriptorTagName fieldName, FieldConstants specialValue) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public void setField_String(ExecutionInfo executeInfo, DescriptorTagName fieldName, String value) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case maintests.samples.typeinfotest.AppSymbols_DescTagName.testField1$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.testField1__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.testField1 = value;
				this.testField1__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was setField_String(ExecutionInfo executeInfo, DescriptorTagName fieldName, String value) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public Object getField(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case maintests.samples.typeinfotest.AppSymbols_DescTagName.testField1$_ID_$:
				if (testField1__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return testField1;

				} else if (testField1__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return null;

				} else if (testField1__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 0, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : null;
				}

 			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was getField(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public String getField_String(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case maintests.samples.typeinfotest.AppSymbols_DescTagName.testField1$_ID_$:
				if (testField1__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return testField1;

				} else if (testField1__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return (String)null;

				} else if (testField1__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return (String)null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 0, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
				}

 			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was getField_String(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}



	//  getField(index), setField(index), and set_<Field>__Special(index) methods_____________

	//  These two methods just call the setField()'s with no symbol type
	@Override
	public void setField(ExecutionInfo executeInfo, int index, Object value, Symbol typeSymbol) throws Exception_InvalidArgumentPassed {
		setField(executeInfo, index, value);
	}

	@Override
	public void setField(ExecutionInfo executeInfo, DescriptorTagName fieldName, Object value, Symbol typeSymbol) throws Exception_InvalidArgumentPassed {
		setField(executeInfo, fieldName, value);
	}


	@Override
	public Object getField(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed {

		if (index < schemaInfo_Positioned.getNum_NonContinuationFields()) {
			switch (index) {
				case 0:
					if (testField1__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return testField1;

					} else if (testField1__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return null;

					} else if (testField1__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 0, schemaInfo_Positioned);
						return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : null;
					}

 				default: // Error, invalid index;
 					throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid index for the method, getField(ExecutionInfo executeInfo, int index). The index that was passed was, " + index +  ", and there is no field of the correct type.");
			} // end of switch


		} else { 
			throw new Exception_InvalidArgumentPassed("Tried to access the field with an index larger than the actual number of field values. The index that was passed in was,  The index that was passed was, " + index +  ". And the number of elements in this fields set is: " + fieldValue_TotalCount);
		}

	}

	@Override
	public String getField_String(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed {

		if (index < schemaInfo_Positioned.getNum_NonContinuationFields()) {
			switch (index) {
				case 0:
					if (testField1__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return testField1;

					} else if (testField1__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return (String)null;

					} else if (testField1__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return (String)null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 0, schemaInfo_Positioned);
						return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
					}

 				default: // Error, invalid index;
 					throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid index for the method, getField_String(ExecutionInfo executeInfo, int index). The index that was passed was, " + index +  ", and there is no field of the correct type.");
			} // end of switch


		} else { 
			throw new Exception_InvalidArgumentPassed("Tried to access the field with an index larger than the actual number of field values. The index that was passed in was,  The index that was passed was, " + index +  ". And the number of elements in this fields set is: " + fieldValue_TotalCount);
		}

	}

	@Override
	public void setField(ExecutionInfo executeInfo, int index, Object value) throws Exception_InvalidArgumentPassed {

		if (index < schemaInfo_Positioned.getNum_NonContinuationFields()) {
			switch (index) {
				case 0:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (testField1__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					testField1 = (String)value;
					testField1__Special = FieldConstants.HAS_STANDARD_VALUE;
					return;


 				default: // Error, invalid index;
 					throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid index for the method, getField(ExecutionInfo executeInfo, int index). The index that was passed was, " + index +  ", and there is no field of the correct type.");
			} // end of switch


		} else { 
			//  error
			throw new Exception_InvalidArgumentPassed("Tried to access the field with an index larger than the actual number of field values. The index that was passed in was,  The index that was passed was, " + index +  ". And the number of elements in this fields set is: " + fieldValue_TotalCount);
		}

	}

	@Override
	public void setField_String(ExecutionInfo executeInfo, int index, String value) throws Exception_InvalidArgumentPassed {

		if (index < schemaInfo_Positioned.getNum_NonContinuationFields()) {
			switch (index) {
				case 0:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (testField1__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					testField1 = value;
					testField1__Special = FieldConstants.HAS_STANDARD_VALUE;
					return;


 				default: // Error, invalid index;
 					throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid index for the method, getField_String(ExecutionInfo executeInfo, int index). The index that was passed was, " + index +  ", and there is no field of the correct type.");
			} // end of switch


		} else { 
			//  error
			throw new Exception_InvalidArgumentPassed("Tried to access the field with an index larger than the actual number of field values. The index that was passed in was,  The index that was passed was, " + index +  ". And the number of elements in this fields set is: " + fieldValue_TotalCount);
		}

	}

	@Override
	public void setField__Special(ExecutionInfo executeInfo, int index, FieldConstants specialValue) throws Exception_InvalidArgumentPassed {

		if (index < schemaInfo_Positioned.getNum_NonContinuationFields()) {
			switch (index) {
				case 0:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (testField1__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					testField1__Special = specialValue;
					testField1 = null;
					return;


 				default: // Error, invalid index;
 					throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid index for the method, getField(ExecutionInfo executeInfo, int index). The index that was passed was, " + index +  ", and there is no field of the correct type.");
			} // end of switch


		} else { 
			//  error
			throw new Exception_InvalidArgumentPassed("Tried to access the field with an index larger than the actual number of field values. The index that was passed in was,  The index that was passed was, " + index +  ". And the number of elements in this fields set is: " + fieldValue_TotalCount);
		}

	}



	//  Public static methods ____________________________________________________

	private static Set<String> importsSet;

	/** This method returns the set of imports that were used for this specialized fieldset. This is used in the metacompiler when generating 	    fieldsets for schemas in external jars, to generate the import list. */
	public static Set<String> getImportsSet() {

		if (importsSet == null ) {
			importsSet = new HashSet<String>();
			importsSet.add("import maintests.samples.typeinfotest.AppSymbols_Label;");
			importsSet.add("import maintests.samples.typeinfotest.AppSymbols_DescTag;");
			importsSet.add("import net.unconventionalthinking.matrix.Descriptor;");
			importsSet.add("import net.unconventionalthinking.matrix.symbols.*;");
			importsSet.add("import maintests.samples.typeinfotest.AppSymbols_MatrixName;");
			importsSet.add("import maintests.samples.typeinfotest.AppSymbols_SchemaName;");
			importsSet.add("import net.unconventionalthinking.matrix.FieldSet_Worker;");
			importsSet.add("import java.util.LinkedList;");
			importsSet.add("import maintests.samples.typeinfotest.AppSymbols;");
			importsSet.add("import java.util.HashSet;");
			importsSet.add("import java.util.List;");
			importsSet.add("import net.unconventionalthinking.exceptions.*;");
			importsSet.add("import net.unconventionalthinking.matrix.symbols.Symbol;");
			importsSet.add("import net.unconventionalthinking.matrix.*;");
			importsSet.add("import java.util.Arrays;");
			importsSet.add("import maintests.samples.typeinfotest.AppControl;");
			importsSet.add("import net.unconventionalthinking.lang.*;");
			importsSet.add("import net.unconventionalthinking.matrix.symbols.DescriptorTagName;");
			importsSet.add("import java.util.ArrayList;");
			importsSet.add("import java.util.Set;");
			importsSet.add("import net.unconventionalthinking.matrix.FieldSet_FieldValueBucket;");
			importsSet.add("import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;");
			importsSet.add("import net.unconventionalthinking.lang.ExecutionInfo;");
			importsSet.add("import net.unconventionalthinking.matrix.FieldSet_Tuple;");
			importsSet.add("import net.unconventionalthinking.matrix.FieldConstants;");
			importsSet.add("import maintests.samples.typeinfotest.AppSymbols_DescTagName;");
		}

		return importsSet;
	}


}
