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

		MatrixSet<SchemaInfo_Schema> descriptor11$_X_$MATRIX$_X_$__UsesSchemaSet;
		Descriptor descriptor11$_X_$MATRIX;

		try {
			descriptor11$_X_$MATRIX$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>().add(appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema), appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventional$__$persistence$_CC_$MATRIXPROG$__$PERSISTENCE));
			descriptor11$_X_$MATRIX = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Matrix(executeInfo, AppSymbols_Label.OrgChart, AppSymbols_DescTagName.com$__$mycompany$__$hr, true, descriptor11$_X_$MATRIX$_X_$__UsesSchemaSet, null, true, 7);
			schemaSet_ScopeStack.add(descriptor11$_X_$MATRIX$_X_$__UsesSchemaSet);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.BASE::MATRIX, and with label, OrgChart, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventional.persistence::MATRIXPROG.PERSISTENCE::MATRIXPROG.PERSISTENCE.SETTINGS __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor12$_X_$MATRIXPROG_PERSISTENCE_SETTINGS$_X_$__UsesSchemaSet;
		Descriptor descriptor12$_X_$MATRIXPROG_PERSISTENCE_SETTINGS;

		try {
			descriptor12$_X_$MATRIXPROG_PERSISTENCE_SETTINGS$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor12$_X_$MATRIXPROG_PERSISTENCE_SETTINGS = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventional$__$persistence$_CC_$MATRIXPROG$__$PERSISTENCE).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventional$__$persistence$_CC_$MATRIXPROG$__$PERSISTENCE$_CC_$MATRIXPROG$__$PERSISTENCE$__$SETTINGS), null, descriptor12$_X_$MATRIXPROG_PERSISTENCE_SETTINGS$_X_$__UsesSchemaSet, descriptor11$_X_$MATRIX, 8);
			com.mycompany.hr.FieldSetTuple__net$__$unconventional$__$persistence$_CC_$MATRIXPROG$__$PERSISTENCE$_S_$MATRIXPROG$__$PERSISTENCE$__$SETTINGS descriptor12$_X_$MATRIXPROG_PERSISTENCE_SETTINGS$_X_$__FieldSet = (com.mycompany.hr.FieldSetTuple__net$__$unconventional$__$persistence$_CC_$MATRIXPROG$__$PERSISTENCE$_S_$MATRIXPROG$__$PERSISTENCE$__$SETTINGS)descriptor12$_X_$MATRIXPROG_PERSISTENCE_SETTINGS.get_FieldSet_Tuple(executeInfo);
			descriptor12$_X_$MATRIXPROG_PERSISTENCE_SETTINGS$_X_$__FieldSet.set_IsPersistentMatrix(executeInfo, AppSymbols.IsPersistent );
			schemaSet_ScopeStack.add(descriptor12$_X_$MATRIXPROG_PERSISTENCE_SETTINGS$_X_$__UsesSchemaSet);
			descriptor11$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor12$_X_$MATRIXPROG_PERSISTENCE_SETTINGS);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventional.persistence::MATRIXPROG.PERSISTENCE::MATRIXPROG.PERSISTENCE.SETTINGS, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and label, `id1` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor13$_X_$EMPLOYEE$_X_$__UsesSchemaSet;
		Descriptor descriptor13$_X_$EMPLOYEE;

		try {
			descriptor13$_X_$EMPLOYEE$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor13$_X_$EMPLOYEE = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_CC_$EMPLOYEE), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("id1"), 0, true), descriptor13$_X_$EMPLOYEE$_X_$__UsesSchemaSet, descriptor11$_X_$MATRIX, 9);
			com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE descriptor13$_X_$EMPLOYEE$_X_$__FieldSet = (com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE)descriptor13$_X_$EMPLOYEE.get_FieldSet_Tuple(executeInfo);
			descriptor13$_X_$EMPLOYEE$_X_$__FieldSet.set_FullName(executeInfo, "Bill Smith" );
			descriptor13$_X_$EMPLOYEE$_X_$__FieldSet.set_Title(executeInfo, "CEO" );
			schemaSet_ScopeStack.add(descriptor13$_X_$EMPLOYEE$_X_$__UsesSchemaSet);
			descriptor11$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor13$_X_$EMPLOYEE);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and with label, id1, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and label, `id2` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor14$_X_$EMPLOYEE$_X_$__UsesSchemaSet;
		Descriptor descriptor14$_X_$EMPLOYEE;

		try {
			descriptor14$_X_$EMPLOYEE$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor14$_X_$EMPLOYEE = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_CC_$EMPLOYEE), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("id2"), 0, true), descriptor14$_X_$EMPLOYEE$_X_$__UsesSchemaSet, descriptor13$_X_$EMPLOYEE, 10);
			com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE descriptor14$_X_$EMPLOYEE$_X_$__FieldSet = (com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE)descriptor14$_X_$EMPLOYEE.get_FieldSet_Tuple(executeInfo);
			descriptor14$_X_$EMPLOYEE$_X_$__FieldSet.set_FullName(executeInfo, "Jill Hughs" );
			descriptor14$_X_$EMPLOYEE$_X_$__FieldSet.set_Title(executeInfo, "CFO" );
			schemaSet_ScopeStack.add(descriptor14$_X_$EMPLOYEE$_X_$__UsesSchemaSet);
			descriptor13$_X_$EMPLOYEE.add_ChildDescriptor(executeInfo, descriptor14$_X_$EMPLOYEE);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and with label, id2, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and label, `id3` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor15$_X_$EMPLOYEE$_X_$__UsesSchemaSet;
		Descriptor descriptor15$_X_$EMPLOYEE;

		try {
			descriptor15$_X_$EMPLOYEE$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor15$_X_$EMPLOYEE = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_CC_$EMPLOYEE), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("id3"), 0, true), descriptor15$_X_$EMPLOYEE$_X_$__UsesSchemaSet, descriptor14$_X_$EMPLOYEE, 11);
			com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE descriptor15$_X_$EMPLOYEE$_X_$__FieldSet = (com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE)descriptor15$_X_$EMPLOYEE.get_FieldSet_Tuple(executeInfo);
			descriptor15$_X_$EMPLOYEE$_X_$__FieldSet.set_FullName(executeInfo, "Paul Taylor" );
			descriptor15$_X_$EMPLOYEE$_X_$__FieldSet.set_Title(executeInfo, "Head of Accounting" );
			schemaSet_ScopeStack.add(descriptor15$_X_$EMPLOYEE$_X_$__UsesSchemaSet);
			descriptor14$_X_$EMPLOYEE.add_ChildDescriptor(executeInfo, descriptor15$_X_$EMPLOYEE);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and with label, id3, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and label, `id4` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor16$_X_$EMPLOYEE$_X_$__UsesSchemaSet;
		Descriptor descriptor16$_X_$EMPLOYEE;

		try {
			descriptor16$_X_$EMPLOYEE$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor16$_X_$EMPLOYEE = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_CC_$EMPLOYEE), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("id4"), 0, true), descriptor16$_X_$EMPLOYEE$_X_$__UsesSchemaSet, descriptor13$_X_$EMPLOYEE, 12);
			com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE descriptor16$_X_$EMPLOYEE$_X_$__FieldSet = (com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE)descriptor16$_X_$EMPLOYEE.get_FieldSet_Tuple(executeInfo);
			descriptor16$_X_$EMPLOYEE$_X_$__FieldSet.set_FullName(executeInfo, "John Jones" );
			descriptor16$_X_$EMPLOYEE$_X_$__FieldSet.set_Title(executeInfo, "CTO" );
			schemaSet_ScopeStack.add(descriptor16$_X_$EMPLOYEE$_X_$__UsesSchemaSet);
			descriptor13$_X_$EMPLOYEE.add_ChildDescriptor(executeInfo, descriptor16$_X_$EMPLOYEE);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and with label, id4, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and label, `id5` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor17$_X_$EMPLOYEE$_X_$__UsesSchemaSet;
		Descriptor descriptor17$_X_$EMPLOYEE;

		try {
			descriptor17$_X_$EMPLOYEE$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor17$_X_$EMPLOYEE = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_CC_$EMPLOYEE), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("id5"), 0, true), descriptor17$_X_$EMPLOYEE$_X_$__UsesSchemaSet, descriptor16$_X_$EMPLOYEE, 13);
			com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE descriptor17$_X_$EMPLOYEE$_X_$__FieldSet = (com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE)descriptor17$_X_$EMPLOYEE.get_FieldSet_Tuple(executeInfo);
			descriptor17$_X_$EMPLOYEE$_X_$__FieldSet.set_FullName(executeInfo, "RJ Gill" );
			descriptor17$_X_$EMPLOYEE$_X_$__FieldSet.set_Title(executeInfo, "Head of Operations" );
			schemaSet_ScopeStack.add(descriptor17$_X_$EMPLOYEE$_X_$__UsesSchemaSet);
			descriptor16$_X_$EMPLOYEE.add_ChildDescriptor(executeInfo, descriptor17$_X_$EMPLOYEE);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and with label, id5, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and label, `id6` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor18$_X_$EMPLOYEE$_X_$__UsesSchemaSet;
		Descriptor descriptor18$_X_$EMPLOYEE;

		try {
			descriptor18$_X_$EMPLOYEE$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor18$_X_$EMPLOYEE = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_CC_$EMPLOYEE), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("id6"), 0, true), descriptor18$_X_$EMPLOYEE$_X_$__UsesSchemaSet, descriptor16$_X_$EMPLOYEE, 14);
			com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE descriptor18$_X_$EMPLOYEE$_X_$__FieldSet = (com.mycompany.hr.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE)descriptor18$_X_$EMPLOYEE.get_FieldSet_Tuple(executeInfo);
			descriptor18$_X_$EMPLOYEE$_X_$__FieldSet.set_FullName(executeInfo, "Sally Ryan" );
			descriptor18$_X_$EMPLOYEE$_X_$__FieldSet.set_Title(executeInfo, "Head or Engineering" );
			schemaSet_ScopeStack.add(descriptor18$_X_$EMPLOYEE$_X_$__UsesSchemaSet);
			descriptor16$_X_$EMPLOYEE.add_ChildDescriptor(executeInfo, descriptor18$_X_$EMPLOYEE);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and with label, id6, but had an error", e);
		}

		matrix = (Matrix)descriptor11$_X_$MATRIX;

		return (Matrix)descriptor11$_X_$MATRIX;
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
