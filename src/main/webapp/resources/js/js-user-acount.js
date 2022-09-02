/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


$(document).ready(function () {
    $('#contact_form').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            first_name: {
                validators: {
                    stringLength: {
                        min: 2,
                    },
                    notEmpty: {
                        message: 'Please enter your First Name'
                    }
                }
            },
            last_name: {
                validators: {
                    stringLength: {
                        min: 2,
                    },
                    notEmpty: {
                        message: 'Please enter your Last Name'
                    }
                }
            },
            user_name: {
                validators: {
                    stringLength: {
                        min: 8,
                    },
                    notEmpty: {
                        message: 'Please enter your Username'
                    }
                }
            },
            user_password: {
                validators: {
                    stringLength: {
                        min: 8,
                    },
                    notEmpty: {
                        message: 'Please enter your Password'
                    }
                }
            },
            confirm_password: {
                validators: {
                    stringLength: {
                        min: 8,
                    },
                    notEmpty: {
                        message: 'Please confirm your Password'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'Please enter your Email Address'
                    },
                    emailAddress: {
                        message: 'Please enter a valid Email Address'
                    }
                }
            },
            contact_no: {
                validators: {
                    stringLength: {
                        min: 12,
                        max: 12,
                        notEmpty: {
                            message: 'Please enter your Contact No.'
                        }
                    }
                },
                department: {
                    validators: {
                        notEmpty: {
                            message: 'Please select your Department/Office'
                        }
                    }
                },
            }
        }
    })
            .on('success.form.bv', function (e) {
                $('#success_message').slideDown({opacity: "show"}, "slow") // Do something ...
                $('#contact_form').data('bootstrapValidator').resetForm();

                // Prevent form submission
                e.preventDefault();

                // Get the form instance
                var $form = $(e.target);

                // Get the BootstrapValidator instance
                var bv = $form.data('bootstrapValidator');

                // Use Ajax to submit form data
                $.post($form.attr('action'), $form.serialize(), function (result) {
                    console.log(result);
                }, 'json');
            });
});
const phoneEl = document.querySelector('#phone');
const addressEl = document.querySelector('#address');
const usernameEl = document.querySelector('#name');
const form = document.querySelector('#signup-form');
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
const isVietnamesePhoneNumber = (phone) => {
    return /^(84|0[3|5|7|8|9])+([0-9]{8})\b/.test(phone);
};

const isRequired = value => value === '' ? false : true;
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
const isBetween = (length, min, max) => length < min || length > max ? false : true;
const checkAddress = () => {

    let valid = false;

    const min = 5,
            max = 100;

    const address = addressEl.value.trim();

    if (!isRequired(address)) {
        showError(addressEl, 'Address cannot be blank.');
    } else if (!isBetween(address.length, min, max)) {
        showError(addressEl, `Address must be between ${min} and ${max} characters.`);
    } else {
        showSuccess(addressEl);
        valid = true;
    }
    return valid;
};
form.addEventListener('submit', function (e) {
    let isPhoneValid = checkPhone();
    let isFormValid = isPhoneValid;
    if (isFormValid) {

    }
});