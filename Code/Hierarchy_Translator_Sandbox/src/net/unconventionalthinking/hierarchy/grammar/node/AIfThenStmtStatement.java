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
public final class AIfThenStmtStatement extends PStatement
{
    private PIfThenStatement _ifThenStatement_;

    public AIfThenStmtStatement()
    {
        // Constructor
    }

    public AIfThenStmtStatement(
        @SuppressWarnings("hiding") PIfThenStatement _ifThenStatement_)
    {
        // Constructor
        setIfThenStatement(_ifThenStatement_);

    }

    @Override
    public Object clone()
    {
        return new AIfThenStmtStatement(
            cloneNode(this._ifThenStatement_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIfThenStmtStatement(this);
    }

    public PIfThenStatement getIfThenStatement()
    {
        return this._ifThenStatement_;
    }

    public void setIfThenStatement(PIfThenStatement node)
    {
        if(this._ifThenStatement_ != null)
        {
            this._ifThenStatement_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ifThenStatement_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._ifThenStatement_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._ifThenStatement_ == child)
        {
            this._ifThenStatement_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._ifThenStatement_ == oldChild)
        {
            setIfThenStatement((PIfThenStatement) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
