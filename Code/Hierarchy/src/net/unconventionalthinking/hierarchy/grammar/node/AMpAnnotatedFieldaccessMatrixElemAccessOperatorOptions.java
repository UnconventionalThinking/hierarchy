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
public final class AMpAnnotatedFieldaccessMatrixElemAccessOperatorOptions extends PMatrixElemAccessOperatorOptions
{
    private TMpColonLtOperator _mpColonLtOperator_;
    private PAnnotationUseage _annotationUseage_;
    private TGt _gt_;

    public AMpAnnotatedFieldaccessMatrixElemAccessOperatorOptions()
    {
        // Constructor
    }

    public AMpAnnotatedFieldaccessMatrixElemAccessOperatorOptions(
        @SuppressWarnings("hiding") TMpColonLtOperator _mpColonLtOperator_,
        @SuppressWarnings("hiding") PAnnotationUseage _annotationUseage_,
        @SuppressWarnings("hiding") TGt _gt_)
    {
        // Constructor
        setMpColonLtOperator(_mpColonLtOperator_);

        setAnnotationUseage(_annotationUseage_);

        setGt(_gt_);

    }

    @Override
    public Object clone()
    {
        return new AMpAnnotatedFieldaccessMatrixElemAccessOperatorOptions(
            cloneNode(this._mpColonLtOperator_),
            cloneNode(this._annotationUseage_),
            cloneNode(this._gt_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMpAnnotatedFieldaccessMatrixElemAccessOperatorOptions(this);
    }

    public TMpColonLtOperator getMpColonLtOperator()
    {
        return this._mpColonLtOperator_;
    }

    public void setMpColonLtOperator(TMpColonLtOperator node)
    {
        if(this._mpColonLtOperator_ != null)
        {
            this._mpColonLtOperator_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mpColonLtOperator_ = node;
    }

    public PAnnotationUseage getAnnotationUseage()
    {
        return this._annotationUseage_;
    }

    public void setAnnotationUseage(PAnnotationUseage node)
    {
        if(this._annotationUseage_ != null)
        {
            this._annotationUseage_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._annotationUseage_ = node;
    }

    public TGt getGt()
    {
        return this._gt_;
    }

    public void setGt(TGt node)
    {
        if(this._gt_ != null)
        {
            this._gt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._gt_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._mpColonLtOperator_)
            + toString(this._annotationUseage_)
            + toString(this._gt_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._mpColonLtOperator_ == child)
        {
            this._mpColonLtOperator_ = null;
            return;
        }

        if(this._annotationUseage_ == child)
        {
            this._annotationUseage_ = null;
            return;
        }

        if(this._gt_ == child)
        {
            this._gt_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._mpColonLtOperator_ == oldChild)
        {
            setMpColonLtOperator((TMpColonLtOperator) newChild);
            return;
        }

        if(this._annotationUseage_ == oldChild)
        {
            setAnnotationUseage((PAnnotationUseage) newChild);
            return;
        }

        if(this._gt_ == oldChild)
        {
            setGt((TGt) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
