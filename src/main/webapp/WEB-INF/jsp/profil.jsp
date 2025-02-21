<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	<main>	
		<div class="container d-flex align-items-center justify-content-center formulaire_utilisateur">
	        <div class="card p-4 bg-light shadow-lg">
	            <div class="card-body">
	                <h1 class="titreformulaire text-center display-6">Votre profil</h1>
	                <form action="modification" method="GET" >						
						<div class="container d-flex gap-3">
							<div id="profil_col1">
								<div>
									<label for="prenom">Prénom :</label>
									<input type="text" name="prenom" id="prenom" placeholder="Votre prénom" value="${sessionScope.utilisateur.prenom }" class="form-control" disabled>
								</div>
								<div>
									<label for="email">Email :</label>
									<input type="text" name="email" id="email" placeholder="Adresse E-Mail" value="${sessionScope.utilisateur.email }" class="form-control" disabled> 
								</div>
								<div>
									<label for="telephone">Numéro de téléphone :</label>
									<input type="text" name="telephone" id="telephone" placeholder="Numéro de téléphone" value="${sessionScope.utilisateur.telephone }" class="form-control" disabled>
								</div>					
							</div>
							<div id="profil_col2">
								<div>
									<label for="nom">Nom :</label>
									<input type="text" name="nom" id="nom" placeholder="Votre nom" value="${sessionScope.utilisateur.nom }" class="form-control" disabled>
								</div>
								<div>
									<label for="identifiant">Identifiant :</label>
									<input type="text" name="identifiant" id="identifiant" placeholder="Identifiant" value="${sessionScope.utilisateur.login }" class="form-control" disabled>
								</div>			
							</div>
						</div>					
						<div class="container mt-3 text-center">				
							<input type="submit" value="Modifier" class="btn btn-primary">
							<a href="deconnexion"><button type="button" class="btn btn-warning">Déconnexion</button></a>
							<button type="button" class="btn btn-danger" id="bouton_suppression">Supprimer</button>
						</div>
					</form>
	            </div>
	        </div>
	    </div>
	</main>
	<%@include file="fragments/footer.jspf" %>
</body>
</html>