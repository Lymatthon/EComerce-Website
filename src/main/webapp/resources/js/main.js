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
function updateCart(obj, productId) {
    fetch("/littleshop/api/cart", {
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
    });
}
function deleteCart(productId) {
    fetch(`/littleshop/api/cart/${productId}`, {
        method: "delete"
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let counter = document.getElementById("cartCounter");
        counter.innerText = data.counter;
        location.reload();
    });
}

function pay(){
    if (confirm("Accept to pay") == true){
        fetch("/littleshop/api/cart", {
            method: "post"
            
        }).then(function (res) {
        return res.json();
    }).then(function (code){
            console.log(code);
            location.reload();
    });
    
}
}