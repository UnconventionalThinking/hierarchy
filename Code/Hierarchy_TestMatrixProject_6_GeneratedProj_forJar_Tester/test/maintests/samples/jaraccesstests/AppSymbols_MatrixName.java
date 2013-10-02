/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package maintests.samples.jaraccesstests;

import java.util.*;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.exceptions.*; 

public class AppSymbols_MatrixName { 



	//  MatrixName:
	public static MatrixName maintests$__$samples$__$typeinfotest$_CC_$Test$__$Matrix;
	public static MatrixName maintests$__$samples$__$typeinfotest$_CC_$Test$__$Matrix2;
	public static MatrixName maintests$__$samples$__$typeinfotest$_CC_$Test$__$Matrix2$95$1;
	public static MatrixName maintests$__$samples$__$typeinfotest$__$anotherpackage$_CC_$Test$__$Matrix3;
	public static MatrixName maintests$__$samples$__$jaraccesstests$_CC_$Test$__$Matrix2;


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

		//  `maintests`.`samples`.`typeinfotest`::`Test`.`Matrix`

		maintests$__$samples$__$typeinfotest$_CC_$Test$__$Matrix = multiLevelSymbol_Factory.createNew_MatrixName(AppSymbols_DescTagName.maintests$__$samples$__$typeinfotest, AppSymbols_DescTagName.Test$__$Matrix,creation_Has_StaticVersion);

		//  `maintests`.`samples`.`typeinfotest`::`Test`.`Matrix2`

		maintests$__$samples$__$typeinfotest$_CC_$Test$__$Matrix2 = multiLevelSymbol_Factory.createNew_MatrixName(AppSymbols_DescTagName.maintests$__$samples$__$typeinfotest, AppSymbols_DescTagName.Test$__$Matrix2,creation_Has_StaticVersion);

		//  `maintests`.`samples`.`typeinfotest`::`Test`.`Matrix2_1`

		maintests$__$samples$__$typeinfotest$_CC_$Test$__$Matrix2$95$1 = multiLevelSymbol_Factory.createNew_MatrixName(AppSymbols_DescTagName.maintests$__$samples$__$typeinfotest, AppSymbols_DescTagName.Test$__$Matrix2$95$1,creation_Has_StaticVersion);

		//  `maintests`.`samples`.`typeinfotest`.`anotherpackage`::`Test`.`Matrix3`

		maintests$__$samples$__$typeinfotest$__$anotherpackage$_CC_$Test$__$Matrix3 = multiLevelSymbol_Factory.createNew_MatrixName(AppSymbols_DescTagName.maintests$__$samples$__$typeinfotest$__$anotherpackage, AppSymbols_DescTagName.Test$__$Matrix3,creation_Has_StaticVersion);

		//  `maintests`.`samples`.`jaraccesstests`::`Test`.`Matrix2`

		maintests$__$samples$__$jaraccesstests$_CC_$Test$__$Matrix2 = multiLevelSymbol_Factory.createNew_MatrixName(AppSymbols_DescTagName.maintests$__$samples$__$jaraccesstests, AppSymbols_DescTagName.Test$__$Matrix2,creation_Has_StaticVersion);

		have_Intialized = true;
	}


}
