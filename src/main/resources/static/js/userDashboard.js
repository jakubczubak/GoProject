// BACK BUTTON

let backButton = document.getElementById("backButton");

backButton.onclick = function () {
    location.href = "/app"
}

//LOGOUT  SECTION

var logoutButton = document.getElementById("logout");

logoutButton.onclick = function (ev) {

    if(window.confirm("Are you sure?")){
        var logoutForm = document.getElementById("logoutForm");
        logoutForm.submit();
    }
};