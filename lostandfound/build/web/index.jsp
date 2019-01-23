<%-- 
    Document   : index
    Created on : Jan 21, 2019, 10:43:10 AM
    Author     : Connor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
    </head>
    <body>
        <!--This jsp takes user input and sends to account servlet  -->
        
        <h1>Create Account</h1>
        <form name="User Info" action="accountservlet" method="GET">
            UserID:
            <input type="text" name="userid" value="" />
            Email:
            <input type="text" name="email" value="" />
            Password:
            <input type="password" name="password" value="" />
            Zip:
             <input type="text" name="zipcode" value="" />
            <input type="submit" value="OK" />
            
        </form>
    </body>
</html>
