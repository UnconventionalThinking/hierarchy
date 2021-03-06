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
public final class AMpSchemaNameListChildren extends PSchemaNameListChildren
{
    private TComma _comma_;
    private PSchemaName _schemaName_;

    public AMpSchemaNameListChildren()
    {
        // Constructor
    }

    public AMpSchemaNameListChildren(
        @SuppressWarnings("hiding") TComma _comma_,
        @SuppressWarnings("hiding") PSchemaName _schemaName_)
    {
        // Constructor
        setComma(_comma_);

        setSchemaName(_schemaName_);

    }

    @Override
    public Object clone()
    {
        return new AMpSchemaNameListChildren(
            cloneNode(this._comma_),
            cloneNode(this._schemaName_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMpSchemaNameListChildren(this);
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

    public PSchemaName getSchemaName()
    {
        return this._schemaName_;
    }

    public void setSchemaName(PSchemaName node)
    {
        if(this._schemaName_ != null)
        {
            this._schemaName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._schemaName_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._comma_)
            + toString(this._schemaName_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._comma_ == child)
        {
            this._comma_ = null;
            return;
        }

        if(this._schemaName_ == child)
        {
            this._schemaName_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._comma_ == oldChild)
        {
            setComma((TComma) newChild);
            return;
        }

        if(this._schemaName_ == oldChild)
        {
            setSchemaName((PSchemaName) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
