<%-- 
    Document   : editlost
    Created on : Feb 8, 2019, 12:18:08 PM
    Author     : Connor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@page import="org.mypackage.login.UserBean"%> 
<%@page import ="org.mypackage.login.loginservlet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Posts</title>
    </head>
    <body>
        <h1>Update your post</h1>
        
        <%UserBean currentUser = (UserBean) session.getAttribute("SessionUser");%>
        
         <% 
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String hostName = "cburroughs.database.windows.net"; 
        String dbName = "petboard"; 
        String us = "cburroughs"; 
        String pass = "Jilsog12God!"; 
        String url = String.format("jdbc:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s;encrypt=true;"
            + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, us, pass);
             
            //connects and adds date to html tabel, images will not display
            Connection connection = DriverManager.getConnection(url);

            Statement statement = connection.createStatement() ;
            ResultSet resultset = 
                statement.executeQuery("select * from lostpets where userid='"+currentUser.getUsername()+"'") ; 
            
             
        %>
       
        <% while(resultset.next()){ %>
        
        <form id="edit" name="update" action="editlostservlet" method="POST">
                User:
                <input type="text" name="user" value="<%= resultset.getString(1) %>" readonly="readonly" />
                Species:
                <input type="text" name="species" value="<%= resultset.getString(2) %>" />
                Description:
                <input type="text" name="desc" value="<%= resultset.getString(3) %>" />
                Contact:
                <input type="text" name="contact" value="<%= resultset.getString(5) %>" size="30" />
                Status: <%= resultset.getString(6) %>
                <select name="status" >
                        <option>Missing</option>
                        <option>Reunited</option>
                    </select>
                <input type="hidden" name="address" value="<%= resultset.getString(9) %>" />        
                        <input type="submit" value="update" name="update" onClick="Update()" />       
        </form>
                    
         <% } %>
         
         
         
         
         
         
         <script>
function Update() {
    var form = document.getElementById("edit");
          form.submit();
    alert("Your post was updated.");
}
</script>
       
    </body>
</html>
