<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Home -->

<div class="home">
    <div class="home_container d-flex flex-column align-items-center justify-content-end">
        <div class="home_content text-center">
            <div class="home_title">Product Details</div>

        </div>
    </div>
</div>

<!-- Product -->

<div class="product">
    <div class="container">
        <div class="row">

            <!-- Product Image -->
            <div class="col-lg-6">
                <div class="product_image_slider_container">
                    <div id="slider" class="flexslider">
                        <ul class="slides"> 
                            <c:forEach var="i" items="${product.images}" begin="0" end="0">
                                <li>
                                    <img src="<c:url value="/resources/image/${i.imageName}"/>" alt="" />

                                </li>
                            </c:forEach>

                        </ul>
                    </div>
                    <div class="carousel_container">
                        <div id="carousel" class="flexslider">
                            <ul class="slides">
                                <c:forEach var="i" items="${product.images}" begin="1">
                                    <li>
                                        <div><img src="<c:url value="/resources/image/${i.imageName}"/>" alt="" /></div>
                                    </li>
                                </c:forEach>

                            </ul>
                        </div>
                        <div class="fs_prev fs_nav disabled"><i class="fa fa-chevron-up" aria-hidden="true"></i></div>
                        <div class="fs_next fs_nav"><i class="fa fa-chevron-down" aria-hidden="true"></i></div>
                    </div>
                </div>
            </div>

            <!-- Product Info -->
            <div class="col-lg-6 product_col">
                <div class="product_info">
                    <div class="product_name"><c:out value="${product.productName}" /></div>
                    <div class="product_category">In <a href="/littleshop/product/category/${product.category.categoryId}"><c:out value="${product.category.categoryName}" /></a></div>
                    <div class="product_rating_container d-flex flex-row align-items-center justify-content-start">
                        <div class="rating_r rating_r_4 product_rating"><i></i><i></i><i></i><i></i><i></i></div>
                        <div class="product_reviews">4.7 out of (3514)</div>
                        <div class="product_reviews_link"><a href="#">Reviews</a></div>
                    </div>
                    <div class="product_price">$<c:out value="${product.price}" /></div>
                    <div class="product_size">
                        <div class="product_size_title">Select Size</div>
                        <ul class="d-flex flex-row align-items-start justify-content-start">
                            <c:forEach var="pDetails" items="${listProductDetails}">
                                <li>
                                    <input type="radio" id="radio_${pDetails.size.size}" name="product_radio" class="regular_radio radio_1">
                                    <label for="radio_${pDetails.size.size}"><c:out value="${pDetails.size.size}" /></label>
                                </li>  
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="product_color">
                        <div class="product_color_title">Select Color</div>
                        <ul class="d-flex flex-row align-items-start justify-content-start">
                            <c:forEach var="pDetails" items="${listProductDetails}">
                                <li>
                                    <input type="radio" id="radio_${pDetails.color.color}" name="product_radio" class="regular_radio radio_1">
                                    <label for="radio_${pDetails.color.color}"><c:out value="${pDetails.color.color}" /></label>
                                </li>  
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="product_color">
                        <div class="product_color_title">Select Quantity</div>
                        <br/>

                        <input value="1" type="number" min="1" class="text-center form-control"
                               onblur="updateCart(this, ${c.productId})"/>

                    </div>
                    <div class="product_text">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque nec consequat lorem. Maecenas elementum at diam consequat bibendum. Mauris iaculis fringilla ex, sit amet semper libero facilisis sit amet. Nunc ut aliquet metus. Praesent pulvinar justo sed velit tempus bibendum. Quisque dictum lorem id mi viverra, in auctor justo laoreet. Nam at massa malesuada, ullamcorper metus vel, consequat risus. Phasellus ultricies velit vel accumsan porta.</p>
                    </div>
                    <div class="product_buttons">
                        <div class="text-right d-flex flex-row align-items-start justify-content-start">
                            <div class="product_button product_fav text-center d-flex flex-column align-items-center justify-content-center">
                                <div><div><img src="<c:url value="/resources/images/heart_2.svg" />" class="svg" alt=""/><div>+</div></div></div>
                            </div>
                            <div class="product_button product_cart text-center d-flex flex-column align-items-center justify-content-center">
                                <div><div><a href="#" onclick="addToCart(${product.productId}, `${product.productName}`,${product.price})"><img src="<c:url value="/resources/images/cart.svg" />" class="svg" alt=""></a><div>+</div></div></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

