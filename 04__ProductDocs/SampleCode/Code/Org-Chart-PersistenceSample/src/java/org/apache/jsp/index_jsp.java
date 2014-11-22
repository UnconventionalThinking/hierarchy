/*  ~*~*~Matrix Meta-Compiled File~*~*~  */

package org . apache . jsp ;

import com.mycompany.hr.AppControl;
import com.mycompany.hr.AppSymbols;
import com.mycompany.hr.AppSymbols_DescTagName;
import com.mycompany.hr.AppSymbols_Label;
import com.mycompany.hr.AppSymbols_DescTag;
import com.mycompany.hr.AppSymbols_MatrixName;
import com.mycompany.hr.AppSymbols_SchemaName;

import net.unconventionalthinking.matrix.*;
import net.unconventionalthinking.lang.*;
import net.unconventionalthinking.matrix.metacompiler.codegen.Exception_MetaCompilerError;
import net.unconventionalthinking.matrix.symbols.*;
import javax . servlet . * ;
import javax . servlet . http . * ;
import javax . servlet . jsp . * ;
import java . text . SimpleDateFormat ;
import java . text . Format ;
import java . util . List ;
import java . util . Arrays ;
import java . util . Iterator ;
import java . io . IOException ;
import java . net . URL ;
import java . net . MalformedURLException ;
import net . unconventionalthinking . hierarchy . persistence . * ;
import com . mycompany . hr . * ;
import net . unconventional . persistence . * ;
public  final  class index_jsp extends org . apache . jasper . runtime . HttpJspBase  implements org . apache . jasper . runtime . JspSourceDependent , index_jsp__Annotations {


	private final static AppControl_Base appControl = com.mycompany.hr.AppControl.initializeApp();
	private final static ExecutionInfo executeInfo = appControl.executionInfo;


	public static final String ClientPropertiesFile_RelPath = "/WEB-INF/client-matrix-persistence.properties" ;
	public static final String IsFormSubmission_FieldName = "isFormSubmission" ;
	public static final String Title_FieldName = "Title" ;
	public static final String FullName_FieldName = "FullName" ;
	public static final String ID_Label = "ID" ;
	public static final String ManagerID_Label = "ManagerID" ;
	static SymbolControl symbolControl ;
	static SchemaInfo_Schema orgChartSchema ;
	static Matrix orgChartMatrix ;
	static PersistentMatricesManager_Client persistManager_Client ;
	@ Override public void jspInit ( ) {
		ServletContext servletContext = getServletConfig ( ) . getServletContext ( ) ;
		String clientPropertiesFile_FullPath = servletContext . getRealPath ( ClientPropertiesFile_RelPath ) ;
		symbolControl  = appControl.symbolControl;
		orgChartSchema  = OrgChart$__$Schema.schema;
		orgChartMatrix  = OrgChart.matrix;
		PersistentMatricesManager_Configurator_Client clientConfigurator = null ;
		try {
			clientConfigurator  = new PersistentMatricesManager_Configurator_Client ( clientPropertiesFile_FullPath , appControl . matrixControl ) ;
			persistManager_Client  = clientConfigurator . configure ( ) ;
			
		}
		catch ( IOException e ) {
			throw new JspInitializationRuntimeException ( "Tried to configure the Persistence Client, but had an error." , e ) ;
			
		}
		persistManager_Client . printSettings ( ) ;
		persistManager_Client . start_PersistenceLogging ( ) ;
		
	}
	public void jspDestroy ( ) {
		try {
			persistManager_Client . shutdown ( ) ;
			
		}
		catch ( Exception e ) {
			throw new JspInitializationRuntimeException ( "Tried to shutdown the Persistence Client, but had an error." , e ) ;
			
		}
		
	}
	private void addNewEmployee ( String fullName , String title , String id , String managerId ) throws Exception {
		SchemaInfo_Descriptor employee_SchemaInfo = orgChartSchema . getChild_SchemaInfoDescriptor ( executeInfo , AppSymbols_DescTagName.EMPLOYEE ) ;
		List < String > labelParts = Arrays . asList ( id ) ;
		Label label = symbolControl . multiPartSymbol_Factory . createNew_Label ( labelParts , 1 , false ) ;
		MatrixSet < SchemaInfo_Schema > uses_SchemaSet = null ;
		Descriptor managerDesc = findEmployee ( managerId ) ;
		Descriptor new_EmployeeDesc = null ;
		Integer_Mutable createdDesc_logVarName_OUT = new Integer_Mutable ( ) ;
		new_EmployeeDesc  = persistManager_Client . commandEncoder_Desc . createNew_Descriptor ( executeInfo , createdDesc_logVarName_OUT , employee_SchemaInfo , label , uses_SchemaSet , managerDesc ) ;
		persistManager_Client . commandEncoder_Desc . addDescriptor ( executeInfo , managerDesc , new_EmployeeDesc ) ;
		PersistenceWrapper_FieldSet fieldSet_PersistWrapper = new PersistenceWrapper_FieldSet ( executeInfo , new_EmployeeDesc . get_FieldSet_Tuple ( executeInfo ) , persistManager_Client ) ;
		if ( fullName != null && fullName . length ( ) > 0 ) fieldSet_PersistWrapper . setField ( executeInfo , 0 , WebUtilities . convertStringForWeb ( fullName ) ) ;
		if ( title != null && title . length ( ) > 0 ) fieldSet_PersistWrapper . setField ( executeInfo , 1 , WebUtilities . convertStringForWeb ( title ) ) ;
		
	}
	Descriptor findEmployee ( String employee_id ) throws Exception {
		List < String > labelParts = Arrays . asList ( employee_id ) ;
		Label employeeId_label = symbolControl . multiPartSymbol_Factory . createNew_Label ( labelParts , 1 , false ) ;
		net.unconventionalthinking.matrix.Descriptor foundEmployee = search_OrgChartMatrix ( index_jsp__MatrixWorker.accessMatrix_OrgChart__27(executeInfo, this), employeeId_label ) ;
		return ( foundEmployee ) ;
		
	}
	Descriptor search_OrgChartMatrix ( net.unconventionalthinking.matrix.Descriptor currEmployeeDesc , Label employeeId_label ) {
		if ( currEmployeeDesc . label == employeeId_label ) return currEmployeeDesc ;
		else if ( currEmployeeDesc . get_ChildDescriptors_Size ( executeInfo ) == 0 ) return null ;
		else {
			for ( net.unconventionalthinking.matrix.Descriptor childEmployeeDesc : index_jsp__MatrixWorker.accessMatrix___28(executeInfo, currEmployeeDesc, this, AppSymbols_DescTagName.EMPLOYEE)) {
				net.unconventionalthinking.matrix.Descriptor foundDescriptor = search_OrgChartMatrix ( childEmployeeDesc , employeeId_label ) ;
				if ( foundDescriptor != null ) return foundDescriptor ;
				
			}
			return null ;
			
		}
		
	}
	static boolean userHasSubmittedForm ( HttpServletRequest request ) {
		String IsSubmittedForm_RawValue = request . getParameter ( "isFormSubmission" ) ;
		return ( requestFieldHasText ( IsSubmittedForm_RawValue ) && IsSubmittedForm_RawValue . equals ( "true" ) ) ;
		
	}
	static boolean requestFieldHasText ( String value ) {
		if ( value == null ) return false ;
		String trimmedValue = value . trim ( ) ;
		if ( trimmedValue . length ( ) > 1 ) return true ;
		else return false ;
		
	}
	private static final JspFactory _jspxFactory = JspFactory . getDefaultFactory ( ) ;
	private static java . util . List _jspx_dependants ;
	private javax . el . ExpressionFactory _el_expressionfactory ;
	private org . apache . AnnotationProcessor _jsp_annotationprocessor ;
	public Object getDependants ( ) {
		return _jspx_dependants ;
		
	}
	public void _jspInit ( ) {
		_el_expressionfactory  = _jspxFactory . getJspApplicationContext ( getServletConfig ( ) . getServletContext ( ) ) . getExpressionFactory ( ) ;
		_jsp_annotationprocessor  = ( org . apache . AnnotationProcessor ) getServletConfig ( ) . getServletContext ( ) . getAttribute ( org . apache . AnnotationProcessor . class . getName ( ) ) ;
		
	}
	public void _jspDestroy ( ) {
		
	}
	public void _jspService ( HttpServletRequest request , HttpServletResponse response ) throws java . io . IOException , ServletException {
		PageContext pageContext = null ;
		HttpSession session = null ;
		ServletContext application = null ;
		ServletConfig config = null ;
		JspWriter out = null ;
		Object page = this ;
		JspWriter _jspx_out = null ;
		PageContext _jspx_page_context = null ;
		try {
			response . setContentType ( "text/html;charset=UTF-8" ) ;
			pageContext  = _jspxFactory . getPageContext ( this , request , response , null , true , 8192 , true ) ;
			_jspx_page_context  = pageContext;
			application  = pageContext . getServletContext ( ) ;
			config  = pageContext . getServletConfig ( ) ;
			session  = pageContext . getSession ( ) ;
			out  = pageContext . getOut ( ) ;
			_jspx_out  = out;
			out . write ( "\n\n\n\n\n\n\n\n\n\n\n\n\n<!--  Import the generated Matrix and Schema classes-->\n\n\n\n<!--  Import the matrices and schemas-->\n\n\n\n\n\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n   \"http://www.w3.org/TR/html4/loose.dtd\">\n\n\n" ) ;
			out . write ( '\n' ) ;
			out . write ( '\n' ) ;
			out . write ( '\n' ) ;
			String adminMessage = null ;
			if ( userHasSubmittedForm ( request ) ) {
				String fullName = request . getParameter ( FullName_FieldName ) ;
				String title = request . getParameter ( Title_FieldName ) ;
				String id = request . getParameter ( ID_Label ) ;
				String managerId = request . getParameter ( ManagerID_Label ) ;
				addNewEmployee ( fullName , title , id , managerId ) ;
				adminMessage  = "Successfully added new employee, \"" + fullName + ".\"" ;
				
			}
			out . write ( "\n<html>\n    <head>\n        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n        <title>My Company</title>\n    </head>\n    <body>\n\n<table><tr>\n    <td width='20'>\n\n        <font face=\"arial\">\n \n            <h1>HR Admin</h1>\n\n            " ) ;
			if ( adminMessage != null ) {
				out . println ( "<font color='red'>" + adminMessage + "</font><p>" ) ;
				
			}
			out . write ( "\n\n            <div style=\"margin-left:16px;\">\n            <form action='index.jsp' method='get'>\n                <b> Add a new employee</b><br>\n                <table>\n\n                <tr>\n                    <td>Full Name</td>\n                    <td>&nbsp;&nbsp;</td>\n                    <td><input type='text' name='" ) ;
			out . print ( FullName_FieldName ) ;
			out . write ( "' size='22' value=\"\"/></td>\n                </tr>\n                <tr>\n                    <td>Title</td>\n                    <td>&nbsp;&nbsp;</td>\n                    <td><input type='text' name='" ) ;
			out . print ( Title_FieldName ) ;
			out . write ( "' size='22' value=\"\"/></td>\n                </tr>\n                <tr>\n                    <td>ID</td>\n                    <td>&nbsp;&nbsp;</td>\n                    <td><input type='text' name='" ) ;
			out . print ( ID_Label ) ;
			out . write ( "' size='10' value=\"\"/></td>\n                </tr>\n                <tr>\n                    <td nowrap>Manager ID</td>\n                    <td>&nbsp;&nbsp;</td>\n                    <td><input type='text' name='" ) ;
			out . print ( ManagerID_Label ) ;
			out . write ( "' size='10' value=\"\"/></td>\n                </tr>\n                <tr>\n                    <td colspan='20'>&nbsp;</td>\n                </tr>\n                <tr>\n                    <td colspan='20'><input type=\"submit\" value=\"Add\" /></td>\n                </tr>\n                </table>\n                <input type=\"hidden\" name=\"" ) ;
			out . print ( IsFormSubmission_FieldName ) ;
			out . write ( "\" value=\"true\">\n             </form>\n             </div>\n            <br>\n            <br>\n            <br>\n            <br>\n\n        </font>\n    </td>\n\n    <td width=\"100%\">\n        <font face=\"arial\">\n\n            <table cellpadding='6' style='margin-left:auto; margin-right:auto;'>\n            <tr>\n                <td style=\"text-align: center; font-size:30px;font-weight:bold;\" colspan=\"99\">\n                    <div style=\"margin-bottom:20px;\">MyCompany's Org-Chart</div></td>\n            </tr>\n            " ) ;
			out . print ( ( ( new OrgChartPrinter ( ) ) . print ( ) ) ) ;
			out . write ( "\n            </table>\n\n        </font>\n    </td>\n</tr></table>\n\n    </body>\n</html>\n\n" ) ;
			out . write ( "\n\n\n\n\n" ) ;
			
		}
		catch ( Throwable t ) {
			if ( ! ( t instanceof SkipPageException ) ) {
				out  = _jspx_out;
				if ( out != null && out . getBufferSize ( ) != 0 ) try {
					out . clearBuffer ( ) ;
					
				}
				catch ( java . io . IOException e ) {
					
				}
				if ( _jspx_page_context != null ) _jspx_page_context . handlePageException ( t ) ;
				
			}
			
		}
		finally {
			_jspxFactory . releasePageContext ( _jspx_page_context ) ;
			
		}
		
	}
	
	public  Object annotationHandler_2(ExecutionInfo executeInfo, 
		boolean annotationReference_Exists, Symbol annotationRef_Base, int annotationRef_AccessCounter,
		int childAccessIndex, AnnotationParameters.AccessType accessType, AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam, 
		Descriptor rootAccessDescriptor, Descriptor currAccessors_ParentDescriptor, MatrixSet<Descriptor> currAccessors_ParentDescriptorSet, 
		boolean passingInException, Exception e, Pair<Object, Object>... childAccessor_Pairs) {

		
		//  Default:
				return null ;


	}

	public  Object annotationHandler_3(ExecutionInfo executeInfo, 
		boolean annotationReference_Exists, Symbol annotationRef_Base, int annotationRef_AccessCounter,
		int childAccessIndex, AnnotationParameters.AccessType accessType, AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam, 
		Descriptor rootAccessDescriptor, Descriptor currAccessors_ParentDescriptor, MatrixSet<Descriptor> currAccessors_ParentDescriptorSet, 
		boolean passingInException, Exception e, Pair<Object, Object>... childAccessor_Pairs) {

		
		//  Default:
				return null ;


	}

	public  Object annotationHandler_4(ExecutionInfo executeInfo, 
		boolean annotationReference_Exists, Symbol annotationRef_Base, int annotationRef_AccessCounter,
		int childAccessIndex, AnnotationParameters.AccessType accessType, AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam, 
		Descriptor rootAccessDescriptor, Descriptor currAccessors_ParentDescriptor, MatrixSet<Descriptor> currAccessors_ParentDescriptorSet, 
		boolean passingInException, Exception e, Pair<Object, Object>... childAccessor_Pairs) {

		
		//  Default:
				return null ;


	}

	public  Object annotationHandler_10(ExecutionInfo executeInfo, 
		boolean annotationReference_Exists, Symbol annotationRef_Base, int annotationRef_AccessCounter,
		int childAccessIndex, AnnotationParameters.AccessType accessType, AnnotationParameters_AccessReturnType_OutParam accessReturnType_OutParam, 
		Descriptor rootAccessDescriptor, Descriptor currAccessors_ParentDescriptor, MatrixSet<Descriptor> currAccessors_ParentDescriptorSet, 
		boolean passingInException, Exception e, Pair<Object, Object>... childAccessor_Pairs) {

		
		//  Default:
				return null ;


	}





}
