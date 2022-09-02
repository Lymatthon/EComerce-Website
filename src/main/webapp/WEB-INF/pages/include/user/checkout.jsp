
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

<div class="checkout" style="padding-top: 0">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <div class="billing">
                    <br>
                    <br>
                    <div class="checkout_title">Customer Information</div>
                    <div class="checkout_form_container">
                        <form action="#" id="checkout_form" class="checkout_form">
                            <div class="row">
                                <div class="col-lg-4">
                                    <input type="text" class="checkout_input label" value="Name: ">
                                </div>
                                <div class="col-lg-8">
                                    <input type="text" id="checkout_name" name="checkout_name" class="checkout_input" readonly="true" value="${user.customerName}" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-4">
                                    <input type="text" class="checkout_input label" value="Mail: ">
                                </div>
                                <div class="col-lg-8">
                                    <input type="text" id="checkout_name" name="checkout_name" class="checkout_input" readonly="true" value="${user.email}" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-4">
                                    <input type="text" class="checkout_input  label" value="Address: ">
                                </div>
                                <div class="col-lg-8">
                                    <input type="text" id="checkout_name" name="checkout_name" class="checkout_input" readonly="true" value="${user.address}" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-4">
                                    <input type="text" class="checkout_input label" value="Phone: ">
                                </div>
                                <div class="col-lg-8">
                                    <input type="text" id="checkout_name" name="checkout_name" class="checkout_input" readonly="true" value="${user.phone}" />
                                </div>
                            </div><!-- comment -->
                            <div class="row">
                                <div class="col-lg-4">
                                    <input type="text" class="checkout_input label" value="Gender: ">
                                </div>
                                <div class="col-lg-8">
                                    <input type="text" id="checkout_name" name="checkout_name" class="checkout_input" readonly="true" value="${user.gender}" />
                                </div>
                            </div>


                        </form>
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
                        <!--                                <div class="checkout_button trans_200"><button style="border: none; font-size: 18px; padding-top: 10px; background: transparent; color: white" type="submit">Next</button></div>-->
                        <div class="row">
                            <div class="checkout_button trans_200 col-6 btn-danger" style="background-color: graytext"><a style="text-decoration: none" href="/littleshop/user/cancelOrder">Cancel</a></div>
                            <div class="checkout_button trans_200 col-6" ><a href="/littleshop/user/processPayment" >Next</a></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
