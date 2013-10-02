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
public class Label_Single extends Symbol_Single implements Label {

    public final String label_withBackTiks;
    public final String label_Simple;
    public final String label_TwoPart;
    public final String primary_LabelName;
    public final String primary_LabelName_withBackTiks;
    public final String secondary_LabelName;


    //  can only be called by classes in the same package. for normal dev, to create symbols, use the above methods.
    Label_Single() throws Exception_InvalidArgumentPassed_Null {
        super("", -1, false);

        label_withBackTiks = getPrimaryLabel(true);
        label_Simple = getLabel_Simple();
        label_TwoPart = getLabel_TwoPart();
        primary_LabelName = getPrimaryLabel(false);
        primary_LabelName_withBackTiks = getPrimaryLabel(true);
        secondary_LabelName = getSecondaryLabel();

    }

    Label_Single(String name, boolean has_StaticVersion) throws Exception_InvalidArgumentPassed_Null {

        super (name, idCreator.getAndInc_ID(), has_StaticVersion);

        label_withBackTiks = getPrimaryLabel(true);
        label_Simple = getLabel_Simple();
        label_TwoPart = getLabel_TwoPart();
        primary_LabelName = getPrimaryLabel(false);
        primary_LabelName_withBackTiks = getPrimaryLabel(true);
        secondary_LabelName = getSecondaryLabel();
    }


    Label_Single(String name, int id, boolean has_StaticVersion) throws Exception_InvalidArgumentPassed_Null {

        super(name, id, has_StaticVersion);

        label_withBackTiks = getPrimaryLabel(true);
        label_Simple = getLabel_Simple();
        label_TwoPart = getLabel_TwoPart();
        primary_LabelName = getPrimaryLabel(false);
        primary_LabelName_withBackTiks = getPrimaryLabel(true);
        secondary_LabelName = getSecondaryLabel();

        //  if the id passed in is greater than the current idCreator's id, the idCreator id will be set to the passed in id.
        idCreator.incAndSet_IfGreater(id);

    }


    public boolean has_TwoPartLabel() { return false; }

    public String getLabel_withBacktiks() {
        return label_withBackTiks;
    }
    public String getLabel_Simple() {
        return "`" + name +"`";
    }
    public String getLabel_TwoPart() {
        return "`" + name +"`";
    }

    public String getPrimaryLabel(boolean with_BackTiks) {
        if (with_BackTiks)
            return "`" + name +"`";
        else
            return name;
    }

    public String getSecondaryLabel() {
        return null;
    }


    public boolean is_MultiPartLabel()  { return false; }

    public Label_Single getLabel_AtPartNum(int i) {
        if (i == 1)
            return (Label_Single)this;
        else
            return null;
    }

    public Symbol getSymbol() { return (Symbol)this; }
    @Override
    public SymbolType getSymbolType() { return SymbolType.Label; }



}
