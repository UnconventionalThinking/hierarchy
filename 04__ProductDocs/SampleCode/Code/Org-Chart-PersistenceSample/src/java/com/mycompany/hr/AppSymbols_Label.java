/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package com.mycompany.hr;

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
	public static Label OrgChart;
	public static final int OrgChart$_ID_$ = 151;
	public static Label Schema;
	public static final int Schema$_ID_$ = 152;
	public static Label EMPLOYEE;
	public static final int EMPLOYEE$_ID_$ = 155;
	public static Label MATRIXPROG;
	public static final int MATRIXPROG$_ID_$ = 167;
	public static Label PERSISTENCE;
	public static final int PERSISTENCE$_ID_$ = 168;
	public static Label SETTINGS;
	public static final int SETTINGS$_ID_$ = 171;
	public static Label id1;
	public static final int id1$_ID_$ = 406;
	public static Label id2;
	public static final int id2$_ID_$ = 407;
	public static Label id3;
	public static final int id3$_ID_$ = 408;
	public static Label id4;
	public static final int id4$_ID_$ = 409;
	public static Label id5;
	public static final int id5$_ID_$ = 410;
	public static Label id6;
	public static final int id6$_ID_$ = 411;


	//  MultiPart Symbols:
	public static Label FIELD$__$NAMES;
	public static final int FIELD$__$NAMES$_ID_$ = 359;
	public static Label FIELD$__$TYPES;
	public static final int FIELD$__$TYPES$_ID_$ = 360;
	public static Label FIELD$__$DESC;
	public static final int FIELD$__$DESC$_ID_$ = 361;
	public static Label FIELD$__$DEFAULTS;
	public static final int FIELD$__$DEFAULTS$_ID_$ = 362;
	public static Label MATRIX$__$BASE;
	public static final int MATRIX$__$BASE$_ID_$ = 364;
	public static Label MATRIX$__$STANDARD;
	public static final int MATRIX$__$STANDARD$_ID_$ = 365;
	public static Label OrgChart$__$Schema;
	public static final int OrgChart$__$Schema$_ID_$ = 367;
	public static Label MATRIXPROG$__$PERSISTENCE;
	public static final int MATRIXPROG$__$PERSISTENCE$_ID_$ = 369;
	public static Label MATRIXPROG$__$PERSISTENCE$__$SETTINGS;
	public static final int MATRIXPROG$__$PERSISTENCE$__$SETTINGS$_ID_$ = 370;


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
		OrgChart = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("OrgChart", true) :
				singleSymbol_Factory.createNew_Label("OrgChart", 151, true, null);
		Schema = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("Schema", true) :
				singleSymbol_Factory.createNew_Label("Schema", 152, true, null);
		EMPLOYEE = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("EMPLOYEE", true) :
				singleSymbol_Factory.createNew_Label("EMPLOYEE", 155, true, null);
		MATRIXPROG = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("MATRIXPROG", true) :
				singleSymbol_Factory.createNew_Label("MATRIXPROG", 167, true, null);
		PERSISTENCE = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("PERSISTENCE", true) :
				singleSymbol_Factory.createNew_Label("PERSISTENCE", 168, true, null);
		SETTINGS = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("SETTINGS", true) :
				singleSymbol_Factory.createNew_Label("SETTINGS", 171, true, null);
		id1 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("id1", true) :
				singleSymbol_Factory.createNew_Label("id1", 406, true, null);
		id2 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("id2", true) :
				singleSymbol_Factory.createNew_Label("id2", 407, true, null);
		id3 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("id3", true) :
				singleSymbol_Factory.createNew_Label("id3", 408, true, null);
		id4 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("id4", true) :
				singleSymbol_Factory.createNew_Label("id4", 409, true, null);
		id5 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("id5", true) :
				singleSymbol_Factory.createNew_Label("id5", 410, true, null);
		id6 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("id6", true) :
				singleSymbol_Factory.createNew_Label("id6", 411, true, null);



		//  MultiPart Symbols _________________________________________________________________________

		//  `FIELD`.`NAMES`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("NAMES");

		FIELD$__$NAMES = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 359, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`TYPES`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("TYPES");

		FIELD$__$TYPES = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 360, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`DESC`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("DESC");

		FIELD$__$DESC = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 361, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`DEFAULTS`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("DEFAULTS");

		FIELD$__$DEFAULTS = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 362, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MATRIX`.`BASE`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIX");
		symbolStrings.add("BASE");

		MATRIX$__$BASE = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 364, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MATRIX`.`STANDARD`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIX");
		symbolStrings.add("STANDARD");

		MATRIX$__$STANDARD = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 365, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `OrgChart`.`Schema`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("OrgChart");
		symbolStrings.add("Schema");

		OrgChart$__$Schema = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 367, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MATRIXPROG`.`PERSISTENCE`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIXPROG");
		symbolStrings.add("PERSISTENCE");

		MATRIXPROG$__$PERSISTENCE = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 369, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MATRIXPROG`.`PERSISTENCE`.`SETTINGS`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIXPROG");
		symbolStrings.add("PERSISTENCE");
		symbolStrings.add("SETTINGS");

		MATRIXPROG$__$PERSISTENCE$__$SETTINGS = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 370, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		have_Intialized = true;
	}


}
