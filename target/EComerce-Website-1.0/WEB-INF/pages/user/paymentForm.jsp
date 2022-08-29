<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <style>
            body {
                margin-top:20px;
            }
            .panel-title {
                display: inline;
                font-weight: bold;
            }
            .checkbox.pull-right {
                margin: 0;
            }
            .pl-ziro {
                padding-left: 0px;
            }
            .inputAmount {
                border: none;
                width: 40px;
                
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row" style="padding-top: 80px" >
                <div class="col-xs-12 col-md-4"></div>
                <div class="col-xs-12 col-md-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">
                                Payment Details
                            </h3>
                        </div>
                        <div class="panel-body">
                            <form:form role="form" action="/littleshop/cart/pay" modelAttribute="paymentDetails" method="post">
                                <div class="form-group">
                                    <label for="customerName">
                                        FULL NAME</label>
                                    <div class="input-group">
                                        <form:input class="form-control" path="customerName" id="customerName" placeholder="Name in Card"/>
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="cardNumber">
                                        CARD NUMBER</label>
                                    <div class="input-group">
                                        <form:input class="form-control" path="cardNumber" id="cardNumber" placeholder="Valid Card Number"/>
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-7 col-md-7">
                                        <div class="form-group">
                                            <label for="expityMonth">
                                                EXPIRY DATE</label>
                                            <div class="col-xs-6 col-lg-6 pl-ziro">
                                                <form:input class="form-control" path="expireMonth" id="expityMonth" placeholder="MM" />
                                            </div>
                                            <div class="col-xs-6 col-lg-6 pl-ziro">
                                                <form:input class="form-control"  path="expireYear" id="expityYear" placeholder="YY" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-5 col-md-5 pull-right">
                                        <div class="form-group">
                                            <label for="cvCode">
                                                CV CODE</label>
                                            <form:password class="form-control" id="cvCode" path="cvvCode" />
                                        </div>
                                        
                                    </div>
                                </div>
                                <ul class="nav nav-pills nav-stacked">
                                    <li class="active"><a style="font-size: 16px"><span class="badge pull-right" style="font-size: 14px">$<form:input class="inputAmount" readonly="readonly" path="amount" id="amount" value="${cartStats.amount}" /></span> Final Payment</a>
                                    </li>
                                </ul>
                                <br/>
                                <button class="btn btn-success btn-lg btn-block" type="submit" role="button">Pay</button>
                            </div>
                        </form:form>
                    </div>


                </div>
            </div>
        </div>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    </body>
</html>
