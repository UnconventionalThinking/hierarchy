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

import net.unconventionalthinking.compiler.tools.CodeBuilder;
import net.unconventionalthinking.lang.Pair;
import java.util.List;

/**
 *
 * @author peterjoh
 */
public class DescriptorAccess_ChildAccessGeneratorInfo {



    public boolean uses_ChildAccess_MethodParam1;
    public String childAccess_MethodParam1_Name;
    public boolean uses_ChildAccess_MethodParam2;
    public String childAccess_MethodParam2_Name;
    public String childAccess_MethodParam_ContIndex_Name;

    //  These are not too important, just to make the OutVarName more descriptive
    public String outVarName_DescriptionText;
    public String outComment_AccessDescription;

    public boolean currently_accessing_fieldOrFieldSet;

    public String getChildDescriptor_ParamValue1;
    public String getChildDescriptor_ParamValue2;

    public String intraMethodChildAccess_Value1;
    public String intraMethodChildAccess_Value2;


    private DescriptorAccess_ChildAccessInfo childAccessInfo;



    

    public DescriptorAccess_ChildAccessGeneratorInfo(int childAccess_Index, DescriptorAccess_ChildAccessInfo childAccessInfo) {

        uses_ChildAccess_MethodParam1 = false;
        childAccess_MethodParam1_Name = "accessParam_" + childAccess_Index + "__value1";
        uses_ChildAccess_MethodParam2 = false;
        childAccess_MethodParam2_Name = "accessParam_" + childAccess_Index + "__value2";
        childAccess_MethodParam_ContIndex_Name = "accessParam_" + childAccess_Index + "__ContinuationIndex";
        //  These are not too important, just to make the OutVarName more descriptive
        outVarName_DescriptionText = "";
        outComment_AccessDescription = "";


        currently_accessing_fieldOrFieldSet =
                childAccessInfo.typeOfElementAccessed == DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.Field ||
                childAccessInfo.typeOfElementAccessed == DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.FieldValueSet;

        getChildDescriptor_ParamValue1 = null;
        getChildDescriptor_ParamValue2 = null;

        intraMethodChildAccess_Value1 = null;
        intraMethodChildAccess_Value2 = null;

        this.childAccessInfo = childAccessInfo;
    }




    public void setup_1_GeneratorInfo_and_AccessMethodSignature(CodeBuilder accessMethodSignature_ParamList, CodeBuilder accessMethodCall_ParamList)
        throws Exception_MetaCompiler_IncorrectMatrixAccess {

        //  Setup the accessMethod's call list and parameter list
        //  ____________________________________________________________________________________________________________

        if (childAccessInfo.is_SingleAccess)
            setup_SingleAccess(accessMethodSignature_ParamList, accessMethodCall_ParamList);
        else
            setup_MultipleAccess(accessMethodSignature_ParamList, accessMethodCall_ParamList);

    }



    public void setup_SingleAccess(CodeBuilder accessMethodSignature_ParamList, CodeBuilder accessMethodCall_ParamList)
        throws Exception_MetaCompiler_IncorrectMatrixAccess {



        if (childAccessInfo.is_StaticAccess) {
            outVarName_DescriptionText = "__STATIC__";

            uses_ChildAccess_MethodParam1 = false;

            // static field access with continuation index
            if (childAccessInfo.accessExpr2_Is_ContinuationIndex) {
                    // NOTE: this is method param1!! (for static access w/ cont index, there is only the cont index passed in, so it' param1)
                    uses_ChildAccess_MethodParam1 = true;

                    accessMethodCall_ParamList.append(", " + childAccessInfo.accessExpr2);
                    accessMethodSignature_ParamList.append(", int " + childAccess_MethodParam_ContIndex_Name);

                    outVarName_DescriptionText += "___CONT_INDEX";
                    outComment_AccessDescription = "//  Static Field Access by Static Descriptor Tag Name, " +
                            childAccessInfo.accessExpr1_DescTagOrLabel_Actual.get_Name_IdentFormat();
                    outComment_AccessDescription += ", and with a continuation index";

            } else {
                if (childAccessInfo.accessExpr1_Is_Static_DescTag) {

                    outVarName_DescriptionText += "DTAG_" +
                            childAccessInfo.accessExpr1_DescTagOrLabel_Actual.get_Name_IdentFormat();
                    outComment_AccessDescription = "//  Static Descriptor Access by Static Descriptor Tag, " +
                            childAccessInfo.accessExpr1_DescTagOrLabel_Actual.get_Name_IdentFormat();

                    
                } else if (childAccessInfo.accessExpr1_Is_Static_DescTagName) {

                    outVarName_DescriptionText += "DTAGNAME_" +
                            childAccessInfo.accessExpr1_DescTagOrLabel_Actual.get_Name_IdentFormat();
                    outComment_AccessDescription = "//  Static Field Access by Static Descriptor Tag Name, " +
                            childAccessInfo.accessExpr1_DescTagOrLabel_Actual.get_Name_IdentFormat();


                } else if (childAccessInfo.accessExpr1_Is_Static_Label) {
                    if (currently_accessing_fieldOrFieldSet)
                        throw new Exception_MetaCompiler_IncorrectMatrixAccess("Cannot access a field using a label.");


                    outVarName_DescriptionText += "LBL_" +
                            childAccessInfo.accessExpr1_DescTagOrLabel_Actual.get_Name_IdentFormat();
                    outComment_AccessDescription = "//  Static Descriptor Access by Static Label, " +
                            childAccessInfo.accessExpr1_DescTagOrLabel_Actual.getName();
                } else {
                    throw new Exception_MetaCompiler_IncorrectMatrixAccess("Should be doing static access using the following accessor, but it is not a static descriptor tag, descriptor tagname, or a label:" + childAccessInfo.accessExpr1);
                }

                //  GetaccessExpr2 _______________________________
                if (childAccessInfo.accessExpr2_Exists) {

                    if (currently_accessing_fieldOrFieldSet && !childAccessInfo.accessExpr2_Is_ContinuationIndex)
                        throw new Exception_MetaCompiler_IncorrectMatrixAccess("You are accessing a field, you have a second accessor, but it is not an integer. You an only have a continuation index as a second accessor of a field.");


                    if (childAccessInfo.accessExpr2_Is_Static_Label) {
                        uses_ChildAccess_MethodParam2 = false;

                        outVarName_DescriptionText += "___LBL_" + childAccessInfo.accessExpr2_Label_Actual.getSymbol().name_IdentFormat;
                        outComment_AccessDescription += ", and with Static Label, " + childAccessInfo.accessExpr2_Label_Actual.getLabel_Simple();


                    } else { // dynamic label
                        uses_ChildAccess_MethodParam2 = true;
                        accessMethodCall_ParamList.append(", " + childAccessInfo.accessExpr2);
                        accessMethodSignature_ParamList.append(", Label " + childAccess_MethodParam2_Name);


                        outVarName_DescriptionText += "___DYN_LBL";
                        outComment_AccessDescription += ", and with a dynamic label";
                    }
                }
            }


        } else { // dynamic access ______________________________________

            uses_ChildAccess_MethodParam1 = true;
            accessMethodCall_ParamList.append(", ").append(childAccessInfo.accessExpr1);

            //  Could be either a desctag or a label, have the type be Symbol_base
            accessMethodSignature_ParamList.append(", Symbol_Base " + childAccess_MethodParam1_Name);

            
            outVarName_DescriptionText = "__DYN__";

            if (childAccessInfo.numberOfExpresions == 1) {
                outVarName_DescriptionText += "w_1_EXPR";
                outComment_AccessDescription = "//  Dynamic Access with 1 access expression: " + childAccessInfo.accessExpr1;

            } else if (childAccessInfo.numberOfExpresions == 2) {
                if (currently_accessing_fieldOrFieldSet && !childAccessInfo.accessExpr2_Is_ContinuationIndex)
                    throw new Exception_MetaCompiler_IncorrectMatrixAccess("You tried to access a field using 2 Expressions, but the second expression was not a continuation index.");

                if (childAccessInfo.accessExpr2_Is_ContinuationIndex) {
                    // NOTE: this is method param1!! (for static access w/ cont index, there is only the cont index passed in, so it' param1)
                    uses_ChildAccess_MethodParam2 = true;

                    accessMethodCall_ParamList.append(", " + childAccessInfo.accessExpr2);
                    accessMethodSignature_ParamList.append(", int " + childAccess_MethodParam_ContIndex_Name);

                    outVarName_DescriptionText += "w_CONT_INDEX";
                    outComment_AccessDescription = "//  Dynamic field Access with FieldName and continunation Indexs: " +
                            childAccessInfo.accessExpr1 + ", and: "+ childAccessInfo.accessExpr2;

                } else { // is a label
                    uses_ChildAccess_MethodParam2 = true;
                    accessMethodSignature_ParamList.append(", Label " + childAccess_MethodParam2_Name);

                    outVarName_DescriptionText += "w_2_EXPR";
                    outComment_AccessDescription = "//  Dynamic Access with Descriptor Tag and Label: " +
                            childAccessInfo.accessExpr1 +
                            ", and: "+ childAccessInfo.accessExpr2;
                }
            } else {
                throw new Exception_MetaCompiler_IncorrectMatrixAccess("Should be doing some type of access that has either 1 or 2 accessor, but you have " + childAccessInfo.numberOfExpresions +
                        " for this access. Access Expression 1 is, " + childAccessInfo.accessExpr1 + ", and Access Expression 2 is, " + childAccessInfo.accessExpr2);
            }
        }

        outComment_AccessDescription += ".\n";

    }




    public void setup_MultipleAccess(CodeBuilder accessMethodSignature_ParamList, CodeBuilder accessMethodCall_ParamList)
        throws Exception_MetaCompiler_IncorrectMatrixAccess {


        uses_ChildAccess_MethodParam1 = true;
        accessMethodCall_ParamList.append(", ").append(childAccessInfo.accessExpr1);

        accessMethodSignature_ParamList.append(", ");
        if (childAccessInfo.accessExpr1_Is_Static_DescTag)
            accessMethodSignature_ParamList.append("DescriptorTag " + childAccess_MethodParam1_Name);
        if (childAccessInfo.accessExpr1_Is_Static_DescTagName)
            accessMethodSignature_ParamList.append("DescriptorTagName " + childAccess_MethodParam1_Name);
        outVarName_DescriptionText = "__MULTI_ACCESS";

        outComment_AccessDescription = "//  Multi Access with access expression: " + childAccessInfo.accessExpr1 + ".\n";
    }




    /**
     * Setup the output code's parameter values passed into get_ChildDescriptor()
     *
     * @throws Exception_MetaCompilerError
     */
    public void setup_2_getChildDescriptor_Parameters() throws Exception_MetaCompilerError {


        //  _______________________________________________

        if (childAccessInfo.is_SingleAccess) {
            if (!uses_ChildAccess_MethodParam1) { // static access of the first child accessor. use accessExpr1
                getChildDescriptor_ParamValue1 = childAccessInfo.accessExpr1;

            } else {
                if (childAccessInfo.is_StaticAccess) { // static access with continuation
                    if (!childAccessInfo.accessExpr2_Is_ContinuationIndex)
                        throw new Exception_MetaCompilerError("Tried to statically access a field, and the static access method had a parameter for this " +
                                "child access, but for some reason, this field was _not_ a continuation Field. This situation should never happen.");
                    getChildDescriptor_ParamValue1 = childAccess_MethodParam_ContIndex_Name;
                } else // dyn access of descriptor or continuation field.
                    getChildDescriptor_ParamValue1 = childAccess_MethodParam1_Name;
            }

            if (childAccessInfo.numberOfExpresions == 2) {
                if (!uses_ChildAccess_MethodParam2) { // static access of the first child accessor. use accessExpr1
                    getChildDescriptor_ParamValue2 = childAccessInfo.accessExpr2;

                } else {

                    if (childAccessInfo.is_StaticAccess && childAccessInfo.accessExpr2_Is_ContinuationIndex)  // static access with continuation index
                        getChildDescriptor_ParamValue2 = null;
                    else if (childAccessInfo.accessExpr2_Is_ContinuationIndex) // dyn access with continuation Index
                        getChildDescriptor_ParamValue2 = childAccess_MethodParam_ContIndex_Name;
                    else // dyn access with desc tag and label
                        getChildDescriptor_ParamValue2 = childAccess_MethodParam2_Name;
                }
            }

            
        } else { // Multi-access
            getChildDescriptor_ParamValue1 = childAccess_MethodParam1_Name;
            getChildDescriptor_ParamValue2 = null;
        }
    }




    /**
     *  Add the pair of "Intra-Method" Access Expressions to the childAccess-Pairs List. By Intra-Method, we mean the expression that is used
     *  inside the access method itself to refer to each accessor (and not the expressions used as a value to the call to the method)
     *  NOTE: for descriptors, this is just the getChildDescriptor_ParamValue, but for field access, it's much more difficult to figure out.
     * 
     * @param intraMethod_ChildAccessExpr_Pairs__List
     */
    public void setup_3_IntraMethod_ChildAccessPairs(List<Pair<String, String>> intraMethod_ChildAccessExpr_Pairs__List) {


        if (childAccessInfo.typeOfElementAccessed == DescriptorAccess_ChildAccessInfo.TypeOfElementAccessed.Descriptor) {
            intraMethodChildAccess_Value1 = getChildDescriptor_ParamValue1;
            intraMethodChildAccess_Value2 = getChildDescriptor_ParamValue2;

        } else { // Field Access
            if (childAccessInfo.accessExpr2_Is_ContinuationIndex) { // continuation field access
                if (childAccessInfo.is_StaticAccess) { // static continuation field-access
                    intraMethodChildAccess_Value1 = childAccessInfo.accessExpr1;
                } else {  // dyn method /w two params
                    intraMethodChildAccess_Value1 = getChildDescriptor_ParamValue1;
                }
                intraMethodChildAccess_Value2 = childAccess_MethodParam_ContIndex_Name;

            } else { // standard field access
                intraMethodChildAccess_Value1 = getChildDescriptor_ParamValue1;
                intraMethodChildAccess_Value2 = null;

            }
        }

        intraMethod_ChildAccessExpr_Pairs__List.add(new Pair<String, String>(intraMethodChildAccess_Value1, intraMethodChildAccess_Value2));
    }

    

}
