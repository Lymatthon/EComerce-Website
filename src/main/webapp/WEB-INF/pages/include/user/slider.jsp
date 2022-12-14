<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="home">
    <!-- Home Slider -->
    <div class="home_slider_container">
        <div class="owl-carousel owl-theme home_slider">

            <!-- Slide -->
            <c:forEach var="p" items="${listNewestProduct}">
                <div class="owl-item">
                    <div class="background_image" style="background-image:url(<c:url value="/resources/images/home.jpg"/>)"></div>
                    <div class="container fill_height">
                        <div class="row fill_height">
                            <div class="col fill_height">
                                <div class="home_container d-flex flex-column align-items-center justify-content-start">
                                    <div class="home_content">
                                        <div class="home_title">New Arrivals</div>
                                        <div class="home_subtitle">Summer Wear</div>
                                        <div class="home_items">
                                            <div class="row">
                                                <div class="col-sm-3 offset-lg-1">
                                                    <c:forEach var="image" items="${p.images}" begin="0" end="0">
                                                    <div class="home_item_side"><a href="/littleshop/product/details/${p.productId}"><img src="<c:url value="/resources/image/"/>${image.imageName}" alt=""></a></div>
                                                    </c:forEach>
                                                </div>
                                                <div class="col-lg-4 col-md-6 col-sm-8 offset-sm-2 offset-md-0">
                                                    <div class="product home_item_large">
                                                        <div class="product_tag d-flex flex-column align-items-center justify-content-center">
                                                            <div>
                                                                <div>from</div>
                                                                <div>$ <c:out value="${minPrice}"/></div>
                                                            </div>
                                                        </div>
                                                        <div class="product_image"><img src="<c:url value="/resources/images/home_2.jpg"/>" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_info d-flex flex-row align-items-start justify-content-start">
                                                                <div>
                                                                    <div>
                                                                        <div class="product_name"><a href="/littleshop/product/details/${p.productId}">${p.productName}</a></div>
                                                                        <div class="product_category">In <a href="/littleshop/product/category/${p.category.categoryId}"><c:out value="${p.category.categoryName}" /></a></div>
                                                                    </div>
                                                                </div>
                                                                <div class="ml-auto text-right">
                                                                    <div class="rating_r rating_r_4 home_item_rating"><i></i><i></i><i></i><i></i><i></i></div>
                                                                    <div class="product_price text-right">$${p.price}</span></div>
                                                                </div>
                                                            </div>
                                                            <div class="product_buttons">
                                                                <div class="text-right d-flex flex-row align-items-start justify-content-start">
                                                                    <div class="product_button product_fav text-center d-flex flex-column align-items-center justify-content-center">
                                                                        <div><div><img src="<c:url value="/resources/images/heart.svg"/>" alt=""><div>+</div></div></div>
                                                                    </div>
                                                                    <div class="product_button product_cart text-center d-flex flex-column align-items-center justify-content-center">
                                                                        <div><div><img src="<c:url value="/resources/images/cart_2.svg"/>" alt=""><div>+</div></div></div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-sm-3">
                                                    <div class="home_item_side"><a href="product.html"><img src="<c:url value="/resources/images/home_3.jpg"/>" alt=""></a></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>	
                </div>


            </c:forEach>
        </div>
        <div class="home_slider_nav home_slider_nav_prev"><i class="fa fa-chevron-left" aria-hidden="true"></i></div>
        <div class="home_slider_nav home_slider_nav_next"><i class="fa fa-chevron-right" aria-hidden="true"></i></div>

        <!-- Home Slider Dots -->

        <div class="home_slider_dots_container">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <div class="home_slider_dots">
                            <ul id="home_slider_custom_dots" class="home_slider_custom_dots d-flex flex-row align-items-center justify-content-center">
                                <li class="home_slider_custom_dot active">01</li>
                                <li class="home_slider_custom_dot">02</li>
                                <li class="home_slider_custom_dot">03</li>
                                <li class="home_slider_custom_dot">04</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>	
        </div>

    </div>
</div>
