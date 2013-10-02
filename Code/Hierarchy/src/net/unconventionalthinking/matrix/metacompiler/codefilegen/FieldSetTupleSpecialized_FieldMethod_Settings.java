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

package net.unconventionalthinking.matrix.metacompiler.codefilegen;

import net.unconventionalthinking.matrix.metacompiler.codegen.*;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.Exception_SchemaInfo;
import net.unconventionalthinking.matrix.SchemaInfo_Field;
import net.unconventionalthinking.matrix.SchemaInfo_FieldSet;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.utilities.TypeUtilities;
import java.util.List;


/**
 *
 * @author peterjoh
 */
class FieldSetTupleSpecialized_FieldMethod_Settings {


    String getMethodName;
    String setMethodName;
    String typeOrObjectString;
    List<SchemaInfo_Field> fields_TypeFiltered;

    boolean createTypedMethod;
    Symbol fieldType;

    boolean checkForOverrideMethod;
    boolean is_OverrideMethod;


    
    static FieldSetTupleSpecialized_FieldMethod_Settings setup_GetAndSet_MethodInfo(ExecutionInfo executeInfo, boolean createTypedMethod,
            Symbol fieldType, SchemaInfo_FieldSet schemaInfo_Fieldset) throws Exception_MetaCompilerError {

        return setup_GetAndSet_MethodInfo(executeInfo, createTypedMethod, fieldType, schemaInfo_Fieldset, false, false);
    }
    
    static FieldSetTupleSpecialized_FieldMethod_Settings setup_GetAndSet_MethodInfo(ExecutionInfo executeInfo, boolean createTypedMethod, 
            Symbol fieldType, SchemaInfo_FieldSet schemaInfo_Fieldset,
            boolean checkForOverrideMethod, boolean createSpecialValueMethod) throws Exception_MetaCompilerError {

        FieldSetTupleSpecialized_FieldMethod_Settings fieldMethod_Settings = new FieldSetTupleSpecialized_FieldMethod_Settings();

        fieldMethod_Settings.createTypedMethod = createTypedMethod;
        fieldMethod_Settings.fieldType = fieldType;


        fieldMethod_Settings.getMethodName = (createTypedMethod) ? "getField_" + fieldType.name_IdentFormat : "getField";
        fieldMethod_Settings.setMethodName = (createTypedMethod) ? "setField_" + fieldType.name_IdentFormat : "setField";
        fieldMethod_Settings.typeOrObjectString = (createTypedMethod) ? fieldType.name_no_backtiks : "Object";

        fieldMethod_Settings.checkForOverrideMethod = checkForOverrideMethod;
        if (checkForOverrideMethod) {
            fieldMethod_Settings.is_OverrideMethod = (createSpecialValueMethod || !createTypedMethod ||
                (createTypedMethod && (TypeUtilities.is_PrimitiveType(fieldType) || fieldType == MPSymbols.Symbol || fieldType == MPSymbols.String)) );
        } else {
            fieldMethod_Settings.is_OverrideMethod = false;
        }

        if (createTypedMethod) {
            try {
                fieldMethod_Settings.fields_TypeFiltered = schemaInfo_Fieldset.get_FieldList(executeInfo, fieldType,
                        SchemaInfo_FieldSet.OrderBy_Property.FieldIndex);
            } catch (Exception_SchemaInfo e) {
                throw new Exception_MetaCompilerError("Tried to get a filtered field list for the primitive type, "  + fieldType +
                        ", but the scheamInfo_Fieldset.get_FieldList method threw an exception: " + e.getMessage(), e);
            }
        } else
            fieldMethod_Settings.fields_TypeFiltered = schemaInfo_Fieldset.get_SchemaInfoFields();

        return fieldMethod_Settings;
    }



}
