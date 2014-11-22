package net.unconventionalthinking.hierarchy;


import net.unconventionalthinking.hierarchy.HierarchyMetaCompiler;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Peter Joh
 */
public class MetacompilationTest {

    public MetacompilationTest() { }
    @BeforeClass
    public static void setUpClass() throws Exception { }
    @AfterClass
    public static void tearDownClass() throws Exception { }
    @Before
    public void setUp() { }
    @After
    public void tearDown() { }


    @Test
    public void metacompileTest() throws Exception {

        HierarchyMetaCompiler.main(new String[] { "-mpropfile", "hierarchy.properties" });

    }

}