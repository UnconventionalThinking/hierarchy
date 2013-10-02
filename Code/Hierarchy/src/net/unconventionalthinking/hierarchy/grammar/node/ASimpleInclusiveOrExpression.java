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
public final class ASimpleInclusiveOrExpression extends PInclusiveOrExpression
{
    private PExclusiveOrExpression _exclusiveOrExpression_;

    public ASimpleInclusiveOrExpression()
    {
        // Constructor
    }

    public ASimpleInclusiveOrExpression(
        @SuppressWarnings("hiding") PExclusiveOrExpression _exclusiveOrExpression_)
    {
        // Constructor
        setExclusiveOrExpression(_exclusiveOrExpression_);

    }

    @Override
    public Object clone()
    {
        return new ASimpleInclusiveOrExpression(
            cloneNode(this._exclusiveOrExpression_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASimpleInclusiveOrExpression(this);
    }

    public PExclusiveOrExpression getExclusiveOrExpression()
    {
        return this._exclusiveOrExpression_;
    }

    public void setExclusiveOrExpression(PExclusiveOrExpression node)
    {
        if(this._exclusiveOrExpression_ != null)
        {
            this._exclusiveOrExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exclusiveOrExpression_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._exclusiveOrExpression_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._exclusiveOrExpression_ == child)
        {
            this._exclusiveOrExpression_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._exclusiveOrExpression_ == oldChild)
        {
            setExclusiveOrExpression((PExclusiveOrExpression) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
