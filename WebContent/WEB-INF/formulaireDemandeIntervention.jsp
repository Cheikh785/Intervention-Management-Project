<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="utf-8">
	<title>demande intervention</title>
	<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
	 <link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/collecter_don.css">
	<link rel="stylesheet" href="css/styleaccueil.css">
	<link rel="stylesheet" type="text/css" href="css/footer.css">
	
	
	<script src="js/jQuery.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <script src="js/script.js" type="text/javascript"></script>
</head>
<body>
<style>
	.form-outer
	{

	}
</style>
	
	<%@ include file="header-connexion.jsp" %>

	
	<div class="don_en_nature">
		<h2></h2>
		<div class="containerf" align="center" id="blur">
		<header><br> Bienvenue dans Demande Intervention M./Mme: ${user.nom }</header>
		<div class="form-outer">
					<!-- DEBUT DE NOTRE FORMULAIRE -->
			<form  method="post" name="formulaire" action="DemanderIntervention">
								<!-- 1 --->
				<div class="page">
					<div class ="field">
						<div class="label">
							Type de defaillance
						</div>
						<select name="tdp" id="tdp" required>
			              <option value="Electricite" selected>
			                Electricite
			              </option>
			              <option value="Plomberie">
			                Plomberie
			              </option>
			              <option value="Maçonnerie">
			                Maçonnerie
			              </option>
			              <option value="Menuiserie">
			                Menuiserie
			              </option>
			              <option value="Climatiseur">
			                Climatiseur
			              </option>
			              <option value="Video-Projecteur">
			                Video Projecteur
			              </option>
			               <option value="Autres">
			                Autres a preciser
			              </option>
			            </select><br>
			            
					</div>
					<div class ="field">
			             <div class="label">
							Autres
						</div>
			            <input type="text" disabled  name="autretdp" id="autretdp">
			        </div>
						<span class="erreur">${form.erreurs['autretdp']}</span>
					<div class ="field">
						<div class="label">
							Priorite
						</div>
						<select name="priorite" required>
			              <option value="Urgent" selected>
			                Urgent
			              </option>
			              <option value="Peu Urgent">
			                Peu Urgent
			              </option>
			              <option value="Pas Urgent">
			                Pas Urgent
			              </option>
			            </select>
			          </div>
					<div class ="field">
						<div class="label">
							Cause de la defaillance
						</div>
						<select name="cdd" id="cdd" required>
			              <option value="Usure Normale" selected>
			                Usure Normale
			              </option>
			              <option value="Defaut d'utilisateur">
			                Defaut d'utilisateur
			              </option>
			              <option value="Defaut Produit">
			                Defaut Produit
			              </option>
			              <option value="Autres">
			                Autres
			              </option>
			            </select>
			            
					</div>
					<div class ="field">
			             <div class="label">
							Autres
						</div>
			            <input type="text" disabled  name="autrecdd" id="autrecdd">
			        </div>   
						<span class="erreur">${form.erreurs['autrecdd']}</span>
					<div class ="field">
						<div class="label">
							Departement ou Service
						</div>
						<select name="service" required="" id="service">
			              <option value="Batiment Direction" selected>
			                Batiment Direction
			              </option>
			              <option value="Batiment Acp">
			                Batiment Acp
			              </option>
			              <option value="Genie Civile">
			                Genie Civile
			              </option>
			              <option value="Gestion">
			                Gestion
			              </option>
			              <option value="Genie Chimique">
			                Genie Chimique
			              </option>
			              <option value="Genie Electrique">
			                Genie Electrique
			              </option>
			              <option value="Genie Mecanique">
			                Genie Mecanique
			              </option>
			              <option value="Genie Informatique">
			                Genie Informatique
			              </option>
			              <option value="Ressources Humaines">
			                Ressources Humaines
			              </option>
			              <option value="Caisse">
			                Caisse
			              </option>
			              <option value="CIFRES">
			                CIFRES
			              </option>
			              <option value="LPAO">
			                LPAO
			              </option>
			              <option value="LERG">
			                LERG
			              </option>
			              <option value="LMAGI">
			                LMAGI
			              </option>
			              <option value="LER">
			                LER
			              </option>
			              <option value="SID">
			                SID
			              </option>
			              <option value="Scolarite">
			                Scolarite
			              </option>
			              <option value="CRENT">
			                CRENT
			              </option>
			              <option value="LAE">
			                LAE
			              </option>
			              <option value="LIMBI">
			                LIMBI
			              </option>
			              <option value="LIRT">
			                LIRT
			              </option>
			               <option value="Autres">
			                Autres a preciser
			              </option>
			            </select>
			            
					</div>
					<div class ="field">
			             <div class="label">
							Autres
						</div>
			            <input type="text" disabled  name="autreservice" id="autreservice">
			        </div>
						<span class="erreur">${form.erreurs['autreservice']}</span>
			        <input type="text" name="matricule" value="<c:out value="${utilisateur.matricule}"/>" hidden>
			        <input type="text" name="name" value="<c:out value="${user.nom}"/>" hidden>
					<div class ="field btns">
						
						<button  class="submit">
							Valider
						</button><br>
					</div>
				</div>
			</form>
				<!-- FIN DE NOTRE FORMULAIRE -->
		</div>
	</div>
   </div>
   <%@ include file="footer.jsp" %>
	<script type="text/javascript" src="js/step_form.js"></script>
   <script>
	   $(document).ready(function()
	   {
 			$("#service").click(function()
			 {
				 if($("#service").val() == "Autres")
				 {
					$("#autreservice").removeAttr("disabled");
				 }
				 else
				 {
					$("#autreservice").attr("disabled","");
				 }
			 });
	   });
	  
   </script>
   <script>
	   $(document).ready(function()
	   {
 			$("#tdp").click(function()
			 {
				 if($("#tdp").val() == "Autres")
				 {
					$("#autretdp").removeAttr("disabled");
				 }
				 else
				 {
					$("#autretdp").attr("disabled","");
				 }
			 });
	   });
	  
   </script>
   <script>
	   $(document).ready(function()
	   {
 			$("#cdd").click(function()
			 {
				 if($("#cdd").val() == "Autres")
				 {
					$("#autrecdd").removeAttr("disabled");
				 }
				 else
				 {
					$("#autrecdd").attr("disabled","");
				 }
			 });
	   });
	  
   </script>
  

	
</body>
</html>