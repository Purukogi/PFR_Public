<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${sessionScope.utilisateur.prenom } ${sessionScope.utilisateur.nom }</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://use.typekit.net/nsr7euh.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
<script type="text/javascript" src="scripts/script_suppression.js" defer></script>
</head>
<body>
	<%@include file="fragments/header.jspf" %>
	<main class="d-flex taille-navbar align-items-center justify-content-center ">
		<div class="row col-8">
		<div class="container d-flex align-items-center justify-content-center mb-3 mt-3 ">
	        <div class="card p-4 bg-light shadow-lg col-12 col-xl-10">
	            <div class="card-body">
	                <h1 class="titreformulaire text-center display-6">Votre profil</h1>
	                
	                <form action="modification" method="GET" class="container ">						
						<div class=" row justify-content-center">
							<div class="form-group col-md-6 col-xl-5">
								<div>
									<label for="prenom">Prénom :</label>
									<input type="text" name="prenom" id="prenom" placeholder="Votre prénom" value="${sessionScope.utilisateur.prenom }" class="form-control mb-2" disabled>
								</div>
								<div>
									<label for="nom">Nom :</label>
									<input type="text" name="nom" id="nom" placeholder="Votre nom" value="${sessionScope.utilisateur.nom }" class="form-control mb-2" disabled>
								</div>
								<div>
									<label for="identifiant">Identifiant :</label>
									<input type="text" name="identifiant" id="identifiant" placeholder="Identifiant" value="${sessionScope.utilisateur.login }" class="form-control mb-2" disabled>
								</div>				
							</div>
							<div class="form-group col-md-6 col-xl-5">
								<div>
									<label for="email">Email :</label>
									<input type="text" name="email" id="email" placeholder="Adresse E-Mail" value="${sessionScope.utilisateur.email }" class="form-control mb-2" disabled> 
								</div>
								<div>
									<label for="telephone">Numéro de téléphone :</label>
									<input type="text" name="telephone" id="telephone" placeholder="Numéro de téléphone" value="${sessionScope.utilisateur.telephone }" class="form-control mb-2" disabled>
								</div>			
							</div>
						</div>					
						<div class="container mt-4 text-center">				
							<input type="submit" value="Modifier" class="btn btn-outline-success ms-2 mb-2">
							<button type="button" class="btn btn-outline-danger ms-2 mb-2" id="bouton_suppression">Supprimer</button>
						</div>
						<div  class="container mt-2 text-center">
							<a href="deconnexion" class="mt-3 w-100 vert">Déconnexion</a>
						</div>
					</form>
	            </div>
	        </div>
	    </div>
	    
	    <div class="container d-flex align-items-center justify-content-center">
	        <div class="card p-4 bg-light shadow-lg col-12 col-xl-10">
	            <div class="card-body">
	                <h1 class="titreformulaire text-center display-6">Vos réservations</h1>
	                
	               <c:forEach items="${listeReservations}" var="r" varStatus="bStatus">
					<fieldset class="container mb-4 col-lg-8 col-md-12 text-center align-items-center">
						<div class="row border border-2 rounded align-items-center" >
							<div class="col-md-6 pt-2 pb-2 d-flex flex-column justify-content-between align-items-center m-auto">
							<p>Le : ${fn:replace(r.horaireReservation, 'T', ' à ')}</p>
							<p>Nombre de personnes : ${r.nbPersonne}</p>
							<p>${r.restaurant.nom}</p>
							</div>
						</div>
					</fieldset>
					</c:forEach>
	            </div>
	        </div>
	    </div>
</div>
	</main>
	<%@include file="fragments/footer.jspf" %>
</body>
</html>