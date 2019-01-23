<%-- 
    Document   : login
    Created on : Jan 22, 2019, 9:57:28 AM
    Author     : Connor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form name="login" action="loginservlet">
            Enter UserID:
            <input type="text" name="userid" value="" />
            Enter Password:
            <input type="password" name="password" value="" />
            
            <input type="submit" value="Login" name="submit" />
        </form>
    </body>
</html>
