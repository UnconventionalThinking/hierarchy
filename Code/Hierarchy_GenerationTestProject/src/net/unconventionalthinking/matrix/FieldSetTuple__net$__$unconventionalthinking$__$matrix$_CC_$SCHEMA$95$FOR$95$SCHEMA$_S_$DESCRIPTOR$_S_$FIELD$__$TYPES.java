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


public class FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_S_$DESCRIPTOR$_S_$FIELD$__$TYPES extends FieldSet_Tuple {

	//  private variables (for fields) _______________________________________________________


	//  Continuation Values List
	List<FieldSet_FieldValueBucket> continuationValues;


	//  Constructors _________________________________________________________________________

	public FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_S_$DESCRIPTOR$_S_$FIELD$__$TYPES(ExecutionInfo executeInfo, Descriptor parentDescriptor) {

		//  passing in 'false' to FieldSet_Tuple parent constructor so that the dynAccessed_Field List is not created.
		super(executeInfo, parentDescriptor, false);


		continuationValues = new ArrayList<FieldSet_FieldValueBucket>();

	}



	//  FieldSet State Methods _______________________________________________________________
	@Override
	public boolean is_SpecializedFieldSet() {
		return true;
	}


	//  get_<Field Name>(), set_<Field Name>(), and set_<Field Name>__Special() methods_______

	public Symbol get_TYPES(ExecutionInfo executeInfo, int continuationIndex) 
			throws Exception_InvalidArgumentPassed {

		if (continuationIndex < continuationValues.size()) {
			FieldSet_FieldValueBucket fieldValueBucket = continuationValues.get(continuationIndex);
			Object value = FieldSet_Worker.getField_ProcessFieldValueBucket(executeInfo, fieldValueBucket, schemaInfo_Positioned, schemaInfo_Positioned.getNum_NonContinuationFields());
			return (value != null) ? (Symbol)value : (Symbol)null;


		} else { 
			Object defaultValue = FieldSet_Worker.getField_DefaultValue(executeInfo, schemaInfo_Positioned.getNum_NonContinuationFields(), schemaInfo_Positioned);
			return (defaultValue != null) ? (Symbol)defaultValue : (Symbol)null;

		}

	}

	public void set_TYPES(ExecutionInfo executeInfo, int continuationIndex, Symbol value) 
			throws Exception_InvalidArgumentPassed  {

		if (continuationIndex == continuationValues.size()) {  // add to end
			FieldSet_Worker.setField_AddNewValue_to_EndOfList(value, continuationValues, this);

		} else if (continuationIndex < continuationValues.size()) {
			FieldSet_Worker.setField_ReplaceExistingValue_in_List(value, continuationIndex, continuationValues, this);

		} else {
			//  Error
			throw new Exception_InvalidArgumentPassed("Tried to access the continuation field with an index greater than the number of field values. The continuation index that was passed was, " + continuationIndex +  ", and the number of continuation values is, " + continuationValues.size() +  ".");		}
	}

	public void set_TYPES__Special(ExecutionInfo executeInfo, int continuationIndex,  FieldConstants specialValue)
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
			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was setField(ExecutionInfo executeInfo, DescriptorTagName fieldName, Object value) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public void setField__Special(ExecutionInfo executeInfo, DescriptorTagName fieldName, FieldConstants specialValue) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was setField__Special(ExecutionInfo executeInfo, DescriptorTagName fieldName, FieldConstants specialValue) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public void setField_Symbol(ExecutionInfo executeInfo, DescriptorTagName fieldName, Symbol value) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was setField_Symbol(ExecutionInfo executeInfo, DescriptorTagName fieldName, Symbol value) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public Object getField(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was getField(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public Symbol getField_Symbol(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
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
	public Symbol getField_Symbol(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed {

		if (index < schemaInfo_Positioned.getNum_NonContinuationFields()) {
			switch (index) {
				default: // Error, invalid index;
 					throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid index for the method, getField_Symbol(ExecutionInfo executeInfo, int index). The index that was passed was, " + index +  ", and there is no field of the correct type.");
			} // end of switch

		}

		int continuationIndex = index - schemaInfo_Positioned.getNum_NonContinuationFields();
		if (continuationIndex < continuationValues.size()) {
			FieldSet_FieldValueBucket fieldValueBucket = continuationValues.get(continuationIndex);
			Object value = FieldSet_Worker.getField_ProcessFieldValueBucket(executeInfo, fieldValueBucket, schemaInfo_Positioned, schemaInfo_Positioned.getNum_NonContinuationFields());
			return (value != null) ? (Symbol)value : (Symbol)null;


		} else { 
			Object defaultValue = FieldSet_Worker.getField_DefaultValue(executeInfo, schemaInfo_Positioned.getNum_NonContinuationFields(), schemaInfo_Positioned);
			return (defaultValue != null) ? (Symbol)defaultValue : (Symbol)null;

		}

	}

	@Override
	public void setField(ExecutionInfo executeInfo, int index, Object value) throws Exception_InvalidArgumentPassed {

		if (index < schemaInfo_Positioned.getNum_NonContinuationFields()) {
			switch (index) {
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
	public void setField_Symbol(ExecutionInfo executeInfo, int index, Symbol value) throws Exception_InvalidArgumentPassed {

		if (index < schemaInfo_Positioned.getNum_NonContinuationFields()) {
			switch (index) {
				default: // Error, invalid index;
 					throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid index for the method, getField_Symbol(ExecutionInfo executeInfo, int index). The index that was passed was, " + index +  ", and there is no field of the correct type.");
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
	public void setField__Special(ExecutionInfo executeInfo, int index, FieldConstants specialValue) throws Exception_InvalidArgumentPassed {

		if (index < schemaInfo_Positioned.getNum_NonContinuationFields()) {
			switch (index) {
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
