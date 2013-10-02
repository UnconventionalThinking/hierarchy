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

import java.util.List;
import net.unconventionalthinking.exceptions.*;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.*;
import java.util.Arrays;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.*;
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
import java.util.LinkedList;
import java.util.HashSet;


public class FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$PEOPLE$_S_$PERSON$__$INFO extends FieldSet_Tuple {

	//  private variables (for fields) _______________________________________________________

	String Person_ID;
	FieldConstants Person_ID__Special;
	String Name;
	FieldConstants Name__Special;
	String Title;
	FieldConstants Title__Special;
	String Role;
	FieldConstants Role__Special;
	String Email;
	FieldConstants Email__Special;
	String Description;
	FieldConstants Description__Special;


	//  Constructors _________________________________________________________________________

	public FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$PEOPLE$_S_$PERSON$__$INFO(ExecutionInfo executeInfo, Descriptor parentDescriptor) {

		//  passing in 'false' to FieldSet_Tuple parent constructor so that the dynAccessed_Field List is not created.
		super(executeInfo, parentDescriptor, false);

		this.Person_ID__Special = null;
		this.Name__Special = null;
		this.Title__Special = null;
		this.Role__Special = null;
		this.Email__Special = null;
		this.Description__Special = null;

	}



	//  FieldSet State Methods _______________________________________________________________
	@Override
	public boolean is_SpecializedFieldSet() {
		return true;
	}


	//  get_<Field Name>(), set_<Field Name>(), and set_<Field Name>__Special() methods_______

	public String get_Person_ID(ExecutionInfo executeInfo) throws Exception_InvalidArgumentPassed  {

		if (Person_ID__Special == FieldConstants.HAS_STANDARD_VALUE) {
			executeInfo.clearResultsInfo();
			return Person_ID;

		} else if (Person_ID__Special == FieldConstants.UNUSED) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
			return (String)null;

		} else if (Person_ID__Special == FieldConstants.NULL) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
			return (String)null;

		} else {
			// no value was set, return default value
			Object fieldDefaultValue_Raw = 
				FieldSet_Worker.getField_DefaultValue(executeInfo, 0, schemaInfo_Positioned);
			return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
		}
	}

	public String get_Name(ExecutionInfo executeInfo) throws Exception_InvalidArgumentPassed  {

		if (Name__Special == FieldConstants.HAS_STANDARD_VALUE) {
			executeInfo.clearResultsInfo();
			return Name;

		} else if (Name__Special == FieldConstants.UNUSED) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
			return (String)null;

		} else if (Name__Special == FieldConstants.NULL) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
			return (String)null;

		} else {
			// no value was set, return default value
			Object fieldDefaultValue_Raw = 
				FieldSet_Worker.getField_DefaultValue(executeInfo, 1, schemaInfo_Positioned);
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
				FieldSet_Worker.getField_DefaultValue(executeInfo, 2, schemaInfo_Positioned);
			return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
		}
	}

	public String get_Role(ExecutionInfo executeInfo) throws Exception_InvalidArgumentPassed  {

		if (Role__Special == FieldConstants.HAS_STANDARD_VALUE) {
			executeInfo.clearResultsInfo();
			return Role;

		} else if (Role__Special == FieldConstants.UNUSED) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
			return (String)null;

		} else if (Role__Special == FieldConstants.NULL) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
			return (String)null;

		} else {
			// no value was set, return default value
			Object fieldDefaultValue_Raw = 
				FieldSet_Worker.getField_DefaultValue(executeInfo, 3, schemaInfo_Positioned);
			return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
		}
	}

	public String get_Email(ExecutionInfo executeInfo) throws Exception_InvalidArgumentPassed  {

		if (Email__Special == FieldConstants.HAS_STANDARD_VALUE) {
			executeInfo.clearResultsInfo();
			return Email;

		} else if (Email__Special == FieldConstants.UNUSED) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
			return (String)null;

		} else if (Email__Special == FieldConstants.NULL) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
			return (String)null;

		} else {
			// no value was set, return default value
			Object fieldDefaultValue_Raw = 
				FieldSet_Worker.getField_DefaultValue(executeInfo, 4, schemaInfo_Positioned);
			return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
		}
	}

	public String get_Description(ExecutionInfo executeInfo) throws Exception_InvalidArgumentPassed  {

		if (Description__Special == FieldConstants.HAS_STANDARD_VALUE) {
			executeInfo.clearResultsInfo();
			return Description;

		} else if (Description__Special == FieldConstants.UNUSED) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
			return (String)null;

		} else if (Description__Special == FieldConstants.NULL) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
			return (String)null;

		} else {
			// no value was set, return default value
			Object fieldDefaultValue_Raw = 
				FieldSet_Worker.getField_DefaultValue(executeInfo, 5, schemaInfo_Positioned);
			return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
		}
	}

	public void set_Person_ID(ExecutionInfo executeInfo, String value) throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.Person_ID__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.Person_ID = value;
		this.Person_ID__Special = FieldConstants.HAS_STANDARD_VALUE;
	}
	public void set_Person_ID__Special(ExecutionInfo executeInfo, FieldConstants specialValue)
			throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.Person_ID__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.Person_ID__Special = specialValue;
		this.Person_ID = null;
	}

	public void set_Name(ExecutionInfo executeInfo, String value) throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.Name__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.Name = value;
		this.Name__Special = FieldConstants.HAS_STANDARD_VALUE;
	}
	public void set_Name__Special(ExecutionInfo executeInfo, FieldConstants specialValue)
			throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.Name__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.Name__Special = specialValue;
		this.Name = null;
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

	public void set_Role(ExecutionInfo executeInfo, String value) throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.Role__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.Role = value;
		this.Role__Special = FieldConstants.HAS_STANDARD_VALUE;
	}
	public void set_Role__Special(ExecutionInfo executeInfo, FieldConstants specialValue)
			throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.Role__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.Role__Special = specialValue;
		this.Role = null;
	}

	public void set_Email(ExecutionInfo executeInfo, String value) throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.Email__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.Email = value;
		this.Email__Special = FieldConstants.HAS_STANDARD_VALUE;
	}
	public void set_Email__Special(ExecutionInfo executeInfo, FieldConstants specialValue)
			throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.Email__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.Email__Special = specialValue;
		this.Email = null;
	}

	public void set_Description(ExecutionInfo executeInfo, String value) throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.Description__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.Description = value;
		this.Description__Special = FieldConstants.HAS_STANDARD_VALUE;
	}
	public void set_Description__Special(ExecutionInfo executeInfo, FieldConstants specialValue)
			throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.Description__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.Description__Special = specialValue;
		this.Description = null;
	}

	@Override
	public void setField(ExecutionInfo executeInfo, DescriptorTagName fieldName, Object value) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case maintests.samples.AppSymbols_DescTagName.Person$95$ID$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Person_ID__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Person_ID = (String)value;
				this.Person_ID__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			case maintests.samples.AppSymbols_DescTagName.Name$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Name__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Name = (String)value;
				this.Name__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			case maintests.samples.AppSymbols_DescTagName.Title$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Title__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Title = (String)value;
				this.Title__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			case maintests.samples.AppSymbols_DescTagName.Role$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Role__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Role = (String)value;
				this.Role__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			case maintests.samples.AppSymbols_DescTagName.Email$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Email__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Email = (String)value;
				this.Email__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			case maintests.samples.AppSymbols_DescTagName.Description$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Description__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Description = (String)value;
				this.Description__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was setField(ExecutionInfo executeInfo, DescriptorTagName fieldName, Object value) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public void setField__Special(ExecutionInfo executeInfo, DescriptorTagName fieldName, FieldConstants specialValue) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case maintests.samples.AppSymbols_DescTagName.Person$95$ID$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Person_ID__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Person_ID__Special = specialValue;
				this.Person_ID = null;
				return;
			case maintests.samples.AppSymbols_DescTagName.Name$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Name__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Name__Special = specialValue;
				this.Name = null;
				return;
			case maintests.samples.AppSymbols_DescTagName.Title$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Title__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Title__Special = specialValue;
				this.Title = null;
				return;
			case maintests.samples.AppSymbols_DescTagName.Role$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Role__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Role__Special = specialValue;
				this.Role = null;
				return;
			case maintests.samples.AppSymbols_DescTagName.Email$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Email__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Email__Special = specialValue;
				this.Email = null;
				return;
			case maintests.samples.AppSymbols_DescTagName.Description$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Description__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Description__Special = specialValue;
				this.Description = null;
				return;
			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was setField__Special(ExecutionInfo executeInfo, DescriptorTagName fieldName, FieldConstants specialValue) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public void setField_String(ExecutionInfo executeInfo, DescriptorTagName fieldName, String value) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case maintests.samples.AppSymbols_DescTagName.Person$95$ID$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Person_ID__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Person_ID = value;
				this.Person_ID__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			case maintests.samples.AppSymbols_DescTagName.Name$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Name__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Name = value;
				this.Name__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			case maintests.samples.AppSymbols_DescTagName.Title$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Title__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Title = value;
				this.Title__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			case maintests.samples.AppSymbols_DescTagName.Role$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Role__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Role = value;
				this.Role__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			case maintests.samples.AppSymbols_DescTagName.Email$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Email__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Email = value;
				this.Email__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			case maintests.samples.AppSymbols_DescTagName.Description$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Description__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Description = value;
				this.Description__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was setField_String(ExecutionInfo executeInfo, DescriptorTagName fieldName, String value) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public Object getField(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case maintests.samples.AppSymbols_DescTagName.Person$95$ID$_ID_$:
				if (Person_ID__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return Person_ID;

				} else if (Person_ID__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return null;

				} else if (Person_ID__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 0, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : null;
				}

 			case maintests.samples.AppSymbols_DescTagName.Name$_ID_$:
				if (Name__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return Name;

				} else if (Name__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return null;

				} else if (Name__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 1, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : null;
				}

 			case maintests.samples.AppSymbols_DescTagName.Title$_ID_$:
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
						FieldSet_Worker.getField_DefaultValue(executeInfo, 2, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : null;
				}

 			case maintests.samples.AppSymbols_DescTagName.Role$_ID_$:
				if (Role__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return Role;

				} else if (Role__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return null;

				} else if (Role__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 3, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : null;
				}

 			case maintests.samples.AppSymbols_DescTagName.Email$_ID_$:
				if (Email__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return Email;

				} else if (Email__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return null;

				} else if (Email__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 4, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : null;
				}

 			case maintests.samples.AppSymbols_DescTagName.Description$_ID_$:
				if (Description__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return Description;

				} else if (Description__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return null;

				} else if (Description__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 5, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : null;
				}

 			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was getField(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public String getField_String(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case maintests.samples.AppSymbols_DescTagName.Person$95$ID$_ID_$:
				if (Person_ID__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return Person_ID;

				} else if (Person_ID__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return (String)null;

				} else if (Person_ID__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return (String)null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 0, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
				}

 			case maintests.samples.AppSymbols_DescTagName.Name$_ID_$:
				if (Name__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return Name;

				} else if (Name__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return (String)null;

				} else if (Name__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return (String)null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 1, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
				}

 			case maintests.samples.AppSymbols_DescTagName.Title$_ID_$:
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
						FieldSet_Worker.getField_DefaultValue(executeInfo, 2, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
				}

 			case maintests.samples.AppSymbols_DescTagName.Role$_ID_$:
				if (Role__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return Role;

				} else if (Role__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return (String)null;

				} else if (Role__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return (String)null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 3, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
				}

 			case maintests.samples.AppSymbols_DescTagName.Email$_ID_$:
				if (Email__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return Email;

				} else if (Email__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return (String)null;

				} else if (Email__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return (String)null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 4, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
				}

 			case maintests.samples.AppSymbols_DescTagName.Description$_ID_$:
				if (Description__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return Description;

				} else if (Description__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return (String)null;

				} else if (Description__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return (String)null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 5, schemaInfo_Positioned);
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
					if (Person_ID__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return Person_ID;

					} else if (Person_ID__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return null;

					} else if (Person_ID__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 0, schemaInfo_Positioned);
						return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : null;
					}

 				case 1:
					if (Name__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return Name;

					} else if (Name__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return null;

					} else if (Name__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 1, schemaInfo_Positioned);
						return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : null;
					}

 				case 2:
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
							FieldSet_Worker.getField_DefaultValue(executeInfo, 2, schemaInfo_Positioned);
						return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : null;
					}

 				case 3:
					if (Role__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return Role;

					} else if (Role__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return null;

					} else if (Role__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 3, schemaInfo_Positioned);
						return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : null;
					}

 				case 4:
					if (Email__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return Email;

					} else if (Email__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return null;

					} else if (Email__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 4, schemaInfo_Positioned);
						return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : null;
					}

 				case 5:
					if (Description__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return Description;

					} else if (Description__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return null;

					} else if (Description__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 5, schemaInfo_Positioned);
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
					if (Person_ID__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return Person_ID;

					} else if (Person_ID__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return (String)null;

					} else if (Person_ID__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return (String)null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 0, schemaInfo_Positioned);
						return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
					}

 				case 1:
					if (Name__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return Name;

					} else if (Name__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return (String)null;

					} else if (Name__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return (String)null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 1, schemaInfo_Positioned);
						return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
					}

 				case 2:
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
							FieldSet_Worker.getField_DefaultValue(executeInfo, 2, schemaInfo_Positioned);
						return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
					}

 				case 3:
					if (Role__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return Role;

					} else if (Role__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return (String)null;

					} else if (Role__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return (String)null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 3, schemaInfo_Positioned);
						return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
					}

 				case 4:
					if (Email__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return Email;

					} else if (Email__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return (String)null;

					} else if (Email__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return (String)null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 4, schemaInfo_Positioned);
						return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
					}

 				case 5:
					if (Description__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return Description;

					} else if (Description__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return (String)null;

					} else if (Description__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return (String)null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 5, schemaInfo_Positioned);
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
					if (Person_ID__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Person_ID = (String)value;
					Person_ID__Special = FieldConstants.HAS_STANDARD_VALUE;
					return;


 				case 1:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (Name__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Name = (String)value;
					Name__Special = FieldConstants.HAS_STANDARD_VALUE;
					return;


 				case 2:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (Title__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Title = (String)value;
					Title__Special = FieldConstants.HAS_STANDARD_VALUE;
					return;


 				case 3:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (Role__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Role = (String)value;
					Role__Special = FieldConstants.HAS_STANDARD_VALUE;
					return;


 				case 4:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (Email__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Email = (String)value;
					Email__Special = FieldConstants.HAS_STANDARD_VALUE;
					return;


 				case 5:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (Description__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Description = (String)value;
					Description__Special = FieldConstants.HAS_STANDARD_VALUE;
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
					if (Person_ID__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Person_ID = value;
					Person_ID__Special = FieldConstants.HAS_STANDARD_VALUE;
					return;


 				case 1:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (Name__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Name = value;
					Name__Special = FieldConstants.HAS_STANDARD_VALUE;
					return;


 				case 2:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (Title__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Title = value;
					Title__Special = FieldConstants.HAS_STANDARD_VALUE;
					return;


 				case 3:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (Role__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Role = value;
					Role__Special = FieldConstants.HAS_STANDARD_VALUE;
					return;


 				case 4:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (Email__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Email = value;
					Email__Special = FieldConstants.HAS_STANDARD_VALUE;
					return;


 				case 5:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (Description__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Description = value;
					Description__Special = FieldConstants.HAS_STANDARD_VALUE;
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
					if (Person_ID__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Person_ID__Special = specialValue;
					Person_ID = null;
					return;


 				case 1:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (Name__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Name__Special = specialValue;
					Name = null;
					return;


 				case 2:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (Title__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Title__Special = specialValue;
					Title = null;
					return;


 				case 3:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (Role__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Role__Special = specialValue;
					Role = null;
					return;


 				case 4:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (Email__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Email__Special = specialValue;
					Email = null;
					return;


 				case 5:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (Description__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Description__Special = specialValue;
					Description = null;
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
			importsSet.add("import java.util.List;");
			importsSet.add("import net.unconventionalthinking.exceptions.*;");
			importsSet.add("import net.unconventionalthinking.matrix.symbols.Symbol;");
			importsSet.add("import net.unconventionalthinking.matrix.*;");
			importsSet.add("import java.util.Arrays;");
			importsSet.add("import net.unconventionalthinking.lang.*;");
			importsSet.add("import net.unconventionalthinking.matrix.symbols.*;");
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
			importsSet.add("import java.util.LinkedList;");
			importsSet.add("import java.util.HashSet;");
		}

		return importsSet;
	}


}
