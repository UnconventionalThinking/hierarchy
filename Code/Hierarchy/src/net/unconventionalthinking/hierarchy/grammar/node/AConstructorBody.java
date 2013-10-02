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

import java.util.*;
import net.unconventionalthinking.hierarchy.grammar.analysis.*;

@SuppressWarnings("nls")
public final class AConstructorBody extends PConstructorBody
{
    private TLBrc _lBrc_;
    private PExplicitConstructorInvocation _explicitConstructorInvocation_;
    private final LinkedList<PBlockStatement> _blockStatements_ = new LinkedList<PBlockStatement>();
    private TRBrc _rBrc_;

    public AConstructorBody()
    {
        // Constructor
    }

    public AConstructorBody(
        @SuppressWarnings("hiding") TLBrc _lBrc_,
        @SuppressWarnings("hiding") PExplicitConstructorInvocation _explicitConstructorInvocation_,
        @SuppressWarnings("hiding") List<PBlockStatement> _blockStatements_,
        @SuppressWarnings("hiding") TRBrc _rBrc_)
    {
        // Constructor
        setLBrc(_lBrc_);

        setExplicitConstructorInvocation(_explicitConstructorInvocation_);

        setBlockStatements(_blockStatements_);

        setRBrc(_rBrc_);

    }

    @Override
    public Object clone()
    {
        return new AConstructorBody(
            cloneNode(this._lBrc_),
            cloneNode(this._explicitConstructorInvocation_),
            cloneList(this._blockStatements_),
            cloneNode(this._rBrc_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAConstructorBody(this);
    }

    public TLBrc getLBrc()
    {
        return this._lBrc_;
    }

    public void setLBrc(TLBrc node)
    {
        if(this._lBrc_ != null)
        {
            this._lBrc_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lBrc_ = node;
    }

    public PExplicitConstructorInvocation getExplicitConstructorInvocation()
    {
        return this._explicitConstructorInvocation_;
    }

    public void setExplicitConstructorInvocation(PExplicitConstructorInvocation node)
    {
        if(this._explicitConstructorInvocation_ != null)
        {
            this._explicitConstructorInvocation_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._explicitConstructorInvocation_ = node;
    }

    public LinkedList<PBlockStatement> getBlockStatements()
    {
        return this._blockStatements_;
    }

    public void setBlockStatements(List<PBlockStatement> list)
    {
        this._blockStatements_.clear();
        this._blockStatements_.addAll(list);
        for(PBlockStatement e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    public TRBrc getRBrc()
    {
        return this._rBrc_;
    }

    public void setRBrc(TRBrc node)
    {
        if(this._rBrc_ != null)
        {
            this._rBrc_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rBrc_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._lBrc_)
            + toString(this._explicitConstructorInvocation_)
            + toString(this._blockStatements_)
            + toString(this._rBrc_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._lBrc_ == child)
        {
            this._lBrc_ = null;
            return;
        }

        if(this._explicitConstructorInvocation_ == child)
        {
            this._explicitConstructorInvocation_ = null;
            return;
        }

        if(this._blockStatements_.remove(child))
        {
            return;
        }

        if(this._rBrc_ == child)
        {
            this._rBrc_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._lBrc_ == oldChild)
        {
            setLBrc((TLBrc) newChild);
            return;
        }

        if(this._explicitConstructorInvocation_ == oldChild)
        {
            setExplicitConstructorInvocation((PExplicitConstructorInvocation) newChild);
            return;
        }

        for(ListIterator<PBlockStatement> i = this._blockStatements_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PBlockStatement) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._rBrc_ == oldChild)
        {
            setRBrc((TRBrc) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
