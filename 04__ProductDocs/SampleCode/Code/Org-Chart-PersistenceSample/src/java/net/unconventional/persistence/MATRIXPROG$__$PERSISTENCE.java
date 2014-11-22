/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package net.unconventional.persistence;

import com.mycompany.hr.AppControl;
import com.mycompany.hr.AppSymbols_DescTag;
import net.unconventionalthinking.exceptions.*;
import com.mycompany.hr.AppSymbols_Label;
import com.mycompany.hr.AppSymbols_SchemaName;
import net.unconventionalthinking.matrix.*;
import java.util.Arrays;
import net.unconventionalthinking.lang.*;
import com.mycompany.hr.AppSymbols;
import com.mycompany.hr.AppSymbols_MatrixName;
import net.unconventionalthinking.matrix.symbols.*;
import com.mycompany.hr.AppSymbols_DescTagName;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import java.util.LinkedList;




public class MATRIXPROG$__$PERSISTENCE implements SchemaContainer {

	public static SchemaInfo_Schema schema;


	public static SchemaInfo_Schema construct(AppControl_Base appControl, ExecutionInfo executeInfo)
		throws Exception_MatrixRuntime_Checked {

		LinkedList<MatrixSet<SchemaInfo_Schema>> schemaSet_ScopeStack = new LinkedList<MatrixSet<SchemaInfo_Schema>>();


		//  Creating Schema with name, MATRIXPROG.PERSISTENCE __________________________________________________
		try {
			schemaSet_ScopeStack.add(new MatrixSet<SchemaInfo_Schema>().add(
				appControl.schemaControl.schemaFactory.get_BaseSchema(executeInfo),
				appControl.schemaControl.schemaForSchema
			));
		} catch (Exception e) {
			throw new Exception_MatrixRuntime_Checked("while trying to create a new Matrix Or Schema descriptor with the name, `MATRIXPROG`.`PERSISTENCE`," + 
				" tried to add the Base Schema to the scope stack, but had an error creating it (see inner exception).", e);
		}

		MatrixSet<SchemaInfo_Schema> descriptor5$_X_$SCHEMA$_X_$__UsesSchemaSet;
		Descriptor descriptor5$_X_$SCHEMA;

		try {
			descriptor5$_X_$SCHEMA$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>().add(appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA));
			descriptor5$_X_$SCHEMA = (Descriptor)appControl.schemaControl.schemaFactory.createNew_Schema(executeInfo, AppSymbols_Label.MATRIXPROG$__$PERSISTENCE, AppSymbols_DescTagName.net$__$unconventional$__$persistence, true, descriptor5$_X_$SCHEMA$_X_$__UsesSchemaSet, null, true);
			schemaSet_ScopeStack.add(descriptor5$_X_$SCHEMA$_X_$__UsesSchemaSet);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::SCHEMA, and with label, `MATRIXPROG`.`PERSISTENCE`, but had an error", e);
		}


		//  Creating SchemaInfo_Descriptor with descriptor tag with label, `MATRIXPROG`.`PERSISTENCE`.`SETTINGS` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor6$_X_$DESCRIPTOR$_X_$__UsesSchemaSet;
		Descriptor descriptor6$_X_$DESCRIPTOR;

		try {
			descriptor6$_X_$DESCRIPTOR$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor6$_X_$DESCRIPTOR = (Descriptor)appControl.schemaControl.schemaFactory.createNew_SchemaInfoDescriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("MATRIXPROG", "PERSISTENCE", "SETTINGS"), 0, true), descriptor6$_X_$DESCRIPTOR$_X_$__UsesSchemaSet, descriptor5$_X_$SCHEMA);
			schemaSet_ScopeStack.add(descriptor6$_X_$DESCRIPTOR$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor5$_X_$SCHEMA).addChild_SchemaInfoDescriptor(executeInfo, (SchemaInfo_Descriptor)descriptor6$_X_$DESCRIPTOR);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::DESCRIPTOR, and with label, `MATRIXPROG`.`PERSISTENCE`.`SETTINGS`, but had an error", e);
		}


		//  Creating Field Descriptor for a schema with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.NAMES __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor7$_X_$FIELD_NAMES$_X_$__UsesSchemaSet;
		Descriptor descriptor7$_X_$FIELD_NAMES;

		try {
			descriptor7$_X_$FIELD_NAMES$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor7$_X_$FIELD_NAMES = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$NAMES), null, descriptor7$_X_$FIELD_NAMES$_X_$__UsesSchemaSet, descriptor6$_X_$DESCRIPTOR);
			FieldSet descriptor7$_X_$FIELD_NAMES$_X_$__FieldSet = descriptor7$_X_$FIELD_NAMES.get_FieldSet_Tuple(executeInfo);
			descriptor7$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 0, AppSymbols_DescTagName.IsPersistentMatrix );
			schemaSet_ScopeStack.add(descriptor7$_X_$FIELD_NAMES$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor6$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor7$_X_$FIELD_NAMES);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.NAMES, and with an empty label, but had an error", e);
		}


		//  Creating Field Descriptor for a schema with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.DESC __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor8$_X_$FIELD_DESC$_X_$__UsesSchemaSet;
		Descriptor descriptor8$_X_$FIELD_DESC;

		try {
			descriptor8$_X_$FIELD_DESC$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor8$_X_$FIELD_DESC = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$DESC), null, descriptor8$_X_$FIELD_DESC$_X_$__UsesSchemaSet, descriptor6$_X_$DESCRIPTOR);
			FieldSet descriptor8$_X_$FIELD_DESC$_X_$__FieldSet = descriptor8$_X_$FIELD_DESC.get_FieldSet_Tuple(executeInfo);
			descriptor8$_X_$FIELD_DESC$_X_$__FieldSet.setField(executeInfo, 0, "Is this matrix persistent?" );
			schemaSet_ScopeStack.add(descriptor8$_X_$FIELD_DESC$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor6$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor8$_X_$FIELD_DESC);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.DESC, and with an empty label, but had an error", e);
		}


		//  Creating Field Descriptor for a schema with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.TYPES __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor9$_X_$FIELD_TYPES$_X_$__UsesSchemaSet;
		Descriptor descriptor9$_X_$FIELD_TYPES;

		try {
			descriptor9$_X_$FIELD_TYPES$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor9$_X_$FIELD_TYPES = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$TYPES), null, descriptor9$_X_$FIELD_TYPES$_X_$__UsesSchemaSet, descriptor6$_X_$DESCRIPTOR);
			FieldSet descriptor9$_X_$FIELD_TYPES$_X_$__FieldSet = descriptor9$_X_$FIELD_TYPES.get_FieldSet_Tuple(executeInfo);
			descriptor9$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 0, AppSymbols.Symbol );
			schemaSet_ScopeStack.add(descriptor9$_X_$FIELD_TYPES$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor6$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor9$_X_$FIELD_TYPES);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.TYPES, and with an empty label, but had an error", e);
		}


		//  Creating Field Descriptor for a schema with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.DEFAULTS __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor10$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet;
		Descriptor descriptor10$_X_$FIELD_DEFAULTS;

		try {
			descriptor10$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor10$_X_$FIELD_DEFAULTS = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$DEFAULTS), null, descriptor10$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet, descriptor6$_X_$DESCRIPTOR);
			FieldSet descriptor10$_X_$FIELD_DEFAULTS$_X_$__FieldSet = descriptor10$_X_$FIELD_DEFAULTS.get_FieldSet_Tuple(executeInfo);
			descriptor10$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 0, AppSymbols.IsNotPersistent );
			schemaSet_ScopeStack.add(descriptor10$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor6$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor10$_X_$FIELD_DEFAULTS);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.DEFAULTS, and with an empty label, but had an error", e);
		}


		//  Initialize the Schema:
		try {
			((SchemaInfo_Descriptor)descriptor5$_X_$SCHEMA).initialize_SchemaInfo(executeInfo, appControl.symbolControl, appControl.schemaControl.schemaControl_Info);

		} catch (Exception_SchemaInfo e) {
			throw new Exception_MatrixRuntime_Checked("Tried to initialize the Schema named, MATRIXPROG$__$PERSISTENCE, but had an error.", e);
		}
		schema = (SchemaInfo_Schema)descriptor5$_X_$SCHEMA;

		return (SchemaInfo_Schema)descriptor5$_X_$SCHEMA;
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
