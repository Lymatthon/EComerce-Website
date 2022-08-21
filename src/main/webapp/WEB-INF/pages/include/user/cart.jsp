<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Home -->

<div class="home">
    <div class="home_container d-flex flex-column align-items-center justify-content-end">
        <div class="home_content text-center">
            <div class="home_title">Shopping Cart</div>
            <div class="breadcrumbs d-flex flex-column align-items-center justify-content-center">
                <ul class="d-flex flex-row align-items-start justify-content-start text-center">

                </ul>
            </div>
        </div>
    </div>
</div>
<!-- Cart -->
<br/>
<br/><!-- comment -->
<c:if test="${carts == null}" >
    <h4 class="text-danger text-center">Khong co san pham nao trong gio hang!</h4>
</c:if>
<br/>

<c:if test="${carts != null}" >
    <div class="cart_section">
        <div class="container">
            <div class="row">
                <div class="col">
                    <div class="cart_container">

                        <!-- Cart Bar -->
                        <div class="cart_bar">
                            <ul class="cart_bar_list item_list d-flex flex-row align-items-center justify-content-end">
                                <li class="mr-auto">Product</li>
                                <li>Price</li>
                                <li>Quantity</li>
<!--                                <li>Total</li>-->
                                <li></li>
                            </ul>
                        </div>

                        <!-- Cart Items -->
                        <c:forEach items="${carts}" var="c">
                            <div class="cart_items">
                                <ul class="cart_items_list">

                                    <!-- Cart Item -->
                                    <li class="cart_item item_list d-flex flex-lg-row flex-column align-items-lg-center align-items-start justify-content-lg-end justify-content-start">
                                        <div class="product d-flex flex-lg-row flex-column align-items-lg-center align-items-start justify-content-start mr-auto">
                                            <div><div class="product_image"><img src="images/cart_item_1.jpg" alt=""></div></div>
                                            <div class="product_name_container">
                                                <div class="product_name"><a href="/littleshop/product/details/${c.productId}">${c.productName}</a></div>
                                            </div>
                                        </div>
                                        <div class="product_price product_text"><span>Price: </span>$${c.price}</div>
                                        <div class="product_quantity_container">
                                            <input value="${c.quantity}" type="number" min="1" class="product_quantity ml-lg-auto mr-lg-auto text-center"
                                                   onblur="updateCart(this, ${c.productId})"/>
                                        </div>
<!--                                        <div class="product_total product_text"><span>Total: </span>$3.99</div>-->
                                        <div class="product_quantity_container">
                                            <input class="btn btn-danger" type="button" value="Delete" onclick="deleteCart(${c.productId})" />
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </c:forEach>




                        <!-- Cart Buttons -->
                        <div class="cart_buttons d-flex flex-row align-items-start justify-content-start">
                            <div class="cart_buttons_inner ml-sm-auto d-flex flex-row align-items-start justify-content-start flex-wrap">
                                <div class="button button_clear trans_200"><a href="categories.html">clear cart</a></div>
                                <div class="button button_continue trans_200"><a href="/littleshop/home">continue shopping</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row cart_extra_row">
                <div class="col-lg-6">
                    <div class="cart_extra cart_extra_1">
                        <div class="cart_extra_content cart_extra_coupon">
                            <div class="cart_extra_title">Coupon code</div>
                            <div class="coupon_form_container">
                                <form action="#" id="coupon_form" class="coupon_form">
                                    <input type="text" class="coupon_input" required="required">
                                    <button class="coupon_button">apply</button>
                                </form>
                            </div>
                            <div class="coupon_text">Phasellus sit amet nunc eros. Sed nec congue tellus. Aenean nulla nisl, volutpat blandit lorem ut.</div>

                        </div>
                    </div>
                </div>
                <div class="col-lg-6 cart_extra_col">
                    <div class="cart_extra cart_extra_2">
                        <div class="cart_extra_content cart_extra_total">
                            <div class="cart_extra_title">Cart Total</div>
                            <ul class="cart_extra_total_list">
                                <li class="d-flex flex-row align-items-center justify-content-start">
                                    <div class="cart_extra_total_title">Subtotal</div>
                                    <div class="cart_extra_total_value ml-auto"><span>$${cartStats.amount}</span></div>
                                </li>
                                <li class="d-flex flex-row align-items-center justify-content-start">
                                    <div class="cart_extra_total_title">Discount</div>
                                    <div class="cart_extra_total_value ml-auto">Free</div>
                                </li>
                                <li class="d-flex flex-row align-items-center justify-content-start">
                                    <div class="cart_extra_total_title">Total</div>
                                    <div class="cart_extra_total_value ml-auto"><span>$10</span></div>
                                </li>
                            </ul>
                                <div onclick="pay()" class="checkout_button trans_200">Checkout</a></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:if>