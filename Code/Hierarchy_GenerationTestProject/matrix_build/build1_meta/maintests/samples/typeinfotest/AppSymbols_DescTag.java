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

package maintests.samples.typeinfotest;

import java.util.*;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.exceptions.*; 

public class AppSymbols_DescTag { 



	//  DescriptorTag:
	public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$SCHEMA;
	public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR;
	public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$NAMES;
	public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$TYPES;
	public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$SCHEMA;
	public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR;
	public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$ITEM;
	public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$MATRIX;
	public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$NAMES;
	public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$TYPES;
	public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$DESC;
	public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$DEFAULTS;
	public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$BASE$_CC_$MATRIX;
	public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM;
	public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$MATRIX;
	public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$ITEM;


	//  Initializer for Symbols:
	public static boolean have_Intialized = false;


	static void initialize(SymbolControl symbol_Control) throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed {
		initialize(symbol_Control, false);
	}

	/**
	 * NOTE: have_ParentAppControl is currently not used by multi-level symbols. It made be in the future. The purpose of this field is:<p>
	 *
	 * If you set have_ParentAppControl to true, then the symbolControl you pass in should be from a parent AppControl (which means this class
	 * and all of the other app control classes for this application context are probably in a jar, being used by a parent application. <p>
	 *
	 * What this means is that all the ID fields for this class are INCORRECT!! The Id's for symbols will not be hard coded, but set dynamically.<br>
	 * What this also means is that for right now, jar files can not have embedded matrix classes methods with matrix accesses that are called from
	 * a parent application (because matrix access uses these id's).
	 */
	static void initialize(SymbolControl symbol_Control, boolean have_ParentAppControl) throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed {

		SymbolControl symbolControl = symbol_Control;
		Symbol_MultiLevel_Factory multiLevelSymbol_Factory = symbolControl.multiLevelSymbol_Factory;

		boolean creation_Has_StaticVersion = true;


		// DescriptorTag _________________________________________________________________________

		//  `com`.`abstractsystems`.`matrix`::SCHEMA_FOR__SCHEMA_FOR_SCHEMA::SCHEMA

		net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$SCHEMA = multiLevelSymbol_Factory.createNew_DescriptorTag(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA, AppSymbols_DescTagName.SCHEMA,creation_Has_StaticVersion);

		//  `com`.`abstractsystems`.`matrix`::SCHEMA_FOR__SCHEMA_FOR_SCHEMA::DESCRIPTOR

		net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR = multiLevelSymbol_Factory.createNew_DescriptorTag(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA, AppSymbols_DescTagName.DESCRIPTOR,creation_Has_StaticVersion);

		//  `com`.`abstractsystems`.`matrix`::SCHEMA_FOR__SCHEMA_FOR_SCHEMA::`FIELD`.`NAMES`

		net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$NAMES = multiLevelSymbol_Factory.createNew_DescriptorTag(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA, AppSymbols_DescTagName.FIELD$__$NAMES,creation_Has_StaticVersion);

		//  `com`.`abstractsystems`.`matrix`::SCHEMA_FOR__SCHEMA_FOR_SCHEMA::`FIELD`.`TYPES`

		net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$TYPES = multiLevelSymbol_Factory.createNew_DescriptorTag(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA, AppSymbols_DescTagName.FIELD$__$TYPES,creation_Has_StaticVersion);

		//  `com`.`abstractsystems`.`matrix`::SCHEMA_FOR_SCHEMA::SCHEMA

		net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$SCHEMA = multiLevelSymbol_Factory.createNew_DescriptorTag(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, AppSymbols_DescTagName.SCHEMA,creation_Has_StaticVersion);

		//  `com`.`abstractsystems`.`matrix`::SCHEMA_FOR_SCHEMA::DESCRIPTOR

		net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR = multiLevelSymbol_Factory.createNew_DescriptorTag(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, AppSymbols_DescTagName.DESCRIPTOR,creation_Has_StaticVersion);

		//  `com`.`abstractsystems`.`matrix`::SCHEMA_FOR_SCHEMA::ITEM

		net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$ITEM = multiLevelSymbol_Factory.createNew_DescriptorTag(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, AppSymbols_DescTagName.ITEM,creation_Has_StaticVersion);

		//  `com`.`abstractsystems`.`matrix`::SCHEMA_FOR_SCHEMA::MATRIX

		net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$MATRIX = multiLevelSymbol_Factory.createNew_DescriptorTag(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, AppSymbols_DescTagName.MATRIX,creation_Has_StaticVersion);

		//  `com`.`abstractsystems`.`matrix`::SCHEMA_FOR_SCHEMA::`FIELD`.`NAMES`

		net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$NAMES = multiLevelSymbol_Factory.createNew_DescriptorTag(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, AppSymbols_DescTagName.FIELD$__$NAMES,creation_Has_StaticVersion);

		//  `com`.`abstractsystems`.`matrix`::SCHEMA_FOR_SCHEMA::`FIELD`.`TYPES`

		net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$TYPES = multiLevelSymbol_Factory.createNew_DescriptorTag(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, AppSymbols_DescTagName.FIELD$__$TYPES,creation_Has_StaticVersion);

		//  `com`.`abstractsystems`.`matrix`::SCHEMA_FOR_SCHEMA::`FIELD`.`DESC`

		net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$DESC = multiLevelSymbol_Factory.createNew_DescriptorTag(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, AppSymbols_DescTagName.FIELD$__$DESC,creation_Has_StaticVersion);

		//  `com`.`abstractsystems`.`matrix`::SCHEMA_FOR_SCHEMA::`FIELD`.`DEFAULTS`

		net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$DEFAULTS = multiLevelSymbol_Factory.createNew_DescriptorTag(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, AppSymbols_DescTagName.FIELD$__$DEFAULTS,creation_Has_StaticVersion);

		//  `com`.`abstractsystems`.`matrix`::`MATRIX`.`BASE`::MATRIX

		net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$BASE$_CC_$MATRIX = multiLevelSymbol_Factory.createNew_DescriptorTag(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$BASE, AppSymbols_DescTagName.MATRIX,creation_Has_StaticVersion);

		//  `com`.`abstractsystems`.`matrix`::`MATRIX`.`STANDARD`::ITEM

		net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM = multiLevelSymbol_Factory.createNew_DescriptorTag(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD, AppSymbols_DescTagName.ITEM,creation_Has_StaticVersion);

		//  `com`.`abstractsystems`.`matrix`::SCHEMA_FOR__SCHEMA_FOR_SCHEMA::MATRIX

		net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$MATRIX = multiLevelSymbol_Factory.createNew_DescriptorTag(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA, AppSymbols_DescTagName.MATRIX,creation_Has_StaticVersion);

		//  `com`.`abstractsystems`.`matrix`::SCHEMA_FOR__SCHEMA_FOR_SCHEMA::ITEM

		net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$ITEM = multiLevelSymbol_Factory.createNew_DescriptorTag(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA, AppSymbols_DescTagName.ITEM,creation_Has_StaticVersion);

		have_Intialized = true;
	}


}
