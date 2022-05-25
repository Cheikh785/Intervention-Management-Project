$(function () {

  window.setTimeout(function () {
    $('.diapo').css('opacity', '1');
  }, 2000);

  $('.cadre').addClass('arriere-plan');

  $('.cadre').on('click', function () {

    var e = $('.diapo > .cadre');
    if (e.hasClass('active-plan')) {
      e.removeClass('active-plan');
      $(this).addClass('active-plan');
    } else {$(this).addClass('active-plan');}
  });
});



/*---------------------------------------------------------------------------------------------------------------*/
$(function () {
    var acc = document.getElementsByClassName("accordion-bis");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener("click", function() {
    this.classList.toggle("active-bis");
    var panel = this.nextElementSibling;
    if (panel.style.maxHeight) {
      panel.style.maxHeight = null;
    } else {
      panel.style.maxHeight = panel.scrollHeight + "px";
    } 
  });
}
});

/*----------------------------------------------------------------------------------------------------------------*/
$(document).ready(function() {
    $("div.presentation-tab-menu>div.list-group>a").click(function(e) {
        e.preventDefault();
        $(this).siblings('a.active').removeClass("active");
        $(this).addClass("active");
        var index = $(this).index();
        $("div.presentation-tab>div.presentation-tab-content").removeClass("active");
        $("div.presentation-tab>div.presentation-tab-content").eq(index).addClass("active");
    });
});

/*----------------------------------------------------------------------------------------------------------------*/
/*var nombre_diamond = 124;
var nombre_gold = 219;
var nombre_silver = 373;
var cpt1 = 0;
var cpt2 = 0;
var cpt3 = 0;
var duree = 1; 
var delta = Math.ceil((duree * 1) / 2);

function membre_diamond() {
                  document.getElementById("compteur_diamond").innerHTML=cpt1++;
                  if( cpt1 <= nombre_diamond ) { 
                     setTimeout(membre_diamond, delta);
                  }
}

function membre_gold() {
                  document.getElementById("compteur_gold").innerHTML=cpt2++;
                  if( cpt2 <= nombre_gold ) { 
                     setTimeout(membre_gold, delta);
                  }
}

function membre_silver() {
                  document.getElementById("compteur_silver").innerHTML=cpt3++;
                  if( cpt3 <= nombre_silver ) { 
                     setTimeout(membre_silver, delta);
                  }
}
*/
/*----------------------------------------------------------------------------------------------------------------*/
/*$(function () {
  var signe = -1;
        var clignotementFading = function(){
        var obj = document.getElementById('clignote');
        if (obj.style.opacity >= 1){
        signe = -1;
        }
        if (obj.style.opacity <= 0.93){
        signe = 1;
        }
        obj.style.opacity = (obj.style.opacity * 1) + (signe * 0.04);
        };

        // mise en place de l appel de la fonction toutes les 0.085 secondes
        // Pour arrêter le clignotement : clearInterval(periode);
        periode = setInterval(clignotementFading, 90 );
});
*/
/*----------------------------------------------------------------------------------------------------------------*/
/*$(function () {
  var signe = -1;
        var clignotementFading2 = function(){
        var obj = document.getElementById('je-donne-id');
        if (obj.style.opacity >= 1){
        signe = -1;
        }
        if (obj.style.opacity <= 0.0001){
        signe = 1;
        }
        obj.style.opacity = (obj.style.opacity * 1) + (signe * 0.02);
        };

        // mise en place de l appel de la fonction toutes les 0.085 secondes
        // Pour arrêter le clignotement : clearInterval(periode);
        periode = setInterval(clignotementFading2, 70 );
});
*/