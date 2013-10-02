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

import net.unconventionalthinking.exceptions.ExceptRuntime_InvalidArgumentPassed;
import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;
import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed_Null;
import net.unconventionalthinking.exceptions.Exception_NotIdentifierFormattedString;
import net.unconventionalthinking.matrix.Exception_Descriptor;
import net.unconventionalthinking.matrix.Matrix;
import net.unconventionalthinking.matrix.MatrixControl;
import net.unconventionalthinking.matrix.SchemaControl;
import net.unconventionalthinking.matrix.SchemaInfo_Schema;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.utilities.TextUtilities;
import org.apache.commons.collections.map.MultiValueMap;


/**
 *
 * @author peterjoh
 */
public class MatrixName_Utilities {


    public static MatrixName create_MatrixName(Label matrixName_Label, DescriptorTagName packageName, boolean matrixName_IsStaticSymbol,
            SymbolControl symbolControl)
        throws Exception_Descriptor {
        try {
            return symbolControl.multiLevelSymbol_Factory.createNew_MatrixName(packageName,
                    SymbolUtilities.convert_Label_to_DescTagName(matrixName_Label, symbolControl), matrixName_IsStaticSymbol);
        } catch (Exception e) {
            throw new Exception_Descriptor("Could not create the Matrix Descriptor. There was a problem creating the MatrixName for it (see inner exception).", e);
        }

    }





    public static MatrixName create_SchemaName(Label schemaName_Label, DescriptorTagName packageName, boolean schemaName_IsStaticSymbol,
            SymbolControl symbolControl)
        throws Exception_Descriptor {
        try {
            return symbolControl.multiLevelSymbol_Factory.createNew_SchemaName(packageName,
                    SymbolUtilities.convert_Label_to_DescTagName(schemaName_Label, symbolControl), schemaName_IsStaticSymbol);
        } catch (Exception e) {
            throw new Exception_Descriptor("Could not create the Schema Descriptor. There was a problem creating the MatrixName object for it (see inner exception).", e);
        }
    }



    public static String convert_MatrixNameWithPackage_to_IdentifierFormat(String matrixName_w_Package) {

        String[] nameParts = matrixName_w_Package.split("::");

        if (nameParts.length != 2)
            throw new ExceptRuntime_InvalidArgumentPassed("tried to convert a Matrix Name with Package to an Identifier, but the matrix name string was not in the correct format (separated by a '::'). The matrix name passed in was: " + matrixName_w_Package);

        StringBuilder name_IdentFormat = new StringBuilder();

        name_IdentFormat.append(nameParts[0]).append('.').append(SymbolUtilities.convert_DescTagNameString_to_Identifier(nameParts[1]));

        return name_IdentFormat.toString();

    }

    /**
     * NOTE: the performance of this method is not as good (not bad, but not high performance). Because needs to build the matrix name from
     * strings.
     */
    public static MatrixName create_MatrixOrSchemaName_FromStrings(String packageName, String matrixSimpleName, boolean isMatrixNameNotSchemaName,
            boolean creation_Has_StaticVersion, SymbolControl symbolControl)
            throws Exception_InvalidArgumentPassed, Exception_MultiPartSymbolAccess, Exception_MultiPartSymbolCreation,
            Exception_MultiPartSymbolCreationOrAccess {

        DescriptorTagName packageDescTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(packageName, 1, creation_Has_StaticVersion,
                null, null);
        DescriptorTagName matrixSimpleName_DescTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(matrixSimpleName, 1, creation_Has_StaticVersion,
                null, null);
        if (isMatrixNameNotSchemaName) {
            return symbolControl.multiLevelSymbol_Factory.createNew_MatrixName(packageDescTagName, matrixSimpleName_DescTagName,
                    creation_Has_StaticVersion);
        } else {
            return symbolControl.multiLevelSymbol_Factory.createNew_SchemaName(packageDescTagName, matrixSimpleName_DescTagName,
                    creation_Has_StaticVersion);
        }
    }


/* not working
    public static String convert_MatrixOrSchema_FullClassName_to_ScopeResolutionFormat(String matrixOrSchema_FullClassName) 
            throws Exception_InvalidArgumentPassed {

        int splitIndex = matrixOrSchema_FullClassName.lastIndexOf(".");
        String packageName_IdentFormat = matrixOrSchema_FullClassName.substring(0, splitIndex);
        String matrixName_IdentFormat = matrixOrSchema_FullClassName.substring(splitIndex + 1, matrixOrSchema_FullClassName.length());

        try {
            return packageName_IdentFormat + "::" + TextUtilities.convertIdentiferToText(matrixName_IdentFormat);
        } catch (Exception e) {
            throw new Exception_InvalidArgumentPassed("Tried to convert the matrix/schema class name into its scope-resolved name, but had an error. The matrix/schema name that was given was: " + matrixOrSchema_FullClassName, e);
        }

    }
 
 */
}
