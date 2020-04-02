
var logout = document.getElementById("logout");
  console.log(logout.innerText);
  console.log(logout.outerHTML);

  logout.onclick = function () { console.log("wyloguj")
      if(confirm('Are you sure to logout')) {
          return true;
      }

      return false;};


  var a = document.getElementById("a");

  a.onclick = function (ev) {
      console.log("asd");
      var body = document.getElementById("layoutSidenav_content");
      body.innerHTML= "<p></p>"
  }

