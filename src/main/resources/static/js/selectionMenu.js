//SELECTION MENU SECTION

var adminBox = document.getElementById("adminBox");
var userBox = document.getElementById("userBox");


adminBox.onclick = function (ev) {
    location.href = "/admin"
};
userBox.onclick = function (ev) {
    location.href = "/user"
};
