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
public final class AIdentifierSwitchStatement extends PSwitchStatement
{
    private TSwitch _switch_;
    private TLPar _lPar_;
    private TIdentifier _identifier_;
    private final LinkedList<PAdditionalIdentifier> _additionalIdentifiers_ = new LinkedList<PAdditionalIdentifier>();
    private TRPar _rPar_;
    private PSwitchBlock _switchBlock_;

    public AIdentifierSwitchStatement()
    {
        // Constructor
    }

    public AIdentifierSwitchStatement(
        @SuppressWarnings("hiding") TSwitch _switch_,
        @SuppressWarnings("hiding") TLPar _lPar_,
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") List<PAdditionalIdentifier> _additionalIdentifiers_,
        @SuppressWarnings("hiding") TRPar _rPar_,
        @SuppressWarnings("hiding") PSwitchBlock _switchBlock_)
    {
        // Constructor
        setSwitch(_switch_);

        setLPar(_lPar_);

        setIdentifier(_identifier_);

        setAdditionalIdentifiers(_additionalIdentifiers_);

        setRPar(_rPar_);

        setSwitchBlock(_switchBlock_);

    }

    @Override
    public Object clone()
    {
        return new AIdentifierSwitchStatement(
            cloneNode(this._switch_),
            cloneNode(this._lPar_),
            cloneNode(this._identifier_),
            cloneList(this._additionalIdentifiers_),
            cloneNode(this._rPar_),
            cloneNode(this._switchBlock_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIdentifierSwitchStatement(this);
    }

    public TSwitch getSwitch()
    {
        return this._switch_;
    }

    public void setSwitch(TSwitch node)
    {
        if(this._switch_ != null)
        {
            this._switch_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._switch_ = node;
    }

    public TLPar getLPar()
    {
        return this._lPar_;
    }

    public void setLPar(TLPar node)
    {
        if(this._lPar_ != null)
        {
            this._lPar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lPar_ = node;
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

    public TRPar getRPar()
    {
        return this._rPar_;
    }

    public void setRPar(TRPar node)
    {
        if(this._rPar_ != null)
        {
            this._rPar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rPar_ = node;
    }

    public PSwitchBlock getSwitchBlock()
    {
        return this._switchBlock_;
    }

    public void setSwitchBlock(PSwitchBlock node)
    {
        if(this._switchBlock_ != null)
        {
            this._switchBlock_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._switchBlock_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._switch_)
            + toString(this._lPar_)
            + toString(this._identifier_)
            + toString(this._additionalIdentifiers_)
            + toString(this._rPar_)
            + toString(this._switchBlock_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._switch_ == child)
        {
            this._switch_ = null;
            return;
        }

        if(this._lPar_ == child)
        {
            this._lPar_ = null;
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

        if(this._rPar_ == child)
        {
            this._rPar_ = null;
            return;
        }

        if(this._switchBlock_ == child)
        {
            this._switchBlock_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._switch_ == oldChild)
        {
            setSwitch((TSwitch) newChild);
            return;
        }

        if(this._lPar_ == oldChild)
        {
            setLPar((TLPar) newChild);
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

        if(this._rPar_ == oldChild)
        {
            setRPar((TRPar) newChild);
            return;
        }

        if(this._switchBlock_ == oldChild)
        {
            setSwitchBlock((PSwitchBlock) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
