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

package net.unconventionalthinking.hierarchy.persistence;

import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.lang.Integer_Mutable;
import net.unconventionalthinking.matrix.Descriptor;
import net.unconventionalthinking.matrix.MatrixSet;
import net.unconventionalthinking.matrix.SchemaInfo_Descriptor;
import net.unconventionalthinking.matrix.SchemaInfo_Schema;
import net.unconventionalthinking.matrix.symbols.DescriptorPath;
import net.unconventionalthinking.matrix.symbols.DescriptorTag;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.MatrixName;
import net.unconventionalthinking.matrix.symbols.SchemaPath;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.SymbolType;
import net.unconventionalthinking.matrix.symbols.Symbol_Base;
import net.unconventionalthinking.matrix.utilities.TypeUtilities;
import net.unconventionalthinking.hierarchy.SchemaSet_ScopeStack;
import net.unconventionalthinking.utilities.IdCreator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author peterjoh
 */
public class CommandEncoder {

    private IdCreator cmdId_Creator;
    private IdCreator logVarId_Creator;
    private ExecutionInfo executeInfo;
    private UpdateLog_Writer updateLog_Writer;

    public CommandEncoder(UpdateLog_Writer updateLog_Writer) throws IOException {
        this.cmdId_Creator = new IdCreator();
        this.logVarId_Creator = new IdCreator();
        this.updateLog_Writer = updateLog_Writer;

        this.executeInfo = new ExecutionInfo();
    }


    
    //  ________________________________________________________________________________________________________________
    //
    //    Descriptor Commands
    //  ________________________________________________________________________________________________________________


    /**
     * DCSi:<cmdid>:<desc id>=(<schema path id>, <symbol id>, <uses_SchemaSet id>, <parentDescriptor id>);
     *
     * ex:
     *      DC:1:%d25=(%sdt12,%sl22,%uss23,%d17);
     */
    public int DescriptorCreate_useSchemaInfo(Integer_Mutable logVarID_OUT, SchemaInfo_Descriptor schemaInfo_Positioned, Label label,
            MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor, int descID) throws IOException {

        int cmdID = cmdId_Creator.getAndInc_ID();

        DescriptorCreate_useSchemaInfo(logVarID_OUT, schemaInfo_Positioned, label, uses_SchemaSet, parentDescriptor, descID, cmdID);

        return cmdID;
    }

    /**
     * @param cmdID  pass in the cmd id
     * @return
     */
    public int DescriptorCreate_useSchemaInfo(Integer_Mutable logVarID_OUT, SchemaInfo_Descriptor schemaInfo_Positioned, Label label,
            MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor, int descID, int cmdID) throws IOException {


        Integer_Mutable schemaPath_logVarID = new Integer_Mutable();
        SymbolCreate_SchemaPath(schemaPath_logVarID, schemaInfo_Positioned, cmdID);

        Integer_Mutable label_logVarID = new Integer_Mutable();
        if (label != null) {
            SymbolCreate_Label(label_logVarID, label, cmdID);
        }

        Object[] methodParams = new Object[] {schemaPath_logVarID.value, label_logVarID.value, null,
                new Integer(parentDescriptor.descriptorID), new Integer(descID)};

        updateLog_Writer.writeCommand_Method(new Command(CommandType.DescriptorCreate_useSchemaInfo, cmdID, descID, methodParams));


        logVarID_OUT.value = new Integer(descID);
        return cmdID;
    }

    /**
     * I think this method can only be used directly with an AddChildDescriptor command, because you won't have the schemaSetScopeStack otherwise.
     * Make this private for now. Maybe it's not even used.
     *
     * DCSS:<cmdid>:<desc id>=(<descTag>, <symbol>, <uses_SchemaSet>, <parentDescriptor>);
     *
     * ex:
     *      DC:1:%d25=(%sdt12,%sl22,%uss23,%d17);
     */
    int DescriptorCreate_useSchemaSetScopeStack(Integer_Mutable logVarID_OUT, DescriptorTag descTag, Label label, MatrixSet<SchemaInfo_Schema> uses_SchemaSet, Descriptor parentDescriptor,
            SchemaSet_ScopeStack schemaSet_ScopeStack, int descID) {
        throw new UnsupportedOperationException("DescriptorCreate_useSchemaSetScopeStack not supported yet!");
    }




    /**
     * DescriptorSetField_byIndex()
     *
     * DSfI:<cmdid>:<desc id>=(<fieldIndex>, <object log var id>);
     *
     */
    public int DescriptorSetField_byIndex(Descriptor fieldSet_Desc, int index, Object value, Symbol typeSymbol) throws IOException {
        int cmdID = cmdId_Creator.getAndInc_ID();
        DescriptorSetField_byIndex(fieldSet_Desc, index, value, typeSymbol, cmdID);
        return cmdID;
    }
    public int DescriptorSetField_byIndex(Descriptor fieldSet_Desc, int index, Object value, Symbol typeSymbol, int cmdID) throws IOException {

        Integer_Mutable value_LogVarID = new Integer_Mutable();
        if (typeSymbol == null ||  !TypeUtilities.is_SymbolType(typeSymbol)) {
            // java object or primitive type (primitive types are wrapped in PrimitiveType object)
            ObjectCreate(value_LogVarID, value, cmdID);

        } else { // symbol type
            if (typeSymbol == MPSymbols.Symbol)
                SymbolCreate(value_LogVarID, (Symbol)value, cmdID);
            else if (typeSymbol == MPSymbols.Label)
                SymbolCreate_Label(value_LogVarID, (Label)value, cmdID);
            else if (typeSymbol == MPSymbols.DescriptorTagName)
                SymbolCreate_DescTagName(value_LogVarID, (DescriptorTagName)value, cmdID);
            else if (typeSymbol == MPSymbols.DescriptorTag)
                SymbolCreate_DescTag(value_LogVarID, (DescriptorTag)value, cmdID);
            else if (typeSymbol == MPSymbols.MatrixName)
                SymbolCreate_MatrixOrSchemaName(false, value_LogVarID, (MatrixName)value, cmdID);
            else if (typeSymbol == MPSymbols.SchemaName)
                SymbolCreate_MatrixOrSchemaName(true, value_LogVarID, (MatrixName)value, cmdID);
            else if (typeSymbol == MPSymbols.DescriptorPath)
                SymbolCreate_DescriptorPath(value_LogVarID, (DescriptorPath)value, cmdID);
            else if (typeSymbol == MPSymbols.SchemaPath)
                SymbolCreate_SchemaPath(value_LogVarID, (SchemaPath)value, cmdID);
            else {
                throw new ExceptRuntime_PersistenceManagerError("While trying to do a DescriptorSetField_byIndex log operation, tried to do a set on a symbol type." +
                        " The type you passed in was supposed to be a symbol, but the symbol type was not found. This usually means that the symbol id's are not correct (meaning somehow, two sets of the same symbols (with different id's) have been created. ");
            }


        } 


        Object[] methodParams = new Object[] { new Integer(index), new Integer(value_LogVarID.value)};

        updateLog_Writer.writeCommand_Method(new Command(CommandType.DescriptorSetField_byIndex, cmdID, fieldSet_Desc.descriptorID, methodParams));


        return cmdID;
    }





    public int DescriptorAddChildDesc(int parentDescID, int childDescID) throws IOException {
        int cmdID = cmdId_Creator.getAndInc_ID();
        DescriptorAddChildDesc(parentDescID, childDescID, cmdID);
        return cmdID;
    }
    public int DescriptorAddChildDesc(int parentDescID, int childDescID, int cmdID) throws IOException {


        Object[] methodParams = new Object[] { new Integer(childDescID)};

        updateLog_Writer.writeCommand_Method(new Command(CommandType.DescriptorAddChildDesc, cmdID, parentDescID, methodParams));

        return cmdID;
    }









    //  ________________________________________________________________________________________________________________
    //
    //    Object Commands
    //  ________________________________________________________________________________________________________________



    public int ObjectCreate(Integer_Mutable logVarID_OUT, Object value) throws IOException {
        int cmdID = cmdId_Creator.getAndInc_ID();
        ObjectCreate(logVarID_OUT, value, cmdID);
        return cmdID;
    }
    public int ObjectCreate(Integer_Mutable logVarID_OUT, Object value, int cmdID) throws IOException {
        int logVarID = logVarId_Creator.getAndInc_ID();
        logVarID_OUT.value = new Integer(logVarID);


        updateLog_Writer.writeCommand_ObjectCreate(new Command(CommandType.ObjectCreate, cmdID, logVarID, value, null));

        return cmdID;
    }


    

    //  ________________________________________________________________________________________________________________
    //
    //    Symbol Commands
    //  ________________________________________________________________________________________________________________

    public int SymbolCreate(Integer_Mutable logVarID_OUT, Symbol label) throws IOException {
        int cmdID = cmdId_Creator.getAndInc_ID();
        SymbolCreate_Worker(SymbolType.Symbol, CommandType.SymbolCreate, logVarID_OUT, (Symbol) label, cmdID);
        return cmdID;
    }

    public int SymbolCreate(Integer_Mutable logVarID_OUT, Symbol label, int cmdID) throws IOException {
        return SymbolCreate_Worker(SymbolType.Symbol, CommandType.SymbolCreate, logVarID_OUT, (Symbol) label, cmdID);
    }

    public int SymbolCreate_Label(Integer_Mutable logVarID_OUT, Label label) throws IOException {
        int cmdID = cmdId_Creator.getAndInc_ID();
        SymbolCreate_Worker(SymbolType.Label, CommandType.SymbolCreate_Label, logVarID_OUT, (Symbol) label, cmdID);
        return cmdID;
    }

    public int SymbolCreate_Label(Integer_Mutable logVarID_OUT, Label label, int cmdID) throws IOException {
        return SymbolCreate_Worker(SymbolType.Label, CommandType.SymbolCreate_Label, logVarID_OUT, (Symbol) label, cmdID);
    }

    public int SymbolCreate_DescTagName(Integer_Mutable logVarID_OUT, Label descTagName) throws IOException {
        int cmdID = cmdId_Creator.getAndInc_ID();
        SymbolCreate_Worker(SymbolType.DescriptorTagName, CommandType.SymbolCreate_DescTagName, logVarID_OUT, (Symbol) descTagName, cmdID);
        return cmdID;
    }

    public int SymbolCreate_DescTagName(Integer_Mutable logVarID_OUT, DescriptorTagName descTagName, int cmdID) throws IOException {
        return SymbolCreate_Worker(SymbolType.DescriptorTagName, CommandType.SymbolCreate_DescTagName, logVarID_OUT, (Symbol) descTagName, cmdID);
    }

    private int SymbolCreate_Worker(SymbolType symbolType, CommandType commandType, Integer_Mutable logVarID_OUT, Symbol symbol, int cmdID)
            throws IOException {

        int logVarID = logVarId_Creator.getAndInc_ID();
        logVarID_OUT.value = new Integer(logVarID);


        // create a list of the symbol parts
        int numParts = symbol.getNumOfParts();
        Object[] methodParams = new Object[numParts];

        for (int i = 1; i <= numParts; i++) {
            methodParams[i - 1] = symbol.getSymbol_AtPartNum(i).name_no_backtiks;
        }


        updateLog_Writer.writeCommand_Method(new Command(commandType, cmdID, logVarID, methodParams));

        return cmdID;

    }

    public int SymbolCreate_DescTag(Integer_Mutable logVarID_OUT, DescriptorTag descTag)
            throws IOException {
        int cmdID = cmdId_Creator.getAndInc_ID();
        SymbolCreate_DescTag(logVarID_OUT, descTag, cmdID);
        return cmdID;
    }

    public int SymbolCreate_DescTag(Integer_Mutable logVarID_OUT, DescriptorTag descTag, int cmdID)
            throws IOException {

        int logVarID = logVarId_Creator.getAndInc_ID();
        logVarID_OUT.value = new Integer(logVarID);


        Integer_Mutable schemaName_LogVarID = new Integer_Mutable();
        SymbolCreate_MatrixOrSchemaName(true, schemaName_LogVarID, descTag.getSchemaName_Full(), cmdID);

        Integer_Mutable descTagName_LogVarID = new Integer_Mutable();
        SymbolCreate_DescTagName(descTagName_LogVarID, descTag.getDescTagName(), cmdID);

        Object[] methodParams = new Object[] {schemaName_LogVarID.value, descTagName_LogVarID.value};

        updateLog_Writer.writeCommand_Method(new Command(CommandType.SymbolCreate_DescTag, cmdID, logVarID,
                methodParams));


        return cmdID;
    }

    public int SymbolCreate_MatrixOrSchemaName(boolean create_SchemaName, Integer_Mutable logVarID_OUT, MatrixName matrixOrSchemaName)
            throws IOException {
        int cmdID = cmdId_Creator.getAndInc_ID();
        SymbolCreate_MatrixOrSchemaName(create_SchemaName, logVarID_OUT, matrixOrSchemaName, cmdID);
        closeCommand(cmdID);
        return cmdID;
    }

    public int SymbolCreate_MatrixOrSchemaName(boolean create_SchemaName, Integer_Mutable logVarID_OUT, MatrixName matrixOrSchemaName, int cmdID)
            throws IOException {

        CommandType commandType = null;
        if (create_SchemaName) {
            commandType = CommandType.SymbolCreate_SchemaName;
        } else {
            commandType = CommandType.SymbolCreate_MatrixName;
        }


        int logVarID = logVarId_Creator.getAndInc_ID();
        logVarID_OUT.value = new Integer(logVarID);


        Integer_Mutable packageName_logVarID = new Integer_Mutable();
        SymbolCreate_DescTagName(packageName_logVarID, matrixOrSchemaName.getPackageName(), cmdID);

        Integer_Mutable matrixOrSchemaName_logVarID = new Integer_Mutable();
        SymbolCreate_DescTagName(matrixOrSchemaName_logVarID, matrixOrSchemaName.getMatrixName(), cmdID);

        Object[] methodParams = new Object[] {packageName_logVarID.value, matrixOrSchemaName_logVarID.value};

        updateLog_Writer.writeCommand_Method(new Command(commandType, cmdID, logVarID,methodParams));


        return cmdID;
    }




    public int SymbolCreate_DescriptorPath(Integer_Mutable descriptorPath_logVarID_OUT, DescriptorPath descPath)
            throws IOException {
        int cmdID = cmdId_Creator.getAndInc_ID();
        SymbolCreate_DescriptorPath(descriptorPath_logVarID_OUT, descPath, cmdID);
        return cmdID;
    }

    public int SymbolCreate_DescriptorPath(Integer_Mutable logVarID_OUT, DescriptorPath descPath,
            int cmdID) throws IOException {

        throw new UnsupportedOperationException("this operation not yet implemented!");
    }

    public int SymbolCreate_DescriptorPath(Integer_Mutable descriptorPath_logVarID_OUT, SchemaInfo_Descriptor schemaInfo_Positioned)
            throws IOException {
        int cmdID = cmdId_Creator.getAndInc_ID();
        SymbolCreate_DescriptorPath(descriptorPath_logVarID_OUT, schemaInfo_Positioned, cmdID);
        return cmdID;
    }

    public int SymbolCreate_DescriptorPath(Integer_Mutable logVarID_OUT, SchemaInfo_Descriptor schemaInfo_Positioned,
            int cmdID) throws IOException {


        int logVarID = logVarId_Creator.getAndInc_ID();
        logVarID_OUT.value = new Integer(logVarID);


        // get the descTag path for the schema Element
        List<Symbol_Base> descTagPath_List = new ArrayList<Symbol_Base>();
        schemaInfo_Positioned.getSchemaInfo_DescTagName_FullPath(executeInfo, descTagPath_List);


        Object[] methodParams = new Object[descTagPath_List.size()];

        boolean isFirstIter = true;
        for(int i = 0; i < descTagPath_List.size(); ++i) {
            
            if (isFirstIter) { 
                //  The first element of the path returned from the getSchemaInfo_DescTagName_FullPath() is the schemaName (which is MatrixName obj).
                //  But, we need just the descriptorTagName
                methodParams[i] = ((MatrixName)descTagPath_List.get(i)).getMatrixName().get_Name_no_backtiks();
                isFirstIter = false;

            } else {
                methodParams[i] = descTagPath_List.get(i).get_Name_no_backtiks();
            }
        }


        updateLog_Writer.writeCommand_Method(new Command(CommandType.SymbolCreate_DescPath, cmdID, logVarID, methodParams));

        return cmdID;

    }



    
    public int SymbolCreate_SchemaPath(Integer_Mutable schemaPath_logVarID, SchemaPath schemaPath) throws IOException {
        int cmdID = cmdId_Creator.getAndInc_ID();
        SymbolCreate_SchemaPath(schemaPath_logVarID, schemaPath, cmdID);
        return cmdID;
    }
    public int SymbolCreate_SchemaPath(Integer_Mutable logVarID_OUT, SchemaPath schemaPath, int cmdID) throws IOException {
        throw new UnsupportedOperationException("this operation not yet implemented!");

    }

    
    public int SymbolCreate_SchemaPath(Integer_Mutable schemaPath_logVarID, SchemaInfo_Descriptor schemaInfo_Positioned) throws IOException {
        int cmdID = cmdId_Creator.getAndInc_ID();
        SymbolCreate_SchemaPath(schemaPath_logVarID, schemaInfo_Positioned, cmdID);
        return cmdID;
    }

    public int SymbolCreate_SchemaPath(Integer_Mutable logVarID_OUT, SchemaInfo_Descriptor schemaInfo_Positioned, int cmdID) throws IOException {

        int logVarID = logVarId_Creator.getAndInc_ID();
        logVarID_OUT.value = new Integer(logVarID);


        Integer_Mutable schemaName_logVarID = new Integer_Mutable();
        SymbolCreate_MatrixOrSchemaName(true, schemaName_logVarID, schemaInfo_Positioned.getSchemaInfo_SchemaNameFull(), cmdID);
        Integer_Mutable descriptorPath_logVarID = new Integer_Mutable();
        SymbolCreate_DescriptorPath(descriptorPath_logVarID, schemaInfo_Positioned, cmdID);

        Object[] methodParams = new Object[] {schemaName_logVarID.value, descriptorPath_logVarID.value};

        updateLog_Writer.writeCommand_Method(new Command(CommandType.SymbolCreate_SchemaPath, cmdID, logVarID, methodParams));

        return cmdID;

    }

    //  ________________________________________________________________________________________________________________
    //
    //    Other Commands
    //  ________________________________________________________________________________________________________________
    public void closeCommand(int cmdID) throws IOException {
        updateLog_Writer.closeCommand(cmdID);
    }


}
