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


import net.unconventionalthinking.exceptions.*;
import net.unconventionalthinking.lang.Boolean_Mutable;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author peterjoh
 */
public class MPSymbols {

	public static SymbolControl symbolControl;
	public static Symbol_Single_Factory singleSymbol_Factory;
	public static Symbol_MultiPart_Factory multiPartSymbol_Factory;


	//  Static Initializer for Symbols:
	public static boolean initError = false;
	public static boolean have_Intialized = false;



	//  Single Symbols:
    public static Symbol ContinuationType;

    //  Primitive Types: These are keywords, so they need the "$sym$" suffix added.
    //  TODO - in symbol name generatration code, need to account for symbol names that are keywords, automatically adding a $sym$ suffix if you
    //  are converting the name for use as an identifier,
    //  and automatically removing the $sym$ when you convert the name back to non-identifier format.
    public static Symbol byte$_sym_$;
    public static Symbol short$_sym_$;
    public static Symbol int$_sym_$;
    public static Symbol long$_sym_$;
    public static Symbol float$_sym_$;
    public static Symbol double$_sym_$;
    public static Symbol char$_sym_$;
    public static Symbol boolean$_sym_$;

    //  More Java types
    public static Symbol String;
    public static Symbol Object;

    //  Matrix Types
    public static Symbol Schema;
    public static Symbol Matrix;
    public static Symbol Descriptor;
    public static Symbol FieldSet;
    public static Symbol Field;

    public static Symbol Symbol;
    public static Symbol DescriptorTagName;
    public static Symbol Label;
    public static Symbol DescriptorTag;
    public static Symbol MatrixName;
    public static Symbol SchemaName;
    public static Symbol DescriptorPath;
    public static Symbol SchemaPath;

    public static Symbol MatrixSet;
    public static Symbol MatrixSet$60$Descriptor$62$;
    public static Symbol MatrixSet$60$Object$62$;

    //  Matrix Keywords
    public static Symbol DEFAULT;

    //  Matrix FieldSet Field Values:
    public static Symbol IsPersistent;
    public static Symbol NotPersistent;

    
    //  Hierarchy Compiler internal symbols:
    public static Symbol BuildingMatrixElement;
    public static Symbol BuildingSchemaElement;
    public static Symbol BuildingMatrixElementForSchema;



	//  MultiPart Symbols:
	public static Symbol ContinuationType$__$byte;
	public static Symbol ContinuationType$__$short;
	public static Symbol ContinuationType$__$int;
	public static Symbol ContinuationType$__$long;
	public static Symbol ContinuationType$__$float;
	public static Symbol ContinuationType$__$double;
	public static Symbol ContinuationType$__$char;
	public static Symbol ContinuationType$__$boolean;

	public static Symbol ContinuationType$__$String;
	public static Symbol ContinuationType$__$Object;

	public static Symbol ContinuationType$__$Symbol;
	public static Symbol ContinuationType$__$DescriptorTagName;
	public static Symbol ContinuationType$__$Label;





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

        ContinuationType = singleSymbol_Factory.createNew("ContinuationType", true);
        //  NOTE: this ordering if symbol creation for the primitive types must remain in this order!
        //  Why? because some functions will simply check to see if a symbol's id is in between byte$_sym_$.ID and
        //  boolean$_sym_$.ID to see if it's a primitive!
        byte$_sym_$ = singleSymbol_Factory.createNew("byte", true);
        short$_sym_$ = singleSymbol_Factory.createNew("short", true);
        int$_sym_$ = singleSymbol_Factory.createNew("int", true);
        long$_sym_$ = singleSymbol_Factory.createNew("long", true);
        float$_sym_$ = singleSymbol_Factory.createNew("float", true);
        double$_sym_$ = singleSymbol_Factory.createNew("double", true);
        char$_sym_$ = singleSymbol_Factory.createNew("char", true);
        boolean$_sym_$ = singleSymbol_Factory.createNew("boolean", true);


        //  More Java types
        String = singleSymbol_Factory.createNew("String", true);
        Object = singleSymbol_Factory.createNew("Object", true);


        //  Matrix Types
        Schema = singleSymbol_Factory.createNew("Schema", true);
        Matrix = singleSymbol_Factory.createNew("Matrix", true);
        Descriptor = singleSymbol_Factory.createNew("Descriptor", true);
        FieldSet = singleSymbol_Factory.createNew("FieldSet", true);
        Field = singleSymbol_Factory.createNew("Field", true);

        Symbol = singleSymbol_Factory.createNew("Symbol", true);
        DescriptorTagName = singleSymbol_Factory.createNew("DescriptorTagName", true);
        Label = singleSymbol_Factory.createNew("Label", true);
        DescriptorTag = singleSymbol_Factory.createNew("DescriptorTag", true);
        MatrixName = singleSymbol_Factory.createNew("MatrixName", true);
        SchemaName = singleSymbol_Factory.createNew("SchemaName", true);
        DescriptorPath = singleSymbol_Factory.createNew("DescriptorPath", true);
        SchemaPath = singleSymbol_Factory.createNew("SchemaPath", true);

        MatrixSet = singleSymbol_Factory.createNew("MatrixSet", true);
        MatrixSet$60$Descriptor$62$ = singleSymbol_Factory.createNew("MatrixSet<Descriptor>", true);
        MatrixSet$60$Object$62$ = singleSymbol_Factory.createNew("MatrixSet<Object>", true);

        
        //  Matrix Keywords
        DEFAULT = singleSymbol_Factory.createNew("DEFAULT", true);



        IsPersistent = singleSymbol_Factory.createNew("IsPersistent", true);
        NotPersistent = singleSymbol_Factory.createNew("NotPersistent", true);


        BuildingMatrixElement = singleSymbol_Factory.createNew("BuildingMatrixElement", true);
        BuildingSchemaElement = singleSymbol_Factory.createNew("BuildingSchemaElement", true);
        BuildingMatrixElementForSchema = singleSymbol_Factory.createNew("BuildingMatrixElementForSchema", true);
        

		//  MultiPart Symbols _________________________________________________________________________

		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("byte");
		ContinuationType$__$byte = multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);

		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("short");
		ContinuationType$__$short = multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);

		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("int");
		ContinuationType$__$int = multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);

		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("long");
		ContinuationType$__$long = multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);

		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("float");
		ContinuationType$__$float = multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);

		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("double");
		ContinuationType$__$double = multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);

		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("char");
		ContinuationType$__$char = multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);

		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("boolean");
		ContinuationType$__$boolean = multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);



		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("String");
		ContinuationType$__$String = multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);

		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("Object");
		ContinuationType$__$Object = multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);


		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("Symbol");
		ContinuationType$__$Symbol = multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);

   		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("DescriptorTagName");
		ContinuationType$__$DescriptorTagName = multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);

  		symbolStrings = new ArrayList<String>();
		symbolStrings.add("ContinuationType");
		symbolStrings.add("Label");
		ContinuationType$__$Label = multiPartSymbol_Factory.createNew(symbolStrings, creation_StartLevel, creation_Has_StaticVersion, have_Created_New_MultiPartSymbol, newlyCreatedSymbols);



		have_Intialized = true;
	}

}
