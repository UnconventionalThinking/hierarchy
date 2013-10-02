/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstractsystems.partita.metacode.grammar.node;

import com.abstractsystems.partita.metacode.grammar.analysis.*;

@SuppressWarnings("nls")
public final class APairMctCodetagOptions extends PMctCodetagOptions
{
    private PMctAttribtagPair _mctAttribtagPair_;

    public APairMctCodetagOptions()
    {
        // Constructor
    }

    public APairMctCodetagOptions(
        @SuppressWarnings("hiding") PMctAttribtagPair _mctAttribtagPair_)
    {
        // Constructor
        setMctAttribtagPair(_mctAttribtagPair_);

    }

    @Override
    public Object clone()
    {
        return new APairMctCodetagOptions(
            cloneNode(this._mctAttribtagPair_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPairMctCodetagOptions(this);
    }

    public PMctAttribtagPair getMctAttribtagPair()
    {
        return this._mctAttribtagPair_;
    }

    public void setMctAttribtagPair(PMctAttribtagPair node)
    {
        if(this._mctAttribtagPair_ != null)
        {
            this._mctAttribtagPair_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mctAttribtagPair_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._mctAttribtagPair_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._mctAttribtagPair_ == child)
        {
            this._mctAttribtagPair_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._mctAttribtagPair_ == oldChild)
        {
            setMctAttribtagPair((PMctAttribtagPair) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
