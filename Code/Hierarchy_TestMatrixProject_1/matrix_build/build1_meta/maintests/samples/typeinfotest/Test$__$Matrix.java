/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package maintests.samples.typeinfotest;

import net.unconventionalthinking.exceptions.*;
import net.unconventionalthinking.matrix.*;
import java.util.Arrays;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import java.util.LinkedList;




public class Test$__$Matrix implements MatrixContainer {

	public static Matrix matrix;


	public static Matrix construct(AppControl_Base appControl, ExecutionInfo executeInfo)
		throws Exception_MatrixRuntime_Checked {

		LinkedList<MatrixSet<SchemaInfo_Schema>> schemaSet_ScopeStack = new LinkedList<MatrixSet<SchemaInfo_Schema>>();

		//  Creating Matrix with name, Test.Matrix __________________________________________________
		try {
			schemaSet_ScopeStack.add(new MatrixSet<SchemaInfo_Schema>().add(
				appControl.schemaControl.schemaFactory.get_BaseSchema(executeInfo),
				appControl.schemaControl.schemaForSchema
			));
		} catch (Exception e) {
			throw new Exception_MatrixRuntime_Checked("while trying to create a new Matrix Or Schema descriptor with the name, `Test`.`Matrix`," + 
				" tried to add the Base Schema to the scope stack, but had an error creating it (see inner exception).", e);
		}

		MatrixSet<SchemaInfo_Schema> descriptor20$_X_$MATRIX$_X_$__UsesSchemaSet;
		Descriptor descriptor20$_X_$MATRIX;

		try {
			descriptor20$_X_$MATRIX$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>().add(appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM));
			descriptor20$_X_$MATRIX = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Matrix(executeInfo, AppSymbols_Label.Test$__$Matrix, AppSymbols_DescTagName.maintests$__$samples$__$typeinfotest, true, descriptor20$_X_$MATRIX$_X_$__UsesSchemaSet, null, true);
			schemaSet_ScopeStack.add(descriptor20$_X_$MATRIX$_X_$__UsesSchemaSet);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.BASE::MATRIX, and with label, `Test`.`Matrix`, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `First Name` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor21$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor21$_X_$ITEM;

		try {
			descriptor21$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor21$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("First Name"), 0, true), descriptor21$_X_$ITEM$_X_$__UsesSchemaSet, descriptor20$_X_$MATRIX);
			schemaSet_ScopeStack.add(descriptor21$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor20$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor21$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, First Name, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples.typeinfotest::WEB.FORM::FORM.REQUIRED __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor22$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor22$_X_$FORM_REQUIRED;

		try {
			descriptor22$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor22$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), null, descriptor22$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor21$_X_$ITEM);
			maintests.samples.typeinfotest.FieldSetTuple__maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor22$_X_$FORM_REQUIRED$_X_$__FieldSet = (maintests.samples.typeinfotest.FieldSetTuple__maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor22$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor22$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.IsRequired );
			descriptor22$_X_$FORM_REQUIRED$_X_$__FieldSet.set_RequiredImagePath(executeInfo, "/images/isRequired" );
			descriptor22$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageHeight(executeInfo, 5 );
			descriptor22$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageWidth(executeInfo, 6 );
			schemaSet_ScopeStack.add(descriptor22$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor21$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor22$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples.typeinfotest::WEB.FORM::FORM.REQUIRED, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `Last Name` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor23$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor23$_X_$ITEM;

		try {
			descriptor23$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor23$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("Last Name"), 0, true), descriptor23$_X_$ITEM$_X_$__UsesSchemaSet, descriptor20$_X_$MATRIX);
			schemaSet_ScopeStack.add(descriptor23$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor20$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor23$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, Last Name, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples.typeinfotest::WEB.FORM::FORM.REQUIRED __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor24$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor24$_X_$FORM_REQUIRED;

		try {
			descriptor24$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor24$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), null, descriptor24$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor23$_X_$ITEM);
			maintests.samples.typeinfotest.FieldSetTuple__maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor24$_X_$FORM_REQUIRED$_X_$__FieldSet = (maintests.samples.typeinfotest.FieldSetTuple__maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor24$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor24$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.NotRequired );
			descriptor24$_X_$FORM_REQUIRED$_X_$__FieldSet.set_RequiredImagePath(executeInfo, "/images/isRequired" );
			descriptor24$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageHeight(executeInfo, 5 );
			descriptor24$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageWidth(executeInfo, 6 );
			schemaSet_ScopeStack.add(descriptor24$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor23$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor24$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples.typeinfotest::WEB.FORM::FORM.REQUIRED, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples.typeinfotest::WEB.FORM::FORM.SELECTOR __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor25$_X_$FORM_SELECTOR$_X_$__UsesSchemaSet;
		Descriptor descriptor25$_X_$FORM_SELECTOR;

		try {
			descriptor25$_X_$FORM_SELECTOR$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor25$_X_$FORM_SELECTOR = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$SELECTOR), null, descriptor25$_X_$FORM_SELECTOR$_X_$__UsesSchemaSet, descriptor20$_X_$MATRIX);
			schemaSet_ScopeStack.add(descriptor25$_X_$FORM_SELECTOR$_X_$__UsesSchemaSet);
			descriptor20$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor25$_X_$FORM_SELECTOR);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples.typeinfotest::WEB.FORM::FORM.SELECTOR, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `item 1` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor26$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor26$_X_$ITEM;

		try {
			descriptor26$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor26$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("item 1"), 0, true), descriptor26$_X_$ITEM$_X_$__UsesSchemaSet, descriptor25$_X_$FORM_SELECTOR);
			schemaSet_ScopeStack.add(descriptor26$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor25$_X_$FORM_SELECTOR.add_ChildDescriptor(executeInfo, descriptor26$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, item 1, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples.typeinfotest::WEB.FORM::FORM.REQUIRED __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor27$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor27$_X_$FORM_REQUIRED;

		try {
			descriptor27$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor27$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), null, descriptor27$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor26$_X_$ITEM);
			maintests.samples.typeinfotest.FieldSetTuple__maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor27$_X_$FORM_REQUIRED$_X_$__FieldSet = (maintests.samples.typeinfotest.FieldSetTuple__maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor27$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor27$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.IsRequired );
			descriptor27$_X_$FORM_REQUIRED$_X_$__FieldSet.set_RequiredImagePath(executeInfo, "stuff" );
			descriptor27$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageHeight(executeInfo, 22 );
			schemaSet_ScopeStack.add(descriptor27$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor26$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor27$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples.typeinfotest::WEB.FORM::FORM.REQUIRED, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `item 2` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor28$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor28$_X_$ITEM;

		try {
			descriptor28$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor28$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("item 2"), 0, true), descriptor28$_X_$ITEM$_X_$__UsesSchemaSet, descriptor25$_X_$FORM_SELECTOR);
			schemaSet_ScopeStack.add(descriptor28$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor25$_X_$FORM_SELECTOR.add_ChildDescriptor(executeInfo, descriptor28$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, item 2, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples.typeinfotest::WEB.FORM::FORM.REQUIRED __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor29$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet;
		Descriptor descriptor29$_X_$FORM_REQUIRED;

		try {
			descriptor29$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor29$_X_$FORM_REQUIRED = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_CC_$FORM$__$REQUIRED), null, descriptor29$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet, descriptor28$_X_$ITEM);
			maintests.samples.typeinfotest.FieldSetTuple__maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED descriptor29$_X_$FORM_REQUIRED$_X_$__FieldSet = (maintests.samples.typeinfotest.FieldSetTuple__maintests$__$samples$__$typeinfotest$_CC_$WEB$__$FORM$_S_$FORM$__$REQUIRED)descriptor29$_X_$FORM_REQUIRED.get_FieldSet_Tuple(executeInfo);
			descriptor29$_X_$FORM_REQUIRED$_X_$__FieldSet.set_IsRequired(executeInfo, AppSymbols.NotRequired );
			descriptor29$_X_$FORM_REQUIRED$_X_$__FieldSet.set_RequiredImagePath(executeInfo, "more stuff" );
			descriptor29$_X_$FORM_REQUIRED$_X_$__FieldSet.set_ImageHeight(executeInfo, 23 );
			schemaSet_ScopeStack.add(descriptor29$_X_$FORM_REQUIRED$_X_$__UsesSchemaSet);
			descriptor28$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor29$_X_$FORM_REQUIRED);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples.typeinfotest::WEB.FORM::FORM.REQUIRED, and with an empty label, but had an error", e);
		}

		matrix = (Matrix)descriptor20$_X_$MATRIX;

		return (Matrix)descriptor20$_X_$MATRIX;
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
