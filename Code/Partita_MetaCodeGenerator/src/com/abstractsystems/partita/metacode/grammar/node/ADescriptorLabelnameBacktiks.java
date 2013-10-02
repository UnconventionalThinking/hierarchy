/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstractsystems.partita.metacode.grammar.node;

import com.abstractsystems.partita.metacode.grammar.analysis.*;

@SuppressWarnings("nls")
public final class ADescriptorLabelnameBacktiks extends PDescriptorLabelnameBacktiks
{
    private TSymbolBacktikText _symbolBacktikText_;

    public ADescriptorLabelnameBacktiks()
    {
        // Constructor
    }

    public ADescriptorLabelnameBacktiks(
        @SuppressWarnings("hiding") TSymbolBacktikText _symbolBacktikText_)
    {
        // Constructor
        setSymbolBacktikText(_symbolBacktikText_);

    }

    @Override
    public Object clone()
    {
        return new ADescriptorLabelnameBacktiks(
            cloneNode(this._symbolBacktikText_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADescriptorLabelnameBacktiks(this);
    }

    public TSymbolBacktikText getSymbolBacktikText()
    {
        return this._symbolBacktikText_;
    }

    public void setSymbolBacktikText(TSymbolBacktikText node)
    {
        if(this._symbolBacktikText_ != null)
        {
            this._symbolBacktikText_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._symbolBacktikText_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._symbolBacktikText_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._symbolBacktikText_ == child)
        {
            this._symbolBacktikText_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._symbolBacktikText_ == oldChild)
        {
            setSymbolBacktikText((TSymbolBacktikText) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
