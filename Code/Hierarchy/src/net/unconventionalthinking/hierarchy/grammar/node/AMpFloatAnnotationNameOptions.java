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
public final class AMpFloatAnnotationNameOptions extends PAnnotationNameOptions
{
    private TStar _star_;
    private TFloatingPointLiteral _floatingPointLiteral_;

    public AMpFloatAnnotationNameOptions()
    {
        // Constructor
    }

    public AMpFloatAnnotationNameOptions(
        @SuppressWarnings("hiding") TStar _star_,
        @SuppressWarnings("hiding") TFloatingPointLiteral _floatingPointLiteral_)
    {
        // Constructor
        setStar(_star_);

        setFloatingPointLiteral(_floatingPointLiteral_);

    }

    @Override
    public Object clone()
    {
        return new AMpFloatAnnotationNameOptions(
            cloneNode(this._star_),
            cloneNode(this._floatingPointLiteral_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMpFloatAnnotationNameOptions(this);
    }

    public TStar getStar()
    {
        return this._star_;
    }

    public void setStar(TStar node)
    {
        if(this._star_ != null)
        {
            this._star_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._star_ = node;
    }

    public TFloatingPointLiteral getFloatingPointLiteral()
    {
        return this._floatingPointLiteral_;
    }

    public void setFloatingPointLiteral(TFloatingPointLiteral node)
    {
        if(this._floatingPointLiteral_ != null)
        {
            this._floatingPointLiteral_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._floatingPointLiteral_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._star_)
            + toString(this._floatingPointLiteral_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._star_ == child)
        {
            this._star_ = null;
            return;
        }

        if(this._floatingPointLiteral_ == child)
        {
            this._floatingPointLiteral_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._star_ == oldChild)
        {
            setStar((TStar) newChild);
            return;
        }

        if(this._floatingPointLiteral_ == oldChild)
        {
            setFloatingPointLiteral((TFloatingPointLiteral) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
