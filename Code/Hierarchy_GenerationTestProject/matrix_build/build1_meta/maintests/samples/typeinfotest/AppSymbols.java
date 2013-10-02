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

public class AppSymbols { 

	//  Single Symbols:
	public static Symbol ContinuationType;
	public static final int ContinuationType$_ID_$ = 0;
	public static Symbol byte$_sym_$;
	public static final int byte$_sym_$$_ID_$ = 1;
	public static Symbol short$_sym_$;
	public static final int short$_sym_$$_ID_$ = 2;
	public static Symbol int$_sym_$;
	public static final int int$_sym_$$_ID_$ = 3;
	public static Symbol long$_sym_$;
	public static final int long$_sym_$$_ID_$ = 4;
	public static Symbol float$_sym_$;
	public static final int float$_sym_$$_ID_$ = 5;
	public static Symbol double$_sym_$;
	public static final int double$_sym_$$_ID_$ = 6;
	public static Symbol char$_sym_$;
	public static final int char$_sym_$$_ID_$ = 7;
	public static Symbol boolean$_sym_$;
	public static final int boolean$_sym_$$_ID_$ = 8;
	public static Symbol String;
	public static final int String$_ID_$ = 9;
	public static Symbol Object;
	public static final int Object$_ID_$ = 10;
	public static Symbol Schema;
	public static final int Schema$_ID_$ = 11;
	public static Symbol Matrix;
	public static final int Matrix$_ID_$ = 12;
	public static Symbol Descriptor;
	public static final int Descriptor$_ID_$ = 13;
	public static Symbol FieldSet;
	public static final int FieldSet$_ID_$ = 14;
	public static Symbol Field;
	public static final int Field$_ID_$ = 15;
	public static Symbol Symbol;
	public static final int Symbol$_ID_$ = 16;
	public static Symbol DescriptorTagName;
	public static final int DescriptorTagName$_ID_$ = 17;
	public static Symbol Label;
	public static final int Label$_ID_$ = 18;
	public static Symbol DescriptorTag;
	public static final int DescriptorTag$_ID_$ = 19;
	public static Symbol MatrixName;
	public static final int MatrixName$_ID_$ = 20;
	public static Symbol SchemaName;
	public static final int SchemaName$_ID_$ = 21;
	public static Symbol DescriptorPath;
	public static final int DescriptorPath$_ID_$ = 22;
	public static Symbol SchemaPath;
	public static final int SchemaPath$_ID_$ = 23;
	public static Symbol MatrixSet;
	public static final int MatrixSet$_ID_$ = 24;
	public static Symbol MatrixSet$60$Descriptor$62$;
	public static final int MatrixSet$60$Descriptor$62$$_ID_$ = 25;
	public static Symbol MatrixSet$60$Object$62$;
	public static final int MatrixSet$60$Object$62$$_ID_$ = 26;
	public static Symbol DEFAULT;
	public static final int DEFAULT$_ID_$ = 27;
	public static Symbol IsPersistentMatrix;
	public static final int IsPersistentMatrix$_ID_$ = 28;
	public static Symbol NotPersistentMatrix;
	public static final int NotPersistentMatrix$_ID_$ = 29;
	public static Symbol BuildingMatrixElement;
	public static final int BuildingMatrixElement$_ID_$ = 30;
	public static Symbol BuildingSchemaElement;
	public static final int BuildingSchemaElement$_ID_$ = 31;
	public static Symbol BuildingMatrixElementForSchema;
	public static final int BuildingMatrixElementForSchema$_ID_$ = 32;
	public static Symbol FieldSetTuple$95$$95$net$36$$95$$95$$36$unconventionalthinking$36$$95$$95$$36$matrix$36$$95$CC$95$$36$SCHEMA$36$95$36$FOR$36$95$36$SCHEMA$36$$95$S$95$$36$DESCRIPTOR$36$$95$S$95$$36$FIELD$36$$95$$95$$36$NAMES;
	public static final int FieldSetTuple$95$$95$net$36$$95$$95$$36$unconventionalthinking$36$$95$$95$$36$matrix$36$$95$CC$95$$36$SCHEMA$36$95$36$FOR$36$95$36$SCHEMA$36$$95$S$95$$36$DESCRIPTOR$36$$95$S$95$$36$FIELD$36$$95$$95$$36$NAMES$_ID_$ = 129;
	public static Symbol FieldSetTuple$95$$95$net$36$$95$$95$$36$unconventionalthinking$36$$95$$95$$36$matrix$36$$95$CC$95$$36$SCHEMA$36$95$36$FOR$36$95$36$SCHEMA$36$$95$S$95$$36$DESCRIPTOR$36$$95$S$95$$36$FIELD$36$$95$$95$$36$TYPES;
	public static final int FieldSetTuple$95$$95$net$36$$95$$95$$36$unconventionalthinking$36$$95$$95$$36$matrix$36$$95$CC$95$$36$SCHEMA$36$95$36$FOR$36$95$36$SCHEMA$36$$95$S$95$$36$DESCRIPTOR$36$$95$S$95$$36$FIELD$36$$95$$95$$36$TYPES$_ID_$ = 130;
	public static Symbol FieldSetTuple$95$$95$net$36$$95$$95$$36$unconventionalthinking$36$$95$$95$$36$matrix$36$$95$CC$95$$36$SCHEMA$36$95$36$FOR$36$95$36$SCHEMA$36$$95$S$95$$36$DESCRIPTOR$36$$95$S$95$$36$FIELD$36$$95$$95$$36$DESC;
	public static final int FieldSetTuple$95$$95$net$36$$95$$95$$36$unconventionalthinking$36$$95$$95$$36$matrix$36$$95$CC$95$$36$SCHEMA$36$95$36$FOR$36$95$36$SCHEMA$36$$95$S$95$$36$DESCRIPTOR$36$$95$S$95$$36$FIELD$36$$95$$95$$36$DESC$_ID_$ = 131;
	public static Symbol FieldSetTuple$95$$95$net$36$$95$$95$$36$unconventionalthinking$36$$95$$95$$36$matrix$36$$95$CC$95$$36$SCHEMA$36$95$36$FOR$36$95$36$SCHEMA$36$$95$S$95$$36$DESCRIPTOR$36$$95$S$95$$36$FIELD$36$$95$$95$$36$DEFAULTS;
	public static final int FieldSetTuple$95$$95$net$36$$95$$95$$36$unconventionalthinking$36$$95$$95$$36$matrix$36$$95$CC$95$$36$SCHEMA$36$95$36$FOR$36$95$36$SCHEMA$36$$95$S$95$$36$DESCRIPTOR$36$$95$S$95$$36$FIELD$36$$95$$95$$36$DEFAULTS$_ID_$ = 132;


	//  MultiPart Symbols:
	public static Symbol ContinuationType$__$byte;
	public static final int ContinuationType$__$byte$_ID_$ = 196;
	public static Symbol ContinuationType$__$short;
	public static final int ContinuationType$__$short$_ID_$ = 197;
	public static Symbol ContinuationType$__$int;
	public static final int ContinuationType$__$int$_ID_$ = 198;
	public static Symbol ContinuationType$__$long;
	public static final int ContinuationType$__$long$_ID_$ = 199;
	public static Symbol ContinuationType$__$float;
	public static final int ContinuationType$__$float$_ID_$ = 200;
	public static Symbol ContinuationType$__$double;
	public static final int ContinuationType$__$double$_ID_$ = 201;
	public static Symbol ContinuationType$__$char;
	public static final int ContinuationType$__$char$_ID_$ = 202;
	public static Symbol ContinuationType$__$boolean;
	public static final int ContinuationType$__$boolean$_ID_$ = 203;
	public static Symbol ContinuationType$__$String;
	public static final int ContinuationType$__$String$_ID_$ = 204;
	public static Symbol ContinuationType$__$Object;
	public static final int ContinuationType$__$Object$_ID_$ = 205;
	public static Symbol ContinuationType$__$Symbol;
	public static final int ContinuationType$__$Symbol$_ID_$ = 206;
	public static Symbol ContinuationType$__$DescriptorTagName;
	public static final int ContinuationType$__$DescriptorTagName$_ID_$ = 207;
	public static Symbol ContinuationType$__$Label;
	public static final int ContinuationType$__$Label$_ID_$ = 208;


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

		ContinuationType = (have_ParentAppControl) ? singleSymbol_Factory.createNew("ContinuationType", true) :
				singleSymbol_Factory.createNew("ContinuationType", 0, true, null);
		byte$_sym_$ = (have_ParentAppControl) ? singleSymbol_Factory.createNew("byte", true) :
				singleSymbol_Factory.createNew("byte", 1, true, null);
		short$_sym_$ = (have_ParentAppControl) ? singleSymbol_Factory.createNew("short", true) :
				singleSymbol_Factory.createNew("short", 2, true, null);
		int$_sym_$ = (have_ParentAppControl) ? singleSymbol_Factory.createNew("int", true) :
				singleSymbol_Factory.createNew("int", 3, true, null);
		long$_sym_$ = (have_ParentAppControl) ? singleSymbol_Factory.createNew("long", true) :
				singleSymbol_Factory.createNew("long", 4, true, null);
		float$_sym_$ = (have_ParentAppControl) ? singleSymbol_Factory.createNew("float", true) :
				singleSymbol_Factory.createNew("float", 5, true, null);
		double$_sym_$ = (have_ParentAppControl) ? singleSymbol_Factory.createNew("double", true) :
				singleSymbol_Factory.createNew("double", 6, true, null);
		char$_sym_$ = (have_ParentAppControl) ? singleSymbol_Factory.createNew("char", true) :
				singleSymbol_Factory.createNew("char", 7, true, null);
		boolean$_sym_$ = (have_ParentAppControl) ? singleSymbol_Factory.createNew("boolean", true) :
				singleSymbol_Factory.createNew("boolean", 8, true, null);
		String = (have_ParentAppControl) ? singleSymbol_Factory.createNew("String", true) :
				singleSymbol_Factory.createNew("String", 9, true, null);
		Object = (have_ParentAppControl) ? singleSymbol_Factory.createNew("Object", true) :
				singleSymbol_Factory.createNew("Object", 10, true, null);
		Schema = (have_ParentAppControl) ? singleSymbol_Factory.createNew("Schema", true) :
				singleSymbol_Factory.createNew("Schema", 11, true, null);
		Matrix = (have_ParentAppControl) ? singleSymbol_Factory.createNew("Matrix", true) :
				singleSymbol_Factory.createNew("Matrix", 12, true, null);
		Descriptor = (have_ParentAppControl) ? singleSymbol_Factory.createNew("Descriptor", true) :
				singleSymbol_Factory.createNew("Descriptor", 13, true, null);
		FieldSet = (have_ParentAppControl) ? singleSymbol_Factory.createNew("FieldSet", true) :
				singleSymbol_Factory.createNew("FieldSet", 14, true, null);
		Field = (have_ParentAppControl) ? singleSymbol_Factory.createNew("Field", true) :
				singleSymbol_Factory.createNew("Field", 15, true, null);
		Symbol = (have_ParentAppControl) ? singleSymbol_Factory.createNew("Symbol", true) :
				singleSymbol_Factory.createNew("Symbol", 16, true, null);
		DescriptorTagName = (have_ParentAppControl) ? singleSymbol_Factory.createNew("DescriptorTagName", true) :
				singleSymbol_Factory.createNew("DescriptorTagName", 17, true, null);
		Label = (have_ParentAppControl) ? singleSymbol_Factory.createNew("Label", true) :
				singleSymbol_Factory.createNew("Label", 18, true, null);
		DescriptorTag = (have_ParentAppControl) ? singleSymbol_Factory.createNew("DescriptorTag", true) :
				singleSymbol_Factory.createNew("DescriptorTag", 19, true, null);
		MatrixName = (have_ParentAppControl) ? singleSymbol_Factory.createNew("MatrixName", true) :
				singleSymbol_Factory.createNew("MatrixName", 20, true, null);
		SchemaName = (have_ParentAppControl) ? singleSymbol_Factory.createNew("SchemaName", true) :
				singleSymbol_Factory.createNew("SchemaName", 21, true, null);
		DescriptorPath = (have_ParentAppControl) ? singleSymbol_Factory.createNew("DescriptorPath", true) :
				singleSymbol_Factory.createNew("DescriptorPath", 22, true, null);
		SchemaPath = (have_ParentAppControl) ? singleSymbol_Factory.createNew("SchemaPath", true) :
				singleSymbol_Factory.createNew("SchemaPath", 23, true, null);
		MatrixSet = (have_ParentAppControl) ? singleSymbol_Factory.createNew("MatrixSet", true) :
				singleSymbol_Factory.createNew("MatrixSet", 24, true, null);
		MatrixSet$60$Descriptor$62$ = (have_ParentAppControl) ? singleSymbol_Factory.createNew("MatrixSet<Descriptor>", true) :
				singleSymbol_Factory.createNew("MatrixSet<Descriptor>", 25, true, null);
		MatrixSet$60$Object$62$ = (have_ParentAppControl) ? singleSymbol_Factory.createNew("MatrixSet<Object>", true) :
				singleSymbol_Factory.createNew("MatrixSet<Object>", 26, true, null);
		DEFAULT = (have_ParentAppControl) ? singleSymbol_Factory.createNew("DEFAULT", true) :
				singleSymbol_Factory.createNew("DEFAULT", 27, true, null);
		IsPersistentMatrix = (have_ParentAppControl) ? singleSymbol_Factory.createNew("IsPersistentMatrix", true) :
				singleSymbol_Factory.createNew("IsPersistentMatrix", 28, true, null);
		NotPersistentMatrix = (have_ParentAppControl) ? singleSymbol_Factory.createNew("NotPersistentMatrix", true) :
				singleSymbol_Factory.createNew("NotPersistentMatrix", 29, true, null);
		BuildingMatrixElement = (have_ParentAppControl) ? singleSymbol_Factory.createNew("BuildingMatrixElement", true) :
				singleSymbol_Factory.createNew("BuildingMatrixElement", 30, true, null);
		BuildingSchemaElement = (have_ParentAppControl) ? singleSymbol_Factory.createNew("BuildingSchemaElement", true) :
				singleSymbol_Factory.createNew("BuildingSchemaElement", 31, true, null);
		BuildingMatrixElementForSchema = (have_ParentAppControl) ? singleSymbol_Factory.createNew("BuildingMatrixElementForSchema", true) :
				singleSymbol_Factory.createNew("BuildingMatrixElementForSchema", 32, true, null);
		FieldSetTuple$95$$95$net$36$$95$$95$$36$unconventionalthinking$36$$95$$95$$36$matrix$36$$95$CC$95$$36$SCHEMA$36$95$36$FOR$36$95$36$SCHEMA$36$$95$S$95$$36$DESCRIPTOR$36$$95$S$95$$36$FIELD$36$$95$$95$$36$NAMES = (have_ParentAppControl) ? singleSymbol_Factory.createNew("FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_S_$DESCRIPTOR$_S_$FIELD$__$NAMES", true) :
				singleSymbol_Factory.createNew("FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_S_$DESCRIPTOR$_S_$FIELD$__$NAMES", 129, true, null);
		FieldSetTuple$95$$95$net$36$$95$$95$$36$unconventionalthinking$36$$95$$95$$36$matrix$36$$95$CC$95$$36$SCHEMA$36$95$36$FOR$36$95$36$SCHEMA$36$$95$S$95$$36$DESCRIPTOR$36$$95$S$95$$36$FIELD$36$$95$$95$$36$TYPES = (have_ParentAppControl) ? singleSymbol_Factory.createNew("FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_S_$DESCRIPTOR$_S_$FIELD$__$TYPES", true) :
				singleSymbol_Factory.createNew("FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_S_$DESCRIPTOR$_S_$FIELD$__$TYPES", 130, true, null);
		FieldSetTuple$95$$95$net$36$$95$$95$$36$unconventionalthinking$36$$95$$95$$36$matrix$36$$95$CC$95$$36$SCHEMA$36$95$36$FOR$36$95$36$SCHEMA$36$$95$S$95$$36$DESCRIPTOR$36$$95$S$95$$36$FIELD$36$$95$$95$$36$DESC = (have_ParentAppControl) ? singleSymbol_Factory.createNew("FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_S_$DESCRIPTOR$_S_$FIELD$__$DESC", true) :
				singleSymbol_Factory.createNew("FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_S_$DESCRIPTOR$_S_$FIELD$__$DESC", 131, true, null);
		FieldSetTuple$95$$95$net$36$$95$$95$$36$unconventionalthinking$36$$95$$95$$36$matrix$36$$95$CC$95$$36$SCHEMA$36$95$36$FOR$36$95$36$SCHEMA$36$$95$S$95$$36$DESCRIPTOR$36$$95$S$95$$36$FIELD$36$$95$$95$$36$DEFAULTS = (have_ParentAppControl) ? singleSymbol_Factory.createNew("FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_S_$DESCRIPTOR$_S_$FIELD$__$DEFAULTS", true) :
				singleSymbol_Factory.createNew("FieldSetTuple__net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_S_$DESCRIPTOR$_S_$FIELD$__$DEFAULTS", 132, true, null);



		//  MultiPart Symbols _________________________________________________________________________

		//  `ContinuationType`.`byte`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("byte");

		ContinuationType$__$byte = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew(symbolStrings, 196, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `ContinuationType`.`short`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("short");

		ContinuationType$__$short = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew(symbolStrings, 197, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `ContinuationType`.`int`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("int");

		ContinuationType$__$int = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew(symbolStrings, 198, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `ContinuationType`.`long`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("long");

		ContinuationType$__$long = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew(symbolStrings, 199, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `ContinuationType`.`float`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("float");

		ContinuationType$__$float = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew(symbolStrings, 200, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `ContinuationType`.`double`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("double");

		ContinuationType$__$double = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew(symbolStrings, 201, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `ContinuationType`.`char`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("char");

		ContinuationType$__$char = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew(symbolStrings, 202, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `ContinuationType`.`boolean`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("boolean");

		ContinuationType$__$boolean = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew(symbolStrings, 203, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `ContinuationType`.`String`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("String");

		ContinuationType$__$String = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew(symbolStrings, 204, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `ContinuationType`.`Object`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("Object");

		ContinuationType$__$Object = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew(symbolStrings, 205, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `ContinuationType`.`Symbol`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("Symbol");

		ContinuationType$__$Symbol = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew(symbolStrings, 206, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `ContinuationType`.`DescriptorTagName`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("DescriptorTagName");

		ContinuationType$__$DescriptorTagName = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew(symbolStrings, 207, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		//  `ContinuationType`.`Label`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("Label");

		ContinuationType$__$Label = (have_ParentAppControl) ? multiPartSymbol_Factory.createNew(symbolStrings, 208, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols) :

				multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		have_Intialized = true;
	}


}
