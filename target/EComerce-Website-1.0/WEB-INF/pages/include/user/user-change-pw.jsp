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
                                    <c:when test="${message == 'Error!'}">
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
                                            <input type="password" class="form-control" name="oldPw" id="inputPasswordOld" required="">
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPasswordNew">New Password</label>
                                            <input type="password" class="form-control" name="newPw" id="inputPasswordNew" required="">
                                            <span class="form-text small text-muted">
                                                The password must be 8-20 characters, and must <em>not</em> contain spaces.
                                            </span>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPasswordNewVerify">Verify</label>
                                            <input type="password" class="form-control" name="verifyPw" id="inputPasswordNewVerify" required="">
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
                            <!-- /form card change password -->

                        </div>

                    </div>
                    <!--/row-->

                    <br><br><br><br>

                </div>
                <!--/col-->
            </div>
            <!--/row-->


        </div>
        <!--/container-->
    </body>
</html>
