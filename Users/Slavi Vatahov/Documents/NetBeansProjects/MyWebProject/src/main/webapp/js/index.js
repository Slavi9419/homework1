/* global breack */

var myWebSocketConnection;
var myUsername;
function init() {
    output = document.getElementById("indexId");
    openConnection();
}
function openConnection() {
    myWebSocketConnection = new WebSocket("ws://localhost:8080/MyWebProject/home");


    myWebSocketConnection.onmessage = function (evt) {
        if (evt.data === "R,E,G,I,S,T,R,A,T,I,O,N,S,U,C,C,E,S,S") {
            loadHomePage();
            breack;
        } else if (evt.data === "L,O,G,I,N,S,U,C,C,E,S,S") {
            loadHomePage();
            breack;
        } else if (evt.data.includes("userlist")) {
            updateActiveUsers(evt);
            breack;
        } else if (evt.data.includes("E,R,R,O,R")) {
            alert(evt.data.substring(9));
            breack;
        }
    };
    myWebSocketConnection.onerror = function (evt) {
        alert(evt.data);
    };
}

function signIn() {
    var authentication = ["S,I,G,N,I,N", document.getElementById('loginUsernameID').value, document.getElementById('loginPasswordID').value];
    myWebSocketConnection.send(authentication);
    myUsername = document.getElementById('loginUsernameID').value;

}
function singUp() {
    if (document.getElementById('singUpPasswordID').value === document.getElementById('singUpPasswordIDConfim').value) {
        var registrationArgs = ["S,I,G,N,U,P", document.getElementById('singUpFirstNameID').value, document.getElementById('singUpLastNameID').value, document.getElementById('singUpUsernameID').value, document.getElementById('emailID').value, document.getElementById('singUpPasswordID').value];
        myWebSocketConnection.send(registrationArgs);
        myUsername = document.getElementById('singUpUsernameID').value;
    } else {
        alert("Password does not match");

    }
}

function writeToScreen(message) {
    var pre = document.createElement("p");
    pre.style.wordWrap = "break-word";
    pre.innerHTML = message;
    output.appendChild(pre);
}

function loadHomePage() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {

        document.getElementById("indexId").innerHTML = this.responseText;

    };
    xhttp.open("GET", "home.html", true);
    xhttp.send();
}
function loadindexPage() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {

        document.getElementById("indexId").innerHTML = this.responseText;

    };
    xhttp.open("GET", "index.html", true);
    xhttp.send();
}
var name;
var array;
var i = 0;
function updateActiveUsers(msg) {
    var data = JSON.parse(msg.data);
    array = new Array();
    array = data.userlist.toString().split(",");
    document.getElementById("roomsList").innerHTML = "<h3>Users</h3>";

    for (var a in array) {
        if (array[a] === myUsername) {
            
        }
        document.getElementById("roomsList").innerHTML += "<li> <a id='aa' href='#' onclick=\'register_popup(\"qnimate\",  " + 'array[0]' + ");\'>" + array[a] + "</a> </li>";
        i++;
    }
}
function refreshRooms() {
    myWebSocketConnection.send("R,E,F,R,E,S,H,R,O,O,M,S");
}
Array.remove = function (array, from, to) {
    var rest = array.slice((to || from) + 1 || array.length);
    array.length = from < 0 ? array.length + from : from;
    return array.push.apply(array, rest);
};

//this variable represents the total number of popups can be displayed according to the viewport width
var total_popups = 0;

//arrays of popups ids
var popups = [];

//this is used to close a popup
function close_popup(id)
{
    for (var iii = 0; iii < popups.length; iii++)
    {
        if (id == popups[iii])
        {
            Array.remove(popups, iii);

            document.getElementById(id).style.display = "none";

            calculate_popups();

            return;
        }
    }
}

//displays the popups. Displays based on the maximum number of popups that can be displayed on the current viewport width
function display_popups()
{
    var right = 220;

    var iii = 0;
    for (iii; iii < total_popups; iii++)
    {
        if (popups[iii] != undefined)
        {
            var element = document.getElementById(popups[iii]);
            element.style.right = right + "px";
            right = right + 320;
            element.style.display = "block";
        }
    }

    for (var jjj = iii; jjj < popups.length; jjj++)
    {
        var element = document.getElementById(popups[jjj]);
        element.style.display = "none";
    }
}

//creates markup for a new popup. Adds the id to popups array.
function register_popup(id, name)
{

    for (var iii = 0; iii < popups.length; iii++)
    {
        //already registered. Bring it to front.
        if (id == popups[iii])
        {
            Array.remove(popups, iii);

            popups.unshift(id);

            calculate_popups();


            return;
        }
    }

    var element = '<div class="popup-box chat-popup" id="' + id + '">';
    element = element + '<div class="popup-head">';
    element = element + '<div class="popup-head-left">' + name + '</div>';
    element = element + '<div class="popup-head-right"><a href="javascript:close_popup(\'' + id + '\');">&#10005;</a></div>';
    element = element + '<div style="clear: both"></div></div><div class="popup-messages"></div></div>';

    document.getElementsByTagName("body")[0].innerHTML = document.getElementsByTagName("body")[0].innerHTML + element;

    popups.unshift(id);

    calculate_popups();

}

//calculate the total number of popups suitable and then populate the toatal_popups variable.
function calculate_popups()
{
    var width = window.innerWidth;
    if (width < 540)
    {
        total_popups = 0;
    } else
    {
        width = width - 200;
        //320 is width of a single popup box
        total_popups = parseInt(width / 320);
    }

    display_popups();

}

//recalculate when window is loaded and also when window is resized.
window.addEventListener("resize", calculate_popups);
window.addEventListener("load", calculate_popups);
window.addEventListener("load", init, false);