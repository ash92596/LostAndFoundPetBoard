<%-- 
    Document   : browselost
    Created on : Jan 30, 2019, 3:59:26 PM
    Author     : Connor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lost Pets</title>
    </head>
    <body>
        <h1>Lost Pets</h1>
        

        <% 
            //connects and adds date to html tabel, images will not display
            Connection connection = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/users", "app", "app");

            Statement statement = connection.createStatement() ;
            ResultSet resultset = 
                statement.executeQuery("select * from lostpets") ; 
        %>
        
        <TABLE BORDER="1">
            <TR>
                <TH>User</TH>
                <TH>Species</TH>
                <TH>Description</TH>
                
            </TR>
            <% while(resultset.next()){ %>
            
            <TD> <%= resultset.getString(1) %></td>
            <TD> <%= resultset.getString(2) %></td>
            <TD> <%= resultset.getString(3) %></td>
            
            
            
            <% } %>
            </table>
    </body>
</html>
