<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Inscription</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://use.typekit.net/nsr7euh.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
</head>
<body>
	<%@include file="fragments/header.jspf" %>
	<main>	
		<div class="container d-flex align-items-center justify-content-center formulaire_utilisateur">
	        <div class="card p-4 bg-light shadow-lg">
	            <div class="card-body">
	                <h1 class="titreformulaire text-center display-6">Inscription</h1>
	                <div>
	                	<c:if test="${!empty erreur_mdp }">
	                		<div class="alert alert-danger">
								${erreur_mdp }
							</div>
	                	</c:if>
	                	<c:if test="${!empty erreurs_inscription }">
	                		<div class="alert alert-danger">
							<ul>
								<c:forEach var="message" items="${erreurs_inscription }">
									<li>${message }</li>
								</c:forEach>
							</ul>
							</div>
	                	</c:if>						
					</div>
	                <form action="inscription" method="POST" novalidate>
	                	<div class="container d-flex gap-3">
							<div id="inscription_col1">
								<div>
									<label for="identifiant">Identifiant :</label>
									<input type="text" name="identifiant" id="identifiant" placeholder="Identifiant" value="${identifiant }" class="form-control">
								</div>
								<div>
									<label for="email">Email<span class="vert">*</span> :</label>
									<input type="email" name="email" id="email" placeholder="Adresse E-Mail" value="${email }" class="form-control"> 
								</div>
								<div>
									<label for="mdp">Mot de passe<span class="vert">*</span> :</label>
									<input type="password" name="mdp" id="mdp" class="form-control">
								</div>
								<div>
									<label for="mdp_confirmation">Confirmez le mot de passe<span class="vert">*</span> :</label>
									<input type="password" name="mdp_confirmation" id="mdp_confirmation" class="form-control">
								</div>			
							</div>
							<div id="inscription_col2">
								<div>
									<label for="prenom">Prénom<span class="vert">*</span> :</label>
									<input type="text" name="prenom" id="prenom" placeholder="Votre prénom" value="${prenom }" class="form-control">
								</div>
								<div>
									<label for="nom">Nom<span class="vert">*</span> :</label>
									<input type="text" name="nom" id="nom" placeholder="Votre nom" value="${nom }" class="form-control">
								</div>
								<div>
									<label for="telephone">Numéro de téléphone :</label>
									<input type="text" name="telephone" id="telephone" placeholder="Numéro de téléphone" value="${telephone }" class="form-control">
								</div>					
							</div>
						</div>
						<div class="container text-center">				
							<input type="submit" value="Envoyer"  class="btn btn-primary d-lg-block mt-3">
						</div>
					</form>
	            </div>
	        </div>
	    </div>
	</main>
	<%@include file="fragments/footer.jspf" %>
</body>
</html>