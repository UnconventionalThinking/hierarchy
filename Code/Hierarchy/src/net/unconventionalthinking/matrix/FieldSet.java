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


package net.unconventionalthinking.matrix;

import net.unconventionalthinking.lang.ExecutionInfo;
import java.util.*;

import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.matrix.utilities.TypeUtilities;


/**
 *
 * @author peterjoh
 */
abstract public class FieldSet extends MatrixElement {

    public enum Type { Tuple, ParameterMap }

    public SchemaInfo_FieldSet      schemaInfo_Positioned;

    protected Descriptor            parentDescriptor;

    protected int                   fieldValue_TotalCount;
    protected int                   fieldValue_NonContinuationCount;





    public FieldSet(ExecutionInfo executeInfo, Descriptor parentDescriptor) {
        executeInfo.reset();

        this.parentDescriptor = parentDescriptor;
        if (parentDescriptor != null && parentDescriptor.schemaInfo_Positioned != null)
            this.schemaInfo_Positioned = parentDescriptor.schemaInfo_Positioned.get_SchemaInfoFieldSet(executeInfo);
        else
            this.schemaInfo_Positioned = null;
    }



    public SchemaInfo getSchemaInfo() { return schemaInfo_Positioned; }

    public Descriptor getParentDescriptor() { return parentDescriptor; }


    

    abstract public Object getField(ExecutionInfo executeInfo, DescriptorTagName fieldname) throws Exception_InvalidArgumentPassed;

    public Object getField(ExecutionInfo executeInfo, String fieldnameString, SymbolControl symbolControl) throws Exception_InvalidArgumentPassed {

        //  remember, eventhough we are creating a new descTag with a false static version, if one already exists with a true
        //  version, it will not set the existing one to false! (and will return this existing one.
        return getField(executeInfo, symbolControl.singleSymbol_Factory.createNew_DescTagName(fieldnameString, false));
    }
    public Object getField(ExecutionInfo executeInfo, List<String> fieldnameStrings, SymbolControl symbolControl)
            throws Exception_InvalidArgumentPassed, Exception_MultiPartSymbolAccess {

        return getField(executeInfo, (DescriptorTagName)symbolControl.multiPartSymbol_Factory.find(SymbolType.DescriptorTagName, fieldnameStrings));
    }

    abstract public Object getField(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed;
    public Object getContinuationField(ExecutionInfo executeInfo, int contField_index) throws Exception_InvalidArgumentPassed {
        return getField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + contField_index));
    }





    public void setField(ExecutionInfo executeInfo, String fieldnameString, SymbolControl symbolControl, Object value, Symbol typeSymbol)
            throws Exception_InvalidArgumentPassed {

        //  remember, eventhough we are creating a new descTag with a false static version, if one already exists with a true
        //  version, it will not set the existing one to false! (and will return this existing one.
         setField(executeInfo, symbolControl.singleSymbol_Factory.createNew_DescTagName(fieldnameString, false), value, typeSymbol);
    }

    public void setField(ExecutionInfo executeInfo, List<String> fieldnameStrings, SymbolControl symbolControl, Object value, Symbol typeSymbol)
            throws Exception_InvalidArgumentPassed, Exception_MultiPartSymbolAccess {

        setField(executeInfo, (DescriptorTagName)symbolControl.multiPartSymbol_Factory.find(SymbolType.DescriptorTagName, fieldnameStrings), value, typeSymbol);
    }
    public void setField(ExecutionInfo executeInfo, DescriptorTagName fieldname, Object value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, fieldname, value, null);
    }
    abstract public void setField(ExecutionInfo executeInfo, DescriptorTagName fieldname, Object value, Symbol typeSymbol) throws Exception_InvalidArgumentPassed ;



    public void setField(ExecutionInfo executeInfo, int index, Object value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, index, value, null);
    }
    abstract public void setField(ExecutionInfo executeInfo, int index, Object value, Symbol typeSymbol) throws Exception_InvalidArgumentPassed;


    public void setContinuationField(ExecutionInfo executeInfo, int continuationIndex, Object value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + continuationIndex), null);
    }
    public void setContinuationField(ExecutionInfo executeInfo, int continuationIndex, Object value, Symbol typeSymbol) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + continuationIndex), typeSymbol);
    }



    abstract public void setField__Special(ExecutionInfo executeInfo, int index, FieldConstants specialValue) throws Exception_InvalidArgumentPassed;
    abstract public void setField__Special(ExecutionInfo executeInfo, DescriptorTagName fieldName, FieldConstants specialValue)
        throws Exception_InvalidArgumentPassed;





    public byte getField_byte(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed {
        return ((Byte)getField(executeInfo, fieldName)).byteValue();
    }
    public void setField_byte(ExecutionInfo executeInfo, DescriptorTagName fieldName, byte value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, fieldName, new Byte(value), MPSymbols.byte$_sym_$);
    }
    public byte getField_byte(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed {
        return ((Byte)getField(executeInfo, index)).byteValue();
    }
    public void setField_byte(ExecutionInfo executeInfo, int index, byte value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, index, new Byte(value), MPSymbols.byte$_sym_$);
    }
    public byte getContinuationField_byte(ExecutionInfo executeInfo, int contField_index) throws Exception_InvalidArgumentPassed {
        return ((Byte)getField(executeInfo, schemaInfo_Positioned.num_NonContinuationFields + contField_index)).byteValue();
    }
    public void setContinuationField_byte(ExecutionInfo executeInfo, int contField_index, byte value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + contField_index), new Byte(value), MPSymbols.byte$_sym_$);
    }


    public short getField_short(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed {
        return ((Short)getField(executeInfo, fieldName)).shortValue();
    }
    public void setField_short(ExecutionInfo executeInfo, DescriptorTagName fieldName, short value) throws Exception_InvalidArgumentPassed  {
        setField(executeInfo, fieldName, new Short(value), MPSymbols.short$_sym_$);
    }
    public short getField_short(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed {
        return ((Short)getField(executeInfo, index)).shortValue();
    }
    public void setField_short(ExecutionInfo executeInfo, int index, short value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, index, new Short(value), MPSymbols.short$_sym_$);
    }
    public short getContinuationField_short(ExecutionInfo executeInfo, int contField_index) throws Exception_InvalidArgumentPassed {
        return ((Short)getField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + contField_index))).shortValue();
    }
    public void setContinuationField_short(ExecutionInfo executeInfo, int contField_index, short value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + contField_index), new Short(value), MPSymbols.short$_sym_$);
    }


    public int getField_int(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed {
        return ((Integer)getField(executeInfo, fieldName)).intValue();
    }
    public void setField_int(ExecutionInfo executeInfo, DescriptorTagName fieldName, int value) throws Exception_InvalidArgumentPassed  {
        setField(executeInfo, fieldName, new Integer(value), MPSymbols.int$_sym_$);
    }
    public int getField_int(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed {
        return ((Integer)getField(executeInfo, index)).intValue();
    }
    public void setField_int(ExecutionInfo executeInfo, int index, int value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, index, new Integer(value), MPSymbols.int$_sym_$);
    }
    public int getContinuationField_int(ExecutionInfo executeInfo, int contField_index) throws Exception_InvalidArgumentPassed {
            return ((Integer)getField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + contField_index))).intValue();
    }
    public void setContinuationField_int(ExecutionInfo executeInfo, int contField_index, int value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + contField_index), new Integer(value), MPSymbols.int$_sym_$);
    }


    public long getField_long(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed {
        return ((Long)getField(executeInfo, fieldName)).longValue();
    }
    public void setField_long(ExecutionInfo executeInfo, DescriptorTagName fieldName, long value) throws Exception_InvalidArgumentPassed  {
        setField(executeInfo, fieldName, new Long(value), MPSymbols.long$_sym_$);
    }
    public long getField_long(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed {
        return ((Long)getField(executeInfo, index)).longValue();
    }
    public void setField_long(ExecutionInfo executeInfo, int index, long value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, index, new Long(value), MPSymbols.long$_sym_$);
    }
    public long getContinuationField_long(ExecutionInfo executeInfo, int contField_index) throws Exception_InvalidArgumentPassed {
        return ((Long)getField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + contField_index))).longValue();
    }
    public void setContinuationField_long(ExecutionInfo executeInfo, int contField_index, long value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + contField_index), new Long(value), MPSymbols.long$_sym_$);
    }


    public float getField_float(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed {
        return ((Float)getField(executeInfo, fieldName)).floatValue();
    }
    public void setField_float(ExecutionInfo executeInfo, DescriptorTagName fieldName, float value) throws Exception_InvalidArgumentPassed  {
        setField(executeInfo, fieldName, new Float(value), MPSymbols.float$_sym_$);
    }
    public float getField_float(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed {
        return ((Float)getField(executeInfo, index)).floatValue();
    }
    public void setField_float(ExecutionInfo executeInfo, int index, float value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, index, new Float(value), MPSymbols.float$_sym_$);
    }
    public float getContinuationField_float(ExecutionInfo executeInfo, int contField_index) throws Exception_InvalidArgumentPassed {
        return ((Float)getField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + contField_index))).floatValue();
    }
    public void setContinuationField_float(ExecutionInfo executeInfo, int contField_index, float value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + contField_index), new Float(value), MPSymbols.float$_sym_$);
    }


    public double getField_double(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed {
        return ((Double)getField(executeInfo, fieldName)).doubleValue();
    }
    public void setField_double(ExecutionInfo executeInfo, DescriptorTagName fieldName, double value) throws Exception_InvalidArgumentPassed  {
        setField(executeInfo, fieldName, new Double(value), MPSymbols.double$_sym_$);
    }
    public double getField_double(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed {
        return ((Double)getField(executeInfo, index)).doubleValue();
    }
    public void setField_double(ExecutionInfo executeInfo, int index, double value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, index, new Double(value), MPSymbols.double$_sym_$);
    }
    public double getContinuationField_double(ExecutionInfo executeInfo, int contField_index) throws Exception_InvalidArgumentPassed {
        return ((Double)getField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + contField_index))).doubleValue();
    }
    public void setContinuationField_double(ExecutionInfo executeInfo, int contField_index, double value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + contField_index), new Double(value), MPSymbols.double$_sym_$);
    }


    public boolean getField_boolean(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed {
        return ((Boolean)getField(executeInfo, fieldName)).booleanValue();
    }
    public void setField_boolean(ExecutionInfo executeInfo, DescriptorTagName fieldName, boolean value) throws Exception_InvalidArgumentPassed  {
        setField(executeInfo, fieldName, new Boolean(value), MPSymbols.boolean$_sym_$);
    }
    public boolean getField_boolean(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed {
        return ((Boolean)getField(executeInfo, index)).booleanValue();
    }
    public void setField_boolean(ExecutionInfo executeInfo, int index, boolean value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, index, new Boolean(value), MPSymbols.boolean$_sym_$);
    }
    public boolean getContinuationField_boolean(ExecutionInfo executeInfo, int contField_index) throws Exception_InvalidArgumentPassed {
        return ((Boolean)getField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + contField_index))).booleanValue();
    }
    public void setContinuationField_boolean(ExecutionInfo executeInfo, int contField_index, boolean value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + contField_index), new Boolean(value), MPSymbols.boolean$_sym_$);
    }


    public char getField_char(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed {
        return ((Character)getField(executeInfo, fieldName)).charValue();
    }
    public void setField_char(ExecutionInfo executeInfo, DescriptorTagName fieldName, char value) throws Exception_InvalidArgumentPassed  {
        setField(executeInfo, fieldName, new Character(value), MPSymbols.char$_sym_$);
    }
    public char getField_char(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed {
        return ((Character)getField(executeInfo, index)).charValue();
    }
    public void setField_char(ExecutionInfo executeInfo, int index, char value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, index, new Character(value), MPSymbols.char$_sym_$);
    }
    public char getContinuationField_char(ExecutionInfo executeInfo, int contField_index) throws Exception_InvalidArgumentPassed {
        return ((Character)getField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + contField_index))).charValue();
    }
    public void setContinuationField_char(ExecutionInfo executeInfo, int contField_index, char value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + contField_index), new Character(value), MPSymbols.char$_sym_$);
    }


    public String getField_String(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed {
        return (String)getField(executeInfo, fieldName);
    }
    public void setField_String(ExecutionInfo executeInfo, DescriptorTagName fieldName, String value) throws Exception_InvalidArgumentPassed  {
        setField(executeInfo, fieldName, value, MPSymbols.String);
    }
    public String getField_String(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed {
        return (String)getField(executeInfo, index);
    }
    public void setField_String(ExecutionInfo executeInfo, int index, String value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, index, value, MPSymbols.String);
    }
    public String getContinuationField_String(ExecutionInfo executeInfo, int contField_index) throws Exception_InvalidArgumentPassed {
        return (String)getField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + contField_index));
    }
    public void setContinuationField_String(ExecutionInfo executeInfo, int contField_index, String value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + contField_index), value, MPSymbols.String);
    }


    public Symbol getField_Symbol(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed {
        return (Symbol)getField(executeInfo, fieldName);
    }
    public void setField_Symbol(ExecutionInfo executeInfo, DescriptorTagName fieldName, Symbol value) throws Exception_InvalidArgumentPassed  {
        setField(executeInfo, fieldName, value, MPSymbols.Symbol);
    }
    public Symbol getField_Symbol(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed {
        return (Symbol)getField(executeInfo, index);
    }
    public void setField_Symbol(ExecutionInfo executeInfo, int index, Symbol value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, index, value, MPSymbols.Symbol);
    }
    public Symbol getContinuationField_Symbol(ExecutionInfo executeInfo, int contField_index) throws Exception_InvalidArgumentPassed {
        return (Symbol)getField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + contField_index));
    }
    public void setContinuationField_Symbol(ExecutionInfo executeInfo, int contField_index, Symbol value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + contField_index), value, MPSymbols.Symbol);
    }


    public DescriptorTagName getField_DescTagName(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed {
        return (DescriptorTagName)getField(executeInfo, fieldName);
    }
    public void setField_DescTagName(ExecutionInfo executeInfo, DescriptorTagName fieldName, DescriptorTagName value) throws Exception_InvalidArgumentPassed  {
        setField(executeInfo, fieldName, value, MPSymbols.DescriptorTagName);
    }
    public DescriptorTagName getField_DescTagName(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed {
        return (DescriptorTagName)getField(executeInfo, index);
    }
    public void setField_DescTagName(ExecutionInfo executeInfo, int index, DescriptorTagName value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, index, value, MPSymbols.DescriptorTagName);
    }
    public DescriptorTagName getContinuationField_DescriptorTagName(ExecutionInfo executeInfo, int contField_index) throws Exception_InvalidArgumentPassed {
        return (DescriptorTagName)getField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + contField_index));
    }
    public void setContinuationField_DescriptorTagName(ExecutionInfo executeInfo, int contField_index, DescriptorTagName value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + contField_index), value, MPSymbols.DescriptorTagName);
    }


    public Label getField_Label(ExecutionInfo executeInfo, DescriptorTagName fieldName) throws Exception_InvalidArgumentPassed {
        return (Label)getField(executeInfo, fieldName);
    }
    public void setField_Label(ExecutionInfo executeInfo, DescriptorTagName fieldName, Label value) throws Exception_InvalidArgumentPassed  {
        setField(executeInfo, fieldName, value, MPSymbols.Label);
    }
    public Label getField_Label(ExecutionInfo executeInfo, int index) throws Exception_InvalidArgumentPassed {
        return (Label)getField(executeInfo, index);
    }
    public void setField_Label(ExecutionInfo executeInfo, int index, Label value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, index, value, MPSymbols.Label);
    }
    public Label getContinuationField_Label(ExecutionInfo executeInfo, int contField_index) throws Exception_InvalidArgumentPassed {
        return (Label)getField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + contField_index));
    }
    public void setContinuationField_Label(ExecutionInfo executeInfo, int contField_index, Label value) throws Exception_InvalidArgumentPassed {
        setField(executeInfo, (schemaInfo_Positioned.num_NonContinuationFields + contField_index), value, MPSymbols.Label);
    }




    public boolean is_SpecializedFieldSet() {
        return false;
    }
    public boolean is_ParameterMap() {
        return false;
    }
    public boolean is_Tuple() {
        return true;
    }
    public int size() {
        return fieldValue_TotalCount;
    }
    public int size_NonContinuationFields() {
        return fieldValue_NonContinuationCount;
    }
    public int size_ContinuationFields() {
        return fieldValue_TotalCount - fieldValue_NonContinuationCount;
    }




    static void test_FieldValueType(ExecutionInfo executeInfo, Symbol typeSymbol, Object value, SchemaInfo_Field schemaInfo_Field)
        throws Exception_InvalidArgumentPassed {

        if (typeSymbol != null) {
            if (!schemaInfo_Field.checkType(typeSymbol)) {
                executeInfo.setErrorMessage("Tried to set a Field value, but the type was not correct. The field, '" + schemaInfo_Field.fieldName.getTagName() +
                        "', expects a " + schemaInfo_Field.fieldType_Symbol_No_ContinuationType.name + " but received a " + typeSymbol.name + ".");
                throw new Exception_InvalidArgumentPassed(executeInfo.getErrorMessage());
            }
        } else { // typesymbol == null
            // for now, do nothing. later on, maybe use reflection to test the type.
        }

    }



    public void print(StringBuilder strBuilder, int indentationLevel) {
        strBuilder.append(": {  ");

        int fieldNum = size_NonContinuationFields();
        boolean hadOne_NonContinuationField = false;

        for (int i = 0; i < fieldNum; ++i) {
            if (i != 0)
                strBuilder.append(", ");


            try {
                Object fieldValue = getField(new ExecutionInfo(), i);
                if (fieldValue != null) {
                    String fieldValueClass = fieldValue.getClass().getName();
                    if (fieldValueClass.equals("java.lang.String"))
                        strBuilder.append("\"" + fieldValue.toString() + "\"");
                    else if (fieldValue instanceof net.unconventionalthinking.matrix.symbols.Symbol) {
                        Symbol fieldValueSymbol = (Symbol)fieldValue;
                        strBuilder.append("`" + fieldValueSymbol + "`");
                    } else
                        strBuilder.append(fieldValue.toString());

                } else
                    strBuilder.append("null");
            } catch (Exception_InvalidArgumentPassed e) {
                strBuilder.append ("****ERROR TRYING TO ACCESS FIELD***: could not get the field at index, " + i +
                        ", in the fieldset\n");
            }

            hadOne_NonContinuationField = true;
        }



        int contFieldNum = size_ContinuationFields();
        for (int i = 0; i < contFieldNum ; ++i) {
            if ( (i == 0 && hadOne_NonContinuationField) || i != 0)
                strBuilder.append(", ");

            if (i == 0)
                strBuilder.append("(Cont Fields) ");

            try {
                Object fieldValue = getField(new ExecutionInfo(), i);
                if (fieldValue != null) {
                    String fieldValueClass = fieldValue.getClass().getName();
                    if (fieldValueClass.equals("java.lang.String"))
                        strBuilder.append("\"" + fieldValue.toString() + "\"");
                    else if (fieldValue instanceof net.unconventionalthinking.matrix.symbols.Symbol) {
                        Symbol fieldValueSymbol = (Symbol)fieldValue;
                        strBuilder.append("`" + fieldValueSymbol + "`");
                    } else
                        strBuilder.append(fieldValue.toString());
                } else
                    strBuilder.append("null");

            } catch (Exception_InvalidArgumentPassed e) {
                strBuilder.append ("****ERROR TRYING TO ACCESS FIELD***: could not get the field at index, " + i +
                        ", in the fieldset\n");
            }
        }

        strBuilder.append("  }");

    }





    public void print_MetaCode(StringBuilder strBuilder, int indentationLevel) {
        strBuilder.append(": {  ");

        int numFieldValues = size_NonContinuationFields();
        boolean hadOne_NonContinuationField = false;

        SchemaInfo_FieldSet schemaInfo_FieldSet = (SchemaInfo_FieldSet)getSchemaInfo();

        for (int i = 0; i < numFieldValues; ++i) {
            if (i != 0)
                strBuilder.append(", ");


            try {
                ExecutionInfo executeInfo = new ExecutionInfo();
                SchemaInfo_Field schemaInfo_Field = schemaInfo_FieldSet.get_SchemaInfoField(executeInfo, i);
                Symbol fieldTypeSymbol = schemaInfo_Field.fieldType_Symbol;
                Object fieldValue = getField(executeInfo, i);


                String valueOut = null;
                
                if (fieldValue != null) {
                    String fieldValueClass = fieldValue.getClass().getName();

                    //  If field is primitive type, print out necessary primitive type modifier
                    if (TypeUtilities.is_PrimitiveType(fieldTypeSymbol)) {
                        if (fieldTypeSymbol == MPSymbols.long$_sym_$) {
                          valueOut = fieldValue + "L";
                        } else if (fieldTypeSymbol == MPSymbols.float$_sym_$) {
                          valueOut = fieldValue + "f";
                        } else if (fieldTypeSymbol == MPSymbols.double$_sym_$) {
                          valueOut = fieldValue + "d";
                        } else if (fieldTypeSymbol == MPSymbols.char$_sym_$) {
                          valueOut = "'" + fieldValue + "'";
                        } else if (fieldTypeSymbol == MPSymbols.boolean$_sym_$) {
                          valueOut = ((Boolean)fieldValue).toString();
                        } else {
                            valueOut = fieldValue.toString();
                        }
                        
                    } else if (fieldValueClass.equals("java.lang.String")) {
                        valueOut = "\"" + fieldValue.toString() + "\"";

                    } else if (fieldValue instanceof net.unconventionalthinking.matrix.symbols.Symbol) {

                        if (fieldValue instanceof Label) {
                            valueOut = "+" + ((Label)fieldValue).getName();
                        } else if (fieldValue instanceof DescriptorTagName) {
                            throw new UnsupportedOperationException("Error in print_MetaCode(): having a field value of DescriptorTagName is unsupported at this time");
                        } else if (fieldValue instanceof DescriptorTag) {
                            throw new UnsupportedOperationException("Error in print_MetaCode(): having a field value of DescriptorTag is unsupported at this time");
                        } else if (fieldValue instanceof MatrixName) {
                            throw new UnsupportedOperationException("Error in print_MetaCode(): having a field value of MatrixName is unsupported at this time");
                        } else if (fieldValue instanceof SchemaPath) {
                            throw new UnsupportedOperationException("Error in print_MetaCode(): having a field value of SchemaPath is unsupported at this time");
                        } else if (fieldValue instanceof DescriptorPath) {
                            throw new UnsupportedOperationException("Error in print_MetaCode(): having a field value of DescriptorPath is unsupported at this time");
                        } else { // just a regular symbol
                            valueOut = printMetaCode_ForSymbolValue((Symbol)fieldValue);
                        }


                    } else
                        valueOut = fieldValue.toString();

                } else
                    valueOut = "null";

                strBuilder.append(valueOut);

            } catch (Exception_InvalidArgumentPassed e) {
                throw new ExceptRuntime_DescriptorAccess("****ERROR TRYING TO ACCESS FIELD***: could not get the field at index, " + i +
                        ", in the fieldset\n");
            }

        }

/*

        int contFieldNum = size_ContinuationFields();
        for (int i = 0; i < contFieldNum ; ++i) {
            if ( (i == 0 && hadOne_NonContinuationField) || i != 0)
                strBuilder.append(", ");


            try {
                Object fieldValue = getField(new ExecutionInfo(), i);
                if (fieldValue != null) {
                    String fieldValueClass = fieldValue.getClass().getName();
                    if (fieldValueClass.equals("java.lang.String"))
                        strBuilder.append("\"" + fieldValue.toString() + "\"");
                    else if (fieldValue instanceof net.unconventionalthinking.matrix.symbols.Symbol) {
                        Symbol fieldValueSymbol = (Symbol)fieldValue;
                        strBuilder.append("`" + fieldValueSymbol + "`");
                    } else
                        strBuilder.append(fieldValue.toString());
                } else
                    strBuilder.append("null");

            } catch (Exception_InvalidArgumentPassed e) {
                strBuilder.append ("****ERROR TRYING TO ACCESS FIELD***: could not get the field at index, " + i +
                        ", in the fieldset\n");
            }
        }
*/
        strBuilder.append("  }");

    }


    public static String printMetaCode_ForSymbolValue(Symbol sym) {
        StringBuilder symbolStringBuilder = new StringBuilder();

        symbolStringBuilder.append("+:");
        boolean is_FirstIter = true;
        for (String symbolPart : sym.getSymbolNames()) {
            if (symbolPart.indexOf(' ') < 0) { // symbol part has no spaces
                symbolStringBuilder.append(symbolPart);

            } else { // symbol part has spaces
                // TODO - there is a bug in the Parttia Symbol grammar. for child symbosl, you have to use the ` char, but this is now only for labels. Once the " char has been added, can remove this if stmt.
                if (is_FirstIter)
                    symbolStringBuilder.append('`').append(symbolPart).append('`');
                else
                    symbolStringBuilder.append('"').append(symbolPart).append('"');
            }
            is_FirstIter = false;

        }

        return symbolStringBuilder.toString();
    }
}
