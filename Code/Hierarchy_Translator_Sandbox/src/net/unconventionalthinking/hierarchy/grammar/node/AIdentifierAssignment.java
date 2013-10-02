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
public final class AIdentifierAssignment extends PAssignment
{
    private PLeftHandSide _leftHandSide_;
    private TAssign _assign_;
    private TIdentifier _identifier_;
    private final LinkedList<PAdditionalIdentifier> _additionalIdentifier_ = new LinkedList<PAdditionalIdentifier>();

    public AIdentifierAssignment()
    {
        // Constructor
    }

    public AIdentifierAssignment(
        @SuppressWarnings("hiding") PLeftHandSide _leftHandSide_,
        @SuppressWarnings("hiding") TAssign _assign_,
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") List<PAdditionalIdentifier> _additionalIdentifier_)
    {
        // Constructor
        setLeftHandSide(_leftHandSide_);

        setAssign(_assign_);

        setIdentifier(_identifier_);

        setAdditionalIdentifier(_additionalIdentifier_);

    }

    @Override
    public Object clone()
    {
        return new AIdentifierAssignment(
            cloneNode(this._leftHandSide_),
            cloneNode(this._assign_),
            cloneNode(this._identifier_),
            cloneList(this._additionalIdentifier_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIdentifierAssignment(this);
    }

    public PLeftHandSide getLeftHandSide()
    {
        return this._leftHandSide_;
    }

    public void setLeftHandSide(PLeftHandSide node)
    {
        if(this._leftHandSide_ != null)
        {
            this._leftHandSide_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._leftHandSide_ = node;
    }

    public TAssign getAssign()
    {
        return this._assign_;
    }

    public void setAssign(TAssign node)
    {
        if(this._assign_ != null)
        {
            this._assign_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._assign_ = node;
    }

    public TIdentifier getIdentifier()
    {
        return this._identifier_;
    }

    public void setIdentifier(TIdentifier node)
    {
        if(this._identifier_ != null)
        {
            this._identifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identifier_ = node;
    }

    public LinkedList<PAdditionalIdentifier> getAdditionalIdentifier()
    {
        return this._additionalIdentifier_;
    }

    public void setAdditionalIdentifier(List<PAdditionalIdentifier> list)
    {
        this._additionalIdentifier_.clear();
        this._additionalIdentifier_.addAll(list);
        for(PAdditionalIdentifier e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._leftHandSide_)
            + toString(this._assign_)
            + toString(this._identifier_)
            + toString(this._additionalIdentifier_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._leftHandSide_ == child)
        {
            this._leftHandSide_ = null;
            return;
        }

        if(this._assign_ == child)
        {
            this._assign_ = null;
            return;
        }

        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        if(this._additionalIdentifier_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._leftHandSide_ == oldChild)
        {
            setLeftHandSide((PLeftHandSide) newChild);
            return;
        }

        if(this._assign_ == oldChild)
        {
            setAssign((TAssign) newChild);
            return;
        }

        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        for(ListIterator<PAdditionalIdentifier> i = this._additionalIdentifier_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PAdditionalIdentifier) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}
