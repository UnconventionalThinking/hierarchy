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
public final class AFloatingNumericType extends PNumericType
{
    private PFloatingPointType _floatingPointType_;

    public AFloatingNumericType()
    {
        // Constructor
    }

    public AFloatingNumericType(
        @SuppressWarnings("hiding") PFloatingPointType _floatingPointType_)
    {
        // Constructor
        setFloatingPointType(_floatingPointType_);

    }

    @Override
    public Object clone()
    {
        return new AFloatingNumericType(
            cloneNode(this._floatingPointType_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFloatingNumericType(this);
    }

    public PFloatingPointType getFloatingPointType()
    {
        return this._floatingPointType_;
    }

    public void setFloatingPointType(PFloatingPointType node)
    {
        if(this._floatingPointType_ != null)
        {
            this._floatingPointType_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._floatingPointType_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._floatingPointType_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._floatingPointType_ == child)
        {
            this._floatingPointType_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._floatingPointType_ == oldChild)
        {
            setFloatingPointType((PFloatingPointType) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
