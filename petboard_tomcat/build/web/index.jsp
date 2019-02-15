<%-- 
    Document   : index
    Created on : Jan 21, 2019, 10:43:10 AM
    Author     : Connor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up Form</title>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css'>
        <link rel="stylesheet" href="indexstyle.css"> 
        <script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
        <script  src="index.js"></script>
    </head>

    <body>
        <div class="wrapper">
            <div class="container">
                <div class="row">
                    <div class="title">
                        <h1>Lost and Found Pet Board</h1>
                    </div>

                    <div class="col-md-6 col-md-offset-3">
                        <div class="form">

                            <!--sign up screen-->
                            <div class="input-container sign-up">
                                <div class="avatar-wrapper">	
                                    <img src="https://s3.amazonaws.com/bucketdrum/Facebook_UI-07-512.png" class="avatar"/>
                                </div>
                                <h2>sign up</h2>
                                <p>Its free and only takes a minute!</p>
                                <form name="User Info" action="accountservlet" method="GET">
                                    <input type="text" placeholder="User ID" name="userid" value="" pattern=".{1,10}" title="Maximum 10 characters" required/>
                                    <input type="text" placeholder="Email" name="email" value="" required/>
                                    <input type="password" placeholder="Password" name="password" pattern="(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-zA-Z]).{8,}" title="8 or more characters with at least one special character, letter, and number" value="" required/>
                                    <input type="text" placeholder="Zip Code" name="zipcode" value="" required/>
                                    <button class="btn submit-btn" value="OK" type="submit" onclick="onSubmitBtnClick()">SUBMIT</button>
                                </form>
                            </div>

                            <!--login screen-->
                            <div class="input-container login">
                                <div class="avatar-wrapper">	
                                    <img src="https://s3.amazonaws.com/bucketdrum/Facebook_UI-07-512.png" class="avatar"/>
                                </div>
                                <h2>login</h2>
                                <p>Welcome back!</p>
                                <form name="login" action="loginservlet">
                                    <input type="text" placeholder="User ID" name="userid" value="" required/>
                                    <input type="password" placeholder="Password" name="password" value="" required/>
                                    <button class="btn submit-btn" type="submit" onclick="onSubmitBtnClick()">SUBMIT</button>
                                </form>
                            </div>

                            <!--login and sign up buttons-->
                            <div class="button-group">
                                <button class="btn login-btn" type="submit" onclick="onLoginBtnClick()">LOGIN</button>
                                <button class="btn signup-btn" type="submit" onclick="onSignupBtnClick()">SIGN UP</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>
