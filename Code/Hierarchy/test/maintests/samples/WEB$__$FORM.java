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




public class WEB$__$FORM implements SchemaContainer {

	public static SchemaInfo_Schema schema;


	public static SchemaInfo_Schema construct(AppControl_Base appControl, ExecutionInfo executeInfo)
		throws Exception_MatrixRuntime_Checked {

		LinkedList<MatrixSet<SchemaInfo_Schema>> schemaSet_ScopeStack = new LinkedList<MatrixSet<SchemaInfo_Schema>>();


		//  Creating Schema with name, WEB.FORM __________________________________________________
		try {
			schemaSet_ScopeStack.add(new MatrixSet<SchemaInfo_Schema>().add(
				appControl.schemaControl.schemaFactory.get_BaseSchema(executeInfo),
				appControl.schemaControl.schemaForSchema
			));
		} catch (Exception e) {
			throw new Exception_MatrixRuntime_Checked("while trying to create a new Matrix Or Schema descriptor with the name, `WEB`.`FORM`," + 
				" tried to add the Base Schema to the scope stack, but had an error creating it (see inner exception).", e);
		}

		MatrixSet<SchemaInfo_Schema> descriptor32$_X_$SCHEMA$_X_$__UsesSchemaSet;
		Descriptor descriptor32$_X_$SCHEMA;

		try {
			descriptor32$_X_$SCHEMA$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>().add(appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA));
			descriptor32$_X_$SCHEMA = (Descriptor)appControl.schemaControl.schemaFactory.createNew_Schema(executeInfo, AppSymbols_Label.WEB$__$FORM, AppSymbols_DescTagName.maintests$__$samples, true, descriptor32$_X_$SCHEMA$_X_$__UsesSchemaSet, null, true);
			schemaSet_ScopeStack.add(descriptor32$_X_$SCHEMA$_X_$__UsesSchemaSet);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::SCHEMA, and with label, `WEB`.`FORM`, but had an error", e);
		}


		//  Creating SchemaInfo_Descriptor with descriptor tag with label, `FORM`.`REQUIRED` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor33$_X_$DESCRIPTOR$_X_$__UsesSchemaSet;
		Descriptor descriptor33$_X_$DESCRIPTOR;

		try {
			descriptor33$_X_$DESCRIPTOR$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor33$_X_$DESCRIPTOR = (Descriptor)appControl.schemaControl.schemaFactory.createNew_SchemaInfoDescriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("FORM", "REQUIRED"), 0, true), descriptor33$_X_$DESCRIPTOR$_X_$__UsesSchemaSet, descriptor32$_X_$SCHEMA);
			schemaSet_ScopeStack.add(descriptor33$_X_$DESCRIPTOR$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor32$_X_$SCHEMA).addChild_SchemaInfoDescriptor(executeInfo, (SchemaInfo_Descriptor)descriptor33$_X_$DESCRIPTOR);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::DESCRIPTOR, and with label, `FORM`.`REQUIRED`, but had an error", e);
		}


		//  Creating Field Descriptor for a schema with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.NAMES __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor34$_X_$FIELD_NAMES$_X_$__UsesSchemaSet;
		Descriptor descriptor34$_X_$FIELD_NAMES;

		try {
			descriptor34$_X_$FIELD_NAMES$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor34$_X_$FIELD_NAMES = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$NAMES), null, descriptor34$_X_$FIELD_NAMES$_X_$__UsesSchemaSet, descriptor33$_X_$DESCRIPTOR);
			FieldSet descriptor34$_X_$FIELD_NAMES$_X_$__FieldSet = descriptor34$_X_$FIELD_NAMES.get_FieldSet_Tuple(executeInfo);
			descriptor34$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 0, AppSymbols_DescTagName.IsRequired );
			descriptor34$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 1, AppSymbols_DescTagName.RequiredImagePath );
			descriptor34$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 2, AppSymbols_DescTagName.ImageHeight );
			descriptor34$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 3, AppSymbols_DescTagName.ImageWidth );
			schemaSet_ScopeStack.add(descriptor34$_X_$FIELD_NAMES$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor33$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor34$_X_$FIELD_NAMES);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.NAMES, and with an empty label, but had an error", e);
		}


		//  Creating Field Descriptor for a schema with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.DESC __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor35$_X_$FIELD_DESC$_X_$__UsesSchemaSet;
		Descriptor descriptor35$_X_$FIELD_DESC;

		try {
			descriptor35$_X_$FIELD_DESC$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor35$_X_$FIELD_DESC = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$DESC), null, descriptor35$_X_$FIELD_DESC$_X_$__UsesSchemaSet, descriptor33$_X_$DESCRIPTOR);
			FieldSet descriptor35$_X_$FIELD_DESC$_X_$__FieldSet = descriptor35$_X_$FIELD_DESC.get_FieldSet_Tuple(executeInfo);
			descriptor35$_X_$FIELD_DESC$_X_$__FieldSet.setField(executeInfo, 0, "Is this field required?" );
			descriptor35$_X_$FIELD_DESC$_X_$__FieldSet.setField(executeInfo, 1, "What is the path to the image that marks required fields" );
			descriptor35$_X_$FIELD_DESC$_X_$__FieldSet.setField(executeInfo, 2, "The height of the image" );
			descriptor35$_X_$FIELD_DESC$_X_$__FieldSet.setField(executeInfo, 3, "The width of the image" );
			schemaSet_ScopeStack.add(descriptor35$_X_$FIELD_DESC$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor33$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor35$_X_$FIELD_DESC);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.DESC, and with an empty label, but had an error", e);
		}


		//  Creating Field Descriptor for a schema with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.TYPES __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor36$_X_$FIELD_TYPES$_X_$__UsesSchemaSet;
		Descriptor descriptor36$_X_$FIELD_TYPES;

		try {
			descriptor36$_X_$FIELD_TYPES$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor36$_X_$FIELD_TYPES = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$TYPES), null, descriptor36$_X_$FIELD_TYPES$_X_$__UsesSchemaSet, descriptor33$_X_$DESCRIPTOR);
			FieldSet descriptor36$_X_$FIELD_TYPES$_X_$__FieldSet = descriptor36$_X_$FIELD_TYPES.get_FieldSet_Tuple(executeInfo);
			descriptor36$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 0, AppSymbols.Symbol );
			descriptor36$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 1, AppSymbols.String );
			descriptor36$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 2, AppSymbols.int$_sym_$ );
			descriptor36$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 3, AppSymbols.int$_sym_$ );
			schemaSet_ScopeStack.add(descriptor36$_X_$FIELD_TYPES$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor33$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor36$_X_$FIELD_TYPES);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.TYPES, and with an empty label, but had an error", e);
		}


		//  Creating Field Descriptor for a schema with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.DEFAULTS __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor37$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet;
		Descriptor descriptor37$_X_$FIELD_DEFAULTS;

		try {
			descriptor37$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor37$_X_$FIELD_DEFAULTS = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$DEFAULTS), null, descriptor37$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet, descriptor33$_X_$DESCRIPTOR);
			FieldSet descriptor37$_X_$FIELD_DEFAULTS$_X_$__FieldSet = descriptor37$_X_$FIELD_DEFAULTS.get_FieldSet_Tuple(executeInfo);
			descriptor37$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 0, AppSymbols.NotRequired );
			descriptor37$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 1, "/images/required.gif" );
			descriptor37$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 2, 6 );
			descriptor37$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 3, 7 );
			schemaSet_ScopeStack.add(descriptor37$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor33$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor37$_X_$FIELD_DEFAULTS);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.DEFAULTS, and with an empty label, but had an error", e);
		}


		//  Creating SchemaInfo_Descriptor with descriptor tag with label, `FORM`.`SELECTOR` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor38$_X_$DESCRIPTOR$_X_$__UsesSchemaSet;
		Descriptor descriptor38$_X_$DESCRIPTOR;

		try {
			descriptor38$_X_$DESCRIPTOR$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor38$_X_$DESCRIPTOR = (Descriptor)appControl.schemaControl.schemaFactory.createNew_SchemaInfoDescriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("FORM", "SELECTOR"), 0, true), descriptor38$_X_$DESCRIPTOR$_X_$__UsesSchemaSet, descriptor32$_X_$SCHEMA);
			schemaSet_ScopeStack.add(descriptor38$_X_$DESCRIPTOR$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor32$_X_$SCHEMA).addChild_SchemaInfoDescriptor(executeInfo, (SchemaInfo_Descriptor)descriptor38$_X_$DESCRIPTOR);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::DESCRIPTOR, and with label, `FORM`.`SELECTOR`, but had an error", e);
		}


		//  Creating SchemaInfo_Descriptor with descriptor tag with label, OPTION __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor39$_X_$DESCRIPTOR$_X_$__UsesSchemaSet;
		Descriptor descriptor39$_X_$DESCRIPTOR;

		try {
			descriptor39$_X_$DESCRIPTOR$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor39$_X_$DESCRIPTOR = (Descriptor)appControl.schemaControl.schemaFactory.createNew_SchemaInfoDescriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("OPTION"), 0, true), descriptor39$_X_$DESCRIPTOR$_X_$__UsesSchemaSet, descriptor38$_X_$DESCRIPTOR);
			schemaSet_ScopeStack.add(descriptor39$_X_$DESCRIPTOR$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor38$_X_$DESCRIPTOR).addChild_SchemaInfoDescriptor(executeInfo, (SchemaInfo_Descriptor)descriptor39$_X_$DESCRIPTOR);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::DESCRIPTOR, and with label, OPTION, but had an error", e);
		}


		//  Creating Field Descriptor for a schema with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.NAMES __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor40$_X_$FIELD_NAMES$_X_$__UsesSchemaSet;
		Descriptor descriptor40$_X_$FIELD_NAMES;

		try {
			descriptor40$_X_$FIELD_NAMES$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor40$_X_$FIELD_NAMES = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$NAMES), null, descriptor40$_X_$FIELD_NAMES$_X_$__UsesSchemaSet, descriptor39$_X_$DESCRIPTOR);
			FieldSet descriptor40$_X_$FIELD_NAMES$_X_$__FieldSet = descriptor40$_X_$FIELD_NAMES.get_FieldSet_Tuple(executeInfo);
			descriptor40$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 0, AppSymbols_DescTagName.Name );
			descriptor40$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 1, AppSymbols_DescTagName.Value );
			descriptor40$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 2, AppSymbols_DescTagName.Selected );
			schemaSet_ScopeStack.add(descriptor40$_X_$FIELD_NAMES$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor39$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor40$_X_$FIELD_NAMES);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.NAMES, and with an empty label, but had an error", e);
		}


		//  Creating Field Descriptor for a schema with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.TYPES __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor41$_X_$FIELD_TYPES$_X_$__UsesSchemaSet;
		Descriptor descriptor41$_X_$FIELD_TYPES;

		try {
			descriptor41$_X_$FIELD_TYPES$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor41$_X_$FIELD_TYPES = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$TYPES), null, descriptor41$_X_$FIELD_TYPES$_X_$__UsesSchemaSet, descriptor39$_X_$DESCRIPTOR);
			FieldSet descriptor41$_X_$FIELD_TYPES$_X_$__FieldSet = descriptor41$_X_$FIELD_TYPES.get_FieldSet_Tuple(executeInfo);
			descriptor41$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 0, AppSymbols.String );
			descriptor41$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 1, AppSymbols.String );
			descriptor41$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 2, AppSymbols.Symbol );
			schemaSet_ScopeStack.add(descriptor41$_X_$FIELD_TYPES$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor39$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor41$_X_$FIELD_TYPES);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.TYPES, and with an empty label, but had an error", e);
		}


		//  Creating Field Descriptor for a schema with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.DEFAULTS __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor42$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet;
		Descriptor descriptor42$_X_$FIELD_DEFAULTS;

		try {
			descriptor42$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor42$_X_$FIELD_DEFAULTS = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$DEFAULTS), null, descriptor42$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet, descriptor39$_X_$DESCRIPTOR);
			FieldSet descriptor42$_X_$FIELD_DEFAULTS$_X_$__FieldSet = descriptor42$_X_$FIELD_DEFAULTS.get_FieldSet_Tuple(executeInfo);
			descriptor42$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 0, null );
			descriptor42$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 1, null );
			descriptor42$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 2, AppSymbols.NotSelected );
			schemaSet_ScopeStack.add(descriptor42$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor39$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor42$_X_$FIELD_DEFAULTS);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.DEFAULTS, and with an empty label, but had an error", e);
		}


		//  Initialize the Schema:
		try {
			((SchemaInfo_Descriptor)descriptor32$_X_$SCHEMA).initialize_SchemaInfo(executeInfo, appControl.symbolControl, appControl.schemaControl.schemaControl_Info);

		} catch (Exception_SchemaInfo e) {
			throw new Exception_MatrixRuntime_Checked("Tried to initialize the Schema named, WEB$__$FORM, but had an error.", e);
		}
		schema = (SchemaInfo_Schema)descriptor32$_X_$SCHEMA;

		return (SchemaInfo_Schema)descriptor32$_X_$SCHEMA;
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
