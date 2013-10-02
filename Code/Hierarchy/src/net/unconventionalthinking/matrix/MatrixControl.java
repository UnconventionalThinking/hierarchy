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
import net.unconventionalthinking.lang.String_Mutable;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Exception_MultiPartSymbolAccess;
import net.unconventionalthinking.matrix.symbols.Exception_MultiPartSymbolCreation;
import net.unconventionalthinking.matrix.symbols.Exception_MultiPartSymbolCreationOrAccess;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.MPSymbols;
import net.unconventionalthinking.matrix.symbols.MatrixName;
import net.unconventionalthinking.matrix.symbols.MatrixName_Utilities;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.matrix.symbols.SymbolType;
import net.unconventionalthinking.matrix.utilities.TextUtilities;
import net.unconventionalthinking.reflection.DynamicClassUtilities;
import net.unconventionalthinking.reflection.MethodInvoker;
import net.unconventionalthinking.utilities.ListUtilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.apache.commons.collections.map.MultiValueMap;

/**
 *
 * @author peterjoh
 */
public class MatrixControl {

    public final MatrixFactory matrixFactory;
    public final DescriptorControl descriptorControl;
    
    private AppControl_Base appControl;
    private SymbolControl   symbolControl;
    private SchemaControl   schemaControl;



    private Map<MatrixName, Matrix>     matrixIndex_byMatrixName;
    private Map<String, Matrix>         matrixIndex_byString;
    private Map<String, Matrix>         matrixIndex_byClassNameFull;

    private Map<MatrixName, Matrix>     staticMatrixIndex_byMatrixName;
    private Map<String, Matrix>         staticMatrixIndex_byString;
    private Map<String, Matrix>         staticMatrixIndex_byClassNameFull;

    private MultiValueMap               staticMatrix_MultiValueIndex__byMatrixNameSimple_String;


    //  MatrixUsageStructures - only used for Metacompiler InMemory Matrices (not for user matrix application)
    private Map<MatrixName, MatrixStructInfo_DescriptorContainer>     matrixUsageStructIndex_byMatrixName;
    private Map<String, MatrixStructInfo_DescriptorContainer>         matrixUsageStructIndex_byString;

    
    public MatrixControl(AppControl_Base appControl) {
        assert(appControl != null && appControl.schemaControl != null && appControl.symbolControl != null);

        this.appControl = appControl;
        this.schemaControl = appControl.schemaControl;
        this.symbolControl = appControl.symbolControl;
        if (appControl.matrixControl == null)
            appControl.matrixControl = this;

        matrixFactory = new MatrixFactory(symbolControl, this, schemaControl);
        descriptorControl = new DescriptorControl(symbolControl);
        
        matrixIndex_byMatrixName = new HashMap<MatrixName, Matrix>();
        matrixIndex_byString = new HashMap<String, Matrix>();
        matrixIndex_byClassNameFull = new HashMap<String, Matrix>();

        staticMatrixIndex_byMatrixName = new HashMap<MatrixName, Matrix>();
        staticMatrixIndex_byString = new HashMap<String, Matrix>();
        staticMatrixIndex_byClassNameFull = new HashMap<String, Matrix>();

        staticMatrix_MultiValueIndex__byMatrixNameSimple_String = new MultiValueMap();


        matrixUsageStructIndex_byMatrixName = new HashMap<MatrixName, MatrixStructInfo_DescriptorContainer>();
        matrixUsageStructIndex_byString = new HashMap<String, MatrixStructInfo_DescriptorContainer>();

    }

    public void addMatrix(Matrix matrix) {
        addMatrix(matrix, false);
    }
    public void addMatrix(Matrix matrix, boolean is_StaticMatrix) {
        matrixIndex_byMatrixName.put(matrix.matrixName, matrix);
        matrixIndex_byString.put(matrix.matrixName.get_Name_no_backtiks(), matrix);
        matrixIndex_byClassNameFull.put(matrix.matrixName.getClassName_Full(), matrix);

        if (is_StaticMatrix) {
            staticMatrixIndex_byMatrixName.put(matrix.matrixName, matrix);
            staticMatrixIndex_byString.put(matrix.matrixName.get_Name_no_backtiks(), matrix);
            staticMatrixIndex_byClassNameFull.put(matrix.matrixName.getClassName_Full(), matrix);

            staticMatrix_MultiValueIndex__byMatrixNameSimple_String.put(matrix.matrixName.getMatrixName().get_Name_no_backtiks(), matrix);
        }
    }


    //  Matrix Usage Stucture add method
    public void add_MatrixUsageStructure(MatrixStructInfo_DescriptorContainer matrix_DescriptorContainer) {

        MatrixName matrixName = null;
        if (matrix_DescriptorContainer.descriptor_Actual != null)
            matrixName = ((Matrix)matrix_DescriptorContainer.descriptor_Actual).getMatrixName();
        else if (matrix_DescriptorContainer.descriptor_Flattened != null)
            matrixName = ((Matrix)matrix_DescriptorContainer.descriptor_Flattened).getMatrixName();

        matrixUsageStructIndex_byMatrixName.put(matrixName, matrix_DescriptorContainer);
        matrixUsageStructIndex_byString.put(matrixName.get_Name_no_backtiks(), matrix_DescriptorContainer);
    }



    public void removeMatrix(MatrixName matrixName) {
        matrixIndex_byMatrixName.remove(matrixName);
        matrixIndex_byString.remove(matrixName.get_Name_no_backtiks());
        Matrix removedMatrix = staticMatrixIndex_byMatrixName.remove(matrixName);
        staticMatrixIndex_byString.remove(matrixName.get_Name_no_backtiks());

        staticMatrix_MultiValueIndex__byMatrixNameSimple_String.remove(matrixName.getMatrixName().get_Name_no_backtiks(), removedMatrix);
    }
    public void removeMatrix(List<String> matrixNameParts, DescriptorTagName packageName)
            throws Exception_MultiPartSymbolAccess {

        DescriptorTagName matrixName_DescTagName = (DescriptorTagName)symbolControl.multiPartSymbol_Factory.find(SymbolType.DescriptorTagName,
                matrixNameParts);

        removeMatrix(symbolControl.matrixName_Index.getMatrixName_ByPackageAndMatrixName(matrixName_DescTagName, packageName));
    }

    /**  gets the collection of all the matrices */
    public Collection<Matrix> getMatrices() {
        return matrixIndex_byMatrixName.values();
    }

    /** The search string should just be the name of the matrix (no back tiks, so:  com.mypackage::My.Matrix, not label format, `My`.`Matrix`) */
    public Matrix find(String matrixName_Full) {
        return (matrixIndex_byString.get(matrixName_Full));
    }
    public Matrix find(MatrixName matrixName) {
        return matrixIndex_byMatrixName.get(matrixName);
    }
    public Matrix findMatrix_ByClassNameFull(String matrixClassName_Full) {
        return matrixIndex_byClassNameFull.get(matrixClassName_Full);
    }

    /**  gets the collection of all the static matrices */
    public Collection<Matrix> getStaticMatrices() {
        return staticMatrixIndex_byMatrixName.values();
    }
    public Matrix findStaticMatrix(MatrixName matrixName) {
        return staticMatrixIndex_byMatrixName.get(matrixName);
    }
    /** The search string should just be the name of the matrix (no back tiks, so:  com.mypackage::My.Matrix, not label format, `My`.`Matrix`) */
    public Matrix findStaticMatrix(String matrixName_Full) {
        return staticMatrixIndex_byString.get(matrixName_Full);
    }
    public Matrix findStaticMatrix_ByClassNameFull(String matrixClassName_Full) {
        return staticMatrixIndex_byClassNameFull.get(matrixClassName_Full);
    }
    public Collection findAllStaticMatrices_ByMatrixNameSimple(String matrixNameSimple) {
        return staticMatrix_MultiValueIndex__byMatrixNameSimple_String.getCollection(matrixNameSimple);
    }



    /** The search string should just be the name of the matrix (no back tiks, so:  com.mypackage::My.Matrix, not label format, `My`.`Matrix`) */
    public MatrixStructInfo_DescriptorContainer findMatrixUsageStructure(String matrixName_Full) throws Exception_MetaCompilerError {

        MatrixStructInfo_DescriptorContainer matrixUsageStructure = matrixUsageStructIndex_byString.get(matrixName_Full);
        Matrix matrix_Actual = matrixIndex_byString.get(matrixName_Full);

        if (matrixUsageStructure == null && matrix_Actual != null) 
            matrixUsageStructure = createMatrixUsageStructure(matrix_Actual, matrixName_Full, null);
        
        return matrixUsageStructure;
    }

    
    public MatrixStructInfo_DescriptorContainer findMatrixUsageStructure(MatrixName matrixName) {

        MatrixStructInfo_DescriptorContainer matrixUsageStructure = matrixUsageStructIndex_byMatrixName.get(matrixName);
        Matrix matrix_Actual = matrixIndex_byMatrixName.get(matrixName);

        if (matrixUsageStructure == null && matrix_Actual != null)
            matrixUsageStructure = createMatrixUsageStructure(matrix_Actual, null, matrixName);

        return matrixUsageStructure;
    }

    /** pass in either the matrixName_Full, or the matrixName. Don't need both.*/
    private MatrixStructInfo_DescriptorContainer createMatrixUsageStructure(Matrix matrix_Actual, String matrixName_Full, MatrixName matrixName) {

        // There is no matrixUsageStructure for this matrix. It's probably an external matrix in a jar. Create the matrix usage struct.
        MatrixStructInfo_DescriptorContainer matrixUsageStructure = null;
        MatrixStructInfoBuilder__buildDescFlattenedFromMatrix matrixStructInfo_Builder = new
                MatrixStructInfoBuilder__buildDescFlattenedFromMatrix(appControl.executionInfo, symbolControl, schemaControl, this,
                matrix_Actual.is_StaticMatrix());
        matrixStructInfo_Builder.setPackageName(matrix_Actual.getMatrixName().getPackageName());
        matrixStructInfo_Builder.setMatrix_Actual(matrix_Actual);

        try {
            matrixStructInfo_Builder.create_MatrixUsageStructure_FromMatrix(MPSymbols.BuildingMatrixElement);
        } catch (Exception_MetaCompilerError e) {
            throw new ExceptRuntime_Matrix_UnexpectedError("Tried to create the matrix usage structure for an external matrix, but had an error. The matrix name was " +
                    matrixName_Full, e);
        }

        //  The new matrixUsageStructure should have now been added to the matrixUsageStruct Indexes.
        if (matrixName_Full != null)
            matrixUsageStructure = matrixUsageStructIndex_byString.get(matrixName_Full);
        else
            matrixUsageStructure = matrixUsageStructIndex_byMatrixName.get(matrixName);

        if (matrixUsageStructure == null)
            throw new ExceptRuntime_Matrix_GeneralError("Tried creating the Matrix Usage Structure for the external matrix: " +
                    matrixName_Full + ", but had a error. It was supposed to have been just created and added to the indexes, but it's not there.");

        return matrixUsageStructure;
    }





    /** Search the classpath for the matrix. This method allows you to find matrices that are in the current project's source, or in external jars in
     *  the classpath. <br>
     *  If the schema is an external schema, this method also does all the secondary tasks needed to make sure the schema is ready for use by the
     *  application and the metacompiler. It loads the external schema's appControl, and adds it to necessary schema control indexes. <p>
     *
     *  This version takes the packageName and matrix name separately.
     *
     * @param OUT_is_ExternalMatrix             indicates if the found matrix is from an external jar.
     * @param OUT_externalAppControl_FullName   if it is an external matrix, this is the full class name of the ext app Control
     */
    public Matrix classPath__FindMatrix(String matrixName, String packageName,
            List<URL> classPath,
            Boolean_Mutable OUT_is_ExternalMatrix, String_Mutable OUT_externalAppControl_FullName)
            throws MalformedURLException {
        
        String matrixNameFull = packageName + "::" + matrixName;
        return classPath__FindMatrix(matrixNameFull, classPath, OUT_is_ExternalMatrix, OUT_externalAppControl_FullName);
    }

    /** Search the classpath for the matrix. This method allows you to find matrices that are in the current project's source, or in external jars in
     *  the classpath.<br>
     *  If the schema is an external schema, this method also does all the secondary tasks needed to make sure the schema is ready for use by the 
     *  application and the metacompiler. It loads the external schema's appControl, and adds it to necessary schema control indexes. <p>
     *
     *  The format of the matrix name is: "my.package::my.matrix".
     *
     * @param OUT_is_ExternalMatrix             indicates if the found matrix is from an external jar.
     * @param OUT_externalAppControl_FullName   if it is an external matrix, this is the full class name of the ext app Control
     */
    public Matrix classPath__FindMatrix(String matrixName_w_Package, List<URL> classPath, Boolean_Mutable OUT_is_ExternalMatrix,
            String_Mutable OUT_externalAppControl_FullName) throws MalformedURLException {

        String matrixName_IdentFormat = MatrixName_Utilities.convert_MatrixNameWithPackage_to_IdentifierFormat(matrixName_w_Package);
        Matrix foundMatrix = find(matrixName_w_Package); // NOTE: use NON-Identifier format for the find


        if (foundMatrix == null && DynamicClassUtilities.classPath__ClassExists(classPath, matrixName_IdentFormat)) {

            Class possibleMatrixContainer_ClassObj = null;
            try  { 
                possibleMatrixContainer_ClassObj = DynamicClassUtilities.classPath__dynLoadClass(classPath, matrixName_IdentFormat);
            } catch (ClassNotFoundException e) {
                throw new ExceptRuntime_Matrix_GeneralError("Tried to load the external matrix class, " + matrixName_IdentFormat + ",  that was loaded from an external source (like a jar), but could not load it even though we tested if it existed, and it did. " +
                        "This should not happen.");
            }

            //  you need to make sure this is a matrix and not a schema (all schemas are matrices, which is why you need the "not schema" test)
            if (MatrixContainer.class.isAssignableFrom(possibleMatrixContainer_ClassObj) && !SchemaContainer.class.isAssignableFrom(possibleMatrixContainer_ClassObj)) {


                AppControlUtilities.loadAppControl_throughMatrixOrSchema(matrixName_IdentFormat, appControl, classPath,
                        appControl.running_AppControl_forMetacompilation);

                //  the Matrix should have been added to the matrix indices now:
                foundMatrix = find(matrixName_w_Package);
                if (foundMatrix == null) {
                    throw new ExceptRuntime_Matrix_GeneralError("Tried to find a matrix object for the matrix," + matrixName_w_Package + ",  that was loaded from an external source (like a jar), but could not find it. " +
                            "This should not happen, because the app control for the jar should have been initialized, which would create the matrix object.");
                }


                try {
                    MatrixContainer matrixContainer = (MatrixContainer)possibleMatrixContainer_ClassObj.newInstance();
                    OUT_is_ExternalMatrix.value = true;
                    OUT_externalAppControl_FullName.value = matrixContainer.get_AppControl_Class().getCanonicalName();
                } catch (Exception e) {
                    throw new ExceptRuntime_Matrix_GeneralError("Tried to load the appControl for the external matrix class, " + matrixName_IdentFormat + ",  that was loaded from an external source (like a jar), but could not get its appControl object. " +
                            "This should not happen.");
                }
            }

        }
        return foundMatrix;

    }






    public boolean checkMatrixIsStatic(MatrixName matrixName) {
        return staticMatrixIndex_byMatrixName.containsKey(matrixName);
    }


    public Iterator<MatrixName> getMatrixNames_Iterator() {
        return matrixIndex_byMatrixName.keySet().iterator();
    }
    public Iterator<MatrixName> getStaticMatrixNames_Iterator() {
        return staticMatrixIndex_byMatrixName.keySet().iterator();
    }



    //  These matrixUsageStructIndex get and set methods are used by the Metacompiler. What happens is the matrix usage struct is created
    //  when the matrices are metacompiled. But, then, a new appControl is created (with out the matrix usage structures). The metacompiler
    //  uses these methods to load them back in...
    public MatrixStructInfoIndex_Container get_MatrixUsageStructIndex_Container() {
        return new MatrixStructInfoIndex_Container(matrixUsageStructIndex_byMatrixName, matrixUsageStructIndex_byString);
    }

    public void set_MatrixUsageStructIndexes(MatrixStructInfoIndex_Container matrixUsageStructIndex_Container) {
        matrixUsageStructIndex_byMatrixName = matrixUsageStructIndex_Container.matrixStructInfoIndex_byMatrixName;
        matrixUsageStructIndex_byString = matrixUsageStructIndex_Container.matrixStructInfoIndex_byString;
    }









    /**
     * Searches to find the full matrix name using the simple name, searching through the embedded matrix file's import list.
     * First, it searches the explicit imported matrix list.
     * Second, it searches the current package. So, if your current package is "com.mypackage", it will check for "com.mypackage::<matrix name>".
     *
     * @param matrixName_Simple
     * @param curr_PackageName
     * @param matrixNames_FromImports_BySchemaNameSimple
     * @param try_Search_UsingCurrPackageName
     * @param OUT_is_ExternalMatrix             indicates if the found matrix is from an external jar.
     * @param OUT_externalAppControl_FullName   if it is an external matrix, this is the full class name of the ext app Control
     * @return
     * @throws Exception_MetaCompilerError
     */
    public MatrixName find_MatrixName_bySimpleName(String matrixName_Simple, DescriptorTagName curr_PackageName,
            MultiValueMap matrixNames_FromImports_BySchemaNameSimple, boolean try_Search_UsingCurrPackageName, List<URL> classPath,
            Boolean_Mutable OUT_is_ExternalMatrix, String_Mutable OUT_externalAppControl_FullName, Boolean_Mutable OUT_is_InCurrentPackage)
        throws Exception_MetaCompilerError {

        DescriptorTagName matrixName_DescTagname = null;
        try {
            matrixName_DescTagname = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(matrixName_Simple, 1, false, null, null);
        } catch (Exception e) {
            throw new Exception_MetaCompilerError("Tried to create a DescriptorTagName symbol for the schema name, " + matrixName_Simple + ", but had an error.", e);
        }
        return find_MatrixName_bySimpleName(matrixName_DescTagname, curr_PackageName, matrixNames_FromImports_BySchemaNameSimple, 
                try_Search_UsingCurrPackageName, classPath, OUT_is_ExternalMatrix, OUT_externalAppControl_FullName, OUT_is_InCurrentPackage);
    }
    /**
     * Searches to find the full matrix name using the simple name, searching through the embedded matrix file's import list.
     * First, it searches the explicit imported matrix list.
     * Second, it searches the current package. So, if your current package is "com.mypackage", it will check for "com.mypackage::<matrix name>".
     *
     * @param matrixName_Simple
     * @param curr_PackageName
     * @param matrixNames_FromImports_BySchemaNameSimple
     * @param try_Search_UsingCurrPackageName
     * @param OUT_is_ExternalMatrix             indicates if the found matrix is from an external jar.
     * @param OUT_externalAppControl_FullName   if it is an external matrix, this is the full class name of the ext app Control
     * @return
     * @throws Exception_MetaCompilerError
     */
    public MatrixName find_MatrixName_bySimpleName(DescriptorTagName matrixName_Simple, DescriptorTagName curr_PackageName,
            MultiValueMap matrixNames_FromImports_ByMatrixNameSimple, boolean try_Search_UsingCurrPackageName, List<URL> classPath,
            Boolean_Mutable OUT_is_ExternalMatrix, String_Mutable OUT_externalAppControl_FullName, Boolean_Mutable OUT_is_InCurrentPackage)
        throws Exception_MetaCompilerError {

        //  TODO - this method is nearly identical to the one in the schema control. may want to combine these methods

        Matrix matrix = null;
        OUT_is_ExternalMatrix.value = false;

        // First, try searching the package list
        Collection foundMatrixNames = null;
        if (matrixNames_FromImports_ByMatrixNameSimple != null)
            foundMatrixNames = matrixNames_FromImports_ByMatrixNameSimple.getCollection(matrixName_Simple);

        int matrixCount = 0;
        if (matrix != null)
            matrixCount++;
        if (foundMatrixNames != null)
            matrixCount += foundMatrixNames.size();

        MatrixName found_MatrixName = null;

        if (matrixCount == 0) {
            //  do nothing, try searching the current package
        } else if (matrixCount == 1) {
            if (matrix != null)
                found_MatrixName = matrix.getMatrixName();
            else
                found_MatrixName = (MatrixName)foundMatrixNames.toArray()[0];

        } else { // name conflict
            List<String> matrixNames = new ArrayList<String>();
            if (matrix != null)
                matrixNames.add(matrix.getMatrixName().get_Name_no_backtiks());
            if (foundMatrixNames != null) {
                for (Object matrixNameObj : foundMatrixNames.toArray())
                    matrixNames.add(((MatrixName)matrixNameObj).get_Name_no_backtiks());
            }
            throw new Exception_MetaCompilerError("Error, tried finding a matrix named, " + matrixName_Simple +
                    ", but had a conflict. Found " + matrixCount + " matrixs with the same Matrix name. " +
                    " The found matrices with name conflicts were: (" + ListUtilities.print(matrixNames) +
                    "). You may need to provide the full matrix name to the name to solve this problem. ");
        }


        // Second, try searching using the current package name
        if (found_MatrixName != null && try_Search_UsingCurrPackageName) {
            MatrixName matrixName = null;
            try {
                matrixName = symbolControl.multiLevelSymbol_Factory.createNew_MatrixName(curr_PackageName, matrixName_Simple, false);
                matrix = classPath__FindMatrix(matrixName.get_Name_no_backtiks(), classPath, OUT_is_ExternalMatrix, OUT_externalAppControl_FullName);

            } catch (Exception_InvalidArgumentPassed e) {
                throw new Exception_MetaCompilerError("Error, tried finding a matrix named, " + curr_PackageName + "::" +  matrixName_Simple +
                    ", but had a problem. Could not create full matrix names for this matrixElemName.", e);
            } catch (MalformedURLException mue) {
                throw new Exception_MetaCompilerError("Error, tried finding a matrix named, " + curr_PackageName + "::" +  matrixName_Simple +
                    ", but had a problem. The class path was incorrect.", mue);
            }



            if (matrix != null)
                found_MatrixName = matrix.getMatrixName();

        }

        if (found_MatrixName != null && OUT_is_InCurrentPackage != null)
            OUT_is_InCurrentPackage.value = found_MatrixName.getPackageName().equals(curr_PackageName);
        else
            OUT_is_InCurrentPackage.value = false;

        return found_MatrixName;

    }




}
