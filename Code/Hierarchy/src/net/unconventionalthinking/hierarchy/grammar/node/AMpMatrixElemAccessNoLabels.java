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
public final class AMpMatrixElemAccessNoLabels extends PMatrixElemAccessNoLabels
{
    private PMatrixElementName _matrixElementName_;
    private final LinkedList<PMatrixElemAccessNoLabelsChildren> _matrixElemAccessNoLabelsChildren_ = new LinkedList<PMatrixElemAccessNoLabelsChildren>();

    public AMpMatrixElemAccessNoLabels()
    {
        // Constructor
    }

    public AMpMatrixElemAccessNoLabels(
        @SuppressWarnings("hiding") PMatrixElementName _matrixElementName_,
        @SuppressWarnings("hiding") List<PMatrixElemAccessNoLabelsChildren> _matrixElemAccessNoLabelsChildren_)
    {
        // Constructor
        setMatrixElementName(_matrixElementName_);

        setMatrixElemAccessNoLabelsChildren(_matrixElemAccessNoLabelsChildren_);

    }

    @Override
    public Object clone()
    {
        return new AMpMatrixElemAccessNoLabels(
            cloneNode(this._matrixElementName_),
            cloneList(this._matrixElemAccessNoLabelsChildren_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMpMatrixElemAccessNoLabels(this);
    }

    public PMatrixElementName getMatrixElementName()
    {
        return this._matrixElementName_;
    }

    public void setMatrixElementName(PMatrixElementName node)
    {
        if(this._matrixElementName_ != null)
        {
            this._matrixElementName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._matrixElementName_ = node;
    }

    public LinkedList<PMatrixElemAccessNoLabelsChildren> getMatrixElemAccessNoLabelsChildren()
    {
        return this._matrixElemAccessNoLabelsChildren_;
    }

    public void setMatrixElemAccessNoLabelsChildren(List<PMatrixElemAccessNoLabelsChildren> list)
    {
        this._matrixElemAccessNoLabelsChildren_.clear();
        this._matrixElemAccessNoLabelsChildren_.addAll(list);
        for(PMatrixElemAccessNoLabelsChildren e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._matrixElementName_)
            + toString(this._matrixElemAccessNoLabelsChildren_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._matrixElementName_ == child)
        {
            this._matrixElementName_ = null;
            return;
        }

        if(this._matrixElemAccessNoLabelsChildren_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._matrixElementName_ == oldChild)
        {
            setMatrixElementName((PMatrixElementName) newChild);
            return;
        }

        for(ListIterator<PMatrixElemAccessNoLabelsChildren> i = this._matrixElemAccessNoLabelsChildren_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PMatrixElemAccessNoLabelsChildren) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}
