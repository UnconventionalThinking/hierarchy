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
public final class AMinusIdIdAdditiveExpression extends PAdditiveExpression
{
    private TIdentifier _id1_;
    private final LinkedList<PAdditionalIdentifier> _addId1_ = new LinkedList<PAdditionalIdentifier>();
    private TMinus _minus_;
    private TIdentifier _id2_;
    private final LinkedList<PAdditionalIdentifier> _addId2_ = new LinkedList<PAdditionalIdentifier>();

    public AMinusIdIdAdditiveExpression()
    {
        // Constructor
    }

    public AMinusIdIdAdditiveExpression(
        @SuppressWarnings("hiding") TIdentifier _id1_,
        @SuppressWarnings("hiding") List<PAdditionalIdentifier> _addId1_,
        @SuppressWarnings("hiding") TMinus _minus_,
        @SuppressWarnings("hiding") TIdentifier _id2_,
        @SuppressWarnings("hiding") List<PAdditionalIdentifier> _addId2_)
    {
        // Constructor
        setId1(_id1_);

        setAddId1(_addId1_);

        setMinus(_minus_);

        setId2(_id2_);

        setAddId2(_addId2_);

    }

    @Override
    public Object clone()
    {
        return new AMinusIdIdAdditiveExpression(
            cloneNode(this._id1_),
            cloneList(this._addId1_),
            cloneNode(this._minus_),
            cloneNode(this._id2_),
            cloneList(this._addId2_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMinusIdIdAdditiveExpression(this);
    }

    public TIdentifier getId1()
    {
        return this._id1_;
    }

    public void setId1(TIdentifier node)
    {
        if(this._id1_ != null)
        {
            this._id1_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._id1_ = node;
    }

    public LinkedList<PAdditionalIdentifier> getAddId1()
    {
        return this._addId1_;
    }

    public void setAddId1(List<PAdditionalIdentifier> list)
    {
        this._addId1_.clear();
        this._addId1_.addAll(list);
        for(PAdditionalIdentifier e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    public TMinus getMinus()
    {
        return this._minus_;
    }

    public void setMinus(TMinus node)
    {
        if(this._minus_ != null)
        {
            this._minus_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._minus_ = node;
    }

    public TIdentifier getId2()
    {
        return this._id2_;
    }

    public void setId2(TIdentifier node)
    {
        if(this._id2_ != null)
        {
            this._id2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._id2_ = node;
    }

    public LinkedList<PAdditionalIdentifier> getAddId2()
    {
        return this._addId2_;
    }

    public void setAddId2(List<PAdditionalIdentifier> list)
    {
        this._addId2_.clear();
        this._addId2_.addAll(list);
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
            + toString(this._id1_)
            + toString(this._addId1_)
            + toString(this._minus_)
            + toString(this._id2_)
            + toString(this._addId2_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._id1_ == child)
        {
            this._id1_ = null;
            return;
        }

        if(this._addId1_.remove(child))
        {
            return;
        }

        if(this._minus_ == child)
        {
            this._minus_ = null;
            return;
        }

        if(this._id2_ == child)
        {
            this._id2_ = null;
            return;
        }

        if(this._addId2_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._id1_ == oldChild)
        {
            setId1((TIdentifier) newChild);
            return;
        }

        for(ListIterator<PAdditionalIdentifier> i = this._addId1_.listIterator(); i.hasNext();)
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

        if(this._minus_ == oldChild)
        {
            setMinus((TMinus) newChild);
            return;
        }

        if(this._id2_ == oldChild)
        {
            setId2((TIdentifier) newChild);
            return;
        }

        for(ListIterator<PAdditionalIdentifier> i = this._addId2_.listIterator(); i.hasNext();)
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
