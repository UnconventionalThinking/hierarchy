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

import java.util.*;

import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.*;



/**
 *
 * @author peterjoh
 */
public class SchemaInfo_FieldSet_Utilities {




    public static Object get_OrderBy_PropertyValue_FromField(SchemaInfo_Field schemaInfo_Field, SchemaInfo_FieldSet.OrderBy_Property orderBy_Property) {

        if (orderBy_Property == null ||
            orderBy_Property == SchemaInfo_FieldSet.OrderBy_Property.FieldIndex)
            return new Integer(schemaInfo_Field.fieldIndex);
        else if (orderBy_Property == SchemaInfo_FieldSet.OrderBy_Property.FieldName)
            return schemaInfo_Field.fieldName;
        else if (orderBy_Property == SchemaInfo_FieldSet.OrderBy_Property.FieldType)
            return schemaInfo_Field.fieldType_Symbol;
        else if (orderBy_Property == SchemaInfo_FieldSet.OrderBy_Property.FieldDefaultValue)
            return schemaInfo_Field.fieldDefault;
        else
            return new Integer(schemaInfo_Field.fieldIndex);
    }

    //  move into a utility class
    public static void sort_SchemaInfoFields(List<SchemaInfo_Field> schemaInfo_FieldList,
            SchemaInfo_FieldSet.OrderBy_Property orderBy_Property) throws Exception_SchemaInfo {

        throw new UnsupportedOperationException("sort_SchemaInfoFields() method is not supported yet.");
/*
        if (orderBy_Property == null || orderBy_Property == SchemaInfo_FieldSet.OrderBy_Property.FieldIndex)
            Collections.sort(schemaInfo_FieldList, comparator_FieldIndex);
        else if (orderBy_Property == SchemaInfo_FieldSet.OrderBy_Property.FieldName)
            Collections.sort(schemaInfo_FieldList, comparator_FieldName);
        else if (orderBy_Property == SchemaInfo_FieldSet.OrderBy_Property.FieldType)
            Collections.sort(schemaInfo_FieldList, comparator_FieldType);
        else if (orderBy_Property == SchemaInfo_FieldSet.OrderBy_Property.FieldDefaultValue)
            throw new Exception_SchemaInfo("Trying to sort schemaInfo_Fields by default value. Not allowed at this time!");
        else
            Collections.sort(schemaInfo_FieldList, comparator_FieldIndex);
 */
    }

    public static void sort_SchemaInfoFieldPairs(List<Pair<Object, SchemaInfo_Field>> schemaInfo_FieldList,
            SchemaInfo_FieldSet.OrderBy_Property orderBy_Property) throws Exception_SchemaInfo {

        throw new UnsupportedOperationException("sort_SchemaInfoFields() method is not supported yet.");
  /*
        if (orderBy_Property == null || orderBy_Property == OSchemaInfo_FieldSet.rderBy_Property.FieldIndex)
            Collections.sort(schemaInfo_FieldList, pairComparator_FirstIsInt);
        else if (orderBy_Property == SchemaInfo_FieldSet.OrderBy_Property.FieldName)
            Collections.sort(schemaInfo_FieldList, pairComparator_FirstDescTagName);
        else if (orderBy_Property == SchemaInfo_FieldSet.OrderBy_Property.FieldType)
            Collections.sort(schemaInfo_FieldList, pairComparator_FirstTypeSymbol);
        else if (orderBy_Property == SchemaInfo_FieldSet.OrderBy_Property.FieldDefaultValue)
            throw new Exception_SchemaInfo("Trying to sort schemaInfo_Fields by default value. Not allowed at this time!");
        else
            Collections.sort(schemaInfo_FieldList, pairComparator_FirstIsInt);
  */
    }

}
