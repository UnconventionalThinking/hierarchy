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
import net.unconventionalthinking.exceptions.*;

/**
 *
 * @author peterjoh
 */
public class Label_MultiPart extends Symbol_MultiPart implements Label {


    public final String label_withBackTiks;
    public final String label_Simple;
    public final String label_TwoPart;
    public final String primary_LabelName;
    public final String primary_LabelName_withBackTiks;
    public final String secondary_LabelName;




    //  Constructors used in Symbol_MultiPart_Worker.addOrAccess_MultiPartSymbol_To_Indexes()

    Label_MultiPart() throws Exception_InvalidArgumentPassed_Null {

        super(new Symbol_Single[0], false);

        label_withBackTiks = name;
        label_Simple = getLabel_Simple();
        label_TwoPart = getLabel_TwoPart();
        primary_LabelName = getPrimaryLabel(false);
        primary_LabelName_withBackTiks = getPrimaryLabel(true);
        secondary_LabelName = getSecondaryLabel();
    }


    Label_MultiPart(Symbol_Single[] symbols, boolean has_StaticVersion) throws Exception_InvalidArgumentPassed_Null {
        super(symbols, has_StaticVersion);

        label_withBackTiks = name;
        label_Simple = getLabel_Simple();
        label_TwoPart = getLabel_TwoPart();
        primary_LabelName = getPrimaryLabel(false);
        primary_LabelName_withBackTiks = getPrimaryLabel(true);
        secondary_LabelName = getSecondaryLabel();
    }
    Label_MultiPart(Symbol_Single[] symbols, int multipart_SymbolID, boolean has_StaticVersion) throws Exception_InvalidArgumentPassed_Null {
        super(symbols, multipart_SymbolID, has_StaticVersion);

        label_withBackTiks = name;
        label_Simple = getLabel_Simple();
        label_TwoPart = getLabel_TwoPart();
        primary_LabelName = getPrimaryLabel(false);
        primary_LabelName_withBackTiks = getPrimaryLabel(true);
        secondary_LabelName = getSecondaryLabel();
    }
    Label_MultiPart(List<Symbol_Single> symbols, boolean has_StaticVersion) throws Exception_InvalidArgumentPassed_Null  {
        super(symbols, has_StaticVersion);

        label_withBackTiks = name;
        label_Simple = getLabel_Simple();
        label_TwoPart = getLabel_TwoPart();
        primary_LabelName = getPrimaryLabel(false);
        primary_LabelName_withBackTiks = getPrimaryLabel(true);
        secondary_LabelName = getSecondaryLabel();
    }
    Label_MultiPart(List<Symbol_Single> symbols, int multipart_SymbolID, boolean has_StaticVersion) throws Exception_InvalidArgumentPassed_Null  {
        super(symbols, multipart_SymbolID, has_StaticVersion);

        label_withBackTiks = name;
        label_Simple = getLabel_Simple();
        label_TwoPart = getLabel_TwoPart();
        primary_LabelName = getPrimaryLabel(false);
        primary_LabelName_withBackTiks = getPrimaryLabel(true);
        secondary_LabelName = getSecondaryLabel();
    }


    public boolean has_TwoPartLabel() {
        return (secondary_LabelName != null);
    }

    public String getLabel_withBacktiks() {
        return label_withBackTiks;
    }
    public String getLabel_Simple() {
        return super.name;
    }

    public String getLabel_TwoPart() {

        if (label_TwoPart != null)
            return label_TwoPart;


        String label = null;
        if (super.symbols!= null && super.symbols.length >= 1)
            label = "`" + super.symbols[0] + "`";
        else
            return null;

        if (super.symbols.length >= 2) {
            label += " IN " + symbols[1];

            for (int i = 2; i < symbols.length; ++i) {
                label += "." + symbols[i];
            }
        }

        return label;
    }

    public String getPrimaryLabel(boolean with_BackTiks) {
        if (super.symbols != null && super.symbols.length > 0) {
            if (with_BackTiks)
                return "`" + super.symbols[0].name +"`";
            else
                return super.symbols[0].name;
        } else
            return null;
    }


    public String getSecondaryLabel() {

        if (secondary_LabelName != null)
            return secondary_LabelName;


        String label = "";
        if (super.symbols!= null && super.symbols.length >= 2) {
            label += symbols[1];

            for (int i = 2; i < symbols.length; ++i) {
                label += "." + symbols[i];
            }

        } else
            label = null;

        return label;
    }




    public boolean is_MultiPartLabel()  { return true; }

    public Label_Single getLabel_AtPartNum(int i) {
        return (Label_Single) super.getSymbol_AtPartNum(i);
    }


    public Symbol getSymbol() { return (Symbol)this; }
    @Override
    public SymbolType getSymbolType() { return SymbolType.Label; }

}
