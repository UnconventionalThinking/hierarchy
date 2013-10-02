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

package net.unconventionalthinking.matrix;

import net.unconventionalthinking.exceptions.*;
import java.util.Arrays;
import net.unconventionalthinking.lang.*;
import java.util.LinkedList;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.*;




public class MyMatrix2 implements MatrixContainer {

	public static Matrix matrix;


	public static Matrix construct(AppControl_Base appControl, ExecutionInfo executeInfo)
		throws Exception_MatrixRuntime_Checked {

		LinkedList<MatrixSet<SchemaInfo_Schema>> schemaSetScopeStack = new LinkedList<MatrixSet<SchemaInfo_Schema>>();

		//  Creating a Matrix with name, MyMatrix2__________________________________________________
		try {
			schemaSetScopeStack.add(new MatrixSet<SchemaInfo_Schema>().add(
				appControl.schemaControl.schemaFactory.get_BaseSchema(executeInfo),
				appControl.schemaControl.schemaForSchema
			));
		} catch (Exception e) {
			throw new Exception_MatrixRuntime_Checked("while trying to create a new Matrix Or Schema descriptor with the name, MyMatrix2," + 
				" tried to add the Base Schema to the scope stack, but had an error creating it (see inner exception).", e);
		}

		MatrixSet<SchemaInfo_Schema> descriptor28$_X_$MATRIX$_X_$__UsesSchemaSet;
		Descriptor descriptor28$_X_$MATRIX;

		try {
			descriptor28$_X_$MATRIX$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>().add(appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM));
			descriptor28$_X_$MATRIX = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Matrix(executeInfo, AppSymbols_Label.MyMatrix2, AppSymbols_DescTagName.net$__$unconventionalthinking$__$matrix, true, descriptor28$_X_$MATRIX$_X_$__UsesSchemaSet, null, true);
			schemaSetScopeStack.add(descriptor28$_X_$MATRIX$_X_$__UsesSchemaSet);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, MATRIX::MATRIX, and with label, MyMatrix2, but had an error", e);
		}


		//  Creating a Descriptor with descriptor tag, FORM.REQUIRED::FORM.REQUIRED, and label, null__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor29$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor29$_X_$FORM_REQUIRED;

		try {
			descriptor29$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor29$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), null, descriptor29$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor28$_X_$MATRIX);
			FieldSet_ParameterMap descriptor29$_X_$FORM_REQUIRED$_X_$__FieldSet = descriptor29$_X_$FORM_REQUIRED.get_FieldSet_ParameterMap(executeInfo);
			descriptor29$_X_$FORM_REQUIRED$_X_$__FieldSet.setField_int(executeInfo, AppSymbols_DescTagName.ImageHeight, 6);
			descriptor29$_X_$FORM_REQUIRED$_X_$__FieldSet.setField__Special(executeInfo, AppSymbols_DescTagName.ImageWidth, FieldConstants.DEFAULT);
			descriptor29$_X_$FORM_REQUIRED$_X_$__FieldSet.setField(executeInfo, AppSymbols_DescTagName.IsRequired, AppSymbols.IsRequired);
			descriptor29$_X_$FORM_REQUIRED$_X_$__FieldSet.setField(executeInfo, AppSymbols_DescTagName.RequiredImagePath, "/images/required.jpg");
			schemaSetScopeStack.add(descriptor29$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor28$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor29$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, FORM.REQUIRED::FORM.REQUIRED, and with an empty label, but had an error", e);
		}


		//  Creating a Descriptor with descriptor tag, TEST.CHILD::TEST.CHILD, and label, null__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor30$_X_$TEST_CHILD$_X_$__UsesSchemaSet;
		Descriptor descriptor30$_X_$TEST_CHILD;

		try {
			descriptor30$_X_$TEST_CHILD$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor30$_X_$TEST_CHILD = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$TEST$__$CHILD), null, descriptor30$_X_$TEST_CHILD$_X_$__UsesSchemaSet, descriptor29$_X_$FORM_REQUIRED);
			FieldSet_ParameterMap descriptor30$_X_$TEST_CHILD$_X_$__FieldSet = descriptor30$_X_$TEST_CHILD.get_FieldSet_ParameterMap(executeInfo);
			descriptor30$_X_$TEST_CHILD$_X_$__FieldSet.setField_int(executeInfo, AppSymbols_DescTagName.Field1int, 111);
			descriptor30$_X_$TEST_CHILD$_X_$__FieldSet.setField(executeInfo, AppSymbols_DescTagName.Field2String, "Test String");
			schemaSetScopeStack.add(descriptor30$_X_$TEST_CHILD$_X_$__UsesSchemaSet);
			descriptor29$_X_$FORM_REQUIRED.add_ChildDescriptor(executeInfo, descriptor30$_X_$TEST_CHILD);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, TEST.CHILD::TEST.CHILD, and with an empty label, but had an error", e);
		}

		matrix = (Matrix)descriptor28$_X_$MATRIX;

		return (Matrix)descriptor28$_X_$MATRIX;
	}




	public Class<?> get_AppControl_Class() throws ClassNotFoundException {
		return net.unconventionalthinking.matrix.AppControl.class;
	}
	public AppControl_Base initialize_AppControl() { return initialize_AppControl(null, false); }
	public AppControl_Base initialize_AppControl(boolean running_AppControl_forMetacompilation) { return initialize_AppControl(null, running_AppControl_forMetacompilation); }
	public AppControl_Base initialize_AppControl(AppControl_Base existing_AppControl) { return initialize_AppControl(existing_AppControl, false); }
	public AppControl_Base initialize_AppControl(AppControl_Base existing_AppControl, boolean running_AppControl_forMetacompilation) {
		if (existing_AppControl != null)
			return net.unconventionalthinking.matrix.AppControl.initializeApp(existing_AppControl, running_AppControl_forMetacompilation);
		else
			return net.unconventionalthinking.matrix.AppControl.initializeApp(running_AppControl_forMetacompilation);
	}

	public AppControl_Base get_AppControl() {
		return net.unconventionalthinking.matrix.AppControl.appControl;
	}

}
