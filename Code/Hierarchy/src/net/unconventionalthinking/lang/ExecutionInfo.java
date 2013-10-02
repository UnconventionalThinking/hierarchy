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

package net.unconventionalthinking.lang;


import java.util.*;

/**
 *
 * @author peterjoh
 */

//  Why is this final? for performance reasons, so the compiler can inline all these methods
public final class ExecutionInfo {

    public enum ResultType { Result_Empty, Result_One_Item_Found, Result_MoreThanOne_Item_Found, Error, Results_Have_InfoParameters,
                            SchemaStackSearch_FoundInParent, SchemaStackSearch_FoundInStack, FieldSet_CreatedGenericFieldSetTuple, FieldSet_CreatedSpecializedFieldSetTuple,
                            FieldValue_NULL, FieldValue_UNUSED, FieldValue_DEFAULT    }
    public enum ErrorType { Other, MoreThanOne_Item_Found, NullArgument, Argument_WrongType, FieldName_NotValid, Desc_DescTagAndLabel_NotMatch, 
                            AbortAccess, AccessedFieldButNoFieldSetExists, AccessedDescriptorThatWasNotFound }


    private EnumSet<ResultType> resultsInfo = EnumSet.noneOf(ResultType.class);
    private Map<String, Object> infoParameters = null;

    private EnumSet<ErrorType>  errorInfo = EnumSet.noneOf(ErrorType.class);
    private String        errorMessage = null;
    private Exception     errorException = null;


    public final void reset() {

        // Changing the result type happens much more often
        resultsInfo.clear();
        infoParameters = null;

    }



    public boolean              getExecuteInfo_HasBeen_Modfied(){ return !resultsInfo.isEmpty(); }

    public boolean              hadEmptyResultSet(){ return resultsInfo.contains(ResultType.Result_Empty);  }
    public void                 addResultsInfo_EmptyResultSet() { resultsInfo.add(ResultType.Result_Empty); }

    public EnumSet<ResultType>  getResultsInfo(){ return resultsInfo; }
    public void                 setResultsInfoToOneValue(ResultType value) { resultsInfo = EnumSet.of(value); }
    public void                 addResultsInfo(ResultType value) { resultsInfo.add(value); }
    public void                 removeResultsInfo(ResultType value) { resultsInfo.remove(value); }
    public void                 clearResultsInfo() { resultsInfo.clear(); }
    public boolean              containsResult(ResultType value){ return resultsInfo.contains(value);  }
    public boolean              haveEmptyResultsInfo() { return resultsInfo.isEmpty(); }
    public boolean              nothingToReport() { return resultsInfo.isEmpty(); } // alias for "haveEmptyResultsInfo()" method

    /**
     * To use infoParameters, you need to first pass in a new map that you create (the ExecutionInfo does not create one for you).
     * The reasoning behind this is for performance. ExecutionInfo objects get reset almost every method call, and not many methods
     * use info parameters, so, it doesn't create a hashMap object.
     *
     * @return
     */
    public Map<String, Object>  getInfoParameterHash(){ return infoParameters; }
    public void                 setInfoParameterHash(Map<String, Object> value) 
        { infoParameters = value; resultsInfo.add(ResultType.Results_Have_InfoParameters); }



    public boolean      get_HadError(){ return resultsInfo.contains(ResultType.Error); }
    /**
     * If you have an error, must call set_HadError() first! then you can call the other setError messages
     * @param value
     */
    public void         set_HadError()
        { resetErrorFields(); resultsInfo.add(ResultType.Error); }

    public EnumSet<ErrorType>   getErrorInfo(){ return errorInfo; }
    public void                 addErrorInfo(ErrorType value) { resultsInfo.add(ResultType.Error); errorInfo.add(value); }
    public void                 removeErrorInfo(ErrorType value) { errorInfo.remove(value); }
    public void                 clearErrorInfo() { errorInfo.clear(); }
    public boolean              containsError(ErrorType value){ return errorInfo.contains(value);  }

    public String               getErrorMessage(){ return errorMessage; }
    public void                 setErrorMessage(String value) { resultsInfo.add(ResultType.Error); errorMessage = value; }
    public Exception            getErrorException(){ return errorException; }
    public void                 setErrorException(Exception value) { resultsInfo.add(ResultType.Error); errorException = value; }



    private void resetErrorFields() {
        errorInfo.clear();
        errorMessage = null;
        errorException = null;
    }

}
