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
public final class ABarBarIdOrConditionalOrExpression extends PConditionalOrExpression
{
    private TIdentifier _identifier_;
    private final LinkedList<PAdditionalIdentifier> _additionalIdentifiers_ = new LinkedList<PAdditionalIdentifier>();
    private TBarBar _barBar_;
    private PConditionalAndExpression _conditionalAndExpression_;

    public ABarBarIdOrConditionalOrExpression()
    {
        // Constructor
    }

    public ABarBarIdOrConditionalOrExpression(
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") List<PAdditionalIdentifier> _additionalIdentifiers_,
        @SuppressWarnings("hiding") TBarBar _barBar_,
        @SuppressWarnings("hiding") PConditionalAndExpression _conditionalAndExpression_)
    {
        // Constructor
        setIdentifier(_identifier_);

        setAdditionalIdentifiers(_additionalIdentifiers_);

        setBarBar(_barBar_);

        setConditionalAndExpression(_conditionalAndExpression_);

    }

    @Override
    public Object clone()
    {
        return new ABarBarIdOrConditionalOrExpression(
            cloneNode(this._identifier_),
            cloneList(this._additionalIdentifiers_),
            cloneNode(this._barBar_),
            cloneNode(this._conditionalAndExpression_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseABarBarIdOrConditionalOrExpression(this);
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

    public TBarBar getBarBar()
    {
        return this._barBar_;
    }

    public void setBarBar(TBarBar node)
    {
        if(this._barBar_ != null)
        {
            this._barBar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._barBar_ = node;
    }

    public PConditionalAndExpression getConditionalAndExpression()
    {
        return this._conditionalAndExpression_;
    }

    public void setConditionalAndExpression(PConditionalAndExpression node)
    {
        if(this._conditionalAndExpression_ != null)
        {
            this._conditionalAndExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._conditionalAndExpression_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._identifier_)
            + toString(this._additionalIdentifiers_)
            + toString(this._barBar_)
            + toString(this._conditionalAndExpression_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        if(this._additionalIdentifiers_.remove(child))
        {
            return;
        }

        if(this._barBar_ == child)
        {
            this._barBar_ = null;
            return;
        }

        if(this._conditionalAndExpression_ == child)
        {
            this._conditionalAndExpression_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
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

        if(this._barBar_ == oldChild)
        {
            setBarBar((TBarBar) newChild);
            return;
        }

        if(this._conditionalAndExpression_ == oldChild)
        {
            setConditionalAndExpression((PConditionalAndExpression) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
