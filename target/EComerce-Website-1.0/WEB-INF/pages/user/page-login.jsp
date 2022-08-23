<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Login Page</title>

        <!-- Font Register -->
        <link rel="stylesheet" href="<c:url value="/resources/register/fonts/material-icon/css/material-design-iconic-font.min.css" />"> 

        <!-- Main css Register-->
        <link rel="stylesheet" href="<c:url value="/resources/register/css/style.css"/>">
    </head>
    <body>
        <br/>
        <br/>
        <br/>
       
        
        <div class="main">
            
            <div class="signup">   
                <form action="/littleshop/j_spring_security_check" method="post" >
                <div class="container">
                    <h2>Welcome back!</h2>
                    <c:if test="${param.error != null}">
                        <div style="text-align: center">
                            <p style="text-decoration: firebrick; color: red">Error!</p>
                        </div>
                    </c:if>
                    <div class="signup-content">
                                                
                            <div class="form-group">
                                <input  class="form-input" id="username" name="username" placeholder="Email"/>
                            </div>
                            
                            <div class="form-group">
                                <input class="form-input" name="password" id="password" placeholder="Password"/>
                                <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                            </div>
                            
                            <div class="form-group">
                                <button type="submit" class="form-submit">Sign up</button>
                            </div>
                        
                        <div>
                        <p class="loginhere">
                            New here? <span></span> <a href="/littleshop/register" class="loginhere-link">Register</a>
                        </p>
                        </div>
                    </div>
                </div>
                    </form>
            </div>
                
        </div>
        <!-- JS -->
        <script src="<c:url value="/resources/register/vendor/jquery/jquery.min.js"/>"></script>
        <script src="<c:url value="/resources/register/js/main.js"/>"></script>
    </body>
</html>
