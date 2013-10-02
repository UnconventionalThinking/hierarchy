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
public final class AOneActualTypeArgumentListShr extends PActualTypeArgumentListShr
{
    private PActualTypeArgumentShr _actualTypeArgumentShr_;

    public AOneActualTypeArgumentListShr()
    {
        // Constructor
    }

    public AOneActualTypeArgumentListShr(
        @SuppressWarnings("hiding") PActualTypeArgumentShr _actualTypeArgumentShr_)
    {
        // Constructor
        setActualTypeArgumentShr(_actualTypeArgumentShr_);

    }

    @Override
    public Object clone()
    {
        return new AOneActualTypeArgumentListShr(
            cloneNode(this._actualTypeArgumentShr_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAOneActualTypeArgumentListShr(this);
    }

    public PActualTypeArgumentShr getActualTypeArgumentShr()
    {
        return this._actualTypeArgumentShr_;
    }

    public void setActualTypeArgumentShr(PActualTypeArgumentShr node)
    {
        if(this._actualTypeArgumentShr_ != null)
        {
            this._actualTypeArgumentShr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._actualTypeArgumentShr_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._actualTypeArgumentShr_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._actualTypeArgumentShr_ == child)
        {
            this._actualTypeArgumentShr_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._actualTypeArgumentShr_ == oldChild)
        {
            setActualTypeArgumentShr((PActualTypeArgumentShr) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
