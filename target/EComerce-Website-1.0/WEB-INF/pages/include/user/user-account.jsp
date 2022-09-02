<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="home_cart">
    <div class="home_container d-flex flex-column align-items-center justify-content-end">
        <div class="home_content text-center">
            <div class="home_title">Account Details</div>
            <div class="breadcrumbs d-flex flex-column align-items-center justify-content-center">
                <ul class="d-flex flex-row align-items-start justify-content-start text-center">

                </ul>
            </div>
        </div>
    </div>
</div>
<br><!-- comment -->

<div class="container" style="padding-top: 40px">
    <div class="row gutters">
        <div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
            <div class="card h-100">
                <div class="card-body">
                    <div class="account-settings">
                        <div class="user-profile">
                            <div class="user-avatar">
                                <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Maxwell Admin">
                            </div>
                            <br>
                            <h5 class="user-name" style="font-size: 18px; font-weight: bold; text-align: center">${account.customerName}</h5>
                        </div>
                        <div class="about">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
            <div class="card h-100">
                <div class="card-body">
                    <form:form modelAttribute="account" id="signup-form" action="/littleshop/user/updateprofile" method="POST">
                        <div class="row gutters">
                            <form:hidden cssClass="form-control" path="id" id="ciTy" value="${account.id}" />

                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <div class="form-group">
                                    <label for="fullName">Full Name</label>
                                    <form:input id="fullName" cssClass="form-control form-input" path="customerName" value="${account.customerName}" />
                                    <small></small>
                                </div>
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <div class="form-group">
                                    <label for="eMail">Email</label>
                                    <input class="form-control" readonly="true" type="email" name="email" value="${account.email}" />
                                </div>
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <div class="form-group">
                                    <label for="phone">Phone</label>
                                    <form:input cssClass="form-control form-input" id="phone" path="phone" value="${account.phone}" />
                                    <small></small>
                                </div>
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <div class="form-group">
                                    <label for="website">Gender</label><br>

                                    <c:if test="${account.gender == 'Male'}"> 
                                        Female <form:radiobutton path="gender" value="Female"/> 
                                        Male <form:radiobutton path="gender" value="${account.gender}"/>
                                    </c:if>
                                    <c:if test="${account.gender == 'Female'}"> 
                                        Female <form:radiobutton path="gender" value="${account.gender}"/> 
                                        Male <form:radiobutton path="gender" value="Male"/>
                                    </c:if>


                                </div>
                            </div>
                        </div>
                        <div class="row gutters">
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <div class="form-group">
                                    <label for="Street">Address</label>
                                    <form:input cssClass="form-control form-input" path="address" value="${account.address}" />
                                    <small></small>
                                </div>
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <div class="form-group">
                                    <label for="ciTy">Status</label>
                                    <input type="name" readonly="true" class="form-control" id="ciTy" value="${account.status}">
                                </div>
                            </div>

                        </div>
                        <div class="row gutters">
                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                <div class="text-right">
                                    <button type="submit" id="submit" name="submit" class="btn btn-primary">Update</button>
                                    <button type="button" id="submit" name="submit" class="btn btn-primary"><a style="text-decoration: none; color: white" href="/littleshop/user/formChangePassword">Change Password</a></button>
                                    <button type="button" id="submit" name="submit" class="btn btn-secondary" onClick="window.location.reload(true)"><a style="text-decoration: none; color: white" href="">Clear Change</a></button>
                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>