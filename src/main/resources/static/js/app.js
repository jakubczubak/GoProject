//PRIORITY SECTION
var newPriority = document.getElementById("newPriority");
var backPriorityButton = document.getElementById("backPriorityButton");

newPriority.onclick = function (ev) {
    document.getElementById("dashboard").className="hidden";
    document.getElementById("priorityMenu").className="add_priority_content";
}

backPriorityButton.onclick = function (ev) {
    document.getElementById("priorityMenu").className="hidden";
    document.getElementById("dashboard").className="main_content";
}
//STATUS SECTION
var newStatus = document.getElementById("newStatus");
var backStatusButton = document.getElementById("backStatusButton");

newStatus.onclick = function (ev) {
    document.getElementById("dashboard").className = "hidden";
    document.getElementById("statusMenu").className = "add_priority_content";

}

backStatusButton.onclick = function (ev) {
    document.getElementById("statusMenu").className = "hidden";
    document.getElementById("dashboard").className = "main_content";
}
//USER SECTION
var newUser = document.getElementById("newUser");
var backUserButton = document.getElementById("backUserButton");

newUser.onclick = function (ev) {
    document.getElementById("dashboard").className = "hidden";
    document.getElementById("userMenu").className = "add_priority_content";
}

backUserButton.onclick = function (ev) {
    document.getElementById("userMenu").className = "hidden";
    document.getElementById("dashboard").className = "main_content";
}

//PROJECT SECTION

var newProject = document.getElementById("newProject");
var backProjectButton = document.getElementById("backProjectButton");

newProject.onclick = function (ev) {
    document.getElementById("dashboard").className = "hidden";
    document.getElementById("projectMenu").className = "add_priority_content";
}

backProjectButton.onclick = function (ev) {
    document.getElementById("projectMenu").className="hidden";
    document.getElementById("dashboard").className="main_content";
}