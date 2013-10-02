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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.unconventionalthinking.matrix.metacompiler.codegen;

import net.unconventionalthinking.lang.Pair;
import net.unconventionalthinking.matrix.Descriptor;
import net.unconventionalthinking.matrix.DescriptorDescription;
import net.unconventionalthinking.matrix.Matrix;
import net.unconventionalthinking.matrix.Schema;
import net.unconventionalthinking.matrix.SchemaInfo_Descriptor;
import net.unconventionalthinking.matrix.SchemaInfo_Descriptor_Impl;
import net.unconventionalthinking.matrix.SchemaInfo_Schema_Impl;
import net.unconventionalthinking.matrix.symbols.DescriptorTag;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.MPSymbols_DescTag;
import net.unconventionalthinking.matrix.symbols.MPSymbols_DescTagName;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author peterjoh
 */
public class DescriptorCodeGenerator_Utilities {


    /**
     * Determine if the desc tag should be MATRIX, SCHEMA, the descTag that was passed in, or DESCRIPTOR (for schemaInfo Descriptors)
     */
    public static DescriptorTag determine_DescriptorTag(Symbol building_MatrixOrSchemaElem, boolean creating_Initial_MatrixOrSchema_Descriptor) {

        DescriptorTag descTag = null;

        if (creating_Initial_MatrixOrSchema_Descriptor) {
            if (building_MatrixOrSchemaElem == MPSymbols.BuildingMatrixElement)
                descTag = MPSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$BASE$_CC_$MATRIX;
            else
                descTag = MPSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$SCHEMA;
        } else {
            if (building_MatrixOrSchemaElem == MPSymbols.BuildingMatrixElement || building_MatrixOrSchemaElem == MPSymbols.BuildingMatrixElementForSchema)
                descTag = null; // should have passed in the descTag
            else
                descTag = MPSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR;
        }
        return descTag;
    }



    public static String determine_DescriptorType_String(Symbol building_MatrixOrSchemaElem, boolean creating_Initial_MatrixOrSchema_Descriptor) {

        if (creating_Initial_MatrixOrSchema_Descriptor) {
            if (building_MatrixOrSchemaElem == MPSymbols.BuildingMatrixElement)
                return Matrix.class.getSimpleName();
            else
                return SchemaInfo_Schema_Impl.class.getSimpleName();
        } else {
            if (building_MatrixOrSchemaElem == MPSymbols.BuildingMatrixElement || building_MatrixOrSchemaElem == MPSymbols.BuildingMatrixElementForSchema)
                return Descriptor.class.getSimpleName();
            else
                return SchemaInfo_Descriptor_Impl.class.getSimpleName();
        }
    }



    public static DescriptorDescription.Types determine_DescriptorType(Symbol building_MatrixOrSchemaElem, boolean creating_Initial_MatrixOrSchema_Descriptor) {
        if (creating_Initial_MatrixOrSchema_Descriptor) {
            if (building_MatrixOrSchemaElem == MPSymbols.BuildingMatrixElement)
                return DescriptorDescription.Types.Matrix;
            else
                return DescriptorDescription.Types.Schema;
        } else {
            if (building_MatrixOrSchemaElem == MPSymbols.BuildingMatrixElement || building_MatrixOrSchemaElem == MPSymbols.BuildingMatrixElementForSchema)
                return DescriptorDescription.Types.Descriptor;
            else
                return DescriptorDescription.Types.SchemaInfo_Descriptor;
        }
    }

    public static String determine_DescriptorFactoryMethod_Code(Symbol building_MatrixOrSchemaElem, boolean creating_Initial_MatrixOrSchema_Descriptor) {

        if (creating_Initial_MatrixOrSchema_Descriptor) {
            if (building_MatrixOrSchemaElem == MPSymbols.BuildingMatrixElement)
                return "matrixControl.matrixFactory.createNew_Matrix";
            else
                return "schemaControl.schemaFactory.createNew_Schema";
        } else {
            if (building_MatrixOrSchemaElem == MPSymbols.BuildingMatrixElement || building_MatrixOrSchemaElem == MPSymbols.BuildingMatrixElementForSchema)
                return "matrixControl.matrixFactory.createNew_Descriptor";
            else
                return "schemaControl.schemaFactory.createNew_SchemaInfoDescriptor";
        }
    }


    public static Pair<Label, String> createLabelAndLabelString(List<String> label_Parts, int label_CreationStartLevel, SymbolControl symbolControl)
        throws Exception_MetaCompilerError {

        Pair<Label, String> labelInfo = new Pair<Label, String>();

        String labelString = null;
        if (label_Parts != null && label_Parts.size() > 0) {
            for (int i = 0; i < label_Parts.size(); ++i) {
                if (i == 0) {
                    labelString  = "`" + label_Parts.get(i) + "`";
                } else {
                    labelString += ".`" + label_Parts.get(i) + "`";
                }
            }
            try {
                labelInfo.first = symbolControl.multiPartSymbol_Factory.createNew_Label(label_Parts, label_CreationStartLevel, true);
            } catch (Exception e) {
                throw new Exception_MetaCompilerError("As we were constructing the label, '" + labelString + "', " +
                        "with a creation level of " + Integer.toString(label_CreationStartLevel) +
                        ", had an error.", e);
            }
            
            labelInfo.second = labelString;
        }
        return labelInfo;
    }

    public static String determine_AddChildDescriptor_Method(Symbol buildingMatrixOrSchemaElem, DescriptorTagName descriptorTagName) {
        Descriptor d;
        SchemaInfo_Descriptor sid;

        if (buildingMatrixOrSchemaElem == MPSymbols.BuildingMatrixElement) {
            return "add_ChildDescriptor";

        } else { // adding schema descriptors
            if (buildingMatrixOrSchemaElem == MPSymbols.BuildingSchemaElement)
                return "addChild_SchemaInfoDescriptor";
            else if (buildingMatrixOrSchemaElem == MPSymbols.BuildingMatrixElementForSchema
                      && descriptorTagName.getDescTagName_AtPartNum(1) == MPSymbols_DescTagName.FIELD)  //  This is a FIELD.* descriptor, like FIELD.NAMES
                return "addChild_SchemaInfo_FieldDescriptor";
            else
                return "add_ChildDescriptor";
        }
    }
    /**
     * This method is used with the method right above this one, determine_AddChildDescriptor_Method(). When you add a child descriptor using all the
     * the addChildDesc methods except addChild_SchemaInfoDescriptor(), it takes in just a Descriptor as the child to add. But, the
     *  addChild_SchemaInfoDescriptor() takes in a SchemaInfo_Descriptor.
     */
    public static String determine_AddChildDescriptor_Parameter_Cast(Symbol buildingMatrixOrSchemaElem, DescriptorTagName descriptorTagName) {
        if (buildingMatrixOrSchemaElem == MPSymbols.BuildingSchemaElement && descriptorTagName == MPSymbols_DescTagName.DESCRIPTOR) {
            return "(SchemaInfo_Descriptor)";
        } else {
            return ""; // no cast necessary for the others.
        }
    }
}
