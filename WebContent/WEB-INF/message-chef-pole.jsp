<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Message Chef de Pôle</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/fonts/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="css/styleaccueil.css">
	<link rel="stylesheet" type="text/css" href="css/don - Copie.css">
	<link rel="stylesheet" type="text/css" href="css/message-chef-pole.css">
	<link rel="icon" type="image/png" href="img/logo.png" />
</head>
<body>

	<%@ include file="header.jsp" %><br><br><br><br><br><br>

	<form method="post" action="message-chef-pole">
	    <div class ="field btns">
			
			<button  class="submit" >
				Actualiser
			</button><br>
		</div>
	</form>    
	<c:forEach items="${ listeIntervention }" var="liste" >
	
		<div class="container-fluid intervention">
			<div class= "row">
				<div class="col title-intervention">
	    			<h2>Intervention n°<c:out value="${ liste.key }" /></h2>
	    		</div>
			</div>
			
			<div class="row contact">
	    		<div class="col"><p><span class="title-contact">Demandeur : </span><c:out value="${ listeUtilisateur.get(liste.value.matricule).prenom}" />  <c:out value="${ listeUtilisateur.get(liste.value.matricule).nom}" /></p></div>
	    		<div class="col"><p><span class="title-contact">Contact : </span><c:out value="${ listeUtilisateur.get(liste.value.matricule).telephone }" /></p></div>
	    		<div class="col"><p><span class="title-defaillance">Type de defaillance : </span><c:out value="${ liste.value.tdp }" /></p></div>
	    		<div class="col"><p><span class="title-defaillance">Cause de la défaillance : </span><c:out value="${ liste.value.cdd }" /></p></div>
			</div>
		<div class="row">
			<div class="col title-mat"><h4>Matériaux utilisés </h4></div>
		</div><br>
		<div class="row">
			<div class="col-10">
				<div class="row">
					<c:forEach items="${ listeMateriel }" var="listeM" >
						<div class="col"><p>${ listeM.get(liste.key).nom } <span class="badge badge-primary">${ listeM.get(liste.key).quantite }</span></p></div>
					</c:forEach>
					<c:forEach items="${ listeMaterielEpuise }" var="listeM" >
						<div class="col"><p class="epuise"><a href="gestion-stock"><i class="fa fa-plus" aria-hidden="true"></i> ${ listeM.get(liste.key).nom } </a><span class="badge badge-secondary">${ listeM.get(liste.key).quantite }</span></p></div>
					</c:forEach>
				</div>
			</div>
			
    			<div class="col"><p class="title-date"><c:out value="${ liste.value.date }" /></p></div>
		</div>
	    </div>
	
	</c:forEach>  
	
		
    

</body>
</html>