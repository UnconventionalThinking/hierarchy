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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.unconventionalthinking.matrix.symbols;

/**
 *
 * @author peterjoh
 */
public interface Label extends Symbol_Base {

    public boolean has_TwoPartLabel();

    public String getLabel_withBacktiks();
    public String getLabel_Simple();
    public String getLabel_TwoPart();

    public String getPrimaryLabel(boolean with_BackTiks);
    public String getSecondaryLabel();


    public boolean is_MultiPartLabel();
    public Label_Single getLabel_AtPartNum(int i);

    public Symbol getSymbol();
}
