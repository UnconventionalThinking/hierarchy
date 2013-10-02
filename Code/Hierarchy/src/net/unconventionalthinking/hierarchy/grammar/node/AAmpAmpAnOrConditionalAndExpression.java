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

import net.unconventionalthinking.hierarchy.grammar.analysis.*;

@SuppressWarnings("nls")
public final class AAmpAmpAnOrConditionalAndExpression extends PConditionalAndExpression
{
    private PConditionalAndExpression _conditionalAndExpression_;
    private TAmpAmp _ampAmp_;
    private PInclusiveOrExpression _inclusiveOrExpression_;

    public AAmpAmpAnOrConditionalAndExpression()
    {
        // Constructor
    }

    public AAmpAmpAnOrConditionalAndExpression(
        @SuppressWarnings("hiding") PConditionalAndExpression _conditionalAndExpression_,
        @SuppressWarnings("hiding") TAmpAmp _ampAmp_,
        @SuppressWarnings("hiding") PInclusiveOrExpression _inclusiveOrExpression_)
    {
        // Constructor
        setConditionalAndExpression(_conditionalAndExpression_);

        setAmpAmp(_ampAmp_);

        setInclusiveOrExpression(_inclusiveOrExpression_);

    }

    @Override
    public Object clone()
    {
        return new AAmpAmpAnOrConditionalAndExpression(
            cloneNode(this._conditionalAndExpression_),
            cloneNode(this._ampAmp_),
            cloneNode(this._inclusiveOrExpression_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAmpAmpAnOrConditionalAndExpression(this);
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
            + toString(this._conditionalAndExpression_)
            + toString(this._ampAmp_)
            + toString(this._inclusiveOrExpression_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._conditionalAndExpression_ == child)
        {
            this._conditionalAndExpression_ = null;
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
        if(this._conditionalAndExpression_ == oldChild)
        {
            setConditionalAndExpression((PConditionalAndExpression) newChild);
            return;
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
