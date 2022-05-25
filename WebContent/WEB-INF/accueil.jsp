<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Accueil</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/fonts/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="css/footer.css">
	<link rel="stylesheet" type="text/css" href="css/styleaccueil.css">
	<link rel="stylesheet" type="text/css" href="css/accueil.css">
	<link rel="stylesheet" type="text/css" href="css/don - Copie.css">
	<link rel="stylesheet" href="css/Hover-master/css/hover-min.css">
	<link rel="icon" type="image/png" href="img/logo.png" />

	<script src="js/jQuery.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <script src="js/script.js" type="text/javascript"></script>


</head>
<body>
	<%@ include file="header.jsp" %>
	<!--BANNIERE  -->
	<div class="banniere" style="background-image: url('img/ban.PNG');">
		<div class="row">
			<div class="col-xl-9 col-lg-9 col-md-9 col-sm-12"><h1> Chef de service </h1></div>
			
			<div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 search-btn">
	  			<form method="post" action="accueil" class="form-inline my-2 my-lg-0" >
	  				<div class="row">
	  					<div class="col"><input class="form-control" type="search" placeholder="Chercher" aria-label="Search"></div>
	  					<div class="col"><button class="btn btn-outline-success" type="submit">Chercher</button></div>
	  				</div>
	       		</form>
  			</div>
		</div>  		
  	</div>
  	
	
	<div class="vc_row wpb_row vc_row-fluid donner">
			<div class="vc_col-xs-12">
				<div class="container">
					<div class="row">
						<div class="wpb_column vc_col-sm-12">
							<div class="vc_column-inner ">
								<div class="wpb_wrapper">
									<div class="pourkoi"></div>
									<div class="wpb_text_column wpb_content_element ">
										<div class="wpb_wrapper ">											
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="container-fluid">
				<div class="row">
			      	<div class="col title-priorite"><h1>Priorités des demandes d'intervention</h1></div>
				</div><br><br>
				
			    <div class="row type-intervention">
			    	<div class="col"><form method="post" action="urgent"><button type="submit" class="col urgent hvr-grow"><h1>Urgent</h1></button></form></div>
			      	<div class="col"><form method="post" action="peu-urgent"><button type="submit" class="col peu-urgent hvr-grow"><h1>Peu Urgent</h1></button></form></div>
			      	<div class="col"><form method="post" action="pas-urgent"><button type="submit" class="col pas-urgent hvr-grow"><h1>Pas Urgent</h1></button></form></div>
			    </div>
			    <br><br>
			    
			    <div class="row">
			    	<div class="col"><form method="post" action="message-chef-pole"><button type="submit" class="col message hvr-float-shadow"><h1>Messages des chefs de pôle</h1></button></form></div>
			    	<div class="col"><form method="post" action="gestion-stock"><button type="submit" class="col stock hvr-float-shadow"><h1>Gestion du stock de matériels</h1></button></form></div>
	    		</div>
			</div> 
			
    
    
    
	</div>
	<script src="js/scroll-out.min.js"></script>
	    <script   type="text/javascript">
		ScrollOut({
			targets:'.formule,.pourkoi,.texte,.texte1'
		})
	</script>


</body>
</html>
