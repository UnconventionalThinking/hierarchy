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
public final class AMpMatrixelementOneOrMoreNamescopesFirstDynAccessor extends PFirstDynAccessor
{
    private PMatrixElementNameIdentifierWOneOrMoreNamescopes _matrixElementNameIdentifierWOneOrMoreNamescopes_;

    public AMpMatrixelementOneOrMoreNamescopesFirstDynAccessor()
    {
        // Constructor
    }

    public AMpMatrixelementOneOrMoreNamescopesFirstDynAccessor(
        @SuppressWarnings("hiding") PMatrixElementNameIdentifierWOneOrMoreNamescopes _matrixElementNameIdentifierWOneOrMoreNamescopes_)
    {
        // Constructor
        setMatrixElementNameIdentifierWOneOrMoreNamescopes(_matrixElementNameIdentifierWOneOrMoreNamescopes_);

    }

    @Override
    public Object clone()
    {
        return new AMpMatrixelementOneOrMoreNamescopesFirstDynAccessor(
            cloneNode(this._matrixElementNameIdentifierWOneOrMoreNamescopes_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMpMatrixelementOneOrMoreNamescopesFirstDynAccessor(this);
    }

    public PMatrixElementNameIdentifierWOneOrMoreNamescopes getMatrixElementNameIdentifierWOneOrMoreNamescopes()
    {
        return this._matrixElementNameIdentifierWOneOrMoreNamescopes_;
    }

    public void setMatrixElementNameIdentifierWOneOrMoreNamescopes(PMatrixElementNameIdentifierWOneOrMoreNamescopes node)
    {
        if(this._matrixElementNameIdentifierWOneOrMoreNamescopes_ != null)
        {
            this._matrixElementNameIdentifierWOneOrMoreNamescopes_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._matrixElementNameIdentifierWOneOrMoreNamescopes_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._matrixElementNameIdentifierWOneOrMoreNamescopes_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._matrixElementNameIdentifierWOneOrMoreNamescopes_ == child)
        {
            this._matrixElementNameIdentifierWOneOrMoreNamescopes_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._matrixElementNameIdentifierWOneOrMoreNamescopes_ == oldChild)
        {
            setMatrixElementNameIdentifierWOneOrMoreNamescopes((PMatrixElementNameIdentifierWOneOrMoreNamescopes) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
