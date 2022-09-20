/* global fetch */

function addToCart(id, name, price) {
    fetch("/littleshop/api/cart", {
        method: 'post',
        body: JSON.stringify({
            "productId": id,
            "productName": name,
            "price": price,
            "quantity": quantitySelected,
            "color": colorSelected,
            "size": sizeSelected

        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let counter = document.getElementById("cartCounter");
        counter.innerText = data;
//        location.reload();
    });

}
function updateQuantityCart(obj, productId, pdId) {
    quantitySelected = obj.value;
    fetch("/littleshop/api/updateQuantity", {
        method: 'put',
        body: JSON.stringify({
            "productId": productId,
            "pDId": pdId,
            "productName": "",
            "price": 0,
            "quantity": obj.value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let counter = document.getElementById("cartCounter");
        counter.innerText = data;
        location.reload();
    });
}
function updateCouponCart(obj, productId) {
    event.preventDefault();
    fetch("/littleshop/api/updateCouponCart", {
        method: 'put',
        body: JSON.stringify({
            "productId": productId,
            "coupon": obj.previousElementSibling.value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (code) {
        console.log(code);
        location.reload();
    });
}

function deleteCart(productId, pDId) {
    fetch(`/littleshop/api/cart/${productId}/${pDId}`, {
        method: "delete"
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let counter = document.getElementById("cartCounter");
        counter.innerText = data.counter;
        let amount = document.getElementById("amountCart");
        counter.innerText = data.amount;
        location.reload();
    });
}


function getQuantityByColor(id, obj) {
    colorSelected = obj.value;
//    let size = document.getElementById("selectSize");
    fetch("/littleshop/api/getQuantityByColor", {
        method: 'post',
        body: JSON.stringify({
            "productId": id,
            "color": obj.value,
            "size": sizeSelected
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let counter2 = document.getElementById("countQuantity");
        counter2.innerText = data;
        if (data == 0) {
            disableButton(true);
        } else {
            disableButton(false);
            document.getElementById("quantityUpdate").max = data;
        }
    });
}
function getQuantityBySize(id, obj) {
    sizeSelected = obj.value;
    let color = $('selectColor li input').val();
    fetch("/littleshop/api/getQuantityBySize", {
        method: 'post',
        body: JSON.stringify({
            "productId": id,
            "color": colorSelected,
            "size": obj.value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let counter1 = document.getElementById("countQuantity");
        counter1.innerText = data;
        if (data == 0) {
            disableButton(true);
        } else {
            disableButton(false);
            document.getElementById("quantityUpdate").max = data;
        }
    });
}

var quantitySelected = 1;
var colorSelected = "";
var sizeSelected = "";


function validateOnAddCart(id, name, price) {
    event.preventDefault();
    if (colorSelected === "" || sizeSelected === "") {
        alert("Please select size and color!");
    } else {
        addToCart(id, name, price);
    }
}

function validateOnSubmit(id, name, price) {
    event.preventDefault();
    if (colorSelected === "" || sizeSelected === "") {
        alert("Please select size and color!");
    } else {
        addToCart(id, name, price);
    }
}

function disableButton(flag) {
    if (flag == true) {
        document.getElementById("minusButton").disabled = true;
        document.getElementById("plusButton").disabled = true;
        document.getElementById("quantityUpdate").disabled = true;
        document.getElementById("quantityUpdate").value = 1;
    } else {
        document.getElementById("minusButton").disabled = false;
        document.getElementById("plusButton").disabled = false;
        document.getElementById("quantityUpdate").disabled = false;
    }
}
function redirectToCart() {
    window.location.href = "/littleshop/cart";
}

   
