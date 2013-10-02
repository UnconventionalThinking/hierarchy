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


package net.unconventionalthinking.matrix;

import net.unconventionalthinking.lang.ExecutionInfo;
import java.util.*;
import net.unconventionalthinking.matrix.symbols.*;


/**
 *
 * @author peterjoh
 */
public interface SchemaInfo extends Element {

    enum Type { SchemaInfoSchema, SchemaInfoMatrix, SchemaInfoDescriptor, SchemaInfoFieldSet, SchemaInfoField }


    public void initialize_SchemaInfo(ExecutionInfo executeInfo, SymbolControl symbolControl, SchemaControl_Info schemaControl_Info)
                        throws Exception_SchemaInfo;

    public SchemaInfo getSchemaInfo_ParentSchemaInfo(ExecutionInfo executeInfo);


    public DescriptorTagName getSchemaInfo_DescriptorTagName();

    public void   getSchemaInfo_DescTagName_FullPath(ExecutionInfo executeInfo, List<Symbol_Base> nameSymbols);
    public String getSchemaInfo_DescTagName_FullPath_String(ExecutionInfo executeInfo);
    public String getSchemaInfo_DescTagName_FullPath_IdentFormat(ExecutionInfo executeInfo);


    public SchemaInfo.Type      getSchemaInfo_SchemaInfoType();

    public SchemaInfo_Schema    getSchemaInfo__Ancestor_SchemaInfoSchema();
    public MatrixName           getSchemaInfo_SchemaNameFull();

}