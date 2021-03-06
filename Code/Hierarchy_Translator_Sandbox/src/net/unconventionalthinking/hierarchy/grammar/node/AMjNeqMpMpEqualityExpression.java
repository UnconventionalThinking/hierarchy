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
public final class AMjNeqMpMpEqualityExpression extends PEqualityExpression
{
    private PMpOutsideIncludedExprRelatedProdPlusId _mpElement1_;
    private TNeq _neq_;
    private PMpOutsideIncludedExprRelatedProdPlusId _mpElement2_;

    public AMjNeqMpMpEqualityExpression()
    {
        // Constructor
    }

    public AMjNeqMpMpEqualityExpression(
        @SuppressWarnings("hiding") PMpOutsideIncludedExprRelatedProdPlusId _mpElement1_,
        @SuppressWarnings("hiding") TNeq _neq_,
        @SuppressWarnings("hiding") PMpOutsideIncludedExprRelatedProdPlusId _mpElement2_)
    {
        // Constructor
        setMpElement1(_mpElement1_);

        setNeq(_neq_);

        setMpElement2(_mpElement2_);

    }

    @Override
    public Object clone()
    {
        return new AMjNeqMpMpEqualityExpression(
            cloneNode(this._mpElement1_),
            cloneNode(this._neq_),
            cloneNode(this._mpElement2_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMjNeqMpMpEqualityExpression(this);
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

    public TNeq getNeq()
    {
        return this._neq_;
    }

    public void setNeq(TNeq node)
    {
        if(this._neq_ != null)
        {
            this._neq_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._neq_ = node;
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
            + toString(this._neq_)
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

        if(this._neq_ == child)
        {
            this._neq_ = null;
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

        if(this._neq_ == oldChild)
        {
            setNeq((TNeq) newChild);
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
