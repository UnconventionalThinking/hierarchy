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
public final class AMpTypedAndSubsetCardinalityMpSetType extends PMpSetType
{
    private TMpSetKeyword _mpSetKeyword_;
    private TLt _lt_;
    private PMpTypes _mpTypes_;
    private TComma _comma_;
    private PMpIntegerLiteral _mpIntegerLiteral_;
    private TGt _gt_;

    public AMpTypedAndSubsetCardinalityMpSetType()
    {
        // Constructor
    }

    public AMpTypedAndSubsetCardinalityMpSetType(
        @SuppressWarnings("hiding") TMpSetKeyword _mpSetKeyword_,
        @SuppressWarnings("hiding") TLt _lt_,
        @SuppressWarnings("hiding") PMpTypes _mpTypes_,
        @SuppressWarnings("hiding") TComma _comma_,
        @SuppressWarnings("hiding") PMpIntegerLiteral _mpIntegerLiteral_,
        @SuppressWarnings("hiding") TGt _gt_)
    {
        // Constructor
        setMpSetKeyword(_mpSetKeyword_);

        setLt(_lt_);

        setMpTypes(_mpTypes_);

        setComma(_comma_);

        setMpIntegerLiteral(_mpIntegerLiteral_);

        setGt(_gt_);

    }

    @Override
    public Object clone()
    {
        return new AMpTypedAndSubsetCardinalityMpSetType(
            cloneNode(this._mpSetKeyword_),
            cloneNode(this._lt_),
            cloneNode(this._mpTypes_),
            cloneNode(this._comma_),
            cloneNode(this._mpIntegerLiteral_),
            cloneNode(this._gt_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMpTypedAndSubsetCardinalityMpSetType(this);
    }

    public TMpSetKeyword getMpSetKeyword()
    {
        return this._mpSetKeyword_;
    }

    public void setMpSetKeyword(TMpSetKeyword node)
    {
        if(this._mpSetKeyword_ != null)
        {
            this._mpSetKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mpSetKeyword_ = node;
    }

    public TLt getLt()
    {
        return this._lt_;
    }

    public void setLt(TLt node)
    {
        if(this._lt_ != null)
        {
            this._lt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lt_ = node;
    }

    public PMpTypes getMpTypes()
    {
        return this._mpTypes_;
    }

    public void setMpTypes(PMpTypes node)
    {
        if(this._mpTypes_ != null)
        {
            this._mpTypes_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mpTypes_ = node;
    }

    public TComma getComma()
    {
        return this._comma_;
    }

    public void setComma(TComma node)
    {
        if(this._comma_ != null)
        {
            this._comma_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._comma_ = node;
    }

    public PMpIntegerLiteral getMpIntegerLiteral()
    {
        return this._mpIntegerLiteral_;
    }

    public void setMpIntegerLiteral(PMpIntegerLiteral node)
    {
        if(this._mpIntegerLiteral_ != null)
        {
            this._mpIntegerLiteral_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mpIntegerLiteral_ = node;
    }

    public TGt getGt()
    {
        return this._gt_;
    }

    public void setGt(TGt node)
    {
        if(this._gt_ != null)
        {
            this._gt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._gt_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._mpSetKeyword_)
            + toString(this._lt_)
            + toString(this._mpTypes_)
            + toString(this._comma_)
            + toString(this._mpIntegerLiteral_)
            + toString(this._gt_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._mpSetKeyword_ == child)
        {
            this._mpSetKeyword_ = null;
            return;
        }

        if(this._lt_ == child)
        {
            this._lt_ = null;
            return;
        }

        if(this._mpTypes_ == child)
        {
            this._mpTypes_ = null;
            return;
        }

        if(this._comma_ == child)
        {
            this._comma_ = null;
            return;
        }

        if(this._mpIntegerLiteral_ == child)
        {
            this._mpIntegerLiteral_ = null;
            return;
        }

        if(this._gt_ == child)
        {
            this._gt_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._mpSetKeyword_ == oldChild)
        {
            setMpSetKeyword((TMpSetKeyword) newChild);
            return;
        }

        if(this._lt_ == oldChild)
        {
            setLt((TLt) newChild);
            return;
        }

        if(this._mpTypes_ == oldChild)
        {
            setMpTypes((PMpTypes) newChild);
            return;
        }

        if(this._comma_ == oldChild)
        {
            setComma((TComma) newChild);
            return;
        }

        if(this._mpIntegerLiteral_ == oldChild)
        {
            setMpIntegerLiteral((PMpIntegerLiteral) newChild);
            return;
        }

        if(this._gt_ == oldChild)
        {
            setGt((TGt) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
