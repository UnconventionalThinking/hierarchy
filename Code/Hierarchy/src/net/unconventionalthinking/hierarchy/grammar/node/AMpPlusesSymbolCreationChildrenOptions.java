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

/* This file was generated by SableCC (http://www.sablecc.org/). */

package net.unconventionalthinking.hierarchy.grammar.node;

import java.util.*;
import net.unconventionalthinking.hierarchy.grammar.analysis.*;

@SuppressWarnings("nls")
public final class AMpPlusesSymbolCreationChildrenOptions extends PSymbolCreationChildrenOptions
{
    private final LinkedList<PSymbolCreationWChildPluses> _symbolCreationWChildPluses_ = new LinkedList<PSymbolCreationWChildPluses>();

    public AMpPlusesSymbolCreationChildrenOptions()
    {
        // Constructor
    }

    public AMpPlusesSymbolCreationChildrenOptions(
        @SuppressWarnings("hiding") List<PSymbolCreationWChildPluses> _symbolCreationWChildPluses_)
    {
        // Constructor
        setSymbolCreationWChildPluses(_symbolCreationWChildPluses_);

    }

    @Override
    public Object clone()
    {
        return new AMpPlusesSymbolCreationChildrenOptions(
            cloneList(this._symbolCreationWChildPluses_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMpPlusesSymbolCreationChildrenOptions(this);
    }

    public LinkedList<PSymbolCreationWChildPluses> getSymbolCreationWChildPluses()
    {
        return this._symbolCreationWChildPluses_;
    }

    public void setSymbolCreationWChildPluses(List<PSymbolCreationWChildPluses> list)
    {
        this._symbolCreationWChildPluses_.clear();
        this._symbolCreationWChildPluses_.addAll(list);
        for(PSymbolCreationWChildPluses e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._symbolCreationWChildPluses_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._symbolCreationWChildPluses_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        for(ListIterator<PSymbolCreationWChildPluses> i = this._symbolCreationWChildPluses_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PSymbolCreationWChildPluses) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}
