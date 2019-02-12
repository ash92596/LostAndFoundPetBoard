<%-- 
    Document   : foundimage
    Created on : Feb 12, 2019, 4:17:23 AM
    Author     : Connor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@page import ="org.mypackage.login.expandfoundservlet" %>

<%
       Blob image = null;

       Connection con = null;

      byte[ ] imgData = null ;

     Statement stmt = null;

      ResultSet rs = null;
       
       //String user = session.getAttribute("SessionUser");
       
       try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String hostName = "cburroughs.database.windows.net"; // update me
        String dbName = "petboard"; // update me
        String us = "cburroughs"; // update me
        String pass = "Jilsog12God!"; // update me
        String url = String.format("jdbc:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s;encrypt=true;"
            + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, us, pass);
           
			con = DriverManager.getConnection(url);
			stmt = con.createStatement();
			rs = stmt.executeQuery("select photo from foundpets where  address = '"+session.getAttribute("image")+"'");
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