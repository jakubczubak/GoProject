var client = null;
var webSocketURL = null;
var userName = null;


function showMessage(value, user) {

    var today    = new Date();
    var date     = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
    var time     = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
    var dateTime = date+' '+time;

    var newResponse = document.createElement('p');
    newResponse.appendChild(document.createTextNode("[" + dateTime + "] "));
    newResponse.appendChild(document.createTextNode(user));
    newResponse.appendChild(document.createTextNode(" : "));
    newResponse.appendChild(document.createTextNode(value));
    var respone = document.getElementById('reponse');
    respone.appendChild(newResponse);
}



function connect() {
    getUserName();
    getWebSocketURL();

    client = Stomp.client(webSocketURL);
    client.connect({}, function (frame) {
        client.subscribe("/topic/messages", function(message){
            if(JSON.parse(message.body).message===""){
                //do nothing
            }else{
                showMessage(JSON.parse(message.body).message, JSON.parse(message.body).user)
            }
        });
    })
}

function sendMessage() {
    var messageToSend = document.getElementById('messageToSend').value;
    client.send("/app/chat", {}, JSON.stringify({'message': messageToSend, 'user': userName}));
    document.getElementById('messageToSend').value = '';
    document.getElementById('messageToSend').focus();
}

document.getElementById('messageToSend').addEventListener("keyup", function(event) {
    if (event.key === 'Enter') {

        event.preventDefault();
        document.getElementById("sendBtn").click();
    }
});

function sendFakeMessage() {
    client.send("/app/chat", {}, JSON.stringify({'message': '', 'user': ''}));
}

function getWebSocketURL() {
    $.ajax({
        url: "/app/websocket-url",
        async: false,
        data: {},
        type: "GET",
        dataType: "text"
    }).done(function(result) {
        webSocketURL=result;

    }).fail(function(xhr,status,err) {
    }).always(function(xhr,status) {
    });
}

//Heroku has a timeout limit (55s), so we use this function to not break the connection.
setTimeout(function() {
    setInterval(sendFakeMessage, 5000);
}, 5000);

function getUserName(){
    $.ajax({
        url: "/app/userInfo",
        async: false,
        data: {},
        type: "GET",
        dataType: "text"
    }).done(function(result) {
        userName=result;
        console.log(userName);
    }).fail(function(xhr,status,err) {
    }).always(function(xhr,status) {
    });
}