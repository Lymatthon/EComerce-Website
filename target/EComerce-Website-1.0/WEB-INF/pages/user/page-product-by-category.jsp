<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Little Closet</title>
        <jsp:include page="/WEB-INF/pages/include/user/css-page-category.jsp" />
    </head>

    <body>
        <!-- Top menu --> 
        <jsp:include page="/WEB-INF/pages/include/user/menu.jsp"/>

        <div class="super_container">
            <jsp:include page="/WEB-INF/pages/include/user/header.jsp"/>
            <div class="super_container_inner">
                <div class="super_overlay"></div>

                <!-- Products -->                                           
                <jsp:include page="/WEB-INF/pages/include/user/product-list-by-category.jsp"/>

                <!-- Footer --> 
                <jsp:include page="/WEB-INF/pages/include/user/footer-page.jsp"/>
            </div>
        </div>

        <jsp:include page="/WEB-INF/pages/include/user/js-page.jsp"/>
    </body>

</html>
