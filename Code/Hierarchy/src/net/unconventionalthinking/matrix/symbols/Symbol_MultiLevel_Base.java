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



package net.unconventionalthinking.matrix.symbols;

/**
 * Can have multie levels, using different separators. And, can ALLOW 3 levels, but use only two For instance:
 *
 *   sym1.child::sym2.child  // has 3 levels
 *   sym1::sym2  // really has only 2 levels (the 2nd level of sym1.<some child sym> is missing)
 *
 * 
 * @author peterjoh
 */
public interface Symbol_MultiLevel_Base extends Symbol_Base {

}
