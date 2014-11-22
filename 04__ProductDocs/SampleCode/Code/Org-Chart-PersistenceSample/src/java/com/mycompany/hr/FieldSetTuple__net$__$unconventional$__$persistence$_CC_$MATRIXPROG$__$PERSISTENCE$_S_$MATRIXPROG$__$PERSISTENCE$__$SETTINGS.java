/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package com.mycompany.hr;

import com.mycompany.hr.AppControl;
import com.mycompany.hr.AppSymbols;
import com.mycompany.hr.AppSymbols_MatrixName;
import net.unconventionalthinking.matrix.Descriptor;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.matrix.FieldSet_Worker;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.List;
import com.mycompany.hr.AppSymbols_DescTag;
import net.unconventionalthinking.exceptions.*;
import net.unconventionalthinking.matrix.symbols.Symbol;
import com.mycompany.hr.AppSymbols_Label;
import com.mycompany.hr.AppSymbols_SchemaName;
import net.unconventionalthinking.matrix.*;
import java.util.Arrays;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import com.mycompany.hr.AppSymbols_DescTagName;
import java.util.ArrayList;
import java.util.Set;
import net.unconventionalthinking.matrix.FieldSet_FieldValueBucket;
import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.FieldSet_Tuple;
import net.unconventionalthinking.matrix.FieldConstants;


public class FieldSetTuple__net$__$unconventional$__$persistence$_CC_$MATRIXPROG$__$PERSISTENCE$_S_$MATRIXPROG$__$PERSISTENCE$__$SETTINGS extends FieldSet_Tuple {

	//  private variables (for fields) _______________________________________________________

	Symbol IsPersistentMatrix;
	FieldConstants IsPersistentMatrix__Special;


	//  Constructors _________________________________________________________________________

	public FieldSetTuple__net$__$unconventional$__$persistence$_CC_$MATRIXPROG$__$PERSISTENCE$_S_$MATRIXPROG$__$PERSISTENCE$__$SETTINGS(ExecutionInfo executeInfo, Descriptor parentDescriptor) {

		//  passing in 'false' to FieldSet_Tuple parent constructor so that the dynAccessed_Field List is not created.
		super(executeInfo, parentDescriptor, false);

		this.IsPersistentMatrix__Special = null;

	}



	//  FieldSet State Methods _______________________________________________________________
	@Override
	public boolean is_SpecializedFieldSet() {
		return true;
	}


	//  get_<Field Name>(), set_<Field Name>(), and set_<Field Name>__Special() methods_______

	public Symbol get_IsPersistentMatrix(ExecutionInfo executeInfo) throws Exception_InvalidArgumentPassed  {

		if (IsPersistentMatrix__Special == FieldConstants.HAS_STANDARD_VALUE) {
			executeInfo.clearResultsInfo();
			return IsPersistentMatrix;

		} else if (IsPersistentMatrix__Special == FieldConstants.UNUSED) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
			return (Symbol)null;

		} else if (IsPersistentMatrix__Special == FieldConstants.NULL) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
			return (Symbol)null;

		} else {
			// no value was set, return default value
			Object fieldDefaultValue_Raw = 
				FieldSet_Worker.getField_DefaultValue(executeInfo, 0, schemaInfo_Positioned);
			return (fieldDefaultValue_Raw != null) ? (Symbol)fieldDefaultValue_Raw : (Symbol)null;
		}
	}

	public void set_IsPersistentMatrix(ExecutionInfo executeInfo, Symbol value) throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.IsPersistentMatrix__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.IsPersistentMatrix = value;
		this.IsPersistentMatrix__Special = FieldConstants.HAS_STANDARD_VALUE;
	}
	public void set_IsPersistentMatrix__Special(ExecutionInfo executeInfo, FieldConstants specialValue)
			throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.IsPersistentMatrix__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.IsPersistentMatrix__Special = specialValue;
		this.IsPersistentMatrix = null;
	}

	@Override
	public void setField(ExecutionInfo executeInfo, DescriptorTagName fieldName, Object value) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case com.mycompany.hr.AppSymbols_DescTagName.IsPersistentMatrix$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.IsPersistentMatrix__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.IsPersistentMatrix = (Symbol)value;
				this.IsPersistentMatrix__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was setField(ExecutionInfo executeInfo, DescriptorTagName fieldName, Object value) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public void setField__Special(ExecutionInfo executeInfo, DescriptorTagName fieldName, FieldConstants specialValue) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case com.mycompany.hr.AppSymbols_DescTagName.IsPersistentMatrix$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.IsPersistentMatrix__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.IsPersistentMatrix__Special = specialValue;
				this.IsPersistentMatrix = null;
				return;
			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was setField__Special(ExecutionInfo executeInfo, DescriptorTagName fieldName, FieldConstants specialValue) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public void setField_Symbol(ExecutionInfo executeInfo, DescriptorTagName fieldName, Symbol value) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case com.mycompany.hr.AppSymbols_DescTagName.IsPersistentMatrix$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.IsPersistentMatrix__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.IsPersistentMatrix = value;
				this.IsPersistentMatrix__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was setField_Symbol(ExecutionInfo executeInfo, DescriptorTagName fieldName, Symbol value) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public Object getField(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case com.mycompany.hr.AppSymbols_DescTagName.IsPersistentMatrix$_ID_$:
				if (IsPersistentMatrix__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return IsPersistentMatrix;

				} else if (IsPersistentMatrix__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return null;

				} else if (IsPersistentMatrix__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 0, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (Symbol)fieldDefaultValue_Raw : null;
				}

 			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was getField(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public Symbol getField_Symbol(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case com.mycompany.hr.AppSymbols_DescTagName.IsPersistentMatrix$_ID_$:
				if (IsPersistentMatrix__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return IsPersistentMatrix;

				} else if (IsPersistentMatrix__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return (Symbol)null;

				} else if (IsPersistentMatrix__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return (Symbol)null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 0, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (Symbol)fieldDefaultValue_Raw : (Symbol)null;
				}

 			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was getField_Symbol(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
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
					if (IsPersistentMatrix__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return IsPersistentMatrix;

					} else if (IsPersistentMatrix__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return null;

					} else if (IsPersistentMatrix__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 0, schemaInfo_Positioned);
						return (fieldDefaultValue_Raw != null) ? (Symbol)fieldDefaultValue_Raw : null;
					}

 				default: // Error, invalid index;
 					throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid index for the method, getField(ExecutionInfo executeInfo, int index). The index that was passed was, " + index +  ", and there is no field of the correct type.");
			} // end of switch


		} else { 
			throw new Exception_InvalidArgumentPassed("Tried to access the field with an index larger than the actual number of field values. The index that was passed in was,  The index that was passed was, " + index +  ". And the number of elements in this fields set is: " + fieldValue_TotalCount);
		}

	}

	@Override
	public Symbol getField_Symbol(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed {

		if (index < schemaInfo_Positioned.getNum_NonContinuationFields()) {
			switch (index) {
				case 0:
					if (IsPersistentMatrix__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return IsPersistentMatrix;

					} else if (IsPersistentMatrix__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return (Symbol)null;

					} else if (IsPersistentMatrix__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return (Symbol)null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 0, schemaInfo_Positioned);
						return (fieldDefaultValue_Raw != null) ? (Symbol)fieldDefaultValue_Raw : (Symbol)null;
					}

 				default: // Error, invalid index;
 					throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid index for the method, getField_Symbol(ExecutionInfo executeInfo, int index). The index that was passed was, " + index +  ", and there is no field of the correct type.");
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
					if (IsPersistentMatrix__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					IsPersistentMatrix = (Symbol)value;
					IsPersistentMatrix__Special = FieldConstants.HAS_STANDARD_VALUE;
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
	public void setField_Symbol(ExecutionInfo executeInfo, int index, Symbol value) throws Exception_InvalidArgumentPassed {

		if (index < schemaInfo_Positioned.getNum_NonContinuationFields()) {
			switch (index) {
				case 0:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (IsPersistentMatrix__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					IsPersistentMatrix = value;
					IsPersistentMatrix__Special = FieldConstants.HAS_STANDARD_VALUE;
					return;


 				default: // Error, invalid index;
 					throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid index for the method, getField_Symbol(ExecutionInfo executeInfo, int index). The index that was passed was, " + index +  ", and there is no field of the correct type.");
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
					if (IsPersistentMatrix__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					IsPersistentMatrix__Special = specialValue;
					IsPersistentMatrix = null;
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
			importsSet.add("import com.mycompany.hr.AppControl;");
			importsSet.add("import com.mycompany.hr.AppSymbols;");
			importsSet.add("import com.mycompany.hr.AppSymbols_MatrixName;");
			importsSet.add("import net.unconventionalthinking.matrix.Descriptor;");
			importsSet.add("import net.unconventionalthinking.matrix.symbols.*;");
			importsSet.add("import net.unconventionalthinking.matrix.FieldSet_Worker;");
			importsSet.add("import java.util.LinkedList;");
			importsSet.add("import java.util.HashSet;");
			importsSet.add("import java.util.List;");
			importsSet.add("import com.mycompany.hr.AppSymbols_DescTag;");
			importsSet.add("import net.unconventionalthinking.exceptions.*;");
			importsSet.add("import net.unconventionalthinking.matrix.symbols.Symbol;");
			importsSet.add("import com.mycompany.hr.AppSymbols_Label;");
			importsSet.add("import com.mycompany.hr.AppSymbols_SchemaName;");
			importsSet.add("import net.unconventionalthinking.matrix.*;");
			importsSet.add("import java.util.Arrays;");
			importsSet.add("import net.unconventionalthinking.lang.*;");
			importsSet.add("import net.unconventionalthinking.matrix.symbols.DescriptorTagName;");
			importsSet.add("import com.mycompany.hr.AppSymbols_DescTagName;");
			importsSet.add("import java.util.ArrayList;");
			importsSet.add("import java.util.Set;");
			importsSet.add("import net.unconventionalthinking.matrix.FieldSet_FieldValueBucket;");
			importsSet.add("import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;");
			importsSet.add("import net.unconventionalthinking.lang.ExecutionInfo;");
			importsSet.add("import net.unconventionalthinking.matrix.FieldSet_Tuple;");
			importsSet.add("import net.unconventionalthinking.matrix.FieldConstants;");
		}

		return importsSet;
	}


}
