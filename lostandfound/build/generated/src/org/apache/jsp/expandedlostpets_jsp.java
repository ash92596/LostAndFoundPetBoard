package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.mypackage.login.expandlostservlet;
import org.mypackage.login.lostpet;
import java.sql.*;
import java.io.*;

public final class expandedlostpets_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-16BE");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('﻿');
      out.write('﻿');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"image/jpg; charset=UTF-8\">\n");
      out.write("        <title>View</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <img src=\"imagetest.jsp\" width=\"240\" height=\"300\"/>\n");
      out.write("              \n");
      out.write("        <div align=\"center\">\n");
      out.write("             ");
 lostpet lp = (lostpet) session.getAttribute("lostinfo"); 
      out.write("         \n");
      out.write("             ");
 String area = (String)request.getSession().getAttribute("area"); 
      out.write("\n");
      out.write("             \n");
      out.write("             <ul>\n");
      out.write("             <li>");
      out.print( lp.getUserid());
      out.write("</li>\n");
      out.write("             <li>");
      out.print( lp.getSpecies());
      out.write("</li>\n");
      out.write("             <li>");
      out.print( lp.getDescription());
      out.write("</li>\n");
      out.write("             <li>");
      out.print( lp.getContact());
      out.write("</li>\n");
      out.write("             <li>");
      out.print( lp.getStatus());
      out.write("</li>\n");
      out.write("             <li>");
      out.print( lp.getAddress() );
      out.write("</li>\n");
      out.write("             </ul>\n");
      out.write("             <input type=\"checkbox\" name=\"flag\" value=\"Flag\" />\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
