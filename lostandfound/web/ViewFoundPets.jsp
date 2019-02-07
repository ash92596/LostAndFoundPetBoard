<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : ViewFoundPets
    Created on : Feb 6, 2019, 8:06:37 PM
    Author     : NV121
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="myStyle.css">
    <table border="0">
        <thead>
            <tr>
                <th>Our mission is to reunite pets with their owners</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>To view contact detail of pets found please select 
                    one of the following </td>
            </tr>
            <tr>
                <td>
                    <form action="PostfoundPage.jsp">
                        <strong>Select a pet </strong>
                        <select name="species">
                            <option></option>
                        </select>
                        <input type="submit" value="submit" name="submit" />
                    </form></td>
            </tr>
        </tbody>
    </table>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Found Pets</title>
    </head>
    <body>
        <h1>Here is a list of our found pets</h1>
           <% 
            //connects and adds date to html tabel, images will not display
            Connection connection = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/users", "app", "app");

            Statement statement = connection.createStatement() ;
            ResultSet resultset = 
                statement.executeQuery("select * from pets") ; 
        %>
        
        <TABLE BORDER="1">
            <TR>
                <TH>User</TH>
                <TH>Species</TH>
                <TH>Description</TH>
                
            </TR>
            <% while(resultset.next()){ %>
            
            <TD> <%= resultset.getString(1)  %><br></td>
            <TD> <%= resultset.getString(2) %></td>
            <TD> <%= resultset.getString(3) %></td>
            
            
            
            <% } %>
            </table>
    </body>
</html>
