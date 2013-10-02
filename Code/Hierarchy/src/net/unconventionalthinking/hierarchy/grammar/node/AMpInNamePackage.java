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
public final class AMpInNamePackage extends PInNamePackage
{
    private TMpInKeyword _mpInKeyword_;
    private PNamePackageName _namePackageName_;

    public AMpInNamePackage()
    {
        // Constructor
    }

    public AMpInNamePackage(
        @SuppressWarnings("hiding") TMpInKeyword _mpInKeyword_,
        @SuppressWarnings("hiding") PNamePackageName _namePackageName_)
    {
        // Constructor
        setMpInKeyword(_mpInKeyword_);

        setNamePackageName(_namePackageName_);

    }

    @Override
    public Object clone()
    {
        return new AMpInNamePackage(
            cloneNode(this._mpInKeyword_),
            cloneNode(this._namePackageName_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMpInNamePackage(this);
    }

    public TMpInKeyword getMpInKeyword()
    {
        return this._mpInKeyword_;
    }

    public void setMpInKeyword(TMpInKeyword node)
    {
        if(this._mpInKeyword_ != null)
        {
            this._mpInKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mpInKeyword_ = node;
    }

    public PNamePackageName getNamePackageName()
    {
        return this._namePackageName_;
    }

    public void setNamePackageName(PNamePackageName node)
    {
        if(this._namePackageName_ != null)
        {
            this._namePackageName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._namePackageName_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._mpInKeyword_)
            + toString(this._namePackageName_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._mpInKeyword_ == child)
        {
            this._mpInKeyword_ = null;
            return;
        }

        if(this._namePackageName_ == child)
        {
            this._namePackageName_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._mpInKeyword_ == oldChild)
        {
            setMpInKeyword((TMpInKeyword) newChild);
            return;
        }

        if(this._namePackageName_ == oldChild)
        {
            setNamePackageName((PNamePackageName) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
