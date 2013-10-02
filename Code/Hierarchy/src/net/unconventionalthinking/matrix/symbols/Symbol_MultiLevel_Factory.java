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


import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;
import java.util.List;


/**
 *
 * @author peterjoh
 */
public class Symbol_MultiLevel_Factory {

    SymbolControl symbolControl;

    public Symbol_MultiLevel_Factory(SymbolControl symbolControl) {
        this.symbolControl = symbolControl;
    }



    /** This version takes no matrix name symbol-id. */
    public MatrixName createNew_MatrixName(DescriptorTagName packageName, DescriptorTagName matrixName, boolean creation_Has_StaticVersion)
            throws Exception_InvalidArgumentPassed {
        return createNew_MatrixName(packageName, matrixName, null, creation_Has_StaticVersion);
    }

    public MatrixName createNew_MatrixName(DescriptorTagName packageName, DescriptorTagName matrixName, Integer matrixName_SymbolID,
            boolean creation_Has_StaticVersion)
        throws Exception_InvalidArgumentPassed {

        MatrixName matrixNameFull = symbolControl.matrixName_Index.getMatrixName_ByPackageAndMatrixName(packageName, matrixName);

        if (matrixNameFull == null) {

            if (matrixName_SymbolID == null)
                matrixNameFull = new MatrixName_MultiLevel(packageName, matrixName, creation_Has_StaticVersion);
            else
                matrixNameFull = new MatrixName_MultiLevel(packageName, matrixName, matrixName_SymbolID.intValue(), creation_Has_StaticVersion);

            symbolControl.matrixName_Index.add((Symbol)matrixNameFull);
        }

        //  if you ever try to create a symbol, even one that exists already and try to set the static version
        //  to true, it will stay true (meaning, has_StaticReference is sticky)
        ((Symbol)matrixNameFull).has_StaticReference = ((Symbol)matrixNameFull).has_StaticReference || creation_Has_StaticVersion;

        return matrixNameFull;

    }



    /** This version takes no schema name symbol-id. */
    public MatrixName createNew_SchemaName(DescriptorTagName packageName, DescriptorTagName matrixName, boolean creation_Has_StaticVersion)
            throws Exception_InvalidArgumentPassed {
        return createNew_SchemaName(packageName, matrixName, null, creation_Has_StaticVersion);
    }

    public MatrixName createNew_SchemaName(DescriptorTagName packageName, DescriptorTagName schemaName, Integer schemaName_SymbolID,
            boolean creation_Has_StaticVersion)
        throws Exception_InvalidArgumentPassed {

        MatrixName schemaNameFull = symbolControl.schemaName_Index.getSchemaName_ByPackageAndSchemaName(packageName, schemaName);

        if (schemaNameFull == null) {
            schemaNameFull = new MatrixName_MultiLevel(packageName, schemaName, creation_Has_StaticVersion);

            if (schemaName_SymbolID == null)
                schemaNameFull = new MatrixName_MultiLevel(packageName, schemaName, creation_Has_StaticVersion);
            else
                schemaNameFull = new MatrixName_MultiLevel(packageName, schemaName, schemaName_SymbolID.intValue(), creation_Has_StaticVersion);


            symbolControl.schemaName_Index.add((Symbol)schemaNameFull);
        }

        //  if you ever try to create a symbol, even one that exists already and try to set the static version
        //  to true, it will stay true (meaning, has_StaticReference is sticky)
        ((Symbol)schemaNameFull).has_StaticReference = ((Symbol)schemaNameFull).has_StaticReference || creation_Has_StaticVersion;

        return schemaNameFull;

    }






    /** This version takes the schema name as separate package-name/schema-name descriptor-tag-names. This version also takes no Descriptor Tag symbol-id. */
    public DescriptorTag createNew_DescriptorTag(DescriptorTagName packageName, DescriptorTagName schemaName, DescriptorTagName descTagName, boolean creation_Has_StaticVersion)
            throws Exception_InvalidArgumentPassed {
        return createNew_DescriptorTag(packageName, schemaName, descTagName, null, creation_Has_StaticVersion);
    }
    public DescriptorTag createNew_DescriptorTag(DescriptorTagName packageName, DescriptorTagName schemaName, DescriptorTagName descTagName,
            Integer descTag_SymbolID, boolean creation_Has_StaticVersion)
        throws Exception_InvalidArgumentPassed {
        
        MatrixName schemaNameFull = createNew_SchemaName(packageName, schemaName, creation_Has_StaticVersion);

        return createNew_DescriptorTag(schemaNameFull, descTagName, descTag_SymbolID, creation_Has_StaticVersion);
    }

    
    /** This version takes no Descriptor Tag symbol-id. */
    public DescriptorTag createNew_DescriptorTag(MatrixName schemaNameFull, DescriptorTagName descTagName, boolean creation_Has_StaticVersion)
        throws Exception_InvalidArgumentPassed {
        return createNew_DescriptorTag(schemaNameFull, descTagName, null, creation_Has_StaticVersion);
    }
    public DescriptorTag createNew_DescriptorTag(MatrixName schemaNameFull, DescriptorTagName descTagName, Integer descTag_SymbolID,
            boolean creation_Has_StaticVersion)
        throws Exception_InvalidArgumentPassed {

        DescriptorTag descTag = symbolControl.descTag_Index.getDescriptorTag_BySchemaNameAndDescTagName(schemaNameFull, descTagName);

        if (descTag == null) {
            if (descTag_SymbolID == null)
                descTag = new DescriptorTag_MultiLevel(schemaNameFull, descTagName, creation_Has_StaticVersion);
            else
                descTag = new DescriptorTag_MultiLevel(schemaNameFull, descTagName, descTag_SymbolID, creation_Has_StaticVersion);

            symbolControl.descTag_Index.add((Symbol)descTag);
        }

        //  if you ever try to create a symbol, even one that exists already and try to set the static version
        //  to true, it will stay true (meaning, has_StaticReference is sticky)
        ((Symbol)descTag).has_StaticReference = ((Symbol)descTag).has_StaticReference || creation_Has_StaticVersion;

        return descTag;
    }



    


    /** This version takes no descriptor Path symbol-id. */
    public DescriptorPath createNew_DescriptorPath__usingPathStringList(List<String> descriptorTagName_PathStringList, boolean creation_Has_StaticVersion)
            throws Exception_InvalidArgumentPassed, Exception_MultiPartSymbolAccess {
        return createNew_DescriptorPath__usingPathStringList(descriptorTagName_PathStringList, null, creation_Has_StaticVersion);
    }
    public DescriptorPath createNew_DescriptorPath__usingPathStringList(List<String> descriptorTagName_PathStringList, Integer descPath_SymID,
            boolean creation_Has_StaticVersion)
        throws Exception_InvalidArgumentPassed, Exception_MultiPartSymbolAccess {

        List<Symbol> descriptorTagName_PathList = Symbol_Index_MultiLevel_DescPath.get_DescTagName_SymbolList(descriptorTagName_PathStringList, symbolControl);

        return createNew_DescriptorPath(descriptorTagName_PathList, descPath_SymID, creation_Has_StaticVersion);
    }

    /** This version takes no descriptor path symbol-id. */
    public DescriptorPath createNew_DescriptorPath(List<Symbol> descriptorTagName_PathList, boolean creation_Has_StaticVersion)
        throws Exception_InvalidArgumentPassed {
        return createNew_DescriptorPath(descriptorTagName_PathList, null, creation_Has_StaticVersion);
    }
    public DescriptorPath createNew_DescriptorPath(List<Symbol> descriptorTagName_PathList, Integer descPath_SymID, boolean creation_Has_StaticVersion)
        throws Exception_InvalidArgumentPassed {
        
        DescriptorPath descPath = symbolControl.descPath_Index.get_byDescTagName_PathList(descriptorTagName_PathList, symbolControl);

        if (descPath == null) {
            if (descPath_SymID == null)
                descPath = new DescriptorPath_MultiLevel(descriptorTagName_PathList, creation_Has_StaticVersion);
            else
                descPath = new DescriptorPath_MultiLevel(descriptorTagName_PathList, descPath_SymID, creation_Has_StaticVersion);

            symbolControl.descPath_Index.add((Symbol)descPath);
        }

        //  if you ever try to create a symbol, even one that exists already and try to set the static version
        //  to true, it will stay true (meaning, has_StaticReference is sticky)
        ((Symbol)descPath).has_StaticReference = ((Symbol)descPath).has_StaticReference || creation_Has_StaticVersion;

        return descPath;
    }






    /** This version takes no schemaPath symbol-id. */
    public SchemaPath createNew_SchemaPath(MatrixName schemaName, DescriptorPath descPath, boolean creation_Has_StaticVersion)
        throws Exception_InvalidArgumentPassed {
        return createNew_SchemaPath(schemaName, descPath, null, creation_Has_StaticVersion);
    }
    public SchemaPath createNew_SchemaPath(MatrixName schemaName, DescriptorPath descPath, Integer schemaPath_SymID,
            boolean creation_Has_StaticVersion)
        throws Exception_InvalidArgumentPassed {

        SchemaPath schemaPath = symbolControl.schemaPath_Index.get(schemaName, descPath);

        if (schemaPath == null) {
            if (schemaPath_SymID == null)
                schemaPath = new SchemaPath_MultiLevel(schemaName, descPath, creation_Has_StaticVersion);
            else
                schemaPath = new SchemaPath_MultiLevel(schemaName, descPath, schemaPath_SymID, creation_Has_StaticVersion);

            symbolControl.schemaPath_Index.add((Symbol)schemaPath);
        }

        //  if you ever try to create a symbol, even one that exists already and try to set the static version
        //  to true, it will stay true (meaning, has_StaticReference is sticky)
        ((Symbol)schemaPath).has_StaticReference = ((Symbol)schemaPath).has_StaticReference || creation_Has_StaticVersion;

        return schemaPath;
    }


}
