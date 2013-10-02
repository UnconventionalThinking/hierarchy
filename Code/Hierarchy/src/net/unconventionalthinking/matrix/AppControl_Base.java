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

import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.matrix.symbols.Exception_SymbolCreation;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author peterjoh
 */
public abstract class AppControl_Base {

	private static AtomicBoolean initializationFinished = new AtomicBoolean(false);

    protected boolean is_ExternalAppControl;
    protected boolean running_AppControl_forMetacompilation;


	public SymbolControl symbolControl;
	public SchemaControl schemaControl;
	public MatrixControl matrixControl;

	public ExecutionInfo executionInfo;

    public List<Class>   externalAppControl_ClassList;

	public Map<Symbol, Constructor> fieldSetTupleSpecialized_Constructor_Index;
	public Map<String, Class>       fieldSetTupleSpecialized_ExternalFieldSets_Index__fromClassName_to_ClassObj;

    public static boolean getInitializationFinished() {
        return initializationFinished.get();
    }




    public boolean is_ExternalAppControl() { return is_ExternalAppControl; }

    public abstract void initialize_ExternalAppControls_List();
	public abstract void initialize_Symbols() throws Exception_SymbolCreation;
    public abstract void initialize_AppObjects()
            throws Exception_Descriptor, Exception_InvalidArgumentPassed, Exception_SchemaInfo, Exception_MatrixRuntime_Checked;


    
    public SymbolControl getSymbolControl() { return symbolControl;}
    public SchemaControl getSchemaControl() { return schemaControl; }
    public MatrixControl getMatrixControl() { return matrixControl; }

    public ExecutionInfo getExecutionInfo() { return executionInfo; }

    public List<Class> get_ExternalAppControl_ClassList() { return externalAppControl_ClassList; }
    public boolean running_AppControl_forMetacompilation() { return running_AppControl_forMetacompilation;}

    
    public Map<Symbol, Constructor> get_FieldSetTupleSpecialized_Constructor_Index() { return fieldSetTupleSpecialized_Constructor_Index; }
    public Map<String, Class>       get_FieldSetTupleSpecialized_ExternalFieldSets_Index__fromClassName_to_ClassObj() {
        return fieldSetTupleSpecialized_ExternalFieldSets_Index__fromClassName_to_ClassObj;
    }




}
