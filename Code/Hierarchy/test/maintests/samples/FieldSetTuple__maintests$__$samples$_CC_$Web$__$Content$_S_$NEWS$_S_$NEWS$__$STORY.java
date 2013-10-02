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


public class FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$NEWS$_S_$NEWS$__$STORY extends FieldSet_Tuple {

	//  private variables (for fields) _______________________________________________________

	String NewsItem_ID;
	FieldConstants NewsItem_ID__Special;
	String Title;
	FieldConstants Title__Special;
	String DateText;
	FieldConstants DateText__Special;
	String Story_Blurb;
	FieldConstants Story_Blurb__Special;
	String Story_Text;
	FieldConstants Story_Text__Special;


	//  Constructors _________________________________________________________________________

	public FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$NEWS$_S_$NEWS$__$STORY(ExecutionInfo executeInfo, Descriptor parentDescriptor) {

		//  passing in 'false' to FieldSet_Tuple parent constructor so that the dynAccessed_Field List is not created.
		super(executeInfo, parentDescriptor, false);

		this.NewsItem_ID__Special = null;
		this.Title__Special = null;
		this.DateText__Special = null;
		this.Story_Blurb__Special = null;
		this.Story_Text__Special = null;

	}



	//  FieldSet State Methods _______________________________________________________________
	@Override
	public boolean is_SpecializedFieldSet() {
		return true;
	}


	//  get_<Field Name>(), set_<Field Name>(), and set_<Field Name>__Special() methods_______

	public String get_NewsItem_ID(ExecutionInfo executeInfo) throws Exception_InvalidArgumentPassed  {

		if (NewsItem_ID__Special == FieldConstants.HAS_STANDARD_VALUE) {
			executeInfo.clearResultsInfo();
			return NewsItem_ID;

		} else if (NewsItem_ID__Special == FieldConstants.UNUSED) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
			return (String)null;

		} else if (NewsItem_ID__Special == FieldConstants.NULL) {
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

	public String get_DateText(ExecutionInfo executeInfo) throws Exception_InvalidArgumentPassed  {

		if (DateText__Special == FieldConstants.HAS_STANDARD_VALUE) {
			executeInfo.clearResultsInfo();
			return DateText;

		} else if (DateText__Special == FieldConstants.UNUSED) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
			return (String)null;

		} else if (DateText__Special == FieldConstants.NULL) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
			return (String)null;

		} else {
			// no value was set, return default value
			Object fieldDefaultValue_Raw = 
				FieldSet_Worker.getField_DefaultValue(executeInfo, 2, schemaInfo_Positioned);
			return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
		}
	}

	public String get_Story_Blurb(ExecutionInfo executeInfo) throws Exception_InvalidArgumentPassed  {

		if (Story_Blurb__Special == FieldConstants.HAS_STANDARD_VALUE) {
			executeInfo.clearResultsInfo();
			return Story_Blurb;

		} else if (Story_Blurb__Special == FieldConstants.UNUSED) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
			return (String)null;

		} else if (Story_Blurb__Special == FieldConstants.NULL) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
			return (String)null;

		} else {
			// no value was set, return default value
			Object fieldDefaultValue_Raw = 
				FieldSet_Worker.getField_DefaultValue(executeInfo, 3, schemaInfo_Positioned);
			return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
		}
	}

	public String get_Story_Text(ExecutionInfo executeInfo) throws Exception_InvalidArgumentPassed  {

		if (Story_Text__Special == FieldConstants.HAS_STANDARD_VALUE) {
			executeInfo.clearResultsInfo();
			return Story_Text;

		} else if (Story_Text__Special == FieldConstants.UNUSED) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
			return (String)null;

		} else if (Story_Text__Special == FieldConstants.NULL) {
			executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
			return (String)null;

		} else {
			// no value was set, return default value
			Object fieldDefaultValue_Raw = 
				FieldSet_Worker.getField_DefaultValue(executeInfo, 4, schemaInfo_Positioned);
			return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
		}
	}

	public void set_NewsItem_ID(ExecutionInfo executeInfo, String value) throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.NewsItem_ID__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.NewsItem_ID = value;
		this.NewsItem_ID__Special = FieldConstants.HAS_STANDARD_VALUE;
	}
	public void set_NewsItem_ID__Special(ExecutionInfo executeInfo, FieldConstants specialValue)
			throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.NewsItem_ID__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.NewsItem_ID__Special = specialValue;
		this.NewsItem_ID = null;
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

	public void set_DateText(ExecutionInfo executeInfo, String value) throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.DateText__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.DateText = value;
		this.DateText__Special = FieldConstants.HAS_STANDARD_VALUE;
	}
	public void set_DateText__Special(ExecutionInfo executeInfo, FieldConstants specialValue)
			throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.DateText__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.DateText__Special = specialValue;
		this.DateText = null;
	}

	public void set_Story_Blurb(ExecutionInfo executeInfo, String value) throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.Story_Blurb__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.Story_Blurb = value;
		this.Story_Blurb__Special = FieldConstants.HAS_STANDARD_VALUE;
	}
	public void set_Story_Blurb__Special(ExecutionInfo executeInfo, FieldConstants specialValue)
			throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.Story_Blurb__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.Story_Blurb__Special = specialValue;
		this.Story_Blurb = null;
	}

	public void set_Story_Text(ExecutionInfo executeInfo, String value) throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.Story_Text__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.Story_Text = value;
		this.Story_Text__Special = FieldConstants.HAS_STANDARD_VALUE;
	}
	public void set_Story_Text__Special(ExecutionInfo executeInfo, FieldConstants specialValue)
			throws Exception_InvalidArgumentPassed  {
		//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
		if (this.Story_Text__Special == null) {
			++fieldValue_TotalCount;
			++fieldValue_NonContinuationCount;
		}
		this.Story_Text__Special = specialValue;
		this.Story_Text = null;
	}

	@Override
	public void setField(ExecutionInfo executeInfo, DescriptorTagName fieldName, Object value) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case maintests.samples.AppSymbols_DescTagName.NewsItem$95$ID$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.NewsItem_ID__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.NewsItem_ID = (String)value;
				this.NewsItem_ID__Special = FieldConstants.HAS_STANDARD_VALUE;
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
			case maintests.samples.AppSymbols_DescTagName.DateText$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.DateText__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.DateText = (String)value;
				this.DateText__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			case maintests.samples.AppSymbols_DescTagName.Story$95$Blurb$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Story_Blurb__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Story_Blurb = (String)value;
				this.Story_Blurb__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			case maintests.samples.AppSymbols_DescTagName.Story$95$Text$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Story_Text__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Story_Text = (String)value;
				this.Story_Text__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was setField(ExecutionInfo executeInfo, DescriptorTagName fieldName, Object value) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public void setField__Special(ExecutionInfo executeInfo, DescriptorTagName fieldName, FieldConstants specialValue) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case maintests.samples.AppSymbols_DescTagName.NewsItem$95$ID$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.NewsItem_ID__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.NewsItem_ID__Special = specialValue;
				this.NewsItem_ID = null;
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
			case maintests.samples.AppSymbols_DescTagName.DateText$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.DateText__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.DateText__Special = specialValue;
				this.DateText = null;
				return;
			case maintests.samples.AppSymbols_DescTagName.Story$95$Blurb$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Story_Blurb__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Story_Blurb__Special = specialValue;
				this.Story_Blurb = null;
				return;
			case maintests.samples.AppSymbols_DescTagName.Story$95$Text$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Story_Text__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Story_Text__Special = specialValue;
				this.Story_Text = null;
				return;
			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was setField__Special(ExecutionInfo executeInfo, DescriptorTagName fieldName, FieldConstants specialValue) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public void setField_String(ExecutionInfo executeInfo, DescriptorTagName fieldName, String value) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case maintests.samples.AppSymbols_DescTagName.NewsItem$95$ID$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.NewsItem_ID__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.NewsItem_ID = value;
				this.NewsItem_ID__Special = FieldConstants.HAS_STANDARD_VALUE;
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
			case maintests.samples.AppSymbols_DescTagName.DateText$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.DateText__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.DateText = value;
				this.DateText__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			case maintests.samples.AppSymbols_DescTagName.Story$95$Blurb$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Story_Blurb__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Story_Blurb = value;
				this.Story_Blurb__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			case maintests.samples.AppSymbols_DescTagName.Story$95$Text$_ID_$:
				//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
				if (this.Story_Text__Special == null) {
					++fieldValue_TotalCount;
					++fieldValue_NonContinuationCount;
				}
				this.Story_Text = value;
				this.Story_Text__Special = FieldConstants.HAS_STANDARD_VALUE;
				return;
			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was setField_String(ExecutionInfo executeInfo, DescriptorTagName fieldName, String value) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public Object getField(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case maintests.samples.AppSymbols_DescTagName.NewsItem$95$ID$_ID_$:
				if (NewsItem_ID__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return NewsItem_ID;

				} else if (NewsItem_ID__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return null;

				} else if (NewsItem_ID__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 0, schemaInfo_Positioned);
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
						FieldSet_Worker.getField_DefaultValue(executeInfo, 1, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : null;
				}

 			case maintests.samples.AppSymbols_DescTagName.DateText$_ID_$:
				if (DateText__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return DateText;

				} else if (DateText__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return null;

				} else if (DateText__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 2, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : null;
				}

 			case maintests.samples.AppSymbols_DescTagName.Story$95$Blurb$_ID_$:
				if (Story_Blurb__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return Story_Blurb;

				} else if (Story_Blurb__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return null;

				} else if (Story_Blurb__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 3, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : null;
				}

 			case maintests.samples.AppSymbols_DescTagName.Story$95$Text$_ID_$:
				if (Story_Text__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return Story_Text;

				} else if (Story_Text__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return null;

				} else if (Story_Text__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 4, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : null;
				}

 			default: // Error, invalid index;
 				throw new Exception_InvalidArgumentPassed("Tried to access the field with an invalid field name or on a continuation field (cannot call setField(fieldName) on continuation fields), The method called was getField(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed . The fieldName that was passed was, " + ( (fieldName != null) ? fieldName.toString() : null ) +  ".");
		} // end of switch

	}

	@Override
	public String getField_String(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed  {

		switch ( ((Symbol)fieldName).ID ) {
			case maintests.samples.AppSymbols_DescTagName.NewsItem$95$ID$_ID_$:
				if (NewsItem_ID__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return NewsItem_ID;

				} else if (NewsItem_ID__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return (String)null;

				} else if (NewsItem_ID__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return (String)null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 0, schemaInfo_Positioned);
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
						FieldSet_Worker.getField_DefaultValue(executeInfo, 1, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
				}

 			case maintests.samples.AppSymbols_DescTagName.DateText$_ID_$:
				if (DateText__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return DateText;

				} else if (DateText__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return (String)null;

				} else if (DateText__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return (String)null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 2, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
				}

 			case maintests.samples.AppSymbols_DescTagName.Story$95$Blurb$_ID_$:
				if (Story_Blurb__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return Story_Blurb;

				} else if (Story_Blurb__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return (String)null;

				} else if (Story_Blurb__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return (String)null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 3, schemaInfo_Positioned);
					return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
				}

 			case maintests.samples.AppSymbols_DescTagName.Story$95$Text$_ID_$:
				if (Story_Text__Special == FieldConstants.HAS_STANDARD_VALUE) {
					executeInfo.clearResultsInfo();
					return Story_Text;

				} else if (Story_Text__Special == FieldConstants.UNUSED) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
					return (String)null;

				} else if (Story_Text__Special == FieldConstants.NULL) {
					executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
					return (String)null;

				} else {
					// no value was set, return default value
					Object fieldDefaultValue_Raw = 
						FieldSet_Worker.getField_DefaultValue(executeInfo, 4, schemaInfo_Positioned);
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
					if (NewsItem_ID__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return NewsItem_ID;

					} else if (NewsItem_ID__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return null;

					} else if (NewsItem_ID__Special == FieldConstants.NULL) {
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

 				case 2:
					if (DateText__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return DateText;

					} else if (DateText__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return null;

					} else if (DateText__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 2, schemaInfo_Positioned);
						return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : null;
					}

 				case 3:
					if (Story_Blurb__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return Story_Blurb;

					} else if (Story_Blurb__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return null;

					} else if (Story_Blurb__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 3, schemaInfo_Positioned);
						return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : null;
					}

 				case 4:
					if (Story_Text__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return Story_Text;

					} else if (Story_Text__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return null;

					} else if (Story_Text__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 4, schemaInfo_Positioned);
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
					if (NewsItem_ID__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return NewsItem_ID;

					} else if (NewsItem_ID__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return (String)null;

					} else if (NewsItem_ID__Special == FieldConstants.NULL) {
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

 				case 2:
					if (DateText__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return DateText;

					} else if (DateText__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return (String)null;

					} else if (DateText__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return (String)null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 2, schemaInfo_Positioned);
						return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
					}

 				case 3:
					if (Story_Blurb__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return Story_Blurb;

					} else if (Story_Blurb__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return (String)null;

					} else if (Story_Blurb__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return (String)null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 3, schemaInfo_Positioned);
						return (fieldDefaultValue_Raw != null) ? (String)fieldDefaultValue_Raw : (String)null;
					}

 				case 4:
					if (Story_Text__Special == FieldConstants.HAS_STANDARD_VALUE) {
						executeInfo.clearResultsInfo();
						return Story_Text;

					} else if (Story_Text__Special == FieldConstants.UNUSED) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_UNUSED);
						return (String)null;

					} else if (Story_Text__Special == FieldConstants.NULL) {
						executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.FieldValue_NULL);
						return (String)null;

					} else {
						// no value was set, return default value
						Object fieldDefaultValue_Raw = 
							FieldSet_Worker.getField_DefaultValue(executeInfo, 4, schemaInfo_Positioned);
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
					if (NewsItem_ID__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					NewsItem_ID = (String)value;
					NewsItem_ID__Special = FieldConstants.HAS_STANDARD_VALUE;
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


 				case 2:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (DateText__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					DateText = (String)value;
					DateText__Special = FieldConstants.HAS_STANDARD_VALUE;
					return;


 				case 3:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (Story_Blurb__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Story_Blurb = (String)value;
					Story_Blurb__Special = FieldConstants.HAS_STANDARD_VALUE;
					return;


 				case 4:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (Story_Text__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Story_Text = (String)value;
					Story_Text__Special = FieldConstants.HAS_STANDARD_VALUE;
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
					if (NewsItem_ID__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					NewsItem_ID = value;
					NewsItem_ID__Special = FieldConstants.HAS_STANDARD_VALUE;
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


 				case 2:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (DateText__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					DateText = value;
					DateText__Special = FieldConstants.HAS_STANDARD_VALUE;
					return;


 				case 3:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (Story_Blurb__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Story_Blurb = value;
					Story_Blurb__Special = FieldConstants.HAS_STANDARD_VALUE;
					return;


 				case 4:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (Story_Text__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Story_Text = value;
					Story_Text__Special = FieldConstants.HAS_STANDARD_VALUE;
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
					if (NewsItem_ID__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					NewsItem_ID__Special = specialValue;
					NewsItem_ID = null;
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


 				case 2:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (DateText__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					DateText__Special = specialValue;
					DateText = null;
					return;


 				case 3:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (Story_Blurb__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Story_Blurb__Special = specialValue;
					Story_Blurb = null;
					return;


 				case 4:
					//  if the previous fieldValue special has not been set, then you are adding a new value. increase count
					if (Story_Text__Special == null) {
						++fieldValue_TotalCount;
						++fieldValue_NonContinuationCount;
					}
					Story_Text__Special = specialValue;
					Story_Text = null;
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
