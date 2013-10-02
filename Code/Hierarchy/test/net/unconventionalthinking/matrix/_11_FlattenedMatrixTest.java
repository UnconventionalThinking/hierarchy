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
import net.unconventionalthinking.matrix.symbols.DescriptorTagName;
import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.MPSymbols_DescTagName;
import net.unconventionalthinking.matrix.symbols.SymbolControl;
import net.unconventionalthinking.hierarchy.HierarchyMetaCompiler;
import net.unconventionalthinking.hierarchy.HierarchySettings;
import maintests.main.MainTests_Setup;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author peterjoh
 */
public class _11_FlattenedMatrixTest {


    static HierarchyMetaCompiler hierarchyCompiler;


    
    public _11_FlattenedMatrixTest() {
    }


    @BeforeClass
    public static void setUpClass() throws Exception {

        hierarchyCompiler = MainTests_Setup.setup_HierarchyCompilerForTests();

        hierarchyCompiler.set_BuildMode_ProjectOrPackage(HierarchySettings.BuildMode_ProjectOrSingleAppPackage.BuildSingleAppPackage);

        //  We need the flattened matrices generated after  the matrix build process. Get them after phase 3
        hierarchyCompiler.phase0_InitiallyCompileJavaCode();
        hierarchyCompiler.phase1_MetacompileSchemaCode();
        hierarchyCompiler.phase2_GenerateFieldSets();
        hierarchyCompiler.phase3_MetacompileMatrices();
        hierarchyCompiler.phase4_CollectTypeInfo();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        // just in case other test use these classes, finish the compilation process
        hierarchyCompiler.phase5_MetaCompileEmbeddedJavaFiles();

    }
    @Before
    public void setUp() {} 
    @After
    public void tearDown() {}


    /**
     * Test of phase1_MetacompileSchemaCode method, of class HierarchyMetaCompiler.
     */
    @Test
    public void testFlattenedMatrix() throws Exception {
        System.out.println("testFlattenedMatrix");


        MatrixControl matrixControl = hierarchyCompiler.get_AppControl().getMatrixControl();
        ExecutionInfo executeInfo = hierarchyCompiler.get_AppControl().getExecutionInfo();
        SymbolControl symbolControl = hierarchyCompiler.get_AppControl().getSymbolControl();


        String matrixNameString = "maintests.samples::Test.Matrix";

        MatrixStructInfo_DescriptorContainer testMatrix_DescContainer = matrixControl.findMatrixUsageStructure(matrixNameString);
        MatrixFlattened_Descriptor matrix_Flattened = testMatrix_DescContainer.descriptor_Flattened;

        assertNotNull(testMatrix_DescContainer.descriptor_Actual);
        assertEquals(matrixNameString, ((Matrix)matrix_Flattened).getMatrixName().get_Name_no_backtiks() );


        String formSelector = "FORM.SELECTOR";
        DescriptorTagName formSelector_DescTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(formSelector, -1, false, null, null);

        Descriptor formSelectorDesc_Flattened = matrix_Flattened.cast_as_Descriptor().get_ChildDescriptor(executeInfo, formSelector_DescTagName);
        assertEquals(formSelector, formSelectorDesc_Flattened.descTagName.getTagName());



        //  There should only be one child descriptor, ITEM with all the labels joined together
        MatrixSet<Descriptor> item_DescSet = formSelectorDesc_Flattened.get_ChildDescriptors(executeInfo, MPSymbols_DescTagName.ITEM);

        assertEquals(1, item_DescSet.size());
        MatrixFlattened_Descriptor itemDesc_Flattened = (MatrixFlattened_Descriptor)item_DescSet.get(0);
        assertEquals(2, itemDesc_Flattened.get_Label_to_DescriptorActual_Index().size());

        Label item1_Label = symbolControl.singleSymbol_Factory.createNew_Label("item 1", false);
        Descriptor item1_Actual = itemDesc_Flattened.get_Label_to_DescriptorActual_Index().get(item1_Label);
        assertEquals(item1_Label, item1_Actual.label);

        Label item2_Label = symbolControl.singleSymbol_Factory.createNew_Label("item 2", false);
        Descriptor item2_Actual = itemDesc_Flattened.get_Label_to_DescriptorActual_Index().get(item2_Label);
        assertEquals(item2_Label, item2_Actual.label);



        //  There should only be one child desc off of ITEM, that's FORM.REQUIRED
        String formRequired = "FORM.REQUIRED";
        DescriptorTagName formRequired_DescTagName = symbolControl.multiPartSymbol_Factory.createNew_DescTagName(formRequired, -1, false, null, null);
        MatrixSet<Descriptor> formRequired_DescSet = ((Descriptor)itemDesc_Flattened).get_ChildDescriptors(executeInfo, formRequired_DescTagName);

        assertEquals(1, formRequired_DescSet.size());

        MatrixFlattened_Descriptor formRequiredDesc_Flattened = (MatrixFlattened_Descriptor)formRequired_DescSet.get(0);
        assertEquals(formRequired_DescTagName, formRequiredDesc_Flattened.cast_as_Descriptor().descTagName);

    }


}