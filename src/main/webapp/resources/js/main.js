/* global fetch */

function addToCart(id, name, price) {
    event.preventDefault();
    fetch("/littleshop/api/cart", {
        method: 'post',
        body: JSON.stringify({
            "productId": id,
            "productName": name,
            "price": price,
            "quantity": 1
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let counter = document.getElementById("cartCounter");
        counter.innerText = data;
    });
}
function updateQuantityCart(obj, productId) {
    fetch("/littleshop/api/updateQuantity", {
        method: 'put',
        body: JSON.stringify({
            "productId": productId,
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
///
function updateColorCart(obj, productId) {
    fetch("/littleshop/api/updateColor", {
        method: 'put',
        body: JSON.stringify({
            "productId": productId,
            "productName": "",
            "price": 0,
            "quantity": 0,
            "color": obj.value,
            "size": ""
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
///
///
function updateSizeCart(obj, productId) {
    fetch("/littleshop/api/updateSize", {
        method: 'put',
        body: JSON.stringify({
            "productId": productId,
            "productName": "",
            "price": 0,
            "quantity": 0,
            "color": "",
            "size": obj.value
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
///
function deleteCart(productId) {
    fetch(`/littleshop/api/cart/${productId}`, {
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

function pay() {
    if (confirm("Accept to pay") == true) {
        fetch("/littleshop/api/pay", {
            method: "post"
        }).then(function (res) {
            return res.json();
        }).then(function (code) {
            console.log(code);
            location.reload();
        });

    }
}