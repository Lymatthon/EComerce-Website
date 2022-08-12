
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Submitted File</h2>
        <table>
            <tr>
                <td>Description</td>
                <td>${description}</td>
            </tr>
            
        </table>
        <div class="product_image">
            <c:forEach items="${uploadedFiles}" var="image">
                <img width="100"  height="100" src="<c:url value="/image/"/>${image.name}"/>
            </li>
        </c:forEach>
        </div>
    </body>
</html>
