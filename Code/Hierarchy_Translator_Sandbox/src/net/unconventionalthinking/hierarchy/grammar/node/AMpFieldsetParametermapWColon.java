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
public final class AMpFieldsetParametermapWColon extends PFieldsetParametermapWColon
{
    private TColon _colon_;
    private PFieldsetParametermapOptions _fieldsetParametermapOptions_;

    public AMpFieldsetParametermapWColon()
    {
        // Constructor
    }

    public AMpFieldsetParametermapWColon(
        @SuppressWarnings("hiding") TColon _colon_,
        @SuppressWarnings("hiding") PFieldsetParametermapOptions _fieldsetParametermapOptions_)
    {
        // Constructor
        setColon(_colon_);

        setFieldsetParametermapOptions(_fieldsetParametermapOptions_);

    }

    @Override
    public Object clone()
    {
        return new AMpFieldsetParametermapWColon(
            cloneNode(this._colon_),
            cloneNode(this._fieldsetParametermapOptions_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMpFieldsetParametermapWColon(this);
    }

    public TColon getColon()
    {
        return this._colon_;
    }

    public void setColon(TColon node)
    {
        if(this._colon_ != null)
        {
            this._colon_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._colon_ = node;
    }

    public PFieldsetParametermapOptions getFieldsetParametermapOptions()
    {
        return this._fieldsetParametermapOptions_;
    }

    public void setFieldsetParametermapOptions(PFieldsetParametermapOptions node)
    {
        if(this._fieldsetParametermapOptions_ != null)
        {
            this._fieldsetParametermapOptions_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._fieldsetParametermapOptions_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._colon_)
            + toString(this._fieldsetParametermapOptions_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._colon_ == child)
        {
            this._colon_ = null;
            return;
        }

        if(this._fieldsetParametermapOptions_ == child)
        {
            this._fieldsetParametermapOptions_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._colon_ == oldChild)
        {
            setColon((TColon) newChild);
            return;
        }

        if(this._fieldsetParametermapOptions_ == oldChild)
        {
            setFieldsetParametermapOptions((PFieldsetParametermapOptions) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
