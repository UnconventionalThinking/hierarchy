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
public final class AMpNoPlusesSymbolCreationChildrenOptions extends PSymbolCreationChildrenOptions
{
    private final LinkedList<PSymbolCreationNoChildPluses> _symbolCreationNoChildPluses_ = new LinkedList<PSymbolCreationNoChildPluses>();

    public AMpNoPlusesSymbolCreationChildrenOptions()
    {
        // Constructor
    }

    public AMpNoPlusesSymbolCreationChildrenOptions(
        @SuppressWarnings("hiding") List<PSymbolCreationNoChildPluses> _symbolCreationNoChildPluses_)
    {
        // Constructor
        setSymbolCreationNoChildPluses(_symbolCreationNoChildPluses_);

    }

    @Override
    public Object clone()
    {
        return new AMpNoPlusesSymbolCreationChildrenOptions(
            cloneList(this._symbolCreationNoChildPluses_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMpNoPlusesSymbolCreationChildrenOptions(this);
    }

    public LinkedList<PSymbolCreationNoChildPluses> getSymbolCreationNoChildPluses()
    {
        return this._symbolCreationNoChildPluses_;
    }

    public void setSymbolCreationNoChildPluses(List<PSymbolCreationNoChildPluses> list)
    {
        this._symbolCreationNoChildPluses_.clear();
        this._symbolCreationNoChildPluses_.addAll(list);
        for(PSymbolCreationNoChildPluses e : list)
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
            + toString(this._symbolCreationNoChildPluses_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._symbolCreationNoChildPluses_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        for(ListIterator<PSymbolCreationNoChildPluses> i = this._symbolCreationNoChildPluses_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PSymbolCreationNoChildPluses) newChild);
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
