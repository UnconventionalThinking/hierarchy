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
public final class ANormalClassDeclaration extends PNormalClassDeclaration
{
    private final LinkedList<PModifier> _modifiers_ = new LinkedList<PModifier>();
    private TClassToken _classToken_;
    private TIdentifier _identifier_;
    private PTypeParameters _typeParameters_;
    private PSuper _super_;
    private PInterfaces _interfaces_;
    private PClassBody _classBody_;

    public ANormalClassDeclaration()
    {
        // Constructor
    }

    public ANormalClassDeclaration(
        @SuppressWarnings("hiding") List<PModifier> _modifiers_,
        @SuppressWarnings("hiding") TClassToken _classToken_,
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") PTypeParameters _typeParameters_,
        @SuppressWarnings("hiding") PSuper _super_,
        @SuppressWarnings("hiding") PInterfaces _interfaces_,
        @SuppressWarnings("hiding") PClassBody _classBody_)
    {
        // Constructor
        setModifiers(_modifiers_);

        setClassToken(_classToken_);

        setIdentifier(_identifier_);

        setTypeParameters(_typeParameters_);

        setSuper(_super_);

        setInterfaces(_interfaces_);

        setClassBody(_classBody_);

    }

    @Override
    public Object clone()
    {
        return new ANormalClassDeclaration(
            cloneList(this._modifiers_),
            cloneNode(this._classToken_),
            cloneNode(this._identifier_),
            cloneNode(this._typeParameters_),
            cloneNode(this._super_),
            cloneNode(this._interfaces_),
            cloneNode(this._classBody_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANormalClassDeclaration(this);
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

    public TClassToken getClassToken()
    {
        return this._classToken_;
    }

    public void setClassToken(TClassToken node)
    {
        if(this._classToken_ != null)
        {
            this._classToken_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._classToken_ = node;
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

    public PTypeParameters getTypeParameters()
    {
        return this._typeParameters_;
    }

    public void setTypeParameters(PTypeParameters node)
    {
        if(this._typeParameters_ != null)
        {
            this._typeParameters_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._typeParameters_ = node;
    }

    public PSuper getSuper()
    {
        return this._super_;
    }

    public void setSuper(PSuper node)
    {
        if(this._super_ != null)
        {
            this._super_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._super_ = node;
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

    public PClassBody getClassBody()
    {
        return this._classBody_;
    }

    public void setClassBody(PClassBody node)
    {
        if(this._classBody_ != null)
        {
            this._classBody_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._classBody_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._modifiers_)
            + toString(this._classToken_)
            + toString(this._identifier_)
            + toString(this._typeParameters_)
            + toString(this._super_)
            + toString(this._interfaces_)
            + toString(this._classBody_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._modifiers_.remove(child))
        {
            return;
        }

        if(this._classToken_ == child)
        {
            this._classToken_ = null;
            return;
        }

        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        if(this._typeParameters_ == child)
        {
            this._typeParameters_ = null;
            return;
        }

        if(this._super_ == child)
        {
            this._super_ = null;
            return;
        }

        if(this._interfaces_ == child)
        {
            this._interfaces_ = null;
            return;
        }

        if(this._classBody_ == child)
        {
            this._classBody_ = null;
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

        if(this._classToken_ == oldChild)
        {
            setClassToken((TClassToken) newChild);
            return;
        }

        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        if(this._typeParameters_ == oldChild)
        {
            setTypeParameters((PTypeParameters) newChild);
            return;
        }

        if(this._super_ == oldChild)
        {
            setSuper((PSuper) newChild);
            return;
        }

        if(this._interfaces_ == oldChild)
        {
            setInterfaces((PInterfaces) newChild);
            return;
        }

        if(this._classBody_ == oldChild)
        {
            setClassBody((PClassBody) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
