package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.io.*;
import org.mypackage.login.expandlostservlet;

public final class imagetest_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("       \n");
      out.write("         ");

       Blob image = null;

       Connection con = null;

      byte[ ] imgData = null ;

     Statement stmt = null;

      ResultSet rs = null;
       
       //String user = session.getAttribute("SessionUser");
       
       try {
			//Class.forName(" org.apache.derby.jdbc.ClientDriver.class");
			con = DriverManager.getConnection("jdbc:derby://localhost:1527/users","app","app");
			stmt = con.createStatement();
			rs = stmt.executeQuery("select photo from lostpets where  userid = '"+session.getAttribute("SessionUser")+"'");
			if (rs.next()) {
				image = rs.getBlob(1);
				imgData = image.getBytes(1,(int)image.length());
			} else {
				out.println("Display Blob Example");
				out.println("image not found for given id>");
				return;
			}

       
       
        response.setContentType("image/jpg");
         OutputStream o = response.getOutputStream();
         o.write(imgData);
         o.flush();
         o.close();
		} catch (Exception e) {
			out.println("Unable To Display image");
			out.println("Image Display Error=" + e.getMessage());
			return;
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
       
       
       
       
       
       
       
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
