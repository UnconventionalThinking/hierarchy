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

import java.util.*;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.exceptions.*; 

public class AppSymbols_Label { 

	//  Single Symbols:
	public static Label SCHEMA;
	public static final int SCHEMA$_ID_$ = 88;
	public static Label MATRIX;
	public static final int MATRIX$_ID_$ = 89;
	public static Label ITEM;
	public static final int ITEM$_ID_$ = 90;
	public static Label DESCRIPTOR;
	public static final int DESCRIPTOR$_ID_$ = 91;
	public static Label FIELD;
	public static final int FIELD$_ID_$ = 92;
	public static Label NAMES;
	public static final int NAMES$_ID_$ = 93;
	public static Label TYPES;
	public static final int TYPES$_ID_$ = 94;
	public static Label DESC;
	public static final int DESC$_ID_$ = 95;
	public static Label DEFAULTS;
	public static final int DEFAULTS$_ID_$ = 96;
	public static Label BASE;
	public static final int BASE$_ID_$ = 97;
	public static Label STANDARD;
	public static final int STANDARD$_ID_$ = 98;
	public static Label SCHEMA$95$FOR$95$SCHEMA;
	public static final int SCHEMA$95$FOR$95$SCHEMA$_ID_$ = 99;
	public static Label TEST;
	public static final int TEST$_ID_$ = 100;
	public static Label WEB;
	public static final int WEB$_ID_$ = 139;
	public static Label FORM;
	public static final int FORM$_ID_$ = 140;
	public static Label REQUIRED;
	public static final int REQUIRED$_ID_$ = 145;
	public static Label SELECT;
	public static final int SELECT$_ID_$ = 158;
	public static Label OPTION;
	public static final int OPTION$_ID_$ = 165;
	public static Label MY$95$DESC;
	public static final int MY$95$DESC$_ID_$ = 181;
	public static Label NUM1;
	public static final int NUM1$_ID_$ = 182;
	public static Label NUM2;
	public static final int NUM2$_ID_$ = 193;


	//  MultiPart Symbols:
	public static Label FIELD$__$NAMES;
	public static final int FIELD$__$NAMES$_ID_$ = 102;
	public static Label FIELD$__$TYPES;
	public static final int FIELD$__$TYPES$_ID_$ = 103;
	public static Label FIELD$__$DESC;
	public static final int FIELD$__$DESC$_ID_$ = 104;
	public static Label FIELD$__$DEFAULTS;
	public static final int FIELD$__$DEFAULTS$_ID_$ = 105;
	public static Label MATRIX$__$BASE;
	public static final int MATRIX$__$BASE$_ID_$ = 107;
	public static Label MATRIX$__$STANDARD;
	public static final int MATRIX$__$STANDARD$_ID_$ = 108;
	public static Label WEB$__$FORM;
	public static final int WEB$__$FORM$_ID_$ = 142;
	public static Label FORM$__$REQUIRED;
	public static final int FORM$__$REQUIRED$_ID_$ = 147;
	public static Label FORM$__$SELECT;
	public static final int FORM$__$SELECT$_ID_$ = 159;
	public static Label TEST$__$SCHEMA;
	public static final int TEST$__$SCHEMA$_ID_$ = 176;
	public static Label MY$95$DESC$__$NUM1;
	public static final int MY$95$DESC$__$NUM1$_ID_$ = 184;
	public static Label MY$95$DESC$__$NUM2;
	public static final int MY$95$DESC$__$NUM2$_ID_$ = 194;


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

		SCHEMA = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("SCHEMA", true) :
				singleSymbol_Factory.createNew_Label("SCHEMA", 88, true, null);
		MATRIX = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("MATRIX", true) :
				singleSymbol_Factory.createNew_Label("MATRIX", 89, true, null);
		ITEM = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("ITEM", true) :
				singleSymbol_Factory.createNew_Label("ITEM", 90, true, null);
		DESCRIPTOR = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("DESCRIPTOR", true) :
				singleSymbol_Factory.createNew_Label("DESCRIPTOR", 91, true, null);
		FIELD = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("FIELD", true) :
				singleSymbol_Factory.createNew_Label("FIELD", 92, true, null);
		NAMES = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("NAMES", true) :
				singleSymbol_Factory.createNew_Label("NAMES", 93, true, null);
		TYPES = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("TYPES", true) :
				singleSymbol_Factory.createNew_Label("TYPES", 94, true, null);
		DESC = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("DESC", true) :
				singleSymbol_Factory.createNew_Label("DESC", 95, true, null);
		DEFAULTS = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("DEFAULTS", true) :
				singleSymbol_Factory.createNew_Label("DEFAULTS", 96, true, null);
		BASE = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("BASE", true) :
				singleSymbol_Factory.createNew_Label("BASE", 97, true, null);
		STANDARD = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("STANDARD", true) :
				singleSymbol_Factory.createNew_Label("STANDARD", 98, true, null);
		SCHEMA$95$FOR$95$SCHEMA = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("SCHEMA_FOR_SCHEMA", true) :
				singleSymbol_Factory.createNew_Label("SCHEMA_FOR_SCHEMA", 99, true, null);
		TEST = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("TEST", true) :
				singleSymbol_Factory.createNew_Label("TEST", 100, true, null);
		WEB = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("WEB", true) :
				singleSymbol_Factory.createNew_Label("WEB", 139, true, null);
		FORM = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("FORM", true) :
				singleSymbol_Factory.createNew_Label("FORM", 140, true, null);
		REQUIRED = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("REQUIRED", true) :
				singleSymbol_Factory.createNew_Label("REQUIRED", 145, true, null);
		SELECT = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("SELECT", true) :
				singleSymbol_Factory.createNew_Label("SELECT", 158, true, null);
		OPTION = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("OPTION", true) :
				singleSymbol_Factory.createNew_Label("OPTION", 165, true, null);
		MY$95$DESC = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("MY_DESC", true) :
				singleSymbol_Factory.createNew_Label("MY_DESC", 181, true, null);
		NUM1 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("NUM1", true) :
				singleSymbol_Factory.createNew_Label("NUM1", 182, true, null);
		NUM2 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("NUM2", true) :
				singleSymbol_Factory.createNew_Label("NUM2", 193, true, null);



		//  MultiPart Symbols _________________________________________________________________________

		//  `FIELD`.`NAMES`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("NAMES");

		FIELD$__$NAMES = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 102, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`TYPES`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("TYPES");

		FIELD$__$TYPES = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 103, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`DESC`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("DESC");

		FIELD$__$DESC = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 104, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`DEFAULTS`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("DEFAULTS");

		FIELD$__$DEFAULTS = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 105, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MATRIX`.`BASE`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIX");
		symbolStrings.add("BASE");

		MATRIX$__$BASE = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 107, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MATRIX`.`STANDARD`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIX");
		symbolStrings.add("STANDARD");

		MATRIX$__$STANDARD = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 108, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `WEB`.`FORM`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("WEB");
		symbolStrings.add("FORM");

		WEB$__$FORM = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 142, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FORM`.`REQUIRED`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FORM");
		symbolStrings.add("REQUIRED");

		FORM$__$REQUIRED = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 147, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FORM`.`SELECT`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FORM");
		symbolStrings.add("SELECT");

		FORM$__$SELECT = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 159, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `TEST`.`SCHEMA`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("TEST");
		symbolStrings.add("SCHEMA");

		TEST$__$SCHEMA = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 176, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MY_DESC`.`NUM1`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MY_DESC");
		symbolStrings.add("NUM1");

		MY$95$DESC$__$NUM1 = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 184, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MY_DESC`.`NUM2`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MY_DESC");
		symbolStrings.add("NUM2");

		MY$95$DESC$__$NUM2 = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 194, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		have_Intialized = true;
	}


}
