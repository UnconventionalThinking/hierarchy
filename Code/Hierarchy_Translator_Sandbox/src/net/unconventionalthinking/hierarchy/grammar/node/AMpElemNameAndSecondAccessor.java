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
public final class AMpElemNameAndSecondAccessor extends PElemNameAndSecondAccessor
{
    private PMatrixElementName _matrixElementName_;
    private TLBkt _lBkt_;
    private PSecondAccessor _secondAccessor_;
    private TRBkt _rBkt_;

    public AMpElemNameAndSecondAccessor()
    {
        // Constructor
    }

    public AMpElemNameAndSecondAccessor(
        @SuppressWarnings("hiding") PMatrixElementName _matrixElementName_,
        @SuppressWarnings("hiding") TLBkt _lBkt_,
        @SuppressWarnings("hiding") PSecondAccessor _secondAccessor_,
        @SuppressWarnings("hiding") TRBkt _rBkt_)
    {
        // Constructor
        setMatrixElementName(_matrixElementName_);

        setLBkt(_lBkt_);

        setSecondAccessor(_secondAccessor_);

        setRBkt(_rBkt_);

    }

    @Override
    public Object clone()
    {
        return new AMpElemNameAndSecondAccessor(
            cloneNode(this._matrixElementName_),
            cloneNode(this._lBkt_),
            cloneNode(this._secondAccessor_),
            cloneNode(this._rBkt_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMpElemNameAndSecondAccessor(this);
    }

    public PMatrixElementName getMatrixElementName()
    {
        return this._matrixElementName_;
    }

    public void setMatrixElementName(PMatrixElementName node)
    {
        if(this._matrixElementName_ != null)
        {
            this._matrixElementName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._matrixElementName_ = node;
    }

    public TLBkt getLBkt()
    {
        return this._lBkt_;
    }

    public void setLBkt(TLBkt node)
    {
        if(this._lBkt_ != null)
        {
            this._lBkt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lBkt_ = node;
    }

    public PSecondAccessor getSecondAccessor()
    {
        return this._secondAccessor_;
    }

    public void setSecondAccessor(PSecondAccessor node)
    {
        if(this._secondAccessor_ != null)
        {
            this._secondAccessor_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._secondAccessor_ = node;
    }

    public TRBkt getRBkt()
    {
        return this._rBkt_;
    }

    public void setRBkt(TRBkt node)
    {
        if(this._rBkt_ != null)
        {
            this._rBkt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rBkt_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._matrixElementName_)
            + toString(this._lBkt_)
            + toString(this._secondAccessor_)
            + toString(this._rBkt_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._matrixElementName_ == child)
        {
            this._matrixElementName_ = null;
            return;
        }

        if(this._lBkt_ == child)
        {
            this._lBkt_ = null;
            return;
        }

        if(this._secondAccessor_ == child)
        {
            this._secondAccessor_ = null;
            return;
        }

        if(this._rBkt_ == child)
        {
            this._rBkt_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._matrixElementName_ == oldChild)
        {
            setMatrixElementName((PMatrixElementName) newChild);
            return;
        }

        if(this._lBkt_ == oldChild)
        {
            setLBkt((TLBkt) newChild);
            return;
        }

        if(this._secondAccessor_ == oldChild)
        {
            setSecondAccessor((PSecondAccessor) newChild);
            return;
        }

        if(this._rBkt_ == oldChild)
        {
            setRBkt((TRBkt) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
