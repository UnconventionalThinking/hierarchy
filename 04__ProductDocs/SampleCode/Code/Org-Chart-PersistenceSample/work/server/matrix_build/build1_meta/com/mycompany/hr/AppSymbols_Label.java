/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package com.mycompany.hr;

import java.util.*;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.exceptions.*; 

public class AppSymbols_Label { 

	//  Single Symbols:
	public static Label SCHEMA;
	public static final int SCHEMA$_ID_$ = 621;
	public static Label MATRIX;
	public static final int MATRIX$_ID_$ = 622;
	public static Label ITEM;
	public static final int ITEM$_ID_$ = 623;
	public static Label DESCRIPTOR;
	public static final int DESCRIPTOR$_ID_$ = 624;
	public static Label FIELD;
	public static final int FIELD$_ID_$ = 625;
	public static Label NAMES;
	public static final int NAMES$_ID_$ = 626;
	public static Label TYPES;
	public static final int TYPES$_ID_$ = 627;
	public static Label DESC;
	public static final int DESC$_ID_$ = 628;
	public static Label DEFAULTS;
	public static final int DEFAULTS$_ID_$ = 629;
	public static Label BASE;
	public static final int BASE$_ID_$ = 630;
	public static Label STANDARD;
	public static final int STANDARD$_ID_$ = 631;
	public static Label SCHEMA$95$FOR$95$SCHEMA;
	public static final int SCHEMA$95$FOR$95$SCHEMA$_ID_$ = 632;
	public static Label TEST;
	public static final int TEST$_ID_$ = 633;
	public static Label OrgChart;
	public static final int OrgChart$_ID_$ = 684;
	public static Label Schema;
	public static final int Schema$_ID_$ = 685;
	public static Label EMPLOYEE;
	public static final int EMPLOYEE$_ID_$ = 688;
	public static Label MATRIXPROG;
	public static final int MATRIXPROG$_ID_$ = 700;
	public static Label PERSISTENCE;
	public static final int PERSISTENCE$_ID_$ = 701;
	public static Label SETTINGS;
	public static final int SETTINGS$_ID_$ = 704;
	public static Label id1;
	public static final int id1$_ID_$ = 939;
	public static Label id2;
	public static final int id2$_ID_$ = 940;
	public static Label id3;
	public static final int id3$_ID_$ = 941;
	public static Label id4;
	public static final int id4$_ID_$ = 942;
	public static Label id5;
	public static final int id5$_ID_$ = 943;
	public static Label id6;
	public static final int id6$_ID_$ = 944;


	//  MultiPart Symbols:
	public static Label FIELD$__$NAMES;
	public static final int FIELD$__$NAMES$_ID_$ = 892;
	public static Label FIELD$__$TYPES;
	public static final int FIELD$__$TYPES$_ID_$ = 893;
	public static Label FIELD$__$DESC;
	public static final int FIELD$__$DESC$_ID_$ = 894;
	public static Label FIELD$__$DEFAULTS;
	public static final int FIELD$__$DEFAULTS$_ID_$ = 895;
	public static Label MATRIX$__$BASE;
	public static final int MATRIX$__$BASE$_ID_$ = 897;
	public static Label MATRIX$__$STANDARD;
	public static final int MATRIX$__$STANDARD$_ID_$ = 898;
	public static Label OrgChart$__$Schema;
	public static final int OrgChart$__$Schema$_ID_$ = 900;
	public static Label MATRIXPROG$__$PERSISTENCE;
	public static final int MATRIXPROG$__$PERSISTENCE$_ID_$ = 902;
	public static Label MATRIXPROG$__$PERSISTENCE$__$SETTINGS;
	public static final int MATRIXPROG$__$PERSISTENCE$__$SETTINGS$_ID_$ = 903;


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
				singleSymbol_Factory.createNew_Label("SCHEMA", 621, true, null);
		MATRIX = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("MATRIX", true) :
				singleSymbol_Factory.createNew_Label("MATRIX", 622, true, null);
		ITEM = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("ITEM", true) :
				singleSymbol_Factory.createNew_Label("ITEM", 623, true, null);
		DESCRIPTOR = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("DESCRIPTOR", true) :
				singleSymbol_Factory.createNew_Label("DESCRIPTOR", 624, true, null);
		FIELD = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("FIELD", true) :
				singleSymbol_Factory.createNew_Label("FIELD", 625, true, null);
		NAMES = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("NAMES", true) :
				singleSymbol_Factory.createNew_Label("NAMES", 626, true, null);
		TYPES = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("TYPES", true) :
				singleSymbol_Factory.createNew_Label("TYPES", 627, true, null);
		DESC = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("DESC", true) :
				singleSymbol_Factory.createNew_Label("DESC", 628, true, null);
		DEFAULTS = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("DEFAULTS", true) :
				singleSymbol_Factory.createNew_Label("DEFAULTS", 629, true, null);
		BASE = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("BASE", true) :
				singleSymbol_Factory.createNew_Label("BASE", 630, true, null);
		STANDARD = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("STANDARD", true) :
				singleSymbol_Factory.createNew_Label("STANDARD", 631, true, null);
		SCHEMA$95$FOR$95$SCHEMA = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("SCHEMA_FOR_SCHEMA", true) :
				singleSymbol_Factory.createNew_Label("SCHEMA_FOR_SCHEMA", 632, true, null);
		TEST = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("TEST", true) :
				singleSymbol_Factory.createNew_Label("TEST", 633, true, null);
		OrgChart = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("OrgChart", true) :
				singleSymbol_Factory.createNew_Label("OrgChart", 684, true, null);
		Schema = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("Schema", true) :
				singleSymbol_Factory.createNew_Label("Schema", 685, true, null);
		EMPLOYEE = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("EMPLOYEE", true) :
				singleSymbol_Factory.createNew_Label("EMPLOYEE", 688, true, null);
		MATRIXPROG = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("MATRIXPROG", true) :
				singleSymbol_Factory.createNew_Label("MATRIXPROG", 700, true, null);
		PERSISTENCE = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("PERSISTENCE", true) :
				singleSymbol_Factory.createNew_Label("PERSISTENCE", 701, true, null);
		SETTINGS = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("SETTINGS", true) :
				singleSymbol_Factory.createNew_Label("SETTINGS", 704, true, null);
		id1 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("id1", true) :
				singleSymbol_Factory.createNew_Label("id1", 939, true, null);
		id2 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("id2", true) :
				singleSymbol_Factory.createNew_Label("id2", 940, true, null);
		id3 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("id3", true) :
				singleSymbol_Factory.createNew_Label("id3", 941, true, null);
		id4 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("id4", true) :
				singleSymbol_Factory.createNew_Label("id4", 942, true, null);
		id5 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("id5", true) :
				singleSymbol_Factory.createNew_Label("id5", 943, true, null);
		id6 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("id6", true) :
				singleSymbol_Factory.createNew_Label("id6", 944, true, null);



		//  MultiPart Symbols _________________________________________________________________________

		//  `FIELD`.`NAMES`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("NAMES");

		FIELD$__$NAMES = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 892, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`TYPES`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("TYPES");

		FIELD$__$TYPES = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 893, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`DESC`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("DESC");

		FIELD$__$DESC = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 894, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`DEFAULTS`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("DEFAULTS");

		FIELD$__$DEFAULTS = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 895, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MATRIX`.`BASE`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIX");
		symbolStrings.add("BASE");

		MATRIX$__$BASE = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 897, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MATRIX`.`STANDARD`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIX");
		symbolStrings.add("STANDARD");

		MATRIX$__$STANDARD = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 898, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `OrgChart`.`Schema`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("OrgChart");
		symbolStrings.add("Schema");

		OrgChart$__$Schema = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 900, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MATRIXPROG`.`PERSISTENCE`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIXPROG");
		symbolStrings.add("PERSISTENCE");

		MATRIXPROG$__$PERSISTENCE = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 902, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MATRIXPROG`.`PERSISTENCE`.`SETTINGS`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIXPROG");
		symbolStrings.add("PERSISTENCE");
		symbolStrings.add("SETTINGS");

		MATRIXPROG$__$PERSISTENCE$__$SETTINGS = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 903, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		have_Intialized = true;
	}


}
