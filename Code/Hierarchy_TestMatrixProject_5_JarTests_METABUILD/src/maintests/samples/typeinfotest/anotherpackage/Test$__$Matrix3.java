/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package maintests.samples.typeinfotest.anotherpackage;

import net.unconventionalthinking.exceptions.*;
import maintests.samples.typeinfotest.AppSymbols_MatrixName;
import java.util.LinkedList;
import maintests.samples.typeinfotest.AppSymbols_DescTag;
import java.util.Arrays;
import net.unconventionalthinking.lang.*;
import maintests.samples.typeinfotest.AppSymbols_SchemaName;
import maintests.samples.typeinfotest.AppSymbols_DescTagName;
import maintests.samples.typeinfotest.AppSymbols;
import net.unconventionalthinking.matrix.*;
import net.unconventionalthinking.matrix.symbols.*;
import maintests.samples.typeinfotest.AppControl;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import maintests.samples.typeinfotest.AppSymbols_Label;




public class Test$__$Matrix3 implements MatrixContainer {

	public static Matrix matrix;


	public static Matrix construct(AppControl_Base appControl, ExecutionInfo executeInfo)
		throws Exception_MatrixRuntime_Checked {

		LinkedList<MatrixSet<SchemaInfo_Schema>> schemaSet_ScopeStack = new LinkedList<MatrixSet<SchemaInfo_Schema>>();

		//  Creating Matrix with name, Test.Matrix3 __________________________________________________
		try {
			schemaSet_ScopeStack.add(new MatrixSet<SchemaInfo_Schema>().add(
				appControl.schemaControl.schemaFactory.get_BaseSchema(executeInfo),
				appControl.schemaControl.schemaForSchema
			));
		} catch (Exception e) {
			throw new Exception_MatrixRuntime_Checked("while trying to create a new Matrix Or Schema descriptor with the name, `Test`.`Matrix3`," + 
				" tried to add the Base Schema to the scope stack, but had an error creating it (see inner exception).", e);
		}

		MatrixSet<SchemaInfo_Schema> descriptor36$_X_$MATRIX$_X_$__UsesSchemaSet;
		Descriptor descriptor36$_X_$MATRIX;

		try {
			descriptor36$_X_$MATRIX$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>().add(appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$__$typeinfotest$__$anotherpackage$_CC_$Test$__$Schema), appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM));
			descriptor36$_X_$MATRIX = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Matrix(executeInfo, AppSymbols_Label.Test$__$Matrix3, AppSymbols_DescTagName.maintests$__$samples$__$typeinfotest$__$anotherpackage, true, descriptor36$_X_$MATRIX$_X_$__UsesSchemaSet, null, true);
			schemaSet_ScopeStack.add(descriptor36$_X_$MATRIX$_X_$__UsesSchemaSet);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.BASE::MATRIX, and with label, `Test`.`Matrix3`, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `test item` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor37$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor37$_X_$ITEM;

		try {
			descriptor37$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor37$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("test item"), 0, true), descriptor37$_X_$ITEM$_X_$__UsesSchemaSet, descriptor36$_X_$MATRIX);
			schemaSet_ScopeStack.add(descriptor37$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor36$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor37$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, test item, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples.typeinfotest.anotherpackage::Test.Schema::TEST.DESC __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor38$_X_$TEST_DESC$_X_$__UsesSchemaSet;
		Descriptor descriptor38$_X_$TEST_DESC;

		try {
			descriptor38$_X_$TEST_DESC$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor38$_X_$TEST_DESC = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$__$typeinfotest$__$anotherpackage$_CC_$Test$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$__$typeinfotest$__$anotherpackage$_CC_$Test$__$Schema$_CC_$TEST$__$DESC), null, descriptor38$_X_$TEST_DESC$_X_$__UsesSchemaSet, descriptor37$_X_$ITEM);
			maintests.samples.typeinfotest.FieldSetTuple__maintests$__$samples$__$typeinfotest$__$anotherpackage$_CC_$Test$__$Schema$_S_$TEST$__$DESC descriptor38$_X_$TEST_DESC$_X_$__FieldSet = (maintests.samples.typeinfotest.FieldSetTuple__maintests$__$samples$__$typeinfotest$__$anotherpackage$_CC_$Test$__$Schema$_S_$TEST$__$DESC)descriptor38$_X_$TEST_DESC.get_FieldSet_Tuple(executeInfo);
			descriptor38$_X_$TEST_DESC$_X_$__FieldSet.set_testField1(executeInfo, AppSymbols.testSym1 );
			descriptor38$_X_$TEST_DESC$_X_$__FieldSet.set_testField2(executeInfo, 6 );
			schemaSet_ScopeStack.add(descriptor38$_X_$TEST_DESC$_X_$__UsesSchemaSet);
			descriptor37$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor38$_X_$TEST_DESC);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples.typeinfotest.anotherpackage::Test.Schema::TEST.DESC, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `First Name` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor39$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor39$_X_$ITEM;

		try {
			descriptor39$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor39$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("First Name"), 0, true), descriptor39$_X_$ITEM$_X_$__UsesSchemaSet, descriptor36$_X_$MATRIX);
			schemaSet_ScopeStack.add(descriptor39$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor36$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor39$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, First Name, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples.typeinfotest::WEB.FORM::FORM.REQUIRED __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor40$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor40$_X_$FORM_REQUIRED;

		try {
			descriptor40$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor40$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), null, descriptor40$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor39$_X_$ITEM);
			maintests.samples.typeinfotest.FieldSetTuple__maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor40$_X_$FORM_REQUIRED$_X_$__FieldSet = (maintests.samples.typeinfotest.FieldSetTuple__maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor40$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor40$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.IsRequired );
			descriptor40$_X_$FORM_REQUIRED$_X_$__FieldSet.set_RequiredImagePath(executeInfo, "/images/isRequired" );
			descriptor40$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageHeight(executeInfo, 5 );
			descriptor40$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageWidth(executeInfo, 6 );
			schemaSet_ScopeStack.add(descriptor40$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor39$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor40$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples.typeinfotest::WEB.FORM::FORM.REQUIRED, and with an empty label, but had an error", e);
		}

		matrix = (Matrix)descriptor36$_X_$MATRIX;

		return (Matrix)descriptor36$_X_$MATRIX;
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
