/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package com.mycompany.hr;

import java.util.*;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.exceptions.*; 

public class AppSymbols_MatrixName { 



	//  MatrixName:
	public static MatrixName com$__$mycompany$__$hr$_CC_$OrgChart;
	public static MatrixName com$__$mycompany$__$hr$_CC_$currEmployee;
	public static MatrixName com$__$mycompany$__$hr$_CC_$currEmployeeDesc;


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

		//  `com`.`mycompany`.`hr`::OrgChart

		com$__$mycompany$__$hr$_CC_$OrgChart = multiLevelSymbol_Factory.createNew_MatrixName(AppSymbols_DescTagName.com$__$mycompany$__$hr, AppSymbols_DescTagName.OrgChart,creation_Has_StaticVersion);

		//  `com`.`mycompany`.`hr`::currEmployee

		com$__$mycompany$__$hr$_CC_$currEmployee = multiLevelSymbol_Factory.createNew_MatrixName(AppSymbols_DescTagName.com$__$mycompany$__$hr, AppSymbols_DescTagName.currEmployee,creation_Has_StaticVersion);

		//  `com`.`mycompany`.`hr`::currEmployeeDesc

		com$__$mycompany$__$hr$_CC_$currEmployeeDesc = multiLevelSymbol_Factory.createNew_MatrixName(AppSymbols_DescTagName.com$__$mycompany$__$hr, AppSymbols_DescTagName.currEmployeeDesc,creation_Has_StaticVersion);

		have_Intialized = true;
	}


}
