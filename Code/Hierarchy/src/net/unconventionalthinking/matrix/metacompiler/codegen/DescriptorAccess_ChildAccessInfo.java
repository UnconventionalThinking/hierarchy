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

package net.unconventionalthinking.matrix.metacompiler.codegen;

import net.unconventionalthinking.matrix.symbols.Label;
import net.unconventionalthinking.matrix.symbols.Symbol;
import net.unconventionalthinking.matrix.symbols.Symbol_Base;
import java.util.List;



/**
 *
 * @author peterjoh
 */
public class DescriptorAccess_ChildAccessInfo {
    public enum TypeOfElementAccessed { Descriptor, Field, DescriptorSet, FieldValueSet };

    public boolean                  is_StaticAccess;
    public TypeOfElementAccessed    typeOfElementAccessed;
    public short                    numberOfExpresions;
    public boolean                  is_SingleAccess;

    
    public String               accessExpr1;
    public boolean              accessExpr1_Is_Static_DescTag;
    public boolean              accessExpr1_Is_Static_DescTagName;
    public boolean              accessExpr1_Is_Static_Label;
    public List<String>         accessExpr1_SymbolParts;
    public Symbol_Base          accessExpr1_DescTagOrLabel_Actual;

    /**
     * NOTE: can have static access using a Static descriptor tagname and a Dynamic label! (static access allows this)
     */
    public boolean              accessExpr2_Exists;
    public String               accessExpr2;
    public boolean              accessExpr2_Is_Static_Label;
    public List<String>         accessExpr2_LabelParts;
    public Label                accessExpr2_Label_Actual;

    public boolean              accessExpr2_Is_ContinuationIndex;
    public int                  accessExpr2_ContinuationIndex_Actual;


    public boolean              annotationReference_Exists;
    public Symbol               annotationReference;


    public boolean              multiAccess_FiltersAnnotationReference_Exists;
    public Symbol               multiAccess_FiltersAnnotationRef;


    public DescriptorAccess_ChildAccessInfo() {};

    public DescriptorAccess_ChildAccessInfo(boolean is_StaticAccess, TypeOfElementAccessed typeOfElementAccessed, short numberOfExpresions,
        boolean is_SingleAccess) {

        this.is_StaticAccess = is_StaticAccess;
        this.typeOfElementAccessed = typeOfElementAccessed;
        this.numberOfExpresions = numberOfExpresions;
        this.is_SingleAccess = is_SingleAccess;

        accessExpr2_Exists = false;
    }

    public void set_AccessExpression1(String accessExpr1_Translated, boolean accessExpr1_Is_Static_DescTag, boolean accessExrp1_Is_Static_DescTagName,
            boolean accessExpr1_Is_Static_Label, List<String> accessExpr1_SymbolParts, Symbol_Base accessExpr1_DescTagOrLabel_Actual) {

        this.accessExpr1 = accessExpr1_Translated;
        this.accessExpr1_Is_Static_DescTag = accessExpr1_Is_Static_DescTag;
        this.accessExpr1_Is_Static_DescTagName = accessExrp1_Is_Static_DescTagName;
        this.accessExpr1_Is_Static_Label = accessExpr1_Is_Static_Label;
        this.accessExpr1_SymbolParts = accessExpr1_SymbolParts;
        this.accessExpr1_DescTagOrLabel_Actual = accessExpr1_DescTagOrLabel_Actual;

        if (!accessExpr2_Exists)
            numberOfExpresions = 1;
        else
            numberOfExpresions = 2;
    }


    public void set_AccessExpression2(String accessExpr2_Translated, boolean accessExpr2_Is_Static_Label,
            List<String> accessExpr2_LabelParts, Label accessExpr2_Label_Actual, boolean accessExpr2_Is_ContinuationIndex) {

        this.accessExpr2_Exists = true;
        
        this.accessExpr2 = accessExpr2_Translated;
        this.accessExpr2_Is_Static_Label = accessExpr2_Is_Static_Label;
        this.accessExpr2_LabelParts = accessExpr2_LabelParts;
        this.accessExpr2_Label_Actual = accessExpr2_Label_Actual;

        this.accessExpr2_Is_ContinuationIndex = accessExpr2_Is_ContinuationIndex;

        if (accessExpr2_Is_ContinuationIndex && accessExpr2 != null) {
            accessExpr2_ContinuationIndex_Actual = Integer.parseInt(accessExpr2);
        } else {
            accessExpr2_ContinuationIndex_Actual = -1;
        }

        this.numberOfExpresions = 2;
    }


    public void set_AnnotationInfo(boolean annotationReference_Exists, Symbol annotationReference) {

        this.annotationReference_Exists = annotationReference_Exists;
        this.annotationReference = annotationReference;
        
    }



    
    //
    //  Utility Methods:
    //
    public static boolean is_DescriptorOrDescriptorSet(DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed typeOfAccess) {
        return (typeOfAccess == DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.Descriptor ||
                typeOfAccess == DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.DescriptorSet);
    }

    public boolean is_StaticDescTag_DynLabel_Access() {
        return numberOfExpresions == 2 && typeOfElementAccessed == typeOfElementAccessed.Descriptor && !accessExpr2_Is_Static_Label ;
    };

}
