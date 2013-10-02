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

package net.unconventionalthinking.hierarchy.persistence.actions;

/**
 *
 * @author peterjoh
 */
public class CmdActionList {


    public final static CmdAction DescriptorCreate_useSchemaInfo = new CmdAction_DescriptorCreate_useSchemaInfo();
    public final static CmdAction DescriptorSetField_ByIndex = new CmdAction_DescriptorSetField_ByIndex();
    public final static CmdAction DescriptorSetFields = new CmdAction_DescriptorSetFields();
    public final static CmdAction DescriptorAddChildDesc = new CmdAction_DescriptorAddChildDesc();


    public final static CmdAction ObjectCreate = new CmdAction_ObjectCreate();
    public final static CmdAction ObjectCreate_Existing = new CmdAction_ObjectCreate_Existing();


    public final static CmdAction SymbolCreate = new CmdAction_SymbolCreate();
    public final static CmdAction SymbolCreate_Label = new CmdAction_SymbolCreate_Label();
    public final static CmdAction SymbolCreate_DescTagName = new CmdAction_SymbolCreate_DescTagName();
    public final static CmdAction SymbolCreate_DescTag = new CmdAction_SymbolCreate_DescTag();
    public final static CmdAction SymbolCreate_MatrixName = new CmdAction_SymbolCreate_MatrixName();
    public final static CmdAction SymbolCreate_SchemaName = new CmdAction_SymbolCreate_SchemaName();
    public final static CmdAction SymbolCreate_DescPath = new CmdAction_SymbolCreate_DescPath();
    public final static CmdAction SymbolCreate_SchemaPath = new CmdAction_SymbolCreate_SchemaPath();


    public final static CmdAction CloseCommand = new CmdAction_CloseCommand();


}
