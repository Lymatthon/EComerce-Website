<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Products -->

<div class="products">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 offset-lg-3">
                <div class="section_title text-center">Popular on Little Closet</div>
            </div>
        </div>
        <div class="row page_nav_row">
            <div class="col">
                <div class="page_nav">
                    <ul class="d-flex flex-row align-items-start justify-content-center">
                        <c:forEach var="cate" items="${cates}">
                            <li class="active"><a href="/littleshop/product/category/${cate.categoryId}">${cate.categoryName}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row products_row">
            <c:forEach var="p" items="${productBestSelling}">

            <!-- Product -->
            <div class="col-xl-4 col-md-6">
                <div class="product">
                    <c:forEach var="i" items="${p.images}" begin="0" end="0">
                    <div class="product_image"><img src="<c:url value="/resources/image/${i.imageName}"/>" alt=""></div>
                    </c:forEach>
                    <div class="product_content">
                        <div class="product_info d-flex flex-row align-items-start justify-content-start">
                            <div>
                                <div>
                                    <div class="product_name"><a href="product.html">${p.productName}</a></div>
                                    
                                    <div class="product_category">In <a href="/littleshop/product/category/${p.category.categoryId}"><c:out value="${p.category.categoryName }" /></a></div>
                                    
                                </div>
                            </div>
                            <div class="ml-auto text-right">
                                <div class="rating_r rating_r_4 home_item_rating"><i></i><i></i><i></i><i></i><i></i></div>
                                <div class="product_price text-right">${p.price}</span></div>
                            </div>
                        </div>
                        <div class="product_buttons">
                            <div class="text-right d-flex flex-row align-items-start justify-content-start">
                                <div class="product_button product_fav text-center d-flex flex-column align-items-center justify-content-center">
                                    <div><div><img src="<c:url value="/resources/images/heart_2.svg"/>" class="svg" alt=""><div>+</div></div></div>
                                </div>
                                <div class="product_button product_cart text-center d-flex flex-column align-items-center justify-content-center">
                                    <div><div><img src="<c:url value="/resources/images/cart.svg"/>" class="svg" alt=""><div>+</div></div></div>
                                
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                                    </c:forEach>
                                
        </div>
        <div class="row load_more_row">
            <div class="col">
                <div class="button load_more ml-auto mr-auto"><a href="#">load more</a></div>
            </div>
        </div>
    </div>
</div>