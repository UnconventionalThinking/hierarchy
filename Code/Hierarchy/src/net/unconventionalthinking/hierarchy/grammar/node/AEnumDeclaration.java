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
public final class AEnumDeclaration extends PEnumDeclaration
{
    private final LinkedList<PModifier> _modifiers_ = new LinkedList<PModifier>();
    private TEnum _enum_;
    private TIdentifier _identifier_;
    private PInterfaces _interfaces_;
    private PEnumBody _enumBody_;

    public AEnumDeclaration()
    {
        // Constructor
    }

    public AEnumDeclaration(
        @SuppressWarnings("hiding") List<PModifier> _modifiers_,
        @SuppressWarnings("hiding") TEnum _enum_,
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") PInterfaces _interfaces_,
        @SuppressWarnings("hiding") PEnumBody _enumBody_)
    {
        // Constructor
        setModifiers(_modifiers_);

        setEnum(_enum_);

        setIdentifier(_identifier_);

        setInterfaces(_interfaces_);

        setEnumBody(_enumBody_);

    }

    @Override
    public Object clone()
    {
        return new AEnumDeclaration(
            cloneList(this._modifiers_),
            cloneNode(this._enum_),
            cloneNode(this._identifier_),
            cloneNode(this._interfaces_),
            cloneNode(this._enumBody_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEnumDeclaration(this);
    }

    public LinkedList<PModifier> getModifiers()
    {
        return this._modifiers_;
    }

    public void setModifiers(List<PModifier> list)
    {
        this._modifiers_.clear();
        this._modifiers_.addAll(list);
        for(PModifier e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    public TEnum getEnum()
    {
        return this._enum_;
    }

    public void setEnum(TEnum node)
    {
        if(this._enum_ != null)
        {
            this._enum_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._enum_ = node;
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

    public PInterfaces getInterfaces()
    {
        return this._interfaces_;
    }

    public void setInterfaces(PInterfaces node)
    {
        if(this._interfaces_ != null)
        {
            this._interfaces_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._interfaces_ = node;
    }

    public PEnumBody getEnumBody()
    {
        return this._enumBody_;
    }

    public void setEnumBody(PEnumBody node)
    {
        if(this._enumBody_ != null)
        {
            this._enumBody_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._enumBody_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._modifiers_)
            + toString(this._enum_)
            + toString(this._identifier_)
            + toString(this._interfaces_)
            + toString(this._enumBody_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._modifiers_.remove(child))
        {
            return;
        }

        if(this._enum_ == child)
        {
            this._enum_ = null;
            return;
        }

        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        if(this._interfaces_ == child)
        {
            this._interfaces_ = null;
            return;
        }

        if(this._enumBody_ == child)
        {
            this._enumBody_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        for(ListIterator<PModifier> i = this._modifiers_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PModifier) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._enum_ == oldChild)
        {
            setEnum((TEnum) newChild);
            return;
        }

        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        if(this._interfaces_ == oldChild)
        {
            setInterfaces((PInterfaces) newChild);
            return;
        }

        if(this._enumBody_ == oldChild)
        {
            setEnumBody((PEnumBody) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
