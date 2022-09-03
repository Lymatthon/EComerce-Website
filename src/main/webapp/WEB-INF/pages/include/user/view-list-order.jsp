<%-- 
    Document   : view-list-order
    Created on : Sep 1, 2022, 12:27:06 AM
    Author     : TriLX
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="home_cart">
    <div class="home_container d-flex flex-column align-items-center justify-content-end">
        <div class="home_content text-center">
            <div class="home_title">My Purchase</div>
            <div class="breadcrumbs d-flex flex-column align-items-center justify-content-center">
                <ul class="d-flex flex-row align-items-start justify-content-start text-center">

                </ul>
            </div>
        </div>
    </div>
</div>
<br><!-- comment -->
<br><!-- comment -->
<c:choose>
    <c:when test="${empty orders || orders == null}">
        <h4 class="text-danger text-center">Your don't have any order yet!</h4>
    </c:when>
    <c:otherwise>

        <div class="container">

            <c:forEach items="${orders}" var="order">
                <div class="row" style="background-color: #D6D6D6; margin-bottom: 20px; padding: 10px">
                    <div >
                        <span style="display: inline; color: black"><h3>Order ID: ${order.orderId} <h4 style="margin-left: 1020px; color: darkred; font-style: italic">${order.status}</h4></h3></span>
                    </div>
                    <table class="table" style="color: black; font-size: 18px">
                        <thead>
                            <tr>
                                <th scope="col">Product Name</th>                        
                                <th scope="col">Size</th>      
                                <th scope="col">Color</th>
                                <th scope="col">Quantity</th>
                                <th scope="col">Price</th>    
                            </tr>
                        </thead>
                        <tbody>
                            <c:set value="${order.orderDetails}" var="oDetails"/>
                            <c:forEach var="o" items="${oDetails}">
                                <tr>
                                    <td><a style="text-decoration: none" href="/littleshop/product/details/${o.product.productId}">${o.product.productName}</a></td>
                                    <td>${o.size}</td>
                                    <td>${o.color}</td>
                                    <td>${o.quantity}</td>
                                    <td>${o.price}</td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                    <div style="margin-left: 820px; color: #FF6347">
                        <span style="alignment-adjust: middle"></span>
                        <h3>Total amount: $ ${order.amount} </h3>
                    </div>
                </div>
            </c:forEach>   

        </div>


    </c:otherwise>
</c:choose>