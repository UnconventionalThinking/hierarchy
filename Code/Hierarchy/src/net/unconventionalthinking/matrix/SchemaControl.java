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
import net.unconventionalthinking.lang.Boolean_Mutable;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.lang.String_Mutable;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.matrix.utilities.TextUtilities;
import net.unconventionalthinking.reflection.DynamicClassUtilities;
import net.unconventionalthinking.reflection.MethodInvoker;
import net.unconventionalthinking.utilities.ListUtilities;
import java.lang.reflect.Constructor;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import org.apache.commons.collections.map.MultiValueMap;



/**
 *
 * @author peterjoh
 */
public class SchemaControl {

    public final SchemaControl_Info schemaControl_Info;

    public final SchemaFactory schemaFactory;
    public final DescriptorControl schema_DescControl;


    public final SchemaForSchema_Container schemaForSchema_Container;
    public final SchemaInfo_Schema schemaForSchema;

    
    //  You can find a schema by using the Schema's schemaName_w_Package object, or by the string version of the schemaName_w_Package.
    Map<MatrixName, SchemaInfo_Schema>          schemaIndex_bySchemaName;
    Map<String, SchemaInfo_Schema>              schemaIndex_bySchemaNameString;

    MultiValueMap                               schemaMultiValueIndex_bySchemaNameSimple_DescTagName;
    MultiValueMap                               schemaMultiValueIndex_bySchemaNameSimple_String;

    Map<MatrixName, SchemaInfo_Schema>          staticSchemaIndex_bySchemaName;


    Map<Symbol, Constructor>    fieldSetTupleSpecialized_Constructor_Index_byTypeSymbol;
	Map<String, Class>          fieldSetTupleSpecialized_ExternalFieldSets_Index__fromClassName_to_ClassObj;

    AppControl_Base             appControl;
    SymbolControl               symbolControl;




    
    public SchemaControl(ExecutionInfo executeInfo, AppControl_Base appControl)
        throws Exception_SchemaInfo, Exception_Descriptor, Exception_InvalidArgumentPassed {
        assert(appControl != null && appControl.symbolControl != null);

        executeInfo.reset();
        this.appControl = appControl;
        this.symbolControl = appControl.symbolControl;
        if (appControl.schemaControl == null)
            appControl.schemaControl = this;

        this.schema_DescControl = new DescriptorControl(symbolControl);

        //  construct the fieldSetTuple specialzied index
        fieldSetTupleSpecialized_Constructor_Index_byTypeSymbol = new HashMap<Symbol, Constructor>();
        fieldSetTupleSpecialized_ExternalFieldSets_Index__fromClassName_to_ClassObj = new HashMap<String, Class>();
        
        schemaControl_Info = new SchemaControl_Info(fieldSetTupleSpecialized_Constructor_Index_byTypeSymbol);

        
        //  Setup schema indexes
        schemaIndex_bySchemaName = new HashMap<MatrixName, SchemaInfo_Schema>();
        schemaIndex_bySchemaNameString = new HashMap<String, SchemaInfo_Schema>();

        schemaMultiValueIndex_bySchemaNameSimple_DescTagName = new MultiValueMap();
        schemaMultiValueIndex_bySchemaNameSimple_String = new MultiValueMap();

        staticSchemaIndex_bySchemaName = new HashMap<MatrixName, SchemaInfo_Schema>();

        
        
        //  Setup schemaForSchema
        schemaForSchema_Container = new SchemaForSchema_Container(executeInfo, schema_DescControl, schemaControl_Info);
        schemaForSchema = schemaForSchema_Container.schema4Schema;
        //  Normally, the schemaFactory would add the new schema to the indexes, but since we're creating the schemaOfSchema outside of the factory,
        //  do it manually.
        schemaIndex_Add(schemaForSchema);

        schemaFactory = new SchemaFactory(schemaForSchema_Container, symbolControl, this);
    }



    public Map<Symbol, Constructor> get_FieldSetTupleSpecialized_Constructor_Index_byTypeSymbol() {
        return fieldSetTupleSpecialized_Constructor_Index_byTypeSymbol;
    }
	public Map<String, Class>      get_FieldSetTupleSpecialized_ExternalFieldSets_Index__fromClassName_to_ClassObj() {
        return fieldSetTupleSpecialized_ExternalFieldSets_Index__fromClassName_to_ClassObj;
    }


    /**
     * Only schemaFactory should be able to add schemas to the schemaIndex.
     *
     * @param schemaName_w_Package
     * @param schema
     */
    void schemaIndex_Add(SchemaInfo_Schema schema) {
        schemaIndex_Add(schema, false);
    }

    /**
     * Only schemaFactory should be able to add schemas to the schemaIndex.
     * 
     * @param schemaName_w_Package
     * @param schema
     * @param is_StaticSchema
     */
    void schemaIndex_Add(SchemaInfo_Schema schema, boolean is_StaticSchema) {

        MatrixName schemaName = schema.getSchemaInfo_SchemaNameFull();
        
        schemaIndex_bySchemaName.put(schemaName, schema);
        schemaIndex_bySchemaNameString.put(((MatrixName_MultiLevel)schemaName).name_no_backtiks, schema);


        schemaMultiValueIndex_bySchemaNameSimple_DescTagName.put(schemaName.getMatrixName(), schema);
        schemaMultiValueIndex_bySchemaNameSimple_String.put(schemaName.getMatrixName().get_Name_no_backtiks(), schema);



        if (is_StaticSchema)
            staticSchemaIndex_bySchemaName.put(schemaName, schema);
    }


    public SchemaInfo_Schema schemaIndex_Find(MatrixName schemaName) {
        return schemaIndex_bySchemaName.get(schemaName);
    }
    public SchemaInfo_Schema schemaIndex_Find(String schemaName_Full) {
        return schemaIndex_bySchemaNameString.get(schemaName_Full);
    }
    public SchemaInfo_Schema schemaIndex_FindStaticSchema(MatrixName schemaName) {
        return staticSchemaIndex_bySchemaName.get(schemaName);
    }
    

    public Collection schemaIndex_Find_bySchemaNameSimple(DescriptorTagName schemaName) {
        return schemaMultiValueIndex_bySchemaNameSimple_DescTagName.getCollection(schemaName);
    }
    public Collection schemaIndex_Find_bySchemaNameSimple(String schemaName) {
        return schemaMultiValueIndex_bySchemaNameSimple_String.getCollection(schemaName);
    }

    public boolean schemaIndex_CheckSchemaIsStatic(MatrixName schemaName) {
        return staticSchemaIndex_bySchemaName.containsKey(schemaName);
    }

    public Iterator<MatrixName> schemaIndex_GetSchemaNamesIterator() {
        return schemaIndex_bySchemaName.keySet().iterator();
    }
    public Iterator<MatrixName> schemaIndex_GetStaticSchemaNamesIterator() {
        return staticSchemaIndex_bySchemaName.keySet().iterator();
    }



    public Collection<SchemaInfo_Schema> schemaIndex_GetSchemas() {
        return schemaIndex_bySchemaName.values();
    }
    public Collection<SchemaInfo_Schema> schemaIndex_GetStaticSchemas() {
        return staticSchemaIndex_bySchemaName.values();
    }


    
    /** Search the classpath for the schema. This method allows you to find schemas that are in the current project's source, or in external jars in
     *  the classpath. <br>
     *  If the schema is an external schema, this method also does all the secondary tasks needed to make sure the schema is ready for use by the
     *  application and the metacompiler. It loads the external schema's appControl, and adds it to necessary schema control indexes. <p>
     *
     *  The format of the schema name is: "my.package::my.schema".
     *   This version takes the packageName and schema name separately.
     *
     * @param OUT_is_ExternalSchema             indicates if the found schema is from an external jar.
     * @param OUT_externalAppControl_FullName   if it is an external schema, this is the full class name of the ext app Control
     */
    public SchemaInfo_Schema classPath__FindSchema(String schemaName, String packageName, List<URL> classPath,
            Boolean_Mutable OUT_is_ExternalSchema, String_Mutable OUT_externalAppControl_FullName) throws MalformedURLException {
        String schemaName_w_Package = packageName + "::" + schemaName;
        return classPath__FindSchema(schemaName_w_Package, classPath, OUT_is_ExternalSchema, OUT_externalAppControl_FullName);
    }

    /** Search the classpath for the schema. This method allows you to find schemas that are in the current project's source, or in external jars 
     *  in the classpath. <br>
     *  If the schema is an external schema, this method also does all the secondary tasks needed to make sure the schema is ready for use by the
     *  application and the metacompiler. It loads the external schema's appControl, and adds it to necessary schema control indexes. <p>
     *
     *  The format of the schema name is: "my.package::my.schema". 
     *
     * @param OUT_is_ExternalSchema             indicates if the found schema is from an external jar.
     * @param OUT_externalAppControl_FullName   if it is an external schema, this is the full class name of the ext app Control
     */
    public SchemaInfo_Schema classPath__FindSchema(String schemaName_w_Package, List<URL> classPath,
            Boolean_Mutable OUT_is_ExternalSchema, String_Mutable OUT_externalAppControl_FullName) throws MalformedURLException {

        String schemaName_IdentFormat = MatrixName_Utilities.convert_MatrixNameWithPackage_to_IdentifierFormat(schemaName_w_Package);
        SchemaInfo_Schema foundSchema = schemaIndex_Find(schemaName_w_Package); // NOTE: use NON-Identifier format for the find

        if (foundSchema == null && DynamicClassUtilities.classPath__ClassExists(classPath, schemaName_IdentFormat)) {

            Class possibleSchemaContainer_ClassObj = null;
            try  {
                possibleSchemaContainer_ClassObj = DynamicClassUtilities.classPath__dynLoadClass(classPath, schemaName_IdentFormat);
            } catch (ClassNotFoundException e) {
                throw new ExceptRuntime_Matrix_GeneralError("Tried to load the schema class, " + schemaName_IdentFormat + ",  that was loaded from an external source (like a jar), but could not load it even though we tested if it existed, and it did. " +
                        "This should not happen.");
            }



            if (SchemaContainer.class.isAssignableFrom(possibleSchemaContainer_ClassObj)) {

                AppControlUtilities.loadAppControl_throughMatrixOrSchema(schemaName_IdentFormat, appControl, classPath,
                        appControl.running_AppControl_forMetacompilation);

                //  the Schema should have been added to the schema indices now:
                foundSchema = schemaIndex_Find(schemaName_w_Package);
                if (foundSchema == null)
                    throw new ExceptRuntime_Matrix_GeneralError("Tried to find a schema object for the schema," + schemaName_w_Package + ", that was loaded from an external source (like a jar), but could not find it. " +
                            "This should not happen, because the app control for the jar should have been initialized, which would create the schema object.");


                try {
                    MatrixContainer matrixContainer = (MatrixContainer)possibleSchemaContainer_ClassObj.newInstance();
                    OUT_is_ExternalSchema.value = true;
                    OUT_externalAppControl_FullName.value = matrixContainer.get_AppControl_Class().getCanonicalName();
                } catch (Exception e) {
                    throw new ExceptRuntime_Matrix_GeneralError("Tried to load the appControl for the external schema class, " + schemaName_w_Package + ",  that was loaded from an external source (like a jar), but could not get its appControl object. " +
                            "This should not happen.");
                }
            }
        } 
        return foundSchema;

    }



    /**
     * This version takes a string for the schema name instead of a descriptor Tag Name<p>
     *
     * Searches to find the full schema name using the simple name, searching through the embedded matrix file's import list.
     * First, it searches the explicit imported schema list.
     * Second, it searches the current package. So, if your current package is "com.mypackage", it will check for "com.mypackage::schemaName_w_Package".
     *
     * @param schemaName_Simple
     * @param curr_PackageName
     * @param schemaNames_FromImports_BySchemaNameSimple
     * @param try_Search_UsingCurrPackageName
     * @param OUT_is_ExternalSchema             indicates if the found schema is from an external jar.
     * @param OUT_externalAppControl_FullName   if it is an external schema, this is the full class name of the ext app Control
     * @return
     * @throws Exception_MetaCompilerError
     */
    public MatrixName find_SchemaName_bySimpleName(String schemaName_Simple, DescriptorTagName curr_PackageName,
            MultiValueMap schemaNames_FromImports_BySchemaNameSimple, boolean try_Search_UsingCurrPackageName, List<URL> classPath,
            Boolean_Mutable OUT_is_ExternalSchema, String_Mutable OUT_externalAppControl_FullName, Boolean_Mutable OUT_is_InCurrentPackage)
        throws Exception_MetaCompilerError {

        DescriptorTagName schemaName_DescTagname = null;
        try {
            schemaName_DescTagname = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(schemaName_Simple, 1, false, null, null);
        } catch (Exception e) {
            throw new Exception_MetaCompilerError("Tried to create a DescriptorTagName symbol for the schema name, " + schemaName_Simple + ", but had an error.", e);
        }
        return find_SchemaName_bySimpleName(schemaName_DescTagname, curr_PackageName, schemaNames_FromImports_BySchemaNameSimple, 
                try_Search_UsingCurrPackageName, classPath, OUT_is_ExternalSchema, OUT_externalAppControl_FullName, OUT_is_InCurrentPackage);
    }
    /**
     * Searches to find the full schema name using the simple name, searching through the embedded matrix file's import list.
     * First, it searches the explicit imported schema list.
     * Second, it searches the current package. So, if your current package is "com.mypackage", it will check for "com.mypackage::schemaName_w_Package".
     *
     * @param schemaName_Simple
     * @param curr_PackageName
     * @param schemaNames_FromImports_BySchemaNameSimple
     * @param try_Search_UsingCurrPackageName
     * @param OUT_is_ExternalSchema             indicates if the found schema is from an external jar.
     * @param OUT_externalAppControl_FullName   if it is an external schema, this is the full class name of the ext app Control
     * @return
     * @throws Exception_MetaCompilerError
     */
    public MatrixName find_SchemaName_bySimpleName(DescriptorTagName schemaName_Simple, DescriptorTagName curr_PackageName,
            MultiValueMap schemaNames_FromImports_BySchemaNameSimple, boolean try_Search_UsingCurrPackageName, List<URL> classPath,
            Boolean_Mutable OUT_is_ExternalSchema, String_Mutable OUT_externalAppControl_FullName, Boolean_Mutable OUT_is_InCurrentPackage)
        throws Exception_MetaCompilerError {

        //  TODO - this method is nearly identical to the one in the matrix control. may want to combine these methods

        SchemaInfo_Schema schema = null;
        OUT_is_ExternalSchema.value = false;

        // 1st, try searching the package list
        Collection foundSchemaNames = null;
        if (schemaNames_FromImports_BySchemaNameSimple != null)
            foundSchemaNames = schemaNames_FromImports_BySchemaNameSimple.getCollection(schemaName_Simple);

        int schemaCount = 0;
        if (schema != null)
            schemaCount++;
        if (foundSchemaNames != null)
            schemaCount += foundSchemaNames.size();


        MatrixName found_SchemaName = null;


        if (schemaCount == 0) {
            // do nothing, try searching curr packages
        } else if (schemaCount == 1) {
            if (schema != null)
                found_SchemaName = schema.getSchemaInfo_SchemaNameFull();
            else
                found_SchemaName = (MatrixName)foundSchemaNames.toArray()[0];

        } else { // name conflict
            ArrayList<String> schemaNames = new ArrayList<String>();
            if (schema != null)
                schemaNames.add(schema.getSchemaInfo_SchemaNameFull().get_Name_no_backtiks());
            if (foundSchemaNames != null) {
                for (Object schemaNameObj : foundSchemaNames.toArray())
                    schemaNames.add(((MatrixName)schemaNameObj).get_Name_no_backtiks());
            }
            throw new Exception_MetaCompilerError("Error, tried finding a schema named, " + schemaName_Simple +
                    ", but had a conflict. Found " + schemaCount + " schemas with the same Schema name. " +
                    " The found schemas with name conflicts were: (" + ListUtilities.print(schemaNames) +
                    "). You may need to provide the full schema name to the name to solve this problem. ");
        }


        // 2nd, try searching using the current package name
        if (found_SchemaName != null && try_Search_UsingCurrPackageName) {
            MatrixName schemaName = null;
            try {
                schemaName = symbolControl.multiLevelSymbol_Factory.createNew_SchemaName(curr_PackageName, schemaName_Simple, false);
                schema = classPath__FindSchema(schemaName.get_Name_no_backtiks(), classPath, OUT_is_ExternalSchema, OUT_externalAppControl_FullName);

            } catch (Exception_InvalidArgumentPassed e) {
                throw new Exception_MetaCompilerError("Error, tried finding a schema named, " + curr_PackageName + "::" +  schemaName_Simple +
                    ", but had a problem. Could not create full schema names for this matrixElemName.", e);
            } catch (MalformedURLException mue) {
                throw new Exception_MetaCompilerError("Error, tried finding a schema named, " + curr_PackageName + "::" +  schemaName_Simple +
                    ", but had a problem. The class path was incorrect.", mue);
            }


            if (schema != null)
                found_SchemaName = schema.getSchemaInfo_SchemaNameFull();
        }

        if (found_SchemaName != null && OUT_is_InCurrentPackage != null)
            OUT_is_InCurrentPackage.value = found_SchemaName.getPackageName().equals(curr_PackageName);
        else
            OUT_is_InCurrentPackage.value = false;

        return found_SchemaName;

    }

    /**
     * You pass in the schemaPath (ex. net.unconventionalthinking::WEB.FORM::\WEB.FORM\FORM.SELECTOR), and it will return the schemaInfo_Descriptor object
     * for this path.
     */
    public SchemaInfo_Descriptor getSchemaInfoDescriptor(ExecutionInfo executeInfo, SchemaPath schemaPath) {
        executeInfo.reset();

        SchemaInfo_Schema schema = schemaIndex_bySchemaName.get(schemaPath.getSchemaName());


        if (schema != null) {

            DescriptorPath descPath = schemaPath.getDescriptorPath();


            DescriptorTagName curr_PathElement = (DescriptorTagName)descPath.getSymbol_AtPartNum(1);
            SchemaInfo_Descriptor curr_SchemaInfoDesc = null;

            if (curr_PathElement != schema.getSchemaInfo_SchemaNameFull().getMatrixName())
                return null;
            else
                curr_SchemaInfoDesc = schema;


            int descPathSize = descPath.getNumOfParts();
            for (int i = 2; i <= descPathSize; i++) {
                curr_PathElement = (DescriptorTagName)descPath.getSymbol_AtPartNum(i);

                curr_SchemaInfoDesc = curr_SchemaInfoDesc.getChild_SchemaInfoDescriptor(executeInfo, curr_PathElement);

                if (curr_SchemaInfoDesc == null)
                    return null;
            }

            return curr_SchemaInfoDesc;

            
        } else
            return null;
    }


    

}
