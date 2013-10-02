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
public class MPSymbols_DescTag {


	public static SymbolControl symbolControl;
	public static Symbol_MultiLevel_Factory multiLevelSymbol_Factory;

	public static boolean initError = false;
	public static boolean have_Intialized = false;


    //  SCHEMA_FOR__SCHEMA_FOR_SCHEMA DescriptorTags:
    public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$SCHEMA;
    public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR;
    public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$NAMES;
    public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$TYPES;

    //  SCHEMA_FOR_SCHEMA DescriptorTags:
    public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$SCHEMA;
    public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR;
    public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$ITEM;
    public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$MATRIX;


    public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$NAMES;
    public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$TYPES;
    public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$DESC;
    public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$DEFAULTS;

    
    //  MATRIX.BASE Schema DescriptorTags:
    public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$BASE$_CC_$MATRIX;
    
    //  MATRIX.STANDARD Schema DescriptorTags:
    public static DescriptorTag net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM;

    
    /**
     * This must be called after MPSymbols_DescTagName.initialize() and MPSymbols_SchemaName.initialize() have been called.
     * Why? because it uses descriptor tags and SchemaNames objects as a part of the descriptorTag Object it creates.
     */
	static void initialize(SymbolControl symbol_Control) throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed {

        symbolControl = symbol_Control;
        multiLevelSymbol_Factory = symbolControl.multiLevelSymbol_Factory;


		boolean creation_Has_StaticVersion = true;



		//  Descriptor Tag, Multi-Level Symbols _________________________________________________________________________
        //  Schema For SchemaForSchema
        net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$SCHEMA = multiLevelSymbol_Factory.createNew_DescriptorTag(
                MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA, MPSymbols_DescTagName.SCHEMA, creation_Has_StaticVersion);
        net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR = multiLevelSymbol_Factory.createNew_DescriptorTag(
                MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA, MPSymbols_DescTagName.DESCRIPTOR, creation_Has_StaticVersion);

        net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$NAMES = multiLevelSymbol_Factory.createNew_DescriptorTag(
                MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA, MPSymbols_DescTagName.FIELD$__$NAMES, creation_Has_StaticVersion);
        net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$TYPES = multiLevelSymbol_Factory.createNew_DescriptorTag(
                MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$$95$SCHEMA$95$FOR$95$SCHEMA, MPSymbols_DescTagName.FIELD$__$TYPES, creation_Has_StaticVersion);


        //  SchemaForSchema
        net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$SCHEMA = multiLevelSymbol_Factory.createNew_DescriptorTag(
                MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, MPSymbols_DescTagName.SCHEMA, creation_Has_StaticVersion);
        net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$DESCRIPTOR = multiLevelSymbol_Factory.createNew_DescriptorTag(
                MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, MPSymbols_DescTagName.DESCRIPTOR, creation_Has_StaticVersion);

        net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$ITEM = multiLevelSymbol_Factory.createNew_DescriptorTag(
                MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, MPSymbols_DescTagName.ITEM, creation_Has_StaticVersion);
        net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$MATRIX = multiLevelSymbol_Factory.createNew_DescriptorTag(
                MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, MPSymbols_DescTagName.MATRIX, creation_Has_StaticVersion);;

        net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$NAMES = multiLevelSymbol_Factory.createNew_DescriptorTag(
                MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, MPSymbols_DescTagName.FIELD$__$NAMES, creation_Has_StaticVersion);
        net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$TYPES = multiLevelSymbol_Factory.createNew_DescriptorTag(
                MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, MPSymbols_DescTagName.FIELD$__$TYPES, creation_Has_StaticVersion);
        net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$DESC = multiLevelSymbol_Factory.createNew_DescriptorTag(
                MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, MPSymbols_DescTagName.FIELD$__$DESC, creation_Has_StaticVersion);
        net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA$_CC_$FIELD$__$DEFAULTS = multiLevelSymbol_Factory.createNew_DescriptorTag(
                MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$SCHEMA$95$FOR$95$SCHEMA, MPSymbols_DescTagName.FIELD$__$DEFAULTS, creation_Has_StaticVersion);

        


        net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$BASE$_CC_$MATRIX = multiLevelSymbol_Factory.createNew_DescriptorTag(
                MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$BASE, MPSymbols_DescTagName.MATRIX, creation_Has_StaticVersion);

        net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM = multiLevelSymbol_Factory.createNew_DescriptorTag(
                MPSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD, MPSymbols_DescTagName.ITEM, creation_Has_StaticVersion);

        
        have_Intialized = true;

	}  

}
