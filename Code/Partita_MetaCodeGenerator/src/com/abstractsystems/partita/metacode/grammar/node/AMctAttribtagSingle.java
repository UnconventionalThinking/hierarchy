/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstractsystems.partita.metacode.grammar.node;

import com.abstractsystems.partita.metacode.grammar.analysis.*;

@SuppressWarnings("nls")
public final class AMctAttribtagSingle extends PMctAttribtagSingle
{
    private TCodetagOpen _codetagOpen_;
    private PMctAttribute _mctAttribute_;
    private TCodetagOpenEndtokenSingle _codetagOpenEndtokenSingle_;

    public AMctAttribtagSingle()
    {
        // Constructor
    }

    public AMctAttribtagSingle(
        @SuppressWarnings("hiding") TCodetagOpen _codetagOpen_,
        @SuppressWarnings("hiding") PMctAttribute _mctAttribute_,
        @SuppressWarnings("hiding") TCodetagOpenEndtokenSingle _codetagOpenEndtokenSingle_)
    {
        // Constructor
        setCodetagOpen(_codetagOpen_);

        setMctAttribute(_mctAttribute_);

        setCodetagOpenEndtokenSingle(_codetagOpenEndtokenSingle_);

    }

    @Override
    public Object clone()
    {
        return new AMctAttribtagSingle(
            cloneNode(this._codetagOpen_),
            cloneNode(this._mctAttribute_),
            cloneNode(this._codetagOpenEndtokenSingle_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMctAttribtagSingle(this);
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

    public TCodetagOpenEndtokenSingle getCodetagOpenEndtokenSingle()
    {
        return this._codetagOpenEndtokenSingle_;
    }

    public void setCodetagOpenEndtokenSingle(TCodetagOpenEndtokenSingle node)
    {
        if(this._codetagOpenEndtokenSingle_ != null)
        {
            this._codetagOpenEndtokenSingle_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._codetagOpenEndtokenSingle_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._codetagOpen_)
            + toString(this._mctAttribute_)
            + toString(this._codetagOpenEndtokenSingle_);
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

        if(this._codetagOpenEndtokenSingle_ == child)
        {
            this._codetagOpenEndtokenSingle_ = null;
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

        if(this._codetagOpenEndtokenSingle_ == oldChild)
        {
            setCodetagOpenEndtokenSingle((TCodetagOpenEndtokenSingle) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
