<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Infos</title>
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

	 <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="css/footer.css">
	
	<link rel="stylesheet" href="css/styleaccueil.css">
	<link rel="stylesheet" type="text/css" href="css/don - Copie.css">
	
	<script src="js/jQuery.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <script src="js/script.js" type="text/javascript"></script>


</head>
<body>
	<%@ include file="header-connexion.jsp" %>
	<!--BANNIERE  -->
	<div class="banniere" style="background-image: url('img/ban.PNG');">
  		<h1 > ${form.resultat} </h1>
  	</div>
	
</body>
</html>