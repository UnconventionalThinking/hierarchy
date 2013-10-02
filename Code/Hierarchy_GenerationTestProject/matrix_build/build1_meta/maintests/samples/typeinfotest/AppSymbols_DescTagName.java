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

public class AppSymbols_DescTagName { 

	//  Single Symbols:
	public static DescriptorTagName SCHEMA;
	public static final int SCHEMA$_ID_$ = 47;
	public static DescriptorTagName MATRIX;
	public static final int MATRIX$_ID_$ = 48;
	public static DescriptorTagName DESCRIPTOR;
	public static final int DESCRIPTOR$_ID_$ = 49;
	public static DescriptorTagName ITEM;
	public static final int ITEM$_ID_$ = 50;
	public static DescriptorTagName FIELD;
	public static final int FIELD$_ID_$ = 51;
	public static DescriptorTagName NAMES;
	public static final int NAMES$_ID_$ = 52;
	public static DescriptorTagName TYPES;
	public static final int TYPES$_ID_$ = 53;
	public static DescriptorTagName DESC;
	public static final int DESC$_ID_$ = 54;
	public static DescriptorTagName DEFAULTS;
	public static final int DEFAULTS$_ID_$ = 55;
	public static DescriptorTagName TEST;
	public static final int TEST$_ID_$ = 56;
	public static DescriptorTagName IsPersistentMatrix;
	public static final int IsPersistentMatrix$_ID_$ = 57;
	public static DescriptorTagName com;
	public static final int com$_ID_$ = 58;
	public static DescriptorTagName abstractsystems;
	public static final int abstractsystems$_ID_$ = 59;
	public static DescriptorTagName matrix;
	public static final int matrix$_ID_$ = 60;
	public static DescriptorTagName schema;
	public static final int schema$_ID_$ = 61;
	public static DescriptorTagName WEB;
	public static final int WEB$_ID_$ = 62;
	public static DescriptorTagName FORM;
	public static final int FORM$_ID_$ = 63;
	public static DescriptorTagName BASE;
	public static final int BASE$_ID_$ = 64;
	public static DescriptorTagName STANDARD;
	public static final int STANDARD$_ID_$ = 65;
	public static DescriptorTagName SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA;
	public static final int SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_ID_$ = 66;
	public static DescriptorTagName SCHEMA$95$FOR$95$SCHEMA;
	public static final int SCHEMA$95$FOR$95$SCHEMA$_ID_$ = 67;


	//  MultiPart Symbols:
	public static DescriptorTagName FIELD$__$NAMES;
	public static final int FIELD$__$NAMES$_ID_$ = 210;
	public static DescriptorTagName FIELD$__$TYPES;
	public static final int FIELD$__$TYPES$_ID_$ = 211;
	public static DescriptorTagName FIELD$__$DESC;
	public static final int FIELD$__$DESC$_ID_$ = 212;
	public static DescriptorTagName FIELD$__$DEFAULTS;
	public static final int FIELD$__$DEFAULTS$_ID_$ = 213;
	public static DescriptorTagName MATRIX$__$BASE;
	public static final int MATRIX$__$BASE$_ID_$ = 215;
	public static DescriptorTagName MATRIX$__$STANDARD;
	public static final int MATRIX$__$STANDARD$_ID_$ = 216;
	public static DescriptorTagName net$__$unconventionalthinking;
	public static final int net$__$unconventionalthinking$_ID_$ = 218;
	public static DescriptorTagName net$__$unconventionalthinking$__$matrix;
	public static final int net$__$unconventionalthinking$__$matrix$_ID_$ = 219;
	public static DescriptorTagName net$__$unconventionalthinking$__$matrix$__$schema;
	public static final int net$__$unconventionalthinking$__$matrix$__$schema$_ID_$ = 220;
	public static DescriptorTagName WEB$__$FORM;
	public static final int WEB$__$FORM$_ID_$ = 222;


	//  Initializer for Symbols:
	public static boolean have_Intialized = false;



	static void initialize(SymbolControl symbol_Control) throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed,
		Exception_SymbolCreation, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolCreationOrAccess {
		initialize(symbol_Control, false);
	}

	/**
	 * If you set have_ParentAppControl to true, then the symbolControl you pass in should be from a parent AppControl (which means this class
	 * and all of the other app control classes for this application context are probably in a jar, being used by a parent application. <p>
	 *
	 * What this means is that all the ID fields for this class are INCORRECT!! The Id's for symbols will not be hard coded, but set dynamically.<br>
	 * What this also means is that for right now, jar files can not have embedded matrix classes methods with matrix accesses that are called from
	 * a parent application (because matrix access uses these id's).
	 */
	static void initialize(SymbolControl symbol_Control, boolean have_ParentAppControl) throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed,
			Exception_SymbolCreation, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolCreationOrAccess {

		SymbolControl symbolControl = symbol_Control;
		Symbol_Single_Factory singleSymbol_Factory = symbolControl.singleSymbol_Factory;
		Symbol_MultiPart_Factory multiPartSymbol_Factory = symbolControl.multiPartSymbol_Factory;

		//  Multipart-Symbol related variables:
		List<Symbol_Single> newlyCreatedSymbols = new ArrayList<Symbol_Single>();
		Boolean_Mutable have_Created_New_MultiPartSymbol = new Boolean_Mutable(false);
		int creation_StartLevel = 0;
		boolean creation_Has_StaticVersion = true;

		List<String> symbolStrings = null;


		//  Single Symbols _________________________________________________________________________

		SCHEMA = (have_ParentAppControl) ? singleSymbol_Factory.createNew_DescTagName("SCHEMA", true) :
				singleSymbol_Factory.createNew_DescTagName("SCHEMA", 47, true, null);
		MATRIX = (have_ParentAppControl) ? singleSymbol_Factory.createNew_DescTagName("MATRIX", true) :
				singleSymbol_Factory.createNew_DescTagName("MATRIX", 48, true, null);
		DESCRIPTOR = (have_ParentAppControl) ? singleSymbol_Factory.createNew_DescTagName("DESCRIPTOR", true) :
				singleSymbol_Factory.createNew_DescTagName("DESCRIPTOR", 49, true, null);
		ITEM = (have_ParentAppControl) ? singleSymbol_Factory.createNew_DescTagName("ITEM", true) :
				singleSymbol_Factory.createNew_DescTagName("ITEM", 50, true, null);
		FIELD = (have_ParentAppControl) ? singleSymbol_Factory.createNew_DescTagName("FIELD", true) :
				singleSymbol_Factory.createNew_DescTagName("FIELD", 51, true, null);
		NAMES = (have_ParentAppControl) ? singleSymbol_Factory.createNew_DescTagName("NAMES", true) :
				singleSymbol_Factory.createNew_DescTagName("NAMES", 52, true, null);
		TYPES = (have_ParentAppControl) ? singleSymbol_Factory.createNew_DescTagName("TYPES", true) :
				singleSymbol_Factory.createNew_DescTagName("TYPES", 53, true, null);
		DESC = (have_ParentAppControl) ? singleSymbol_Factory.createNew_DescTagName("DESC", true) :
				singleSymbol_Factory.createNew_DescTagName("DESC", 54, true, null);
		DEFAULTS = (have_ParentAppControl) ? singleSymbol_Factory.createNew_DescTagName("DEFAULTS", true) :
				singleSymbol_Factory.createNew_DescTagName("DEFAULTS", 55, true, null);
		TEST = (have_ParentAppControl) ? singleSymbol_Factory.createNew_DescTagName("TEST", true) :
				singleSymbol_Factory.createNew_DescTagName("TEST", 56, true, null);
		IsPersistentMatrix = (have_ParentAppControl) ? singleSymbol_Factory.createNew_DescTagName("IsPersistentMatrix", true) :
				singleSymbol_Factory.createNew_DescTagName("IsPersistentMatrix", 57, true, null);
		com = (have_ParentAppControl) ? singleSymbol_Factory.createNew_DescTagName("com", true) :
				singleSymbol_Factory.createNew_DescTagName("com", 58, true, null);
		abstractsystems = (have_ParentAppControl) ? singleSymbol_Factory.createNew_DescTagName("abstractsystems", true) :
				singleSymbol_Factory.createNew_DescTagName("abstractsystems", 59, true, null);
		matrix = (have_ParentAppControl) ? singleSymbol_Factory.createNew_DescTagName("matrix", true) :
				singleSymbol_Factory.createNew_DescTagName("matrix", 60, true, null);
		schema = (have_ParentAppControl) ? singleSymbol_Factory.createNew_DescTagName("schema", true) :
				singleSymbol_Factory.createNew_DescTagName("schema", 61, true, null);
		WEB = (have_ParentAppControl) ? singleSymbol_Factory.createNew_DescTagName("WEB", true) :
				singleSymbol_Factory.createNew_DescTagName("WEB", 62, true, null);
		FORM = (have_ParentAppControl) ? singleSymbol_Factory.createNew_DescTagName("FORM", true) :
				singleSymbol_Factory.createNew_DescTagName("FORM", 63, true, null);
		BASE = (have_ParentAppControl) ? singleSymbol_Factory.createNew_DescTagName("BASE", true) :
				singleSymbol_Factory.createNew_DescTagName("BASE", 64, true, null);
		STANDARD = (have_ParentAppControl) ? singleSymbol_Factory.createNew_DescTagName("STANDARD", true) :
				singleSymbol_Factory.createNew_DescTagName("STANDARD", 65, true, null);
		SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA = (have_ParentAppControl) ? singleSymbol_Factory.createNew_DescTagName("SCHEMA_FOR__SCHEMA_FOR_SCHEMA", true) :
				singleSymbol_Factory.createNew_DescTagName("SCHEMA_FOR__SCHEMA_FOR_SCHEMA", 66, true, null);
		SCHEMA$95$FOR$95$SCHEMA = (have_ParentAppControl) ? singleSymbol_Factory.createNew_DescTagName("SCHEMA_FOR_SCHEMA", true) :
				singleSymbol_Factory.createNew_DescTagName("SCHEMA_FOR_SCHEMA", 67, true, null);



		//  MultiPart Symbols _________________________________________________________________________

		//  `FIELD`.`NAMES`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("NAMES");

		FIELD$__$NAMES = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, 210, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`TYPES`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("TYPES");

		FIELD$__$TYPES = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, 211, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`DESC`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("DESC");

		FIELD$__$DESC = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, 212, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`DEFAULTS`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("DEFAULTS");

		FIELD$__$DEFAULTS = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, 213, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MATRIX`.`BASE`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIX");
		symbolStrings.add("BASE");

		MATRIX$__$BASE = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, 215, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MATRIX`.`STANDARD`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIX");
		symbolStrings.add("STANDARD");

		MATRIX$__$STANDARD = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, 216, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `com`.`abstractsystems`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("com");
		symbolStrings.add("abstractsystems");

		net$__$unconventionalthinking = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, 218, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `com`.`abstractsystems`.`matrix`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("com");
		symbolStrings.add("abstractsystems");
		symbolStrings.add("matrix");

		net$__$unconventionalthinking$__$matrix = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, 219, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `com`.`abstractsystems`.`matrix`.`schema`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("com");
		symbolStrings.add("abstractsystems");
		symbolStrings.add("matrix");
		symbolStrings.add("schema");

		net$__$unconventionalthinking$__$matrix$__$schema = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, 220, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `WEB`.`FORM`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("WEB");
		symbolStrings.add("FORM");

		WEB$__$FORM = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, 222, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		have_Intialized = true;
	}


}
