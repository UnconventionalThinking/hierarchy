/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstractsystems.partita.metacode.grammar.node;

import com.abstractsystems.partita.metacode.grammar.analysis.*;

@SuppressWarnings("nls")
public final class ASingleMctCodetagOptions extends PMctCodetagOptions
{
    private PMctAttribtagSingle _mctAttribtagSingle_;

    public ASingleMctCodetagOptions()
    {
        // Constructor
    }

    public ASingleMctCodetagOptions(
        @SuppressWarnings("hiding") PMctAttribtagSingle _mctAttribtagSingle_)
    {
        // Constructor
        setMctAttribtagSingle(_mctAttribtagSingle_);

    }

    @Override
    public Object clone()
    {
        return new ASingleMctCodetagOptions(
            cloneNode(this._mctAttribtagSingle_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASingleMctCodetagOptions(this);
    }

    public PMctAttribtagSingle getMctAttribtagSingle()
    {
        return this._mctAttribtagSingle_;
    }

    public void setMctAttribtagSingle(PMctAttribtagSingle node)
    {
        if(this._mctAttribtagSingle_ != null)
        {
            this._mctAttribtagSingle_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mctAttribtagSingle_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._mctAttribtagSingle_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._mctAttribtagSingle_ == child)
        {
            this._mctAttribtagSingle_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._mctAttribtagSingle_ == oldChild)
        {
            setMctAttribtagSingle((PMctAttribtagSingle) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
