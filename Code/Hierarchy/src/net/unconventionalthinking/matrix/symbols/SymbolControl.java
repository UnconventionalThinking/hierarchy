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

/**
 *
 * @author peterjoh
 */
public class SymbolControl {


    public final Symbol_Single_Factory singleSymbol_Factory;
    public final Symbol_MultiPart_Factory multiPartSymbol_Factory;
    public final Symbol_MultiLevel_Factory multiLevelSymbol_Factory;

    
    public final Symbol_Index appSymbolsIndex;
    public final Symbol_Index descTagNames_Index;
    public final Symbol_Index labels_Index;

    public final Symbol_Index_MultiLevel_DescTag descTag_Index;
    public final Symbol_Index_MultiLevel_MatrixName matrixName_Index;
    public final Symbol_Index_MultiLevel_SchemaName schemaName_Index;

    public final Symbol_Index_MultiLevel_DescPath descPath_Index;
    public final Symbol_Index_MultiLevel_SchemaPath schemaPath_Index;

    
    public SymbolControl() {

        appSymbolsIndex = new Symbol_Index();
        descTagNames_Index = new Symbol_Index();
        labels_Index = new Symbol_Index();

        descTag_Index = new Symbol_Index_MultiLevel_DescTag();
        matrixName_Index = new Symbol_Index_MultiLevel_MatrixName();
        schemaName_Index = new Symbol_Index_MultiLevel_SchemaName();

        descPath_Index = new Symbol_Index_MultiLevel_DescPath();
        schemaPath_Index = new Symbol_Index_MultiLevel_SchemaPath();


        singleSymbol_Factory = new Symbol_Single_Factory(this);
        multiPartSymbol_Factory = new Symbol_MultiPart_Factory(this);
        multiLevelSymbol_Factory = new Symbol_MultiLevel_Factory(this);

    }


    public Symbol_Index selectIndex_NonMultiLevel(SymbolType symbolType) {

        switch(symbolType) {
            case Symbol:
                return appSymbolsIndex;
            case DescriptorTagName:
                return descTagNames_Index;
            case Label:
                return labels_Index;
            default:
                return appSymbolsIndex;
        }

    }

    //  MpSymbol initializers - these need to be called from the corresponding Appsymbols initializers

    public void intialize_All_MPSymbols() 
            throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed, Exception_MultiPartSymbolAccess,
                    Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolCreationOrAccess
    {
        MPSymbols.initialize(this);
        MPSymbols_DescTagName.initialize(this);
        MPSymbols_Label.initialize(this);
        MPSymbols_MatrixName.initialize(this);
        MPSymbols_SchemaName.initialize(this);
        MPSymbols_DescTag.initialize(this);
    }

    public void intialize_MPSymbols() throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed,
            Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolCreationOrAccess {
        MPSymbols.initialize(this);
    }
    public void intialize_MPSymbols_DescTagName() throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed,
            Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolCreationOrAccess {
        MPSymbols_DescTagName.initialize(this);
    }
    public void intialize_MPSymbols_Label() throws Exception_InvalidArgumentPassed_Null, Exception_InvalidArgumentPassed,
            Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreation, Exception_MultiPartSymbolCreationOrAccess{
        MPSymbols_Label.initialize(this);
    }



}
