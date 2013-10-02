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

package maintests.samples;

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

		MatrixSet<SchemaInfo_Schema> descriptor68$_X_$MATRIX$_X_$__UsesSchemaSet;
		Descriptor descriptor68$_X_$MATRIX;

		try {
			descriptor68$_X_$MATRIX$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>().add(appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$WEB$__$FORM));
			descriptor68$_X_$MATRIX = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Matrix(executeInfo, AppSymbols_Label.Test$__$Matrix, AppSymbols_DescTagName.maintests$__$samples, true, descriptor68$_X_$MATRIX$_X_$__UsesSchemaSet, null, true);
			schemaSet_ScopeStack.add(descriptor68$_X_$MATRIX$_X_$__UsesSchemaSet);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.BASE::MATRIX, and with label, `Test`.`Matrix`, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `First Name` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor69$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor69$_X_$ITEM;

		try {
			descriptor69$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor69$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("First Name"), 0, true), descriptor69$_X_$ITEM$_X_$__UsesSchemaSet, descriptor68$_X_$MATRIX);
			schemaSet_ScopeStack.add(descriptor69$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor68$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor69$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, First Name, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::WEB.FORM::FORM.REQUIRED __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor70$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor70$_X_$FORM_REQUIRED;

		try {
			descriptor70$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor70$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), null, descriptor70$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor69$_X_$ITEM);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor70$_X_$FORM_REQUIRED$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor70$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor70$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.IsRequired );
			descriptor70$_X_$FORM_REQUIRED$_X_$__FieldSet.set_RequiredImagePath(executeInfo, TestConstants . RequiredImagePath );
			descriptor70$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageHeight(executeInfo, 5 );
			descriptor70$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageWidth(executeInfo, 6 );
			schemaSet_ScopeStack.add(descriptor70$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor69$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor70$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::WEB.FORM::FORM.REQUIRED, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `Last Name` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor71$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor71$_X_$ITEM;

		try {
			descriptor71$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor71$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("Last Name"), 0, true), descriptor71$_X_$ITEM$_X_$__UsesSchemaSet, descriptor68$_X_$MATRIX);
			schemaSet_ScopeStack.add(descriptor71$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor68$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor71$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, Last Name, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::WEB.FORM::FORM.REQUIRED __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor72$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor72$_X_$FORM_REQUIRED;

		try {
			descriptor72$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor72$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), null, descriptor72$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor71$_X_$ITEM);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor72$_X_$FORM_REQUIRED$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor72$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor72$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.NotRequired );
			descriptor72$_X_$FORM_REQUIRED$_X_$__FieldSet.set_RequiredImagePath(executeInfo, "/images/isRequired" );
			descriptor72$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageHeight(executeInfo, 5 );
			descriptor72$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageWidth(executeInfo, 6 );
			schemaSet_ScopeStack.add(descriptor72$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor71$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor72$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::WEB.FORM::FORM.REQUIRED, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `Two`.`Part Label` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor73$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor73$_X_$ITEM;

		try {
			descriptor73$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor73$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("Two", "Part Label"), 0, true), descriptor73$_X_$ITEM$_X_$__UsesSchemaSet, descriptor68$_X_$MATRIX);
			schemaSet_ScopeStack.add(descriptor73$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor68$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor73$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, `Two`.`Part Label`, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::WEB.FORM::FORM.REQUIRED, and label, `Test`.`Label` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor74$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor74$_X_$FORM_REQUIRED;

		try {
			descriptor74$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor74$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("Test", "Label"), 0, true), descriptor74$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor73$_X_$ITEM);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor74$_X_$FORM_REQUIRED$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor74$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor74$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.IsRequired );
			descriptor74$_X_$FORM_REQUIRED$_X_$__FieldSet.set_RequiredImagePath(executeInfo, TestConstants . RequiredImagePath );
			descriptor74$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageHeight(executeInfo, 5 );
			descriptor74$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageWidth(executeInfo, 6 );
			schemaSet_ScopeStack.add(descriptor74$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor73$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor74$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::WEB.FORM::FORM.REQUIRED, and with label, `Test`.`Label`, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::WEB.FORM::FORM.SELECTOR __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor75$_X_$FORM_SELECTOR$_X_$__UsesSchemaSet;
		Descriptor descriptor75$_X_$FORM_SELECTOR;

		try {
			descriptor75$_X_$FORM_SELECTOR$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor75$_X_$FORM_SELECTOR = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$WEB$__$FORM$_CC_$FORM$__$SELECTOR), null, descriptor75$_X_$FORM_SELECTOR$_X_$__UsesSchemaSet, descriptor68$_X_$MATRIX);
			schemaSet_ScopeStack.add(descriptor75$_X_$FORM_SELECTOR$_X_$__UsesSchemaSet);
			descriptor68$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor75$_X_$FORM_SELECTOR);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::WEB.FORM::FORM.SELECTOR, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `item 1` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor76$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor76$_X_$ITEM;

		try {
			descriptor76$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor76$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("item 1"), 0, true), descriptor76$_X_$ITEM$_X_$__UsesSchemaSet, descriptor75$_X_$FORM_SELECTOR);
			schemaSet_ScopeStack.add(descriptor76$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor75$_X_$FORM_SELECTOR.add_ChildDescriptor(executeInfo, descriptor76$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, item 1, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::WEB.FORM::FORM.REQUIRED __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor77$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor77$_X_$FORM_REQUIRED;

		try {
			descriptor77$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor77$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), null, descriptor77$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor76$_X_$ITEM);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor77$_X_$FORM_REQUIRED$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor77$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor77$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.IsRequired );
			descriptor77$_X_$FORM_REQUIRED$_X_$__FieldSet.set_RequiredImagePath(executeInfo, "required stuff" );
			descriptor77$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageHeight(executeInfo, 22 );
			schemaSet_ScopeStack.add(descriptor77$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor76$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor77$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::WEB.FORM::FORM.REQUIRED, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `item 2` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor78$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor78$_X_$ITEM;

		try {
			descriptor78$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor78$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("item 2"), 0, true), descriptor78$_X_$ITEM$_X_$__UsesSchemaSet, descriptor75$_X_$FORM_SELECTOR);
			schemaSet_ScopeStack.add(descriptor78$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor75$_X_$FORM_SELECTOR.add_ChildDescriptor(executeInfo, descriptor78$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, item 2, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::WEB.FORM::FORM.REQUIRED __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor79$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor79$_X_$FORM_REQUIRED;

		try {
			descriptor79$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor79$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), null, descriptor79$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor78$_X_$ITEM);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor79$_X_$FORM_REQUIRED$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor79$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor79$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.NotRequired );
			descriptor79$_X_$FORM_REQUIRED$_X_$__FieldSet.set_RequiredImagePath(executeInfo, "more required stuff" );
			descriptor79$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageHeight(executeInfo, 23 );
			schemaSet_ScopeStack.add(descriptor79$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor78$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor79$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::WEB.FORM::FORM.REQUIRED, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::WEB.FORM::FORM.REQUIRED, and label, `1` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor80$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor80$_X_$FORM_REQUIRED;

		try {
			descriptor80$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor80$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("1"), 0, true), descriptor80$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor75$_X_$FORM_SELECTOR);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor80$_X_$FORM_REQUIRED$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor80$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor80$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.IsRequired );
			descriptor80$_X_$FORM_REQUIRED$_X_$__FieldSet.set_RequiredImagePath(executeInfo, "required stuff" );
			descriptor80$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageHeight(executeInfo, 22 );
			schemaSet_ScopeStack.add(descriptor80$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor75$_X_$FORM_SELECTOR.add_ChildDescriptor(executeInfo, descriptor80$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::WEB.FORM::FORM.REQUIRED, and with label, 1, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::WEB.FORM::FORM.REQUIRED, and label, `2` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor81$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor81$_X_$FORM_REQUIRED;

		try {
			descriptor81$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor81$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("2"), 0, true), descriptor81$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor75$_X_$FORM_SELECTOR);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor81$_X_$FORM_REQUIRED$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor81$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor81$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.IsRequired );
			descriptor81$_X_$FORM_REQUIRED$_X_$__FieldSet.set_RequiredImagePath(executeInfo, "required stuff" );
			descriptor81$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageHeight(executeInfo, 22 );
			schemaSet_ScopeStack.add(descriptor81$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor75$_X_$FORM_SELECTOR.add_ChildDescriptor(executeInfo, descriptor81$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::WEB.FORM::FORM.REQUIRED, and with label, 2, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::WEB.FORM::OPTION __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor82$_X_$OPTION$_X_$__UsesSchemaSet;
		Descriptor descriptor82$_X_$OPTION;

		try {
			descriptor82$_X_$OPTION$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor82$_X_$OPTION = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$WEB$__$FORM$_CC_$FORM$__$SELECTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$WEB$__$FORM$_CC_$OPTION), null, descriptor82$_X_$OPTION$_X_$__UsesSchemaSet, descriptor75$_X_$FORM_SELECTOR);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$WEB$__$FORM$_S_$FORM$__$SELECTOR$_S_$OPTION descriptor82$_X_$OPTION$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$WEB$__$FORM$_S_$FORM$__$SELECTOR$_S_$OPTION)descriptor82$_X_$OPTION.get_FieldSet_Tuple(executeInfo);
			descriptor82$_X_$OPTION$_X_$__FieldSet.set_Name(executeInfo, "California" );
			descriptor82$_X_$OPTION$_X_$__FieldSet.set_Value(executeInfo, "CA" );
			schemaSet_ScopeStack.add(descriptor82$_X_$OPTION$_X_$__UsesSchemaSet);
			descriptor75$_X_$FORM_SELECTOR.add_ChildDescriptor(executeInfo, descriptor82$_X_$OPTION);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::WEB.FORM::OPTION, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::WEB.FORM::OPTION __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor83$_X_$OPTION$_X_$__UsesSchemaSet;
		Descriptor descriptor83$_X_$OPTION;

		try {
			descriptor83$_X_$OPTION$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor83$_X_$OPTION = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$WEB$__$FORM$_CC_$FORM$__$SELECTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$WEB$__$FORM$_CC_$OPTION), null, descriptor83$_X_$OPTION$_X_$__UsesSchemaSet, descriptor75$_X_$FORM_SELECTOR);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$WEB$__$FORM$_S_$FORM$__$SELECTOR$_S_$OPTION descriptor83$_X_$OPTION$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$WEB$__$FORM$_S_$FORM$__$SELECTOR$_S_$OPTION)descriptor83$_X_$OPTION.get_FieldSet_Tuple(executeInfo);
			descriptor83$_X_$OPTION$_X_$__FieldSet.set_Name(executeInfo, "Colorado" );
			descriptor83$_X_$OPTION$_X_$__FieldSet.set_Value(executeInfo, "CO" );
			schemaSet_ScopeStack.add(descriptor83$_X_$OPTION$_X_$__UsesSchemaSet);
			descriptor75$_X_$FORM_SELECTOR.add_ChildDescriptor(executeInfo, descriptor83$_X_$OPTION);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::WEB.FORM::OPTION, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::WEB.FORM::OPTION __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor84$_X_$OPTION$_X_$__UsesSchemaSet;
		Descriptor descriptor84$_X_$OPTION;

		try {
			descriptor84$_X_$OPTION$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor84$_X_$OPTION = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$WEB$__$FORM$_CC_$FORM$__$SELECTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$WEB$__$FORM$_CC_$OPTION), null, descriptor84$_X_$OPTION$_X_$__UsesSchemaSet, descriptor75$_X_$FORM_SELECTOR);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$WEB$__$FORM$_S_$FORM$__$SELECTOR$_S_$OPTION descriptor84$_X_$OPTION$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$WEB$__$FORM$_S_$FORM$__$SELECTOR$_S_$OPTION)descriptor84$_X_$OPTION.get_FieldSet_Tuple(executeInfo);
			descriptor84$_X_$OPTION$_X_$__FieldSet.set_Name(executeInfo, "Michigan" );
			descriptor84$_X_$OPTION$_X_$__FieldSet.set_Value(executeInfo, "MI" );
			descriptor84$_X_$OPTION$_X_$__FieldSet.set_Selected(executeInfo, AppSymbols.Selected );
			schemaSet_ScopeStack.add(descriptor84$_X_$OPTION$_X_$__UsesSchemaSet);
			descriptor75$_X_$FORM_SELECTOR.add_ChildDescriptor(executeInfo, descriptor84$_X_$OPTION);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::WEB.FORM::OPTION, and with an empty label, but had an error", e);
		}

		matrix = (Matrix)descriptor68$_X_$MATRIX;

		return (Matrix)descriptor68$_X_$MATRIX;
	}




	public Class<?> get_AppControl_Class() throws ClassNotFoundException {
		return maintests.samples.AppControl.class;
	}
	public AppControl_Base initialize_AppControl() { return initialize_AppControl(null, false); }
	public AppControl_Base initialize_AppControl(boolean running_AppControl_forMetacompilation) { return initialize_AppControl(null, running_AppControl_forMetacompilation); }
	public AppControl_Base initialize_AppControl(AppControl_Base existing_AppControl) { return initialize_AppControl(existing_AppControl, false); }
	public AppControl_Base initialize_AppControl(AppControl_Base existing_AppControl, boolean running_AppControl_forMetacompilation) {
		if (existing_AppControl != null)
			return maintests.samples.AppControl.initializeApp(existing_AppControl, running_AppControl_forMetacompilation);
		else
			return maintests.samples.AppControl.initializeApp(running_AppControl_forMetacompilation);
	}

	public AppControl_Base get_AppControl() {
		return maintests.samples.AppControl.appControl;
	}

}
