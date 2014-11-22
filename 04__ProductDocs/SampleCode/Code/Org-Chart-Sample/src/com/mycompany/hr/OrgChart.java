/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package com.mycompany.hr;

import net.unconventionalthinking.exceptions.*;
import samples.matrix.app.AppSymbols_MatrixName;
import samples.matrix.app.AppControl;
import net.unconventionalthinking.matrix.*;
import java.util.Arrays;
import samples.matrix.app.AppSymbols;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.*;
import samples.matrix.app.AppSymbols_SchemaName;
import samples.matrix.app.AppSymbols_Label;
import samples.matrix.app.AppSymbols_DescTag;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import samples.matrix.app.AppSymbols_DescTagName;
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

		MatrixSet<SchemaInfo_Schema> descriptor5$_X_$MATRIX$_X_$__UsesSchemaSet;
		Descriptor descriptor5$_X_$MATRIX;

		try {
			descriptor5$_X_$MATRIX$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>().add(appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema));
			descriptor5$_X_$MATRIX = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Matrix(executeInfo, AppSymbols_Label.OrgChart, AppSymbols_DescTagName.com$__$mycompany$__$hr, true, descriptor5$_X_$MATRIX$_X_$__UsesSchemaSet, null, true);
			schemaSet_ScopeStack.add(descriptor5$_X_$MATRIX$_X_$__UsesSchemaSet);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.BASE::MATRIX, and with label, OrgChart, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and label, `id1` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor6$_X_$EMPLOYEE$_X_$__UsesSchemaSet;
		Descriptor descriptor6$_X_$EMPLOYEE;

		try {
			descriptor6$_X_$EMPLOYEE$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor6$_X_$EMPLOYEE = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_CC_$EMPLOYEE), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("id1"), 0, true), descriptor6$_X_$EMPLOYEE$_X_$__UsesSchemaSet, descriptor5$_X_$MATRIX);
			samples.matrix.app.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE descriptor6$_X_$EMPLOYEE$_X_$__FieldSet = (samples.matrix.app.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE)descriptor6$_X_$EMPLOYEE.get_FieldSet_Tuple(executeInfo);
			descriptor6$_X_$EMPLOYEE$_X_$__FieldSet.set_FullName(executeInfo, "Bill Smith" );
			descriptor6$_X_$EMPLOYEE$_X_$__FieldSet.set_Title(executeInfo, "CEO" );
			schemaSet_ScopeStack.add(descriptor6$_X_$EMPLOYEE$_X_$__UsesSchemaSet);
			descriptor5$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor6$_X_$EMPLOYEE);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and with label, id1, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and label, `id2` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor7$_X_$EMPLOYEE$_X_$__UsesSchemaSet;
		Descriptor descriptor7$_X_$EMPLOYEE;

		try {
			descriptor7$_X_$EMPLOYEE$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor7$_X_$EMPLOYEE = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_CC_$EMPLOYEE), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("id2"), 0, true), descriptor7$_X_$EMPLOYEE$_X_$__UsesSchemaSet, descriptor6$_X_$EMPLOYEE);
			samples.matrix.app.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE descriptor7$_X_$EMPLOYEE$_X_$__FieldSet = (samples.matrix.app.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE)descriptor7$_X_$EMPLOYEE.get_FieldSet_Tuple(executeInfo);
			descriptor7$_X_$EMPLOYEE$_X_$__FieldSet.set_FullName(executeInfo, "Jill Hughs" );
			descriptor7$_X_$EMPLOYEE$_X_$__FieldSet.set_Title(executeInfo, "CFO" );
			schemaSet_ScopeStack.add(descriptor7$_X_$EMPLOYEE$_X_$__UsesSchemaSet);
			descriptor6$_X_$EMPLOYEE.add_ChildDescriptor(executeInfo, descriptor7$_X_$EMPLOYEE);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and with label, id2, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and label, `id3` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor8$_X_$EMPLOYEE$_X_$__UsesSchemaSet;
		Descriptor descriptor8$_X_$EMPLOYEE;

		try {
			descriptor8$_X_$EMPLOYEE$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor8$_X_$EMPLOYEE = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_CC_$EMPLOYEE), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("id3"), 0, true), descriptor8$_X_$EMPLOYEE$_X_$__UsesSchemaSet, descriptor7$_X_$EMPLOYEE);
			samples.matrix.app.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE descriptor8$_X_$EMPLOYEE$_X_$__FieldSet = (samples.matrix.app.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE)descriptor8$_X_$EMPLOYEE.get_FieldSet_Tuple(executeInfo);
			descriptor8$_X_$EMPLOYEE$_X_$__FieldSet.set_FullName(executeInfo, "Paul Taylor" );
			descriptor8$_X_$EMPLOYEE$_X_$__FieldSet.set_Title(executeInfo, "Head of Accounting" );
			schemaSet_ScopeStack.add(descriptor8$_X_$EMPLOYEE$_X_$__UsesSchemaSet);
			descriptor7$_X_$EMPLOYEE.add_ChildDescriptor(executeInfo, descriptor8$_X_$EMPLOYEE);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and with label, id3, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and label, `id4` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor9$_X_$EMPLOYEE$_X_$__UsesSchemaSet;
		Descriptor descriptor9$_X_$EMPLOYEE;

		try {
			descriptor9$_X_$EMPLOYEE$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor9$_X_$EMPLOYEE = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_CC_$EMPLOYEE), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("id4"), 0, true), descriptor9$_X_$EMPLOYEE$_X_$__UsesSchemaSet, descriptor6$_X_$EMPLOYEE);
			samples.matrix.app.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE descriptor9$_X_$EMPLOYEE$_X_$__FieldSet = (samples.matrix.app.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE)descriptor9$_X_$EMPLOYEE.get_FieldSet_Tuple(executeInfo);
			descriptor9$_X_$EMPLOYEE$_X_$__FieldSet.set_FullName(executeInfo, "John Jones" );
			descriptor9$_X_$EMPLOYEE$_X_$__FieldSet.set_Title(executeInfo, "CTO" );
			schemaSet_ScopeStack.add(descriptor9$_X_$EMPLOYEE$_X_$__UsesSchemaSet);
			descriptor6$_X_$EMPLOYEE.add_ChildDescriptor(executeInfo, descriptor9$_X_$EMPLOYEE);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and with label, id4, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and label, `id5` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor10$_X_$EMPLOYEE$_X_$__UsesSchemaSet;
		Descriptor descriptor10$_X_$EMPLOYEE;

		try {
			descriptor10$_X_$EMPLOYEE$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor10$_X_$EMPLOYEE = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_CC_$EMPLOYEE), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("id5"), 0, true), descriptor10$_X_$EMPLOYEE$_X_$__UsesSchemaSet, descriptor9$_X_$EMPLOYEE);
			samples.matrix.app.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE descriptor10$_X_$EMPLOYEE$_X_$__FieldSet = (samples.matrix.app.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE)descriptor10$_X_$EMPLOYEE.get_FieldSet_Tuple(executeInfo);
			descriptor10$_X_$EMPLOYEE$_X_$__FieldSet.set_FullName(executeInfo, "RJ Gill" );
			descriptor10$_X_$EMPLOYEE$_X_$__FieldSet.set_Title(executeInfo, "Head of Operations" );
			schemaSet_ScopeStack.add(descriptor10$_X_$EMPLOYEE$_X_$__UsesSchemaSet);
			descriptor9$_X_$EMPLOYEE.add_ChildDescriptor(executeInfo, descriptor10$_X_$EMPLOYEE);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and with label, id5, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and label, `id6` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor11$_X_$EMPLOYEE$_X_$__UsesSchemaSet;
		Descriptor descriptor11$_X_$EMPLOYEE;

		try {
			descriptor11$_X_$EMPLOYEE$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor11$_X_$EMPLOYEE = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_CC_$EMPLOYEE), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("id6"), 0, true), descriptor11$_X_$EMPLOYEE$_X_$__UsesSchemaSet, descriptor9$_X_$EMPLOYEE);
			samples.matrix.app.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE descriptor11$_X_$EMPLOYEE$_X_$__FieldSet = (samples.matrix.app.FieldSetTuple__com$__$mycompany$__$hr$_CC_$OrgChart$__$Schema$_S_$EMPLOYEE)descriptor11$_X_$EMPLOYEE.get_FieldSet_Tuple(executeInfo);
			descriptor11$_X_$EMPLOYEE$_X_$__FieldSet.set_FullName(executeInfo, "Sally Ryan" );
			descriptor11$_X_$EMPLOYEE$_X_$__FieldSet.set_Title(executeInfo, "Head or Engineering" );
			schemaSet_ScopeStack.add(descriptor11$_X_$EMPLOYEE$_X_$__UsesSchemaSet);
			descriptor9$_X_$EMPLOYEE.add_ChildDescriptor(executeInfo, descriptor11$_X_$EMPLOYEE);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, com.mycompany.hr::OrgChart.Schema::EMPLOYEE, and with label, id6, but had an error", e);
		}

		matrix = (Matrix)descriptor5$_X_$MATRIX;

		return (Matrix)descriptor5$_X_$MATRIX;
	}




	public Class<?> get_AppControl_Class() throws ClassNotFoundException {
		return samples.matrix.app.AppControl.class;
	}
	public AppControl_Base initialize_AppControl() { return initialize_AppControl(null, false); }
	public AppControl_Base initialize_AppControl(boolean running_AppControl_forMetacompilation) { return initialize_AppControl(null, running_AppControl_forMetacompilation); }
	public AppControl_Base initialize_AppControl(AppControl_Base existing_AppControl) { return initialize_AppControl(existing_AppControl, false); }
	public AppControl_Base initialize_AppControl(AppControl_Base existing_AppControl, boolean running_AppControl_forMetacompilation) {
		if (existing_AppControl != null)
			return samples.matrix.app.AppControl.initializeApp(existing_AppControl, running_AppControl_forMetacompilation);
		else
			return samples.matrix.app.AppControl.initializeApp(running_AppControl_forMetacompilation);
	}

	public AppControl_Base get_AppControl() {
		return samples.matrix.app.AppControl.appControl;
	}

}
