//PRIORITY SECTION
var newPriority = document.getElementById("newPriority");
var backPriorityButton = document.getElementById("backPriorityButton");


newPriority.onclick = function (ev) {
    document.getElementById("dashboard").className = "hidden";
    document.getElementById("priorityMenu").className = "add_priority_content";

};

backPriorityButton.onclick = function (ev) {
    document.getElementById("priorityMenu").className = "hidden";
    document.getElementById("dashboard").className = "main_content";
};
// -----------------------------------------------------------------------------------
var priorityName = document.getElementById("priorityName");
var priorityFeedback = document.getElementById("priorityFeedback");

function checkPriorityName(minLength) {
    if (priorityName.value.length < minLength) {
        document.getElementById("priorityBox").className = "error";
        document.getElementById("priorityOK").className = "hidden";
        document.getElementById("priorityError").className = "";
        priorityFeedback.textContent = 'Enter at least 5 characters!';
    } else {
        document.getElementById("priorityError").className = "hidden";
        document.getElementById("priorityOK").className = "";
        document.getElementById("priorityBox").className = "box";
        priorityFeedback.innerHTML = '';

    }
}

priorityName.addEventListener('blur', function (ev) {
    checkPriorityName(5);
}, false);
// -----------------------------------------------------------------------------------

var prioritySendButton = document.getElementById("prioritySendButton");
prioritySendButton.onclick = function () {
    if (priorityName.value.length < 5) {
        checkPriorityName(5)
    } else {

        var data = "{\"name\":" + "\"" + priorityName.value + "\"}";

        $.ajax({
            url: '/priority/add',
            data: data,
            contentType: "application/json",
            method: "PUT"
        });


        document.getElementById("priorityBox").className = "success";

        setTimeout(function () {
            document.getElementById("priorityBox").className = "box";
        }, 500);
        priorityName.value = "";
    }
};
// -----------------------------------------------------------------------------------


//STATUS SECTION
var newStatus = document.getElementById("newStatus");
var backStatusButton = document.getElementById("backStatusButton");

newStatus.onclick = function (ev) {
    document.getElementById("dashboard").className = "hidden";
    document.getElementById("statusMenu").className = "add_priority_content";

};

backStatusButton.onclick = function (ev) {
    document.getElementById("statusMenu").className = "hidden";
    document.getElementById("dashboard").className = "main_content";
};

//---------------------------------------------------------------------------

var statusName = document.getElementById("statusName");
var statusFeedback = document.getElementById("statusFeedback");

function checkStatusName(minLength) {
    if (statusName.value.length < minLength) {
        document.getElementById("statusBox").className = "error";
        document.getElementById("statusOK").className = "hidden";
        document.getElementById("statusError").className = "";
        statusFeedback.textContent = 'Enter at least 5 characters!';
    } else {
        document.getElementById("statusError").className = "hidden";
        document.getElementById("statusOK").className = "";
        document.getElementById("statusBox").className = "box";
        statusFeedback.innerHTML = '';

    }
}

statusName.addEventListener('blur', function (ev) {
    checkStatusName(5);
}, false);

//---------------------------------------------------------------------------


var statusSendButton = document.getElementById("statusSendButton");
statusSendButton.onclick = function () {
    if (statusName.value.length < 5) {
        checkStatusName(5)
    } else {

        var data = "{\"name\":" + "\"" + statusName.value + "\"}";

        $.ajax({
            url: '/status/add',
            data: data,
            contentType: "application/json",
            method: "PUT"
        });


        document.getElementById("statusBox").className = "success";

        setTimeout(function () {
            document.getElementById("statusBox").className = "box";
        }, 500);
        statusName.value = "";
    }
};

//USER SECTION
var newUser = document.getElementById("newUser");
var backUserButton = document.getElementById("backUserButton");

newUser.onclick = function (ev) {
    document.getElementById("dashboard").className = "hidden";
    document.getElementById("userMenu").className = "add_priority_content";
};

backUserButton.onclick = function (ev) {
    document.getElementById("userMenu").className = "hidden";
    document.getElementById("dashboard").className = "main_content";
};
//---------------------------------------------------------------------------

var userLogin = document.getElementById("userLogin");
var userName = document.getElementById("userName");
var userSurname = document.getElementById("userSurname");
var userPassword = document.getElementById("userPassword");
var userRepassword = document.getElementById("userRepassword");
var userFeedback = document.getElementById("userFeedback");

function checkUserFormLength(el, minLength) {
    if (el.value.length < minLength) {
        document.getElementById("userBox").className = "error";
        document.getElementById("userOK").className = "hidden";
        document.getElementById("userError").className = "";
        userFeedback.textContent = (el.name + " min. " + minLength + " characters");

    } else {
        document.getElementById("userError").className = "hidden";
        document.getElementById("userOK").className = "";
        document.getElementById("userBox").className = "box";
        userFeedback.innerHTML = '';

    }
}

userLogin.addEventListener('blur', function (ev) {
    checkUserFormLength(userLogin, 5);
}, false);

userName.addEventListener('blur', function (ev) {
    checkUserFormLength(userName, 3);
}, false);

userSurname.addEventListener('blur', function (ev) {
    checkUserFormLength(userSurname, 3);
}, false);

userPassword.addEventListener('blur', function (ev) {
    checkUserFormLength(userPassword, 6);
}, false);

function passwordComparison() {
    if (userPassword.value !== userRepassword.value) {
        document.getElementById("userBox").className = "error";
        document.getElementById("userOK").className = "hidden";
        document.getElementById("userError").className = "";
        userFeedback.textContent = "Passwords are not the same!";
    }
}

//

var userSendButton = document.getElementById("userSendButton");

userSendButton.onclick = function () {
    if (userLogin.value.length < 5) {
        checkUserFormLength(userLogin, 5);
    } else if (userName.value.length < 3) {
        checkUserFormLength(userName, 3);
    } else if (userSurname.value.length < 3) {
        checkUserFormLength(userSurname, 3);
    } else if (userPassword.value.length < 6) {
        checkUserFormLength(userPassword, 6);
    } else if (userPassword.value !== userRepassword.value) {
        passwordComparison();
    } else {

        var data = JSON.stringify({
            login: userLogin.value,
            name: userName.value,
            surname: userSurname.value,
            password: userPassword.value
        });

        $.ajax({
            url: '/users/add',
            data: data,
            contentType: "application/json",
            method: "PUT"
        });


        document.getElementById("userBox").className = "success";

        setTimeout(function () {
            document.getElementById("userBox").className = "box";
        }, 500);

        userName.value = "";
        userLogin.value = "";
        userSurname.value = "";
        userPassword.value = "";
        userRepassword.value = "";
    }
};

//PROJECT SECTION

var newProject = document.getElementById("newProject");
var backProjectButton = document.getElementById("backProjectButton");

newProject.onclick = function (ev) {
    document.getElementById("dashboard").className = "hidden";
    document.getElementById("projectMenu").className = "add_priority_content";
};

backProjectButton.onclick = function (ev) {
    document.getElementById("projectMenu").className = "hidden";
    document.getElementById("dashboard").className = "main_content";
};

//---------------------------------------------------------------------------

var projectName = document.getElementById("projectName");
var projectSite = document.getElementById("projectSite");
var projectDescription = document.getElementById("projectDescription");
var projectFeedback = document.getElementById("projectFeedback");

function checkProjectFormLength(el, minLength) {
    if (el.value.length < minLength) {
        document.getElementById("projectBox").className = "error";
        document.getElementById("projectOK").className = "hidden";
        document.getElementById("projectError").className = "";
        projectFeedback.textContent = (el.name + " min. " + minLength + " characters");


    } else {
        document.getElementById("projectError").className = "hidden";
        document.getElementById("projectOK").className = "";
        document.getElementById("projectBox").className = "box";
        projectFeedback.innerHTML = '';
    }
}

function checkDescriptionLength(el, maxLength) {
    if (el.value.length > maxLength) {
        document.getElementById("projectBox").className = "error";
        document.getElementById("projectOK").className = "hidden";
        document.getElementById("projectError").className = "";
        projectFeedback.textContent = (el.name + " max. " + maxLength + " characters");
    } else {
        document.getElementById("projectError").className = "hidden";
        document.getElementById("projectOK").className = "";
        document.getElementById("projectBox").className = "box";
        projectFeedback.innerHTML = '';
    }
}

function validURL(str) {
    var pattern = new RegExp('^(https?:\\/\\/)?' + // protocol
        '((([a-z\\d]([a-z\\d-]*[a-z\\d])*)\\.)+[a-z]{2,}|' + // domain name
        '((\\d{1,3}\\.){3}\\d{1,3}))' + // OR ip (v4) address
        '(\\:\\d+)?(\\/[-a-z\\d%_.~+]*)*' + // port and path
        '(\\?[;&a-z\\d%_.~+=-]*)?' + // query string
        '(\\#[-a-z\\d_]*)?$', 'i'); // fragment locator
    return !!pattern.test(str);
}

projectName.addEventListener('blur', function (ev) {
    checkProjectFormLength(projectName, 5);
}, false);

projectDescription.addEventListener('blur', function (ev) {
    checkDescriptionLength(projectDescription, 30);
}, false);

projectSite.addEventListener('blur', function (ev) {

    if (validURL(projectSite.value)) {
        document.getElementById("projectError").className = "hidden";
        document.getElementById("projectOK").className = "";
        document.getElementById("projectBox").className = "box";
        projectFeedback.innerHTML = '';
    } else {
        document.getElementById("projectBox").className = "error";
        document.getElementById("projectOK").className = "hidden";
        document.getElementById("projectError").className = "";
        projectFeedback.textContent = ("Incorrect URL");
    }
});

//---------------------------------------------------------------------------

var projectSendButton = document.getElementById("projectSendButton");

projectSendButton.onclick = function (ev) {
    if (projectName.value.length < 5) {
        checkProjectFormLength(projectName, 5);
    } else if (!validURL(projectSite.value)) {
        document.getElementById("projectBox").className = "error";
        document.getElementById("projectOK").className = "hidden";
        document.getElementById("projectError").className = "";
        projectFeedback.textContent = ("Incorrect URL");
    } else if (projectDescription.value.length > 30) {
        checkDescriptionLength(projectDescription, 30);
    } else {

        var data = JSON.stringify({
            name: projectName.value,
            description: projectDescription.value,
            site: projectSite.value
        });

        $.ajax({
            url: '/projects/add',
            data: data,
            contentType: "application/json",
            method: "PUT"
        });


        document.getElementById("projectBox").className = "success";

        setTimeout(function () {
            document.getElementById("projectBox").className = "box";
        }, 500);

        projectName.value = "";
        projectSite.value = "";
        projectDescription.value = "";

    }
};