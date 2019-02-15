<%-- 
    Document   : browsefound
    Created on : 
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Found Pets</title>
    </head>
    <body>
        <h1>Found Pets</h1>
        
         <% 
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
        %>
        
        <TABLE BORDER="1">
            <thead>  
            <TR>
                <TH>User</TH>
                <th>Status</th>
                <TH>Species</TH>
                <th>Area</th>
                <th>Expand</th>
                
            </TR>
            </thead>
           
            <% while(resultset.next()){ %>
             <tbody>  
                <tr>
                    
     
            <td> <%= resultset.getString(1) %></td>
            <td> <%= resultset.getString(6) %></td>
            <td> <%= resultset.getString(2) %></td>
            <td> <%= resultset.getString(9) %></td>
            
            <td>                               
                <form id="info" action="expandfoundservlet" method="POST">
    <input type="hidden" name="address" value="<%= resultset.getString(9) %>" />
    <input id="button" type="submit" value="View" >
                   </form>                 
            </td>
           </tr>
        </tbody> 
            <% } %>
            
            </table>
        
        
    </body>
</html>
