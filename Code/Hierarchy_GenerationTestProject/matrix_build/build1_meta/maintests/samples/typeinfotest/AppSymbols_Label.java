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

public class AppSymbols_Label { 

	//  Single Symbols:
	public static Label SCHEMA;
	public static final int SCHEMA$_ID_$ = 82;
	public static Label MATRIX;
	public static final int MATRIX$_ID_$ = 83;
	public static Label ITEM;
	public static final int ITEM$_ID_$ = 84;
	public static Label DESCRIPTOR;
	public static final int DESCRIPTOR$_ID_$ = 85;
	public static Label FIELD;
	public static final int FIELD$_ID_$ = 86;
	public static Label NAMES;
	public static final int NAMES$_ID_$ = 87;
	public static Label TYPES;
	public static final int TYPES$_ID_$ = 88;
	public static Label DESC;
	public static final int DESC$_ID_$ = 89;
	public static Label DEFAULTS;
	public static final int DEFAULTS$_ID_$ = 90;
	public static Label BASE;
	public static final int BASE$_ID_$ = 91;
	public static Label STANDARD;
	public static final int STANDARD$_ID_$ = 92;
	public static Label SCHEMA$95$FOR$95$SCHEMA;
	public static final int SCHEMA$95$FOR$95$SCHEMA$_ID_$ = 93;
	public static Label TEST;
	public static final int TEST$_ID_$ = 94;


	//  MultiPart Symbols:
	public static Label FIELD$__$NAMES;
	public static final int FIELD$__$NAMES$_ID_$ = 224;
	public static Label FIELD$__$TYPES;
	public static final int FIELD$__$TYPES$_ID_$ = 225;
	public static Label FIELD$__$DESC;
	public static final int FIELD$__$DESC$_ID_$ = 226;
	public static Label FIELD$__$DEFAULTS;
	public static final int FIELD$__$DEFAULTS$_ID_$ = 227;
	public static Label MATRIX$__$BASE;
	public static final int MATRIX$__$BASE$_ID_$ = 229;
	public static Label MATRIX$__$STANDARD;
	public static final int MATRIX$__$STANDARD$_ID_$ = 230;


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
				singleSymbol_Factory.createNew_Label("SCHEMA", 82, true, null);
		MATRIX = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("MATRIX", true) :
				singleSymbol_Factory.createNew_Label("MATRIX", 83, true, null);
		ITEM = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("ITEM", true) :
				singleSymbol_Factory.createNew_Label("ITEM", 84, true, null);
		DESCRIPTOR = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("DESCRIPTOR", true) :
				singleSymbol_Factory.createNew_Label("DESCRIPTOR", 85, true, null);
		FIELD = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("FIELD", true) :
				singleSymbol_Factory.createNew_Label("FIELD", 86, true, null);
		NAMES = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("NAMES", true) :
				singleSymbol_Factory.createNew_Label("NAMES", 87, true, null);
		TYPES = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("TYPES", true) :
				singleSymbol_Factory.createNew_Label("TYPES", 88, true, null);
		DESC = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("DESC", true) :
				singleSymbol_Factory.createNew_Label("DESC", 89, true, null);
		DEFAULTS = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("DEFAULTS", true) :
				singleSymbol_Factory.createNew_Label("DEFAULTS", 90, true, null);
		BASE = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("BASE", true) :
				singleSymbol_Factory.createNew_Label("BASE", 91, true, null);
		STANDARD = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("STANDARD", true) :
				singleSymbol_Factory.createNew_Label("STANDARD", 92, true, null);
		SCHEMA$95$FOR$95$SCHEMA = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("SCHEMA_FOR_SCHEMA", true) :
				singleSymbol_Factory.createNew_Label("SCHEMA_FOR_SCHEMA", 93, true, null);
		TEST = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("TEST", true) :
				singleSymbol_Factory.createNew_Label("TEST", 94, true, null);



		//  MultiPart Symbols _________________________________________________________________________

		//  `FIELD`.`NAMES`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("NAMES");

		FIELD$__$NAMES = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 224, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`TYPES`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("TYPES");

		FIELD$__$TYPES = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 225, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`DESC`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("DESC");

		FIELD$__$DESC = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 226, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`DEFAULTS`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("DEFAULTS");

		FIELD$__$DEFAULTS = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 227, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MATRIX`.`BASE`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIX");
		symbolStrings.add("BASE");

		MATRIX$__$BASE = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 229, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MATRIX`.`STANDARD`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIX");
		symbolStrings.add("STANDARD");

		MATRIX$__$STANDARD = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 230, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		have_Intialized = true;
	}


}
