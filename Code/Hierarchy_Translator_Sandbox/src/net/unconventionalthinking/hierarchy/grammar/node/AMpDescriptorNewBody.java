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
public final class AMpDescriptorNewBody extends PDescriptorNewBody
{
    private PDescriptorHeadStd _descriptorHeadStd_;
    private PUsesSchemas _usesSchemas_;
    private PDescriptorFieldAndBodyOptions _descriptorFieldAndBodyOptions_;
    private TSemi _semi_;

    public AMpDescriptorNewBody()
    {
        // Constructor
    }

    public AMpDescriptorNewBody(
        @SuppressWarnings("hiding") PDescriptorHeadStd _descriptorHeadStd_,
        @SuppressWarnings("hiding") PUsesSchemas _usesSchemas_,
        @SuppressWarnings("hiding") PDescriptorFieldAndBodyOptions _descriptorFieldAndBodyOptions_,
        @SuppressWarnings("hiding") TSemi _semi_)
    {
        // Constructor
        setDescriptorHeadStd(_descriptorHeadStd_);

        setUsesSchemas(_usesSchemas_);

        setDescriptorFieldAndBodyOptions(_descriptorFieldAndBodyOptions_);

        setSemi(_semi_);

    }

    @Override
    public Object clone()
    {
        return new AMpDescriptorNewBody(
            cloneNode(this._descriptorHeadStd_),
            cloneNode(this._usesSchemas_),
            cloneNode(this._descriptorFieldAndBodyOptions_),
            cloneNode(this._semi_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMpDescriptorNewBody(this);
    }

    public PDescriptorHeadStd getDescriptorHeadStd()
    {
        return this._descriptorHeadStd_;
    }

    public void setDescriptorHeadStd(PDescriptorHeadStd node)
    {
        if(this._descriptorHeadStd_ != null)
        {
            this._descriptorHeadStd_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._descriptorHeadStd_ = node;
    }

    public PUsesSchemas getUsesSchemas()
    {
        return this._usesSchemas_;
    }

    public void setUsesSchemas(PUsesSchemas node)
    {
        if(this._usesSchemas_ != null)
        {
            this._usesSchemas_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._usesSchemas_ = node;
    }

    public PDescriptorFieldAndBodyOptions getDescriptorFieldAndBodyOptions()
    {
        return this._descriptorFieldAndBodyOptions_;
    }

    public void setDescriptorFieldAndBodyOptions(PDescriptorFieldAndBodyOptions node)
    {
        if(this._descriptorFieldAndBodyOptions_ != null)
        {
            this._descriptorFieldAndBodyOptions_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._descriptorFieldAndBodyOptions_ = node;
    }

    public TSemi getSemi()
    {
        return this._semi_;
    }

    public void setSemi(TSemi node)
    {
        if(this._semi_ != null)
        {
            this._semi_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._semi_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._descriptorHeadStd_)
            + toString(this._usesSchemas_)
            + toString(this._descriptorFieldAndBodyOptions_)
            + toString(this._semi_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._descriptorHeadStd_ == child)
        {
            this._descriptorHeadStd_ = null;
            return;
        }

        if(this._usesSchemas_ == child)
        {
            this._usesSchemas_ = null;
            return;
        }

        if(this._descriptorFieldAndBodyOptions_ == child)
        {
            this._descriptorFieldAndBodyOptions_ = null;
            return;
        }

        if(this._semi_ == child)
        {
            this._semi_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._descriptorHeadStd_ == oldChild)
        {
            setDescriptorHeadStd((PDescriptorHeadStd) newChild);
            return;
        }

        if(this._usesSchemas_ == oldChild)
        {
            setUsesSchemas((PUsesSchemas) newChild);
            return;
        }

        if(this._descriptorFieldAndBodyOptions_ == oldChild)
        {
            setDescriptorFieldAndBodyOptions((PDescriptorFieldAndBodyOptions) newChild);
            return;
        }

        if(this._semi_ == oldChild)
        {
            setSemi((TSemi) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
