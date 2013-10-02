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

package annotationdetectiontests;

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

		//  Creating a Matrix with name, `Test`.`Matrix`__________________________________________________
		try {
			schemaSet_ScopeStack.add(new MatrixSet<SchemaInfo_Schema>().add(
				appControl.schemaControl.schemaFactory.get_BaseSchema(executeInfo),
				appControl.schemaControl.schemaForSchema
			));
		} catch (Exception e) {
			throw new Exception_MatrixRuntime_Checked("while trying to create a new Matrix Or Schema descriptor with the name, `Test`.`Matrix`," + 
				" tried to add the Base Schema to the scope stack, but had an error creating it (see inner exception).", e);
		}

		MatrixSet<SchemaInfo_Schema> descriptor11$_X_$MATRIX$_X_$__UsesSchemaSet;
		Descriptor descriptor11$_X_$MATRIX;

		try {
			descriptor11$_X_$MATRIX$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>().add(appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.annotationdetectiontests$_CC_$WEB$__$FORM));
			descriptor11$_X_$MATRIX = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Matrix(executeInfo, AppSymbols_Label.Test$__$Matrix, AppSymbols_DescTagName.annotationdetectiontests, true, descriptor11$_X_$MATRIX$_X_$__UsesSchemaSet, null, true);
			schemaSet_ScopeStack.add(descriptor11$_X_$MATRIX$_X_$__UsesSchemaSet);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, MATRIX::MATRIX, and with label, `Test`.`Matrix`, but had an error", e);
		}


		//  Creating a Descriptor with descriptor tag, ITEM::ITEM, and label, First Name__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor12$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor12$_X_$ITEM;

		try {
			descriptor12$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor12$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("First Name"), 0, true), descriptor12$_X_$ITEM$_X_$__UsesSchemaSet, descriptor11$_X_$MATRIX);
			schemaSet_ScopeStack.add(descriptor12$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor11$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor12$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, ITEM::ITEM, and with label, First Name, but had an error", e);
		}


		//  Creating a Descriptor with descriptor tag, FORM.REQUIRED::FORM.REQUIRED, and label, null__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor13$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor13$_X_$FORM_REQUIRED;

		try {
			descriptor13$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor13$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.annotationdetectiontests$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.annotationdetectiontests$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), null, descriptor13$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor12$_X_$ITEM);
			annotationdetectiontests.FieldSetTuple__annotationdetectiontests$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor13$_X_$FORM_REQUIRED$_X_$__FieldSet = (annotationdetectiontests.FieldSetTuple__annotationdetectiontests$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor13$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor13$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.IsRequired );
			descriptor13$_X_$FORM_REQUIRED$_X_$__FieldSet.set_RequiredImagePath(executeInfo, "/images/isRequired" );
			descriptor13$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageHeight(executeInfo, 5 );
			descriptor13$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageWidth(executeInfo, 6 );
			schemaSet_ScopeStack.add(descriptor13$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor12$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor13$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, FORM.REQUIRED::FORM.REQUIRED, and with an empty label, but had an error", e);
		}


		//  Creating a Descriptor with descriptor tag, ITEM::ITEM, and label, Last Name__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor14$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor14$_X_$ITEM;

		try {
			descriptor14$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor14$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("Last Name"), 0, true), descriptor14$_X_$ITEM$_X_$__UsesSchemaSet, descriptor11$_X_$MATRIX);
			schemaSet_ScopeStack.add(descriptor14$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor11$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor14$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, ITEM::ITEM, and with label, Last Name, but had an error", e);
		}


		//  Creating a Descriptor with descriptor tag, FORM.REQUIRED::FORM.REQUIRED, and label, null__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor15$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor15$_X_$FORM_REQUIRED;

		try {
			descriptor15$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor15$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.annotationdetectiontests$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.annotationdetectiontests$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), null, descriptor15$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor14$_X_$ITEM);
			annotationdetectiontests.FieldSetTuple__annotationdetectiontests$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor15$_X_$FORM_REQUIRED$_X_$__FieldSet = (annotationdetectiontests.FieldSetTuple__annotationdetectiontests$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor15$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor15$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.NotRequired );
			descriptor15$_X_$FORM_REQUIRED$_X_$__FieldSet.set_RequiredImagePath(executeInfo, "/images/isRequired" );
			descriptor15$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageHeight(executeInfo, 5 );
			descriptor15$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageWidth(executeInfo, 6 );
			schemaSet_ScopeStack.add(descriptor15$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor14$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor15$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, FORM.REQUIRED::FORM.REQUIRED, and with an empty label, but had an error", e);
		}


		//  Creating a Descriptor with descriptor tag, FORM.SELECTOR::FORM.SELECTOR, and label, null__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor16$_X_$FORM_SELECTOR$_X_$__UsesSchemaSet;
		Descriptor descriptor16$_X_$FORM_SELECTOR;

		try {
			descriptor16$_X_$FORM_SELECTOR$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor16$_X_$FORM_SELECTOR = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.annotationdetectiontests$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.annotationdetectiontests$_CC_$WEB$__$FORM$_CC_$FORM$__$SELECTOR), null, descriptor16$_X_$FORM_SELECTOR$_X_$__UsesSchemaSet, descriptor11$_X_$MATRIX);
			schemaSet_ScopeStack.add(descriptor16$_X_$FORM_SELECTOR$_X_$__UsesSchemaSet);
			descriptor11$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor16$_X_$FORM_SELECTOR);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, FORM.SELECTOR::FORM.SELECTOR, and with an empty label, but had an error", e);
		}


		//  Creating a Descriptor with descriptor tag, ITEM::ITEM, and label, item 1__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor17$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor17$_X_$ITEM;

		try {
			descriptor17$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor17$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("item 1"), 0, true), descriptor17$_X_$ITEM$_X_$__UsesSchemaSet, descriptor16$_X_$FORM_SELECTOR);
			schemaSet_ScopeStack.add(descriptor17$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor16$_X_$FORM_SELECTOR.add_ChildDescriptor(executeInfo, descriptor17$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, ITEM::ITEM, and with label, item 1, but had an error", e);
		}


		//  Creating a Descriptor with descriptor tag, FORM.REQUIRED::FORM.REQUIRED, and label, null__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor18$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor18$_X_$FORM_REQUIRED;

		try {
			descriptor18$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor18$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.annotationdetectiontests$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.annotationdetectiontests$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), null, descriptor18$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor17$_X_$ITEM);
			annotationdetectiontests.FieldSetTuple__annotationdetectiontests$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor18$_X_$FORM_REQUIRED$_X_$__FieldSet = (annotationdetectiontests.FieldSetTuple__annotationdetectiontests$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor18$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor18$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.IsRequired );
			descriptor18$_X_$FORM_REQUIRED$_X_$__FieldSet.set_RequiredImagePath(executeInfo, "required stuff" );
			descriptor18$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageHeight(executeInfo, 22 );
			schemaSet_ScopeStack.add(descriptor18$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor17$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor18$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, FORM.REQUIRED::FORM.REQUIRED, and with an empty label, but had an error", e);
		}


		//  Creating a Descriptor with descriptor tag, ITEM::ITEM, and label, item 2__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor19$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor19$_X_$ITEM;

		try {
			descriptor19$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor19$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("item 2"), 0, true), descriptor19$_X_$ITEM$_X_$__UsesSchemaSet, descriptor16$_X_$FORM_SELECTOR);
			schemaSet_ScopeStack.add(descriptor19$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor16$_X_$FORM_SELECTOR.add_ChildDescriptor(executeInfo, descriptor19$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, ITEM::ITEM, and with label, item 2, but had an error", e);
		}


		//  Creating a Descriptor with descriptor tag, FORM.REQUIRED::FORM.REQUIRED, and label, null__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor20$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor20$_X_$FORM_REQUIRED;

		try {
			descriptor20$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor20$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.annotationdetectiontests$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.annotationdetectiontests$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), null, descriptor20$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor19$_X_$ITEM);
			annotationdetectiontests.FieldSetTuple__annotationdetectiontests$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor20$_X_$FORM_REQUIRED$_X_$__FieldSet = (annotationdetectiontests.FieldSetTuple__annotationdetectiontests$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor20$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor20$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.NotRequired );
			descriptor20$_X_$FORM_REQUIRED$_X_$__FieldSet.set_RequiredImagePath(executeInfo, "more required stuff" );
			descriptor20$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageHeight(executeInfo, 23 );
			schemaSet_ScopeStack.add(descriptor20$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor19$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor20$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, FORM.REQUIRED::FORM.REQUIRED, and with an empty label, but had an error", e);
		}


		//  Creating a Descriptor with descriptor tag, FORM.REQUIRED::FORM.REQUIRED, and label, 1__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor21$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor21$_X_$FORM_REQUIRED;

		try {
			descriptor21$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor21$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.annotationdetectiontests$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.annotationdetectiontests$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("1"), 0, true), descriptor21$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor16$_X_$FORM_SELECTOR);
			annotationdetectiontests.FieldSetTuple__annotationdetectiontests$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor21$_X_$FORM_REQUIRED$_X_$__FieldSet = (annotationdetectiontests.FieldSetTuple__annotationdetectiontests$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor21$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor21$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.IsRequired );
			descriptor21$_X_$FORM_REQUIRED$_X_$__FieldSet.set_RequiredImagePath(executeInfo, "required stuff" );
			descriptor21$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageHeight(executeInfo, 22 );
			schemaSet_ScopeStack.add(descriptor21$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor16$_X_$FORM_SELECTOR.add_ChildDescriptor(executeInfo, descriptor21$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, FORM.REQUIRED::FORM.REQUIRED, and with label, 1, but had an error", e);
		}


		//  Creating a Descriptor with descriptor tag, FORM.REQUIRED::FORM.REQUIRED, and label, 2__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor22$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor22$_X_$FORM_REQUIRED;

		try {
			descriptor22$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor22$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.annotationdetectiontests$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.annotationdetectiontests$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("2"), 0, true), descriptor22$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor16$_X_$FORM_SELECTOR);
			annotationdetectiontests.FieldSetTuple__annotationdetectiontests$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor22$_X_$FORM_REQUIRED$_X_$__FieldSet = (annotationdetectiontests.FieldSetTuple__annotationdetectiontests$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor22$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor22$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.IsRequired );
			descriptor22$_X_$FORM_REQUIRED$_X_$__FieldSet.set_RequiredImagePath(executeInfo, "required stuff" );
			descriptor22$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageHeight(executeInfo, 22 );
			schemaSet_ScopeStack.add(descriptor22$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor16$_X_$FORM_SELECTOR.add_ChildDescriptor(executeInfo, descriptor22$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, FORM.REQUIRED::FORM.REQUIRED, and with label, 2, but had an error", e);
		}


		//  Creating a Descriptor with descriptor tag, OPTION::OPTION, and label, null__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor23$_X_$OPTION$_X_$__UsesSchemaSet;
		Descriptor descriptor23$_X_$OPTION;

		try {
			descriptor23$_X_$OPTION$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor23$_X_$OPTION = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.annotationdetectiontests$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.annotationdetectiontests$_CC_$WEB$__$FORM$_CC_$FORM$__$SELECTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.annotationdetectiontests$_CC_$WEB$__$FORM$_CC_$OPTION), null, descriptor23$_X_$OPTION$_X_$__UsesSchemaSet, descriptor16$_X_$FORM_SELECTOR);
			annotationdetectiontests.FieldSetTuple__annotationdetectiontests$_CC_$WEB$__$FORM$_S_$FORM$__$SELECTOR$_S_$OPTION descriptor23$_X_$OPTION$_X_$__FieldSet = (annotationdetectiontests.FieldSetTuple__annotationdetectiontests$_CC_$WEB$__$FORM$_S_$FORM$__$SELECTOR$_S_$OPTION)descriptor23$_X_$OPTION.get_FieldSet_Tuple(executeInfo);
			descriptor23$_X_$OPTION$_X_$__FieldSet.set_Name(executeInfo, "California" );
			descriptor23$_X_$OPTION$_X_$__FieldSet.set_Value(executeInfo, "CA" );
			schemaSet_ScopeStack.add(descriptor23$_X_$OPTION$_X_$__UsesSchemaSet);
			descriptor16$_X_$FORM_SELECTOR.add_ChildDescriptor(executeInfo, descriptor23$_X_$OPTION);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, OPTION::OPTION, and with an empty label, but had an error", e);
		}


		//  Creating a Descriptor with descriptor tag, OPTION::OPTION, and label, null__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor24$_X_$OPTION$_X_$__UsesSchemaSet;
		Descriptor descriptor24$_X_$OPTION;

		try {
			descriptor24$_X_$OPTION$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor24$_X_$OPTION = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.annotationdetectiontests$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.annotationdetectiontests$_CC_$WEB$__$FORM$_CC_$FORM$__$SELECTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.annotationdetectiontests$_CC_$WEB$__$FORM$_CC_$OPTION), null, descriptor24$_X_$OPTION$_X_$__UsesSchemaSet, descriptor16$_X_$FORM_SELECTOR);
			annotationdetectiontests.FieldSetTuple__annotationdetectiontests$_CC_$WEB$__$FORM$_S_$FORM$__$SELECTOR$_S_$OPTION descriptor24$_X_$OPTION$_X_$__FieldSet = (annotationdetectiontests.FieldSetTuple__annotationdetectiontests$_CC_$WEB$__$FORM$_S_$FORM$__$SELECTOR$_S_$OPTION)descriptor24$_X_$OPTION.get_FieldSet_Tuple(executeInfo);
			descriptor24$_X_$OPTION$_X_$__FieldSet.set_Name(executeInfo, "Colorado" );
			descriptor24$_X_$OPTION$_X_$__FieldSet.set_Value(executeInfo, "CO" );
			schemaSet_ScopeStack.add(descriptor24$_X_$OPTION$_X_$__UsesSchemaSet);
			descriptor16$_X_$FORM_SELECTOR.add_ChildDescriptor(executeInfo, descriptor24$_X_$OPTION);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, OPTION::OPTION, and with an empty label, but had an error", e);
		}


		//  Creating a Descriptor with descriptor tag, OPTION::OPTION, and label, null__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor25$_X_$OPTION$_X_$__UsesSchemaSet;
		Descriptor descriptor25$_X_$OPTION;

		try {
			descriptor25$_X_$OPTION$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor25$_X_$OPTION = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.annotationdetectiontests$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.annotationdetectiontests$_CC_$WEB$__$FORM$_CC_$FORM$__$SELECTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.annotationdetectiontests$_CC_$WEB$__$FORM$_CC_$OPTION), null, descriptor25$_X_$OPTION$_X_$__UsesSchemaSet, descriptor16$_X_$FORM_SELECTOR);
			annotationdetectiontests.FieldSetTuple__annotationdetectiontests$_CC_$WEB$__$FORM$_S_$FORM$__$SELECTOR$_S_$OPTION descriptor25$_X_$OPTION$_X_$__FieldSet = (annotationdetectiontests.FieldSetTuple__annotationdetectiontests$_CC_$WEB$__$FORM$_S_$FORM$__$SELECTOR$_S_$OPTION)descriptor25$_X_$OPTION.get_FieldSet_Tuple(executeInfo);
			descriptor25$_X_$OPTION$_X_$__FieldSet.set_Name(executeInfo, "Michigan" );
			descriptor25$_X_$OPTION$_X_$__FieldSet.set_Value(executeInfo, "MI" );
			descriptor25$_X_$OPTION$_X_$__FieldSet.set_Selected(executeInfo, AppSymbols.Selected );
			schemaSet_ScopeStack.add(descriptor25$_X_$OPTION$_X_$__UsesSchemaSet);
			descriptor16$_X_$FORM_SELECTOR.add_ChildDescriptor(executeInfo, descriptor25$_X_$OPTION);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, OPTION::OPTION, and with an empty label, but had an error", e);
		}

		matrix = (Matrix)descriptor11$_X_$MATRIX;

		return (Matrix)descriptor11$_X_$MATRIX;
	}




	public Class<?> get_AppControl_Class() throws ClassNotFoundException {
		return annotationdetectiontests.AppControl.class;
	}
	public AppControl_Base initialize_AppControl() { return initialize_AppControl(null, false); }
	public AppControl_Base initialize_AppControl(boolean running_AppControl_forMetacompilation) { return initialize_AppControl(null, running_AppControl_forMetacompilation); }
	public AppControl_Base initialize_AppControl(AppControl_Base existing_AppControl) { return initialize_AppControl(existing_AppControl, false); }
	public AppControl_Base initialize_AppControl(AppControl_Base existing_AppControl, boolean running_AppControl_forMetacompilation) {
		if (existing_AppControl != null)
			return annotationdetectiontests.AppControl.initializeApp(existing_AppControl, running_AppControl_forMetacompilation);
		else
			return annotationdetectiontests.AppControl.initializeApp(running_AppControl_forMetacompilation);
	}

	public AppControl_Base get_AppControl() {
		return annotationdetectiontests.AppControl.appControl;
	}

}
