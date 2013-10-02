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

import net.unconventionalthinking.hierarchy.grammar.analysis.*;

@SuppressWarnings("nls")
public final class AIfThenElseStatement extends PIfThenElseStatement
{
    private TIf _if_;
    private TLPar _lPar_;
    private PExpression _expression_;
    private TRPar _rPar_;
    private PStatementNoShortIf _thenStmt_;
    private TElse _else_;
    private PStatement _elseStmt_;

    public AIfThenElseStatement()
    {
        // Constructor
    }

    public AIfThenElseStatement(
        @SuppressWarnings("hiding") TIf _if_,
        @SuppressWarnings("hiding") TLPar _lPar_,
        @SuppressWarnings("hiding") PExpression _expression_,
        @SuppressWarnings("hiding") TRPar _rPar_,
        @SuppressWarnings("hiding") PStatementNoShortIf _thenStmt_,
        @SuppressWarnings("hiding") TElse _else_,
        @SuppressWarnings("hiding") PStatement _elseStmt_)
    {
        // Constructor
        setIf(_if_);

        setLPar(_lPar_);

        setExpression(_expression_);

        setRPar(_rPar_);

        setThenStmt(_thenStmt_);

        setElse(_else_);

        setElseStmt(_elseStmt_);

    }

    @Override
    public Object clone()
    {
        return new AIfThenElseStatement(
            cloneNode(this._if_),
            cloneNode(this._lPar_),
            cloneNode(this._expression_),
            cloneNode(this._rPar_),
            cloneNode(this._thenStmt_),
            cloneNode(this._else_),
            cloneNode(this._elseStmt_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIfThenElseStatement(this);
    }

    public TIf getIf()
    {
        return this._if_;
    }

    public void setIf(TIf node)
    {
        if(this._if_ != null)
        {
            this._if_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._if_ = node;
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

    public PExpression getExpression()
    {
        return this._expression_;
    }

    public void setExpression(PExpression node)
    {
        if(this._expression_ != null)
        {
            this._expression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression_ = node;
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

    public PStatementNoShortIf getThenStmt()
    {
        return this._thenStmt_;
    }

    public void setThenStmt(PStatementNoShortIf node)
    {
        if(this._thenStmt_ != null)
        {
            this._thenStmt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._thenStmt_ = node;
    }

    public TElse getElse()
    {
        return this._else_;
    }

    public void setElse(TElse node)
    {
        if(this._else_ != null)
        {
            this._else_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._else_ = node;
    }

    public PStatement getElseStmt()
    {
        return this._elseStmt_;
    }

    public void setElseStmt(PStatement node)
    {
        if(this._elseStmt_ != null)
        {
            this._elseStmt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._elseStmt_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._if_)
            + toString(this._lPar_)
            + toString(this._expression_)
            + toString(this._rPar_)
            + toString(this._thenStmt_)
            + toString(this._else_)
            + toString(this._elseStmt_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._if_ == child)
        {
            this._if_ = null;
            return;
        }

        if(this._lPar_ == child)
        {
            this._lPar_ = null;
            return;
        }

        if(this._expression_ == child)
        {
            this._expression_ = null;
            return;
        }

        if(this._rPar_ == child)
        {
            this._rPar_ = null;
            return;
        }

        if(this._thenStmt_ == child)
        {
            this._thenStmt_ = null;
            return;
        }

        if(this._else_ == child)
        {
            this._else_ = null;
            return;
        }

        if(this._elseStmt_ == child)
        {
            this._elseStmt_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._if_ == oldChild)
        {
            setIf((TIf) newChild);
            return;
        }

        if(this._lPar_ == oldChild)
        {
            setLPar((TLPar) newChild);
            return;
        }

        if(this._expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
            return;
        }

        if(this._rPar_ == oldChild)
        {
            setRPar((TRPar) newChild);
            return;
        }

        if(this._thenStmt_ == oldChild)
        {
            setThenStmt((PStatementNoShortIf) newChild);
            return;
        }

        if(this._else_ == oldChild)
        {
            setElse((TElse) newChild);
            return;
        }

        if(this._elseStmt_ == oldChild)
        {
            setElseStmt((PStatement) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
