<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Login Page</title>
        <!-- Main css Login-->
        <link rel="stylesheet" href="<c:url value="/resources/login/bootstrap.min.css"/>">
    </head>
    <body>
        <br/><!-- comment -->
        <br/>
        <br/>
        <div class="cont">
            <div class="form sign-in">
                <h2>Welcome back,</h2>
                <label>
                    <span>Email</span>
                    <input type="email" />
                </label>
                <label>
                    <span>Password</span>
                    <input type="password" />
                </label>
                <p class="forgot-pass">Forgot password?</p>
                <button type="button" class="submit">Sign In</button>
                <button type="button" class="fb-btn">Connect with <span>facebook</span></button>
            </div>
            <div class="sub-cont">
                <div class="img">
                    <br/><!-- comment -->
                    <br/><!-- comment -->
                    <br/><!-- comment -->
                    <div class="img__text m--up">
                        <h2>New here?</h2>
                        <p>Sign up and discover great amount of new opportunities!</p>
                        <br/><!-- comment -->
                        <br/><!-- comment -->
                        <!--                        <button type="button" class="submit">
                                                    <a href="/littleshop/register" class="loginhere-link">Sign Up</a>
                                                </button>-->

                        <a class="sign-in" tyle="text-decoration: none" href="/littleshop/register">Sign Up</a>
                    </div>                 

                </div>

            </div>




            <!-- JS -->
            <script src="<c:url value="/resources/login/bootstrap.bundle.min.js"/>"></script>
    </body>
</html>
