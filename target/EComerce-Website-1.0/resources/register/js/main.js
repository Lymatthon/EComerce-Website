(function ($) {

    $(".toggle-password").click(function () {

        $(this).toggleClass("zmdi-eye zmdi-eye-off");
        var input = $($(this).attr("toggle"));
        if (input.attr("type") == "password") {
            input.attr("type", "text");
        } else {
            input.attr("type", "password");
        }
    });

})(jQuery);

function checkValid() {
    var cbChecked = $("#agree-term").is(":checked");
    $("#submit").prop("disabled", !cbChecked);
}

$(function () {
    checkValid(); // run it for the first time
    $("#agree-term").on("change", checkValid);
});
////////Validate form

const usernameEl = document.querySelector('#name');
const emailEl = document.querySelector('#email');
const passwordEl = document.querySelector('#password');
const confirmPasswordEl = document.querySelector('#confirmPassword');
const addressEl = document.querySelector('#address');
const phoneEl = document.querySelector('#phone');
const genderEl = document.querySelector('#gender');
const form = document.querySelector('#signup-form');


const checkUsername = () => {

    let valid = false;

    const min = 3,
            max = 50;

    const username = usernameEl.value.trim();

    if (!isRequired(username)) {
        showError(usernameEl, 'Name cannot be blank.');
    } else if (!isBetween(username.length, min, max)) {
        showError(usernameEl, `Name must be between ${min} and ${max} characters.`);
    } else {
        showSuccess(usernameEl);
        valid = true;
    }
    return valid;
};
const checkPhone = () => {

    let valid = false;

    const phone = phoneEl.value.trim();

    if (!isRequired(phone)) {
        showError(phoneEl, 'Phone cannot be blank.');
    } else if (!isVietnamesePhoneNumber(phone)) {
        showError(phoneEl, `Invalid phone!`);
    } else {
        showSuccess(phoneEl);
        valid = true;
    }
    return valid;
};
const checkGender = () => {

    let valid = false;

    const gender = genderEl.value.trim();

    if (!isRequired(gender)) {
        showError(genderEl, 'Gender cannot be blank.');
    } else {
        showSuccess(genderEl);
        valid = true;
    }
    return valid;
};



const checkAddress = () => {

    let valid = false;

    const min = 5,
            max = 100;

    const address = addressEl.value.trim();

    if (!isRequired(address)) {
        showError(addressEl, 'Address cannot be blank.');
    } else if (!isBetween(address.length, min, max)) {
        showError(addressEl, `Name must be between ${min} and ${max} characters.`);
    } else {
        showSuccess(addressEl);
        valid = true;
    }
    return valid;
};


const checkEmail = () => {
    let valid = false;
    const email = emailEl.value.trim();
    if (!isRequired(email)) {
        showError(emailEl, 'Email cannot be blank.');
    } else if (!isEmailValid(email)) {
        showError(emailEl, 'Email is not valid.');
    } else {
        showSuccess(emailEl);
        valid = true;
    }
    return valid;
};

const checkPassword = () => {
    let valid = false;


    const password = passwordEl.value.trim();

    if (!isRequired(password)) {
        showError(passwordEl, 'Password cannot be blank.');
    } else if (!isPasswordSecure(password)) {
        showError(passwordEl, 'Password must has at least 8 characters that include at least 1 lowercase character, 1 uppercase characters, 1 number, and 1 special character in (!@#$%^&*)');
    } else {
        showSuccess(passwordEl);
        valid = true;
    }

    return valid;
};

const checkConfirmPassword = () => {
    let valid = false;
    // check confirm password
    const confirmPassword = confirmPasswordEl.value.trim();
    const password = passwordEl.value.trim();

    if (!isRequired(confirmPassword)) {
        showError(confirmPasswordEl, 'Please enter the password again');
    } else if (password !== confirmPassword) {
        showError(confirmPasswordEl, 'The password does not match');
    } else {
        showSuccess(confirmPasswordEl);
        valid = true;
    }

    return valid;
};

const isEmailValid = (email) => {
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
};

const isPasswordSecure = (password) => {
    const re = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
    return re.test(password);
};

const isVietnamesePhoneNumber = (phone) => {
    const re = new RegExp("^(84|0[3|5|7|8|9])+([0-9]{8})\b");
    return re.test(phone);
};

const isRequired = value => value === '' ? false : true;
const isBetween = (length, min, max) => length < min || length > max ? false : true;


const showError = (input, message) => {
    // get the form-field element
    const formField = input.parentElement;
    // add the error class
    formField.classList.remove('success');
    formField.classList.add('error');

    // show the error message
    const error = formField.querySelector('small');
    error.textContent = message;
};

const showSuccess = (input) => {
    // get the form-field element
    const formField = input.parentElement;

    // remove the error class
    formField.classList.remove('error');
    formField.classList.add('success');

    // hide the error message
    const error = formField.querySelector('small');
    error.textContent = '';
};


form.addEventListener('submit', function (e) {
    // prevent the form from submitting
    e.preventDefault();

    // validate fields
    let isUsernameValid = checkUsername(),
            isEmailValid = checkEmail(),
            isPasswordValid = checkPassword(),
            isConfirmPasswordValid = checkConfirmPassword(),
            isAddressValid = checkAddress(),
            isPhoneValid = checkPhone(),
            isGenderValid = checkGender();

    let isFormValid = isUsernameValid &&
            isEmailValid &&
            isPasswordValid &&
            isAddressValid &&
            isPhoneValid &&
            isGenderValid &&
            isConfirmPasswordValid;

    // submit to the server if the form is valid
    if (isFormValid) {

    }
});


const debounce = (fn, delay = 500) => {
    let timeoutId;
    return (...args) => {
        // cancel the previous timer
        if (timeoutId) {
            clearTimeout(timeoutId);
        }
        // setup a new timer
        timeoutId = setTimeout(() => {
            fn.apply(null, args);
        }, delay);
    };
};

form.addEventListener('input', debounce(function (e) {
    switch (e.target.id) {
        case 'name':
            checkUsername();
            break;
        case 'address':
            checkAddress();
            break;
        case 'phone':
            checkPhone();
            break;
        case 'gender':
            checkGender();
            break;    
        case 'email':
            checkEmail();
            break;
        case 'password':
            checkPassword();
            break;
        case 'confirmPassword':
            checkConfirmPassword();
            break;
    }
}));

/* https://www.javascripttutorial.net/javascript-dom/javascript-form-validation/ */


//