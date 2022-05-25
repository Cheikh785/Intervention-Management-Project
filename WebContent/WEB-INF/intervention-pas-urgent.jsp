<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Intervention Pas Urgent</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/fonts/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="css/styleaccueil.css">
	<link rel="stylesheet" type="text/css" href="css/don - Copie.css">
	<link rel="stylesheet" type="text/css" href="css/intervention-pas-urgent.css">
	<link rel="icon" type="image/png" href="img/logo.png" />
</head>
<body>

	<%@ include file="header.jsp" %><br><br><br><br>
	
	<div class="row">
       	<div class="col-sm-9 col-md-11 col-lg-11 col-xl-11"><span class="type-pas-urgent">Pas Urgent</span></div>
       	<div class="col-sm-3 col-md-1 col-lg-1 col-xl-1">
       		<form method="post" action="#">
				<button type="submit" class="btn btn-secondary actualiser">Actualiser</button>
			</form> 		
       	</div>
	</div><br>   
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
	    		<div class="col"><p><span class="title-contact">Fonction : </span><c:out value="${ listeUtilisateur.get(liste.value.matricule).fonction }" /></p></div>
			</div>
			
			<div class="row defaillance">
	    		<div class="col"><p><span class="title-defaillance">Type de defaillance : </span><c:out value="${ liste.value.tdp }" /></p></div>
	    		<div class="col"><p><span class="title-defaillance">Service : </span><c:out value="${ liste.value.service }" /></p></div>
	    		<div class="col"><p><span class="title-defaillance">Cause de la défaillance : </span><c:out value="${ liste.value.cdd }" /></p></div>
			</div>
			<div class="row status">
	    		<div class="col"><span class="title-status-ok"><c:out value="${ liste.value.statut }" /></span></div>
    			<div class="col"><p class="title-date"><c:out value="${ liste.value.date }" /></p></div>
			</div>
	    </div>
	
	</c:forEach>
    

</body>
</html>
