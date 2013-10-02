/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package maintests.samples.typeinfotest;

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
	public static final int WEB$_ID_$ = 147;
	public static Label FORM;
	public static final int FORM$_ID_$ = 148;
	public static Label REQUIRED;
	public static final int REQUIRED$_ID_$ = 151;
	public static Label SELECTOR;
	public static final int SELECTOR$_ID_$ = 163;
	public static Label OPTION;
	public static final int OPTION$_ID_$ = 168;
	public static Label Test;
	public static final int Test$_ID_$ = 183;
	public static Label Schema;
	public static final int Schema$_ID_$ = 184;
	public static Label CHILD;
	public static final int CHILD$_ID_$ = 195;
	public static Label Matrix;
	public static final int Matrix$_ID_$ = 466;
	public static Label First$32$Name;
	public static final int First$32$Name$_ID_$ = 469;
	public static Label Last$32$Name;
	public static final int Last$32$Name$_ID_$ = 471;
	public static Label item$32$1;
	public static final int item$32$1$_ID_$ = 472;
	public static Label item$32$2;
	public static final int item$32$2$_ID_$ = 473;
	public static Label Matrix2;
	public static final int Matrix2$_ID_$ = 478;
	public static Label test$32$item;
	public static final int test$32$item$_ID_$ = 481;
	public static Label Matrix2$95$1;
	public static final int Matrix2$95$1$_ID_$ = 487;
	public static Label Matrix3;
	public static final int Matrix3$_ID_$ = 495;


	//  MultiPart Symbols:
	public static Label FIELD$__$NAMES;
	public static final int FIELD$__$NAMES$_ID_$ = 409;
	public static Label FIELD$__$TYPES;
	public static final int FIELD$__$TYPES$_ID_$ = 410;
	public static Label FIELD$__$DESC;
	public static final int FIELD$__$DESC$_ID_$ = 411;
	public static Label FIELD$__$DEFAULTS;
	public static final int FIELD$__$DEFAULTS$_ID_$ = 412;
	public static Label MATRIX$__$BASE;
	public static final int MATRIX$__$BASE$_ID_$ = 414;
	public static Label MATRIX$__$STANDARD;
	public static final int MATRIX$__$STANDARD$_ID_$ = 415;
	public static Label WEB$__$FORM;
	public static final int WEB$__$FORM$_ID_$ = 417;
	public static Label FORM$__$REQUIRED;
	public static final int FORM$__$REQUIRED$_ID_$ = 419;
	public static Label FORM$__$SELECTOR;
	public static final int FORM$__$SELECTOR$_ID_$ = 420;
	public static Label Test$__$Schema;
	public static final int Test$__$Schema$_ID_$ = 422;
	public static Label TEST$__$DESC;
	public static final int TEST$__$DESC$_ID_$ = 424;
	public static Label CHILD$__$DESC;
	public static final int CHILD$__$DESC$_ID_$ = 426;
	public static Label Test$__$Matrix;
	public static final int Test$__$Matrix$_ID_$ = 467;
	public static Label Test$__$Matrix2;
	public static final int Test$__$Matrix2$_ID_$ = 479;
	public static Label Test$__$Matrix2$95$1;
	public static final int Test$__$Matrix2$95$1$_ID_$ = 488;
	public static Label Test$__$Matrix3;
	public static final int Test$__$Matrix3$_ID_$ = 496;


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
				singleSymbol_Factory.createNew_Label("WEB", 147, true, null);
		FORM = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("FORM", true) :
				singleSymbol_Factory.createNew_Label("FORM", 148, true, null);
		REQUIRED = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("REQUIRED", true) :
				singleSymbol_Factory.createNew_Label("REQUIRED", 151, true, null);
		SELECTOR = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("SELECTOR", true) :
				singleSymbol_Factory.createNew_Label("SELECTOR", 163, true, null);
		OPTION = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("OPTION", true) :
				singleSymbol_Factory.createNew_Label("OPTION", 168, true, null);
		Test = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("Test", true) :
				singleSymbol_Factory.createNew_Label("Test", 183, true, null);
		Schema = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("Schema", true) :
				singleSymbol_Factory.createNew_Label("Schema", 184, true, null);
		CHILD = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("CHILD", true) :
				singleSymbol_Factory.createNew_Label("CHILD", 195, true, null);
		Matrix = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("Matrix", true) :
				singleSymbol_Factory.createNew_Label("Matrix", 466, true, null);
		First$32$Name = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("First Name", true) :
				singleSymbol_Factory.createNew_Label("First Name", 469, true, null);
		Last$32$Name = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("Last Name", true) :
				singleSymbol_Factory.createNew_Label("Last Name", 471, true, null);
		item$32$1 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("item 1", true) :
				singleSymbol_Factory.createNew_Label("item 1", 472, true, null);
		item$32$2 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("item 2", true) :
				singleSymbol_Factory.createNew_Label("item 2", 473, true, null);
		Matrix2 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("Matrix2", true) :
				singleSymbol_Factory.createNew_Label("Matrix2", 478, true, null);
		test$32$item = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("test item", true) :
				singleSymbol_Factory.createNew_Label("test item", 481, true, null);
		Matrix2$95$1 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("Matrix2_1", true) :
				singleSymbol_Factory.createNew_Label("Matrix2_1", 487, true, null);
		Matrix3 = (have_ParentAppControl) ? singleSymbol_Factory.createNew_Label("Matrix3", true) :
				singleSymbol_Factory.createNew_Label("Matrix3", 495, true, null);



		//  MultiPart Symbols _________________________________________________________________________

		//  `FIELD`.`NAMES`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("NAMES");

		FIELD$__$NAMES = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 409, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`TYPES`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("TYPES");

		FIELD$__$TYPES = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 410, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`DESC`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("DESC");

		FIELD$__$DESC = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 411, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FIELD`.`DEFAULTS`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("DEFAULTS");

		FIELD$__$DEFAULTS = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 412, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MATRIX`.`BASE`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIX");
		symbolStrings.add("BASE");

		MATRIX$__$BASE = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 414, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `MATRIX`.`STANDARD`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIX");
		symbolStrings.add("STANDARD");

		MATRIX$__$STANDARD = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 415, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `WEB`.`FORM`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("WEB");
		symbolStrings.add("FORM");

		WEB$__$FORM = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 417, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FORM`.`REQUIRED`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FORM");
		symbolStrings.add("REQUIRED");

		FORM$__$REQUIRED = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 419, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `FORM`.`SELECTOR`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FORM");
		symbolStrings.add("SELECTOR");

		FORM$__$SELECTOR = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 420, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `Test`.`Schema`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("Test");
		symbolStrings.add("Schema");

		Test$__$Schema = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 422, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `TEST`.`DESC`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("TEST");
		symbolStrings.add("DESC");

		TEST$__$DESC = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 424, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `CHILD`.`DESC`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("CHILD");
		symbolStrings.add("DESC");

		CHILD$__$DESC = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 426, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `Test`.`Matrix`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("Test");
		symbolStrings.add("Matrix");

		Test$__$Matrix = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 467, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `Test`.`Matrix2`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("Test");
		symbolStrings.add("Matrix2");

		Test$__$Matrix2 = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 479, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `Test`.`Matrix2_1`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("Test");
		symbolStrings.add("Matrix2_1");

		Test$__$Matrix2$95$1 = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 488, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `Test`.`Matrix3`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("Test");
		symbolStrings.add("Matrix3");

		Test$__$Matrix3 = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew_Label(symbolStrings, 496, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		have_Intialized = true;
	}


}
