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
public final class AMpVarMpMatrixTypes extends PMpMatrixTypes
{
    private TMpVarKeyword _mpVarKeyword_;

    public AMpVarMpMatrixTypes()
    {
        // Constructor
    }

    public AMpVarMpMatrixTypes(
        @SuppressWarnings("hiding") TMpVarKeyword _mpVarKeyword_)
    {
        // Constructor
        setMpVarKeyword(_mpVarKeyword_);

    }

    @Override
    public Object clone()
    {
        return new AMpVarMpMatrixTypes(
            cloneNode(this._mpVarKeyword_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMpVarMpMatrixTypes(this);
    }

    public TMpVarKeyword getMpVarKeyword()
    {
        return this._mpVarKeyword_;
    }

    public void setMpVarKeyword(TMpVarKeyword node)
    {
        if(this._mpVarKeyword_ != null)
        {
            this._mpVarKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mpVarKeyword_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._mpVarKeyword_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._mpVarKeyword_ == child)
        {
            this._mpVarKeyword_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._mpVarKeyword_ == oldChild)
        {
            setMpVarKeyword((TMpVarKeyword) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
