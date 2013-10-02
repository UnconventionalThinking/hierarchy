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
public final class ASimpleEqualityExpression extends PEqualityExpression
{
    private PRelationalExpression _relationalExpression_;

    public ASimpleEqualityExpression()
    {
        // Constructor
    }

    public ASimpleEqualityExpression(
        @SuppressWarnings("hiding") PRelationalExpression _relationalExpression_)
    {
        // Constructor
        setRelationalExpression(_relationalExpression_);

    }

    @Override
    public Object clone()
    {
        return new ASimpleEqualityExpression(
            cloneNode(this._relationalExpression_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASimpleEqualityExpression(this);
    }

    public PRelationalExpression getRelationalExpression()
    {
        return this._relationalExpression_;
    }

    public void setRelationalExpression(PRelationalExpression node)
    {
        if(this._relationalExpression_ != null)
        {
            this._relationalExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._relationalExpression_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._relationalExpression_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._relationalExpression_ == child)
        {
            this._relationalExpression_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._relationalExpression_ == oldChild)
        {
            setRelationalExpression((PRelationalExpression) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
