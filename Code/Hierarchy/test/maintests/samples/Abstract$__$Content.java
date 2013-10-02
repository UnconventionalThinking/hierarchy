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

/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package maintests.samples;

import net.unconventionalthinking.exceptions.*;
import net.unconventionalthinking.matrix.*;
import java.util.Arrays;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import java.util.LinkedList;




public class Abstract$__$Content implements MatrixContainer {

	public static Matrix matrix;


	public static Matrix construct(AppControl_Base appControl, ExecutionInfo executeInfo)
		throws Exception_MatrixRuntime_Checked {

		LinkedList<MatrixSet<SchemaInfo_Schema>> schemaSet_ScopeStack = new LinkedList<MatrixSet<SchemaInfo_Schema>>();

		//  Creating Matrix with name, Abstract.Content __________________________________________________
		try {
			schemaSet_ScopeStack.add(new MatrixSet<SchemaInfo_Schema>().add(
				appControl.schemaControl.schemaFactory.get_BaseSchema(executeInfo),
				appControl.schemaControl.schemaForSchema
			));
		} catch (Exception e) {
			throw new Exception_MatrixRuntime_Checked("while trying to create a new Matrix Or Schema descriptor with the name, `Abstract`.`Content`," + 
				" tried to add the Base Schema to the scope stack, but had an error creating it (see inner exception).", e);
		}

		MatrixSet<SchemaInfo_Schema> descriptor43$_X_$MATRIX$_X_$__UsesSchemaSet;
		Descriptor descriptor43$_X_$MATRIX;

		try {
			descriptor43$_X_$MATRIX$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>().add(appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Web$__$Content));
			descriptor43$_X_$MATRIX = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Matrix(executeInfo, AppSymbols_Label.Abstract$__$Content, AppSymbols_DescTagName.maintests$__$samples, true, descriptor43$_X_$MATRIX$_X_$__UsesSchemaSet, null, true);
			schemaSet_ScopeStack.add(descriptor43$_X_$MATRIX$_X_$__UsesSchemaSet);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.BASE::MATRIX, and with label, `Abstract`.`Content`, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `Home` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor44$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor44$_X_$ITEM;

		try {
			descriptor44$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor44$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("Home"), 0, true), descriptor44$_X_$ITEM$_X_$__UsesSchemaSet, descriptor43$_X_$MATRIX);
			schemaSet_ScopeStack.add(descriptor44$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor43$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor44$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, Home, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::Web.Content::PAGE.INFO __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor45$_X_$PAGE_INFO$_X_$__UsesSchemaSet;
		Descriptor descriptor45$_X_$PAGE_INFO;

		try {
			descriptor45$_X_$PAGE_INFO$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor45$_X_$PAGE_INFO = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Web$__$Content).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$PAGE$__$INFO), null, descriptor45$_X_$PAGE_INFO$_X_$__UsesSchemaSet, descriptor44$_X_$ITEM);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$PAGE$__$INFO descriptor45$_X_$PAGE_INFO$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$PAGE$__$INFO)descriptor45$_X_$PAGE_INFO.get_FieldSet_Tuple(executeInfo);
			descriptor45$_X_$PAGE_INFO$_X_$__FieldSet.set_Name_NoSpaces(executeInfo, "home" );
			descriptor45$_X_$PAGE_INFO$_X_$__FieldSet.set_Page_ID(executeInfo, 0 );
			descriptor45$_X_$PAGE_INFO$_X_$__FieldSet.set_Title(executeInfo, "Home" );
			descriptor45$_X_$PAGE_INFO$_X_$__FieldSet.set_BlurbText(executeInfo, "We build good software. We provide software consulting for many areas of industry: financial, automotive, software retailers, and other forms of technology and business. And, we develop our own software products to help improve our world. We truly enjoy developing software that enhances your quality of life." );
			descriptor45$_X_$PAGE_INFO$_X_$__FieldSet.set_LNav_Href(executeInfo, "" );
			descriptor45$_X_$PAGE_INFO$_X_$__FieldSet.set_LNav_Image(executeInfo, "" );
			descriptor45$_X_$PAGE_INFO$_X_$__FieldSet.set_LNav_IsActive(executeInfo, false );
			schemaSet_ScopeStack.add(descriptor45$_X_$PAGE_INFO$_X_$__UsesSchemaSet);
			descriptor44$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor45$_X_$PAGE_INFO);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::Web.Content::PAGE.INFO, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::Web.Content::NEWS __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor46$_X_$NEWS$_X_$__UsesSchemaSet;
		Descriptor descriptor46$_X_$NEWS;

		try {
			descriptor46$_X_$NEWS$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor46$_X_$NEWS = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Web$__$Content).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$NEWS), null, descriptor46$_X_$NEWS$_X_$__UsesSchemaSet, descriptor44$_X_$ITEM);
			schemaSet_ScopeStack.add(descriptor46$_X_$NEWS$_X_$__UsesSchemaSet);
			descriptor44$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor46$_X_$NEWS);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::Web.Content::NEWS, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::Web.Content::NEWS.STORY __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor47$_X_$NEWS_STORY$_X_$__UsesSchemaSet;
		Descriptor descriptor47$_X_$NEWS_STORY;

		try {
			descriptor47$_X_$NEWS_STORY$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor47$_X_$NEWS_STORY = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Web$__$Content).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$NEWS).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$NEWS$__$STORY), null, descriptor47$_X_$NEWS_STORY$_X_$__UsesSchemaSet, descriptor46$_X_$NEWS);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$NEWS$_S_$NEWS$__$STORY descriptor47$_X_$NEWS_STORY$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$NEWS$_S_$NEWS$__$STORY)descriptor47$_X_$NEWS_STORY.get_FieldSet_Tuple(executeInfo);
			descriptor47$_X_$NEWS_STORY$_X_$__FieldSet.set_NewsItem_ID(executeInfo, "N-Dimensional Architecture" );
			descriptor47$_X_$NEWS_STORY$_X_$__FieldSet.set_Title(executeInfo, "Research and Development on N-Dimensional Architecture Yields New Meta-Compiler for Java" );
			descriptor47$_X_$NEWS_STORY$_X_$__FieldSet.set_DateText(executeInfo, "December 1<sup>st</sup>, 2009" );
			descriptor47$_X_$NEWS_STORY$_X_$__FieldSet.set_Story_Blurb(executeInfo, "We have been researching theories on system architecture for over four years and are nearly ready to show the results of our countless days working late into the night. We have created a meta-compiler for Java with which developers can create systems designed with the principles of N-Dimensional Architecture. Traditionally, when software developers use the ideas of 3-tier architectures, they organize their systems using one design characteristic. N-Dimensional Architecture is a new technique for designing software systems that organize them using more than one characteristic at the same time. The resulting systems are simplier to understand, but more flexible for future changes and for handling systems that are larger and more complex. The first major features to roll out will be the meta-compiler for the Matrix data-structure and for Matrix-Programming. We plan to release an alpha version for customers to preview in early 2010!" );
			schemaSet_ScopeStack.add(descriptor47$_X_$NEWS_STORY$_X_$__UsesSchemaSet);
			descriptor46$_X_$NEWS.add_ChildDescriptor(executeInfo, descriptor47$_X_$NEWS_STORY);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::Web.Content::NEWS.STORY, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::Web.Content::NEWS.STORY __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor48$_X_$NEWS_STORY$_X_$__UsesSchemaSet;
		Descriptor descriptor48$_X_$NEWS_STORY;

		try {
			descriptor48$_X_$NEWS_STORY$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor48$_X_$NEWS_STORY = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Web$__$Content).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$NEWS).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$NEWS$__$STORY), null, descriptor48$_X_$NEWS_STORY$_X_$__UsesSchemaSet, descriptor46$_X_$NEWS);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$NEWS$_S_$NEWS$__$STORY descriptor48$_X_$NEWS_STORY$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$NEWS$_S_$NEWS$__$STORY)descriptor48$_X_$NEWS_STORY.get_FieldSet_Tuple(executeInfo);
			descriptor48$_X_$NEWS_STORY$_X_$__FieldSet.set_NewsItem_ID(executeInfo, "Vanso" );
			descriptor48$_X_$NEWS_STORY$_X_$__FieldSet.set_Title(executeInfo, "Creating a High-Volume, Bulk SMS-Message Sender for Vanso " );
			descriptor48$_X_$NEWS_STORY$_X_$__FieldSet.set_DateText(executeInfo, "December 1<sup>st</sup>, 2009" );
			descriptor48$_X_$NEWS_STORY$_X_$__FieldSet.set_Story_Blurb(executeInfo, "We're creating a bulk message sender for txt messages that uses surprisingly little resources while being able to send millions of messages per hour! This little, mighty server is being implemented in SMPP and Java. " );
			schemaSet_ScopeStack.add(descriptor48$_X_$NEWS_STORY$_X_$__UsesSchemaSet);
			descriptor46$_X_$NEWS.add_ChildDescriptor(executeInfo, descriptor48$_X_$NEWS_STORY);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::Web.Content::NEWS.STORY, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::Web.Content::NEWS.STORY __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor49$_X_$NEWS_STORY$_X_$__UsesSchemaSet;
		Descriptor descriptor49$_X_$NEWS_STORY;

		try {
			descriptor49$_X_$NEWS_STORY$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor49$_X_$NEWS_STORY = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Web$__$Content).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$NEWS).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$NEWS$__$STORY), null, descriptor49$_X_$NEWS_STORY$_X_$__UsesSchemaSet, descriptor46$_X_$NEWS);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$NEWS$_S_$NEWS$__$STORY descriptor49$_X_$NEWS_STORY$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$NEWS$_S_$NEWS$__$STORY)descriptor49$_X_$NEWS_STORY.get_FieldSet_Tuple(executeInfo);
			descriptor49$_X_$NEWS_STORY$_X_$__FieldSet.set_NewsItem_ID(executeInfo, "Rubbermaid" );
			descriptor49$_X_$NEWS_STORY$_X_$__FieldSet.set_Title(executeInfo, "Building Web Services and Content Management Systems for Rubbermaid" );
			descriptor49$_X_$NEWS_STORY$_X_$__FieldSet.set_DateText(executeInfo, "February 20<sup>th</sup>, 2007" );
			descriptor49$_X_$NEWS_STORY$_X_$__FieldSet.set_Story_Blurb(executeInfo, "We are currently working to help Rubbermaid to securely connect to their clients and partners using web services. We are also working with them to create an easy to use but powerful interface for managing the content on their site, <a href ='http://www.rcpworksmarter.com'>http://www.rcpworksmarter.com</a>." );
			schemaSet_ScopeStack.add(descriptor49$_X_$NEWS_STORY$_X_$__UsesSchemaSet);
			descriptor46$_X_$NEWS.add_ChildDescriptor(executeInfo, descriptor49$_X_$NEWS_STORY);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::Web.Content::NEWS.STORY, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::Web.Content::NEWS.STORY __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor50$_X_$NEWS_STORY$_X_$__UsesSchemaSet;
		Descriptor descriptor50$_X_$NEWS_STORY;

		try {
			descriptor50$_X_$NEWS_STORY$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor50$_X_$NEWS_STORY = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Web$__$Content).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$NEWS).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$NEWS$__$STORY), null, descriptor50$_X_$NEWS_STORY$_X_$__UsesSchemaSet, descriptor46$_X_$NEWS);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$NEWS$_S_$NEWS$__$STORY descriptor50$_X_$NEWS_STORY$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$NEWS$_S_$NEWS$__$STORY)descriptor50$_X_$NEWS_STORY.get_FieldSet_Tuple(executeInfo);
			descriptor50$_X_$NEWS_STORY$_X_$__FieldSet.set_NewsItem_ID(executeInfo, "Unisys" );
			descriptor50$_X_$NEWS_STORY$_X_$__FieldSet.set_Title(executeInfo, "Building Web Services for the Unisys Corporation!" );
			descriptor50$_X_$NEWS_STORY$_X_$__FieldSet.set_DateText(executeInfo, "June 24<sup>th</sup>, 2006" );
			descriptor50$_X_$NEWS_STORY$_X_$__FieldSet.set_Story_Blurb(executeInfo, "We have formed a new relationship with the Unisys Corporation. One of our developers is helping Unisys build a hand-writing recognition-system for the banking industry. This system will be a web service that will save financial corporations millions in overhead for many of their transactions. Unisys is one of the top banking computing-services in the world." );
			schemaSet_ScopeStack.add(descriptor50$_X_$NEWS_STORY$_X_$__UsesSchemaSet);
			descriptor46$_X_$NEWS.add_ChildDescriptor(executeInfo, descriptor50$_X_$NEWS_STORY);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::Web.Content::NEWS.STORY, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::Web.Content::NEWS.STORY __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor51$_X_$NEWS_STORY$_X_$__UsesSchemaSet;
		Descriptor descriptor51$_X_$NEWS_STORY;

		try {
			descriptor51$_X_$NEWS_STORY$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor51$_X_$NEWS_STORY = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Web$__$Content).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$NEWS).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$NEWS$__$STORY), null, descriptor51$_X_$NEWS_STORY$_X_$__UsesSchemaSet, descriptor46$_X_$NEWS);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$NEWS$_S_$NEWS$__$STORY descriptor51$_X_$NEWS_STORY$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$NEWS$_S_$NEWS$__$STORY)descriptor51$_X_$NEWS_STORY.get_FieldSet_Tuple(executeInfo);
			descriptor51$_X_$NEWS_STORY$_X_$__FieldSet.set_NewsItem_ID(executeInfo, "Opening" );
			descriptor51$_X_$NEWS_STORY$_X_$__FieldSet.set_Title(executeInfo, "Abstract Systems opens its doors with its first project!" );
			descriptor51$_X_$NEWS_STORY$_X_$__FieldSet.set_DateText(executeInfo, "May, 2006" );
			descriptor51$_X_$NEWS_STORY$_X_$__FieldSet.set_Story_Blurb(executeInfo, "It has taken a great deal of work, but Abstract Systems is now ready to provide customers with great " + "service " + "and innovative products. " + "Abstract Systems was formed by three seasoned, software-development specialists and one skilled and highly respected, sales and marketing manager." + " And, we have already received our first project! We are currently working on sales and production tracking software for a large furniture manufacturer." );
			schemaSet_ScopeStack.add(descriptor51$_X_$NEWS_STORY$_X_$__UsesSchemaSet);
			descriptor46$_X_$NEWS.add_ChildDescriptor(executeInfo, descriptor51$_X_$NEWS_STORY);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::Web.Content::NEWS.STORY, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `Services` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor52$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor52$_X_$ITEM;

		try {
			descriptor52$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor52$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("Services"), 0, true), descriptor52$_X_$ITEM$_X_$__UsesSchemaSet, descriptor43$_X_$MATRIX);
			schemaSet_ScopeStack.add(descriptor52$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor43$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor52$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, Services, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::Web.Content::PAGE.INFO __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor53$_X_$PAGE_INFO$_X_$__UsesSchemaSet;
		Descriptor descriptor53$_X_$PAGE_INFO;

		try {
			descriptor53$_X_$PAGE_INFO$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor53$_X_$PAGE_INFO = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Web$__$Content).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$PAGE$__$INFO), null, descriptor53$_X_$PAGE_INFO$_X_$__UsesSchemaSet, descriptor52$_X_$ITEM);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$PAGE$__$INFO descriptor53$_X_$PAGE_INFO$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$PAGE$__$INFO)descriptor53$_X_$PAGE_INFO.get_FieldSet_Tuple(executeInfo);
			descriptor53$_X_$PAGE_INFO$_X_$__FieldSet.set_Name_NoSpaces(executeInfo, "services" );
			descriptor53$_X_$PAGE_INFO$_X_$__FieldSet.set_Page_ID(executeInfo, 1 );
			descriptor53$_X_$PAGE_INFO$_X_$__FieldSet.set_Title(executeInfo, "Services" );
			descriptor53$_X_$PAGE_INFO$_X_$__FieldSet.set_BlurbText(executeInfo, "We believe in developing the best software possible. We do our best to find software developers with only the best skill and experience in their fields. All our Developers, Architects, Managers, Requirements Modelers and Testers believe that focusing on good quality software development will save you time and money.   Fewer problems, fewer headaches. More features and innovation." );
			descriptor53$_X_$PAGE_INFO$_X_$__FieldSet.set_LNav_Href(executeInfo, "" );
			descriptor53$_X_$PAGE_INFO$_X_$__FieldSet.set_LNav_Image(executeInfo, "" );
			descriptor53$_X_$PAGE_INFO$_X_$__FieldSet.set_LNav_IsActive(executeInfo, false );
			schemaSet_ScopeStack.add(descriptor53$_X_$PAGE_INFO$_X_$__UsesSchemaSet);
			descriptor52$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor53$_X_$PAGE_INFO);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::Web.Content::PAGE.INFO, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `Research` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor54$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor54$_X_$ITEM;

		try {
			descriptor54$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor54$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("Research"), 0, true), descriptor54$_X_$ITEM$_X_$__UsesSchemaSet, descriptor43$_X_$MATRIX);
			schemaSet_ScopeStack.add(descriptor54$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor43$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor54$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, Research, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::Web.Content::PAGE.INFO __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor55$_X_$PAGE_INFO$_X_$__UsesSchemaSet;
		Descriptor descriptor55$_X_$PAGE_INFO;

		try {
			descriptor55$_X_$PAGE_INFO$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor55$_X_$PAGE_INFO = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Web$__$Content).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$PAGE$__$INFO), null, descriptor55$_X_$PAGE_INFO$_X_$__UsesSchemaSet, descriptor54$_X_$ITEM);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$PAGE$__$INFO descriptor55$_X_$PAGE_INFO$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$PAGE$__$INFO)descriptor55$_X_$PAGE_INFO.get_FieldSet_Tuple(executeInfo);
			descriptor55$_X_$PAGE_INFO$_X_$__FieldSet.set_Name_NoSpaces(executeInfo, "research" );
			descriptor55$_X_$PAGE_INFO$_X_$__FieldSet.set_Page_ID(executeInfo, 2 );
			descriptor55$_X_$PAGE_INFO$_X_$__FieldSet.set_Title(executeInfo, "Research" );
			descriptor55$_X_$PAGE_INFO$_X_$__FieldSet.set_BlurbText(executeInfo, "New ideas, ground-breaking products, and better techniques. Our first goal in research is to find new and useful ideas for our software products. Great ideas make great products. Our second goal is to find innovative methods to build software better and quicker. Better methods for building software allows developers to focus more on creating and less on fixing problems." );
			descriptor55$_X_$PAGE_INFO$_X_$__FieldSet.set_LNav_Href(executeInfo, "" );
			descriptor55$_X_$PAGE_INFO$_X_$__FieldSet.set_LNav_Image(executeInfo, "" );
			descriptor55$_X_$PAGE_INFO$_X_$__FieldSet.set_LNav_IsActive(executeInfo, false );
			schemaSet_ScopeStack.add(descriptor55$_X_$PAGE_INFO$_X_$__UsesSchemaSet);
			descriptor54$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor55$_X_$PAGE_INFO);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::Web.Content::PAGE.INFO, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::Web.Content::NEWS __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor56$_X_$NEWS$_X_$__UsesSchemaSet;
		Descriptor descriptor56$_X_$NEWS;

		try {
			descriptor56$_X_$NEWS$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor56$_X_$NEWS = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Web$__$Content).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$NEWS), null, descriptor56$_X_$NEWS$_X_$__UsesSchemaSet, descriptor54$_X_$ITEM);
			schemaSet_ScopeStack.add(descriptor56$_X_$NEWS$_X_$__UsesSchemaSet);
			descriptor54$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor56$_X_$NEWS);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::Web.Content::NEWS, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::Web.Content::NEWS.STORY __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor57$_X_$NEWS_STORY$_X_$__UsesSchemaSet;
		Descriptor descriptor57$_X_$NEWS_STORY;

		try {
			descriptor57$_X_$NEWS_STORY$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor57$_X_$NEWS_STORY = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Web$__$Content).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$NEWS).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$NEWS$__$STORY), null, descriptor57$_X_$NEWS_STORY$_X_$__UsesSchemaSet, descriptor56$_X_$NEWS);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$NEWS$_S_$NEWS$__$STORY descriptor57$_X_$NEWS_STORY$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$NEWS$_S_$NEWS$__$STORY)descriptor57$_X_$NEWS_STORY.get_FieldSet_Tuple(executeInfo);
			descriptor57$_X_$NEWS_STORY$_X_$__FieldSet.set_NewsItem_ID(executeInfo, "NDA" );
			descriptor57$_X_$NEWS_STORY$_X_$__FieldSet.set_Title(executeInfo, "N-Dimensional Architecture with Scaling" );
			descriptor57$_X_$NEWS_STORY$_X_$__FieldSet.set_DateText(executeInfo, null );
			descriptor57$_X_$NEWS_STORY$_X_$__FieldSet.set_Story_Blurb(executeInfo, "We are currently researching a new form of multi-dimensional software architecture. Traditional architectures are typically one dimensional. Some of the most well know one-dimensional architectures are <b>3-Tier</b> and <b>MVC</b> architectures*. These one-dimensional architectures organize a system based on only one characteristic of the system, object behavior (is the object a \"view\" object? or is it a \"model\" object?). Multi-dimensional architectures organize a system based on more than one characteristic of a system simultaneously (one of the most well known is Multi-Dimensional Separation of Concerns - MDSOC)." + "<p>" + "One of the toughest challenges in designing large systems is managing the great deal of complexity from the numerous objects and all their different relationships. Multi-dimensional architectures better manage this complexity by allowing architects to organize these objects in multiple ways. The goal is that the developers of these systems should more easily understand the system organization, reducing the learning curve and thus, development time. We are researching a new form of multi-dimensional architecture called N-Dimensional Architecture with Scaling. We hope this work will provide software architects and developers with new, beneficial ways of designing their software systems." + "<br><br><br>*Note: Many software architects consider MVC and 3-Tier Architecture to be relatively very different, operating at two different levels of a system architecture. If you think of these two as they do, they can even be used together in the same system." );
			schemaSet_ScopeStack.add(descriptor57$_X_$NEWS_STORY$_X_$__UsesSchemaSet);
			descriptor56$_X_$NEWS.add_ChildDescriptor(executeInfo, descriptor57$_X_$NEWS_STORY);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::Web.Content::NEWS.STORY, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `Products` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor58$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor58$_X_$ITEM;

		try {
			descriptor58$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor58$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("Products"), 0, true), descriptor58$_X_$ITEM$_X_$__UsesSchemaSet, descriptor43$_X_$MATRIX);
			schemaSet_ScopeStack.add(descriptor58$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor43$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor58$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, Products, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::Web.Content::PAGE.INFO __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor59$_X_$PAGE_INFO$_X_$__UsesSchemaSet;
		Descriptor descriptor59$_X_$PAGE_INFO;

		try {
			descriptor59$_X_$PAGE_INFO$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor59$_X_$PAGE_INFO = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Web$__$Content).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$PAGE$__$INFO), null, descriptor59$_X_$PAGE_INFO$_X_$__UsesSchemaSet, descriptor58$_X_$ITEM);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$PAGE$__$INFO descriptor59$_X_$PAGE_INFO$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$PAGE$__$INFO)descriptor59$_X_$PAGE_INFO.get_FieldSet_Tuple(executeInfo);
			descriptor59$_X_$PAGE_INFO$_X_$__FieldSet.set_Name_NoSpaces(executeInfo, "products" );
			descriptor59$_X_$PAGE_INFO$_X_$__FieldSet.set_Page_ID(executeInfo, 3 );
			descriptor59$_X_$PAGE_INFO$_X_$__FieldSet.set_Title(executeInfo, "Products" );
			descriptor59$_X_$PAGE_INFO$_X_$__FieldSet.set_BlurbText(executeInfo, "We truly enjoy creating good software. Many applications are slow, crash or have poorly designed features. Bad applications make users sad. Building software that is powerful and easy to use, and reliable and responsive takes a lot of hard work, but we feel the greatest satisfaction in seeing our users happy. " );
			descriptor59$_X_$PAGE_INFO$_X_$__FieldSet.set_LNav_Href(executeInfo, "" );
			descriptor59$_X_$PAGE_INFO$_X_$__FieldSet.set_LNav_Image(executeInfo, "" );
			descriptor59$_X_$PAGE_INFO$_X_$__FieldSet.set_LNav_IsActive(executeInfo, false );
			schemaSet_ScopeStack.add(descriptor59$_X_$PAGE_INFO$_X_$__UsesSchemaSet);
			descriptor58$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor59$_X_$PAGE_INFO);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::Web.Content::PAGE.INFO, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::Web.Content::NEWS __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor60$_X_$NEWS$_X_$__UsesSchemaSet;
		Descriptor descriptor60$_X_$NEWS;

		try {
			descriptor60$_X_$NEWS$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor60$_X_$NEWS = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Web$__$Content).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$NEWS), null, descriptor60$_X_$NEWS$_X_$__UsesSchemaSet, descriptor58$_X_$ITEM);
			schemaSet_ScopeStack.add(descriptor60$_X_$NEWS$_X_$__UsesSchemaSet);
			descriptor58$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor60$_X_$NEWS);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::Web.Content::NEWS, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::Web.Content::NEWS.STORY __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor61$_X_$NEWS_STORY$_X_$__UsesSchemaSet;
		Descriptor descriptor61$_X_$NEWS_STORY;

		try {
			descriptor61$_X_$NEWS_STORY$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor61$_X_$NEWS_STORY = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Web$__$Content).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$NEWS).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$NEWS$__$STORY), null, descriptor61$_X_$NEWS_STORY$_X_$__UsesSchemaSet, descriptor60$_X_$NEWS);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$NEWS$_S_$NEWS$__$STORY descriptor61$_X_$NEWS_STORY$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$NEWS$_S_$NEWS$__$STORY)descriptor61$_X_$NEWS_STORY.get_FieldSet_Tuple(executeInfo);
			descriptor61$_X_$NEWS_STORY$_X_$__FieldSet.set_NewsItem_ID(executeInfo, "Matrix" );
			descriptor61$_X_$NEWS_STORY$_X_$__FieldSet.set_Title(executeInfo, "Abstract-Systems Matrix-Programming for N-Dimensional Architecture " );
			descriptor61$_X_$NEWS_STORY$_X_$__FieldSet.set_DateText(executeInfo, null );
			descriptor61$_X_$NEWS_STORY$_X_$__FieldSet.set_Story_Blurb(executeInfo, "Based on our research in multi-dimensional architectures, we are creating a software-architecture design-application that " + "we believe will be of great benefit to architects and developers. Architects will design systems that are organized " + "as N-Dimensional Architectures using powerful visual design tools. And, Developers will use our architectural " + "libraries for Java and .Net to implement these N-Dimensional Architectures in their code. Both the architecture " + "and the code of the system will be easier to understand compared to current 3-tier systems. In addition, developers will be able " + "to add their future enhancements to these N-Dimensional systems with less time and effort." + "<br><br>We plan to have a beta system available for download at the middle of 2010." );
			schemaSet_ScopeStack.add(descriptor61$_X_$NEWS_STORY$_X_$__UsesSchemaSet);
			descriptor60$_X_$NEWS.add_ChildDescriptor(executeInfo, descriptor61$_X_$NEWS_STORY);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::Web.Content::NEWS.STORY, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `People` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor62$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor62$_X_$ITEM;

		try {
			descriptor62$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor62$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("People"), 0, true), descriptor62$_X_$ITEM$_X_$__UsesSchemaSet, descriptor43$_X_$MATRIX);
			schemaSet_ScopeStack.add(descriptor62$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor43$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor62$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, People, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::Web.Content::PAGE.INFO __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor63$_X_$PAGE_INFO$_X_$__UsesSchemaSet;
		Descriptor descriptor63$_X_$PAGE_INFO;

		try {
			descriptor63$_X_$PAGE_INFO$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor63$_X_$PAGE_INFO = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Web$__$Content).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$PAGE$__$INFO), null, descriptor63$_X_$PAGE_INFO$_X_$__UsesSchemaSet, descriptor62$_X_$ITEM);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$PAGE$__$INFO descriptor63$_X_$PAGE_INFO$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$PAGE$__$INFO)descriptor63$_X_$PAGE_INFO.get_FieldSet_Tuple(executeInfo);
			descriptor63$_X_$PAGE_INFO$_X_$__FieldSet.set_Name_NoSpaces(executeInfo, "people" );
			descriptor63$_X_$PAGE_INFO$_X_$__FieldSet.set_Page_ID(executeInfo, 4 );
			descriptor63$_X_$PAGE_INFO$_X_$__FieldSet.set_Title(executeInfo, "People" );
			descriptor63$_X_$PAGE_INFO$_X_$__FieldSet.set_BlurbText(executeInfo, "No materials, no machinery, no factories. More than almost any industry, good software development requires good people. We believe in finding the right person for the job. Dedicated, skilled employees are invaluable. And, we believe in treating them that way." );
			descriptor63$_X_$PAGE_INFO$_X_$__FieldSet.set_LNav_Href(executeInfo, "" );
			descriptor63$_X_$PAGE_INFO$_X_$__FieldSet.set_LNav_Image(executeInfo, "" );
			descriptor63$_X_$PAGE_INFO$_X_$__FieldSet.set_LNav_IsActive(executeInfo, false );
			schemaSet_ScopeStack.add(descriptor63$_X_$PAGE_INFO$_X_$__UsesSchemaSet);
			descriptor62$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor63$_X_$PAGE_INFO);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::Web.Content::PAGE.INFO, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::Web.Content::PEOPLE __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor64$_X_$PEOPLE$_X_$__UsesSchemaSet;
		Descriptor descriptor64$_X_$PEOPLE;

		try {
			descriptor64$_X_$PEOPLE$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor64$_X_$PEOPLE = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Web$__$Content).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$PEOPLE), null, descriptor64$_X_$PEOPLE$_X_$__UsesSchemaSet, descriptor62$_X_$ITEM);
			schemaSet_ScopeStack.add(descriptor64$_X_$PEOPLE$_X_$__UsesSchemaSet);
			descriptor62$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor64$_X_$PEOPLE);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::Web.Content::PEOPLE, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::Web.Content::PERSON.INFO __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor65$_X_$PERSON_INFO$_X_$__UsesSchemaSet;
		Descriptor descriptor65$_X_$PERSON_INFO;

		try {
			descriptor65$_X_$PERSON_INFO$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor65$_X_$PERSON_INFO = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Web$__$Content).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$PEOPLE).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$PERSON$__$INFO), null, descriptor65$_X_$PERSON_INFO$_X_$__UsesSchemaSet, descriptor64$_X_$PEOPLE);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$PEOPLE$_S_$PERSON$__$INFO descriptor65$_X_$PERSON_INFO$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$PEOPLE$_S_$PERSON$__$INFO)descriptor65$_X_$PERSON_INFO.get_FieldSet_Tuple(executeInfo);
			descriptor65$_X_$PERSON_INFO$_X_$__FieldSet.set_Person_ID(executeInfo, "Peter" );
			descriptor65$_X_$PERSON_INFO$_X_$__FieldSet.set_Name(executeInfo, "Peter Joh" );
			descriptor65$_X_$PERSON_INFO$_X_$__FieldSet.set_Title(executeInfo, "Head of Technology & Business Strategies" );
			descriptor65$_X_$PERSON_INFO$_X_$__FieldSet.set_Role(executeInfo, "Software Engineer & Consultant" );
			descriptor65$_X_$PERSON_INFO$_X_$__FieldSet.set_Email(executeInfo, null );
			descriptor65$_X_$PERSON_INFO$_X_$__FieldSet.set_Description(executeInfo, "Peter has led the development of large applications for various sectors of industry.  His experience ranges from developing hand writing applications at Microsoft to leading a requirements team on adding predictive modeling to State Farm's claims-processing system. This core system processed a majority of their insurance claims ($100's millions of dollars in claims annually). He has a Bachelor's degree in Computer Science from the University of Michigan and has consulted for Ford, GM, Chrysler, and ABC News. He is currently researching concepts in multi-dimensional, software architecture. Specifically, on how to use them to solve many of the problems found in the development of our current systems." );
			schemaSet_ScopeStack.add(descriptor65$_X_$PERSON_INFO$_X_$__UsesSchemaSet);
			descriptor64$_X_$PEOPLE.add_ChildDescriptor(executeInfo, descriptor65$_X_$PERSON_INFO);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::Web.Content::PERSON.INFO, and with an empty label, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and label, `Contact` __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor66$_X_$ITEM$_X_$__UsesSchemaSet;
		Descriptor descriptor66$_X_$ITEM;

		try {
			descriptor66$_X_$ITEM$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor66$_X_$ITEM = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.net$__$unconventionalthinking$__$matrix$_CC_$MATRIX$__$STANDARD$_CC_$ITEM), appControl.symbolControl.multiPartSymbol_Factory.createNew_Label(Arrays.asList("Contact"), 0, true), descriptor66$_X_$ITEM$_X_$__UsesSchemaSet, descriptor43$_X_$MATRIX);
			schemaSet_ScopeStack.add(descriptor66$_X_$ITEM$_X_$__UsesSchemaSet);
			descriptor43$_X_$MATRIX.add_ChildDescriptor(executeInfo, descriptor66$_X_$ITEM);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, net.unconventionalthinking.matrix::MATRIX.STANDARD::ITEM, and with label, Contact, but had an error", e);
		}


		//  Creating Descriptor with descriptor tag, maintests.samples::Web.Content::PAGE.INFO __________________________________________________
		MatrixSet<SchemaInfo_Schema> descriptor67$_X_$PAGE_INFO$_X_$__UsesSchemaSet;
		Descriptor descriptor67$_X_$PAGE_INFO;

		try {
			descriptor67$_X_$PAGE_INFO$_X_$__UsesSchemaSet = new MatrixSet<SchemaInfo_Schema>();
			descriptor67$_X_$PAGE_INFO = (Descriptor)appControl.matrixControl.matrixFactory.createNew_Descriptor(executeInfo, appControl.schemaControl.schemaIndex_Find(AppSymbols_SchemaName.maintests$__$samples$_CC_$Web$__$Content).getChild_SchemaInfoDescriptor(executeInfo, AppSymbols_DescTag.maintests$__$samples$_CC_$Web$__$Content$_CC_$PAGE$__$INFO), null, descriptor67$_X_$PAGE_INFO$_X_$__UsesSchemaSet, descriptor66$_X_$ITEM);
			maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$PAGE$__$INFO descriptor67$_X_$PAGE_INFO$_X_$__FieldSet = (maintests.samples.FieldSetTuple__maintests$__$samples$_CC_$Web$__$Content$_S_$PAGE$__$INFO)descriptor67$_X_$PAGE_INFO.get_FieldSet_Tuple(executeInfo);
			descriptor67$_X_$PAGE_INFO$_X_$__FieldSet.set_Name_NoSpaces(executeInfo, "contactus" );
			descriptor67$_X_$PAGE_INFO$_X_$__FieldSet.set_Page_ID(executeInfo, 5 );
			descriptor67$_X_$PAGE_INFO$_X_$__FieldSet.set_Title(executeInfo, "Contact Us" );
			descriptor67$_X_$PAGE_INFO$_X_$__FieldSet.set_BlurbText(executeInfo, "Please feel free to contact us" );
			descriptor67$_X_$PAGE_INFO$_X_$__FieldSet.set_LNav_Href(executeInfo, "" );
			descriptor67$_X_$PAGE_INFO$_X_$__FieldSet.set_LNav_Image(executeInfo, "" );
			descriptor67$_X_$PAGE_INFO$_X_$__FieldSet.set_LNav_IsActive(executeInfo, false );
			schemaSet_ScopeStack.add(descriptor67$_X_$PAGE_INFO$_X_$__UsesSchemaSet);
			descriptor66$_X_$ITEM.add_ChildDescriptor(executeInfo, descriptor67$_X_$PAGE_INFO);

		} catch(Exception e) {
			throw new Exception_MatrixRuntime_Checked("Tried to create a new descriptor with the name, maintests.samples::Web.Content::PAGE.INFO, and with an empty label, but had an error", e);
		}

		matrix = (Matrix)descriptor43$_X_$MATRIX;

		return (Matrix)descriptor43$_X_$MATRIX;
	}




	public Class<?> get_AppControl_Class() throws ClassNotFoundException {
		return maintests.samples.AppControl.class;
	}
	public AppControl_Base initialize_AppControl() { return initialize_AppControl(null, false); }
	public AppControl_Base initialize_AppControl(boolean running_AppControl_forMetacompilation) { return initialize_AppControl(null, running_AppControl_forMetacompilation); }
	public AppControl_Base initialize_AppControl(AppControl_Base existing_AppControl) { return initialize_AppControl(existing_AppControl, false); }
	public AppControl_Base initialize_AppControl(AppControl_Base existing_AppControl, boolean running_AppControl_forMetacompilation) {
		if (existing_AppControl != null)
			return maintests.samples.AppControl.initializeApp(existing_AppControl, running_AppControl_forMetacompilation);
		else
			return maintests.samples.AppControl.initializeApp(running_AppControl_forMetacompilation);
	}

	public AppControl_Base get_AppControl() {
		return maintests.samples.AppControl.appControl;
	}

}
