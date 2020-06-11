document.getElementById("updatePasswordButton").onclick =function () {

    var newPasswordInput = document.getElementById("newPasswordInput");
    var confirmPasswordInput = document.getElementById("confirmPasswordInput");

    if(newPasswordInput.value != confirmPasswordInput.value){
        document.getElementById("forgetPasswordMessage").innerText="Passwords are different!";
    }else{
        var token = $("meta[name='_csrf']").attr("content");
        $.ajax({
            url: '/savePassword',
            data: JSON.stringify({
                "newPassword":   newPasswordInput.value
            }),
            contentType: "application/json",
            headers: {"X-CSRF-TOKEN": token},
            method: "POST"
        }).done(function (data) {
            window.location.href = data;
        });
    }

};