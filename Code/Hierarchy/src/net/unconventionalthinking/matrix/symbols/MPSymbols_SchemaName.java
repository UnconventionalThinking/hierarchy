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
public class MPSymbols_SchemaName {


    public static SymbolControl symbolControl;
    public static Symbol_MultiLevel_Factory multiLevelSymbol_Factory;

    public static boolean initError = false;
    public static boolean have_Intialized = false;


    //  Schema Names
    public static MatrixName net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA;
    public static MatrixName net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA;

    public static MatrixName net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$BASE;
    public static MatrixName net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD;

    public static MatrixName net$__$unconventionalthinking$__$matrix$__$schema$_CC_$WEB$__$FORM;



    /**
     * This must be called after MPSymbols_DescTagName.initialize() and MPSymbols_SchemaName.initialize() have been called.
     * Why? because it uses descriptor tags and SchemaNames objects as a part of the descriptorTag Object it creates.
     */
    static void initialize(SymbolControl symbol_Control) throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed {

        symbolControl = symbol_Control;
        multiLevelSymbol_Factory = symbolControl.multiLevelSymbol_Factory;

		boolean creation_Has_StaticVersion = true;



		//  Schema-Name, Multi-Level Symbols _________________________________________________________________________
        net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA = multiLevelSymbol_Factory.createNew_SchemaName(
                    MPSymbols_DescTagName.net$__$unconventionalthinking$__$matrix, MPSymbols_DescTagName.SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA, creation_Has_StaticVersion);
        net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA = multiLevelSymbol_Factory.createNew_SchemaName(
                    MPSymbols_DescTagName.net$__$unconventionalthinking$__$matrix, MPSymbols_DescTagName.SCHEMA$95$FOR$95$SCHEMA, creation_Has_StaticVersion);

        
        net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$BASE = multiLevelSymbol_Factory.createNew_SchemaName(
                MPSymbols_DescTagName.net$__$unconventionalthinking$__$matrix, MPSymbols_DescTagName.MATRIX$__$BASE, creation_Has_StaticVersion);
        net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD = multiLevelSymbol_Factory.createNew_SchemaName(
                MPSymbols_DescTagName.net$__$unconventionalthinking$__$matrix, MPSymbols_DescTagName.MATRIX$__$STANDARD, creation_Has_StaticVersion);


        net$__$unconventionalthinking$__$matrix$__$schema$_CC_$WEB$__$FORM = multiLevelSymbol_Factory.createNew_SchemaName(
                MPSymbols_DescTagName.net$__$unconventionalthinking$__$matrix$__$schema, MPSymbols_DescTagName.WEB$__$FORM, creation_Has_StaticVersion);

        
        have_Intialized = true;

    }

}
