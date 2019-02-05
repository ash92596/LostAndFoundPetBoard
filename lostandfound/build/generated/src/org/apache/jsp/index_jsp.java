package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\" >\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Sign Up Form</title>\r\n");
      out.write("        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>\r\n");
      out.write("        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css'>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\"> \r\n");
      out.write("        <script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js'></script>\r\n");
      out.write("        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>\r\n");
      out.write("        <script  src=\"index.js\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"wrapper\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"title\">\r\n");
      out.write("                        <h1>Lost and Found Pet Board</h1>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"col-md-6 col-md-offset-3\">\r\n");
      out.write("                        <div class=\"form\">\r\n");
      out.write("\r\n");
      out.write("                            <!--sign up screen-->\r\n");
      out.write("                            <div class=\"input-container sign-up\">\r\n");
      out.write("                                <div class=\"avatar-wrapper\">\t\r\n");
      out.write("                                    <img src=\"https://s3.amazonaws.com/bucketdrum/Facebook_UI-07-512.png\" class=\"avatar\"/>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <h2>sign up</h2>\r\n");
      out.write("                                <p>Its free and only takes a minute!</p>\r\n");
      out.write("                                <form name=\"User Info\" action=\"accountservlet\" method=\"GET\">\r\n");
      out.write("                                    <input type=\"text\" placeholder=\"User ID\" name=\"userid\" value=\"\" />\r\n");
      out.write("                                    <input type=\"text\" placeholder=\"Email\" name=\"email\" value=\"\" />\r\n");
      out.write("                                    <input type=\"password\" placeholder=\"Password\" name=\"password\" value=\"\" />\r\n");
      out.write("                                    <input type=\"text\" placeholder=\"Zip Code\" name=\"zipcode\" value=\"\" />\r\n");
      out.write("                                    <button class=\"btn submit-btn\" value=\"OK\" type=\"submit\" onclick=\"onSubmitBtnClick()\">SUBMIT</button>\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <!--login screen-->\r\n");
      out.write("                            <div class=\"input-container login\">\r\n");
      out.write("                                <div class=\"avatar-wrapper\">\t\r\n");
      out.write("                                    <img src=\"https://s3.amazonaws.com/bucketdrum/Facebook_UI-07-512.png\" class=\"avatar\"/>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <h2>login</h2>\r\n");
      out.write("                                <p>Welcome back!</p>\r\n");
      out.write("                                <form name=\"login\" action=\"loginservlet\">\r\n");
      out.write("                                    <input type=\"text\" placeholder=\"User ID\" name=\"userid\" value=\"\" />\r\n");
      out.write("                                    <input type=\"password\" placeholder=\"Password\" name=\"password\" value=\"\" />\r\n");
      out.write("                                    <button class=\"btn submit-btn\" type=\"submit\" onclick=\"onSubmitBtnClick()\">SUBMIT</button>\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <!--login and sign up buttons-->\r\n");
      out.write("                            <div class=\"button-group\">\r\n");
      out.write("                                <button class=\"btn login-btn\" type=\"submit\" onclick=\"onLoginBtnClick()\">LOGIN</button>\r\n");
      out.write("                                <button class=\"btn signup-btn\" type=\"submit\" onclick=\"onSignupBtnClick()\">SIGN UP</button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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
