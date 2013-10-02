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

package net.unconventionalthinking.matrix.symbols;

import java.util.*;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.exceptions.*;
import net.unconventionalthinking.matrix.metacompiler.codegen.CodeConstants;

/**
 *
 * @author peterjoh
 */
public class MPSymbols_Label {

	public static SymbolControl symbolControl;
	public static Symbol_Single_Factory singleSymbol_Factory;
	public static Symbol_MultiPart_Factory multiPartSymbol_Factory;

	//  Static Initializer for Symbols:
	public static boolean initError = false;
	public static boolean have_Intialized = false;


	//  Single Symbols:
    public static Label SCHEMA;
    public static Label MATRIX;
    public static Label ITEM;
    public static Label DESCRIPTOR;
    public static Label FIELD;
    public static Label NAMES;
    public static Label TYPES;
    public static Label DESC;
    public static Label DEFAULTS;
    public static Label BASE;
    public static Label STANDARD;

    public static Label SCHEMA$95$FOR$95$SCHEMA;

    // Test
    public static Label TEST;


	//  MultiPart Symbols:
	public static Label FIELD$__$NAMES;
	public static Label FIELD$__$TYPES;
	public static Label FIELD$__$DESC;
	public static Label FIELD$__$DEFAULTS;


	public static Label MATRIX$__$BASE;
	public static Label MATRIX$__$STANDARD;



	static void initialize(SymbolControl symbol_Control) throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed,
			Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolCreationOrAccess {

        symbolControl = symbol_Control;
        singleSymbol_Factory = symbolControl.singleSymbol_Factory;
        multiPartSymbol_Factory = symbolControl.multiPartSymbol_Factory;

		//  Multipart-Symbol related variables:
		List<Symbol_Single> newlyCreatedSymbols = new ArrayList<Symbol_Single>();
		Boolean_Mutable have_Created_New_MultiPartSymbol = new Boolean_Mutable(false);
		int creation_StartLevel = 0;
		boolean creation_Has_StaticVersion = true;

		List<String> symbolStrings = null;


		//  Single Symbols _________________________________________________________________________

        SCHEMA = singleSymbol_Factory.createNew_Label(CodeConstants.SCHEMA_KEYWORD, true);
        MATRIX = singleSymbol_Factory.createNew_Label(CodeConstants.MATRIX_KEYWORD, true);
        ITEM = singleSymbol_Factory.createNew_Label(CodeConstants.ITEM_KEYWORD, true);
        DESCRIPTOR = singleSymbol_Factory.createNew_Label(CodeConstants.DESCRIPTOR_KEYWORD, true);
        FIELD = singleSymbol_Factory.createNew_Label("FIELD", true);
        NAMES = singleSymbol_Factory.createNew_Label("NAMES", true);
        TYPES = singleSymbol_Factory.createNew_Label("TYPES", true);
        DESC = singleSymbol_Factory.createNew_Label("DESC", true);
        DEFAULTS = singleSymbol_Factory.createNew_Label("DEFAULTS", true);
        BASE = singleSymbol_Factory.createNew_Label("BASE", true);
        STANDARD = singleSymbol_Factory.createNew_Label("STANDARD", true);

        SCHEMA$95$FOR$95$SCHEMA = singleSymbol_Factory.createNew_Label("SCHEMA_FOR_SCHEMA", true);

        TEST = singleSymbol_Factory.createNew_Label("TEST", true);



		//  MultiPart Symbols _________________________________________________________________________


		//  `FIELD`.`NAMES`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("NAMES");
		FIELD$__$NAMES = multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);

		//  `FIELD`.`TYPES`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("TYPES");
		FIELD$__$TYPES = multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);

		//  `FIELD`.`DESC`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("DESC");
		FIELD$__$DESC = multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);

		//  `FIELD`.`DEFAULTS`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("FIELD");
		symbolStrings.add("DEFAULTS");
		FIELD$__$DEFAULTS = multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);

		//  `MATRIX`.`BASE`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIX");
		symbolStrings.add("BASE");
		MATRIX$__$BASE = multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);

		//  `MATRIX`.`STANDARD`
		symbolStrings = new ArrayList<String>();
		symbolStrings.add("MATRIX");
		symbolStrings.add("STANDARD");
		MATRIX$__$STANDARD = multiPartSymbol_Factory.createNew_Label(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);

		have_Intialized = true;
	}

}
