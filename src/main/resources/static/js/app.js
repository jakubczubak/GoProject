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

var priorityName = document.getElementById("priorityName");
var priorityFeedback = document.getElementById("priorityFeedback");

function checkPriorityName(minLength) {
    if(priorityName.value.length<minLength){
        document.getElementById("priorityBox").className="error";
        document.getElementById("priorityOK").className="hidden";
        document.getElementById("priorityError").className="";
        priorityFeedback.textContent = 'Enter at least 5 characters!';
    }else{
        document.getElementById("priorityError").className="hidden";
        document.getElementById("priorityOK").className="";
        document.getElementById("priorityBox").className="box";
        priorityFeedback.innerHTML='';

    }
}

priorityName.addEventListener('blur', function (ev) {
    checkPriorityName(5);
},false);

var prioritySendButton = document.getElementById("prioritySendButton");
prioritySendButton.onclick = function () {
    if (priorityName.value.length<5){
        checkPriorityName(5)
    }else{
        var data = "{\"name\":" + "\"" + priorityName.value +"\"}";
        $.ajax({
            url: '/priority/add',
            data: data,
            contentType: "application/json",
            method: "PUT"
        }).done(function () {

        });
        document.getElementById("priorityBox").className="success";
        setTimeout(function(){
            document.getElementById("priorityBox").className="box";
        }, 1000);
        priorityName.value="";
    }

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