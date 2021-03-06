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
public final class AMpAccessorReturnStatement extends PAccessorReturnStatement
{
    private TMpAccessorKeyword _mpAccessorKeyword_;
    private TDot _dot_;
    private TMpReturnKeyword _mpReturnKeyword_;
    private PMatrixExpression _matrixExpression_;
    private TSemi _semi_;

    public AMpAccessorReturnStatement()
    {
        // Constructor
    }

    public AMpAccessorReturnStatement(
        @SuppressWarnings("hiding") TMpAccessorKeyword _mpAccessorKeyword_,
        @SuppressWarnings("hiding") TDot _dot_,
        @SuppressWarnings("hiding") TMpReturnKeyword _mpReturnKeyword_,
        @SuppressWarnings("hiding") PMatrixExpression _matrixExpression_,
        @SuppressWarnings("hiding") TSemi _semi_)
    {
        // Constructor
        setMpAccessorKeyword(_mpAccessorKeyword_);

        setDot(_dot_);

        setMpReturnKeyword(_mpReturnKeyword_);

        setMatrixExpression(_matrixExpression_);

        setSemi(_semi_);

    }

    @Override
    public Object clone()
    {
        return new AMpAccessorReturnStatement(
            cloneNode(this._mpAccessorKeyword_),
            cloneNode(this._dot_),
            cloneNode(this._mpReturnKeyword_),
            cloneNode(this._matrixExpression_),
            cloneNode(this._semi_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMpAccessorReturnStatement(this);
    }

    public TMpAccessorKeyword getMpAccessorKeyword()
    {
        return this._mpAccessorKeyword_;
    }

    public void setMpAccessorKeyword(TMpAccessorKeyword node)
    {
        if(this._mpAccessorKeyword_ != null)
        {
            this._mpAccessorKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mpAccessorKeyword_ = node;
    }

    public TDot getDot()
    {
        return this._dot_;
    }

    public void setDot(TDot node)
    {
        if(this._dot_ != null)
        {
            this._dot_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._dot_ = node;
    }

    public TMpReturnKeyword getMpReturnKeyword()
    {
        return this._mpReturnKeyword_;
    }

    public void setMpReturnKeyword(TMpReturnKeyword node)
    {
        if(this._mpReturnKeyword_ != null)
        {
            this._mpReturnKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mpReturnKeyword_ = node;
    }

    public PMatrixExpression getMatrixExpression()
    {
        return this._matrixExpression_;
    }

    public void setMatrixExpression(PMatrixExpression node)
    {
        if(this._matrixExpression_ != null)
        {
            this._matrixExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._matrixExpression_ = node;
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
            + toString(this._mpAccessorKeyword_)
            + toString(this._dot_)
            + toString(this._mpReturnKeyword_)
            + toString(this._matrixExpression_)
            + toString(this._semi_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._mpAccessorKeyword_ == child)
        {
            this._mpAccessorKeyword_ = null;
            return;
        }

        if(this._dot_ == child)
        {
            this._dot_ = null;
            return;
        }

        if(this._mpReturnKeyword_ == child)
        {
            this._mpReturnKeyword_ = null;
            return;
        }

        if(this._matrixExpression_ == child)
        {
            this._matrixExpression_ = null;
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
        if(this._mpAccessorKeyword_ == oldChild)
        {
            setMpAccessorKeyword((TMpAccessorKeyword) newChild);
            return;
        }

        if(this._dot_ == oldChild)
        {
            setDot((TDot) newChild);
            return;
        }

        if(this._mpReturnKeyword_ == oldChild)
        {
            setMpReturnKeyword((TMpReturnKeyword) newChild);
            return;
        }

        if(this._matrixExpression_ == oldChild)
        {
            setMatrixExpression((PMatrixExpression) newChild);
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
