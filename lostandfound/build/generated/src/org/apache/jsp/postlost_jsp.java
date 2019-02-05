package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class postlost_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Lost Pet</title>\n");
      out.write("        \n");
      out.write("        <style>\n");
      out.write("      /* Always set the map height explicitly to define the size of the div\n");
      out.write("       * element that contains the map. */\n");
      out.write("      #map {\n");
      out.write("        height: 50%;\n");
      out.write("      }\n");
      out.write("      /* Optional: Makes the sample page fill the window. */\n");
      out.write("      html, body {\n");
      out.write("        height: 100%;\n");
      out.write("        margin: 0;\n");
      out.write("        padding: 0;\n");
      out.write("      }\n");
      out.write("    </style>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Lost Pet Info</h1>\n");
      out.write("        \n");
      out.write("        <form id=\"info\" method=\"post\" action=\"lostpetservlet\"  enctype=\"multipart/form-data\">\n");
      out.write("            UserID:\n");
      out.write("            <input type=\"text\" name=\"userid\" value=\"\" />\n");
      out.write("            Species(specify breed):\n");
      out.write("            <input type=\"text\" name=\"species\" value=\"\" />\n");
      out.write("            Description:\n");
      out.write("            <textarea name=\"description\" rows=\"6\" cols=\"40\">\n");
      out.write("            </textarea>\n");
      out.write("            Photo:\n");
      out.write("            <input type=\"file\" name=\"photo\" value=\"\" />\n");
      out.write("            Contact Info(phone/email):\n");
      out.write("            <textarea name=\"contact\" rows=\"6\" cols=\"40\">\n");
      out.write("            </textarea>\n");
      out.write("            Status:\n");
      out.write("            <select name=\"status\">\n");
      out.write("                <option value=\"Missing\">Missing</option>\n");
      out.write("               <option value=\"Reunited\">Reunited</option>\n");
      out.write("            </select>\n");
      out.write("            <input type=\"hidden\" name=\"latposition\" id=\"latposition\"/>\n");
      out.write("            <input type=\"hidden\" name=\"lngposition\" id=\"lngposition\"/>\n");
      out.write("            <input type=\"submit\" value=\"Submit\" onClick=\"processinfo()\" />\n");
      out.write("\n");
      out.write("            \n");
      out.write("        </form> \n");
      out.write("        \n");
      out.write("        <div id=\"map\" height=\"460px\" width=\"100%\"></div>\n");
      out.write("        \n");
      out.write("        <div id=\"form\">\n");
      out.write("            \n");
      out.write("            <table>\n");
      out.write("                \n");
      out.write("                <tr><td><td>Confirm lost pet location</td><input type='button' value='save' onclick='markerdata()'/></td></tr>\n");
      out.write("                   \n");
      out.write("                                \n");
      out.write("            </table>\n");
      out.write("                                  \n");
      out.write("                      \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    <script>\n");
      out.write("      var map;\n");
      out.write("      var marker;\n");
      out.write("      var infowindow;\n");
      out.write("      var locationlat;\n");
      out.write("      var locationlng;\n");
      out.write("      function initMap() {\n");
      out.write("         var alabama = {lat: 32.3792, lng: -86.3077};\n");
      out.write("        map = new google.maps.Map(document.getElementById('map'), {\n");
      out.write("          center: alabama,\n");
      out.write("          zoom: 13\n");
      out.write("        });\n");
      out.write("        \n");
      out.write("        infowindow = new google.maps.InfoWindow({\n");
      out.write("          content: document.getElementById('form')\n");
      out.write("        });\n");
      out.write("        \n");
      out.write("        \n");
      out.write("         google.maps.event.addListener(map, 'click', function(event) {\n");
      out.write("          marker = new google.maps.Marker({\n");
      out.write("            position: event.latLng,\n");
      out.write("            map: map\n");
      out.write("          });\n");
      out.write("          \n");
      out.write("          google.maps.event.addListener(marker, 'click', function() {\n");
      out.write("            infowindow.open(map, marker);\n");
      out.write("        });\n");
      out.write("          \n");
      out.write("      });\n");
      out.write("      }\n");
      out.write("      \n");
      out.write("      function markerdata(){\n");
      out.write("          \n");
      out.write("          var latlng = marker.getPosition();\n");
      out.write("           locationlat = latlng.lat();\n");
      out.write("           locationlng= latlng.lng();              \n");
      out.write("      }\n");
      out.write("      \n");
      out.write("      function processinfo(){\n");
      out.write("          \n");
      out.write("          var hiddenlat = document.getElementById(\"latposition\");\n");
      out.write("          var hiddenlng = document.getElementById(\"lngposition\")\n");
      out.write("          hiddenlat.value= locationlat;\n");
      out.write("          hiddenlng.value= locationlng;\n");
      out.write("          \n");
      out.write("          var form = document.getElementById(\"info\");\n");
      out.write("          form.submit();\n");
      out.write("      }\n");
      out.write("      \n");
      out.write("      \n");
      out.write("    </script>\n");
      out.write("    <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyDkYfkn-x3aD_jJWJwa_81AnA3Qz-d-TcU&callback=initMap\"\n");
      out.write("    async defer></script>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <!--<form id=\"info\" method=\"post\" action=\"lostpetservlet\"  enctype=\"multipart/form-data\">\n");
      out.write("            UserID:\n");
      out.write("            <input type=\"text\" name=\"userid\" value=\"\" />\n");
      out.write("            Species(specify breed):\n");
      out.write("            <input type=\"text\" name=\"species\" value=\"\" />\n");
      out.write("            Description:\n");
      out.write("            <textarea name=\"description\" rows=\"6\" cols=\"40\">\n");
      out.write("            </textarea>\n");
      out.write("            Photo:\n");
      out.write("            <input type=\"file\" name=\"photo\" value=\"\" />\n");
      out.write("            Contact Info(phone/email):\n");
      out.write("            <textarea name=\"contact\" rows=\"6\" cols=\"40\">\n");
      out.write("            </textarea>\n");
      out.write("            Status:\n");
      out.write("            <select name=\"status\">\n");
      out.write("                <option value=\"Missing\">Missing</option>\n");
      out.write("               <option value=\"Reunited\">Reunited</option>\n");
      out.write("            </select>\n");
      out.write("            <input type=\"hidden\" name=\"markerposition\" id=\"markerposition\"/>\n");
      out.write("            \n");
      out.write("            <input type=\"submit\" value=\"Submit\" name=\"post\" />\n");
      out.write("\n");
      out.write("            \n");
      out.write("        </form> -->\n");
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
