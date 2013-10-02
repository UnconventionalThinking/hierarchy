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

import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.matrix.utilities.TypeUtilities;
import java.util.*;


/**
 *
 * @author peterjoh
 */
public class SchemaInfo_Field extends MatrixElement implements SchemaInfo {


    public DescriptorTagName        fieldName;
    public Symbol                   fieldType_Symbol;
    public Symbol                   fieldType_Symbol_No_ContinuationType;

    public String                   fieldDescription;
    public Object                   fieldDefault;


    int                   fieldIndex;
    SchemaInfo_FieldSet   parent_SchemaInfoFieldSet;

    boolean               is_PrimitiveType;
    boolean               is_Continuation_Field;




    SchemaInfo_Field(ExecutionInfo executeInfo, int fieldIndex, SchemaInfo_FieldSet parent_SchemaInfoFieldSet,
                            DescriptorTagName fieldName, Symbol fieldType_Symbol, SymbolControl symbolControl, String fieldDescription)
                            throws Exception_SchemaInfo {
        this(executeInfo, fieldIndex, parent_SchemaInfoFieldSet, fieldName, fieldType_Symbol, symbolControl, fieldDescription, null);
    }
    
    SchemaInfo_Field(ExecutionInfo executeInfo, int fieldIndex, SchemaInfo_FieldSet parent_SchemaInfoFieldSet,
                            DescriptorTagName fieldName, Symbol fieldType_Symbol, SymbolControl symbolControl, String fieldDescription, Object fieldDefault)
        throws Exception_SchemaInfo {

        executeInfo.reset();

        this.fieldName = fieldName;
        this.fieldType_Symbol = fieldType_Symbol;
        this.fieldDescription = fieldDescription;
        this.fieldDefault = fieldDefault;

        this.fieldType_Symbol = fieldType_Symbol;

        this.fieldIndex = fieldIndex;
        this.parent_SchemaInfoFieldSet = parent_SchemaInfoFieldSet;


        is_PrimitiveType = false;
        if (fieldType_Symbol != null) {

            //  first, set hte symbol_No_ContinuationType
            if (fieldType_Symbol.is_Single() || fieldType_Symbol.getSymbol_AtPartNum(1) != MPSymbols.ContinuationType) {
               this.fieldType_Symbol_No_ContinuationType = fieldType_Symbol;

            } else { // must be a multipart symbol that is a continuation
               this.is_Continuation_Field = true;
               try {
                   this.fieldType_Symbol_No_ContinuationType = ((Symbol_MultiPart)fieldType_Symbol).createSymbol_StartingAtLevel(
                                                                symbolControl.multiPartSymbol_Factory, 2, true);
                } catch (Exception_SymbolCreation e) {
                    throw new Exception_SchemaInfo("Tried to create a schemaInfo_FieldSet, " +
                            ((fieldName != null) ? fieldName.toString() : null) +
                            ", with a continunation type. But, while trying to create the non-continuation type, had an error trying to create the new multipart symbol.", e);
                }
            }
            
            //  Now, figure out if this is a primitive type
            is_PrimitiveType = TypeUtilities.is_PrimitiveType(fieldType_Symbol_No_ContinuationType);
        }
    }



    public void setDefaultValue(Object value) {
        fieldDefault = value;
    }

    public void setDefaultValue_byte(byte value) throws Exception_SchemaInfo {
        if (fieldType_Symbol_No_ContinuationType != MPSymbols.byte$_sym_$)
            throw new Exception_SchemaInfo("Tried to set a default value of type 'byte', but the type of this field is:" + ((fieldType_Symbol_No_ContinuationType != null) ? fieldType_Symbol_No_ContinuationType.toString() : null) );
        fieldDefault = new Byte(value);

    }
    public void setDefaultValue_short(short value) throws Exception_SchemaInfo {
        if (fieldType_Symbol_No_ContinuationType != MPSymbols.short$_sym_$)
            throw new Exception_SchemaInfo("Tried to set a default value of type 'short', but the type of this field is:" + ((fieldType_Symbol_No_ContinuationType != null) ? fieldType_Symbol_No_ContinuationType.toString() : null) );
        fieldDefault = new Short(value);
    }
    public void setDefaultValue_int(int value) throws Exception_SchemaInfo {
        if (fieldType_Symbol_No_ContinuationType != MPSymbols.int$_sym_$)
            throw new Exception_SchemaInfo("Tried to set a default value of type 'int', but the type of this field is:" + ((fieldType_Symbol_No_ContinuationType != null) ? fieldType_Symbol_No_ContinuationType.toString() : null) );
        fieldDefault = new Integer(value);
    }
    public void setDefaultValue_long(long value) throws Exception_SchemaInfo {
        if (fieldType_Symbol_No_ContinuationType != MPSymbols.long$_sym_$)
            throw new Exception_SchemaInfo("Tried to set a default value of type 'long', but the type of this field is:" + ((fieldType_Symbol_No_ContinuationType != null) ? fieldType_Symbol_No_ContinuationType.toString() : null) );
        fieldDefault = new Long(value);
    }
    public void setDefaultValue_float(float value) throws Exception_SchemaInfo {
        if (fieldType_Symbol_No_ContinuationType != MPSymbols.float$_sym_$)
            throw new Exception_SchemaInfo("Tried to set a default value of type 'float', but the type of this field is:" + ((fieldType_Symbol_No_ContinuationType != null) ? fieldType_Symbol_No_ContinuationType.toString() : null) );
        fieldDefault = new Float(value);
    }
    public void setDefaultValue_double(double value) throws Exception_SchemaInfo {
        if (fieldType_Symbol_No_ContinuationType != MPSymbols.double$_sym_$)
            throw new Exception_SchemaInfo("Tried to set a default value of type 'double', but the type of this field is:" + ((fieldType_Symbol_No_ContinuationType != null) ? fieldType_Symbol_No_ContinuationType.toString() : null) );
        fieldDefault = new Double(value);
    }
    public void setDefaultValue_char(char value) throws Exception_SchemaInfo {
        if (fieldType_Symbol_No_ContinuationType != MPSymbols.char$_sym_$)
            throw new Exception_SchemaInfo("Tried to set a default value of type 'char', but the type of this field is:" + ((fieldType_Symbol_No_ContinuationType != null) ? fieldType_Symbol_No_ContinuationType.toString() : null) );
        fieldDefault = new Character(value);
    }
    public void setDefaultValue_boolean(boolean value) throws Exception_SchemaInfo {
        if (fieldType_Symbol_No_ContinuationType != MPSymbols.boolean$_sym_$)
            throw new Exception_SchemaInfo("Tried to set a default value of type 'boolean', but the type of this field is:" + ((fieldType_Symbol_No_ContinuationType != null) ? fieldType_Symbol_No_ContinuationType.toString() : null) );
        fieldDefault = new Boolean(value);
    }



    public void initialize_SchemaInfo(ExecutionInfo executeInfo, SymbolControl symbolControl, SchemaControl_Info schemaControl_Info) throws Exception_SchemaInfo {
        //  Nothing needs to be done, it's all done in the constructor.
    }


    /**
     * SchemaInfo_Fields don't have schemaInfo's return null;
     * @return
     */
    public SchemaInfo getSchemaInfo() { return null; }


    public DescriptorTagName        getFieldName() { return fieldName; }
    public Symbol                   getFieldType_Symbol() { return fieldType_Symbol; }
    public Symbol                   getFieldType_Symbol_No_ContinuationType() { return fieldType_Symbol_No_ContinuationType; }
    public String                   getFieldDescription() { return fieldDescription; }
    public Object                   getFieldDefault() { return fieldDefault; }

    public void                     setFieldName(DescriptorTagName value) { fieldName = value; }
    public void                     setFieldType_Symbol(Symbol value) { fieldType_Symbol = value; }
    public void                     setFieldType_Symbol_No_Continuation(Symbol value) { fieldType_Symbol_No_ContinuationType = value; }
    public void                     setFieldDescription(String value) { fieldDescription = value; }
    public void                     setFieldDefault(Object value) { fieldDefault = value; }


    public int                      getFieldIndex() { return fieldIndex; }
    public boolean                  is_ContinuationField() { return is_Continuation_Field; }






    public SchemaInfo getSchemaInfo_ParentSchemaInfo(ExecutionInfo executeInfo) {
        return parent_SchemaInfoFieldSet;
    }


    public DescriptorTagName getSchemaInfo_DescriptorTagName() {
        return fieldName;
    }

    public DescriptorTag getSchemaInfo_DescriptorTag() {
        throw new UnsupportedOperationException("Not supported yet.");
    }




    public void getSchemaInfo_DescTagName_FullPath(ExecutionInfo executeInfo, List<Symbol_Base> nameSymbols) {
        parent_SchemaInfoFieldSet.getSchemaInfo_DescTagName_FullPath(executeInfo, nameSymbols);
        nameSymbols.add(fieldName);
    }
    public String getSchemaInfo_DescTagName_FullPath_String(ExecutionInfo executeInfo) {
        return parent_SchemaInfoFieldSet.getSchemaInfo_DescTagName_FullPath_String(executeInfo) + SymbolConstants.SymbolPath_SymbolSeparator
                + fieldName.getTagName();
    }
    public String getSchemaInfo_DescTagName_FullPath_IdentFormat(ExecutionInfo executeInfo) {
        return parent_SchemaInfoFieldSet.getSchemaInfo_DescTagName_FullPath_IdentFormat(executeInfo) + SymbolConstants.SymbolPath_SymbolSeparator_IdentFormat
                + fieldName.getTagName();
    }

    public Type getSchemaInfo_SchemaInfoType() {
        return Type.SchemaInfoField;
    }

    public SchemaInfo_Schema getSchemaInfo__Ancestor_SchemaInfoSchema() {
        return parent_SchemaInfoFieldSet.getSchemaInfo__Ancestor_SchemaInfoSchema();
    }
    public MatrixName getSchemaInfo_SchemaNameFull() {
        return parent_SchemaInfoFieldSet.getSchemaInfo_SchemaNameFull();
    }



    public boolean checkType(Symbol typeSymbol) {
        return (typeSymbol == fieldType_Symbol_No_ContinuationType);
    }


}
