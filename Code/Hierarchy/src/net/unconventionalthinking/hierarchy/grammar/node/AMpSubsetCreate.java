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
public final class AMpSubsetCreate extends PSubsetCreate
{
    private TMpSymbolSetCreationOperator _mpSymbolSetCreationOperator_;
    private PSubsetBodyOptions _subsetBodyOptions_;
    private TRBrc _rBrc_;

    public AMpSubsetCreate()
    {
        // Constructor
    }

    public AMpSubsetCreate(
        @SuppressWarnings("hiding") TMpSymbolSetCreationOperator _mpSymbolSetCreationOperator_,
        @SuppressWarnings("hiding") PSubsetBodyOptions _subsetBodyOptions_,
        @SuppressWarnings("hiding") TRBrc _rBrc_)
    {
        // Constructor
        setMpSymbolSetCreationOperator(_mpSymbolSetCreationOperator_);

        setSubsetBodyOptions(_subsetBodyOptions_);

        setRBrc(_rBrc_);

    }

    @Override
    public Object clone()
    {
        return new AMpSubsetCreate(
            cloneNode(this._mpSymbolSetCreationOperator_),
            cloneNode(this._subsetBodyOptions_),
            cloneNode(this._rBrc_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMpSubsetCreate(this);
    }

    public TMpSymbolSetCreationOperator getMpSymbolSetCreationOperator()
    {
        return this._mpSymbolSetCreationOperator_;
    }

    public void setMpSymbolSetCreationOperator(TMpSymbolSetCreationOperator node)
    {
        if(this._mpSymbolSetCreationOperator_ != null)
        {
            this._mpSymbolSetCreationOperator_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mpSymbolSetCreationOperator_ = node;
    }

    public PSubsetBodyOptions getSubsetBodyOptions()
    {
        return this._subsetBodyOptions_;
    }

    public void setSubsetBodyOptions(PSubsetBodyOptions node)
    {
        if(this._subsetBodyOptions_ != null)
        {
            this._subsetBodyOptions_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._subsetBodyOptions_ = node;
    }

    public TRBrc getRBrc()
    {
        return this._rBrc_;
    }

    public void setRBrc(TRBrc node)
    {
        if(this._rBrc_ != null)
        {
            this._rBrc_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rBrc_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._mpSymbolSetCreationOperator_)
            + toString(this._subsetBodyOptions_)
            + toString(this._rBrc_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._mpSymbolSetCreationOperator_ == child)
        {
            this._mpSymbolSetCreationOperator_ = null;
            return;
        }

        if(this._subsetBodyOptions_ == child)
        {
            this._subsetBodyOptions_ = null;
            return;
        }

        if(this._rBrc_ == child)
        {
            this._rBrc_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._mpSymbolSetCreationOperator_ == oldChild)
        {
            setMpSymbolSetCreationOperator((TMpSymbolSetCreationOperator) newChild);
            return;
        }

        if(this._subsetBodyOptions_ == oldChild)
        {
            setSubsetBodyOptions((PSubsetBodyOptions) newChild);
            return;
        }

        if(this._rBrc_ == oldChild)
        {
            setRBrc((TRBrc) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
