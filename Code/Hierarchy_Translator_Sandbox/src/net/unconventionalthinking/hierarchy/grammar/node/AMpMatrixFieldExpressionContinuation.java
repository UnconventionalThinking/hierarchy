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
public final class AMpMatrixFieldExpressionContinuation extends PMatrixFieldExpressionContinuation
{
    private PMatrixFieldExpressionOptions _matrixFieldExpressionOptions_;
    private PContinuationOperator _continuationOperator_;

    public AMpMatrixFieldExpressionContinuation()
    {
        // Constructor
    }

    public AMpMatrixFieldExpressionContinuation(
        @SuppressWarnings("hiding") PMatrixFieldExpressionOptions _matrixFieldExpressionOptions_,
        @SuppressWarnings("hiding") PContinuationOperator _continuationOperator_)
    {
        // Constructor
        setMatrixFieldExpressionOptions(_matrixFieldExpressionOptions_);

        setContinuationOperator(_continuationOperator_);

    }

    @Override
    public Object clone()
    {
        return new AMpMatrixFieldExpressionContinuation(
            cloneNode(this._matrixFieldExpressionOptions_),
            cloneNode(this._continuationOperator_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMpMatrixFieldExpressionContinuation(this);
    }

    public PMatrixFieldExpressionOptions getMatrixFieldExpressionOptions()
    {
        return this._matrixFieldExpressionOptions_;
    }

    public void setMatrixFieldExpressionOptions(PMatrixFieldExpressionOptions node)
    {
        if(this._matrixFieldExpressionOptions_ != null)
        {
            this._matrixFieldExpressionOptions_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._matrixFieldExpressionOptions_ = node;
    }

    public PContinuationOperator getContinuationOperator()
    {
        return this._continuationOperator_;
    }

    public void setContinuationOperator(PContinuationOperator node)
    {
        if(this._continuationOperator_ != null)
        {
            this._continuationOperator_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._continuationOperator_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._matrixFieldExpressionOptions_)
            + toString(this._continuationOperator_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._matrixFieldExpressionOptions_ == child)
        {
            this._matrixFieldExpressionOptions_ = null;
            return;
        }

        if(this._continuationOperator_ == child)
        {
            this._continuationOperator_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._matrixFieldExpressionOptions_ == oldChild)
        {
            setMatrixFieldExpressionOptions((PMatrixFieldExpressionOptions) newChild);
            return;
        }

        if(this._continuationOperator_ == oldChild)
        {
            setContinuationOperator((PContinuationOperator) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
