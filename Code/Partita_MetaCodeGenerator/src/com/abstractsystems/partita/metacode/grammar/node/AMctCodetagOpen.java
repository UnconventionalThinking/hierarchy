/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstractsystems.partita.metacode.grammar.node;

import com.abstractsystems.partita.metacode.grammar.analysis.*;

@SuppressWarnings("nls")
public final class AMctCodetagOpen extends PMctCodetagOpen
{
    private TCodetagOpen _codetagOpen_;
    private PMctAttribute _mctAttribute_;
    private TCodetagEndtoken _codetagEndtoken_;

    public AMctCodetagOpen()
    {
        // Constructor
    }

    public AMctCodetagOpen(
        @SuppressWarnings("hiding") TCodetagOpen _codetagOpen_,
        @SuppressWarnings("hiding") PMctAttribute _mctAttribute_,
        @SuppressWarnings("hiding") TCodetagEndtoken _codetagEndtoken_)
    {
        // Constructor
        setCodetagOpen(_codetagOpen_);

        setMctAttribute(_mctAttribute_);

        setCodetagEndtoken(_codetagEndtoken_);

    }

    @Override
    public Object clone()
    {
        return new AMctCodetagOpen(
            cloneNode(this._codetagOpen_),
            cloneNode(this._mctAttribute_),
            cloneNode(this._codetagEndtoken_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMctCodetagOpen(this);
    }

    public TCodetagOpen getCodetagOpen()
    {
        return this._codetagOpen_;
    }

    public void setCodetagOpen(TCodetagOpen node)
    {
        if(this._codetagOpen_ != null)
        {
            this._codetagOpen_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._codetagOpen_ = node;
    }

    public PMctAttribute getMctAttribute()
    {
        return this._mctAttribute_;
    }

    public void setMctAttribute(PMctAttribute node)
    {
        if(this._mctAttribute_ != null)
        {
            this._mctAttribute_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mctAttribute_ = node;
    }

    public TCodetagEndtoken getCodetagEndtoken()
    {
        return this._codetagEndtoken_;
    }

    public void setCodetagEndtoken(TCodetagEndtoken node)
    {
        if(this._codetagEndtoken_ != null)
        {
            this._codetagEndtoken_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._codetagEndtoken_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._codetagOpen_)
            + toString(this._mctAttribute_)
            + toString(this._codetagEndtoken_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._codetagOpen_ == child)
        {
            this._codetagOpen_ = null;
            return;
        }

        if(this._mctAttribute_ == child)
        {
            this._mctAttribute_ = null;
            return;
        }

        if(this._codetagEndtoken_ == child)
        {
            this._codetagEndtoken_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._codetagOpen_ == oldChild)
        {
            setCodetagOpen((TCodetagOpen) newChild);
            return;
        }

        if(this._mctAttribute_ == oldChild)
        {
            setMctAttribute((PMctAttribute) newChild);
            return;
        }

        if(this._codetagEndtoken_ == oldChild)
        {
            setCodetagEndtoken((TCodetagEndtoken) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
