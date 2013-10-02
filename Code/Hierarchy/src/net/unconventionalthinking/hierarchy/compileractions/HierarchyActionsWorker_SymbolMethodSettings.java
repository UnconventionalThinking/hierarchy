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

package net.unconventionalthinking.hierarchy.compileractions;

import java.util.LinkedList;
import net.unconventionalthinking.compiler.tools.MethodAttributeSet;
import net.unconventionalthinking.lang.Boolean_Mutable;
import net.unconventionalthinking.lang.Integer_Mutable;

/**
 * This class is usual. It's a settings object that is only used by the _root_ symbol production-method, and so
 * isn't used by the _child_ production-methods).
 * The reason this class is needed is because there are a lot of symbol production methods, with a lot of initialization. So, the main purpose of
 * its objects is to initialize all the variables in the _methodAttributeSet_ for each symbol method!!! this takes place in the all the
 * _root_ symbol production methods. So, only in these methods is this settings object actual accessed for it's values. In the _child_ production
 * methods, they don't bother with recreating this object, and just pull out what they need from the methodAttributeSet.
 *
 * @author Peter Joh
 */
public class HierarchyActionsWorker_SymbolMethodSettings {

    public Integer_Mutable      symbolCount;
    public LinkedList<String>   child_Symbols;
    public Integer_Mutable      creation_StartLevel;
    public Boolean_Mutable      is_LateStartCreation;
    
    public Boolean_Mutable      is_LabelAccessOrCreation;
    public Integer_Mutable      labelCount;
    public Boolean_Mutable      is_DescTagNameAccessOrCreation;

    public Boolean_Mutable      haveSeen_Plus;
    public Boolean              generateAndReturn_DescTagName;



    public HierarchyActionsWorker_SymbolMethodSettings() {}

    /**
     * This version does not take a 'checkParamsFor_CreationStartlevel' parameter. This is used by the two, main symbol-creation and symbol-access
     * methods (because, as the var name implies, they don't check the parameters for the creation start level).
     * 
     * @param is_NewSymbolCreation
     * @param checkParamsFor_CreationStartlevel
     * @param symbolMethod_AttribSet
     */
    public void initialize(boolean is_NewSymbolCreation, MethodAttributeSet symbolMethod_AttribSet) {
        initialize(is_NewSymbolCreation, false, symbolMethod_AttribSet);
    }

    public void initialize(boolean is_NewSymbolCreation, boolean checkParamsFor_CreationStartlevel, MethodAttributeSet symbolMethod_AttribSet) {

        //  Params _____________________________
        generateAndReturn_DescTagName = (Boolean) symbolMethod_AttribSet.params.get(
                                                                        HierarchyMethodConstants.param_GenerateAndReturn_DescTagName);
        if (is_NewSymbolCreation) {
           creation_StartLevel = new Integer_Mutable(1);
           
        } else {
            if (checkParamsFor_CreationStartlevel) {
                //  check if there's a parameter passed to production-method:
                creation_StartLevel = (Integer_Mutable) symbolMethod_AttribSet.params.get(HierarchyMethodConstants.param_Creation_StartLevel);
            }
            //  No parameter, this is symbol access. Set to max creation level.
        	if (creation_StartLevel == null)
				creation_StartLevel = new Integer_Mutable(Integer.MAX_VALUE);
        }
        
		//  Setup vars _____________________________

		symbolCount = new Integer_Mutable(0);
      	symbolMethod_AttribSet.vars.put(HierarchyMethodConstants.var_SymbolCount, symbolCount);
      	child_Symbols = new LinkedList<String>();
      	symbolMethod_AttribSet.vars.put(HierarchyMethodConstants.var_Child_Symbols, child_Symbols);

        is_LabelAccessOrCreation = new Boolean_Mutable(false);
        symbolMethod_AttribSet.vars.put(HierarchyMethodConstants.var_Is_LabelAccessOrCreation, is_LabelAccessOrCreation);
        labelCount = new Integer_Mutable(0);
        symbolMethod_AttribSet.vars.put(HierarchyMethodConstants.var_LabelCount, labelCount);

        is_DescTagNameAccessOrCreation = new Boolean_Mutable(false);
        symbolMethod_AttribSet.vars.put(HierarchyMethodConstants.var_Is_DescTagNameAccessOrCreation, is_DescTagNameAccessOrCreation);

		//  CreationStartLevel is param and var. Use the creation_StartLevel value created above
        symbolMethod_AttribSet.vars.put(HierarchyMethodConstants.var_Creation_StartLevel, creation_StartLevel);

        is_LateStartCreation = new Boolean_Mutable(false);
        symbolMethod_AttribSet.vars.put(HierarchyMethodConstants.var_Is_LateStartCreation, is_LateStartCreation);

      	haveSeen_Plus = new Boolean_Mutable(false);
      	symbolMethod_AttribSet.vars.put(HierarchyMethodConstants.var_HaveSeen_Plus, haveSeen_Plus);

    }
}
