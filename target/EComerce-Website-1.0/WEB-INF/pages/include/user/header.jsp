<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="header">
    <div class="header_overlay"></div>
    <div class="header_content d-flex flex-row align-items-center justify-content-start">
        <div class="logo">
            <a href="#">
                <div class="d-flex flex-row align-items-center justify-content-start">
                    <div><img src="<c:url value="/resources/images/logo_1.png"/>" alt=""></div>
                    <div>Little Closet</div>
                </div>
            </a>	
        </div>
        <div class="hamburger"><i class="fa fa-bars" aria-hidden="true"></i></div>
        <nav class="main_nav">
            <ul class="d-flex flex-row align-items-start justify-content-start">
                <li class="active"><a href="#">Women</a></li>
                <li><a href="#">Men</a></li>
                <li><a href="#">Kids</a></li>
                <li><a href="#">Home Deco</a></li>
                <li><a href="#">Contact</a></li>
            </ul>
        </nav>
        <div class="header_right d-flex flex-row align-items-center justify-content-start ml-auto">
            <!-- Search -->
            <div class="header_search">
                <form action="#" id="header_search_form">
                    <input type="text" class="search_input" placeholder="Search Item" required="required">
                    <button class="header_search_button"><img src="<c:url value="/resources/images/search.png"/>" alt=""></button>
                </form>
            </div>

            <!-- User -->
            <div class="user">
                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sign in/Sign up
                        <span class="caret"></span></button>
                    <ul class="dropdown-menu">
                        <li><a href="/littleshop/login">Sign in</a></li>
                        <li><a href="/littleshop/register">Sign up</a></li>
                    </ul>
                </div>                
            </div>

            <!-- Cart -->
            <div class="cart"><a href="cart.html"><div><img class="svg" src="<c:url value="/resources/images/cart.svg"/>" alt="https://www.flaticon.com/authors/freepik"></div></a></div>
            <!-- Phone -->
            <div class="header_phone d-flex flex-row align-items-center justify-content-start">
                <div><div><img src="<c:url value="/resources/images/phone.svg"/>" alt="https://www.flaticon.com/authors/freepik"></div></div>
                <div>+1 912-252-7350</div>
            </div>
        </div>
    </div>
</header>