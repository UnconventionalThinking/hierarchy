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

import java.util.Arrays;
import net.unconventionalthinking.exceptions.*;
import net.unconventionalthinking.lang.*;
import java.util.LinkedList;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.matrix.*;




public class WEB$__$FORM implements SchemaContainer {

	public static SchemaInfo_Schema schema;


	public static SchemaInfo_Schema construct(AppControl_Base appControl, ExecutionInfo executeInfo)
		throws Exception_MatrixRuntime_Checked {

		LinkedList<MatrixSet<SchemaInfo_Schema>> schemaSet_ScopeStack = new LinkedList<MatrixSet<SchemaInfo_Schema>>();


		//  Creating a Schema with name, `WEB`.`FORM`__________________________________________________
		try {
			schemaSet_ScopeStack.add(new MatrixSet<SchemaInfo_Schema>().add(
				appControl.schemaControl.schemaFactory.get_BaseSchema(executeInfo),
				appControl.schemaControl.schemaForSchema
			));
		} catch (Exception e) {
			throw new Exception_MatrixRuntime_Checked("while trying to create a new Matrix Or Schema descriptor with the name, `WEB`.`FORM`," + 
				" tried to add the Base Schema to the scope stack, but had an error creating it (see inner exception).", e);
		}

		MatrixSet<SchemaInfo_Schema> descriptor0$_X_$SCHEMA$_X_$__UsesSchemaSet;
		Descriptor descriptor0$_X_$SCHEMA;

		try {
			descriptor0$_X_$SCHEMA$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>().add(appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA));
			descriptor0$_X_$SCHEMA = (Descriptor)appControl.schemaControl.schemaFactory.createNew_Schema(executeInfo, AppSymbols_Label.WEB$__$FORM, AppSymbols_DescTagName.net$__$unconventionalthinking$__$matrix, true, descriptor0$_X_$SCHEMA$_X_$__UsesSchemaSet, null, true);
			schemaSet_ScopeStack.add(descriptor0$_X_$SCHEMA$_X_$__UsesSchemaSet);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, SCHEMA::SCHEMA, and with label, `WEB`.`FORM`, but had an error", e);
		}


		//  Creating a SchemaInfo_Descriptor with descriptor tag with label, `FORM`.`REQUIRED`__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor1$_X_$DESCRIPTOR$_X_$__UsesSchemaSet;
		Descriptor descriptor1$_X_$DESCRIPTOR;

		try {
			descriptor1$_X_$DESCRIPTOR$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor1$_X_$DESCRIPTOR = (Descriptor)appControl.schemaControl.schemaFactory.createNew_SchemaInfoDescriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("FORM", "REQUIRED"), 0, true), descriptor1$_X_$DESCRIPTOR$_X_$__UsesSchemaSet, descriptor0$_X_$SCHEMA);
			schemaSet_ScopeStack.add(descriptor1$_X_$DESCRIPTOR$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor0$_X_$SCHEMA).addChild_SchemaInfoDescriptor(executeInfo, (SchemaInfo_Descriptor)descriptor1$_X_$DESCRIPTOR);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, DESCRIPTOR::DESCRIPTOR, and with label, `FORM`.`REQUIRED`, but had an error", e);
		}


		//  Creating a Field Descriptor for a schema with the name, FIELD.NAMES::FIELD.NAMES__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor2$_X_$FIELD_NAMES$_X_$__UsesSchemaSet;
		Descriptor descriptor2$_X_$FIELD_NAMES;

		try {
			descriptor2$_X_$FIELD_NAMES$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor2$_X_$FIELD_NAMES = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$NAMES), null, descriptor2$_X_$FIELD_NAMES$_X_$__UsesSchemaSet, descriptor1$_X_$DESCRIPTOR);
			FieldSet descriptor2$_X_$FIELD_NAMES$_X_$__FieldSet = descriptor2$_X_$FIELD_NAMES.get_FieldSet_Tuple(executeInfo);
			descriptor2$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 0, appControl.symbolControl.multiPartSymbol_Factory.createNew_DescTagName("IsRequired", 1, false, null, null));
			descriptor2$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 1, appControl.symbolControl.multiPartSymbol_Factory.createNew_DescTagName("RequiredImagePath", 1, false, null, null));
			descriptor2$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 2, appControl.symbolControl.multiPartSymbol_Factory.createNew_DescTagName("ImageHeight", 1, false, null, null));
			descriptor2$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 3, appControl.symbolControl.multiPartSymbol_Factory.createNew_DescTagName("ImageWidth", 1, false, null, null));
			schemaSet_ScopeStack.add(descriptor2$_X_$FIELD_NAMES$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor1$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor2$_X_$FIELD_NAMES);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, FIELD.NAMES::FIELD.NAMES, and with an empty label, but had an error", e);
		}


		//  Creating a Field Descriptor for a schema with the name, FIELD.TYPES::FIELD.TYPES__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor3$_X_$FIELD_TYPES$_X_$__UsesSchemaSet;
		Descriptor descriptor3$_X_$FIELD_TYPES;

		try {
			descriptor3$_X_$FIELD_TYPES$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor3$_X_$FIELD_TYPES = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$TYPES), null, descriptor3$_X_$FIELD_TYPES$_X_$__UsesSchemaSet, descriptor1$_X_$DESCRIPTOR);
			FieldSet descriptor3$_X_$FIELD_TYPES$_X_$__FieldSet = descriptor3$_X_$FIELD_TYPES.get_FieldSet_Tuple(executeInfo);
			descriptor3$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 0, MPSymbols.Symbol);
			descriptor3$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 1, MPSymbols.String);
			descriptor3$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 2, MPSymbols.int$_sym_$);
			descriptor3$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 3, MPSymbols.int$_sym_$);
			schemaSet_ScopeStack.add(descriptor3$_X_$FIELD_TYPES$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor1$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor3$_X_$FIELD_TYPES);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, FIELD.TYPES::FIELD.TYPES, and with an empty label, but had an error", e);
		}


		//  Creating a SchemaInfo_Descriptor with descriptor tag with label, `TEST`.`CHILD`__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor4$_X_$DESCRIPTOR$_X_$__UsesSchemaSet;
		Descriptor descriptor4$_X_$DESCRIPTOR;

		try {
			descriptor4$_X_$DESCRIPTOR$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor4$_X_$DESCRIPTOR = (Descriptor)appControl.schemaControl.schemaFactory.createNew_SchemaInfoDescriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("TEST", "CHILD"), 0, true), descriptor4$_X_$DESCRIPTOR$_X_$__UsesSchemaSet, descriptor1$_X_$DESCRIPTOR);
			schemaSet_ScopeStack.add(descriptor4$_X_$DESCRIPTOR$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor1$_X_$DESCRIPTOR).addChild_SchemaInfoDescriptor(executeInfo, (SchemaInfo_Descriptor)descriptor4$_X_$DESCRIPTOR);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, DESCRIPTOR::DESCRIPTOR, and with label, `TEST`.`CHILD`, but had an error", e);
		}


		//  Creating a Field Descriptor for a schema with the name, FIELD.NAMES::FIELD.NAMES__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor5$_X_$FIELD_NAMES$_X_$__UsesSchemaSet;
		Descriptor descriptor5$_X_$FIELD_NAMES;

		try {
			descriptor5$_X_$FIELD_NAMES$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor5$_X_$FIELD_NAMES = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$NAMES), null, descriptor5$_X_$FIELD_NAMES$_X_$__UsesSchemaSet, descriptor4$_X_$DESCRIPTOR);
			FieldSet descriptor5$_X_$FIELD_NAMES$_X_$__FieldSet = descriptor5$_X_$FIELD_NAMES.get_FieldSet_Tuple(executeInfo);
			descriptor5$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 0, appControl.symbolControl.multiPartSymbol_Factory.createNew_DescTagName("Field1int", 1, false, null, null));
			descriptor5$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 1, appControl.symbolControl.multiPartSymbol_Factory.createNew_DescTagName("Field2String", 1, false, null, null));
			schemaSet_ScopeStack.add(descriptor5$_X_$FIELD_NAMES$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor4$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor5$_X_$FIELD_NAMES);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, FIELD.NAMES::FIELD.NAMES, and with an empty label, but had an error", e);
		}


		//  Creating a Field Descriptor for a schema with the name, FIELD.TYPES::FIELD.TYPES__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor6$_X_$FIELD_TYPES$_X_$__UsesSchemaSet;
		Descriptor descriptor6$_X_$FIELD_TYPES;

		try {
			descriptor6$_X_$FIELD_TYPES$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor6$_X_$FIELD_TYPES = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$TYPES), null, descriptor6$_X_$FIELD_TYPES$_X_$__UsesSchemaSet, descriptor4$_X_$DESCRIPTOR);
			FieldSet descriptor6$_X_$FIELD_TYPES$_X_$__FieldSet = descriptor6$_X_$FIELD_TYPES.get_FieldSet_Tuple(executeInfo);
			descriptor6$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 0, MPSymbols.int$_sym_$);
			descriptor6$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 1, MPSymbols.String);
			schemaSet_ScopeStack.add(descriptor6$_X_$FIELD_TYPES$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor4$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor6$_X_$FIELD_TYPES);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, FIELD.TYPES::FIELD.TYPES, and with an empty label, but had an error", e);
		}


		//  Creating a SchemaInfo_Descriptor with descriptor tag with label, `TEST`.`CONT`__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor7$_X_$DESCRIPTOR$_X_$__UsesSchemaSet;
		Descriptor descriptor7$_X_$DESCRIPTOR;

		try {
			descriptor7$_X_$DESCRIPTOR$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor7$_X_$DESCRIPTOR = (Descriptor)appControl.schemaControl.schemaFactory.createNew_SchemaInfoDescriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("TEST", "CONT"), 0, true), descriptor7$_X_$DESCRIPTOR$_X_$__UsesSchemaSet, descriptor0$_X_$SCHEMA);
			schemaSet_ScopeStack.add(descriptor7$_X_$DESCRIPTOR$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor0$_X_$SCHEMA).addChild_SchemaInfoDescriptor(executeInfo, (SchemaInfo_Descriptor)descriptor7$_X_$DESCRIPTOR);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, DESCRIPTOR::DESCRIPTOR, and with label, `TEST`.`CONT`, but had an error", e);
		}


		//  Creating a Field Descriptor for a schema with the name, FIELD.NAMES::FIELD.NAMES__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor8$_X_$FIELD_NAMES$_X_$__UsesSchemaSet;
		Descriptor descriptor8$_X_$FIELD_NAMES;

		try {
			descriptor8$_X_$FIELD_NAMES$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor8$_X_$FIELD_NAMES = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$NAMES), null, descriptor8$_X_$FIELD_NAMES$_X_$__UsesSchemaSet, descriptor7$_X_$DESCRIPTOR);
			FieldSet descriptor8$_X_$FIELD_NAMES$_X_$__FieldSet = descriptor8$_X_$FIELD_NAMES.get_FieldSet_Tuple(executeInfo);
			descriptor8$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 0, appControl.symbolControl.multiPartSymbol_Factory.createNew_DescTagName("field1int", 1, false, null, null));
			descriptor8$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 1, appControl.symbolControl.multiPartSymbol_Factory.createNew_DescTagName("field2ContInt", 1, false, null, null));
			schemaSet_ScopeStack.add(descriptor8$_X_$FIELD_NAMES$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor7$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor8$_X_$FIELD_NAMES);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, FIELD.NAMES::FIELD.NAMES, and with an empty label, but had an error", e);
		}


		//  Creating a Field Descriptor for a schema with the name, FIELD.TYPES::FIELD.TYPES__________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor9$_X_$FIELD_TYPES$_X_$__UsesSchemaSet;
		Descriptor descriptor9$_X_$FIELD_TYPES;

		try {
			descriptor9$_X_$FIELD_TYPES$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor9$_X_$FIELD_TYPES = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$TYPES), null, descriptor9$_X_$FIELD_TYPES$_X_$__UsesSchemaSet, descriptor7$_X_$DESCRIPTOR);
			FieldSet descriptor9$_X_$FIELD_TYPES$_X_$__FieldSet = descriptor9$_X_$FIELD_TYPES.get_FieldSet_Tuple(executeInfo);
			descriptor9$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 0, MPSymbols.int$_sym_$);
			descriptor9$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 1, MPSymbols.ContinuationType$__$int);
			schemaSet_ScopeStack.add(descriptor9$_X_$FIELD_TYPES$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor7$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor9$_X_$FIELD_TYPES);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, FIELD.TYPES::FIELD.TYPES, and with an empty label, but had an error", e);
		}


		//  Initialize the Schema:
		try {
			((SchemaInfo_Descriptor)descriptor0$_X_$SCHEMA).initialize_SchemaInfo(executeInfo, appControl.symbolControl, appControl.schemaControl.schemaControl_Info);

		} catch (Exception_SchemaInfo e) {
			throw new Exception_MatrixRuntime_Checked("Tried to initialize the Schema named, WEB$__$FORM, but had an error.", e);
		}
		schema = (SchemaInfo_Schema)descriptor0$_X_$SCHEMA;

		return (SchemaInfo_Schema)descriptor0$_X_$SCHEMA;
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
