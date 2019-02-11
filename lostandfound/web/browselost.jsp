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
            <thead>  
            <TR>
                <TH>User</TH>
                <th>Satus</th>
                <TH>Species</TH>
                <TH>Description</TH>
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
            <td> <%= resultset.getString(3) %></td>
            <td> <%= resultset.getString(9) %></td>
            
            <td>                               
                <form id="info" action="expandlostservlet" method="POST">
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
