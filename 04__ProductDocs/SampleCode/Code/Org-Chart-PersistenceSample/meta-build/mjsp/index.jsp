<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.Format"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.io.IOException"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.MalformedURLException"%>


<%@page import="net.unconventionalthinking.hierarchy.persistence.*"%>


<!--  Import the generated Matrix and Schema classes-->
<%@page import="com.mycompany.hr.*"%>
<%@page import="net.unconventional.persistence.*"%>

<!--  Import the matrices and schemas-->
<%@page import="MATRIX com.mycompany.hr::OrgChart"%>
<%@page import="SCHEMA com.mycompany.hr::OrgChart.Schema"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<%!
    //  Constants ________________________________________________________________________

    //  This should be relative to the PersistentaMatrix WebSample project dir.
    public static final String ClientPropertiesFile_RelPath = "/WEB-INF/client-matrix-persistence.properties";

    public static final String IsFormSubmission_FieldName = "isFormSubmission";
    public static final String Title_FieldName = "Title";
    public static final String FullName_FieldName = "FullName";
    public static final String ID_Label = "ID";
    public static final String ManagerID_Label = "ManagerID";


    //  Static vars ______________________________________________________________________

    static SymbolControl symbolControl;

    static SchemaInfo_Schema orgChartSchema;
    static Matrix orgChartMatrix;

    static PersistentMatricesManager_Client persistManager_Client;

    @Override
    public void jspInit() {
        ServletContext servletContext = getServletConfig().getServletContext();

        String clientPropertiesFile_FullPath = servletContext.getRealPath(ClientPropertiesFile_RelPath);
        symbolControl = appControl.symbolControl;

        orgChartSchema = OrgChart$__$Schema.schema;
        orgChartMatrix = OrgChart.matrix;

        PersistentMatricesManager_Configurator_Client clientConfigurator = null;
        try{
            clientConfigurator = new PersistentMatricesManager_Configurator_Client(
                clientPropertiesFile_FullPath, appControl.matrixControl);
            persistManager_Client = clientConfigurator.configure();
        } catch (IOException e) {
            throw new JspInitializationRuntimeException("Tried to configure the Persistence Client, but had an error.", e);
        }
        persistManager_Client.printSettings();
        persistManager_Client.start_PersistenceLogging();
    }

    //  Shutdown the client
    public void jspDestroy() {
        try {
            persistManager_Client.shutdown();
        } catch (Exception e) {
            throw new JspInitializationRuntimeException("Tried to shutdown the Persistence Client, but had an error.", e);
        }
    }

%>


<%
    String adminMessage = null;
    if (userHasSubmittedForm(request)) {
        //  Get form info and add news item to persistent matrix
        String fullName = request.getParameter(FullName_FieldName);
        String title = request.getParameter(Title_FieldName);
        String id = request.getParameter(ID_Label);
        String managerId = request.getParameter(ManagerID_Label);

        addNewEmployee(fullName, title, id, managerId);

        adminMessage = "Successfully added new employee, \"" + fullName + ".\"";
    }

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Company</title>
    </head>
    <body>

<table><tr>
    <td width='20'>

        <font face="arial">
 
            <h1>HR Admin</h1>

            <% if (adminMessage != null) {
                out.println("<font color='red'>" + adminMessage + "</font><p>");
            } %>

            <div style="margin-left:16px;">
            <form action='index.jsp' method='get'>
                <b> Add a new employee</b><br>
                <table>

                <tr>
                    <td>Full Name</td>
                    <td>&nbsp;&nbsp;</td>
                    <td><input type='text' name='<%=FullName_FieldName%>' size='22' value=""/></td>
                </tr>
                <tr>
                    <td>Title</td>
                    <td>&nbsp;&nbsp;</td>
                    <td><input type='text' name='<%=Title_FieldName%>' size='22' value=""/></td>
                </tr>
                <tr>
                    <td>ID</td>
                    <td>&nbsp;&nbsp;</td>
                    <td><input type='text' name='<%=ID_Label%>' size='10' value=""/></td>
                </tr>
                <tr>
                    <td nowrap>Manager ID</td>
                    <td>&nbsp;&nbsp;</td>
                    <td><input type='text' name='<%=ManagerID_Label%>' size='10' value=""/></td>
                </tr>
                <tr>
                    <td colspan='20'>&nbsp;</td>
                </tr>
                <tr>
                    <td colspan='20'><input type="submit" value="Add" /></td>
                </tr>
                </table>
                <input type="hidden" name="<%=IsFormSubmission_FieldName%>" value="true">
             </form>
             </div>
            <br>
            <br>
            <br>
            <br>

        </font>
    </td>

    <td width="100%">
        <font face="arial">

            <table cellpadding='6' style='margin-left:auto; margin-right:auto;'>
            <tr>
                <td style="text-align: center; font-size:30px;font-weight:bold;" colspan="99">
                    <div style="margin-bottom:20px;">MyCompany's Org-Chart</div></td>
            </tr>
            <%=( (new OrgChartPrinter()).print() )%>
            </table>

        </font>
    </td>
</tr></table>

    </body>
</html>

<%
    ANNOTATIONS {
        DEFAULT {
            return null;
        }
    }
%>




<%!
    //  __________________________________________________________________________________________________
    //
    //  Utility Methods
    //  __________________________________________________________________________________________________



    private void addNewEmployee(String fullName, String title, String id, String managerId) throws Exception {

        SchemaInfo_Descriptor employee_SchemaInfo = orgChartSchema.getChild_SchemaInfoDescriptor(executeInfo, :%EMPLOYEE);

        List<String> labelParts = Arrays.asList(id);
        Label label = symbolControl.multiPartSymbol_Factory.createNew_Label(labelParts, 1, false);
        MatrixSet<SchemaInfo_Schema> uses_SchemaSet = null;
        Descriptor managerDesc = findEmployee(managerId);

        Descriptor new_EmployeeDesc = null;
        Integer_Mutable createdDesc_logVarName_OUT = new Integer_Mutable();
        new_EmployeeDesc = persistManager_Client.commandEncoder_Desc.createNew_Descriptor(
                executeInfo, createdDesc_logVarName_OUT, 
                employee_SchemaInfo, label, uses_SchemaSet, managerDesc);

        persistManager_Client.commandEncoder_Desc.addDescriptor(executeInfo, managerDesc, new_EmployeeDesc);

        //  Set the field values.
        PersistenceWrapper_FieldSet fieldSet_PersistWrapper = new PersistenceWrapper_FieldSet(executeInfo, 
                                new_EmployeeDesc.get_FieldSet_Tuple(executeInfo), persistManager_Client);
        if (fullName != null && fullName.length() > 0)
            fieldSet_PersistWrapper.setField(executeInfo, 0, WebUtilities.convertStringForWeb(fullName));
        if (title != null && title.length() > 0)
            fieldSet_PersistWrapper.setField(executeInfo, 1, WebUtilities.convertStringForWeb(title));


        ANNOTATIONS {
            DEFAULT { return null; }
        }
    }



    Descriptor findEmployee(String employee_id) throws Exception {
        List<String> labelParts = Arrays.asList(employee_id);
        Label employeeId_label = symbolControl.multiPartSymbol_Factory.createNew_Label(labelParts, 1, false);
        
        DESCRIPTOR<OrgChart->EMPLOYEE> foundEmployee = search_OrgChartMatrix(OrgChart->`id1`, employeeId_label);
     
        return (foundEmployee);

        ANNOTATIONS {
            DEFAULT { return null; }
        }
    }
    Descriptor search_OrgChartMatrix(DESCRIPTOR<OrgChart->EMPLOYEE> currEmployeeDesc, Label employeeId_label) {
        
        if (currEmployeeDesc.label == employeeId_label)
            return currEmployeeDesc;
        else if (currEmployeeDesc.get_ChildDescriptors_Size(executeInfo) == 0)
            return null;
        else {
            for (DESCRIPTOR<OrgChart->EMPLOYEE> childEmployeeDesc : currEmployeeDesc->EMPLOYEE{*}) {
                DESCRIPTOR foundDescriptor = search_OrgChartMatrix(childEmployeeDesc, employeeId_label);
                if (foundDescriptor != null)
                    return foundDescriptor;
            }
            return null;
        }

        ANNOTATIONS {
            DEFAULT { return null; }
        }
    }
    

    static boolean userHasSubmittedForm(HttpServletRequest request) {

        String IsSubmittedForm_RawValue = request.getParameter("isFormSubmission");
        return (requestFieldHasText(IsSubmittedForm_RawValue) && IsSubmittedForm_RawValue.equals("true"));

    }

  
    static boolean requestFieldHasText(String value) {
        if (value == null) return false;
        String trimmedValue = value.trim();
        if (trimmedValue.length() > 1)
            return true;
        else
            return false;
    }
%>