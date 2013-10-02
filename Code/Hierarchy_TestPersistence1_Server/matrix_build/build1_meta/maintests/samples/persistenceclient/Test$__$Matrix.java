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

package maintests.samples.persistenceclient;


import net.unconventionalthinking.exceptions.*;
import net.unconventionalthinking.matrix.*;
import java.util.Arrays;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import java.util.LinkedList;




public class Test$__$Matrix implements MatrixContainer {

	public static Matrix matrix;


	public static Matrix construct(AppControl_Base appControl, ExecutionInfo executeInfo)
		throws Exception_MatrixRuntime_Checked {

		LinkedList<MatrixSet<SchemaInfo_Schema>> schemaSet_ScopeStack = new LinkedList<MatrixSet<SchemaInfo_Schema>>();

		//  Creating Matrix with name, Test.Matrix __________________________________________________
		try {
			schemaSet_ScopeStack.add(new MatrixSet<SchemaInfo_Schema>().add(
				appControl.schemaControl.schemaFactory.get_BaseSchema(executeInfo),
				appControl.schemaControl.schemaForSchema
			));
		} catch (Exception e) {
			throw new Exception_MatrixRuntime_Checked("while trying to create a new Matrix Or Schema descriptor with the name, `Test`.`Matrix`," + 
				" tried to add the Base Schema to the scope stack, but had an error creating it (see inner exception).", e);
		}

		MatrixSet<SchemaInfo_Schema> descriptor53$_X_$MATRIX$_X_$__UsesSchemaSet;
		Descriptor descriptor53$_X_$MATRIX;

		try {
			descriptor53$_X_$MATRIX$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>().add(appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM), appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventional$__$persistence$_CC_$MATRIXPROG$__$PERSISTENCE));
			descriptor53$_X_$MATRIX = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Matrix(executeInfo, AppSymbols_Label.Test$__$Matrix, AppSymbols_DescTagName.maintests$__$samples$__$persistenceclient, true, descriptor53$_X_$MATRIX$_X_$__UsesSchemaSet, null, true, 11);
			schemaSet_ScopeStack.add(descriptor53$_X_$MATRIX$_X_$__UsesSchemaSet);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.BASE::MATRIX, and with label, `Test`.`Matrix`, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventional.persistence::MATRIXPROG.PERSISTENCE::MATRIXPROG.PERSISTENCE.SETTINGS __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor54$_X_$MATRIXPROG_PERSISTENCE_SETTINGS$_X_$__UsesSchemaSet;
		Descriptor descriptor54$_X_$MATRIXPROG_PERSISTENCE_SETTINGS;

		try {
			descriptor54$_X_$MATRIXPROG_PERSISTENCE_SETTINGS$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor54$_X_$MATRIXPROG_PERSISTENCE_SETTINGS = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventional$__$persistence$_CC_$MATRIXPROG$__$PERSISTENCE).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventional$__$persistence$_CC_$MATRIXPROG$__$PERSISTENCE$_CC_$MATRIXPROG$__$PERSISTENCE$__$SETTINGS), null, descriptor54$_X_$MATRIXPROG_PERSISTENCE_SETTINGS$_X_$__UsesSchemaSet, descriptor53$_X_$MATRIX, 12);
			maintests.samples.persistenceclient.FieldSetTuple__net$__$unconventional$__$persistence$_CC_$MATRIXPROG$__$PERSISTENCE$_S_$MATRIXPROG$__$PERSISTENCE$__$SETTINGS descriptor54$_X_$MATRIXPROG_PERSISTENCE_SETTINGS$_X_$__FieldSet = (maintests.samples.persistenceclient.FieldSetTuple__net$__$unconventional$__$persistence$_CC_$MATRIXPROG$__$PERSISTENCE$_S_$MATRIXPROG$__$PERSISTENCE$__$SETTINGS)descriptor54$_X_$MATRIXPROG_PERSISTENCE_SETTINGS.get_FieldSet_Tuple(executeInfo);
			descriptor54$_X_$MATRIXPROG_PERSISTENCE_SETTINGS$_X_$__FieldSet.set_IsPersistentMatrix(executeInfo, AppSymbols.IsPersistent );
			schemaSet_ScopeStack.add(descriptor54$_X_$MATRIXPROG_PERSISTENCE_SETTINGS$_X_$__UsesSchemaSet);
			descriptor53$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor54$_X_$MATRIXPROG_PERSISTENCE_SETTINGS);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventional.persistence::MATRIXPROG.PERSISTENCE::MATRIXPROG.PERSISTENCE.SETTINGS, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `First Name` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor55$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor55$_X_$ITEM;

		try {
			descriptor55$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor55$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("First Name"), 0, true), descriptor55$_X_$ITEM$_X_$__UsesSchemaSet, descriptor53$_X_$MATRIX, 13);
			schemaSet_ScopeStack.add(descriptor55$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor53$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor55$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, First Name, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples.persistenceclient::WEB.FORM::FORM.REQUIRED __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor56$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor56$_X_$FORM_REQUIRED;

		try {
			descriptor56$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor56$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), null, descriptor56$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor55$_X_$ITEM, 14);
			maintests.samples.persistenceclient.FieldSetTuple__maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor56$_X_$FORM_REQUIRED$_X_$__FieldSet = (maintests.samples.persistenceclient.FieldSetTuple__maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor56$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor56$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.IsRequired );
			descriptor56$_X_$FORM_REQUIRED$_X_$__FieldSet.set_RequiredImagePath(executeInfo, "*** TEST PATH 1t ***" );
			descriptor56$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageHeight(executeInfo, 222222 );
			descriptor56$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageWidth(executeInfo, 333333 );
			schemaSet_ScopeStack.add(descriptor56$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor55$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor56$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples.persistenceclient::WEB.FORM::FORM.REQUIRED, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `Last Name` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor57$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor57$_X_$ITEM;

		try {
			descriptor57$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor57$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("Last Name"), 0, true), descriptor57$_X_$ITEM$_X_$__UsesSchemaSet, descriptor53$_X_$MATRIX, 15);
			schemaSet_ScopeStack.add(descriptor57$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor53$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor57$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, Last Name, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples.persistenceclient::WEB.FORM::FORM.REQUIRED __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor58$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor58$_X_$FORM_REQUIRED;

		try {
			descriptor58$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor58$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), null, descriptor58$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor57$_X_$ITEM, 16);
			maintests.samples.persistenceclient.FieldSetTuple__maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor58$_X_$FORM_REQUIRED$_X_$__FieldSet = (maintests.samples.persistenceclient.FieldSetTuple__maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor58$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor58$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.NotRequired );
			descriptor58$_X_$FORM_REQUIRED$_X_$__FieldSet.set_RequiredImagePath(executeInfo, "/images/isRequired" );
			descriptor58$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageHeight(executeInfo, 5 );
			descriptor58$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageWidth(executeInfo, 6 );
			schemaSet_ScopeStack.add(descriptor58$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor57$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor58$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples.persistenceclient::WEB.FORM::FORM.REQUIRED, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples.persistenceclient::WEB.FORM::FORM.SELECTOR __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor59$_X_$FORM_SELECTOR$_X_$__UsesSchemaSet;
		Descriptor descriptor59$_X_$FORM_SELECTOR;

		try {
			descriptor59$_X_$FORM_SELECTOR$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor59$_X_$FORM_SELECTOR = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM$_CC_$FORM$__$SELECTOR), null, descriptor59$_X_$FORM_SELECTOR$_X_$__UsesSchemaSet, descriptor53$_X_$MATRIX, 17);
			schemaSet_ScopeStack.add(descriptor59$_X_$FORM_SELECTOR$_X_$__UsesSchemaSet);
			descriptor53$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor59$_X_$FORM_SELECTOR);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples.persistenceclient::WEB.FORM::FORM.SELECTOR, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `item 1` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor60$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor60$_X_$ITEM;

		try {
			descriptor60$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor60$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("item 1"), 0, true), descriptor60$_X_$ITEM$_X_$__UsesSchemaSet, descriptor59$_X_$FORM_SELECTOR, 18);
			schemaSet_ScopeStack.add(descriptor60$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor59$_X_$FORM_SELECTOR.add_ChildDescriptor(executeInfo, descriptor60$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, item 1, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples.persistenceclient::WEB.FORM::FORM.REQUIRED __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor61$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor61$_X_$FORM_REQUIRED;

		try {
			descriptor61$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor61$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), null, descriptor61$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor60$_X_$ITEM, 19);
			maintests.samples.persistenceclient.FieldSetTuple__maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor61$_X_$FORM_REQUIRED$_X_$__FieldSet = (maintests.samples.persistenceclient.FieldSetTuple__maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor61$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor61$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.IsRequired );
			descriptor61$_X_$FORM_REQUIRED$_X_$__FieldSet.set_RequiredImagePath(executeInfo, "stuff" );
			descriptor61$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageHeight(executeInfo, 22 );
			schemaSet_ScopeStack.add(descriptor61$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor60$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor61$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples.persistenceclient::WEB.FORM::FORM.REQUIRED, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `item 2` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor62$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor62$_X_$ITEM;

		try {
			descriptor62$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor62$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("item 2"), 0, true), descriptor62$_X_$ITEM$_X_$__UsesSchemaSet, descriptor59$_X_$FORM_SELECTOR, 20);
			schemaSet_ScopeStack.add(descriptor62$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor59$_X_$FORM_SELECTOR.add_ChildDescriptor(executeInfo, descriptor62$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, item 2, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples.persistenceclient::WEB.FORM::FORM.REQUIRED __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor63$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor63$_X_$FORM_REQUIRED;

		try {
			descriptor63$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor63$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), null, descriptor63$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor62$_X_$ITEM, 21);
			maintests.samples.persistenceclient.FieldSetTuple__maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor63$_X_$FORM_REQUIRED$_X_$__FieldSet = (maintests.samples.persistenceclient.FieldSetTuple__maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor63$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor63$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.NotRequired );
			descriptor63$_X_$FORM_REQUIRED$_X_$__FieldSet.set_RequiredImagePath(executeInfo, "more stuff" );
			descriptor63$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageHeight(executeInfo, 23 );
			schemaSet_ScopeStack.add(descriptor63$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor62$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor63$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples.persistenceclient::WEB.FORM::FORM.REQUIRED, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples.persistenceclient::WEB.FORM::FORM.SELECTOR, and label, `my`.`formSelector` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor64$_X_$FORM_SELECTOR$_X_$__UsesSchemaSet;
		Descriptor descriptor64$_X_$FORM_SELECTOR;

		try {
			descriptor64$_X_$FORM_SELECTOR$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor64$_X_$FORM_SELECTOR = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM$_CC_$FORM$__$SELECTOR), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("my", "formSelector"), 0, true), descriptor64$_X_$FORM_SELECTOR$_X_$__UsesSchemaSet, descriptor53$_X_$MATRIX, 22);
			schemaSet_ScopeStack.add(descriptor64$_X_$FORM_SELECTOR$_X_$__UsesSchemaSet);
			descriptor53$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor64$_X_$FORM_SELECTOR);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples.persistenceclient::WEB.FORM::FORM.SELECTOR, and with label, `my`.`formSelector`, but had an error", e);
		}

		matrix = (Matrix)descriptor53$_X_$MATRIX;

		return (Matrix)descriptor53$_X_$MATRIX;
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
