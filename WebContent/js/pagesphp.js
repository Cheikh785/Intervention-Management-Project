function choisirNav(s)
{
var x=document.getElementById("myTab");
var y=document.getElementsByClassName("nav-link");
  for (var i = 0; i < y.length; i++) 
  {
    if(y[i].classList.contains("act"))//enlève la classe "active" au bouton précédemment cliqué
      y[i].classList.remove("act");
  }
    //pour ajouter la classe active au bouton cliqué
  var z=document.getElementById(s);
  z.classList.add("act");//ajoute la classe "active" au bouton cliqué
}

function cacheMP(myInput, myToggle)
{
  var x = document.getElementById(myInput);
  var y = document.getElementById(myToggle);
  if (x.type === "password") 
  {
    x.type = "text";
    y.classList.remove("fa-eye");
    y.classList.add("fa-eye-slash");
  } 
  else 
  {
    x.type = "password";
    y.classList.remove("fa-eye-slash");
    y.classList.add("fa-eye");
  }
}

var cl = true;

$(document).ready(function()
{
  $(".nav-link").click(function()
  {
    if((this).attr("id") != "mod")
    {
      $("#default").hide();
    }
    else
    {
      $("#default").show();
    }
  });
});