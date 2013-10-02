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

package maintests.samples.persistenceclient;

import java.util.*;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.exceptions.*; 

public class AppSymbols_Label { 

	//  Single Symbols:
	public static Label SCHEMA;
	public static final int SCHEMA$_ID_$ = 673;
	public static Label MATRIX;
	public static final int MATRIX$_ID_$ = 674;
	public static Label ITEM;
	public static final int ITEM$_ID_$ = 675;
	public static Label DESCRIPTOR;
	public static final int DESCRIPTOR$_ID_$ = 676;
	public static Label FIELD;
	public static final int FIELD$_ID_$ = 677;
	public static Label NAMES;
	public static final int NAMES$_ID_$ = 678;
	public static Label TYPES;
	public static final int TYPES$_ID_$ = 679;
	public static Label DESC;
	public static final int DESC$_ID_$ = 680;
	public static Label DEFAULTS;
	public static final int DEFAULTS$_ID_$ = 681;
	public static Label BASE;
	public static final int BASE$_ID_$ = 682;
	public static Label STANDARD;
	public static final int STANDARD$_ID_$ = 683;
	public static Label SCHEMA$95$FOR$95$SCHEMA;
	public static final int SCHEMA$95$FOR$95$SCHEMA$_ID_$ = 684;
	public static Label TEST;
	public static final int TEST$_ID_$ = 685;
	public static Label WEB;
	public static final int WEB$_ID_$ = 732;
	public static Label FORM;
	public static final int FORM$_ID_$ = 733;
	public static Label REQUIRED;
	public static final int REQUIRED$_ID_$ = 736;
	public static Label SELECTOR;
	public static final int SELECTOR$_ID_$ = 748;
	public static Label OPTION;
	public static final int OPTION$_ID_$ = 753;
	public static Label MATRIXPROG;
	public static final int MATRIXPROG$_ID_$ = 766;
	public static Label PERSISTENCE;
	public static final int PERSISTENCE$_ID_$ = 767;
	public static Label SETTINGS;
	public static final int SETTINGS$_ID_$ = 770;
	public static Label Test;
	public static final int Test$_ID_$ = 1021;
	public static Label Matrix;
	public static final int Matrix$_ID_$ = 1022;
	public static Label First$32$Name;
	public static final int First$32$Name$_ID_$ = 1026;
	public static Label Last$32$Name;
	public static final int Last$32$Name$_ID_$ = 1028;
	public static Label item$32$1;
	public static final int item$32$1$_ID_$ = 1029;
	public static Label item$32$2;
	public static final int item$32$2$_ID_$ = 1030;
	public static Label my;
	public static final int my$_ID_$ = 1031;
	public static Label formSelector;
	public static final int formSelector$_ID_$ = 1032;
	public static Label Matrix2;
	public static final int Matrix2$_ID_$ = 1041;
	public static Label Company$32$Name;
	public static final int Company$32$Name$_ID_$ = 1044;


	//  MultiPart Symbols:
	public static Label FIELD$__$NAMES;
	public static final int FIELD$__$NAMES$_ID_$ = 966;
	public static Label FIELD$__$TYPES;
	public static final int FIELD$__$TYPES$_ID_$ = 967;
	public static Label FIELD$__$DESC;
	public static final int FIELD$__$DESC$_ID_$ = 968;
	public static Label FIELD$__$DEFAULTS;
	public static final int FIELD$__$DEFAULTS$_ID_$ = 969;
	public static Label MATRIX$__$BASE;
	public static final int MATRIX$__$BASE$_ID_$ = 971;
	public static Label MATRIX$__$STANDARD;
	public static final int MATRIX$__$STANDARD$_ID_$ = 972;
	public static Label WEB$__$FORM;
	public static final int WEB$__$FORM$_ID_$ = 974;
	public static Label FORM$__$REQUIRED;
	public static final int FORM$__$REQUIRED$_ID_$ = 976;
	public static Label FORM$__$SELECTOR;
	public static final int FORM$__$SELECTOR$_ID_$ = 977;
	public static Label MATRIXPROG$__$PERSISTENCE;
	public static final int MATRIXPROG$__$PERSISTENCE$_ID_$ = 979;
	public static Label MATRIXPROG$__$PERSISTENCE$__$SETTINGS;
	public static final int MATRIXPROG$__$PERSISTENCE$__$SETTINGS$_ID_$ = 980;
	public static Label Test$__$Matrix;
	public static final int Test$__$Matrix$_ID_$ = 1024;
	public static Label my$__$formSelector;
	public static final int my$__$formSelector$_ID_$ = 1034;
	public static Label Test$__$Matrix2;
	public static final int Test$__$Matrix2$_ID_$ = 1042;


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
				singleSymbol_Factory.createNew_Label("SCHEMA", 673, true, null);
		MATRIX = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("MATRIX", true) :
				singleSymbol_Factory.createNew_Label("MATRIX", 674, true, null);
		ITEM = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("ITEM", true) :
				singleSymbol_Factory.createNew_Label("ITEM", 675, true, null);
		DESCRIPTOR = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("DESCRIPTOR", true) :
				singleSymbol_Factory.createNew_Label("DESCRIPTOR", 676, true, null);
		FIELD = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("FIELD", true) :
				singleSymbol_Factory.createNew_Label("FIELD", 677, true, null);
		NAMES = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("NAMES", true) :
				singleSymbol_Factory.createNew_Label("NAMES", 678, true, null);
		TYPES = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("TYPES", true) :
				singleSymbol_Factory.createNew_Label("TYPES", 679, true, null);
		DESC = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("DESC", true) :
				singleSymbol_Factory.createNew_Label("DESC", 680, true, null);
		DEFAULTS = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("DEFAULTS", true) :
				singleSymbol_Factory.createNew_Label("DEFAULTS", 681, true, null);
		BASE = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("BASE", true) :
				singleSymbol_Factory.createNew_Label("BASE", 682, true, null);
		STANDARD = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("STANDARD", true) :
				singleSymbol_Factory.createNew_Label("STANDARD", 683, true, null);
		SCHEMA$95$FOR$95$SCHEMA = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("SCHEMA_FOR_SCHEMA", true) :
				singleSymbol_Factory.createNew_Label("SCHEMA_FOR_SCHEMA", 684, true, null);
		TEST = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("TEST", true) :
				singleSymbol_Factory.createNew_Label("TEST", 685, true, null);
		WEB = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("WEB", true) :
				singleSymbol_Factory.createNew_Label("WEB", 732, true, null);
		FORM = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("FORM", true) :
				singleSymbol_Factory.createNew_Label("FORM", 733, true, null);
		REQUIRED = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("REQUIRED", true) :
				singleSymbol_Factory.createNew_Label("REQUIRED", 736, true, null);
		SELECTOR = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("SELECTOR", true) :
				singleSymbol_Factory.createNew_Label("SELECTOR", 748, true, null);
		OPTION = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("OPTION", true) :
				singleSymbol_Factory.createNew_Label("OPTION", 753, true, null);
		MATRIXPROG = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("MATRIXPROG", true) :
				singleSymbol_Factory.createNew_Label("MATRIXPROG", 766, true, null);
		PERSISTENCE = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("PERSISTENCE", true) :
				singleSymbol_Factory.createNew_Label("PERSISTENCE", 767, true, null);
		SETTINGS = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("SETTINGS", true) :
				singleSymbol_Factory.createNew_Label("SETTINGS", 770, true, null);
		Test = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("Test", true) :
				singleSymbol_Factory.createNew_Label("Test", 1021, true, null);
		Matrix = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("Matrix", true) :
				singleSymbol_Factory.createNew_Label("Matrix", 1022, true, null);
		First$32$Name = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("First Name", true) :
				singleSymbol_Factory.createNew_Label("First Name", 1026, true, null);
		Last$32$Name = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("Last Name", true) :
				singleSymbol_Factory.createNew_Label("Last Name", 1028, true, null);
		item$32$1 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("item 1", true) :
				singleSymbol_Factory.createNew_Label("item 1", 1029, true, null);
		item$32$2 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("item 2", true) :
				singleSymbol_Factory.createNew_Label("item 2", 1030, true, null);
		my = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("my", true) :
				singleSymbol_Factory.createNew_Label("my", 1031, true, null);
		formSelector = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("formSelector", true) :
				singleSymbol_Factory.createNew_Label("formSelector", 1032, true, null);
		Matrix2 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("Matrix2", true) :
				singleSymbol_Factory.createNew_Label("Matrix2", 1041, true, null);
		Company$32$Name = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("Company Name", true) :
				singleSymbol_Factory.createNew_Label("Company Name", 1044, true, null);



		//  MultiPart Symbols _________________________________________________________________________

		//  `FIELD`.`NAMES`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("NAMES");

		FIELD$__$NAMES = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 966, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`TYPES`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("TYPES");

		FIELD$__$TYPES = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 967, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`DESC`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("DESC");

		FIELD$__$DESC = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 968, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`DEFAULTS`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("DEFAULTS");

		FIELD$__$DEFAULTS = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 969, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MATRIX`.`BASE`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIX");
		symbolStrings.add("BASE");

		MATRIX$__$BASE = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 971, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MATRIX`.`STANDARD`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIX");
		symbolStrings.add("STANDARD");

		MATRIX$__$STANDARD = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 972, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `WEB`.`FORM`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("WEB");
		symbolStrings.add("FORM");

		WEB$__$FORM = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 974, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FORM`.`REQUIRED`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FORM");
		symbolStrings.add("REQUIRED");

		FORM$__$REQUIRED = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 976, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FORM`.`SELECTOR`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FORM");
		symbolStrings.add("SELECTOR");

		FORM$__$SELECTOR = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 977, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MATRIXPROG`.`PERSISTENCE`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIXPROG");
		symbolStrings.add("PERSISTENCE");

		MATRIXPROG$__$PERSISTENCE = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 979, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MATRIXPROG`.`PERSISTENCE`.`SETTINGS`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIXPROG");
		symbolStrings.add("PERSISTENCE");
		symbolStrings.add("SETTINGS");

		MATRIXPROG$__$PERSISTENCE$__$SETTINGS = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 980, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `Test`.`Matrix`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("Test");
		symbolStrings.add("Matrix");

		Test$__$Matrix = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 1024, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `my`.`formSelector`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("my");
		symbolStrings.add("formSelector");

		my$__$formSelector = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 1034, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `Test`.`Matrix2`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("Test");
		symbolStrings.add("Matrix2");

		Test$__$Matrix2 = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 1042, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		have_Intialized = true;
	}


}
