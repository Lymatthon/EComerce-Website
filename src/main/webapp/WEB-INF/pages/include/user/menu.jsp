<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="menu">

    <!-- Search -->
    <div class="menu_search">
        <form action="#" id="menu_search_form" class="menu_search_form">
            <input type="text" class="search_input" placeholder="Search Item" required="required">
            <button class="menu_search_button"><img src="<c:url value="/resources/images/search.png"/>" alt=""></button>
        </form>
    </div>

    <!-- Contact Info -->
    <div class="menu_contact">
<!--        <div class="menu_phone d-flex flex-row align-items-center justify-content-start">
            <div><div><img src="<c:url value="/resources/images/phone.svg"/>" alt="https://www.flaticon.com/authors/freepik"></div></div>
            <div>+1 912-252-7350</div>
        </div>-->
        <div class="menu_social">
            <ul class="menu_social_list d-flex flex-row align-items-start justify-content-start">
                <li><a href="#"><i class="fa fa-facebook" >hhhh</i></a></li>
                <li><a href="#"><i class="fa fa-youtube-play" >hhh</i></a></li>
                <li><a href="#"><i class="fa fa-google-plus" >hhh</i></a></li>
                <li><a href="#"><i class="fa fa-instagram" >hhh</i></a></li>
            </ul>
        </div>
    </div>
</div>