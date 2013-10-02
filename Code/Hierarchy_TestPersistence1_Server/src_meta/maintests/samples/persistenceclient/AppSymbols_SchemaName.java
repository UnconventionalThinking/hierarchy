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

public class AppSymbols_SchemaName { 



	//  SchemaName:
	public static MatrixName net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA;
	public static MatrixName net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA;
	public static MatrixName net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$BASE;
	public static MatrixName net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD;
	public static MatrixName net$__$unconventionalthinking$__$matrix$__$schema$_CC_$WEB$__$FORM;
	public static MatrixName maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM;
	public static MatrixName net$__$unconventional$__$persistence$_CC_$MATRIXPROG$__$PERSISTENCE;
	public static MatrixName maintests$__$samples$__$persistenceclient$_CC_$Test$__$Matrix;
	public static MatrixName maintests$__$samples$__$persistenceclient$__$otherpackage$_CC_$Test$__$Matrix2;


	//  Initializer for Symbols:
	public static boolean have_Intialized = false;


	static void initialize(SymbolControl symbol_Control) throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed {
		initialize(symbol_Control, false);
	}

	/**
	 * NOTE: have_ParentAppControl is currently not used by multi-level symbols. It made be in the future. The purpose of this field is:<p>
	 *
	 * If you set have_ParentAppControl to true, then the symbolControl you pass in should be from a parent AppControl (which means this class
	 * and all of the other app control classes for this application context are probably in a jar, being used by a parent application. <p>
	 *
	 * What this means is that all the ID fields for this class are INCORRECT!! The Id's for symbols will not be hard coded, but set dynamically.<br>
	 * What this also means is that for right now, jar files can not have embedded matrix classes methods with matrix accesses that are called from
	 * a parent application (because matrix access uses these id's).
	 */
	static void initialize(SymbolControl symbol_Control, boolean have_ParentAppControl) throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed {

		SymbolControl symbolControl = symbol_Control;
		Symbol_MultiLevel_Factory multiLevelSymbol_Factory = symbolControl.multiLevelSymbol_Factory;

		boolean creation_Has_StaticVersion = true;


		// SchemaName _________________________________________________________________________

		//  `net`.`unconventionalthinking`.`matrix`::SCHEMA_FOR__SCHEMA_FOR_SCHEMA

		net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA = multiLevelSymbol_Factory.createNew_SchemaName(AppSymbols_DescTagName.net$__$unconventionalthinking$__$matrix, AppSymbols_DescTagName.SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA,creation_Has_StaticVersion);

		//  `net`.`unconventionalthinking`.`matrix`::SCHEMA_FOR_SCHEMA

		net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA = multiLevelSymbol_Factory.createNew_SchemaName(AppSymbols_DescTagName.net$__$unconventionalthinking$__$matrix, AppSymbols_DescTagName.SCHEMA$95$FOR$95$SCHEMA,creation_Has_StaticVersion);

		//  `net`.`unconventionalthinking`.`matrix`::`MATRIX`.`BASE`

		net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$BASE = multiLevelSymbol_Factory.createNew_SchemaName(AppSymbols_DescTagName.net$__$unconventionalthinking$__$matrix, AppSymbols_DescTagName.MATRIX$__$BASE,creation_Has_StaticVersion);

		//  `net`.`unconventionalthinking`.`matrix`::`MATRIX`.`STANDARD`

		net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD = multiLevelSymbol_Factory.createNew_SchemaName(AppSymbols_DescTagName.net$__$unconventionalthinking$__$matrix, AppSymbols_DescTagName.MATRIX$__$STANDARD,creation_Has_StaticVersion);

		//  `net`.`unconventionalthinking`.`matrix`.`schema`::`WEB`.`FORM`

		net$__$unconventionalthinking$__$matrix$__$schema$_CC_$WEB$__$FORM = multiLevelSymbol_Factory.createNew_SchemaName(AppSymbols_DescTagName.net$__$unconventionalthinking$__$matrix$__$schema, AppSymbols_DescTagName.WEB$__$FORM,creation_Has_StaticVersion);

		//  `maintests`.`samples`.`persistenceclient`::`WEB`.`FORM`

		maintests$__$samples$__$persistenceclient$_CC_$WEB$__$FORM = multiLevelSymbol_Factory.createNew_SchemaName(AppSymbols_DescTagName.maintests$__$samples$__$persistenceclient, AppSymbols_DescTagName.WEB$__$FORM,creation_Has_StaticVersion);

		//  `net`.`unconventional`.`persistence`::`MATRIXPROG`.`PERSISTENCE`

		net$__$unconventional$__$persistence$_CC_$MATRIXPROG$__$PERSISTENCE = multiLevelSymbol_Factory.createNew_SchemaName(AppSymbols_DescTagName.net$__$unconventional$__$persistence, AppSymbols_DescTagName.MATRIXPROG$__$PERSISTENCE,creation_Has_StaticVersion);

		//  `maintests`.`samples`.`persistenceclient`::`Test`.`Matrix`

		maintests$__$samples$__$persistenceclient$_CC_$Test$__$Matrix = multiLevelSymbol_Factory.createNew_SchemaName(AppSymbols_DescTagName.maintests$__$samples$__$persistenceclient, AppSymbols_DescTagName.Test$__$Matrix,creation_Has_StaticVersion);

		//  `maintests`.`samples`.`persistenceclient`.`otherpackage`::`Test`.`Matrix2`

		maintests$__$samples$__$persistenceclient$__$otherpackage$_CC_$Test$__$Matrix2 = multiLevelSymbol_Factory.createNew_SchemaName(AppSymbols_DescTagName.maintests$__$samples$__$persistenceclient$__$otherpackage, AppSymbols_DescTagName.Test$__$Matrix2,creation_Has_StaticVersion);

		have_Intialized = true;
	}


}
