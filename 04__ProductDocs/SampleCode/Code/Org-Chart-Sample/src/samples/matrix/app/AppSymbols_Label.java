/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package samples.matrix.app;

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
	public static Label id1;
	public static final int id1$_ID_$ = 374;
	public static Label id2;
	public static final int id2$_ID_$ = 375;
	public static Label id3;
	public static final int id3$_ID_$ = 376;
	public static Label id4;
	public static final int id4$_ID_$ = 377;
	public static Label id5;
	public static final int id5$_ID_$ = 378;
	public static Label id6;
	public static final int id6$_ID_$ = 379;


	//  MultiPart Symbols:
	public static Label FIELD$__$NAMES;
	public static final int FIELD$__$NAMES$_ID_$ = 333;
	public static Label FIELD$__$TYPES;
	public static final int FIELD$__$TYPES$_ID_$ = 334;
	public static Label FIELD$__$DESC;
	public static final int FIELD$__$DESC$_ID_$ = 335;
	public static Label FIELD$__$DEFAULTS;
	public static final int FIELD$__$DEFAULTS$_ID_$ = 336;
	public static Label MATRIX$__$BASE;
	public static final int MATRIX$__$BASE$_ID_$ = 338;
	public static Label MATRIX$__$STANDARD;
	public static final int MATRIX$__$STANDARD$_ID_$ = 339;
	public static Label OrgChart$__$Schema;
	public static final int OrgChart$__$Schema$_ID_$ = 341;


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
		id1 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("id1", true) :
				singleSymbol_Factory.createNew_Label("id1", 374, true, null);
		id2 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("id2", true) :
				singleSymbol_Factory.createNew_Label("id2", 375, true, null);
		id3 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("id3", true) :
				singleSymbol_Factory.createNew_Label("id3", 376, true, null);
		id4 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("id4", true) :
				singleSymbol_Factory.createNew_Label("id4", 377, true, null);
		id5 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("id5", true) :
				singleSymbol_Factory.createNew_Label("id5", 378, true, null);
		id6 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("id6", true) :
				singleSymbol_Factory.createNew_Label("id6", 379, true, null);



		//  MultiPart Symbols _________________________________________________________________________

		//  `FIELD`.`NAMES`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("NAMES");

		FIELD$__$NAMES = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 333, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`TYPES`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("TYPES");

		FIELD$__$TYPES = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 334, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`DESC`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("DESC");

		FIELD$__$DESC = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 335, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`DEFAULTS`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("DEFAULTS");

		FIELD$__$DEFAULTS = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 336, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MATRIX`.`BASE`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIX");
		symbolStrings.add("BASE");

		MATRIX$__$BASE = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 338, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MATRIX`.`STANDARD`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIX");
		symbolStrings.add("STANDARD");

		MATRIX$__$STANDARD = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 339, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `OrgChart`.`Schema`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("OrgChart");
		symbolStrings.add("Schema");

		OrgChart$__$Schema = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 341, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		have_Intialized = true;
	}


}
