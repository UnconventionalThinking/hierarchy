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

package maintests.samples.persistenceclient.otherpackage;


import maintests.samples.persistenceclient.AppSymbols_MatrixName;
import maintests.samples.persistenceclient.AppSymbols_DescTag;
import net.unconventionalthinking.exceptions.*;
import net.unconventionalthinking.matrix.*;
import java.util.Arrays;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.*;
import maintests.samples.persistenceclient.AppSymbols_SchemaName;
import maintests.samples.persistenceclient.AppSymbols_Label;
import maintests.samples.persistenceclient.AppSymbols;
import maintests.samples.persistenceclient.AppControl;
import maintests.samples.persistenceclient.AppSymbols_DescTagName;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import java.util.LinkedList;




public class Test$__$Matrix2 implements MatrixContainer {

	public static Matrix matrix;


	public static Matrix construct(AppControl_Base appControl, ExecutionInfo executeInfo)
		throws Exception_MatrixRuntime_Checked {

		LinkedList<MatrixSet<SchemaInfo_Schema>> schemaSet_ScopeStack = new LinkedList<MatrixSet<SchemaInfo_Schema>>();

		//  Creating Matrix with name, Test.Matrix2 __________________________________________________
		try {
			schemaSet_ScopeStack.add(new MatrixSet<SchemaInfo_Schema>().add(
				appControl.schemaControl.schemaFactory.get_BaseSchema(executeInfo),
				appControl.schemaControl.schemaForSchema
			));
		} catch (Exception e) {
			throw new Exception_MatrixRuntime_Checked("while trying to create a new Matrix Or Schema descriptor with the name, `Test`.`Matrix2`," + 
				" tried to add the Base Schema to the scope stack, but had an error creating it (see inner exception).", e);
		}

		MatrixSet<SchemaInfo_Schema> descriptor65$_X_$MATRIX$_X_$__UsesSchemaSet;
		Descriptor descriptor65$_X_$MATRIX;

		try {
			descriptor65$_X_$MATRIX$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>().add(appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM), appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventional$__$persistence$_CC_$MATRIXPROG$__$PERSISTENCE));
			descriptor65$_X_$MATRIX = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Matrix(executeInfo, AppSymbols_Label.Test$__$Matrix2, AppSymbols_DescTagName.maintests$__$samples$__$persistenceclient$__$otherpackage, true, descriptor65$_X_$MATRIX$_X_$__UsesSchemaSet, null, true, 23);
			schemaSet_ScopeStack.add(descriptor65$_X_$MATRIX$_X_$__UsesSchemaSet);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.BASE::MATRIX, and with label, `Test`.`Matrix2`, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventional.persistence::MATRIXPROG.PERSISTENCE::MATRIXPROG.PERSISTENCE.SETTINGS __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor66$_X_$MATRIXPROG_PERSISTENCE_SETTINGS$_X_$__UsesSchemaSet;
		Descriptor descriptor66$_X_$MATRIXPROG_PERSISTENCE_SETTINGS;

		try {
			descriptor66$_X_$MATRIXPROG_PERSISTENCE_SETTINGS$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor66$_X_$MATRIXPROG_PERSISTENCE_SETTINGS = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventional$__$persistence$_CC_$MATRIXPROG$__$PERSISTENCE).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventional$__$persistence$_CC_$MATRIXPROG$__$PERSISTENCE$_CC_$MATRIXPROG$__$PERSISTENCE$__$SETTINGS), null, descriptor66$_X_$MATRIXPROG_PERSISTENCE_SETTINGS$_X_$__UsesSchemaSet, descriptor65$_X_$MATRIX, 24);
			maintests.samples.persistenceclient.FieldSetTuple__net$__$unconventional$__$persistence$_CC_$MATRIXPROG$__$PERSISTENCE$_S_$MATRIXPROG$__$PERSISTENCE$__$SETTINGS descriptor66$_X_$MATRIXPROG_PERSISTENCE_SETTINGS$_X_$__FieldSet = (maintests.samples.persistenceclient.FieldSetTuple__net$__$unconventional$__$persistence$_CC_$MATRIXPROG$__$PERSISTENCE$_S_$MATRIXPROG$__$PERSISTENCE$__$SETTINGS)descriptor66$_X_$MATRIXPROG_PERSISTENCE_SETTINGS.get_FieldSet_Tuple(executeInfo);
			descriptor66$_X_$MATRIXPROG_PERSISTENCE_SETTINGS$_X_$__FieldSet.set_IsPersistentMatrix(executeInfo, AppSymbols.IsPersistent );
			schemaSet_ScopeStack.add(descriptor66$_X_$MATRIXPROG_PERSISTENCE_SETTINGS$_X_$__UsesSchemaSet);
			descriptor65$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor66$_X_$MATRIXPROG_PERSISTENCE_SETTINGS);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventional.persistence::MATRIXPROG.PERSISTENCE::MATRIXPROG.PERSISTENCE.SETTINGS, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `First Name` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor67$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor67$_X_$ITEM;

		try {
			descriptor67$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor67$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("First Name"), 0, true), descriptor67$_X_$ITEM$_X_$__UsesSchemaSet, descriptor65$_X_$MATRIX, 25);
			schemaSet_ScopeStack.add(descriptor67$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor65$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor67$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, First Name, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples.persistenceclient::WEB.FORM::FORM.REQUIRED __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor68$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor68$_X_$FORM_REQUIRED;

		try {
			descriptor68$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor68$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), null, descriptor68$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor67$_X_$ITEM, 26);
			maintests.samples.persistenceclient.FieldSetTuple__maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor68$_X_$FORM_REQUIRED$_X_$__FieldSet = (maintests.samples.persistenceclient.FieldSetTuple__maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor68$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor68$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.IsRequired );
			descriptor68$_X_$FORM_REQUIRED$_X_$__FieldSet.set_RequiredImagePath(executeInfo, "*** TEST PATH 1t ***" );
			descriptor68$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageHeight(executeInfo, 222222 );
			descriptor68$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageWidth(executeInfo, 333333 );
			schemaSet_ScopeStack.add(descriptor68$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor67$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor68$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples.persistenceclient::WEB.FORM::FORM.REQUIRED, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `Company Name` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor69$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor69$_X_$ITEM;

		try {
			descriptor69$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor69$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("Company Name"), 0, true), descriptor69$_X_$ITEM$_X_$__UsesSchemaSet, descriptor65$_X_$MATRIX, 27);
			schemaSet_ScopeStack.add(descriptor69$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor65$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor69$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, Company Name, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples.persistenceclient::WEB.FORM::FORM.REQUIRED __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor70$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor70$_X_$FORM_REQUIRED;

		try {
			descriptor70$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor70$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), null, descriptor70$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor69$_X_$ITEM, 28);
			maintests.samples.persistenceclient.FieldSetTuple__maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor70$_X_$FORM_REQUIRED$_X_$__FieldSet = (maintests.samples.persistenceclient.FieldSetTuple__maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor70$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor70$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.IsRequired );
			descriptor70$_X_$FORM_REQUIRED$_X_$__FieldSet.set_RequiredImagePath(executeInfo, "/images/isRequired" );
			descriptor70$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageHeight(executeInfo, 55 );
			descriptor70$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageWidth(executeInfo, 66 );
			schemaSet_ScopeStack.add(descriptor70$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor69$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor70$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples.persistenceclient::WEB.FORM::FORM.REQUIRED, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples.persistenceclient::WEB.FORM::FORM.SELECTOR, and label, `my`.`formSelector` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor71$_X_$FORM_SELECTOR$_X_$__UsesSchemaSet;
		Descriptor descriptor71$_X_$FORM_SELECTOR;

		try {
			descriptor71$_X_$FORM_SELECTOR$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor71$_X_$FORM_SELECTOR = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM$_CC_$FORM$__$SELECTOR), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("my", "formSelector"), 0, true), descriptor71$_X_$FORM_SELECTOR$_X_$__UsesSchemaSet, descriptor65$_X_$MATRIX, 29);
			schemaSet_ScopeStack.add(descriptor71$_X_$FORM_SELECTOR$_X_$__UsesSchemaSet);
			descriptor65$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor71$_X_$FORM_SELECTOR);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples.persistenceclient::WEB.FORM::FORM.SELECTOR, and with label, `my`.`formSelector`, but had an error", e);
		}

		matrix = (Matrix)descriptor65$_X_$MATRIX;

		return (Matrix)descriptor65$_X_$MATRIX;
	}




	public Class<?> get_AppControl_Class() throws ClassNotFoundException {
		return maintests.samples.persistenceclient.AppControl.class;
	}
	public AppControl_Base initialize_AppControl() { return initialize_AppControl(null, false); }
	public AppControl_Base initialize_AppControl(boolean running_AppControl_forMetacompilation) { return initialize_AppControl(null, running_AppControl_forMetacompilation); }
	public AppControl_Base initialize_AppControl(AppControl_Base existing_AppControl) { return initialize_AppControl(existing_AppControl, false); }
	public AppControl_Base initialize_AppControl(AppControl_Base existing_AppControl, boolean running_AppControl_forMetacompilation) {
		if (existing_AppControl != null)
			return maintests.samples.persistenceclient.AppControl.initializeApp(existing_AppControl, running_AppControl_forMetacompilation);
		else
			return maintests.samples.persistenceclient.AppControl.initializeApp(running_AppControl_forMetacompilation);
	}

	public AppControl_Base get_AppControl() {
		return maintests.samples.persistenceclient.AppControl.appControl;
	}

}
