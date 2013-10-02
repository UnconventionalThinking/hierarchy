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
public final class ATwoExExAssertStatement extends PAssertStatement
{
    private TAssert _assert_;
    private PExpression _expression1_;
    private TColon _colon_;
    private PExpression _expression2_;
    private TSemi _semi_;

    public ATwoExExAssertStatement()
    {
        // Constructor
    }

    public ATwoExExAssertStatement(
        @SuppressWarnings("hiding") TAssert _assert_,
        @SuppressWarnings("hiding") PExpression _expression1_,
        @SuppressWarnings("hiding") TColon _colon_,
        @SuppressWarnings("hiding") PExpression _expression2_,
        @SuppressWarnings("hiding") TSemi _semi_)
    {
        // Constructor
        setAssert(_assert_);

        setExpression1(_expression1_);

        setColon(_colon_);

        setExpression2(_expression2_);

        setSemi(_semi_);

    }

    @Override
    public Object clone()
    {
        return new ATwoExExAssertStatement(
            cloneNode(this._assert_),
            cloneNode(this._expression1_),
            cloneNode(this._colon_),
            cloneNode(this._expression2_),
            cloneNode(this._semi_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATwoExExAssertStatement(this);
    }

    public TAssert getAssert()
    {
        return this._assert_;
    }

    public void setAssert(TAssert node)
    {
        if(this._assert_ != null)
        {
            this._assert_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._assert_ = node;
    }

    public PExpression getExpression1()
    {
        return this._expression1_;
    }

    public void setExpression1(PExpression node)
    {
        if(this._expression1_ != null)
        {
            this._expression1_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression1_ = node;
    }

    public TColon getColon()
    {
        return this._colon_;
    }

    public void setColon(TColon node)
    {
        if(this._colon_ != null)
        {
            this._colon_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._colon_ = node;
    }

    public PExpression getExpression2()
    {
        return this._expression2_;
    }

    public void setExpression2(PExpression node)
    {
        if(this._expression2_ != null)
        {
            this._expression2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression2_ = node;
    }

    public TSemi getSemi()
    {
        return this._semi_;
    }

    public void setSemi(TSemi node)
    {
        if(this._semi_ != null)
        {
            this._semi_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._semi_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._assert_)
            + toString(this._expression1_)
            + toString(this._colon_)
            + toString(this._expression2_)
            + toString(this._semi_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._assert_ == child)
        {
            this._assert_ = null;
            return;
        }

        if(this._expression1_ == child)
        {
            this._expression1_ = null;
            return;
        }

        if(this._colon_ == child)
        {
            this._colon_ = null;
            return;
        }

        if(this._expression2_ == child)
        {
            this._expression2_ = null;
            return;
        }

        if(this._semi_ == child)
        {
            this._semi_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._assert_ == oldChild)
        {
            setAssert((TAssert) newChild);
            return;
        }

        if(this._expression1_ == oldChild)
        {
            setExpression1((PExpression) newChild);
            return;
        }

        if(this._colon_ == oldChild)
        {
            setColon((TColon) newChild);
            return;
        }

        if(this._expression2_ == oldChild)
        {
            setExpression2((PExpression) newChild);
            return;
        }

        if(this._semi_ == oldChild)
        {
            setSemi((TSemi) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
