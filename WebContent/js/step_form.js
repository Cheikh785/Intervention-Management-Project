	/* mes contantes et variables*/
const slidePage = document.querySelector(".slidepage");
const firstNextBtn = document.querySelector(".nextBtn");
const prevBtnSec = document.querySelector(".prev-1");
const nextBtnSec = document.querySelector(".next-1");
const prevBtn3 = document.querySelector(".prev-2");
const nextBtn3 = document.querySelector(".next-2");
const prevBtn4 = document.querySelector(".prev-3");
const submitBtn = document.querySelector(".submit");
const progressText = document.querySelectorAll(".step p");
const progressCheck = document.querySelectorAll(".step .check");
const bullet = document.querySelectorAll(".step .bullet");
let max = 4;
let current = 1;
let valide = 0;
/* FONCTIONS DE VERIFICATIONS*/

/* boutons next et fonction*/
firstNextBtn.addEventListener("click", function(){
	
	/*	if(document.formulaire.nom.value === "")  {
   document.formulaire.nom.style.boxShadow = " 1px 1px 1px 1px  red";
   document.formulaire.nom.focus();
   return false;
  }*/
  document.formulaire.nom.style.boxShadow = " 1px 1px 1px 1px green";
 /*if(document.formulaire.prenom.value === "") {
   document.formulaire.prenom.style.boxShadow = " 1px 1px 1px 1px red";
   document.formulaire.prenom.focus();
   return false;
  } */
  document.formulaire.prenom.style.boxShadow = " 1px 1px 1px 1px green";

	slidePage.style.marginLeft = "-25%";
	bullet[current-1].classList.add("active");
	progressText[current-1].classList.add("active");
	progressCheck[current-1].classList.add("active");
	
	

	current+=1;
});



nextBtnSec.addEventListener("click", function(){


         /*function checkEmail(email) {
             var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
             return re.test(email);
         }
       
             
             if (checkEmail(document.formulaire.email.value)) {
                document.formulaire.email.style.boxShadow = " 1px 1px 1px 1px green";
             } else {
                 document.formulaire.email.style.boxShadow = " 1px 1px 1px 1px  red";
                 document.getElementById("email").value= '';
                 document.formulaire.email.focus();
             
             return false;
         }

	
	if(document.formulaire.email.value == "")  {
   document.formulaire.email.style.boxShadow = " 1px 1px 1px 1px  red";
   document.formulaire.email.focus();
   return false;
  }*/
  document.formulaire.email.style.boxShadow = " 1px 1px 1px 1px green";

	slidePage.style.marginLeft = "-50%";
	bullet[current-1].classList.add("active");
	progressText[current-1].classList.add("active");
	progressCheck[current-1].classList.add("active");

	current+=1;
});



nextBtn3.addEventListener("click", function(){
	
/*	if(document.formulaire.adresse.value == "")  {
   document.formulaire.adresse.style.boxShadow = " 1px 1px 1px 1px  red";
   document.formulaire.adresse.focus();
   return false;
  }
  document.formulaire.adresse.style.boxShadow = " 1px 1px 1px 1px green";
*/
	slidePage.style.marginLeft = "-75%";
	bullet[current-1].classList.add("active");
	progressText[current-1].classList.add("active");
	progressCheck[current-1].classList.add("active");

	current+=1;
});

submitBtn.addEventListener("click", function(){
	
    toggle();
    if(valide == 0)
    	return false;

	bullet[current-1].classList.add("active");
	progressText[current-1].classList.add("active");
	progressCheck[current-1].classList.add("active");
	
});

	/* boutons prev et fonction*/
prevBtnSec.addEventListener("click", function(){
	slidePage.style.marginLeft = "0%";
	bullet[current-2].classList.remove("active");
	progressText[current-2].classList.remove("active");
	progressCheck[current-2].classList.remove("active");

	current-=1;
});

prevBtn3.addEventListener("click", function(){
	slidePage.style.marginLeft = "-25%";
	bullet[current-2].classList.remove("active");
	progressText[current-2].classList.remove("active");
	progressCheck[current-2].classList.remove("active");

	current-=1;
});

prevBtn4.addEventListener("click", function(){
	slidePage.style.marginLeft = "-50%";
	bullet[current-2].classList.remove("active");
	progressText[current-2].classList.remove("active");
	progressCheck[current-2].classList.remove("active");

	current-=1;
});

/********pop up **********************************/

 /*var valider = document.getElementById('validation');*/
      /*var fermer = document.getElementById('fermer_popup');*/

		/*valider.addEventListener('click',toggle);*/
		/*fermer.addEventListener('click',toggle);*/

function toggle() {

			/* verification sur le champ "nature du don" 

			if((document.formulaire.type.value == "donner") && (document.formulaire.nature_don.value == ""))  {
			   
			   document.formulaire.nature_don.style.boxShadow = " 1px 1px 1px 1px  red";
			   document.formulaire.nature_don.focus();
			   return false;
			  }
			  document.formulaire.nature_don.style.boxShadow = " 1px 1px 1px 1px green";
			

			if(document.formulaire.description.value == "")  {
			  
			   document.formulaire.description.style.boxShadow = " 1px 1px 1px 1px  red";
			   document.formulaire.description.focus();
			   return false;
			  }*/
			
             /*document.formulaire.description.style.boxShadow = " 1px 1px 1px 1px green";*/
             
			
			
			/*var blur = document.getElementById('blur');
			blur.classList.toggle('active');
			var popup = document.getElementById('popup');
			popup.classList.toggle('active');*/
			valide = 1;
		}