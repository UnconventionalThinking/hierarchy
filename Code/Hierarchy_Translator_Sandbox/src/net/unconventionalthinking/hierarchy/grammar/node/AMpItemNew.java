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
public final class AMpItemNew extends PItemNew
{
    private TMpItemKeyword _mpItemKeyword_;
    private TDot _dot_;
    private TMpNewKeyword _mpNewKeyword_;
    private PNewUsesSchema _newUsesSchema_;
    private PItemNewBodyOptions _itemNewBodyOptions_;

    public AMpItemNew()
    {
        // Constructor
    }

    public AMpItemNew(
        @SuppressWarnings("hiding") TMpItemKeyword _mpItemKeyword_,
        @SuppressWarnings("hiding") TDot _dot_,
        @SuppressWarnings("hiding") TMpNewKeyword _mpNewKeyword_,
        @SuppressWarnings("hiding") PNewUsesSchema _newUsesSchema_,
        @SuppressWarnings("hiding") PItemNewBodyOptions _itemNewBodyOptions_)
    {
        // Constructor
        setMpItemKeyword(_mpItemKeyword_);

        setDot(_dot_);

        setMpNewKeyword(_mpNewKeyword_);

        setNewUsesSchema(_newUsesSchema_);

        setItemNewBodyOptions(_itemNewBodyOptions_);

    }

    @Override
    public Object clone()
    {
        return new AMpItemNew(
            cloneNode(this._mpItemKeyword_),
            cloneNode(this._dot_),
            cloneNode(this._mpNewKeyword_),
            cloneNode(this._newUsesSchema_),
            cloneNode(this._itemNewBodyOptions_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMpItemNew(this);
    }

    public TMpItemKeyword getMpItemKeyword()
    {
        return this._mpItemKeyword_;
    }

    public void setMpItemKeyword(TMpItemKeyword node)
    {
        if(this._mpItemKeyword_ != null)
        {
            this._mpItemKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mpItemKeyword_ = node;
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

    public TMpNewKeyword getMpNewKeyword()
    {
        return this._mpNewKeyword_;
    }

    public void setMpNewKeyword(TMpNewKeyword node)
    {
        if(this._mpNewKeyword_ != null)
        {
            this._mpNewKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mpNewKeyword_ = node;
    }

    public PNewUsesSchema getNewUsesSchema()
    {
        return this._newUsesSchema_;
    }

    public void setNewUsesSchema(PNewUsesSchema node)
    {
        if(this._newUsesSchema_ != null)
        {
            this._newUsesSchema_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._newUsesSchema_ = node;
    }

    public PItemNewBodyOptions getItemNewBodyOptions()
    {
        return this._itemNewBodyOptions_;
    }

    public void setItemNewBodyOptions(PItemNewBodyOptions node)
    {
        if(this._itemNewBodyOptions_ != null)
        {
            this._itemNewBodyOptions_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._itemNewBodyOptions_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._mpItemKeyword_)
            + toString(this._dot_)
            + toString(this._mpNewKeyword_)
            + toString(this._newUsesSchema_)
            + toString(this._itemNewBodyOptions_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._mpItemKeyword_ == child)
        {
            this._mpItemKeyword_ = null;
            return;
        }

        if(this._dot_ == child)
        {
            this._dot_ = null;
            return;
        }

        if(this._mpNewKeyword_ == child)
        {
            this._mpNewKeyword_ = null;
            return;
        }

        if(this._newUsesSchema_ == child)
        {
            this._newUsesSchema_ = null;
            return;
        }

        if(this._itemNewBodyOptions_ == child)
        {
            this._itemNewBodyOptions_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._mpItemKeyword_ == oldChild)
        {
            setMpItemKeyword((TMpItemKeyword) newChild);
            return;
        }

        if(this._dot_ == oldChild)
        {
            setDot((TDot) newChild);
            return;
        }

        if(this._mpNewKeyword_ == oldChild)
        {
            setMpNewKeyword((TMpNewKeyword) newChild);
            return;
        }

        if(this._newUsesSchema_ == oldChild)
        {
            setNewUsesSchema((PNewUsesSchema) newChild);
            return;
        }

        if(this._itemNewBodyOptions_ == oldChild)
        {
            setItemNewBodyOptions((PItemNewBodyOptions) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
