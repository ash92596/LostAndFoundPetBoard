<%-- 
    Document   : welcome
    Created on : Jan 21, 2019, 1:49:12 PM
    Author     : Connor
--%>
<%@page import ="org.mypackage.login.loginservlet" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.mypackage.login.UserBean" 
        language="java"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lost and Found</title>
    </head>
    
                  
     <%UserBean currentUser = (UserBean) session.getAttribute("SessionUser");%>
     <form action="postlost.jsp" method="POST">
        <h1>Welcome <%= currentUser.getUsername()+"!"%> </h1>
        <input type="submit" value="post" name="post" />
     </form>    
    
</html>
