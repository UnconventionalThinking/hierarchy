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
	public static final int WEB$_ID_$ = 145;
	public static Label FORM;
	public static final int FORM$_ID_$ = 146;
	public static Label REQUIRED;
	public static final int REQUIRED$_ID_$ = 149;
	public static Label SELECTOR;
	public static final int SELECTOR$_ID_$ = 161;
	public static Label OPTION;
	public static final int OPTION$_ID_$ = 166;
	public static Label Test;
	public static final int Test$_ID_$ = 401;
	public static Label Matrix;
	public static final int Matrix$_ID_$ = 402;
	public static Label First$32$Name;
	public static final int First$32$Name$_ID_$ = 406;
	public static Label Last$32$Name;
	public static final int Last$32$Name$_ID_$ = 408;
	public static Label item$32$1;
	public static final int item$32$1$_ID_$ = 409;
	public static Label item$32$2;
	public static final int item$32$2$_ID_$ = 410;
	public static Label $49$;
	public static final int $49$$_ID_$ = 411;
	public static Label $50$;
	public static final int $50$$_ID_$ = 412;
	public static Label Two;
	public static final int Two$_ID_$ = 522;
	public static Label Part$32$Label;
	public static final int Part$32$Label$_ID_$ = 523;
	public static Label Label;
	public static final int Label$_ID_$ = 526;


	//  MultiPart Symbols:
	public static Label FIELD$__$NAMES;
	public static final int FIELD$__$NAMES$_ID_$ = 666;
	public static Label FIELD$__$TYPES;
	public static final int FIELD$__$TYPES$_ID_$ = 667;
	public static Label FIELD$__$DESC;
	public static final int FIELD$__$DESC$_ID_$ = 668;
	public static Label FIELD$__$DEFAULTS;
	public static final int FIELD$__$DEFAULTS$_ID_$ = 669;
	public static Label MATRIX$__$BASE;
	public static final int MATRIX$__$BASE$_ID_$ = 671;
	public static Label MATRIX$__$STANDARD;
	public static final int MATRIX$__$STANDARD$_ID_$ = 672;
	public static Label WEB$__$FORM;
	public static final int WEB$__$FORM$_ID_$ = 674;
	public static Label FORM$__$REQUIRED;
	public static final int FORM$__$REQUIRED$_ID_$ = 676;
	public static Label FORM$__$SELECTOR;
	public static final int FORM$__$SELECTOR$_ID_$ = 677;
	public static Label Test$__$Matrix;
	public static final int Test$__$Matrix$_ID_$ = 679;
	public static Label Two$__$Part$32$Label;
	public static final int Two$__$Part$32$Label$_ID_$ = 681;
	public static Label Test$__$Label;
	public static final int Test$__$Label$_ID_$ = 682;


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
				singleSymbol_Factory.createNew_Label("WEB", 145, true, null);
		FORM = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("FORM", true) :
				singleSymbol_Factory.createNew_Label("FORM", 146, true, null);
		REQUIRED = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("REQUIRED", true) :
				singleSymbol_Factory.createNew_Label("REQUIRED", 149, true, null);
		SELECTOR = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("SELECTOR", true) :
				singleSymbol_Factory.createNew_Label("SELECTOR", 161, true, null);
		OPTION = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("OPTION", true) :
				singleSymbol_Factory.createNew_Label("OPTION", 166, true, null);
		Test = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("Test", true) :
				singleSymbol_Factory.createNew_Label("Test", 401, true, null);
		Matrix = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("Matrix", true) :
				singleSymbol_Factory.createNew_Label("Matrix", 402, true, null);
		First$32$Name = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("First Name", true) :
				singleSymbol_Factory.createNew_Label("First Name", 406, true, null);
		Last$32$Name = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("Last Name", true) :
				singleSymbol_Factory.createNew_Label("Last Name", 408, true, null);
		item$32$1 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("item 1", true) :
				singleSymbol_Factory.createNew_Label("item 1", 409, true, null);
		item$32$2 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("item 2", true) :
				singleSymbol_Factory.createNew_Label("item 2", 410, true, null);
		$49$ = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("1", true) :
				singleSymbol_Factory.createNew_Label("1", 411, true, null);
		$50$ = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("2", true) :
				singleSymbol_Factory.createNew_Label("2", 412, true, null);
		Two = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("Two", true) :
				singleSymbol_Factory.createNew_Label("Two", 522, true, null);
		Part$32$Label = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("Part Label", true) :
				singleSymbol_Factory.createNew_Label("Part Label", 523, true, null);
		Label = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("Label", true) :
				singleSymbol_Factory.createNew_Label("Label", 526, true, null);



		//  MultiPart Symbols _________________________________________________________________________

		//  `FIELD`.`NAMES`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("NAMES");

		FIELD$__$NAMES = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 666, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`TYPES`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("TYPES");

		FIELD$__$TYPES = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 667, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`DESC`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("DESC");

		FIELD$__$DESC = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 668, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`DEFAULTS`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("DEFAULTS");

		FIELD$__$DEFAULTS = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 669, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MATRIX`.`BASE`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIX");
		symbolStrings.add("BASE");

		MATRIX$__$BASE = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 671, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MATRIX`.`STANDARD`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIX");
		symbolStrings.add("STANDARD");

		MATRIX$__$STANDARD = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 672, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `WEB`.`FORM`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("WEB");
		symbolStrings.add("FORM");

		WEB$__$FORM = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 674, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FORM`.`REQUIRED`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FORM");
		symbolStrings.add("REQUIRED");

		FORM$__$REQUIRED = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 676, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FORM`.`SELECTOR`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FORM");
		symbolStrings.add("SELECTOR");

		FORM$__$SELECTOR = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 677, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `Test`.`Matrix`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("Test");
		symbolStrings.add("Matrix");

		Test$__$Matrix = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 679, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `Two`.`Part Label`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("Two");
		symbolStrings.add("Part Label");

		Two$__$Part$32$Label = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 681, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `Test`.`Label`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("Test");
		symbolStrings.add("Label");

		Test$__$Label = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 682, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		have_Intialized = true;
	}


}
