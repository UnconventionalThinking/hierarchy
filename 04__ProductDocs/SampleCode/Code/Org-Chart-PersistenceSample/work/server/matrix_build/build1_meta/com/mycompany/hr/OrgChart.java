/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package com.mycompany.hr;


import net.unconventionalthinking.exceptions.*;
import net.unconventionalthinking.matrix.*;
import java.util.Arrays;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import java.util.LinkedList;




public class OrgChart implements MatrixContainer {

	public static Matrix matrix;


	public static Matrix construct(AppControl_Base appControl, ExecutionInfo executeInfo)
		throws Exception_MatrixRuntime_Checked {

		LinkedList<MatrixSet<SchemaInfo_Schema>> schemaSet_ScopeStack = new LinkedList<MatrixSet<SchemaInfo_Schema>>();

		//  Creating Matrix with name, OrgChart __________________________________________________
		try {
			schemaSet_ScopeStack.add(new MatrixSet<SchemaInfo_Schema>().add(
				appControl.schemaControl.schemaFactory.get_BaseSchema(executeInfo),
				appControl.schemaControl.schemaForSchema
			));
		} catch (Exception e) {
			throw new Exception_MatrixRuntime_Checked("while trying to create a new Matrix Or Schema descriptor with the name, OrgChart," + 
				" tried to add the Base Schema to the scope stack, but had an error creating it (see inner exception).", e);
		}

		MatrixSet<SchemaInfo_Schema> descriptor52$_X_$MATRIX$_X_$__UsesSchemaSet;
		Descriptor descriptor52$_X_$MATRIX;

		try {
			descriptor52$_X_$MATRIX$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>().add(appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema), appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventional$__$persistence$_CC_$MATRIXPROG$__$PERSISTENCE));
			descriptor52$_X_$MATRIX = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Matrix(executeInfo, AppSymbols_Label.OrgChart, AppSymbols_DescTagName.com$__$mycompany$__$hr, true, descriptor52$_X_$MATRIX$_X_$__UsesSchemaSet, null, true, 7);
			schemaSet_ScopeStack.add(descriptor52$_X_$MATRIX$_X_$__UsesSchemaSet);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.BASE::MATRIX, and with label, OrgChart, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventional.persistence::MATRIXPROG.PERSISTENCE::MATRIXPROG.PERSISTENCE.SETTINGS __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor53$_X_$MATRIXPROG_PERSISTENCE_SETTINGS$_X_$__UsesSchemaSet;
		Descriptor descriptor53$_X_$MATRIXPROG_PERSISTENCE_SETTINGS;

		try {
			descriptor53$_X_$MATRIXPROG_PERSISTENCE_SETTINGS$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor53$_X_$MATRIXPROG_PERSISTENCE_SETTINGS = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventional$__$persistence$_CC_$MATRIXPROG$__$PERSISTENCE).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventional$__$persistence$_CC_$MATRIXPROG$__$PERSISTENCE$_CC_$MATRIXPROG$__$PERSISTENCE$__$SETTINGS), null, descriptor53$_X_$MATRIXPROG_PERSISTENCE_SETTINGS$_X_$__UsesSchemaSet, descriptor52$_X_$MATRIX, 8);
			com.mycompany.hr.FieldSetTuple__net$__$unconventional$__$persistence$_CC_$MATRIXPROG$__$PERSISTENCE$_S_$MATRIXPROG$__$PERSISTENCE$__$SETTINGS descriptor53$_X_$MATRIXPROG_PERSISTENCE_SETTINGS$_X_$__FieldSet = (com.mycompany.hr.FieldSetTuple__net$__$unconventional$__$persistence$_CC_$MATRIXPROG$__$PERSISTENCE$_S_$MATRIXPROG$__$PERSISTENCE$__$SETTINGS)descriptor53$_X_$MATRIXPROG_PERSISTENCE_SETTINGS.get_FieldSet_Tuple(executeInfo);
			descriptor53$_X_$MATRIXPROG_PERSISTENCE_SETTINGS$_X_$__FieldSet.set_IsPersistentMatrix(executeInfo, AppSymbols.IsPersistent );
			schemaSet_ScopeStack.add(descriptor53$_X_$MATRIXPROG_PERSISTENCE_SETTINGS$_X_$__UsesSchemaSet);
			descriptor52$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor53$_X_$MATRIXPROG_PERSISTENCE_SETTINGS);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventional.persistence::MATRIXPROG.PERSISTENCE::MATRIXPROG.PERSISTENCE.SETTINGS, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and label, `id1` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor54$_X_$EMPLOYEE$_X_$__UsesSchemaSet;
		Descriptor descriptor54$_X_$EMPLOYEE;

		try {
			descriptor54$_X_$EMPLOYEE$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor54$_X_$EMPLOYEE = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_CC_$EMPLOYEE), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("id1"), 0, true), descriptor54$_X_$EMPLOYEE$_X_$__UsesSchemaSet, descriptor52$_X_$MATRIX, 9);
			com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE descriptor54$_X_$EMPLOYEE$_X_$__FieldSet = (com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE)descriptor54$_X_$EMPLOYEE.get_FieldSet_Tuple(executeInfo);
			descriptor54$_X_$EMPLOYEE$_X_$__FieldSet.set_FullName(executeInfo, "Bill Smith" );
			descriptor54$_X_$EMPLOYEE$_X_$__FieldSet.set_Title(executeInfo, "CEO" );
			schemaSet_ScopeStack.add(descriptor54$_X_$EMPLOYEE$_X_$__UsesSchemaSet);
			descriptor52$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor54$_X_$EMPLOYEE);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and with label, id1, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and label, `id2` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor55$_X_$EMPLOYEE$_X_$__UsesSchemaSet;
		Descriptor descriptor55$_X_$EMPLOYEE;

		try {
			descriptor55$_X_$EMPLOYEE$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor55$_X_$EMPLOYEE = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_CC_$EMPLOYEE), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("id2"), 0, true), descriptor55$_X_$EMPLOYEE$_X_$__UsesSchemaSet, descriptor54$_X_$EMPLOYEE, 10);
			com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE descriptor55$_X_$EMPLOYEE$_X_$__FieldSet = (com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE)descriptor55$_X_$EMPLOYEE.get_FieldSet_Tuple(executeInfo);
			descriptor55$_X_$EMPLOYEE$_X_$__FieldSet.set_FullName(executeInfo, "Jill Hughs" );
			descriptor55$_X_$EMPLOYEE$_X_$__FieldSet.set_Title(executeInfo, "CFO" );
			schemaSet_ScopeStack.add(descriptor55$_X_$EMPLOYEE$_X_$__UsesSchemaSet);
			descriptor54$_X_$EMPLOYEE.add_ChildDescriptor(executeInfo, descriptor55$_X_$EMPLOYEE);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and with label, id2, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and label, `id3` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor56$_X_$EMPLOYEE$_X_$__UsesSchemaSet;
		Descriptor descriptor56$_X_$EMPLOYEE;

		try {
			descriptor56$_X_$EMPLOYEE$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor56$_X_$EMPLOYEE = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_CC_$EMPLOYEE), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("id3"), 0, true), descriptor56$_X_$EMPLOYEE$_X_$__UsesSchemaSet, descriptor55$_X_$EMPLOYEE, 11);
			com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE descriptor56$_X_$EMPLOYEE$_X_$__FieldSet = (com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE)descriptor56$_X_$EMPLOYEE.get_FieldSet_Tuple(executeInfo);
			descriptor56$_X_$EMPLOYEE$_X_$__FieldSet.set_FullName(executeInfo, "Paul Taylor" );
			descriptor56$_X_$EMPLOYEE$_X_$__FieldSet.set_Title(executeInfo, "Head of Accounting" );
			schemaSet_ScopeStack.add(descriptor56$_X_$EMPLOYEE$_X_$__UsesSchemaSet);
			descriptor55$_X_$EMPLOYEE.add_ChildDescriptor(executeInfo, descriptor56$_X_$EMPLOYEE);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and with label, id3, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and label, `id4` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor57$_X_$EMPLOYEE$_X_$__UsesSchemaSet;
		Descriptor descriptor57$_X_$EMPLOYEE;

		try {
			descriptor57$_X_$EMPLOYEE$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor57$_X_$EMPLOYEE = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_CC_$EMPLOYEE), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("id4"), 0, true), descriptor57$_X_$EMPLOYEE$_X_$__UsesSchemaSet, descriptor54$_X_$EMPLOYEE, 12);
			com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE descriptor57$_X_$EMPLOYEE$_X_$__FieldSet = (com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE)descriptor57$_X_$EMPLOYEE.get_FieldSet_Tuple(executeInfo);
			descriptor57$_X_$EMPLOYEE$_X_$__FieldSet.set_FullName(executeInfo, "John Jones" );
			descriptor57$_X_$EMPLOYEE$_X_$__FieldSet.set_Title(executeInfo, "CTO" );
			schemaSet_ScopeStack.add(descriptor57$_X_$EMPLOYEE$_X_$__UsesSchemaSet);
			descriptor54$_X_$EMPLOYEE.add_ChildDescriptor(executeInfo, descriptor57$_X_$EMPLOYEE);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and with label, id4, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and label, `id5` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor58$_X_$EMPLOYEE$_X_$__UsesSchemaSet;
		Descriptor descriptor58$_X_$EMPLOYEE;

		try {
			descriptor58$_X_$EMPLOYEE$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor58$_X_$EMPLOYEE = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_CC_$EMPLOYEE), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("id5"), 0, true), descriptor58$_X_$EMPLOYEE$_X_$__UsesSchemaSet, descriptor57$_X_$EMPLOYEE, 13);
			com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE descriptor58$_X_$EMPLOYEE$_X_$__FieldSet = (com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE)descriptor58$_X_$EMPLOYEE.get_FieldSet_Tuple(executeInfo);
			descriptor58$_X_$EMPLOYEE$_X_$__FieldSet.set_FullName(executeInfo, "RJ Gill" );
			descriptor58$_X_$EMPLOYEE$_X_$__FieldSet.set_Title(executeInfo, "Head of Operations" );
			schemaSet_ScopeStack.add(descriptor58$_X_$EMPLOYEE$_X_$__UsesSchemaSet);
			descriptor57$_X_$EMPLOYEE.add_ChildDescriptor(executeInfo, descriptor58$_X_$EMPLOYEE);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and with label, id5, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and label, `id6` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor59$_X_$EMPLOYEE$_X_$__UsesSchemaSet;
		Descriptor descriptor59$_X_$EMPLOYEE;

		try {
			descriptor59$_X_$EMPLOYEE$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor59$_X_$EMPLOYEE = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_CC_$EMPLOYEE), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("id6"), 0, true), descriptor59$_X_$EMPLOYEE$_X_$__UsesSchemaSet, descriptor57$_X_$EMPLOYEE, 14);
			com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE descriptor59$_X_$EMPLOYEE$_X_$__FieldSet = (com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE)descriptor59$_X_$EMPLOYEE.get_FieldSet_Tuple(executeInfo);
			descriptor59$_X_$EMPLOYEE$_X_$__FieldSet.set_FullName(executeInfo, "Sally Ryan" );
			descriptor59$_X_$EMPLOYEE$_X_$__FieldSet.set_Title(executeInfo, "Head or Engineering" );
			schemaSet_ScopeStack.add(descriptor59$_X_$EMPLOYEE$_X_$__UsesSchemaSet);
			descriptor57$_X_$EMPLOYEE.add_ChildDescriptor(executeInfo, descriptor59$_X_$EMPLOYEE);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and with label, id6, but had an error", e);
		}

		matrix = (Matrix)descriptor52$_X_$MATRIX;

		return (Matrix)descriptor52$_X_$MATRIX;
	}




	public Class<?> get_AppControl_Class() throws ClassNotFoundException {
		return com.mycompany.hr.AppControl.class;
	}
	public AppControl_Base initialize_AppControl() { return initialize_AppControl(null, false); }
	public AppControl_Base initialize_AppControl(boolean running_AppControl_forMetacompilation) { return initialize_AppControl(null, running_AppControl_forMetacompilation); }
	public AppControl_Base initialize_AppControl(AppControl_Base existing_AppControl) { return initialize_AppControl(existing_AppControl, false); }
	public AppControl_Base initialize_AppControl(AppControl_Base existing_AppControl, boolean running_AppControl_forMetacompilation) {
		if (existing_AppControl != null)
			return com.mycompany.hr.AppControl.initializeApp(existing_AppControl, running_AppControl_forMetacompilation);
		else
			return com.mycompany.hr.AppControl.initializeApp(running_AppControl_forMetacompilation);
	}

	public AppControl_Base get_AppControl() {
		return com.mycompany.hr.AppControl.appControl;
	}

}
