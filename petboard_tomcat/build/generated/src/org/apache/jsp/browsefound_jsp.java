package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class browsefound_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Found Pets</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Found Pets</h1>\n");
      out.write("        \n");
      out.write("         ");
 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String hostName = "cburroughs.database.windows.net"; // update me
        String dbName = "petboard"; // update me
        String us = "cburroughs"; // update me
        String pass = "Jilsog12God!"; // update me
        String url = String.format("jdbc:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s;encrypt=true;"
            + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, us, pass);
            
            //connects and adds date to html tabel, images will not display
            Connection connection = DriverManager.getConnection(url);

            Statement statement = connection.createStatement() ;
            ResultSet resultset = 
                statement.executeQuery("select * from foundpets") ; 
        
      out.write("\n");
      out.write("        \n");
      out.write("        <TABLE BORDER=\"1\">\n");
      out.write("            <thead>  \n");
      out.write("            <TR>\n");
      out.write("                <TH>User</TH>\n");
      out.write("                <th>Status</th>\n");
      out.write("                <TH>Species</TH>\n");
      out.write("                <TH>Description</TH>\n");
      out.write("                <th>Area</th>\n");
      out.write("                <th>Expand</th>\n");
      out.write("                \n");
      out.write("            </TR>\n");
      out.write("            </thead>\n");
      out.write("           \n");
      out.write("            ");
 while(resultset.next()){ 
      out.write("\n");
      out.write("             <tbody>  \n");
      out.write("                <tr>\n");
      out.write("                    \n");
      out.write("     \n");
      out.write("            <td> ");
      out.print( resultset.getString(1) );
      out.write("</td>\n");
      out.write("            <td> ");
      out.print( resultset.getString(6) );
      out.write("</td>\n");
      out.write("            <td> ");
      out.print( resultset.getString(2) );
      out.write("</td>\n");
      out.write("            <td> ");
      out.print( resultset.getString(3) );
      out.write("</td>\n");
      out.write("            <td> ");
      out.print( resultset.getString(9) );
      out.write("</td>\n");
      out.write("            \n");
      out.write("            <td>                               \n");
      out.write("                <form id=\"info\" action=\"expandfoundservlet\" method=\"POST\">\n");
      out.write("    <input type=\"hidden\" name=\"address\" value=\"");
      out.print( resultset.getString(9) );
      out.write("\" />\n");
      out.write("    <input id=\"button\" type=\"submit\" value=\"View\" >\n");
      out.write("                   </form>                 \n");
      out.write("            </td>\n");
      out.write("           </tr>\n");
      out.write("        </tbody> \n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("            \n");
      out.write("            </table>\n");
      out.write("        \n");
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
