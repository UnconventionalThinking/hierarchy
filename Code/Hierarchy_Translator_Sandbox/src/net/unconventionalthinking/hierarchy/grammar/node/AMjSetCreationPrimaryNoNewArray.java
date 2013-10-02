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
public final class AMjSetCreationPrimaryNoNewArray extends PPrimaryNoNewArray
{
    private PSetInstanceCreation _setInstanceCreation_;

    public AMjSetCreationPrimaryNoNewArray()
    {
        // Constructor
    }

    public AMjSetCreationPrimaryNoNewArray(
        @SuppressWarnings("hiding") PSetInstanceCreation _setInstanceCreation_)
    {
        // Constructor
        setSetInstanceCreation(_setInstanceCreation_);

    }

    @Override
    public Object clone()
    {
        return new AMjSetCreationPrimaryNoNewArray(
            cloneNode(this._setInstanceCreation_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMjSetCreationPrimaryNoNewArray(this);
    }

    public PSetInstanceCreation getSetInstanceCreation()
    {
        return this._setInstanceCreation_;
    }

    public void setSetInstanceCreation(PSetInstanceCreation node)
    {
        if(this._setInstanceCreation_ != null)
        {
            this._setInstanceCreation_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._setInstanceCreation_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._setInstanceCreation_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._setInstanceCreation_ == child)
        {
            this._setInstanceCreation_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._setInstanceCreation_ == oldChild)
        {
            setSetInstanceCreation((PSetInstanceCreation) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
