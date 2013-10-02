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
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.matrix.*;




public class MyMatrix1 implements MatrixContainer {

	public static Matrix matrix;


	public static Matrix construct(AppControl_Base appControl, ExecutionInfo executeInfo)
		throws Exception_MatrixRuntime_Checked {

		LinkedList<MatrixSet<SchemaInfo_Schema>> schemaSet_ScopeStack = new LinkedList<MatrixSet<SchemaInfo_Schema>>();

		//  Creating a Matrix with name, MyMatrix1__________________________________________________
		try {
			schemaSet_ScopeStack.add(new MatrixSet<SchemaInfo_Schema>().add(
				appControl.schemaControl.schemaFactory.get_BaseSchema(executeInfo),
				appControl.schemaControl.schemaForSchema
			));
		} catch (Exception e) {
			throw new Exception_MatrixRuntime_Checked("while trying to create a new Matrix Or Schema descriptor with the name, MyMatrix1," + 
				" tried to add the Base Schema to the scope stack, but had an error creating it (see inner exception).", e);
		}

		MatrixSet<SchemaInfo_Schema> descriptor0$_X_$MATRIX$_X_$__UsesSchemaSet;
		Descriptor descriptor0$_X_$MATRIX;

		try {
			descriptor0$_X_$MATRIX$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>().add(appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM));
			descriptor0$_X_$MATRIX = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Matrix(executeInfo, AppSymbols_Label.MyMatrix1, AppSymbols_DescTagName.net$__$unconventionalthinking$__$matrix, true, descriptor0$_X_$MATRIX$_X_$__UsesSchemaSet, null, true);
			schemaSet_ScopeStack.add(descriptor0$_X_$MATRIX$_X_$__UsesSchemaSet);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, MATRIX::MATRIX, and with label, MyMatrix1, but had an error", e);
		}


		//  Creating a Descriptor with descriptor tag, FORM.REQUIRED::FORM.REQUIRED, and label, null__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor1$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor1$_X_$FORM_REQUIRED;

		try {
			descriptor1$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor1$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), null, descriptor1$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor0$_X_$MATRIX);
			net.unconventionalthinking.matrix.FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor1$_X_$FORM_REQUIRED$_X_$__FieldSet = (net.unconventionalthinking.matrix.FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor1$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor1$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.IsRequired);
			descriptor1$_X_$FORM_REQUIRED$_X_$__FieldSet.set_RequiredImagePath(executeInfo, "/images/required.jpg");
			descriptor1$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageHeight(executeInfo, 6);
			descriptor1$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageWidth__Special(executeInfo, FieldConstants.DEFAULT);
			schemaSet_ScopeStack.add(descriptor1$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor0$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor1$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, FORM.REQUIRED::FORM.REQUIRED, and with an empty label, but had an error", e);
		}


		//  Creating a Descriptor with descriptor tag, TEST.CHILD::TEST.CHILD, and label, null__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor2$_X_$TEST_CHILD$_X_$__UsesSchemaSet;
		Descriptor descriptor2$_X_$TEST_CHILD;

		try {
			descriptor2$_X_$TEST_CHILD$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor2$_X_$TEST_CHILD = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$TEST$__$CHILD), null, descriptor2$_X_$TEST_CHILD$_X_$__UsesSchemaSet, descriptor1$_X_$FORM_REQUIRED);
			FieldSet descriptor2$_X_$TEST_CHILD$_X_$__FieldSet = descriptor2$_X_$TEST_CHILD.get_FieldSet_Tuple(executeInfo);
			descriptor2$_X_$TEST_CHILD$_X_$__FieldSet.setField_int(executeInfo, 0, 111);
			descriptor2$_X_$TEST_CHILD$_X_$__FieldSet.setField(executeInfo, 1, "Test String");
			schemaSet_ScopeStack.add(descriptor2$_X_$TEST_CHILD$_X_$__UsesSchemaSet);
			descriptor1$_X_$FORM_REQUIRED.add_ChildDescriptor(executeInfo, descriptor2$_X_$TEST_CHILD);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, TEST.CHILD::TEST.CHILD, and with an empty label, but had an error", e);
		}


		//  Creating a Descriptor with descriptor tag, FORM.REQUIRED::FORM.REQUIRED, and label, null__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor3$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor3$_X_$FORM_REQUIRED;

		try {
			descriptor3$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor3$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), null, descriptor3$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor2$_X_$TEST_CHILD);
			net.unconventionalthinking.matrix.FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor3$_X_$FORM_REQUIRED$_X_$__FieldSet = (net.unconventionalthinking.matrix.FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor3$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor3$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.NotRequired);
			schemaSet_ScopeStack.add(descriptor3$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor2$_X_$TEST_CHILD.add_ChildDescriptor(executeInfo, descriptor3$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, FORM.REQUIRED::FORM.REQUIRED, and with an empty label, but had an error", e);
		}




		//  Creating a Descriptor with descriptor tag, TEST.CONT::TEST.CONT, and label, null__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor4$_X_$TEST_CONT$_X_$__UsesSchemaSet;
		Descriptor descriptor4$_X_$TEST_CONT;

		try {
			descriptor4$_X_$TEST_CONT$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor4$_X_$TEST_CONT = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$WEB$__$FORM$_CC_$TEST$__$CONT), null, descriptor4$_X_$TEST_CONT$_X_$__UsesSchemaSet, descriptor0$_X_$MATRIX);
			FieldSet descriptor4$_X_$TEST_CONT$_X_$__FieldSet = descriptor4$_X_$TEST_CONT.get_FieldSet_Tuple(executeInfo);
			descriptor4$_X_$TEST_CONT$_X_$__FieldSet.setField_int(executeInfo, 0, 1111);
			descriptor4$_X_$TEST_CONT$_X_$__FieldSet.setField_int(executeInfo, 1, 1);
			descriptor4$_X_$TEST_CONT$_X_$__FieldSet.setField_int(executeInfo, 2, 2);
			descriptor4$_X_$TEST_CONT$_X_$__FieldSet.setField_int(executeInfo, 3, 3);
			schemaSet_ScopeStack.add(descriptor4$_X_$TEST_CONT$_X_$__UsesSchemaSet);
			descriptor0$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor4$_X_$TEST_CONT);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, TEST.CONT::TEST.CONT, and with an empty label, but had an error", e);
		}

		matrix = (Matrix)descriptor0$_X_$MATRIX;

		return (Matrix)descriptor0$_X_$MATRIX;
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
