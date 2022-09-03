<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Little Closet</title>
        <jsp:include page="/WEB-INF/pages/include/user/css-page-cart.jsp" />
        <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css" />
        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.0/css/bootstrapValidator.min.css" />

        <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css" />

        <style>
            #success_message
            {
                display: none;
            }

        </style>
    </head>

    <body>
        <!-- Top menu --> 
        <jsp:include page="/WEB-INF/pages/include/user/menu.jsp"/>

        <div class="super_container">
            <jsp:include page="/WEB-INF/pages/include/user/header.jsp"/>
            <div class="super_container_inner">
                <div class="super_overlay"></div>

                <!-- Cart -->                                           
                <jsp:include page="/WEB-INF/pages/include/user/user-change-pw.jsp"/>


            </div>
        </div>

        <jsp:include page="/WEB-INF/pages/include/user/js-page-cart.jsp"/>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 
        <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js"></script>
        <script>
            $("#btnLogin").click(function (event) {

                var form = $("#loginForm");

                if (form[0].checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }

                form.addClass('was-validated');
            });
            $(document).ready(function () {
                $("#show_hide_password a").on('click', function (event1) {
                    event1.preventDefault();
                    if ($('#show_hide_password input').attr("type") === "text") {
                        $('#show_hide_password input').attr('type', 'password');
                        $('#show_hide_password i').addClass("fa-eye-slash");
                        $('#show_hide_password i').removeClass("fa-eye");
                    } else if ($('#show_hide_password input').attr("type") === "password") {
                        $('#show_hide_password input').attr('type', 'text');
                        $('#show_hide_password i').removeClass("fa-eye-slash");
                        $('#show_hide_password i').addClass("fa-eye");
                    }
                });
            });
            $(document).ready(function () {
                $("#show_hide_password_2 a").on('click', function (event1) {
                    event1.preventDefault();
                    if ($('#show_hide_password_2 input').attr("type") === "text") {
                        $('#show_hide_password_2 input').attr('type', 'password');
                        $('#show_hide_password_2 i').addClass("fa-eye-slash");
                        $('#show_hide_password_2 i').removeClass("fa-eye");
                    } else if ($('#show_hide_password_2 input').attr("type") === "password") {
                        $('#show_hide_password_2 input').attr('type', 'text');
                        $('#show_hide_password_2 i').removeClass("fa-eye-slash");
                        $('#show_hide_password_2 i').addClass("fa-eye");
                    }
                });
            });
            $(document).ready(function () {
                $("#show_hide_password_1 a").on('click', function (event1) {
                    event1.preventDefault();
                    if ($('#show_hide_password_1 input').attr("type") === "text") {
                        $('#show_hide_password_1 input').attr('type', 'password');
                        $('#show_hide_password_1 i').addClass("fa-eye-slash");
                        $('#show_hide_password_1 i').removeClass("fa-eye");
                    } else if ($('#show_hide_password_1 input').attr("type") === "password") {
                        $('#show_hide_password_1 input').attr('type', 'text');
                        $('#show_hide_password_1 i').removeClass("fa-eye-slash");
                        $('#show_hide_password_1 i').addClass("fa-eye");
                    }
                });
            });
        </script>
    </body>

</html>
