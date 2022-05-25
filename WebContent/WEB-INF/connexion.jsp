<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Inscription</title>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" charset="UTF-8" / >
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/pagesphp.css">
		<link rel="stylesheet" type="text/css" href="css/evenement.css">
		<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
		<link rel="stylesheet" href="css/styleaccueil.css">
		<link rel="stylesheet" type="text/css" href="css/footer.css">
		<script src="js/jQuery.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/script.js" type="text/javascript"></script>
        <script src="js/pagesphp.js" type="text/javascript"></script>
		<link rel="icon" type="image/png" href="img/log.png" />
</head>
<body>

	
	<%@ include file="header-connexion.jsp" %>

	<!-- Banniere -->
    <div class="banniere" style="background-image: url('img/ban.PNG');">
        <h1 > Connexion </h1>
    </div>
    
		<div class="connexion" id="connect">
			<form method="post" action="Connexion" >
				 <div class="form-group">
					<label for="login">Matricule : </label><br/>
					<input type="text" id="login" value="<c:out value="${empty form.erreurs ? '':utilisateur.matricule}"/>"  name="matricule" class="form-control"  autofocus autocomplete required/>
				 	<span class="erreur">${form.erreurs['matricule']}</span>
				 </div >
				  <div class="form-group">
					<label for="password">Mot de passe : </label><br/>
    				<div>
                      <input id="myInput" type="password" class="form-control" name="password" required>
                   	  <span class="erreur">${form.erreurs['password']}</span>
                      <span class="fa fa-fw fa-eye field-icon toggle-password" id="myToggle" onclick="cacheMP('myInput','myToggle')"></span>
                    </div>
				 </div><br>
				 <input type="submit" value="Se Connecter" class="btn btn-secondary" />
				<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
			</form>
		</div>



	<%@ include file="footer.jsp" %>
</body>
</html>