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
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.exceptions.*;


/**
 *
 * @author peterjoh
 */

// TODO **** add the mpsymbols to the appsymbols indexes!!!
public class MPSymbols_DescTagName {


	public static SymbolControl symbolControl;
	public static Symbol_Single_Factory singleSymbol_Factory;
	public static Symbol_MultiPart_Factory multiPartSymbol_Factory;

	public static boolean initError = false;
	public static boolean have_Intialized = false;


	//  Single Symbols:

    //  MatrixElements DescTagNames
    public static DescriptorTagName SCHEMA;
    public static DescriptorTagName MATRIX;
    public static DescriptorTagName DESCRIPTOR;
    public static DescriptorTagName ITEM;
    public static DescriptorTagName FIELD;
    public static DescriptorTagName NAMES;
    public static DescriptorTagName TYPES;
    public static DescriptorTagName DESC;
    public static DescriptorTagName DEFAULTS;



    //  SchemaName DescTags
    public static DescriptorTagName net;
    public static DescriptorTagName unconventionalthinking;
    public static DescriptorTagName matrix;
    public static DescriptorTagName schema;
    public static DescriptorTagName WEB;
    public static DescriptorTagName FORM;

    public static DescriptorTagName BASE; // MATRIX.BASE
    public static DescriptorTagName STANDARD; // MATRIX.STANDARD
    
    public static DescriptorTagName SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA;  //  SCHEMA_FOR__SCHEMA_FOR_SCHEMA
    public static DescriptorTagName SCHEMA$95$FOR$95$SCHEMA;                   //  SCHEMA_FOR_SCHEMA


    //  Matrix FieldSet FieldNames:
    public static DescriptorTagName IsPersistentMatrix;

    //  Test DescTagName
    public static DescriptorTagName TEST;

    //  MultiPart Symbols _______________________________________________

    public static DescriptorTagName FIELD$__$NAMES;
    public static DescriptorTagName FIELD$__$TYPES;
    public static DescriptorTagName FIELD$__$DESC;
    public static DescriptorTagName FIELD$__$DEFAULTS;

    public static DescriptorTagName MATRIX$__$BASE;
    public static DescriptorTagName MATRIX$__$STANDARD;

	public static DescriptorTagName MATRIXPROG$__$PERSISTENCE$__$SETTINGS;

    public static DescriptorTagName net$__$unconventionalthinking$__$matrix;
    public static DescriptorTagName net$__$unconventionalthinking$__$matrix$__$schema;

    public static DescriptorTagName WEB$__$FORM;

    

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

        SCHEMA = singleSymbol_Factory.createNew_DescTagName("SCHEMA", true);
        MATRIX = singleSymbol_Factory.createNew_DescTagName("MATRIX", true);
        DESCRIPTOR = singleSymbol_Factory.createNew_DescTagName("DESCRIPTOR", true);
        ITEM = singleSymbol_Factory.createNew_DescTagName("ITEM", true);
        FIELD = singleSymbol_Factory.createNew_DescTagName("FIELD", true);
        NAMES = singleSymbol_Factory.createNew_DescTagName("NAMES", true);
        TYPES = singleSymbol_Factory.createNew_DescTagName("TYPES", true);
        DESC = singleSymbol_Factory.createNew_DescTagName("DESC", true);
        DEFAULTS = singleSymbol_Factory.createNew_DescTagName("DEFAULTS", true);


        TEST = singleSymbol_Factory.createNew_DescTagName("TEST", true);

        IsPersistentMatrix = singleSymbol_Factory.createNew_DescTagName("IsPersistentMatrix", true);


        net = singleSymbol_Factory.createNew_DescTagName("net", true);
        unconventionalthinking = singleSymbol_Factory.createNew_DescTagName("unconventionalthinking", true);
        matrix = singleSymbol_Factory.createNew_DescTagName("matrix", true);
        schema = singleSymbol_Factory.createNew_DescTagName("schema", true);
        WEB = singleSymbol_Factory.createNew_DescTagName("WEB", true);
        FORM = singleSymbol_Factory.createNew_DescTagName("FORM", true);

        BASE = singleSymbol_Factory.createNew_DescTagName("BASE", true);
        STANDARD = singleSymbol_Factory.createNew_DescTagName("STANDARD", true);

        SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA = singleSymbol_Factory.createNew_DescTagName("SCHEMA_FOR__SCHEMA_FOR_SCHEMA", true);
        SCHEMA$95$FOR$95$SCHEMA = singleSymbol_Factory.createNew_DescTagName("SCHEMA_FOR_SCHEMA", true);


        //  MultiPart Symbols _________________________________________________________________________


        //  FIELD.NAMES
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("FIELD");
        symbolStrings.add("NAMES");
        FIELD$__$NAMES = multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);

        //  FIELD.TYPES
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("FIELD");
        symbolStrings.add("TYPES");
        FIELD$__$TYPES = multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);

        //  FIELD.DESC
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("FIELD");
        symbolStrings.add("DESC");
        FIELD$__$DESC = multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);

        //  FIELD.DEFAULTS
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("FIELD");
        symbolStrings.add("DEFAULTS");
        FIELD$__$DEFAULTS = multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


        //  MATRIX.BASE
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("MATRIX");
        symbolStrings.add("BASE");
        MATRIX$__$BASE = multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);

        //  MATRIX.STANDARD
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("MATRIX");
        symbolStrings.add("STANDARD");
        MATRIX$__$STANDARD = multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);

        //  MATRIXPROG.PERSISTENCE.SETTINGS
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("MATRIXPROG");
        symbolStrings.add("PERSISTENCE");
        symbolStrings.add("SETTINGS");
        MATRIXPROG$__$PERSISTENCE$__$SETTINGS = multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);

        //  net.unconventionalthinking.matrix
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("net");
        symbolStrings.add("unconventionalthinking");
        symbolStrings.add("matrix");
        net$__$unconventionalthinking$__$matrix = multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);

        //  net.unconventionalthinking.matrix.schema
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("net");
        symbolStrings.add("unconventionalthinking");
        symbolStrings.add("matrix");
        symbolStrings.add("schema");
        net$__$unconventionalthinking$__$matrix$__$schema = multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);

        //  WEB.FORM
        symbolStrings = new ArrayList<String>();
        symbolStrings.add("WEB");
        symbolStrings.add("FORM");
        WEB$__$FORM = multiPartSymbol_Factory.createNew_DescTagName(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);




        have_Intialized = true;

    }  

}
