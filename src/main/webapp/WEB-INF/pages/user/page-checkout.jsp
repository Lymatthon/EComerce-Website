<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Little Closet</title>
        <jsp:include page="/include/user/css-page.jsp" />
    </head>

    <body>
        <!-- Top menu --> 
        <jsp:include page="/include/user/menu.jsp"/>

        <div class="super_container">
            <jsp:include page="include/user/header.jsp"/>
            <div class="super_container_inner">
                <div class="super_overlay"></div>
                                
                <!-- Products -->                                           
                <jsp:include page="include/user/checkout.jsp"/>

                <!-- Footer --> 
                <jsp:include page="include/user/footer-page.jsp"/>
            </div>
        </div>

        <jsp:include page="include/user/js-page.jsp"/>
    </body>

</html>
