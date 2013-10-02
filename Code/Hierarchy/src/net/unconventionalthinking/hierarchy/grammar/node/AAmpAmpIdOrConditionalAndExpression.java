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
public final class AAmpAmpIdOrConditionalAndExpression extends PConditionalAndExpression
{
    private TIdentifier _identifier_;
    private final LinkedList<PAdditionalIdentifier> _additionalIdentifiers_ = new LinkedList<PAdditionalIdentifier>();
    private TAmpAmp _ampAmp_;
    private PInclusiveOrExpression _inclusiveOrExpression_;

    public AAmpAmpIdOrConditionalAndExpression()
    {
        // Constructor
    }

    public AAmpAmpIdOrConditionalAndExpression(
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") List<PAdditionalIdentifier> _additionalIdentifiers_,
        @SuppressWarnings("hiding") TAmpAmp _ampAmp_,
        @SuppressWarnings("hiding") PInclusiveOrExpression _inclusiveOrExpression_)
    {
        // Constructor
        setIdentifier(_identifier_);

        setAdditionalIdentifiers(_additionalIdentifiers_);

        setAmpAmp(_ampAmp_);

        setInclusiveOrExpression(_inclusiveOrExpression_);

    }

    @Override
    public Object clone()
    {
        return new AAmpAmpIdOrConditionalAndExpression(
            cloneNode(this._identifier_),
            cloneList(this._additionalIdentifiers_),
            cloneNode(this._ampAmp_),
            cloneNode(this._inclusiveOrExpression_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAmpAmpIdOrConditionalAndExpression(this);
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

    public TAmpAmp getAmpAmp()
    {
        return this._ampAmp_;
    }

    public void setAmpAmp(TAmpAmp node)
    {
        if(this._ampAmp_ != null)
        {
            this._ampAmp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ampAmp_ = node;
    }

    public PInclusiveOrExpression getInclusiveOrExpression()
    {
        return this._inclusiveOrExpression_;
    }

    public void setInclusiveOrExpression(PInclusiveOrExpression node)
    {
        if(this._inclusiveOrExpression_ != null)
        {
            this._inclusiveOrExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._inclusiveOrExpression_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._identifier_)
            + toString(this._additionalIdentifiers_)
            + toString(this._ampAmp_)
            + toString(this._inclusiveOrExpression_);
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

        if(this._ampAmp_ == child)
        {
            this._ampAmp_ = null;
            return;
        }

        if(this._inclusiveOrExpression_ == child)
        {
            this._inclusiveOrExpression_ = null;
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

        if(this._ampAmp_ == oldChild)
        {
            setAmpAmp((TAmpAmp) newChild);
            return;
        }

        if(this._inclusiveOrExpression_ == oldChild)
        {
            setInclusiveOrExpression((PInclusiveOrExpression) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
