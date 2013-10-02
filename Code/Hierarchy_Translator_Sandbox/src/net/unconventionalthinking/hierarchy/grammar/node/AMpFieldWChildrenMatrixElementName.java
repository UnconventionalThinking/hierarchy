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
public final class AMpFieldWChildrenMatrixElementName extends PMatrixElementName
{
    private TMpFieldKeyword _mpFieldKeyword_;
    private final LinkedList<PAdditionalIdentifier> _additionalIdentifier_ = new LinkedList<PAdditionalIdentifier>();

    public AMpFieldWChildrenMatrixElementName()
    {
        // Constructor
    }

    public AMpFieldWChildrenMatrixElementName(
        @SuppressWarnings("hiding") TMpFieldKeyword _mpFieldKeyword_,
        @SuppressWarnings("hiding") List<PAdditionalIdentifier> _additionalIdentifier_)
    {
        // Constructor
        setMpFieldKeyword(_mpFieldKeyword_);

        setAdditionalIdentifier(_additionalIdentifier_);

    }

    @Override
    public Object clone()
    {
        return new AMpFieldWChildrenMatrixElementName(
            cloneNode(this._mpFieldKeyword_),
            cloneList(this._additionalIdentifier_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMpFieldWChildrenMatrixElementName(this);
    }

    public TMpFieldKeyword getMpFieldKeyword()
    {
        return this._mpFieldKeyword_;
    }

    public void setMpFieldKeyword(TMpFieldKeyword node)
    {
        if(this._mpFieldKeyword_ != null)
        {
            this._mpFieldKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mpFieldKeyword_ = node;
    }

    public LinkedList<PAdditionalIdentifier> getAdditionalIdentifier()
    {
        return this._additionalIdentifier_;
    }

    public void setAdditionalIdentifier(List<PAdditionalIdentifier> list)
    {
        this._additionalIdentifier_.clear();
        this._additionalIdentifier_.addAll(list);
        for(PAdditionalIdentifier e : list)
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
            + toString(this._mpFieldKeyword_)
            + toString(this._additionalIdentifier_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._mpFieldKeyword_ == child)
        {
            this._mpFieldKeyword_ = null;
            return;
        }

        if(this._additionalIdentifier_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._mpFieldKeyword_ == oldChild)
        {
            setMpFieldKeyword((TMpFieldKeyword) newChild);
            return;
        }

        for(ListIterator<PAdditionalIdentifier> i = this._additionalIdentifier_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PAdditionalIdentifier) newChild);
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
