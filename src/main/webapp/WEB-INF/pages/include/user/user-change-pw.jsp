<%-- 
    Document   : user-change-pw
    Created on : Aug 31, 2022, 10:47:01 PM
    Author     : TriLX
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .container_input{
                display: flex;
                flex-direction: row;
                justify-content: flex-end;
                align-items: center;
                background: white;
            }
        </style>

    </head>
    <body>
        <div class="container py-5">
            <div class="row">
                <div class="col-md-12">

                    <hr class="mb-5">
                    <div class="row">
                        <div class="col-md-6 offset-md-3">
                            <span class="anchor" id="formChangePassword"></span>
                            <hr class="mb-5">

                            <!-- form card change password -->
                            <div class="card card-outline-secondary">
                                <div class="card-header">
                                    <h3 class="mb-0">Change Password</h3>
                                </div>
                                <c:choose>
                                    <c:when test="${flag == false}">
                                        <div style="text-align: center">
                                            <p style="text-decoration: firebrick; color: red">${message}</p>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div style="text-align: center">
                                            <p style="text-decoration: firebrick; color: green">${message}</p>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                                <div class="card-body">
                                    <form class="form" action="/littleshop/user/changePassword" method="post" role="form" autocomplete="off">
                                        <div class="form-group">
                                            <label for="inputPasswordOld">Current Password</label>
                                            <div class="input-group" id="show_hide_password">
                                                <input type="password" class="form-control" name="oldPw" id="inputPasswordOld" required="true">
                                                <div class="input-group-addon">
                                                    <a href=""><i class="fa fa-eye-slash" id="btn" aria-hidden="true"></i></a>

                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPasswordNew">New Password</label>
                                            <div class="input-group" id="show_hide_password_1">
                                                <input type="password" class="form-control" name="newPw" id="inputPasswordNew" required="true"> 
                                                <div class="input-group-addon">
                                                    <a href=""><i class="fa fa-eye-slash" id="btn" aria-hidden="true"></i></a>

                                                </div>
                                            </div>
                                            <span class="form-text small text-muted">
                                                The password must be 8-20 characters, and must <em>not</em> contain spaces.
                                            </span>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPasswordNewVerify">Verify</label>
                                            <div class="input-group" id="show_hide_password_2">
                                                <input type="password" class="form-control" name="verifyPw" id="inputPasswordNewVerify" required="true">
                                                <div class="input-group-addon">
                                                    <a href=""><i class="fa fa-eye-slash" id="btn" aria-hidden="true"></i></a>

                                                </div>
                                            </div>
                                            <span class="form-text small text-muted">
                                                To confirm, type the new password again.
                                            </span>
                                        </div>
                                        <div class="form-group">
                                            <button type="submit" class="btn btn-success btn-lg float-right">Save</button>
                                            <button type="button" class="btn btn-info btn-lg float-right"><a style="text-decoration: none; color: white" href="/littleshop/user/viewprofile">Cancel</a></button>
                                        </div>
                                    </form>

                                </div>
                            </div>

                        </div>
                        <br><br><br><br>

                    </div>
                </div> 

            </div>
    </body>
</html>
