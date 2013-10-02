/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package maintests.samples.typeinfotest;

import net.unconventionalthinking.exceptions.*;
import net.unconventionalthinking.matrix.*;
import java.util.Arrays;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import java.util.LinkedList;




public class Test$__$Matrix2 implements MatrixContainer {

	public static Matrix matrix;


	public static Matrix construct(AppControl_Base appControl, ExecutionInfo executeInfo)
		throws Exception_MatrixRuntime_Checked {

		LinkedList<MatrixSet<SchemaInfo_Schema>> schemaSet_ScopeStack = new LinkedList<MatrixSet<SchemaInfo_Schema>>();

		//  Creating Matrix with name, Test.Matrix2 __________________________________________________
		try {
			schemaSet_ScopeStack.add(new MatrixSet<SchemaInfo_Schema>().add(
				appControl.schemaControl.schemaFactory.get_BaseSchema(executeInfo),
				appControl.schemaControl.schemaForSchema
			));
		} catch (Exception e) {
			throw new Exception_MatrixRuntime_Checked("while trying to create a new Matrix Or Schema descriptor with the name, `Test`.`Matrix2`," + 
				" tried to add the Base Schema to the scope stack, but had an error creating it (see inner exception).", e);
		}

		MatrixSet<SchemaInfo_Schema> descriptor30$_X_$MATRIX$_X_$__UsesSchemaSet;
		Descriptor descriptor30$_X_$MATRIX;

		try {
			descriptor30$_X_$MATRIX$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>().add(appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$__$typeinfotest$__$anotherpackage$_CC_$Test$__$Schema));
			descriptor30$_X_$MATRIX = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Matrix(executeInfo, AppSymbols_Label.Test$__$Matrix2, AppSymbols_DescTagName.maintests$__$samples$__$typeinfotest, true, descriptor30$_X_$MATRIX$_X_$__UsesSchemaSet, null, true);
			schemaSet_ScopeStack.add(descriptor30$_X_$MATRIX$_X_$__UsesSchemaSet);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.BASE::MATRIX, and with label, `Test`.`Matrix2`, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `test item` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor31$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor31$_X_$ITEM;

		try {
			descriptor31$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor31$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("test item"), 0, true), descriptor31$_X_$ITEM$_X_$__UsesSchemaSet, descriptor30$_X_$MATRIX);
			schemaSet_ScopeStack.add(descriptor31$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor30$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor31$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, test item, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples.typeinfotest.anotherpackage::Test.Schema::TEST.DESC __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor32$_X_$TEST_DESC$_X_$__UsesSchemaSet;
		Descriptor descriptor32$_X_$TEST_DESC;

		try {
			descriptor32$_X_$TEST_DESC$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor32$_X_$TEST_DESC = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$__$typeinfotest$__$anotherpackage$_CC_$Test$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$__$typeinfotest$__$anotherpackage$_CC_$Test$__$Schema$_CC_$TEST$__$DESC), null, descriptor32$_X_$TEST_DESC$_X_$__UsesSchemaSet, descriptor31$_X_$ITEM);
			maintests.samples.typeinfotest.FieldSetTuple__maintests$__$samples$__$typeinfotest$__$anotherpackage$_CC_$Test$__$Schema$_S_$TEST$__$DESC descriptor32$_X_$TEST_DESC$_X_$__FieldSet = (maintests.samples.typeinfotest.FieldSetTuple__maintests$__$samples$__$typeinfotest$__$anotherpackage$_CC_$Test$__$Schema$_S_$TEST$__$DESC)descriptor32$_X_$TEST_DESC.get_FieldSet_Tuple(executeInfo);
			descriptor32$_X_$TEST_DESC$_X_$__FieldSet.set_testField1(executeInfo, AppSymbols.testSym1 );
			descriptor32$_X_$TEST_DESC$_X_$__FieldSet.set_testField2(executeInfo, 6 );
			schemaSet_ScopeStack.add(descriptor32$_X_$TEST_DESC$_X_$__UsesSchemaSet);
			descriptor31$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor32$_X_$TEST_DESC);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples.typeinfotest.anotherpackage::Test.Schema::TEST.DESC, and with an empty label, but had an error", e);
		}

		matrix = (Matrix)descriptor30$_X_$MATRIX;

		return (Matrix)descriptor30$_X_$MATRIX;
	}




	public Class<?> get_AppControl_Class() throws ClassNotFoundException {
		return maintests.samples.typeinfotest.AppControl.class;
	}
	public AppControl_Base initialize_AppControl() { return initialize_AppControl(null, false); }
	public AppControl_Base initialize_AppControl(boolean running_AppControl_forMetacompilation) { return initialize_AppControl(null, running_AppControl_forMetacompilation); }
	public AppControl_Base initialize_AppControl(AppControl_Base existing_AppControl) { return initialize_AppControl(existing_AppControl, false); }
	public AppControl_Base initialize_AppControl(AppControl_Base existing_AppControl, boolean running_AppControl_forMetacompilation) {
		if (existing_AppControl != null)
			return maintests.samples.typeinfotest.AppControl.initializeApp(existing_AppControl, running_AppControl_forMetacompilation);
		else
			return maintests.samples.typeinfotest.AppControl.initializeApp(running_AppControl_forMetacompilation);
	}

	public AppControl_Base get_AppControl() {
		return maintests.samples.typeinfotest.AppControl.appControl;
	}

}
