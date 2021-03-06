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
public final class ALteqShIdRelationalExpression extends PRelationalExpression
{
    private PShiftExpression _shiftExpression_;
    private TLteq _lteq_;
    private TIdentifier _identifier_;
    private final LinkedList<PAdditionalIdentifier> _additionalIdentifiers_ = new LinkedList<PAdditionalIdentifier>();

    public ALteqShIdRelationalExpression()
    {
        // Constructor
    }

    public ALteqShIdRelationalExpression(
        @SuppressWarnings("hiding") PShiftExpression _shiftExpression_,
        @SuppressWarnings("hiding") TLteq _lteq_,
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") List<PAdditionalIdentifier> _additionalIdentifiers_)
    {
        // Constructor
        setShiftExpression(_shiftExpression_);

        setLteq(_lteq_);

        setIdentifier(_identifier_);

        setAdditionalIdentifiers(_additionalIdentifiers_);

    }

    @Override
    public Object clone()
    {
        return new ALteqShIdRelationalExpression(
            cloneNode(this._shiftExpression_),
            cloneNode(this._lteq_),
            cloneNode(this._identifier_),
            cloneList(this._additionalIdentifiers_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALteqShIdRelationalExpression(this);
    }

    public PShiftExpression getShiftExpression()
    {
        return this._shiftExpression_;
    }

    public void setShiftExpression(PShiftExpression node)
    {
        if(this._shiftExpression_ != null)
        {
            this._shiftExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._shiftExpression_ = node;
    }

    public TLteq getLteq()
    {
        return this._lteq_;
    }

    public void setLteq(TLteq node)
    {
        if(this._lteq_ != null)
        {
            this._lteq_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lteq_ = node;
    }

    public TIdentifier getIdentifier()
    {
        return this._identifier_;
    }

    public void setIdentifier(TIdentifier node)
    {
        if(this._identifier_ != null)
        {
            this._identifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identifier_ = node;
    }

    public LinkedList<PAdditionalIdentifier> getAdditionalIdentifiers()
    {
        return this._additionalIdentifiers_;
    }

    public void setAdditionalIdentifiers(List<PAdditionalIdentifier> list)
    {
        this._additionalIdentifiers_.clear();
        this._additionalIdentifiers_.addAll(list);
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
            + toString(this._shiftExpression_)
            + toString(this._lteq_)
            + toString(this._identifier_)
            + toString(this._additionalIdentifiers_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._shiftExpression_ == child)
        {
            this._shiftExpression_ = null;
            return;
        }

        if(this._lteq_ == child)
        {
            this._lteq_ = null;
            return;
        }

        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        if(this._additionalIdentifiers_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._shiftExpression_ == oldChild)
        {
            setShiftExpression((PShiftExpression) newChild);
            return;
        }

        if(this._lteq_ == oldChild)
        {
            setLteq((TLteq) newChild);
            return;
        }

        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        for(ListIterator<PAdditionalIdentifier> i = this._additionalIdentifiers_.listIterator(); i.hasNext();)
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
