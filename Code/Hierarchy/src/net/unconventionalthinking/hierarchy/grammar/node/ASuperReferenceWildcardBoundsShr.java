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
public final class ASuperReferenceWildcardBoundsShr extends PWildcardBoundsShr
{
    private TSuperToken _superToken_;
    private TIdentifier _identifier_;
    private final LinkedList<PAdditionalIdentifier> _additionalIdentifiers_ = new LinkedList<PAdditionalIdentifier>();
    private final LinkedList<PTypeComponent> _typeComponents_ = new LinkedList<PTypeComponent>();
    private PTypeArgumentsShrNoGt _typeArgumentsShrNoGt_;

    public ASuperReferenceWildcardBoundsShr()
    {
        // Constructor
    }

    public ASuperReferenceWildcardBoundsShr(
        @SuppressWarnings("hiding") TSuperToken _superToken_,
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") List<PAdditionalIdentifier> _additionalIdentifiers_,
        @SuppressWarnings("hiding") List<PTypeComponent> _typeComponents_,
        @SuppressWarnings("hiding") PTypeArgumentsShrNoGt _typeArgumentsShrNoGt_)
    {
        // Constructor
        setSuperToken(_superToken_);

        setIdentifier(_identifier_);

        setAdditionalIdentifiers(_additionalIdentifiers_);

        setTypeComponents(_typeComponents_);

        setTypeArgumentsShrNoGt(_typeArgumentsShrNoGt_);

    }

    @Override
    public Object clone()
    {
        return new ASuperReferenceWildcardBoundsShr(
            cloneNode(this._superToken_),
            cloneNode(this._identifier_),
            cloneList(this._additionalIdentifiers_),
            cloneList(this._typeComponents_),
            cloneNode(this._typeArgumentsShrNoGt_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASuperReferenceWildcardBoundsShr(this);
    }

    public TSuperToken getSuperToken()
    {
        return this._superToken_;
    }

    public void setSuperToken(TSuperToken node)
    {
        if(this._superToken_ != null)
        {
            this._superToken_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._superToken_ = node;
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

    public LinkedList<PAdditionalIdentifier> getAdditionalIdentifiers()
    {
        return this._additionalIdentifiers_;
    }

    public void setAdditionalIdentifiers(List<PAdditionalIdentifier> list)
    {
        this._additionalIdentifiers_.clear();
        this._additionalIdentifiers_.addAll(list);
        for(PAdditionalIdentifier e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    public LinkedList<PTypeComponent> getTypeComponents()
    {
        return this._typeComponents_;
    }

    public void setTypeComponents(List<PTypeComponent> list)
    {
        this._typeComponents_.clear();
        this._typeComponents_.addAll(list);
        for(PTypeComponent e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    public PTypeArgumentsShrNoGt getTypeArgumentsShrNoGt()
    {
        return this._typeArgumentsShrNoGt_;
    }

    public void setTypeArgumentsShrNoGt(PTypeArgumentsShrNoGt node)
    {
        if(this._typeArgumentsShrNoGt_ != null)
        {
            this._typeArgumentsShrNoGt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._typeArgumentsShrNoGt_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._superToken_)
            + toString(this._identifier_)
            + toString(this._additionalIdentifiers_)
            + toString(this._typeComponents_)
            + toString(this._typeArgumentsShrNoGt_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._superToken_ == child)
        {
            this._superToken_ = null;
            return;
        }

        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        if(this._additionalIdentifiers_.remove(child))
        {
            return;
        }

        if(this._typeComponents_.remove(child))
        {
            return;
        }

        if(this._typeArgumentsShrNoGt_ == child)
        {
            this._typeArgumentsShrNoGt_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._superToken_ == oldChild)
        {
            setSuperToken((TSuperToken) newChild);
            return;
        }

        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        for(ListIterator<PAdditionalIdentifier> i = this._additionalIdentifiers_.listIterator(); i.hasNext();)
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

        for(ListIterator<PTypeComponent> i = this._typeComponents_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PTypeComponent) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._typeArgumentsShrNoGt_ == oldChild)
        {
            setTypeArgumentsShrNoGt((PTypeArgumentsShrNoGt) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
