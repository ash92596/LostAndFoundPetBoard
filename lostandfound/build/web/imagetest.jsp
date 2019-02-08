<%-- 
    Document   : test
    Created on : Feb 4, 2019, 4:25:58 PM
    Author     : Connor
--%>


<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@page import ="org.mypackage.login.expandlostservlet" %>
       
         <%
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
			rs = stmt.executeQuery("select photo from lostpets where  userid = '"+session.getAttribute("image")+"'");
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
       
       
       
       
       
       
       %>
        
        
        
        
        
        


