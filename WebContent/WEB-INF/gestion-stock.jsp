<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Gestion de stock</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/fonts/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="css/styleaccueil.css">
	<link rel="stylesheet" type="text/css" href="css/don - Copie.css">
	<link rel="stylesheet" type="text/css" href="css/gestion-stock.css">	
	<link rel="icon" type="image/png" href="img/logo.png" />
	
	<link rel="stylesheet" href="css/Hover-master/css/hover-min.css">
	<script src="js/jQuery.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>

	<%@ include file="header.jsp" %><br><br><br><br>
	<div>
		<h2 class="title-stock">Stock des Matériaux</h2>
	</div>
	
	
	<div class="nav-stock-materiaux">
		<div class="row">
			<div class="col title-category"><h3>Electricité</h3></div>
			<div class="col title-category"><h3>Menuiserie</h3></div>
			<div class="col title-category"><h3>Climatisation</h3></div>
			<div class="col title-category"><h3>Maçonnerie</h3></div>
		</div>
	</div>
	
	  
	<div class="container-fluid ">		
		<div class="row">
			<c:forEach items="${ listeMateriel }" var="listeM" >
				<div class="col-sm-12 col-md-4 col-lg-3 col-xl-3 stock">
					<div class="row">
			    		<div class="col"><span class="badge badge-success"><c:out value="${ listeM.value.quantite }"/></span></div>
			    		<div class="col"><button type="button" class="btn btn-primary ajouter" data-toggle="modal" data-target="#A<c:out value="${ listeM.key }" />">Ajouter</button></div>
					</div>
					
					<div class="row">
						<div class="col title-mat"><h4><c:out value="${ listeM.value.nom }"></c:out></h4></div>
					</div>
					
					<div class="row">
						<div class="col"><button type="button" class="btn btn-danger supprimer" data-toggle="modal" data-target="#mymodaldelete">Supprimer</button></div>
						<div class="col"><button type="button" class="btn btn-warning diminuer" data-toggle="modal" data-target="#D<c:out value="${ listeM.key }" />">Diminuer</button></div>
					</div>
				</div>
				
				
				<div class="modal fade" id="A<c:out value="${ listeM.key }" />" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
					<div class="modal-dialog modal-md modal-dialog-centered" role="document">
						<div class="modal-content">
						
					    	<div class="modal-header">
					        	<h5 class="modal-title" id="exampleModalLongTitle">Veuillez saisir le nombre de <c:out value="${ listeM.value.nom }" /> que vous voulez ajouter au stock</h5>
					        	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					         		<span aria-hidden="true">&times;</span>
					        	</button>
					     	</div>
					     	
					     	<form method="post" action="materiaux-utilises">
								<div class="modal-body">
			                   		<div class="form-group">
										<div class="add-modal">
									  		<label class="form-check-label" for="lampes" class="label-lampe"><c:out value="${ listeM.value.nom }" /></label>
									  		<input type="number" name="a<c:out value="${ listeM.key }" />" id="lampes" min="1" max="100" class="quantite">
									  	</div>
									</div>
								</div>
							
								<div class="modal-footer">
									<div class="col">
										<button type="button" class="btn btn-secondary" data-dismiss="modal">Quitter</button>
									</div>
									<div class="col">
										<button type="submit" class="btn btn-primary enregistrer">Enregistrer</button>
									</div>
			
								</div>
							</form>
							
						</div>
					</div>
				</div>
	
	
	
	<div class="modal fade" id="D<c:out value="${ listeM.key }" />" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-md modal-dialog-centered" role="document">
			<div class="modal-content">
			
		    	<div class="modal-header">
		        	<h5 class="modal-title" id="exampleModalLongTitle">Veuillez saisir le nombre de <c:out value="${ listeM.value.nom }" /> que vous voulez diminuer au stock</h5>
		        	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		         		<span aria-hidden="true">&times;</span>
		        	</button>
		     	</div>
		     	
		     	<form method="post" action="materiaux-utilises">
					<div class="modal-body">
                   		<div class="form-group">
							<div class="add-modal">
						  		<label class="form-check-label" for="lampes" class="label-lampe"><c:out value="${ listeM.value.nom }" /></label>
						  		<input type="number" name="d<c:out value="${ listeM.key }" />" id="lampes" min="1" max="<c:out value="${ listeM.value.quantite }"/>" class="quantite">
						  	</div>
						</div>
					</div>
				
					<div class="modal-footer">
					  	<div class="col">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Quitter</button>
						</div>
						<div class="col">
							<button type="submit" class="btn btn-warning diminuer">Diminuer</button>
						</div>
					</div>
				</form>
				
			</div>
		</div>
	</div>
				
				
				
			</c:forEach>
		</div>
    </div>
    

    
    
    
    
    
    
    
    
    
    <div class="modal fade" id="mymodaldelete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
		        	<h5 class="modal-title" id="exampleModalLabel">Êtes-vous sûr de vouloir supprimer définitivement ce matériel du stock ?</h5>
		        	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          		<span aria-hidden="true">&times;</span>
		        	</button>
				</div>
		     	<div class="modal-footer">
		        	<button type="button" class="btn btn-secondary" data-dismiss="modal">Quitter</button>
		        	<form method="post" action="supprimerMateriel"><button type="button" class="btn btn-primary">Oui</button></form>
				</div>
			</div>
		</div>
	</div>
		


</body>
</html>
