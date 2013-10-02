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




public class Web$__$Content implements SchemaContainer {

	public static SchemaInfo_Schema schema;


	public static SchemaInfo_Schema construct(AppControl_Base appControl, ExecutionInfo executeInfo)
		throws Exception_MatrixRuntime_Checked {

		LinkedList<MatrixSet<SchemaInfo_Schema>> schemaSet_ScopeStack = new LinkedList<MatrixSet<SchemaInfo_Schema>>();


		//  Creating Schema with name, Web.Content __________________________________________________
		try {
			schemaSet_ScopeStack.add(new MatrixSet<SchemaInfo_Schema>().add(
				appControl.schemaControl.schemaFactory.get_BaseSchema(executeInfo),
				appControl.schemaControl.schemaForSchema
			));
		} catch (Exception e) {
			throw new Exception_MatrixRuntime_Checked("while trying to create a new Matrix Or Schema descriptor with the name, `Web`.`Content`," + 
				" tried to add the Base Schema to the scope stack, but had an error creating it (see inner exception).", e);
		}

		MatrixSet<SchemaInfo_Schema> descriptor15$_X_$SCHEMA$_X_$__UsesSchemaSet;
		Descriptor descriptor15$_X_$SCHEMA;

		try {
			descriptor15$_X_$SCHEMA$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>().add(appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA));
			descriptor15$_X_$SCHEMA = (Descriptor)appControl.schemaControl.schemaFactory.createNew_Schema(executeInfo, AppSymbols_Label.Web$__$Content, AppSymbols_DescTagName.maintests$__$samples, true, descriptor15$_X_$SCHEMA$_X_$__UsesSchemaSet, null, true);
			schemaSet_ScopeStack.add(descriptor15$_X_$SCHEMA$_X_$__UsesSchemaSet);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::SCHEMA, and with label, `Web`.`Content`, but had an error", e);
		}


		//  Creating SchemaInfo_Descriptor with descriptor tag with label, `PAGE`.`INFO` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor16$_X_$DESCRIPTOR$_X_$__UsesSchemaSet;
		Descriptor descriptor16$_X_$DESCRIPTOR;

		try {
			descriptor16$_X_$DESCRIPTOR$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor16$_X_$DESCRIPTOR = (Descriptor)appControl.schemaControl.schemaFactory.createNew_SchemaInfoDescriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("PAGE", "INFO"), 0, true), descriptor16$_X_$DESCRIPTOR$_X_$__UsesSchemaSet, descriptor15$_X_$SCHEMA);
			schemaSet_ScopeStack.add(descriptor16$_X_$DESCRIPTOR$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor15$_X_$SCHEMA).addChild_SchemaInfoDescriptor(executeInfo, (SchemaInfo_Descriptor)descriptor16$_X_$DESCRIPTOR);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::DESCRIPTOR, and with label, `PAGE`.`INFO`, but had an error", e);
		}


		//  Creating Field Descriptor for a schema with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.NAMES __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor17$_X_$FIELD_NAMES$_X_$__UsesSchemaSet;
		Descriptor descriptor17$_X_$FIELD_NAMES;

		try {
			descriptor17$_X_$FIELD_NAMES$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor17$_X_$FIELD_NAMES = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$NAMES), null, descriptor17$_X_$FIELD_NAMES$_X_$__UsesSchemaSet, descriptor16$_X_$DESCRIPTOR);
			FieldSet descriptor17$_X_$FIELD_NAMES$_X_$__FieldSet = descriptor17$_X_$FIELD_NAMES.get_FieldSet_Tuple(executeInfo);
			descriptor17$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 0, AppSymbols_DescTagName.Name$95$NoSpaces );
			descriptor17$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 1, AppSymbols_DescTagName.Page$95$ID );
			descriptor17$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 2, AppSymbols_DescTagName.Title );
			descriptor17$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 3, AppSymbols_DescTagName.BlurbText );
			descriptor17$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 4, AppSymbols_DescTagName.LNav$95$Href );
			descriptor17$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 5, AppSymbols_DescTagName.LNav$95$Image );
			descriptor17$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 6, AppSymbols_DescTagName.LNav$95$IsActive );
			schemaSet_ScopeStack.add(descriptor17$_X_$FIELD_NAMES$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor16$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor17$_X_$FIELD_NAMES);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.NAMES, and with an empty label, but had an error", e);
		}


		//  Creating Field Descriptor for a schema with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.DESC __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor18$_X_$FIELD_DESC$_X_$__UsesSchemaSet;
		Descriptor descriptor18$_X_$FIELD_DESC;

		try {
			descriptor18$_X_$FIELD_DESC$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor18$_X_$FIELD_DESC = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$DESC), null, descriptor18$_X_$FIELD_DESC$_X_$__UsesSchemaSet, descriptor16$_X_$DESCRIPTOR);
			FieldSet descriptor18$_X_$FIELD_DESC$_X_$__FieldSet = descriptor18$_X_$FIELD_DESC.get_FieldSet_Tuple(executeInfo);
			descriptor18$_X_$FIELD_DESC$_X_$__FieldSet.setField(executeInfo, 0, TestConstants . WebFormSchema_NameField_Description );
			descriptor18$_X_$FIELD_DESC$_X_$__FieldSet.setField(executeInfo, 1, "The page id (int)" );
			descriptor18$_X_$FIELD_DESC$_X_$__FieldSet.setField(executeInfo, 2, "Page Title" );
			descriptor18$_X_$FIELD_DESC$_X_$__FieldSet.setField(executeInfo, 3, "Short, descriptive text about the page" );
			descriptor18$_X_$FIELD_DESC$_X_$__FieldSet.setField(executeInfo, 4, "The left nav Href" );
			descriptor18$_X_$FIELD_DESC$_X_$__FieldSet.setField(executeInfo, 5, "The left nav image name" );
			descriptor18$_X_$FIELD_DESC$_X_$__FieldSet.setField(executeInfo, 6, "The left nav, is active field" );
			schemaSet_ScopeStack.add(descriptor18$_X_$FIELD_DESC$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor16$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor18$_X_$FIELD_DESC);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.DESC, and with an empty label, but had an error", e);
		}


		//  Creating Field Descriptor for a schema with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.TYPES __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor19$_X_$FIELD_TYPES$_X_$__UsesSchemaSet;
		Descriptor descriptor19$_X_$FIELD_TYPES;

		try {
			descriptor19$_X_$FIELD_TYPES$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor19$_X_$FIELD_TYPES = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$TYPES), null, descriptor19$_X_$FIELD_TYPES$_X_$__UsesSchemaSet, descriptor16$_X_$DESCRIPTOR);
			FieldSet descriptor19$_X_$FIELD_TYPES$_X_$__FieldSet = descriptor19$_X_$FIELD_TYPES.get_FieldSet_Tuple(executeInfo);
			descriptor19$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 0, AppSymbols.String );
			descriptor19$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 1, AppSymbols.int$_sym_$ );
			descriptor19$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 2, AppSymbols.String );
			descriptor19$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 3, AppSymbols.String );
			descriptor19$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 4, AppSymbols.String );
			descriptor19$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 5, AppSymbols.String );
			descriptor19$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 6, AppSymbols.boolean$_sym_$ );
			schemaSet_ScopeStack.add(descriptor19$_X_$FIELD_TYPES$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor16$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor19$_X_$FIELD_TYPES);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.TYPES, and with an empty label, but had an error", e);
		}


		//  Creating Field Descriptor for a schema with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.DEFAULTS __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor20$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet;
		Descriptor descriptor20$_X_$FIELD_DEFAULTS;

		try {
			descriptor20$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor20$_X_$FIELD_DEFAULTS = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$DEFAULTS), null, descriptor20$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet, descriptor16$_X_$DESCRIPTOR);
			FieldSet descriptor20$_X_$FIELD_DEFAULTS$_X_$__FieldSet = descriptor20$_X_$FIELD_DEFAULTS.get_FieldSet_Tuple(executeInfo);
			descriptor20$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 0, null );
			descriptor20$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 1, null );
			descriptor20$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 2, null );
			descriptor20$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 3, null );
			descriptor20$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 4, null );
			descriptor20$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 5, null );
			descriptor20$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 6, true );
			schemaSet_ScopeStack.add(descriptor20$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor16$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor20$_X_$FIELD_DEFAULTS);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.DEFAULTS, and with an empty label, but had an error", e);
		}


		//  Creating SchemaInfo_Descriptor with descriptor tag with label, NEWS __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor21$_X_$DESCRIPTOR$_X_$__UsesSchemaSet;
		Descriptor descriptor21$_X_$DESCRIPTOR;

		try {
			descriptor21$_X_$DESCRIPTOR$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor21$_X_$DESCRIPTOR = (Descriptor)appControl.schemaControl.schemaFactory.createNew_SchemaInfoDescriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("NEWS"), 0, true), descriptor21$_X_$DESCRIPTOR$_X_$__UsesSchemaSet, descriptor15$_X_$SCHEMA);
			schemaSet_ScopeStack.add(descriptor21$_X_$DESCRIPTOR$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor15$_X_$SCHEMA).addChild_SchemaInfoDescriptor(executeInfo, (SchemaInfo_Descriptor)descriptor21$_X_$DESCRIPTOR);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::DESCRIPTOR, and with label, NEWS, but had an error", e);
		}


		//  Creating SchemaInfo_Descriptor with descriptor tag with label, `NEWS`.`STORY` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor22$_X_$DESCRIPTOR$_X_$__UsesSchemaSet;
		Descriptor descriptor22$_X_$DESCRIPTOR;

		try {
			descriptor22$_X_$DESCRIPTOR$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor22$_X_$DESCRIPTOR = (Descriptor)appControl.schemaControl.schemaFactory.createNew_SchemaInfoDescriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("NEWS", "STORY"), 0, true), descriptor22$_X_$DESCRIPTOR$_X_$__UsesSchemaSet, descriptor21$_X_$DESCRIPTOR);
			schemaSet_ScopeStack.add(descriptor22$_X_$DESCRIPTOR$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor21$_X_$DESCRIPTOR).addChild_SchemaInfoDescriptor(executeInfo, (SchemaInfo_Descriptor)descriptor22$_X_$DESCRIPTOR);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::DESCRIPTOR, and with label, `NEWS`.`STORY`, but had an error", e);
		}


		//  Creating Field Descriptor for a schema with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.NAMES __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor23$_X_$FIELD_NAMES$_X_$__UsesSchemaSet;
		Descriptor descriptor23$_X_$FIELD_NAMES;

		try {
			descriptor23$_X_$FIELD_NAMES$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor23$_X_$FIELD_NAMES = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$NAMES), null, descriptor23$_X_$FIELD_NAMES$_X_$__UsesSchemaSet, descriptor22$_X_$DESCRIPTOR);
			FieldSet descriptor23$_X_$FIELD_NAMES$_X_$__FieldSet = descriptor23$_X_$FIELD_NAMES.get_FieldSet_Tuple(executeInfo);
			descriptor23$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 0, AppSymbols_DescTagName.NewsItem$95$ID );
			descriptor23$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 1, AppSymbols_DescTagName.Title );
			descriptor23$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 2, AppSymbols_DescTagName.DateText );
			descriptor23$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 3, AppSymbols_DescTagName.Story$95$Blurb );
			descriptor23$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 4, AppSymbols_DescTagName.Story$95$Text );
			schemaSet_ScopeStack.add(descriptor23$_X_$FIELD_NAMES$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor22$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor23$_X_$FIELD_NAMES);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.NAMES, and with an empty label, but had an error", e);
		}


		//  Creating Field Descriptor for a schema with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.DESC __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor24$_X_$FIELD_DESC$_X_$__UsesSchemaSet;
		Descriptor descriptor24$_X_$FIELD_DESC;

		try {
			descriptor24$_X_$FIELD_DESC$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor24$_X_$FIELD_DESC = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$DESC), null, descriptor24$_X_$FIELD_DESC$_X_$__UsesSchemaSet, descriptor22$_X_$DESCRIPTOR);
			FieldSet descriptor24$_X_$FIELD_DESC$_X_$__FieldSet = descriptor24$_X_$FIELD_DESC.get_FieldSet_Tuple(executeInfo);
			descriptor24$_X_$FIELD_DESC$_X_$__FieldSet.setField(executeInfo, 0, "Id of news item" );
			descriptor24$_X_$FIELD_DESC$_X_$__FieldSet.setField(executeInfo, 1, "News item description" );
			descriptor24$_X_$FIELD_DESC$_X_$__FieldSet.setField(executeInfo, 2, "Date" );
			descriptor24$_X_$FIELD_DESC$_X_$__FieldSet.setField(executeInfo, 3, "The short blurb about the story" );
			descriptor24$_X_$FIELD_DESC$_X_$__FieldSet.setField(executeInfo, 4, "The text of the story." );
			schemaSet_ScopeStack.add(descriptor24$_X_$FIELD_DESC$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor22$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor24$_X_$FIELD_DESC);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.DESC, and with an empty label, but had an error", e);
		}


		//  Creating Field Descriptor for a schema with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.TYPES __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor25$_X_$FIELD_TYPES$_X_$__UsesSchemaSet;
		Descriptor descriptor25$_X_$FIELD_TYPES;

		try {
			descriptor25$_X_$FIELD_TYPES$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor25$_X_$FIELD_TYPES = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$TYPES), null, descriptor25$_X_$FIELD_TYPES$_X_$__UsesSchemaSet, descriptor22$_X_$DESCRIPTOR);
			FieldSet descriptor25$_X_$FIELD_TYPES$_X_$__FieldSet = descriptor25$_X_$FIELD_TYPES.get_FieldSet_Tuple(executeInfo);
			descriptor25$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 0, AppSymbols.String );
			descriptor25$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 1, AppSymbols.String );
			descriptor25$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 2, AppSymbols.String );
			descriptor25$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 3, AppSymbols.String );
			descriptor25$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 4, AppSymbols.String );
			schemaSet_ScopeStack.add(descriptor25$_X_$FIELD_TYPES$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor22$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor25$_X_$FIELD_TYPES);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.TYPES, and with an empty label, but had an error", e);
		}


		//  Creating Field Descriptor for a schema with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.DEFAULTS __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor26$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet;
		Descriptor descriptor26$_X_$FIELD_DEFAULTS;

		try {
			descriptor26$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor26$_X_$FIELD_DEFAULTS = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$DEFAULTS), null, descriptor26$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet, descriptor22$_X_$DESCRIPTOR);
			FieldSet descriptor26$_X_$FIELD_DEFAULTS$_X_$__FieldSet = descriptor26$_X_$FIELD_DEFAULTS.get_FieldSet_Tuple(executeInfo);
			descriptor26$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 0, null );
			descriptor26$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 1, null );
			descriptor26$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 2, null );
			descriptor26$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 3, null );
			descriptor26$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 4, null );
			schemaSet_ScopeStack.add(descriptor26$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor22$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor26$_X_$FIELD_DEFAULTS);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.DEFAULTS, and with an empty label, but had an error", e);
		}


		//  Creating SchemaInfo_Descriptor with descriptor tag with label, PEOPLE __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor27$_X_$DESCRIPTOR$_X_$__UsesSchemaSet;
		Descriptor descriptor27$_X_$DESCRIPTOR;

		try {
			descriptor27$_X_$DESCRIPTOR$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor27$_X_$DESCRIPTOR = (Descriptor)appControl.schemaControl.schemaFactory.createNew_SchemaInfoDescriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("PEOPLE"), 0, true), descriptor27$_X_$DESCRIPTOR$_X_$__UsesSchemaSet, descriptor15$_X_$SCHEMA);
			schemaSet_ScopeStack.add(descriptor27$_X_$DESCRIPTOR$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor15$_X_$SCHEMA).addChild_SchemaInfoDescriptor(executeInfo, (SchemaInfo_Descriptor)descriptor27$_X_$DESCRIPTOR);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::DESCRIPTOR, and with label, PEOPLE, but had an error", e);
		}


		//  Creating SchemaInfo_Descriptor with descriptor tag with label, `PERSON`.`INFO` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor28$_X_$DESCRIPTOR$_X_$__UsesSchemaSet;
		Descriptor descriptor28$_X_$DESCRIPTOR;

		try {
			descriptor28$_X_$DESCRIPTOR$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor28$_X_$DESCRIPTOR = (Descriptor)appControl.schemaControl.schemaFactory.createNew_SchemaInfoDescriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("PERSON", "INFO"), 0, true), descriptor28$_X_$DESCRIPTOR$_X_$__UsesSchemaSet, descriptor27$_X_$DESCRIPTOR);
			schemaSet_ScopeStack.add(descriptor28$_X_$DESCRIPTOR$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor27$_X_$DESCRIPTOR).addChild_SchemaInfoDescriptor(executeInfo, (SchemaInfo_Descriptor)descriptor28$_X_$DESCRIPTOR);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::DESCRIPTOR, and with label, `PERSON`.`INFO`, but had an error", e);
		}


		//  Creating Field Descriptor for a schema with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.NAMES __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor29$_X_$FIELD_NAMES$_X_$__UsesSchemaSet;
		Descriptor descriptor29$_X_$FIELD_NAMES;

		try {
			descriptor29$_X_$FIELD_NAMES$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor29$_X_$FIELD_NAMES = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$NAMES), null, descriptor29$_X_$FIELD_NAMES$_X_$__UsesSchemaSet, descriptor28$_X_$DESCRIPTOR);
			FieldSet descriptor29$_X_$FIELD_NAMES$_X_$__FieldSet = descriptor29$_X_$FIELD_NAMES.get_FieldSet_Tuple(executeInfo);
			descriptor29$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 0, AppSymbols_DescTagName.Person$95$ID );
			descriptor29$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 1, AppSymbols_DescTagName.Name );
			descriptor29$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 2, AppSymbols_DescTagName.Title );
			descriptor29$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 3, AppSymbols_DescTagName.Role );
			descriptor29$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 4, AppSymbols_DescTagName.Email );
			descriptor29$_X_$FIELD_NAMES$_X_$__FieldSet.setField(executeInfo, 5, AppSymbols_DescTagName.Description );
			schemaSet_ScopeStack.add(descriptor29$_X_$FIELD_NAMES$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor28$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor29$_X_$FIELD_NAMES);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.NAMES, and with an empty label, but had an error", e);
		}


		//  Creating Field Descriptor for a schema with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.TYPES __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor30$_X_$FIELD_TYPES$_X_$__UsesSchemaSet;
		Descriptor descriptor30$_X_$FIELD_TYPES;

		try {
			descriptor30$_X_$FIELD_TYPES$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor30$_X_$FIELD_TYPES = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$TYPES), null, descriptor30$_X_$FIELD_TYPES$_X_$__UsesSchemaSet, descriptor28$_X_$DESCRIPTOR);
			FieldSet descriptor30$_X_$FIELD_TYPES$_X_$__FieldSet = descriptor30$_X_$FIELD_TYPES.get_FieldSet_Tuple(executeInfo);
			descriptor30$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 0, AppSymbols.String );
			descriptor30$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 1, AppSymbols.String );
			descriptor30$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 2, AppSymbols.String );
			descriptor30$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 3, AppSymbols.String );
			descriptor30$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 4, AppSymbols.String );
			descriptor30$_X_$FIELD_TYPES$_X_$__FieldSet.setField(executeInfo, 5, AppSymbols.String );
			schemaSet_ScopeStack.add(descriptor30$_X_$FIELD_TYPES$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor28$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor30$_X_$FIELD_TYPES);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.TYPES, and with an empty label, but had an error", e);
		}


		//  Creating Field Descriptor for a schema with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.DEFAULTS __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor31$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet;
		Descriptor descriptor31$_X_$FIELD_DEFAULTS;

		try {
			descriptor31$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor31$_X_$FIELD_DEFAULTS = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$DEFAULTS), null, descriptor31$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet, descriptor28$_X_$DESCRIPTOR);
			FieldSet descriptor31$_X_$FIELD_DEFAULTS$_X_$__FieldSet = descriptor31$_X_$FIELD_DEFAULTS.get_FieldSet_Tuple(executeInfo);
			descriptor31$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 0, null );
			descriptor31$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 1, null );
			descriptor31$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 2, null );
			descriptor31$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 3, null );
			descriptor31$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 4, null );
			descriptor31$_X_$FIELD_DEFAULTS$_X_$__FieldSet.setField(executeInfo, 5, null );
			schemaSet_ScopeStack.add(descriptor31$_X_$FIELD_DEFAULTS$_X_$__UsesSchemaSet);
			((SchemaInfo_Descriptor)descriptor28$_X_$DESCRIPTOR).addChild_SchemaInfo_FieldDescriptor(executeInfo, descriptor31$_X_$FIELD_DEFAULTS);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::SCHEMA_FOR_SCHEMA::FIELD.DEFAULTS, and with an empty label, but had an error", e);
		}


		//  Initialize the Schema:
		try {
			((SchemaInfo_Descriptor)descriptor15$_X_$SCHEMA).initialize_SchemaInfo(executeInfo, appControl.symbolControl, appControl.schemaControl.schemaControl_Info);

		} catch (Exception_SchemaInfo e) {
			throw new Exception_MatrixRuntime_Checked("Tried to initialize the Schema named, Web$__$Content, but had an error.", e);
		}
		schema = (SchemaInfo_Schema)descriptor15$_X_$SCHEMA;

		return (SchemaInfo_Schema)descriptor15$_X_$SCHEMA;
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
