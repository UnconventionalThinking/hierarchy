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
public final class AMjEqMpMpEqualityExpression extends PEqualityExpression
{
    private PMpOutsideIncludedExprRelatedProdPlusId _mpElement1_;
    private TEq _eq_;
    private PMpOutsideIncludedExprRelatedProdPlusId _mpElement2_;

    public AMjEqMpMpEqualityExpression()
    {
        // Constructor
    }

    public AMjEqMpMpEqualityExpression(
        @SuppressWarnings("hiding") PMpOutsideIncludedExprRelatedProdPlusId _mpElement1_,
        @SuppressWarnings("hiding") TEq _eq_,
        @SuppressWarnings("hiding") PMpOutsideIncludedExprRelatedProdPlusId _mpElement2_)
    {
        // Constructor
        setMpElement1(_mpElement1_);

        setEq(_eq_);

        setMpElement2(_mpElement2_);

    }

    @Override
    public Object clone()
    {
        return new AMjEqMpMpEqualityExpression(
            cloneNode(this._mpElement1_),
            cloneNode(this._eq_),
            cloneNode(this._mpElement2_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMjEqMpMpEqualityExpression(this);
    }

    public PMpOutsideIncludedExprRelatedProdPlusId getMpElement1()
    {
        return this._mpElement1_;
    }

    public void setMpElement1(PMpOutsideIncludedExprRelatedProdPlusId node)
    {
        if(this._mpElement1_ != null)
        {
            this._mpElement1_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mpElement1_ = node;
    }

    public TEq getEq()
    {
        return this._eq_;
    }

    public void setEq(TEq node)
    {
        if(this._eq_ != null)
        {
            this._eq_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._eq_ = node;
    }

    public PMpOutsideIncludedExprRelatedProdPlusId getMpElement2()
    {
        return this._mpElement2_;
    }

    public void setMpElement2(PMpOutsideIncludedExprRelatedProdPlusId node)
    {
        if(this._mpElement2_ != null)
        {
            this._mpElement2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mpElement2_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._mpElement1_)
            + toString(this._eq_)
            + toString(this._mpElement2_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._mpElement1_ == child)
        {
            this._mpElement1_ = null;
            return;
        }

        if(this._eq_ == child)
        {
            this._eq_ = null;
            return;
        }

        if(this._mpElement2_ == child)
        {
            this._mpElement2_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._mpElement1_ == oldChild)
        {
            setMpElement1((PMpOutsideIncludedExprRelatedProdPlusId) newChild);
            return;
        }

        if(this._eq_ == oldChild)
        {
            setEq((TEq) newChild);
            return;
        }

        if(this._mpElement2_ == oldChild)
        {
            setMpElement2((PMpOutsideIncludedExprRelatedProdPlusId) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
