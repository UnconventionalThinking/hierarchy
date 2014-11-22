/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package com.mycompany.hr;

import net.unconventionalthinking.exceptions.*;
import net.unconventionalthinking.matrix.*;
import java.util.Arrays;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import java.util.LinkedList;




public class OrgChart$__$Schema implements SchemaContainer {

	public static SchemaInfo_Schema schema;


	public static SchemaInfo_Schema construct(AppControl_Base appControl, ExecutionInfo executeInfo)
		throws Exception_MatrixRuntime_Checked {

		LinkedList<MatrixSet<SchemaInfo_Schema>> schemaSet_ScopeStack = new LinkedList<MatrixSet<SchemaInfo_Schema>>();


		//  Creating Schema with name, OrgChart.Schema __________________________________________________
		try {
			schemaSet_ScopeStack.add(new MatrixSet<SchemaInfo_Schema>().add(
				appControl.schemaControl.schemaFactory.get_BaseSchema(executeInfo),
				appControl.schemaControl.schemaForSchema
			));
		} catch (Exception e) {
			throw new Exception_MatrixRuntime_Checked("while trying to create a new Matrix Or Schema descriptor with the name, `OrgChart`.`Schema`," + 
				" tried to add the Base Schema to the scope stack, but had an error creating it (see inner exception).", e);
		}

		MatrixSet<SchemaInfo_Schema> descriptor0$_X_$SCHEMA$_X_$__UsesSchemaSet;
		Descriptor descriptor0$_X_$SCHEMA;

		try {
			descriptor0$_X_$SCHEMA$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>().add(appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA));
			descriptor0$_X_$SCHEMA = (Descriptor)appControl.schemaControl.schemaFactory.createNew_Schema(executeInfo, AppSymbols_Label.OrgChart$__$Schema, AppSymbols_DescTagName.com$__$mycompany$__$hr, true, descriptor0$_X_$SCHEMA$_X_$__UsesSchemaSet, null, true);
			schemaSet_ScopeStack.add(descriptor0$_X_$SCHEMA$_X_$__UsesSchemaSet);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::SCHEMA, and with label, `OrgChart`.`Schema`, but had an error", e);
		}


		//  Creating SchemaInfo_Descriptor with descriptor tag with label, EMPLOYEE __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor1$_X_$DESCRIPTOR$_X_$__UsesSchemaSet;
		Descriptor descriptor1$_X_$DESCRIPTOR;

		try {
			descriptor1$_X_$DESCRIPTOR$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor1$_X_$DESCRIPTOR = (Descriptor)appControl.schemaControl.schemaFactory.createNew_SchemaInfoDescriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("EMPLOYEE"), 0, true), descriptor1$_X_$DESCRIPTOR$_X_$__UsesSchemaSet, descriptor0$_X_$SCHEMA);
			schemaSet_ScopeStack.add(descriptor1$_X_$DESCRIPTOR$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor0$_X_$SCHEMA).addChild_SchemaInfoDescriptor(executeInfo, (SchemaInfo_Descriptor)descriptor1$_X_$DESCRIPTOR);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::DESCRIPTOR, and with label, EMPLOYEE, but had an error", e);
		}


		//  Creating Field Descriptor for a schema with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.NAMES __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor2$_X_$FIELD_NAMES$_X_$__UsesSchemaSet;
		Descriptor descriptor2$_X_$FIELD_NAMES;

		try {
			descriptor2$_X_$FIELD_NAMES$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor2$_X_$FIELD_NAMES = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$NAMES), null, descriptor2$_X_$FIELD_NAMES$_X_$__UsesSchemaSet, descriptor1$_X_$DESCRIPTOR);
			FieldSet descriptor2$_X_$FIELD_NAMES$_X_$__FieldSet = descriptor2$_X_$FIELD_NAMES.get_FieldSet_Tuple(executeInfo);
			descriptor2$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 0, AppSymbols_DescTagName.FullName );
			descriptor2$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 1, AppSymbols_DescTagName.Title );
			descriptor2$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 2, AppSymbols_DescTagName.NumColumns );
			schemaSet_ScopeStack.add(descriptor2$_X_$FIELD_NAMES$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor1$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor2$_X_$FIELD_NAMES);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.NAMES, and with an empty label, but had an error", e);
		}


		//  Creating Field Descriptor for a schema with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.TYPES __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor3$_X_$FIELD_TYPES$_X_$__UsesSchemaSet;
		Descriptor descriptor3$_X_$FIELD_TYPES;

		try {
			descriptor3$_X_$FIELD_TYPES$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor3$_X_$FIELD_TYPES = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$TYPES), null, descriptor3$_X_$FIELD_TYPES$_X_$__UsesSchemaSet, descriptor1$_X_$DESCRIPTOR);
			FieldSet descriptor3$_X_$FIELD_TYPES$_X_$__FieldSet = descriptor3$_X_$FIELD_TYPES.get_FieldSet_Tuple(executeInfo);
			descriptor3$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 0, AppSymbols.String );
			descriptor3$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 1, AppSymbols.String );
			descriptor3$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 2, AppSymbols.int$_sym_$ );
			schemaSet_ScopeStack.add(descriptor3$_X_$FIELD_TYPES$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor1$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor3$_X_$FIELD_TYPES);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.TYPES, and with an empty label, but had an error", e);
		}


		//  Creating Field Descriptor for a schema with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.DEFAULTS __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor4$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet;
		Descriptor descriptor4$_X_$FIELD_DEFAULTS;

		try {
			descriptor4$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor4$_X_$FIELD_DEFAULTS = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$DEFAULTS), null, descriptor4$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet, descriptor1$_X_$DESCRIPTOR);
			FieldSet descriptor4$_X_$FIELD_DEFAULTS$_X_$__FieldSet = descriptor4$_X_$FIELD_DEFAULTS.get_FieldSet_Tuple(executeInfo);
			descriptor4$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 0, null );
			descriptor4$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 1, null );
			descriptor4$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 2, 0 );
			schemaSet_ScopeStack.add(descriptor4$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor1$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor4$_X_$FIELD_DEFAULTS);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.DEFAULTS, and with an empty label, but had an error", e);
		}


		//  Initialize the Schema:
		try {
			((SchemaInfo_Descriptor)descriptor0$_X_$SCHEMA).initialize_SchemaInfo(executeInfo, appControl.symbolControl, appControl.schemaControl.schemaControl_Info);

		} catch (Exception_SchemaInfo e) {
			throw new Exception_MatrixRuntime_Checked("Tried to initialize the Schema named, OrgChart$__$Schema, but had an error.", e);
		}
		schema = (SchemaInfo_Schema)descriptor0$_X_$SCHEMA;

		return (SchemaInfo_Schema)descriptor0$_X_$SCHEMA;
	}




	public Class<?> get_AppControl_Class() throws ClassNotFoundException {
		return com.mycompany.hr.AppControl.class;
	}
	public AppControl_Base initialize_AppControl() { return initialize_AppControl(null, false); }
	public AppControl_Base initialize_AppControl(boolean running_AppControl_forMetacompilation) { return initialize_AppControl(null, running_AppControl_forMetacompilation); }
	public AppControl_Base initialize_AppControl(AppControl_Base existing_AppControl) { return initialize_AppControl(existing_AppControl, false); }
	public AppControl_Base initialize_AppControl(AppControl_Base existing_AppControl, boolean running_AppControl_forMetacompilation) {
		if (existing_AppControl != null)
			return com.mycompany.hr.AppControl.initializeApp(existing_AppControl, running_AppControl_forMetacompilation);
		else
			return com.mycompany.hr.AppControl.initializeApp(running_AppControl_forMetacompilation);
	}

	public AppControl_Base get_AppControl() {
		return com.mycompany.hr.AppControl.appControl;
	}

}
