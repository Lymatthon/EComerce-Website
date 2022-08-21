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
        <!-- Main css Login-->
        <link rel="stylesheet" href="<c:url value="/resources/login/bootstrap.min.css"/>">
    </head>
    <body>
        <br/>
        <br/>
        <br/>

        <div class="cont">

            <form action="/littleshop/j_spring_security_check" method="post" >
                <div class="form sign-in">
                    <h2>Welcome back,</h2>
                    <c:if test="${param.error != null}">
                        <div class="alert alert-danger">
                            <p>Error!</p>
                        </div>
                    </c:if>

                    <label for="username">
                        <span>Email</span>
                        <input name="username" id="username" type="email" />
                    </label>
                    <label for="password">
                        <span>Password</span>
                        <input name="password" id="password" type="password" />
                    </label>
                    <!--                    <p class="forgot-pass">Forgot password?</p>-->
                    <button type="submit" class="submit">Sign In</button>
                    <!--                    <button type="button" class="fb-btn">Connect with <span>facebook</span></button>-->
                </div>
            </form>
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
                        <a class="sign-in" tyle="text-decoration: none" href="/littleshop/register">Sign Up</a>
                    </div>                 

                </div>

            </div>
        </div>

        <script src="<c:url value="/resources/login/bootstrap.bundle.min.js"/>"></script>
    </body>
</html>
