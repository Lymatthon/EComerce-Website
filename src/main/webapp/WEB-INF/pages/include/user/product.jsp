<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Home -->

<div class="home_category">
    <div class="home_container d-flex flex-column align-items-center justify-content-end">
        <div class="home_content text-center">
            <div class="home_title">Product Details</div>
            <div class="breadcrumbs d-flex flex-column align-items-center justify-content-center">
                <ul class="d-flex flex-row align-items-start justify-content-start text-center">
                    <c:forEach var="cate" items="${cates}">
                        <li class="active"><a href="/littleshop/product/category/${cate.categoryId}">${cate.categoryName}</a></li>
                        </c:forEach>
                </ul>
            </div>
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
                    <c:if test="${product.images.size() > 1}" >
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
                    </c:if>
                </div>
            </div>

            <!-- Product Info -->
            <div class="col-lg-6 product_col">
                <div class="product_info" style="padding-top: 0px">
                    <div class="product_name_details" style="margin-right: 0px"><c:out value="${product.productName}" /></div>
                    <div class="product_category_button">In <a href="/littleshop/product/category/${product.category.categoryId}"><c:out value="${product.category.categoryName}" /></a></div>
                    <div class="product_rating_container d-flex flex-row align-items-center justify-content-start">
                        <div class="rating_r rating_r_4 product_rating"><i></i><i></i><i></i><i></i><i></i></div>
                        <div class="product_reviews">4.7 out of (3514)</div>
                        <div class="product_reviews_link"><a href="#">Reviews</a></div>
                    </div>
                    <div class="product_color" style="padding-top: 0px">
                        <div class="product_color_title">Select Color</div>
                        <ul class="d-flex flex-row align-items-start justify-content-start">
                            <c:forEach var="color" items="${uniqueColor}">
                                <li>
                                    <input onclick="updateColorCart(this, ${c.productId})" type="radio" id="radio_${color}" name="product_radio1" class="regular_radio radio_1" >
                                    <label id="colorLabel" for="radio_${color}">${color}</label>
                                </li>  
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="product_size" style="padding-top: 0px">
                        <div class="product_size_title">Select Size</div>
                        <ul class="d-flex flex-row align-items-start justify-content-start">
                            <c:forEach var="size" items="${uniqueSize}">
                                <li>
                                    <input onclick="updateSizeCart(this, ${c.productId})" type="radio" id="radio_${size}" name="product_radio2" class="regular_radio radio_2">
                                    <label id="sizeLabel" for="radio_${size}">${size}</label>
                                </li>  
                            </c:forEach>
                        </ul>
                    </div>                    
                    <div class="product_color" style="padding-top: 0px">
                        <div class="product_color_title">Select Quantity</div>
                        <br/>
                        <div class="d-flex flex-row align-items-start justify-content-start input-group" style="width: 150px">
                            <span class="input-group-prepend">
                                <button type="button" class="btn btn-outline-secondary btn-number number_input_button" disabled="disabled" data-type="minus" data-field="quant[1]">
                                    <span class="fa fa-minus"></span>
                                </button>
                            </span>
                            <input id="quantityUpdate" onblur="updateQuantityCart(this, ${c.productId})" type="text" name="quant[1]" style="color: green" class="form-control input-number number_input_button" value="1" min="1" max="2000">
                            <span class="input-group-append">
                                <button type="button" class="btn btn-outline-secondary btn-number number_input_button" data-type="plus" data-field="quant[1]">
                                    <span class="fa fa-plus"></span>
                                </button>
                            </span>
                        </div>
                    </div>

                    <br/>
                    <div class="product_price" style="color: coral"><span>$ </span><c:out value="${product.price}" /></div>
                    <div class="product_buttons">
                        <div class="text-right d-flex flex-row align-items-start justify-content-start">
                            <div class="product_button product_fav text-center d-flex flex-column align-items-center justify-content-center">
                                <div><div><img src="<c:url value="/resources/images/heart_2.svg" />" class="svg" alt=""/><div>+</div></div></div>
                            </div>
                            <div class="product_button product_cart text-center d-flex flex-column align-items-center justify-content-center">
                                <div><div><a href="#" onclick="addToCartFull(${product.productId}, `${product.productName}`,${product.price})"><img src="<c:url value="/resources/images/cart.svg" />" class="svg" alt=""></a><div>+</div></div></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <br><!-- comment -->
        <div class="row">
            <div class="col-lg-12">
                <div class="product_color_title" style="width: 400px">Product Description</div>            
                <div class="product_text text_description" style="text-align: left; margin-top: 10px">
                    <p style="text-align: left" class="text_description">${product.description}</p>
                </div>            
            </div>
        </div>

    </div>
</div>

