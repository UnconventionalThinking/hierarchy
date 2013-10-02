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

package net.unconventionalthinking.matrix;

import java.util.List;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.Descriptor;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import java.util.ArrayList;
import net.unconventionalthinking.matrix.FieldSet_FieldValueBucket;
import java.util.Set;
import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.FieldConstants;
import net.unconventionalthinking.matrix.FieldSet_Tuple;
import net.unconventionalthinking.matrix.FieldSet_Worker;
import java.util.HashSet;


public class FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1 extends FieldSet_Tuple {

	//  private variables (for fields) _______________________________________________________

	String field1Str;
	FieldConstants field1Str__Special;
	short field2Short;
	FieldConstants field2Short__Special;

	//  Continuation Values List
	List<FieldSet_FieldValueBucket> continuationValues;


	//  Constructors _________________________________________________________________________

	public FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$TEST$__$SCHEMA$_S_$MY$95$DESC$__$NUM1(ExecutionInfo executeInfo, Descriptor parentDescriptor) {

		//  passing in 'false' to FieldSet_Tuple parent constructor so that the dynAccessed_Field List is not created.
		super(executeInfo, parentDescriptor, false);

		this.field1Str__Special = null;
		this.field2Short__Special = null;

		continuationValues = new ArrayList<FieldSet_FieldValueBucket>();

	}



	//  FieldSet State Methods _______________________________________________________________
	@Override
	public boolean is_SpecializedFieldSet() {
		return true;
	}


	//  get_<Field Name>(), set_<Field Name>(), and set_<Field Name>__Special() methods_______

	public String get_field1Str(ExecutionInfo executeInfo) throws Exception_InvalidArgumentPassed  {

		if (field1Str__Special == FieldConstants.HAS_STANDARD_VALUE) {
			executeInfo.clearResultsInfo();
			return field1Str;

		} else if (field1Str__Special == FieldConstants.UNUSED) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
			return (String)null;

		} else if (field1Str__Special == FieldConstants.NULL) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
			return (String)null;

		} else {
			// no value was set, return default value
			Object fieldDefaultValue_Raw = 
				FieldSet_Worker.getField_DefaultValue(executeInfo, 0, schemaInfo_Positioned);
			return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
		}
	}

	public short get_field2Short(ExecutionInfo executeInfo) throws Exception_InvalidArgumentPassed  {

		if (field2Short__Special == FieldConstants.HAS_STANDARD_VALUE) {
			executeInfo.clearResultsInfo();
			return field2Short;

		} else if (field2Short__Special == FieldConstants.UNUSED) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
			return (short)-1;

		} else if (field2Short__Special == FieldConstants.NULL) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
			return (short)-1;

		} else {
			// no value was set, return default value
			Object fieldDefaultValue_Raw = 
				FieldSet_Worker.getField_DefaultValue(executeInfo, 1, schemaInfo_Positioned);
			return (fieldDefaultValue_Raw != null) ? ((Short)fieldDefaultValue_Raw).shortValue() : (short)-1;
		}
	}

	public int get_field3ContInt(ExecutionInfo executeInfo, int continuationIndex) 
			throws Exception_InvalidArgumentPassed {

		if (continuationIndex < continuationValues.size()) {
			FieldSet_FieldValueBucket fieldValueBucket = continuationValues.get(continuationIndex);
			Object value = FieldSet_Worker.getField_ProcessFieldValueBucket(executeInfo, fieldValueBucket, schemaInfo_Positioned, schemaInfo_Positioned.getNum_NonContinuationFields());
			return (value != null) ? ((Integer)value).intValue() : (int)-1;


		} else { 
			Object defaultValue = FieldSet_Worker.getField_DefaultValue(executeInfo, schemaInfo_Positioned.getNum_NonContinuationFields(), schemaInfo_Positioned);
			return (defaultValue != null) ? ((Integer)defaultValue).intValue() : (int)-1;

		}

	}

	public void set_field1Str(ExecutionInfo executeInfo, String value) throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.field1Str__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.field1Str = value;
		this.field1Str__Special = FieldConstants.HAS_STANDARD_VALUE;
	}
	public void set_field1Str__Special(ExecutionInfo executeInfo, FieldConstants specialValue)
			throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.field1Str__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.field1Str__Special = specialValue;
		this.field1Str = null;
	}

	public void set_field2Short(ExecutionInfo executeInfo, short value) throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.field2Short__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.field2Short = value;
		this.field2Short__Special = FieldConstants.HAS_STANDARD_VALUE;
	}
	public void set_field2Short__Special(ExecutionInfo executeInfo, FieldConstants specialValue)
			throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.field2Short__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.field2Short__Special = specialValue;
		this.field2Short = -1;
	}

	public void set_field3ContInt(ExecutionInfo executeInfo, int continuationIndex, int value) 
			throws Exception_InvalidArgumentPassed  {

		if (continuationIndex == continuationValues.size()) {  // add to end
			FieldSet_Worker.setField_AddNewValue_to_EndOfList(new Integer((int)value), continuationValues, this);

		} else if (continuationIndex < continuationValues.size()) {
			FieldSet_Worker.setField_ReplaceExistingValue_in_List(new Integer((int)value), continuationIndex, continuationValues, this);

		} else {
			//  Error
			throw new Exception_InvalidArgumentPassed("Tried to access the continuation field with an index greater than the number of field values. The continuation index that was passed was, " + continuationIndex +  ", and the number of continuation values is, " + continuationValues.size() +  ".");		}
	}

	public void set_field3ContInt__Special(ExecutionInfo executeInfo, int continuationIndex,  FieldConstants specialValue)
			throws Exception_InvalidArgumentPassed  {

		if (continuationIndex == continuationValues.size()) {  // add to end
			FieldSet_Worker.setFieldSpecial_AddNewValue_to_EndOfList(specialValue, continuationValues, this);

		} else if (continuationIndex < continuationValues.size()) {
			FieldSet_Worker.setFieldSpecial_ReplaceExistingValue_in_List(specialValue, continuationIndex, continuationValues, this);

		} else {
			//  Error
			throw new Exception_InvalidArgumentPassed("Tried to access the continuation field with an index greater than the number of field values. The continuation index that was passed was, " + continuationIndex +  ", and the number of continuation values is, " + continuationValues.size() +  ".");		}
	}

	@Override
	public void setField(ExecutionInfo executeInfo, DescriptorTagName fieldName, Object value) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case net.unconventionalthinking.matrix.AppSymbols_DescTagName.field1Str$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.field1Str__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.field1Str = (String)value;
				this.field1Str__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			case net.unconventionalthinking.matrix.AppSymbols_DescTagName.field2Short$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.field2Short__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.field2Short = ((Short)value).shortValue();
				this.field2Short__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was setField(ExecutionInfo executeInfo, DescriptorTagName fieldName, Object value) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public void setField__Special(ExecutionInfo executeInfo, DescriptorTagName fieldName, FieldConstants specialValue) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case net.unconventionalthinking.matrix.AppSymbols_DescTagName.field1Str$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.field1Str__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.field1Str__Special = specialValue;
				this.field1Str = null;
				return;
			case net.unconventionalthinking.matrix.AppSymbols_DescTagName.field2Short$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.field2Short__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.field2Short__Special = specialValue;
				this.field2Short = -1;
				return;
			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was setField__Special(ExecutionInfo executeInfo, DescriptorTagName fieldName, FieldConstants specialValue) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public void setField_String(ExecutionInfo executeInfo, DescriptorTagName fieldName, String value) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case net.unconventionalthinking.matrix.AppSymbols_DescTagName.field1Str$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.field1Str__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.field1Str = value;
				this.field1Str__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was setField_String(ExecutionInfo executeInfo, DescriptorTagName fieldName, String value) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public void setField_short(ExecutionInfo executeInfo, DescriptorTagName fieldName, short value) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case net.unconventionalthinking.matrix.AppSymbols_DescTagName.field2Short$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.field2Short__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.field2Short = value;
				this.field2Short__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was setField_short(ExecutionInfo executeInfo, DescriptorTagName fieldName, short value) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public void setField_int(ExecutionInfo executeInfo, DescriptorTagName fieldName, int value) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was setField_int(ExecutionInfo executeInfo, DescriptorTagName fieldName, int value) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public Object getField(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case net.unconventionalthinking.matrix.AppSymbols_DescTagName.field1Str$_ID_$:
				if (field1Str__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return field1Str;

				} else if (field1Str__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return null;

				} else if (field1Str__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 0, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : null;
				}

 			case net.unconventionalthinking.matrix.AppSymbols_DescTagName.field2Short$_ID_$:
				if (field2Short__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return new Short((short)field2Short);

				} else if (field2Short__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return null;

				} else if (field2Short__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 1, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? ((Short)fieldDefaultValue_Raw).shortValue() : null;
				}

 			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was getField(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public String getField_String(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case net.unconventionalthinking.matrix.AppSymbols_DescTagName.field1Str$_ID_$:
				if (field1Str__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return field1Str;

				} else if (field1Str__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return (String)null;

				} else if (field1Str__Special == FieldConstants.NULL) {
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

	@Override
	public short getField_short(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case net.unconventionalthinking.matrix.AppSymbols_DescTagName.field2Short$_ID_$:
				if (field2Short__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return field2Short;

				} else if (field2Short__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return (short)-1;

				} else if (field2Short__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return (short)-1;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 1, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? ((Short)fieldDefaultValue_Raw).shortValue() : (short)-1;
				}

 			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was getField_short(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public int getField_int(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was getField_int(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
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
					if (field1Str__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return field1Str;

					} else if (field1Str__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return null;

					} else if (field1Str__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 0, schemaInfo_Positioned);
						return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : null;
					}

 				case 1:
					if (field2Short__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return new Short((short)field2Short);

					} else if (field2Short__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return null;

					} else if (field2Short__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 1, schemaInfo_Positioned);
						return (fieldDefaultValue_Raw != null) ? ((Short)fieldDefaultValue_Raw).shortValue() : null;
					}

 				default: // Error, invalid index;
 					throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid index for the method, getField(ExecutionInfo executeInfo, int index). The index that was passed was, " + index +  ", and there is no field of the correct type.");
			} // end of switch

		}

		int continuationIndex = index - schemaInfo_Positioned.getNum_NonContinuationFields();
		if (continuationIndex < continuationValues.size()) {
			FieldSet_FieldValueBucket fieldValueBucket = continuationValues.get(continuationIndex);
			return FieldSet_Worker.getField_ProcessFieldValueBucket(executeInfo, fieldValueBucket, schemaInfo_Positioned, schemaInfo_Positioned.getNum_NonContinuationFields());

		} else { 
			return FieldSet_Worker.getField_DefaultValue(executeInfo, schemaInfo_Positioned.getNum_NonContinuationFields(), schemaInfo_Positioned);

		}

	}

	@Override
	public String getField_String(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed {

		if (index < schemaInfo_Positioned.getNum_NonContinuationFields()) {
			switch (index) {
				case 0:
					if (field1Str__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return field1Str;

					} else if (field1Str__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return (String)null;

					} else if (field1Str__Special == FieldConstants.NULL) {
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
	public short getField_short(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed {

		if (index < schemaInfo_Positioned.getNum_NonContinuationFields()) {
			switch (index) {
				case 1:
					if (field2Short__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return field2Short;

					} else if (field2Short__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return (short)-1;

					} else if (field2Short__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return (short)-1;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 1, schemaInfo_Positioned);
						return (fieldDefaultValue_Raw != null) ? ((Short)fieldDefaultValue_Raw).shortValue() : (short)-1;
					}

 				default: // Error, invalid index;
 					throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid index for the method, getField_short(ExecutionInfo executeInfo, int index). The index that was passed was, " + index +  ", and there is no field of the correct type.");
			} // end of switch


		} else { 
			throw new Exception_InvalidArgumentPassed("Tried to access the field with an index larger than the actual number of field values. The index that was passed in was,  The index that was passed was, " + index +  ". And the number of elements in this fields set is: " + fieldValue_TotalCount);
		}

	}

	@Override
	public int getField_int(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed {

		if (index < schemaInfo_Positioned.getNum_NonContinuationFields()) {
			switch (index) {
				default: // Error, invalid index;
 					throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid index for the method, getField_int(ExecutionInfo executeInfo, int index). The index that was passed was, " + index +  ", and there is no field of the correct type.");
			} // end of switch

		}

		int continuationIndex = index - schemaInfo_Positioned.getNum_NonContinuationFields();
		if (continuationIndex < continuationValues.size()) {
			FieldSet_FieldValueBucket fieldValueBucket = continuationValues.get(continuationIndex);
			Object value = FieldSet_Worker.getField_ProcessFieldValueBucket(executeInfo, fieldValueBucket, schemaInfo_Positioned, schemaInfo_Positioned.getNum_NonContinuationFields());
			return (value != null) ? ((Integer)value).intValue() : (int)-1;


		} else { 
			Object defaultValue = FieldSet_Worker.getField_DefaultValue(executeInfo, schemaInfo_Positioned.getNum_NonContinuationFields(), schemaInfo_Positioned);
			return (defaultValue != null) ? ((Integer)defaultValue).intValue() : (int)-1;

		}

	}

	@Override
	public void setField(ExecutionInfo executeInfo, int index, Object value) throws Exception_InvalidArgumentPassed {

		if (index < schemaInfo_Positioned.getNum_NonContinuationFields()) {
			switch (index) {
				case 0:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (field1Str__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					field1Str = (String)value;
					field1Str__Special = FieldConstants.HAS_STANDARD_VALUE;
					return;


 				case 1:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (field2Short__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					field2Short = ((Short)value).shortValue();
					field2Short__Special = FieldConstants.HAS_STANDARD_VALUE;
					return;


 				default: // Error, invalid index;
 					throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid index for the method, getField(ExecutionInfo executeInfo, int index). The index that was passed was, " + index +  ", and there is no field of the correct type.");
			} // end of switch

		}

		int continuationIndex = index - schemaInfo_Positioned.getNum_NonContinuationFields();
		if (continuationIndex == continuationValues.size()) {  // add to end
			FieldSet_Worker.setField_AddNewValue_to_EndOfList(value, continuationValues, this);

		} else if (continuationIndex < continuationValues.size()) {
			FieldSet_Worker.setField_ReplaceExistingValue_in_List(value, continuationIndex, continuationValues, this);

		} else {
			//  Error
			throw new Exception_InvalidArgumentPassed("Tried to access the continuation field with an index greater than the number of field values. The continuation index that was passed was, " + continuationIndex +  ", and the number of continuation values is, " + continuationValues.size() +  ".");		}
	}

	@Override
	public void setField_String(ExecutionInfo executeInfo, int index, String value) throws Exception_InvalidArgumentPassed {

		if (index < schemaInfo_Positioned.getNum_NonContinuationFields()) {
			switch (index) {
				case 0:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (field1Str__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					field1Str = value;
					field1Str__Special = FieldConstants.HAS_STANDARD_VALUE;
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
	public void setField_short(ExecutionInfo executeInfo, int index, short value) throws Exception_InvalidArgumentPassed {

		if (index < schemaInfo_Positioned.getNum_NonContinuationFields()) {
			switch (index) {
				case 1:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (field2Short__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					field2Short = value;
					field2Short__Special = FieldConstants.HAS_STANDARD_VALUE;
					return;


 				default: // Error, invalid index;
 					throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid index for the method, getField_short(ExecutionInfo executeInfo, int index). The index that was passed was, " + index +  ", and there is no field of the correct type.");
			} // end of switch


		} else { 
			//  error
			throw new Exception_InvalidArgumentPassed("Tried to access the field with an index larger than the actual number of field values. The index that was passed in was,  The index that was passed was, " + index +  ". And the number of elements in this fields set is: " + fieldValue_TotalCount);
		}

	}

	@Override
	public void setField_int(ExecutionInfo executeInfo, int index, int value) throws Exception_InvalidArgumentPassed {

		if (index < schemaInfo_Positioned.getNum_NonContinuationFields()) {
			switch (index) {
				default: // Error, invalid index;
 					throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid index for the method, getField_int(ExecutionInfo executeInfo, int index). The index that was passed was, " + index +  ", and there is no field of the correct type.");
			} // end of switch

		}

		int continuationIndex = index - schemaInfo_Positioned.getNum_NonContinuationFields();
		if (continuationIndex == continuationValues.size()) {  // add to end
			FieldSet_Worker.setField_AddNewValue_to_EndOfList(new Integer((int)value), continuationValues, this);

		} else if (continuationIndex < continuationValues.size()) {
			FieldSet_Worker.setField_ReplaceExistingValue_in_List(new Integer((int)value), continuationIndex, continuationValues, this);

		} else {
			//  Error
			throw new Exception_InvalidArgumentPassed("Tried to access the continuation field with an index greater than the number of field values. The continuation index that was passed was, " + continuationIndex +  ", and the number of continuation values is, " + continuationValues.size() +  ".");		}
	}

	@Override
	public void setField__Special(ExecutionInfo executeInfo, int index, FieldConstants specialValue) throws Exception_InvalidArgumentPassed {

		if (index < schemaInfo_Positioned.getNum_NonContinuationFields()) {
			switch (index) {
				case 0:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (field1Str__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					field1Str__Special = specialValue;
					field1Str = null;
					return;


 				case 1:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (field2Short__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					field2Short__Special = specialValue;
					field2Short = -1;
					return;


 				default: // Error, invalid index;
 					throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid index for the method, getField(ExecutionInfo executeInfo, int index). The index that was passed was, " + index +  ", and there is no field of the correct type.");
			} // end of switch

		}

		int continuationIndex = index - schemaInfo_Positioned.getNum_NonContinuationFields();
		if (continuationIndex == continuationValues.size()) {  // add to end
			FieldSet_Worker.setFieldSpecial_AddNewValue_to_EndOfList(specialValue, continuationValues, this);

		} else if (continuationIndex < continuationValues.size()) {
			FieldSet_Worker.setFieldSpecial_ReplaceExistingValue_in_List(specialValue, continuationIndex, continuationValues, this);

		} else {
			//  Error
			throw new Exception_InvalidArgumentPassed("Tried to access the continuation field with an index greater than the number of field values. The continuation index that was passed was, " + continuationIndex +  ", and the number of continuation values is, " + continuationValues.size() +  ".");		}
	}



	//  Public static methods ____________________________________________________

	private static Set<String> importsSet;

	/** This method returns the set of imports that were used for this specialized fieldset. This is used in the metacompiler when generating 	    fieldsets for schemas in external jars, to generate the import list. */
	public static Set<String> getImportsSet() {

		if (importsSet == null ) {
			importsSet = new HashSet<String>();
			importsSet.add("import java.util.List;");
			importsSet.add("import net.unconventionalthinking.matrix.symbols.Symbol;");
			importsSet.add("import net.unconventionalthinking.matrix.Descriptor;");
			importsSet.add("import net.unconventionalthinking.matrix.symbols.DescriptorTagName;");
			importsSet.add("import java.util.ArrayList;");
			importsSet.add("import net.unconventionalthinking.matrix.FieldSet_FieldValueBucket;");
			importsSet.add("import java.util.Set;");
			importsSet.add("import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;");
			importsSet.add("import net.unconventionalthinking.lang.ExecutionInfo;");
			importsSet.add("import net.unconventionalthinking.matrix.FieldConstants;");
			importsSet.add("import net.unconventionalthinking.matrix.FieldSet_Tuple;");
			importsSet.add("import net.unconventionalthinking.matrix.FieldSet_Worker;");
			importsSet.add("import java.util.HashSet;");
		}

		return importsSet;
	}


}
