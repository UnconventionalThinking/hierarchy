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
import java . util . Date ;

import java . util . concurrent . ConcurrentHashMap ;

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

		MatrixSet<SchemaInfo_Schema> descriptor85$_X_$MATRIX$_X_$__UsesSchemaSet;
		Descriptor descriptor85$_X_$MATRIX;

		try {
			descriptor85$_X_$MATRIX$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>().add(appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Test$__$Schema));
			descriptor85$_X_$MATRIX = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Matrix(executeInfo, AppSymbols_Label.Test$__$Matrix2, AppSymbols_DescTagName.maintests$__$samples, true, descriptor85$_X_$MATRIX$_X_$__UsesSchemaSet, null, true);
			schemaSet_ScopeStack.add(descriptor85$_X_$MATRIX$_X_$__UsesSchemaSet);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.BASE::MATRIX, and with label, `Test`.`Matrix2`, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `test item` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor86$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor86$_X_$ITEM;

		try {
			descriptor86$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor86$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("test item"), 0, true), descriptor86$_X_$ITEM$_X_$__UsesSchemaSet, descriptor85$_X_$MATRIX);
			schemaSet_ScopeStack.add(descriptor86$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor85$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor86$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, test item, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::Test.Schema::TEST.DESC __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor87$_X_$TEST_DESC$_X_$__UsesSchemaSet;
		Descriptor descriptor87$_X_$TEST_DESC;

		try {
			descriptor87$_X_$TEST_DESC$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor87$_X_$TEST_DESC = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Test$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Test$__$Schema$_CC_$TEST$__$DESC), null, descriptor87$_X_$TEST_DESC$_X_$__UsesSchemaSet, descriptor86$_X_$ITEM);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Test$__$Schema$_S_$TEST$__$DESC descriptor87$_X_$TEST_DESC$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Test$__$Schema$_S_$TEST$__$DESC)descriptor87$_X_$TEST_DESC.get_FieldSet_Tuple(executeInfo);
			descriptor87$_X_$TEST_DESC$_X_$__FieldSet.set_testField1(executeInfo, AppSymbols.testSym1 );
			descriptor87$_X_$TEST_DESC$_X_$__FieldSet.set_testField2(executeInfo, 6 );
			schemaSet_ScopeStack.add(descriptor87$_X_$TEST_DESC$_X_$__UsesSchemaSet);
			descriptor86$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor87$_X_$TEST_DESC);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::Test.Schema::TEST.DESC, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `test item 2` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor88$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor88$_X_$ITEM;

		try {
			descriptor88$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor88$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("test item 2"), 0, true), descriptor88$_X_$ITEM$_X_$__UsesSchemaSet, descriptor85$_X_$MATRIX);
			schemaSet_ScopeStack.add(descriptor88$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor85$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor88$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, test item 2, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::Test.Schema::TEST.DESC, and label, `1` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor89$_X_$TEST_DESC$_X_$__UsesSchemaSet;
		Descriptor descriptor89$_X_$TEST_DESC;

		try {
			descriptor89$_X_$TEST_DESC$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor89$_X_$TEST_DESC = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Test$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Test$__$Schema$_CC_$TEST$__$DESC), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("1"), 0, true), descriptor89$_X_$TEST_DESC$_X_$__UsesSchemaSet, descriptor88$_X_$ITEM);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Test$__$Schema$_S_$TEST$__$DESC descriptor89$_X_$TEST_DESC$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Test$__$Schema$_S_$TEST$__$DESC)descriptor89$_X_$TEST_DESC.get_FieldSet_Tuple(executeInfo);
			descriptor89$_X_$TEST_DESC$_X_$__FieldSet.set_testField1(executeInfo, AppSymbols.testSymA );
			descriptor89$_X_$TEST_DESC$_X_$__FieldSet.set_testField2(executeInfo, 1 );
			schemaSet_ScopeStack.add(descriptor89$_X_$TEST_DESC$_X_$__UsesSchemaSet);
			descriptor88$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor89$_X_$TEST_DESC);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::Test.Schema::TEST.DESC, and with label, 1, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::Test.Schema::TEST.DESC, and label, `2` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor90$_X_$TEST_DESC$_X_$__UsesSchemaSet;
		Descriptor descriptor90$_X_$TEST_DESC;

		try {
			descriptor90$_X_$TEST_DESC$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor90$_X_$TEST_DESC = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Test$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Test$__$Schema$_CC_$TEST$__$DESC), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("2"), 0, true), descriptor90$_X_$TEST_DESC$_X_$__UsesSchemaSet, descriptor88$_X_$ITEM);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Test$__$Schema$_S_$TEST$__$DESC descriptor90$_X_$TEST_DESC$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Test$__$Schema$_S_$TEST$__$DESC)descriptor90$_X_$TEST_DESC.get_FieldSet_Tuple(executeInfo);
			descriptor90$_X_$TEST_DESC$_X_$__FieldSet.set_testField1(executeInfo, AppSymbols.testSymB );
			descriptor90$_X_$TEST_DESC$_X_$__FieldSet.set_testField2(executeInfo, 2 );
			schemaSet_ScopeStack.add(descriptor90$_X_$TEST_DESC$_X_$__UsesSchemaSet);
			descriptor88$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor90$_X_$TEST_DESC);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::Test.Schema::TEST.DESC, and with label, 2, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::Test.Schema::TEST.DESC, and label, `2`.`A` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor91$_X_$TEST_DESC$_X_$__UsesSchemaSet;
		Descriptor descriptor91$_X_$TEST_DESC;

		try {
			descriptor91$_X_$TEST_DESC$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor91$_X_$TEST_DESC = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Test$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Test$__$Schema$_CC_$TEST$__$DESC), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("2", "A"), 0, true), descriptor91$_X_$TEST_DESC$_X_$__UsesSchemaSet, descriptor90$_X_$TEST_DESC);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Test$__$Schema$_S_$TEST$__$DESC descriptor91$_X_$TEST_DESC$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Test$__$Schema$_S_$TEST$__$DESC)descriptor91$_X_$TEST_DESC.get_FieldSet_Tuple(executeInfo);
			descriptor91$_X_$TEST_DESC$_X_$__FieldSet.set_testField1(executeInfo, AppSymbols.testSymC );
			descriptor91$_X_$TEST_DESC$_X_$__FieldSet.set_testField2(executeInfo, 3 );
			schemaSet_ScopeStack.add(descriptor91$_X_$TEST_DESC$_X_$__UsesSchemaSet);
			descriptor90$_X_$TEST_DESC.add_ChildDescriptor(executeInfo, descriptor91$_X_$TEST_DESC);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::Test.Schema::TEST.DESC, and with label, `2`.`A`, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `field assignment test` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor92$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor92$_X_$ITEM;

		try {
			descriptor92$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor92$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("field assignment test"), 0, true), descriptor92$_X_$ITEM$_X_$__UsesSchemaSet, descriptor85$_X_$MATRIX);
			schemaSet_ScopeStack.add(descriptor92$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor85$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor92$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, field assignment test, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::Test.Schema::TEST.DESC __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor93$_X_$TEST_DESC$_X_$__UsesSchemaSet;
		Descriptor descriptor93$_X_$TEST_DESC;

		try {
			descriptor93$_X_$TEST_DESC$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor93$_X_$TEST_DESC = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Test$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Test$__$Schema$_CC_$TEST$__$DESC), null, descriptor93$_X_$TEST_DESC$_X_$__UsesSchemaSet, descriptor92$_X_$ITEM);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Test$__$Schema$_S_$TEST$__$DESC descriptor93$_X_$TEST_DESC$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Test$__$Schema$_S_$TEST$__$DESC)descriptor93$_X_$TEST_DESC.get_FieldSet_Tuple(executeInfo);
			descriptor93$_X_$TEST_DESC$_X_$__FieldSet.set_testField1(executeInfo, AppSymbols.someValue );
			descriptor93$_X_$TEST_DESC$_X_$__FieldSet.set_testField2(executeInfo, - 1 );
			schemaSet_ScopeStack.add(descriptor93$_X_$TEST_DESC$_X_$__UsesSchemaSet);
			descriptor92$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor93$_X_$TEST_DESC);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::Test.Schema::TEST.DESC, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `test object field types test` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor94$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor94$_X_$ITEM;

		try {
			descriptor94$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor94$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("test object field types test"), 0, true), descriptor94$_X_$ITEM$_X_$__UsesSchemaSet, descriptor85$_X_$MATRIX);
			schemaSet_ScopeStack.add(descriptor94$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor85$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor94$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, test object field types test, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::Test.Schema::TEST.OBJECT.TYPES __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor95$_X_$TEST_OBJECT_TYPES$_X_$__UsesSchemaSet;
		Descriptor descriptor95$_X_$TEST_OBJECT_TYPES;

		try {
			descriptor95$_X_$TEST_OBJECT_TYPES$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor95$_X_$TEST_OBJECT_TYPES = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Test$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Test$__$Schema$_CC_$TEST$__$OBJECT$__$TYPES), null, descriptor95$_X_$TEST_OBJECT_TYPES$_X_$__UsesSchemaSet, descriptor94$_X_$ITEM);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Test$__$Schema$_S_$TEST$__$OBJECT$__$TYPES descriptor95$_X_$TEST_OBJECT_TYPES$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Test$__$Schema$_S_$TEST$__$OBJECT$__$TYPES)descriptor95$_X_$TEST_OBJECT_TYPES.get_FieldSet_Tuple(executeInfo);
			descriptor95$_X_$TEST_OBJECT_TYPES$_X_$__FieldSet.set_testField1(executeInfo, new Date ( ) );
			descriptor95$_X_$TEST_OBJECT_TYPES$_X_$__FieldSet.set_testField2(executeInfo, System . out );
			schemaSet_ScopeStack.add(descriptor95$_X_$TEST_OBJECT_TYPES$_X_$__UsesSchemaSet);
			descriptor94$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor95$_X_$TEST_OBJECT_TYPES);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::Test.Schema::TEST.OBJECT.TYPES, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::Test.Schema::TEST.IMPORTING.TYPES __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor96$_X_$TEST_IMPORTING_TYPES$_X_$__UsesSchemaSet;
		Descriptor descriptor96$_X_$TEST_IMPORTING_TYPES;

		try {
			descriptor96$_X_$TEST_IMPORTING_TYPES$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor96$_X_$TEST_IMPORTING_TYPES = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Test$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Test$__$Schema$_CC_$TEST$__$IMPORTING$__$TYPES), null, descriptor96$_X_$TEST_IMPORTING_TYPES$_X_$__UsesSchemaSet, descriptor94$_X_$ITEM);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Test$__$Schema$_S_$TEST$__$IMPORTING$__$TYPES descriptor96$_X_$TEST_IMPORTING_TYPES$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Test$__$Schema$_S_$TEST$__$IMPORTING$__$TYPES)descriptor96$_X_$TEST_IMPORTING_TYPES.get_FieldSet_Tuple(executeInfo);
			descriptor96$_X_$TEST_IMPORTING_TYPES$_X_$__FieldSet.set_testField1(executeInfo, new java . util . concurrent . ConcurrentHashMap ( ) );
			descriptor96$_X_$TEST_IMPORTING_TYPES$_X_$__FieldSet.set_testField2(executeInfo, new ConcurrentHashMap ( ) );
			descriptor96$_X_$TEST_IMPORTING_TYPES$_X_$__FieldSet.set_testField3(executeInfo, new ConcurrentHashMap < String , Integer > ( ) );
			descriptor96$_X_$TEST_IMPORTING_TYPES$_X_$__FieldSet.set_testField4(executeInfo, new ConcurrentHashMap < String , Integer > ( ) );
			schemaSet_ScopeStack.add(descriptor96$_X_$TEST_IMPORTING_TYPES$_X_$__UsesSchemaSet);
			descriptor94$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor96$_X_$TEST_IMPORTING_TYPES);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::Test.Schema::TEST.IMPORTING.TYPES, and with an empty label, but had an error", e);
		}

		matrix = (Matrix)descriptor85$_X_$MATRIX;

		return (Matrix)descriptor85$_X_$MATRIX;
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
