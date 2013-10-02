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
public final class ANormalInterfaceDeclaration extends PNormalInterfaceDeclaration
{
    private final LinkedList<PModifier> _modifiers_ = new LinkedList<PModifier>();
    private TInterface _interface_;
    private TIdentifier _identifier_;
    private PTypeParameters _typeParameters_;
    private PExtendsInterfaces _extendsInterfaces_;
    private PInterfaceBody _interfaceBody_;

    public ANormalInterfaceDeclaration()
    {
        // Constructor
    }

    public ANormalInterfaceDeclaration(
        @SuppressWarnings("hiding") List<PModifier> _modifiers_,
        @SuppressWarnings("hiding") TInterface _interface_,
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") PTypeParameters _typeParameters_,
        @SuppressWarnings("hiding") PExtendsInterfaces _extendsInterfaces_,
        @SuppressWarnings("hiding") PInterfaceBody _interfaceBody_)
    {
        // Constructor
        setModifiers(_modifiers_);

        setInterface(_interface_);

        setIdentifier(_identifier_);

        setTypeParameters(_typeParameters_);

        setExtendsInterfaces(_extendsInterfaces_);

        setInterfaceBody(_interfaceBody_);

    }

    @Override
    public Object clone()
    {
        return new ANormalInterfaceDeclaration(
            cloneList(this._modifiers_),
            cloneNode(this._interface_),
            cloneNode(this._identifier_),
            cloneNode(this._typeParameters_),
            cloneNode(this._extendsInterfaces_),
            cloneNode(this._interfaceBody_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANormalInterfaceDeclaration(this);
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

    public TInterface getInterface()
    {
        return this._interface_;
    }

    public void setInterface(TInterface node)
    {
        if(this._interface_ != null)
        {
            this._interface_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._interface_ = node;
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

    public PExtendsInterfaces getExtendsInterfaces()
    {
        return this._extendsInterfaces_;
    }

    public void setExtendsInterfaces(PExtendsInterfaces node)
    {
        if(this._extendsInterfaces_ != null)
        {
            this._extendsInterfaces_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._extendsInterfaces_ = node;
    }

    public PInterfaceBody getInterfaceBody()
    {
        return this._interfaceBody_;
    }

    public void setInterfaceBody(PInterfaceBody node)
    {
        if(this._interfaceBody_ != null)
        {
            this._interfaceBody_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._interfaceBody_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._modifiers_)
            + toString(this._interface_)
            + toString(this._identifier_)
            + toString(this._typeParameters_)
            + toString(this._extendsInterfaces_)
            + toString(this._interfaceBody_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._modifiers_.remove(child))
        {
            return;
        }

        if(this._interface_ == child)
        {
            this._interface_ = null;
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

        if(this._extendsInterfaces_ == child)
        {
            this._extendsInterfaces_ = null;
            return;
        }

        if(this._interfaceBody_ == child)
        {
            this._interfaceBody_ = null;
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

        if(this._interface_ == oldChild)
        {
            setInterface((TInterface) newChild);
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

        if(this._extendsInterfaces_ == oldChild)
        {
            setExtendsInterfaces((PExtendsInterfaces) newChild);
            return;
        }

        if(this._interfaceBody_ == oldChild)
        {
            setInterfaceBody((PInterfaceBody) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
