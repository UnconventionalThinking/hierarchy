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

package maintests.samples;

import java.util.*;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.exceptions.*; 

public class AppSymbols_MatrixName { 



	//  MatrixName:
	public static MatrixName maintests$__$samples$_CC_$Abstract$__$Content;
	public static MatrixName maintests$__$samples$_CC_$Test$__$Matrix;
	public static MatrixName maintests$__$samples$_CC_$Test$__$Matrix2;
	public static MatrixName maintests$__$samples$_CC_$testDescVar;
	public static MatrixName maintests$__$samples$_CC_$testDescVar$95$FormRequired;
	public static MatrixName maintests$__$samples$_CC_$testDescField$95$Item;
	public static MatrixName maintests$__$samples$_CC_$testDesc;
	public static MatrixName maintests$__$samples$_CC_$formReq$95$Desc;
	public static MatrixName maintests$__$samples$_CC_$testImportingTypes$95$desc;
	public static MatrixName maintests$__$samples$_CC_$testDescVar$95$Item;
	public static MatrixName maintests$__$samples$_CC_$testItem;


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


		// MatrixName _________________________________________________________________________

		//  `maintests`.`samples`::`Abstract`.`Content`

		maintests$__$samples$_CC_$Abstract$__$Content = multiLevelSymbol_Factory.createNew_MatrixName(AppSymbols_DescTagName.maintests$__$samples, AppSymbols_DescTagName.Abstract$__$Content,creation_Has_StaticVersion);

		//  `maintests`.`samples`::`Test`.`Matrix`

		maintests$__$samples$_CC_$Test$__$Matrix = multiLevelSymbol_Factory.createNew_MatrixName(AppSymbols_DescTagName.maintests$__$samples, AppSymbols_DescTagName.Test$__$Matrix,creation_Has_StaticVersion);

		//  `maintests`.`samples`::`Test`.`Matrix2`

		maintests$__$samples$_CC_$Test$__$Matrix2 = multiLevelSymbol_Factory.createNew_MatrixName(AppSymbols_DescTagName.maintests$__$samples, AppSymbols_DescTagName.Test$__$Matrix2,creation_Has_StaticVersion);

		//  `maintests`.`samples`::testDescVar

		maintests$__$samples$_CC_$testDescVar = multiLevelSymbol_Factory.createNew_MatrixName(AppSymbols_DescTagName.maintests$__$samples, AppSymbols_DescTagName.testDescVar,creation_Has_StaticVersion);

		//  `maintests`.`samples`::testDescVar_FormRequired

		maintests$__$samples$_CC_$testDescVar$95$FormRequired = multiLevelSymbol_Factory.createNew_MatrixName(AppSymbols_DescTagName.maintests$__$samples, AppSymbols_DescTagName.testDescVar$95$FormRequired,creation_Has_StaticVersion);

		//  `maintests`.`samples`::testDescField_Item

		maintests$__$samples$_CC_$testDescField$95$Item = multiLevelSymbol_Factory.createNew_MatrixName(AppSymbols_DescTagName.maintests$__$samples, AppSymbols_DescTagName.testDescField$95$Item,creation_Has_StaticVersion);

		//  `maintests`.`samples`::testDesc

		maintests$__$samples$_CC_$testDesc = multiLevelSymbol_Factory.createNew_MatrixName(AppSymbols_DescTagName.maintests$__$samples, AppSymbols_DescTagName.testDesc,creation_Has_StaticVersion);

		//  `maintests`.`samples`::formReq_Desc

		maintests$__$samples$_CC_$formReq$95$Desc = multiLevelSymbol_Factory.createNew_MatrixName(AppSymbols_DescTagName.maintests$__$samples, AppSymbols_DescTagName.formReq$95$Desc,creation_Has_StaticVersion);

		//  `maintests`.`samples`::testImportingTypes_desc

		maintests$__$samples$_CC_$testImportingTypes$95$desc = multiLevelSymbol_Factory.createNew_MatrixName(AppSymbols_DescTagName.maintests$__$samples, AppSymbols_DescTagName.testImportingTypes$95$desc,creation_Has_StaticVersion);

		//  `maintests`.`samples`::testDescVar_Item

		maintests$__$samples$_CC_$testDescVar$95$Item = multiLevelSymbol_Factory.createNew_MatrixName(AppSymbols_DescTagName.maintests$__$samples, AppSymbols_DescTagName.testDescVar$95$Item,creation_Has_StaticVersion);

		//  `maintests`.`samples`::testItem

		maintests$__$samples$_CC_$testItem = multiLevelSymbol_Factory.createNew_MatrixName(AppSymbols_DescTagName.maintests$__$samples, AppSymbols_DescTagName.testItem,creation_Has_StaticVersion);

		have_Intialized = true;
	}


}
