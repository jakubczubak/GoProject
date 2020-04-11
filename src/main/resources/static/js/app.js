
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