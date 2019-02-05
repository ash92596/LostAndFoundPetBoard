<%-- 
    Document   : welcome
    Created on : Jan 21, 2019, 1:49:12 PM
    Author     : Connor
--%>
<%@page import ="org.mypackage.login.loginservlet" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.mypackage.login.UserBean" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lost and Found</title>
    </head>
    
                  
     <%UserBean currentUser = (UserBean) session.getAttribute("SessionUser");
    
     
     %>
        <h1>Welcome <%= currentUser.getUsername()+" "+currentUser.getZipcode() %> </h1>
         
    
</html>
