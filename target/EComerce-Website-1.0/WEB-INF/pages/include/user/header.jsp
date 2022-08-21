<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://www.springframework.org/security/tags" 
           prefix="sec" %>
<header class="header">
    <div class="header_overlay"></div>
    <div class="header_content d-flex flex-row align-items-center justify-content-start">
        <div class="logo">
            <a href="/littleshop/home">
                <div class="d-flex flex-row align-items-center justify-content-start">
                    <div><img src="<c:url value="/resources/images/logo_1.png"/>" alt=""></div>
                    <div>Little Closet</div>
                </div>
            </a>	
        </div>
        <nav class="main_nav">
            <ul class="d-flex flex-row align-items-start justify-content-start">
                <c:forEach var="cate" items="${cates}">                

                    <li class="active"><a href="/littleshop/product/category/${cate.categoryId}">${cate.categoryName}</a></li>
                    </c:forEach>
                <li class="active"><a href="/littleshop/product/best-selling">Best-Selling</a></li>
            </ul>
        </nav>
        <!-- Search -->
        <div class="header_search">
            <form:form action="/littleshop/search" id="header_search_form" method="Get">
                <input type="text" name="keyword" value="${param.keyword}" class="search_input" placeholder="Search Item" required="required">
                <button class="header_search_button"><img sr="<c:url value="/resources/images/search.png"/>" alt=""></button>
                </form:form>
        </div>
        <div class="header_right d-flex flex-row align-items-center justify-content-start ml-auto">


            <!-- User -->


            <div class="btn-group header_phone d-flex flex-row align-items-center justify-content-start cart">
                <sec:authorize access="isAuthenticated()">
                    <button type="button" class="btn btn-primary btn-success" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${pageContext.request.userPrincipal.name}</button>
                    <div class="dropdown-menu" style="padding-left: 0">                    
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <a class="dropdown-item" href="<c:url value="/admin/home" />">Admin Manage</a>
                        </sec:authorize>
                        <a class="dropdown-item"  href="<c:url value="#" />">My Account</a>
                        <a class="dropdown-item" href="<c:url value="/logout" />">Logout</a>                       
                    </sec:authorize>
                </div>
            </div>  
            <sec:authorize access="!isAuthenticated()"> 
                <div class="header_phone d-flex flex-row align-items-center justify-content-start">
                    <nav class="align-items-center main_nav">
                        <ul class="nav">                    
                            <li class="nav-item">
                                <a class="active" href="<c:url value="/login" />">Sign in</a>
                            </li>
                            <li class="nav-item">                        
                                <a class="active" href="<c:url value="/register" />">Sign up</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </sec:authorize>


            <!-- Cart -->
            <div class="cart">
                <div></div>
                <a href="/littleshop/cart" class="text-success iconClass">
                    <div>
                        <i class="svg fa fa-3x fa-shopping-cart"></i>
                        <span class="badge badge-danger rounded-circle badge-pill" id="cartCounter">${cartCounter}</span> 
                    </div>
                </a>
            </div>
            <!-- Phone -->
            <div class="header_phone d-flex flex-row align-items-center justify-content-start">
                <div><div><img src="<c:url value="/resources/images/phone.svg"/>" alt="https://www.flaticon.com/authors/freepik"></div></div>

            </div>            
        </div>
    </div>
</header>