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
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css'>
        <link rel="stylesheet" href="welcomepagestyle.css"> 
        <script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
    </head>
    
                  
     <%UserBean currentUser = (UserBean) session.getAttribute("SessionUser");%>
     <h1>Welcome <%= currentUser.getUsername()+"!"%> </h1>
     <form action="editlost.jsp" method="POST">
     My posts:
     <a href="editlost.jsp"><input  type="button" value="Lost Pets" class="" /></a>
      <a href="editfound.jsp"><input  type="button" value="Found Pets" class="" /></a>
       </form>
     
    
     
    

     
     <body>
        <div class="wrapper">
            <div class="container">
                    <div class="title">
                         <h1>Welcome! <%-- <%= currentUser.getUsername() +"!"%>--%> </h1> 
                    </div>
                    
                    <a href="index.jsp"><input type="button" value="Sign Out" class="btn signout-btn" /></a>
             
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form">

                                <!--link to browse lost screen-->
                                <a href="browselost.jsp">
                                    <!--container for browse lost-->
                                    <div class="input-container sign-up a">
                                        <div class="avatar-wrapper">	
                                            <img src="https://s3.amazonaws.com/bucketdrum/SearchLostFound.png" class="avatar"/>
                                        </div>
                                        <h2>Browse Lost</h2>
                                        <p>Search missing pets here!</p>
                                    </div>  
                                </a>

                            </div>
                        </div>
                    
                        <div class="col-md-6">
                            <div class="form">
                                
                                <!--link to post lost screen-->
                                 <a href="postlost.jsp">
                                    <!--container for post lost-->
                                    <div class="input-container sign-up a">
                                        <div class="avatar-wrapper">	
                                            <img src="https://s3.amazonaws.com/bucketdrum/PostLostFound.png" class="avatar"/>
                                        </div>
                                        <h2>Post Lost</h2>
                                        <p>Post missing pets here!</p>
                                    </div>
                                </a>

                            </div>
                        </div>
                    </div>
                    
                <div class ="row">
                    <div class="col-md-6">
                        <div class="form">

                            <a href="browsefound.jsp">
                            <!--container for browse found-->
                            <div class="input-container sign-up a">
                                <div class="avatar-wrapper">	
                                    <img src="https://s3.amazonaws.com/bucketdrum/SearchLostFound.png" class="avatar"/>
                                </div>
                                <h2>Browse Found</h2>
                                <p>Search found pets here!</p>
                            </div>
                            </a>
                        </div>
                    </div>
                    
                    <div class="col-md-6">
                        <div class="form">

                            <a href="postfound.jsp">
                            <!--sign up screen-->
                            <div class="input-container sign-up a">
                                <div class="avatar-wrapper">	
                                    <img src="https://s3.amazonaws.com/bucketdrum/PostLostFound.png" class="avatar"/>
                                </div>
                                <h2>Post Found</h2>
                                <p>Post found pets here!</p>
                            </div>
                            </a>
                       </div>
                    </div>
                </div>
            </div>
        </div>
    </body>    

</html>
