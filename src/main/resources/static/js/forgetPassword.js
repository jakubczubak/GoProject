<!--Forget Password section-->
var emailForgetPassword = document.getElementById("forgetPasswordEmail");
var forgetPasswordButton = document.getElementById("forgetPasswordButton");
var forgetPasswordMessage = document.getElementById("forgetPasswordMessage");

forgetPasswordButton.onclick = function (ev) {
    var token = $("meta[name='_csrf']").attr("content");

    if(emailForgetPassword.value==""){
        forgetPasswordMessage.innerText="Enter email!"
    }else{
        $.ajax({
            url: '/forgetPassword',
            data: JSON.stringify({
                "email":   emailForgetPassword.value
            }),
            contentType: "application/json",
            headers: {"X-CSRF-TOKEN": token},
            method: "POST"
        }).done(function () {
            forgetPasswordMessage.innerText="Check your mailbox!"
        });
    }

};