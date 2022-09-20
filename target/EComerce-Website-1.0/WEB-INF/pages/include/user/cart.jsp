<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Home -->


<!-- Cart -->
<br/>
<br/>
<br/>
<br/>
<div style="margin: 35px"><!-- comment --><!-- comment -->
    <c:if test="${empty carts || carts == null}" >
        <h4 class="text-danger text-center">Khong co san pham nao trong gio hang!</h4>
    </c:if>
</div>

<br/>

<c:if test="${carts != null || !empty carts}" >
    <div class="cart_section">
        <div class="container">
            <div class="row">
                <div class="col">
                    <div class="cart_container">

                        <!-- Cart Bar -->
                        <div class="cart_bar">
                            <ul class="cart_bar_list item_list d-flex flex-row align-items-center justify-content-end">
                                <li style="font-weight: bold; font-size: 18px" class="mr-auto">Product</li>
                                <li style="font-weight: bold; font-size: 18px">Size</li>
                                <li style="font-weight: bold; font-size: 18px">Color</li>
                                <li style="font-weight: bold; font-size: 18px">Price</li>
                                <li style="font-weight: bold; font-size: 18px">Quantity</li>
                                <li style="font-weight: bold; font-size: 18px">Action</li>
                            </ul>
                        </div>

                        <!-- Cart Items -->
                        <c:forEach items="${carts}" var="c">
                            <div class="cart_items">
                                <ul class="cart_items_list">

                                    <!-- Cart Item -->
                                    <li class="cart_item item_list d-flex flex-lg-row flex-column align-items-lg-center align-items-start justify-content-lg-end justify-content-start">
                                        <div class="product d-flex flex-lg-row flex-column align-items-lg-center align-items-start justify-content-start mr-auto">

                                            <div class="product_name" style="padding: auto"><a href="/littleshop/product/details/${c.productId}">${c.productName}</a></div>

                                        </div>
                                        <div class="product_size product_text">${c.size}</div>
                                        <div class="product_color product_text">${c.color}</div>
                                        <div class="product_color product_text">$${c.price}</div>

                                        <div class="product_quantity_container">
                                            <input value="${c.quantity}" type="number" min="1" class="product_quantity ml-lg-auto mr-lg-auto text-center"
                                                   onblur="updateQuantityCart(this,${c.productId},${c.pDId})"/>
                                        </div>
                                        <!--                                        <div class="product_total product_text"><span>Total: </span>$3.99</div>-->
                                        <div class="product_quantity_container">
                                            <input class="btn btn-danger" type="button" value="Delete" onclick="deleteCart(${c.productId},${c.pDId})" />
                                        </div>
                                    </li>
                                </ul>
                            </div>                            
                        </c:forEach>

                        <!-- Cart Buttons -->
                        <div class="cart_buttons d-flex flex-row align-items-start justify-content-start">
                            <div class="cart_buttons_inner ml-sm-auto d-flex flex-row align-items-start justify-content-start flex-wrap">
                                <div class="button button_clear trans_200" style="width: 300px"><a href="/littleshop/clearCart">clear cart</a></div>
                                <div class="button button_continue trans_200" style="width: 300px"><a href="/littleshop/home">continue shopping</a></div>
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
                                <c:forEach items="${carts}" var="cartItem" begin="0" end="0">
                                    <c:set value="${cartItem.productId}" var="cId" />
                                    <c:set value="${cartItem.coupon}" var="cCoupon" />
                                </c:forEach>                                
                                <form action="#" id="coupon_form" class="coupon_form">
                                    <input id="coupon_input" type="text" value="${cCoupon}" class="coupon_input">
                                    <button onclick="updateCouponCart(this, ${cId})" class="coupon_button">apply</button>                                        
                                </form>
                                <div><p>See more promotion <a href="#">here</a></p></div>
                            </div>
                            <div class="coupon_text">Enter multiple codes, separated by commas!</div>

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
                                    <div class="cart_extra_total_value ml-auto"><span>$${cartStats.subTotal}</span></div>
                                </li>
                                <li class="d-flex flex-row align-items-center justify-content-start">
                                    <div class="cart_extra_total_title">Discount</div>
                                    <div class="cart_extra_total_value ml-auto"><span>$${cartStats.discount}</span></div>
                                </li>
                                <li class="d-flex flex-row align-items-center justify-content-start">
                                    <div class="cart_extra_total_title">Total</div>
                                    <div class="cart_extra_total_value ml-auto"><span><span>$${cartStats.amount}</span></span></div>
                                </li>
                            </ul>
                            <br>
                            <br>
                            <div class="button button_clear trans_200" style="margin: auto"><a href="/littleshop/user/getOrderInformation">Check out</a></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:if>