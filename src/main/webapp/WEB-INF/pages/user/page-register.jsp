<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register Page</title>

<!-- Font Register -->
<link rel="stylesheet" href="<c:url value="/resources/register/fonts/material-icon/css/material-design-iconic-font.min.css" />"> 

<!-- Main css Register-->
<link rel="stylesheet" href="<c:url value="/resources/register/css/style.css"/>">
</head>
<body>

    <div class="main">

        <section class="signup">
            <!-- <img src="images/signup-bg.jpg" alt=""> -->
            <div class="container">
                <div class="signup-content">
                    <c:url value="/register" var="action"/>
                    
                    <form:form method="POST" action="${action}" modelAttribute="user" id="signup-form" class="signup-form">
                        <h2 class="form-title">Create account</h2>
                        <div class="form-group">
                            <form:input class="form-input" path="customerName" id="name" placeholder="Name"/>
                        </div>
                        <div class="form-group">
                            <form:input  class="form-input" path="email" id="email" placeholder="Email"/>
                        </div>
                        <div class="form-group">
                            <form:input  class="form-input" path="address" id="address" placeholder="Address"/>
                        </div>
                        <div class="form-group">
                            <form:input  class="form-input" path="phone" id="phone" placeholder="Phone Number"/>
                        </div>
                        <div class="form-group">                            
                            <form:radiobuttons class="form-input" path="gender" id="gender" items="${genderMap}"/>                                                        
                        </div>
                        <div class="form-group">
                            <form:input class="form-input" path="password" id="password" placeholder="Password"/>
                            <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                        </div>
                        <div class="form-group">
                            <form:input class="form-input" path="confirmPassword" id="confirmPassword" placeholder="Repeat your password"/>
                        </div>
                        <div class="form-group">
                            <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                            <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                        </div>
                        <div class="form-group">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="Sign up"/>
                        </div>
                    </form:form>
                    <p class="loginhere">
                        Have already an account ? <a href="/littleshop/login" class="loginhere-link">Login here</a>
                    </p>
                </div>
            </div>
        </section>

    </div>

    <!-- JS -->
    <script src="<c:url value="/resources/register/vendor/jquery/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/register/js/main.js"/>"></script>
</body>
</html>
