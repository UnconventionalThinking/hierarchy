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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.unconventionalthinking.matrix;

import net.unconventionalthinking.exceptions.Exception_InvalidArgumentPassed;
import net.unconventionalthinking.lang.ExecutionInfo;
import net.unconventionalthinking.lang.Integer_Mutable;
import net.unconventionalthinking.matrix.*;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import java.util.*;

import net.unconventionalthinking.matrix.symbols.*;
import net.unconventionalthinking.hierarchy.SchemaSet_ScopeStack;

/**
 *
 * @author peterjoh
 */
public class SchemaInfoUtilities {

    public static final String Found_SchemaInfoDescriptor_Param = "Found_SchemaInfoDescriptor";

    public static final String Found_in_Schema_Param = "Found_in_Schema";
    public static final String Found_SchemaSet_Param = "Found_SchemaSet";

    public static final String Found_DepthLevel = "Found_DepthLevel";




    /**
     * This method is used by the metacompiler when creating a descriptor. It finds the schemaInfo_Descriptor for the
     * Descriptor, searching first the parent descriptor, then moving through the schemaset scope stack.
     *
     * @param executeInfo
     * @param find_DescriptorTagName        this version takes in a desctagname and schemaName
     * @param schemaName                    the schemaName
     * @param symbolControl                 used to create the descriptorTag
     * @param parent_SchemaInfoDescriptor
     * @param schemaSet_ScopeStack
     * @return
     */
    public static SchemaInfo_Descriptor find_SchemaInfoDescriptor_in_Stack(ExecutionInfo executeInfo,
            DescriptorTagName find_DescriptorTagName, MatrixName schemaName, SymbolControl symbolControl,
            SchemaInfo_Descriptor parent_SchemaInfoDescriptor, SchemaSet_ScopeStack schemaSet_ScopeStack)
        throws Exception_InvalidArgumentPassed {

        executeInfo.reset();
        
        DescriptorTag find_DescriptorTag = symbolControl.multiLevelSymbol_Factory.createNew_DescriptorTag(schemaName, find_DescriptorTagName, false);
        return find_SchemaInfoDescriptor_in_Stack(executeInfo, find_DescriptorTag, parent_SchemaInfoDescriptor, schemaSet_ScopeStack, false);
    }

    /**
     * This method is used by the metacompiler when creating a descriptor. It finds the schemaInfo_Descriptor for the
     * Descriptor, searching first the parent descriptor, then moving through the schemaset scope stack.
     *
     * @param executeInfo
     * @param find_DescriptorTagName        this version takes in a desctagname and schemaName
     * @param schemaName                    the schemaName
     * @param symbolControl                 used to create the descriptorTag
     * @param parent_SchemaInfoDescriptor
     * @param schemaSet_ScopeStack
     * @param describe_FindLocation     if you want the method to return information on where it found the schemaInfo_Descriptor,
     *                                  then set this to true. it will pass the description through the executeInfo object's infoParameter hash.
     * @return
     */
    public static SchemaInfo_Descriptor find_SchemaInfoDescriptor_in_Stack(ExecutionInfo executeInfo,
            DescriptorTagName find_DescriptorTagName, MatrixName schemaName, SymbolControl symbolControl,
            SchemaInfo_Descriptor parent_SchemaInfoDescriptor, SchemaSet_ScopeStack schemaSet_ScopeStack, boolean describe_FindLocation)
        throws Exception_InvalidArgumentPassed {

        executeInfo.reset();

        DescriptorTag find_DescriptorTag = symbolControl.multiLevelSymbol_Factory.createNew_DescriptorTag(schemaName, find_DescriptorTagName, false);
        return find_SchemaInfoDescriptor_in_Stack(executeInfo, find_DescriptorTag, parent_SchemaInfoDescriptor, schemaSet_ScopeStack, describe_FindLocation);
    }

    /**
     * This method is used by the metacompiler when creating a descriptor. It finds the schemaInfo_Descriptor for the
     * Descriptor, searching first the parent descriptor, then moving through the schemaset scope stack.
     *
     * @param executeInfo
     * @param find_DescriptorTag
     * @param parent_SchemaInfoDescriptor
     * @param schemaSet_ScopeStack
     * @return
     */
    public static SchemaInfo_Descriptor find_SchemaInfoDescriptor_in_Stack(ExecutionInfo executeInfo, DescriptorTag find_DescriptorTag,
        SchemaInfo_Descriptor parent_SchemaInfoDescriptor, SchemaSet_ScopeStack schemaSet_ScopeStack) {

        return find_SchemaInfoDescriptor_in_Stack(executeInfo, find_DescriptorTag, parent_SchemaInfoDescriptor, schemaSet_ScopeStack, false);
    }
    /**
     * This method is used by the metacompiler when creating a descriptor. It finds the schemaInfo_Descriptor for the
     * Descriptor, searching first the parent descriptor, then moving through the schemaset scope stack.
     *
     * @param executeInfo
     * @param find_DescriptorTagName
     * @param parent_SchemaInfoDescriptor
     * @param schemaSet_ScopeStack
     * @param describe_FindLocation     if you want the method to return information on where it found the schemaInfo_Descriptor,
     *                                  then set this to true. it will pass the description through the executeInfo object's infoParameter hash.
     * @return
     */
    public static SchemaInfo_Descriptor find_SchemaInfoDescriptor_in_Stack(ExecutionInfo executeInfo, DescriptorTag find_DescriptorTag,
        SchemaInfo_Descriptor parent_SchemaInfoDescriptor, SchemaSet_ScopeStack schemaSet_ScopeStack, boolean describe_FindLocation) {

        executeInfo.reset();



        boolean haveFound_SchemaInfoDesc = false;
        SchemaInfo_Descriptor found_SchemaInfoDescriptor = null;
        int depthLevelOfFoundDescriptors = 0;



        //  First, check the parent Descriptor's schema Element:
        if (parent_SchemaInfoDescriptor != null) {
            found_SchemaInfoDescriptor = parent_SchemaInfoDescriptor.getChild_SchemaInfoDescriptor(executeInfo, find_DescriptorTag);

        }

//        if (found_SchemaInfoDescriptor.properties.check(SchemaInfo_Descriptor.SchemaInfo_Property.Addable)) {

        if (found_SchemaInfoDescriptor != null && !executeInfo.hadEmptyResultSet()) {
            haveFound_SchemaInfoDesc = true;

            executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.SchemaStackSearch_FoundInParent);
            if (describe_FindLocation)
                process_DescribeFindLocation(executeInfo, found_SchemaInfoDescriptor, depthLevelOfFoundDescriptors, null, null);


        } else {


            //  Search schemaSet ScopeStack:
            if (schemaSet_ScopeStack != null) {
                Iterator<MatrixSet<SchemaInfo_Schema>> scopeStack_Iterator = schemaSet_ScopeStack.stack.iterator();


                while(scopeStack_Iterator.hasNext() && !haveFound_SchemaInfoDesc) {
                    depthLevelOfFoundDescriptors++;


                    MatrixSet<SchemaInfo_Schema> schemaSet = scopeStack_Iterator.next();

                    if (schemaSet != null) {
                        Iterator<SchemaInfo_Schema> schemaSet_Iter = schemaSet.iterator();


                        while(schemaSet_Iter.hasNext() && !haveFound_SchemaInfoDesc) {
                            SchemaInfo_Descriptor schema_SchemaInfo = schemaSet_Iter.next();


                            found_SchemaInfoDescriptor = schema_SchemaInfo.getChild_SchemaInfoDescriptor(executeInfo, find_DescriptorTag,
                                    SearchType.SearchOnlyOneLevel);
                            if (found_SchemaInfoDescriptor != null && !executeInfo.hadEmptyResultSet()) {
                                haveFound_SchemaInfoDesc = true;

                                executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.SchemaStackSearch_FoundInStack);
                                if (describe_FindLocation)
                                    process_DescribeFindLocation(executeInfo, found_SchemaInfoDescriptor, depthLevelOfFoundDescriptors,
                                            (SchemaInfo_Schema) schema_SchemaInfo, schemaSet);

                            }

                        } // end of while
                    }

                }


            } else {
                haveFound_SchemaInfoDesc = false;
            }


        }

        if (haveFound_SchemaInfoDesc) {
            return found_SchemaInfoDescriptor;
        } else {
            executeInfo.addResultsInfo_EmptyResultSet();
            return null;
        }

    }








    /**
     * When we search the schema scope stack, we'll returm ALL the schemas at each level of the stack for all the matching schema_InfoDescriptors with
     * the descTagName passed in. This is useful for situations like metacompilation, where you want to see if there are any name conflicts.
     *
     * @param executeInfo
     * @param find_DescriptorTagName
     * @param symbolControl
     * @param parent_SchemaInfoDescriptor
     * @param schemaSet_ScopeStack
     * @param describe_FindLocation
     * @return
     * @throws Exception_InvalidArgumentPassed
     */

    public static MatrixSet<SchemaInfo_Descriptor> find_SchemaInfoDescriptors_AtSameLevel_in_Stack(ExecutionInfo executeInfo,
            DescriptorTagName find_DescriptorTagName, 
            SchemaInfo_Descriptor parent_SchemaInfoDescriptor, SchemaSet_ScopeStack schemaSet_ScopeStack,
            boolean describe_FindLocation)
        throws Exception_InvalidArgumentPassed {

        executeInfo.reset();



        SchemaInfo_Descriptor found_SchemaInfoDescriptor = null;
        boolean haveFound_SchemaInfoDescriptors = false;
        // may find multiple descriptors
        MatrixSet<SchemaInfo_Descriptor> found_SchemaInfoDescriptor_Set = new MatrixSet<SchemaInfo_Descriptor>();
        int depthLevelOfFoundDescriptors = 0;

        //  First, check the parent Descriptor's schema Element:
        if (parent_SchemaInfoDescriptor != null) {
            found_SchemaInfoDescriptor = parent_SchemaInfoDescriptor.getChild_SchemaInfoDescriptor(executeInfo, find_DescriptorTagName);

        }

//        if (found_SchemaInfoDescriptor.properties.check(SchemaInfo_Descriptor.SchemaInfo_Property.Addable)) {

        if (found_SchemaInfoDescriptor != null && !executeInfo.hadEmptyResultSet()) {
            haveFound_SchemaInfoDescriptors = true;
            found_SchemaInfoDescriptor_Set.add(found_SchemaInfoDescriptor);

            executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.SchemaStackSearch_FoundInParent);
            if (describe_FindLocation)
                process_DescribeFindLocation(executeInfo, found_SchemaInfoDescriptor, depthLevelOfFoundDescriptors, null, null);


        } else {


            //  Search schemaSet ScopeStack:
            if (schemaSet_ScopeStack != null) {
                Iterator<MatrixSet<SchemaInfo_Schema>> scopeStack_Iterator = schemaSet_ScopeStack.stack.iterator(); // TODO - is this the right direction for the iterator??


                while(scopeStack_Iterator.hasNext() && !haveFound_SchemaInfoDescriptors) {  // iterate many set of schemas
                    MatrixSet<SchemaInfo_Schema> schemaSet = scopeStack_Iterator.next();
                    Iterator<SchemaInfo_Schema> schemaSet_Iter = schemaSet.iterator();

                    depthLevelOfFoundDescriptors++;

                    while(schemaSet_Iter.hasNext()) { // iterate over each schema in the set. search ALL of them at this level, even if you find a match
                        SchemaInfo_Descriptor schema_SchemaInfo = schemaSet_Iter.next();


                        found_SchemaInfoDescriptor = schema_SchemaInfo.getChild_SchemaInfoDescriptor(executeInfo, find_DescriptorTagName,
                                SearchType.SearchOnlyOneLevel);

                        if (found_SchemaInfoDescriptor != null && !executeInfo.hadEmptyResultSet()) {
                            found_SchemaInfoDescriptor_Set.add(found_SchemaInfoDescriptor);
                            
                            executeInfo.setResultsInfoToOneValue(ExecutionInfo.ResultType.SchemaStackSearch_FoundInStack);
                            if (describe_FindLocation)
                                process_DescribeFindLocation(executeInfo, found_SchemaInfoDescriptor, depthLevelOfFoundDescriptors,
                                        (SchemaInfo_Schema) schema_SchemaInfo, schemaSet);
                        }


                    }
                    
                    if (found_SchemaInfoDescriptor_Set.size() > 0)
                        haveFound_SchemaInfoDescriptors = true;

                }  // end of while



            } else {
                haveFound_SchemaInfoDescriptors = false;
            }


        }

        if (haveFound_SchemaInfoDescriptors) {
            return found_SchemaInfoDescriptor_Set;
        } else {
            executeInfo.addResultsInfo_EmptyResultSet();
            return null;
        }
    }



    

    /**
     * Starting at the schemaInfo_Descriptor, search up into the parents for its first schemaInfo_Schema object.
     *
     * @param schemaInfoDescriptor
     * @return
     */
    public static SchemaInfo_Schema find_SchemaInfoSchema_for_SchemaInfoDescriptor(ExecutionInfo executeInfo,
                                                                        SchemaInfo_Descriptor schemaInfoDescriptor) {
        executeInfo.reset();


        if (schemaInfoDescriptor == null) {
            return null;
        }



        //  For efficiency, we want to check the parent schemaInfo_descriptor's value for the schemaInfo_schema.
        //  This is probably already set, so we can just use that. but, have to check the curr schemaInfo_Descriptor first!
        SchemaInfo_Descriptor parent_SchemaInfoDescriptor = null;

        //  First, see if this object is a schemaInfo_Schema
        if (schemaInfoDescriptor.getSchemaInfo_SchemaInfoType() == SchemaInfo.Type.SchemaInfoSchema) {
            return (SchemaInfo_Schema)schemaInfoDescriptor;

        } else {
            parent_SchemaInfoDescriptor = (SchemaInfo_Descriptor)schemaInfoDescriptor.getSchemaInfo_ParentSchemaInfo(executeInfo);

            if (parent_SchemaInfoDescriptor != null) {

                // now, check its parent schemaInfoDescriptor to see if it is a schemaInfoSchema
                if (parent_SchemaInfoDescriptor.getSchemaInfo_SchemaInfoType() == SchemaInfo.Type.SchemaInfoSchema) {
                    return (SchemaInfo_Schema)parent_SchemaInfoDescriptor;

                } else {
                    // check the ancestor of the parent. There is a good chance that this is already set, so use it.
                    if (parent_SchemaInfoDescriptor.getSchemaInfo__Ancestor_SchemaInfoSchema() != null) {
                        return parent_SchemaInfoDescriptor.getSchemaInfo__Ancestor_SchemaInfoSchema();
                    }
                }
            } else {
                // no schemaInfoSchema
                return null;
            }
        }




        //  We got to this point, so, the parent schemaInfo_Descriptor's ancestor is not set. search down.
        SchemaInfo_Descriptor curr_SchemaInfoDescriptor = null;

        //  Search down through schemaInfo_Descriptors
        //  start at the parent, cause we've already checked the top level schemaInfoDescriptor
        for (curr_SchemaInfoDescriptor = parent_SchemaInfoDescriptor;
             curr_SchemaInfoDescriptor != null &&
             curr_SchemaInfoDescriptor.getSchemaInfo_SchemaInfoType() != SchemaInfo.Type.SchemaInfoSchema;
             curr_SchemaInfoDescriptor = (SchemaInfo_Descriptor)curr_SchemaInfoDescriptor.getSchemaInfo_ParentSchemaInfo(executeInfo)) { }


        if (curr_SchemaInfoDescriptor != null && curr_SchemaInfoDescriptor.getSchemaInfo_SchemaInfoType() != SchemaInfo.Type.SchemaInfoSchema)
            return (SchemaInfo_Schema)curr_SchemaInfoDescriptor;
        else
            return null;

    }















    /**
     * Searches down through the schema set scope stack for schemas _at the same level_ that have the schema name we're searching for.
     * 
     * @param executeInfo
     * @param schemaName
     * @param schemaSet_ScopeStack
     * @return
     * @throws Exception_MetaCompilerError
     */
    public static Set<SchemaInfo_Schema> find_Schemas_AtSameLevelinStack_by_SchemaNameSimple(ExecutionInfo executeInfo, DescriptorTagName schemaName,
             SchemaSet_ScopeStack schemaSet_ScopeStack, Integer_Mutable depthLevel)
        throws Exception_MetaCompilerError {
        executeInfo.reset();

        Set<SchemaInfo_Schema> foundSchemas_At_Level = new HashSet<SchemaInfo_Schema>();
        boolean have_FoundSchemas = false;
        depthLevel.value = 0;


        //  search through the schemaSet Scope Stack for the nearest matching schemaName.

        for (int i = 0; i < schemaSet_ScopeStack.stack.size() && !have_FoundSchemas; ++i)  {
            MatrixSet<SchemaInfo_Schema> schemaSet = schemaSet_ScopeStack.stack.get(i);

            depthLevel.value++;

            // Search the entire level for schemas that match
            for (int j = 0; j < schemaSet.size(); ++j) {
                SchemaInfo_Schema schema = schemaSet.get(j);

                if (schema.getSchemaInfo_SchemaNameFull().getMatrixName().equals(schemaName))
                    foundSchemas_At_Level.add(schema);

            }

            if (foundSchemas_At_Level.size() > 0)
                have_FoundSchemas = true;

        }

        return foundSchemas_At_Level;
    }









    private static void process_DescribeFindLocation(ExecutionInfo executeInfo, SchemaInfo_Descriptor found_SchemaInfoDescriptor,
                int depthLevelOfFoundDescriptors, SchemaInfo_Schema found_in_Schema, MatrixSet<SchemaInfo_Schema> found_in_SchemaSet) {

        Map<String, Object> infoParameters = new HashMap<String, Object>();
        
        infoParameters.put(Found_SchemaInfoDescriptor_Param, found_SchemaInfoDescriptor);
        if (found_in_Schema != null)
            infoParameters.put(Found_in_Schema_Param, found_in_Schema);
        if (found_in_SchemaSet != null)
            infoParameters.put(Found_SchemaSet_Param, found_in_SchemaSet);


        infoParameters.put(Found_DepthLevel, depthLevelOfFoundDescriptors);

        executeInfo.setInfoParameterHash(infoParameters);
    }
}
