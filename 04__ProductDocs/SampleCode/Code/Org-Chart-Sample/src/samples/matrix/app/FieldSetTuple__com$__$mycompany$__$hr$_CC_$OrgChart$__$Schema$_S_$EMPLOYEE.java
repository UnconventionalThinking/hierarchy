/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package samples.matrix.app;

import samples.matrix.app.AppSymbols_MatrixName;
import samples.matrix.app.AppControl;
import samples.matrix.app.AppSymbols;
import net.unconventionalthinking.matrix.Descriptor;
import net.unconventionalthinking.matrix.symbols.*;
import samples.matrix.app.AppSymbols_SchemaName;
import samples.matrix.app.AppSymbols_DescTag;
import net.unconventionalthinking.matrix.FieldSet_Worker;
import samples.matrix.app.AppSymbols_DescTagName;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.List;
import net.unconventionalthinking.exceptions.*;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.*;
import java.util.Arrays;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import java.util.ArrayList;
import java.util.Set;
import net.unconventionalthinking.matrix.FieldSet_FieldValueBucket;
import samples.matrix.app.AppSymbols_Label;
import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.FieldSet_Tuple;
import net.unconventionalthinking.matrix.FieldConstants;


public class FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE extends FieldSet_Tuple {

	//  private variables (for fields) _______________________________________________________

	String FullName;
	FieldConstants FullName__Special;
	String Title;
	FieldConstants Title__Special;


	//  Constructors _________________________________________________________________________

	public FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE(ExecutionInfo executeInfo, Descriptor parentDescriptor) {

		//  passing in 'false' to FieldSet_Tuple parent constructor so that the dynAccessed_Field List is not created.
		super(executeInfo, parentDescriptor, false);

		this.FullName__Special = null;
		this.Title__Special = null;

	}



	//  FieldSet State Methods _______________________________________________________________
	@Override
	public boolean is_SpecializedFieldSet() {
		return true;
	}


	//  get_<Field Name>(), set_<Field Name>(), and set_<Field Name>__Special() methods_______

	public String get_FullName(ExecutionInfo executeInfo) throws Exception_InvalidArgumentPassed  {

		if (FullName__Special == FieldConstants.HAS_STANDARD_VALUE) {
			executeInfo.clearResultsInfo();
			return FullName;

		} else if (FullName__Special == FieldConstants.UNUSED) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
			return (String)null;

		} else if (FullName__Special == FieldConstants.NULL) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
			return (String)null;

		} else {
			// no value was set, return default value
			Object fieldDefaultValue_Raw = 
				FieldSet_Worker.getField_DefaultValue(executeInfo, 0, schemaInfo_Positioned);
			return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
		}
	}

	public String get_Title(ExecutionInfo executeInfo) throws Exception_InvalidArgumentPassed  {

		if (Title__Special == FieldConstants.HAS_STANDARD_VALUE) {
			executeInfo.clearResultsInfo();
			return Title;

		} else if (Title__Special == FieldConstants.UNUSED) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
			return (String)null;

		} else if (Title__Special == FieldConstants.NULL) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
			return (String)null;

		} else {
			// no value was set, return default value
			Object fieldDefaultValue_Raw = 
				FieldSet_Worker.getField_DefaultValue(executeInfo, 1, schemaInfo_Positioned);
			return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
		}
	}

	public void set_FullName(ExecutionInfo executeInfo, String value) throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.FullName__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.FullName = value;
		this.FullName__Special = FieldConstants.HAS_STANDARD_VALUE;
	}
	public void set_FullName__Special(ExecutionInfo executeInfo, FieldConstants specialValue)
			throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.FullName__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.FullName__Special = specialValue;
		this.FullName = null;
	}

	public void set_Title(ExecutionInfo executeInfo, String value) throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.Title__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.Title = value;
		this.Title__Special = FieldConstants.HAS_STANDARD_VALUE;
	}
	public void set_Title__Special(ExecutionInfo executeInfo, FieldConstants specialValue)
			throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.Title__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.Title__Special = specialValue;
		this.Title = null;
	}

	@Override
	public void setField(ExecutionInfo executeInfo, DescriptorTagName fieldName, Object value) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case samples.matrix.app.AppSymbols_DescTagName.FullName$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.FullName__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.FullName = (String)value;
				this.FullName__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			case samples.matrix.app.AppSymbols_DescTagName.Title$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Title__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Title = (String)value;
				this.Title__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was setField(ExecutionInfo executeInfo, DescriptorTagName fieldName, Object value) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public void setField__Special(ExecutionInfo executeInfo, DescriptorTagName fieldName, FieldConstants specialValue) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case samples.matrix.app.AppSymbols_DescTagName.FullName$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.FullName__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.FullName__Special = specialValue;
				this.FullName = null;
				return;
			case samples.matrix.app.AppSymbols_DescTagName.Title$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Title__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Title__Special = specialValue;
				this.Title = null;
				return;
			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was setField__Special(ExecutionInfo executeInfo, DescriptorTagName fieldName, FieldConstants specialValue) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public void setField_String(ExecutionInfo executeInfo, DescriptorTagName fieldName, String value) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case samples.matrix.app.AppSymbols_DescTagName.FullName$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.FullName__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.FullName = value;
				this.FullName__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			case samples.matrix.app.AppSymbols_DescTagName.Title$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Title__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Title = value;
				this.Title__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was setField_String(ExecutionInfo executeInfo, DescriptorTagName fieldName, String value) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public Object getField(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case samples.matrix.app.AppSymbols_DescTagName.FullName$_ID_$:
				if (FullName__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return FullName;

				} else if (FullName__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return null;

				} else if (FullName__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 0, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : null;
				}

 			case samples.matrix.app.AppSymbols_DescTagName.Title$_ID_$:
				if (Title__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return Title;

				} else if (Title__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return null;

				} else if (Title__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 1, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : null;
				}

 			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was getField(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public String getField_String(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case samples.matrix.app.AppSymbols_DescTagName.FullName$_ID_$:
				if (FullName__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return FullName;

				} else if (FullName__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return (String)null;

				} else if (FullName__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return (String)null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 0, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
				}

 			case samples.matrix.app.AppSymbols_DescTagName.Title$_ID_$:
				if (Title__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return Title;

				} else if (Title__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return (String)null;

				} else if (Title__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return (String)null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 1, schemaInfo_Positioned);
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
					if (FullName__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return FullName;

					} else if (FullName__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return null;

					} else if (FullName__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 0, schemaInfo_Positioned);
						return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : null;
					}

 				case 1:
					if (Title__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return Title;

					} else if (Title__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return null;

					} else if (Title__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 1, schemaInfo_Positioned);
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
					if (FullName__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return FullName;

					} else if (FullName__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return (String)null;

					} else if (FullName__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return (String)null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 0, schemaInfo_Positioned);
						return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
					}

 				case 1:
					if (Title__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return Title;

					} else if (Title__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return (String)null;

					} else if (Title__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return (String)null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 1, schemaInfo_Positioned);
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
					if (FullName__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					FullName = (String)value;
					FullName__Special = FieldConstants.HAS_STANDARD_VALUE;
					return;


 				case 1:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (Title__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Title = (String)value;
					Title__Special = FieldConstants.HAS_STANDARD_VALUE;
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
					if (FullName__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					FullName = value;
					FullName__Special = FieldConstants.HAS_STANDARD_VALUE;
					return;


 				case 1:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (Title__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Title = value;
					Title__Special = FieldConstants.HAS_STANDARD_VALUE;
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
					if (FullName__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					FullName__Special = specialValue;
					FullName = null;
					return;


 				case 1:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (Title__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Title__Special = specialValue;
					Title = null;
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
			importsSet.add("import samples.matrix.app.AppSymbols_MatrixName;");
			importsSet.add("import samples.matrix.app.AppControl;");
			importsSet.add("import samples.matrix.app.AppSymbols;");
			importsSet.add("import net.unconventionalthinking.matrix.Descriptor;");
			importsSet.add("import net.unconventionalthinking.matrix.symbols.*;");
			importsSet.add("import samples.matrix.app.AppSymbols_SchemaName;");
			importsSet.add("import samples.matrix.app.AppSymbols_DescTag;");
			importsSet.add("import net.unconventionalthinking.matrix.FieldSet_Worker;");
			importsSet.add("import samples.matrix.app.AppSymbols_DescTagName;");
			importsSet.add("import java.util.LinkedList;");
			importsSet.add("import java.util.HashSet;");
			importsSet.add("import java.util.List;");
			importsSet.add("import net.unconventionalthinking.exceptions.*;");
			importsSet.add("import net.unconventionalthinking.matrix.symbols.Symbol;");
			importsSet.add("import net.unconventionalthinking.matrix.*;");
			importsSet.add("import java.util.Arrays;");
			importsSet.add("import net.unconventionalthinking.lang.*;");
			importsSet.add("import net.unconventionalthinking.matrix.symbols.DescriptorTagName;");
			importsSet.add("import java.util.ArrayList;");
			importsSet.add("import java.util.Set;");
			importsSet.add("import net.unconventionalthinking.matrix.FieldSet_FieldValueBucket;");
			importsSet.add("import samples.matrix.app.AppSymbols_Label;");
			importsSet.add("import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;");
			importsSet.add("import net.unconventionalthinking.lang.ExecutionInfo;");
			importsSet.add("import net.unconventionalthinking.matrix.FieldSet_Tuple;");
			importsSet.add("import net.unconventionalthinking.matrix.FieldConstants;");
		}

		return importsSet;
	}


}
