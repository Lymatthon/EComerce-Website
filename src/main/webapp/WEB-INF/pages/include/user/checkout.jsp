<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Home -->

<div class="home_checkout">
    <div class="home_container d-flex flex-column align-items-center justify-content-end">
        <div class="home_content text-center">
            <div class="home_title">Checkout</div>
            <div class="breadcrumbs d-flex flex-column align-items-center justify-content-center">
                <ul class="d-flex flex-row align-items-start justify-content-start text-center">

                </ul>
            </div>
        </div>
    </div>
</div>

<!-- Checkout -->

<div class="checkout">
    <div class="container">
        <div class="row">

            <!-- Billing -->
            <div class="col-lg-6">
                <div class="billing">
                    <div class="checkout_title">Billing</div>
                    <div class="checkout_form_container">
                        <form:form action="/littleshop/cart/processPayment" method="POST" modelAttribute="order" id="checkout_form" class="checkout_form">

                            <div>
                                <!-- Name -->
                                <form:input path="customerName" id="checkout_name" class="checkout_input" placeholder="Full Name" />
                            </div>

                            <div>
                                <!-- Address -->
                                <form:input class="checkout_input" path="address" id="checkout_address" placeholder="Address"/>
                            </div>
                            <!-- Phone no -->
                            <div>
                                <form:input  class="checkout_input" path="phone" id="checkout_phone" placeholder="Phone Number"/>
                            </div>
                            <div>
                                <form:radiobuttons class="checkbox" path="gender" id="gender" items="${genderMap}"/>
                            </div>
                        </div>


                    </div>
                </div>


                <!-- Cart Total -->
                <div class="col-lg-6 cart_col">
                    <div class="cart_total">
                        <div class="cart_extra_content cart_extra_total">
                            <div class="checkout_title">Cart Total</div>
                            <ul class="cart_extra_total_list">
                                <li class="d-flex flex-row align-items-center justify-content-start">
                                    <div class="cart_extra_total_title">Total</div>
                                    <div class="cart_extra_total_value ml-auto">$${cartStats.amount}</div>
                                </li>
                            </ul>
                            <div class="payment_options">
                                <div class="checkout_title">Payment</div>
                                <ul>
                                    <li class="shipping_option d-flex flex-row align-items-center justify-content-start">
                                        <label class="radio_container">
                                            <input type="radio" id="radio_2" name="payment_radio" class="payment_radio">
                                            <span class="radio_mark"></span>
                                            <span class="radio_text">Cash on Delivery</span>
                                        </label>
                                    </li>
                                    <li class="shipping_option d-flex flex-row align-items-center justify-content-start">
                                        <label class="radio_container">
                                            <input type="radio" id="radio_3" name="payment_radio" class="payment_radio" checked>
                                            <span class="radio_mark"></span>
                                            <span class="radio_text">Credit Card</span>
                                        </label>
                                    </li>
                                </ul>
                            </div>
                            <div class="cart_text">
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin pharetra tempor so dales. Phasellus sagittis auctor gravida. Integ er bibendum sodales arcu id te mpus. Ut consectetur lacus.</p>
                            </div>
                                <div class="checkout_button trans_200"><button style="border: none; font-size: 18px; padding-top: 10px; background: transparent; color: white" type="submit">Next</button></div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
