<!--Forget Password section-->
var emailForgetPassword = document.getElementById("forgetPasswordEmail");
var forgetPasswordButton = document.getElementById("forgetPasswordButton");
var forgetPasswordMessage = document.getElementById("forgetPasswordMessage");

forgetPasswordButton.onclick = function (ev) {
    var token = $("meta[name='_csrf']").attr("content");

    if(validateEmail(emailForgetPassword.value)){
        $.ajax({
            url: '/forgetPassword',
            data: JSON.stringify({
                "email":   emailForgetPassword.value
            }),
            contentType: "application/json",
            headers: {"X-CSRF-TOKEN": token},
            method: "POST"
        }).done(function (data) {
            forgetPasswordMessage.innerText=data.message;
        });
    }else{
        forgetPasswordMessage.innerText="Incorrect email!"
    }

};

function validateEmail(email) {
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}