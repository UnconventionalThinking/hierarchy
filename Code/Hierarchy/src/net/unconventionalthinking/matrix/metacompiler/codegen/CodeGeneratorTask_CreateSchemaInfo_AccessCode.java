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

package net.unconventionalthinking.matrix.metacompiler.codegen;

import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.lang.Task_VTable;
import net.unconventionalthinking.matrix.Descriptor;
import net.unconventionalthinking.matrix.SchemaInfo;
import net.unconventionalthinking.matrix.SchemaInfo_Descriptor;
import net.unconventionalthinking.matrix.SchemaInfo_Field;
import net.unconventionalthinking.matrix.SchemaInfo_FieldSet;
import net.unconventionalthinking.matrix.SchemaInfo_Schema;

/**
 * NOTE: this is a Task (the experimental programming language feature that is corresponds to Use-Cases, called Task-Oriented Programming
 *
 * @author peterjoh
 */
public class CodeGeneratorTask_CreateSchemaInfo_AccessCode {

    public String SchemaInfo_Field__GenerateAccessCode(SchemaInfo thisObj, ExecutionInfo executeInfo, String appControlObjectName,
            String appSymbolsClass_BaseName) {
        executeInfo.reset();

        SchemaInfo parent_SchemaInfo = thisObj.getSchemaInfo_ParentSchemaInfo(executeInfo);


        String schemaInfo_AccessCode = "get_SchemaInfoField(executeInfo, " + appSymbolsClass_BaseName + "_DescTagName." +
                ((SchemaInfo_Field)thisObj).fieldName.getTagName_Symbol().name_IdentFormat + ")";

        if (parent_SchemaInfo != null) {
            return
              ((String)Task_VTable.selectAndInvokeMethod(this, parent_SchemaInfo, executeInfo, appControlObjectName,
                appSymbolsClass_BaseName)) + "." + schemaInfo_AccessCode;

        } else {
            return schemaInfo_AccessCode;
        }

    }
    

    public String SchemaInfo_FieldSet__GenerateAccessCode(SchemaInfo thisObj, ExecutionInfo executeInfo, String appControlObjectName,
            String appSymbolsClass_BaseName) {
        executeInfo.reset();

        SchemaInfo parent_SchemaInfo = thisObj.getSchemaInfo_ParentSchemaInfo(executeInfo);

        String schemaInfo_AccessCode = "get_SchemaInfoFieldSet(executeInfo)";
        
        if (parent_SchemaInfo != null) {
            return
              ((String)Task_VTable.selectAndInvokeMethod(this, parent_SchemaInfo, executeInfo, appControlObjectName,
                appSymbolsClass_BaseName)) + "." + schemaInfo_AccessCode;

        } else {
            return schemaInfo_AccessCode;
        }

    }

    public String SchemaInfo_Descriptor__GenerateAccessCode(SchemaInfo thisObj, ExecutionInfo executeInfo, String appControlObjectName,
            String appSymbolsClass_BaseName) {
        executeInfo.reset();
        SchemaInfo parent_SchemaInfo = thisObj.getSchemaInfo_ParentSchemaInfo(executeInfo);

        String schemaInfo_AccessCode = generateCode__GetChild_SchemaInfoDescriptor((SchemaInfo_Descriptor)thisObj, appSymbolsClass_BaseName);
        if (parent_SchemaInfo != null) {
            return 
              ((String)Task_VTable.selectAndInvokeMethod(this, parent_SchemaInfo, executeInfo, appControlObjectName,
                appSymbolsClass_BaseName)) + "." + schemaInfo_AccessCode;

        } else {
            return schemaInfo_AccessCode;
        }

    }

    /**
     * NOTE: this method will not work in it's current implementation with the Schema_4_SchemaForSchema schemaInfo_Schema object. Why? because
     * it is not also a descriptor, and we cast this object to a descriptor to get at it's label.
     *
     * Why do we get the schemaInfo_Desc obj's label instead of its getSchemaInfo_DescriptorTag()? because of SchemaForSchema's schemaInfo_Schema
     * Object. Its getSchemaInfo_DescriptorTag() return `SCHEMA`, and not the true, underlying label of SCHEMA_FOR_SCHEMA, which is what
     * we really want.
     * @param thisObj
     * @param executeInfo
     * @param appControlObjectName
     * @param appSymbolsClass_BaseName
     * @return
     */
    public String SchemaInfo_Schema__GenerateAccessCode(SchemaInfo thisObj, ExecutionInfo executeInfo, String appControlObjectName,
            String appSymbolsClass_BaseName) {
        executeInfo.reset();

        SchemaInfo parent_SchemaInfo = thisObj.getSchemaInfo_ParentSchemaInfo(executeInfo);

        if (parent_SchemaInfo == null) {
            //  if there is no parent_SchemaInfo, then that means that in the Output Code, we have to find the Schema object from the Schema Index.
            //
            //  Why do we get the schemaInfo_Desc obj's label instead of its getSchemaInfo_DescriptorTag()? because of
            //  SchemaForSchema's schemaInfo_Schema Object. Its getSchemaInfo_DescriptorTag() return `SCHEMA`, and not the true,
            //  underlying label of SCHEMA_FOR_SCHEMA, which is what we want.

            return
                appControlObjectName + ".schemaControl.schemaIndex_Find(" + appSymbolsClass_BaseName + "_SchemaName." +
                ((SchemaInfo_Schema)thisObj).getSchemaInfo_SchemaNameFull().get_Name_IdentFormat() + ")";


        } else {
            String schemaInfo_AccessCode = generateCode__GetChild_SchemaInfoDescriptor((SchemaInfo_Descriptor)thisObj, appSymbolsClass_BaseName);
            return
              ((String)Task_VTable.selectAndInvokeMethod(this, parent_SchemaInfo, executeInfo, appControlObjectName, appSymbolsClass_BaseName)) +
              "." + schemaInfo_AccessCode;
        }


    }



    private static String generateCode__GetChild_SchemaInfoDescriptor(SchemaInfo_Descriptor schemaInfoDesc_to_Get, String appSymbolsClass_BaseName) {
        return "getChild_SchemaInfoDescriptor(executeInfo, " +
                    appSymbolsClass_BaseName + "_DescTag." + schemaInfoDesc_to_Get.getSchemaInfo_DescriptorTag().get_Name_IdentFormat() + ")";
    }

}
