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


import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.symbols.*;

import java.util.*;


/**
 *
 * @author peterjoh
 */
public class SchemaForSchema_Container {

    //  SchemaForSchema
    public final SchemaInfo_Schema_Impl             schema4Schema;
    public final SchemaInfo_Descriptor              schema4Schema__SchemaInfoDesc_Descriptor;
    public final SchemaInfo_Descriptor              schema4Schema__DescDescriptor__SchemaInfoDesc_FieldNames;
    public final SchemaInfo_Descriptor              schema4Schema__DescDescriptor__SchemaInfoDesc_FieldTypes;
    public final SchemaInfo_Descriptor              schema4Schema__DescDescriptor__SchemaInfoDesc_FieldDescription;
    public final SchemaInfo_Descriptor              schema4Schema__DescDescriptor__SchemaInfoDesc_FieldDefaults;

    public final SchemaInfo_Descriptor              schema4Schema__SchemaInfoDesc_Schema;
    public final SchemaInfo_Descriptor              schema4Schema__SchemaInfoDesc_Matrix;
    public final SchemaInfo_Descriptor              schema4Schema__SchemaInfoDesc_Item;

    //  Schema for SchemaForSchema
    public final SchemaInfo_Schema                  schema_4_schema4Schema__SchemaInfoSchema;
    public final SchemaInfo_Descriptor              schema_4_Schema4Schema__SchemaInfoDesc_Descriptor;

    public final SchemaInfo_Descriptor              schema_4_Schema4Schema__SchemaInfoDesc_FieldNames;
    public final SchemaInfo_Descriptor              schema_4_Schema4Schema__SchemaInfoDesc_FieldTypes;


    public SchemaForSchema_Container(ExecutionInfo executeInfo, DescriptorControl schema_DescControl,
            SchemaControl_Info schemaControl_Info)
            throws Exception_SchemaInfo, Exception_Descriptor, Exception_InvalidArgumentPassed {



        //  First, setup the schema for the schemaForSchema:
        schema_4_schema4Schema__SchemaInfoSchema = new Schema_for_SchemaForSchema__SchemaInfoSchema(executeInfo, schema_DescControl);

        schema_4_Schema4Schema__SchemaInfoDesc_Descriptor =
                schema_4_schema4Schema__SchemaInfoSchema.getChild_SchemaInfoDescriptor(executeInfo,MPSymbols_DescTagName.DESCRIPTOR);
        schema_4_Schema4Schema__SchemaInfoDesc_FieldNames =
                schema_4_Schema4Schema__SchemaInfoDesc_Descriptor.getChild_SchemaInfoDescriptor(executeInfo,
                MPSymbols_DescTagName.FIELD$__$NAMES);
        schema_4_Schema4Schema__SchemaInfoDesc_FieldTypes =
                schema_4_Schema4Schema__SchemaInfoDesc_Descriptor.getChild_SchemaInfoDescriptor(executeInfo,
                MPSymbols_DescTagName.FIELD$__$TYPES);



        //  Now, build the SchemaForSchema_Container, Schema-Matrix:

        try {
            schema4Schema = new SchemaInfo_Schema_Impl(executeInfo, schema_4_schema4Schema__SchemaInfoSchema,
                MPSymbols_Label.SCHEMA$95$FOR$95$SCHEMA, MPSymbols_DescTagName.net$__$unconventionalthinking$__$matrix, true, null, null, schema_DescControl);

            schema4Schema__SchemaInfoDesc_Descriptor = new SchemaInfo_Descriptor_Impl(executeInfo, schema_4_Schema4Schema__SchemaInfoDesc_Descriptor,
                    MPSymbols_Label.DESCRIPTOR, null, (Descriptor)schema4Schema, schema_DescControl);



            //  DESCRIPTOR `FIELD`.`NAMES`
            schema4Schema__DescDescriptor__SchemaInfoDesc_FieldNames = new SchemaInfo_Descriptor_Impl(executeInfo,
                    schema_4_Schema4Schema__SchemaInfoDesc_Descriptor,
                    MPSymbols_Label.FIELD$__$NAMES, null, (Descriptor)schema4Schema__SchemaInfoDesc_Descriptor, schema_DescControl);

            Descriptor fieldNames_For_FieldNames_Descriptor = new Descriptor(executeInfo,
                    schema_4_Schema4Schema__SchemaInfoDesc_FieldNames,
                    null, null, (Descriptor)schema4Schema__DescDescriptor__SchemaInfoDesc_FieldNames, schema_DescControl);
            FieldSet_Tuple fieldNames_FieldSet = fieldNames_For_FieldNames_Descriptor.get_FieldSet_Tuple(executeInfo);
            fieldNames_FieldSet.setField_DescTagName(executeInfo, 0, MPSymbols_DescTagName.NAMES);

            Descriptor fieldTypes_For_FieldNames_Descriptor = new Descriptor(executeInfo,
                    schema_4_Schema4Schema__SchemaInfoDesc_FieldTypes,
                    null, null, (Descriptor)schema4Schema__DescDescriptor__SchemaInfoDesc_FieldNames, schema_DescControl);
            FieldSet_Tuple fieldTypes_FieldSet = fieldTypes_For_FieldNames_Descriptor.get_FieldSet_Tuple(executeInfo);
            fieldTypes_FieldSet.setField_Symbol(executeInfo, 0, MPSymbols.ContinuationType$__$DescriptorTagName);




            //  DESCRIPTOR `FIELD`.`TYPES`
            schema4Schema__DescDescriptor__SchemaInfoDesc_FieldTypes = new SchemaInfo_Descriptor_Impl(executeInfo,
                    schema_4_Schema4Schema__SchemaInfoDesc_Descriptor,
                    MPSymbols_Label.FIELD$__$TYPES, null, (Descriptor)schema4Schema__SchemaInfoDesc_Descriptor, schema_DescControl);

            Descriptor fieldNames_For_FieldTypes_Descriptor = new Descriptor(executeInfo,
                    schema_4_Schema4Schema__SchemaInfoDesc_FieldNames,
                    null, null, (Descriptor)schema4Schema__DescDescriptor__SchemaInfoDesc_FieldTypes, schema_DescControl);
            fieldNames_FieldSet = fieldNames_For_FieldTypes_Descriptor.get_FieldSet_Tuple(executeInfo);
            fieldNames_FieldSet.setField_DescTagName(executeInfo, 0, MPSymbols_DescTagName.TYPES);

            Descriptor fieldTypes_For_FieldTypes_Descriptor = new Descriptor(executeInfo,
                    schema_4_Schema4Schema__SchemaInfoDesc_FieldTypes,
                    null, null, (Descriptor)schema4Schema__DescDescriptor__SchemaInfoDesc_FieldTypes, schema_DescControl);
            fieldTypes_FieldSet = fieldTypes_For_FieldTypes_Descriptor.get_FieldSet_Tuple(executeInfo);
            fieldTypes_FieldSet.setField_Symbol(executeInfo, 0, MPSymbols.ContinuationType$__$Symbol);




            //  DESCRIPTOR `FIELD`.`DESC`
            schema4Schema__DescDescriptor__SchemaInfoDesc_FieldDescription = new SchemaInfo_Descriptor_Impl(executeInfo,
                    schema_4_Schema4Schema__SchemaInfoDesc_Descriptor,
                    MPSymbols_Label.FIELD$__$DESC, null, (Descriptor)schema4Schema__SchemaInfoDesc_Descriptor, schema_DescControl);

            Descriptor fieldNames_For_FieldDesc_Descriptor = new Descriptor(executeInfo,
                    schema_4_Schema4Schema__SchemaInfoDesc_FieldNames,
                    null, null, (Descriptor)schema4Schema__DescDescriptor__SchemaInfoDesc_FieldDescription, schema_DescControl);
            fieldNames_FieldSet = fieldNames_For_FieldDesc_Descriptor.get_FieldSet_Tuple(executeInfo);
            fieldNames_FieldSet.setField_DescTagName(executeInfo, 0, MPSymbols_DescTagName.DESC);

            Descriptor fieldTypes_For_FieldDesc_Descriptor = new Descriptor(executeInfo,
                    schema_4_Schema4Schema__SchemaInfoDesc_FieldTypes,
                    null, null, (Descriptor)schema4Schema__DescDescriptor__SchemaInfoDesc_FieldDescription, schema_DescControl);
            fieldTypes_FieldSet = fieldTypes_For_FieldDesc_Descriptor.get_FieldSet_Tuple(executeInfo);
            fieldTypes_FieldSet.setField_Symbol(executeInfo, 0, MPSymbols.ContinuationType$__$String);



            //  DESCRIPTOR `FIELD`.`DEFAULTS`
            schema4Schema__DescDescriptor__SchemaInfoDesc_FieldDefaults = new SchemaInfo_Descriptor_Impl(executeInfo,
                    schema_4_Schema4Schema__SchemaInfoDesc_Descriptor,
                    MPSymbols_Label.FIELD$__$DEFAULTS, null, (Descriptor)schema4Schema__SchemaInfoDesc_Descriptor, schema_DescControl);

            Descriptor fieldNames_For_FieldDefaults_Descriptor = new Descriptor(executeInfo,
                    schema_4_Schema4Schema__SchemaInfoDesc_FieldNames,
                    null, null, (Descriptor)schema4Schema__DescDescriptor__SchemaInfoDesc_FieldDefaults, schema_DescControl);
            fieldNames_FieldSet = fieldNames_For_FieldDefaults_Descriptor.get_FieldSet_Tuple(executeInfo);
            fieldNames_FieldSet.setField_DescTagName(executeInfo, 0, MPSymbols_DescTagName.DEFAULTS);

            Descriptor fieldTypes_For_FieldDefaults_Descriptor = new Descriptor(executeInfo,
                    schema_4_Schema4Schema__SchemaInfoDesc_FieldTypes,
                    null, null, (Descriptor)schema4Schema__DescDescriptor__SchemaInfoDesc_FieldDefaults, schema_DescControl);
            fieldTypes_FieldSet = fieldTypes_For_FieldDefaults_Descriptor.get_FieldSet_Tuple(executeInfo);
            fieldTypes_FieldSet.setField_Symbol(executeInfo, 0, MPSymbols.ContinuationType$__$Object);



            /*FIX*/
            //  TODO build fieldset for schemaforschema later on!


            schema4Schema__SchemaInfoDesc_Schema = new SchemaInfo_Descriptor_Impl(executeInfo,
                    schema_4_Schema4Schema__SchemaInfoDesc_Descriptor,
                    MPSymbols_Label.SCHEMA, null, (Descriptor)schema4Schema, schema_DescControl);
            schema4Schema__SchemaInfoDesc_Matrix = new SchemaInfo_Descriptor_Impl(executeInfo,
                    schema_4_Schema4Schema__SchemaInfoDesc_Descriptor,
                    MPSymbols_Label.MATRIX, null, (Descriptor)schema4Schema, schema_DescControl);
            schema4Schema__SchemaInfoDesc_Item = new SchemaInfo_Descriptor_Impl(executeInfo,
                    schema_4_Schema4Schema__SchemaInfoDesc_Descriptor,
                    MPSymbols_Label.ITEM, null, (Descriptor)schema4Schema, schema_DescControl);




            schema4Schema.addChild_SchemaInfoDescriptor(executeInfo, schema4Schema__SchemaInfoDesc_Descriptor);

                schema4Schema__SchemaInfoDesc_Descriptor.addChild_SchemaInfoDescriptor(executeInfo,
                        schema4Schema__DescDescriptor__SchemaInfoDesc_FieldNames);
                    schema4Schema__DescDescriptor__SchemaInfoDesc_FieldNames.addChild_SchemaInfo_FieldDescriptor(executeInfo,
                            fieldNames_For_FieldNames_Descriptor);
                    schema4Schema__DescDescriptor__SchemaInfoDesc_FieldNames.addChild_SchemaInfo_FieldDescriptor(executeInfo,
                            fieldTypes_For_FieldNames_Descriptor);

                schema4Schema__SchemaInfoDesc_Descriptor.addChild_SchemaInfoDescriptor(executeInfo,
                        schema4Schema__DescDescriptor__SchemaInfoDesc_FieldTypes);
                    schema4Schema__DescDescriptor__SchemaInfoDesc_FieldTypes.addChild_SchemaInfo_FieldDescriptor(executeInfo,
                            fieldNames_For_FieldTypes_Descriptor);
                    schema4Schema__DescDescriptor__SchemaInfoDesc_FieldTypes.addChild_SchemaInfo_FieldDescriptor(executeInfo,
                            fieldTypes_For_FieldTypes_Descriptor);

                schema4Schema__SchemaInfoDesc_Descriptor.addChild_SchemaInfoDescriptor(executeInfo,
                        schema4Schema__DescDescriptor__SchemaInfoDesc_FieldDescription);
                    schema4Schema__DescDescriptor__SchemaInfoDesc_FieldDescription.addChild_SchemaInfo_FieldDescriptor(executeInfo,
                            fieldNames_For_FieldDesc_Descriptor);
                    schema4Schema__DescDescriptor__SchemaInfoDesc_FieldDescription.addChild_SchemaInfo_FieldDescriptor(executeInfo,
                            fieldTypes_For_FieldDesc_Descriptor);

                schema4Schema__SchemaInfoDesc_Descriptor.addChild_SchemaInfoDescriptor(executeInfo,
                        schema4Schema__DescDescriptor__SchemaInfoDesc_FieldDefaults);
                    schema4Schema__DescDescriptor__SchemaInfoDesc_FieldDefaults.addChild_SchemaInfo_FieldDescriptor(executeInfo,
                            fieldNames_For_FieldDefaults_Descriptor);
                    schema4Schema__DescDescriptor__SchemaInfoDesc_FieldDefaults.addChild_SchemaInfo_FieldDescriptor(executeInfo,
                            fieldTypes_For_FieldDefaults_Descriptor);

            schema4Schema.addChild_SchemaInfoDescriptor(executeInfo, schema4Schema__SchemaInfoDesc_Schema);
            schema4Schema.addChild_SchemaInfoDescriptor(executeInfo, schema4Schema__SchemaInfoDesc_Matrix);
            schema4Schema.addChild_SchemaInfoDescriptor(executeInfo, schema4Schema__SchemaInfoDesc_Item);


            schema4Schema.initialize_SchemaInfo(executeInfo, schema_DescControl.symbolControl, schemaControl_Info);


        } catch(Exception_SchemaInfo e) {
            throw e;
        } catch(Exception_Descriptor e) {
            throw e;
        }

    }
}
